package com.android.server.blob;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Base64;
import android.util.DebugUtils;
import android.util.IndentingPrintWriter;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
class BlobAccessMode {
    public static final int ACCESS_TYPE_ALLOWLIST = 8;
    public static final int ACCESS_TYPE_PRIVATE = 1;
    public static final int ACCESS_TYPE_PUBLIC = 2;
    public static final int ACCESS_TYPE_SAME_SIGNATURE = 4;
    private int mAccessType;
    private final ArraySet<PackageIdentifier> mAllowedPackages;

    @Retention(RetentionPolicy.SOURCE)
    @interface AccessType {
    }

    private static final class PackageIdentifier {
        public final byte[] certificate;
        public final String packageName;

        private PackageIdentifier(String packageName, byte[] certificate) {
            this.packageName = packageName;
            this.certificate = certificate;
        }

        public static PackageIdentifier create(String packageName, byte[] certificate) {
            return new PackageIdentifier(packageName, certificate);
        }

        public boolean equals(Object obj) {
            if (this != obj) goto L6;
            return true;
        L6:
            if (obj != null) goto L8;
        L17:
            return false;
        L8:
            if ((obj instanceof PackageIdentifier) == false) goto L17;
            PackageIdentifier other = (PackageIdentifier) obj;
            if (this.packageName.equals(other.packageName) == false) goto L16;
            if (Arrays.equals(this.certificate, other.certificate) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.packageName, Integer.valueOf(Arrays.hashCode(this.certificate))});
        }

        public String toString() {
            return "[" + this.packageName + ", " + Base64.encodeToString(this.certificate, 2) + "]";
        }
    }

    BlobAccessMode() {
        this.mAccessType = 1;
        this.mAllowedPackages = new ArraySet();
    }

    void allow(BlobAccessMode other) {
        if ((other.mAccessType & 8) == 0) goto L5;
        this.mAllowedPackages.addAll(other.mAllowedPackages);
    L5:
        this.mAccessType |= other.mAccessType;
    }

    void allowPublicAccess() {
        this.mAccessType |= 2;
    }

    void allowSameSignatureAccess() {
        this.mAccessType |= 4;
    }

    void allowPackageAccess(String packageName, byte[] certificate) {
        this.mAccessType |= 8;
        this.mAllowedPackages.add(PackageIdentifier.create(packageName, certificate));
    }

    boolean isPublicAccessAllowed() {
        if ((this.mAccessType & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isSameSignatureAccessAllowed() {
        if ((this.mAccessType & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isPackageAccessAllowed(String packageName, byte[] certificate) {
        if ((this.mAccessType & 8) != 0) goto L7;
        return false;
    L7:
        return this.mAllowedPackages.contains(PackageIdentifier.create(packageName, certificate));
    }

    boolean isAccessAllowedForCaller(Context context, String callingPackage, int callingUid, int committerUid) {
        if ((this.mAccessType & 2) == 0) goto L6;
        return true;
    L6:
        if ((this.mAccessType & 4) == 0) goto L11;
        if (checkSignatures(callingUid, committerUid) == false) goto L11;
        return true;
    L11:
        if ((this.mAccessType & 8) == 0) goto L21;
        UserHandle callingUser = UserHandle.of(UserHandle.getUserId(callingUid));
        PackageManager pm = context.createContextAsUser(callingUser, 0).getPackageManager();
        int i = 0;
    L14:
        if (i >= this.mAllowedPackages.size()) goto L21;
        PackageIdentifier packageIdentifier = this.mAllowedPackages.valueAt(i);
        if (packageIdentifier.packageName.equals(callingPackage) == false) goto L20;
        if (pm.hasSigningCertificate(callingPackage, packageIdentifier.certificate, 1) == false) goto L20;
        return true;
    L20:
        i = i + 1;
    L21:
        return false;
    }

    private boolean checkSignatures(int uid1, int uid2) {
        long token = Binder.clearCallingIdentity();
        if (((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).checkUidSignaturesForAllUsers(uid1, uid2) != 0) goto L6;
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

    int getAccessType() {
        return this.mAccessType;
    }

    int getAllowedPackagesCount() {
        return this.mAllowedPackages.size();
    }

    void dump(IndentingPrintWriter fout) {
        fout.println("accessType: " + DebugUtils.flagsToString(BlobAccessMode.class, "ACCESS_TYPE_", this.mAccessType));
        fout.print("Explicitly allowed pkgs:");
        if (this.mAllowedPackages.isEmpty() == false) goto L5;
        fout.println(" (Empty)");
        return;
    L5:
        fout.increaseIndent();
        int i = 0;
        int count = this.mAllowedPackages.size();
    L6:
        if (i >= count) goto L8;
        fout.println(this.mAllowedPackages.valueAt(i).toString());
        i = i + 1;
        goto L6
    L8:
        fout.decreaseIndent();
    }

    void writeToXml(XmlSerializer out) throws IOException {
        XmlUtils.writeIntAttribute(out, "t", this.mAccessType);
        int i = 0;
        int count = this.mAllowedPackages.size();
    L3:
        if (i >= count) goto L6;
        out.startTag(null, "wl");
        PackageIdentifier packageIdentifier = this.mAllowedPackages.valueAt(i);
        XmlUtils.writeStringAttribute(out, "p", packageIdentifier.packageName);
        XmlUtils.writeByteArrayAttribute(out, "ct", packageIdentifier.certificate);
        out.endTag(null, "wl");
        i = i + 1;
        goto L3
    }

    static BlobAccessMode createFromXml(XmlPullParser in) throws IOException, XmlPullParserException {
        BlobAccessMode blobAccessMode = new BlobAccessMode();
        int accessType = XmlUtils.readIntAttribute(in, "t");
        blobAccessMode.mAccessType = accessType;
        int depth = in.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(in, depth) == false) goto L8;
        if ("wl".equals(in.getName()) == false) goto L4;
        String packageName = XmlUtils.readStringAttribute(in, "p");
        byte[] certificate = XmlUtils.readByteArrayAttribute(in, "ct");
        blobAccessMode.allowPackageAccess(packageName, certificate);
        goto L4
    L8:
        return blobAccessMode;
    }
}
