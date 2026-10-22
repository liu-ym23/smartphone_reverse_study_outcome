package com.bytedance.android.shopping.anchorv4.containers.page;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends com.bytedance.android.ec.core.anchorv3.q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BaseProductDetailPage f166289e;

    @Override // com.bytedance.android.ec.core.anchorv3.q
    public final boolean b() {
        if (this.f166289e.f166243p.f166266a.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.q
    public final void c() {
        this.f166289e.C();
    }

    public e(BaseProductDetailPage r100) {
        this.f166289e = r100;
        super(-1);
    }
}
