package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import com.android.ttcjpaysdk.base.utils.CJPayAnimationUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/overlay/CJOverlayMask;", "", "maskColor", "", "maskBlur", "", "<init>", "(Ljava/lang/String;I)V", "getMaskColor", "()Ljava/lang/String;", "getMaskBlur", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayMask {
    public static final int $stable = 0;
    private final int maskBlur;
    private final String maskColor;

    /* JADX WARN: Multi-variable type inference failed */
    public CJOverlayMask() {
        String r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CJOverlayMask copy$default(CJOverlayMask r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.maskColor;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.maskBlur;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.maskColor;
    }

    public final int component2() {
        return this.maskBlur;
    }

    public final CJOverlayMask copy(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "maskColor");
        return new CJOverlayMask(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJOverlayMask) == true) goto L8;
        return false;
    L8:
        CJOverlayMask r101 = (CJOverlayMask) r100;
        if (Intrinsics.areEqual(this.maskColor, r101.maskColor) == true) goto L12;
        return false;
    L12:
        if (this.maskBlur == r101.maskBlur) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.maskColor.hashCode() * 31) + this.maskBlur;
    }

    public String toString() {
        return "CJOverlayMask(maskColor=" + this.maskColor + ", maskBlur=" + this.maskBlur + ')';
    }

    public final int getMaskBlur() {
        return this.maskBlur;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public CJOverlayMask(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "maskColor");
        this.maskColor = r100;
        this.maskBlur = r101;
    }

    public /* synthetic */ CJOverlayMask(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CJPayAnimationUtils.CJ_PAY_BG_LAYER_COLOR;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
