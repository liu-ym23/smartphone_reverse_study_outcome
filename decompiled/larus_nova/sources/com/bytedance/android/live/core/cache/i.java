package com.bytedance.android.live.core.cache;

import android.util.Pair;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes45.dex */
public class i<K, V> implements a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function<K, Integer> f64776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BiFunction<K, List<V>, List<V>> f64777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<K, List<V>, Integer, List<V>, List<V>> f64778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, List<V>> f64779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentMap<Integer, PublishSubject<a.C1063a>> f64780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject<Pair<K, a.C1063a>> f64781f;

    public i() {
        this(new c(), new g(), new h());
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final void clear() {
        ((ConcurrentHashMap) this.f64779d).clear();
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final void e(K r100) {
        int r101 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r102 = this.f64779d;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        if (r103.containsKey(Integer.valueOf(r101)) == true) goto L5;
        Map<Integer, List<V>> r104 = this.f64779d;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(Integer.valueOf(r101), new ArrayList());
    L5:
        Map<Integer, List<V>> r106 = this.f64779d;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        ((List) r107.get(Integer.valueOf(r101))).clear();
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final List<V> get(K r100) {
        int r101 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r102 = this.f64779d;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        if (r103.containsKey(Integer.valueOf(r101)) == true) goto L5;
        Map<Integer, List<V>> r104 = this.f64779d;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(Integer.valueOf(r101), new ArrayList());
    L5:
        Map<Integer, List<V>> r106 = this.f64779d;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        return (List) r107.get(Integer.valueOf(r101));
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final int size(K r100) {
        int r101 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r102 = this.f64779d;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        if (r103.containsKey(Integer.valueOf(r101)) == true) goto L5;
        Map<Integer, List<V>> r104 = this.f64779d;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(Integer.valueOf(r101), new ArrayList());
    L5:
        Map<Integer, List<V>> r106 = this.f64779d;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        return ((List) r107.get(Integer.valueOf(r101))).size();
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final int a(K r100, V r101) {
        int r102 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r103 = this.f64779d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Integer.valueOf(r102)) == true) goto L5;
        Map<Integer, List<V>> r105 = this.f64779d;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(Integer.valueOf(r102), new ArrayList());
    L5:
        Map<Integer, List<V>> r107 = this.f64779d;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        return ((List) r108.get(Integer.valueOf(r102))).indexOf(r101);
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final V c(K r100, j<V> r101) {
        int r102 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r103 = this.f64779d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Integer.valueOf(r102)) == true) goto L5;
        Map<Integer, List<V>> r105 = this.f64779d;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(Integer.valueOf(r102), new ArrayList());
    L5:
        Map<Integer, List<V>> r107 = this.f64779d;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        Iterator r109 = ((List) r108.get(Integer.valueOf(r102))).iterator();
    L7:
        if (r109.hasNext() == false) goto L14;
        V r110 = (V) r109.next();
        if (r101.test(r110) == false) goto L7;
        return r110;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final List<V> d(K r100, List<V> r101) {
        int r102 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r103 = this.f64779d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Integer.valueOf(r102)) == true) goto L5;
        Map<Integer, List<V>> r105 = this.f64779d;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(Integer.valueOf(r102), new ArrayList());
    L5:
        Map<Integer, List<V>> r107 = this.f64779d;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        return insert(r100, ((List) r108.get(Integer.valueOf(r102))).size(), r101);
    }

    @Override // com.bytedance.android.live.core.cache.a
    public void delete(K r100, V r101) {
        int r102 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r103 = this.f64779d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Integer.valueOf(r102)) == true) goto L5;
        Map<Integer, List<V>> r105 = this.f64779d;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(Integer.valueOf(r102), new ArrayList());
    L5:
        Map<Integer, List<V>> r107 = this.f64779d;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        List r109 = (List) r108.get(Integer.valueOf(r102));
        r109.indexOf(r101);
        if (r109.remove(r101) == true) goto L8;
        return;
    L8:
        a.C1063a r110 = new a.C1063a(Collections.singletonList(r101));
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r111 = this.f64780e;
        ConcurrentHashMap r112 = (ConcurrentHashMap) r111;
        if (r112.containsKey(Integer.valueOf(r102)) == false) goto L11;
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r113 = this.f64780e;
        ConcurrentHashMap r114 = (ConcurrentHashMap) r113;
        ((PublishSubject) r114.get(Integer.valueOf(r102))).onNext(r110);
    L11:
        this.f64781f.onNext(Pair.create(r100, r110));
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final V get(K r100, int r101) {
        int r102 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r103 = this.f64779d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Integer.valueOf(r102)) == true) goto L5;
        Map<Integer, List<V>> r105 = this.f64779d;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(Integer.valueOf(r102), new ArrayList());
    L5:
        Map<Integer, List<V>> r107 = this.f64779d;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        List r109 = (List) r108.get(Integer.valueOf(r102));
        if (r101 >= 0) goto L8;
        return null;
    L8:
        if (r101 <= r109.size()) goto L11;
        return null;
    L11:
        return (V) ListProtector.get(r109, r101);
    }

    @Override // com.bytedance.android.live.core.cache.a
    public void delete(K r100, int r101) {
        int r102 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r103 = this.f64779d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(Integer.valueOf(r102)) == true) goto L5;
        Map<Integer, List<V>> r105 = this.f64779d;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(Integer.valueOf(r102), new ArrayList());
    L5:
        Map<Integer, List<V>> r107 = this.f64779d;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        List r109 = (List) r108.get(Integer.valueOf(r102));
        if (r101 >= 0) goto L8;
        return;
    L8:
        if (r101 > r109.size()) goto L16;
        Object r110 = ListProtector.remove(r109, r101);
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r111 = this.f64780e;
        ConcurrentHashMap r112 = (ConcurrentHashMap) r111;
        if (r112.containsKey(Integer.valueOf(r102)) == false) goto L15;
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r113 = this.f64780e;
        ConcurrentHashMap r114 = (ConcurrentHashMap) r113;
        ((PublishSubject) r114.get(Integer.valueOf(r102))).onNext(new a.C1063a(Collections.singletonList(r110)));
        return;
    L15:
        return;
    }

    public i(Function<K, Integer> r100, Function4<K, List<V>, Integer, List<V>, List<V>> r101, BiFunction<K, List<V>, List<V>> r102) {
        this.f64779d = new ConcurrentHashMap();
        this.f64780e = new ConcurrentHashMap(20, 0.75f, 4);
        this.f64781f = PublishSubject.create();
        this.f64776a = r100;
        this.f64778c = r101;
        this.f64777b = r102;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final void b(K r100, int r101, V r102) {
        int r103 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();
        Map<Integer, List<V>> r104 = this.f64779d;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        if (r105.containsKey(Integer.valueOf(r103)) == true) goto L5;
        Map<Integer, List<V>> r106 = this.f64779d;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(Integer.valueOf(r103), new ArrayList());
    L5:
        Map<Integer, List<V>> r108 = this.f64779d;
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;
        List r110 = (List) r109.get(Integer.valueOf(r103));
        if (r101 >= 0) goto L8;
        return;
    L8:
        if (r101 > r110.size()) goto L16;
        ListProtector.set(r110, r101, r102);
        a.C1063a r111 = new a.C1063a(Collections.singletonList(r102));
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r112 = this.f64780e;
        ConcurrentHashMap r113 = (ConcurrentHashMap) r112;
        if (r113.containsKey(Integer.valueOf(r103)) == false) goto L13;
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r114 = this.f64780e;
        ConcurrentHashMap r115 = (ConcurrentHashMap) r114;
        ((PublishSubject) r115.get(Integer.valueOf(r103))).onNext(r111);
    L13:
        this.f64781f.onNext(Pair.create(r100, r111));
        return;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public synchronized List<V> insert(K r100, int r101, List<V> r102) {
        monitor-enter(this);
        int r103 = ((Integer) RxUtil.apply(this.f64776a, r100)).intValue();     // Catch: Throwable -> L16
        Map<Integer, List<V>> r104 = this.f64779d;     // Catch: Throwable -> L16
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L16
        if (r105.containsKey(Integer.valueOf(r103)) == true) goto L6;
        Map<Integer, List<V>> r106 = this.f64779d;     // Catch: Throwable -> L16
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;     // Catch: Throwable -> L16
        r107.put(Integer.valueOf(r103), new ArrayList());     // Catch: Throwable -> L16
    L6:
        List r108 = (List) RxUtil.apply(this.f64777b, r100, r102);     // Catch: Throwable -> L16
        Map<Integer, List<V>> r109 = this.f64779d;     // Catch: Throwable -> L16
        ConcurrentHashMap r110 = (ConcurrentHashMap) r109;     // Catch: Throwable -> L16
        List r111 = (List) r110.get(Integer.valueOf(r103));     // Catch: Throwable -> L16
        List<V> r112 = (List) RxUtil.apply(this.f64778c, r100, r111, Integer.valueOf(r101), r108);     // Catch: Throwable -> L16
        if (Lists.isEmpty(r112) == false) goto L10;
        monitor-exit(this);
        return r112;
    L10:
        r111.addAll(Math.min(r101, r111.size()), r112);     // Catch: Throwable -> L16
        Map<Integer, List<V>> r113 = this.f64779d;     // Catch: Throwable -> L16
        ConcurrentHashMap r114 = (ConcurrentHashMap) r113;     // Catch: Throwable -> L16
        r114.put(Integer.valueOf(r103), r111);     // Catch: Throwable -> L16
        a.C1063a r115 = new a.C1063a(r112);     // Catch: Throwable -> L16
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r116 = this.f64780e;     // Catch: Throwable -> L16
        ConcurrentHashMap r117 = (ConcurrentHashMap) r116;     // Catch: Throwable -> L16
        if (r117.containsKey(Integer.valueOf(r103)) == false) goto L13;
        ConcurrentMap<Integer, PublishSubject<a.C1063a>> r118 = this.f64780e;     // Catch: Throwable -> L16
        ConcurrentHashMap r119 = (ConcurrentHashMap) r118;     // Catch: Throwable -> L16
        ((PublishSubject) r119.get(Integer.valueOf(r103))).onNext(r115);     // Catch: Throwable -> L16
    L13:
        this.f64781f.onNext(Pair.create(r100, r115));     // Catch: Throwable -> L16
        monitor-exit(this);
        return r112;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public List<V> insert(K r100, int r101, V r102) {
        ArrayList r103 = new ArrayList();
        r103.add(r102);
        return insert(r100, r101, r103);
    }
}
