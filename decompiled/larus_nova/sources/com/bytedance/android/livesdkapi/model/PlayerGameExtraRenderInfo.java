package com.bytedance.android.livesdkapi.model;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÂ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003JQ\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\tJ\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u0013¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderInfo;", "", "initSeiInfo", "Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo;", "curSeiInfo", "mainViewInfo", "Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "extraViewInfo", "landStyle", "", "cropRect", "Landroid/graphics/Rect;", "extraEnable", "(Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo;Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo;Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;ZLandroid/graphics/Rect;Z)V", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "getCurSeiInfo", "()Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo;", "setCurSeiInfo", "(Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo;)V", "getExtraEnable", "()Z", "setExtraEnable", "(Z)V", "getExtraViewInfo", "()Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "setExtraViewInfo", "(Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;)V", "getLandStyle", "setLandStyle", "getMainViewInfo", "setMainViewInfo", "seiInfo", "getSeiInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "getHorizontalPosition", "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "isWindow", "hashCode", "", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerGameExtraRenderInfo {
    private Rect cropRect;
    private PlayerGameExtraRenderSeiInfo curSeiInfo;
    private boolean extraEnable;
    private RenderViewInfo extraViewInfo;
    private final PlayerGameExtraRenderSeiInfo initSeiInfo;
    private boolean landStyle;
    private RenderViewInfo mainViewInfo;

    public PlayerGameExtraRenderInfo() {
        this(null, null, null, null, false, null, false, 127, null);
    }

    private final PlayerGameExtraRenderSeiInfo component1() {
        return this.initSeiInfo;
    }

    public static /* synthetic */ PlayerGameExtraRenderInfo copy$default(PlayerGameExtraRenderInfo r100, PlayerGameExtraRenderSeiInfo r101, PlayerGameExtraRenderSeiInfo r102, RenderViewInfo r103, RenderViewInfo r104, boolean r110, Rect r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.initSeiInfo;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.curSeiInfo;
    L8:
        PlayerGameExtraRenderSeiInfo r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.mainViewInfo;
    L11:
        RenderViewInfo r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.extraViewInfo;
    L14:
        RenderViewInfo r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.landStyle;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.cropRect;
    L20:
        Rect r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.extraEnable;
    L23:
        PlayerGameExtraRenderSeiInfo r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final PlayerGameExtraRenderSeiInfo component2() {
        return this.curSeiInfo;
    }

    public final RenderViewInfo component3() {
        return this.mainViewInfo;
    }

    public final RenderViewInfo component4() {
        return this.extraViewInfo;
    }

    public final boolean component5() {
        return this.landStyle;
    }

    public final Rect component6() {
        return this.cropRect;
    }

    public final boolean component7() {
        return this.extraEnable;
    }

    public final PlayerGameExtraRenderInfo copy(PlayerGameExtraRenderSeiInfo r110, PlayerGameExtraRenderSeiInfo r111, RenderViewInfo r112, RenderViewInfo r113, boolean r114, Rect r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "initSeiInfo");
        Intrinsics.checkNotNullParameter(r111, "curSeiInfo");
        Intrinsics.checkNotNullParameter(r112, "mainViewInfo");
        Intrinsics.checkNotNullParameter(r113, "extraViewInfo");
        return new PlayerGameExtraRenderInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerGameExtraRenderInfo) == false) goto L20;
        PlayerGameExtraRenderInfo r101 = (PlayerGameExtraRenderInfo) r100;
        if (Intrinsics.areEqual(this.initSeiInfo, r101.initSeiInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.curSeiInfo, r101.curSeiInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mainViewInfo, r101.mainViewInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraViewInfo, r101.extraViewInfo) == true) goto L14;
        return false;
    L14:
        if (this.landStyle == r101.landStyle) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cropRect, r101.cropRect) == true) goto L18;
        return false;
    L18:
        if (this.extraEnable == r101.extraEnable) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        PlayerGameExtraRenderSeiInfo r100 = this.initSeiInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PlayerGameExtraRenderSeiInfo r104 = this.curSeiInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        RenderViewInfo r107 = this.mainViewInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        RenderViewInfo r110 = this.extraViewInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.landStyle;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        Rect r117 = this.cropRect;
        if (r117 == null) goto L24;
        r101 = r117.hashCode();
    L24:
        int r118 = (r116 + r101) * 31;
        boolean r119 = this.extraEnable;
        if (r119 == true) goto L29;
        r114 = r119;
    L29:
        return r118 + r114;
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
        return "PlayerGameExtraRenderInfo(initSeiInfo=" + this.initSeiInfo + ", curSeiInfo=" + this.curSeiInfo + ", mainViewInfo=" + this.mainViewInfo + ", extraViewInfo=" + this.extraViewInfo + ", landStyle=" + this.landStyle + ", cropRect=" + this.cropRect + ", extraEnable=" + this.extraEnable + ")";
    }

    public final Rect getCropRect() {
        return this.cropRect;
    }

    public final PlayerGameExtraRenderSeiInfo getCurSeiInfo() {
        return this.curSeiInfo;
    }

    public final boolean getExtraEnable() {
        return this.extraEnable;
    }

    public final RenderViewInfo getExtraViewInfo() {
        return this.extraViewInfo;
    }

    public final boolean getLandStyle() {
        return this.landStyle;
    }

    public final RenderViewInfo getMainViewInfo() {
        return this.mainViewInfo;
    }

    public final PlayerGameExtraRenderSeiInfo getSeiInfo() {
        return this.curSeiInfo;
    }

    public final RenderAreaInfo getHorizontalPosition(boolean r100) {
        RenderAreaInfo r101 = getSeiInfo().getCameraHorizontalPosition();
        if (r101 == null) goto L12;
        if (r101.isValidHorizontalArea() == true) goto L14;
        if (r100 == false) goto L9;
        RenderAreaInfo r102 = new RenderAreaInfo(0.0f, 0.0f, 0.25f, 0.25f);
    L13:
        return r102;
    L9:
        r102 = new RenderAreaInfo(1.0f, 0.0f, 0.25f, 1.0f);
        goto L13
    L14:
        return r101;
    L12:
        return new RenderAreaInfo(0.0f, 0.0f, 0.25f, 0.25f);
    }

    public final void setCropRect(Rect r100) {
        this.cropRect = r100;
    }

    public final void setCurSeiInfo(PlayerGameExtraRenderSeiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.curSeiInfo = r100;
    }

    public final void setExtraEnable(boolean r100) {
        this.extraEnable = r100;
    }

    public final void setExtraViewInfo(RenderViewInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraViewInfo = r100;
    }

    public final void setLandStyle(boolean r100) {
        this.landStyle = r100;
    }

    public final void setMainViewInfo(RenderViewInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mainViewInfo = r100;
    }

    public PlayerGameExtraRenderInfo(PlayerGameExtraRenderSeiInfo r100, PlayerGameExtraRenderSeiInfo r101, RenderViewInfo r102, RenderViewInfo r103, boolean r104, Rect r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "initSeiInfo");
        Intrinsics.checkNotNullParameter(r101, "curSeiInfo");
        Intrinsics.checkNotNullParameter(r102, "mainViewInfo");
        Intrinsics.checkNotNullParameter(r103, "extraViewInfo");
        this.initSeiInfo = r100;
        this.curSeiInfo = r101;
        this.mainViewInfo = r102;
        this.extraViewInfo = r103;
        this.landStyle = r104;
        this.cropRect = r105;
        this.extraEnable = r106;
    }

    public /* synthetic */ PlayerGameExtraRenderInfo(PlayerGameExtraRenderSeiInfo r110, PlayerGameExtraRenderSeiInfo r111, RenderViewInfo r112, RenderViewInfo r113, boolean r114, Rect r210, boolean r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 1) == 0) goto L5;
        PlayerGameExtraRenderSeiInfo r100 = new PlayerGameExtraRenderSeiInfo(null, null, null, 0, false, 31, null);
    L7:
        if ((r212 & 2) == 0) goto L9;
        PlayerGameExtraRenderSeiInfo r101 = r100;
    L11:
        if ((r212 & 4) == 0) goto L13;
        RenderViewInfo r102 = new RenderViewInfo(null, 0, 0, 0, 0, null, false, 127, null);
    L15:
        if ((r212 & 8) == 0) goto L17;
        RenderViewInfo r103 = new RenderViewInfo(null, 0, 0, 0, 0, null, false, 127, null);
    L18:
        boolean r104 = false;
        if ((r212 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r212 & 32) == 0) goto L25;
        Rect r106 = null;
    L27:
        if ((r212 & 64) != 0) goto L30;
        r104 = r211;
    L30:
        this(r100, r101, r102, r103, r105, r106, r104);
        return;
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
