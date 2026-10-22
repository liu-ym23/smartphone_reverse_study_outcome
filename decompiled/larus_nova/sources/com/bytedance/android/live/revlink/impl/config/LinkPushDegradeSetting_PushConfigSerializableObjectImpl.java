package com.bytedance.android.live.revlink.impl.config;

import com.amap.api.col.s.ce;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r11.h;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPushDegradeSetting_PushConfigSerializableObjectImpl;", "Lr11/h$b;", "", "w", "I", "getW", "()I", "h", "getH", "bitrateKbps", ce.f26395j, "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPushDegradeSetting_PushConfigSerializableObjectImpl implements h.b {

    @SerializedName("bitrate_kbps")
    private final int bitrateKbps;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SerializedName("h")
    private final int f92207h;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @SerializedName("w")
    private final int f92208w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/config/LinkPushDegradeSetting_PushConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkPushDegradeSetting_PushConfigSerializableObjectImpl.class);
        }
    }

    public LinkPushDegradeSetting_PushConfigSerializableObjectImpl() {
        this.f92208w = 0;
        this.f92207h = 0;
        this.bitrateKbps = 0;
    }

    @Override // r11.h.b
    public final int getH() {
        return this.f92207h;
    }

    @Override // r11.h.b
    public final int getW() {
        return this.f92208w;
    }

    @Override // r11.h.b
    public final int j() {
        return this.bitrateKbps;
    }
}
