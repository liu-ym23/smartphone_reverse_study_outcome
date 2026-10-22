package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1.0f;

    static {
    }

    public AnimatorDurationScaleProvider() {
    }

    public float getSystemAnimatorDurationScale(ContentResolver r2) {
        return Settings.Global.getFloat(r2, "animator_duration_scale", 1.0f);
    }

    public static void setDefaultSystemAnimatorDurationScale(float r0) {
        defaultSystemAnimatorDurationScale = r0;
    }
}
