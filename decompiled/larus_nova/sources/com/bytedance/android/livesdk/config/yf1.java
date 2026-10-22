package com.bytedance.android.livesdk.config;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/yf1;", "", "", "x", FaceService.girlLabel, "getX", "()F", "setX", "(F)V", "y", "getY", "setY", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getZ", "setZ", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class yf1 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f121683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f121684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    private float f121685z;

    public yf1() {
        this(0.0f, 0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof yf1) == false) goto L12;
        yf1 r101 = (yf1) r100;
        if (Float.compare(this.f121683x, r101.f121683x) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f121684y, r101.f121684y) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f121685z, r101.f121685z) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f121683x) * 31) + Float.floatToIntBits(this.f121684y)) * 31) + Float.floatToIntBits(this.f121685z);
    }

    public final String toString() {
        return "RevSpatialOrientation(x=" + this.f121683x + ", y=" + this.f121684y + ", z=" + this.f121685z + ")";
    }

    public yf1(float r100, float r101, float r102) {
        this.f121683x = r100;
        this.f121684y = r101;
        this.f121685z = r102;
    }
}
