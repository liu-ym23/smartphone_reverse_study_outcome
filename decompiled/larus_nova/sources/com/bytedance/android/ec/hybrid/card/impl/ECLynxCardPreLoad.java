package com.bytedance.android.ec.hybrid.card.impl;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class ECLynxCardPreLoad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f46513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f46514b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r.a f46515c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f46516d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SoftReference<Map<String, List<com.bytedance.android.ec.hybrid.card.cache.template.e>>> f46517e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArraySet<Integer>> f46518f = null;

    static {
        f46513a = LazyKt.lazy(ECLynxCardPreLoad$releaseTemplateCacheEnabled$2.INSTANCE);
        f46514b = new Object();
        f46515c = r.a.f47516b;
        f46516d = new ArrayList();
        f46517e = new SoftReference(new LinkedHashMap());
        f46518f = new LinkedHashMap();
    }

    public static void a() {
        Object r100 = f46514b;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((Boolean) f46513a.getValue()).booleanValue() == false) goto L7;
        b();     // Catch: Throwable -> L10
    L7:
        f46517e.clear();     // Catch: Throwable -> L10
        ((ArrayList) f46516d).clear();     // Catch: Throwable -> L10
        ((LinkedHashMap) f46518f).clear();     // Catch: Throwable -> L10
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
    }

    public static void b() {
        Map<String, List<com.bytedance.android.ec.hybrid.card.cache.template.e>> r100 = f46517e.get();
        int r101 = 0;
        if (r100 == null) goto L10;
        Collection<List<com.bytedance.android.ec.hybrid.card.cache.template.e>> r102 = r100.values();
        if (r102 == null) goto L10;
        Iterator<T> r103 = r102.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L11;
        r104 = r104 + ((List) r103.next()).size();
    L11:
        Lazy r105 = ECMallLogUtil.f47441a;
        r.a r106 = f46515c;
        StringBuilder r107 = new StringBuilder("releaseCachedTemplates, strongRefPoolAlive=");
        r107.append(false);
        r107.append(", strongRefKeyCount=");
        r107.append(0);
        r107.append(", strongRefCacheCount=");
        r107.append(0);
        r107.append(", softRefPoolAlive=");
        if (r100 == null) goto L14;
        boolean r108 = true;
    L15:
        r107.append(r108);
        r107.append(", softRefKeyCount=");
        if (r100 == null) goto L18;
        r101 = r100.size();
    L18:
        r107.append(r101);
        r107.append(", softRefCacheCount=");
        r107.append(r104);
        ECMallLogUtil.c(r106, r107.toString());
        return;
    L14:
        r108 = false;
    L10:
        r104 = 0;
        goto L11
    }
}
