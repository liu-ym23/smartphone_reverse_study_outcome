package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.GiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftComboState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftVerticalState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnComboSingleClickStart;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboBottomAnimationView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIComboView extends BaseGiftMVIViewChildNode<GiftVerticalState, GiftComboState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ComboBottomAnimationView f127493m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final GiftComboView f127494n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f127495o;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_base_gift_combo_widget;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f127493m = (ComboBottomAnimationView) r().findViewById(R.id.combo_bottom_animation);
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        View r100 = r();
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L9;
        r101.removeAllViews();
        return;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftVerticalState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIComboView$bindToParent$1 r101 = GiftMVIComboView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    public GiftMVIComboView(final Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
        View r102 = null;
        GiftComboView r103 = new GiftComboView(r100, null, 0, 6);
        View r104 = r();
        if ((r104 instanceof ViewGroup) == false) goto L6;
        r102 = r104;
    L6:
        ViewGroup r105 = (ViewGroup) r102;
        if (r105 == null) goto L9;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        r106.rightMargin = UtilityKotlinExtentionsKt.i(-35);
        r106.bottomMargin = UtilityKotlinExtentionsKt.i(-95);
        Unit r107 = Unit.INSTANCE;
        r105.addView(r103, r106);
    L9:
        Unit r108 = Unit.INSTANCE;
        this.f127494n = r103;
        this.f127495o = LazyKt.lazy(LazyThreadSafetyMode.NONE, new GiftMVIComboView$groupHintView$2(this, r100));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r110, MVIState r111) {
        GiftComboState r112 = (GiftComboState) r111;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r112, "state");
        com.bytedance.android.anya.r0<GiftComboState, Integer> r100 = r112.getComboNum();
        Object r101 = r110.f41740c.a(r100);
        if (r101 == null) goto L12;
        r110.f41739b.f41563a.invoke(r100);
        int r102 = ((Number) r101).intValue();
        yz0.k r103 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r103 != null) goto L7;
    L11:
        UtilityKotlinExtentionsKt.w(this.f127494n);
        this.f127494n.setComboCount(r102);
        this.f127494n.c(new b(this), 0, 0);
        goto L12
    L7:
        if (r103.isPortraitInteraction() != true) goto L11;
        ComboBottomAnimationView r104 = this.f127493m;
        if (r104 == null) goto L11;
        r104.b(r102);
    L12:
        com.bytedance.android.anya.r0<GiftComboState, Integer> r105 = r112.getPositionX();
        Object r106 = r110.f41740c.a(r105);
        if (r106 == null) goto L20;
        r110.f41739b.f41563a.invoke(r105);
        int r107 = ((Number) r106).intValue();
        int[] r108 = new int[2];
        this.f126234l.getLocationInWindow(r108);
        int r109 = r108[0] + UtilityKotlinExtentionsKt.i(35);
        ViewGroup.LayoutParams r113 = this.f127494n.getLayoutParams();
        if ((r113 instanceof FrameLayout.LayoutParams) == false) goto L20;
        if (com.bytedance.android.livesdk.gift.util.c.c() == false) goto L19;
        int[] r114 = new int[2];
        this.f126234l.getLocationInWindow(r114);
        ((FrameLayout.LayoutParams) r113).leftMargin = ((int) ((r107 - r114[0]) / nz1.a.q().c())) - UtilityKotlinExtentionsKt.i(35);
        goto L20
    L19:
        ((FrameLayout.LayoutParams) r113).leftMargin = r107 - r109;
    L20:
        com.bytedance.android.anya.r0<GiftComboState, Integer> r115 = r112.getPositionY();
        Object r116 = r110.f41740c.a(r115);
        if (r116 == null) goto L36;
        r110.f41739b.f41563a.invoke(r115);
        int r117 = ((Number) r116).intValue();
        if (b02.a.e() == false) goto L25;
        int[] r118 = new int[2];
        this.f126234l.getLocationInWindow(r118);
        int r119 = r118[1];
        int r120 = UtilityKotlinExtentionsKt.i(95);
    L26:
        int r121 = r119 + r120;
        ViewGroup.LayoutParams r122 = this.f127494n.getLayoutParams();
        if ((r122 instanceof FrameLayout.LayoutParams) == false) goto L36;
        if (com.bytedance.android.livesdk.gift.util.c.c() == true) goto L31;
        ((FrameLayout.LayoutParams) r122).topMargin = r117 - r121;
        goto L36
    L31:
        if (b02.a.e() == false) goto L33;
        int r123 = UtilityKotlinExtentionsKt.i(95);
    L34:
        int[] r124 = new int[2];
        this.f126234l.getLocationInWindow(r124);
        ((FrameLayout.LayoutParams) r122).topMargin = ((int) ((r117 - r124[1]) / nz1.a.q().c())) - r123;
        goto L36
    L33:
        r123 = UtilityKotlinExtentionsKt.i(75);
        goto L34
    L25:
        int[] r125 = new int[2];
        this.f126234l.getLocationInWindow(r125);
        r119 = r125[1];
        r120 = UtilityKotlinExtentionsKt.i(75);
    L36:
        com.bytedance.android.anya.r0<GiftComboState, Boolean> r126 = r112.isSingleTap();
        Object r127 = r110.f41740c.a(r126);
        if (r127 == null) goto L42;
        r110.f41739b.f41563a.invoke(r126);
        if (((Boolean) r127).booleanValue() == false) goto L41;
        this.f127494n.g();
        goto L42
    L41:
        this.f127494n.f();
    L42:
        com.bytedance.android.anya.r0<GiftComboState, ComboState> r128 = r112.getComboStatus();
        Object r129 = r110.f41740c.a(r128);
        if (r129 == null) goto L54;
        r110.f41739b.f41563a.invoke(r128);
        int r130 = a.f127683a[((ComboState) r129).ordinal()];
        if (r130 == 1) goto L52;
        if (r130 != 2) goto L48;
        this.f127494n.setVisibility(0);
        o(new OnComboSingleClickStart(false, 1, null));
        return;
    L48:
        if (r130 != 3) goto L57;
        this.f127494n.setVisibility(0);
        return;
    L57:
        return;
    L52:
        UtilityKotlinExtentionsKt.t(this.f127494n);
        this.f127494n.d();
        return;
    }
}
