package com.bytedance.android.livesdk.feed.services;

import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.network.GsonProvider;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f124377b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a<?>> f124378a;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T> f124379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f124380b;

        public a() {
            throw null;
        }

        public a(b r100) {
            this.f124379a = r100;
        }
    }

    public interface b<T> {

        public static final class a<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public R f124381a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f124382b;

            public a() {
            }
        }

        a<T> a(a<T> r100);
    }

    public c() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        this.f124378a = r100;
        r100.put(f.class, new a(new com.bytedance.android.livesdk.feed.services.a()));
        r100.put(hw1.a.class, new a(new e()));
        r100.put(Gson.class, new a(new GsonProvider()));
    }

    public static <T> T b(Class<T> r100) {
        if (f124377b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f124377b != null) goto L9;
        f124377b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return (T) f124377b.a(r100);
    }

    public final <T> T a(final Class<T> r100) {
        a r101 = (a) ((ConcurrentHashMap) this.f124378a).get(r100);
        if (r101 != null) goto L5;
        a r102 = new a(new com.bytedance.android.livesdk.feed.services.b(r100));
        ((ConcurrentHashMap) this.f124378a).put(r100, r102);
        r101 = r102;
    L5:
        b.a<T> r103 = r101.f124379a.a(new b.a());
        if (r103.f124382b == false) goto L21;
        if (r101.f124380b != null) goto L24;
        monitor-enter(c.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r101.f124380b != null) goto L14;
        r101.f124380b = r103.f124381a;     // Catch: Throwable -> L16
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L16
    L24:
        return (T) r101.f124380b;
    L21:
        return r103.f124381a;
    }
}
