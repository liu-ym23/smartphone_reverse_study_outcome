package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003Jy\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010+\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMainRenderLayoutConfig;", "", "containerWidth", "", "containerHeight", "topMargin", "leftMargin", "isPortrait", "", "videoRatio", "", "wrapperWidth", "wrapperHeight", "enableLandStyle", "isFoldScreen", "displayRatio", "Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "(IIIIZFIIZZLcom/bytedance/android/livesdkapi/model/DisplayRatio;)V", "getContainerHeight", "()I", "getContainerWidth", "getDisplayRatio", "()Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "getEnableLandStyle", "()Z", "getLeftMargin", "getTopMargin", "getVideoRatio", "()F", "getWrapperHeight", "getWrapperWidth", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMainRenderLayoutConfig {
    private final int containerHeight;
    private final int containerWidth;
    private final DisplayRatio displayRatio;
    private final boolean enableLandStyle;
    private final boolean isFoldScreen;
    private final boolean isPortrait;
    private final int leftMargin;
    private final int topMargin;
    private final float videoRatio;
    private final int wrapperHeight;
    private final int wrapperWidth;

    public PlayerMainRenderLayoutConfig() {
        this(0, 0, 0, 0, false, 0.0f, 0, 0, false, false, null, 2047, null);
    }

    public static /* synthetic */ PlayerMainRenderLayoutConfig copy$default(PlayerMainRenderLayoutConfig r110, int r111, int r112, int r113, int r114, boolean r115, float r116, int r117, int r210, boolean r211, boolean r212, DisplayRatio r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        int r100 = r110.containerWidth;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r101 = r110.containerHeight;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = r110.topMargin;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r103 = r110.leftMargin;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r104 = r110.isPortrait;
    L23:
        if ((r214 & 32) == 0) goto L25;
        float r105 = r110.videoRatio;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r106 = r110.wrapperWidth;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r107 = r110.wrapperHeight;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r118 = r110.enableLandStyle;
    L39:
        if ((r214 & 512) == 0) goto L41;
        boolean r119 = r110.isFoldScreen;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        DisplayRatio r108 = r110.displayRatio;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
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
        return this.isFoldScreen;
    }

    public final DisplayRatio component11() {
        return this.displayRatio;
    }

    public final int component2() {
        return this.containerHeight;
    }

    public final int component3() {
        return this.topMargin;
    }

    public final int component4() {
        return this.leftMargin;
    }

    public final boolean component5() {
        return this.isPortrait;
    }

    public final float component6() {
        return this.videoRatio;
    }

    public final int component7() {
        return this.wrapperWidth;
    }

    public final int component8() {
        return this.wrapperHeight;
    }

    public final boolean component9() {
        return this.enableLandStyle;
    }

    public final PlayerMainRenderLayoutConfig copy(int r110, int r111, int r112, int r113, boolean r114, float r115, int r210, int r211, boolean r212, boolean r213, DisplayRatio r214) {
        return new PlayerMainRenderLayoutConfig(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMainRenderLayoutConfig) == false) goto L28;
        PlayerMainRenderLayoutConfig r101 = (PlayerMainRenderLayoutConfig) r100;
        if (this.containerWidth == r101.containerWidth) goto L8;
        return false;
    L8:
        if (this.containerHeight == r101.containerHeight) goto L10;
        return false;
    L10:
        if (this.topMargin == r101.topMargin) goto L12;
        return false;
    L12:
        if (this.leftMargin == r101.leftMargin) goto L14;
        return false;
    L14:
        if (this.isPortrait == r101.isPortrait) goto L16;
        return false;
    L16:
        if (Float.compare(this.videoRatio, r101.videoRatio) == 0) goto L18;
        return false;
    L18:
        if (this.wrapperWidth == r101.wrapperWidth) goto L20;
        return false;
    L20:
        if (this.wrapperHeight == r101.wrapperHeight) goto L22;
        return false;
    L22:
        if (this.enableLandStyle == r101.enableLandStyle) goto L24;
        return false;
    L24:
        if (this.isFoldScreen == r101.isFoldScreen) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.displayRatio, r101.displayRatio) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = ((((((this.containerWidth * 31) + this.containerHeight) * 31) + this.topMargin) * 31) + this.leftMargin) * 31;
        boolean r101 = this.isPortrait;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (((((((r100 + r103) * 31) + Float.floatToIntBits(this.videoRatio)) * 31) + this.wrapperWidth) * 31) + this.wrapperHeight) * 31;
        boolean r105 = this.enableLandStyle;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.isFoldScreen;
        if (r108 == true) goto L12;
        r102 = r108;
    L12:
        int r109 = (r107 + r102) * 31;
        DisplayRatio r110 = this.displayRatio;
        if (r110 == null) goto L15;
        int r111 = r110.hashCode();
    L17:
        return r109 + r111;
    L15:
        r111 = 0;
        goto L17
    }

    public String toString() {
        return "PlayerMainRenderLayoutConfig(containerWidth=" + this.containerWidth + ", containerHeight=" + this.containerHeight + ", topMargin=" + this.topMargin + ", leftMargin=" + this.leftMargin + ", isPortrait=" + this.isPortrait + ", videoRatio=" + this.videoRatio + ", wrapperWidth=" + this.wrapperWidth + ", wrapperHeight=" + this.wrapperHeight + ", enableLandStyle=" + this.enableLandStyle + ", isFoldScreen=" + this.isFoldScreen + ", displayRatio=" + this.displayRatio + ")";
    }

    public final int getContainerHeight() {
        return this.containerHeight;
    }

    public final int getContainerWidth() {
        return this.containerWidth;
    }

    public final DisplayRatio getDisplayRatio() {
        return this.displayRatio;
    }

    public final boolean getEnableLandStyle() {
        return this.enableLandStyle;
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getTopMargin() {
        return this.topMargin;
    }

    public final float getVideoRatio() {
        return this.videoRatio;
    }

    public final int getWrapperHeight() {
        return this.wrapperHeight;
    }

    public final int getWrapperWidth() {
        return this.wrapperWidth;
    }

    public final boolean isFoldScreen() {
        return this.isFoldScreen;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    public PlayerMainRenderLayoutConfig(int r100, int r101, int r102, int r103, boolean r104, float r105, int r106, int r107, boolean r108, boolean r110, DisplayRatio r111) {
        this.containerWidth = r100;
        this.containerHeight = r101;
        this.topMargin = r102;
        this.leftMargin = r103;
        this.isPortrait = r104;
        this.videoRatio = r105;
        this.wrapperWidth = r106;
        this.wrapperHeight = r107;
        this.enableLandStyle = r108;
        this.isFoldScreen = r110;
        this.displayRatio = r111;
    }

    public /* synthetic */ PlayerMainRenderLayoutConfig(int r110, int r111, int r112, int r113, boolean r114, float r115, int r116, int r210, boolean r211, boolean r212, DisplayRatio r213, int r214, DefaultConstructorMarker r215) {
        boolean r100 = false;
        if ((r214 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r214 & 8) == 0) goto L17;
        int r104 = 0;
    L19:
        if ((r214 & 16) == 0) goto L21;
        boolean r105 = true;
    L23:
        if ((r214 & 32) == 0) goto L25;
        float r106 = 0.0f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r107 = 0;
    L31:
        if ((r214 & 128) == 0) goto L33;
        int r108 = 0;
    L35:
        if ((r214 & 256) == 0) goto L37;
        boolean r117 = false;
    L39:
        if ((r214 & 512) != 0) goto L43;
        r100 = r212;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        DisplayRatio r109 = null;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r100, r109);
        return;
    L45:
        r109 = r213;
        goto L46
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
