package w5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ b[] $VALUES;
    public static final b PENDING = new b("PENDING", 0);
    public static final b RUNNING = new b("RUNNING", 1);
    public static final b PASS = new b("PASS", 2);
    public static final b WARNING = new b("WARNING", 3);
    public static final b FAIL = new b("FAIL", 4);
    public static final b SKIPPED = new b("SKIPPED", 5);
    public static final b TIMEOUT = new b("TIMEOUT", 6);

    private static final /* synthetic */ b[] $values() {
        return new b[]{PENDING, RUNNING, PASS, WARNING, FAIL, SKIPPED, TIMEOUT};
    }

    static {
        b[] bVarArr$values = $values();
        $VALUES = bVarArr$values;
        $ENTRIES = w7.e0.s(bVarArr$values);
    }

    private b(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }
}
