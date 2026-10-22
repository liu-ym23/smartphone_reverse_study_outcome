package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopCarouselViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCarouselData;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVIOperationCarouselView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopCarouselViewState, GiftAction> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f128112m;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return R.layout.ttlive_top_gift_buff_container_view;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        ((ViewGroup) this.f128112m.getValue()).removeAllViews();
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVIOperationCarouselView$bindToParent$1 r101 = GiftMVIOperationCarouselView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    public GiftMVIOperationCarouselView(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        super(r100, r101);
        this.f128112m = LazyKt.lazy(new GiftMVIOperationCarouselView$rootView$2(this));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r101) {
        GiftTopCarouselViewState r102 = (GiftTopCarouselViewState) r101;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r102, "state");
        r0<GiftTopCarouselViewState, ShowCarouselData> r103 = r102.getShowData();
        Object r104 = r100.f41740c.a(r103);
        if (r104 == null) goto L6;
        r100.f41739b.f41563a.invoke(r103);
        ShowCarouselData r105 = (ShowCarouselData) r104;
        return;
    }
}
