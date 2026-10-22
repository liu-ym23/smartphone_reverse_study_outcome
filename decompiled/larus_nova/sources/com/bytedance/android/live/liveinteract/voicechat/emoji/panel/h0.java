package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class h0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f80224a;

    public h0(s r100) {
        this.f80224a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        s r102 = this.f80224a;
        r102.f80239c = false;
        s.a r103 = (s.a) r102.f531633a;
        if (r103 == null) goto L6;
        r103.U2(r101);
        return;
    }
}
