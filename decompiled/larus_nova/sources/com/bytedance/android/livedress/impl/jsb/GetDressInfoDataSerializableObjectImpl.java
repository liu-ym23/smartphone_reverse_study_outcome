package com.bytedance.android.livedress.impl.jsb;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import jd1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoDataSerializableObjectImpl;", "Ljd1/a;", "Lcom/google/gson/JsonObject;", "dressInfo", "Lcom/google/gson/JsonObject;", "getDressInfo", "()Lcom/google/gson/JsonObject;", "h3", "(Lcom/google/gson/JsonObject;)V", "", "dressInfoString", "Ljava/lang/String;", "getDressInfoString", "()Ljava/lang/String;", "e6", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetDressInfoDataSerializableObjectImpl implements a {

    @SerializedName("dressInfo")
    private JsonObject dressInfo;

    @SerializedName("dressInfoString")
    private String dressInfoString;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoDataSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GetDressInfoDataSerializableObjectImpl.class);
        }
    }

    public GetDressInfoDataSerializableObjectImpl() {
        this.dressInfo = (JsonObject) d.c(JsonObject.class);
        this.dressInfoString = "";
    }

    @Override // jd1.a
    public final void e6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dressInfoString = r100;
    }

    @Override // jd1.a
    public final void h3(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dressInfo = r100;
    }
}
