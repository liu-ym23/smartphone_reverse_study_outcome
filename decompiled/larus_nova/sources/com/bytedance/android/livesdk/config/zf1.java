package com.bytedance.android.livesdk.config;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/zf1;", "", "", "x", "I", "getX", "()I", "setX", "(I)V", "y", "getY", "setY", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getZ", "setZ", "liverevlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class zf1 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private int f121760x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private int f121761y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    private int f121762z;

    public zf1() {
        this(0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof zf1) == false) goto L12;
        zf1 r101 = (zf1) r100;
        if (this.f121760x == r101.f121760x) goto L8;
        return false;
    L8:
        if (this.f121761y == r101.f121761y) goto L10;
        return false;
    L10:
        if (this.f121762z == r101.f121762z) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f121760x * 31) + this.f121761y) * 31) + this.f121762z;
    }

    public final String toString() {
        return "RevSpatialPosition(x=" + this.f121760x + ", y=" + this.f121761y + ", z=" + this.f121762z + ")";
    }

    public zf1(int r100, int r101, int r102) {
        this.f121760x = r100;
        this.f121761y = r101;
        this.f121762z = r102;
    }
}
