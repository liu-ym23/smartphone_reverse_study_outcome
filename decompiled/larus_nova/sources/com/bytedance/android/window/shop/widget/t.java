package com.bytedance.android.window.shop.widget;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f190112a;

    public t(Function1 r100) {
        this.f190112a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1 r101 = this.f190112a;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(null);
        return;
    }
}
