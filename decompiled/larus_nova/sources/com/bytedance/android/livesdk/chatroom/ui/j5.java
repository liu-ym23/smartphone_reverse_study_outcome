package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class j5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5 f113601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.b f113602b;

    public j5(h5 r100, h5.b r101) {
        this.f113601a = r100;
        this.f113602b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DialogInterface.OnClickListener r101 = this.f113602b.f113567h;
        if (r101 == null) goto L6;
        r101.onClick(this.f113601a, 1);
        return;
    }
}
