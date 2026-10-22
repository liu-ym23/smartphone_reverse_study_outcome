package com.stepos.core.model.task;

import com.stepos.core.common.telemetry.FailStage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ExecutionLocation {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ ExecutionLocation[] $VALUES;
    public static final ExecutionLocation UNKNOWN = new ExecutionLocation(FailStage.UNKNOWN, 0);
    public static final ExecutionLocation LOCAL = new ExecutionLocation("LOCAL", 1);
    public static final ExecutionLocation CLOUD = new ExecutionLocation("CLOUD", 2);

    private static final /* synthetic */ ExecutionLocation[] $values() {
        return new ExecutionLocation[]{UNKNOWN, LOCAL, CLOUD};
    }

    static {
        ExecutionLocation[] executionLocationArr$values = $values();
        $VALUES = executionLocationArr$values;
        $ENTRIES = kotlin.enums.a.a(executionLocationArr$values);
    }

    private ExecutionLocation(String str, int i10) {
    }

    public static sb.a<ExecutionLocation> getEntries() {
        return $ENTRIES;
    }

    public static ExecutionLocation valueOf(String str) {
        return (ExecutionLocation) Enum.valueOf(ExecutionLocation.class, str);
    }

    public static ExecutionLocation[] values() {
        return (ExecutionLocation[]) $VALUES.clone();
    }
}
