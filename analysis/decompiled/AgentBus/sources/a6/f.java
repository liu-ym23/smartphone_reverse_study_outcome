package a6;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class f {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ f[] $VALUES;
    public static final f OK = new f("OK", 0);
    public static final f ERROR = new f("ERROR", 1);
    public static final f SKIPPED = new f("SKIPPED", 2);

    private static final /* synthetic */ f[] $values() {
        return new f[]{OK, ERROR, SKIPPED};
    }

    static {
        f[] fVarArr$values = $values();
        $VALUES = fVarArr$values;
        $ENTRIES = e0.s(fVarArr$values);
    }

    private f(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static f valueOf(String str) {
        return (f) Enum.valueOf(f.class, str);
    }

    public static f[] values() {
        return (f[]) $VALUES.clone();
    }
}
