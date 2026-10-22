package com.bytedance.android.shopping.anchorv4.topnav;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.action.IAction;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f167482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IAction f167483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f167484c;

    public c(FrameLayout r100, IAction r101, d r102) {
        this.f167482a = r100;
        this.f167483b = r101;
        this.f167484c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = com.bytedance.android.shopping.anchorv4.event_chain.c.f166550a;
        com.bytedance.android.shopping.anchorv4.event_chain.c.b(null, null, this.f167484c.f167489e, this.f167483b, this.f167482a, null);
    }
}
