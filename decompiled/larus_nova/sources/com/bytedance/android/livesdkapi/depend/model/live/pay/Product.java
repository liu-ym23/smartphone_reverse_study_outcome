package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Product;", "", "()V", "authors", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Author;", "basicInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductBasicInfo;", "combined", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Combined;", "comments", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Comments;", "contentInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ContentInfo;", "itemInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ItemInfo;", "liveInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/LiveInfo;", "paymentArrea", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaymentArea;", "priceInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ProductPriceStruct;", "privilege", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PrivilegeTicket;", "rating", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/Rating;", "shareTicket", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/ShareTicket;", "skuList", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Product implements h {

    @SerializedName("authors")
    public List<Author> authors;

    @SerializedName("basic_info")
    public ProductBasicInfo basicInfo;

    @SerializedName("combined")
    public Combined combined;

    @SerializedName("comments")
    public Comments comments;

    @SerializedName("content_info")
    public ContentInfo contentInfo;

    @SerializedName("item_info")
    public ItemInfo itemInfo;

    @SerializedName("live_info")
    public LiveInfo liveInfo;

    @SerializedName("payment_arrea")
    public PaymentArea paymentArrea;

    @SerializedName(a.KEY_PRICE_INFO)
    public ProductPriceStruct priceInfo;

    @SerializedName("privilege")
    public PrivilegeTicket privilege;

    @SerializedName("rating")
    public Rating rating;

    @SerializedName("share_ticket")
    public ShareTicket shareTicket;

    @SerializedName("sku_list")
    public List<SKU> skuList;

    @SerializedName("user")
    public IBaseUser user;

    public Product() {
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public Product(g r100) {
        this.skuList = new ArrayList();
        this.authors = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L29;
        if (r102 == 17) goto L27;
        if (r102 != 35) goto L10;
        this.user = f.a(r100, IBaseUser.class);
        goto L3
    L10:
        if (r102 != 36) goto L11;
        List r103 = this.authors;
        h r104 = new Author(r100);
    L28:
        r103.add(r104);
        goto L3
    L11:
        switch(r102) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            default: goto L12;
        };
    L19:
        this.paymentArrea = new PaymentArea(r100);
        goto L3
    L20:
        this.contentInfo = new ContentInfo(r100);
        goto L3
    L21:
        this.itemInfo = new ItemInfo(r100);
        goto L3
    L22:
        this.liveInfo = new LiveInfo(r100);
        goto L3
    L23:
        this.priceInfo = new ProductPriceStruct(r100);
        goto L3
    L24:
        this.basicInfo = new ProductBasicInfo(r100);
        goto L3
    L12:
        switch(r102) {
            case 29: goto L18;
            case 30: goto L17;
            case 31: goto L16;
            case 32: goto L15;
            case 33: goto L14;
            default: goto L13;
        };
    L14:
        this.rating = new Rating(r100);
        goto L3
    L15:
        this.comments = new Comments(r100);
        goto L3
    L16:
        this.combined = new Combined(r100);
        goto L3
    L17:
        this.privilege = new PrivilegeTicket(r100);
        goto L3
    L18:
        this.shareTicket = new ShareTicket(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L27:
        r103 = this.skuList;
        r104 = new SKU(r100);
        goto L28
    L29:
        r100.d(r101);
    }
}
