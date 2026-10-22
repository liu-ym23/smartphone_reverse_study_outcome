package com.stepos.motionkit;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/motionkit/MotionKitError;", "", "level", "Lcom/stepos/motionkit/ErrorLevel;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/ErrorLevel;Ljava/lang/String;Ljava/lang/Throwable;)V", "getLevel", "()Lcom/stepos/motionkit/ErrorLevel;", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MotionKitError {
    private final Throwable cause;
    private final ErrorLevel level;
    private final String message;

    public MotionKitError(ErrorLevel level, String message, Throwable th) {
        k.f(level, "level");
        k.f(message, "message");
        this.level = level;
        this.message = message;
        this.cause = th;
    }

    public static /* synthetic */ MotionKitError copy$default(MotionKitError motionKitError, ErrorLevel errorLevel, String str, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            errorLevel = motionKitError.level;
        }
        if ((i & 2) != 0) {
            str = motionKitError.message;
        }
        if ((i & 4) != 0) {
            th = motionKitError.cause;
        }
        return motionKitError.copy(errorLevel, str, th);
    }

    /* renamed from: component1, reason: from getter */
    public final ErrorLevel getLevel() {
        return this.level;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final Throwable getCause() {
        return this.cause;
    }

    public final MotionKitError copy(ErrorLevel level, String message, Throwable cause) {
        k.f(level, "level");
        k.f(message, "message");
        return new MotionKitError(level, message, cause);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MotionKitError)) {
            return false;
        }
        MotionKitError motionKitError = (MotionKitError) other;
        return this.level == motionKitError.level && k.b(this.message, motionKitError.message) && k.b(this.cause, motionKitError.cause);
    }

    public final Throwable getCause() {
        return this.cause;
    }

    public final ErrorLevel getLevel() {
        return this.level;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iC = a.c(this.level.hashCode() * 31, 31, this.message);
        Throwable th = this.cause;
        return iC + (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "MotionKitError(level=" + this.level + ", message=" + this.message + ", cause=" + this.cause + ")";
    }

    public /* synthetic */ MotionKitError(ErrorLevel errorLevel, String str, Throwable th, int i, e eVar) {
        this(errorLevel, str, (i & 4) != 0 ? null : th);
    }
}
