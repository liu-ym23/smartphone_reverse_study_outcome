package k5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ j[] $VALUES;
    public static final j ONLINE = new j("ONLINE", 0);
    public static final j DEGRADING = new j("DEGRADING", 1);
    public static final j OFFLINE = new j("OFFLINE", 2);
    public static final j DOWN = new j("DOWN", 3);

    private static final /* synthetic */ j[] $values() {
        return new j[]{ONLINE, DEGRADING, OFFLINE, DOWN};
    }

    static {
        j[] jVarArr$values = $values();
        $VALUES = jVarArr$values;
        $ENTRIES = e0.s(jVarArr$values);
    }

    private j(String str, int i2) {
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
}
