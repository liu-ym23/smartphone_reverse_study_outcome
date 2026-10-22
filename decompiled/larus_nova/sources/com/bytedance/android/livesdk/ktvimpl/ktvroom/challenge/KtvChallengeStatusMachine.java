package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvChallengeStatusMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f144537a = 0;

    static {
    }

    public static StateMachine a(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        StateMachine.a r101 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<f, c, e>, Unit> r102 = new KtvChallengeStatusMachine$create$1(r100);
        r101.getClass();
        return StateMachine.a.a(r102);
    }
}
