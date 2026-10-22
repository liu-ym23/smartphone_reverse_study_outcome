package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class BaseInfoServiceSnapshotTransitionController$findAttachedBaseInfoGroup$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public BaseInfoServiceSnapshotTransitionController$findAttachedBaseInfoGroup$1(BaseInfoServiceSnapshotTransitionController r100) {
        super(1, r100, BaseInfoServiceSnapshotTransitionController.class, "isBaseInfoGroupSliceId", "isBaseInfoGroupSliceId(Ljava/lang/String;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((BaseInfoServiceSnapshotTransitionController) this.receiver).getClass();
        if (Intrinsics.areEqual(r100, "BaseInfoGroupV2") == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "BaseInfoGroup") == false) goto L7;
        return true;
    L7:
        if (StringsKt.contains(r100, "BaseInfoGroup", true) == true) goto L9;
    L11:
        return false;
    L9:
        if (StringsKt.contains(r100, "Mask", true) == true) goto L11;
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
