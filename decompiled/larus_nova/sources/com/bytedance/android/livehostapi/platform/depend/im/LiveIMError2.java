package com.bytedance.android.livehostapi.platform.depend.im;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livehostapi/platform/depend/im/LiveIMError2;", "", "()V", "check", "", "getCheck", "()J", "setCheck", "(J)V", "checkMsg", "", "getCheckMsg", "()Ljava/lang/String;", "setCheckMsg", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "setCode", "(I)V", "codeLogger", "getCodeLogger", "setCodeLogger", "status", "getStatus", "setStatus", a.KEY_STATUS_MSG, "getStatusMsg", "setStatusMsg", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIMError2 {
    private long check;
    private String checkMsg;
    private int code;
    private int codeLogger;
    private int status;
    private String statusMsg;

    public LiveIMError2() {
    }

    public String toString() {
        return "LiveIMError2(code=" + this.code + ", status=" + this.status + ", statusMsg=" + this.statusMsg + ", check=" + this.check + ", checkMsg=" + this.checkMsg + ", codeLogger=" + this.codeLogger + ')';
    }

    public final long getCheck() {
        return this.check;
    }

    public final String getCheckMsg() {
        return this.checkMsg;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getCodeLogger() {
        return this.codeLogger;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final void setCheck(long r100) {
        this.check = r100;
    }

    public final void setCheckMsg(String r100) {
        this.checkMsg = r100;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setCodeLogger(int r100) {
        this.codeLogger = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setStatusMsg(String r100) {
        this.statusMsg = r100;
    }
}
