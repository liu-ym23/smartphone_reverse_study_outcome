package com.bytedance.android.shopping.widget.buybutton;

import android.view.View;
import com.bytedance.android.ec.model.ClickButtonParam;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f187301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ClickButtonParam f187302b;

    public h(g r100, ClickButtonParam r101) {
        this.f187301a = r100;
        this.f187302b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b r101 = this.f187301a.f187297b;
        if (r101 == null) goto L6;
        r101.b();
    L6:
        if (Intrinsics.areEqual(this.f187302b.getEnterFrom(), com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL) == false) goto L10;
        b r102 = this.f187301a.f187297b;
        if (r102 == null) goto L15;
        r102.e();
        return;
    L15:
        return;
    L10:
        g r103 = this.f187301a;
        c r104 = r103.f187300e;
        String r105 = r103.f187296a.f187277c;
        Pair[] r106 = new Pair[1];
        String r107 = this.f187302b.getEnterFrom();
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        r106[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_THREE_D, r107);
        r104.b(r105, MapsKt.hashMapOf(r106), MapsKt.hashMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, this.f187302b.getEntranceInfo())}));
    }
}
