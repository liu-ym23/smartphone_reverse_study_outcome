package com.bytedance.android.livesdk.chatroom.replay.paid;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 implements cjc.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PaidReplayPresenter f109360a;

    public a0(PaidReplayPresenter r100) {
        this.f109360a = r100;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.constraintlayout.widget.ConstraintLayout, com.bytedance.android.livesdk.chatroom.replay.paid.b] */
    @Override // cjc.d
    public final void a(Bitmap r100) {
        if (r100 == null) goto L7;
        ?? r101 = this.f109360a.f109308i;
        if (r101 == 0) goto L8;
        r101.l4(r100, 1);
        return;
    L8:
        return;
    }
}
