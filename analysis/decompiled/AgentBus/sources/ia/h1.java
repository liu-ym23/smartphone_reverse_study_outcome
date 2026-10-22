package ia;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class h1 extends CancellationException {

    /* renamed from: f, reason: collision with root package name */
    public final transient o1 f4961f;

    public h1(String str, Throwable th, o1 o1Var) {
        super(str);
        this.f4961f = o1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        if (!q7.k.a(h1Var.getMessage(), getMessage())) {
            return false;
        }
        Object obj2 = h1Var.f4961f;
        if (obj2 == null) {
            obj2 = r1.f4998g;
        }
        Object obj3 = this.f4961f;
        if (obj3 == null) {
            obj3 = r1.f4998g;
        }
        return q7.k.a(obj2, obj3) && q7.k.a(h1Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        q7.k.b(message);
        int iHashCode = message.hashCode() * 31;
        Object obj = this.f4961f;
        if (obj == null) {
            obj = r1.f4998g;
        }
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Throwable cause = getCause();
        return iHashCode2 + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("; job=");
        Object obj = this.f4961f;
        if (obj == null) {
            obj = r1.f4998g;
        }
        sb2.append(obj);
        return sb2.toString();
    }
}
