package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import com.bytedance.android.window.shop.innerflow.widget.ControllerState;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;", "p1", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$1 extends FunctionReferenceImpl implements Function1<ControllerState, ControllerState> {
    public ECWindowInnerFlowVideoElementPresenter$doControllerInitialize$1(ECWindowInnerFlowVideoElementPresenter.a r100) {
        super(1, r100, ECWindowInnerFlowVideoElementPresenter.a.class, "doStateTransform", "doStateTransform(Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;)Lcom/bytedance/android/window/shop/innerflow/widget/ControllerState;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ControllerState invoke2(ControllerState r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((ECWindowInnerFlowVideoElementPresenter.a) this.receiver).getClass();
        return ECWindowInnerFlowVideoElementPresenter.a.a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ControllerState invoke(ControllerState r100) {
        return invoke2(r100);
    }
}
