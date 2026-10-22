package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopBuffContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowBuffCardData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIBuffContainerView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopBuffContainerViewState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zy0.b f127995m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f127996n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_gift_buff_container_view;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        ((ViewGroup) this.f127996n.getValue()).removeAllViews();
        zy0.b r100 = this.f127995m;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIBuffContainerView$bindToParent$1 r101 = GiftMVIBuffContainerView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    public GiftMVIBuffContainerView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
        this.f127996n = LazyKt.lazy(new GiftMVIBuffContainerView$rootView$2(this));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTopBuffContainerViewState r102 = (GiftTopBuffContainerViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftTopBuffContainerViewState, ShowBuffCardData> r103 = r102.getShowCard();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L21;
        r100.f41739b.f41563a.invoke(r103);
        ShowBuffCardData r105 = (ShowBuffCardData) r104;
        if (nz1.a.h().c() == true) goto L8;
        return;
    L8:
        if (r105.getCanShow() == true) goto L10;
        return;
    L10:
        if (this.f127995m == null) goto L12;
        return;
    L12:
        if (com.bytedance.android.live.revenue.common.b0.a().b() == false) goto L14;
        zy0.b r106 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(getContext(), UriProtector.parse(nz1.a.h().a()), null);
    L15:
        this.f127995m = r106;
        if (r106 == null) goto L24;
        ((ViewGroup) this.f127996n.getValue()).addView(r106.c());
        xy0.a<?> r107 = r106.g();
        if (r107 == null) goto L25;
        r107.load(null, r105.getParams());
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r106 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).J8(getContext(), UriProtector.parse(nz1.a.h().a()), null);
        goto L15
    }
}
