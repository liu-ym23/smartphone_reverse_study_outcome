package com.bytedance.android.shopping.card_list.widgets.nest;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class CardListLinkedScrollView$initView$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public CardListLinkedScrollView$initView$1$1$1(CardListLinkedScrollView r100) {
        super(0, r100, CardListLinkedScrollView.class, "gulViewSticky", "gulViewSticky()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CardListLinkedScrollView r100 = (CardListLinkedScrollView) this.receiver;
        int r101 = r100.f171966n.getTop();
        if (r101 <= 0) goto L6;
        r100.scrollBy(0, r101);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
