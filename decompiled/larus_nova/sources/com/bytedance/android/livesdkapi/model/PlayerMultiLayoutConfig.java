package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMultiLayoutConfig;", "", "width", "", "height", "leftMargin", "topMargin", "(IIII)V", "getHeight", "()I", "getLeftMargin", "getTopMargin", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMultiLayoutConfig {
    private final int height;
    private final int leftMargin;
    private final int topMargin;
    private final int width;

    public static /* synthetic */ PlayerMultiLayoutConfig copy$default(PlayerMultiLayoutConfig r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.height;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.leftMargin;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.topMargin;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.leftMargin;
    }

    public final int component4() {
        return this.topMargin;
    }

    public final PlayerMultiLayoutConfig copy(int r100, int r101, int r102, int r103) {
        return new PlayerMultiLayoutConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMultiLayoutConfig) == false) goto L14;
        PlayerMultiLayoutConfig r101 = (PlayerMultiLayoutConfig) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (this.leftMargin == r101.leftMargin) goto L12;
        return false;
    L12:
        if (this.topMargin == r101.topMargin) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.leftMargin) * 31) + this.topMargin;
    }

    public String toString() {
        return "PlayerMultiLayoutConfig(width=" + this.width + ", height=" + this.height + ", leftMargin=" + this.leftMargin + ", topMargin=" + this.topMargin + ")";
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    public final int getWidth() {
        return this.width;
    }

    public PlayerMultiLayoutConfig(int r100, int r101, int r102, int r103) {
        this.width = r100;
        this.height = r101;
        this.leftMargin = r102;
        this.topMargin = r103;
    }
}
