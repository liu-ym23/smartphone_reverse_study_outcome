package com.google.gson;

/* JADX INFO: loaded from: classes2.dex */
public final enum Strictness extends Enum<Strictness> {
    private static final /* synthetic */ Strictness[] $VALUES = null;
    public static final Strictness LEGACY_STRICT = null;
    public static final Strictness LENIENT = null;
    public static final Strictness STRICT = null;

    private Strictness(String r1, int r2) {
        super(r1, r2);
    }

    public static Strictness valueOf(String r1) {
        return (Strictness) Enum.valueOf(Strictness.class, r1);
    }

    public static Strictness[] values() {
        return (Strictness[]) $VALUES.clone();
    }

    static {
        Strictness r0 = new Strictness("LENIENT", 0);
        LENIENT = r0;
        Strictness r1 = new Strictness("LEGACY_STRICT", 1);
        LEGACY_STRICT = r1;
        Strictness r3 = new Strictness("STRICT", 2);
        STRICT = r3;
        $VALUES = new Strictness[]{r0, r1, r3};
    }
}
