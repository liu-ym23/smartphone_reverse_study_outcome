package com.android.server.pm;

import android.mifavor.MFVUtils;
import android.util.Log;
import com.zte.feature.Feature;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswNoFilteringResolver {
    public static final String TAG = "NoFilteringResolverComZteHook";

    static boolean isAppCloningBuildingBlocksEnabled_DoubleApp() {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == true) goto L5;
        return true;
    L5:
        if (isCtsTesting() == true) goto L10;
        Log.d(TAG, "999 apps not allow to display in sharesheet for zte doublelay !");
        return false;
    L10:
        return true;
    }

    private static boolean isCtsTesting() {
        return Feature.getCtsRunningStatus();
    }
}
