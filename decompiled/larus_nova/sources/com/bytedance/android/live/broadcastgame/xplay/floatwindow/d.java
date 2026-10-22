package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.view.View;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XplayFloatWindowView.ViewHolder f62152a;

    public d(XplayFloatWindowView.ViewHolder r100) {
        this.f62152a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = XplayLog.f61931a;
        XplayLog.a("XplayFloatWindowView", "click to (un)fold, animate=" + this.f62152a.f62110p);
        XplayFloatWindowView.ViewHolder r102 = this.f62152a;
        if (r102.f62110p == false) goto L5;
        return;
    L5:
        XplayFloatWindowView.ViewState r103 = r102.f62095a;
        if (r103 == null) goto L14;
        int r104 = e.f62153a[r103.ordinal()];
        if (r104 == 1) goto L13;
        if (r104 != 2) goto L14;
        this.f62152a.c(XplayFloatWindowView.ViewState.InteractiveExpanded);
        goto L14
    L13:
        this.f62152a.c(XplayFloatWindowView.ViewState.InteractiveCollapsed);
    L14:
        XplayFloatWindowView.S5(this.f62152a.f62115u, 2);
    }
}
