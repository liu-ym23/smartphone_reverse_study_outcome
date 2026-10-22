package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowNodeView f175396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rd3.a f175397b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        WindowNodeView r101 = this.f175396a;
        rd3.a r102 = this.f175397b;
        int r103 = WindowNodeView.f175344l;
        r101.a(r102, "else", null, null);
    }

    public o(WindowNodeView r100, rd3.a r101) {
        this.f175396a = r100;
        this.f175397b = r101;
    }
}
