package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.configmodel.x0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopSeriesViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVISeriesTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopSeriesViewState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f128113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public zy0.b f128114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final x0 f128115o;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_gift_series_lynx_view;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        ViewGroup r100 = this.f128113m;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r100.removeAllViews();
        zy0.b r101 = this.f128114n;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        this.f128113m = (ViewGroup) r().findViewById(R.id.gift_panel_series_lynx_view_container);
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVISeriesTopView$bindToParent$1 r101 = GiftMVISeriesTopView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    public GiftMVISeriesTopView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
        this.f128115o = (x0) nz1.a.f521364w.getValue(null, nz1.a.f521324a[21]);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTopSeriesViewState r102 = (GiftTopSeriesViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftTopSeriesViewState, Map<String, Object>> r103 = r102.getSeriesGiftMap();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L25;
        r100.f41739b.f41563a.invoke(r103);
        Map<String, ? extends Object> r105 = (Map) r104;
        if (r105.isEmpty() == true) goto L30;
        zy0.b r106 = this.f128114n;
        if (r106 == null) goto L13;
        xy0.a<?> r107 = r106.g();
        if (r107 == null) goto L26;
        r107.updateData(r105);
        return;
    L26:
        return;
    L13:
        if (com.bytedance.android.live.revenue.common.b0.a().e() == false) goto L15;
        zy0.b r108 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(getContext(), UriProtector.parse(this.f128115o.b() + "&enable_canvas=1&enable_canvas_optmize=1"), null);
    L16:
        this.f128114n = r108;
        if (r108 == null) goto L28;
        ViewGroup r109 = this.f128113m;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        r109.addView(r108.c());
        Map<String, ? extends Object> r110 = MapsKt.toMutableMap(r105);
        r110.put("panel_new_architecture", Integer.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() ? 1 : 0));
        xy0.a<?> r111 = r108.g();
        if (r111 == null) goto L29;
        r111.load(null, r110);
        return;
    L29:
        return;
    L28:
        return;
    L15:
        r108 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(getContext(), UriProtector.parse(this.f128115o.b() + "&enable_canvas=1&enable_canvas_optmize=1"), null);
        goto L16
    L30:
        return;
    }
}
