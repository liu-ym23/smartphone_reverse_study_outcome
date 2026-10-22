package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import com.bytedance.android.ec.model.inflowfeed.Promotion;

/* JADX INFO: loaded from: classes13.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f175404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Promotion f175405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WindowNodeView f175406c;

    public s(int r100, Promotion r101, WindowNodeView r102) {
        this.f175404a = r100;
        this.f175405b = r101;
        this.f175406c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WindowNodeView r101 = this.f175406c;
        rd3.a r102 = r101.f175347c;
        if (r102 == null) goto L6;
        r101.a(r102, "pic", String.valueOf(this.f175404a), this.f175405b);
        return;
    }
}
