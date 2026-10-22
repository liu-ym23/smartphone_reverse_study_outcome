package com.bytedance.android.shopping.anchorv4.components;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001#BO\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JX\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/Frame;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "width", "height", "direction", "alignType", "verticalOffset", "horizontalOffset", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/components/Frame;", "", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getWidth", "getHeight", "getDirection", "getAlignType", "getVerticalOffset", "getHorizontalOffset", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Frame implements Serializable {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_START = 1;
    public static final a Companion = null;
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;

    @SerializedName("align_type")
    private final Integer alignType;
    private final Integer direction;
    private final Integer height;

    @SerializedName("horizontal_offset")
    private final Integer horizontalOffset;

    @SerializedName("vertical_offset")
    private final Integer verticalOffset;
    private final Integer width;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Frame() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Frame copy$default(Frame r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.direction;
    L11:
        Integer r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.alignType;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.verticalOffset;
    L17:
        Integer r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.horizontalOffset;
    L20:
        Integer r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Integer component1() {
        return this.width;
    }

    public final Integer component2() {
        return this.height;
    }

    public final Integer component3() {
        return this.direction;
    }

    public final Integer component4() {
        return this.alignType;
    }

    public final Integer component5() {
        return this.verticalOffset;
    }

    public final Integer component6() {
        return this.horizontalOffset;
    }

    public final Frame copy(Integer r100, Integer r110, Integer r111, Integer r112, Integer r113, Integer r114) {
        return new Frame(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Frame) == false) goto L18;
        Frame r101 = (Frame) r100;
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.direction, r101.direction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.alignType, r101.alignType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.verticalOffset, r101.verticalOffset) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.horizontalOffset, r101.horizontalOffset) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.width;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.height;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.direction;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.alignType;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.verticalOffset;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.horizontalOffset;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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

    public String toString() {
        return "Frame(width=" + this.width + ", height=" + this.height + ", direction=" + this.direction + ", alignType=" + this.alignType + ", verticalOffset=" + this.verticalOffset + ", horizontalOffset=" + this.horizontalOffset + ")";
    }

    public final Integer getAlignType() {
        return this.alignType;
    }

    public final Integer getDirection() {
        return this.direction;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public final Integer getVerticalOffset() {
        return this.verticalOffset;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public Frame(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105) {
        this.width = r100;
        this.height = r101;
        this.direction = r102;
        this.alignType = r103;
        this.verticalOffset = r104;
        this.horizontalOffset = r105;
    }

    public /* synthetic */ Frame(Integer r100, Integer r101, Integer r102, Integer r103, Integer r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Integer r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Integer r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
