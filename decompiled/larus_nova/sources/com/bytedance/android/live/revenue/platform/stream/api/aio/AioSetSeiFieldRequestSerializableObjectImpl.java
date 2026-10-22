package com.bytedance.android.live.revenue.platform.stream.api.aio;

import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import e01.g;
import e01.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/stream/api/aio/AioSetSeiFieldRequestSerializableObjectImpl;", "Le01/j;", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "value", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "getValue", "()Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "setValue", "(Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;)V", "Le01/g;", "attributes", "Le01/g;", "getAttributes", "()Le01/g;", "setAttributes", "(Le01/g;)V", "<init>", "()V", "Adapter", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AioSetSeiFieldRequestSerializableObjectImpl implements j {

    @SerializedName("attributes")
    private g attributes;

    @SerializedName("key")
    private String key;

    @SerializedName("value")
    private JsonOrBytesJvm value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/stream/api/aio/AioSetSeiFieldRequestSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AioSetSeiFieldRequestSerializableObjectImpl.class);
        }
    }

    public AioSetSeiFieldRequestSerializableObjectImpl() {
    }

    @Override // e01.j
    public final g getAttributes() {
        return this.attributes;
    }

    @Override // e01.j
    public final String getKey() {
        return this.key;
    }

    @Override // e01.j
    public final JsonOrBytesJvm getValue() {
        return this.value;
    }
}
