package o4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class h1 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ h1[] $VALUES;
    public static final h1 IDLE = new h1("IDLE", 0);
    public static final h1 CONNECTING = new h1("CONNECTING", 1);
    public static final h1 ONLINE = new h1("ONLINE", 2);
    public static final h1 OFFLINE = new h1("OFFLINE", 3);

    private static final /* synthetic */ h1[] $values() {
        return new h1[]{IDLE, CONNECTING, ONLINE, OFFLINE};
    }

    static {
        h1[] h1VarArr$values = $values();
        $VALUES = h1VarArr$values;
        $ENTRIES = w7.e0.s(h1VarArr$values);
    }

    private h1(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static h1 valueOf(String str) {
        return (h1) Enum.valueOf(h1.class, str);
    }

    public static h1[] values() {
        return (h1[]) $VALUES.clone();
    }
}
