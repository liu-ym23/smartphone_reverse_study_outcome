package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
public abstract enum BoundType extends Enum<BoundType> {
    private static final /* synthetic */ BoundType[] $VALUES = null;
    public static final BoundType CLOSED = null;
    public static final BoundType OPEN = null;

    abstract BoundType flip();

    public static BoundType valueOf(String r1) {
        return (BoundType) Enum.valueOf(BoundType.class, r1);
    }

    public static BoundType[] values() {
        return (BoundType[]) $VALUES.clone();
    }

    private BoundType(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ BoundType(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    static {
        final String r1 = "OPEN";
        final int r2 = 0;
        BoundType r0 = new AnonymousClass1(r1, r2);
        OPEN = r0;
        final String r3 = "CLOSED";
        final int r4 = 1;
        BoundType r5 = new AnonymousClass2(r3, r4);
        CLOSED = r5;
        $VALUES = new BoundType[]{r0, r5};
    }

    static BoundType forBoolean(boolean r0) {
        if (r0 == false) goto L5;
        return CLOSED;
    L5:
        return OPEN;
    }
}
