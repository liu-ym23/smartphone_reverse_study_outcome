package com.bytedance.android.shopping.card_list.utils;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CardListExtentionsKt$scrollToBottom$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RecyclerView $this_scrollToBottom;

    public CardListExtentionsKt$scrollToBottom$1(RecyclerView r100) {
        this.$this_scrollToBottom = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RecyclerView.Adapter r100 = this.$this_scrollToBottom.getAdapter();
        if (r100 == null) goto L14;
        Integer r101 = Integer.valueOf(r100.getItemCount());
        if (r101.intValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        int r103 = r101.intValue();
        this.$this_scrollToBottom.scrollToPosition(r103 - 1);
        return;
    L15:
        return;
    L7:
        r102 = false;
        goto L8
    }
}
