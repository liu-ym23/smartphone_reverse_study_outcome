package com.bytedance.android.shopping.buynow.slice.counter;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BuyNowCounterView$registerKeyboardChangedListener$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ BuyNowCounterView this$0;

    public BuyNowCounterView$registerKeyboardChangedListener$1(BuyNowCounterView r100) {
        this.this$0 = r100;
        super(1);
    }

    public final void invoke(int r100) {
        this.this$0.f171069n.clearFocus();
        this.this$0.d(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
