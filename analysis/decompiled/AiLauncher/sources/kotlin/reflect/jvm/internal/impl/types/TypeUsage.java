package kotlin.reflect.jvm.internal.impl.types;

import h9.InterfaceC4149a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class TypeUsage {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TypeUsage[] $VALUES;
    public static final TypeUsage SUPERTYPE = new TypeUsage("SUPERTYPE", 0);
    public static final TypeUsage COMMON = new TypeUsage("COMMON", 1);

    private static final /* synthetic */ TypeUsage[] $values() {
        return new TypeUsage[]{SUPERTYPE, COMMON};
    }

    static {
        TypeUsage[] typeUsageArr$values = $values();
        $VALUES = typeUsageArr$values;
        $ENTRIES = kotlin.enums.a.a(typeUsageArr$values);
    }

    private TypeUsage(String str, int i10) {
    }

    public static TypeUsage valueOf(String str) {
        return (TypeUsage) Enum.valueOf(TypeUsage.class, str);
    }

    public static TypeUsage[] values() {
        return (TypeUsage[]) $VALUES.clone();
    }
}
