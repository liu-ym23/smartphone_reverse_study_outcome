package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.g0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ShowCarouselData;", "", "", "component1", "Lcom/bytedance/android/livesdk/gift/model/g0;", "component2", "canShow", "extraInfo", "copy", "", "toString", "", "hashCode", "other", "equals", "Z", "getCanShow", "()Z", "Lcom/bytedance/android/livesdk/gift/model/g0;", "getExtraInfo", "()Lcom/bytedance/android/livesdk/gift/model/g0;", "<init>", "(ZLcom/bytedance/android/livesdk/gift/model/g0;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShowCarouselData {
    private final boolean canShow;
    private final g0 extraInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ShowCarouselData() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ShowCarouselData copy$default(ShowCarouselData r100, boolean r101, g0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.canShow;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extraInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.canShow;
    }

    public final g0 component2() {
        return this.extraInfo;
    }

    public final ShowCarouselData copy(boolean r100, g0 r101) {
        return new ShowCarouselData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShowCarouselData) == false) goto L10;
        ShowCarouselData r101 = (ShowCarouselData) r100;
        if (this.canShow == r101.canShow) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.canShow;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        g0 r103 = this.extraInfo;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "ShowCarouselData(canShow=" + this.canShow + ", extraInfo=" + this.extraInfo + ")";
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    public final g0 getExtraInfo() {
        return this.extraInfo;
    }

    public ShowCarouselData(boolean r100, g0 r101) {
        this.canShow = r100;
        this.extraInfo = r101;
    }

    public /* synthetic */ ShowCarouselData(boolean r100, g0 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
