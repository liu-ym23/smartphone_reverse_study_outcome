package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ContainerLayout;", "", "()V", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "marginBottom", "getMarginBottom", "setMarginBottom", "marginLeft", "getMarginLeft", "setMarginLeft", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "paddingBottom", "getPaddingBottom", "setPaddingBottom", "paddingLeft", "getPaddingLeft", "setPaddingLeft", "paddingRight", "getPaddingRight", "setPaddingRight", "paddingTop", "getPaddingTop", "setPaddingTop", "width", "getWidth", "setWidth", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ContainerLayout implements h {

    @SerializedName("height")
    protected Integer height;

    @SerializedName("marginBottom")
    protected Integer marginBottom;

    @SerializedName("marginLeft")
    protected Integer marginLeft;

    @SerializedName("marginRight")
    protected Integer marginRight;

    @SerializedName("marginTop")
    protected Integer marginTop;

    @SerializedName("paddingBottom")
    protected Integer paddingBottom;

    @SerializedName("paddingLeft")
    protected Integer paddingLeft;

    @SerializedName("paddingRight")
    protected Integer paddingRight;

    @SerializedName("paddingTop")
    protected Integer paddingTop;

    @SerializedName("width")
    protected Integer width;

    public ContainerLayout() {
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getMarginBottom() {
        return this.marginBottom;
    }

    public final Integer getMarginLeft() {
        return this.marginLeft;
    }

    public final Integer getMarginRight() {
        return this.marginRight;
    }

    public final Integer getMarginTop() {
        return this.marginTop;
    }

    public final Integer getPaddingBottom() {
        return this.paddingBottom;
    }

    public final Integer getPaddingLeft() {
        return this.paddingLeft;
    }

    public final Integer getPaddingRight() {
        return this.paddingRight;
    }

    public final Integer getPaddingTop() {
        return this.paddingTop;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public ContainerLayout(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.paddingTop = Integer.valueOf(r100.i());
        goto L3
    L8:
        this.paddingBottom = Integer.valueOf(r100.i());
        goto L3
    L9:
        this.paddingRight = Integer.valueOf(r100.i());
        goto L3
    L10:
        this.paddingLeft = Integer.valueOf(r100.i());
        goto L3
    L11:
        this.marginRight = Integer.valueOf(r100.i());
        goto L3
    L12:
        this.marginBottom = Integer.valueOf(r100.i());
        goto L3
    L13:
        this.marginTop = Integer.valueOf(r100.i());
        goto L3
    L14:
        this.marginLeft = Integer.valueOf(r100.i());
        goto L3
    L15:
        this.height = Integer.valueOf(r100.i());
        goto L3
    L16:
        this.width = Integer.valueOf(r100.i());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setMarginBottom(Integer r100) {
        this.marginBottom = r100;
    }

    public final void setMarginLeft(Integer r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(Integer r100) {
        this.marginRight = r100;
    }

    public final void setMarginTop(Integer r100) {
        this.marginTop = r100;
    }

    public final void setPaddingBottom(Integer r100) {
        this.paddingBottom = r100;
    }

    public final void setPaddingLeft(Integer r100) {
        this.paddingLeft = r100;
    }

    public final void setPaddingRight(Integer r100) {
        this.paddingRight = r100;
    }

    public final void setPaddingTop(Integer r100) {
        this.paddingTop = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }
}
