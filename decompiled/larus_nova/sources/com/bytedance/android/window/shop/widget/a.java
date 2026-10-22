package com.bytedance.android.window.shop.widget;

import android.view.View;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickSeparatedTabSelectListener f189967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECTabLayout.Tab f189968b;

    public a(ECWindowTabLayout.c r100, ECTabLayout.Tab r101) {
        this.f189967a = r100;
        this.f189968b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f189967a.f189822a.put(this.f189968b, Boolean.TRUE);
    }
}
