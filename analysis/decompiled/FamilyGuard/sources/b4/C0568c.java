package b4;

import W3.AbstractC0392c;
import W3.C0396g;
import j4.k;
import java.io.Serializable;
import java.lang.Enum;

/* renamed from: b4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0568c<T extends Enum<T>> extends AbstractC0392c<T> implements InterfaceC0566a<T>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    private final T[] f11832b;

    public C0568c(T[] tArr) {
        k.g(tArr, "entries");
        this.f11832b = tArr;
    }

    @Override // W3.AbstractC0391b
    public int c() {
        return this.f11832b.length;
    }

    @Override // W3.AbstractC0391b, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return h((Enum) obj);
        }
        return false;
    }

    public boolean h(T t5) {
        k.g(t5, "element");
        return ((Enum) C0396g.q(this.f11832b, t5.ordinal())) == t5;
    }

    @Override // W3.AbstractC0392c, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public T get(int i5) {
        AbstractC0392c.f5747a.a(i5, this.f11832b.length);
        return this.f11832b[i5];
    }

    @Override // W3.AbstractC0392c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return m((Enum) obj);
        }
        return -1;
    }

    @Override // W3.AbstractC0392c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return n((Enum) obj);
        }
        return -1;
    }

    public int m(T t5) {
        k.g(t5, "element");
        int iOrdinal = t5.ordinal();
        if (((Enum) C0396g.q(this.f11832b, iOrdinal)) == t5) {
            return iOrdinal;
        }
        return -1;
    }

    public int n(T t5) {
        k.g(t5, "element");
        return m(t5);
    }
}
