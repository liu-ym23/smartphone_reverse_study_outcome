package com.bytedance.android.annie.ng;

import android.app.Application;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f39669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f39670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f39671c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f39672d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.android.annie.card.e f39673e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f39674f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f39675g;

    static {
        f39671c = new ConcurrentHashMap();
        f39672d = new ConcurrentHashMap();
        f39673e = new com.bytedance.android.annie.card.e();
        f39674f = Collections.synchronizedList(CollectionsKt.mutableListOf(new String[]{"host", "webcast", "default"}));
    }

    public static final Application a() {
        Application r100 = f39669a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mApplication");
        return null;
    }

    public static final d b() {
        d r100 = f39670b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mGlobalConfig");
        return null;
    }

    public static void d(String r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "moduleKey");
        Intrinsics.checkNotNullParameter(r101, "initGlobalConfigCallBack");
        Map<String, j> r102 = i.f39677b;
        monitor-enter(r102);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((LinkedHashMap) r102).get(r100) != null) goto L7;
        r102.put(r100, r101);     // Catch: Throwable -> L10
    L7:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r102);
    }

    public static void c(String r100, String r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bizKey");
        Intrinsics.checkNotNullParameter(r101, "moduleKey");
        Intrinsics.checkNotNullParameter(r102, "initBizConfigCallBack");
        Map<String, Map<String, h>> r103 = i.f39676a;
        monitor-enter(r103);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (((LinkedHashMap) r103).get(r100) != null) goto L7;
        r103.put(r100, new LinkedHashMap());     // Catch: Throwable -> L13
    L7:
        Object r104 = ((LinkedHashMap) r103).get(r100);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L13
        if (((Map) r104).get(r101) != null) goto L10;
        Object r105 = ((LinkedHashMap) r103).get(r100);     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L13
        ((Map) r105).put(r101, r102);     // Catch: Throwable -> L13
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r103);
    }
}
