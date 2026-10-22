package com.bytedance.android.annie.bridge.method.abs;

import com.amap.api.col.s.ce;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR$\u0010+\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016¨\u00061"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/RequestResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/abs/RequestResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/abs/RequestResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/abs/RequestResultModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/method/abs/RequestResultModel$Code;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "", "clientCode", "Ljava/lang/Number;", "getClientCode", "()Ljava/lang/Number;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Number;)V", "httpCode", "getHttpCode", "d", "Lcom/google/gson/JsonObject;", "header", "Lcom/google/gson/JsonObject;", "getHeader", "()Lcom/google/gson/JsonObject;", "c", "(Lcom/google/gson/JsonObject;)V", "", "response", "Ljava/lang/Object;", "getResponse", "()Ljava/lang/Object;", "f", "(Ljava/lang/Object;)V", "responseType", "getResponseType", ce.f26391f, "cacheCode", "getCacheCode", "setCacheCode", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class RequestResultModel implements k0 {

    @SerializedName("cacheCode")
    private Number cacheCode;

    @SerializedName("clientCode")
    private Number clientCode;

    @SerializedName("code")
    private Code code;

    @SerializedName("header")
    private JsonObject header;

    @SerializedName("httpCode")
    private Number httpCode;

    @SerializedName("msg")
    private String msg;

    @SerializedName("response")
    private Object response;

    @SerializedName("responseType")
    private String responseType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/RequestResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "InvalidParam", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code InvalidParam = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f38536a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f38536a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("InvalidParam", 2, -3);
            InvalidParam = r102;
            f38536a = new Code[]{r100, r101, r102};
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public RequestResultModel() {
    }

    public final void a(Number r100) {
        this.clientCode = r100;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(JsonObject r100) {
        this.header = r100;
    }

    public final void d(Number r100) {
        this.httpCode = r100;
    }

    public final void e(String r100) {
        this.msg = r100;
    }

    public final void f(Object r100) {
        this.response = r100;
    }

    public final void g(String r100) {
        this.responseType = r100;
    }
}
