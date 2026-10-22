package com.bytedance.android.live.revenue.common.settings;

import ay0.d;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revenue/common/settings/RevenueDynamicSwitchesSerializableObjectImpl;", "Lay0/d;", "", "serviceCenter", "Z", "D", "()Z", "", "luckyBoxType", "I", "b0", "()I", "", "delayTimeMillis", "J", "j8", "()J", "<init>", "()V", "Adapter", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevenueDynamicSwitchesSerializableObjectImpl implements d {

    @SerializedName("delay_time_millis")
    private final long delayTimeMillis;

    @SerializedName("lucky_box_type")
    private final int luckyBoxType;

    @SerializedName("service_center")
    private final boolean serviceCenter;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/common/settings/RevenueDynamicSwitchesSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevenueDynamicSwitchesSerializableObjectImpl.class);
        }
    }

    public RevenueDynamicSwitchesSerializableObjectImpl() {
    }

    @Override // ay0.d
    public final boolean D() {
        return this.serviceCenter;
    }

    @Override // ay0.d
    public final int b0() {
        return this.luckyBoxType;
    }

    @Override // ay0.d
    public final long j8() {
        return this.delayTimeMillis;
    }
}
