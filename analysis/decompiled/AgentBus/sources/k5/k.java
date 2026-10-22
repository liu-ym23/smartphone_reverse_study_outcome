package k5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class k {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ k[] $VALUES;
    public static final k INBOUND = new k("INBOUND", 0);
    public static final k OUTBOUND = new k("OUTBOUND", 1);

    private static final /* synthetic */ k[] $values() {
        return new k[]{INBOUND, OUTBOUND};
    }

    static {
        k[] kVarArr$values = $values();
        $VALUES = kVarArr$values;
        $ENTRIES = e0.s(kVarArr$values);
    }

    private k(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) $VALUES.clone();
    }
}
