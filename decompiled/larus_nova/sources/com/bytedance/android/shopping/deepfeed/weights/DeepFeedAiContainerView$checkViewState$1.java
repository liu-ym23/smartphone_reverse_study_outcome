package com.bytedance.android.shopping.deepfeed.weights;

import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "text", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DeepFeedAiContainerView$checkViewState$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ InFeedProductV2 $data;
    final /* synthetic */ com.bytedance.android.shopping.deepfeed.action.i $parentAbility;

    public DeepFeedAiContainerView$checkViewState$1(com.bytedance.android.shopping.deepfeed.action.i r100, InFeedProductV2 r101) {
        this.$parentAbility = r100;
        this.$data = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (this.$parentAbility.isCardVisible() == true) goto L5;
        return;
    L5:
        if (this.$data.getDynamicData().f484851m.contains(r100) == true) goto L9;
        this.$parentAbility.T2(r100);
        this.$data.getDynamicData().f484851m.add(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
