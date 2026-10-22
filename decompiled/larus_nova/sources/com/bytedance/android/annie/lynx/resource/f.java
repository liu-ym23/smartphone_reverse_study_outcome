package com.bytedance.android.annie.lynx.resource;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements d8a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxTemplateProvider f39522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d8a.b.a f39523b;

    @Override // d8a.b.a
    public final void onFailed(String r100) {
        d8a.b.a r101 = this.f39523b;
        if (r101 == null) goto L6;
        r101.onFailed(r100);
        return;
    }

    @Override // d8a.b.a
    public final void onSuccess(byte[] r100) {
        c r101 = this.f39522a.f39499e;
        if (r101 == null) goto L5;
        r101.a(new com.bytedance.android.annie.card.web.resource.a(false, "unknown", 0, false));
    L5:
        d8a.b.a r102 = this.f39523b;
        if (r102 == null) goto L9;
        r102.onSuccess(r100);
        return;
    }

    public f(LynxTemplateProvider r100, d8a.b.a r101) {
        this.f39522a = r100;
        this.f39523b = r101;
    }
}
