package a6;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class x {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ x[] $VALUES;
    public static final x MODEL = new x("MODEL", 0);
    public static final x FILES = new x("FILES", 1);
    public static final x CRONJOBS = new x("CRONJOBS", 2);
    public static final x CLAW = new x("CLAW", 3);
    public static final x ALL = new x("ALL", 4);

    private static final /* synthetic */ x[] $values() {
        return new x[]{MODEL, FILES, CRONJOBS, CLAW, ALL};
    }

    static {
        x[] xVarArr$values = $values();
        $VALUES = xVarArr$values;
        $ENTRIES = e0.s(xVarArr$values);
    }

    private x(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) $VALUES.clone();
    }
}
