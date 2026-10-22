package com.bytedance.android.live.livelink.guestlink.media;

import fr2.u;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuestLinkMediaManager f81221a;

    @Override // fr2.u
    public final void X1(int r100, int r101, Exception r102) {
    }

    public b(GuestLinkMediaManager r100) {
        this.f81221a = r100;
    }

    @Override // fr2.u
    public final void q2(int r100, int r101, int r102) {
        if (r100 != 8) goto L5;
        jy0.b.d("GuestLinkMediaManager", "MSG_INFO_AUDIO_STARTED_CAPTURE");
        ob6.a.InterfaceC7033a r103 = this.f81221a.f81211k;
        if (r103 == null) goto L23;
        r103.s();
        return;
    L23:
        return;
    L5:
        if (r100 != 9) goto L7;
        jy0.b.d("GuestLinkMediaManager", "MSG_INFO_AUDIO_STOPED_CAPTURE");
        ob6.a.InterfaceC7033a r104 = this.f81221a.f81211k;
        if (r104 == null) goto L21;
        r104.s();
        return;
    L21:
        return;
    L7:
        if (r100 != 30) goto L24;
        jy0.b.d("GuestLinkMediaManager", "MSG_INFO_CAPTURE_FIRST_FRAME");
        ob6.a.InterfaceC7033a r105 = this.f81221a.f81211k;
        if (r105 == null) goto L19;
        r105.t();
        return;
    L19:
        return;
    }
}
