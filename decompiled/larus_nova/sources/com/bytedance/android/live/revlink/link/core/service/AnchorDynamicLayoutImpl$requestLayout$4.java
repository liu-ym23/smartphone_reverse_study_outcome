package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class AnchorDynamicLayoutImpl$requestLayout$4 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public AnchorDynamicLayoutImpl$requestLayout$4(AnchorDynamicLayoutImpl r100) {
        super(1, r100, AnchorDynamicLayoutImpl.class, "onSnapShotRefreshFailed", "onSnapShotRefreshFailed(Ljava/lang/String;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        AnchorDynamicLayoutImpl r101 = (AnchorDynamicLayoutImpl) this.receiver;
        int r102 = AnchorDynamicLayoutImpl.f98316g;
        r101.getClass();
        jy0.b.c("RevenueDynamicLayoutClient", "requestLayout fail for snapshot no change with reason: " + r100, null, 4);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
