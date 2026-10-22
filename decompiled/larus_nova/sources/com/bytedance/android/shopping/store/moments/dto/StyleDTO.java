package com.bytedance.android.shopping.store.moments.dto;

import com.bytedance.android.ec.hybrid.list.entity.j;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u001a\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u0019\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/StyleDTO;", "Ljava/io/Serializable;", "", "backgroundColor", "Ljava/lang/String;", "getBackgroundColor", "()Ljava/lang/String;", "setBackgroundColor", "(Ljava/lang/String;)V", "backgroundImg", "getBackgroundImg", "setBackgroundImg", "", "marginLeft", "D", "getMarginLeft", "()D", "setMarginLeft", "(D)V", "marginRight", "getMarginRight", "setMarginRight", "marginTop", "getMarginTop", "setMarginTop", "marginBottom", "getMarginBottom", "setMarginBottom", "itemGapH", "getItemGapH", "setItemGapH", "itemGapV", "getItemGapV", "setItemGapV", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StyleDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("background_color")
    private String backgroundColor;

    @SerializedName("background_img")
    private String backgroundImg;

    @SerializedName("item_gap_h")
    private double itemGapH;

    @SerializedName("item_gap_v")
    private double itemGapV;

    @SerializedName("margin_Bottom")
    private double marginBottom;

    @SerializedName("margin_left")
    private double marginLeft;

    @SerializedName("margin_right")
    private double marginRight;

    @SerializedName("margin_top")
    private double marginTop;

    public static final class a {
        public a() {
        }

        public static j a(StyleDTO r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            j r101 = new j();
            r101.f47125i = r100.getBackgroundColor();
            r101.f47124h = r100.getBackgroundImg();
            r101.f47117a = Double.valueOf(r100.getMarginLeft());
            r101.f47119c = Double.valueOf(r100.getMarginTop());
            r101.f47118b = Double.valueOf(r100.getMarginRight());
            r101.f47120d = Double.valueOf(r100.getMarginBottom());
            r101.f47121e = Double.valueOf(r100.getItemGapH());
            r101.f47122f = Double.valueOf(r100.getItemGapV());
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public StyleDTO() {
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBackgroundImg() {
        return this.backgroundImg;
    }

    public final double getItemGapH() {
        return this.itemGapH;
    }

    public final double getItemGapV() {
        return this.itemGapV;
    }

    public final double getMarginBottom() {
        return this.marginBottom;
    }

    public final double getMarginLeft() {
        return this.marginLeft;
    }

    public final double getMarginRight() {
        return this.marginRight;
    }

    public final double getMarginTop() {
        return this.marginTop;
    }

    public final void setBackgroundColor(String r100) {
        this.backgroundColor = r100;
    }

    public final void setBackgroundImg(String r100) {
        this.backgroundImg = r100;
    }

    public final void setItemGapH(double r100) {
        this.itemGapH = r100;
    }

    public final void setItemGapV(double r100) {
        this.itemGapV = r100;
    }

    public final void setMarginBottom(double r100) {
        this.marginBottom = r100;
    }

    public final void setMarginLeft(double r100) {
        this.marginLeft = r100;
    }

    public final void setMarginRight(double r100) {
        this.marginRight = r100;
    }

    public final void setMarginTop(double r100) {
        this.marginTop = r100;
    }
}
