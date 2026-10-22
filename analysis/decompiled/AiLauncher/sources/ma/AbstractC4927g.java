package ma;

import E9.InterfaceC0819y;
import ya.S;

/* renamed from: ma.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4927g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f37193a;

    public AbstractC4927g(T t10) {
        this.f37193a = t10;
    }

    public abstract S a(InterfaceC0819y interfaceC0819y);

    public T b() {
        return this.f37193a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        T tB = b();
        AbstractC4927g abstractC4927g = obj instanceof AbstractC4927g ? (AbstractC4927g) obj : null;
        return kotlin.jvm.internal.p.d(tB, abstractC4927g != null ? abstractC4927g.b() : null);
    }

    public int hashCode() {
        T tB = b();
        if (tB != null) {
            return tB.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
