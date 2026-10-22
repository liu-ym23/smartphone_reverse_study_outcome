package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkPanelTopBarWidget f75410a;

    public s(LinkPanelTopBarWidget r100) {
        this.f75410a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LinkPanelTopBarWidget.wq(this.f75410a);
    }
}
