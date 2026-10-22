package a6;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c0 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ c0[] $VALUES;
    public static final c0 CORE = new c0("CORE", 0);
    public static final c0 INSTALLED = new c0("INSTALLED", 1);

    private static final /* synthetic */ c0[] $values() {
        return new c0[]{CORE, INSTALLED};
    }

    static {
        c0[] c0VarArr$values = $values();
        $VALUES = c0VarArr$values;
        $ENTRIES = e0.s(c0VarArr$values);
    }

    private c0(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) $VALUES.clone();
    }
}
