package com.bytedance.android.livesdkapi.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0006\u0010&\u001a\u00020\fJ\u0006\u0010'\u001a\u00020\fJ\u0006\u0010(\u001a\u00020\fJ\u0006\u0010)\u001a\u00020\fJ\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMultiDisplay;", "", "displayId", "", "width", "height", "fitType", "alignType", "outputs", "", "Lcom/bytedance/android/livesdkapi/model/PlayerMultiOutput;", "withSkin", "", "(IIIIILjava/util/Map;Z)V", "getAlignType", "()I", "setAlignType", "(I)V", "getDisplayId", "getFitType", "setFitType", "getHeight", "getOutputs", "()Ljava/util/Map;", "getWidth", "getWithSkin", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "isCommon", "isLandscape", "isMultiRender", "isPortrait", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMultiDisplay {
    private int alignType;
    private final int displayId;
    private int fitType;
    private final int height;
    private final Map<Integer, PlayerMultiOutput> outputs;
    private final int width;
    private final boolean withSkin;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerMultiDisplay copy$default(PlayerMultiDisplay r100, int r101, int r102, int r103, int r104, int r110, Map r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.displayId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.height;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.fitType;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.alignType;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.outputs;
    L20:
        Map r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.withSkin;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.displayId;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.fitType;
    }

    public final int component5() {
        return this.alignType;
    }

    public final Map<Integer, PlayerMultiOutput> component6() {
        return this.outputs;
    }

    public final boolean component7() {
        return this.withSkin;
    }

    public final PlayerMultiDisplay copy(int r110, int r111, int r112, int r113, int r114, Map<Integer, PlayerMultiOutput> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r115, "outputs");
        return new PlayerMultiDisplay(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMultiDisplay) == false) goto L20;
        PlayerMultiDisplay r101 = (PlayerMultiDisplay) r100;
        if (this.displayId == r101.displayId) goto L8;
        return false;
    L8:
        if (this.width == r101.width) goto L10;
        return false;
    L10:
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (this.fitType == r101.fitType) goto L14;
        return false;
    L14:
        if (this.alignType == r101.alignType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.outputs, r101.outputs) == true) goto L18;
        return false;
    L18:
        if (this.withSkin == r101.withSkin) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int r100 = ((((((((this.displayId * 31) + this.width) * 31) + this.height) * 31) + this.fitType) * 31) + this.alignType) * 31;
        Map<Integer, PlayerMultiOutput> r101 = this.outputs;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.withSkin;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlayerMultiDisplay(displayId=" + this.displayId + ", width=" + this.width + ", height=" + this.height + ", fitType=" + this.fitType + ", alignType=" + this.alignType + ", outputs=" + this.outputs + ", withSkin=" + this.withSkin + ")";
    }

    public final boolean isCommon() {
        if (((this.displayId / 100) % 10) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLandscape() {
        if (((this.displayId / 100) % 10) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiRender() {
        if ((this.displayId / 1000) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPortrait() {
        if (((this.displayId / 100) % 10) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getAlignType() {
        return this.alignType;
    }

    public final int getDisplayId() {
        return this.displayId;
    }

    public final int getFitType() {
        return this.fitType;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Map<Integer, PlayerMultiOutput> getOutputs() {
        return this.outputs;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean getWithSkin() {
        return this.withSkin;
    }

    public final void setAlignType(int r100) {
        this.alignType = r100;
    }

    public final void setFitType(int r100) {
        this.fitType = r100;
    }

    public PlayerMultiDisplay(int r100, int r101, int r102, int r103, int r104, Map<Integer, PlayerMultiOutput> r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r105, "outputs");
        this.displayId = r100;
        this.width = r101;
        this.height = r102;
        this.fitType = r103;
        this.alignType = r104;
        this.outputs = r105;
        this.withSkin = r106;
    }

    public /* synthetic */ PlayerMultiDisplay(int r110, int r111, int r112, int r113, int r114, Map r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 64) == 0) goto L5;
        boolean r100 = false;
    L6:
        this(r110, r111, r112, r113, r114, r115, r100);
        return;
    L5:
        r100 = r116;
        goto L6
    }
}
