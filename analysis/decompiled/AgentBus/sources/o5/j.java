package o5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ j[] $VALUES;
    private final String wire;
    public static final j Auto = new j("Auto", 0, "auto");
    public static final j UserAction = new j("UserAction", 1, "user_action");
    public static final j Permanent = new j("Permanent", 2, "permanent");

    private static final /* synthetic */ j[] $values() {
        return new j[]{Auto, UserAction, Permanent};
    }

    static {
        j[] jVarArr$values = $values();
        $VALUES = jVarArr$values;
        $ENTRIES = e0.s(jVarArr$values);
    }

    private j(String str, int i2, String str2) {
        this.wire = str2;
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) $VALUES.clone();
    }

    public final String getWire() {
        return this.wire;
    }
}
