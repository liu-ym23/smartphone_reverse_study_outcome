package Z2;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class p0 extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient o0 f2231a;

    public p0(String str, Throwable th, o0 o0Var) {
        super(str);
        this.f2231a = o0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof p0) {
                p0 p0Var = (p0) obj;
                if (!Intrinsics.areEqual(p0Var.getMessage(), getMessage()) || !Intrinsics.areEqual(p0Var.f2231a, this.f2231a) || !Intrinsics.areEqual(p0Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        Intrinsics.checkNotNull(message);
        int iHashCode = (this.f2231a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f2231a;
    }
}
