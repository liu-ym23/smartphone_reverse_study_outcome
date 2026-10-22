package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMainApplyConfig;", "", "containerLeftMargin", "", "containerGravity", "containerVideoWidth", "containerVideoHeight", "bgNeedUpdate", "", "enableLandStyle", "containerTopMargin", "displayRatio", "Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "(IIIIZZILcom/bytedance/android/livesdkapi/model/DisplayRatio;)V", "getBgNeedUpdate", "()Z", "getContainerGravity", "()I", "getContainerLeftMargin", "getContainerTopMargin", "getContainerVideoHeight", "getContainerVideoWidth", "getDisplayRatio", "()Lcom/bytedance/android/livesdkapi/model/DisplayRatio;", "getEnableLandStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMainApplyConfig {
    private final boolean bgNeedUpdate;
    private final int containerGravity;
    private final int containerLeftMargin;
    private final int containerTopMargin;
    private final int containerVideoHeight;
    private final int containerVideoWidth;
    private final DisplayRatio displayRatio;
    private final boolean enableLandStyle;

    public PlayerMainApplyConfig() {
        this(0, 0, 0, 0, false, false, 0, null, 255, null);
    }

    public static /* synthetic */ PlayerMainApplyConfig copy$default(PlayerMainApplyConfig r100, int r110, int r111, int r112, int r113, boolean r114, boolean r115, int r116, DisplayRatio r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.containerLeftMargin;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.containerGravity;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.containerVideoWidth;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.containerVideoHeight;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.bgNeedUpdate;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.enableLandStyle;
    L27:
        if ((r118 & 64) == 0) goto L29;
        int r107 = r100.containerTopMargin;
    L31:
        if ((r118 & 128) == 0) goto L33;
        DisplayRatio r108 = r100.displayRatio;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
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

    public final int component1() {
        return this.containerLeftMargin;
    }

    public final int component2() {
        return this.containerGravity;
    }

    public final int component3() {
        return this.containerVideoWidth;
    }

    public final int component4() {
        return this.containerVideoHeight;
    }

    public final boolean component5() {
        return this.bgNeedUpdate;
    }

    public final boolean component6() {
        return this.enableLandStyle;
    }

    public final int component7() {
        return this.containerTopMargin;
    }

    public final DisplayRatio component8() {
        return this.displayRatio;
    }

    public final PlayerMainApplyConfig copy(int r110, int r111, int r112, int r113, boolean r114, boolean r115, int r116, DisplayRatio r117) {
        return new PlayerMainApplyConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMainApplyConfig) == false) goto L22;
        PlayerMainApplyConfig r101 = (PlayerMainApplyConfig) r100;
        if (this.containerLeftMargin == r101.containerLeftMargin) goto L8;
        return false;
    L8:
        if (this.containerGravity == r101.containerGravity) goto L10;
        return false;
    L10:
        if (this.containerVideoWidth == r101.containerVideoWidth) goto L12;
        return false;
    L12:
        if (this.containerVideoHeight == r101.containerVideoHeight) goto L14;
        return false;
    L14:
        if (this.bgNeedUpdate == r101.bgNeedUpdate) goto L16;
        return false;
    L16:
        if (this.enableLandStyle == r101.enableLandStyle) goto L18;
        return false;
    L18:
        if (this.containerTopMargin == r101.containerTopMargin) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.displayRatio, r101.displayRatio) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r100 = ((((((this.containerLeftMargin * 31) + this.containerGravity) * 31) + this.containerVideoWidth) * 31) + this.containerVideoHeight) * 31;
        boolean r101 = this.bgNeedUpdate;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.enableLandStyle;
        if (r105 == true) goto L9;
        r102 = r105;
    L9:
        int r106 = (((r104 + r102) * 31) + this.containerTopMargin) * 31;
        DisplayRatio r107 = this.displayRatio;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L14:
        return r106 + r108;
    L12:
        r108 = 0;
        goto L14
    }

    public String toString() {
        return "PlayerMainApplyConfig(containerLeftMargin=" + this.containerLeftMargin + ", containerGravity=" + this.containerGravity + ", containerVideoWidth=" + this.containerVideoWidth + ", containerVideoHeight=" + this.containerVideoHeight + ", bgNeedUpdate=" + this.bgNeedUpdate + ", enableLandStyle=" + this.enableLandStyle + ", containerTopMargin=" + this.containerTopMargin + ", displayRatio=" + this.displayRatio + ")";
    }

    public final boolean getBgNeedUpdate() {
        return this.bgNeedUpdate;
    }

    public final int getContainerGravity() {
        return this.containerGravity;
    }

    public final int getContainerLeftMargin() {
        return this.containerLeftMargin;
    }

    public final int getContainerTopMargin() {
        return this.containerTopMargin;
    }

    public final int getContainerVideoHeight() {
        return this.containerVideoHeight;
    }

    public final int getContainerVideoWidth() {
        return this.containerVideoWidth;
    }

    public final DisplayRatio getDisplayRatio() {
        return this.displayRatio;
    }

    public final boolean getEnableLandStyle() {
        return this.enableLandStyle;
    }

    public PlayerMainApplyConfig(int r100, int r101, int r102, int r103, boolean r104, boolean r105, int r106, DisplayRatio r107) {
        this.containerLeftMargin = r100;
        this.containerGravity = r101;
        this.containerVideoWidth = r102;
        this.containerVideoHeight = r103;
        this.bgNeedUpdate = r104;
        this.enableLandStyle = r105;
        this.containerTopMargin = r106;
        this.displayRatio = r107;
    }

    public /* synthetic */ PlayerMainApplyConfig(int r100, int r110, int r111, int r112, boolean r113, boolean r114, int r115, DisplayRatio r116, int r117, DefaultConstructorMarker r118) {
        boolean r101 = false;
        if ((r117 & 1) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r117 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r117 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r117 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r117 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r117 & 32) != 0) goto L27;
        r101 = r114;
    L27:
        if ((r117 & 64) == 0) goto L29;
        int r107 = -1;
    L31:
        if ((r117 & 128) == 0) goto L33;
        DisplayRatio r108 = null;
    L34:
        this(r102, r103, r104, r105, r106, r101, r107, r108);
        return;
    L33:
        r108 = r116;
        goto L34
    L29:
        r107 = r115;
        goto L31
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
