package kotlin.reflect.jvm.internal.impl.km;

import h9.InterfaceC4149a;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class KmEffectType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ KmEffectType[] $VALUES;
    public static final KmEffectType RETURNS_CONSTANT = new KmEffectType("RETURNS_CONSTANT", 0);
    public static final KmEffectType CALLS = new KmEffectType("CALLS", 1);
    public static final KmEffectType RETURNS_NOT_NULL = new KmEffectType("RETURNS_NOT_NULL", 2);

    private static final /* synthetic */ KmEffectType[] $values() {
        return new KmEffectType[]{RETURNS_CONSTANT, CALLS, RETURNS_NOT_NULL};
    }

    static {
        KmEffectType[] kmEffectTypeArr$values = $values();
        $VALUES = kmEffectTypeArr$values;
        $ENTRIES = a.a(kmEffectTypeArr$values);
    }

    private KmEffectType(String str, int i10) {
    }

    public static KmEffectType valueOf(String str) {
        return (KmEffectType) Enum.valueOf(KmEffectType.class, str);
    }

    public static KmEffectType[] values() {
        return (KmEffectType[]) $VALUES.clone();
    }
}
