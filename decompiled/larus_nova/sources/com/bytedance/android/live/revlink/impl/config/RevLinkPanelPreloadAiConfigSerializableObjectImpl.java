package com.bytedance.android.live.revlink.impl.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.t;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/RevLinkPanelPreloadAiConfigSerializableObjectImpl;", "Lr11/t;", "", "enable", "Z", "getEnable", "()Z", "", "predictInterval", "J", "x1", "()J", "consumeResult", "K3", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevLinkPanelPreloadAiConfigSerializableObjectImpl implements t {

    @SerializedName("pitaya_enable")
    private final boolean consumeResult;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("prediction_interval")
    private final long predictInterval;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/RevLinkPanelPreloadAiConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevLinkPanelPreloadAiConfigSerializableObjectImpl.class);
        }
    }

    public RevLinkPanelPreloadAiConfigSerializableObjectImpl() {
        this.enable = false;
        this.predictInterval = 120;
        this.consumeResult = false;
    }

    @Override // r11.t
    public final boolean K3() {
        return this.consumeResult;
    }

    @Override // r11.t
    public final boolean getEnable() {
        return this.enable;
    }

    @Override // r11.t
    public final long x1() {
        return this.predictInterval;
    }
}
