package com.bytedance.android.livesdk.widget.board;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f161476a;

    public h(e r100) {
        this.f161476a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.livesdk.interactivity.api.expression.j r101 = this.f161476a.f161468i.getOnCommentSendDelegate().getValue();
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
