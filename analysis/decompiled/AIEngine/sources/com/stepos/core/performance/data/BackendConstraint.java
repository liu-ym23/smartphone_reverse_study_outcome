package com.stepos.core.performance.data;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BackendConstraint {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ BackendConstraint[] $VALUES;
    public static final BackendConstraint FREE = new BackendConstraint("FREE", 0);
    public static final BackendConstraint CPU_ONLY = new BackendConstraint("CPU_ONLY", 1);

    private static final /* synthetic */ BackendConstraint[] $values() {
        return new BackendConstraint[]{FREE, CPU_ONLY};
    }

    static {
        BackendConstraint[] backendConstraintArr$values = $values();
        $VALUES = backendConstraintArr$values;
        $ENTRIES = kotlin.enums.a.a(backendConstraintArr$values);
    }

    private BackendConstraint(String str, int i10) {
    }

    public static a<BackendConstraint> getEntries() {
        return $ENTRIES;
    }

    public static BackendConstraint valueOf(String str) {
        return (BackendConstraint) Enum.valueOf(BackendConstraint.class, str);
    }

    public static BackendConstraint[] values() {
        return (BackendConstraint[]) $VALUES.clone();
    }
}
