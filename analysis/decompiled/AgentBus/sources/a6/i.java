package a6;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class i {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ i[] $VALUES;
    public static final i BUNDLED = new i("BUNDLED", 0);
    public static final i LOCAL = new i("LOCAL", 1);
    public static final i REMOTE = new i("REMOTE", 2);
    public static final i UNKNOWN = new i("UNKNOWN", 3);

    private static final /* synthetic */ i[] $values() {
        return new i[]{BUNDLED, LOCAL, REMOTE, UNKNOWN};
    }

    static {
        i[] iVarArr$values = $values();
        $VALUES = iVarArr$values;
        $ENTRIES = e0.s(iVarArr$values);
    }

    private i(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) $VALUES.clone();
    }
}
