package com.android.server.notification;

import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.ParceledListSlice;
import android.net.Uri;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.permission.IPermissionManager;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionHelper {
    private static final String NOTIFICATION_PERMISSION = "android.permission.POST_NOTIFICATIONS";
    private static final String TAG = "PermissionHelper";
    private final Context mContext;
    private final IPackageManager mPackageManager;
    private final IPermissionManager mPermManager;

    public static class PackagePermission {
        public final boolean granted;
        public final String packageName;
        public final int userId;
        public final boolean userModifiedSettings;

        public PackagePermission(String pkg, int userId, boolean granted, boolean userSet) {
            this.packageName = pkg;
            this.userId = userId;
            this.granted = granted;
            this.userModifiedSettings = userSet;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L21;
            PackagePermission that = (PackagePermission) o;
            if (this.userId != that.userId) goto L20;
            if (this.granted != that.granted) goto L20;
            if (this.userModifiedSettings != that.userModifiedSettings) goto L20;
            if (Objects.equals(this.packageName, that.packageName) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.packageName, Integer.valueOf(this.userId), Boolean.valueOf(this.granted), Boolean.valueOf(this.userModifiedSettings)});
        }

        public String toString() {
            return "PackagePermission{packageName='" + this.packageName + "', userId=" + this.userId + ", granted=" + this.granted + ", userSet=" + this.userModifiedSettings + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$ujfEcEaO8KtQKpKwTI2OrrAIhFM(UriGrantsManagerInternal r0, int r1, Uri r2) {
        lambda$grantUriPermission$0(r0, r1, r2);
    }

    public PermissionHelper(Context context, IPackageManager packageManager, IPermissionManager permManager) {
        this.mContext = context;
        this.mPackageManager = packageManager;
        this.mPermManager = permManager;
    }

    public boolean hasPermission(int uid) {
        long callingId = Binder.clearCallingIdentity();
        if (this.mContext.checkPermission(NOTIFICATION_PERMISSION, -1, uid) != 0) goto L6;
        boolean r2 = true;
    L7:
        Binder.restoreCallingIdentity(callingId);
        return r2;
    L6:
        r2 = false;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    public boolean hasRequestedPermission(String permission, String pkg, int userId) {
        long callingId = Binder.clearCallingIdentity();
        PackageInfo pi = this.mPackageManager.getPackageInfo(pkg, 4096, userId);     // Catch: Throwable -> L15 RemoteException -> L17
        if (pi == null) goto L21;
        if (pi.requestedPermissions == null) goto L21;
        String[] r4 = pi.requestedPermissions;     // Catch: Throwable -> L15 RemoteException -> L17
        int r5 = r4.length;     // Catch: Throwable -> L15 RemoteException -> L17
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L20;
        String perm = r4[r6];     // Catch: Throwable -> L15 RemoteException -> L17
        if (permission.equals(perm) == true) goto L12;
        r6 = r6 + 1;
        goto L9
    L12:
        Binder.restoreCallingIdentity(callingId);
        return true;
    L20:
        Binder.restoreCallingIdentity(callingId);
        return false;
    L21:
        Binder.restoreCallingIdentity(callingId);
        return false;
    L17:
        e = move-exception;
        Slog.d(TAG, "Could not reach system server", e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    Set<Pair<Integer, String>> getAppsRequestingPermission(int userId) {
        Set<Pair<Integer, String>> requested = new HashSet();
        List<PackageInfo> pkgs = getInstalledPackages(userId);
        Iterator<PackageInfo> r2 = pkgs.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        PackageInfo pi = r2.next();
        if (pi.requestedPermissions == null) goto L4;
        String[] r4 = pi.requestedPermissions;
        int r5 = r4.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L4;
        String perm = r4[r6];
        if (NOTIFICATION_PERMISSION.equals(perm) == true) goto L13;
        r6 = r6 + 1;
        goto L10
    L13:
        requested.add(new Pair(Integer.valueOf(pi.applicationInfo.uid), pi.packageName));
        goto L4
    L16:
        return requested;
    }

    private List<PackageInfo> getInstalledPackages(int userId) {
        ParceledListSlice<PackageInfo> parceledList = null;
        parceledList = this.mPackageManager.getInstalledPackages(4096, userId);     // Catch: RemoteException -> L5
    L7:
        if (parceledList != null) goto L11;
        return Collections.emptyList();
    L11:
        return parceledList.getList();
    L5:
        e = move-exception;
        Slog.d(TAG, "Could not reach system server", e);
        goto L7
    }

    Set<Pair<Integer, String>> getAppsGrantedPermission(int userId) {
        Set<Pair<Integer, String>> granted = new HashSet();
        ParceledListSlice<PackageInfo> parceledList = null;
        parceledList = this.mPackageManager.getPackagesHoldingPermissions(new String[]{NOTIFICATION_PERMISSION}, 0, userId);     // Catch: RemoteException -> L5
    L7:
        if (parceledList != null) goto L9;
        return granted;
    L9:
        Iterator r2 = parceledList.getList().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        PackageInfo pi = (PackageInfo) r2.next();
        granted.add(new Pair(Integer.valueOf(pi.applicationInfo.uid), pi.packageName));
        goto L11
    L13:
        return granted;
    L5:
        e = move-exception;
        Slog.e(TAG, "Could not reach system server", e);
        goto L7
    }

    public ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> getNotificationPermissionValues(int userId) {
        ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> notifPermissions = new ArrayMap();
        Set<Pair<Integer, String>> allRequestingUids = getAppsRequestingPermission(userId);
        Set<Pair<Integer, String>> allApprovedUids = getAppsGrantedPermission(userId);
        Iterator<Pair<Integer, String>> r3 = allRequestingUids.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Pair<Integer, String> pair = r3.next();
        notifPermissions.put(pair, new Pair(Boolean.valueOf(allApprovedUids.contains(pair)), Boolean.valueOf(isPermissionUserSet((String) pair.second, userId))));
        goto L4
    L6:
        return notifPermissions;
    }

    public void setNotificationPermission(String packageName, int userId, boolean grant, boolean userSet) {
        long callingId = Binder.clearCallingIdentity();
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L17:
        e = move-exception;
        Slog.e(TAG, "Could not reach system server", e);     // Catch: Throwable -> L15
    L27:
        Binder.restoreCallingIdentity(callingId);
        return;
    L4:
        if (packageRequestsNotificationPermission(packageName, userId) == true) goto L6;
    L28:
        Binder.restoreCallingIdentity(callingId);
        return;
    L6:
        if (isPermissionFixed(packageName, userId) == true) goto L28;
        if (isPermissionGrantedByDefaultOrRole(packageName, userId) == false) goto L11;
        if (userSet == false) goto L28;
    L11:
        int uid = this.mPackageManager.getPackageUid(packageName, 0, userId);     // Catch: Throwable -> L15 RemoteException -> L17
        boolean currentlyGranted = hasPermission(uid);     // Catch: Throwable -> L15 RemoteException -> L17
        if (grant == false) goto L19;
        if (currentlyGranted == true) goto L19;
        this.mPermManager.grantRuntimePermission(packageName, NOTIFICATION_PERMISSION, "default:0", userId);     // Catch: Throwable -> L15 RemoteException -> L17
    L23:
        if (userSet == false) goto L25;
        this.mPermManager.updatePermissionFlags(packageName, NOTIFICATION_PERMISSION, 3, 1, true, "default:0", userId);     // Catch: Throwable -> L15 RemoteException -> L17
        goto L27
    L25:
        this.mPermManager.updatePermissionFlags(packageName, NOTIFICATION_PERMISSION, 3, 0, true, "default:0", userId);     // Catch: Throwable -> L15 RemoteException -> L17
    L19:
        if (grant == true) goto L23;
        if (currentlyGranted == false) goto L23;
        this.mPermManager.revokeRuntimePermission(packageName, NOTIFICATION_PERMISSION, "default:0", userId, TAG);     // Catch: Throwable -> L15 RemoteException -> L17
        goto L23
    }

    public void setNotificationPermission(PackagePermission pkgPerm) {
        if (pkgPerm != null) goto L4;
        return;
    L4:
        if (pkgPerm.packageName != null) goto L7;
        return;
    L7:
        if (isPermissionFixed(pkgPerm.packageName, pkgPerm.userId) == true) goto L11;
        setNotificationPermission(pkgPerm.packageName, pkgPerm.userId, pkgPerm.granted, true);
        return;
    }

    public boolean isPermissionFixed(String packageName, int userId) {
        long callingId = Binder.clearCallingIdentity();
        boolean r2 = false;
        int flags = this.mPermManager.getPermissionFlags(packageName, NOTIFICATION_PERMISSION, "default:0", userId);     // Catch: Throwable -> L11 RemoteException -> L13
    L5:
        if ((flags & 16) == 0) goto L7;
    L8:
        r2 = true;
    L9:
        Binder.restoreCallingIdentity(callingId);
        return r2;
    L7:
        if ((flags & 4) == 0) goto L9;
    L13:
        e = move-exception;
        Slog.e(TAG, "Could not reach system server", e);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(callingId);
        return false;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    boolean isPermissionUserSet(String packageName, int userId) {
        long callingId = Binder.clearCallingIdentity();
        boolean r2 = false;
        int flags = this.mPermManager.getPermissionFlags(packageName, NOTIFICATION_PERMISSION, "default:0", userId);     // Catch: Throwable -> L9 RemoteException -> L11
    L5:
        if ((flags & 3) == 0) goto L7;
        r2 = true;
    L7:
        Binder.restoreCallingIdentity(callingId);
        return r2;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L11:
        e = move-exception;
        Slog.e(TAG, "Could not reach system server", e);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(callingId);
        return false;
    }

    boolean isPermissionGrantedByDefaultOrRole(String packageName, int userId) {
        long callingId = Binder.clearCallingIdentity();
        boolean r2 = false;
        int flags = this.mPermManager.getPermissionFlags(packageName, NOTIFICATION_PERMISSION, "default:0", userId);     // Catch: Throwable -> L9 RemoteException -> L11
    L5:
        if ((32800 & flags) == 0) goto L7;
        r2 = true;
    L7:
        Binder.restoreCallingIdentity(callingId);
        return r2;
    L11:
        e = move-exception;
        Slog.e(TAG, "Could not reach system server", e);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(callingId);
        return false;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    }

    private boolean packageRequestsNotificationPermission(String packageName, int userId) {
        PackageInfo pi = this.mPackageManager.getPackageInfo(packageName, 4096, userId);     // Catch: RemoteException -> L6
        if (pi == null) goto L14;
        String[] permissions = pi.requestedPermissions;     // Catch: RemoteException -> L6
        return ArrayUtils.contains(permissions, NOTIFICATION_PERMISSION);
    L14:
        return false;
    L6:
        e = move-exception;
        Slog.e(TAG, "Could not reach system server", e);
        return false;
    }

    static void grantUriPermission(final UriGrantsManagerInternal ugmInternal, final Uri uri, final int sourceUid) {
        if (uri != null) goto L4;
        return;
    L4:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L9;
        Binder.withCleanCallingIdentity(new PermissionHelper$$ExternalSyntheticLambda0(ugmInternal, sourceUid, uri));
        return;
    }

    private static /* synthetic */ void lambda$grantUriPermission$0(UriGrantsManagerInternal ugmInternal, int sourceUid, Uri uri) throws Exception {
        ugmInternal.checkGrantUriPermission(sourceUid, null, ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(sourceUid)));
    }
}
