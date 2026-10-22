package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.util.LruCache;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, a> f131491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetsService f131492b;

    public static final class a extends LruCache<Long, Pair<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f131493a;

        public a(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final void trimToSize(int r100) {
            int r101 = size();
            int r102 = r101 - this.f131493a;
            Set<Map.Entry<Long, Pair<? extends Integer, ? extends String>>> r103 = snapshot().entrySet();
            Map.Entry r104 = null;
            if ((!r103.isEmpty()) == true) goto L6;
            r103 = null;
        L6:
            if (r103 == null) goto L8;
            r104 = (Map.Entry) CollectionsKt.last(r103);
        L8:
            if (r104 == null) goto L14;
            Pair r105 = (Pair) r104.getValue();
            if (r105 == null) goto L14;
            Integer r106 = (Integer) r105.getFirst();
            if (r106 == null) goto L14;
            int r107 = r106.intValue();
        L15:
            if (r102 >= r107) goto L18;
            r102 = r107 + 1;
        L18:
            if (r104 == null) goto L20;
            Long r108 = (Long) r104.getKey();
        L20:
            if (r101 <= r100) goto L24;
            if (r102 > r100) goto L24;
            super.trimToSize(r102);
            return;
        L24:
            super.trimToSize(r100);
            return;
        L14:
            r107 = 0;
            goto L15
        }

        @Override // android.util.LruCache
        public final int sizeOf(Long r100, Pair<? extends Integer, ? extends String> r101) {
            r100.longValue();
            Pair<? extends Integer, ? extends String> r102 = r101;
            Intrinsics.checkNotNullParameter(r102, "value");
            return r102.getFirst().intValue();
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, Long r101, Pair<? extends Integer, ? extends String> r102, Pair<? extends Integer, ? extends String> r103) {
            Long r104 = r101;
            Pair<? extends Integer, ? extends String> r105 = r102;
            if (r105 == null) goto L9;
            if (r100 == false) goto L8;
            Single.create(new c(this, r105, r104)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
            return;
        L8:
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131491a.clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.c().isEmpty() == false) goto L5;
        return;
    L5:
        Single.create(new f(this)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
    }

    public d(AssetsService r100) {
        Intrinsics.checkNotNullParameter(r100, "assetsService");
        this.f131492b = r100;
        this.f131491a = new HashMap();
    }

    public static final void a(d r100) {
        HashMap<String, a> r101 = r100.f131491a;
        monitor-enter(r101);
        HashMap r102 = new HashMap();     // Catch: Throwable -> L15
        Iterator<Map.Entry<String, a>> r103 = r100.f131491a.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L12;
        Map.Entry<String, a> r104 = r103.next();     // Catch: Throwable -> L15
        String r105 = r104.getKey();     // Catch: Throwable -> L15
        Map<Long, Pair<? extends Integer, ? extends String>> r106 = r104.getValue().snapshot();     // Catch: Throwable -> L15
        if (r106 == null) goto L11;
        r102.put(r105, (LinkedHashMap) r106);     // Catch: Throwable -> L15
        goto L6
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.util.LinkedHashMap<kotlin.Long!, kotlin.Pair<kotlin.Int, kotlin.String>!>");     // Catch: Throwable -> L15
    L12:
        KProperty[] r107 = ay1.b.f16675a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r102, "<set-?>");     // Catch: Throwable -> L15
        ay1.b.f16714t0.setValue(null, ay1.b.f16675a[86], r102);     // Catch: Throwable -> L15
        r100.c("writeToDisk");     // Catch: Throwable -> L15
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r101);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void c(String r100) {
        Iterator<Map.Entry<String, a>> r101 = this.f131491a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, a> r102 = r101.next();
        String r103 = r102.getKey();
        Objects.toString(r102.getValue().snapshot());
        r102.getValue().size();
        goto L4
    }
}
