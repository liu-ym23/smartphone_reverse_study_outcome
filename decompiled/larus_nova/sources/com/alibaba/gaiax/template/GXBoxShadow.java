package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/alibaba/gaiax/template/GXBoxShadow;", "", "xOffset", "Lcom/alibaba/gaiax/template/GXSize;", "yOffset", "blurOffset", "spreadOffset", "color", "Lcom/alibaba/gaiax/template/GXColor;", "(Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXSize;Lcom/alibaba/gaiax/template/GXColor;)V", "getBlurOffset", "()Lcom/alibaba/gaiax/template/GXSize;", "getColor", "()Lcom/alibaba/gaiax/template/GXColor;", "getSpreadOffset", "getXOffset", "getYOffset", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXBoxShadow {
    private final GXSize blurOffset;
    private final GXColor color;
    private final GXSize spreadOffset;
    private final GXSize xOffset;
    private final GXSize yOffset;

    public final GXSize getBlurOffset() {
        return this.blurOffset;
    }

    public final GXColor getColor() {
        return this.color;
    }

    public final GXSize getSpreadOffset() {
        return this.spreadOffset;
    }

    public final GXSize getXOffset() {
        return this.xOffset;
    }

    public final GXSize getYOffset() {
        return this.yOffset;
    }

    public GXBoxShadow(GXSize r100, GXSize r101, GXSize r102, GXSize r103, GXColor r104) {
        Intrinsics.checkNotNullParameter(r100, "xOffset");
        Intrinsics.checkNotNullParameter(r101, "yOffset");
        Intrinsics.checkNotNullParameter(r102, "blurOffset");
        Intrinsics.checkNotNullParameter(r103, "spreadOffset");
        Intrinsics.checkNotNullParameter(r104, "color");
        this.xOffset = r100;
        this.yOffset = r101;
        this.blurOffset = r102;
        this.spreadOffset = r103;
        this.color = r104;
    }
}
