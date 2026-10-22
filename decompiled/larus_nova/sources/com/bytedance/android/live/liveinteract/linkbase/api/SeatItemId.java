package com.bytedance.android.live.liveinteract.linkbase.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkbase/api/SeatItemId;", "", "UNKNOWN", "USER_INFO", "GIFT_ICON", "TAG_LABEL_INFO", "EMPTY_INFO", "SEAT_WIDGET", "RANDOM_EMOJI", "SEAT_UI_UPDATE", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeatItemId extends Enum<SeatItemId> {
    public static final SeatItemId EMPTY_INFO = null;
    public static final SeatItemId GIFT_ICON = null;
    public static final SeatItemId RANDOM_EMOJI = null;
    public static final SeatItemId SEAT_UI_UPDATE = null;
    public static final SeatItemId SEAT_WIDGET = null;
    public static final SeatItemId TAG_LABEL_INFO = null;
    public static final SeatItemId UNKNOWN = null;
    public static final SeatItemId USER_INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeatItemId[] f74282a = null;

    static {
        SeatItemId r100 = new SeatItemId("UNKNOWN", 0);
        UNKNOWN = r100;
        SeatItemId r101 = new SeatItemId("USER_INFO", 1);
        USER_INFO = r101;
        SeatItemId r102 = new SeatItemId("GIFT_ICON", 2);
        GIFT_ICON = r102;
        SeatItemId r103 = new SeatItemId("TAG_LABEL_INFO", 3);
        TAG_LABEL_INFO = r103;
        SeatItemId r104 = new SeatItemId("EMPTY_INFO", 4);
        EMPTY_INFO = r104;
        SeatItemId r105 = new SeatItemId("SEAT_WIDGET", 5);
        SEAT_WIDGET = r105;
        SeatItemId r106 = new SeatItemId("RANDOM_EMOJI", 6);
        RANDOM_EMOJI = r106;
        SeatItemId r107 = new SeatItemId("SEAT_UI_UPDATE", 7);
        SEAT_UI_UPDATE = r107;
        f74282a = new SeatItemId[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static SeatItemId valueOf(String r100) {
        return (SeatItemId) a.a(SeatItemId.class, r100);
    }

    public static SeatItemId[] values() {
        return (SeatItemId[]) f74282a.clone();
    }

    public SeatItemId(String r100, int r101) {
        super(r100, r101);
    }
}
