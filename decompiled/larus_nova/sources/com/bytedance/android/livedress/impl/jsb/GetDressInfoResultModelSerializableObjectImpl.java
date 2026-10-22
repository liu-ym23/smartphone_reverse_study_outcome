package com.bytedance.android.livedress.impl.jsb;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.google.gson.annotations.SerializedName;
import jd1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoResultModelSerializableObjectImpl;", "Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoResultModel;", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "Ljd1/a;", "data", "Ljd1/a;", "getData", "()Ljd1/a;", "E2", "(Ljd1/a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Adapter", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetDressInfoResultModelSerializableObjectImpl implements GetDressInfoResultModel {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livedress/impl/jsb/GetDressInfoResultModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-dress-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GetDressInfoResultModelSerializableObjectImpl.class);
        }
    }

    public GetDressInfoResultModelSerializableObjectImpl() {
        this.data = (a) d.c(a.class);
        this.msg = "";
    }

    @Override // com.bytedance.android.livedress.impl.jsb.GetDressInfoResultModel
    public final void E2(a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    @Override // com.bytedance.android.livedress.impl.jsb.GetDressInfoResultModel
    public final void setCode(int r100) {
        this.code = r100;
    }

    @Override // com.bytedance.android.livedress.impl.jsb.GetDressInfoResultModel
    public final void setMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msg = r100;
    }
}
