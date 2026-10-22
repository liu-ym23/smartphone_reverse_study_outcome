package com.bytedance.android.livesdkapi.model;

import android.graphics.Rect;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003JO\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "", "videoAreaInfo", "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "viewWidth", "", "viewHeight", "videoWidth", "videoHeight", GXTemplateKey.FLEXBOX_MARGIN, "Landroid/graphics/Rect;", "hidden", "", "(Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;IIIILandroid/graphics/Rect;Z)V", "getHidden", "()Z", "setHidden", "(Z)V", "getMargin", "()Landroid/graphics/Rect;", "setMargin", "(Landroid/graphics/Rect;)V", "getVideoAreaInfo", "()Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "setVideoAreaInfo", "(Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;)V", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "getVideoWidth", "setVideoWidth", "getViewHeight", "setViewHeight", "getViewWidth", "setViewWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RenderViewInfo {
    private boolean hidden;
    private Rect margin;
    private RenderAreaInfo videoAreaInfo;
    private int videoHeight;
    private int videoWidth;
    private int viewHeight;
    private int viewWidth;

    public RenderViewInfo() {
        this(null, 0, 0, 0, 0, null, false, 127, null);
    }

    public static /* synthetic */ RenderViewInfo copy$default(RenderViewInfo r100, RenderAreaInfo r101, int r102, int r103, int r104, int r110, Rect r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.videoAreaInfo;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.viewWidth;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.viewHeight;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.videoWidth;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.videoHeight;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.margin;
    L20:
        Rect r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.hidden;
    L23:
        RenderAreaInfo r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final RenderAreaInfo component1() {
        return this.videoAreaInfo;
    }

    public final int component2() {
        return this.viewWidth;
    }

    public final int component3() {
        return this.viewHeight;
    }

    public final int component4() {
        return this.videoWidth;
    }

    public final int component5() {
        return this.videoHeight;
    }

    public final Rect component6() {
        return this.margin;
    }

    public final boolean component7() {
        return this.hidden;
    }

    public final RenderViewInfo copy(RenderAreaInfo r110, int r111, int r112, int r113, int r114, Rect r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "videoAreaInfo");
        Intrinsics.checkNotNullParameter(r115, GXTemplateKey.FLEXBOX_MARGIN);
        return new RenderViewInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RenderViewInfo) == false) goto L20;
        RenderViewInfo r101 = (RenderViewInfo) r100;
        if (Intrinsics.areEqual(this.videoAreaInfo, r101.videoAreaInfo) == true) goto L8;
        return false;
    L8:
        if (this.viewWidth == r101.viewWidth) goto L10;
        return false;
    L10:
        if (this.viewHeight == r101.viewHeight) goto L12;
        return false;
    L12:
        if (this.videoWidth == r101.videoWidth) goto L14;
        return false;
    L14:
        if (this.videoHeight == r101.videoHeight) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.margin, r101.margin) == true) goto L18;
        return false;
    L18:
        if (this.hidden == r101.hidden) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        RenderAreaInfo r100 = this.videoAreaInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((((r102 * 31) + this.viewWidth) * 31) + this.viewHeight) * 31) + this.videoWidth) * 31) + this.videoHeight) * 31;
        Rect r104 = this.margin;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.hidden;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RenderViewInfo(videoAreaInfo=" + this.videoAreaInfo + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + ", videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", margin=" + this.margin + ", hidden=" + this.hidden + ")";
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final Rect getMargin() {
        return this.margin;
    }

    public final RenderAreaInfo getVideoAreaInfo() {
        return this.videoAreaInfo;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    public final void setHidden(boolean r100) {
        this.hidden = r100;
    }

    public final void setMargin(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.margin = r100;
    }

    public final void setVideoAreaInfo(RenderAreaInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoAreaInfo = r100;
    }

    public final void setVideoHeight(int r100) {
        this.videoHeight = r100;
    }

    public final void setVideoWidth(int r100) {
        this.videoWidth = r100;
    }

    public final void setViewHeight(int r100) {
        this.viewHeight = r100;
    }

    public final void setViewWidth(int r100) {
        this.viewWidth = r100;
    }

    public RenderViewInfo(RenderAreaInfo r100, int r101, int r102, int r103, int r104, Rect r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "videoAreaInfo");
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.FLEXBOX_MARGIN);
        this.videoAreaInfo = r100;
        this.viewWidth = r101;
        this.viewHeight = r102;
        this.videoWidth = r103;
        this.videoHeight = r104;
        this.margin = r105;
        this.hidden = r106;
    }

    public /* synthetic */ RenderViewInfo(RenderAreaInfo r100, int r110, int r111, int r112, int r113, Rect r114, boolean r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        RenderAreaInfo r101 = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    L6:
        int r102 = 0;
        if ((r116 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r116 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r116 & 16) != 0) goto L23;
        r102 = r113;
    L23:
        if ((r116 & 32) == 0) goto L25;
        Rect r106 = new Rect();
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r107 = true;
    L30:
        this(r101, r103, r104, r105, r102, r106, r107);
        return;
    L29:
        r107 = r115;
        goto L30
    L25:
        r106 = r114;
        goto L27
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
        r101 = r100;
        goto L6
    }
}
