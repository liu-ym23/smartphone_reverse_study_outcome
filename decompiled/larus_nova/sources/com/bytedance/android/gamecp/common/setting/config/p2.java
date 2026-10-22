package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/p2;", "", "", "enableEffectEnhance", "I", "b", "()I", "setEnableEffectEnhance", "(I)V", "effectInterval", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEffectInterval", "iconEnableEffectEnhance", "c", "setIconEnableEffectEnhance", "iconEffectInterval", "getIconEffectInterval", "setIconEffectInterval", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p2 {

    @SerializedName("effect_interval")
    private int effectInterval;

    @SerializedName("enable_effect_enhance")
    private int enableEffectEnhance;

    @SerializedName("icon_effect_interval")
    private int iconEffectInterval;

    @SerializedName("icon_enable_effect_enhance")
    private int iconEnableEffectEnhance;

    public p2() {
    }

    public final int a() {
        return this.effectInterval;
    }

    public final int b() {
        return this.enableEffectEnhance;
    }

    public final int c() {
        return this.iconEnableEffectEnhance;
    }
}
