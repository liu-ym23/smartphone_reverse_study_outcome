package com.android.server.uri;

import android.app.GrantedUriPermission;
import android.os.Binder;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import com.google.android.collect.Sets;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class UriPermission {
    static final long INVALID_TIME = Long.MIN_VALUE;
    public static final int STRENGTH_GLOBAL = 2;
    public static final int STRENGTH_NONE = 0;
    public static final int STRENGTH_OWNED = 1;
    public static final int STRENGTH_PERSISTABLE = 3;
    private static final String TAG = "UriPermission";
    int globalModeFlags;
    private ArraySet<UriPermissionOwner> mReadOwners;
    private ArraySet<UriPermissionOwner> mWriteOwners;
    int modeFlags;
    int ownedModeFlags;
    int persistableModeFlags;
    long persistedCreateTime;
    int persistedModeFlags;
    final String sourcePkg;
    private String stringName;
    final String targetPkg;
    final int targetUid;
    final int targetUserId;
    final GrantUri uri;

    public static class PersistedTimeComparator implements Comparator<UriPermission> {
        public PersistedTimeComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(UriPermission r1, UriPermission r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(UriPermission lhs, UriPermission rhs) {
            return Long.compare(lhs.persistedCreateTime, rhs.persistedCreateTime);
        }
    }

    public static class Snapshot {
        final long persistedCreateTime;
        final int persistedModeFlags;
        final String sourcePkg;
        final String targetPkg;
        final int targetUserId;
        final GrantUri uri;

        /* synthetic */ Snapshot(UriPermission r1, UriPermissionIA r2) {
            this(r1);
        }

        private Snapshot(UriPermission perm) {
            this.targetUserId = perm.targetUserId;
            this.sourcePkg = perm.sourcePkg;
            this.targetPkg = perm.targetPkg;
            this.uri = perm.uri;
            this.persistedModeFlags = perm.persistedModeFlags;
            this.persistedCreateTime = perm.persistedCreateTime;
        }
    }

    UriPermission(String sourcePkg, String targetPkg, int targetUid, GrantUri uri) {
        this.modeFlags = 0;
        this.ownedModeFlags = 0;
        this.globalModeFlags = 0;
        this.persistableModeFlags = 0;
        this.persistedModeFlags = 0;
        this.persistedCreateTime = Long.MIN_VALUE;
        this.targetUserId = UserHandle.getUserId(targetUid);
        this.sourcePkg = sourcePkg;
        this.targetPkg = targetPkg;
        this.targetUid = targetUid;
        this.uri = uri;
    }

    private void updateModeFlags() {
        int oldModeFlags = this.modeFlags;
        this.modeFlags = (this.ownedModeFlags | this.globalModeFlags) | this.persistedModeFlags;
        if (Log.isLoggable(TAG, 2) == true) goto L5;
        return;
    L5:
        if (this.modeFlags == oldModeFlags) goto L9;
        Slog.d(TAG, "Permission for " + this.targetPkg + " to " + this.uri + " is changing from 0x" + Integer.toHexString(oldModeFlags) + " to 0x" + Integer.toHexString(this.modeFlags) + " via calling UID " + Binder.getCallingUid() + " PID " + Binder.getCallingPid(), new Throwable());
        return;
    }

    void initPersistedModes(int modeFlags, long createdTime) {
        int modeFlags2 = modeFlags & 3;
        this.persistableModeFlags = modeFlags2;
        this.persistedModeFlags = modeFlags2;
        this.persistedCreateTime = createdTime;
        updateModeFlags();
    }

    boolean grantModes(int modeFlags, UriPermissionOwner owner) {
        if ((modeFlags & 64) == 0) goto L5;
        boolean persistable = true;
    L6:
        int modeFlags2 = modeFlags & 3;
        if (persistable == false) goto L9;
        this.persistableModeFlags |= modeFlags2;
    L9:
        if (owner != null) goto L12;
        this.globalModeFlags |= modeFlags2;
    L17:
        updateModeFlags();
        return false;
    L12:
        if ((modeFlags2 & 1) == 0) goto L15;
        addReadOwner(owner);
    L15:
        if ((modeFlags2 & 2) == 0) goto L17;
        addWriteOwner(owner);
        goto L17
    L5:
        persistable = false;
        goto L6
    }

    boolean takePersistableModes(int modeFlags) {
        int modeFlags2 = modeFlags & 3;
        if ((this.persistableModeFlags & modeFlags2) == modeFlags2) goto L6;
        Slog.w(TAG, "Requested flags 0x" + Integer.toHexString(modeFlags2) + ", but only 0x" + Integer.toHexString(this.persistableModeFlags) + " are allowed");
        return false;
    L6:
        int before = this.persistedModeFlags;
        this.persistedModeFlags |= this.persistableModeFlags & modeFlags2;
        if (this.persistedModeFlags == 0) goto L9;
        this.persistedCreateTime = System.currentTimeMillis();
    L9:
        updateModeFlags();
        if (this.persistedModeFlags == before) goto L13;
        return true;
    L13:
        return false;
    }

    boolean releasePersistableModes(int modeFlags) {
        int before = this.persistedModeFlags;
        this.persistedModeFlags &= ~(modeFlags & 3);
        if (this.persistedModeFlags != 0) goto L5;
        this.persistedCreateTime = Long.MIN_VALUE;
    L5:
        updateModeFlags();
        if (this.persistedModeFlags == before) goto L8;
        return true;
    L8:
        return false;
    }

    boolean revokeModes(int modeFlags, boolean includingOwners) {
        if ((modeFlags & 64) == 0) goto L5;
        boolean persistable = true;
    L6:
        int modeFlags2 = modeFlags & 3;
        int before = this.persistedModeFlags;
        List<UriPermissionOwner> readOwnersSnapshot = Collections.emptyList();
        List<UriPermissionOwner> writeOwnersSnapshot = Collections.emptyList();
        monitor-enter(this);
        if ((modeFlags2 & 1) == 0) goto L18;
        if (persistable == true) goto L43;
    L14:
        this.globalModeFlags &= -2;     // Catch: Throwable -> L12
        if (includingOwners == false) goto L18;
        this.ownedModeFlags &= -2;     // Catch: Throwable -> L12
        readOwnersSnapshot = snapshotOrEmpty(this.mReadOwners);     // Catch: Throwable -> L12
        this.mReadOwners = null;     // Catch: Throwable -> L12
        goto L18
    L43:
        this.persistableModeFlags &= -2;     // Catch: Throwable -> L12
        this.persistedModeFlags &= -2;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L18:
        if ((modeFlags2 & 2) == 0) goto L25;
        if (persistable == false) goto L21;
        this.persistableModeFlags &= -3;     // Catch: Throwable -> L12
        this.persistedModeFlags &= -3;     // Catch: Throwable -> L12
    L21:
        this.globalModeFlags &= -3;     // Catch: Throwable -> L12
        if (includingOwners == false) goto L25;
        this.ownedModeFlags &= -3;     // Catch: Throwable -> L12
        writeOwnersSnapshot = snapshotOrEmpty(this.mWriteOwners);     // Catch: Throwable -> L12
        this.mWriteOwners = null;     // Catch: Throwable -> L12
    L25:
        if (this.persistedModeFlags != 0) goto L27;
        this.persistedCreateTime = Long.MIN_VALUE;     // Catch: Throwable -> L12
    L27:
        updateModeFlags();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        Iterator<UriPermissionOwner> r6 = readOwnersSnapshot.iterator();
    L31:
        if (r6.hasNext() == false) goto L33;
        UriPermissionOwner r = r6.next();
        r.removeReadPermission(this);
        goto L31
    L33:
        Iterator<UriPermissionOwner> r7 = writeOwnersSnapshot.iterator();
    L35:
        if (r7.hasNext() == false) goto L38;
        UriPermissionOwner r2 = r7.next();
        r2.removeWritePermission(this);
        goto L35
    L38:
        if (this.persistedModeFlags != before) goto L40;
        return false;
    L40:
        return true;
    L5:
        persistable = false;
        goto L6
    }

    private static <T> List<T> snapshotOrEmpty(Collection<T> c) {
        if (c == null) goto L8;
        if (c.isEmpty() == true) goto L8;
        return new ArrayList(c);
    L8:
        return Collections.emptyList();
    }

    public int getStrength(int modeFlags) {
        int modeFlags2 = modeFlags & 3;
        if ((this.persistableModeFlags & modeFlags2) != modeFlags2) goto L6;
        return 3;
    L6:
        if ((this.globalModeFlags & modeFlags2) != modeFlags2) goto L10;
        return 2;
    L10:
        if ((this.ownedModeFlags & modeFlags2) != modeFlags2) goto L13;
        return 1;
    L13:
        return 0;
    }

    private synchronized void addReadOwner(UriPermissionOwner owner) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mReadOwners != null) goto L9;
        this.mReadOwners = Sets.newArraySet();     // Catch: Throwable -> L6
        this.ownedModeFlags |= 1;     // Catch: Throwable -> L6
        updateModeFlags();     // Catch: Throwable -> L6
    L9:
        if (this.mReadOwners.add(owner) == false) goto L11;
        owner.addReadPermission(this);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
    }

    synchronized void removeReadOwner(UriPermissionOwner owner) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mReadOwners != null) goto L6;
    L16:
        Slog.w(TAG, "Unknown read owner " + owner + " in " + this);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L6:
        if (this.mReadOwners.remove(owner) == false) goto L16;
        if (this.mReadOwners.size() != 0) goto L14;
        this.mReadOwners = null;     // Catch: Throwable -> L12
        this.ownedModeFlags &= -2;     // Catch: Throwable -> L12
        updateModeFlags();     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
    }

    private synchronized void addWriteOwner(UriPermissionOwner owner) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mWriteOwners != null) goto L9;
        this.mWriteOwners = Sets.newArraySet();     // Catch: Throwable -> L6
        this.ownedModeFlags |= 2;     // Catch: Throwable -> L6
        updateModeFlags();     // Catch: Throwable -> L6
    L9:
        if (this.mWriteOwners.add(owner) == false) goto L11;
        owner.addWritePermission(this);     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
    }

    synchronized void removeWriteOwner(UriPermissionOwner owner) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mWriteOwners != null) goto L6;
    L16:
        Slog.w(TAG, "Unknown write owner " + owner + " in " + this);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L6:
        if (this.mWriteOwners.remove(owner) == false) goto L16;
        if (this.mWriteOwners.size() != 0) goto L14;
        this.mWriteOwners = null;     // Catch: Throwable -> L12
        this.ownedModeFlags &= -3;     // Catch: Throwable -> L12
        updateModeFlags();     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("UriPermission{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.uri);
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L5:
        return this.stringName;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("targetUserId=" + this.targetUserId);
        pw.print(" sourcePkg=" + this.sourcePkg);
        pw.println(" targetPkg=" + this.targetPkg);
        pw.print(prefix);
        pw.print("mode=0x" + Integer.toHexString(this.modeFlags));
        pw.print(" owned=0x" + Integer.toHexString(this.ownedModeFlags));
        pw.print(" global=0x" + Integer.toHexString(this.globalModeFlags));
        pw.print(" persistable=0x" + Integer.toHexString(this.persistableModeFlags));
        pw.print(" persisted=0x" + Integer.toHexString(this.persistedModeFlags));
        if (this.persistedCreateTime == Long.MIN_VALUE) goto L5;
        pw.print(" persistedCreate=" + this.persistedCreateTime);
    L5:
        pw.println();
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.mReadOwners == null) goto L16;
        pw.print(prefix);     // Catch: Throwable -> L13
        pw.println("readOwners:");     // Catch: Throwable -> L13
        Iterator<UriPermissionOwner> r0 = this.mReadOwners.iterator();     // Catch: Throwable -> L13
    L11:
        if (r0.hasNext() == false) goto L16;
        UriPermissionOwner owner = r0.next();     // Catch: Throwable -> L13
        pw.print(prefix);     // Catch: Throwable -> L13
        pw.println("  * " + owner);     // Catch: Throwable -> L13
    L16:
        if (this.mWriteOwners == null) goto L21;
        pw.print(prefix);     // Catch: Throwable -> L13
        pw.println("writeOwners:");     // Catch: Throwable -> L13
        Iterator<UriPermissionOwner> r1 = this.mWriteOwners.iterator();     // Catch: Throwable -> L13
    L19:
        if (r1.hasNext() == false) goto L21;
        UriPermissionOwner owner2 = r1.next();     // Catch: Throwable -> L13
        pw.print(prefix);     // Catch: Throwable -> L13
        pw.println("  * " + owner2);     // Catch: Throwable -> L13
    L21:
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public Snapshot snapshot() {
        return new Snapshot(this, null);
    }

    public android.content.UriPermission buildPersistedPublicApiObject() {
        return new android.content.UriPermission(this.uri.uri, this.persistedModeFlags, this.persistedCreateTime);
    }

    public GrantedUriPermission buildGrantedUriPermission() {
        return new GrantedUriPermission(this.uri.uri, this.targetPkg);
    }
}
