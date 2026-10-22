package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopCollectionViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCollectionData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVICollectionContainerView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopCollectionViewState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public zy0.b f127997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f127998n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_gift_collection_view;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        ((ViewGroup) this.f127998n.getValue()).removeAllViews();
        zy0.b r100 = this.f127997m;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVICollectionContainerView$bindToParent$1 r101 = GiftMVICollectionContainerView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    public GiftMVICollectionContainerView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
        this.f127998n = LazyKt.lazy(new GiftMVICollectionContainerView$rootView$2(this));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTopCollectionViewState r102 = (GiftTopCollectionViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftTopCollectionViewState, ShowCollectionData> r103 = r102.getShowCollection();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L6;
        r100.f41739b.f41563a.invoke(r103);
        final ShowCollectionData r105 = (ShowCollectionData) r104;
        GiftPanelBizBoostUtils.E.getClass();
        UtilityKotlinExtentionsKt.s(0, false, ((Boolean) GiftPanelBizBoostUtils.B.getValue()).booleanValue(), new GiftMVICollectionContainerView$handleDiff$$inlined$select$lambda$1(r105, this), 3);
        return;
    }
}
