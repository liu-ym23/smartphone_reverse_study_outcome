package com.bytedance.android.anya;

import com.bytedance.android.anya.BaseMVIDataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BaseMVIDataStore<STORE extends BaseMVIDataStore<STORE>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f41528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function2<Map<Object, ? extends j<?>>, lb.e, Unit>> f41529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f0> f41530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Object, Object> f41531d;

    public boolean f() {
        return false;
    }

    public BaseMVIDataStore() {
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock(false);
        r100.readLock();
        this.f41528a = r100.writeLock();
        this.f41529b = new ArrayList();
        this.f41530c = new ArrayList();
        this.f41531d = new ConcurrentHashMap();
    }

    public final com.bytedance.android.anya.internal.g i(Object r100) {
        return new com.bytedance.android.anya.internal.g(new com.bytedance.android.anya.internal.n(this, r100, true));
    }

    public final com.bytedance.android.anya.internal.g j(Object r100) {
        return new com.bytedance.android.anya.internal.g(new com.bytedance.android.anya.internal.n(this, r100, false));
    }

    public final void d(final Object r110, final Map<Object, ? extends j<?>> r111) {
        if (f() == true) goto L9;
        Iterator r100 = ((ArrayList) this.f41530c).iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        final f0 r101 = (f0) r100.next();
        r101.f41609a.R(new BaseMVIDataStore$commitChangesToExecutor$$inlined$forEach$lambda$1(r101, r110, r111));
        goto L6
    L8:
        return;
    L9:
        List<f0> r102 = this.f41530c;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = ((ArrayList) r102).iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        r103.add(((f0) r104.next()).f41609a);
        goto L11
    L13:
        Iterator r105 = CollectionsKt.toSet(r103).iterator();
    L15:
        if (r105.hasNext() == false) goto L27;
        com.bytedance.android.anya.internal.b r106 = (com.bytedance.android.anya.internal.b) r105.next();
        r106.getClass();
        final com.bytedance.android.anya.internal.b.c r107 = new com.bytedance.android.anya.internal.b.c(r106);
        List<f0> r108 = this.f41530c;
        ArrayList r109 = new ArrayList();
        Iterator r112 = ((ArrayList) r108).iterator();
    L18:
        if (r112.hasNext() == false) goto L22;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((f0) r113).f41609a, r106) == false) goto L18;
        r109.add(r113);
        goto L18
    L22:
        Iterator r114 = r109.iterator();
    L24:
        if (r114.hasNext() == false) goto L26;
        final f0 r115 = (f0) r114.next();
        Function0<Unit> r116 = new BaseMVIDataStore$commitChangesToExecutor$$inlined$forEach$lambda$2(r115, r107, this, r110, r111);
        r107.f41661a.add(r116);
        r107.f41662b = r115.f41611c;
        goto L24
    L26:
        r107.a();
        goto L15
    }

    public final void g(Object r110, Function1<? super n<STORE>, Unit> r111) {
        com.bytedance.android.anya.internal.f r100 = new com.bytedance.android.anya.internal.f();
        Lock r101 = this.f41528a;
        r101.lock();
        mb.c r102 = mb.a.f512756a;     // Catch: Throwable -> L6
        String r103 = "mutateExternal source=" + r110;     // Catch: Throwable -> L6
        mb.c r104 = mb.a.f512756a;     // Catch: Throwable -> L6
        if (r104 == null) goto L8;
        r104.logD("ttlive_anya_ds", r103);     // Catch: Throwable -> L6
    L8:
        r111.invoke(r100);     // Catch: Throwable -> L6
        r100.f41690b = true;     // Catch: Throwable -> L33
        Map<com.bytedance.android.anya.internal.n<?, ?>, Object> r112 = r100.f41689a;     // Catch: Throwable -> L33
        LinkedHashMap r105 = new LinkedHashMap(MapsKt.mapCapacity(r112.size()));     // Catch: Throwable -> L33
        Iterator r113 = ((LinkedHashMap) r112).entrySet().iterator();     // Catch: Throwable -> L33
    L11:
        if (r113.hasNext() == false) goto L14;
        Object r106 = r113.next();     // Catch: Throwable -> L33
        Object r107 = ((Map.Entry) r106).getKey();     // Catch: Throwable -> L33
        Map.Entry r108 = (Map.Entry) r106;     // Catch: Throwable -> L33
        r105.put(r107, new j(r108.getValue(), ((com.bytedance.android.anya.internal.n) r108.getKey()).a(), true));     // Catch: Throwable -> L33
        goto L11
    L14:
        if (q0.f41751f == true) goto L17;
        d(r110, r105);     // Catch: Throwable -> L33
        r105 = null;
    L17:
        ((LinkedHashMap) r100.f41689a).clear();     // Catch: Throwable -> L33
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r101.unlock();
        if (q0.f41751f == false) goto L40;
        if (r105 == null) goto L41;
        d(r110, r105);
        return;
    L41:
        return;
    L40:
        return;
    L6:
        th = move-exception;
        r100.f41690b = true;     // Catch: Throwable -> L33
        Map<com.bytedance.android.anya.internal.n<?, ?>, Object> r109 = r100.f41689a;     // Catch: Throwable -> L33
        LinkedHashMap r115 = new LinkedHashMap(MapsKt.mapCapacity(r109.size()));     // Catch: Throwable -> L33
        Iterator r116 = ((LinkedHashMap) r109).entrySet().iterator();     // Catch: Throwable -> L33
    L25:
        if (r116.hasNext() == false) goto L28;
        Object r117 = r116.next();     // Catch: Throwable -> L33
        Object r118 = ((Map.Entry) r117).getKey();     // Catch: Throwable -> L33
        Map.Entry r119 = (Map.Entry) r117;     // Catch: Throwable -> L33
        r115.put(r118, new j(r119.getValue(), ((com.bytedance.android.anya.internal.n) r119.getKey()).a(), true));     // Catch: Throwable -> L33
        goto L25
    L28:
        if (q0.f41751f == true) goto L31;
        d(r110, r115);     // Catch: Throwable -> L33
    L31:
        ((LinkedHashMap) r100.f41689a).clear();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
