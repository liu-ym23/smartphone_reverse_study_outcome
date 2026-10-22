package com.bytedance.android.ec.core.widget;

import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECAuctionStatusLayout$bindInList$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECPromotionAuctionInfo $auctionInfo;
    final /* synthetic */ Function0 $countDownAction;
    final /* synthetic */ ECAuctionStatusLayout this$0;

    public ECAuctionStatusLayout$bindInList$1(ECAuctionStatusLayout r100, ECPromotionAuctionInfo r101, Function0 r102) {
        this.this$0 = r100;
        this.$auctionInfo = r101;
        this.$countDownAction = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.e(this.$auctionInfo) == false) goto L8;
        Function0 r100 = this.$countDownAction;
        if (r100 == null) goto L9;
        Unit r101 = (Unit) r100.invoke();
        return;
    L9:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
