package com.bytedance.android.live.browser;

import android.content.Intent;
import com.bytedance.android.livesdkapi.jsb.IExternalActivityResultListener;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class x extends y6.b<com.bytedance.ies.web.jsbridge2.f<?, ?>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f64420b;

    @Override // y6.b
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
        return ((com.bytedance.ies.web.jsbridge2.f.b) this.f64420b.getValue()).a();
    }

    public x(Map.Entry r100) {
        this.f64420b = r100;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment.a
    public final void onActivityResult(int r100, int r101, Intent r102) {
        Object r103 = this.f566287a;
        if ((r103 instanceof IExternalActivityResultListener) == true) goto L5;
        r103 = null;
    L5:
        IExternalActivityResultListener r104 = (IExternalActivityResultListener) r103;
        if (r104 == null) goto L9;
        r104.onActivityResult(r100, r101, r102);
        return;
    }
}
