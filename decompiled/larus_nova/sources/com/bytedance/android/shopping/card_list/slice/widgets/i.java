package com.bytedance.android.shopping.card_list.slice.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CounterView f171859a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public i(CounterView r100) {
        this.f171859a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r110) {
        if (this.f171859a.f171786t.hasFocus() == true) goto L5;
        return;
    L5:
        Integer r111 = StringsKt.toIntOrNull(String.valueOf(r110));
        if (r111 == null) goto L20;
        int r112 = r111.intValue();
        if (r112 >= this.f171859a.getMinQuantity()) goto L14;
        CardListTrackerComponent r113 = CounterView.d(this.f171859a);
        if (r113 == null) goto L12;
        CardListTrackerComponent.h(r113, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f171859a.getMinLimitToast()), TuplesKt.to("product_id", this.f171859a.getProductId())}), 4);
    L12:
        ECToast.showToast$default(ECToast.INSTANCE, this.f171859a.getContext(), this.f171859a.getMinLimitToast(), 0, null, 8, null);
        CounterView r114 = this.f171859a;
        r114.h(r114.getMinQuantity());
        return;
    L14:
        if (r112 <= this.f171859a.getMaxQuantity()) goto L22;
        CardListTrackerComponent r115 = CounterView.d(this.f171859a);
        if (r115 == null) goto L18;
        CardListTrackerComponent.h(r115, "cart_list_toast_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("toast_word", this.f171859a.getMaxLimitToast()), TuplesKt.to("product_id", this.f171859a.getProductId())}), 4);
    L18:
        ECToast.showToast$default(ECToast.INSTANCE, this.f171859a.getContext(), this.f171859a.getMaxLimitToast(), 0, null, 8, null);
        CounterView r116 = this.f171859a;
        r116.h(r116.getMaxQuantity());
        return;
    L22:
        return;
    }
}
