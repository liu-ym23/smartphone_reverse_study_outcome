package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import com.bytedance.android.live.revlink.impl.player.h;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import rc0.p;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/player/h;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/revlink/impl/player/h;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class StreamLayoutManager$shouldDeal$1 extends FunctionReferenceImpl implements Function1<h, Unit> {
    public StreamLayoutManager$shouldDeal$1(StreamLayoutManager r100) {
        super(1, r100, StreamLayoutManager.class, "relayoutPlayer", "relayoutPlayer(Lcom/bytedance/android/live/revlink/impl/player/PlayerLayout;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(h r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Function1<p, Unit> r101 = ((StreamLayoutManager) this.receiver).f94588l;
        Intrinsics.checkNotNullParameter(r100, "$this$toExternal");
        r101.invoke(new p(r100.f97426a, r100.f97427b, r100.f97428c, r100.f97429d));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(h r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
