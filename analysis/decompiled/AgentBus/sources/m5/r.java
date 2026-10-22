package m5;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class r {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ r[] $VALUES;
    public static final r CLIENT = new r("CLIENT", 0);
    public static final r SERVER = new r("SERVER", 1);
    public static final r INTERNAL = new r("INTERNAL", 2);
    public static final r PRODUCER = new r("PRODUCER", 3);
    public static final r CONSUMER = new r("CONSUMER", 4);
    public static final r EVENT = new r("EVENT", 5);

    private static final /* synthetic */ r[] $values() {
        return new r[]{CLIENT, SERVER, INTERNAL, PRODUCER, CONSUMER, EVENT};
    }

    static {
        r[] rVarArr$values = $values();
        $VALUES = rVarArr$values;
        $ENTRIES = e0.s(rVarArr$values);
    }

    private r(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) $VALUES.clone();
    }
}
