package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class k5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5 f113642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.b f113643b;

    public k5(h5 r100, h5.b r101) {
        this.f113642a = r100;
        this.f113643b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DialogInterface.OnClickListener r101 = this.f113643b.f113569j;
        if (r101 == null) goto L6;
        r101.onClick(this.f113642a, 2);
        return;
    }
}
