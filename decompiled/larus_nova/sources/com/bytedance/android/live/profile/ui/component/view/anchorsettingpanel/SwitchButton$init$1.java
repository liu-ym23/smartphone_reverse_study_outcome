package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class SwitchButton$init$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public SwitchButton$init$1(SwitchButton r100) {
        super(1, r100, SwitchButton.class, SendEventContainerMethodParamModel.EventKinds.onClick, "onClick(Landroid/view/View;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        SwitchButton r101 = (SwitchButton) this.receiver;
        boolean r102 = !r101.f86854c;
        r101.f86854c = r102;
        r101.a(r102);
        r101.b(r101.f86854c, true);
        Function1<? super Boolean, Unit> r103 = r101.f86855d;
        if (r103 == null) goto L6;
        Unit r104 = r103.invoke(Boolean.valueOf(r101.f86854c));
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
