package com.stepos.core.cta;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDownloadPreferences {
    public static final ModelDownloadPreferences INSTANCE = new ModelDownloadPreferences();
    private static final String KEY_AUTO_UPDATE_ON_WIFI = "auto_update_on_wifi";
    private static final String KEY_CELLULAR_CONFIRMED_PREFIX = "cellular_confirmed_";
    private static final String MMKV_ID = "aiengine_model_download";
    private static volatile MMKV mmkv;

    private ModelDownloadPreferences() {
    }

    public final void init(Context context) {
        g.f(context, "context");
        MMKV.m(context);
        mmkv = MMKV.o(MMKV_ID);
    }

    public final boolean isAutoUpdateOnWifi() {
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.d(KEY_AUTO_UPDATE_ON_WIFI, true);
        }
        return true;
    }

    public final boolean isCellularConfirmed(String algorithmId) {
        g.f(algorithmId, "algorithmId");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            return mmkv2.d(KEY_CELLULAR_CONFIRMED_PREFIX.concat(algorithmId), false);
        }
        return false;
    }

    public final void setAutoUpdateOnWifi(boolean z) {
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.k(KEY_AUTO_UPDATE_ON_WIFI, z);
        }
    }

    public final void setCellularConfirmed(String algorithmId, boolean z) {
        g.f(algorithmId, "algorithmId");
        MMKV mmkv2 = mmkv;
        if (mmkv2 != null) {
            mmkv2.k(KEY_CELLULAR_CONFIRMED_PREFIX.concat(algorithmId), z);
        }
    }
}
