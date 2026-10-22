package com.stepos.core.transport.bridge;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/core/transport/bridge/InferenceResponseError;", "", "code", "", "message", "", "cause", "", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InferenceResponseError {
    private final Throwable cause;
    private final int code;
    private final String message;

    public InferenceResponseError(int i10, String message, Throwable th) {
        p.i(message, "message");
        this.code = i10;
        this.message = message;
        this.cause = th;
    }

    public static /* synthetic */ InferenceResponseError copy$default(InferenceResponseError inferenceResponseError, int i10, String str, Throwable th, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = inferenceResponseError.code;
        }
        if ((i11 & 2) != 0) {
            str = inferenceResponseError.message;
        }
        if ((i11 & 4) != 0) {
            th = inferenceResponseError.cause;
        }
        return inferenceResponseError.copy(i10, str, th);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    public final InferenceResponseError copy(int code, String message, Throwable cause) {
        p.i(message, "message");
        return new InferenceResponseError(code, message, cause);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InferenceResponseError)) {
            return false;
        }
        InferenceResponseError inferenceResponseError = (InferenceResponseError) other;
        return this.code == inferenceResponseError.code && p.d(this.message, inferenceResponseError.message) && p.d(this.cause, inferenceResponseError.cause);
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        Throwable th = this.cause;
        return iHashCode + (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "InferenceResponseError(code=" + this.code + ", message=" + this.message + ", cause=" + this.cause + ")";
    }

    public /* synthetic */ InferenceResponseError(int i10, String str, Throwable th, int i11, i iVar) {
        this(i10, str, (i11 & 4) != 0 ? null : th);
    }
}
