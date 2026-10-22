package o4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class r {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ r[] $VALUES;
    public static final r ASSISTANT = new r("ASSISTANT", 0);
    public static final r CHAT_DELTA = new r("CHAT_DELTA", 1);
    public static final r CHAT_FINAL = new r("CHAT_FINAL", 2);

    private static final /* synthetic */ r[] $values() {
        return new r[]{ASSISTANT, CHAT_DELTA, CHAT_FINAL};
    }

    static {
        r[] rVarArr$values = $values();
        $VALUES = rVarArr$values;
        $ENTRIES = w7.e0.s(rVarArr$values);
    }

    private r(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) $VALUES.clone();
    }
}
