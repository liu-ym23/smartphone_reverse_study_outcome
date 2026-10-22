package com.bytedance.android.shopping.skubuy.platform.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlatformErrorView f183199a;

    public b(PlatformErrorView r100) {
        this.f183199a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function0<Unit> r101 = this.f183199a.f183183b;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
        return;
    }
}
