package k5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class n {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ n[] $VALUES;
    public static final n INFO = new n("INFO", 0);
    public static final n WARN = new n("WARN", 1);
    public static final n ERROR = new n("ERROR", 2);
    public static final n FATAL = new n("FATAL", 3);

    private static final /* synthetic */ n[] $values() {
        return new n[]{INFO, WARN, ERROR, FATAL};
    }

    static {
        n[] nVarArr$values = $values();
        $VALUES = nVarArr$values;
        $ENTRIES = e0.s(nVarArr$values);
    }

    private n(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) $VALUES.clone();
    }
}
