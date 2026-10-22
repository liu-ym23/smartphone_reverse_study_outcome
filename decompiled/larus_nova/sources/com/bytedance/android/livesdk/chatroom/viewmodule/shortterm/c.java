package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements om3.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BubbleComponent f115535a;

    @Override // om3.e.c
    public final void bubbleDismiss() {
        BubbleComponent r100 = this.f115535a;
        r100.f115502b = null;
        r100.f115508h.removeObserver(r100);
    }

    public c(BubbleComponent r100) {
        this.f115535a = r100;
    }
}
