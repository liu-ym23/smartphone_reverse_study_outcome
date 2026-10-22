package com.bytedance.android.window.shop.widget;

import android.view.View;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolBarView f190060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e0 f190061b;

    public o(ToolBarView r100, e0 r101) {
        this.f190060a = r100;
        this.f190061b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = rp.a.f538829a;
        if (rp.a.a(r100.getId()) == false) goto L6;
        return;
    L6:
        if (this.f190061b.f189550k.isDoubleColumn() == false) goto L12;
        e0 r102 = this.f190061b;
        if (r102.f189550k.isNewLayout() == false) goto L10;
        WindowLayoutType r103 = WindowLayoutType.SINGLECOLUMN_V2;
    L11:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f189550k = r103;
    L17:
        Function2<String, Map<String, String>, Unit> r104 = this.f190060a.getDoEventAction();
        if (r104 == null) goto L24;
        Pair[] r105 = new Pair[1];
        if (this.f190061b.f189550k.isSingleColumn() == false) goto L22;
        String r106 = "single_product";
    L23:
        r105[0] = TuplesKt.to("switch_type", r106);
        Unit r107 = r104.invoke("store_product_form_switch_click", MapsKt.mutableMapOf(r105));
        goto L24
    L22:
        r106 = "double_product";
    L24:
        Function1<WindowLayoutType, Unit> r108 = this.f190060a.getLayoutChangeCallback();
        if (r108 == null) goto L27;
        Unit r109 = r108.invoke(this.f190061b.f189550k);
    L27:
        this.f190060a.U5(this.f190061b.f189550k);
        return;
    L10:
        r103 = WindowLayoutType.SINGLECOLUMN;
        goto L11
    L12:
        e0 r110 = this.f190061b;
        if (r110.f189550k.isNewLayout() == false) goto L15;
        WindowLayoutType r111 = WindowLayoutType.DOUBLECOLUMN_V2;
    L16:
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r110.f189550k = r111;
        goto L17
    L15:
        r111 = WindowLayoutType.DOUBLECOLUMN;
        goto L16
    }
}
