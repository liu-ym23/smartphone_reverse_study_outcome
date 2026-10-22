package d5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class m {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ m[] $VALUES;
    public static final m NODE = new m("NODE", 0);
    public static final m CHANNEL = new m("CHANNEL", 1);
    public static final m CONSOLE = new m("CONSOLE", 2);
    public static final m GATEWAY = new m("GATEWAY", 3);

    private static final /* synthetic */ m[] $values() {
        return new m[]{NODE, CHANNEL, CONSOLE, GATEWAY};
    }

    static {
        m[] mVarArr$values = $values();
        $VALUES = mVarArr$values;
        $ENTRIES = e0.s(mVarArr$values);
    }

    private m(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) $VALUES.clone();
    }
}
