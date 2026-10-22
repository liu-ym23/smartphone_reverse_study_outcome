package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class BreakThroughStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<d, b, c> f97254a;

    public BreakThroughStateMachine(final Function1<? super StateMachine.c<? extends d, ? extends b, ? extends c>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        StateMachine.a r101 = StateMachine.f255141c;
        Function1<StateMachine.GraphBuilder<d, b, c>, Unit> r102 = new BreakThroughStateMachine$stateMachine$1(r100);
        r101.getClass();
        this.f97254a = StateMachine.a.a(r102);
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine.c(this.f97254a, r100);
    }
}
