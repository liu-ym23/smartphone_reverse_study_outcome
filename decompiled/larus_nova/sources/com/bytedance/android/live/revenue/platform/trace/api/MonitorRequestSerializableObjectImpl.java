package com.bytedance.android.live.revenue.platform.trace.api;

import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import j01.a;
import j01.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/trace/api/MonitorRequestSerializableObjectImpl;", "Lj01/c;", "Lj01/a$a;", "meta", "Lj01/a$a;", "getMeta", "()Lj01/a$a;", "i4", "(Lj01/a$a;)V", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "category", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "getCategory", "()Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "f1", "(Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;)V", "metric", "y6", "D3", "extra", "getExtra", "W0", "<init>", "()V", "Adapter", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MonitorRequestSerializableObjectImpl implements c {

    @SerializedName("category")
    private JsonOrBytesJvm category;

    @SerializedName("extra")
    private JsonOrBytesJvm extra;

    @SerializedName("meta")
    private a.InterfaceC6375a meta;

    @SerializedName("metric")
    private JsonOrBytesJvm metric;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/trace/api/MonitorRequestSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(MonitorRequestSerializableObjectImpl.class);
        }
    }

    public MonitorRequestSerializableObjectImpl() {
    }

    @Override // j01.c
    public final JsonOrBytesJvm getCategory() {
        return this.category;
    }

    @Override // j01.c
    public final JsonOrBytesJvm getExtra() {
        return this.extra;
    }

    @Override // j01.c
    public final a.InterfaceC6375a getMeta() {
        return this.meta;
    }

    @Override // j01.c
    public final JsonOrBytesJvm y6() {
        return this.metric;
    }

    @Override // j01.c
    public final void D3(JsonOrBytesJvm r100) {
        this.metric = r100;
    }

    @Override // j01.c
    public final void W0(JsonOrBytesJvm r100) {
        this.extra = r100;
    }

    @Override // j01.c
    public final void f1(JsonOrBytesJvm r100) {
        this.category = r100;
    }

    @Override // j01.c
    public final void i4(a.InterfaceC6375a r100) {
        this.meta = r100;
    }
}
