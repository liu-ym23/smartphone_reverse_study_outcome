package com.byted.mgl.merge.base.service.protocol.media.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Lcom/byted/mgl/merge/base/service/protocol/media/entity/ImageInfo;", "", "width", "", "height", "path", "", "type", "orientation", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHeight", "()I", "setHeight", "(I)V", "getOrientation", "()Ljava/lang/String;", "setOrientation", "(Ljava/lang/String;)V", "getPath", "setPath", "getType", "setType", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "bdp-appbase_release"}, k = 1, mv = {1, 1, 18})
public final class ImageInfo {
    private int height;
    private String orientation;
    private String path;
    private String type;
    private int width;

    public static /* synthetic */ ImageInfo copy$default(ImageInfo r100, int r101, int r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.path;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.type;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.orientation;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final String component3() {
        return this.path;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.orientation;
    }

    public final ImageInfo copy(int r100, int r101, String r110, String r111, String r112) {
        return new ImageInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageInfo) == false) goto L16;
        ImageInfo r101 = (ImageInfo) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.orientation, r101.orientation) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.width * 31) + this.height) * 31;
        String r101 = this.path;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.type;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.orientation;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "ImageInfo(width=" + this.width + ", height=" + this.height + ", path=" + this.path + ", type=" + this.type + ", orientation=" + this.orientation + ")";
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getOrientation() {
        return this.orientation;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getType() {
        return this.type;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setOrientation(String r100) {
        this.orientation = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public ImageInfo(int r100, int r101, String r102, String r103, String r104) {
        this.width = r100;
        this.height = r101;
        this.path = r102;
        this.type = r103;
        this.orientation = r104;
    }

    public /* synthetic */ ImageInfo(int r100, int r101, String r102, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        r111 = "up";
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
