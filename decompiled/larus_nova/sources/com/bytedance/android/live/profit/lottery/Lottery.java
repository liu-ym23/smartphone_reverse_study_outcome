package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.core.utils.StateMachine;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class Lottery implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublishSubject<k3> f87924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject f87925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateMachine<LotteryState, LotteryAction, Unit> f87927d;

    @Override // com.bytedance.android.live.profit.lottery.g
    public final LotteryState getState() {
        return this.f87927d.b();
    }

    public final String toString() {
        return this.f87926c + '(' + getState() + ')';
    }

    @Override // com.bytedance.android.live.profit.lottery.g
    public final PublishSubject a() {
        return this.f87925b;
    }

    public Lottery(final LotteryState r100) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        PublishSubject<k3> r101 = PublishSubject.create();
        this.f87924a = r101;
        this.f87925b = r101;
        this.f87926c = "Lottery@" + com.bytedance.android.live.core.utils.z0.c(this);
        StateMachine.a r102 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<LotteryState, LotteryAction, Unit>, Unit> r103 = new Lottery$stateMachine$1(this, r100);
        r102.getClass();
        this.f87927d = StateMachine.a.a(r103);
    }

    public final void b(LotteryAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        LinkedHashMap<String, String> r101 = LotteryTraceMonitor.f88034a;
        LotteryTraceMonitor.b(LotteryTraceMonitor.EventName.lottery_action_change.name(), "to action = ".concat(r100.getClass().getSimpleName()));
        StateMachine<LotteryState, LotteryAction, Unit> r102 = this.f87927d;
        StateMachine.a r103 = StateMachine.f66079c;
        boolean r104 = r102.d(r100, null) instanceof StateMachine.c.b;
    }
}
