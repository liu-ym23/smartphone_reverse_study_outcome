package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class y0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f117509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f117510b;

    public y0(x0 r100, boolean r101) {
        this.f117509a = r100;
        this.f117510b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f117510b == false) goto L5;
        xs2.b.a().post(new o42.k("guide_bubble"));
    L5:
        x0 r101 = this.f117509a;
        yo2.d<?> r102 = r101.f117494f;
        if (r102 == null) goto L8;
        r102.d();
    L8:
        r101.f117494f = null;
    }
}
