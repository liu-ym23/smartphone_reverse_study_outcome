package a6;

import java.util.Locale;
import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class w {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ w[] $VALUES;
    public static final v Companion;
    public static final w AUTO = new w("AUTO", 0);
    public static final w EDGE = new w("EDGE", 1);
    public static final w CLOUD = new w("CLOUD", 2);

    private static final /* synthetic */ w[] $values() {
        return new w[]{AUTO, EDGE, CLOUD};
    }

    static {
        w[] wVarArr$values = $values();
        $VALUES = wVarArr$values;
        $ENTRIES = e0.s(wVarArr$values);
        Companion = new v();
    }

    private w(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) $VALUES.clone();
    }

    public final String getWire() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        q7.k.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
