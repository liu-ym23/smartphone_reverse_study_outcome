package m4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class s0 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ s0[] $VALUES;
    public static final s0 MANAGED = new s0("MANAGED", 0);
    public static final s0 BUNDLED = new s0("BUNDLED", 1);

    private static final /* synthetic */ s0[] $values() {
        return new s0[]{MANAGED, BUNDLED};
    }

    static {
        s0[] s0VarArr$values = $values();
        $VALUES = s0VarArr$values;
        $ENTRIES = w7.e0.s(s0VarArr$values);
    }

    private s0(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static s0 valueOf(String str) {
        return (s0) Enum.valueOf(s0.class, str);
    }

    public static s0[] values() {
        return (s0[]) $VALUES.clone();
    }
}
