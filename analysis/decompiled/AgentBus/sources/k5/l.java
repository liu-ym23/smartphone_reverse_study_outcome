package k5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class l {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ l[] $VALUES;
    public static final l DEDUP = new l("DEDUP", 0);
    public static final l TIMEOUT = new l("TIMEOUT", 1);
    public static final l QUEUE_OVERFLOW = new l("QUEUE_OVERFLOW", 2);
    public static final l ORPHAN = new l("ORPHAN", 3);
    public static final l INVALID = new l("INVALID", 4);

    private static final /* synthetic */ l[] $values() {
        return new l[]{DEDUP, TIMEOUT, QUEUE_OVERFLOW, ORPHAN, INVALID};
    }

    static {
        l[] lVarArr$values = $values();
        $VALUES = lVarArr$values;
        $ENTRIES = e0.s(lVarArr$values);
    }

    private l(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) $VALUES.clone();
    }
}
