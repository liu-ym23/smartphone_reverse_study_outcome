package com.bytedance.android.livesdkapi.model;

import android.graphics.Rect;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\u0083\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderLayoutConfig;", "", "containerWidth", "", "containerHeight", "containerGravity", "containerLeftMargin", "containerTopMargin", "wrapperWidth", "wrapperHeight", "wrapperGravity", "wrapperCorner", "", "bgVisibility", "scaleType", "cropRect", "Landroid/graphics/Rect;", "(IIIIIIIIZZILandroid/graphics/Rect;)V", "getBgVisibility", "()Z", "getContainerGravity", "()I", "getContainerHeight", "getContainerLeftMargin", "getContainerTopMargin", "getContainerWidth", "getCropRect", "()Landroid/graphics/Rect;", "getScaleType", "getWrapperCorner", "getWrapperGravity", "getWrapperHeight", "getWrapperWidth", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerExtraRenderLayoutConfig {
    private final boolean bgVisibility;
    private final int containerGravity;
    private final int containerHeight;
    private final int containerLeftMargin;
    private final int containerTopMargin;
    private final int containerWidth;
    private final Rect cropRect;
    private final int scaleType;
    private final boolean wrapperCorner;
    private final int wrapperGravity;
    private final int wrapperHeight;
    private final int wrapperWidth;

    public PlayerExtraRenderLayoutConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ PlayerExtraRenderLayoutConfig copy$default(PlayerExtraRenderLayoutConfig r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, int r211, boolean r212, boolean r213, int r214, Rect r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        int r100 = r110.containerWidth;
    L7:
        if ((r216 & 2) == 0) goto L9;
        int r101 = r110.containerHeight;
    L11:
        if ((r216 & 4) == 0) goto L13;
        int r102 = r110.containerGravity;
    L15:
        if ((r216 & 8) == 0) goto L17;
        int r103 = r110.containerLeftMargin;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r104 = r110.containerTopMargin;
    L23:
        if ((r216 & 32) == 0) goto L25;
        int r105 = r110.wrapperWidth;
    L27:
        if ((r216 & 64) == 0) goto L29;
        int r106 = r110.wrapperHeight;
    L31:
        if ((r216 & 128) == 0) goto L33;
        int r107 = r110.wrapperGravity;
    L35:
        if ((r216 & 256) == 0) goto L37;
        boolean r117 = r110.wrapperCorner;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r118 = r110.bgVisibility;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        int r119 = r110.scaleType;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        Rect r108 = r110.cropRect;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final int component1() {
        return this.containerWidth;
    }

    public final boolean component10() {
        return this.bgVisibility;
    }

    public final int component11() {
        return this.scaleType;
    }

    public final Rect component12() {
        return this.cropRect;
    }

    public final int component2() {
        return this.containerHeight;
    }

    public final int component3() {
        return this.containerGravity;
    }

    public final int component4() {
        return this.containerLeftMargin;
    }

    public final int component5() {
        return this.containerTopMargin;
    }

    public final int component6() {
        return this.wrapperWidth;
    }

    public final int component7() {
        return this.wrapperHeight;
    }

    public final int component8() {
        return this.wrapperGravity;
    }

    public final boolean component9() {
        return this.wrapperCorner;
    }

    public final PlayerExtraRenderLayoutConfig copy(int r110, int r111, int r112, int r113, int r114, int r210, int r211, int r212, boolean r213, boolean r214, int r215, Rect r216) {
        return new PlayerExtraRenderLayoutConfig(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerExtraRenderLayoutConfig) == false) goto L30;
        PlayerExtraRenderLayoutConfig r101 = (PlayerExtraRenderLayoutConfig) r100;
        if (this.containerWidth == r101.containerWidth) goto L8;
        return false;
    L8:
        if (this.containerHeight == r101.containerHeight) goto L10;
        return false;
    L10:
        if (this.containerGravity == r101.containerGravity) goto L12;
        return false;
    L12:
        if (this.containerLeftMargin == r101.containerLeftMargin) goto L14;
        return false;
    L14:
        if (this.containerTopMargin == r101.containerTopMargin) goto L16;
        return false;
    L16:
        if (this.wrapperWidth == r101.wrapperWidth) goto L18;
        return false;
    L18:
        if (this.wrapperHeight == r101.wrapperHeight) goto L20;
        return false;
    L20:
        if (this.wrapperGravity == r101.wrapperGravity) goto L22;
        return false;
    L22:
        if (this.wrapperCorner == r101.wrapperCorner) goto L24;
        return false;
    L24:
        if (this.bgVisibility == r101.bgVisibility) goto L26;
        return false;
    L26:
        if (this.scaleType == r101.scaleType) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.cropRect, r101.cropRect) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = ((((((((((((((this.containerWidth * 31) + this.containerHeight) * 31) + this.containerGravity) * 31) + this.containerLeftMargin) * 31) + this.containerTopMargin) * 31) + this.wrapperWidth) * 31) + this.wrapperHeight) * 31) + this.wrapperGravity) * 31;
        boolean r101 = this.wrapperCorner;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.bgVisibility;
        if (r105 == true) goto L9;
        r102 = r105;
    L9:
        int r106 = (((r104 + r102) * 31) + this.scaleType) * 31;
        Rect r107 = this.cropRect;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L14:
        return r106 + r108;
    L12:
        r108 = 0;
        goto L14
    }

    public String toString() {
        return "PlayerExtraRenderLayoutConfig(containerWidth=" + this.containerWidth + ", containerHeight=" + this.containerHeight + ", containerGravity=" + this.containerGravity + ", containerLeftMargin=" + this.containerLeftMargin + ", containerTopMargin=" + this.containerTopMargin + ", wrapperWidth=" + this.wrapperWidth + ", wrapperHeight=" + this.wrapperHeight + ", wrapperGravity=" + this.wrapperGravity + ", wrapperCorner=" + this.wrapperCorner + ", bgVisibility=" + this.bgVisibility + ", scaleType=" + this.scaleType + ", cropRect=" + this.cropRect + ")";
    }

    public final boolean getBgVisibility() {
        return this.bgVisibility;
    }

    public final int getContainerGravity() {
        return this.containerGravity;
    }

    public final int getContainerHeight() {
        return this.containerHeight;
    }

    public final int getContainerLeftMargin() {
        return this.containerLeftMargin;
    }

    public final int getContainerTopMargin() {
        return this.containerTopMargin;
    }

    public final int getContainerWidth() {
        return this.containerWidth;
    }

    public final Rect getCropRect() {
        return this.cropRect;
    }

    public final int getScaleType() {
        return this.scaleType;
    }

    public final boolean getWrapperCorner() {
        return this.wrapperCorner;
    }

    public final int getWrapperGravity() {
        return this.wrapperGravity;
    }

    public final int getWrapperHeight() {
        return this.wrapperHeight;
    }

    public final int getWrapperWidth() {
        return this.wrapperWidth;
    }

    public PlayerExtraRenderLayoutConfig(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r108, boolean r110, int r111, Rect r112) {
        this.containerWidth = r100;
        this.containerHeight = r101;
        this.containerGravity = r102;
        this.containerLeftMargin = r103;
        this.containerTopMargin = r104;
        this.wrapperWidth = r105;
        this.wrapperHeight = r106;
        this.wrapperGravity = r107;
        this.wrapperCorner = r108;
        this.bgVisibility = r110;
        this.scaleType = r111;
        this.cropRect = r112;
    }

    public /* synthetic */ PlayerExtraRenderLayoutConfig(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r210, boolean r211, boolean r212, int r213, Rect r214, int r215, DefaultConstructorMarker r216) {
        boolean r100 = false;
        if ((r215 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r215 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r215 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r215 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r215 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r215 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r215 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r215 & 128) == 0) goto L33;
        int r108 = 0;
    L35:
        if ((r215 & 256) == 0) goto L37;
        boolean r117 = false;
    L39:
        if ((r215 & 512) != 0) goto L43;
        r100 = r212;
    L43:
        if ((r215 & 1024) == 0) goto L45;
        int r118 = 3;
    L47:
        if ((r215 & 2048) == 0) goto L49;
        Rect r109 = null;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r100, r118, r109);
        return;
    L49:
        r109 = r214;
        goto L50
    L45:
        r118 = r213;
        goto L47
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
