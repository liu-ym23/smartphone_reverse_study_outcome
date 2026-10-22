package com.android.server.pm.permission;

import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.SyncNotedAppOp;
import android.content.AttributionSource;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.IBinder;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.function.DodecFunction;
import com.android.internal.util.function.HexConsumer;
import com.android.internal.util.function.HexFunction;
import com.android.internal.util.function.NonaFunction;
import com.android.internal.util.function.QuadFunction;
import com.android.internal.util.function.TriFunction;
import com.android.internal.util.function.UndecFunction;
import com.android.server.LocalServices;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface AccessCheckDelegate extends PermissionManagerServiceInternal.CheckPermissionDelegate, AppOpsManagerInternal.CheckOpsDelegate {

    public static class AccessCheckDelegateImpl implements AccessCheckDelegate {
        public static final String SHELL_PKG = "com.android.shell";
        boolean mDelegateAllPermissions;
        private int mDelegateAndOwnerUid;
        private String mDelegatePackage;
        private String[] mDelegatePermissions;
        private final Object mLock;
        private SparseArray<ArrayMap<String, Integer>> mOverridePermissionStates;

        public AccessCheckDelegateImpl() {
            this.mLock = new Object();
            this.mDelegateAndOwnerUid = -1;
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public void setShellPermissionDelegate(int uid, String packageName, String[] permissions) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mDelegateAndOwnerUid = uid;     // Catch: Throwable -> L12
            this.mDelegatePackage = packageName;     // Catch: Throwable -> L12
            this.mDelegatePermissions = permissions;     // Catch: Throwable -> L12
            if (permissions != null) goto L7;
            boolean r1 = true;
        L8:
            this.mDelegateAllPermissions = r1;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            PackageManager.invalidatePackageInfoCache();
            return;
        L7:
            r1 = false;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public void removeShellPermissionDelegate() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mDelegatePackage = null;     // Catch: Throwable -> L9
            this.mDelegatePermissions = null;     // Catch: Throwable -> L9
            this.mDelegateAllPermissions = false;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            PackageManager.invalidatePackageInfoCache();
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public void addOverridePermissionState(int ownerUid, int uid, String permission, int state) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mOverridePermissionStates != null) goto L9;
            this.mDelegateAndOwnerUid = ownerUid;     // Catch: Throwable -> L7
            this.mOverridePermissionStates = new SparseArray();     // Catch: Throwable -> L7
        L9:
            int uidIdx = this.mOverridePermissionStates.indexOfKey(uid);     // Catch: Throwable -> L7
            if (uidIdx >= 0) goto L12;
            ArrayMap<String, Integer> perUidOverrides = new ArrayMap();     // Catch: Throwable -> L7
            this.mOverridePermissionStates.put(uid, perUidOverrides);     // Catch: Throwable -> L7
        L13:
            perUidOverrides.put(permission, Integer.valueOf(state));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            PackageManager.invalidatePackageInfoCache();
            return;
        L12:
            perUidOverrides = this.mOverridePermissionStates.valueAt(uidIdx);     // Catch: Throwable -> L7
            goto L13
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public void removeOverridePermissionState(int uid, String permission) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mOverridePermissionStates != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            ArrayMap<String, Integer> perUidOverrides = this.mOverridePermissionStates.get(uid);     // Catch: Throwable -> L8
            if (perUidOverrides != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L14:
            perUidOverrides.remove(permission);     // Catch: Throwable -> L8
            if (perUidOverrides.isEmpty() == false) goto L18;
            this.mOverridePermissionStates.remove(uid);     // Catch: Throwable -> L8
        L18:
            if (this.mOverridePermissionStates.size() != 0) goto L20;
            this.mOverridePermissionStates = null;     // Catch: Throwable -> L8
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManager.invalidatePackageInfoCache();
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public void clearOverridePermissionStates(int uid) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mOverridePermissionStates != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.mOverridePermissionStates.remove(uid);     // Catch: Throwable -> L8
            if (this.mOverridePermissionStates.size() != 0) goto L13;
            this.mOverridePermissionStates = null;     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
            PackageManager.invalidatePackageInfoCache();
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public void clearAllOverridePermissionStates() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mOverridePermissionStates = null;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            PackageManager.invalidatePackageInfoCache();
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public List<String> getDelegatedPermissionNames() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mDelegatePermissions != null) goto L7;
            List<String> r1 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = List.of(this.mDelegatePermissions);     // Catch: Throwable -> L10
            goto L8
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public boolean hasShellPermissionDelegate() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mDelegateAllPermissions == true) goto L12;
            if (this.mDelegatePermissions != null) goto L12;
            boolean r1 = false;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L12:
            r1 = true;
            goto L13
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public boolean isDelegatePackage(int uid, String packageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mDelegateAndOwnerUid == uid) goto L7;
        L11:
            boolean r1 = false;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L7:
            if (TextUtils.equals(this.mDelegatePackage, packageName) == false) goto L11;
            r1 = true;
            goto L12
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public boolean hasOverriddenPermissions() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mOverridePermissionStates == null) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public boolean isDelegateAndOwnerUid(int uid) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (uid != this.mDelegateAndOwnerUid) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.permission.AccessCheckDelegate
        public boolean hasDelegateOrOverrides() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (hasShellPermissionDelegate() == true) goto L12;
            if (hasOverriddenPermissions() == true) goto L12;
            boolean r1 = false;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L12:
            r1 = true;
            goto L13
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal.CheckPermissionDelegate
        public int checkPermission(String packageName, String permissionName, String persistentDeviceId, int userId, QuadFunction<String, String, String, Integer, Integer> superImpl) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            boolean r4 = false;
            if ("com.android.shell".equals(packageName) == false) goto L7;
        L13:
            boolean r0 = false;
        L14:
            boolean useShellDelegate = r0;
            if (this.mOverridePermissionStates == null) goto L17;
            r4 = true;
        L17:
            boolean hasOverridePermissionStates = r4;
            monitor-exit(r2);     // Catch: Throwable -> L11
            if (useShellDelegate == true) goto L41;
            if (hasOverridePermissionStates == false) goto L41;
            int uid = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageUid(packageName, 0, userId);
            if (uid < 0) goto L41;
            Object r5 = this.mLock;
            monitor-enter(r5);
        L34:
            th = move-exception;
            throw th;
        L26:
            if (this.mOverridePermissionStates == null) goto L36;
            Map<String, Integer> permissionGrants = this.mOverridePermissionStates.get(uid);     // Catch: Throwable -> L34
            if (permissionGrants == null) goto L36;
            if (permissionGrants.containsKey(permissionName) == false) goto L36;
            int r6 = permissionGrants.get(permissionName).intValue();     // Catch: Throwable -> L34
            monitor-exit(r5);     // Catch: Throwable -> L34
            return r6;
        L36:
            monitor-exit(r5);     // Catch: Throwable -> L34
        L41:
            if (useShellDelegate == false) goto L50;
            long identity = Binder.clearCallingIdentity();
            int r1 = checkPermission("com.android.shell", permissionName, persistentDeviceId, userId, superImpl);     // Catch: Throwable -> L46
            Binder.restoreCallingIdentity(identity);
            return r1;
        L46:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L50:
            return ((Integer) superImpl.apply(packageName, permissionName, persistentDeviceId, Integer.valueOf(userId))).intValue();
        L7:
            if (TextUtils.equals(this.mDelegatePackage, packageName) == false) goto L13;
            if (isDelegatePermission(permissionName) == false) goto L13;
            r0 = true;
        L11:
            th = th;
        L58:
            throw th;
        L53:
            th = th;
            goto L58
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal.CheckPermissionDelegate
        public int checkUidPermission(int uid, String permissionName, String persistentDeviceId, TriFunction<Integer, String, String, Integer> superImpl) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            if (uid != 2000) goto L38;
        L13:
            boolean useShellDelegate = false;
        L15:
            if (useShellDelegate == false) goto L17;
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (useShellDelegate == false) goto L35;
            long identity = Binder.clearCallingIdentity();
            int r1 = checkUidPermission(2000, permissionName, persistentDeviceId, superImpl);     // Catch: Throwable -> L31
            Binder.restoreCallingIdentity(identity);
            return r1;
        L31:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L35:
            return ((Integer) superImpl.apply(Integer.valueOf(uid), permissionName, persistentDeviceId)).intValue();
        L17:
            if (this.mOverridePermissionStates == null) goto L25;
            Map<String, Integer> permissionGrants = this.mOverridePermissionStates.get(uid);     // Catch: Throwable -> L11
            if (permissionGrants == null) goto L25;
            if (permissionGrants.containsKey(permissionName) == false) goto L25;
            int r2 = permissionGrants.get(permissionName).intValue();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L38:
        L11:
            th = move-exception;
            throw th;
        L7:
            if (uid != this.mDelegateAndOwnerUid) goto L13;
            if (isDelegatePermission(permissionName) == false) goto L13;
            useShellDelegate = true;
            goto L15
        }

        public int checkOperation(int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean raw, HexFunction<Integer, Integer, String, String, Integer, Boolean, Integer> superImpl) {
            Object r1 = this.mLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (uid == this.mDelegateAndOwnerUid) goto L7;
        L11:
            boolean r0 = false;
        L12:
            boolean useShellDelegate = r0;
            monitor-exit(r1);     // Catch: Throwable -> L9
            if (useShellDelegate == false) goto L23;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(uid), 2000);
            long identity = Binder.clearCallingIdentity();
            int r2 = ((Integer) superImpl.apply(Integer.valueOf(code), Integer.valueOf(shellUid), "com.android.shell", null, Integer.valueOf(virtualDeviceId), Boolean.valueOf(raw))).intValue();     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(identity);
            return r2;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L23:
            return ((Integer) superImpl.apply(Integer.valueOf(code), Integer.valueOf(uid), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(raw))).intValue();
        L7:
            if (isDelegateOp(code) == false) goto L11;
            r0 = true;
            goto L12
        }

        public int checkAudioOperation(int code, int usage, int uid, String packageName, QuadFunction<Integer, Integer, Integer, String, Integer> superImpl) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (uid == this.mDelegateAndOwnerUid) goto L7;
        L11:
            boolean useShellDelegate = false;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (useShellDelegate == false) goto L23;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(uid), 2000);
            long identity = Binder.clearCallingIdentity();
            int r4 = ((Integer) superImpl.apply(Integer.valueOf(code), Integer.valueOf(usage), Integer.valueOf(shellUid), "com.android.shell")).intValue();     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(identity);
            return r4;
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L23:
            return ((Integer) superImpl.apply(Integer.valueOf(code), Integer.valueOf(usage), Integer.valueOf(uid), packageName)).intValue();
        L7:
            if (isDelegateOp(code) == false) goto L11;
            useShellDelegate = true;
            goto L13
        }

        public SyncNotedAppOp noteOperation(int code, int uid, String packageName, String featureId, int virtualDeviceId, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int notedCount, NonaFunction<Integer, Integer, String, String, Integer, Boolean, String, Boolean, Integer, SyncNotedAppOp> superImpl) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            if (uid == this.mDelegateAndOwnerUid) goto L8;
        L12:
            boolean r0 = false;
        L13:
            boolean useShellDelegate = r0;
            monitor-exit(r2);     // Catch: Throwable -> L10
            if (useShellDelegate == false) goto L24;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(uid), 2000);
            long identity = Binder.clearCallingIdentity();
            SyncNotedAppOp r1 = (SyncNotedAppOp) superImpl.apply(Integer.valueOf(code), Integer.valueOf(shellUid), "com.android.shell", featureId, Integer.valueOf(virtualDeviceId), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Integer.valueOf(notedCount));     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(identity);
            return r1;
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L24:
            return (SyncNotedAppOp) superImpl.apply(Integer.valueOf(code), Integer.valueOf(uid), packageName, featureId, Integer.valueOf(virtualDeviceId), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Integer.valueOf(notedCount));
        L8:
            if (isDelegateOp(code) == false) goto L12;
            r0 = true;
        L10:
            th = th;
        L27:
            monitor-exit(r2);     // Catch: Throwable -> L10
            throw th;
        L25:
            th = th;
            goto L27
        }

        public SyncNotedAppOp noteProxyOperation(int code, AttributionSource attributionSource, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skiProxyOperation, HexFunction<Integer, AttributionSource, Boolean, String, Boolean, Boolean, SyncNotedAppOp> superImpl) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            boolean isDelegateOp = isDelegateOp(code);     // Catch: Throwable -> L26
            int delegateAndOwnerUid = this.mDelegateAndOwnerUid;     // Catch: Throwable -> L26
            monitor-exit(r2);     // Catch: Throwable -> L26
            if (isDelegateOp == false) goto L8;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(attributionSource.getUid()), 2000);
            AttributionSource next = attributionSource.getNext();
            if (next != null) goto L12;
        L14:
            AttributionSource attributionSource2 = attributionSource;
        L16:
            if (attributionSource2.getUid() != delegateAndOwnerUid) goto L18;
            AttributionSource attributionSource3 = new AttributionSource(shellUid, -1, "com.android.shell", attributionSource2.getAttributionTag(), attributionSource2.getToken(), null, attributionSource2.getDeviceId(), attributionSource2.getNext());
        L19:
            long identity = Binder.clearCallingIdentity();
            SyncNotedAppOp r0 = (SyncNotedAppOp) superImpl.apply(Integer.valueOf(code), attributionSource3, Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Boolean.valueOf(skiProxyOperation));     // Catch: Throwable -> L23
            Binder.restoreCallingIdentity(identity);
            return r0;
        L23:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L18:
            attributionSource3 = attributionSource2;
            goto L19
        L12:
            if (next.getUid() != delegateAndOwnerUid) goto L14;
            attributionSource2 = new AttributionSource(attributionSource, new AttributionSource(shellUid, -1, "com.android.shell", next.getAttributionTag(), next.getToken(), null, next.getDeviceId(), next.getNext()));
            goto L16
        L8:
            return (SyncNotedAppOp) superImpl.apply(Integer.valueOf(code), attributionSource, Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Boolean.valueOf(skiProxyOperation));
        L26:
            th = th;
        L32:
            throw th;
        L30:
            th = th;
            goto L32
        }

        public SyncNotedAppOp startOperation(IBinder token, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, int attributionFlags, int attributionChainId, DodecFunction<IBinder, Integer, Integer, String, String, Integer, Boolean, Boolean, String, Boolean, Integer, Integer, SyncNotedAppOp> superImpl) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            if (uid != this.mDelegateAndOwnerUid) goto L13;
            int r4 = code;
            if (isDelegateOp(r4) == false) goto L14;
            boolean r0 = true;
        L15:
            boolean useShellDelegate = r0;
            monitor-exit(r2);     // Catch: Throwable -> L11
            if (useShellDelegate == false) goto L26;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(uid), 2000);
            long identity = Binder.clearCallingIdentity();
            SyncNotedAppOp r1 = (SyncNotedAppOp) superImpl.apply(token, Integer.valueOf(r4), Integer.valueOf(shellUid), "com.android.shell", attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(startIfModeDefault), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Integer.valueOf(attributionFlags), Integer.valueOf(attributionChainId));     // Catch: Throwable -> L22
            Binder.restoreCallingIdentity(identity);
            return r1;
        L22:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L26:
            return (SyncNotedAppOp) superImpl.apply(token, Integer.valueOf(r4), Integer.valueOf(uid), packageName, attributionTag, Integer.valueOf(virtualDeviceId), Boolean.valueOf(startIfModeDefault), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Integer.valueOf(attributionFlags), Integer.valueOf(attributionChainId));
        L14:
            r0 = false;
            goto L15
        L13:
            r4 = code;
        L11:
            th = th;
        L29:
            monitor-exit(r2);     // Catch: Throwable -> L11
            throw th;
        L27:
            th = th;
            goto L29
        }

        public SyncNotedAppOp startProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean startIfModeDefault, boolean shouldCollectAsyncNotedOp, String message, boolean shouldCollectMessage, boolean skipProxyOperation, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId, UndecFunction<IBinder, Integer, AttributionSource, Boolean, Boolean, String, Boolean, Boolean, Integer, Integer, Integer, SyncNotedAppOp> superImpl) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            if (attributionSource.getUid() != this.mDelegateAndOwnerUid) goto L12;
            int r3 = code;
            if (isDelegateOp(r3) == false) goto L13;
            boolean r0 = true;
        L14:
            boolean useShellDelegate = r0;
            monitor-exit(r2);     // Catch: Throwable -> L10
            if (useShellDelegate == false) goto L25;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(attributionSource.getUid()), 2000);
            long identity = Binder.clearCallingIdentity();
            SyncNotedAppOp r1 = (SyncNotedAppOp) superImpl.apply(clientId, Integer.valueOf(r3), new AttributionSource(shellUid, -1, "com.android.shell", attributionSource.getAttributionTag(), attributionSource.getToken(), null, attributionSource.getDeviceId(), attributionSource.getNext()), Boolean.valueOf(startIfModeDefault), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Boolean.valueOf(skipProxyOperation), Integer.valueOf(proxyAttributionFlags), Integer.valueOf(proxiedAttributionFlags), Integer.valueOf(attributionChainId));     // Catch: Throwable -> L21
            Binder.restoreCallingIdentity(identity);
            return r1;
        L21:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L25:
            return (SyncNotedAppOp) superImpl.apply(clientId, Integer.valueOf(r3), attributionSource, Boolean.valueOf(startIfModeDefault), Boolean.valueOf(shouldCollectAsyncNotedOp), message, Boolean.valueOf(shouldCollectMessage), Boolean.valueOf(skipProxyOperation), Integer.valueOf(proxyAttributionFlags), Integer.valueOf(proxiedAttributionFlags), Integer.valueOf(attributionChainId));
        L13:
            r0 = false;
            goto L14
        L12:
            r3 = code;
        L26:
            th = th;
        L28:
            monitor-exit(r2);     // Catch: Throwable -> L10
            throw th;
        L10:
            th = th;
            goto L28
        }

        public void finishProxyOperation(IBinder clientId, int code, AttributionSource attributionSource, boolean skipProxyOperation, QuadFunction<IBinder, Integer, AttributionSource, Boolean, Void> superImpl) {
            Object r4 = this.mLock;
            monitor-enter(r4);
            if (attributionSource.getUid() != this.mDelegateAndOwnerUid) goto L12;
            int r5 = code;
        L10:
            th = th;
        L36:
            monitor-exit(r4);     // Catch: Throwable -> L30
            throw th;
        L30:
            th = th;
            goto L36
        L8:
            if (isDelegateOp(r5) == false) goto L13;
            boolean r0 = true;
        L14:
            boolean useShellDelegate = r0;
            monitor-exit(r4);     // Catch: Throwable -> L10
            if (useShellDelegate == false) goto L24;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(attributionSource.getUid()), 2000);
            long identity = Binder.clearCallingIdentity();
            superImpl.apply(clientId, Integer.valueOf(r5), new AttributionSource(shellUid, -1, "com.android.shell", attributionSource.getAttributionTag(), attributionSource.getToken(), null, attributionSource.getDeviceId(), attributionSource.getNext()), Boolean.valueOf(skipProxyOperation));     // Catch: Throwable -> L21
            Binder.restoreCallingIdentity(identity);
            return;
        L21:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L24:
            superImpl.apply(clientId, Integer.valueOf(r5), attributionSource, Boolean.valueOf(skipProxyOperation));
            return;
        L13:
            r0 = false;
            goto L14
        L12:
            r5 = code;
        L26:
            th = th;
            goto L36
        }

        public void finishOperation(IBinder clientId, int code, int uid, String packageName, String attributionTag, int virtualDeviceId, HexConsumer<IBinder, Integer, Integer, String, String, Integer> superImpl) {
            Object r2 = this.mLock;
            monitor-enter(r2);
            if (uid != this.mDelegateAndOwnerUid) goto L13;
            int r4 = code;
            if (isDelegateOp(r4) == false) goto L14;
            boolean r0 = true;
        L15:
            boolean useShellDelegate = r0;
            monitor-exit(r2);     // Catch: Throwable -> L11
            if (useShellDelegate == false) goto L25;
            int shellUid = UserHandle.getUid(UserHandle.getUserId(uid), 2000);
            long identity = Binder.clearCallingIdentity();
            superImpl.accept(clientId, Integer.valueOf(r4), Integer.valueOf(shellUid), "com.android.shell", attributionTag, Integer.valueOf(virtualDeviceId));     // Catch: Throwable -> L22
            Binder.restoreCallingIdentity(identity);
            return;
        L22:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L25:
            superImpl.accept(clientId, Integer.valueOf(r4), Integer.valueOf(uid), packageName, attributionTag, Integer.valueOf(virtualDeviceId));
            return;
        L14:
            r0 = false;
            goto L15
        L13:
            r4 = code;
        L11:
            th = th;
        L29:
            monitor-exit(r2);     // Catch: Throwable -> L11
            throw th;
        L27:
            th = th;
            goto L29
        }

        private boolean isDelegatePermission(String permission) {
            if (this.mDelegateAndOwnerUid != (-1)) goto L5;
        L9:
            return false;
        L5:
            if (this.mDelegateAllPermissions == false) goto L7;
        L8:
            return true;
        L7:
            if (ArrayUtils.contains(this.mDelegatePermissions, permission) == false) goto L9;
            goto L8
        }

        private boolean isDelegateOp(int code) {
            if (this.mDelegateAllPermissions == false) goto L5;
            return true;
        L5:
            String permission = AppOpsManager.opToPermission(code);
            if (permission != null) goto L9;
            return true;
        L9:
            return isDelegatePermission(permission);
        }
    }

    void addOverridePermissionState(int r1, int r2, String r3, int r4);

    void clearAllOverridePermissionStates();

    void clearOverridePermissionStates(int r1);

    List<String> getDelegatedPermissionNames();

    boolean hasDelegateOrOverrides();

    boolean hasOverriddenPermissions();

    boolean hasShellPermissionDelegate();

    boolean isDelegateAndOwnerUid(int r1);

    boolean isDelegatePackage(int r1, String r2);

    void removeOverridePermissionState(int r1, String r2);

    void removeShellPermissionDelegate();

    void setShellPermissionDelegate(int r1, String r2, String[] r3);
}
