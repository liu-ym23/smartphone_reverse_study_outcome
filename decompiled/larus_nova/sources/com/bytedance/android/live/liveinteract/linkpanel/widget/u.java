package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkPanelTopBarWidget f75412a;

    public u(LinkPanelTopBarWidget r100) {
        this.f75412a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LinkPanelTopBarWidget.wq(this.f75412a);
    }
}
