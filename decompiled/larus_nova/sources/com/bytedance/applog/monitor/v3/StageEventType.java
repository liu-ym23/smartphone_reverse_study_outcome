package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum StageEventType extends Enum<StageEventType> {
    public static final StageEventType ITEM_IMPRESSION = null;
    public static final StageEventType LAUNCH = null;
    public static final StageEventType LOG_DATA = null;
    public static final StageEventType TERMINATE = null;
    public static final StageEventType V1_EVENT = null;
    public static final StageEventType V3_EVENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageEventType[] f192499a = null;
    private final int label;

    static {
        StageEventType r100 = new StageEventType("V3_EVENT", 0, 0);
        V3_EVENT = r100;
        StageEventType r101 = new StageEventType("V1_EVENT", 1, 1);
        V1_EVENT = r101;
        StageEventType r102 = new StageEventType("LOG_DATA", 2, 2);
        LOG_DATA = r102;
        StageEventType r103 = new StageEventType("LAUNCH", 3, 3);
        LAUNCH = r103;
        StageEventType r104 = new StageEventType("TERMINATE", 4, 4);
        TERMINATE = r104;
        StageEventType r105 = new StageEventType("ITEM_IMPRESSION", 5, 5);
        ITEM_IMPRESSION = r105;
        f192499a = new StageEventType[]{r100, r101, r102, r103, r104, r105};
    }

    public static StageEventType[] values() {
        return (StageEventType[]) f192499a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "-" + this.label;
    }

    public int getLabel() {
        return this.label;
    }

    public static StageEventType fromLabel(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return V3_EVENT;
    L13:
        return TERMINATE;
    L15:
        return LAUNCH;
    L17:
        return LOG_DATA;
    L19:
        return V1_EVENT;
    }

    public static StageEventType parse(String r100) {
        StageEventType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        StageEventType r104 = r101[r103];
        if (r104.name().equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return V3_EVENT;
    }

    public static StageEventType valueOf(String r100) {
        return (StageEventType) a.a(StageEventType.class, r100);
    }

    public StageEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.label = r102;
    }
}
