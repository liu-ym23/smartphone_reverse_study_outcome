package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/GetTempStateDurationResponseSerializableObjectImpl;", "Lcom/bytedance/android/live/profit/redpacket/model/a;", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "<init>", "()V", "Adapter", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetTempStateDurationResponseSerializableObjectImpl implements a {

    @SerializedName("duration")
    private long duration;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/GetTempStateDurationResponseSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GetTempStateDurationResponseSerializableObjectImpl.class);
        }
    }

    public GetTempStateDurationResponseSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.profit.redpacket.model.a
    public final void setDuration(long r100) {
        this.duration = r100;
    }
}
