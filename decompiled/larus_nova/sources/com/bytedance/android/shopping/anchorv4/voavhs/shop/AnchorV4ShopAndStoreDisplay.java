package com.bytedance.android.shopping.anchorv4.voavhs.shop;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bO\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010$\u001a\u00020%\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010+J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010!HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010e\u001a\u00020%HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jé\u0002\u0010r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010s\u001a\u00020%2\b\u0010t\u001a\u0004\u0018\u00010uHÖ\u0003J\t\u0010v\u001a\u00020wHÖ\u0001J\t\u0010x\u001a\u00020yHÖ\u0001R\u0018\u0010&\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00101R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0018\u0010 \u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0018\u0010(\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0018\u0010\"\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u00105R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u00101R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u00105R\u0018\u0010)\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010:R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u00103R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u0016\u0010$\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006z"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreDisplay;", "Ljava/io/Serializable;", "shopAvatar", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "shopInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "jumpButton", "trustPics", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "ratingScore", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "peersExceeded", "recommendInfo", "shopPromotionInfo", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "shopProfile", "shopRecommendTitle", "shopBackground", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "storeReputation", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;", "shopSalesText", "shopSlogan", "followAndSellInfo", "", "shopIcon", "shopAvatarIcon", "rankBanner", "reputationIconsAndFans", "Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", IconList.ELEM_NAME, "shopDistanceText", "shopAmbient", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;", "shopDetailMainInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;", "shopStructOptimize", "", "basicInfoBg", "shopAvatarBorder", "shopAvatarTag", "shopScoreIcons", "shopScoreText", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;ZLcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getBasicInfoBg", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getFollowAndSellInfo", "()Ljava/util/List;", "getIconList", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "getJumpButton", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getPeersExceeded", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getRankBanner", "getRatingScore", "getRecommendInfo", "getReputationIconsAndFans", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/TagsScrollBoxComponent;", "getShopAmbient", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAmbient;", "getShopAvatar", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "getShopAvatarBorder", "getShopAvatarIcon", "getShopAvatarTag", "getShopBackground", "getShopDetailMainInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopDetailMainInfo;", "getShopDistanceText", "getShopIcon", "getShopInfo", "getShopProfile", "getShopPromotionInfo", "getShopRecommendTitle", "getShopSalesText", "getShopScoreIcons", "getShopScoreText", "getShopSlogan", "getShopStructOptimize", "()Z", "getStoreReputation", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/shop/AnchorV4ShopAndStoreReputation;", "getTrustPics", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ShopAndStoreDisplay implements Serializable {

    @SerializedName("basic_info_bg")
    private final Background basicInfoBg;

    @SerializedName("follow_and_sell")
    private final List<TextElement> followAndSellInfo;

    @SerializedName("icon_list")
    private final LongContentLabelComponent iconList;

    @SerializedName("jump_button")
    private final TextWithOneIconElement jumpButton;

    @SerializedName("peers_exceeded")
    private final TextElement peersExceeded;

    @SerializedName("rank_banner")
    private final LongContentLabelComponent rankBanner;

    @SerializedName("rating_score")
    private final TextElement ratingScore;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final TextElement recommendInfo;

    @SerializedName("reputation_icons_and_fans")
    private final TagsScrollBoxComponent reputationIconsAndFans;

    @SerializedName("shop_ambient")
    private final AnchorV4ShopAmbient shopAmbient;

    @SerializedName("shop_avatar")
    private final MediaBoxElement shopAvatar;

    @SerializedName("shop_avatar_border")
    private final MediaBoxElement shopAvatarBorder;

    @SerializedName("shop_avatar_icon")
    private final TextWithOneIconElement shopAvatarIcon;

    @SerializedName("shop_avatar_tag")
    private final TextWithOneIconElement shopAvatarTag;

    @SerializedName("shop_background")
    private final Background shopBackground;

    @SerializedName("shop_detail_main_info")
    private final AnchorV4ShopDetailMainInfo shopDetailMainInfo;

    @SerializedName("shop_distance")
    private final TextElement shopDistanceText;

    @SerializedName("shop_icon")
    private final TextWithOneIconElement shopIcon;

    @SerializedName("shop_info")
    private final TextWithOneIconElement shopInfo;

    @SerializedName("shop_profile")
    private final LongContentLabelComponent shopProfile;

    @SerializedName("shop_promotion_info")
    private final LongContentLabelComponent shopPromotionInfo;

    @SerializedName("shop_recommend_title")
    private final LongContentLabelComponent shopRecommendTitle;

    @SerializedName("shop_sales")
    private final TextElement shopSalesText;

    @SerializedName("shop_score_icons")
    private final TagsScrollBoxComponent shopScoreIcons;

    @SerializedName("shop_score_text")
    private final TextWithOneIconElement shopScoreText;

    @SerializedName("shop_slogan")
    private final TextWithOneIconElement shopSlogan;

    @SerializedName("shop_struct_optimize")
    private final boolean shopStructOptimize;

    @SerializedName("store_reputation")
    private final AnchorV4ShopAndStoreReputation storeReputation;

    @SerializedName("trust_pics")
    private final IconsWithSpaceElement trustPics;

    public AnchorV4ShopAndStoreDisplay() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4ShopAndStoreDisplay copy$default(AnchorV4ShopAndStoreDisplay r110, MediaBoxElement r111, TextWithOneIconElement r112, TextWithOneIconElement r210, IconsWithSpaceElement r211, TextElement r212, TextElement r213, TextElement r214, LongContentLabelComponent r215, LongContentLabelComponent r216, LongContentLabelComponent r217, Background r218, AnchorV4ShopAndStoreReputation r219, TextElement r310, TextWithOneIconElement r311, List r312, TextWithOneIconElement r313, TextWithOneIconElement r314, LongContentLabelComponent r315, TagsScrollBoxComponent r316, LongContentLabelComponent r317, TextElement r318, AnchorV4ShopAmbient r319, AnchorV4ShopDetailMainInfo r410, boolean r411, Background r412, MediaBoxElement r413, TextWithOneIconElement r414, TagsScrollBoxComponent r415, TextWithOneIconElement r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        MediaBoxElement r100 = r110.shopAvatar;
    L7:
        if ((r417 & 2) == 0) goto L9;
        TextWithOneIconElement r101 = r110.shopInfo;
    L11:
        if ((r417 & 4) == 0) goto L13;
        TextWithOneIconElement r102 = r110.jumpButton;
    L15:
        if ((r417 & 8) == 0) goto L17;
        IconsWithSpaceElement r103 = r110.trustPics;
    L19:
        if ((r417 & 16) == 0) goto L21;
        TextElement r104 = r110.ratingScore;
    L23:
        if ((r417 & 32) == 0) goto L25;
        TextElement r105 = r110.peersExceeded;
    L27:
        if ((r417 & 64) == 0) goto L29;
        TextElement r106 = r110.recommendInfo;
    L31:
        if ((r417 & 128) == 0) goto L33;
        LongContentLabelComponent r107 = r110.shopPromotionInfo;
    L35:
        if ((r417 & 256) == 0) goto L37;
        LongContentLabelComponent r113 = r110.shopProfile;
    L39:
        if ((r417 & 512) == 0) goto L41;
        LongContentLabelComponent r114 = r110.shopRecommendTitle;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        Background r115 = r110.shopBackground;
    L47:
        if ((r417 & 2048) == 0) goto L49;
        AnchorV4ShopAndStoreReputation r116 = r110.storeReputation;
    L51:
        if ((r417 & 4096) == 0) goto L53;
        TextElement r117 = r110.shopSalesText;
    L55:
        if ((r417 & 8192) == 0) goto L57;
        TextWithOneIconElement r118 = r110.shopSlogan;
    L58:
        TextWithOneIconElement r320 = r118;
        if ((r417 & 16384) == 0) goto L61;
        List r119 = r110.followAndSellInfo;
    L62:
        List r321 = r119;
        if ((r417 & 32768) == 0) goto L65;
        TextWithOneIconElement r120 = r110.shopIcon;
    L66:
        TextWithOneIconElement r322 = r120;
        if ((r417 & 65536) == 0) goto L69;
        TextWithOneIconElement r121 = r110.shopAvatarIcon;
    L70:
        TextWithOneIconElement r323 = r121;
        if ((r417 & 131072) == 0) goto L73;
        LongContentLabelComponent r122 = r110.rankBanner;
    L74:
        LongContentLabelComponent r324 = r122;
        if ((r417 & 262144) == 0) goto L77;
        TagsScrollBoxComponent r123 = r110.reputationIconsAndFans;
    L78:
        TagsScrollBoxComponent r325 = r123;
        if ((r417 & 524288) == 0) goto L81;
        LongContentLabelComponent r124 = r110.iconList;
    L82:
        LongContentLabelComponent r326 = r124;
        if ((r417 & 1048576) == 0) goto L85;
        TextElement r125 = r110.shopDistanceText;
    L86:
        TextElement r327 = r125;
        if ((r417 & 2097152) == 0) goto L89;
        AnchorV4ShopAmbient r126 = r110.shopAmbient;
    L90:
        AnchorV4ShopAmbient r328 = r126;
        if ((r417 & 4194304) == 0) goto L93;
        AnchorV4ShopDetailMainInfo r127 = r110.shopDetailMainInfo;
    L94:
        AnchorV4ShopDetailMainInfo r419 = r127;
        if ((r417 & 8388608) == 0) goto L97;
        boolean r128 = r110.shopStructOptimize;
    L98:
        boolean r420 = r128;
        if ((r417 & 16777216) == 0) goto L101;
        Background r129 = r110.basicInfoBg;
    L102:
        Background r421 = r129;
        if ((r417 & 33554432) == 0) goto L105;
        MediaBoxElement r130 = r110.shopAvatarBorder;
    L106:
        MediaBoxElement r422 = r130;
        if ((r417 & 67108864) == 0) goto L109;
        TextWithOneIconElement r131 = r110.shopAvatarTag;
    L110:
        TextWithOneIconElement r423 = r131;
        if ((r417 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        TagsScrollBoxComponent r132 = r110.shopScoreIcons;
    L115:
        if ((r417 & 268435456) == 0) goto L117;
        TextWithOneIconElement r108 = r110.shopScoreText;
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

    public final MediaBoxElement component1() {
        return this.shopAvatar;
    }

    public final LongContentLabelComponent component10() {
        return this.shopRecommendTitle;
    }

    public final Background component11() {
        return this.shopBackground;
    }

    public final AnchorV4ShopAndStoreReputation component12() {
        return this.storeReputation;
    }

    public final TextElement component13() {
        return this.shopSalesText;
    }

    public final TextWithOneIconElement component14() {
        return this.shopSlogan;
    }

    public final List<TextElement> component15() {
        return this.followAndSellInfo;
    }

    public final TextWithOneIconElement component16() {
        return this.shopIcon;
    }

    public final TextWithOneIconElement component17() {
        return this.shopAvatarIcon;
    }

    public final LongContentLabelComponent component18() {
        return this.rankBanner;
    }

    public final TagsScrollBoxComponent component19() {
        return this.reputationIconsAndFans;
    }

    public final TextWithOneIconElement component2() {
        return this.shopInfo;
    }

    public final LongContentLabelComponent component20() {
        return this.iconList;
    }

    public final TextElement component21() {
        return this.shopDistanceText;
    }

    public final AnchorV4ShopAmbient component22() {
        return this.shopAmbient;
    }

    public final AnchorV4ShopDetailMainInfo component23() {
        return this.shopDetailMainInfo;
    }

    public final boolean component24() {
        return this.shopStructOptimize;
    }

    public final Background component25() {
        return this.basicInfoBg;
    }

    public final MediaBoxElement component26() {
        return this.shopAvatarBorder;
    }

    public final TextWithOneIconElement component27() {
        return this.shopAvatarTag;
    }

    public final TagsScrollBoxComponent component28() {
        return this.shopScoreIcons;
    }

    public final TextWithOneIconElement component29() {
        return this.shopScoreText;
    }

    public final TextWithOneIconElement component3() {
        return this.jumpButton;
    }

    public final IconsWithSpaceElement component4() {
        return this.trustPics;
    }

    public final TextElement component5() {
        return this.ratingScore;
    }

    public final TextElement component6() {
        return this.peersExceeded;
    }

    public final TextElement component7() {
        return this.recommendInfo;
    }

    public final LongContentLabelComponent component8() {
        return this.shopPromotionInfo;
    }

    public final LongContentLabelComponent component9() {
        return this.shopProfile;
    }

    public final AnchorV4ShopAndStoreDisplay copy(MediaBoxElement r310, TextWithOneIconElement r311, TextWithOneIconElement r312, IconsWithSpaceElement r313, TextElement r314, TextElement r315, TextElement r316, LongContentLabelComponent r317, LongContentLabelComponent r410, LongContentLabelComponent r411, Background r412, AnchorV4ShopAndStoreReputation r413, TextElement r414, TextWithOneIconElement r415, List<TextElement> r416, TextWithOneIconElement r417, TextWithOneIconElement r418, LongContentLabelComponent r419, TagsScrollBoxComponent r510, LongContentLabelComponent r511, TextElement r512, AnchorV4ShopAmbient r513, AnchorV4ShopDetailMainInfo r514, boolean r515, Background r516, MediaBoxElement r517, TextWithOneIconElement r518, TagsScrollBoxComponent r519, TextWithOneIconElement r610) {
        return new AnchorV4ShopAndStoreDisplay(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4ShopAndStoreDisplay) == false) goto L64;
        AnchorV4ShopAndStoreDisplay r101 = (AnchorV4ShopAndStoreDisplay) r100;
        if (Intrinsics.areEqual(this.shopAvatar, r101.shopAvatar) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopInfo, r101.shopInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpButton, r101.jumpButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trustPics, r101.trustPics) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.ratingScore, r101.ratingScore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.peersExceeded, r101.peersExceeded) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.shopPromotionInfo, r101.shopPromotionInfo) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopProfile, r101.shopProfile) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shopRecommendTitle, r101.shopRecommendTitle) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shopBackground, r101.shopBackground) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.storeReputation, r101.storeReputation) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shopSalesText, r101.shopSalesText) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.shopSlogan, r101.shopSlogan) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.followAndSellInfo, r101.followAndSellInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.shopIcon, r101.shopIcon) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.shopAvatarIcon, r101.shopAvatarIcon) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.rankBanner, r101.rankBanner) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.reputationIconsAndFans, r101.reputationIconsAndFans) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.iconList, r101.iconList) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.shopDistanceText, r101.shopDistanceText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.shopAmbient, r101.shopAmbient) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.shopDetailMainInfo, r101.shopDetailMainInfo) == true) goto L52;
        return false;
    L52:
        if (this.shopStructOptimize == r101.shopStructOptimize) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.basicInfoBg, r101.basicInfoBg) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.shopAvatarBorder, r101.shopAvatarBorder) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.shopAvatarTag, r101.shopAvatarTag) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.shopScoreIcons, r101.shopScoreIcons) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.shopScoreText, r101.shopScoreText) == true) goto L97;
        return false;
    L97:
        return true;
    L64:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v108 */
    /* JADX WARN: Type inference failed for: r2v67, types: [int] */
    /* JADX WARN: Type inference failed for: r2v85 */
    public int hashCode() {
        MediaBoxElement r100 = this.shopAvatar;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextWithOneIconElement r104 = this.shopInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextWithOneIconElement r107 = this.jumpButton;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IconsWithSpaceElement r110 = this.trustPics;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        TextElement r113 = this.ratingScore;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        TextElement r116 = this.peersExceeded;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        TextElement r119 = this.recommendInfo;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        LongContentLabelComponent r122 = this.shopPromotionInfo;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        LongContentLabelComponent r125 = this.shopProfile;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        LongContentLabelComponent r128 = this.shopRecommendTitle;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Background r131 = this.shopBackground;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        AnchorV4ShopAndStoreReputation r134 = this.storeReputation;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        TextElement r137 = this.shopSalesText;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        TextWithOneIconElement r140 = this.shopSlogan;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        List<TextElement> r143 = this.followAndSellInfo;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        TextWithOneIconElement r146 = this.shopIcon;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        TextWithOneIconElement r149 = this.shopAvatarIcon;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        LongContentLabelComponent r152 = this.rankBanner;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        TagsScrollBoxComponent r155 = this.reputationIconsAndFans;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        LongContentLabelComponent r158 = this.iconList;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        TextElement r161 = this.shopDistanceText;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        AnchorV4ShopAmbient r164 = this.shopAmbient;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        AnchorV4ShopDetailMainInfo r167 = this.shopDetailMainInfo;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        boolean r170 = this.shopStructOptimize;
        ?? r171 = r170;
        if (r170 == false) goto L97;
        r171 = 1;
    L97:
        int r172 = (r169 + r171) * 31;
        Background r173 = this.basicInfoBg;
        if (r173 == null) goto L100;
        int r174 = r173.hashCode();
    L101:
        int r175 = (r172 + r174) * 31;
        MediaBoxElement r176 = this.shopAvatarBorder;
        if (r176 == null) goto L104;
        int r177 = r176.hashCode();
    L105:
        int r178 = (r175 + r177) * 31;
        TextWithOneIconElement r179 = this.shopAvatarTag;
        if (r179 == null) goto L108;
        int r180 = r179.hashCode();
    L109:
        int r181 = (r178 + r180) * 31;
        TagsScrollBoxComponent r182 = this.shopScoreIcons;
        if (r182 == null) goto L112;
        int r183 = r182.hashCode();
    L113:
        int r184 = (r181 + r183) * 31;
        TextWithOneIconElement r185 = this.shopScoreText;
        if (r185 == null) goto L117;
        r101 = r185.hashCode();
    L117:
        return r184 + r101;
    L112:
        r183 = 0;
        goto L113
    L108:
        r180 = 0;
        goto L109
    L104:
        r177 = 0;
        goto L105
    L100:
        r174 = 0;
        goto L101
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
        return "AnchorV4ShopAndStoreDisplay(shopAvatar=" + this.shopAvatar + ", shopInfo=" + this.shopInfo + ", jumpButton=" + this.jumpButton + ", trustPics=" + this.trustPics + ", ratingScore=" + this.ratingScore + ", peersExceeded=" + this.peersExceeded + ", recommendInfo=" + this.recommendInfo + ", shopPromotionInfo=" + this.shopPromotionInfo + ", shopProfile=" + this.shopProfile + ", shopRecommendTitle=" + this.shopRecommendTitle + ", shopBackground=" + this.shopBackground + ", storeReputation=" + this.storeReputation + ", shopSalesText=" + this.shopSalesText + ", shopSlogan=" + this.shopSlogan + ", followAndSellInfo=" + this.followAndSellInfo + ", shopIcon=" + this.shopIcon + ", shopAvatarIcon=" + this.shopAvatarIcon + ", rankBanner=" + this.rankBanner + ", reputationIconsAndFans=" + this.reputationIconsAndFans + ", iconList=" + this.iconList + ", shopDistanceText=" + this.shopDistanceText + ", shopAmbient=" + this.shopAmbient + ", shopDetailMainInfo=" + this.shopDetailMainInfo + ", shopStructOptimize=" + this.shopStructOptimize + ", basicInfoBg=" + this.basicInfoBg + ", shopAvatarBorder=" + this.shopAvatarBorder + ", shopAvatarTag=" + this.shopAvatarTag + ", shopScoreIcons=" + this.shopScoreIcons + ", shopScoreText=" + this.shopScoreText + ")";
    }

    public final Background getBasicInfoBg() {
        return this.basicInfoBg;
    }

    public final List<TextElement> getFollowAndSellInfo() {
        return this.followAndSellInfo;
    }

    public final LongContentLabelComponent getIconList() {
        return this.iconList;
    }

    public final TextWithOneIconElement getJumpButton() {
        return this.jumpButton;
    }

    public final TextElement getPeersExceeded() {
        return this.peersExceeded;
    }

    public final LongContentLabelComponent getRankBanner() {
        return this.rankBanner;
    }

    public final TextElement getRatingScore() {
        return this.ratingScore;
    }

    public final TextElement getRecommendInfo() {
        return this.recommendInfo;
    }

    public final TagsScrollBoxComponent getReputationIconsAndFans() {
        return this.reputationIconsAndFans;
    }

    public final AnchorV4ShopAmbient getShopAmbient() {
        return this.shopAmbient;
    }

    public final MediaBoxElement getShopAvatar() {
        return this.shopAvatar;
    }

    public final MediaBoxElement getShopAvatarBorder() {
        return this.shopAvatarBorder;
    }

    public final TextWithOneIconElement getShopAvatarIcon() {
        return this.shopAvatarIcon;
    }

    public final TextWithOneIconElement getShopAvatarTag() {
        return this.shopAvatarTag;
    }

    public final Background getShopBackground() {
        return this.shopBackground;
    }

    public final AnchorV4ShopDetailMainInfo getShopDetailMainInfo() {
        return this.shopDetailMainInfo;
    }

    public final TextElement getShopDistanceText() {
        return this.shopDistanceText;
    }

    public final TextWithOneIconElement getShopIcon() {
        return this.shopIcon;
    }

    public final TextWithOneIconElement getShopInfo() {
        return this.shopInfo;
    }

    public final LongContentLabelComponent getShopProfile() {
        return this.shopProfile;
    }

    public final LongContentLabelComponent getShopPromotionInfo() {
        return this.shopPromotionInfo;
    }

    public final LongContentLabelComponent getShopRecommendTitle() {
        return this.shopRecommendTitle;
    }

    public final TextElement getShopSalesText() {
        return this.shopSalesText;
    }

    public final TagsScrollBoxComponent getShopScoreIcons() {
        return this.shopScoreIcons;
    }

    public final TextWithOneIconElement getShopScoreText() {
        return this.shopScoreText;
    }

    public final TextWithOneIconElement getShopSlogan() {
        return this.shopSlogan;
    }

    public final boolean getShopStructOptimize() {
        return this.shopStructOptimize;
    }

    public final AnchorV4ShopAndStoreReputation getStoreReputation() {
        return this.storeReputation;
    }

    public final IconsWithSpaceElement getTrustPics() {
        return this.trustPics;
    }

    public AnchorV4ShopAndStoreDisplay(MediaBoxElement r100, TextWithOneIconElement r101, TextWithOneIconElement r102, IconsWithSpaceElement r103, TextElement r104, TextElement r105, TextElement r106, LongContentLabelComponent r110, LongContentLabelComponent r111, LongContentLabelComponent r112, Background r113, AnchorV4ShopAndStoreReputation r114, TextElement r115, TextWithOneIconElement r116, List<TextElement> r117, TextWithOneIconElement r118, TextWithOneIconElement r119, LongContentLabelComponent r210, TagsScrollBoxComponent r211, LongContentLabelComponent r212, TextElement r213, AnchorV4ShopAmbient r214, AnchorV4ShopDetailMainInfo r215, boolean r216, Background r217, MediaBoxElement r218, TextWithOneIconElement r219, TagsScrollBoxComponent r310, TextWithOneIconElement r311) {
        this.shopAvatar = r100;
        this.shopInfo = r101;
        this.jumpButton = r102;
        this.trustPics = r103;
        this.ratingScore = r104;
        this.peersExceeded = r105;
        this.recommendInfo = r106;
        this.shopPromotionInfo = r110;
        this.shopProfile = r111;
        this.shopRecommendTitle = r112;
        this.shopBackground = r113;
        this.storeReputation = r114;
        this.shopSalesText = r115;
        this.shopSlogan = r116;
        this.followAndSellInfo = r117;
        this.shopIcon = r118;
        this.shopAvatarIcon = r119;
        this.rankBanner = r210;
        this.reputationIconsAndFans = r211;
        this.iconList = r212;
        this.shopDistanceText = r213;
        this.shopAmbient = r214;
        this.shopDetailMainInfo = r215;
        this.shopStructOptimize = r216;
        this.basicInfoBg = r217;
        this.shopAvatarBorder = r218;
        this.shopAvatarTag = r219;
        this.shopScoreIcons = r310;
        this.shopScoreText = r311;
    }

    public /* synthetic */ AnchorV4ShopAndStoreDisplay(MediaBoxElement r310, TextWithOneIconElement r311, TextWithOneIconElement r312, IconsWithSpaceElement r313, TextElement r314, TextElement r315, TextElement r316, LongContentLabelComponent r317, LongContentLabelComponent r318, LongContentLabelComponent r410, Background r411, AnchorV4ShopAndStoreReputation r412, TextElement r413, TextWithOneIconElement r414, List r415, TextWithOneIconElement r416, TextWithOneIconElement r417, LongContentLabelComponent r418, TagsScrollBoxComponent r419, LongContentLabelComponent r510, TextElement r511, AnchorV4ShopAmbient r512, AnchorV4ShopDetailMainInfo r513, boolean r514, Background r515, MediaBoxElement r516, TextWithOneIconElement r517, TagsScrollBoxComponent r518, TextWithOneIconElement r519, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        MediaBoxElement r100 = null;
    L7:
        if ((r610 & 2) == 0) goto L9;
        TextWithOneIconElement r101 = null;
    L11:
        if ((r610 & 4) == 0) goto L13;
        TextWithOneIconElement r102 = null;
    L15:
        if ((r610 & 8) == 0) goto L17;
        IconsWithSpaceElement r103 = null;
    L19:
        if ((r610 & 16) == 0) goto L21;
        TextElement r104 = null;
    L23:
        if ((r610 & 32) == 0) goto L25;
        TextElement r105 = null;
    L27:
        if ((r610 & 64) == 0) goto L29;
        TextElement r106 = null;
    L31:
        if ((r610 & 128) == 0) goto L33;
        LongContentLabelComponent r107 = null;
    L35:
        if ((r610 & 256) == 0) goto L37;
        LongContentLabelComponent r110 = null;
    L39:
        if ((r610 & 512) == 0) goto L41;
        LongContentLabelComponent r111 = null;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        Background r112 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        AnchorV4ShopAndStoreReputation r113 = null;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        TextElement r114 = null;
    L55:
        if ((r610 & 8192) == 0) goto L57;
        TextWithOneIconElement r115 = null;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r610 & 32768) == 0) goto L65;
        TextWithOneIconElement r116 = null;
    L67:
        if ((r610 & 65536) == 0) goto L69;
        TextWithOneIconElement r117 = null;
    L71:
        if ((r610 & 131072) == 0) goto L73;
        LongContentLabelComponent r118 = null;
    L75:
        if ((r610 & 262144) == 0) goto L77;
        TagsScrollBoxComponent r119 = null;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        LongContentLabelComponent r210 = null;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        TextElement r211 = null;
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        AnchorV4ShopAmbient r212 = null;
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        AnchorV4ShopDetailMainInfo r213 = null;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        boolean r214 = false;
    L99:
        if ((r610 & 16777216) == 0) goto L101;
        Background r215 = null;
    L103:
        if ((r610 & 33554432) == 0) goto L105;
        MediaBoxElement r216 = null;
    L107:
        if ((r610 & 67108864) == 0) goto L109;
        TextWithOneIconElement r217 = null;
    L111:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        TagsScrollBoxComponent r218 = null;
    L115:
        if ((r610 & 268435456) == 0) goto L117;
        TextWithOneIconElement r109 = null;
    L118:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r109);
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
        r115 = r414;
        goto L59
    L53:
        r114 = r413;
        goto L55
    L49:
        r113 = r412;
        goto L51
    L45:
        r112 = r411;
        goto L47
    L41:
        r111 = r410;
        goto L43
    L37:
        r110 = r318;
        goto L39
    L33:
        r107 = r317;
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
