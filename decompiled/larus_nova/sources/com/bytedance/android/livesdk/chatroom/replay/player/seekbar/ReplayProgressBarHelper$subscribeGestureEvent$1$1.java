package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljm1/c;", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE, "(Ljm1/c;Z)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ReplayProgressBarHelper$subscribeGestureEvent$1$1 extends FunctionReferenceImpl implements Function2<jm1.c, Boolean, Unit> {
    public static final ReplayProgressBarHelper$subscribeGestureEvent$1$1 INSTANCE = null;

    static {
        INSTANCE = new ReplayProgressBarHelper$subscribeGestureEvent$1$1();
    }

    public ReplayProgressBarHelper$subscribeGestureEvent$1$1() {
        super(2, jm1.c.class, "onProgressBarStartTracking", "onProgressBarStartTracking(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(jm1.c r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(jm1.c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        r100.Xa(r101);
    }
}
