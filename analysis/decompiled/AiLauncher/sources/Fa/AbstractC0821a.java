package Fa;

import java.util.Iterator;
import q9.InterfaceC5162a;
import w9.InterfaceC5745d;

/* renamed from: Fa.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0821a<K, V> implements Iterable<V>, InterfaceC5162a {

    /* renamed from: Fa.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0033a<K, V, T extends V> {

        /* renamed from: a, reason: collision with root package name */
        public final int f2630a;

        public AbstractC0033a(int i10) {
            this.f2630a = i10;
        }

        public final T a(AbstractC0821a<K, V> thisRef) {
            kotlin.jvm.internal.p.i(thisRef, "thisRef");
            return thisRef.b().get(this.f2630a);
        }
    }

    public abstract c<V> b();

    public abstract z<K, V> c();

    public abstract void e(String str, V v10);

    public final void f(InterfaceC5745d<? extends K> tClass, V value) {
        kotlin.jvm.internal.p.i(tClass, "tClass");
        kotlin.jvm.internal.p.i(value, "value");
        String strN = tClass.n();
        kotlin.jvm.internal.p.f(strN);
        e(strN, value);
    }

    public final boolean isEmpty() {
        return b().b() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<V> iterator() {
        return b().iterator();
    }
}
