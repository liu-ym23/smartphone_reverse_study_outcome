package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;

/* JADX INFO: compiled from: AnimatorDurationScaleProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f13505a = 1.0f;

    static {
    }

    public a() {
    }

    public float a(ContentResolver r4) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Settings.Global.getFloat(r4, "animator_duration_scale", 1.0f);
    L7:
        if (Build.VERSION.SDK_INT != 16) goto L11;
        return Settings.System.getFloat(r4, "animator_duration_scale", 1.0f);
    L11:
        return f13505a;
    }
}
