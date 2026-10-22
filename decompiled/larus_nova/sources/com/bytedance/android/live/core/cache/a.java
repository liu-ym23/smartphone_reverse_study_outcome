package com.bytedance.android.live.core.cache;

import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public interface a<K, V> {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.cache.a$a, reason: collision with other inner class name */
    public static class C1063a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<V> f64768a;

        public C1063a(List r100) {
            this.f64768a = r100;
        }
    }

    int a(K r100, V r101);

    void b(K r100, int r101, V r102);

    V c(K r100, j<V> r101);

    void clear();

    List<V> d(K r100, List<V> r101);

    void delete(K r100, int r101);

    void delete(K r100, V r101);

    void e(K r100);

    V get(K r100, int r101);

    List<V> get(K r100);

    List<V> insert(K r100, int r101, V r102);

    List<V> insert(K r100, int r101, List<V> r102);

    int size(K r100);
}
