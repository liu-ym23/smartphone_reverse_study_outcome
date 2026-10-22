package com.android.server.security;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInstalld;
import android.os.ParcelFileDescriptor;
import android.os.PermissionEnforcer;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.storage.StorageManagerInternal;
import android.security.IFileIntegrityService;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileIntegrityService extends SystemService {
    private static final String TAG = "FileIntegrityService";
    private final IBinder mService;

    private final class BinderService extends IFileIntegrityService.Stub {
        final /* synthetic */ FileIntegrityService this$0;

        BinderService(FileIntegrityService r1, Context context) {
            this.this$0 = r1;
            super(PermissionEnforcer.fromContext(context));
        }

        private void checkCallerPackageName(String packageName) {
            int callingUid = Binder.getCallingUid();
            int callingUserId = UserHandle.getUserId(callingUid);
            PackageManagerInternal packageManager = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            int packageUid = packageManager.getPackageUid(packageName, 0, callingUserId);
            if (callingUid != packageUid) goto L6;
            return;
        L6:
            throw new SecurityException("Calling uid " + callingUid + " does not own package " + packageName);
        }

        private void checkCallerPermission(String packageName) {
            checkCallerPackageName(packageName);
            if (this.this$0.getContext().checkCallingPermission("android.permission.INSTALL_PACKAGES") != 0) goto L5;
            return;
        L5:
            AppOpsManager appOpsManager = (AppOpsManager) this.this$0.getContext().getSystemService(AppOpsManager.class);
            int mode = appOpsManager.checkOpNoThrow(66, Binder.getCallingUid(), packageName);
            if (mode != 0) goto L9;
            return;
        L9:
            throw new SecurityException("Caller should have INSTALL_PACKAGES or REQUEST_INSTALL_PACKAGES");
        }

        public IInstalld.IFsveritySetupAuthToken createAuthToken(ParcelFileDescriptor authFd) throws RemoteException {
            authFd.getClass();
            IInstalld.IFsveritySetupAuthToken authToken = FileIntegrityService.m8025$$Nest$mgetStorageManagerInternal(this.this$0).createFsveritySetupAuthToken(authFd, Binder.getCallingUid());     // Catch: IOException -> L5
            authFd.close();     // Catch: IOException -> L5
            return authToken;
        L5:
            e = move-exception;
            throw new RemoteException(e);
        }

        public int setupFsverity(IInstalld.IFsveritySetupAuthToken authToken, String filePath, String packageName) throws RemoteException {
            setupFsverity_enforcePermission();
            authToken.getClass();
            filePath.getClass();
            packageName.getClass();
            checkCallerPackageName(packageName);
            return FileIntegrityService.m8025$$Nest$mgetStorageManagerInternal(this.this$0).enableFsverity(authToken, filePath, packageName);
        L5:
            e = move-exception;
            throw new RemoteException(e);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mgetStorageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ StorageManagerInternal m8025$$Nest$mgetStorageManagerInternal(FileIntegrityService r0) {
        return r0.getStorageManagerInternal();
    }

    public static FileIntegrityService getService() {
        return (FileIntegrityService) LocalServices.getService(FileIntegrityService.class);
    }

    public FileIntegrityService(Context context) {
        super(context);
        this.mService = new BinderService(this, context);
        LocalServices.addService(FileIntegrityService.class, this);
    }

    private StorageManagerInternal getStorageManagerInternal() {
        return (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("file_integrity", this.mService);
    }
}
