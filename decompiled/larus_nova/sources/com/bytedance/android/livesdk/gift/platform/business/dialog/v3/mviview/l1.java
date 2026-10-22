package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public interface l1 {
    int a();

    GiftTopViewState.Mode c();

    BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?> d(Context r100, ViewGroup r101, DataCenter r102);
}
