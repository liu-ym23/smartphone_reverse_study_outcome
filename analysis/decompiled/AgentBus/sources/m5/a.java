package m5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ a[] $VALUES;
    public static final a INFO = new a("INFO", 0);
    public static final a WARN = new a("WARN", 1);
    public static final a ERROR = new a("ERROR", 2);

    private static final /* synthetic */ a[] $values() {
        return new a[]{INFO, WARN, ERROR};
    }

    static {
        a[] aVarArr$values = $values();
        $VALUES = aVarArr$values;
        $ENTRIES = e0.s(aVarArr$values);
    }

    private a(String str, int i2) {
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
}
