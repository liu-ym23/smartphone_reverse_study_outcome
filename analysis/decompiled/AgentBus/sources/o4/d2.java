package o4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d2 {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ d2[] $VALUES;
    public static final d2 None = new d2("None", 0);
    public static final d2 WaitScreenOn = new d2("WaitScreenOn", 1);
    public static final d2 WaitAck = new d2("WaitAck", 2);
    public static final d2 FinalizeUnsent = new d2("FinalizeUnsent", 3);
    public static final d2 FinalizeOffline = new d2("FinalizeOffline", 4);

    private static final /* synthetic */ d2[] $values() {
        return new d2[]{None, WaitScreenOn, WaitAck, FinalizeUnsent, FinalizeOffline};
    }

    static {
        d2[] d2VarArr$values = $values();
        $VALUES = d2VarArr$values;
        $ENTRIES = w7.e0.s(d2VarArr$values);
    }

    private d2(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static d2 valueOf(String str) {
        return (d2) Enum.valueOf(d2.class, str);
    }

    public static d2[] values() {
        return (d2[]) $VALUES.clone();
    }
}
