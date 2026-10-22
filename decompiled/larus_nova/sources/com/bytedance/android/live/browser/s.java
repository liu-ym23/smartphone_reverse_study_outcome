package com.bytedance.android.live.browser;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HybridDebugFragment f64187a;

    public s(HybridDebugFragment r100) {
        this.f64187a = r100;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        w r102 = this.f64187a.f62562g;
        if (r102 == null) goto L6;
        r102.setEnableDevtoolDebug(r101);
        return;
    }
}
