package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f92916a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f92917b = null;

    static {
        int[] r100 = new int[PkBaseStateMachine.Source.values().length];
        f92916a = r100;
        PkBaseStateMachine.Source r101 = PkBaseStateMachine.Source.BattleFinishInstantKill;
        r100[r101.ordinal()] = 1;
        PkBaseStateMachine.Source r102 = PkBaseStateMachine.Source.BattleFinishTimeUp;
        r100[r102.ordinal()] = 2;
        PkBaseStateMachine.Source r103 = PkBaseStateMachine.Source.PKTimeUp;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[PkBaseStateMachine.Source.values().length];
        f92917b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
