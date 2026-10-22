package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.live.kmp.statemachine.StateMachine;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class ConnectStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f91742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateMachine<ey.f, ey.e, ey.l> f91743b;

    public ConnectStateMachine(Function1<? super StateMachine.c<? extends ey.f, ? extends ey.e, ? extends ey.l>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f91742a = new ArrayList();
        StateMachine.a r101 = StateMachine.f255141c;
        ConnectStateMachine$stateMachine$1 r102 = new ConnectStateMachine$stateMachine$1(this, r100);
        r101.getClass();
        this.f91743b = StateMachine.a.a(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ey.l a(ey.e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        StateMachine.c r101 = StateMachine.c(this.f91743b, r100);
        if ((r101 instanceof StateMachine.c.b) == true) goto L5;
        r101 = null;
    L5:
        StateMachine.c.b r102 = (StateMachine.c.b) r101;
        if (r102 != null) goto L8;
        return null;
    L8:
        return (ey.l) r102.f255164d;
    }
}
