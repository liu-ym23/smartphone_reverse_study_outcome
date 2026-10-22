package com.bytedance.android.livesdk.chatroom.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f118795a;

    public f(g r100) {
        this.f118795a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        zg1.q r102 = this.f118795a.f118809e.f571893d;
        if (r102 == null) goto L5;
        zg1.q.a.a(r102, false);
    L5:
        r100.dismiss();
    }
}
