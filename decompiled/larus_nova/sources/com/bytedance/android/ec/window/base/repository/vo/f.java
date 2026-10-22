package com.bytedance.android.ec.window.base.repository.vo;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/f;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "Lcom/bytedance/android/ec/window/base/repository/vo/h;", "text", "Lcom/bytedance/android/ec/window/base/repository/vo/h;", ce.f26391f, "()Lcom/bytedance/android/ec/window/base/repository/vo/h;", "setText", "(Lcom/bytedance/android/ec/window/base/repository/vo/h;)V", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "specialImage", "f", "setSpecialImage", "Lcom/bytedance/android/ec/window/base/repository/vo/a;", "dividerLine", "Lcom/bytedance/android/ec/window/base/repository/vo/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/window/base/repository/vo/a;", "setDividerLine", "(Lcom/bytedance/android/ec/window/base/repository/vo/a;)V", "", "marginLeft", "D", "c", "()D", "setMarginLeft", "(D)V", "marginRight", "d", "setMarginRight", "Lcom/bytedance/android/ec/window/base/repository/vo/g;", GXTemplateKey.FLEXBOX_PADDING, "Lcom/bytedance/android/ec/window/base/repository/vo/g;", "e", "()Lcom/bytedance/android/ec/window/base/repository/vo/g;", "setPadding", "(Lcom/bytedance/android/ec/window/base/repository/vo/g;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("divider_line")
    private a dividerLine;

    @SerializedName("image")
    private ECUrlModel image;

    @SerializedName("margin_left")
    private double marginLeft;

    @SerializedName("margin_right")
    private double marginRight;

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private g padding;

    @SerializedName("special_image")
    private ECUrlModel specialImage;

    @SerializedName("text")
    private h text;

    @SerializedName("type")
    private int type;

    public final void h() {
        this.text.getClass();
    }

    public f() {
        this.type = WindowSubTagType.TEXT.getType();
        this.text = new h();
        this.dividerLine = new a();
    }

    public final a a() {
        return this.dividerLine;
    }

    public final ECUrlModel b() {
        return this.image;
    }

    public final double c() {
        return this.marginLeft;
    }

    public final double d() {
        return this.marginRight;
    }

    public final g e() {
        return this.padding;
    }

    public final ECUrlModel f() {
        return this.specialImage;
    }

    public final h g() {
        return this.text;
    }

    public final int getType() {
        return this.type;
    }
}
