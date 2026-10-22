package com.android.server.wm;

import com.zte.feature.Feature;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswDisplayPolicy {
    public static final boolean ZTE_FEATURE_SHOW_IMMERSIVE_MODE_COMFIRMATION = false;

    void focusChangedLw(WindowState r1);

    void onFling(int r1);

    static {
        ZTE_FEATURE_SHOW_IMMERSIVE_MODE_COMFIRMATION = Feature.getBoolean("ZTE_FEATURE_SHOW_IMMERSIVE_MODE_COMFIRMATION", true);
    }
}
