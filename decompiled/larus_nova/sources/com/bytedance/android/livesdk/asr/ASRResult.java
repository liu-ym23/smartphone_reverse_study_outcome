package com.bytedance.android.livesdk.asr;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/asr/ASRResult;", "Ljava/io/Serializable;", "()V", "code", "", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "message", "getMessage", "setMessage", "reqId", "getReqId", "setReqId", "result", "", "Lcom/bytedance/android/livesdk/asr/ASRResult$Result;", "getResult", "()Ljava/util/List;", "setResult", "(Ljava/util/List;)V", "Result", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ASRResult implements Serializable {

    @SerializedName("code")
    private String code;

    @SerializedName("err_code")
    private int errorCode;

    @SerializedName("message")
    private String message;

    @SerializedName("reqid")
    private String reqId;

    @SerializedName("result")
    private List<Result> result;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/asr/ASRResult$Result;", "Ljava/io/Serializable;", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Result implements Serializable {

        @SerializedName("text")
        private String text;

        public Result() {
            this.text = "";
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.text = r100;
        }
    }

    public ASRResult() {
        this.message = "";
        this.code = "";
        this.reqId = "";
    }

    public final String getCode() {
        return this.code;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final List<Result> getResult() {
        return this.result;
    }

    public final void setCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.code = r100;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }

    public final void setReqId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reqId = r100;
    }

    public final void setResult(List<Result> r100) {
        this.result = r100;
    }
}
