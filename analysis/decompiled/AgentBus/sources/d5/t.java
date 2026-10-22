package d5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class t {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ t[] $VALUES;
    public static final t CLOUD = new t("CLOUD", 0);
    public static final t EDGE = new t("EDGE", 1);

    private static final /* synthetic */ t[] $values() {
        return new t[]{CLOUD, EDGE};
    }

    static {
        t[] tVarArr$values = $values();
        $VALUES = tVarArr$values;
        $ENTRIES = e0.s(tVarArr$values);
    }

    private t(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) $VALUES.clone();
    }
}
