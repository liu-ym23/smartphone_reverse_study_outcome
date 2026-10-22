package n5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ a[] $VALUES;
    private final int severity;
    public static final a NONE = new a("NONE", 0, 0);
    public static final a L1_TRANSPORT = new a("L1_TRANSPORT", 1, 1);
    public static final a L2_ROUTER = new a("L2_ROUTER", 2, 2);
    public static final a L3_APPLICATION = new a("L3_APPLICATION", 3, 3);

    private static final /* synthetic */ a[] $values() {
        return new a[]{NONE, L1_TRANSPORT, L2_ROUTER, L3_APPLICATION};
    }

    static {
        a[] aVarArr$values = $values();
        $VALUES = aVarArr$values;
        $ENTRIES = e0.s(aVarArr$values);
    }

    private a(String str, int i2, int i10) {
        this.severity = i10;
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) $VALUES.clone();
    }

    public final int getSeverity() {
        return this.severity;
    }
}
