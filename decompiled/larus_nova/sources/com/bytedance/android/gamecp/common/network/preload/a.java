package com.bytedance.android.gamecp.common.network.preload;

import com.bytedance.android.gamecp.base.cache.c;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes44.dex */
public final class a<K, V> extends c<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f56708e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentMap<K, Subject<V>> f56709d;

    static {
        f56708e = a.class.getSimpleName();
    }

    public a() {
        super(8);
        this.f56709d = new ConcurrentHashMap(8);
    }

    public final synchronized Observable<V> d(K r100) {
        monitor-enter(this);
        yr.c.e(f56708e, "observe : " + r100.toString());     // Catch: Throwable -> L7
        ((ConcurrentHashMap) this.f56709d).putIfAbsent(r100, PublishSubject.create());     // Catch: Throwable -> L7
        Observable<V> r101 = (Observable) ((ConcurrentHashMap) this.f56709d).get(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }
}
