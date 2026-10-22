package org.apache.commons.math.stat.ranking;

/* JADX INFO: loaded from: classes3.dex */
public final enum TiesStrategy extends Enum<TiesStrategy> {
    private static final /* synthetic */ TiesStrategy[] $VALUES = null;
    public static final TiesStrategy AVERAGE = null;
    public static final TiesStrategy MAXIMUM = null;
    public static final TiesStrategy MINIMUM = null;
    public static final TiesStrategy RANDOM = null;
    public static final TiesStrategy SEQUENTIAL = null;

    private static /* synthetic */ TiesStrategy[] $values() {
        return new TiesStrategy[]{SEQUENTIAL, MINIMUM, MAXIMUM, AVERAGE, RANDOM};
    }

    private TiesStrategy(String r1, int r2) {
        super(r1, r2);
    }

    public static TiesStrategy valueOf(String name) {
        return (TiesStrategy) Enum.valueOf(TiesStrategy.class, name);
    }

    public static TiesStrategy[] values() {
        return (TiesStrategy[]) $VALUES.clone();
    }

    static {
        SEQUENTIAL = new TiesStrategy("SEQUENTIAL", 0);
        MINIMUM = new TiesStrategy("MINIMUM", 1);
        MAXIMUM = new TiesStrategy("MAXIMUM", 2);
        AVERAGE = new TiesStrategy("AVERAGE", 3);
        RANDOM = new TiesStrategy("RANDOM", 4);
        $VALUES = $values();
    }
}
