package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class n5 extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoFallbackHybridComponentContainer f113732a;

    public n5(AutoFallbackHybridComponentContainer r100) {
        this.f113732a = r100;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        super.onInnerFallback(r100, r101);
        this.f113732a.b("lynx view load error. url is " + this.f113732a.f112112a);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        AutoFallbackHybridComponentContainer r103 = this.f113732a;
        String r104 = "h5 view load error. url is " + r101 + ", msg is " + r102;
        int r105 = AutoFallbackHybridComponentContainer.f112111e;
        r103.b(r104);
    }
}
