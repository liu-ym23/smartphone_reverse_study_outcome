package com.android.server.uri;

import android.content.Intent;
import android.mifavor.MFVUtils;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswUriGrantsManagerService {
    public static final String TAG = "IZswUriGrantsManagerService";

    boolean allowSystemGrantUriPermission(int r1, Intent r2);

    boolean isExemptedByZTE(String r1, String r2, boolean r3);

    boolean isPassWithoutPermission(int r1, String r2);

    static int checkGrantUriPermissionFromIntentUnlocked_DoubleApp(int callingUid, String targetPkg, int contentUserHint, SparseArray<ArrayMap<GrantUri, UriPermission>> grantedUriPermissions) {
        int callingUserId = UserHandle.getUserId(callingUid);
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L17;
        if (callingUserId != 0) goto L6;
    L7:
        ArrayMap<GrantUri, UriPermission> perms = grantedUriPermissions.get(callingUid);
        Slog.d(TAG, "checkGrantUriPermissionFromIntentUnlocked: perms: " + perms);
        if (perms != null) goto L10;
        Slog.w(TAG, "No permission grants found for " + targetPkg);
        goto L17
    L10:
        int j = 0;
    L12:
        if (j >= perms.size()) goto L17;
        UriPermission perm = perms.valueAt(j);
        if (targetPkg.equals(perm.targetPkg) == false) goto L16;
        contentUserHint = perm.uri.sourceUserId;
    L16:
        j = j + 1;
        goto L12
    L6:
        if (callingUserId == 999) goto L7;
    L17:
        return contentUserHint;
    }

    static int fallbackUserId_DoubleApp(int targetUserId, String targetPkg) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return targetUserId;
    L5:
        if (targetUserId == 999) goto L7;
        return targetUserId;
    L7:
        if ("com.android.packageinstaller".equals(targetPkg) == false) goto L12;
        return 0;
    L12:
        return targetUserId;
    }

    static boolean checkUriPermissionLocked_DoubleApp(GrantUri grantUri, int uid, SparseArray<ArrayMap<GrantUri, UriPermission>> grantedUriPermissions) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L15;
        int callingUserId = UserHandle.getUserId(uid);
        if (grantUri == null) goto L7;
        int uriSourceUserId = grantUri.sourceUserId;
    L9:
        if (callingUserId != 0) goto L11;
        if (uriSourceUserId != 999) goto L11;
    L13:
        Slog.d(TAG, "checkUriPermissionLocked allow cross access from " + callingUserId + " to " + uriSourceUserId + ",uid:" + uid + ",grantUri:" + grantUri + ",perms:" + grantedUriPermissions.get(uid));
        return true;
    L11:
        if (callingUserId != 999) goto L15;
        if (uriSourceUserId != 0) goto L15;
    L7:
        uriSourceUserId = 0;
    L15:
        return false;
    }
}
