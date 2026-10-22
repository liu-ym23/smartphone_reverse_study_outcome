package o4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c2 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ c2[] $VALUES;
    public static final c2 Resend = new c2("Resend", 0);
    public static final c2 FinalizeExpired = new c2("FinalizeExpired", 1);

    private static final /* synthetic */ c2[] $values() {
        return new c2[]{Resend, FinalizeExpired};
    }

    static {
        c2[] c2VarArr$values = $values();
        $VALUES = c2VarArr$values;
        $ENTRIES = w7.e0.s(c2VarArr$values);
    }

    private c2(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static c2 valueOf(String str) {
        return (c2) Enum.valueOf(c2.class, str);
    }

    public static c2[] values() {
        return (c2[]) $VALUES.clone();
    }
}
