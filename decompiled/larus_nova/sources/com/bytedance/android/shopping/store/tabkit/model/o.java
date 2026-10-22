package com.bytedance.android.shopping.store.tabkit.model;

import androidx.core.provider.FontsContractCompat;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/o;", "", "", "fontSize", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "f", "(Ljava/lang/Integer;)V", "fontWeight", "b", ce.f26391f, "", "titleColor", "Ljava/lang/String;", "e", "()Ljava/lang/String;", ce.f26395j, "(Ljava/lang/String;)V", "imageWidth", "d", RXScreenCaptureService.KEY_INDEX, "imageHeight", "c", "h", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("font_size")
    private Integer fontSize;

    @SerializedName(FontsContractCompat.Columns.WEIGHT)
    private Integer fontWeight;

    @SerializedName("image_height")
    private Integer imageHeight;

    @SerializedName("image_width")
    private Integer imageWidth;

    @SerializedName("title_color")
    private String titleColor;

    public o() {
    }

    public final Integer a() {
        return this.fontSize;
    }

    public final Integer b() {
        return this.fontWeight;
    }

    public final Integer c() {
        return this.imageHeight;
    }

    public final Integer d() {
        return this.imageWidth;
    }

    public final String e() {
        return this.titleColor;
    }

    public final void f(Integer r100) {
        this.fontSize = r100;
    }

    public final void g(Integer r100) {
        this.fontWeight = r100;
    }

    public final void h(Integer r100) {
        this.imageHeight = r100;
    }

    public final void i(Integer r100) {
        this.imageWidth = r100;
    }

    public final void j(String r100) {
        this.titleColor = r100;
    }
}
