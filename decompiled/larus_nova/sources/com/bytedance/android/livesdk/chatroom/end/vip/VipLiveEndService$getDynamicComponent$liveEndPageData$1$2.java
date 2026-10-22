package com.bytedance.android.livesdk.chatroom.end.vip;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class VipLiveEndService$getDynamicComponent$liveEndPageData$1$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public VipLiveEndService$getDynamicComponent$liveEndPageData$1$2(VipLiveEndService r100) {
        super(0, r100, VipLiveEndService.class, "onShowFragmentCallback", "onShowFragmentCallback()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((VipLiveEndService) this.receiver).f106131f.onNext(Boolean.TRUE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
