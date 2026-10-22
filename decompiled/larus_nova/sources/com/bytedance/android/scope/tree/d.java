package com.bytedance.android.scope.tree;

import com.bytedance.android.scope.ServiceContainer;
import com.bytedance.android.scope.e;
import com.bytedance.android.scope.f;
import com.bytedance.android.scope.g;
import com.bytedance.android.scope.i;
import com.bytedance.android.scope.j;
import com.bytedance.android.scope.o;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import e33.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends com.bytedance.android.scope.tree.a implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<com.bytedance.android.scope.tree.a> f163465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet<com.bytedance.android.scope.tree.a> f163466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ServiceContainer f163467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f163468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d> f163469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<d> f163470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j f163471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final KClass<?> f163472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d f163473l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Unit> f163474m;

    public final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f163475a;

        public a(d r100) {
            this.f163475a = r100;
        }

        @Override // com.bytedance.android.scope.e
        public final <T> T b(KClass<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "objType");
            j r101 = this.f163475a.f163471j;
            Intrinsics.checkNotNullParameter(r101, "scopeInstance");
            Intrinsics.checkNotNullParameter(r100, "scopeType");
            if (r100.isInstance(r101) == false) goto L9;
            T r102 = (T) this.f163475a.f163471j;
            if (r102 == null) goto L8;
            return r102;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type T");
        L9:
            Iterator<T> r103 = this.f163475a.f163469h.iterator();
        L11:
            if (r103.hasNext() == false) goto L15;
            T r104 = (T) ((d) r103.next()).b(r100);
            if (r104 == null) goto L11;
            return r104;
        L15:
            d r105 = this.f163475a.f163473l;
            if (r105 == null) goto L20;
            T r106 = (T) r105.b(r100);
            if (r106 == null) goto L20;
            return r106;
        L20:
            Iterator<T> r107 = this.f163475a.f163470i.iterator();
        L22:
            if (r107.hasNext() == false) goto L26;
            T r108 = (T) ((d) r107.next()).b(r100);
            if (r108 == null) goto L22;
            return r108;
        L26:
            return null;
        }

        @Override // com.bytedance.android.scope.e
        public final <T> T d(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "objKey");
            Iterator<T> r101 = this.f163475a.f163469h.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            T r102 = (T) ((d) r101.next()).d(r100);
            if (r102 == null) goto L4;
            return r102;
        L8:
            d r103 = this.f163475a.f163473l;
            if (r103 == null) goto L13;
            T r104 = (T) r103.d(r100);
            if (r104 == null) goto L13;
            return r104;
        L13:
            Iterator<T> r105 = this.f163475a.f163470i.iterator();
        L15:
            if (r105.hasNext() == false) goto L19;
            T r106 = (T) ((d) r105.next()).d(r100);
            if (r106 == null) goto L15;
            return r106;
        L19:
            return null;
        }

        @Override // com.bytedance.android.scope.e
        public final <T> void a(KClass<T> r100, Collection<? super T> r101) {
            Intrinsics.checkNotNullParameter(r100, "objType");
            Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_OUTPUT);
            Iterator r102 = ((ArrayList) this.f163475a.f163469h).iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((d) r102.next()).a(r100, r101);
            goto L4
        L6:
            d r103 = this.f163475a.f163473l;
            if (r103 == null) goto L9;
            r103.a(r100, r101);
        L9:
            Iterator r104 = ((ArrayList) this.f163475a.f163470i).iterator();
        L11:
            if (r104.hasNext() == false) goto L13;
            ((d) r104.next()).a(r100, r101);
            goto L11
        }
    }

    @Override // com.bytedance.android.scope.tree.a
    public final void f() {
        LinkedHashSet<com.bytedance.android.scope.tree.a> r100 = this.f163465d;
        if (r100.isEmpty() == true) goto L8;
        Iterator r101 = CollectionsKt.asReversedMutable(CollectionsKt.toMutableList(r100)).iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((com.bytedance.android.scope.tree.a) r101.next()).e();
    L8:
        LinkedHashSet<com.bytedance.android.scope.tree.a> r102 = this.f163466e;
        if (r102.isEmpty() == true) goto L15;
        Iterator r103 = CollectionsKt.asReversedMutable(CollectionsKt.toMutableList(r102)).iterator();
    L12:
        if (r103.hasNext() == false) goto L15;
        ((com.bytedance.android.scope.tree.a) r103.next()).e();
    L15:
        if ((!this.f163465d.isEmpty()) == true) goto L51;
        if ((!this.f163466e.isEmpty()) == true) goto L49;
        this.f163465d.clear();
        this.f163466e.clear();
        ((ArrayList) this.f163469h).clear();
        ((ArrayList) this.f163470i).clear();
        ServiceContainer r104 = this.f163467f;
        ReentrantReadWriteLock r105 = r104.f163412g;
        ReentrantReadWriteLock.ReadLock r106 = r105.readLock();
        int r107 = 0;
        if (r105.getWriteHoldCount() != 0) goto L21;
        int r108 = r105.getReadHoldCount();
    L22:
        int r109 = 0;
    L23:
        if (r109 >= r108) goto L25;
        r106.unlock();
        r109 = r109 + 1;
        goto L23
    L25:
        ReentrantReadWriteLock.WriteLock r110 = r105.writeLock();
        r110.lock();
        Iterator r111 = CollectionsKt.asReversedMutable(r104.f163409d).iterator();     // Catch: Throwable -> L43
    L28:
        if (r111.hasNext() == false) goto L38;
        ServiceContainer.ServiceState r112 = (ServiceContainer.ServiceState) r111.next();     // Catch: Throwable -> L43
        o r113 = r112.f163415b;     // Catch: Throwable -> L43
        if (r112.f163414a != ServiceContainer.ServiceState.State.STARTED) goto L32;
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L43
        r113.onStop();     // Catch: Throwable -> L43
    L32:
        r112.f163414a = ServiceContainer.ServiceState.State.STOPPED;     // Catch: Throwable -> L43
        r112.f163415b = null;     // Catch: Throwable -> L43
        r112.f163416c = null;     // Catch: Throwable -> L43
        if (r113 == null) goto L28;
        Iterator r114 = ((ArrayList) r104.f163410e.f163421c).iterator();     // Catch: Throwable -> L43
    L36:
        if (r114.hasNext() == false) goto L28;
        ((f) r114.next()).k(r104.f163413h, r113, r112.f163417d);     // Catch: Throwable -> L43
        goto L36
    L38:
        ((ArrayList) r104.f163409d).clear();     // Catch: Throwable -> L43
        ServiceContainer.b r115 = r104.f163410e;     // Catch: Throwable -> L43
        ((ArrayList) r115.f163420b).clear();     // Catch: Throwable -> L43
        ((ArrayList) r115.f163421c).clear();     // Catch: Throwable -> L43
        ((HashMap) r104.f163407b).clear();     // Catch: Throwable -> L43
        r104.f163408c.f470906a.clear();     // Catch: Throwable -> L43
        ((HashMap) r104.f163406a).clear();     // Catch: Throwable -> L43
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L43
    L39:
        if (r107 >= r108) goto L41;
        r106.lock();
        r107 = r107 + 1;
        goto L39
    L41:
        r110.unlock();
        this.f163474m.invoke();
        return;
    L43:
        th = move-exception;
    L44:
        if (r107 >= r108) goto L46;
        r106.lock();
        r107 = r107 + 1;
        goto L44
    L46:
        r110.unlock();
        throw th;
    L21:
        r108 = 0;
        goto L22
    L49:
        throw new IllegalStateException("Shadow children is not empty");
    L51:
        throw new IllegalStateException("Children is not empty");
    }

    public final String toString() {
        return "ScopeNode(" + this.f163471j + ')';
    }

    @Override // com.bytedance.android.scope.e
    public final <T> T b(KClass<T> r110) {
        Intrinsics.checkNotNullParameter(r110, "objType");
        ServiceContainer r100 = this.f163467f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "objType");
        ReentrantReadWriteLock.ReadLock r101 = r100.f163412g.readLock();
        r101.lock();
        l r102 = (l) r100.f163408c.get(r110);     // Catch: Throwable -> L52
        if (r102 != null) goto L6;
        r101.unlock();
    L9:
        T r103 = null;
    L44:
        if (r103 == null) goto L47;
        return r103;
    L47:
        return (T) this.f163468g.b(r110);
    L6:
        ServiceContainer.ServiceState r104 = (ServiceContainer.ServiceState) ((HashMap) r100.f163407b).get(r102.f470909a);     // Catch: Throwable -> L52
        if (r104 != null) goto L10;
        r101.unlock();
        goto L9
    L10:
        o r105 = r104.f163415b;     // Catch: Throwable -> L52
        if (r105 == null) goto L13;
        r101.unlock();
        r103 = (T) r105;
        goto L44
    L13:
        ReentrantReadWriteLock r106 = r100.f163412g;     // Catch: Throwable -> L52
        ReentrantReadWriteLock.ReadLock r107 = r106.readLock();     // Catch: Throwable -> L52
        int r108 = 0;
        if (r106.getWriteHoldCount() != 0) goto L16;
        int r109 = r106.getReadHoldCount();     // Catch: Throwable -> L52
    L17:
        int r111 = 0;
    L18:
        if (r111 >= r109) goto L20;
        r107.unlock();     // Catch: Throwable -> L52
        r111 = r111 + 1;     // Catch: Throwable -> L52
        goto L18
    L20:
        ReentrantReadWriteLock.WriteLock r112 = r106.writeLock();     // Catch: Throwable -> L52
        r112.lock();     // Catch: Throwable -> L52
    L32:
        th = move-exception;
    L48:
        if (r108 >= r109) goto L50;
        r107.lock();     // Catch: Throwable -> L52
        r108 = r108 + 1;     // Catch: Throwable -> L52
        goto L48
    L50:
        r112.unlock();     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L22:
        if (r100.f163411f == true) goto L24;
    L26:
        boolean r113 = false;
    L27:
        if (r113 == false) goto L34;
        int r114 = f33.c.f475382a;     // Catch: Throwable -> L32
        System.nanoTime();     // Catch: Throwable -> L32
        if (r100.f163410e.d() == false) goto L34;
        ServiceContainer.c r115 = new ServiceContainer.c("launch_postponed_services_begin");     // Catch: Throwable -> L32
        ServiceContainer.a(r100, r115);     // Catch: Throwable -> L32
        r100.f163410e.b(r115);     // Catch: Throwable -> L32
    L34:
        o r116 = r104.b();     // Catch: Throwable -> L32
        if (r113 == false) goto L40;
        int r117 = f33.c.f475382a;     // Catch: Throwable -> L32
        System.nanoTime();     // Catch: Throwable -> L32
        if (r100.f163410e.d() == false) goto L40;
        ServiceContainer.c r118 = new ServiceContainer.c("launch_postponed_services_end");     // Catch: Throwable -> L32
        ServiceContainer.a(r100, r118);     // Catch: Throwable -> L32
        r100.f163410e.b(r118);     // Catch: Throwable -> L32
    L40:
        if (r108 >= r109) goto L42;
        r107.lock();     // Catch: Throwable -> L52
        r108 = r108 + 1;     // Catch: Throwable -> L52
        goto L40
    L42:
        r112.unlock();     // Catch: Throwable -> L52
        r101.unlock();
        r103 = (T) r116;
        goto L44
    L24:
        if (r100.f163410e.d() == false) goto L26;
        r113 = true;
        goto L27
    L16:
        r109 = 0;
    L52:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // com.bytedance.android.scope.e
    public final <T> T d(Object r110) {
        Intrinsics.checkNotNullParameter(r110, "objKey");
        ServiceContainer r100 = this.f163467f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "objKey");
        ReentrantReadWriteLock.ReadLock r101 = r100.f163412g.readLock();
        r101.lock();
    L52:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (((l) ((HashMap) r100.f163406a).get(r110)) != null) goto L6;
        r101.unlock();
    L9:
        T r102 = null;
    L44:
        if (r102 == null) goto L47;
        return r102;
    L47:
        return (T) this.f163468g.d(r110);
    L6:
        ServiceContainer.ServiceState r103 = (ServiceContainer.ServiceState) ((HashMap) r100.f163407b).get(r110);     // Catch: Throwable -> L52
        if (r103 != null) goto L10;
        r101.unlock();
        goto L9
    L10:
        o r104 = r103.f163415b;     // Catch: Throwable -> L52
        if (r104 == null) goto L13;
        r101.unlock();
        r102 = (T) r104;
        goto L44
    L13:
        ReentrantReadWriteLock r105 = r100.f163412g;     // Catch: Throwable -> L52
        ReentrantReadWriteLock.ReadLock r106 = r105.readLock();     // Catch: Throwable -> L52
        int r107 = 0;
        if (r105.getWriteHoldCount() != 0) goto L16;
        int r108 = r105.getReadHoldCount();     // Catch: Throwable -> L52
    L17:
        int r109 = 0;
    L18:
        if (r109 >= r108) goto L20;
        r106.unlock();     // Catch: Throwable -> L52
        r109 = r109 + 1;     // Catch: Throwable -> L52
        goto L18
    L20:
        ReentrantReadWriteLock.WriteLock r111 = r105.writeLock();     // Catch: Throwable -> L52
        r111.lock();     // Catch: Throwable -> L52
    L32:
        th = move-exception;
    L48:
        if (r107 >= r108) goto L50;
        r106.lock();     // Catch: Throwable -> L52
        r107 = r107 + 1;     // Catch: Throwable -> L52
        goto L48
    L50:
        r111.unlock();     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L22:
        if (r100.f163411f == true) goto L24;
    L26:
        boolean r112 = false;
    L27:
        if (r112 == false) goto L34;
        int r113 = f33.c.f475382a;     // Catch: Throwable -> L32
        System.nanoTime();     // Catch: Throwable -> L32
        if (r100.f163410e.d() == false) goto L34;
        ServiceContainer.c r114 = new ServiceContainer.c("launch_postponed_services_begin");     // Catch: Throwable -> L32
        ServiceContainer.a(r100, r114);     // Catch: Throwable -> L32
        r100.f163410e.b(r114);     // Catch: Throwable -> L32
    L34:
        o r115 = r103.b();     // Catch: Throwable -> L32
        if (r112 == false) goto L40;
        int r116 = f33.c.f475382a;     // Catch: Throwable -> L32
        System.nanoTime();     // Catch: Throwable -> L32
        if (r100.f163410e.d() == false) goto L40;
        ServiceContainer.c r117 = new ServiceContainer.c("launch_postponed_services_end");     // Catch: Throwable -> L32
        ServiceContainer.a(r100, r117);     // Catch: Throwable -> L32
        r100.f163410e.b(r117);     // Catch: Throwable -> L32
    L40:
        if (r107 >= r108) goto L42;
        r106.lock();     // Catch: Throwable -> L52
        r107 = r107 + 1;     // Catch: Throwable -> L52
        goto L40
    L42:
        r111.unlock();     // Catch: Throwable -> L52
        r101.unlock();
        r102 = (T) r115;
        goto L44
    L24:
        if (r100.f163410e.d() == false) goto L26;
        r112 = true;
        goto L27
    L16:
        r108 = 0;
        goto L17
    }

    public final void g(Collection<l> r110) {
        Intrinsics.checkNotNullParameter(r110, "serviceDescriptors");
        if (this.f163460a == true) goto L73;
        ServiceContainer r100 = this.f163467f;
        a r101 = this.f163468g;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "serviceDescriptors");
        Intrinsics.checkNotNullParameter(r101, "externalDependencyResolver");
        Collection<l> r111 = r110;
        if (r111.isEmpty() == true) goto L20;
        Iterator<T> r102 = r111.iterator();
    L9:
        if (r102.hasNext() == false) goto L20;
        l r103 = (l) r102.next();
        Intrinsics.checkNotNullParameter(r103, "$this$isPerformanceMonitor");
        KClass r104 = (KClass) CollectionsKt.firstOrNull(r103.f470910b);
        if (r104 == null) goto L17;
        Class r105 = JvmClassMappingKt.getJavaClass(r104);
        if (r105 == null) goto L17;
        if (i.class.isAssignableFrom(r105) != true) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L9;
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
        r100.f163410e.f163424f = true;
    L23:
        int r108 = f33.c.f475382a;
        System.nanoTime();
        if (r100.f163410e.d() == false) goto L27;
        ServiceContainer.c r109 = new ServiceContainer.c("launch_services_begin");
        ServiceContainer.a(r100, r109);
        r100.f163410e.b(r109);
    L27:
        Iterator<T> r112 = r111.iterator();
    L29:
        if (r112.hasNext() == false) goto L35;
        l r113 = (l) r112.next();
        Object r114 = r113.f470909a;
        ((HashMap) r100.f163406a).put(r114, r113);
        Iterator<T> r115 = r113.f470910b.iterator();
    L32:
        if (r115.hasNext() == false) goto L34;
        r100.f163408c.b((KClass) r115.next(), r113);
        goto L32
    L34:
        ((HashMap) r100.f163407b).put(r114, new ServiceContainer.ServiceState(r113));
        goto L29
    L35:
        ServiceContainer.e r116 = new ServiceContainer.e(r100.f163406a, r100.f163408c);
        r116.f163432b = new ServiceContainer.d(r100, r116, r101);
        Iterator r117 = ((HashMap) r100.f163407b).values().iterator();
    L37:
        if (r117.hasNext() == false) goto L43;
        ServiceContainer.ServiceState r118 = (ServiceContainer.ServiceState) r117.next();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r116, "lazyContext");
        ServiceContainer.ServiceState.State r119 = ServiceContainer.ServiceState.State.UNINITIALIZED;
        if (r118.f163414a != r119) goto L42;
        r118.f163416c = r116;
        r118.f163414a = ServiceContainer.ServiceState.State.CONFIGURED;
        goto L37
    L42:
        throw new IllegalStateException("Required state is " + r119 + " but got " + r118.f163414a);
    L43:
        ArrayList r120 = new ArrayList();
        ArrayList r121 = new ArrayList();
        Iterator<T> r122 = r111.iterator();
    L45:
        if (r122.hasNext() == false) goto L59;
        l r123 = (l) r122.next();
        Intrinsics.checkNotNullParameter(r123, "$this$isMetaService");
        KClass r124 = (KClass) CollectionsKt.firstOrNull(r123.f470910b);
        if (r124 == null) goto L53;
        Class r125 = JvmClassMappingKt.getJavaClass(r124);
        if (r125 == null) goto L53;
        if (g.class.isAssignableFrom(r125) != true) goto L53;
        boolean r126 = true;
    L54:
        if (r126 == true) goto L55;
        if ((r123.f470913e & 1) != 0) goto L45;
        r121.add(r123);
        goto L45
    L55:
        r120.add(r123);
    L53:
        r126 = false;
        goto L54
    L59:
        Iterator r127 = r120.iterator();
    L61:
        if (r127.hasNext() == false) goto L63;
        r116.d(((l) r127.next()).f470909a);
        goto L61
    L63:
        ServiceContainer.b r128 = r100.f163410e;
        r128.f163424f = false;
        ((ArrayList) r128.f163423e).clear();
        Iterator r129 = r121.iterator();
    L65:
        if (r129.hasNext() == false) goto L67;
        r116.d(((l) r129.next()).f470909a);
        goto L65
    L67:
        r100.f163411f = true;
        int r130 = f33.c.f475382a;
        System.nanoTime();
        if (r100.f163410e.d() == false) goto L93;
        ServiceContainer.c r131 = new ServiceContainer.c("launch_services_end");
        ServiceContainer.a(r100, r131);
        r100.f163410e.b(r131);
        return;
    L93:
        return;
    L17:
        r106 = false;
    L20:
        r107 = false;
        goto L21
    L73:
        throw new IllegalStateException("Node is destroyed");
    }

    public final Collection<g> h(j r100) {
        Intrinsics.checkNotNullParameter(r100, "childScope");
        ServiceContainer r101 = this.f163467f;
        j r102 = this.f163471j;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "parentScope");
        Intrinsics.checkNotNullParameter(r100, "childScope");
        ServiceContainer.b r103 = r101.f163410e;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "parentScope");
        Intrinsics.checkNotNullParameter(r100, "childScope");
        List<g> r104 = r103.f163419a;
        ArrayList r105 = new ArrayList();
        Iterator r106 = ((ArrayList) r104).iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        Object r107 = r106.next();
        if (((g) r107).c(r102, r100) == false) goto L4;
        r105.add(r107);
        goto L4
    L8:
        return r105;
    }

    @Override // com.bytedance.android.scope.tree.a
    public void onEvent(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof b.a) == false) goto L25;
        ReentrantReadWriteLock r101 = this.f163461b;
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L7;
        int r104 = r101.getReadHoldCount();
    L8:
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L11;
        r102.unlock();
        r105 = r105 + 1;
        goto L9
    L11:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
        this.f163465d.remove(((b.a) r100).f163463a);     // Catch: Throwable -> L15
        this.f163466e.remove(((b.a) r100).f163463a);     // Catch: Throwable -> L15
        if ((((b.a) r100).f163463a instanceof d) == false) goto L17;
        this.f163467f.b(((d) ((b.a) r100).f163463a).f163471j, false);     // Catch: Throwable -> L15
    L17:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L18:
        if (r103 >= r104) goto L20;
        r102.lock();
        r103 = r103 + 1;
        goto L18
    L20:
        r106.unlock();
        return;
    L15:
        th = move-exception;
    L21:
        if (r103 >= r104) goto L23;
        r102.lock();
        r103 = r103 + 1;
        goto L21
    L23:
        r106.unlock();
        throw th;
    L7:
        r104 = 0;
        goto L8
    }

    @Override // com.bytedance.android.scope.e
    public final <T> void a(KClass<T> r110, Collection<? super T> r111) {
        Intrinsics.checkNotNullParameter(r110, "objType");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        ServiceContainer r100 = this.f163467f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "objType");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        ReentrantReadWriteLock r101 = r100.f163412g;
        ReentrantReadWriteLock.ReadLock r102 = r101.readLock();
        int r103 = 0;
        if (r101.getWriteHoldCount() != 0) goto L5;
        int r104 = r101.getReadHoldCount();
    L6:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        r102.unlock();
        r105 = r105 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r106 = r101.writeLock();
        r106.lock();
        Collection r107 = r100.f163408c.a(r110);     // Catch: Throwable -> L26
        if (r107.isEmpty() == false) goto L16;
    L12:
        if (r103 >= r104) goto L14;
        r102.lock();
        r103 = r103 + 1;
        goto L12
    L14:
        r106.unlock();
    L46:
        this.f163468g.a(r110, r111);
        return;
    L16:
        if (r100.f163411f == true) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == false) goto L28;
        int r109 = f33.c.f475382a;     // Catch: Throwable -> L26
        System.nanoTime();     // Catch: Throwable -> L26
        if (r100.f163410e.d() == false) goto L28;
        ServiceContainer.c r112 = new ServiceContainer.c("launch_postponed_services_begin");     // Catch: Throwable -> L26
        ServiceContainer.a(r100, r112);     // Catch: Throwable -> L26
        r100.f163410e.b(r112);     // Catch: Throwable -> L26
    L28:
        Iterator<T> r113 = r107.iterator();     // Catch: Throwable -> L26
    L30:
        if (r113.hasNext() == false) goto L37;
        l r114 = (l) r113.next();     // Catch: Throwable -> L26
        Map<Object, ServiceContainer.ServiceState> r115 = r100.f163407b;     // Catch: Throwable -> L26
        HashMap r116 = (HashMap) r115;     // Catch: Throwable -> L26
        ServiceContainer.ServiceState r117 = (ServiceContainer.ServiceState) r116.get(r114.f470909a);     // Catch: Throwable -> L26
        if (r117 == null) goto L34;
        o r118 = r117.b();     // Catch: Throwable -> L26
    L35:
        if (r118 == null) goto L30;
        ((ArrayList) r111).add(r118);     // Catch: Throwable -> L26
        goto L30
    L34:
        r118 = null;
        goto L35
    L37:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L26
        if (r108 == false) goto L43;
        int r120 = f33.c.f475382a;     // Catch: Throwable -> L26
        System.nanoTime();     // Catch: Throwable -> L26
        if (r100.f163410e.d() == false) goto L43;
        ServiceContainer.c r121 = new ServiceContainer.c("launch_postponed_services_end");     // Catch: Throwable -> L26
        ServiceContainer.a(r100, r121);     // Catch: Throwable -> L26
        r100.f163410e.b(r121);     // Catch: Throwable -> L26
    L43:
        if (r103 >= r104) goto L45;
        r102.lock();
        r103 = r103 + 1;
        goto L43
    L45:
        r106.unlock();
        goto L46
    L18:
        if (r100.f163410e.d() == false) goto L20;
        r108 = true;
    L26:
        th = move-exception;
    L48:
        if (r103 >= r104) goto L50;
        r102.lock();
        r103 = r103 + 1;
        goto L48
    L50:
        r106.unlock();
        throw th;
    L5:
        r104 = 0;
        goto L6
    }

    public d(j r100, KClass<?> r101, d r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "scopeType");
        Intrinsics.checkNotNullParameter(r103, "doAfterDestroy");
        this.f163471j = r100;
        this.f163472k = r101;
        this.f163473l = r102;
        this.f163474m = r103;
        this.f163465d = new LinkedHashSet();
        this.f163466e = new LinkedHashSet();
        this.f163467f = new ServiceContainer(this.f163461b, r100);
        this.f163468g = new a(this);
        this.f163469h = new ArrayList();
        this.f163470i = new ArrayList();
    }
}
