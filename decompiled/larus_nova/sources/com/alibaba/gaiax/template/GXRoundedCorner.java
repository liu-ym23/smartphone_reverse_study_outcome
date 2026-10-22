package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/alibaba/gaiax/template/GXRoundedCorner;", "", "topLeft", "Lcom/alibaba/gaiax/template/GXSize;", "topRight", "bottomLeft", "bottomRight", "(Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXSize;)V", "getBottomLeft", "()Lcom/alibaba/gaiax/template/GXSize;", "setBottomLeft", "(Lcom/alibaba/gaiax/template/GXSize;)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "value", "", "getValue", "()[F", "isSameRadius", "", "toFloatArray", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXRoundedCorner {
    private GXSize bottomLeft;
    private GXSize bottomRight;
    private GXSize topLeft;
    private GXSize topRight;

    private final float[] toFloatArray() {
        float[] r100 = new float[8];
        GXSize r101 = this.topLeft;
        float r102 = 0.0f;
        if (r101 == null) goto L5;
        float r103 = r101.getValueFloat();
    L6:
        GXSize r104 = this.topRight;
        if (r104 == null) goto L9;
        float r105 = r104.getValueFloat();
    L10:
        GXSize r106 = this.bottomLeft;
        if (r106 == null) goto L13;
        float r107 = r106.getValueFloat();
    L14:
        GXSize r108 = this.bottomRight;
        if (r108 == null) goto L17;
        r102 = r108.getValueFloat();
    L17:
        r100[0] = r103;
        r100[1] = r103;
        r100[2] = r105;
        r100[3] = r105;
        r100[4] = r102;
        r100[5] = r102;
        r100[6] = r107;
        r100[7] = r107;
        return r100;
    L13:
        r107 = 0.0f;
        goto L14
    L9:
        r105 = 0.0f;
        goto L10
    L5:
        r103 = 0.0f;
        goto L6
    }

    public final boolean isSameRadius() {
        GXSize r100 = this.topLeft;
        Float r101 = null;
        if (r100 == null) goto L5;
        Float r102 = Float.valueOf(r100.getValueFloat());
    L6:
        GXSize r103 = this.topRight;
        if (r103 == null) goto L9;
        Float r104 = Float.valueOf(r103.getValueFloat());
    L11:
        if (Intrinsics.areEqual(r102, r104) == false) goto L32;
        GXSize r105 = this.topRight;
        if (r105 == null) goto L15;
        Float r106 = Float.valueOf(r105.getValueFloat());
    L16:
        GXSize r107 = this.bottomLeft;
        if (r107 == null) goto L19;
        Float r108 = Float.valueOf(r107.getValueFloat());
    L21:
        if (Intrinsics.areEqual(r106, r108) == false) goto L32;
        GXSize r109 = this.bottomLeft;
        if (r109 == null) goto L25;
        Float r110 = Float.valueOf(r109.getValueFloat());
    L26:
        GXSize r111 = this.bottomRight;
        if (r111 == null) goto L30;
        r101 = Float.valueOf(r111.getValueFloat());
    L30:
        if (Intrinsics.areEqual(r110, r101) == false) goto L32;
        return true;
    L25:
        r110 = null;
        goto L26
    L19:
        r108 = null;
        goto L21
    L15:
        r106 = null;
    L32:
        return false;
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    public final float[] getValue() {
        return toFloatArray();
    }

    public final GXSize getBottomLeft() {
        return this.bottomLeft;
    }

    public final GXSize getBottomRight() {
        return this.bottomRight;
    }

    public final GXSize getTopLeft() {
        return this.topLeft;
    }

    public final GXSize getTopRight() {
        return this.topRight;
    }

    public final void setBottomLeft(GXSize r100) {
        this.bottomLeft = r100;
    }

    public final void setBottomRight(GXSize r100) {
        this.bottomRight = r100;
    }

    public final void setTopLeft(GXSize r100) {
        this.topLeft = r100;
    }

    public final void setTopRight(GXSize r100) {
        this.topRight = r100;
    }

    public GXRoundedCorner(GXSize r100, GXSize r101, GXSize r102, GXSize r103) {
        this.topLeft = r100;
        this.topRight = r101;
        this.bottomLeft = r102;
        this.bottomRight = r103;
    }
}
