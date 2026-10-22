package com.bytedance.android.gamecp.business.gamedetail.page.lynx;

import com.bytedance.android.gamecp.business.gamedetail.page.BaseGameDetailTabWidget;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.android.gamecp.business.hybrid.uielement.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameLynxTabWidgetV4 f55419a;

    @Override // com.bytedance.android.gamecp.business.hybrid.uielement.a
    public final void onLoadSuccess() {
    }

    public e(GameLynxTabWidgetV4 r100) {
        this.f55419a = r100;
    }

    @Override // com.bytedance.android.gamecp.business.hybrid.uielement.a
    public final void a(String r100) {
        BaseGameDetailTabWidget.Wq(this.f55419a, Integer.valueOf(y0.c(R.color.gamecp_game_80161823)), 1);
    }
}
