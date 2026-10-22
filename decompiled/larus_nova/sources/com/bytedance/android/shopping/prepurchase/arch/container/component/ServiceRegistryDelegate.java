package com.bytedance.android.shopping.prepurchase.arch.container.component;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.utils.j0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ServiceRegistryDelegate implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f180748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<List<Class<?>>> f180749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f180750d;

    public static boolean g(Class r100) {
        if (com.bytedance.android.shopping.prepurchase.arch.container.intf.j.class.isAssignableFrom(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if (l.class.isAssignableFrom(r100) == true) goto L12;
        if (com.bytedance.android.shopping.prepurchase.arch.container.ability.i.class.isAssignableFrom(r100) == true) goto L12;
        if (com.bytedance.android.shopping.prepurchase.arch.container.ability.f.class.isAssignableFrom(r100) == true) goto L12;
        return false;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f180748b.a(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f180748b.b(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f180748b.c(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        if (j0.f187150a == false) goto L12;
        if (((List) this.f180747a.getValue()).contains(r100) == true) goto L12;
        if (g(r100) == true) goto L12;
        throw new IllegalArgumentException("please register " + r100 + " to \"" + this.f180750d + "#dependencies()\" function");
    L12:
        return (T) this.f180748b.getService(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final j d(String r100, Function0<? extends List<? extends Class<?>>> r101) {
        Intrinsics.checkNotNullParameter(r100, "componentName");
        Intrinsics.checkNotNullParameter(r101, "block");
        return this.f180748b.d(r100, r101);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> Object e(Class<T> r100, Continuation<? super T> r101) {
        if (j0.f187150a == false) goto L12;
        if (((List) this.f180747a.getValue()).contains(r100) == true) goto L12;
        if (g(r100) == true) goto L12;
        throw new IllegalArgumentException("please register " + r100 + " to \"" + this.f180750d + "#dependencies()\" function");
    L12:
        return this.f180748b.e(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ServiceRegistryDelegate(j r100, Function0<? extends List<? extends Class<?>>> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, "block");
        Intrinsics.checkNotNullParameter(r102, "componentName");
        this.f180748b = r100;
        this.f180749c = r101;
        this.f180750d = r102;
        this.f180747a = LazyKt.lazy(new ServiceRegistryDelegate$dependencies$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.j
    public final <T extends com.bytedance.android.shopping.prepurchase.arch.container.ability.a> void f(Class<T> r100, T r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "inst");
        this.f180748b.f(r100, r101, r102);
    }
}
