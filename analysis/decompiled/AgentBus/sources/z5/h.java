package z5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class h {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ h[] $VALUES;
    public static final h INFO = new h("INFO", 0);
    public static final h WARN = new h("WARN", 1);
    public static final h ERROR = new h("ERROR", 2);

    private static final /* synthetic */ h[] $values() {
        return new h[]{INFO, WARN, ERROR};
    }

    static {
        h[] hVarArr$values = $values();
        $VALUES = hVarArr$values;
        $ENTRIES = e0.s(hVarArr$values);
    }

    private h(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) $VALUES.clone();
    }
}
