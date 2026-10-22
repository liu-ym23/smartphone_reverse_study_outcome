package com.stepos.aicgroup.memory;

import com.stepos.aicgroup.MemoryState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PressureLevel {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ PressureLevel[] $VALUES;
    private final int level;
    public static final PressureLevel NORMAL = new PressureLevel("NORMAL", 0, 0);
    public static final PressureLevel LOW = new PressureLevel("LOW", 1, 1);
    public static final PressureLevel ULTRA_LOW = new PressureLevel("ULTRA_LOW", 2, 2);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PressureLevel.values().length];
            try {
                iArr[PressureLevel.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PressureLevel.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PressureLevel.ULTRA_LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ PressureLevel[] $values() {
        return new PressureLevel[]{NORMAL, LOW, ULTRA_LOW};
    }

    static {
        PressureLevel[] pressureLevelArr$values = $values();
        $VALUES = pressureLevelArr$values;
        $ENTRIES = kotlin.enums.a.a(pressureLevelArr$values);
    }

    private PressureLevel(String str, int i10, int i11) {
        this.level = i11;
    }

    public static a<PressureLevel> getEntries() {
        return $ENTRIES;
    }

    public static PressureLevel valueOf(String str) {
        return (PressureLevel) Enum.valueOf(PressureLevel.class, str);
    }

    public static PressureLevel[] values() {
        return (PressureLevel[]) $VALUES.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public final boolean isHigherThan(PressureLevel other) {
        g.f(other, "other");
        return this.level > other.level;
    }

    public final MemoryState toMemoryState() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i10 == 1) {
            return MemoryState.NORMAL;
        }
        if (i10 == 2) {
            return MemoryState.LOW;
        }
        if (i10 == 3) {
            return MemoryState.ULTRA_LOW;
        }
        throw new NoWhenBranchMatchedException();
    }
}
