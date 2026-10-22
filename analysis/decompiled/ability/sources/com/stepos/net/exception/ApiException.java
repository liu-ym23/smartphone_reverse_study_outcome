package com.stepos.net.exception;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001aJ\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/stepos/net/exception/ApiException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "errorMessage", "", "cause", "", "errorGroup", "Lcom/stepos/net/exception/ErrorGroup;", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/lang/Throwable;Lcom/stepos/net/exception/ErrorGroup;)V", "getCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getErrorGroup", "()Lcom/stepos/net/exception/ErrorGroup;", "isHttpError", "", "()Z", "isNetworkError", "isBusinessError", "isCanceled", "crashKeys", "", "toString", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiException extends RuntimeException {
    private final int code;
    private final ErrorGroup errorGroup;
    private final String errorMessage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApiException(int i, String errorMessage) {
        this(i, errorMessage, null, null, 12, null);
        k.f(errorMessage, "errorMessage");
    }

    public final Map<String, String> crashKeys() {
        return a.R(new Pair("api.code", String.valueOf(this.code)), new Pair("api.errorGroup", this.errorGroup.getTag()), new Pair("api.retriable", String.valueOf(this.errorGroup.getRetriable())));
    }

    public final int getCode() {
        return this.code;
    }

    public final ErrorGroup getErrorGroup() {
        return this.errorGroup;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean isBusinessError() {
        return this.errorGroup == ErrorGroup.BUSINESS;
    }

    public final boolean isCanceled() {
        return this.errorGroup == ErrorGroup.CANCELED;
    }

    public final boolean isHttpError() {
        int i = this.code;
        return 400 <= i && i < 600;
    }

    public final boolean isNetworkError() {
        return this.errorGroup == ErrorGroup.NETWORK;
    }

    @Override // java.lang.Throwable
    public String toString() {
        int i = this.code;
        String tag = this.errorGroup.getTag();
        return B7.a.q(androidx.constraintlayout.core.dsl.a.k(i, "ApiException(code=", ", group=", tag, ", message="), this.errorMessage, ")");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApiException(int i, String errorMessage, Throwable th) {
        this(i, errorMessage, th, null, 8, null);
        k.f(errorMessage, "errorMessage");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiException(int i, String errorMessage, Throwable th, ErrorGroup errorGroup) {
        super(errorMessage, th);
        k.f(errorMessage, "errorMessage");
        k.f(errorGroup, "errorGroup");
        this.code = i;
        this.errorMessage = errorMessage;
        this.errorGroup = errorGroup;
    }

    public /* synthetic */ ApiException(int i, String str, Throwable th, ErrorGroup errorGroup, int i6, e eVar) {
        this(i, str, (i6 & 4) != 0 ? null : th, (i6 & 8) != 0 ? ErrorGroup.INSTANCE.fromCode(i) : errorGroup);
    }
}
