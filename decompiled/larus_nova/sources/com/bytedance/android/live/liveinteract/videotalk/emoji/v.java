package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f79424a;

    public v(int r100) {
        this.f79424a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        rj0.l.f537955n2.getClass();
        rj0.l r102 = rj0.l.a.a();
        if (r102 == null) goto L6;
        rj0.l.b.d(r102, this.f79424a, true, false, 12);
        return;
    }
}
