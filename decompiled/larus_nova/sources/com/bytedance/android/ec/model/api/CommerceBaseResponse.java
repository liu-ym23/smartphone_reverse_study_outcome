package com.bytedance.android.ec.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "getStatusMsg", "setStatusMsg", "", "ttNetExtraInfo", "Ljava/lang/Object;", "getTtNetExtraInfo", "()Ljava/lang/Object;", "setTtNetExtraInfo", "(Ljava/lang/Object;)V", "", "ecNetRequestEnd", "Ljava/lang/Long;", "getEcNetRequestEnd", "()Ljava/lang/Long;", "setEcNetRequestEnd", "(Ljava/lang/Long;)V", "base", "getBase", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public class CommerceBaseResponse implements Serializable {
    public static final int CODE_SUCCESS = 0;
    public static final a Companion = null;

    @SerializedName("base")
    private final Object base;
    private Long ecNetRequestEnd;

    @SerializedName("message")
    private String message;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMsg;
    private Object ttNetExtraInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommerceBaseResponse() {
        this.message = "";
        this.statusMsg = "";
    }

    public final Object getBase() {
        return this.base;
    }

    public final Long getEcNetRequestEnd() {
        return this.ecNetRequestEnd;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final Object getTtNetExtraInfo() {
        return this.ttNetExtraInfo;
    }

    public final void setEcNetRequestEnd(Long r100) {
        this.ecNetRequestEnd = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }

    public final void setTtNetExtraInfo(Object r100) {
        this.ttNetExtraInfo = r100;
    }
}
