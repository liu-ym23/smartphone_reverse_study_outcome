package com.bytedance.android.ec.common.impl.sku.view;

import android.text.TextUtils;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f43553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n.c f43554b;

    public q(n r100, n.c r101) {
        this.f43553a = r100;
        this.f43554b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        n r101 = this.f43553a;
        if (r101.f43543p == true) goto L5;
        return;
    L5:
        if (this.f43554b.f43544a == false) goto L32;
        n.c r102 = r101.f43534g;
        if (r102 == null) goto L12;
        Intrinsics.checkNotNull(r102);
        if (TextUtils.equals(r102.f43545b, this.f43554b.f43545b) == false) goto L12;
        n r103 = this.f43553a;
        r103.f43534g = null;
        r103.f43535h = false;
        r103.e(null);
    L17:
        n.b r104 = this.f43553a.f43538k;
        if (r104 == null) goto L20;
        r104.c();
    L20:
        n r105 = this.f43553a;
        n.b r106 = r105.f43538k;
        if (r106 == null) goto L23;
        r106.d(r105.f43537j, r105.f43534g, false);
    L23:
        n r107 = this.f43553a;
        if (r107.f43534g == null) goto L30;
        n.b r108 = r107.f43538k;
        if (r108 == null) goto L31;
        r108.a();
        return;
    L31:
        return;
    L30:
        return;
    L12:
        n.c r109 = this.f43554b;
        if (r109.f43544a == false) goto L17;
        n r110 = this.f43553a;
        r110.f43534g = r109;
        r110.f43535h = true;
        Intrinsics.checkNotNull(r109);
        r110.e(r109.f43545b);
        n r111 = this.f43553a;
        n.b r112 = r111.f43538k;
        if (r112 == null) goto L17;
        r112.b(r111.f43537j);
        goto L17
    }
}
