package com.stepos.motionkit;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/motionkit/EasingType;", "", "<init>", "(Ljava/lang/String;I)V", "LINEAR", "EASE_IN", "EASE_OUT", "EASE_IN_OUT", "SPRING", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EasingType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ EasingType[] $VALUES;
    public static final EasingType LINEAR = new EasingType("LINEAR", 0);
    public static final EasingType EASE_IN = new EasingType("EASE_IN", 1);
    public static final EasingType EASE_OUT = new EasingType("EASE_OUT", 2);
    public static final EasingType EASE_IN_OUT = new EasingType("EASE_IN_OUT", 3);
    public static final EasingType SPRING = new EasingType("SPRING", 4);

    private static final /* synthetic */ EasingType[] $values() {
        return new EasingType[]{LINEAR, EASE_IN, EASE_OUT, EASE_IN_OUT, SPRING};
    }

    static {
        EasingType[] easingTypeArr$values = $values();
        $VALUES = easingTypeArr$values;
        $ENTRIES = a.a(easingTypeArr$values);
    }

    private EasingType(String str, int i10) {
    }

    public static InterfaceC4149a<EasingType> getEntries() {
        return $ENTRIES;
    }

    public static EasingType valueOf(String str) {
        return (EasingType) Enum.valueOf(EasingType.class, str);
    }

    public static EasingType[] values() {
        return (EasingType[]) $VALUES.clone();
    }
}
