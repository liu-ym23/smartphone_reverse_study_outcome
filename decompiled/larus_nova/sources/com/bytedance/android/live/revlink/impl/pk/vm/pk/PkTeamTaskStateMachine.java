package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PkTeamTaskStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<g, h, i> f97266a;

    public PkTeamTaskStateMachine(final Function1<? super StateMachine.c<? extends g, ? extends h, ? extends i>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        StateMachine.a r101 = StateMachine.f255141c;
        Function1<StateMachine.GraphBuilder<g, h, i>, Unit> r102 = new PkTeamTaskStateMachine$stateMachine$1(r100);
        r101.getClass();
        this.f97266a = StateMachine.a.a(r102);
    }

    public final void a(h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine.c(this.f97266a, r100);
    }
}
