package com.bytedance.android.live.core.cache;

import android.util.Pair;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes45.dex */
public final class f<K, V> implements Cache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function<K, Integer> f64770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BiFunction<K, V, Boolean> f64771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<K, V, Long, Boolean> f64772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BiFunction<V, V, V> f64773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Integer, Pair<V, Long>> f64774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentMap<Integer, Subject<V>> f64775f;

    public f() {
        BiFunction<K, V, Boolean> r100 = new b();
        c r101 = new c();
        Function3<K, V, Long, Boolean> r102 = new d();
        BiFunction<V, V, V> r103 = new e();
        this.f64774e = new ConcurrentHashMap();
        this.f64775f = new ConcurrentHashMap(20, 0.75f, 4);
        this.f64770a = r101;
        this.f64771b = r100;
        this.f64772c = r102;
        this.f64773d = r103;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final void clear() {
        ((ConcurrentHashMap) this.f64774e).clear();
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public void delete(K r100) {
        Map<Integer, Pair<V, Long>> r101 = this.f64774e;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.remove(RxUtil.apply(this.f64770a, r100));
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final V get(K r100) {
        Map<Integer, Pair<V, Long>> r101 = this.f64774e;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        Pair r103 = (Pair) r102.get(RxUtil.apply(this.f64770a, r100));
        if (r103 != null) goto L5;
        return null;
    L5:
        if (((Boolean) RxUtil.apply(this.f64772c, r100, r103.first, (Long) r103.second)).booleanValue() == false) goto L7;
        return null;
    L7:
        return (V) r103.first;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final Observable<V> observe(K r100) {
        int r101 = ((Integer) RxUtil.apply(this.f64770a, r100)).intValue();
        ConcurrentMap<Integer, Subject<V>> r102 = this.f64775f;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.putIfAbsent(Integer.valueOf(r101), PublishSubject.create());
        ConcurrentMap<Integer, Subject<V>> r104 = this.f64775f;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        return (Observable) r105.get(Integer.valueOf(r101));
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final void put(K r100, V r101) {
        if (((Boolean) RxUtil.apply(this.f64771b, r100, r101)).booleanValue() == false) goto L5;
        return;
    L5:
        int r102 = ((Integer) RxUtil.apply(this.f64770a, r100)).intValue();
        Map<Integer, Pair<V, Long>> r103 = this.f64774e;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        Pair r105 = (Pair) r104.get(Integer.valueOf(r102));
        if (r105 != null) goto L8;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L15;
        return;
    L15:
        Map<Integer, Pair<V, Long>> r107 = this.f64774e;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        r108.put(Integer.valueOf(r102), new Pair(r101, Long.valueOf(System.currentTimeMillis())));
        ConcurrentMap<Integer, Subject<V>> r109 = this.f64775f;
        ConcurrentHashMap r110 = (ConcurrentHashMap) r109;
        if (r110.containsKey(Integer.valueOf(r102)) == false) goto L19;
        ConcurrentMap<Integer, Subject<V>> r111 = this.f64775f;
        ConcurrentHashMap r112 = (ConcurrentHashMap) r111;
        ((Subject) r112.get(Integer.valueOf(r102))).onNext(r101);
        return;
    L19:
        return;
    L8:
        if (((Boolean) RxUtil.apply(this.f64772c, r100, r105.first, (Long) r105.second)).booleanValue() == true) goto L12;
        Map<Integer, Pair<V, Long>> r113 = this.f64774e;
        ConcurrentHashMap r114 = (ConcurrentHashMap) r113;
        Object r115 = ((Pair) r114.get(Integer.valueOf(r102))).first;
        r106 = r101.equals(r115);
        if (r106 == true) goto L13;
        r101 = (V) RxUtil.apply(this.f64773d, r115, r101);
        r106 = r101.equals(r115);
        goto L13
    }
}
