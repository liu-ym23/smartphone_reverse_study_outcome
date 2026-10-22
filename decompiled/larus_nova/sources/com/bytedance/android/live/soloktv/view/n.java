package com.bytedance.android.live.soloktv.view;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MvControlTabWrapper f101840a;

    public n(MvControlTabWrapper r100) {
        this.f101840a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        MvControlTabWrapper r101 = this.f101840a;
        int r102 = r101.f101728l;
        r101.getClass();
        if (r102 != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        this.f101840a.f101731o.a();
    L9:
        View r104 = this.f101840a.f101739w;
        if (r104 == null) goto L13;
        r104.setVisibility(8);
        return;
    L13:
        return;
    L8:
        this.f101840a.f101732p.a();
        goto L9
    L5:
        r103 = false;
        goto L6
    }
}
