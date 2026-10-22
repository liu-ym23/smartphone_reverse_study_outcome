package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LittleWindowLayer$createCastLittleWindow$1 extends FunctionReferenceImpl implements Function1<ViewGroup, Unit> {
    public LittleWindowLayer$createCastLittleWindow$1(com.bytedance.android.live.broadcastgame.api.xplay.h r100) {
        super(1, r100, com.bytedance.android.live.broadcastgame.api.xplay.h.class, "onCreateView", "onCreateView(Landroid/view/ViewGroup;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        ((com.bytedance.android.live.broadcastgame.api.xplay.h) this.receiver).b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewGroup r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
