package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/CarouselTabType;", "", "", "value", "I", "getValue", "()I", "DOU_PLUS", "FRESHMAN_SUPPORT", "ANCHOR_TRAFFIC_SUPPORT", "ROOM_INDICATOR", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CarouselTabType extends Enum<CarouselTabType> {
    public static final CarouselTabType ANCHOR_TRAFFIC_SUPPORT = null;
    public static final CarouselTabType DOU_PLUS = null;
    public static final CarouselTabType FRESHMAN_SUPPORT = null;
    public static final CarouselTabType ROOM_INDICATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CarouselTabType[] f99702a = null;
    private final int value;

    static {
        CarouselTabType r100 = new CarouselTabType("DOU_PLUS", 0, 1);
        DOU_PLUS = r100;
        CarouselTabType r101 = new CarouselTabType("FRESHMAN_SUPPORT", 1, 2);
        FRESHMAN_SUPPORT = r101;
        CarouselTabType r102 = new CarouselTabType("ANCHOR_TRAFFIC_SUPPORT", 2, 3);
        ANCHOR_TRAFFIC_SUPPORT = r102;
        CarouselTabType r103 = new CarouselTabType("ROOM_INDICATOR", 3, 4);
        ROOM_INDICATOR = r103;
        f99702a = new CarouselTabType[]{r100, r101, r102, r103};
    }

    public static CarouselTabType valueOf(String r100) {
        return (CarouselTabType) a.a(CarouselTabType.class, r100);
    }

    public static CarouselTabType[] values() {
        return (CarouselTabType[]) f99702a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CarouselTabType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
