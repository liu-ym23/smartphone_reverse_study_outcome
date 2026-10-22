package com.amap.api.col.s;

import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: loaded from: classes28.dex */
final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f26001a;

    public static synchronized void a() {
        monitor-enter(ac.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f26001a == true) goto L7;
        ad.a().a("regeo", new af(new String[]{"/geocode/regeo"}));     // Catch: Throwable -> L9
        ad.a().a("placeAround", new af(new String[]{"/place/around"}));     // Catch: Throwable -> L9
        ad.a().a("placeText", new ae(new String[]{"/place/text"}));     // Catch: Throwable -> L9
        ad.a().a(MapBundleKey.MapObjKey.OBJ_GEO, new ae(new String[]{"/geocode/geo"}));     // Catch: Throwable -> L9
        f26001a = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(ac.class);
    }
}
