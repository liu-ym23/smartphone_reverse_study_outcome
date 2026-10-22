package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final enum BoundType extends Enum<BoundType> {
    private static final /* synthetic */ BoundType[] $VALUES = null;
    public static final BoundType CLOSED = null;
    public static final BoundType OPEN = null;
    final boolean inclusive;

    static {
        BoundType r10 = new BoundType("OPEN", 0, false);
        OPEN = r10;
        BoundType r11 = new BoundType("CLOSED", 1, true);
        CLOSED = r11;
        $VALUES = new BoundType[]{r10, r11};
    }

    private BoundType(String r10, int r11, boolean r12) {
        super(r10, r11);
        this.inclusive = r12;
    }

    public static BoundType forBoolean(boolean r10) {
        if (r10 == false) goto L5;
        return CLOSED;
    L5:
        return OPEN;
    }

    public static BoundType valueOf(String r10) {
        return (BoundType) Enum.valueOf(BoundType.class, r10);
    }

    public static BoundType[] values() {
        return (BoundType[]) $VALUES.clone();
    }

    public BoundType flip() {
        return forBoolean(!this.inclusive);
    }
}
