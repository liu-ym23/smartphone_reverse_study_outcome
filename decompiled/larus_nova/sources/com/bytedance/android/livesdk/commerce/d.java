package com.bytedance.android.livesdk.commerce;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/commerce/d;", "", "", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "promotionId", "e", "setPromotionId", "Lcom/bytedance/android/live/base/model/ImageModel;", "cover", "Lcom/bytedance/android/live/base/model/ImageModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/base/model/ImageModel;", "setCover", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "price", "I", "d", "()I", "setPrice", "(I)V", "title", ce.f26391f, com.alipay.sdk.m.x.d.f25925o, SalesInfoStruct.SALES, "f", "setSales", "detailUrl", "b", "setDetailUrl", "mark", "c", "setMark", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class d {

    @SerializedName("cover")
    private ImageModel cover;

    @SerializedName("detail_url")
    private String detailUrl;

    @SerializedName("mark")
    private String mark;

    @SerializedName("price")
    private int price;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("promotion_id")
    private String promotionId;

    @SerializedName(SalesInfoStruct.SALES)
    private int sales;

    @SerializedName("title")
    private String title;

    public d() {
        this.productId = "";
        this.promotionId = "";
        this.title = "";
        this.detailUrl = "";
        this.mark = "";
    }

    public final ImageModel a() {
        return this.cover;
    }

    public final String b() {
        return this.detailUrl;
    }

    public final String c() {
        return this.mark;
    }

    public final int d() {
        return this.price;
    }

    public final String e() {
        return this.promotionId;
    }

    public final int f() {
        return this.sales;
    }

    public final String g() {
        return this.title;
    }
}
