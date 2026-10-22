package com.bytedance.android.shopping.utils.gallery;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements ee3.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridViewerDialog f187142a;

    public l(HybridViewerDialog r100) {
        this.f187142a = r100;
    }

    @Override // ee3.f.b
    public final void a(int r100) {
        this.f187142a.getPager().smoothScrollToPosition(r100);
    }
}
