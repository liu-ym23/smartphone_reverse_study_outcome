package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorDurationScaleProvider {
    private static float defaultSystemAnimatorDurationScale = 1.0f;

    static {
    }

    public AnimatorDurationScaleProvider() {
    }

    @VisibleForTesting
    public static void setDefaultSystemAnimatorDurationScale(float r10) {
        defaultSystemAnimatorDurationScale = r10;
    }

    public float getSystemAnimatorDurationScale(@NonNull ContentResolver r10) {
        return Settings.Global.getFloat(r10, "animator_duration_scale", 1.0f);
    }
}
