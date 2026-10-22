package com.bytedance.android.live.browser;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.browser.jsbridge.newmethods.j8;

/* JADX INFO: loaded from: classes45.dex */
public final class z extends y6.b<j8> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f64423b;

    @Override // y6.b
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> b() {
        return new j8(this.f64423b);
    }

    public z(Fragment r100) {
        this.f64423b = r100;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment.a
    public final void onActivityResult(int r100, int r101, Intent r102) {
        j8 r103 = (j8) this.f566287a;
        if (r103 == null) goto L6;
        r103.onActivityResult(r100, r101, r102);
        return;
    }
}
