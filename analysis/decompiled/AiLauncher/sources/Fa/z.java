package Fa;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

/* loaded from: classes5.dex */
public abstract class z<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f2736a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f2737b = new AtomicInteger(0);

    public static final int g(z zVar, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return zVar.f2737b.getAndIncrement();
    }

    public final Map<String, Integer> b() {
        return this.f2736a;
    }

    public abstract int c(ConcurrentHashMap<String, Integer> concurrentHashMap, String str, InterfaceC5074l<? super String, Integer> interfaceC5074l);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> n<K, V, T> d(InterfaceC5745d<KK> kClass) {
        kotlin.jvm.internal.p.i(kClass, "kClass");
        return new n<>(f(kClass));
    }

    public final int e(String keyQualifiedName) {
        kotlin.jvm.internal.p.i(keyQualifiedName, "keyQualifiedName");
        return c(this.f2736a, keyQualifiedName, new y(this));
    }

    public final <T extends K> int f(InterfaceC5745d<T> kClass) {
        kotlin.jvm.internal.p.i(kClass, "kClass");
        String strN = kClass.n();
        kotlin.jvm.internal.p.f(strN);
        return e(strN);
    }

    public final Collection<Integer> h() {
        Collection<Integer> collectionValues = this.f2736a.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        return collectionValues;
    }
}
