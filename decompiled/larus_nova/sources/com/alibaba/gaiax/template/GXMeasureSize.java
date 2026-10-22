package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/alibaba/gaiax/template/GXMeasureSize;", "", "width", "", "height", "(Ljava/lang/Float;Ljava/lang/Float;)V", "getHeight", "()Ljava/lang/Float;", "setHeight", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getWidth", "setWidth", "component1", "component2", "copy", "(Ljava/lang/Float;Ljava/lang/Float;)Lcom/alibaba/gaiax/template/GXMeasureSize;", "equals", "", "other", "hashCode", "", "toString", "", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXMeasureSize {
    private Float height;
    private Float width;

    public static /* synthetic */ GXMeasureSize copy$default(GXMeasureSize r100, Float r101, Float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        return r100.copy(r101, r102);
    }

    public final Float component1() {
        return this.width;
    }

    public final Float component2() {
        return this.height;
    }

    public final GXMeasureSize copy(Float r100, Float r101) {
        return new GXMeasureSize(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXMeasureSize) == true) goto L8;
        return false;
    L8:
        GXMeasureSize r101 = (GXMeasureSize) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Float r100 = this.width;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.height;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GXMeasureSize(width=" + this.width + ", height=" + this.height + ')';
    }

    public final Float getHeight() {
        return this.height;
    }

    public final Float getWidth() {
        return this.width;
    }

    public final void setHeight(Float r100) {
        this.height = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }

    public GXMeasureSize(Float r100, Float r101) {
        this.width = r100;
        this.height = r101;
    }
}
