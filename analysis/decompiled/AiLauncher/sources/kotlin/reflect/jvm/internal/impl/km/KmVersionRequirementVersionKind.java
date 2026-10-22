package kotlin.reflect.jvm.internal.impl.km;

import h9.InterfaceC4149a;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class KmVersionRequirementVersionKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ KmVersionRequirementVersionKind[] $VALUES;
    public static final KmVersionRequirementVersionKind LANGUAGE_VERSION = new KmVersionRequirementVersionKind("LANGUAGE_VERSION", 0);
    public static final KmVersionRequirementVersionKind COMPILER_VERSION = new KmVersionRequirementVersionKind("COMPILER_VERSION", 1);
    public static final KmVersionRequirementVersionKind API_VERSION = new KmVersionRequirementVersionKind("API_VERSION", 2);
    public static final KmVersionRequirementVersionKind UNKNOWN = new KmVersionRequirementVersionKind("UNKNOWN", 3);

    private static final /* synthetic */ KmVersionRequirementVersionKind[] $values() {
        return new KmVersionRequirementVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION, UNKNOWN};
    }

    static {
        KmVersionRequirementVersionKind[] kmVersionRequirementVersionKindArr$values = $values();
        $VALUES = kmVersionRequirementVersionKindArr$values;
        $ENTRIES = a.a(kmVersionRequirementVersionKindArr$values);
    }

    private KmVersionRequirementVersionKind(String str, int i10) {
    }

    public static KmVersionRequirementVersionKind valueOf(String str) {
        return (KmVersionRequirementVersionKind) Enum.valueOf(KmVersionRequirementVersionKind.class, str);
    }

    public static KmVersionRequirementVersionKind[] values() {
        return (KmVersionRequirementVersionKind[]) $VALUES.clone();
    }
}
