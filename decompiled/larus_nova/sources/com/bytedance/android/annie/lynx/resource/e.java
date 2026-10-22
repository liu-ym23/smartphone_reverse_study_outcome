package com.bytedance.android.annie.lynx.resource;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements k7a.a.InterfaceC6515a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f39519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k7a.a.InterfaceC6515a f39521c;

    public e(d r100, String r101, k7a.a.InterfaceC6515a r102) {
        this.f39519a = r100;
        this.f39520b = r101;
        this.f39521c = r102;
    }

    @Override // k7a.a.InterfaceC6515a
    public final void a(byte[] r100, Throwable r101) {
        if (r101 != null) goto L14;
        if (r100 == null) goto L14;
        if (r100.length != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L14;
        k7a.a.InterfaceC6515a r103 = this.f39521c;
        if (r103 == null) goto L16;
        r103.a(r100, r101);
        return;
    L16:
        return;
    L7:
        r102 = false;
    L14:
        this.f39519a.b(this.f39520b, this.f39521c);
    }
}
