package com.android.server.oemlock;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pdb.PersistentDataBlockManagerInternal;
import com.android.server.pm.UserManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
public class OemLockService extends SystemService {
    private static final String FLASH_LOCK_PROP = "ro.boot.flash.locked";
    private static final String FLASH_LOCK_UNLOCKED = "0";
    private static final String TAG = "OemLock";
    private Context mContext;
    private OemLock mOemLock;
    private final IBinder mService;
    private final UserManagerInternal.UserRestrictionsListener mUserRestrictionsListener;

    /* JADX INFO: renamed from: -$$Nest$fgetmOemLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ OemLock m6326$$Nest$fgetmOemLock(OemLockService r0) {
        return r0.mOemLock;
    }

    /* JADX INFO: renamed from: -$$Nest$menforceUserIsAdmin, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6327$$Nest$menforceUserIsAdmin(OemLockService r0) {
        r0.enforceUserIsAdmin();
    }

    /* JADX INFO: renamed from: -$$Nest$misOemUnlockAllowedByAdmin, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6328$$Nest$misOemUnlockAllowedByAdmin(OemLockService r0) {
        return r0.isOemUnlockAllowedByAdmin();
    }

    /* JADX INFO: renamed from: -$$Nest$msetPersistentDataBlockOemUnlockAllowedBit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6329$$Nest$msetPersistentDataBlockOemUnlockAllowedBit(OemLockService r0, boolean r1) {
        r0.setPersistentDataBlockOemUnlockAllowedBit(r1);
    }

    public static boolean isHalPresent() {
        if (VendorLockHidl.getOemLockHalService() == null) goto L5;
    L8:
        return true;
    L5:
        if (VendorLockAidl.getOemLockHalService() != null) goto L8;
        return false;
    }

    private static OemLock getOemLock(Context context) {
        if (VendorLockAidl.getOemLockHalService() == null) goto L7;
        Slog.i(TAG, "Using vendor lock via the HAL(aidl)");
        return new VendorLockAidl(context);
    L7:
        if (VendorLockHidl.getOemLockHalService() == null) goto L10;
        Slog.i(TAG, "Using vendor lock via the HAL(hidl)");
        return new VendorLockHidl(context);
    L10:
        Slog.i(TAG, "Using persistent data block based lock");
        return new PersistentDataBlockLock(context);
    }

    public OemLockService(Context context) {
        this(context, getOemLock(context));
    }

    OemLockService(Context context, OemLock oemLock) {
        super(context);
        this.mUserRestrictionsListener = new AnonymousClass1(this);
        this.mService = new AnonymousClass2(this);
        this.mContext = context;
        this.mOemLock = oemLock;
        ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).addUserRestrictionsListener(this.mUserRestrictionsListener);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("oem_lock", this.mService);
    }

    private void setPersistentDataBlockOemUnlockAllowedBit(boolean allowed) {
        PersistentDataBlockManagerInternal pdbmi = (PersistentDataBlockManagerInternal) LocalServices.getService(PersistentDataBlockManagerInternal.class);
        if (pdbmi != null) goto L5;
        return;
    L5:
        if ((this.mOemLock instanceof PersistentDataBlockLock) == true) goto L9;
        Slog.i(TAG, "Update OEM Unlock bit in pst partition to " + allowed);
        pdbmi.forceOemUnlockEnabled(allowed);
        return;
    }

    private boolean isOemUnlockAllowedByAdmin() {
        return !UserManager.get(this.mContext).hasUserRestriction("no_factory_reset", UserHandle.SYSTEM);
    }

    private void enforceUserIsAdmin() {
        int userId = UserHandle.getCallingUserId();
        long token = Binder.clearCallingIdentity();
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        if (UserManager.get(this.mContext).isUserAdmin(userId) == false) goto L8;
        Binder.restoreCallingIdentity(token);
        return;
    L8:
        throw new SecurityException("Must be an admin user");     // Catch: Throwable -> L9
    }
}
