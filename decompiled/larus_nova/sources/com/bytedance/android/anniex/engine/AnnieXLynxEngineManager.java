package com.bytedance.android.anniex.engine;

import android.util.LruCache;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXLynxEngineManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnnieXLynxEngineManager f40721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f40722b = null;

    public AnnieXLynxEngineManager() {
    }

    public final synchronized void c() {
        monitor-enter(this);
        Iterator r100 = b().entrySet().iterator();     // Catch: Throwable -> L20
    L4:
        if (r100.hasNext() == false) goto L18;
        LruCache r101 = (LruCache) ((Map.Entry) r100.next()).getValue();     // Catch: Throwable -> L20
        Iterator r102 = r101.snapshot().entrySet().iterator();     // Catch: Throwable -> L20
    L8:
        if (r102.hasNext() == false) goto L4;
        Map.Entry r103 = (Map.Entry) r102.next();     // Catch: Throwable -> L20
        String r104 = (String) r103.getKey();     // Catch: Throwable -> L20
        AnnieXLynxEngine r105 = (AnnieXLynxEngine) r103.getValue();     // Catch: Throwable -> L20
        boolean r106 = false;
        if (r105.f40716h > 0) goto L13;
    L15:
        if (r106 == false) goto L8;
        r101.remove(r104);     // Catch: Throwable -> L20
        goto L8
    L13:
        if ((System.currentTimeMillis() - r105.f40714f) <= r105.f40716h) goto L15;
        r106 = true;
        goto L15
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    static {
        f40721a = new AnnieXLynxEngineManager();
        f40722b = LazyKt.lazy(AnnieXLynxEngineManager$engineCacheMap$2.INSTANCE);
    }

    public static ConcurrentHashMap b() {
        return (ConcurrentHashMap) f40722b.getValue();
    }

    public final synchronized AnnieXLynxEngine a(String r110, String r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "bid");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r111, "sessionId");     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
        LruCache r100 = (LruCache) b().get(r110);     // Catch: Throwable -> L22
        AnnieXLynxEngine r101 = null;
        if (r100 == null) goto L20;
        AnnieXLynxEngine r102 = (AnnieXLynxEngine) r100.get(r111);     // Catch: Throwable -> L22
        if (r102 == null) goto L20;
        boolean r103 = false;
        if (r102.f40716h > 0) goto L12;
    L14:
        if (r103 == false) goto L16;
        r100.remove(r111);     // Catch: Throwable -> L22
        HybridLogger r104 = HybridLogger.f246343a;     // Catch: Throwable -> L22
        HybridLogger.i("AnnieXLynxEngineManager", "AnnieXLynxEngine expired, bid: " + r110 + ", sessionId: " + r111, null, 12);     // Catch: Throwable -> L22
    L18:
        monitor-exit(this);
        return r101;
    L16:
        r100.remove(r111);     // Catch: Throwable -> L22
        r101 = r102;
        goto L18
    L12:
        if ((System.currentTimeMillis() - r102.f40714f) <= r102.f40716h) goto L14;
        r103 = true;
    L20:
        monitor-exit(this);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(String r100, String r101, AnnieXLynxEngine r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "bid");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r101, "sessionId");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r102, "annieXLynxEngine");     // Catch: Throwable -> L21
        if (b().containsKey(r100) == false) goto L14;
        LruCache r103 = (LruCache) b().get(r100);     // Catch: Throwable -> L21
        if (r103 == null) goto L9;
        AnnieXLynxEngine r104 = (AnnieXLynxEngine) r103.put(r101, r102);     // Catch: Throwable -> L21
    L9:
        HybridLogger r105 = HybridLogger.f246343a;     // Catch: Throwable -> L21
        StringBuilder r106 = new StringBuilder("AnnieXLynxEngine Count, bid: ");     // Catch: Throwable -> L21
        r106.append(r100);     // Catch: Throwable -> L21
        r106.append(", count: ");     // Catch: Throwable -> L21
        LruCache r107 = (LruCache) b().get(r100);     // Catch: Throwable -> L21
        if (r107 == null) goto L12;
        Integer r108 = Integer.valueOf(r107.size());     // Catch: Throwable -> L21
    L13:
        r106.append(r108);     // Catch: Throwable -> L21
        HybridLogger.m("AnnieXLynxEngineManager", r106.toString(), null, null, 12);     // Catch: Throwable -> L21
    L19:
        monitor-exit(this);
        return;
    L12:
        r108 = null;
        goto L13
    L14:
        LruCache r109 = new LruCache(r102.f40715g);     // Catch: Throwable -> L21
        r109.put(r101, r102);     // Catch: Throwable -> L21
        HybridLogger r110 = HybridLogger.f246343a;     // Catch: Throwable -> L21
        StringBuilder r111 = new StringBuilder("AnnieXLynxEngine Count, bid: ");     // Catch: Throwable -> L21
        r111.append(r100);     // Catch: Throwable -> L21
        r111.append(", count: ");     // Catch: Throwable -> L21
        LruCache r112 = (LruCache) b().get(r100);     // Catch: Throwable -> L21
        if (r112 == null) goto L17;
        Integer r113 = Integer.valueOf(r112.size());     // Catch: Throwable -> L21
    L18:
        r111.append(r113);     // Catch: Throwable -> L21
        HybridLogger.m("AnnieXLynxEngineManager", r111.toString(), null, null, 12);     // Catch: Throwable -> L21
        b().put(r100, r109);     // Catch: Throwable -> L21
        goto L19
    L17:
        r113 = null;
    L21:
        th = move-exception;
        throw th;
    }
}
