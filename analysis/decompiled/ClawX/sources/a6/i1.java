package a6;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i1 extends CancellationException implements x {

    /* renamed from: a, reason: collision with root package name */
    public final transient p1 f181a;

    public i1(String str, Throwable th, p1 p1Var) {
        super(str);
        this.f181a = p1Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // a6.x
    public final /* bridge */ /* synthetic */ Throwable a() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        if (!kotlin.jvm.internal.p.a(i1Var.getMessage(), getMessage())) {
            return false;
        }
        Object obj2 = i1Var.f181a;
        if (obj2 == null) {
            obj2 = r1.f212b;
        }
        Object obj3 = this.f181a;
        if (obj3 == null) {
            obj3 = r1.f212b;
        }
        return kotlin.jvm.internal.p.a(obj2, obj3) && kotlin.jvm.internal.p.a(i1Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.p.b(message);
        int iHashCode = message.hashCode() * 31;
        Object obj = this.f181a;
        if (obj == null) {
            obj = r1.f212b;
        }
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Throwable cause = getCause();
        return iHashCode2 + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        Object obj = this.f181a;
        if (obj == null) {
            obj = r1.f212b;
        }
        sb.append(obj);
        return sb.toString();
    }
}
