package com.bytedance.android.ec.core.imagex.common;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements com.bytedance.android.shopping.api.image.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageUrlParser f44654a;

    public o(ImageUrlParser r100) {
        this.f44654a = r100;
    }

    @Override // com.bytedance.android.shopping.api.image.u
    public final boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.f44654a.f44581q.containsKey(r100) == false) goto L6;
        return true;
    }

    @Override // com.bytedance.android.shopping.api.image.u
    public final String b(String r100) {
        return this.f44654a.f44581q.get(r100);
    }

    @Override // com.bytedance.android.shopping.api.image.v
    public final void appendQueryParameter(String r100, String r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.f44654a.f44581q.put(r100, r101);
        return;
    L7:
        return;
    }
}
