package com.stepos.ailauncher.migu.play;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/migu/play/MiguBindPhase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "BINDING", "BOUND", "FAILED", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MiguBindPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MiguBindPhase[] $VALUES;
    public static final MiguBindPhase IDLE = new MiguBindPhase("IDLE", 0);
    public static final MiguBindPhase BINDING = new MiguBindPhase("BINDING", 1);
    public static final MiguBindPhase BOUND = new MiguBindPhase("BOUND", 2);
    public static final MiguBindPhase FAILED = new MiguBindPhase("FAILED", 3);

    private static final /* synthetic */ MiguBindPhase[] $values() {
        return new MiguBindPhase[]{IDLE, BINDING, BOUND, FAILED};
    }

    static {
        MiguBindPhase[] miguBindPhaseArr$values = $values();
        $VALUES = miguBindPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(miguBindPhaseArr$values);
    }

    private MiguBindPhase(String str, int i10) {
    }

    public static InterfaceC4149a<MiguBindPhase> getEntries() {
        return $ENTRIES;
    }

    public static MiguBindPhase valueOf(String str) {
        return (MiguBindPhase) Enum.valueOf(MiguBindPhase.class, str);
    }

    public static MiguBindPhase[] values() {
        return (MiguBindPhase[]) $VALUES.clone();
    }
}
