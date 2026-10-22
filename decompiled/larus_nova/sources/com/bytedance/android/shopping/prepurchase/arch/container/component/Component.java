package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.arch.utils.ViewExtensionsKt;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class Component<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> extends AbsComponent<STATE, STORE> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f180743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e<STATE, STORE> f180744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f180745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f180746l;

    public View c2(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        return null;
    }

    public final g<STATE, STORE> d2() {
        return (g) this.f180745k.getValue();
    }

    public final View e2() {
        View r100 = this.f180743i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        return r100;
    }

    public Component() {
        this.f180745k = LazyKt.lazy(new Component$componentLoader$2(this));
    }

    public void b2(ViewGroup r100, ViewGroup.LayoutParams r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        View r103 = c2(LayoutInflater.from(r100.getContext()), r100);
        if (r103 == null) goto L11;
        ViewExtensionsKt.a(r103);
        if (r101 != null) goto L7;
        r100.addView(r103, r102);
    L8:
        this.f180746l = true;
        Intrinsics.checkNotNullParameter(r103, "view");
        this.f180743i = r103;
        return;
    L7:
        r100.addView(r103, r102, r101);
        goto L8
    L11:
        throw new IllegalStateException("contentView is empty");
    }

    public static void a2(Component r100, ViewGroup r101, m r102, ViewGroup.LayoutParams r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        int r105 = -1;
    L9:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "parentView");
        Intrinsics.checkNotNullParameter(r102, "component");
        r100.d2().a(r101, r102, r103, r105);
        return;
    L8:
        r105 = 0;
        goto L9
    }
}
