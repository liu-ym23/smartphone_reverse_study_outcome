package com.bytedance.android.shopping.deepfeed.weights;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f174225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f174226b;

    public e(int r100, Function1 r101) {
        this.f174225a = r100;
        this.f174226b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1 r101 = this.f174226b;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(Integer.valueOf(this.f174225a));
        return;
    }
}
