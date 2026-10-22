package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f119168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f119169b;

    public r(u r100, boolean r101) {
        this.f119168a = r100;
        this.f119169b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        u r101 = this.f119168a;
        u.b r102 = r101.B;
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f119169b == false) goto L12;
        String r103 = r101.f119214z;
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r102.Lf(r103, r101.getRoomDecoration());
        return;
    }
}
