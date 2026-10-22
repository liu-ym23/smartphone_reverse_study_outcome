package com.android.server.autofill;

import android.app.IUriGrantsManager;
import android.app.UriGrantsManager;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.wm.ActivityTaskManagerInternal;

/* JADX INFO: loaded from: classes.dex */
final class AutofillUriGrantsManager {
    private static final String TAG = null;
    private final ActivityTaskManagerInternal mActivityTaskMgrInternal;
    private final int mSourceUid;
    private final int mSourceUserId;
    private final IUriGrantsManager mUgm;

    static {
        TAG = AutofillUriGrantsManager.class.getSimpleName();
    }

    AutofillUriGrantsManager(int serviceUid) {
        this.mSourceUid = serviceUid;
        this.mSourceUserId = UserHandle.getUserId(this.mSourceUid);
        this.mActivityTaskMgrInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mUgm = UriGrantsManager.getService();
    }

    public void grantUriPermissions(ComponentName targetActivity, IBinder targetActivityToken, int targetUserId, ClipData clip) {
        String targetPkg = targetActivity.getPackageName();
        IBinder permissionOwner = this.mActivityTaskMgrInternal.getUriPermissionOwnerForActivity(targetActivityToken);
        if (permissionOwner != null) goto L6;
        Slog.w(TAG, "Can't grant URI permissions, because the target activity token is invalid: clip=" + clip + ", targetActivity=" + targetActivity + ", targetUserId=" + targetUserId + ", targetActivityToken=" + Integer.toHexString(targetActivityToken.hashCode()));
        return;
    L6:
        int i = 0;
    L8:
        if (i >= clip.getItemCount()) goto L17;
        ClipData.Item item = clip.getItemAt(i);
        Uri uri = item.getUri();
        if (uri == null) goto L15;
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L15;
        grantUriPermissions(uri, targetPkg, targetUserId, permissionOwner);
    L15:
        i = i + 1;
        goto L8
    }

    private void grantUriPermissions(Uri uri, String targetPkg, int targetUserId, IBinder permissionOwner) {
        int sourceUserId = ContentProvider.getUserIdFromUri(uri, this.mSourceUserId);
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Granting URI permissions: uri=" + uri + ", sourceUid=" + this.mSourceUid + ", sourceUserId=" + sourceUserId + ", targetPkg=" + targetPkg + ", targetUserId=" + targetUserId + ", permissionOwner=" + Integer.toHexString(permissionOwner.hashCode()));
    L5:
        Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
        long ident = Binder.clearCallingIdentity();
        this.mUgm.grantUriPermissionFromOwner(permissionOwner, this.mSourceUid, targetPkg, uriWithoutUserId, 1, sourceUserId, targetUserId);     // Catch: Throwable -> L8 RemoteException -> L10
    L7:
        Binder.restoreCallingIdentity(ident);
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L10:
        e = move-exception;
        Slog.e(TAG, "Granting URI permissions failed: uri=" + uri + ", sourceUid=" + this.mSourceUid + ", sourceUserId=" + sourceUserId + ", targetPkg=" + targetPkg + ", targetUserId=" + targetUserId + ", permissionOwner=" + Integer.toHexString(permissionOwner.hashCode()), e);     // Catch: Throwable -> L8
        goto L7
    }
}
