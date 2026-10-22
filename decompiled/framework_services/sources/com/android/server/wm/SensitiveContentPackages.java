package com.android.server.wm;

import android.os.IBinder;
import android.util.ArraySet;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class SensitiveContentPackages {
    private final ArraySet<PackageInfo> mProtectedPackages;

    public static class PackageInfo {
        private final String mPkg;
        private final int mUid;
        private final IBinder mWindowToken;

        /* JADX INFO: renamed from: -$$Nest$fgetmPkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m10134$$Nest$fgetmPkg(PackageInfo r0) {
            return r0.mPkg;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10135$$Nest$fgetmUid(PackageInfo r0) {
            return r0.mUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWindowToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m10136$$Nest$fgetmWindowToken(PackageInfo r0) {
            return r0.mWindowToken;
        }

        public PackageInfo(String pkg, int uid) {
            this(pkg, uid, null);
        }

        public PackageInfo(String pkg, int uid, IBinder windowToken) {
            this.mPkg = pkg;
            this.mUid = uid;
            this.mWindowToken = windowToken;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof PackageInfo) == true) goto L8;
            return false;
        L8:
            PackageInfo that = (PackageInfo) o;
            if (this.mUid != that.mUid) goto L16;
            if (Objects.equals(this.mPkg, that.mPkg) == false) goto L16;
            if (Objects.equals(this.mWindowToken, that.mWindowToken) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mPkg, Integer.valueOf(this.mUid), this.mWindowToken});
        }

        public IBinder getWindowToken() {
            return this.mWindowToken;
        }

        public int getUid() {
            return this.mUid;
        }

        public String getPkg() {
            return this.mPkg;
        }

        public String toString() {
            return "package=" + this.mPkg + "  uid=" + this.mUid + " windowToken=" + this.mWindowToken;
        }
    }

    public SensitiveContentPackages() {
        this.mProtectedPackages = new ArraySet();
    }

    public boolean shouldBlockScreenCaptureForApp(String pkg, int uid, IBinder windowToken) {
        int i = 0;
    L4:
        if (i >= this.mProtectedPackages.size()) goto L18;
        PackageInfo info = this.mProtectedPackages.valueAt(i);
        if (info == null) goto L17;
        if (PackageInfo.m10134$$Nest$fgetmPkg(info).equals(pkg) == false) goto L17;
        if (PackageInfo.m10135$$Nest$fgetmUid(info) != uid) goto L17;
        if (windowToken == info.getWindowToken()) goto L15;
        if (info.getWindowToken() != null) goto L17;
        return true;
    L15:
        return true;
    L17:
        i = i + 1;
        goto L4
    L18:
        return false;
    }

    public boolean addBlockScreenCaptureForApps(ArraySet<PackageInfo> packageInfos) {
        if (this.mProtectedPackages.equals(packageInfos) == false) goto L6;
        return false;
    L6:
        this.mProtectedPackages.addAll(packageInfos);
        return true;
    }

    public boolean removeBlockScreenCaptureForApps(ArraySet<PackageInfo> packageInfos) {
        return this.mProtectedPackages.removeAll(packageInfos);
    }

    public boolean clearBlockedApps() {
        if (this.mProtectedPackages.isEmpty() == false) goto L6;
        return false;
    L6:
        this.mProtectedPackages.clear();
        return true;
    }

    public int size() {
        return this.mProtectedPackages.size();
    }

    void dump(PrintWriter pw) {
        pw.println("SensitiveContentPackages:");
        pw.println("  Packages that should block screen capture (" + this.mProtectedPackages.size() + "):");
        Iterator<PackageInfo> r1 = this.mProtectedPackages.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PackageInfo info = r1.next();
        pw.println("    package=" + PackageInfo.m10134$$Nest$fgetmPkg(info) + "  uid=" + PackageInfo.m10135$$Nest$fgetmUid(info) + " windowToken=" + PackageInfo.m10136$$Nest$fgetmWindowToken(info));
        goto L4
    }
}
