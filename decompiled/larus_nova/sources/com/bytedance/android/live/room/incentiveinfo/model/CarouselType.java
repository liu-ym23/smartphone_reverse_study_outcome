package com.bytedance.android.live.room.incentiveinfo.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/incentiveinfo/model/CarouselType;", "", "ADD", "REMOVE", "UPDATE", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CarouselType extends Enum<CarouselType> {
    public static final CarouselType ADD = null;
    public static final CarouselType REMOVE = null;
    public static final CarouselType UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CarouselType[] f99703a = null;

    static {
        CarouselType r100 = new CarouselType("ADD", 0);
        ADD = r100;
        CarouselType r101 = new CarouselType("REMOVE", 1);
        REMOVE = r101;
        CarouselType r102 = new CarouselType("UPDATE", 2);
        UPDATE = r102;
        f99703a = new CarouselType[]{r100, r101, r102};
    }

    public static CarouselType valueOf(String r100) {
        return (CarouselType) a.a(CarouselType.class, r100);
    }

    public static CarouselType[] values() {
        return (CarouselType[]) f99703a.clone();
    }

    public CarouselType(String r100, int r101) {
        super(r100, r101);
    }
}
