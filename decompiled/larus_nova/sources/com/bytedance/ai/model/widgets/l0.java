package com.bytedance.ai.model.widgets;

/* JADX INFO: loaded from: classes43.dex */
public final class l0 implements ix7.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebEngineAssem f37064a;

    @Override // ix7.h
    public final void b(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r108) {
    }

    @Override // ix7.h
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
    }

    public l0(WebEngineAssem r100) {
        this.f37064a = r100;
    }

    @Override // ix7.h
    public final void a(int r100, int r101, boolean r102, boolean r103) {
        WebEngineAssem r104 = this.f37064a;
        if (r104.f36986q == false) goto L16;
        boolean r105 = r104.f36990u;
        boolean r106 = true;
        if (r105 == true) goto L8;
        if (r103 == false) goto L8;
        boolean r107 = true;
    L9:
        r104.f36987r = r107;
        if (r105 == false) goto L13;
        if (r103 == false) goto L13;
    L14:
        r104.f36988s = r106;
        com.bytedance.ai.utils.g.f37637a.i("WebViewAssem", "scrollY: " + r101 + ", clampedY: " + r103 + ", isReachTop: " + this.f37064a.f36987r + ", isReachBottom: " + this.f37064a.f36988s);
        return;
    L13:
        r106 = false;
    L8:
        r107 = false;
        goto L9
    }
}
