package com.bytedance.android.live.base;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/g;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "isHorizontal", "disableEnter", "getDisableEnter", "", "leftPadding", "I", "getLeftPadding", "()I", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("enable_pre_only_click_guide")
    private final boolean disableEnter;

    @SerializedName("enable_pre_lite_interaction")
    private final boolean enable;

    @SerializedName("enable_pre_horizontal_container")
    private final boolean isHorizontal;

    @SerializedName("interact_left_padding")
    private final int leftPadding;

    public g() {
    }

    public final boolean a() {
        return this.enable;
    }
}
