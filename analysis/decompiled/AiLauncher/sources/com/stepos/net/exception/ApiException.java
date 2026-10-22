package com.stepos.net.exception;

import Y8.j;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001aJ\b\u0010\u001b\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/stepos/net/exception/ApiException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "code", "", "errorMessage", "", "cause", "", "errorGroup", "Lcom/stepos/net/exception/ErrorGroup;", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;Lcom/stepos/net/exception/ErrorGroup;)V", "getCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getErrorGroup", "()Lcom/stepos/net/exception/ErrorGroup;", "isHttpError", "", "()Z", "isNetworkError", "isBusinessError", "isCanceled", "crashKeys", "", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ApiException extends RuntimeException {
    private final int code;
    private final ErrorGroup errorGroup;

    /* renamed from: errorMessage, reason: from kotlin metadata and from toString */
    private final String message;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApiException(int i10, String errorMessage) {
        this(i10, errorMessage, null, null, 12, null);
        p.i(errorMessage, "errorMessage");
    }

    public final Map<String, String> crashKeys() {
        return a.m(j.a("api.code", String.valueOf(this.code)), j.a("api.errorGroup", this.errorGroup.getTag()), j.a("api.retriable", String.valueOf(this.errorGroup.getRetriable())));
    }

    public final int getCode() {
        return this.code;
    }

    public final ErrorGroup getErrorGroup() {
        return this.errorGroup;
    }

    /* renamed from: getErrorMessage, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final boolean isBusinessError() {
        return this.errorGroup == ErrorGroup.BUSINESS;
    }

    public final boolean isCanceled() {
        return this.errorGroup == ErrorGroup.CANCELED;
    }

    public final boolean isHttpError() {
        int i10 = this.code;
        return 400 <= i10 && i10 < 600;
    }

    public final boolean isNetworkError() {
        return this.errorGroup == ErrorGroup.NETWORK;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "ApiException(code=" + this.code + ", group=" + this.errorGroup.getTag() + ", message=" + this.message + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApiException(int i10, String errorMessage, Throwable th) {
        this(i10, errorMessage, th, null, 8, null);
        p.i(errorMessage, "errorMessage");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiException(int i10, String errorMessage, Throwable th, ErrorGroup errorGroup) {
        super(errorMessage, th);
        p.i(errorMessage, "errorMessage");
        p.i(errorGroup, "errorGroup");
        this.code = i10;
        this.message = errorMessage;
        this.errorGroup = errorGroup;
    }

    public /* synthetic */ ApiException(int i10, String str, Throwable th, ErrorGroup errorGroup, int i11, i iVar) {
        this(i10, str, (i11 & 4) != 0 ? null : th, (i11 & 8) != 0 ? ErrorGroup.INSTANCE.fromCode(i10) : errorGroup);
    }
}
