package com.stepos.motionkit;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/motionkit/EndBehavior;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "FREEZE", "RELEASE", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EndBehavior {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ EndBehavior[] $VALUES;
    public static final EndBehavior FREEZE = new EndBehavior("FREEZE", 0);
    public static final EndBehavior RELEASE = new EndBehavior("RELEASE", 1);

    private static final /* synthetic */ EndBehavior[] $values() {
        return new EndBehavior[]{FREEZE, RELEASE};
    }

    static {
        EndBehavior[] endBehaviorArr$values = $values();
        $VALUES = endBehaviorArr$values;
        $ENTRIES = kotlin.enums.a.a(endBehaviorArr$values);
    }

    private EndBehavior(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static EndBehavior valueOf(String str) {
        return (EndBehavior) Enum.valueOf(EndBehavior.class, str);
    }

    public static EndBehavior[] values() {
        return (EndBehavior[]) $VALUES.clone();
    }
}
