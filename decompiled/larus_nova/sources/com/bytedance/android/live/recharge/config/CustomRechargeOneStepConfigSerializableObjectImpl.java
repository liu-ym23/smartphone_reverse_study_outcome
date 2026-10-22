package com.bytedance.android.live.recharge.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/recharge/config/CustomRechargeOneStepConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/recharge/config/CustomRechargeOneStepConfig;", "", "enableLastUseRec", "Z", "m6", "()Z", "Z5", "(Z)V", "enableInputMode", "M5", "w8", "", "lastRechargeLimit", "J", "v7", "()J", "n1", "(J)V", "isLimitMinPrice", "I2", "X4", "<init>", "()V", "Adapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRechargeOneStepConfigSerializableObjectImpl implements CustomRechargeOneStepConfig {

    @SerializedName("enable_input_mode")
    private boolean enableInputMode;

    @SerializedName("enable_rec_last_use")
    private boolean enableLastUseRec;

    @SerializedName("is_limit_min_price")
    private boolean isLimitMinPrice;

    @SerializedName("last_recharge_price_limit")
    private long lastRechargeLimit;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/config/CustomRechargeOneStepConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(CustomRechargeOneStepConfigSerializableObjectImpl.class);
        }
    }

    public CustomRechargeOneStepConfigSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final void X4() {
        this.isLimitMinPrice = false;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final void Z5() {
        this.enableLastUseRec = false;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final void w8() {
        this.enableInputMode = false;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final void n1() {
        this.lastRechargeLimit = 5000000;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final boolean I2() {
        return this.isLimitMinPrice;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final boolean M5() {
        return this.enableInputMode;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final boolean m6() {
        return this.enableLastUseRec;
    }

    @Override // com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig
    public final long v7() {
        return this.lastRechargeLimit;
    }
}
