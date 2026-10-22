package com.bytedance.android.window.shop.widget;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final class v implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f190124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uq3.e f190125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f190126c;

    public v(Function1 r100, uq3.e r101, Function2 r102) {
        this.f190124a = r100;
        this.f190125b = r101;
        this.f190126c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Function1 r101 = this.f190124a;
        if (r101 == null) goto L5;
        Unit r102 = (Unit) r101.invoke(this.f190125b.f551222e);
    L5:
        Function2 r103 = this.f190126c;
        if (r103 == null) goto L13;
        Integer r104 = this.f190125b.f551223f;
        if (r104 == null) goto L10;
        String r105 = String.valueOf(r104.intValue());
    L11:
        Unit r106 = (Unit) r103.invoke("bubble_click", r105);
        return;
    L10:
        r105 = null;
        goto L11
    }
}
