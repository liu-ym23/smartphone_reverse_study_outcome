package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f63341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f63342b;

    public d0(h0 r100, View r101) {
        this.f63341a = r100;
        this.f63342b = r101;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        this.f63341a.f63407a = r101;
    }
}
