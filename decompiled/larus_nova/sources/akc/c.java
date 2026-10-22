package akc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes5.dex */
public final class c<K, V> implements Map<K, V>, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f4110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4111b;

    public c() {
        HashMap r100 = new HashMap();
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f4110a = r100;
        this.f4111b = new Object();
    }

    @Override // java.util.Map
    public final void clear() {
        Object r100 = this.f4111b;
        monitor-enter(r100);
        this.f4110a.clear();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Object r100 = this.f4111b;
        monitor-enter(r100);
        d r101 = new d(this.f4110a.entrySet(), this.f4111b);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        Object r100 = this.f4111b;
        monitor-enter(r100);
        boolean r101 = this.f4110a.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        Object r100 = this.f4111b;
        monitor-enter(r100);
        d r101 = new d(this.f4110a.keySet(), this.f4111b);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final int size() {
        Object r100 = this.f4111b;
        monitor-enter(r100);
        int r101 = this.f4110a.size();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        Object r100 = this.f4111b;
        monitor-enter(r100);
        a r101 = new a(this.f4110a.values(), this.f4111b);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r100) {
        Object r101 = this.f4111b;
        monitor-enter(r101);
        boolean r102 = this.f4110a.containsKey(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r100) {
        Object r101 = this.f4111b;
        monitor-enter(r101);
        boolean r102 = this.f4110a.containsValue(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final V get(Object r100) {
        Object r101 = this.f4111b;
        monitor-enter(r101);
        V r102 = this.f4110a.get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Object r101 = this.f4111b;
        monitor-enter(r101);
        this.f4110a.putAll(r100);     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final V remove(Object r100) {
        Object r101 = this.f4111b;
        monitor-enter(r101);
        V r102 = this.f4110a.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final V put(K r100, V r101) {
        Object r102 = this.f4111b;
        monitor-enter(r102);
        V r103 = this.f4110a.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }
}
