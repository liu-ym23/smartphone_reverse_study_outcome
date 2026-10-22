package k4;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ d[] $VALUES;
    public static final d AuthResponse = new d("AuthResponse", 0);
    public static final d HeartbeatResponse = new d("HeartbeatResponse", 1);
    public static final d Business = new d("Business", 2);
    public static final d Unparseable = new d("Unparseable", 3);

    private static final /* synthetic */ d[] $values() {
        return new d[]{AuthResponse, HeartbeatResponse, Business, Unparseable};
    }

    static {
        d[] dVarArr$values = $values();
        $VALUES = dVarArr$values;
        $ENTRIES = e0.s(dVarArr$values);
    }

    private d(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) $VALUES.clone();
    }
}
