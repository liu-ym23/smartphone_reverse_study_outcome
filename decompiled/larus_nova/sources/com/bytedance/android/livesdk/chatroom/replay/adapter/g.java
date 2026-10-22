package com.bytedance.android.livesdk.chatroom.replay.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoItemViewHolder f108122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f108123b;

    public g(ReplayVideoItemViewHolder r100, a r101) {
        this.f108122a = r100;
        this.f108123b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f108122a.f108110l.invoke(this.f108123b);
    }
}
