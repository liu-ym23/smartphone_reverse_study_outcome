package com.bytedance.android.livesdk.viewholder;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SubscribeEmojiViewHolder f159299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.vip.l f159300b;

    public k(SubscribeEmojiViewHolder r100, com.bytedance.android.live.profit.vip.l r101) {
        this.f159299a = r100;
        this.f159300b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        jf2.c r101 = this.f159299a.f159282e;
        if (r101 == null) goto L6;
        r101.a(this.f159300b);
        return;
    }
}
