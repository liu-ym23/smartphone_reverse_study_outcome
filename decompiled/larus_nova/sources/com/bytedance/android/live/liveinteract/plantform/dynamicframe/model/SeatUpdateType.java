package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/SeatUpdateType;", "", "UNKNOWN", "UPDATE_BY_UID", "UPDATE_BY_POS", "UPDATE_ALL", "UPDATE_SEAT_WIDGET", "RESET", "UPDATE_SEAT_UI", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeatUpdateType extends Enum<SeatUpdateType> {
    public static final SeatUpdateType RESET = null;
    public static final SeatUpdateType UNKNOWN = null;
    public static final SeatUpdateType UPDATE_ALL = null;
    public static final SeatUpdateType UPDATE_BY_POS = null;
    public static final SeatUpdateType UPDATE_BY_UID = null;
    public static final SeatUpdateType UPDATE_SEAT_UI = null;
    public static final SeatUpdateType UPDATE_SEAT_WIDGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeatUpdateType[] f77080a = null;

    static {
        SeatUpdateType r100 = new SeatUpdateType("UNKNOWN", 0);
        UNKNOWN = r100;
        SeatUpdateType r101 = new SeatUpdateType("UPDATE_BY_UID", 1);
        UPDATE_BY_UID = r101;
        SeatUpdateType r102 = new SeatUpdateType("UPDATE_BY_POS", 2);
        UPDATE_BY_POS = r102;
        SeatUpdateType r103 = new SeatUpdateType("UPDATE_ALL", 3);
        UPDATE_ALL = r103;
        SeatUpdateType r104 = new SeatUpdateType("UPDATE_SEAT_WIDGET", 4);
        UPDATE_SEAT_WIDGET = r104;
        SeatUpdateType r105 = new SeatUpdateType("RESET", 5);
        RESET = r105;
        SeatUpdateType r106 = new SeatUpdateType("UPDATE_SEAT_UI", 6);
        UPDATE_SEAT_UI = r106;
        f77080a = new SeatUpdateType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static SeatUpdateType valueOf(String r100) {
        return (SeatUpdateType) a.a(SeatUpdateType.class, r100);
    }

    public static SeatUpdateType[] values() {
        return (SeatUpdateType[]) f77080a.clone();
    }

    public SeatUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
