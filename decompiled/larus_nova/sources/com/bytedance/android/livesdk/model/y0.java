package com.bytedance.android.livesdk.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/model/y0;", "", "", "x", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "d", "(I)V", "y", "b", "setY", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "c", "e", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private int f153952x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private int f153953y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    private int f153954z;

    public y0() {
        this(0, 0, 0);
    }

    public final void d() {
        this.f153952x = 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y0) == false) goto L12;
        y0 r101 = (y0) r100;
        if (this.f153952x == r101.f153952x) goto L8;
        return false;
    L8:
        if (this.f153953y == r101.f153953y) goto L10;
        return false;
    L10:
        if (this.f153954z == r101.f153954z) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f153952x * 31) + this.f153953y) * 31) + this.f153954z;
    }

    public final String toString() {
        return "SpatialPosition(x=" + this.f153952x + ", y=" + this.f153953y + ", z=" + this.f153954z + ")";
    }

    public final int a() {
        return this.f153952x;
    }

    public final int b() {
        return this.f153953y;
    }

    public final int c() {
        return this.f153954z;
    }

    public final void e(int r100) {
        this.f153954z = r100;
    }

    public y0(int r100, int r101, int r102) {
        this.f153952x = r100;
        this.f153953y = r101;
        this.f153954z = r102;
    }
}
