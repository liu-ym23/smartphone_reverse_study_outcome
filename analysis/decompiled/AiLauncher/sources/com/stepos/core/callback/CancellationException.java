package com.stepos.core.callback;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/stepos/core/callback/CancellationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reason", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getReason", "()I", "getMessage", "()Ljava/lang/String;", "isUserCancelled", "", "isTimeout", "isInterrupted", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CancellationException extends Exception {
    private final String message;
    private final int reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancellationException(int i10, String message) {
        super(message);
        p.i(message, "message");
        this.reason = i10;
        this.message = message;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final int getReason() {
        return this.reason;
    }

    public final boolean isInterrupted() {
        return this.reason == -102;
    }

    public final boolean isTimeout() {
        return this.reason == -101;
    }

    public final boolean isUserCancelled() {
        return this.reason == -100;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CancellationException(" + this.reason + ": " + getMessage() + ")";
    }
}
