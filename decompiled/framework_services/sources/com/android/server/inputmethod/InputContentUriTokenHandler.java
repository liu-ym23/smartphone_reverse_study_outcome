package com.android.server.inputmethod;

import android.app.UriGrantsManager;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.inputmethod.IInputContentUriToken;
import com.android.server.LocalServices;
import com.android.server.uri.UriGrantsManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
final class InputContentUriTokenHandler extends IInputContentUriToken.Stub {
    private final Object mLock;
    private IBinder mPermissionOwnerToken;
    private final int mSourceUid;
    private final int mSourceUserId;
    private final String mTargetPackage;
    private final int mTargetUserId;
    private final Uri mUri;

    InputContentUriTokenHandler(Uri contentUri, int sourceUid, String targetPackage, int sourceUserId, int targetUserId) {
        this.mLock = new Object();
        this.mPermissionOwnerToken = null;
        this.mUri = contentUri;
        this.mSourceUid = sourceUid;
        this.mTargetPackage = targetPackage;
        this.mSourceUserId = sourceUserId;
        this.mTargetUserId = targetUserId;
    }

    public void take() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPermissionOwnerToken == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPermissionOwnerToken = ((UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class)).newUriPermissionOwner("InputContentUriTokenHandler");     // Catch: Throwable -> L8
        doTakeLocked(this.mPermissionOwnerToken);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void doTakeLocked(IBinder permissionOwner) {
        long origId = Binder.clearCallingIdentity();
    L23:
        UriGrantsManager.getService().grantUriPermissionFromOwner(permissionOwner, this.mSourceUid, this.mTargetPackage, this.mUri, 1, this.mSourceUserId, this.mTargetUserId);     // Catch: Throwable -> L7 RemoteException -> L9
    L17:
        Binder.restoreCallingIdentity(origId);
        return;
    L9:
        e = move-exception;
        RemoteException e = e;
    L16:
        e.rethrowFromSystemServer();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        Throwable r12 = th;
    L19:
        Binder.restoreCallingIdentity(origId);
        throw r12;
    L13:
        e = move-exception;
        e = e;
    L11:
        th = move-exception;
        r12 = th;
        goto L19
    }

    public void release() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPermissionOwnerToken != null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L20:
        ((UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class)).revokeUriPermissionFromOwner(this.mPermissionOwnerToken, this.mUri, 1, this.mSourceUserId);     // Catch: Throwable -> L15
        this.mPermissionOwnerToken = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        th = move-exception;
        this.mPermissionOwnerToken = null;     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    }

    protected void finalize() throws Throwable {
        release();     // Catch: Throwable -> L5
        super/*java.lang.Object*/.finalize();
        return;
    L5:
        th = move-exception;
        super/*java.lang.Object*/.finalize();
        throw th;
    }
}
