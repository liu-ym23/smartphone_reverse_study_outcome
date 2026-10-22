package com.bytedance.android.shopping.anchorv4.dto.business;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/a;", "", "", "", GXTemplateKey.FLEXBOX_MARGIN, "Ljava/util/List;", "b", "()Ljava/util/List;", GXTemplateKey.FLEXBOX_PADDING, "c", "", "bgColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "radius", "d", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("bg_color")
    private final String bgColor;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final List<Float> margin;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final List<Float> padding;

    @SerializedName("radius")
    private final List<Float> radius;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.padding, r101.padding) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<Float> r100 = this.margin;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Float> r104 = this.padding;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bgColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Float> r110 = this.radius;
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
        return "ComponentStyle(margin=" + this.margin + ", padding=" + this.padding + ", bgColor=" + this.bgColor + ", radius=" + this.radius + ")";
    }

    public a() {
        this.margin = null;
        this.padding = null;
        this.bgColor = null;
        this.radius = null;
    }

    public final String a() {
        return this.bgColor;
    }

    public final List<Float> b() {
        return this.margin;
    }

    public final List<Float> c() {
        return this.padding;
    }

    public final List<Float> d() {
        return this.radius;
    }
}
