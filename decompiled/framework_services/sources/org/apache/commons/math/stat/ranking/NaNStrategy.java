package org.apache.commons.math.stat.ranking;

/* JADX INFO: loaded from: classes3.dex */
public final enum NaNStrategy extends Enum<NaNStrategy> {
    private static final /* synthetic */ NaNStrategy[] $VALUES = null;
    public static final NaNStrategy FIXED = null;
    public static final NaNStrategy MAXIMAL = null;
    public static final NaNStrategy MINIMAL = null;
    public static final NaNStrategy REMOVED = null;

    private static /* synthetic */ NaNStrategy[] $values() {
        return new NaNStrategy[]{MINIMAL, MAXIMAL, REMOVED, FIXED};
    }

    private NaNStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static NaNStrategy valueOf(String name) {
        return (NaNStrategy) Enum.valueOf(NaNStrategy.class, name);
    }

    public static NaNStrategy[] values() {
        return (NaNStrategy[]) $VALUES.clone();
    }

    static {
        MINIMAL = new NaNStrategy("MINIMAL", 0);
        MAXIMAL = new NaNStrategy("MAXIMAL", 1);
        REMOVED = new NaNStrategy("REMOVED", 2);
        FIXED = new NaNStrategy("FIXED", 3);
        $VALUES = $values();
    }
}
