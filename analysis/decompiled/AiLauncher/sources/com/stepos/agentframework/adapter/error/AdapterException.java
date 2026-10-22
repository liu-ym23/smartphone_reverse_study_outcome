package com.stepos.agentframework.adapter.error;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m4.AbstractC4898a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/error/AdapterException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lm4/a;", "error", "", "detail", "<init>", "(Lm4/a;Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lm4/a;", Const.INTENT_KEY_APIKEY, "()Lm4/a;", "Ljava/lang/Throwable;", "getDetail", "()Ljava/lang/Throwable;", "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AdapterException extends Exception {
    private final Throwable detail;
    private final AbstractC4898a error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdapterException(AbstractC4898a error, Throwable th) {
        super(error.message, th);
        p.i(error, "error");
        this.error = error;
        this.detail = th;
    }

    /* renamed from: a, reason: from getter */
    public final AbstractC4898a getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    public String toString() {
        AbstractC4898a abstractC4898a = this.error;
        return "AdapterException(code=" + abstractC4898a.code + ", message=" + abstractC4898a.message + ")";
    }
}
