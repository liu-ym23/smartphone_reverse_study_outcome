package com.bytedance.android.live.revenue.platform.time.api;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import g01.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/time/api/GetServerTimestampResponseSerializableObjectImpl;", "Lg01/a;", "", "serverTimestamp", "J", "getServerTimestamp", "()J", "B7", "(J)V", "sendTimestamp", "getSendTimestamp", "D4", "<init>", "()V", "Adapter", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetServerTimestampResponseSerializableObjectImpl implements a {

    @SerializedName("send_time_stamp")
    private long sendTimestamp;

    @SerializedName("server_time_stamp")
    private long serverTimestamp;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/time/api/GetServerTimestampResponseSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GetServerTimestampResponseSerializableObjectImpl.class);
        }
    }

    public GetServerTimestampResponseSerializableObjectImpl() {
    }

    @Override // g01.a
    public final void B7(long r100) {
        this.serverTimestamp = r100;
    }

    @Override // g01.a
    public final void D4(long r100) {
        this.sendTimestamp = r100;
    }
}
