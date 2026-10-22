package com.mdisdk.capability.utils;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.dsl.a;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.model.IntentEntity;

/* loaded from: classes3.dex */
public class IntentUtils {
    private static final String TAG = "IntentUtils";

    private IntentUtils() {
    }

    @Nullable
    public static IntentEntity getActivityIntentByPackage(String str, int i) {
        try {
            Intent activityIntentByPackage = FrameworkBridgeFactory.get().getActivityIntentByPackage(str, i);
            if (activityIntentByPackage == null) {
                Log.w(TAG, "getActivityIntentByPackage returned null for packageName=" + str + ", displayId=" + i);
                return null;
            }
            IntentEntity intentEntityFromIntent = IntentEntity.fromIntent(activityIntentByPackage);
            Log.d(TAG, "getActivityIntentByPackage success, packageName=" + str + ", displayId=" + i + ", entity=" + intentEntityFromIntent);
            return intentEntityFromIntent;
        } catch (Exception e) {
            a.t(e, new StringBuilder("getActivityIntentByPackage failed: "), TAG);
            return null;
        }
    }

    @Nullable
    public static IntentEntity getTopActivityIntent(int i) {
        try {
            Intent topActivityIntent = FrameworkBridgeFactory.get().getTopActivityIntent(i);
            if (topActivityIntent == null) {
                Log.w(TAG, "getTopActivityIntent returned null for displayId=" + i);
                return null;
            }
            IntentEntity intentEntityFromIntent = IntentEntity.fromIntent(topActivityIntent);
            Log.d(TAG, "getTopActivityIntent success, displayId=" + i + ", entity=" + intentEntityFromIntent);
            return intentEntityFromIntent;
        } catch (Exception e) {
            a.t(e, new StringBuilder("getTopActivityIntent failed: "), TAG);
            return null;
        }
    }
}
