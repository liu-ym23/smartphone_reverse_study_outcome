package p5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ e[] $VALUES;
    public static final e BROADCAST = new e("BROADCAST", 0);
    public static final e SERVICE = new e("SERVICE", 1);
    public static final e ACTIVITY = new e("ACTIVITY", 2);

    private static final /* synthetic */ e[] $values() {
        return new e[]{BROADCAST, SERVICE, ACTIVITY};
    }

    static {
        e[] eVarArr$values = $values();
        $VALUES = eVarArr$values;
        $ENTRIES = e0.s(eVarArr$values);
    }

    private e(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) $VALUES.clone();
    }
}
