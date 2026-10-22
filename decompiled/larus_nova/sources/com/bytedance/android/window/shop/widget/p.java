package com.bytedance.android.window.shop.widget;

import android.view.View;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.d f190062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ToolBarView f190063b;

    public p(com.bytedance.android.window.shop.repository.tab.entity.d r100, ToolBarView r101) {
        this.f190062a = r100;
        this.f190063b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = rp.a.f538829a;
        if (rp.a.a(r100.getId()) == false) goto L5;
        return;
    L5:
        Function2<String, Map<String, String>, Unit> r102 = this.f190063b.getDoEventAction();
        if (r102 == null) goto L8;
        Unit r103 = r102.invoke("win_goods_filter_button_click", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, this.f190062a.f189532b)));
    L8:
        com.bytedance.android.window.shop.repository.tab.entity.d r104 = this.f190062a;
        r104.f189533c = !r104.f189533c;
        this.f190063b.T5(r104);
        Function1<String, Unit> r105 = this.f190063b.getFilterTypeChangeCB();
        if (r105 == null) goto L12;
        StringBuilder r106 = new StringBuilder();
        r106.append(this.f190062a.f189531a);
        r106.append('_');
        r106.append(this.f190062a.f189533c ? 1 : 0);
        Unit r107 = r105.invoke(r106.toString());
        return;
    }
}
