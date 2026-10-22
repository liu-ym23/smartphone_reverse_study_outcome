package com.android.ttcjpaysdk.kmp.common.view.carousel;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/carousel/CarouselConfig;", "", "interval_time", "", "animation_time", "component_list", "", "Lcom/android/ttcjpaysdk/kmp/common/view/carousel/CarouselItem;", "<init>", "(JJLjava/util/List;)V", "getInterval_time", "()J", "getAnimation_time", "getComponent_list", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CarouselConfig {
    public static final int $stable = 8;
    private final long animation_time;
    private final List<CarouselItem> component_list;
    private final long interval_time;

    public CarouselConfig() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarouselConfig copy$default(CarouselConfig r100, long r101, long r102, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.interval_time;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.animation_time;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.component_list;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return this.interval_time;
    }

    public final long component2() {
        return this.animation_time;
    }

    public final List<CarouselItem> component3() {
        return this.component_list;
    }

    public final CarouselConfig copy(long r100, long r110, List<CarouselItem> r111) {
        return new CarouselConfig(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CarouselConfig) == true) goto L8;
        return false;
    L8:
        CarouselConfig r101 = (CarouselConfig) r100;
        if (this.interval_time == r101.interval_time) goto L12;
        return false;
    L12:
        if (this.animation_time == r101.animation_time) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.component_list, r101.component_list) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.interval_time;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.animation_time;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        List<CarouselItem> r104 = this.component_list;
        if (r104 != null) goto L5;
        int r105 = 0;
    L7:
        return r103 + r105;
    L5:
        r105 = r104.hashCode();
        goto L7
    }

    public String toString() {
        return "CarouselConfig(interval_time=" + this.interval_time + ", animation_time=" + this.animation_time + ", component_list=" + this.component_list + ')';
    }

    public final long getAnimation_time() {
        return this.animation_time;
    }

    public final List<CarouselItem> getComponent_list() {
        return this.component_list;
    }

    public final long getInterval_time() {
        return this.interval_time;
    }

    public CarouselConfig(long r100, long r101, List<CarouselItem> r102) {
        this.interval_time = r100;
        this.animation_time = r101;
        this.component_list = r102;
    }

    public /* synthetic */ CarouselConfig(long r100, long r101, List r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = 2000;
    L5:
        long r102 = r100;
        if ((r111 & 2) == 0) goto L8;
        r101 = 500;
    L8:
        long r103 = r101;
        if ((r111 & 4) == 0) goto L11;
        r110 = null;
    L11:
        this(r102, r103, r110);
    }
}
