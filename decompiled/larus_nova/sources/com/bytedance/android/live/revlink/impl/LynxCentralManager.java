package com.bytedance.android.live.revlink.impl;

import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.h;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.i;
import com.bytedance.android.live.revlink.scopeui.LynxBizType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class LynxCentralManager implements x51.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f92007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f92008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vy0.c f92009c;

    @Override // x51.a
    public final void removeAll() {
        this.f92008b.removeAllViews();
    }

    public LynxCentralManager(FrameLayout r100, vy0.c r101) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "hybridService");
        this.f92008b = r100;
        this.f92009c = r101;
        this.f92007a = LazyKt.lazy(LynxCentralManager$isAnnieXOpt$2.INSTANCE);
    }

    @Override // x51.a
    public final void a(zy0.b r100, boolean r101) {
        if (r100 == null) goto L8;
        View r102 = r100.c();
        if (r102 == null) goto L9;
        ViewUtilsKt.g(r102, r101);
        return;
    L9:
        return;
    }

    @Override // x51.a
    public final void d(String r100, zy0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (r101 == null) goto L11;
        View r102 = r101.c();
        if (r102 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r102.getParent(), this.f92008b) == false) goto L12;
        this.f92008b.removeView(r102);
        return;
    L12:
        return;
    }

    @Override // x51.a
    public final void b(i r100, zy0.b r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "lynxLayout");
        Intrinsics.checkNotNullParameter(r102, "tag");
        if (r101 == null) goto L13;
        View r103 = r101.c();
        if (r103 == null) goto L14;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(r100.f94082a, r100.f94083b);
        r104.leftMargin = r100.f94084c;
        r104.topMargin = r100.f94085d;
        if (this.f92008b.indexOfChild(r103) != (-1)) goto L10;
        this.f92008b.addView(r103, r104);
    L11:
        r103.setTranslationZ(r100.f94086e);
        return;
    L10:
        r103.setLayoutParams(r104);
        goto L11
    L14:
        return;
    }

    @Override // x51.a
    public final zy0.b c(LynxBizType r100, h r101, Uri r102, Function1<? super yy0.c, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        Intrinsics.checkNotNullParameter(r101, "loadSource");
        int r104 = c.f92206a[r100.ordinal()];
        boolean r105 = true;
        if (r104 != 1) goto L5;
        h.b r106 = h.b.f94081b;
        if (Intrinsics.areEqual(r101, r106) == false) goto L19;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r107 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r107.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97544o.getValue(r107, com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a[13])).booleanValue() == false) goto L19;
    L24:
        if (r105 == false) goto L26;
        Function3 r108 = new LynxCentralManager$createCardOrNull$createCard$1(this.f92009c);
    L28:
        return (zy0.b) r108.invoke(this.f92008b.getContext(), r102, new LynxCentralManager$createCardOrNull$1(this, r102, r103));
    L26:
        r108 = new LynxCentralManager$createCardOrNull$createCard$2(this.f92009c);
    L19:
        if ((!Intrinsics.areEqual(r101, r106)) == true) goto L21;
    L23:
        r105 = false;
        goto L24
    L21:
        if (((Boolean) this.f92007a.getValue()).booleanValue() == false) goto L23;
    L5:
        if (r104 != 2) goto L7;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r109 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r109.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97546q.getValue(r109, com.bytedance.android.live.revlink.impl.settings.dynamic.a.f97530a[15])).booleanValue() == false) goto L23;
    L7:
        if (r104 == 3) goto L23;
        throw new NoWhenBranchMatchedException();
    }
}
