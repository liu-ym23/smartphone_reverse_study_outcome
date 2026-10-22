package o4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e3 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ e3[] $VALUES;
    public static final e3 SIGNAL_RECONNECT = new e3("SIGNAL_RECONNECT", 0);
    public static final e3 KICK_RECONNECT = new e3("KICK_RECONNECT", 1);
    public static final e3 PROBE = new e3("PROBE", 2);
    public static final e3 KEEP = new e3("KEEP", 3);

    private static final /* synthetic */ e3[] $values() {
        return new e3[]{SIGNAL_RECONNECT, KICK_RECONNECT, PROBE, KEEP};
    }

    static {
        e3[] e3VarArr$values = $values();
        $VALUES = e3VarArr$values;
        $ENTRIES = w7.e0.s(e3VarArr$values);
    }

    private e3(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static e3 valueOf(String str) {
        return (e3) Enum.valueOf(e3.class, str);
    }

    public static e3[] values() {
        return (e3[]) $VALUES.clone();
    }
}
