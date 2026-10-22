package com.bytedance.android.live.livelink.guestlink.media;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements sq2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuestLinkMediaManager f81220a;

    public a(GuestLinkMediaManager r100) {
        this.f81220a = r100;
    }

    @Override // sq2.a
    public final void a(boolean r100) {
        jy0.b.d("GuestLinkMediaManager", "appEnterBackground, background: " + r100);
        if (r100 == false) goto L12;
        GuestLinkMediaManager r101 = this.f81220a;
        r101.f81213m = true;
        jy0.b.d("GuestLinkMediaManager", "pause");
        if (r101.f81206f == false) goto L21;
        jy0.b.d("GuestLinkMediaManager", "pause start");
        ei6.a r102 = r101.f81203c;
        if (r102 == null) goto L9;
        r102.pause();
    L9:
        ob6.a.InterfaceC7033a r103 = r101.f81211k;
        if (r103 == null) goto L22;
        r103.c();
        return;
    L22:
        return;
    L21:
        return;
    L12:
        GuestLinkMediaManager r104 = this.f81220a;
        r104.f81213m = false;
        jy0.b.d("GuestLinkMediaManager", "resume");
        if (r104.f81206f == false) goto L24;
        jy0.b.d("GuestLinkMediaManager", "resume start");
        ei6.a r105 = r104.f81203c;
        if (r105 == null) goto L17;
        r105.resume();
    L17:
        ob6.a.InterfaceC7033a r106 = r104.f81211k;
        if (r106 == null) goto L25;
        r106.c();
        return;
    L25:
        return;
    }
}
