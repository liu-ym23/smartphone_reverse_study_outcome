package com.android.server.grammaticalinflection;

import android.content.AttributionSource;
import android.permission.PermissionManager;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class GrammaticalInflectionUtils {
    private static final String TAG = "GrammaticalInflectionUtils";

    public GrammaticalInflectionUtils() {
    }

    public static boolean checkSystemGrammaticalGenderPermission(PermissionManager permissionManager, AttributionSource attributionSource) {
        int permissionCheckResult = permissionManager.checkPermissionForDataDelivery("android.permission.READ_SYSTEM_GRAMMATICAL_GENDER", attributionSource, null);
        if (permissionCheckResult == 0) goto L6;
        Log.v(TAG, "AttributionSource: " + attributionSource + " does not have READ_SYSTEM_GRAMMATICAL_GENDER permission.");
        return false;
    L6:
        return true;
    }
}
