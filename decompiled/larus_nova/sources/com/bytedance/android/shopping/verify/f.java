package com.bytedance.android.shopping.verify;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f187188c;

    @Override // com.bytedance.android.shopping.verify.c, android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f187188c.invoke();
        super.onClick(r100);
    }

    public f(String r100, int r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "mUrl");
        Intrinsics.checkNotNullParameter(r102, "spanClickListener");
        super(r100, r101);
        this.f187188c = r102;
    }
}
