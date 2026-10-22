package com.bytedance.android.livesdk.chatroom.replay.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoItemViewHolder f108116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f108117b;

    public e(ReplayVideoItemViewHolder r100, a r101) {
        this.f108116a = r100;
        this.f108117b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f108116a.f108109k.invoke(this.f108117b);
    }
}
