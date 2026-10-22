package com.bytedance.android.livesdkapi.model;

import android.graphics.Rect;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003JQ\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraLayoutConfig;", "", "width", "", "height", "top", "left", GXTemplateKey.GAIAX_LAYER_GRAVITY, "cropRect", "Landroid/graphics/Rect;", "landStyle", "", "(IIIIILandroid/graphics/Rect;Z)V", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "getGravity", "()I", "setGravity", "(I)V", "getHeight", "setHeight", "getLandStyle", "()Z", "setLandStyle", "(Z)V", "getLeft", "setLeft", "getTop", "setTop", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerGameExtraLayoutConfig {
    private Rect cropRect;
    private int gravity;
    private int height;
    private boolean landStyle;
    private int left;
    private int top;
    private int width;

    public PlayerGameExtraLayoutConfig() {
        this(0, 0, 0, 0, 0, null, false, 127, null);
    }

    public static /* synthetic */ PlayerGameExtraLayoutConfig copy$default(PlayerGameExtraLayoutConfig r100, int r101, int r102, int r103, int r104, int r110, Rect r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.top;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.left;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.gravity;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.cropRect;
    L20:
        Rect r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.landStyle;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.left;
    }

    public final int component5() {
        return this.gravity;
    }

    public final Rect component6() {
        return this.cropRect;
    }

    public final boolean component7() {
        return this.landStyle;
    }

    public final PlayerGameExtraLayoutConfig copy(int r110, int r111, int r112, int r113, int r114, Rect r115, boolean r116) {
        return new PlayerGameExtraLayoutConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerGameExtraLayoutConfig) == false) goto L20;
        PlayerGameExtraLayoutConfig r101 = (PlayerGameExtraLayoutConfig) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (this.top == r101.top) goto L12;
        return false;
    L12:
        if (this.left == r101.left) goto L14;
        return false;
    L14:
        if (this.gravity == r101.gravity) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.cropRect, r101.cropRect) == true) goto L18;
        return false;
    L18:
        if (this.landStyle == r101.landStyle) goto L31;
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
        int r100 = ((((((((this.width * 31) + this.height) * 31) + this.top) * 31) + this.left) * 31) + this.gravity) * 31;
        Rect r101 = this.cropRect;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.landStyle;
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
        return "PlayerGameExtraLayoutConfig(width=" + this.width + ", height=" + this.height + ", top=" + this.top + ", left=" + this.left + ", gravity=" + this.gravity + ", cropRect=" + this.cropRect + ", landStyle=" + this.landStyle + ")";
    }

    public final Rect getCropRect() {
        return this.cropRect;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getHeight() {
        return this.height;
    }

    public final boolean getLandStyle() {
        return this.landStyle;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setCropRect(Rect r100) {
        this.cropRect = r100;
    }

    public final void setGravity(int r100) {
        this.gravity = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setLandStyle(boolean r100) {
        this.landStyle = r100;
    }

    public final void setLeft(int r100) {
        this.left = r100;
    }

    public final void setTop(int r100) {
        this.top = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public PlayerGameExtraLayoutConfig(int r100, int r101, int r102, int r103, int r104, Rect r105, boolean r106) {
        this.width = r100;
        this.height = r101;
        this.top = r102;
        this.left = r103;
        this.gravity = r104;
        this.cropRect = r105;
        this.landStyle = r106;
    }

    public /* synthetic */ PlayerGameExtraLayoutConfig(int r100, int r101, int r102, int r110, int r111, Rect r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        int r116 = 0;
    L7:
        if ((r114 & 2) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r114 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r114 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r114 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r114 & 32) == 0) goto L25;
        r112 = null;
    L25:
        Rect r107 = r112;
        if ((r114 & 64) == 0) goto L28;
        boolean r117 = false;
    L29:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
