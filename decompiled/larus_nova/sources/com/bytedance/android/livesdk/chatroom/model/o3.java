package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLiteWrapper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/o3;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "isV2", "setV2", "", "triggerGCValue", "I", "getTriggerGCValue", "()I", "setTriggerGCValue", "(I)V", "diffGCValue", "getDiffGCValue", "setDiffGCValue", "expandHeapValue", "getExpandHeapValue", "setExpandHeapValue", "resetTriggerValue", "getResetTriggerValue", "setResetTriggerValue", "", "minFreeRatio", FaceService.girlLabel, "getMinFreeRatio", "()F", "setMinFreeRatio", "(F)V", "maxFreeRatio", "getMaxFreeRatio", "setMaxFreeRatio", "foregroundMulRatio", "getForegroundMulRatio", "setForegroundMulRatio", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o3 {

    @SerializedName("diff_value")
    private int diffGCValue;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(StrategySQLiteWrapper.TABLE_EXPAND)
    private int expandHeapValue;

    @SerializedName("foreground_mul_ratio")
    private float foregroundMulRatio;

    @SerializedName("is_v2")
    private boolean isV2;

    @SerializedName("max_free_ratio")
    private float maxFreeRatio;

    @SerializedName("min_free_ratio")
    private float minFreeRatio;

    @SerializedName("reset_value")
    private int resetTriggerValue;

    @SerializedName("trigger_value")
    private int triggerGCValue;

    public o3() {
        this.isV2 = true;
        this.resetTriggerValue = 100;
        this.minFreeRatio = 1.0f;
        this.maxFreeRatio = 1.0f;
        this.foregroundMulRatio = 1.0f;
    }

    public final boolean a() {
        return this.enable;
    }
}
