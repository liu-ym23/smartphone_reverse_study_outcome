package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0003+,-B\u0007¢\u0006\u0004\b)\u0010*R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0007R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0007R\u0016\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\nR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0016\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU;", "", "", "id", "Ljava/lang/String;", "", "category", "I", "", "price", "J", "saleStartTime", "saleEndTime", "refundable", "coverUri", "Lpy/k;", "cover", "Lpy/k;", "introduction", "title", "saleStatus", "productId", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$RelatedSkuSimpleInfo;", "relatedSkuSimpleInfos", "Ljava/util/List;", "orderItemType", "orderBizExtInfo", "limitCount", "purchaseStatus", "", "canPurchase", "Z", "episode", "introductionText", "priceType", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$CaremaInfo;", "cameraInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$CaremaInfo;", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$EntityIDsMap;", "entityIdsMap", "<init>", "()V", "CaremaInfo", "EntityIDsMap", "RelatedSkuSimpleInfo", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SKU implements h {

    @SerializedName("camera_info")
    public CaremaInfo cameraInfo;

    @SerializedName("can_purchase")
    public boolean canPurchase;

    @SerializedName("category")
    public int category;

    @SerializedName("cover")
    public k cover;

    @SerializedName("cover_uri")
    public String coverUri;

    @SerializedName("entity_ids_map")
    public List<EntityIDsMap> entityIdsMap;

    @SerializedName("episode")
    public long episode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public String f162626id;

    @SerializedName("introduction")
    public String introduction;

    @SerializedName("introduction_text")
    public String introductionText;

    @SerializedName("limit_count")
    public int limitCount;

    @SerializedName("order_biz_ext_info")
    public String orderBizExtInfo;

    @SerializedName("order_item_type")
    public int orderItemType;

    @SerializedName("price")
    public long price;

    @SerializedName(a.KEY_PRICE_TYPE)
    public int priceType;

    @SerializedName("product_id")
    public String productId;

    @SerializedName("purchase_status")
    public int purchaseStatus;

    @SerializedName("refundable")
    public int refundable;

    @SerializedName("related_sku_simple_infos")
    public List<RelatedSkuSimpleInfo> relatedSkuSimpleInfos;

    @SerializedName("sale_end_time")
    public long saleEndTime;

    @SerializedName("sale_start_time")
    public long saleStartTime;

    @SerializedName("sale_status")
    public int saleStatus;

    @SerializedName("title")
    public String title;

    @ForMain
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$CaremaInfo;", "", "()V", ShortVideoSegments.KEY_CAMERA_ID, "", "cameraIdStr", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CaremaInfo implements h {

        @SerializedName(VSConstants.VS_CAMERA_ID)
        public long cameraId;

        @SerializedName("camera_id_str")
        public String cameraIdStr;

        public CaremaInfo() {
        }

        public CaremaInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.cameraId = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.cameraIdStr = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @ForMain
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$EntityIDsMap;", "", "()V", "entitytype", "", "releatedEntityIds", "", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EntityIDsMap implements h {

        @SerializedName("entityType")
        public int entitytype;

        @SerializedName("releated_entity_ids")
        public List<Long> releatedEntityIds;

        public EntityIDsMap() {
        }

        public EntityIDsMap(g r100) {
            this.releatedEntityIds = new ArrayList();
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.entitytype = r100.i();
            goto L3
        L8:
            if (r102 != 23) goto L9;
            this.releatedEntityIds.add(Long.valueOf(r100.j()));
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    @ForMain
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/SKU$RelatedSkuSimpleInfo;", "", "()V", "productId", "", "skuId", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RelatedSkuSimpleInfo implements h {

        @SerializedName("product_id")
        public String productId;

        @SerializedName(a.KEY_SKU_ID)
        public String skuId;

        public RelatedSkuSimpleInfo() {
        }

        public RelatedSkuSimpleInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.skuId = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.productId = am3.h.c(r100);
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }
    }

    public SKU() {
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public SKU(g r100) {
        this.relatedSkuSimpleInfos = new ArrayList();
        this.entityIdsMap = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L31;
        switch(r102) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            case 23: goto L7;
            default: goto L6;
        };
    L7:
        List r103 = this.entityIdsMap;
        h r104 = new EntityIDsMap(r100);
    L18:
        r103.add(r104);
        goto L3
    L8:
        this.cameraInfo = new CaremaInfo(r100);
        goto L3
    L9:
        this.priceType = r100.i();
        goto L3
    L10:
        this.introductionText = am3.h.c(r100);
        goto L3
    L11:
        this.episode = r100.j();
        goto L3
    L12:
        this.canPurchase = am3.h.a(r100);
        goto L3
    L13:
        this.purchaseStatus = r100.i();
        goto L3
    L14:
        this.limitCount = r100.i();
        goto L3
    L15:
        this.orderBizExtInfo = am3.h.c(r100);
        goto L3
    L16:
        this.orderItemType = r100.i();
        goto L3
    L17:
        r103 = this.relatedSkuSimpleInfos;
        r104 = new RelatedSkuSimpleInfo(r100);
        goto L18
    L19:
        this.productId = am3.h.c(r100);
        goto L3
    L20:
        this.saleStatus = r100.i();
        goto L3
    L21:
        this.title = am3.h.c(r100);
        goto L3
    L22:
        this.introduction = am3.h.c(r100);
        goto L3
    L23:
        this.cover = f.a(r100, k.class);
        goto L3
    L24:
        this.coverUri = am3.h.c(r100);
        goto L3
    L25:
        this.refundable = r100.i();
        goto L3
    L26:
        this.saleEndTime = r100.j();
        goto L3
    L27:
        this.saleStartTime = r100.j();
        goto L3
    L28:
        this.price = r100.j();
        goto L3
    L29:
        this.category = r100.i();
        goto L3
    L30:
        this.f162626id = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L31:
        r100.d(r101);
    }
}
