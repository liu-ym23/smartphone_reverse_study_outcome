package com.bytedance.android.livesdk.interactivity.seek;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<g, e, f> f140798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f140799b;

    public final void a() {
        if (Intrinsics.areEqual(this.f140798a.b(), g.b.f140797a) == false) goto L6;
        e.a r100 = e.a.f140792a;
        StateMachine<g, e, f> r101 = this.f140798a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
        return;
    }

    public h(EpisodeSeekMessageServiceWidget.b r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f140799b = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<g, e, f>, Unit> r102 = new SeekMessageStateMachine$stateMachine$1(this);
        r101.getClass();
        this.f140798a = StateMachine.a.a(r102);
    }

    public final void b(boolean r100) {
        e.b r101 = new e.b(r100);
        StateMachine<g, e, f> r102 = this.f140798a;
        StateMachine.a r103 = StateMachine.f66079c;
        r102.d(r101, null);
    }
}
