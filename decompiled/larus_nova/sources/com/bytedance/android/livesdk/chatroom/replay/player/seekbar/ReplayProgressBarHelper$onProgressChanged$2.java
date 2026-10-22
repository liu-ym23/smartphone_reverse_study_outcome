package com.bytedance.android.livesdk.chatroom.replay.player.seekbar;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Ljm1/c;", "p1", "", "p2", "", "p3", "", "p4", "", AbsMethodDelegate.TAG_INVOKE, "(Ljm1/c;FZJ)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ReplayProgressBarHelper$onProgressChanged$2 extends FunctionReferenceImpl implements Function4<jm1.c, Float, Boolean, Long, Unit> {
    public static final ReplayProgressBarHelper$onProgressChanged$2 INSTANCE = null;

    static {
        INSTANCE = new ReplayProgressBarHelper$onProgressChanged$2();
    }

    public ReplayProgressBarHelper$onProgressChanged$2() {
        super(4, jm1.c.class, "onProgressChanged", "onProgressChanged(FZJ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(jm1.c r100, Float r101, Boolean r102, Long r110) {
        invoke(r100, r101.floatValue(), r102.booleanValue(), r110.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(jm1.c r100, float r101, boolean r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        r100.Pc(r101, r102, r103);
    }
}
