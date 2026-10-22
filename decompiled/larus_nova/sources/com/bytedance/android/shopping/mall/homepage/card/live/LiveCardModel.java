package com.bytedance.android.shopping.mall.homepage.card.live;

import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$MaskStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001:\u0004/012Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel;", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "live", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;", "experiment", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "showAdTag", "", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "showJustNowUI", "windVane", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "elementStyle", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "ttExperiment", "Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;)V", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getElementStyle", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "getExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/live/LiveCardData$FavoriteItemStyle;", "getLive", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "getShowAdTag", "()Z", "getShowJustNowUI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTtExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "getWindVane", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "ElementStyle", "Experiment", "Live", "TTExperiment", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCardModel {
    private final CommonData.CoinData coinData;
    private final ElementStyle elementStyle;
    private final Experiment experiment;
    private final LiveCardData.FavoriteItemStyle itemStyle;
    private final Live live;
    private final CommonModel$Product product;
    private final boolean showAdTag;
    private final Boolean showJustNowUI;
    private final TTExperiment ttExperiment;
    private final CommonModel$User user;
    private final CommonData.WindVaneEventData windVane;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\bK\b\u0087\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\u0015¢\u0006\u0002\u0010&J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0010HÆ\u0003J\t\u0010R\u001a\u00020\u0012HÆ\u0003J\t\u0010S\u001a\u00020\u0012HÆ\u0003J\t\u0010T\u001a\u00020\u0015HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010V\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u00106J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0012HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u00101J\t\u0010a\u001a\u00020\u0015HÆ\u0003J\t\u0010b\u001a\u00020\u0006HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0006HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J¤\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u0015HÆ\u0001¢\u0006\u0002\u0010jJ\u0013\u0010k\u001a\u00020\u00152\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020$HÖ\u0001J\t\u0010n\u001a\u00020\"HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010(R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010(R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010(R\u0011\u0010\u001e\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bI\u0010=R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010(R\u0011\u0010%\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\bK\u00104R\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bL\u0010=R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u0010+¨\u0006o"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "", "infoLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "avatarLayout", "userTextStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "logoLayout", "logoTextLayout", "logoTextStyle", "hotLayout", "hotTextStyle", "arriveTimeIconLayout", "arriveTimeTextStyle", "arriveTimeTextLayout", "maskStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "hotIconStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "rootStyle", "darkModeEnable", "", "height", "", "feedCardRatio", "", "redPacketLayout", "coinLayout", "coinStyle", "coinIconLayout", "playerMaskStyle", "playerLayout", "feedbackLayout", "leftTopAnimUrl", "", "colorfulCardStyle", "", "removeShadow", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getArriveTimeIconLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getArriveTimeTextLayout", "getArriveTimeTextStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getAvatarLayout", "getCoinIconLayout", "getCoinLayout", "getCoinStyle", "getColorfulCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDarkModeEnable", "()Z", "getFeedCardRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFeedbackLayout", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHotIconStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "getHotLayout", "getHotTextStyle", "getInfoLayout", "getLeftTopAnimUrl", "()Ljava/lang/String;", "getLogoLayout", "getLogoTextLayout", "getLogoTextStyle", "getMaskStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "getPlayerLayout", "getPlayerMaskStyle", "getRedPacketLayout", "getRemoveShadow", "getRootStyle", "getUserTextStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$ElementStyle;", "equals", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementStyle {
        private final CommonModel$LayoutStyle arriveTimeIconLayout;
        private final CommonModel$LayoutStyle arriveTimeTextLayout;
        private final CommonModel$CusTextStyle arriveTimeTextStyle;
        private final CommonModel$LayoutStyle avatarLayout;
        private final CommonModel$LayoutStyle coinIconLayout;
        private final CommonModel$LayoutStyle coinLayout;
        private final CommonModel$CusTextStyle coinStyle;
        private final Integer colorfulCardStyle;
        private final boolean darkModeEnable;
        private final Float feedCardRatio;
        private final CommonModel$LayoutStyle feedbackLayout;
        private final Double height;
        private final CommonModel$CommonColorStyle hotIconStyle;
        private final CommonModel$LayoutStyle hotLayout;
        private final CommonModel$CusTextStyle hotTextStyle;
        private final CommonModel$LayoutStyle infoLayout;
        private final String leftTopAnimUrl;
        private final CommonModel$LayoutStyle logoLayout;
        private final CommonModel$LayoutStyle logoTextLayout;
        private final CommonModel$CusTextStyle logoTextStyle;
        private final CommonModel$MaskStyle maskStyle;
        private final CommonModel$LayoutStyle playerLayout;
        private final CommonModel$CommonColorStyle playerMaskStyle;
        private final CommonModel$LayoutStyle redPacketLayout;
        private final boolean removeShadow;
        private final CommonModel$CommonColorStyle rootStyle;
        private final CommonModel$CusTextStyle userTextStyle;

        public static /* synthetic */ ElementStyle copy$default(ElementStyle r110, CommonModel$LayoutStyle r111, CommonModel$LayoutStyle r112, CommonModel$CusTextStyle r210, CommonModel$LayoutStyle r211, CommonModel$LayoutStyle r212, CommonModel$CusTextStyle r213, CommonModel$LayoutStyle r214, CommonModel$CusTextStyle r215, CommonModel$LayoutStyle r216, CommonModel$CusTextStyle r217, CommonModel$LayoutStyle r218, CommonModel$MaskStyle r219, CommonModel$CommonColorStyle r310, CommonModel$CommonColorStyle r311, boolean r312, Double r313, Float r314, CommonModel$LayoutStyle r315, CommonModel$LayoutStyle r316, CommonModel$CusTextStyle r317, CommonModel$LayoutStyle r318, CommonModel$CommonColorStyle r319, CommonModel$LayoutStyle r410, CommonModel$LayoutStyle r411, String r412, Integer r413, boolean r414, int r415, Object r416) {
            if ((r415 & 1) == 0) goto L5;
            CommonModel$LayoutStyle r100 = r110.infoLayout;
        L7:
            if ((r415 & 2) == 0) goto L9;
            CommonModel$LayoutStyle r101 = r110.avatarLayout;
        L11:
            if ((r415 & 4) == 0) goto L13;
            CommonModel$CusTextStyle r102 = r110.userTextStyle;
        L15:
            if ((r415 & 8) == 0) goto L17;
            CommonModel$LayoutStyle r103 = r110.logoLayout;
        L19:
            if ((r415 & 16) == 0) goto L21;
            CommonModel$LayoutStyle r104 = r110.logoTextLayout;
        L23:
            if ((r415 & 32) == 0) goto L25;
            CommonModel$CusTextStyle r105 = r110.logoTextStyle;
        L27:
            if ((r415 & 64) == 0) goto L29;
            CommonModel$LayoutStyle r106 = r110.hotLayout;
        L31:
            if ((r415 & 128) == 0) goto L33;
            CommonModel$CusTextStyle r107 = r110.hotTextStyle;
        L35:
            if ((r415 & 256) == 0) goto L37;
            CommonModel$LayoutStyle r113 = r110.arriveTimeIconLayout;
        L39:
            if ((r415 & 512) == 0) goto L41;
            CommonModel$CusTextStyle r114 = r110.arriveTimeTextStyle;
        L43:
            if ((r415 & 1024) == 0) goto L45;
            CommonModel$LayoutStyle r115 = r110.arriveTimeTextLayout;
        L47:
            if ((r415 & 2048) == 0) goto L49;
            CommonModel$MaskStyle r116 = r110.maskStyle;
        L51:
            if ((r415 & 4096) == 0) goto L53;
            CommonModel$CommonColorStyle r117 = r110.hotIconStyle;
        L55:
            if ((r415 & 8192) == 0) goto L57;
            CommonModel$CommonColorStyle r118 = r110.rootStyle;
        L58:
            CommonModel$CommonColorStyle r320 = r118;
            if ((r415 & 16384) == 0) goto L61;
            boolean r119 = r110.darkModeEnable;
        L62:
            boolean r321 = r119;
            if ((r415 & 32768) == 0) goto L65;
            Double r120 = r110.height;
        L66:
            Double r322 = r120;
            if ((r415 & 65536) == 0) goto L69;
            Float r121 = r110.feedCardRatio;
        L70:
            Float r323 = r121;
            if ((r415 & 131072) == 0) goto L73;
            CommonModel$LayoutStyle r122 = r110.redPacketLayout;
        L74:
            CommonModel$LayoutStyle r324 = r122;
            if ((r415 & 262144) == 0) goto L77;
            CommonModel$LayoutStyle r123 = r110.coinLayout;
        L78:
            CommonModel$LayoutStyle r325 = r123;
            if ((r415 & 524288) == 0) goto L81;
            CommonModel$CusTextStyle r124 = r110.coinStyle;
        L82:
            CommonModel$CusTextStyle r326 = r124;
            if ((r415 & 1048576) == 0) goto L85;
            CommonModel$LayoutStyle r125 = r110.coinIconLayout;
        L86:
            CommonModel$LayoutStyle r327 = r125;
            if ((r415 & 2097152) == 0) goto L89;
            CommonModel$CommonColorStyle r126 = r110.playerMaskStyle;
        L90:
            CommonModel$CommonColorStyle r328 = r126;
            if ((r415 & 4194304) == 0) goto L93;
            CommonModel$LayoutStyle r127 = r110.playerLayout;
        L94:
            CommonModel$LayoutStyle r417 = r127;
            if ((r415 & 8388608) == 0) goto L97;
            CommonModel$LayoutStyle r128 = r110.feedbackLayout;
        L98:
            CommonModel$LayoutStyle r418 = r128;
            if ((r415 & 16777216) == 0) goto L101;
            String r129 = r110.leftTopAnimUrl;
        L102:
            String r419 = r129;
            if ((r415 & 33554432) == 0) goto L105;
            Integer r130 = r110.colorfulCardStyle;
        L107:
            if ((r415 & 67108864) == 0) goto L109;
            boolean r108 = r110.removeShadow;
        L111:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r417, r418, r419, r130, r108);
        L109:
            r108 = r414;
            goto L111
        L105:
            r130 = r413;
            goto L107
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

        public final CommonModel$LayoutStyle component1() {
            return this.infoLayout;
        }

        public final CommonModel$CusTextStyle component10() {
            return this.arriveTimeTextStyle;
        }

        public final CommonModel$LayoutStyle component11() {
            return this.arriveTimeTextLayout;
        }

        public final CommonModel$MaskStyle component12() {
            return this.maskStyle;
        }

        public final CommonModel$CommonColorStyle component13() {
            return this.hotIconStyle;
        }

        public final CommonModel$CommonColorStyle component14() {
            return this.rootStyle;
        }

        public final boolean component15() {
            return this.darkModeEnable;
        }

        public final Double component16() {
            return this.height;
        }

        public final Float component17() {
            return this.feedCardRatio;
        }

        public final CommonModel$LayoutStyle component18() {
            return this.redPacketLayout;
        }

        public final CommonModel$LayoutStyle component19() {
            return this.coinLayout;
        }

        public final CommonModel$LayoutStyle component2() {
            return this.avatarLayout;
        }

        public final CommonModel$CusTextStyle component20() {
            return this.coinStyle;
        }

        public final CommonModel$LayoutStyle component21() {
            return this.coinIconLayout;
        }

        public final CommonModel$CommonColorStyle component22() {
            return this.playerMaskStyle;
        }

        public final CommonModel$LayoutStyle component23() {
            return this.playerLayout;
        }

        public final CommonModel$LayoutStyle component24() {
            return this.feedbackLayout;
        }

        public final String component25() {
            return this.leftTopAnimUrl;
        }

        public final Integer component26() {
            return this.colorfulCardStyle;
        }

        public final boolean component27() {
            return this.removeShadow;
        }

        public final CommonModel$CusTextStyle component3() {
            return this.userTextStyle;
        }

        public final CommonModel$LayoutStyle component4() {
            return this.logoLayout;
        }

        public final CommonModel$LayoutStyle component5() {
            return this.logoTextLayout;
        }

        public final CommonModel$CusTextStyle component6() {
            return this.logoTextStyle;
        }

        public final CommonModel$LayoutStyle component7() {
            return this.hotLayout;
        }

        public final CommonModel$CusTextStyle component8() {
            return this.hotTextStyle;
        }

        public final CommonModel$LayoutStyle component9() {
            return this.arriveTimeIconLayout;
        }

        public final ElementStyle copy(CommonModel$LayoutStyle r310, CommonModel$LayoutStyle r311, CommonModel$CusTextStyle r312, CommonModel$LayoutStyle r313, CommonModel$LayoutStyle r314, CommonModel$CusTextStyle r315, CommonModel$LayoutStyle r316, CommonModel$CusTextStyle r317, CommonModel$LayoutStyle r318, CommonModel$CusTextStyle r410, CommonModel$LayoutStyle r411, CommonModel$MaskStyle r412, CommonModel$CommonColorStyle r413, CommonModel$CommonColorStyle r414, boolean r415, Double r416, Float r417, CommonModel$LayoutStyle r418, CommonModel$LayoutStyle r419, CommonModel$CusTextStyle r510, CommonModel$LayoutStyle r511, CommonModel$CommonColorStyle r512, CommonModel$LayoutStyle r513, CommonModel$LayoutStyle r514, String r515, Integer r516, boolean r517) {
            Intrinsics.checkNotNullParameter(r310, "infoLayout");
            Intrinsics.checkNotNullParameter(r311, "avatarLayout");
            Intrinsics.checkNotNullParameter(r312, "userTextStyle");
            Intrinsics.checkNotNullParameter(r313, "logoLayout");
            Intrinsics.checkNotNullParameter(r314, "logoTextLayout");
            Intrinsics.checkNotNullParameter(r315, "logoTextStyle");
            Intrinsics.checkNotNullParameter(r316, "hotLayout");
            Intrinsics.checkNotNullParameter(r317, "hotTextStyle");
            Intrinsics.checkNotNullParameter(r318, "arriveTimeIconLayout");
            Intrinsics.checkNotNullParameter(r410, "arriveTimeTextStyle");
            Intrinsics.checkNotNullParameter(r411, "arriveTimeTextLayout");
            Intrinsics.checkNotNullParameter(r412, "maskStyle");
            Intrinsics.checkNotNullParameter(r413, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r414, "rootStyle");
            Intrinsics.checkNotNullParameter(r418, "redPacketLayout");
            Intrinsics.checkNotNullParameter(r419, "coinLayout");
            Intrinsics.checkNotNullParameter(r510, "coinStyle");
            Intrinsics.checkNotNullParameter(r511, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r512, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r513, "playerLayout");
            Intrinsics.checkNotNullParameter(r514, "feedbackLayout");
            return new ElementStyle(r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ElementStyle) == false) goto L60;
            ElementStyle r101 = (ElementStyle) r100;
            if (Intrinsics.areEqual(this.infoLayout, r101.infoLayout) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avatarLayout, r101.avatarLayout) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.userTextStyle, r101.userTextStyle) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.logoLayout, r101.logoLayout) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.logoTextLayout, r101.logoTextLayout) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.logoTextStyle, r101.logoTextStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.hotLayout, r101.hotLayout) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.hotTextStyle, r101.hotTextStyle) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.arriveTimeIconLayout, r101.arriveTimeIconLayout) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.arriveTimeTextStyle, r101.arriveTimeTextStyle) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.arriveTimeTextLayout, r101.arriveTimeTextLayout) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.maskStyle, r101.maskStyle) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.hotIconStyle, r101.hotIconStyle) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.rootStyle, r101.rootStyle) == true) goto L34;
            return false;
        L34:
            if (this.darkModeEnable == r101.darkModeEnable) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.feedCardRatio, r101.feedCardRatio) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.redPacketLayout, r101.redPacketLayout) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.coinLayout, r101.coinLayout) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.coinStyle, r101.coinStyle) == true) goto L46;
            return false;
        L46:
            if (Intrinsics.areEqual(this.coinIconLayout, r101.coinIconLayout) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.playerMaskStyle, r101.playerMaskStyle) == true) goto L50;
            return false;
        L50:
            if (Intrinsics.areEqual(this.playerLayout, r101.playerLayout) == true) goto L52;
            return false;
        L52:
            if (Intrinsics.areEqual(this.feedbackLayout, r101.feedbackLayout) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.leftTopAnimUrl, r101.leftTopAnimUrl) == true) goto L56;
            return false;
        L56:
            if (Intrinsics.areEqual(this.colorfulCardStyle, r101.colorfulCardStyle) == true) goto L58;
            return false;
        L58:
            if (this.removeShadow == r101.removeShadow) goto L91;
            return false;
        L91:
            return true;
        L60:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v30, types: [int] */
        /* JADX WARN: Type inference failed for: r0v54, types: [int] */
        /* JADX WARN: Type inference failed for: r2v40, types: [int] */
        /* JADX WARN: Type inference failed for: r2v82 */
        /* JADX WARN: Type inference failed for: r2v96 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            CommonModel$LayoutStyle r100 = this.infoLayout;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            CommonModel$LayoutStyle r104 = this.avatarLayout;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            CommonModel$CusTextStyle r107 = this.userTextStyle;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            CommonModel$LayoutStyle r110 = this.logoLayout;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            CommonModel$LayoutStyle r113 = this.logoTextLayout;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            CommonModel$CusTextStyle r116 = this.logoTextStyle;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            CommonModel$LayoutStyle r119 = this.hotLayout;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            CommonModel$CusTextStyle r122 = this.hotTextStyle;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            CommonModel$LayoutStyle r125 = this.arriveTimeIconLayout;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            CommonModel$CusTextStyle r128 = this.arriveTimeTextStyle;
            if (r128 == null) goto L41;
            int r129 = r128.hashCode();
        L42:
            int r130 = (r127 + r129) * 31;
            CommonModel$LayoutStyle r131 = this.arriveTimeTextLayout;
            if (r131 == null) goto L45;
            int r132 = r131.hashCode();
        L46:
            int r133 = (r130 + r132) * 31;
            CommonModel$MaskStyle r134 = this.maskStyle;
            if (r134 == null) goto L49;
            int r135 = r134.hashCode();
        L50:
            int r136 = (r133 + r135) * 31;
            CommonModel$CommonColorStyle r137 = this.hotIconStyle;
            if (r137 == null) goto L53;
            int r138 = r137.hashCode();
        L54:
            int r139 = (r136 + r138) * 31;
            CommonModel$CommonColorStyle r140 = this.rootStyle;
            if (r140 == null) goto L57;
            int r141 = r140.hashCode();
        L58:
            int r142 = (r139 + r141) * 31;
            boolean r143 = this.darkModeEnable;
            ?? r144 = 1;
            ?? r145 = r143;
            if (r143 == false) goto L61;
            r145 = 1;
        L61:
            int r146 = (r142 + r145) * 31;
            Double r147 = this.height;
            if (r147 == null) goto L64;
            int r148 = r147.hashCode();
        L65:
            int r149 = (r146 + r148) * 31;
            Float r150 = this.feedCardRatio;
            if (r150 == null) goto L68;
            int r151 = r150.hashCode();
        L69:
            int r152 = (r149 + r151) * 31;
            CommonModel$LayoutStyle r153 = this.redPacketLayout;
            if (r153 == null) goto L72;
            int r154 = r153.hashCode();
        L73:
            int r155 = (r152 + r154) * 31;
            CommonModel$LayoutStyle r156 = this.coinLayout;
            if (r156 == null) goto L76;
            int r157 = r156.hashCode();
        L77:
            int r158 = (r155 + r157) * 31;
            CommonModel$CusTextStyle r159 = this.coinStyle;
            if (r159 == null) goto L80;
            int r160 = r159.hashCode();
        L81:
            int r161 = (r158 + r160) * 31;
            CommonModel$LayoutStyle r162 = this.coinIconLayout;
            if (r162 == null) goto L84;
            int r163 = r162.hashCode();
        L85:
            int r164 = (r161 + r163) * 31;
            CommonModel$CommonColorStyle r165 = this.playerMaskStyle;
            if (r165 == null) goto L88;
            int r166 = r165.hashCode();
        L89:
            int r167 = (r164 + r166) * 31;
            CommonModel$LayoutStyle r168 = this.playerLayout;
            if (r168 == null) goto L92;
            int r169 = r168.hashCode();
        L93:
            int r170 = (r167 + r169) * 31;
            CommonModel$LayoutStyle r171 = this.feedbackLayout;
            if (r171 == null) goto L96;
            int r172 = r171.hashCode();
        L97:
            int r173 = (r170 + r172) * 31;
            String r174 = this.leftTopAnimUrl;
            if (r174 == null) goto L100;
            int r175 = r174.hashCode();
        L101:
            int r176 = (r173 + r175) * 31;
            Integer r177 = this.colorfulCardStyle;
            if (r177 == null) goto L104;
            r101 = r177.hashCode();
        L104:
            int r178 = (r176 + r101) * 31;
            boolean r179 = this.removeShadow;
            if (r179 == true) goto L109;
            r144 = r179;
        L109:
            return r178 + r144;
        L100:
            r175 = 0;
            goto L101
        L96:
            r172 = 0;
            goto L97
        L92:
            r169 = 0;
            goto L93
        L88:
            r166 = 0;
            goto L89
        L84:
            r163 = 0;
            goto L85
        L80:
            r160 = 0;
            goto L81
        L76:
            r157 = 0;
            goto L77
        L72:
            r154 = 0;
            goto L73
        L68:
            r151 = 0;
            goto L69
        L64:
            r148 = 0;
            goto L65
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
            return "ElementStyle(infoLayout=" + this.infoLayout + ", avatarLayout=" + this.avatarLayout + ", userTextStyle=" + this.userTextStyle + ", logoLayout=" + this.logoLayout + ", logoTextLayout=" + this.logoTextLayout + ", logoTextStyle=" + this.logoTextStyle + ", hotLayout=" + this.hotLayout + ", hotTextStyle=" + this.hotTextStyle + ", arriveTimeIconLayout=" + this.arriveTimeIconLayout + ", arriveTimeTextStyle=" + this.arriveTimeTextStyle + ", arriveTimeTextLayout=" + this.arriveTimeTextLayout + ", maskStyle=" + this.maskStyle + ", hotIconStyle=" + this.hotIconStyle + ", rootStyle=" + this.rootStyle + ", darkModeEnable=" + this.darkModeEnable + ", height=" + this.height + ", feedCardRatio=" + this.feedCardRatio + ", redPacketLayout=" + this.redPacketLayout + ", coinLayout=" + this.coinLayout + ", coinStyle=" + this.coinStyle + ", coinIconLayout=" + this.coinIconLayout + ", playerMaskStyle=" + this.playerMaskStyle + ", playerLayout=" + this.playerLayout + ", feedbackLayout=" + this.feedbackLayout + ", leftTopAnimUrl=" + this.leftTopAnimUrl + ", colorfulCardStyle=" + this.colorfulCardStyle + ", removeShadow=" + this.removeShadow + ")";
        }

        public final CommonModel$LayoutStyle getArriveTimeIconLayout() {
            return this.arriveTimeIconLayout;
        }

        public final CommonModel$LayoutStyle getArriveTimeTextLayout() {
            return this.arriveTimeTextLayout;
        }

        public final CommonModel$CusTextStyle getArriveTimeTextStyle() {
            return this.arriveTimeTextStyle;
        }

        public final CommonModel$LayoutStyle getAvatarLayout() {
            return this.avatarLayout;
        }

        public final CommonModel$LayoutStyle getCoinIconLayout() {
            return this.coinIconLayout;
        }

        public final CommonModel$LayoutStyle getCoinLayout() {
            return this.coinLayout;
        }

        public final CommonModel$CusTextStyle getCoinStyle() {
            return this.coinStyle;
        }

        public final Integer getColorfulCardStyle() {
            return this.colorfulCardStyle;
        }

        public final boolean getDarkModeEnable() {
            return this.darkModeEnable;
        }

        public final Float getFeedCardRatio() {
            return this.feedCardRatio;
        }

        public final CommonModel$LayoutStyle getFeedbackLayout() {
            return this.feedbackLayout;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final CommonModel$CommonColorStyle getHotIconStyle() {
            return this.hotIconStyle;
        }

        public final CommonModel$LayoutStyle getHotLayout() {
            return this.hotLayout;
        }

        public final CommonModel$CusTextStyle getHotTextStyle() {
            return this.hotTextStyle;
        }

        public final CommonModel$LayoutStyle getInfoLayout() {
            return this.infoLayout;
        }

        public final String getLeftTopAnimUrl() {
            return this.leftTopAnimUrl;
        }

        public final CommonModel$LayoutStyle getLogoLayout() {
            return this.logoLayout;
        }

        public final CommonModel$LayoutStyle getLogoTextLayout() {
            return this.logoTextLayout;
        }

        public final CommonModel$CusTextStyle getLogoTextStyle() {
            return this.logoTextStyle;
        }

        public final CommonModel$MaskStyle getMaskStyle() {
            return this.maskStyle;
        }

        public final CommonModel$LayoutStyle getPlayerLayout() {
            return this.playerLayout;
        }

        public final CommonModel$CommonColorStyle getPlayerMaskStyle() {
            return this.playerMaskStyle;
        }

        public final CommonModel$LayoutStyle getRedPacketLayout() {
            return this.redPacketLayout;
        }

        public final boolean getRemoveShadow() {
            return this.removeShadow;
        }

        public final CommonModel$CommonColorStyle getRootStyle() {
            return this.rootStyle;
        }

        public final CommonModel$CusTextStyle getUserTextStyle() {
            return this.userTextStyle;
        }

        public ElementStyle(CommonModel$LayoutStyle r110, CommonModel$LayoutStyle r111, CommonModel$CusTextStyle r112, CommonModel$LayoutStyle r210, CommonModel$LayoutStyle r211, CommonModel$CusTextStyle r212, CommonModel$LayoutStyle r213, CommonModel$CusTextStyle r214, CommonModel$LayoutStyle r215, CommonModel$CusTextStyle r216, CommonModel$LayoutStyle r217, CommonModel$MaskStyle r218, CommonModel$CommonColorStyle r219, CommonModel$CommonColorStyle r310, boolean r311, Double r312, Float r313, CommonModel$LayoutStyle r314, CommonModel$LayoutStyle r315, CommonModel$CusTextStyle r316, CommonModel$LayoutStyle r317, CommonModel$CommonColorStyle r318, CommonModel$LayoutStyle r319, CommonModel$LayoutStyle r410, String r411, Integer r412, boolean r413) {
            Intrinsics.checkNotNullParameter(r110, "infoLayout");
            Intrinsics.checkNotNullParameter(r111, "avatarLayout");
            Intrinsics.checkNotNullParameter(r112, "userTextStyle");
            Intrinsics.checkNotNullParameter(r210, "logoLayout");
            Intrinsics.checkNotNullParameter(r211, "logoTextLayout");
            Intrinsics.checkNotNullParameter(r212, "logoTextStyle");
            Intrinsics.checkNotNullParameter(r213, "hotLayout");
            Intrinsics.checkNotNullParameter(r214, "hotTextStyle");
            Intrinsics.checkNotNullParameter(r215, "arriveTimeIconLayout");
            Intrinsics.checkNotNullParameter(r216, "arriveTimeTextStyle");
            Intrinsics.checkNotNullParameter(r217, "arriveTimeTextLayout");
            Intrinsics.checkNotNullParameter(r218, "maskStyle");
            Intrinsics.checkNotNullParameter(r219, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r310, "rootStyle");
            Intrinsics.checkNotNullParameter(r314, "redPacketLayout");
            Intrinsics.checkNotNullParameter(r315, "coinLayout");
            Intrinsics.checkNotNullParameter(r316, "coinStyle");
            Intrinsics.checkNotNullParameter(r317, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r318, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r319, "playerLayout");
            Intrinsics.checkNotNullParameter(r410, "feedbackLayout");
            this.infoLayout = r110;
            this.avatarLayout = r111;
            this.userTextStyle = r112;
            this.logoLayout = r210;
            this.logoTextLayout = r211;
            this.logoTextStyle = r212;
            this.hotLayout = r213;
            this.hotTextStyle = r214;
            this.arriveTimeIconLayout = r215;
            this.arriveTimeTextStyle = r216;
            this.arriveTimeTextLayout = r217;
            this.maskStyle = r218;
            this.hotIconStyle = r219;
            this.rootStyle = r310;
            this.darkModeEnable = r311;
            this.height = r312;
            this.feedCardRatio = r313;
            this.redPacketLayout = r314;
            this.coinLayout = r315;
            this.coinStyle = r316;
            this.coinIconLayout = r317;
            this.playerMaskStyle = r318;
            this.playerLayout = r319;
            this.feedbackLayout = r410;
            this.leftTopAnimUrl = r411;
            this.colorfulCardStyle = r412;
            this.removeShadow = r413;
        }

        public /* synthetic */ ElementStyle(CommonModel$LayoutStyle r310, CommonModel$LayoutStyle r311, CommonModel$CusTextStyle r312, CommonModel$LayoutStyle r313, CommonModel$LayoutStyle r314, CommonModel$CusTextStyle r315, CommonModel$LayoutStyle r316, CommonModel$CusTextStyle r317, CommonModel$LayoutStyle r410, CommonModel$CusTextStyle r411, CommonModel$LayoutStyle r412, CommonModel$MaskStyle r413, CommonModel$CommonColorStyle r414, CommonModel$CommonColorStyle r415, boolean r416, Double r417, Float r418, CommonModel$LayoutStyle r419, CommonModel$LayoutStyle r510, CommonModel$CusTextStyle r511, CommonModel$LayoutStyle r512, CommonModel$CommonColorStyle r513, CommonModel$LayoutStyle r514, CommonModel$LayoutStyle r515, String r516, Integer r517, boolean r518, int r519, DefaultConstructorMarker r610) {
            if ((r519 & 16384) == 0) goto L5;
            boolean r110 = false;
        L7:
            if ((32768 & r519) == 0) goto L9;
            Double r111 = null;
        L11:
            if ((65536 & r519) == 0) goto L13;
            Float r210 = null;
        L15:
            if ((16777216 & r519) == 0) goto L17;
            String r211 = null;
        L19:
            if ((33554432 & r519) == 0) goto L21;
            Integer r212 = null;
        L23:
            if ((r519 & 67108864) == 0) goto L25;
            boolean r318 = false;
        L26:
            this(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r110, r111, r210, r419, r510, r511, r512, r513, r514, r515, r211, r212, r318);
            return;
        L25:
            r318 = r518;
            goto L26
        L21:
            r212 = r517;
            goto L23
        L17:
            r211 = r516;
            goto L19
        L13:
            r210 = r418;
            goto L15
        L9:
            r111 = r417;
            goto L11
        L5:
            r110 = r416;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003Jt\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00032\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\fHÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006."}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "", "noProductInfo", "", "isNewProductUI", "showPeopleNewIcon", "newPadding", "highValue", "uiCompact", "liveCardChangeCover", "liveCardEnlargePlayArea", "coinLabelStyle", "", "appendHeight", "", "(ZZZZZZZZILjava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()I", "getHighValue", "()Z", "getLiveCardChangeCover", "getLiveCardEnlargePlayArea", "getNewPadding", "getNoProductInfo", "getShowPeopleNewIcon", "getUiCompact", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZZZZZZZILjava/lang/Double;)Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Experiment;", "equals", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Experiment {
        private final Double appendHeight;
        private final int coinLabelStyle;
        private final boolean highValue;
        private final boolean isNewProductUI;
        private final boolean liveCardChangeCover;
        private final boolean liveCardEnlargePlayArea;
        private final boolean newPadding;
        private final boolean noProductInfo;
        private final boolean showPeopleNewIcon;
        private final boolean uiCompact;

        public static /* synthetic */ Experiment copy$default(Experiment r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, int r210, Double r211, int r212, Object r213) {
            if ((r212 & 1) == 0) goto L5;
            boolean r100 = r110.noProductInfo;
        L7:
            if ((r212 & 2) == 0) goto L9;
            boolean r101 = r110.isNewProductUI;
        L11:
            if ((r212 & 4) == 0) goto L13;
            boolean r102 = r110.showPeopleNewIcon;
        L15:
            if ((r212 & 8) == 0) goto L17;
            boolean r103 = r110.newPadding;
        L19:
            if ((r212 & 16) == 0) goto L21;
            boolean r104 = r110.highValue;
        L23:
            if ((r212 & 32) == 0) goto L25;
            boolean r105 = r110.uiCompact;
        L27:
            if ((r212 & 64) == 0) goto L29;
            boolean r106 = r110.liveCardChangeCover;
        L31:
            if ((r212 & 128) == 0) goto L33;
            boolean r107 = r110.liveCardEnlargePlayArea;
        L35:
            if ((r212 & 256) == 0) goto L37;
            int r119 = r110.coinLabelStyle;
        L39:
            if ((r212 & 512) == 0) goto L41;
            Double r108 = r110.appendHeight;
        L43:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
        L41:
            r108 = r211;
            goto L43
        L37:
            r119 = r210;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final boolean component1() {
            return this.noProductInfo;
        }

        public final Double component10() {
            return this.appendHeight;
        }

        public final boolean component2() {
            return this.isNewProductUI;
        }

        public final boolean component3() {
            return this.showPeopleNewIcon;
        }

        public final boolean component4() {
            return this.newPadding;
        }

        public final boolean component5() {
            return this.highValue;
        }

        public final boolean component6() {
            return this.uiCompact;
        }

        public final boolean component7() {
            return this.liveCardChangeCover;
        }

        public final boolean component8() {
            return this.liveCardEnlargePlayArea;
        }

        public final int component9() {
            return this.coinLabelStyle;
        }

        public final Experiment copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r210, int r211, Double r212) {
            return new Experiment(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Experiment) == false) goto L26;
            Experiment r101 = (Experiment) r100;
            if (this.noProductInfo == r101.noProductInfo) goto L8;
            return false;
        L8:
            if (this.isNewProductUI == r101.isNewProductUI) goto L10;
            return false;
        L10:
            if (this.showPeopleNewIcon == r101.showPeopleNewIcon) goto L12;
            return false;
        L12:
            if (this.newPadding == r101.newPadding) goto L14;
            return false;
        L14:
            if (this.highValue == r101.highValue) goto L16;
            return false;
        L16:
            if (this.uiCompact == r101.uiCompact) goto L18;
            return false;
        L18:
            if (this.liveCardChangeCover == r101.liveCardChangeCover) goto L20;
            return false;
        L20:
            if (this.liveCardEnlargePlayArea == r101.liveCardEnlargePlayArea) goto L22;
            return false;
        L22:
            if (this.coinLabelStyle == r101.coinLabelStyle) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.appendHeight, r101.appendHeight) == true) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v21 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        public int hashCode() {
            boolean r100 = this.noProductInfo;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.isNewProductUI;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.showPeopleNewIcon;
            ?? r108 = r107;
            if (r107 == false) goto L11;
            r108 = 1;
        L11:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.newPadding;
            ?? r111 = r110;
            if (r110 == false) goto L14;
            r111 = 1;
        L14:
            int r112 = (r109 + r111) * 31;
            boolean r113 = this.highValue;
            ?? r114 = r113;
            if (r113 == false) goto L17;
            r114 = 1;
        L17:
            int r115 = (r112 + r114) * 31;
            boolean r116 = this.uiCompact;
            ?? r117 = r116;
            if (r116 == false) goto L20;
            r117 = 1;
        L20:
            int r118 = (r115 + r117) * 31;
            boolean r119 = this.liveCardChangeCover;
            ?? r120 = r119;
            if (r119 == false) goto L23;
            r120 = 1;
        L23:
            int r121 = (r118 + r120) * 31;
            boolean r122 = this.liveCardEnlargePlayArea;
            if (r122 == true) goto L27;
            r101 = r122;
        L27:
            int r123 = (((r121 + r101) * 31) + this.coinLabelStyle) * 31;
            Double r124 = this.appendHeight;
            if (r124 == null) goto L30;
            int r125 = r124.hashCode();
        L32:
            return r123 + r125;
        L30:
            r125 = 0;
            goto L32
        }

        public String toString() {
            return "Experiment(noProductInfo=" + this.noProductInfo + ", isNewProductUI=" + this.isNewProductUI + ", showPeopleNewIcon=" + this.showPeopleNewIcon + ", newPadding=" + this.newPadding + ", highValue=" + this.highValue + ", uiCompact=" + this.uiCompact + ", liveCardChangeCover=" + this.liveCardChangeCover + ", liveCardEnlargePlayArea=" + this.liveCardEnlargePlayArea + ", coinLabelStyle=" + this.coinLabelStyle + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final int getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final boolean getHighValue() {
            return this.highValue;
        }

        public final boolean getLiveCardChangeCover() {
            return this.liveCardChangeCover;
        }

        public final boolean getLiveCardEnlargePlayArea() {
            return this.liveCardEnlargePlayArea;
        }

        public final boolean getNewPadding() {
            return this.newPadding;
        }

        public final boolean getNoProductInfo() {
            return this.noProductInfo;
        }

        public final boolean getShowPeopleNewIcon() {
            return this.showPeopleNewIcon;
        }

        public final boolean getUiCompact() {
            return this.uiCompact;
        }

        public final boolean isNewProductUI() {
            return this.isNewProductUI;
        }

        public Experiment(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107, int r108, Double r110) {
            this.noProductInfo = r100;
            this.isNewProductUI = r101;
            this.showPeopleNewIcon = r102;
            this.newPadding = r103;
            this.highValue = r104;
            this.uiCompact = r105;
            this.liveCardChangeCover = r106;
            this.liveCardEnlargePlayArea = r107;
            this.coinLabelStyle = r108;
            this.appendHeight = r110;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b1\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0015HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003JÅ\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010B\u001a\u00020\u00152\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\nHÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001a¨\u0006F"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$Live;", "", "roomId", "", "streamData", "", "cover", "recommend", "animateImageUrl", "animateImageWidth", "", "animateImageHeight", "content", "hotNum", "hotNumStr", "accessibilityLabel", "playIconUrl", "title", "recReason", "recReasonType", "showProductImage", "", "newHotIcon", "newHotDesc", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getAnimateImageHeight", "()I", "getAnimateImageUrl", "getAnimateImageWidth", "getContent", "getCover", "getHotNum", "getHotNumStr", "getNewHotDesc", "getNewHotIcon", "getPlayIconUrl", "getRecReason", "getRecReasonType", "getRecommend", "getRoomId", "()J", "getShowProductImage", "()Z", "getStreamData", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Live {
        private final String accessibilityLabel;
        private final int animateImageHeight;
        private final String animateImageUrl;
        private final int animateImageWidth;
        private final String content;
        private final String cover;
        private final String hotNum;
        private final String hotNumStr;
        private final String newHotDesc;
        private final String newHotIcon;
        private final String playIconUrl;
        private final String recReason;
        private final String recReasonType;
        private final String recommend;
        private final long roomId;
        private final boolean showProductImage;
        private final String streamData;
        private final String title;

        public static /* synthetic */ Live copy$default(Live r110, long r111, String r210, String r211, String r212, String r213, int r214, int r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, boolean r314, String r315, String r316, int r317, Object r318) {
            if ((r317 & 1) == 0) goto L5;
            long r100 = r110.roomId;
        L7:
            if ((r317 & 2) == 0) goto L9;
            String r101 = r110.streamData;
        L11:
            if ((r317 & 4) == 0) goto L13;
            String r102 = r110.cover;
        L15:
            if ((r317 & 8) == 0) goto L17;
            String r103 = r110.recommend;
        L19:
            if ((r317 & 16) == 0) goto L21;
            String r104 = r110.animateImageUrl;
        L23:
            if ((r317 & 32) == 0) goto L25;
            int r105 = r110.animateImageWidth;
        L27:
            if ((r317 & 64) == 0) goto L29;
            int r106 = r110.animateImageHeight;
        L31:
            if ((r317 & 128) == 0) goto L33;
            String r112 = r110.content;
        L35:
            if ((r317 & 256) == 0) goto L37;
            String r113 = r110.hotNum;
        L39:
            if ((r317 & 512) == 0) goto L41;
            String r114 = r110.hotNumStr;
        L43:
            if ((r317 & 1024) == 0) goto L45;
            String r115 = r110.accessibilityLabel;
        L47:
            if ((r317 & 2048) == 0) goto L49;
            String r116 = r110.playIconUrl;
        L51:
            if ((r317 & 4096) == 0) goto L53;
            String r117 = r110.title;
        L54:
            String r319 = r117;
            if ((r317 & 8192) == 0) goto L57;
            String r118 = r110.recReason;
        L58:
            String r320 = r118;
            if ((r317 & 16384) == 0) goto L61;
            String r119 = r110.recReasonType;
        L62:
            String r321 = r119;
            if ((r317 & 32768) == 0) goto L65;
            boolean r120 = r110.showProductImage;
        L66:
            boolean r322 = r120;
            if ((r317 & 65536) == 0) goto L69;
            String r121 = r110.newHotIcon;
        L71:
            if ((r317 & 131072) == 0) goto L73;
            String r107 = r110.newHotDesc;
        L75:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r319, r320, r321, r322, r121, r107);
        L73:
            r107 = r316;
            goto L75
        L69:
            r121 = r315;
            goto L71
        L65:
            r120 = r314;
            goto L66
        L61:
            r119 = r313;
            goto L62
        L57:
            r118 = r312;
            goto L58
        L53:
            r117 = r311;
            goto L54
        L49:
            r116 = r310;
            goto L51
        L45:
            r115 = r219;
            goto L47
        L41:
            r114 = r218;
            goto L43
        L37:
            r113 = r217;
            goto L39
        L33:
            r112 = r216;
            goto L35
        L29:
            r106 = r215;
            goto L31
        L25:
            r105 = r214;
            goto L27
        L21:
            r104 = r213;
            goto L23
        L17:
            r103 = r212;
            goto L19
        L13:
            r102 = r211;
            goto L15
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final long component1() {
            return this.roomId;
        }

        public final String component10() {
            return this.hotNumStr;
        }

        public final String component11() {
            return this.accessibilityLabel;
        }

        public final String component12() {
            return this.playIconUrl;
        }

        public final String component13() {
            return this.title;
        }

        public final String component14() {
            return this.recReason;
        }

        public final String component15() {
            return this.recReasonType;
        }

        public final boolean component16() {
            return this.showProductImage;
        }

        public final String component17() {
            return this.newHotIcon;
        }

        public final String component18() {
            return this.newHotDesc;
        }

        public final String component2() {
            return this.streamData;
        }

        public final String component3() {
            return this.cover;
        }

        public final String component4() {
            return this.recommend;
        }

        public final String component5() {
            return this.animateImageUrl;
        }

        public final int component6() {
            return this.animateImageWidth;
        }

        public final int component7() {
            return this.animateImageHeight;
        }

        public final String component8() {
            return this.content;
        }

        public final String component9() {
            return this.hotNum;
        }

        public final Live copy(long r210, String r211, String r212, String r213, String r214, int r215, int r216, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, boolean r318, String r319, String r410) {
            Intrinsics.checkNotNullParameter(r211, "streamData");
            Intrinsics.checkNotNullParameter(r212, "cover");
            Intrinsics.checkNotNullParameter(r213, "recommend");
            Intrinsics.checkNotNullParameter(r214, "animateImageUrl");
            Intrinsics.checkNotNullParameter(r310, "content");
            Intrinsics.checkNotNullParameter(r311, "hotNum");
            Intrinsics.checkNotNullParameter(r312, "hotNumStr");
            Intrinsics.checkNotNullParameter(r313, "accessibilityLabel");
            Intrinsics.checkNotNullParameter(r314, "playIconUrl");
            Intrinsics.checkNotNullParameter(r315, "title");
            return new Live(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Live) == false) goto L42;
            Live r101 = (Live) r100;
            if (this.roomId == r101.roomId) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.streamData, r101.streamData) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.recommend, r101.recommend) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.animateImageUrl, r101.animateImageUrl) == true) goto L16;
            return false;
        L16:
            if (this.animateImageWidth == r101.animateImageWidth) goto L18;
            return false;
        L18:
            if (this.animateImageHeight == r101.animateImageHeight) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.hotNum, r101.hotNum) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.hotNumStr, r101.hotNumStr) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.accessibilityLabel, r101.accessibilityLabel) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.playIconUrl, r101.playIconUrl) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.recReason, r101.recReason) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.recReasonType, r101.recReasonType) == true) goto L36;
            return false;
        L36:
            if (this.showProductImage == r101.showProductImage) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.newHotIcon, r101.newHotIcon) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.newHotDesc, r101.newHotDesc) == true) goto L64;
            return false;
        L64:
            return true;
        L42:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v41, types: [int] */
        /* JADX WARN: Type inference failed for: r0v47 */
        /* JADX WARN: Type inference failed for: r0v60 */
        /* JADX WARN: Type inference failed for: r1v30, types: [int] */
        public int hashCode() {
            long r100 = this.roomId;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.streamData;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = r102.hashCode();
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.cover;
            if (r106 == null) goto L9;
            int r107 = r106.hashCode();
        L10:
            int r108 = (r105 + r107) * 31;
            String r109 = this.recommend;
            if (r109 == null) goto L13;
            int r110 = r109.hashCode();
        L14:
            int r111 = (r108 + r110) * 31;
            String r112 = this.animateImageUrl;
            if (r112 == null) goto L17;
            int r113 = r112.hashCode();
        L18:
            int r114 = (((((r111 + r113) * 31) + this.animateImageWidth) * 31) + this.animateImageHeight) * 31;
            String r115 = this.content;
            if (r115 == null) goto L21;
            int r116 = r115.hashCode();
        L22:
            int r117 = (r114 + r116) * 31;
            String r118 = this.hotNum;
            if (r118 == null) goto L25;
            int r119 = r118.hashCode();
        L26:
            int r120 = (r117 + r119) * 31;
            String r121 = this.hotNumStr;
            if (r121 == null) goto L29;
            int r122 = r121.hashCode();
        L30:
            int r123 = (r120 + r122) * 31;
            String r124 = this.accessibilityLabel;
            if (r124 == null) goto L33;
            int r125 = r124.hashCode();
        L34:
            int r126 = (r123 + r125) * 31;
            String r127 = this.playIconUrl;
            if (r127 == null) goto L37;
            int r128 = r127.hashCode();
        L38:
            int r129 = (r126 + r128) * 31;
            String r130 = this.title;
            if (r130 == null) goto L41;
            int r131 = r130.hashCode();
        L42:
            int r132 = (r129 + r131) * 31;
            String r133 = this.recReason;
            if (r133 == null) goto L45;
            int r134 = r133.hashCode();
        L46:
            int r135 = (r132 + r134) * 31;
            String r136 = this.recReasonType;
            if (r136 == null) goto L49;
            int r137 = r136.hashCode();
        L50:
            int r138 = (r135 + r137) * 31;
            boolean r139 = this.showProductImage;
            ?? r140 = r139;
            if (r139 == false) goto L53;
            r140 = 1;
        L53:
            int r141 = (r138 + r140) * 31;
            String r142 = this.newHotIcon;
            if (r142 == null) goto L56;
            int r143 = r142.hashCode();
        L57:
            int r144 = (r141 + r143) * 31;
            String r145 = this.newHotDesc;
            if (r145 == null) goto L61;
            r103 = r145.hashCode();
        L61:
            return r144 + r103;
        L56:
            r143 = 0;
            goto L57
        L49:
            r137 = 0;
            goto L50
        L45:
            r134 = 0;
            goto L46
        L41:
            r131 = 0;
            goto L42
        L37:
            r128 = 0;
            goto L38
        L33:
            r125 = 0;
            goto L34
        L29:
            r122 = 0;
            goto L30
        L25:
            r119 = 0;
            goto L26
        L21:
            r116 = 0;
            goto L22
        L17:
            r113 = 0;
            goto L18
        L13:
            r110 = 0;
            goto L14
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        public String toString() {
            return "Live(roomId=" + this.roomId + ", streamData=" + this.streamData + ", cover=" + this.cover + ", recommend=" + this.recommend + ", animateImageUrl=" + this.animateImageUrl + ", animateImageWidth=" + this.animateImageWidth + ", animateImageHeight=" + this.animateImageHeight + ", content=" + this.content + ", hotNum=" + this.hotNum + ", hotNumStr=" + this.hotNumStr + ", accessibilityLabel=" + this.accessibilityLabel + ", playIconUrl=" + this.playIconUrl + ", title=" + this.title + ", recReason=" + this.recReason + ", recReasonType=" + this.recReasonType + ", showProductImage=" + this.showProductImage + ", newHotIcon=" + this.newHotIcon + ", newHotDesc=" + this.newHotDesc + ")";
        }

        public final String getAccessibilityLabel() {
            return this.accessibilityLabel;
        }

        public final int getAnimateImageHeight() {
            return this.animateImageHeight;
        }

        public final String getAnimateImageUrl() {
            return this.animateImageUrl;
        }

        public final int getAnimateImageWidth() {
            return this.animateImageWidth;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getCover() {
            return this.cover;
        }

        public final String getHotNum() {
            return this.hotNum;
        }

        public final String getHotNumStr() {
            return this.hotNumStr;
        }

        public final String getNewHotDesc() {
            return this.newHotDesc;
        }

        public final String getNewHotIcon() {
            return this.newHotIcon;
        }

        public final String getPlayIconUrl() {
            return this.playIconUrl;
        }

        public final String getRecReason() {
            return this.recReason;
        }

        public final String getRecReasonType() {
            return this.recReasonType;
        }

        public final String getRecommend() {
            return this.recommend;
        }

        public final long getRoomId() {
            return this.roomId;
        }

        public final boolean getShowProductImage() {
            return this.showProductImage;
        }

        public final String getStreamData() {
            return this.streamData;
        }

        public final String getTitle() {
            return this.title;
        }

        public Live(long r110, String r111, String r112, String r113, String r114, int r210, int r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, boolean r310, String r311, String r312) {
            Intrinsics.checkNotNullParameter(r111, "streamData");
            Intrinsics.checkNotNullParameter(r112, "cover");
            Intrinsics.checkNotNullParameter(r113, "recommend");
            Intrinsics.checkNotNullParameter(r114, "animateImageUrl");
            Intrinsics.checkNotNullParameter(r212, "content");
            Intrinsics.checkNotNullParameter(r213, "hotNum");
            Intrinsics.checkNotNullParameter(r214, "hotNumStr");
            Intrinsics.checkNotNullParameter(r215, "accessibilityLabel");
            Intrinsics.checkNotNullParameter(r216, "playIconUrl");
            Intrinsics.checkNotNullParameter(r217, "title");
            this.roomId = r110;
            this.streamData = r111;
            this.cover = r112;
            this.recommend = r113;
            this.animateImageUrl = r114;
            this.animateImageWidth = r210;
            this.animateImageHeight = r211;
            this.content = r212;
            this.hotNum = r213;
            this.hotNumStr = r214;
            this.accessibilityLabel = r215;
            this.playIconUrl = r216;
            this.title = r217;
            this.recReason = r218;
            this.recReasonType = r219;
            this.showProductImage = r310;
            this.newHotIcon = r311;
            this.newHotDesc = r312;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/live/LiveCardModel$TTExperiment;", "", "uiStyle", "", "taskExpGroup", "(Ljava/lang/String;Ljava/lang/String;)V", "getTaskExpGroup", "()Ljava/lang/String;", "getUiStyle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTExperiment {
        private final String taskExpGroup;
        private final String uiStyle;

        public static /* synthetic */ TTExperiment copy$default(TTExperiment r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.uiStyle;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.taskExpGroup;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.uiStyle;
        }

        public final String component2() {
            return this.taskExpGroup;
        }

        public final TTExperiment copy(String r100, String r101) {
            return new TTExperiment(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof TTExperiment) == false) goto L10;
            TTExperiment r101 = (TTExperiment) r100;
            if (Intrinsics.areEqual(this.uiStyle, r101.uiStyle) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.taskExpGroup, r101.taskExpGroup) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r100 = this.uiStyle;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.taskExpGroup;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "TTExperiment(uiStyle=" + this.uiStyle + ", taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public final String getUiStyle() {
            return this.uiStyle;
        }

        public TTExperiment(String r100, String r101) {
            this.uiStyle = r100;
            this.taskExpGroup = r101;
        }
    }

    public final CommonData.CoinData getCoinData() {
        return this.coinData;
    }

    public final ElementStyle getElementStyle() {
        return this.elementStyle;
    }

    public final Experiment getExperiment() {
        return this.experiment;
    }

    public final LiveCardData.FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final Live getLive() {
        return this.live;
    }

    public final CommonModel$Product getProduct() {
        return this.product;
    }

    public final boolean getShowAdTag() {
        return this.showAdTag;
    }

    public final Boolean getShowJustNowUI() {
        return this.showJustNowUI;
    }

    public final TTExperiment getTtExperiment() {
        return this.ttExperiment;
    }

    public final CommonModel$User getUser() {
        return this.user;
    }

    public final CommonData.WindVaneEventData getWindVane() {
        return this.windVane;
    }

    public LiveCardModel(CommonModel$Product r100, CommonModel$User r101, Live r102, Experiment r103, boolean r104, LiveCardData.FavoriteItemStyle r105, Boolean r106, CommonData.WindVaneEventData r107, CommonData.CoinData r110, ElementStyle r111, TTExperiment r112) {
        Intrinsics.checkNotNullParameter(r100, "product");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "live");
        Intrinsics.checkNotNullParameter(r103, "experiment");
        Intrinsics.checkNotNullParameter(r111, "elementStyle");
        this.product = r100;
        this.user = r101;
        this.live = r102;
        this.experiment = r103;
        this.showAdTag = r104;
        this.itemStyle = r105;
        this.showJustNowUI = r106;
        this.windVane = r107;
        this.coinData = r110;
        this.elementStyle = r111;
        this.ttExperiment = r112;
    }

    public /* synthetic */ LiveCardModel(CommonModel$Product r110, CommonModel$User r111, Live r112, Experiment r113, boolean r210, LiveCardData.FavoriteItemStyle r211, Boolean r212, CommonData.WindVaneEventData r213, CommonData.CoinData r214, ElementStyle r215, TTExperiment r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 32) == 0) goto L5;
        LiveCardData.FavoriteItemStyle r100 = null;
    L7:
        if ((r217 & 64) == 0) goto L9;
        Boolean r114 = null;
    L11:
        if ((r217 & 128) == 0) goto L13;
        CommonData.WindVaneEventData r115 = null;
    L15:
        if ((r217 & 256) == 0) goto L17;
        CommonData.CoinData r116 = null;
    L19:
        if ((r217 & 1024) == 0) goto L21;
        TTExperiment r117 = null;
    L22:
        this(r110, r111, r112, r113, r210, r100, r114, r115, r116, r215, r117);
        return;
    L21:
        r117 = r216;
        goto L22
    L17:
        r116 = r214;
        goto L19
    L13:
        r115 = r213;
        goto L15
    L9:
        r114 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
