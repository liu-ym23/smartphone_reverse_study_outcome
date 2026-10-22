package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.message;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<e, c, d> f109273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f109274b;

    public final void a() {
        if (Intrinsics.areEqual(this.f109273a.b(), e.b.f109272a) == false) goto L6;
        c.a r100 = c.a.f109267a;
        StateMachine<e, c, d> r101 = this.f109273a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
        return;
    }

    public f(ReplaySeekMessageServiceWidget.a r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f109274b = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<e, c, d>, Unit> r102 = new ReplaySeekMessageStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f109273a = StateMachine.a.a(r102);
    }
}
