package com.android.ttcjpaysdk.base.utils;

import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public final enum CJPayNavBarType extends Enum<CJPayNavBarType> {
    private static final /* synthetic */ CJPayNavBarType[] $VALUES = null;
    public static final CJPayNavBarType CLASSIC = null;
    public static final CJPayNavBarType DOUBLE = null;
    public static final CJPayNavBarType GESTURES = null;
    public static final CJPayNavBarType GESTURES_THREE_STAGE = null;
    public static final CJPayNavBarType UNKNOWN = null;
    private final int type;

    private static /* synthetic */ CJPayNavBarType[] $values() {
        return new CJPayNavBarType[]{CLASSIC, GESTURES, GESTURES_THREE_STAGE, DOUBLE, UNKNOWN};
    }

    static {
        CLASSIC = new CJPayNavBarType("CLASSIC", 0, 0);
        GESTURES = new CJPayNavBarType("GESTURES", 1, 1);
        GESTURES_THREE_STAGE = new CJPayNavBarType("GESTURES_THREE_STAGE", 2, 2);
        DOUBLE = new CJPayNavBarType("DOUBLE", 3, 3);
        UNKNOWN = new CJPayNavBarType("UNKNOWN", 4, -1);
        $VALUES = $values();
    }

    public static CJPayNavBarType[] values() {
        return (CJPayNavBarType[]) $VALUES.clone();
    }

    public static CJPayNavBarType valueOf(String r100) {
        return (CJPayNavBarType) a.a(CJPayNavBarType.class, r100);
    }

    private CJPayNavBarType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
