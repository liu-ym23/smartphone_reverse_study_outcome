package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TabSelectorView f61618a;

    public d(TabSelectorView r100) {
        this.f61618a = r100;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        TabSelectorView r100 = this.f61618a;
        r100.f61609c = false;
        r100.f61608b.setRotation(0.0f);
    }
}
