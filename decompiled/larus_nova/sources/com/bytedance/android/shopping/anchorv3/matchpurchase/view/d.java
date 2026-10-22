package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuideTagView f165246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p63.c f165247b;

    public d(GuideTagView r100, p63.c r101) {
        this.f165246a = r100;
        this.f165247b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Map<String, String> r101 = t63.a.f544661a;
        t63.a.a(this.f165246a.getContext(), this.f165247b.f527884d);
    }
}
