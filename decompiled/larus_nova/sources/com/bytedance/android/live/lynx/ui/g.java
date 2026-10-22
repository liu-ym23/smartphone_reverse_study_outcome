package com.bytedance.android.live.lynx.ui;

import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements e76.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLynxAlphaPlayer f82738a;

    public g(LiveLynxAlphaPlayer r100) {
        this.f82738a = r100;
    }

    @Override // e76.b
    public final void onResult(Object r100) {
        String r101 = (String) r100;
        LiveLynxAlphaPlayer r102 = this.f82738a;
        if (r101 != "success") goto L15;
        int r103 = LiveLynxAlphaPlayer.f82670h;
        r102.sendEvent("ready", r102.P(1, "load resource success", null));
        if (r102.f82673c != null) goto L7;
        return;
    L7:
        if (r102.f82674d == false) goto L18;
        IPlayerController r104 = r102.f82671a;
        if (r104 == null) goto L11;
        r104.attachAlphaView(LiveLynxAlphaPlayer.M(r102));
    L11:
        IPlayerController r105 = r102.f82671a;
        if (r105 == null) goto L19;
        r105.d(r102.f82673c);
        return;
    L19:
        return;
    L18:
        return;
    L15:
        r102.Q("unknown exception, " + r101, r102.f82677g, -6);
        throw null;
    }
}
