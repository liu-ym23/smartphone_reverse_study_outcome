package com.stepos.agentframework.adapter.coze.bean;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/bean/ErrorResult;", "", "code", "", "message", "status", "", "tempCode", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTempCode", "()I", "setTempCode", "(I)V", "toString", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ErrorResult {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private Integer status;
    private int tempCode;

    public ErrorResult() {
        this(null, null, null, 0, 15, null);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final int getTempCode() {
        return this.tempCode;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setStatus(Integer num) {
        this.status = num;
    }

    public final void setTempCode(int i) {
        this.tempCode = i;
    }

    public String toString() {
        String str = this.code;
        String str2 = this.message;
        Integer num = this.status;
        StringBuilder sbW = a.w("ErrorResult(code=", str, ", message=", str2, ", status=");
        sbW.append(num);
        sbW.append(")");
        return sbW.toString();
    }

    public ErrorResult(String str, String str2, Integer num, int i) {
        this.code = str;
        this.message = str2;
        this.status = num;
        this.tempCode = i;
    }

    public /* synthetic */ ErrorResult(String str, String str2, Integer num, int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? null : str2, (i6 & 4) != 0 ? null : num, (i6 & 8) != 0 ? 0 : i);
    }
}
