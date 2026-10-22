package com.bytedance.android.shopping.anchorv4.dto.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Point;", "Ljava/io/Serializable;", "x", "", "y", "(II)V", "getX", "()I", "getY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Point implements Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private final int f166512x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private final int f166513y;

    public Point() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ Point copy$default(Point r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f166512x;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f166513y;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.f166512x;
    }

    public final int component2() {
        return this.f166513y;
    }

    public final Point copy(int r100, int r101) {
        return new Point(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Point) == false) goto L10;
        Point r101 = (Point) r100;
        if (this.f166512x == r101.f166512x) goto L8;
        return false;
    L8:
        if (this.f166513y == r101.f166513y) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.f166512x * 31) + this.f166513y;
    }

    public String toString() {
        return "Point(x=" + this.f166512x + ", y=" + this.f166513y + ")";
    }

    public final int getX() {
        return this.f166512x;
    }

    public final int getY() {
        return this.f166513y;
    }

    public Point(int r100, int r101) {
        this.f166512x = r100;
        this.f166513y = r101;
    }

    public /* synthetic */ Point(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
