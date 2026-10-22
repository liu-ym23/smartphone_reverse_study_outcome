package com.stepos.datacenter.entity;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/datacenter/entity/FieldPriority;", "", "weightMultiplier", "", "<init>", "(Ljava/lang/String;IF)V", "getWeightMultiplier", "()F", "LOW", "NORMAL", "HIGH", "CRITICAL", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FieldPriority {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FieldPriority[] $VALUES;
    private final float weightMultiplier;
    public static final FieldPriority LOW = new FieldPriority("LOW", 0, 0.5f);
    public static final FieldPriority NORMAL = new FieldPriority("NORMAL", 1, 1.0f);
    public static final FieldPriority HIGH = new FieldPriority("HIGH", 2, 2.0f);
    public static final FieldPriority CRITICAL = new FieldPriority("CRITICAL", 3, 4.0f);

    private static final /* synthetic */ FieldPriority[] $values() {
        return new FieldPriority[]{LOW, NORMAL, HIGH, CRITICAL};
    }

    static {
        FieldPriority[] fieldPriorityArr$values = $values();
        $VALUES = fieldPriorityArr$values;
        $ENTRIES = a.a(fieldPriorityArr$values);
    }

    private FieldPriority(String str, int i10, float f10) {
        this.weightMultiplier = f10;
    }

    public static InterfaceC4149a<FieldPriority> getEntries() {
        return $ENTRIES;
    }

    public static FieldPriority valueOf(String str) {
        return (FieldPriority) Enum.valueOf(FieldPriority.class, str);
    }

    public static FieldPriority[] values() {
        return (FieldPriority[]) $VALUES.clone();
    }

    public final float getWeightMultiplier() {
        return this.weightMultiplier;
    }
}
