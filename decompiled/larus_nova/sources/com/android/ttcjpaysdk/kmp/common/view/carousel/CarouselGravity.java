package com.android.ttcjpaysdk.kmp.common.view.carousel;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/carousel/CarouselGravity;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER", GXAnimation.STATE_START, GXAnimation.STATE_END, "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CarouselGravity extends Enum<CarouselGravity> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CarouselGravity[] $VALUES = null;
    public static final CarouselGravity CENTER = null;
    public static final CarouselGravity END = null;
    public static final CarouselGravity START = null;

    private static final /* synthetic */ CarouselGravity[] $values() {
        return new CarouselGravity[]{CENTER, START, END};
    }

    public static EnumEntries<CarouselGravity> getEntries() {
        return $ENTRIES;
    }

    static {
        CENTER = new CarouselGravity("CENTER", 0);
        START = new CarouselGravity(GXAnimation.STATE_START, 1);
        END = new CarouselGravity(GXAnimation.STATE_END, 2);
        CarouselGravity[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static CarouselGravity[] values() {
        return (CarouselGravity[]) $VALUES.clone();
    }

    public static CarouselGravity valueOf(String r100) {
        return (CarouselGravity) r27.a.a(CarouselGravity.class, r100);
    }

    private CarouselGravity(String r100, int r101) {
        super(r100, r101);
    }
}
