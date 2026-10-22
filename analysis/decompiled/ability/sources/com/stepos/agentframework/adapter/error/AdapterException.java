package com.stepos.agentframework.adapter.error;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", "detail", "", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;Ljava/lang/Throwable;)V", "getError", "()Lcom/stepos/agentframework/adapter/error/AdapterErrorCode;", "getDetail", "()Ljava/lang/Throwable;", "code", "", "getCode", "()I", "toString", "", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AdapterException extends Exception {
    private final Throwable detail;
    private final AdapterErrorCode error;

    public /* synthetic */ AdapterException(AdapterErrorCode adapterErrorCode, Throwable th, int i, e eVar) {
        this(adapterErrorCode, (i & 2) != 0 ? null : th);
    }

    public final int getCode() {
        return this.error.code;
    }

    public final Throwable getDetail() {
        return this.detail;
    }

    public final AdapterErrorCode getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    public String toString() {
        AdapterErrorCode adapterErrorCode = this.error;
        return "AdapterException(code=" + adapterErrorCode.code + ", message=" + adapterErrorCode.message + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterException(AdapterErrorCode error, Throwable th) {
        super(error.message, th);
        k.f(error, "error");
        this.error = error;
        this.detail = th;
    }
}
