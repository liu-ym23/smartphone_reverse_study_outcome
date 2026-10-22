package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h0 implements l1, com.bytedance.android.scope.o {
    public h0() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1
    public final int a() {
        return R.id.gift_series_lynx_container;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1
    public final GiftTopViewState.Mode c() {
        return GiftTopViewState.Mode.Series;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.l1
    public final BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?> d(Context r100, ViewGroup r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        return new GiftMVISeriesTopView(r100, r101);
    }
}
