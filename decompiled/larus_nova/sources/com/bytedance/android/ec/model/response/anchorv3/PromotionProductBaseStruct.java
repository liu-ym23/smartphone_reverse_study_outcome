package com.bytedance.android.ec.model.response.anchorv3;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\bH\b\u0086\b\u0018\u0000 \u009d\u00012\u00020\u0001:\u0002\u009e\u0001Bç\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010;\u001a\u00020\u0014\u0012\b\b\u0002\u0010<\u001a\u00020\u0014\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010B\u001a\u00020\u0014\u0012\b\b\u0002\u0010C\u001a\u00020\u0014\u0012\b\b\u0002\u0010D\u001a\u00020\u0014\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010-\u0012\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u000e\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u000b¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0014HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010 \u001a\u00020\u0014HÆ\u0003J\t\u0010!\u001a\u00020\u0014HÆ\u0003J\t\u0010\"\u001a\u00020\u0014HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003J\u0012\u0010*\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b*\u0010\u001cJ\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u000eHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u000101HÆ\u0003J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010\u001eJ\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jî\u0002\u0010S\u001a\u00020\u00002\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010;\u001a\u00020\u00142\b\b\u0002\u0010<\u001a\u00020\u00142\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010B\u001a\u00020\u00142\b\b\u0002\u0010C\u001a\u00020\u00142\b\b\u0002\u0010D\u001a\u00020\u00142\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010-2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u000e2\n\b\u0002\u0010O\u001a\u0004\u0018\u0001012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\bS\u0010TJ\t\u0010U\u001a\u00020\u000bHÖ\u0001J\t\u0010V\u001a\u00020\u0014HÖ\u0001J\u0013\u0010Y\u001a\u00020\u00022\b\u0010X\u001a\u0004\u0018\u00010WHÖ\u0003R$\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u00107\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010Z\u001a\u0004\b_\u0010\\R*\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010Z\u001a\u0004\be\u0010\\\"\u0004\bf\u0010^R$\u0010:\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010;\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010<\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010l\u001a\u0004\bq\u0010n\"\u0004\br\u0010pR\u001c\u0010=\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010s\u001a\u0004\bt\u0010\u0018R\u001c\u0010>\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010Z\u001a\u0004\bu\u0010\\R$\u0010?\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010v\u001a\u0004\bw\u0010\u001c\"\u0004\bx\u0010yR\u001c\u0010@\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010z\u001a\u0004\b{\u0010\u001eR\u001c\u0010A\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010|\u001a\u0004\b}\u0010~R\u001a\u0010B\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010l\u001a\u0004\b\u007f\u0010nR\u001b\u0010C\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\r\n\u0004\bC\u0010l\u001a\u0005\b\u0080\u0001\u0010nR$\u0010D\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bD\u0010l\u001a\u0005\b\u0081\u0001\u0010n\"\u0005\b\u0082\u0001\u0010pR\u001d\u0010E\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bE\u0010|\u001a\u0005\b\u0083\u0001\u0010~R\u001d\u0010F\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bF\u0010Z\u001a\u0005\b\u0084\u0001\u0010\\R\u001d\u0010G\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bG\u0010Z\u001a\u0005\b\u0085\u0001\u0010\\R\u001d\u0010H\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bH\u0010Z\u001a\u0005\b\u0086\u0001\u0010\\R\u001d\u0010I\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bI\u0010Z\u001a\u0005\b\u0087\u0001\u0010\\R\u001f\u0010J\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bJ\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R&\u0010K\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bK\u0010v\u001a\u0005\b\u008b\u0001\u0010\u001c\"\u0005\b\u008c\u0001\u0010yR)\u0010L\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bL\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010M\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bM\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R#\u0010N\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bN\u0010`\u001a\u0005\b\u0095\u0001\u0010bR\u001f\u0010O\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bO\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010z\u001a\u0004\bP\u0010\u001eR\u001d\u0010Q\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bQ\u0010Z\u001a\u0005\b\u0099\u0001\u0010\\R\u001d\u0010R\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bR\u0010Z\u001a\u0005\b\u009a\u0001\u0010\\¨\u0006\u009f\u0001"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBaseStruct;", "Ljava/io/Serializable;", "", "isFindGood", "isComposeGood", "isSoldOut", "isInsuranceProduct", "isGoodAvailable", "isGoodUnAvailable", "isOnSale", "isNotSaleType", "", "component1", "component2", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component3", "component4", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "component5", "", "component6", "component7", "component8", "()Ljava/lang/Integer;", "component9", "", "component10", "()Ljava/lang/Long;", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductTaxStruct;", "component21", "component22", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductImageActivityStruct;", "component23", "Lcom/bytedance/android/ec/model/response/anchorv3/SalesInfoStruct;", "component24", "Lcom/bytedance/android/ec/model/response/anchorv3/SellingPointInfoStruct;", "component25", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductSpecInfoStruct;", "component26", "component27", "component28", "component29", "promotionId", "productId", "images", "title", "price", "status", "soldStatus", "promotionSource", "promotionSourceText", SalesInfoStruct.SALES, "hideSales", "brandIcon", "preSellType", "productKind", "productType", "productIcon", "productIconLink", "bmpSellerType", "bmpVerticalType", "bmpSource", "taxInfo", "saleType", "imageActivity", "salesInfo", "sellingPointInfo", "specInfo", "isHideProduct", "skuId", "shopId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ECUrlModel;IIILcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/ProductTaxStruct;Ljava/lang/Long;Lcom/bytedance/android/ec/model/response/anchorv3/ProductImageActivityStruct;Lcom/bytedance/android/ec/model/response/anchorv3/SalesInfoStruct;Ljava/util/List;Lcom/bytedance/android/ec/model/response/anchorv3/ProductSpecInfoStruct;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductBaseStruct;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "setPromotionId", "(Ljava/lang/String;)V", "getProductId", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "getTitle", com.alipay.sdk.m.x.d.f25925o, "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "getPrice", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;", "setPrice", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;)V", "I", "getStatus", "()I", "setStatus", "(I)V", "getSoldStatus", "setSoldStatus", "Ljava/lang/Integer;", "getPromotionSource", "getPromotionSourceText", "Ljava/lang/Long;", "getSales", "setSales", "(Ljava/lang/Long;)V", "Ljava/lang/Boolean;", "getHideSales", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getBrandIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getPreSellType", "getProductKind", "getProductType", "setProductType", "getProductIcon", "getProductIconLink", "getBmpSellerType", "getBmpVerticalType", "getBmpSource", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductTaxStruct;", "getTaxInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductTaxStruct;", "getSaleType", "setSaleType", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductImageActivityStruct;", "getImageActivity", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductImageActivityStruct;", "setImageActivity", "(Lcom/bytedance/android/ec/model/response/anchorv3/ProductImageActivityStruct;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/SalesInfoStruct;", "getSalesInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/SalesInfoStruct;", "getSellingPointInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductSpecInfoStruct;", "getSpecInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductSpecInfoStruct;", "getSkuId", "getShopId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductPrice;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/ECUrlModel;IIILcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/ProductTaxStruct;Ljava/lang/Long;Lcom/bytedance/android/ec/model/response/anchorv3/ProductImageActivityStruct;Lcom/bytedance/android/ec/model/response/anchorv3/SalesInfoStruct;Ljava/util/List;Lcom/bytedance/android/ec/model/response/anchorv3/ProductSpecInfoStruct;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductBaseStruct implements Serializable {
    public static final long COMPOSE_TYPE = 0;
    public static final a Companion = null;
    public static final long FIND_GOODS_TYPE = 2;
    public static final long NOT_SALE_TYPE = 3;
    public static final int ON_SALE = 2;
    public static final int PRODUCT_KIND_TYPE_1 = 1;
    public static final int PRODUCT_KIND_TYPE_2 = 2;
    public static final long PRODUCT_PACKAGE_SALE = 1;
    public static final int SELL_TYPE_FULL_PRE = 1;
    public static final int SELL_TYPE_PRE_SALE = 2;
    public static final int SELL_TYPE_SPOT = 0;
    public static final int SOLD_STATUS_CAN_SELL = 0;
    public static final int SOLD_STATUS_SOLD_OUT = 1;
    public static final int SOLD_STATUS_UNDER_STOCK = 2;

    @SerializedName("bmp_seller_type")
    private final String bmpSellerType;

    @SerializedName("bmp_source")
    private final String bmpSource;

    @SerializedName("bmp_vertical_market")
    private final String bmpVerticalType;

    @SerializedName("brand_icon")
    private final ECUrlModel brandIcon;

    @SerializedName("is_hide_sales")
    private final Boolean hideSales;

    @SerializedName("image_activity")
    private ProductImageActivityStruct imageActivity;

    @SerializedName("images")
    private List<? extends ECUrlModel> images;

    @SerializedName("is_hide_product")
    private final Boolean isHideProduct;

    @SerializedName("presell_type")
    private final int preSellType;

    @SerializedName("price")
    private PromotionProductPrice price;

    @SerializedName("product_icon")
    private final ECUrlModel productIcon;

    @SerializedName("product_icon_link")
    private final String productIconLink;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("biz_kind")
    private final int productKind;

    @SerializedName("product_type")
    private int productType;

    @SerializedName("promotion_id")
    private String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final Integer promotionSource;

    @SerializedName("promotion_source_text")
    private final String promotionSourceText;

    @SerializedName("sale_type")
    private Long saleType;

    @SerializedName(SalesInfoStruct.SALES)
    private Long sales;

    @SerializedName("sales_info")
    private final SalesInfoStruct salesInfo;

    @SerializedName("selling_point_info")
    private final List<SellingPointInfoStruct> sellingPointInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName("sold_status")
    private int soldStatus;

    @SerializedName("spec_info")
    private final ProductSpecInfoStruct specInfo;

    @SerializedName("status")
    private int status;

    @SerializedName("tax_info")
    private final ProductTaxStruct taxInfo;

    @SerializedName("title")
    private String title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductBaseStruct() {
        this(null, null, null, null, null, 0, 0, null, null, null, null, null, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionProductBaseStruct copy$default(PromotionProductBaseStruct r110, String r111, String r112, List r210, String r211, PromotionProductPrice r212, int r213, int r214, Integer r215, String r216, Long r217, Boolean r218, ECUrlModel r219, int r310, int r311, int r312, ECUrlModel r313, String r314, String r315, String r316, String r317, ProductTaxStruct r318, Long r319, ProductImageActivityStruct r410, SalesInfoStruct r411, List r412, ProductSpecInfoStruct r413, Boolean r414, String r415, String r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        String r100 = r110.promotionId;
    L7:
        if ((r417 & 2) == 0) goto L9;
        String r101 = r110.productId;
    L11:
        if ((r417 & 4) == 0) goto L13;
        List r102 = r110.images;
    L15:
        if ((r417 & 8) == 0) goto L17;
        String r103 = r110.title;
    L19:
        if ((r417 & 16) == 0) goto L21;
        PromotionProductPrice r104 = r110.price;
    L23:
        if ((r417 & 32) == 0) goto L25;
        int r105 = r110.status;
    L27:
        if ((r417 & 64) == 0) goto L29;
        int r106 = r110.soldStatus;
    L31:
        if ((r417 & 128) == 0) goto L33;
        Integer r107 = r110.promotionSource;
    L35:
        if ((r417 & 256) == 0) goto L37;
        String r113 = r110.promotionSourceText;
    L39:
        if ((r417 & 512) == 0) goto L41;
        Long r114 = r110.sales;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        Boolean r115 = r110.hideSales;
    L47:
        if ((r417 & 2048) == 0) goto L49;
        ECUrlModel r116 = r110.brandIcon;
    L51:
        if ((r417 & 4096) == 0) goto L53;
        int r117 = r110.preSellType;
    L55:
        if ((r417 & 8192) == 0) goto L57;
        int r118 = r110.productKind;
    L58:
        int r320 = r118;
        if ((r417 & 16384) == 0) goto L61;
        int r119 = r110.productType;
    L62:
        int r321 = r119;
        if ((r417 & 32768) == 0) goto L65;
        ECUrlModel r120 = r110.productIcon;
    L66:
        ECUrlModel r322 = r120;
        if ((r417 & 65536) == 0) goto L69;
        String r121 = r110.productIconLink;
    L70:
        String r323 = r121;
        if ((r417 & 131072) == 0) goto L73;
        String r122 = r110.bmpSellerType;
    L74:
        String r324 = r122;
        if ((r417 & 262144) == 0) goto L77;
        String r123 = r110.bmpVerticalType;
    L78:
        String r325 = r123;
        if ((r417 & 524288) == 0) goto L81;
        String r124 = r110.bmpSource;
    L82:
        String r326 = r124;
        if ((r417 & 1048576) == 0) goto L85;
        ProductTaxStruct r125 = r110.taxInfo;
    L86:
        ProductTaxStruct r327 = r125;
        if ((r417 & 2097152) == 0) goto L89;
        Long r126 = r110.saleType;
    L90:
        Long r328 = r126;
        if ((r417 & 4194304) == 0) goto L93;
        ProductImageActivityStruct r127 = r110.imageActivity;
    L94:
        ProductImageActivityStruct r419 = r127;
        if ((r417 & 8388608) == 0) goto L97;
        SalesInfoStruct r128 = r110.salesInfo;
    L98:
        SalesInfoStruct r420 = r128;
        if ((r417 & 16777216) == 0) goto L101;
        List r129 = r110.sellingPointInfo;
    L102:
        List r421 = r129;
        if ((r417 & 33554432) == 0) goto L105;
        ProductSpecInfoStruct r130 = r110.specInfo;
    L106:
        ProductSpecInfoStruct r422 = r130;
        if ((r417 & 67108864) == 0) goto L109;
        Boolean r131 = r110.isHideProduct;
    L110:
        Boolean r423 = r131;
        if ((r417 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r132 = r110.skuId;
    L115:
        if ((r417 & 268435456) == 0) goto L117;
        String r108 = r110.shopId;
    L119:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r419, r420, r421, r422, r423, r132, r108);
    L117:
        r108 = r416;
        goto L119
    L113:
        r132 = r415;
        goto L115
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.promotionId;
    }

    public final Long component10() {
        return this.sales;
    }

    public final Boolean component11() {
        return this.hideSales;
    }

    public final ECUrlModel component12() {
        return this.brandIcon;
    }

    public final int component13() {
        return this.preSellType;
    }

    public final int component14() {
        return this.productKind;
    }

    public final int component15() {
        return this.productType;
    }

    public final ECUrlModel component16() {
        return this.productIcon;
    }

    public final String component17() {
        return this.productIconLink;
    }

    public final String component18() {
        return this.bmpSellerType;
    }

    public final String component19() {
        return this.bmpVerticalType;
    }

    public final String component2() {
        return this.productId;
    }

    public final String component20() {
        return this.bmpSource;
    }

    public final ProductTaxStruct component21() {
        return this.taxInfo;
    }

    public final Long component22() {
        return this.saleType;
    }

    public final ProductImageActivityStruct component23() {
        return this.imageActivity;
    }

    public final SalesInfoStruct component24() {
        return this.salesInfo;
    }

    public final List<SellingPointInfoStruct> component25() {
        return this.sellingPointInfo;
    }

    public final ProductSpecInfoStruct component26() {
        return this.specInfo;
    }

    public final Boolean component27() {
        return this.isHideProduct;
    }

    public final String component28() {
        return this.skuId;
    }

    public final String component29() {
        return this.shopId;
    }

    public final List<ECUrlModel> component3() {
        return this.images;
    }

    public final String component4() {
        return this.title;
    }

    public final PromotionProductPrice component5() {
        return this.price;
    }

    public final int component6() {
        return this.status;
    }

    public final int component7() {
        return this.soldStatus;
    }

    public final Integer component8() {
        return this.promotionSource;
    }

    public final String component9() {
        return this.promotionSourceText;
    }

    public final PromotionProductBaseStruct copy(String r310, String r311, List<? extends ECUrlModel> r312, String r313, PromotionProductPrice r314, int r315, int r316, Integer r317, String r410, Long r411, Boolean r412, ECUrlModel r413, int r414, int r415, int r416, ECUrlModel r417, String r418, String r419, String r510, String r511, ProductTaxStruct r512, Long r513, ProductImageActivityStruct r514, SalesInfoStruct r515, List<SellingPointInfoStruct> r516, ProductSpecInfoStruct r517, Boolean r518, String r519, String r610) {
        return new PromotionProductBaseStruct(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductBaseStruct) == false) goto L64;
        PromotionProductBaseStruct r101 = (PromotionProductBaseStruct) r100;
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L16;
        return false;
    L16:
        if (this.status == r101.status) goto L18;
        return false;
    L18:
        if (this.soldStatus == r101.soldStatus) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.promotionSource, r101.promotionSource) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.promotionSourceText, r101.promotionSourceText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sales, r101.sales) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.hideSales, r101.hideSales) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.brandIcon, r101.brandIcon) == true) goto L30;
        return false;
    L30:
        if (this.preSellType == r101.preSellType) goto L32;
        return false;
    L32:
        if (this.productKind == r101.productKind) goto L34;
        return false;
    L34:
        if (this.productType == r101.productType) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.productIcon, r101.productIcon) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.productIconLink, r101.productIconLink) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.bmpSellerType, r101.bmpSellerType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.bmpVerticalType, r101.bmpVerticalType) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.bmpSource, r101.bmpSource) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.taxInfo, r101.taxInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.saleType, r101.saleType) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.imageActivity, r101.imageActivity) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.salesInfo, r101.salesInfo) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sellingPointInfo, r101.sellingPointInfo) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.specInfo, r101.specInfo) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.isHideProduct, r101.isHideProduct) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    public int hashCode() {
        String r100 = this.promotionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<? extends ECUrlModel> r107 = this.images;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        PromotionProductPrice r113 = this.price;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((((r112 + r114) * 31) + this.status) * 31) + this.soldStatus) * 31;
        Integer r116 = this.promotionSource;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.promotionSourceText;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Long r122 = this.sales;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.hideSales;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ECUrlModel r128 = this.brandIcon;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (((((((r127 + r129) * 31) + this.preSellType) * 31) + this.productKind) * 31) + this.productType) * 31;
        ECUrlModel r131 = this.productIcon;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.productIconLink;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.bmpSellerType;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.bmpVerticalType;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.bmpSource;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        ProductTaxStruct r146 = this.taxInfo;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Long r149 = this.saleType;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        ProductImageActivityStruct r152 = this.imageActivity;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        SalesInfoStruct r155 = this.salesInfo;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        List<SellingPointInfoStruct> r158 = this.sellingPointInfo;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        ProductSpecInfoStruct r161 = this.specInfo;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Boolean r164 = this.isHideProduct;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.skuId;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.shopId;
        if (r170 == null) goto L98;
        r101 = r170.hashCode();
    L98:
        return r169 + r101;
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionProductBaseStruct(promotionId=" + this.promotionId + ", productId=" + this.productId + ", images=" + this.images + ", title=" + this.title + ", price=" + this.price + ", status=" + this.status + ", soldStatus=" + this.soldStatus + ", promotionSource=" + this.promotionSource + ", promotionSourceText=" + this.promotionSourceText + ", sales=" + this.sales + ", hideSales=" + this.hideSales + ", brandIcon=" + this.brandIcon + ", preSellType=" + this.preSellType + ", productKind=" + this.productKind + ", productType=" + this.productType + ", productIcon=" + this.productIcon + ", productIconLink=" + this.productIconLink + ", bmpSellerType=" + this.bmpSellerType + ", bmpVerticalType=" + this.bmpVerticalType + ", bmpSource=" + this.bmpSource + ", taxInfo=" + this.taxInfo + ", saleType=" + this.saleType + ", imageActivity=" + this.imageActivity + ", salesInfo=" + this.salesInfo + ", sellingPointInfo=" + this.sellingPointInfo + ", specInfo=" + this.specInfo + ", isHideProduct=" + this.isHideProduct + ", skuId=" + this.skuId + ", shopId=" + this.shopId + ")";
    }

    public final boolean isComposeGood() {
        Long r100 = this.saleType;
        if (r100 == null) goto L9;
        if (r100 == null) goto L9;
        if (r100.longValue() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isFindGood() {
        Long r100 = this.saleType;
        if (r100 == null) goto L9;
        if (r100 == null) goto L9;
        if (r100.longValue() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isInsuranceProduct() {
        if (Intrinsics.areEqual(this.bmpSellerType, "xiaodian") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.bmpVerticalType, "insurance") == false) goto L7;
        return true;
    }

    public final boolean isNotSaleType() {
        Long r100 = this.saleType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.longValue() != 3) goto L8;
        return true;
    }

    public final boolean isOnSale() {
        if (this.status != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSoldOut() {
        if (this.soldStatus == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isGoodAvailable() {
        if (isSoldOut() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.status != 2) goto L7;
        return true;
    }

    public final boolean isGoodUnAvailable() {
        return !isGoodAvailable();
    }

    public final String getBmpSellerType() {
        return this.bmpSellerType;
    }

    public final String getBmpSource() {
        return this.bmpSource;
    }

    public final String getBmpVerticalType() {
        return this.bmpVerticalType;
    }

    public final ECUrlModel getBrandIcon() {
        return this.brandIcon;
    }

    public final Boolean getHideSales() {
        return this.hideSales;
    }

    public final ProductImageActivityStruct getImageActivity() {
        return this.imageActivity;
    }

    public final List<ECUrlModel> getImages() {
        return this.images;
    }

    public final int getPreSellType() {
        return this.preSellType;
    }

    public final PromotionProductPrice getPrice() {
        return this.price;
    }

    public final ECUrlModel getProductIcon() {
        return this.productIcon;
    }

    public final String getProductIconLink() {
        return this.productIconLink;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final int getProductKind() {
        return this.productKind;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final Integer getPromotionSource() {
        return this.promotionSource;
    }

    public final String getPromotionSourceText() {
        return this.promotionSourceText;
    }

    public final Long getSaleType() {
        return this.saleType;
    }

    public final Long getSales() {
        return this.sales;
    }

    public final SalesInfoStruct getSalesInfo() {
        return this.salesInfo;
    }

    public final List<SellingPointInfoStruct> getSellingPointInfo() {
        return this.sellingPointInfo;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final int getSoldStatus() {
        return this.soldStatus;
    }

    public final ProductSpecInfoStruct getSpecInfo() {
        return this.specInfo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final ProductTaxStruct getTaxInfo() {
        return this.taxInfo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isHideProduct() {
        return this.isHideProduct;
    }

    public final void setImageActivity(ProductImageActivityStruct r100) {
        this.imageActivity = r100;
    }

    public final void setImages(List<? extends ECUrlModel> r100) {
        this.images = r100;
    }

    public final void setPrice(PromotionProductPrice r100) {
        this.price = r100;
    }

    public final void setProductType(int r100) {
        this.productType = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setSaleType(Long r100) {
        this.saleType = r100;
    }

    public final void setSales(Long r100) {
        this.sales = r100;
    }

    public final void setSoldStatus(int r100) {
        this.soldStatus = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public PromotionProductBaseStruct(String r100, String r101, List<? extends ECUrlModel> r102, String r103, PromotionProductPrice r104, int r105, int r106, Integer r110, String r111, Long r112, Boolean r113, ECUrlModel r114, int r115, int r116, int r117, ECUrlModel r118, String r119, String r210, String r211, String r212, ProductTaxStruct r213, Long r214, ProductImageActivityStruct r215, SalesInfoStruct r216, List<SellingPointInfoStruct> r217, ProductSpecInfoStruct r218, Boolean r219, String r310, String r311) {
        this.promotionId = r100;
        this.productId = r101;
        this.images = r102;
        this.title = r103;
        this.price = r104;
        this.status = r105;
        this.soldStatus = r106;
        this.promotionSource = r110;
        this.promotionSourceText = r111;
        this.sales = r112;
        this.hideSales = r113;
        this.brandIcon = r114;
        this.preSellType = r115;
        this.productKind = r116;
        this.productType = r117;
        this.productIcon = r118;
        this.productIconLink = r119;
        this.bmpSellerType = r210;
        this.bmpVerticalType = r211;
        this.bmpSource = r212;
        this.taxInfo = r213;
        this.saleType = r214;
        this.imageActivity = r215;
        this.salesInfo = r216;
        this.sellingPointInfo = r217;
        this.specInfo = r218;
        this.isHideProduct = r219;
        this.skuId = r310;
        this.shopId = r311;
    }

    public /* synthetic */ PromotionProductBaseStruct(String r310, String r311, List r312, String r313, PromotionProductPrice r314, int r315, int r316, Integer r317, String r318, Long r410, Boolean r411, ECUrlModel r412, int r413, int r414, int r415, ECUrlModel r416, String r417, String r418, String r419, String r510, ProductTaxStruct r511, Long r512, ProductImageActivityStruct r513, SalesInfoStruct r514, List r515, ProductSpecInfoStruct r516, Boolean r517, String r518, String r519, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r610 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r610 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        PromotionProductPrice r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        int r105 = 2;
    L27:
        if ((r610 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r610 & 128) == 0) goto L33;
        Integer r110 = null;
    L35:
        if ((r610 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        Long r112 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        Boolean r113 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        ECUrlModel r114 = null;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        int r115 = -1;
    L55:
        if ((r610 & 8192) == 0) goto L57;
        int r107 = 0;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        int r108 = 0;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        ECUrlModel r116 = null;
    L67:
        if ((r610 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r610 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r610 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        String r210 = null;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        ProductTaxStruct r211 = null;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        Long r212 = null;
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        ProductImageActivityStruct r213 = null;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        SalesInfoStruct r214 = null;
    L99:
        if ((r610 & 16777216) == 0) goto L101;
        List r215 = null;
    L103:
        if ((r610 & 33554432) == 0) goto L105;
        ProductSpecInfoStruct r216 = null;
    L107:
        if ((r610 & 67108864) == 0) goto L109;
        Boolean r217 = null;
    L111:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r218 = null;
    L115:
        if ((r610 & 268435456) == 0) goto L117;
        String r109 = null;
    L118:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r109);
        return;
    L117:
        r109 = r519;
        goto L118
    L113:
        r218 = r518;
        goto L115
    L109:
        r217 = r517;
        goto L111
    L105:
        r216 = r516;
        goto L107
    L101:
        r215 = r515;
        goto L103
    L97:
        r214 = r514;
        goto L99
    L93:
        r213 = r513;
        goto L95
    L89:
        r212 = r512;
        goto L91
    L85:
        r211 = r511;
        goto L87
    L81:
        r210 = r510;
        goto L83
    L77:
        r119 = r419;
        goto L79
    L73:
        r118 = r418;
        goto L75
    L69:
        r117 = r417;
        goto L71
    L65:
        r116 = r416;
        goto L67
    L61:
        r108 = r415;
        goto L63
    L57:
        r107 = r414;
        goto L59
    L53:
        r115 = r413;
        goto L55
    L49:
        r114 = r412;
        goto L51
    L45:
        r113 = r411;
        goto L47
    L41:
        r112 = r410;
        goto L43
    L37:
        r111 = r318;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
