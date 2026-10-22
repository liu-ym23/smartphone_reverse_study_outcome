package com.android.server.wm;

import android.app.UriGrantsManager;
import android.content.ClipData;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.view.IDragAndDropPermissions;
import com.android.server.LocalServices;
import com.android.server.uri.UriGrantsManagerInternal;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class DragAndDropPermissionsHandler extends IDragAndDropPermissions.Stub {
    private static final boolean DEBUG = false;
    private static final String TAG = "DragAndDrop";
    private IBinder mActivityToken;
    private final WindowManagerGlobalLock mGlobalLock;
    private final int mMode;
    private IBinder mPermissionOwnerToken;
    private final int mSourceUid;
    private final int mSourceUserId;
    private final String mTargetPackage;
    private final int mTargetUserId;
    private final ArrayList<Uri> mUris;

    DragAndDropPermissionsHandler(WindowManagerGlobalLock lock, ClipData clipData, int sourceUid, String targetPackage, int mode, int sourceUserId, int targetUserId) {
        this.mUris = new ArrayList();
        this.mActivityToken = null;
        this.mPermissionOwnerToken = null;
        this.mGlobalLock = lock;
        this.mSourceUid = sourceUid;
        this.mTargetPackage = targetPackage;
        this.mMode = mode;
        this.mSourceUserId = sourceUserId;
        this.mTargetUserId = targetUserId;
        clipData.collectUris(this.mUris);
    }

    public void take(IBinder activityToken) throws RemoteException {
        if (this.mActivityToken == null) goto L5;
        return;
    L5:
        if (this.mPermissionOwnerToken != null) goto L10;
        this.mActivityToken = activityToken;
        IBinder permissionOwner = getUriPermissionOwnerForActivity(this.mActivityToken);
        doTake(permissionOwner);
        return;
    }

    private void doTake(IBinder permissionOwner) throws RemoteException {
        long origId = Binder.clearCallingIdentity();
        int i = 0;
    L19:
    L11:
        th = move-exception;
        Throwable r13 = th;
    L15:
        Binder.restoreCallingIdentity(origId);
        throw r13;
    L4:
        if (i >= this.mUris.size()) goto L13;
        IBinder permissionOwner2 = permissionOwner;
        UriGrantsManager.getService().grantUriPermissionFromOwner(permissionOwner2, this.mSourceUid, this.mTargetPackage, this.mUris.get(i), this.mMode, this.mSourceUserId, this.mTargetUserId);     // Catch: Throwable -> L9
        i = i + 1;
        permissionOwner = permissionOwner2;
    L9:
        th = move-exception;
        r13 = th;
        goto L15
    L13:
        Binder.restoreCallingIdentity(origId);
    }

    public void takeTransient() throws RemoteException {
        if (this.mActivityToken == null) goto L5;
        return;
    L5:
        if (this.mPermissionOwnerToken != null) goto L10;
        this.mPermissionOwnerToken = ((UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class)).newUriPermissionOwner("drop");
        doTake(this.mPermissionOwnerToken);
        return;
    }

    public void release() throws RemoteException {
        if (this.mActivityToken != null) goto L8;
        if (this.mPermissionOwnerToken != null) goto L8;
        return;
    L8:
        if (this.mActivityToken != null) goto L26;
        IBinder permissionOwner = this.mPermissionOwnerToken;
        this.mPermissionOwnerToken = null;
    L20:
        UriGrantsManagerInternal ugm = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        int i = 0;
    L22:
        if (i >= this.mUris.size()) goto L25;
        ugm.revokeUriPermissionFromOwner(permissionOwner, this.mUris.get(i), this.mMode, this.mSourceUserId);
        i = i + 1;
        goto L22
    L25:
        return;
    L26:
        permissionOwner = getUriPermissionOwnerForActivity(this.mActivityToken);     // Catch: Throwable -> L11 Exception -> L13
        this.mActivityToken = null;
        goto L20
    L11:
        th = move-exception;
        this.mActivityToken = null;
        throw th;
    L17:
        this.mActivityToken = null;
    }

    private IBinder getUriPermissionOwnerForActivity(IBinder activityToken) {
        ActivityTaskManagerService.enforceNotIsolatedCaller("getUriPermissionOwnerForActivity");
        WindowManagerGlobalLock r0 = this.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ActivityRecord r = ActivityRecord.isInRootTaskLocked(activityToken);     // Catch: Throwable -> L10
        if (r == null) goto L13;
        Binder r2 = r.getUriPermissionsLocked().getExternalToken();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L13:
        throw new IllegalArgumentException("Activity does not exist; token=" + activityToken);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    protected void finalize() throws Throwable {
        if (this.mActivityToken == null) goto L5;
        return;
    L5:
        if (this.mPermissionOwnerToken == null) goto L10;
        release();
        return;
    }
}
