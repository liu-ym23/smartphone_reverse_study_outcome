package com.bytedance.android.shopping.mall.homepage.card.video;

import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CommonColorStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$CusTextStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$LayoutStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$MaskStyle;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$Product;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.CommonModel$User;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u00002\u00020\u0001:\u00040123Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel;", "", "product", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "user", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "video", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;", "liveHeader", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "experiment", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "itemStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "showJustNowUI", "", "windVane", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "coinData", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "elementStyle", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "ttExperiment", "Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;Ljava/lang/Boolean;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;)V", "getCoinData", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$CoinData;", "getElementStyle", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "getExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "getItemStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$FavoriteItemStyle;", "getLiveHeader", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/video/VideoCardData$Companion$LiveHeader;", "getProduct", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$Product;", "getShowJustNowUI", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTtExperiment", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;", "getUser", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$User;", "getVideo", "()Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;", "getWindVane", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$WindVaneEventData;", "ElementStyle", "Experiment", "TTExperiment", "Video", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCardModel {
    private final CommonData.CoinData coinData;
    private final ElementStyle elementStyle;
    private final Experiment experiment;
    private final VideoCardData.FavoriteItemStyle itemStyle;
    private final VideoCardData.Companion.LiveHeader liveHeader;
    private final CommonModel$Product product;
    private final Boolean showJustNowUI;
    private final TTExperiment ttExperiment;
    private final CommonModel$User user;
    private final Video video;
    private final CommonData.WindVaneEventData windVane;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÅ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010C\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\rHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0010HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010O\u001a\u00020\u0006HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\t\u0010T\u001a\u00020\rHÆ\u0003J\t\u0010U\u001a\u00020\rHÆ\u0003Jð\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00102\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020[HÖ\u0001J\t\u0010\\\u001a\u00020]HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u001d\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010(R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u0010\u001a\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u00101R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010&¨\u0006^"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "", "infoLayout", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "avatarLayout", "userTextStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "logoLayout", "videoTitleLayout", "videoTitleTextStyle", "maskStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "hotIconStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "rootStyle", "darkModeEnable", "", "height", "", "feedCardRatio", "", "liveHeaderStateStyle", "liveHeaderEnterIconLayout", "coinLayout", "coinStyle", "coinIconLayout", "playerMaskStyle", "playerLayout", "feedBackLayout", "isEnlarge", "videoLikeStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;)V", "getAvatarLayout", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getCoinIconLayout", "getCoinLayout", "getCoinStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getDarkModeEnable", "()Z", "getFeedBackLayout", "getFeedCardRatio", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHotIconStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;", "getInfoLayout", "getLiveHeaderEnterIconLayout", "getLiveHeaderStateStyle", "getLogoLayout", "getMaskStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;", "getPlayerLayout", "getPlayerMaskStyle", "getRootStyle", "getUserTextStyle", "getVideoLikeStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;", "getVideoTitleLayout", "getVideoTitleTextStyle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$MaskStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;ZLjava/lang/Double;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CommonColorStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;ZLcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonData$ElementStyle$VideoLikeStyle;)Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$ElementStyle;", "equals", "other", "hashCode", "", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ElementStyle {
        private final CommonModel$LayoutStyle avatarLayout;
        private final CommonModel$LayoutStyle coinIconLayout;
        private final CommonModel$LayoutStyle coinLayout;
        private final CommonModel$CusTextStyle coinStyle;
        private final boolean darkModeEnable;
        private final CommonModel$LayoutStyle feedBackLayout;
        private final Float feedCardRatio;
        private final Double height;
        private final CommonModel$CommonColorStyle hotIconStyle;
        private final CommonModel$LayoutStyle infoLayout;
        private final boolean isEnlarge;
        private final CommonModel$LayoutStyle liveHeaderEnterIconLayout;
        private final CommonModel$CusTextStyle liveHeaderStateStyle;
        private final CommonModel$LayoutStyle logoLayout;
        private final CommonModel$MaskStyle maskStyle;
        private final CommonModel$LayoutStyle playerLayout;
        private final CommonModel$CommonColorStyle playerMaskStyle;
        private final CommonModel$CommonColorStyle rootStyle;
        private final CommonModel$CusTextStyle userTextStyle;
        private final CommonData.ElementStyle.VideoLikeStyle videoLikeStyle;
        private final CommonModel$LayoutStyle videoTitleLayout;
        private final CommonModel$CusTextStyle videoTitleTextStyle;

        public static /* synthetic */ ElementStyle copy$default(ElementStyle r110, CommonModel$LayoutStyle r111, CommonModel$LayoutStyle r112, CommonModel$CusTextStyle r210, CommonModel$LayoutStyle r211, CommonModel$LayoutStyle r212, CommonModel$CusTextStyle r213, CommonModel$MaskStyle r214, CommonModel$CommonColorStyle r215, CommonModel$CommonColorStyle r216, boolean r217, Double r218, Float r219, CommonModel$CusTextStyle r310, CommonModel$LayoutStyle r311, CommonModel$LayoutStyle r312, CommonModel$CusTextStyle r313, CommonModel$LayoutStyle r314, CommonModel$CommonColorStyle r315, CommonModel$LayoutStyle r316, CommonModel$LayoutStyle r317, boolean r318, CommonData.ElementStyle.VideoLikeStyle r319, int r410, Object r411) {
            if ((r410 & 1) == 0) goto L5;
            CommonModel$LayoutStyle r100 = r110.infoLayout;
        L7:
            if ((r410 & 2) == 0) goto L9;
            CommonModel$LayoutStyle r101 = r110.avatarLayout;
        L11:
            if ((r410 & 4) == 0) goto L13;
            CommonModel$CusTextStyle r102 = r110.userTextStyle;
        L15:
            if ((r410 & 8) == 0) goto L17;
            CommonModel$LayoutStyle r103 = r110.logoLayout;
        L19:
            if ((r410 & 16) == 0) goto L21;
            CommonModel$LayoutStyle r104 = r110.videoTitleLayout;
        L23:
            if ((r410 & 32) == 0) goto L25;
            CommonModel$CusTextStyle r105 = r110.videoTitleTextStyle;
        L27:
            if ((r410 & 64) == 0) goto L29;
            CommonModel$MaskStyle r106 = r110.maskStyle;
        L31:
            if ((r410 & 128) == 0) goto L33;
            CommonModel$CommonColorStyle r107 = r110.hotIconStyle;
        L35:
            if ((r410 & 256) == 0) goto L37;
            CommonModel$CommonColorStyle r113 = r110.rootStyle;
        L39:
            if ((r410 & 512) == 0) goto L41;
            boolean r114 = r110.darkModeEnable;
        L43:
            if ((r410 & 1024) == 0) goto L45;
            Double r115 = r110.height;
        L47:
            if ((r410 & 2048) == 0) goto L49;
            Float r116 = r110.feedCardRatio;
        L51:
            if ((r410 & 4096) == 0) goto L53;
            CommonModel$CusTextStyle r117 = r110.liveHeaderStateStyle;
        L55:
            if ((r410 & 8192) == 0) goto L57;
            CommonModel$LayoutStyle r118 = r110.liveHeaderEnterIconLayout;
        L58:
            CommonModel$LayoutStyle r320 = r118;
            if ((r410 & 16384) == 0) goto L61;
            CommonModel$LayoutStyle r119 = r110.coinLayout;
        L62:
            CommonModel$LayoutStyle r321 = r119;
            if ((r410 & 32768) == 0) goto L65;
            CommonModel$CusTextStyle r120 = r110.coinStyle;
        L66:
            CommonModel$CusTextStyle r322 = r120;
            if ((r410 & 65536) == 0) goto L69;
            CommonModel$LayoutStyle r121 = r110.coinIconLayout;
        L70:
            CommonModel$LayoutStyle r323 = r121;
            if ((r410 & 131072) == 0) goto L73;
            CommonModel$CommonColorStyle r122 = r110.playerMaskStyle;
        L74:
            CommonModel$CommonColorStyle r324 = r122;
            if ((r410 & 262144) == 0) goto L77;
            CommonModel$LayoutStyle r123 = r110.playerLayout;
        L78:
            CommonModel$LayoutStyle r325 = r123;
            if ((r410 & 524288) == 0) goto L81;
            CommonModel$LayoutStyle r124 = r110.feedBackLayout;
        L82:
            CommonModel$LayoutStyle r326 = r124;
            if ((r410 & 1048576) == 0) goto L85;
            boolean r125 = r110.isEnlarge;
        L87:
            if ((r410 & 2097152) == 0) goto L89;
            CommonData.ElementStyle.VideoLikeStyle r108 = r110.videoLikeStyle;
        L91:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r125, r108);
        L89:
            r108 = r319;
            goto L91
        L85:
            r125 = r318;
            goto L87
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

        public final boolean component10() {
            return this.darkModeEnable;
        }

        public final Double component11() {
            return this.height;
        }

        public final Float component12() {
            return this.feedCardRatio;
        }

        public final CommonModel$CusTextStyle component13() {
            return this.liveHeaderStateStyle;
        }

        public final CommonModel$LayoutStyle component14() {
            return this.liveHeaderEnterIconLayout;
        }

        public final CommonModel$LayoutStyle component15() {
            return this.coinLayout;
        }

        public final CommonModel$CusTextStyle component16() {
            return this.coinStyle;
        }

        public final CommonModel$LayoutStyle component17() {
            return this.coinIconLayout;
        }

        public final CommonModel$CommonColorStyle component18() {
            return this.playerMaskStyle;
        }

        public final CommonModel$LayoutStyle component19() {
            return this.playerLayout;
        }

        public final CommonModel$LayoutStyle component2() {
            return this.avatarLayout;
        }

        public final CommonModel$LayoutStyle component20() {
            return this.feedBackLayout;
        }

        public final boolean component21() {
            return this.isEnlarge;
        }

        public final CommonData.ElementStyle.VideoLikeStyle component22() {
            return this.videoLikeStyle;
        }

        public final CommonModel$CusTextStyle component3() {
            return this.userTextStyle;
        }

        public final CommonModel$LayoutStyle component4() {
            return this.logoLayout;
        }

        public final CommonModel$LayoutStyle component5() {
            return this.videoTitleLayout;
        }

        public final CommonModel$CusTextStyle component6() {
            return this.videoTitleTextStyle;
        }

        public final CommonModel$MaskStyle component7() {
            return this.maskStyle;
        }

        public final CommonModel$CommonColorStyle component8() {
            return this.hotIconStyle;
        }

        public final CommonModel$CommonColorStyle component9() {
            return this.rootStyle;
        }

        public final ElementStyle copy(CommonModel$LayoutStyle r210, CommonModel$LayoutStyle r211, CommonModel$CusTextStyle r212, CommonModel$LayoutStyle r213, CommonModel$LayoutStyle r310, CommonModel$CusTextStyle r311, CommonModel$MaskStyle r312, CommonModel$CommonColorStyle r313, CommonModel$CommonColorStyle r314, boolean r315, Double r316, Float r317, CommonModel$CusTextStyle r318, CommonModel$LayoutStyle r319, CommonModel$LayoutStyle r410, CommonModel$CusTextStyle r411, CommonModel$LayoutStyle r412, CommonModel$CommonColorStyle r413, CommonModel$LayoutStyle r414, CommonModel$LayoutStyle r415, boolean r416, CommonData.ElementStyle.VideoLikeStyle r417) {
            Intrinsics.checkNotNullParameter(r210, "infoLayout");
            Intrinsics.checkNotNullParameter(r211, "avatarLayout");
            Intrinsics.checkNotNullParameter(r212, "userTextStyle");
            Intrinsics.checkNotNullParameter(r213, "logoLayout");
            Intrinsics.checkNotNullParameter(r310, "videoTitleLayout");
            Intrinsics.checkNotNullParameter(r311, "videoTitleTextStyle");
            Intrinsics.checkNotNullParameter(r312, "maskStyle");
            Intrinsics.checkNotNullParameter(r313, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r314, "rootStyle");
            Intrinsics.checkNotNullParameter(r318, "liveHeaderStateStyle");
            Intrinsics.checkNotNullParameter(r319, "liveHeaderEnterIconLayout");
            Intrinsics.checkNotNullParameter(r410, "coinLayout");
            Intrinsics.checkNotNullParameter(r411, "coinStyle");
            Intrinsics.checkNotNullParameter(r412, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r413, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r414, "playerLayout");
            Intrinsics.checkNotNullParameter(r415, "feedBackLayout");
            return new ElementStyle(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ElementStyle) == false) goto L50;
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
            if (Intrinsics.areEqual(this.videoTitleLayout, r101.videoTitleLayout) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.videoTitleTextStyle, r101.videoTitleTextStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.maskStyle, r101.maskStyle) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.hotIconStyle, r101.hotIconStyle) == true) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.rootStyle, r101.rootStyle) == true) goto L24;
            return false;
        L24:
            if (this.darkModeEnable == r101.darkModeEnable) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.feedCardRatio, r101.feedCardRatio) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.liveHeaderStateStyle, r101.liveHeaderStateStyle) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.liveHeaderEnterIconLayout, r101.liveHeaderEnterIconLayout) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.coinLayout, r101.coinLayout) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.coinStyle, r101.coinStyle) == true) goto L38;
            return false;
        L38:
            if (Intrinsics.areEqual(this.coinIconLayout, r101.coinIconLayout) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.playerMaskStyle, r101.playerMaskStyle) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.playerLayout, r101.playerLayout) == true) goto L44;
            return false;
        L44:
            if (Intrinsics.areEqual(this.feedBackLayout, r101.feedBackLayout) == true) goto L46;
            return false;
        L46:
            if (this.isEnlarge == r101.isEnlarge) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.videoLikeStyle, r101.videoLikeStyle) == true) goto L76;
            return false;
        L76:
            return true;
        L50:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r2v25, types: [int] */
        /* JADX WARN: Type inference failed for: r2v68 */
        /* JADX WARN: Type inference failed for: r2v77 */
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
            CommonModel$LayoutStyle r113 = this.videoTitleLayout;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            CommonModel$CusTextStyle r116 = this.videoTitleTextStyle;
            if (r116 == null) goto L25;
            int r117 = r116.hashCode();
        L26:
            int r118 = (r115 + r117) * 31;
            CommonModel$MaskStyle r119 = this.maskStyle;
            if (r119 == null) goto L29;
            int r120 = r119.hashCode();
        L30:
            int r121 = (r118 + r120) * 31;
            CommonModel$CommonColorStyle r122 = this.hotIconStyle;
            if (r122 == null) goto L33;
            int r123 = r122.hashCode();
        L34:
            int r124 = (r121 + r123) * 31;
            CommonModel$CommonColorStyle r125 = this.rootStyle;
            if (r125 == null) goto L37;
            int r126 = r125.hashCode();
        L38:
            int r127 = (r124 + r126) * 31;
            boolean r128 = this.darkModeEnable;
            ?? r129 = 1;
            ?? r130 = r128;
            if (r128 == false) goto L41;
            r130 = 1;
        L41:
            int r131 = (r127 + r130) * 31;
            Double r132 = this.height;
            if (r132 == null) goto L44;
            int r133 = r132.hashCode();
        L45:
            int r134 = (r131 + r133) * 31;
            Float r135 = this.feedCardRatio;
            if (r135 == null) goto L48;
            int r136 = r135.hashCode();
        L49:
            int r137 = (r134 + r136) * 31;
            CommonModel$CusTextStyle r138 = this.liveHeaderStateStyle;
            if (r138 == null) goto L52;
            int r139 = r138.hashCode();
        L53:
            int r140 = (r137 + r139) * 31;
            CommonModel$LayoutStyle r141 = this.liveHeaderEnterIconLayout;
            if (r141 == null) goto L56;
            int r142 = r141.hashCode();
        L57:
            int r143 = (r140 + r142) * 31;
            CommonModel$LayoutStyle r144 = this.coinLayout;
            if (r144 == null) goto L60;
            int r145 = r144.hashCode();
        L61:
            int r146 = (r143 + r145) * 31;
            CommonModel$CusTextStyle r147 = this.coinStyle;
            if (r147 == null) goto L64;
            int r148 = r147.hashCode();
        L65:
            int r149 = (r146 + r148) * 31;
            CommonModel$LayoutStyle r150 = this.coinIconLayout;
            if (r150 == null) goto L68;
            int r151 = r150.hashCode();
        L69:
            int r152 = (r149 + r151) * 31;
            CommonModel$CommonColorStyle r153 = this.playerMaskStyle;
            if (r153 == null) goto L72;
            int r154 = r153.hashCode();
        L73:
            int r155 = (r152 + r154) * 31;
            CommonModel$LayoutStyle r156 = this.playerLayout;
            if (r156 == null) goto L76;
            int r157 = r156.hashCode();
        L77:
            int r158 = (r155 + r157) * 31;
            CommonModel$LayoutStyle r159 = this.feedBackLayout;
            if (r159 == null) goto L80;
            int r160 = r159.hashCode();
        L81:
            int r161 = (r158 + r160) * 31;
            boolean r162 = this.isEnlarge;
            if (r162 == true) goto L85;
            r129 = r162;
        L85:
            int r163 = (r161 + r129) * 31;
            CommonData.ElementStyle.VideoLikeStyle r164 = this.videoLikeStyle;
            if (r164 == null) goto L89;
            r101 = r164.hashCode();
        L89:
            return r163 + r101;
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
        L60:
            r145 = 0;
            goto L61
        L56:
            r142 = 0;
            goto L57
        L52:
            r139 = 0;
            goto L53
        L48:
            r136 = 0;
            goto L49
        L44:
            r133 = 0;
            goto L45
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
            return "ElementStyle(infoLayout=" + this.infoLayout + ", avatarLayout=" + this.avatarLayout + ", userTextStyle=" + this.userTextStyle + ", logoLayout=" + this.logoLayout + ", videoTitleLayout=" + this.videoTitleLayout + ", videoTitleTextStyle=" + this.videoTitleTextStyle + ", maskStyle=" + this.maskStyle + ", hotIconStyle=" + this.hotIconStyle + ", rootStyle=" + this.rootStyle + ", darkModeEnable=" + this.darkModeEnable + ", height=" + this.height + ", feedCardRatio=" + this.feedCardRatio + ", liveHeaderStateStyle=" + this.liveHeaderStateStyle + ", liveHeaderEnterIconLayout=" + this.liveHeaderEnterIconLayout + ", coinLayout=" + this.coinLayout + ", coinStyle=" + this.coinStyle + ", coinIconLayout=" + this.coinIconLayout + ", playerMaskStyle=" + this.playerMaskStyle + ", playerLayout=" + this.playerLayout + ", feedBackLayout=" + this.feedBackLayout + ", isEnlarge=" + this.isEnlarge + ", videoLikeStyle=" + this.videoLikeStyle + ")";
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

        public final boolean getDarkModeEnable() {
            return this.darkModeEnable;
        }

        public final CommonModel$LayoutStyle getFeedBackLayout() {
            return this.feedBackLayout;
        }

        public final Float getFeedCardRatio() {
            return this.feedCardRatio;
        }

        public final Double getHeight() {
            return this.height;
        }

        public final CommonModel$CommonColorStyle getHotIconStyle() {
            return this.hotIconStyle;
        }

        public final CommonModel$LayoutStyle getInfoLayout() {
            return this.infoLayout;
        }

        public final CommonModel$LayoutStyle getLiveHeaderEnterIconLayout() {
            return this.liveHeaderEnterIconLayout;
        }

        public final CommonModel$CusTextStyle getLiveHeaderStateStyle() {
            return this.liveHeaderStateStyle;
        }

        public final CommonModel$LayoutStyle getLogoLayout() {
            return this.logoLayout;
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

        public final CommonModel$CommonColorStyle getRootStyle() {
            return this.rootStyle;
        }

        public final CommonModel$CusTextStyle getUserTextStyle() {
            return this.userTextStyle;
        }

        public final CommonData.ElementStyle.VideoLikeStyle getVideoLikeStyle() {
            return this.videoLikeStyle;
        }

        public final CommonModel$LayoutStyle getVideoTitleLayout() {
            return this.videoTitleLayout;
        }

        public final CommonModel$CusTextStyle getVideoTitleTextStyle() {
            return this.videoTitleTextStyle;
        }

        public final boolean isEnlarge() {
            return this.isEnlarge;
        }

        public ElementStyle(CommonModel$LayoutStyle r110, CommonModel$LayoutStyle r111, CommonModel$CusTextStyle r112, CommonModel$LayoutStyle r210, CommonModel$LayoutStyle r211, CommonModel$CusTextStyle r212, CommonModel$MaskStyle r213, CommonModel$CommonColorStyle r214, CommonModel$CommonColorStyle r215, boolean r216, Double r217, Float r218, CommonModel$CusTextStyle r219, CommonModel$LayoutStyle r310, CommonModel$LayoutStyle r311, CommonModel$CusTextStyle r312, CommonModel$LayoutStyle r313, CommonModel$CommonColorStyle r314, CommonModel$LayoutStyle r315, CommonModel$LayoutStyle r316, boolean r317, CommonData.ElementStyle.VideoLikeStyle r318) {
            Intrinsics.checkNotNullParameter(r110, "infoLayout");
            Intrinsics.checkNotNullParameter(r111, "avatarLayout");
            Intrinsics.checkNotNullParameter(r112, "userTextStyle");
            Intrinsics.checkNotNullParameter(r210, "logoLayout");
            Intrinsics.checkNotNullParameter(r211, "videoTitleLayout");
            Intrinsics.checkNotNullParameter(r212, "videoTitleTextStyle");
            Intrinsics.checkNotNullParameter(r213, "maskStyle");
            Intrinsics.checkNotNullParameter(r214, "hotIconStyle");
            Intrinsics.checkNotNullParameter(r215, "rootStyle");
            Intrinsics.checkNotNullParameter(r219, "liveHeaderStateStyle");
            Intrinsics.checkNotNullParameter(r310, "liveHeaderEnterIconLayout");
            Intrinsics.checkNotNullParameter(r311, "coinLayout");
            Intrinsics.checkNotNullParameter(r312, "coinStyle");
            Intrinsics.checkNotNullParameter(r313, "coinIconLayout");
            Intrinsics.checkNotNullParameter(r314, "playerMaskStyle");
            Intrinsics.checkNotNullParameter(r315, "playerLayout");
            Intrinsics.checkNotNullParameter(r316, "feedBackLayout");
            this.infoLayout = r110;
            this.avatarLayout = r111;
            this.userTextStyle = r112;
            this.logoLayout = r210;
            this.videoTitleLayout = r211;
            this.videoTitleTextStyle = r212;
            this.maskStyle = r213;
            this.hotIconStyle = r214;
            this.rootStyle = r215;
            this.darkModeEnable = r216;
            this.height = r217;
            this.feedCardRatio = r218;
            this.liveHeaderStateStyle = r219;
            this.liveHeaderEnterIconLayout = r310;
            this.coinLayout = r311;
            this.coinStyle = r312;
            this.coinIconLayout = r313;
            this.playerMaskStyle = r314;
            this.playerLayout = r315;
            this.feedBackLayout = r316;
            this.isEnlarge = r317;
            this.videoLikeStyle = r318;
        }

        public /* synthetic */ ElementStyle(CommonModel$LayoutStyle r210, CommonModel$LayoutStyle r211, CommonModel$CusTextStyle r212, CommonModel$LayoutStyle r310, CommonModel$LayoutStyle r311, CommonModel$CusTextStyle r312, CommonModel$MaskStyle r313, CommonModel$CommonColorStyle r314, CommonModel$CommonColorStyle r315, boolean r316, Double r317, Float r318, CommonModel$CusTextStyle r319, CommonModel$LayoutStyle r410, CommonModel$LayoutStyle r411, CommonModel$CusTextStyle r412, CommonModel$LayoutStyle r413, CommonModel$CommonColorStyle r414, CommonModel$LayoutStyle r415, CommonModel$LayoutStyle r416, boolean r417, CommonData.ElementStyle.VideoLikeStyle r418, int r419, DefaultConstructorMarker r510) {
            if ((r419 & 512) == 0) goto L5;
            boolean r110 = false;
        L7:
            if ((r419 & 1024) == 0) goto L9;
            Double r111 = null;
        L11:
            if ((r419 & 2048) == 0) goto L13;
            Float r112 = null;
        L15:
            if ((1048576 & r419) == 0) goto L17;
            boolean r213 = false;
        L19:
            if ((r419 & 2097152) == 0) goto L21;
            CommonData.ElementStyle.VideoLikeStyle r214 = null;
        L22:
            this(r210, r211, r212, r310, r311, r312, r313, r314, r315, r110, r111, r112, r319, r410, r411, r412, r413, r414, r415, r416, r213, r214);
            return;
        L21:
            r214 = r418;
            goto L22
        L17:
            r213 = r417;
            goto L19
        L13:
            r112 = r318;
            goto L15
        L9:
            r111 = r317;
            goto L11
        L5:
            r110 = r316;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u000fJ`\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "", "noProductInfo", "", "isNewProductUI", "newPadding", "hideVideoTime", "hideVideoDesc", "uiCompact", "coinLabelStyle", "", "appendHeight", "", "(ZZZZZZILjava/lang/Double;)V", "getAppendHeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCoinLabelStyle", "()I", "getHideVideoDesc", "()Z", "getHideVideoTime", "getNewPadding", "getNoProductInfo", "getUiCompact", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZZZZZZILjava/lang/Double;)Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Experiment;", "equals", "other", "hashCode", "toString", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Experiment {
        private final Double appendHeight;
        private final int coinLabelStyle;
        private final boolean hideVideoDesc;
        private final boolean hideVideoTime;
        private final boolean isNewProductUI;
        private final boolean newPadding;
        private final boolean noProductInfo;
        private final boolean uiCompact;

        public static /* synthetic */ Experiment copy$default(Experiment r100, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116, Double r117, int r118, Object r119) {
            if ((r118 & 1) == 0) goto L5;
            boolean r101 = r100.noProductInfo;
        L7:
            if ((r118 & 2) == 0) goto L9;
            boolean r102 = r100.isNewProductUI;
        L11:
            if ((r118 & 4) == 0) goto L13;
            boolean r103 = r100.newPadding;
        L15:
            if ((r118 & 8) == 0) goto L17;
            boolean r104 = r100.hideVideoTime;
        L19:
            if ((r118 & 16) == 0) goto L21;
            boolean r105 = r100.hideVideoDesc;
        L23:
            if ((r118 & 32) == 0) goto L25;
            boolean r106 = r100.uiCompact;
        L27:
            if ((r118 & 64) == 0) goto L29;
            int r107 = r100.coinLabelStyle;
        L31:
            if ((r118 & 128) == 0) goto L33;
            Double r108 = r100.appendHeight;
        L35:
            return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }

        public final boolean component1() {
            return this.noProductInfo;
        }

        public final boolean component2() {
            return this.isNewProductUI;
        }

        public final boolean component3() {
            return this.newPadding;
        }

        public final boolean component4() {
            return this.hideVideoTime;
        }

        public final boolean component5() {
            return this.hideVideoDesc;
        }

        public final boolean component6() {
            return this.uiCompact;
        }

        public final int component7() {
            return this.coinLabelStyle;
        }

        public final Double component8() {
            return this.appendHeight;
        }

        public final Experiment copy(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, int r116, Double r117) {
            return new Experiment(r110, r111, r112, r113, r114, r115, r116, r117);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Experiment) == false) goto L22;
            Experiment r101 = (Experiment) r100;
            if (this.noProductInfo == r101.noProductInfo) goto L8;
            return false;
        L8:
            if (this.isNewProductUI == r101.isNewProductUI) goto L10;
            return false;
        L10:
            if (this.newPadding == r101.newPadding) goto L12;
            return false;
        L12:
            if (this.hideVideoTime == r101.hideVideoTime) goto L14;
            return false;
        L14:
            if (this.hideVideoDesc == r101.hideVideoDesc) goto L16;
            return false;
        L16:
            if (this.uiCompact == r101.uiCompact) goto L18;
            return false;
        L18:
            if (this.coinLabelStyle == r101.coinLabelStyle) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.appendHeight, r101.appendHeight) == true) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
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
            boolean r107 = this.newPadding;
            ?? r108 = r107;
            if (r107 == false) goto L11;
            r108 = 1;
        L11:
            int r109 = (r106 + r108) * 31;
            boolean r110 = this.hideVideoTime;
            ?? r111 = r110;
            if (r110 == false) goto L14;
            r111 = 1;
        L14:
            int r112 = (r109 + r111) * 31;
            boolean r113 = this.hideVideoDesc;
            ?? r114 = r113;
            if (r113 == false) goto L17;
            r114 = 1;
        L17:
            int r115 = (r112 + r114) * 31;
            boolean r116 = this.uiCompact;
            if (r116 == true) goto L21;
            r101 = r116;
        L21:
            int r117 = (((r115 + r101) * 31) + this.coinLabelStyle) * 31;
            Double r118 = this.appendHeight;
            if (r118 == null) goto L24;
            int r119 = r118.hashCode();
        L26:
            return r117 + r119;
        L24:
            r119 = 0;
            goto L26
        }

        public String toString() {
            return "Experiment(noProductInfo=" + this.noProductInfo + ", isNewProductUI=" + this.isNewProductUI + ", newPadding=" + this.newPadding + ", hideVideoTime=" + this.hideVideoTime + ", hideVideoDesc=" + this.hideVideoDesc + ", uiCompact=" + this.uiCompact + ", coinLabelStyle=" + this.coinLabelStyle + ", appendHeight=" + this.appendHeight + ")";
        }

        public final Double getAppendHeight() {
            return this.appendHeight;
        }

        public final int getCoinLabelStyle() {
            return this.coinLabelStyle;
        }

        public final boolean getHideVideoDesc() {
            return this.hideVideoDesc;
        }

        public final boolean getHideVideoTime() {
            return this.hideVideoTime;
        }

        public final boolean getNewPadding() {
            return this.newPadding;
        }

        public final boolean getNoProductInfo() {
            return this.noProductInfo;
        }

        public final boolean getUiCompact() {
            return this.uiCompact;
        }

        public final boolean isNewProductUI() {
            return this.isNewProductUI;
        }

        public Experiment(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106, Double r107) {
            this.noProductInfo = r100;
            this.isNewProductUI = r101;
            this.newPadding = r102;
            this.hideVideoTime = r103;
            this.hideVideoDesc = r104;
            this.uiCompact = r105;
            this.coinLabelStyle = r106;
            this.appendHeight = r107;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$TTExperiment;", "", "taskExpGroup", "", "(Ljava/lang/String;)V", "getTaskExpGroup", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TTExperiment {
        private final String taskExpGroup;

        public static /* synthetic */ TTExperiment copy$default(TTExperiment r100, String r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.taskExpGroup;
        L6:
            return r100.copy(r101);
        }

        public final String component1() {
            return this.taskExpGroup;
        }

        public final TTExperiment copy(String r100) {
            return new TTExperiment(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof TTExperiment) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.taskExpGroup, ((TTExperiment) r100).taskExpGroup) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            String r100 = this.taskExpGroup;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "TTExperiment(taskExpGroup=" + this.taskExpGroup + ")";
        }

        public final String getTaskExpGroup() {
            return this.taskExpGroup;
        }

        public TTExperiment(String r100) {
            this.taskExpGroup = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/video/VideoCardModel$Video;", "", "id", "", "seconds", "", "cover", "addr", "addrH265", "width", "height", "accessibilityLabel", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getAccessibilityLabel", "()Ljava/lang/String;", "getAddr", "getAddrH265", "getCover", "getDesc", "getHeight", "()I", "getId", "getSeconds", "getWidth", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Video {
        private final String accessibilityLabel;
        private final String addr;
        private final String addrH265;
        private final String cover;
        private final String desc;
        private final int height;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final String f178064id;
        private final int seconds;
        private final int width;

        public final String getAccessibilityLabel() {
            return this.accessibilityLabel;
        }

        public final String getAddr() {
            return this.addr;
        }

        public final String getAddrH265() {
            return this.addrH265;
        }

        public final String getCover() {
            return this.cover;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getHeight() {
            return this.height;
        }

        public final String getId() {
            return this.f178064id;
        }

        public final int getSeconds() {
            return this.seconds;
        }

        public final int getWidth() {
            return this.width;
        }

        public Video(String r100, int r101, String r102, String r103, String r104, int r105, int r106, String r107, String r110) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r102, "cover");
            Intrinsics.checkNotNullParameter(r103, "addr");
            Intrinsics.checkNotNullParameter(r104, "addrH265");
            Intrinsics.checkNotNullParameter(r107, "accessibilityLabel");
            Intrinsics.checkNotNullParameter(r110, SocialConstants.PARAM_APP_DESC);
            this.f178064id = r100;
            this.seconds = r101;
            this.cover = r102;
            this.addr = r103;
            this.addrH265 = r104;
            this.width = r105;
            this.height = r106;
            this.accessibilityLabel = r107;
            this.desc = r110;
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

    public final VideoCardData.FavoriteItemStyle getItemStyle() {
        return this.itemStyle;
    }

    public final VideoCardData.Companion.LiveHeader getLiveHeader() {
        return this.liveHeader;
    }

    public final CommonModel$Product getProduct() {
        return this.product;
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

    public final Video getVideo() {
        return this.video;
    }

    public final CommonData.WindVaneEventData getWindVane() {
        return this.windVane;
    }

    public VideoCardModel(CommonModel$Product r100, CommonModel$User r101, Video r102, VideoCardData.Companion.LiveHeader r103, Experiment r104, VideoCardData.FavoriteItemStyle r105, Boolean r106, CommonData.WindVaneEventData r107, CommonData.CoinData r110, ElementStyle r111, TTExperiment r112) {
        Intrinsics.checkNotNullParameter(r100, "product");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, "video");
        Intrinsics.checkNotNullParameter(r104, "experiment");
        Intrinsics.checkNotNullParameter(r111, "elementStyle");
        this.product = r100;
        this.user = r101;
        this.video = r102;
        this.liveHeader = r103;
        this.experiment = r104;
        this.itemStyle = r105;
        this.showJustNowUI = r106;
        this.windVane = r107;
        this.coinData = r110;
        this.elementStyle = r111;
        this.ttExperiment = r112;
    }

    public /* synthetic */ VideoCardModel(CommonModel$Product r110, CommonModel$User r111, Video r112, VideoCardData.Companion.LiveHeader r113, Experiment r210, VideoCardData.FavoriteItemStyle r211, Boolean r212, CommonData.WindVaneEventData r213, CommonData.CoinData r214, ElementStyle r215, TTExperiment r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 8) == 0) goto L5;
        VideoCardData.Companion.LiveHeader r100 = null;
    L7:
        if ((r217 & 32) == 0) goto L9;
        VideoCardData.FavoriteItemStyle r101 = null;
    L11:
        if ((r217 & 64) == 0) goto L13;
        Boolean r114 = null;
    L15:
        if ((r217 & 128) == 0) goto L17;
        CommonData.WindVaneEventData r115 = null;
    L19:
        if ((r217 & 256) == 0) goto L21;
        CommonData.CoinData r116 = null;
    L23:
        if ((r217 & 1024) == 0) goto L25;
        TTExperiment r117 = null;
    L26:
        this(r110, r111, r112, r100, r210, r101, r114, r115, r116, r215, r117);
        return;
    L25:
        r117 = r216;
        goto L26
    L21:
        r116 = r214;
        goto L23
    L17:
        r115 = r213;
        goto L19
    L13:
        r114 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
