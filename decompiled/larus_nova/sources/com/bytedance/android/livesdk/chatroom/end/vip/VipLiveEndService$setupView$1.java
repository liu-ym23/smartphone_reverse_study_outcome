package com.bytedance.android.livesdk.chatroom.end.vip;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class VipLiveEndService$setupView$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public VipLiveEndService$setupView$1(VipLiveEndService r100) {
        super(1, r100, VipLiveEndService.class, "onJoinVipClick", "onJoinVipClick(Landroid/view/View;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        VipLiveEndService.a((VipLiveEndService) this.receiver);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
