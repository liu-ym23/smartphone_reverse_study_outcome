package com.bytedance.android.livesdk.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/model/x0;", "", "", "x", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "setX", "(F)V", "y", "b", "setY", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "c", "setZ", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f153949x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f153950y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    private float f153951z;

    public x0() {
        this(0.0f, 0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L12;
        x0 r101 = (x0) r100;
        if (Float.compare(this.f153949x, r101.f153949x) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f153950y, r101.f153950y) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f153951z, r101.f153951z) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f153949x) * 31) + Float.floatToIntBits(this.f153950y)) * 31) + Float.floatToIntBits(this.f153951z);
    }

    public final String toString() {
        return "SpatialOrientation(x=" + this.f153949x + ", y=" + this.f153950y + ", z=" + this.f153951z + ")";
    }

    public final float a() {
        return this.f153949x;
    }

    public final float b() {
        return this.f153950y;
    }

    public final float c() {
        return this.f153951z;
    }

    public x0(float r100, float r101, float r102) {
        this.f153949x = r100;
        this.f153950y = r101;
        this.f153951z = r102;
    }
}
