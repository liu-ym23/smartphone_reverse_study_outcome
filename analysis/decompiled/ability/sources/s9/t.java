package s9;

/* loaded from: classes4.dex */
public final class t implements H7.g {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f6009a;

    public t(ThreadLocal threadLocal) {
        this.f6009a = threadLocal;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && kotlin.jvm.internal.k.b(this.f6009a, ((t) obj).f6009a);
    }

    public final int hashCode() {
        return this.f6009a.hashCode();
    }

    public final String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f6009a + ')';
    }
}
