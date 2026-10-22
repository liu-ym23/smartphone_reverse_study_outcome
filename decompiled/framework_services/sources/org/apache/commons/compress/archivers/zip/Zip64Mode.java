package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes3.dex */
public final enum Zip64Mode extends Enum<Zip64Mode> {
    private static final /* synthetic */ Zip64Mode[] $VALUES = null;
    public static final Zip64Mode Always = null;
    public static final Zip64Mode AsNeeded = null;
    public static final Zip64Mode Never = null;

    private static /* synthetic */ Zip64Mode[] $values() {
        return new Zip64Mode[]{Always, Never, AsNeeded};
    }

    private Zip64Mode(String r1, int r2) {
        super(r1, r2);
    }

    public static Zip64Mode valueOf(String name) {
        return (Zip64Mode) Enum.valueOf(Zip64Mode.class, name);
    }

    public static Zip64Mode[] values() {
        return (Zip64Mode[]) $VALUES.clone();
    }

    static {
        Always = new Zip64Mode("Always", 0);
        Never = new Zip64Mode("Never", 1);
        AsNeeded = new Zip64Mode("AsNeeded", 2);
        $VALUES = $values();
    }
}
