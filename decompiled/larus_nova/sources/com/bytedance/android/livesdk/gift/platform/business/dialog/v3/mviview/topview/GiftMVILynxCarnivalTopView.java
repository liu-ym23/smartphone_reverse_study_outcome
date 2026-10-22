package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftMVICarnivalViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVILynxCarnivalTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftMVICarnivalViewState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f128102m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public zy0.b f128103n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_gift_carnival_lynx_view;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        ViewGroup r100 = this.f128102m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r100.removeAllViews();
        zy0.b r101 = this.f128103n;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f128102m = (ViewGroup) r().findViewById(R.id.gift_panel_carnival_lynx_view_container);
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVILynxCarnivalTopView$bindToParent$1 r101 = GiftMVILynxCarnivalTopView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    public GiftMVILynxCarnivalTopView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftMVICarnivalViewState r102 = (GiftMVICarnivalViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftMVICarnivalViewState, Map<String, Object>> r103 = r102.getLynxParams();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L25;
        r100.f41739b.f41563a.invoke(r103);
        Map<String, ? extends Object> r105 = (Map) r104;
        if (r105.isEmpty() == false) goto L7;
        return;
    L7:
        if (nz1.a.b().a() == false) goto L32;
        zy0.b r106 = this.f128103n;
        if (r106 == null) goto L15;
        xy0.a<?> r107 = r106.g();
        if (r107 == null) goto L27;
        r107.sendJsEvent("event_gift_progress_update", r105);
        return;
    L27:
        return;
    L15:
        if (r105.get("progress_data") == null) goto L29;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r108 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(getContext(), UriProtector.parse(nz1.a.b().b()), null);
        this.f128103n = r108;
        if (r108 == null) goto L30;
        ViewGroup r109 = this.f128102m;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        r109.addView((View) r108.f91463d);
        xy0.a<?> r110 = r108.g();
        if (r110 == null) goto L31;
        r110.load(null, r105);
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L32:
        return;
    }
}
