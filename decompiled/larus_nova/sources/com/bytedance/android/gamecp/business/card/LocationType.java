package com.bytedance.android.gamecp.business.card;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/gamecp/business/card/LocationType;", "", "", "num", "I", "getNum", "()I", "LIVE_ROOM", "LIVE_PREVIEW", "AI_AVATAR", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LocationType extends Enum<LocationType> {
    public static final LocationType AI_AVATAR = null;
    public static final LocationType LIVE_PREVIEW = null;
    public static final LocationType LIVE_ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocationType[] f51780a = null;
    private final int num;

    static {
        LocationType r100 = new LocationType("LIVE_ROOM", 0, 0);
        LIVE_ROOM = r100;
        LocationType r101 = new LocationType("LIVE_PREVIEW", 1, 1);
        LIVE_PREVIEW = r101;
        LocationType r102 = new LocationType("AI_AVATAR", 2, 2);
        AI_AVATAR = r102;
        f51780a = new LocationType[]{r100, r101, r102};
    }

    public static LocationType valueOf(String r100) {
        return (LocationType) r27.a.a(LocationType.class, r100);
    }

    public static LocationType[] values() {
        return (LocationType[]) f51780a.clone();
    }

    public final int getNum() {
        return this.num;
    }

    public LocationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.num = r102;
    }
}
