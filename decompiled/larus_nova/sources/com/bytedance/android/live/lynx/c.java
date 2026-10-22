package com.bytedance.android.live.lynx;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, a> f82536a = null;

    public interface a<T> {
        void provide();
    }

    static {
        ConcurrentHashMap<Class, a> r100 = new ConcurrentHashMap();
        f82536a = r100;
        r100.put(com.bytedance.android.live.lynx.a.class, new b.a());
    }

    public static <T> T a(Class<T> r100) {
        a r101 = f82536a.get(r100);
        if (r101 == null) goto L6;
        r101.provide();
        return (T) b.a.C1257a.f82534a;
    L6:
        return null;
    }
}
