package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.arch.utils.ViewExtensionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> implements e<STATE, STORE>, g<STATE, STORE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AbsComponent<?, ?>> f180760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> f180761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f180762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lifecycle f180763d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void d(i<STATE, STORE> r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        if (((ArrayList) this.f180760a).contains(r100) == false) goto L5;
        return;
    L5:
        r100.L1(this.f180761b, this.f180762c);
        this.f180763d.a(r100);
        this.f180761b.w7().d("ComponentLoader", "load service: ".concat(r100.getClass().getName()));
        ((ArrayList) this.f180760a).add(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void e(Component r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        if (((ArrayList) this.f180760a).contains(r100) == true) goto L5;
        return;
    L5:
        this.f180763d.c(r100);
        Lifecycle.State r101 = this.f180763d.b();
        int r102 = d.f180764a[r101.ordinal()];
        if (r102 != 2) goto L8;
        r100.h0(r100, Lifecycle.Event.ON_DESTROY);
    L21:
        if ((r100 instanceof Component) == true) goto L23;
    L28:
        this.f180761b.w7().d("ComponentLoader", "unload: ".concat(r100.getClass().getName()));
        ((ArrayList) this.f180760a).remove(r100);
        return;
    L23:
        if (r100.f180746l == false) goto L28;
        View r103 = r100.f180743i;
        if (r103 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L27:
        ViewExtensionsKt.a(r103);
        goto L28
    L8:
        if (r102 != 3) goto L10;
        r100.h0(r100, Lifecycle.Event.ON_STOP);
        r100.h0(r100, Lifecycle.Event.ON_DESTROY);
        goto L21
    L10:
        if (r102 != 4) goto L12;
        r100.h0(r100, Lifecycle.Event.ON_PAUSE);
        r100.h0(r100, Lifecycle.Event.ON_STOP);
        r100.h0(r100, Lifecycle.Event.ON_DESTROY);
        goto L21
    L12:
        if (r102 != 5) goto L21;
        if (r100.f180738c == true) goto L21;
        r100.h0(r100, Lifecycle.Event.ON_DESTROY);
        goto L21
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final boolean f(AbsComponent<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        return ((ArrayList) this.f180760a).contains(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.e
    public final c b(View r100, LifecycleRegistry r101) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r101, NewBroadcastMonitor.STAGE.LIFECYCLE);
        return new c(this.f180761b, this.f180762c, r101);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void c(Component<STATE, STORE> r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(r101, "contentView");
        if (((ArrayList) this.f180760a).contains(r100) == false) goto L5;
        return;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "view");
        r100.f180743i = r101;
        r100.L1(this.f180761b, this.f180762c);
        Intrinsics.checkNotNullParameter(this, "componentLoaderParent");
        r100.f180744j = this;
        this.f180761b.w7().d("ComponentLoader", "loadWithContent: ".concat(r100.getClass().getName()));
        ((ArrayList) this.f180760a).add(r100);
        this.f180763d.a(r100);
    }

    public c(com.bytedance.android.shopping.prepurchase.arch.container.c r100, j r101, LifecycleRegistry r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r102, "lifecycleRegistry");
        this.f180761b = r100;
        this.f180762c = r101;
        this.f180763d = r102;
        this.f180760a = new ArrayList();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void a(ViewGroup r100, Component<STATE, STORE> r101, ViewGroup.LayoutParams r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        Intrinsics.checkNotNullParameter(r101, "component");
        if (((ArrayList) this.f180760a).contains(r101) == false) goto L5;
        return;
    L5:
        r101.L1(this.f180761b, this.f180762c);
        Intrinsics.checkNotNullParameter(this, "componentLoaderParent");
        r101.f180744j = this;
        r101.b2(r100, r102, r103);
        this.f180761b.w7().d("ComponentLoader", "load: ".concat(r101.getClass().getName()));
        ((ArrayList) this.f180760a).add(r101);
        this.f180763d.a(r101);
    }
}
