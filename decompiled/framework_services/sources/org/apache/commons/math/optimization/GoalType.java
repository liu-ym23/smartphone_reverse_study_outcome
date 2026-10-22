package org.apache.commons.math.optimization;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final enum GoalType extends Enum<GoalType> implements Serializable {
    private static final /* synthetic */ GoalType[] $VALUES = null;
    public static final GoalType MAXIMIZE = null;
    public static final GoalType MINIMIZE = null;

    private static /* synthetic */ GoalType[] $values() {
        return new GoalType[]{MAXIMIZE, MINIMIZE};
    }

    private GoalType(String r1, int r2) {
        super(r1, r2);
    }

    public static GoalType valueOf(String name) {
        return (GoalType) Enum.valueOf(GoalType.class, name);
    }

    public static GoalType[] values() {
        return (GoalType[]) $VALUES.clone();
    }

    static {
        MAXIMIZE = new GoalType("MAXIMIZE", 0);
        MINIMIZE = new GoalType("MINIMIZE", 1);
        $VALUES = $values();
    }
}
