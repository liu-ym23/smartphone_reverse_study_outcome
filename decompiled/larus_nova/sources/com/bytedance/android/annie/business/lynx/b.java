package com.bytedance.android.annie.business.lynx;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements k7a.a.InterfaceC6515a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f39044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k7a.a.InterfaceC6515a f39046c;

    public b(a r100, String r101, k7a.a.InterfaceC6515a r102) {
        this.f39044a = r100;
        this.f39045b = r101;
        this.f39046c = r102;
    }

    @Override // k7a.a.InterfaceC6515a
    public final void a(byte[] r100, Throwable r101) {
        if (r101 != null) goto L14;
        if (r100 == null) goto L14;
        if (r100.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L14;
        k7a.a.InterfaceC6515a r103 = this.f39046c;
        if (r103 == null) goto L16;
        r103.a(r100, r101);
        return;
    L16:
        return;
    L7:
        r102 = false;
    L14:
        this.f39044a.f247382c.loadDynamicComponent(this.f39045b, this.f39046c);
    }
}
