package a6;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c {
    private static final /* synthetic */ j7.a $ENTRIES;
    private static final /* synthetic */ c[] $VALUES;
    public static final c SOUL = new c("SOUL", 0);
    public static final c AGENTS = new c("AGENTS", 1);
    public static final c USER = new c("USER", 2);
    public static final c MEMORY = new c("MEMORY", 3);
    public static final c TOOLS = new c("TOOLS", 4);
    public static final c IDENTITY = new c("IDENTITY", 5);

    private static final /* synthetic */ c[] $values() {
        return new c[]{SOUL, AGENTS, USER, MEMORY, TOOLS, IDENTITY};
    }

    static {
        c[] cVarArr$values = $values();
        $VALUES = cVarArr$values;
        $ENTRIES = e0.s(cVarArr$values);
    }

    private c(String str, int i2) {
    }

    public static j7.a getEntries() {
        return $ENTRIES;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) $VALUES.clone();
    }
}
