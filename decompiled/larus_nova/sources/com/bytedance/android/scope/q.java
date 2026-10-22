package com.bytedance.android.scope;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<? extends j>, LinkedHashMap<Object, e33.l>> f163453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantReadWriteLock f163454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f163455c;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f163456a;

        public a(q r100) {
            this.f163456a = r100;
        }

        public final Map<Object, e33.l> a(KClass<? extends j> r100) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            LinkedHashMap r101 = (LinkedHashMap) ((HashMap) this.f163456a.f163453a).get(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            return MapsKt.emptyMap();
        }
    }

    public final Collection<KClass<? extends j>> a() {
        ReentrantReadWriteLock.ReadLock r100 = this.f163454b.readLock();
        r100.lock();
        List r101 = CollectionsKt.toList(((HashMap) this.f163453a).keySet());     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public q() {
        this.f163453a = new HashMap();
        this.f163454b = new ReentrantReadWriteLock();
        this.f163455c = new a(this);
    }

    public final Collection<e33.l> b(KClass<? extends j> r100) {
        Intrinsics.checkNotNullParameter(r100, "scopeCls");
        ReentrantReadWriteLock.ReadLock r101 = this.f163454b.readLock();
        r101.lock();
        LinkedHashMap r102 = (LinkedHashMap) ((HashMap) this.f163453a).get(r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        Collection r103 = r102.values();     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        List r104 = CollectionsKt.toList(r103);     // Catch: Throwable -> L12
        if (r104 == null) goto L9;
    L10:
        r101.unlock();
        return r104;
    L9:
        r104 = CollectionsKt.emptyList();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
