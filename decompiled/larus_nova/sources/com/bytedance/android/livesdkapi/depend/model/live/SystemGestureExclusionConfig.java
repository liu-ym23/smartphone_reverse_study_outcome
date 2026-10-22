package com.bytedance.android.livesdkapi.depend.model.live;

import android.graphics.Rect;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0002\u0010\u001eR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/SystemGestureExclusionConfig;", "", "()V", "bottom", "", "getBottom", "()[F", "setBottom", "([F)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "top", "getTop", "setTop", "getExclusionRect", "", "Landroid/graphics/Rect;", "width", "", "height", "(II)[Landroid/graphics/Rect;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SystemGestureExclusionConfig {

    @SerializedName("bottom")
    private float[] bottom;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("left")
    private float[] left;

    @SerializedName("right")
    private float[] right;

    @SerializedName("top")
    private float[] top;

    public SystemGestureExclusionConfig() {
    }

    public final float[] getBottom() {
        return this.bottom;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float[] getLeft() {
        return this.left;
    }

    public final float[] getRight() {
        return this.right;
    }

    public final float[] getTop() {
        return this.top;
    }

    public final void setBottom(float[] r100) {
        this.bottom = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setLeft(float[] r100) {
        this.left = r100;
    }

    public final void setRight(float[] r100) {
        this.right = r100;
    }

    public final void setTop(float[] r100) {
        this.top = r100;
    }

    public final Rect[] getExclusionRect(int r100, int r110) {
        float[] r101 = this.left;
        Rect[] r102 = null;
        if (r101 == null) goto L31;
        float[] r103 = this.top;
        if (r103 == null) goto L31;
        float[] r104 = this.right;
        if (r104 == null) goto L31;
        float[] r105 = this.bottom;
        if (r105 == null) goto L31;
        int r106 = 0;
        if (r101 == null) goto L14;
        int r107 = r101.length;
    L15:
        if (r103 == null) goto L17;
        int r108 = r103.length;
    L18:
        if (r104 == null) goto L20;
        int r109 = r104.length;
    L21:
        if (r105 == null) goto L23;
        int r111 = r105.length;
    L24:
        if (r107 != r108) goto L31;
        if (r108 != r109) goto L31;
        if (r109 != r111) goto L31;
        if (r111 <= 0) goto L31;
        r102 = new Rect[r107];
    L29:
        if (r106 >= r107) goto L31;
        float[] r112 = this.left;
        Intrinsics.checkNotNull(r112);
        float r113 = r100;
        int r114 = (int) (r112[r106] * r113);
        float[] r115 = this.top;
        Intrinsics.checkNotNull(r115);
        float r116 = r110;
        int r117 = (int) (r115[r106] * r116);
        float[] r118 = this.right;
        Intrinsics.checkNotNull(r118);
        int r119 = (int) (r118[r106] * r113);
        float[] r120 = this.bottom;
        Intrinsics.checkNotNull(r120);
        r102[r106] = new Rect(r114, r117, r119, (int) (r120[r106] * r116));
        r106 = r106 + 1;
        goto L29
    L23:
        r111 = 0;
        goto L24
    L20:
        r109 = 0;
        goto L21
    L17:
        r108 = 0;
        goto L18
    L14:
        r107 = 0;
    L31:
        return r102;
    }
}
