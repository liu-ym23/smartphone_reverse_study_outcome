package com.bytedance.android.livesdk.coupon.customview;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f121845a;

    public g(Function1 r100) {
        this.f121845a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View r100) {
        this.f121845a.invoke(r100);
    }
}
