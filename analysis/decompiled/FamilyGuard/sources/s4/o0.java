package s4;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class o0 extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient n0 f20366a;

    public o0(String str, Throwable th, n0 n0Var) {
        super(str);
        this.f20366a = n0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return j4.k.b(o0Var.getMessage(), getMessage()) && j4.k.b(o0Var.f20366a, this.f20366a) && j4.k.b(o0Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        j4.k.d(message);
        int iHashCode = ((message.hashCode() * 31) + this.f20366a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f20366a;
    }
}
