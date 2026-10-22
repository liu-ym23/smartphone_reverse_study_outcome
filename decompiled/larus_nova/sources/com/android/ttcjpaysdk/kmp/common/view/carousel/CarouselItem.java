package com.android.ttcjpaysdk.kmp.common.view.carousel;

import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/carousel/CarouselItem;", "", SocialConstants.PARAM_APP_DESC, "", "atomic_component_list", "", "Lcom/android/ttcjpaysdk/kmp/common/view/carousel/CarouselAtomicComponent;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getDesc", "()Ljava/lang/String;", "getAtomic_component_list", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CarouselItem {
    public static final int $stable = 8;
    private final List<CarouselAtomicComponent> atomic_component_list;
    private final String desc;

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselItem() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CarouselItem copy$default(CarouselItem r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.desc;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.atomic_component_list;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.desc;
    }

    public final List<CarouselAtomicComponent> component2() {
        return this.atomic_component_list;
    }

    public final CarouselItem copy(String r100, List<CarouselAtomicComponent> r101) {
        return new CarouselItem(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CarouselItem) == true) goto L8;
        return false;
    L8:
        CarouselItem r101 = (CarouselItem) r100;
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.atomic_component_list, r101.atomic_component_list) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.desc;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CarouselAtomicComponent> r104 = this.atomic_component_list;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CarouselItem(desc=" + this.desc + ", atomic_component_list=" + this.atomic_component_list + ')';
    }

    public final List<CarouselAtomicComponent> getAtomic_component_list() {
        return this.atomic_component_list;
    }

    public final String getDesc() {
        return this.desc;
    }

    public CarouselItem(String r100, List<CarouselAtomicComponent> r101) {
        this.desc = r100;
        this.atomic_component_list = r101;
    }

    public /* synthetic */ CarouselItem(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
