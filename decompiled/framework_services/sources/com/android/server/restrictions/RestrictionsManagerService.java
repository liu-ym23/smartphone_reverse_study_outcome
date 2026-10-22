package com.android.server.restrictions;

import android.app.AppGlobals;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.admin.IDevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.IRestrictionsManager;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IUserManager;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.UserHandle;
import com.android.internal.util.ArrayUtils;
import com.android.server.SystemService;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class RestrictionsManagerService extends SystemService {
    static final boolean DEBUG = false;
    static final String LOG_TAG = "RestrictionsManagerService";
    private final RestrictionsManagerImpl mRestrictionsManagerImpl;

    class RestrictionsManagerImpl extends IRestrictionsManager.Stub {
        final Context mContext;
        private final IDevicePolicyManager mDpm;
        private final DevicePolicyManagerInternal mDpmInternal;
        private final IUserManager mUm;

        public RestrictionsManagerImpl(RestrictionsManagerService this$0, Context context) {
            this.mContext = context;
            this.mUm = RestrictionsManagerService.access$000(this$0, "user");
            this.mDpm = RestrictionsManagerService.access$100(this$0, "device_policy");
            this.mDpmInternal = (DevicePolicyManagerInternal) RestrictionsManagerService.access$200(this$0, DevicePolicyManagerInternal.class);
        }

        @Deprecated
        public Bundle getApplicationRestrictions(String packageName) throws RemoteException {
            return this.mUm.getApplicationRestrictions(packageName);
        }

        public List<Bundle> getApplicationRestrictionsPerAdminForUser(int userId, String packageName) throws RemoteException {
            if (this.mDpmInternal == null) goto L7;
            return this.mDpmInternal.getApplicationRestrictionsPerAdminForUser(packageName, userId);
        L7:
            return new ArrayList();
        }

        public boolean hasRestrictionsProvider() throws RemoteException {
            int userHandle = UserHandle.getCallingUserId();
            boolean r2 = false;
            if (this.mDpm == null) goto L13;
            long ident = Binder.clearCallingIdentity();
            if (this.mDpm.getRestrictionsProvider(userHandle) == null) goto L8;
            r2 = true;
        L8:
            Binder.restoreCallingIdentity(ident);
            return r2;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L13:
            return false;
        }

        public void requestPermission(String packageName, String requestType, String requestId, PersistableBundle requestData) throws RemoteException {
            int callingUid = Binder.getCallingUid();
            int userHandle = UserHandle.getUserId(callingUid);
            if (this.mDpm == null) goto L15;
            long ident = Binder.clearCallingIdentity();
            ComponentName restrictionsProvider = this.mDpm.getRestrictionsProvider(userHandle);     // Catch: Throwable -> L9
            if (restrictionsProvider == null) goto L12;
            enforceCallerMatchesPackage(callingUid, packageName, "Package name does not match caller ");     // Catch: Throwable -> L9
            Intent intent = new Intent("android.content.action.REQUEST_PERMISSION");     // Catch: Throwable -> L9
            intent.setComponent(restrictionsProvider);     // Catch: Throwable -> L9
            intent.putExtra("android.content.extra.PACKAGE_NAME", packageName);     // Catch: Throwable -> L9
            intent.putExtra("android.content.extra.REQUEST_TYPE", requestType);     // Catch: Throwable -> L9
            intent.putExtra("android.content.extra.REQUEST_ID", requestId);     // Catch: Throwable -> L9
            intent.putExtra("android.content.extra.REQUEST_BUNDLE", requestData);     // Catch: Throwable -> L9
            this.mContext.sendBroadcastAsUser(intent, new UserHandle(userHandle));     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L12:
            throw new IllegalStateException("Cannot request permission without a restrictions provider registered");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public Intent createLocalApprovalIntent() throws RemoteException {
            int userHandle = UserHandle.getCallingUserId();
            if (this.mDpm == null) goto L23;
            long ident = Binder.clearCallingIdentity();
            ComponentName restrictionsProvider = this.mDpm.getRestrictionsProvider(userHandle);     // Catch: Throwable -> L16
            if (restrictionsProvider == null) goto L20;
            String providerPackageName = restrictionsProvider.getPackageName();     // Catch: Throwable -> L16
            Intent intent = new Intent("android.content.action.REQUEST_LOCAL_APPROVAL");     // Catch: Throwable -> L16
            intent.setPackage(providerPackageName);     // Catch: Throwable -> L16
            ResolveInfo ri = AppGlobals.getPackageManager().resolveIntent(intent, null, 0, userHandle);     // Catch: Throwable -> L16
            if (ri != null) goto L10;
        L18:
            Binder.restoreCallingIdentity(ident);
            return null;
        L10:
            if (ri.activityInfo == null) goto L18;
            if (ri.activityInfo.exported == false) goto L18;
            intent.setComponent(new ComponentName(ri.activityInfo.packageName, ri.activityInfo.name));     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(ident);
            return intent;
        L20:
            throw new IllegalStateException("Cannot request permission without a restrictions provider registered");     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L23:
            return null;
        }

        public void notifyPermissionResponse(String packageName, PersistableBundle response) throws RemoteException {
            int callingUid = Binder.getCallingUid();
            int userHandle = UserHandle.getUserId(callingUid);
            if (this.mDpm == null) goto L15;
            long ident = Binder.clearCallingIdentity();
            ComponentName permProvider = this.mDpm.getRestrictionsProvider(userHandle);     // Catch: Throwable -> L9
            if (permProvider == null) goto L12;
            enforceCallerMatchesPackage(callingUid, permProvider.getPackageName(), "Restrictions provider does not match caller ");     // Catch: Throwable -> L9
            Intent responseIntent = new Intent("android.content.action.PERMISSION_RESPONSE_RECEIVED");     // Catch: Throwable -> L9
            responseIntent.setPackage(packageName);     // Catch: Throwable -> L9
            responseIntent.putExtra("android.content.extra.RESPONSE_BUNDLE", response);     // Catch: Throwable -> L9
            this.mContext.sendBroadcastAsUser(responseIntent, new UserHandle(userHandle));     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L12:
            throw new SecurityException("No restrictions provider registered for user");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        private void enforceCallerMatchesPackage(int callingUid, String packageName, String message) {
            String[] pkgs = AppGlobals.getPackageManager().getPackagesForUid(callingUid);     // Catch: RemoteException -> L9
            if (pkgs != null) goto L5;
            return;
        L5:
            if (ArrayUtils.contains(pkgs, packageName) == false) goto L8;
            return;
        L8:
            throw new SecurityException(message + callingUid);     // Catch: RemoteException -> L9
        }
    }

    static /* synthetic */ IBinder access$000(RestrictionsManagerService x0, String x1) {
        return x0.getBinderService(x1);
    }

    static /* synthetic */ IBinder access$100(RestrictionsManagerService x0, String x1) {
        return x0.getBinderService(x1);
    }

    static /* synthetic */ Object access$200(RestrictionsManagerService x0, Class x1) {
        return x0.getLocalService(x1);
    }

    public RestrictionsManagerService(Context context) {
        super(context);
        this.mRestrictionsManagerImpl = new RestrictionsManagerImpl(this, context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("restrictions", this.mRestrictionsManagerImpl);
    }
}
