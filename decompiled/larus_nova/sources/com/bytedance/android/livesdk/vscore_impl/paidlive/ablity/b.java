package com.bytedance.android.livesdk.vscore_impl.paidlive.ablity;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoFallbackHybridComponentContainer f160097a;

    public b(AutoFallbackHybridComponentContainer r100) {
        this.f160097a = r100;
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        super.onInnerFallback(r100, r101);
        this.f160097a.b("lynx view load error. url is " + this.f160097a.f160030a);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        super.onLoadFail(r100, r101, r102);
        AutoFallbackHybridComponentContainer r103 = this.f160097a;
        String r104 = "h5 view load error. url is " + r101 + ", msg is " + r102;
        int r105 = AutoFallbackHybridComponentContainer.f160029f;
        r103.b(r104);
    }
}
