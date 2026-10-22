package com.bytedance.android.ec.core.imagex.opt;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/opt/g0;", "", "", "originResizeWidth", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "originResizeHeight", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "useScale", "d", "specificScale", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Integer f44853d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f44854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f44855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f44856c;

    @SerializedName("resize_height")
    private final Integer originResizeHeight;

    @SerializedName("resize_width")
    private final Integer originResizeWidth;

    @SerializedName("specific_scale")
    private final Integer specificScale;

    @SerializedName("use_scale")
    private final Integer useScale;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L14;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.originResizeWidth, r101.originResizeWidth) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originResizeHeight, r101.originResizeHeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.useScale, r101.useScale) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.specificScale, r101.specificScale) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.originResizeWidth;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.originResizeHeight;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.useScale;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.specificScale;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageXModifyResize(originResizeWidth=" + this.originResizeWidth + ", originResizeHeight=" + this.originResizeHeight + ", useScale=" + this.useScale + ", specificScale=" + this.specificScale + ")";
    }

    public g0() {
        this.originResizeWidth = null;
        this.originResizeHeight = null;
        this.useScale = null;
        this.specificScale = null;
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        this.f44854a = LazyKt.lazy(r100, new ImageXModifyResize$scale$2(this));
        this.f44855b = LazyKt.lazy(r100, new ImageXModifyResize$resizeWidth$2(this));
        this.f44856c = LazyKt.lazy(r100, new ImageXModifyResize$resizeHeight$2(this));
    }

    public final Integer a() {
        return this.originResizeHeight;
    }

    public final Integer b() {
        return this.originResizeWidth;
    }

    public final Integer c() {
        return this.specificScale;
    }

    public final Integer d() {
        return this.useScale;
    }
}
