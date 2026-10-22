package c6;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class m {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ m[] $VALUES;
    public static final m LS = new m("LS", 0);
    public static final m WS = new m("WS", 1);
    public static final m WSS = new m("WSS", 2);

    private static final /* synthetic */ m[] $values() {
        return new m[]{LS, WS, WSS};
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
