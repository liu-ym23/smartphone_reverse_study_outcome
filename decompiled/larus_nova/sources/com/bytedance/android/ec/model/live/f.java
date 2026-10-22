package com.bytedance.android.ec.model.live;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/live/f;", "", "", "height", "J", "f", "()J", "borderRadius", "c", "", "backgroundColor", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "borderColor", "b", "text", "h", "fontSize", "e", "color", "d", "horizontalPadding", ce.f26391f, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("border_color")
    private final String borderColor;

    @SerializedName("border_radius")
    private final long borderRadius;

    @SerializedName("color")
    private final String color;

    @SerializedName("font_size")
    private final long fontSize;

    @SerializedName("height")
    private final long height;

    @SerializedName("horizontal_padding")
    private final long horizontalPadding;

    @SerializedName("text")
    private final String text;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L22;
        f r101 = (f) r100;
        if (this.height == r101.height) goto L8;
        return false;
    L8:
        if (this.borderRadius == r101.borderRadius) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backgroundColor, r101.backgroundColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderColor, r101.borderColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L16;
        return false;
    L16:
        if (this.fontSize == r101.fontSize) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L20;
        return false;
    L20:
        if (this.horizontalPadding == r101.horizontalPadding) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        long r100 = this.height;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.borderRadius;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.backgroundColor;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.borderColor;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.text;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        long r113 = this.fontSize;
        int r114 = (((r110 + r112) * 31) + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        String r115 = this.color;
        if (r115 == null) goto L17;
        r105 = r115.hashCode();
    L17:
        int r116 = (r114 + r105) * 31;
        long r117 = this.horizontalPadding;
        return r116 + ((int) (r117 ^ (r117 >>> 32)));
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "ECElementBubble(height=" + this.height + ", borderRadius=" + this.borderRadius + ", backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", text=" + this.text + ", fontSize=" + this.fontSize + ", color=" + this.color + ", horizontalPadding=" + this.horizontalPadding + ")";
    }

    public f() {
        this(0, 0, null, null, null, 0, null, 0);
    }

    public final String a() {
        return this.backgroundColor;
    }

    public final String b() {
        return this.borderColor;
    }

    public final long c() {
        return this.borderRadius;
    }

    public final String d() {
        return this.color;
    }

    public final long e() {
        return this.fontSize;
    }

    public final long f() {
        return this.height;
    }

    public final long g() {
        return this.horizontalPadding;
    }

    public final String h() {
        return this.text;
    }

    public f(long r100, long r101, String r102, String r103, String r104, long r105, String r110, long r111) {
        this.height = r100;
        this.borderRadius = r101;
        this.backgroundColor = r102;
        this.borderColor = r103;
        this.text = r104;
        this.fontSize = r105;
        this.color = r110;
        this.horizontalPadding = r111;
    }
}
