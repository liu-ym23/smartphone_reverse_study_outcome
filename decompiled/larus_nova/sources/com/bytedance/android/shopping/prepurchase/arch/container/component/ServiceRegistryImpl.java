package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ServiceRegistryImpl implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f180751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f180752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, CompletableDeferred<?>> f180753c;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f180754a = null;

        static {
            f180754a = new a();
        }

        public a() {
        }

        @Override // java.util.function.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((Class) r100, "it");
            return CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
    }

    public ServiceRegistryImpl() {
        this.f180751a = new ConcurrentHashMap();
        this.f180752b = new ArrayList();
        this.f180753c = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<f> r101 = this.f180752b;
        monitor-enter(r101);
        ((ArrayList) this.f180752b).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void b(final T r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        ConcurrentHashMap<Class<?>, Object> r101 = this.f180751a;
        Function1<Map.Entry<? extends Class<?>, ? extends Object>, Boolean> r102 = new ServiceRegistryImpl$unregisterService$1(r100);
        CollectionsKt.removeAll(r101.entrySet(), r102);
        List<f> r103 = this.f180752b;
        monitor-enter(r103);
        Iterator<T> r104 = this.f180752b.iterator();     // Catch: Throwable -> L11
    L6:
        if (r104.hasNext() == false) goto L8;
        ((f) r104.next()).a(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r103);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<f> r101 = this.f180752b;
        monitor-enter(r101);
        ((ArrayList) this.f180752b).add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Object r101 = this.f180751a.get(r100);
        if ((r101 instanceof com.bytedance.android.shopping.prepurchase.arch.container.ability.a) == true) goto L6;
        r101 = null;
    L6:
        return (T) r101;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final j d(String r100, Function0<? extends List<? extends Class<?>>> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        Intrinsics.checkNotNullParameter(r101, "block");
        return new ServiceRegistryDelegate(this, r101, r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> Object e(Class<T> r100, Continuation<? super T> r101) {
        if ((r101 instanceof ServiceRegistryImpl$awaitServiceAvailable$1) == false) goto L7;
        ServiceRegistryImpl$awaitServiceAvailable$1 r102 = (ServiceRegistryImpl$awaitServiceAvailable$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L31:
        if (r104 == null) goto L35;
        return (com.bytedance.android.shopping.prepurchase.arch.container.ability.a) r104;
    L35:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r107 = getService(r100);
        if (r107 == null) goto L17;
        return r107;
    L17:
        monitor-enter(r100);
    L36:
        th = move-exception;
        throw th;
    L19:
        if (Build.VERSION.SDK_INT < 24) goto L21;
        CompletableDeferred<?> r108 = this.f180753c.computeIfAbsent(r100, a.f180754a);     // Catch: Throwable -> L36
    L27:
        monitor-exit(r100);
        r102.label = 1;
        r104 = r108.await(r102);
        if (r104 != r105) goto L31;
        return r105;
    L21:
        r108 = this.f180753c.get(r100);     // Catch: Throwable -> L36
        if (r108 != null) goto L27;
        r108 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L36
        CompletableDeferred<?> r109 = this.f180753c.putIfAbsent(r100, r108);     // Catch: Throwable -> L36
        if (r109 == null) goto L27;
        r108 = r109;
    L7:
        r102 = new ServiceRegistryImpl$awaitServiceAvailable$1(this, r101);
        goto L8
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void f(Class<T> r100, T r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "inst");
        CompletableDeferred<?> r103 = null;
        if (r102 == false) goto L5;
        this.f180751a.put(r100, r101);
    L11:
        monitor-enter(r100);
        CompletableDeferred<?> r104 = this.f180753c.remove(r100);     // Catch: Throwable -> L21
        if ((r104 instanceof CompletableDeferred) == false) goto L16;
        r103 = r104;
    L16:
        CompletableDeferred<?> r105 = r103;     // Catch: Throwable -> L21
        if (r105 == null) goto L19;
        r105.complete(r101);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r100);
        return;
    L21:
        th = move-exception;
        throw th;
    L5:
        Object r106 = this.f180751a.putIfAbsent(r100, r101);
        if ((r106 instanceof com.bytedance.android.shopping.prepurchase.arch.container.ability.a) == true) goto L8;
        r106 = null;
    L8:
        com.bytedance.android.shopping.prepurchase.arch.container.ability.a r107 = (com.bytedance.android.shopping.prepurchase.arch.container.ability.a) r106;
        if (r107 == null) goto L11;
        r101 = (T) r107;
        goto L11
    }
}
