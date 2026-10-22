package com.bytedance.android.bcm.impl2;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import pc.f;
import pc.g;

/* JADX INFO: loaded from: classes43.dex */
public final class ScopedBcmConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f41881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f41882b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f41883c = null;

    static {
        f41881a = LazyKt.lazy(ScopedBcmConfigManager$scopeConfigMap$2.INSTANCE);
        f41882b = LazyKt.lazy(ScopedBcmConfigManager$eventConfigMap$2.INSTANCE);
        f41883c = LazyKt.lazy(ScopedBcmConfigManager$cache$2.INSTANCE);
    }

    public static void a(final String r100, final f r101) {
        ((ConcurrentHashMap) f41881a.getValue()).put(r100, r101);
        Lazy r102 = f41882b;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102.getValue();
        monitor-enter(r103);
        Iterator r104 = ((ConcurrentHashMap) r102.getValue()).entrySet().iterator();     // Catch: Throwable -> L21
    L6:
        if (r104.hasNext() == false) goto L8;
        final CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) ((Map.Entry) r104.next()).getValue();     // Catch: Throwable -> L21
        new ScopedBcmConfigManager$setScopeConfig$$inlined$synchronized$lambda$1(r105, r100, r101);     // Catch: Throwable -> L21
        goto L6
    L8:
        Iterator<T> r106 = r101.b().iterator();     // Catch: Throwable -> L21
    L10:
        if (r106.hasNext() == false) goto L18;
        pc.b r107 = (pc.b) r106.next();     // Catch: Throwable -> L21
        ConcurrentHashMap r108 = (ConcurrentHashMap) f41882b.getValue();     // Catch: Throwable -> L21
        String r109 = r107.e();     // Catch: Throwable -> L21
        Object r110 = r108.get(r109);     // Catch: Throwable -> L21
        if (r110 != null) goto L17;
        r110 = new CopyOnWriteArraySet();     // Catch: Throwable -> L21
        Object r111 = r108.putIfAbsent(r109, r110);     // Catch: Throwable -> L21
        if (r111 == null) goto L17;
        r110 = r111;
    L17:
        ((CopyOnWriteArraySet) r110).add(new g(r100, r107));     // Catch: Throwable -> L21
        goto L10
    L18:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r103);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
