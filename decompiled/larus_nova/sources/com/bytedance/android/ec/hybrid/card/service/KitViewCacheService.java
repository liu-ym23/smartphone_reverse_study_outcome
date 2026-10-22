package com.bytedance.android.ec.hybrid.card.service;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.lynx.hybrid.base.IKitView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class KitViewCacheService implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f46575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f46576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, CopyOnWriteArraySet<Integer>> f46577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f46578d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/service/KitViewCacheService$PageCacheCleaner;", "Landroidx/lifecycle/LifecycleObserver;", "", "clear", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PageCacheCleaner implements LifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f46579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KitViewCacheService f46580b;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void clear() {
            KitViewCacheService r100 = this.f46580b;
            String r101 = this.f46579a;
            a r102 = r100.f46576b.remove(r101);
            if (r102 == null) goto L6;
            r102.a();
            return;
        }

        public PageCacheCleaner(KitViewCacheService r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "holderKey");
            this.f46580b = r100;
            this.f46579a = r101;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, CopyOnWriteArrayList<com.bytedance.android.ec.hybrid.card.api.a>> f46581a;

        public final void a() {
            Iterator<Map.Entry<String, CopyOnWriteArrayList<com.bytedance.android.ec.hybrid.card.api.a>>> r100 = this.f46581a.entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            Iterator<T> r101 = r100.next().getValue().iterator();
        L7:
            if (r101.hasNext() == false) goto L4;
            IKitView.DefaultImpls.destroy$default(((com.bytedance.android.ec.hybrid.card.api.a) r101.next()).f46363a, false, 1, null);
            goto L7
        L9:
            this.f46581a.clear();
        }

        public a() {
            this.f46581a = new ConcurrentHashMap();
        }

        public final com.bytedance.android.ec.hybrid.card.api.a b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            CopyOnWriteArrayList<com.bytedance.android.ec.hybrid.card.api.a> r101 = this.f46581a.get(r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if ((!r101.isEmpty()) == true) goto L8;
            r101 = null;
        L8:
            if (r101 != null) goto L10;
            return null;
        L10:
            return r101.remove(0);
        }
    }

    public KitViewCacheService() {
        this.f46575a = new a();
        this.f46576b = new ConcurrentHashMap();
        this.f46577c = new LinkedHashMap();
        this.f46578d = new Object();
    }

    @Override // com.bytedance.android.ec.hybrid.card.service.e
    public final com.bytedance.android.ec.hybrid.card.api.a b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        return this.f46575a.b(r100);
    }

    @Override // com.bytedance.android.ec.hybrid.card.service.e
    public final CopyOnWriteArraySet<Integer> d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Object r101 = this.f46578d;
        monitor-enter(r101);
        CopyOnWriteArraySet<Integer> r102 = (CopyOnWriteArraySet) ((LinkedHashMap) this.f46577c).get(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static String e(Context r100, String r101) {
        Activity r102 = ECHybridExtensionsKt.a(r100);
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.hashCode());
    L7:
        return String.valueOf(r103) + '_' + r101;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.ec.hybrid.card.service.e
    public final void c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        String r102 = e(r100, r101);
        a r103 = this.f46576b.remove(r102);
        if (r103 == null) goto L6;
        r103.a();
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.card.service.e
    public final com.bytedance.android.ec.hybrid.card.api.a a(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "schema");
        a r103 = this.f46576b.get(e(r100, r101));
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.b(r102);
    }

    public final void f(Context r100, String r101, String r102, com.bytedance.android.ec.hybrid.card.api.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "cache");
        String r104 = e(r100, r101);
        a r105 = this.f46576b.get(r104);
        if (r105 != null) goto L12;
        r105 = new a();
        this.f46576b.put(r104, r105);
        ComponentCallbacks2 r106 = ECHybridExtensionsKt.a(r100);
        if ((r106 instanceof LifecycleOwner) == true) goto L7;
        r106 = null;
    L7:
        LifecycleOwner r107 = (LifecycleOwner) r106;
        if (r107 == null) goto L12;
        Lifecycle r108 = r107.getLifecycle();
        if (r108 == null) goto L12;
        r108.addObserver(new PageCacheCleaner(this, r104));
    L12:
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "cache");
        CopyOnWriteArrayList<com.bytedance.android.ec.hybrid.card.api.a> r109 = r105.f46581a.get(r102);
        if (r109 != null) goto L15;
        r109 = new CopyOnWriteArrayList();
        r105.f46581a.put(r102, r109);
    L15:
        r109.add(r103);
        Object r110 = this.f46578d;
        monitor-enter(r110);
    L25:
        th = move-exception;
        throw th;
    L18:
        if (this.f46577c.containsKey(r101) == false) goto L22;
        CopyOnWriteArraySet r111 = (CopyOnWriteArraySet) ((LinkedHashMap) this.f46577c).get(r101);     // Catch: Throwable -> L25
        if (r111 == null) goto L23;
        r111.add(Integer.valueOf(r103.f46374l));     // Catch: Throwable -> L25
    L23:
        monitor-exit(r110);
        return;
    L22:
        Map<String, CopyOnWriteArraySet<Integer>> r112 = this.f46577c;     // Catch: Throwable -> L25
        CopyOnWriteArraySet<Integer> r113 = new CopyOnWriteArraySet();     // Catch: Throwable -> L25
        r113.add(Integer.valueOf(r103.f46374l));     // Catch: Throwable -> L25
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r112.put(r101, r113);     // Catch: Throwable -> L25
        goto L23
    }
}
