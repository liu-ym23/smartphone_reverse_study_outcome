package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;
import com.bytedance.android.live.core.utils.LiveResUtil;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsHybridFragment f64380a;

    public g(AbsHybridFragment r100) {
        this.f64380a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (this.f64380a.f64319d == true) goto L5;
        return;
    L5:
        if (Math.abs(r104 - r108) >= 200) goto L8;
        return;
    L8:
        if (r104 >= (LiveResUtil.getScreenHeight() * 0.75f)) goto L12;
        AbsHybridFragment r109 = this.f64380a;
        if (r109.f64320e == true) goto L17;
        r109.f64320e = true;
        AbsHybridFragment.S90(r109, true);
        return;
    L17:
        return;
    L12:
        AbsHybridFragment r110 = this.f64380a;
        if (r110.f64320e == false) goto L19;
        r110.f64320e = false;
        AbsHybridFragment.S90(r110, false);
        return;
    }
}
