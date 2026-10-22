package com.bytedance.android.annie.bridge.method.abs;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0019\u000eB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$Code;", "setCode", "(Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$Code;)V", "Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$a;", "data", "Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$a;", "getData", "()Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class PiaRenderingExecuteResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NOPERMISSION", "NOTREGISTER", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOPERMISSION = null;
        public static final Code NOTREGISTER = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f38525a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f38525a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NOPERMISSION", 2, -1);
            NOPERMISSION = r102;
            Code r103 = new Code("NOTREGISTER", 3, -2);
            NOTREGISTER = r103;
            f38525a = new Code[]{r100, r101, r102, r103};
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PiaRenderingExecuteResultModel$a;", "", "Lcom/google/gson/JsonObject;", "result", "Lcom/google/gson/JsonObject;", "getResult", "()Lcom/google/gson/JsonObject;", "setResult", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("result")
        private JsonObject result;

        public a() {
        }

        public final void setResult(JsonObject r100) {
            this.result = r100;
        }
    }

    public PiaRenderingExecuteResultModel() {
    }

    public final void a(a r100) {
        this.data = r100;
    }
}
