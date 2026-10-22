package com.bytedance.android.livesdkapi.distribution;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/ViewConfig;", "", "marginTop", "", "marginBottom", "(II)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "getMarginTop", "setMarginTop", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewConfig {
    private int marginBottom;
    private int marginTop;

    public ViewConfig() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ ViewConfig copy$default(ViewConfig r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.marginTop;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.marginBottom;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.marginTop;
    }

    public final int component2() {
        return this.marginBottom;
    }

    public final ViewConfig copy(int r100, int r101) {
        return new ViewConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ViewConfig) == false) goto L10;
        ViewConfig r101 = (ViewConfig) r100;
        if (this.marginTop == r101.marginTop) goto L8;
        return false;
    L8:
        if (this.marginBottom == r101.marginBottom) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.marginTop * 31) + this.marginBottom;
    }

    public String toString() {
        return "ViewConfig(marginTop=" + this.marginTop + ", marginBottom=" + this.marginBottom + ")";
    }

    public final int getMarginBottom() {
        return this.marginBottom;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final void setMarginBottom(int r100) {
        this.marginBottom = r100;
    }

    public final void setMarginTop(int r100) {
        this.marginTop = r100;
    }

    public ViewConfig(int r100, int r101) {
        this.marginTop = r100;
        this.marginBottom = r101;
    }

    public /* synthetic */ ViewConfig(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
