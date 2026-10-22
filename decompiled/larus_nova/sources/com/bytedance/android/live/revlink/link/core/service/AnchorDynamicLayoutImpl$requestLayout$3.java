package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/layoutstatus/n;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/revlink/link/core/layoutstatus/n;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class AnchorDynamicLayoutImpl$requestLayout$3 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.revlink.link.core.layoutstatus.n, Unit> {
    public AnchorDynamicLayoutImpl$requestLayout$3(AnchorDynamicLayoutImpl r100) {
        super(1, r100, AnchorDynamicLayoutImpl.class, "onSnapShotRefresh", "onSnapShotRefresh(Lcom/bytedance/android/live/revlink/link/core/layoutstatus/RequestLayoutSnapShot;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.android.live.revlink.link.core.layoutstatus.n r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        AnchorDynamicLayoutImpl.a((AnchorDynamicLayoutImpl) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.android.live.revlink.link.core.layoutstatus.n r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
