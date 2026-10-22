package com.bytedance.android.livesdk.gamesticker.hok.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gamesticker.hok.HokGameStickerView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class BattleMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateMachine<c, a, b> f125607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HokGameStickerView f125608b;

    public BattleMachine(HokGameStickerView r100) {
        Intrinsics.checkNotNullParameter(r100, "stickerView");
        this.f125608b = r100;
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r102 = new BattleMachine$machine$1(this);
        r101.getClass();
        this.f125607a = StateMachine.a.a(r102);
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Objects.toString(r100);
        StateMachine<c, a, b> r101 = this.f125607a;
        StateMachine.a r102 = StateMachine.f66079c;
        r101.d(r100, null);
    }
}
