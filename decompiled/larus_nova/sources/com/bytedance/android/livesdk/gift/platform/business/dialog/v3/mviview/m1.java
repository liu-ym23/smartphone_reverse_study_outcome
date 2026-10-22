package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftReceiverViewState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m1 implements com.bytedance.android.scope.o, k1 {
    public m1() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.k1
    public final GiftReceiverViewState.Mode c() {
        return GiftReceiverViewState.Mode.Receiver;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.k1
    public final GiftOnlineReceiverMVIView a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        return new GiftOnlineReceiverMVIView(r100, r101);
    }
}
