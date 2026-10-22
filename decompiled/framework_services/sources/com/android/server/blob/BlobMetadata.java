package com.android.server.blob;

import android.app.blob.BlobHandle;
import android.app.blob.LeaseInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ResourceId;
import android.content.res.Resources;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.RevocableFileDescriptor;
import android.os.UserHandle;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.text.format.Formatter;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StatsEvent;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class BlobMetadata {
    private File mBlobFile;
    private final BlobHandle mBlobHandle;
    private final long mBlobId;
    private final ArraySet<Committer> mCommitters;
    private final Context mContext;
    private final ArraySet<Leasee> mLeasees;
    private final Object mMetadataLock;
    private final ArrayMap<Accessor, ArraySet<RevocableFileDescriptor>> mRevocableFds;

    static class Accessor {
        public final String packageName;
        public final int uid;

        Accessor(String packageName, int uid) {
            this.packageName = packageName;
            this.uid = uid;
        }

        public boolean equals(String packageName, int uid) {
            if (this.uid == uid) goto L5;
        L7:
            return false;
        L5:
            if (this.packageName.equals(packageName) == false) goto L7;
            return true;
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if (obj != null) goto L8;
        L17:
            return false;
        L8:
            if ((obj instanceof Accessor) == false) goto L17;
            Accessor other = (Accessor) obj;
            if (this.uid != other.uid) goto L16;
            if (this.packageName.equals(other.packageName) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.packageName, Integer.valueOf(this.uid)});
        }

        public String toString() {
            return "[" + this.packageName + ", " + this.uid + "]";
        }
    }

    static final class Committer extends Accessor {
        public final BlobAccessMode blobAccessMode;
        public final long commitTimeMs;

        Committer(String packageName, int uid, BlobAccessMode blobAccessMode, long commitTimeMs) {
            super(packageName, uid);
            this.blobAccessMode = blobAccessMode;
            this.commitTimeMs = commitTimeMs;
        }

        long getCommitTimeMs() {
            return this.commitTimeMs;
        }

        void dump(IndentingPrintWriter fout) {
            StringBuilder r0 = new StringBuilder();
            r0.append("commit time: ");
            if (this.commitTimeMs != 0) goto L5;
            String r1 = "<null>";
        L6:
            r0.append(r1);
            fout.println(r0.toString());
            fout.println("accessMode:");
            fout.increaseIndent();
            this.blobAccessMode.dump(fout);
            fout.decreaseIndent();
            return;
        L5:
            r1 = BlobStoreUtils.formatTime(this.commitTimeMs);
            goto L6
        }

        void writeToXml(XmlSerializer out) throws IOException {
            XmlUtils.writeStringAttribute(out, "p", this.packageName);
            XmlUtils.writeIntAttribute(out, "u", this.uid);
            XmlUtils.writeLongAttribute(out, "cmt", this.commitTimeMs);
            out.startTag(null, "am");
            this.blobAccessMode.writeToXml(out);
            out.endTag(null, "am");
        }

        static Committer createFromXml(XmlPullParser in, int version) throws XmlPullParserException, IOException {
            String packageName = XmlUtils.readStringAttribute(in, "p");
            int uid = XmlUtils.readIntAttribute(in, "u");
            if (version < 4) goto L5;
            long commitTimeMs = XmlUtils.readLongAttribute(in, "cmt");
        L6:
            int depth = in.getDepth();
            BlobAccessMode blobAccessMode = null;
        L8:
            if (XmlUtils.nextElementWithin(in, depth) == false) goto L12;
            if ("am".equals(in.getName()) == false) goto L8;
            blobAccessMode = BlobAccessMode.createFromXml(in);
            goto L8
        L12:
            if (blobAccessMode != null) goto L16;
            Slog.wtf(BlobStoreConfig.TAG, "blobAccessMode should be available");
            return null;
        L16:
            return new Committer(packageName, uid, blobAccessMode, commitTimeMs);
        L5:
            commitTimeMs = 0;
            goto L6
        }
    }

    static final class Leasee extends Accessor {
        public final CharSequence description;
        public final String descriptionResEntryName;
        public final long expiryTimeMillis;

        Leasee(Context context, String packageName, int uid, int descriptionResId, CharSequence description, long expiryTimeMillis) {
            super(packageName, uid);
            Resources packageResources = BlobStoreUtils.getPackageResources(context, packageName, UserHandle.getUserId(uid));
            this.descriptionResEntryName = getResourceEntryName(packageResources, descriptionResId);
            this.expiryTimeMillis = expiryTimeMillis;
            if (description != null) goto L5;
            CharSequence r1 = getDescription(packageResources, descriptionResId);
        L6:
            this.description = r1;
            return;
        L5:
            r1 = description;
            goto L6
        }

        Leasee(String packageName, int uid, String descriptionResEntryName, CharSequence description, long expiryTimeMillis) {
            super(packageName, uid);
            this.descriptionResEntryName = descriptionResEntryName;
            this.expiryTimeMillis = expiryTimeMillis;
            this.description = description;
        }

        private static String getResourceEntryName(Resources packageResources, int resId) {
            if (ResourceId.isValid(resId) == false) goto L8;
            if (packageResources != null) goto L7;
            return null;
        L7:
            return packageResources.getResourceEntryName(resId);
        L8:
            return null;
        }

        private static String getDescription(Context context, String descriptionResEntryName, String packageName, int userId) {
            if (descriptionResEntryName != null) goto L5;
        L15:
            return null;
        L5:
            if (descriptionResEntryName.isEmpty() == true) goto L15;
            Resources resources = BlobStoreUtils.getPackageResources(context, packageName, userId);
            if (resources != null) goto L10;
            return null;
        L10:
            int resId = BlobStoreUtils.getDescriptionResourceId(resources, descriptionResEntryName, packageName);
            if (resId != 0) goto L14;
            return null;
        L14:
            return resources.getString(resId);
        }

        private static String getDescription(Resources packageResources, int descriptionResId) {
            if (ResourceId.isValid(descriptionResId) == false) goto L8;
            if (packageResources != null) goto L7;
            return null;
        L7:
            return packageResources.getString(descriptionResId);
        L8:
            return null;
        }

        boolean isStillValid() {
            if (this.expiryTimeMillis != 0) goto L5;
        L8:
            return true;
        L5:
            if (this.expiryTimeMillis >= System.currentTimeMillis()) goto L8;
            return false;
        }

        void dump(Context context, IndentingPrintWriter fout) {
            fout.println("desc: " + getDescriptionToDump(context));
            fout.println("expiryMs: " + this.expiryTimeMillis);
        }

        private String getDescriptionToDump(Context context) {
            String desc = getDescription(context, this.descriptionResEntryName, this.packageName, UserHandle.getUserId(this.uid));
            if (desc != null) goto L5;
            desc = this.description.toString();
        L5:
            if (desc != null) goto L8;
            return "<none>";
        L8:
            return desc;
        }

        void writeToXml(XmlSerializer out) throws IOException {
            XmlUtils.writeStringAttribute(out, "p", this.packageName);
            XmlUtils.writeIntAttribute(out, "u", this.uid);
            XmlUtils.writeStringAttribute(out, "rn", this.descriptionResEntryName);
            XmlUtils.writeLongAttribute(out, "ex", this.expiryTimeMillis);
            XmlUtils.writeStringAttribute(out, "d", this.description);
        }

        static Leasee createFromXml(XmlPullParser in, int version) throws IOException {
            String packageName = XmlUtils.readStringAttribute(in, "p");
            int uid = XmlUtils.readIntAttribute(in, "u");
            if (version < 3) goto L5;
            String descriptionResEntryName = XmlUtils.readStringAttribute(in, "rn");
        L6:
            long expiryTimeMillis = XmlUtils.readLongAttribute(in, "ex");
            if (version < 2) goto L9;
            CharSequence description = XmlUtils.readStringAttribute(in, "d");
        L11:
            return new Leasee(packageName, uid, descriptionResEntryName, description, expiryTimeMillis);
        L9:
            description = null;
            goto L11
        L5:
            descriptionResEntryName = null;
            goto L6
        }
    }

    public static /* synthetic */ boolean $r8$lambda$Dl4va3hecqfmhJMbYVxC6bxhMZ8(int r0, Leasee r1) {
        return lambda$removeDataForUser$6(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$Fzd5GGCZd4rdOTsyoLLIZTpMOao(int r0, String r1, Committer r2) {
        return lambda$removeCommitter$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$HBYdPGV-U05oUr5Yaah7qeOPMOg, reason: not valid java name */
    public static /* synthetic */ boolean m2757$r8$lambda$HBYdPGVU05oUr5Yaah7qeOPMOg(int r0, String r1, Leasee r2) {
        return lambda$removeLeasee$2(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$U8Rl2B_xWWp3u6IX-5BLiERxwL8, reason: not valid java name */
    public static /* synthetic */ boolean m2758$r8$lambda$U8Rl2B_xWWp3u6IX5BLiERxwL8(SparseArray r0, Leasee r1) {
        return lambda$removeLeaseesFromUnknownPkgs$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ua2X8a5UEXzmlQlYwqPuaY-LNlA, reason: not valid java name */
    public static /* synthetic */ boolean m2759$r8$lambda$Ua2X8a5UEXzmlQlYwqPuaYLNlA(Leasee r0) {
        return lambda$removeExpiredLeases$4(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$Yaq82tDXZZRr6nju_vRc7kZ7hag(SparseArray r0, Committer r1) {
        return lambda$removeCommittersFromUnknownPkgs$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$iC90ocsrRUOqdsp9UA-1BFmuKz4, reason: not valid java name */
    public static /* synthetic */ boolean m2760$r8$lambda$iC90ocsrRUOqdsp9UA1BFmuKz4(int r0, Committer r1) {
        return lambda$removeDataForUser$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$k9HBHYGitsS-loR2nthFqTG0XFk, reason: not valid java name */
    public static /* synthetic */ boolean m2761$r8$lambda$k9HBHYGitsSloR2nthFqTG0XFk(int r0, Map.Entry r1) {
        return lambda$removeDataForUser$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$qr8MFVrAy5kbTEx1uC2enQ4TjQI(BlobMetadata r0, Accessor r1, RevocableFileDescriptor r2, IOException r3) {
        r0.lambda$createRevocableFd$8(r1, r2, r3);
    }

    BlobMetadata(Context context, long blobId, BlobHandle blobHandle) {
        this.mMetadataLock = new Object();
        this.mCommitters = new ArraySet();
        this.mLeasees = new ArraySet();
        this.mRevocableFds = new ArrayMap();
        this.mContext = context;
        this.mBlobId = blobId;
        this.mBlobHandle = blobHandle;
    }

    long getBlobId() {
        return this.mBlobId;
    }

    BlobHandle getBlobHandle() {
        return this.mBlobHandle;
    }

    void addOrReplaceCommitter(Committer committer) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mCommitters.remove(committer);     // Catch: Throwable -> L7
        this.mCommitters.add(committer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setCommitters(ArraySet<Committer> committers) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mCommitters.clear();     // Catch: Throwable -> L7
        this.mCommitters.addAll(committers);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeCommitter(final String packageName, final int uid) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mCommitters.removeIf(new BlobMetadata$$ExternalSyntheticLambda2(uid, packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeCommitter$0(int uid, String packageName, Committer committer) {
        if (committer.uid == uid) goto L5;
    L7:
        return false;
    L5:
        if (committer.packageName.equals(packageName) == false) goto L7;
        return true;
    }

    void removeCommitter(Committer committer) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mCommitters.remove(committer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeCommittersFromUnknownPkgs(final SparseArray<SparseArray<String>> knownPackages) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mCommitters.removeIf(new BlobMetadata$$ExternalSyntheticLambda8(knownPackages));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeCommittersFromUnknownPkgs$1(SparseArray knownPackages, Committer committer) {
        int userId = UserHandle.getUserId(committer.uid);
        SparseArray<String> userPackages = (SparseArray) knownPackages.get(userId);
        if (userPackages != null) goto L6;
        return true;
    L6:
        return true ^ committer.packageName.equals(userPackages.get(committer.uid));
    }

    void addCommittersAndLeasees(BlobMetadata blobMetadata) {
        this.mCommitters.addAll(blobMetadata.mCommitters);
        this.mLeasees.addAll(blobMetadata.mLeasees);
    }

    Committer getExistingCommitter(String packageName, int uid) {
        ArraySet<Committer> r0 = this.mCommitters;
        monitor-enter(r0);
        int i = 0;
        int size = this.mCommitters.size();     // Catch: Throwable -> L13
    L6:
        if (i >= size) goto L17;
        Committer committer = this.mCommitters.valueAt(i);     // Catch: Throwable -> L13
        if (committer.uid != uid) goto L15;
        if (committer.packageName.equals(packageName) == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return committer;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    void addOrReplaceLeasee(String callingPackage, int callingUid, int descriptionResId, CharSequence description, long leaseExpiryTimeMillis) {
        Object r1 = this.mMetadataLock;
        monitor-enter(r1);
        Leasee leasee = new Leasee(this.mContext, callingPackage, callingUid, descriptionResId, description, leaseExpiryTimeMillis);     // Catch: Throwable -> L7
        this.mLeasees.remove(leasee);     // Catch: Throwable -> L7
        this.mLeasees.add(leasee);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setLeasees(ArraySet<Leasee> leasees) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mLeasees.clear();     // Catch: Throwable -> L7
        this.mLeasees.addAll(leasees);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeLeasee(final String packageName, final int uid) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mLeasees.removeIf(new BlobMetadata$$ExternalSyntheticLambda1(uid, packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeLeasee$2(int uid, String packageName, Leasee leasee) {
        if (leasee.uid == uid) goto L5;
    L7:
        return false;
    L5:
        if (leasee.packageName.equals(packageName) == false) goto L7;
        return true;
    }

    void removeLeaseesFromUnknownPkgs(final SparseArray<SparseArray<String>> knownPackages) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mLeasees.removeIf(new BlobMetadata$$ExternalSyntheticLambda3(knownPackages));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeLeaseesFromUnknownPkgs$3(SparseArray knownPackages, Leasee leasee) {
        int userId = UserHandle.getUserId(leasee.uid);
        SparseArray<String> userPackages = (SparseArray) knownPackages.get(userId);
        if (userPackages != null) goto L6;
        return true;
    L6:
        return true ^ leasee.packageName.equals(userPackages.get(leasee.uid));
    }

    void removeExpiredLeases() {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mLeasees.removeIf(new BlobMetadata$$ExternalSyntheticLambda0());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeExpiredLeases$4(Leasee leasee) {
        return !leasee.isStillValid();
    }

    void removeDataForUser(final int userId) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mCommitters.removeIf(new BlobMetadata$$ExternalSyntheticLambda4(userId));     // Catch: Throwable -> L7
        this.mLeasees.removeIf(new BlobMetadata$$ExternalSyntheticLambda5(userId));     // Catch: Throwable -> L7
        this.mRevocableFds.entrySet().removeIf(new BlobMetadata$$ExternalSyntheticLambda6(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeDataForUser$5(int userId, Committer committer) {
        if (userId != UserHandle.getUserId(committer.uid)) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$removeDataForUser$6(int userId, Leasee leasee) {
        if (userId != UserHandle.getUserId(leasee.uid)) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$removeDataForUser$7(int userId, Map.Entry entry) {
        Accessor accessor = (Accessor) entry.getKey();
        ArraySet<RevocableFileDescriptor> rFds = (ArraySet) entry.getValue();
        if (userId == UserHandle.getUserId(accessor.uid)) goto L6;
        return false;
    L6:
        int i = 0;
        int fdCount = rFds.size();
    L7:
        if (i >= fdCount) goto L9;
        rFds.valueAt(i).revoke();
        i = i + 1;
        goto L7
    L9:
        rFds.clear();
        return true;
    }

    boolean hasValidLeases() {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        int i = 0;
        int size = this.mLeasees.size();     // Catch: Throwable -> L12
    L6:
        if (i >= size) goto L16;
        if (this.mLeasees.valueAt(i).isStillValid() == true) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    long getSize() {
        return getBlobFile().length();
    }

    boolean isAccessAllowedForCaller(String callingPackage, int callingUid) {
        if (getBlobHandle().isExpired() == false) goto L5;
        return false;
    L5:
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        int i = 0;
        int size = this.mLeasees.size();     // Catch: Throwable -> L17
    L10:
        if (i >= size) goto L20;
        Leasee leasee = this.mLeasees.valueAt(i);     // Catch: Throwable -> L17
        if (leasee.isStillValid() == false) goto L19;
        if (leasee.equals(callingPackage, callingUid) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L19:
        i = i + 1;     // Catch: Throwable -> L17
        goto L10
    L20:
        int callingUserId = UserHandle.getUserId(callingUid);     // Catch: Throwable -> L17
        int i2 = 0;
        int size2 = this.mCommitters.size();     // Catch: Throwable -> L17
    L21:
        if (i2 >= size2) goto L34;
        Committer committer = this.mCommitters.valueAt(i2);     // Catch: Throwable -> L17
        if (callingUserId == UserHandle.getUserId(committer.uid)) goto L26;
    L33:
        i2 = i2 + 1;     // Catch: Throwable -> L17
        goto L21
    L26:
        if (committer.equals(callingPackage, callingUid) == true) goto L27;
        if (committer.blobAccessMode.isAccessAllowedForCaller(this.mContext, callingPackage, callingUid, committer.uid) == false) goto L33;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L34:
        boolean canCallerAccessBlobsAcrossUsers = checkCallerCanAccessBlobsAcrossUsers(callingUid);     // Catch: Throwable -> L17
        if (canCallerAccessBlobsAcrossUsers == true) goto L38;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L38:
        int i3 = 0;
        int size3 = this.mCommitters.size();     // Catch: Throwable -> L17
    L39:
        if (i3 >= size3) goto L52;
        Committer committer2 = this.mCommitters.valueAt(i3);     // Catch: Throwable -> L17
        int committerUserId = UserHandle.getUserId(committer2.uid);     // Catch: Throwable -> L17
        if (callingUserId != committerUserId) goto L44;
    L50:
        i3 = i3 + 1;     // Catch: Throwable -> L17
        goto L39
    L44:
        if (isPackageInstalledOnUser(callingPackage, committerUserId) == false) goto L50;
        if (committer2.blobAccessMode.isAccessAllowedForCaller(this.mContext, callingPackage, callingUid, committer2.uid) == false) goto L50;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L52:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L17:
        th = move-exception;
        throw th;
    }

    private boolean checkCallerCanAccessBlobsAcrossUsers(int callingUid) {
        long token = Binder.clearCallingIdentity();
        if (this.mContext.checkPermission("android.permission.ACCESS_BLOBS_ACROSS_USERS", -1, callingUid) != 0) goto L6;
        boolean r2 = true;
    L7:
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        r2 = false;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean isPackageInstalledOnUser(String packageName, int userId) {
        long token = Binder.clearCallingIdentity();
        this.mContext.getPackageManager().getPackageInfoAsUser(packageName, 0, userId);     // Catch: Throwable -> L6 PackageManager.NameNotFoundException -> L8
        Binder.restoreCallingIdentity(token);
        return true;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        Binder.restoreCallingIdentity(token);
        return false;
    }

    boolean hasACommitterOrLeaseeInUser(int userId) {
        if (hasACommitterInUser(userId) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasALeaseeInUser(userId) == true) goto L8;
        return false;
    }

    boolean hasACommitterInUser(int userId) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        int i = 0;
        int size = this.mCommitters.size();     // Catch: Throwable -> L12
    L6:
        if (i >= size) goto L16;
        Committer committer = this.mCommitters.valueAt(i);     // Catch: Throwable -> L12
        if (userId == UserHandle.getUserId(committer.uid)) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean hasALeaseeInUser(int userId) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        int i = 0;
        int size = this.mLeasees.size();     // Catch: Throwable -> L12
    L6:
        if (i >= size) goto L16;
        Leasee leasee = this.mLeasees.valueAt(i);     // Catch: Throwable -> L12
        if (userId == UserHandle.getUserId(leasee.uid)) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    boolean isACommitter(String packageName, int uid) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        boolean r1 = isAnAccessor(this.mCommitters, packageName, uid, UserHandle.getUserId(uid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isALeasee(String packageName, int uid) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        Leasee leasee = (Leasee) getAccessor(this.mLeasees, packageName, uid, UserHandle.getUserId(uid));     // Catch: Throwable -> L9
        if (leasee != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (leasee.isStillValid() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isALeaseeInUser(String packageName, int uid, int userId) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        Leasee leasee = (Leasee) getAccessor(this.mLeasees, packageName, uid, userId);     // Catch: Throwable -> L9
        if (leasee != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (leasee.isStillValid() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private static <T extends Accessor> boolean isAnAccessor(ArraySet<T> accessors, String packageName, int uid, int userId) {
        if (getAccessor(accessors, packageName, uid, userId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static <T extends Accessor> T getAccessor(ArraySet<T> accessors, String packageName, int uid, int userId) {
        int i = 0;
        int size = accessors.size();
    L3:
        if (i >= size) goto L21;
        T r2 = accessors.valueAt(i);
        if (packageName == null) goto L10;
        if (uid == (-1)) goto L10;
        if (r2.equals(packageName, uid) == false) goto L10;
        return r2;
    L10:
        if (packageName != null) goto L12;
    L16:
        if (uid == (-1)) goto L20;
        if (r2.uid != uid) goto L20;
        return r2;
    L20:
        i = i + 1;
        goto L3
    L12:
        if (r2.packageName.equals(packageName) == false) goto L16;
        if (userId != UserHandle.getUserId(r2.uid)) goto L16;
        return r2;
    L21:
        return null;
    }

    boolean shouldAttributeToUser(int userId) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        int i = 0;
        int size = this.mLeasees.size();     // Catch: Throwable -> L12
    L6:
        if (i >= size) goto L16;
        Leasee leasee = this.mLeasees.valueAt(i);     // Catch: Throwable -> L12
        if (userId != UserHandle.getUserId(leasee.uid)) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    boolean shouldAttributeToLeasee(String packageName, int userId, boolean callerHasStatsPermission) {
        if (isALeaseeInUser(packageName, -1, userId) == true) goto L5;
        return false;
    L5:
        if (callerHasStatsPermission == true) goto L7;
        return true;
    L7:
        if (hasOtherLeasees(packageName, -1, userId) == false) goto L12;
        return false;
    L12:
        return true;
    }

    boolean shouldAttributeToLeasee(int uid, boolean callerHasStatsPermission) {
        int userId = UserHandle.getUserId(uid);
        if (isALeaseeInUser(null, uid, userId) == true) goto L5;
        return false;
    L5:
        if (callerHasStatsPermission == true) goto L7;
        return true;
    L7:
        if (hasOtherLeasees(null, uid, userId) == false) goto L12;
        return false;
    L12:
        return true;
    }

    private boolean hasOtherLeasees(String packageName, int uid, int userId) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        int i = 0;
        int size = this.mLeasees.size();     // Catch: Throwable -> L17
    L6:
        if (i >= size) goto L33;
        Leasee leasee = this.mLeasees.valueAt(i);     // Catch: Throwable -> L17
        if (leasee.isStillValid() == true) goto L11;
    L31:
        i = i + 1;     // Catch: Throwable -> L17
        goto L6
    L11:
        if (packageName == null) goto L19;
        if (uid == (-1)) goto L19;
        if (leasee.equals(packageName, uid) == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L19:
        if (packageName != null) goto L21;
    L26:
        if (uid == (-1)) goto L31;
        if (leasee.uid == uid) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L21:
        if (leasee.packageName.equals(packageName) == false) goto L24;
        if (userId == UserHandle.getUserId(leasee.uid)) goto L26;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L17:
        th = move-exception;
        throw th;
    }

    LeaseInfo getLeaseInfo(String packageName, int uid) {
        Object r1 = this.mMetadataLock;
        monitor-enter(r1);
        int i = 0;
        int size = this.mLeasees.size();     // Catch: Throwable -> L25
    L6:
        if (i >= size) goto L30;
        Leasee leasee = this.mLeasees.valueAt(i);     // Catch: Throwable -> L25
        if (leasee.isStillValid() == true) goto L11;
    L28:
        i = i + 1;     // Catch: Throwable -> L23
        packageName = packageName;
        goto L6
    L11:
        if (leasee.uid != uid) goto L28;
        if (leasee.packageName.equals(packageName) == false) goto L28;
        if (leasee.descriptionResEntryName != null) goto L17;
        int r4 = 0;
    L18:
        int descriptionResId = r4;
        LeaseInfo r5 = new LeaseInfo(packageName, leasee.expiryTimeMillis, descriptionResId, leasee.description);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return r5;
    L17:
        r4 = BlobStoreUtils.getDescriptionResourceId(this.mContext, leasee.descriptionResEntryName, leasee.packageName, UserHandle.getUserId(leasee.uid));     // Catch: Throwable -> L25
        goto L18
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L23
        return null;
    L23:
        th = move-exception;
        Throwable r12 = th;
    L33:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw r12;
    L25:
        th = move-exception;
        r12 = th;
        goto L33
    }

    void forEachLeasee(Consumer<Leasee> consumer) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        this.mLeasees.forEach(consumer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    File getBlobFile() {
        if (this.mBlobFile != null) goto L6;
        this.mBlobFile = BlobStoreConfig.getBlobFile(this.mBlobId);
    L6:
        return this.mBlobFile;
    }

    ParcelFileDescriptor openForRead(String callingPackage, int callingUid) throws IOException {
        FileDescriptor fd = Os.open(getBlobFile().getPath(), OsConstants.O_RDONLY, 0);     // Catch: ErrnoException -> L13
    L7:
        e = move-exception;
        IoUtils.closeQuietly(fd);
        throw e;
    L4:
        if (BlobStoreConfig.shouldUseRevocableFdForReads() == false) goto L10;
        return createRevocableFd(fd, callingPackage, callingUid);
    L10:
        return new ParcelFileDescriptor(fd);
    L13:
        e = move-exception;
        throw e.rethrowAsIOException();
    }

    private ParcelFileDescriptor createRevocableFd(FileDescriptor fd, String callingPackage, int callingUid) throws IOException {
        final RevocableFileDescriptor revocableFd = new RevocableFileDescriptor(this.mContext, fd, BlobStoreUtils.getRevocableFdHandler());
        ArrayMap<Accessor, ArraySet<RevocableFileDescriptor>> r1 = this.mRevocableFds;
        monitor-enter(r1);
        final Accessor accessor = new Accessor(callingPackage, callingUid);     // Catch: Throwable -> L7
        ArraySet<RevocableFileDescriptor> revocableFdsForAccessor = this.mRevocableFds.get(accessor);     // Catch: Throwable -> L7
        if (revocableFdsForAccessor != null) goto L9;
        revocableFdsForAccessor = new ArraySet();     // Catch: Throwable -> L7
        this.mRevocableFds.put(accessor, revocableFdsForAccessor);     // Catch: Throwable -> L7
    L9:
        revocableFdsForAccessor.add(revocableFd);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        revocableFd.addOnCloseListener(new BlobMetadata$$ExternalSyntheticLambda7(this, accessor, revocableFd));
        return revocableFd.getRevocableFileDescriptor();
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$createRevocableFd$8(Accessor accessor, RevocableFileDescriptor revocableFd, IOException e) {
        ArrayMap<Accessor, ArraySet<RevocableFileDescriptor>> r0 = this.mRevocableFds;
        monitor-enter(r0);
        ArraySet<RevocableFileDescriptor> revocableFdsForAccessor = this.mRevocableFds.get(accessor);     // Catch: Throwable -> L9
        if (revocableFdsForAccessor == null) goto L11;
        revocableFdsForAccessor.remove(revocableFd);     // Catch: Throwable -> L9
        if (revocableFdsForAccessor.isEmpty() == false) goto L11;
        this.mRevocableFds.remove(accessor);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void destroy() {
        revokeAndClearAllFds();
        getBlobFile().delete();
    }

    private void revokeAndClearAllFds() {
        ArrayMap<Accessor, ArraySet<RevocableFileDescriptor>> r0 = this.mRevocableFds;
        monitor-enter(r0);
        int i = 0;
        int accessorCount = this.mRevocableFds.size();     // Catch: Throwable -> L13
    L6:
        if (i >= accessorCount) goto L16;
        ArraySet<RevocableFileDescriptor> rFds = this.mRevocableFds.valueAt(i);     // Catch: Throwable -> L13
        if (rFds == null) goto L15;
        int j = 0;
        int fdCount = rFds.size();     // Catch: Throwable -> L13
    L11:
        if (j >= fdCount) goto L15;
        rFds.valueAt(j).revoke();     // Catch: Throwable -> L13
        j = j + 1;     // Catch: Throwable -> L13
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L16:
        this.mRevocableFds.clear();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    boolean shouldBeDeleted(boolean respectLeaseWaitTime) {
        if (getBlobHandle().isExpired() == false) goto L5;
        return true;
    L5:
        if (respectLeaseWaitTime == false) goto L9;
        if (hasLeaseWaitTimeElapsedForAll() == true) goto L9;
        return false;
    L9:
        if (hasValidLeases() == true) goto L13;
        return true;
    L13:
        return false;
    }

    boolean hasLeaseWaitTimeElapsedForAll() {
        int i = 0;
        int size = this.mCommitters.size();
    L3:
        if (i >= size) goto L9;
        Committer committer = this.mCommitters.valueAt(i);
        if (BlobStoreConfig.hasLeaseWaitTimeElapsed(committer.getCommitTimeMs()) == false) goto L6;
        i = i + 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    StatsEvent dumpAsStatsEvent(int atomTag) {
        Object r2 = this.mMetadataLock;
        monitor-enter(r2);
        ProtoOutputStream proto = new ProtoOutputStream();     // Catch: Throwable -> L8
        int i = 0;
        int size = this.mCommitters.size();     // Catch: Throwable -> L8
    L6:
        if (i >= size) goto L10;
        Committer committer = this.mCommitters.valueAt(i);     // Catch: Throwable -> L8
        long token = proto.start(2246267895809L);     // Catch: Throwable -> L8
        proto.write(1120986464257L, committer.uid);     // Catch: Throwable -> L8
        proto.write(1112396529666L, committer.commitTimeMs);     // Catch: Throwable -> L8
        proto.write(1120986464259L, committer.blobAccessMode.getAccessType());     // Catch: Throwable -> L8
        proto.write(1120986464260L, committer.blobAccessMode.getAllowedPackagesCount());     // Catch: Throwable -> L8
        proto.end(token);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        byte[] committersBytes = proto.getBytes();     // Catch: Throwable -> L8
        ProtoOutputStream proto2 = new ProtoOutputStream();     // Catch: Throwable -> L8
        int i2 = 0;
        int size2 = this.mLeasees.size();     // Catch: Throwable -> L8
    L11:
        if (i2 >= size2) goto L13;
        Leasee leasee = this.mLeasees.valueAt(i2);     // Catch: Throwable -> L8
        long token2 = proto2.start(2246267895809L);     // Catch: Throwable -> L8
        proto2.write(1120986464257L, leasee.uid);     // Catch: Throwable -> L8
        proto2.write(1112396529666L, leasee.expiryTimeMillis);     // Catch: Throwable -> L8
        proto2.end(token2);     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L11
    L13:
        byte[] leaseesBytes = proto2.getBytes();     // Catch: Throwable -> L8
        StatsEvent r0 = FrameworkStatsLog.buildStatsEvent(atomTag, this.mBlobId, getSize(), this.mBlobHandle.getExpiryTimeMillis(), committersBytes, leaseesBytes);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    void dump(IndentingPrintWriter fout, BlobStoreManagerService.DumpArgs dumpArgs) {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        fout.println("blobHandle:");     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        this.mBlobHandle.dump(fout, dumpArgs.shouldDumpFull());     // Catch: Throwable -> L7
        fout.decreaseIndent();     // Catch: Throwable -> L7
        fout.println("size: " + Formatter.formatFileSize(this.mContext, getSize(), 8));     // Catch: Throwable -> L7
        fout.println("Committers:");     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        if (this.mCommitters.isEmpty() == false) goto L9;
        fout.println("<empty>");     // Catch: Throwable -> L7
    L12:
        fout.decreaseIndent();     // Catch: Throwable -> L7
        fout.println("Leasees:");     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        if (this.mLeasees.isEmpty() == false) goto L15;
        fout.println("<empty>");     // Catch: Throwable -> L7
    L18:
        fout.decreaseIndent();     // Catch: Throwable -> L7
        fout.println("Open fds:");     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        if (this.mRevocableFds.isEmpty() == false) goto L21;
        fout.println("<empty>");     // Catch: Throwable -> L7
    L24:
        fout.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L21:
        int i = 0;
        int count = this.mRevocableFds.size();     // Catch: Throwable -> L7
    L22:
        if (i >= count) goto L24;
        Accessor accessor = this.mRevocableFds.keyAt(i);     // Catch: Throwable -> L7
        ArraySet<RevocableFileDescriptor> rFds = this.mRevocableFds.valueAt(i);     // Catch: Throwable -> L7
        fout.println(accessor + ": #" + rFds.size());     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L22
    L15:
        int i2 = 0;
        int count2 = this.mLeasees.size();     // Catch: Throwable -> L7
    L16:
        if (i2 >= count2) goto L18;
        Leasee leasee = this.mLeasees.valueAt(i2);     // Catch: Throwable -> L7
        fout.println("leasee " + leasee.toString());     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        leasee.dump(this.mContext, fout);     // Catch: Throwable -> L7
        fout.decreaseIndent();     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L16
    L9:
        int i3 = 0;
        int count3 = this.mCommitters.size();     // Catch: Throwable -> L7
    L10:
        if (i3 >= count3) goto L12;
        Committer committer = this.mCommitters.valueAt(i3);     // Catch: Throwable -> L7
        fout.println("committer " + committer.toString());     // Catch: Throwable -> L7
        fout.increaseIndent();     // Catch: Throwable -> L7
        committer.dump(fout);     // Catch: Throwable -> L7
        fout.decreaseIndent();     // Catch: Throwable -> L7
        i3 = i3 + 1;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void writeToXml(XmlSerializer out) throws IOException {
        Object r0 = this.mMetadataLock;
        monitor-enter(r0);
        XmlUtils.writeLongAttribute(out, "id", this.mBlobId);     // Catch: Throwable -> L7
        out.startTag(null, "bh");     // Catch: Throwable -> L7
        this.mBlobHandle.writeToXml(out);     // Catch: Throwable -> L7
        out.endTag(null, "bh");     // Catch: Throwable -> L7
        int i = 0;
        int count = this.mCommitters.size();     // Catch: Throwable -> L7
    L5:
        if (i >= count) goto L9;
        out.startTag(null, "c");     // Catch: Throwable -> L7
        this.mCommitters.valueAt(i).writeToXml(out);     // Catch: Throwable -> L7
        out.endTag(null, "c");     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int i2 = 0;
        int count2 = this.mLeasees.size();     // Catch: Throwable -> L7
    L10:
        if (i2 >= count2) goto L13;
        out.startTag(null, "l");     // Catch: Throwable -> L7
        this.mLeasees.valueAt(i2).writeToXml(out);     // Catch: Throwable -> L7
        out.endTag(null, "l");     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static BlobMetadata createFromXml(XmlPullParser in, int version, Context context) throws XmlPullParserException, IOException {
        long blobId = XmlUtils.readLongAttribute(in, "id");
        if (version >= 6) goto L5;
        XmlUtils.readIntAttribute(in, "us");
    L5:
        BlobHandle blobHandle = null;
        ArraySet<Committer> committers = new ArraySet();
        ArraySet<Leasee> leasees = new ArraySet();
        int depth = in.getDepth();
    L7:
        if (XmlUtils.nextElementWithin(in, depth) == false) goto L20;
        if ("bh".equals(in.getName()) == true) goto L10;
        if ("c".equals(in.getName()) == true) goto L13;
        if ("l".equals(in.getName()) == false) goto L7;
        leasees.add(Leasee.createFromXml(in, version));
        goto L7
    L13:
        Committer committer = Committer.createFromXml(in, version);
        if (committer == null) goto L7;
        committers.add(committer);
        goto L7
    L10:
        blobHandle = BlobHandle.createFromXml(in);
        goto L7
    L20:
        if (blobHandle != null) goto L23;
        Slog.wtf(BlobStoreConfig.TAG, "blobHandle should be available");
        return null;
    L23:
        BlobMetadata blobMetadata = new BlobMetadata(context, blobId, blobHandle);
        blobMetadata.setCommitters(committers);
        blobMetadata.setLeasees(leasees);
        return blobMetadata;
    }
}
