package com.bytedance.android.ec.store.repository.dto;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.connect.share.QzonePublish;
import com.tencent.open.SocialConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import im.v;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\buw#r\u0083\u0001\u0085\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\rR\u001c\u0010'\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\rR\u001c\u0010)\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\rR\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001c\u00100\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00105\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010\u001fR\u001c\u00107\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010\u001fR\u001c\u0010>\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010\u0018R\u001c\u0010@\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006R\u001c\u0010B\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\u0016\u001a\u0004\bC\u0010\u0018R0\u0010F\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020E\u0018\u00010\u001b\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR2\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010I\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u0016\u001a\u0004\bO\u0010\u0018R\u001c\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0006R\u001c\u0010R\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bR\u0010\u0016\u001a\u0004\bS\u0010\u0018R\"\u0010U\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\u001d\u001a\u0004\bV\u0010\u001fR\u001c\u0010X\u001a\u0004\u0018\u00010W8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u001c\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\u0004\u001a\u0004\b]\u0010\u0006R\u001c\u0010_\u001a\u0004\u0018\u00010^8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001c\u0010g\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bg\u00108\u001a\u0004\bh\u0010:R\u001c\u0010i\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006R\u001c\u0010k\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010\u0004\u001a\u0004\bl\u0010\u0006R\"\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bm\u0010\u001d\u001a\u0004\bn\u0010\u001fR\u001c\u0010p\u001a\u0004\u0018\u00010o8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bt\u0010\u0004\u001a\u0004\bu\u0010\u0006R\u001c\u0010v\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bv\u0010\u0004\u001a\u0004\bw\u0010\u0006R\u001c\u0010x\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\bx\u0010\u0016\u001a\u0004\by\u0010\u0018R\u001c\u0010{\u001a\u0004\u0018\u00010z8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R%\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u007f\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u001d\u001a\u0005\b\u0081\u0001\u0010\u001fR\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0004\u001a\u0005\b\u0083\u0001\u0010\u0006R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006R\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010\u0004\u001a\u0005\b\u0087\u0001\u0010\u0006R\u001f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0004\u001a\u0005\b\u0089\u0001\u0010\u0006R\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R,\u0010\u0090\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u008f\u0001\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010G\u001a\u0005\b\u0091\u0001\u0010IR\"\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R%\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010\u001d\u001a\u0005\b\u009d\u0001\u0010\u001fR)\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\b\u009e\u0001\u0010\u0004\u001a\u0005\b\u009f\u0001\u0010\u0006\"\u0006\b \u0001\u0010¡\u0001R\"\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010§\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b§\u0001\u0010\u000b\u001a\u0005\b¨\u0001\u0010\rR,\u0010ª\u0001\u001a\u0005\u0018\u00010©\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001¨\u0006°\u0001"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l;", "", "", "productId", "Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/String;", "promotionId", "B", "", "promotionSource", "Ljava/lang/Long;", "C", "()Ljava/lang/Long;", "name", "s", "middleTitle", "r", "shortTitle", "getShortTitle", "", "goodType", "Ljava/lang/Integer;", "l", "()Ljava/lang/Integer;", "source", "K", "", "imgUrlList", "Ljava/util/List;", OfficeSDKRequestTag.KEY_NEW_USER, "()Ljava/util/List;", "", "canScroll", "Z", "c", "()Z", "price", BaseSwitches.V, "marketPrice", "getMarketPrice", "sellNum", "G", "videoId", "Q", "videoUrl", "getVideoUrl", "", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "Ljava/lang/Float;", "getVideoDuration", "()Ljava/lang/Float;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionDiscountLabel;", "discountLabel", RXScreenCaptureService.KEY_INDEX, "isSecKill", "Ljava/lang/Boolean;", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Boolean;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "platformTextActivity", "t", "status", "L", "storeUrl", "getStoreUrl", "stockStatus", "M", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "ritTag", "Ljava/util/Map;", "D", "()Ljava/util/Map;", "logExtra", "p", "setLogExtra", "(Ljava/util/Map;)V", "skuType", "J", "pricePrefix", "w", "pricePrefixType", "x", "Lcom/bytedance/android/ec/store/repository/dto/l$e;", "recommendInfoList", "getRecommendInfoList", "Lcom/bytedance/android/ec/store/repository/dto/l$b;", "currentStatus", "Lcom/bytedance/android/ec/store/repository/dto/l$b;", ce.f26391f, "()Lcom/bytedance/android/ec/store/repository/dto/l$b;", "jumpUrl", "getJumpUrl", "Lim/v;", "liveInfo", "Lim/v;", "o", "()Lim/v;", "storeLogo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getStoreLogo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "hideSales", "m", "saleText", ExifInterface.LONGITUDE_EAST, "detailUrl", "h", "verticalImgUrlList", "P", "Lcom/bytedance/android/ec/store/repository/dto/b;", "cartCtrlInfo", "Lcom/bytedance/android/ec/store/repository/dto/b;", "d", "()Lcom/bytedance/android/ec/store/repository/dto/b;", "buyingTrack", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cBizCombo", "b", "showType", FaceService.neutralLabel, "Lcom/bytedance/android/ec/store/repository/dto/MarketingDataDTO;", "marketingData", "Lcom/bytedance/android/ec/store/repository/dto/MarketingDataDTO;", "q", "()Lcom/bytedance/android/ec/store/repository/dto/MarketingDataDTO;", "Lcom/bytedance/android/ec/store/repository/dto/l$f;", "cardLabelInfoList", "getCardLabelInfoList", RemoteMessageConst.Notification.CHANNEL_ID, "e", "channelType", "f", "preProductInfo", "u", "refreshParam", "getRefreshParam", "Lcom/bytedance/android/ec/store/repository/dto/n;", "videoInfo", "Lcom/bytedance/android/ec/store/repository/dto/n;", "R", "()Lcom/bytedance/android/ec/store/repository/dto/n;", "Lcom/bytedance/android/ec/store/repository/vo/ECTagListDTO;", "tagListMap", "N", "Lcom/bytedance/android/ec/store/repository/dto/i;", "skuInfo", "Lcom/bytedance/android/ec/store/repository/dto/i;", "I", "()Lcom/bytedance/android/ec/store/repository/dto/i;", "Lcom/bytedance/android/ec/store/repository/dto/l$d;", "dividerLine", "Lcom/bytedance/android/ec/store/repository/dto/l$d;", ce.f26395j, "()Lcom/bytedance/android/ec/store/repository/dto/l$d;", "productCardBackgroundColor", "y", "schema", FaceService.girlLabel, "setSchema", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/store/repository/dto/o;", "timeSaleInfo", "Lcom/bytedance/android/ec/store/repository/dto/o;", "O", "()Lcom/bytedance/android/ec/store/repository/dto/o;", "productCardType", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Lcom/bytedance/android/ec/store/repository/dto/l$c;", "extendInfo", "Lcom/bytedance/android/ec/store/repository/dto/l$c;", ce.f26396k, "()Lcom/bytedance/android/ec/store/repository/dto/l$c;", "setExtendInfo", "(Lcom/bytedance/android/ec/store/repository/dto/l$c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class l {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BUYIN_TRACK)
    private final String buyingTrack;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_C_BIZ_COMBO)
    private final String cBizCombo;

    @SerializedName("scroll_ctrl")
    private final boolean canScroll;

    @SerializedName("card_label_info")
    private final List<f> cardLabelInfoList;

    @SerializedName("cart_ctrl")
    private final com.bytedance.android.ec.store.repository.dto.b cartCtrlInfo;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final String channelType;

    @SerializedName("current_status")
    private final b currentStatus;

    @SerializedName(alternate = {"good_detail_schema"}, value = "detail_url")
    private final String detailUrl;

    @SerializedName("discount_label")
    private final List<PromotionDiscountLabel> discountLabel;

    @SerializedName("divider_line")
    private final d dividerLine;

    @SerializedName("extend_info")
    private c extendInfo;

    @SerializedName("good_type")
    private final Integer goodType;

    @SerializedName("hide_sales")
    private final Boolean hideSales;

    @SerializedName("img_url_list")
    private final List<String> imgUrlList;

    @SerializedName("is_sec_kill")
    private final Boolean isSecKill;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("live_info")
    private final v liveInfo;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("market_price")
    private final Long marketPrice;

    @SerializedName("marketing_data")
    private final MarketingDataDTO marketingData;

    @SerializedName("middle_title")
    private final String middleTitle;

    @SerializedName("name")
    private final String name;

    @SerializedName("platform_text_activity")
    private final List<ECUrlModel> platformTextActivity;

    @SerializedName("pre_product_info")
    private final String preProductInfo;

    @SerializedName("price")
    private final Long price;

    @SerializedName("price_header")
    private final String pricePrefix;

    @SerializedName("price_header_type")
    private final Integer pricePrefixType;

    @SerializedName("product_card_background_color")
    private final List<String> productCardBackgroundColor;

    @SerializedName("product_card_type")
    private final Long productCardType;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final Long promotionSource;

    @SerializedName("recommend_infos")
    private final List<e> recommendInfoList;

    @SerializedName("refresh_param")
    private final String refreshParam;

    @SerializedName("rit_tag")
    private final Map<String, List<ECRitTag>> ritTag;

    @SerializedName("sale_text")
    private final String saleText;

    @SerializedName("schema")
    private String schema;

    @SerializedName("sell_num")
    private final Long sellNum;

    @SerializedName("short_title")
    private final String shortTitle;

    @SerializedName("show_type")
    private final Integer showType;

    @SerializedName("sku_info")
    private final i skuInfo;

    @SerializedName("sku_type")
    private final Integer skuType;

    @SerializedName("source")
    private final String source;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("stock_status")
    private final Integer stockStatus;

    @SerializedName("shop_icon")
    private final ECUrlModel storeLogo;

    @SerializedName("store_url")
    private final String storeUrl;

    @SerializedName("tag_list_map")
    private final Map<String, ECTagListDTO> tagListMap;

    @SerializedName("timing_sale")
    private final o timeSaleInfo;

    @SerializedName("vertical_img_url_list")
    private final List<String> verticalImgUrlList;

    @SerializedName("main_video_duration")
    private final Float videoDuration;

    @SerializedName("video_id")
    private final String videoId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_VIDEO_INFO)
    private final n videoInfo;

    @SerializedName("main_video_url")
    private final String videoUrl;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$b;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "label", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("status_label")
        private final ECUrlModel label;

        @SerializedName("status_text")
        private final String text;

        @SerializedName("status_type")
        private final Integer type;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L12;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.label, r101.label) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r100 = this.label;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.type;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.text;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CurrentStatusInfo(label=" + this.label + ", type=" + this.type + ", text=" + this.text + ")";
        }

        public final boolean c() {
            Integer r100 = this.type;
            if (r100 != null) goto L6;
        L7:
            Integer r101 = this.type;
            if (r101 != null) goto L11;
        L12:
            Integer r102 = this.type;
            if (r102 != null) goto L16;
        L18:
            return false;
        L16:
            if (r102.intValue() != 2) goto L18;
            return true;
        L11:
            if (r101.intValue() != 6) goto L12;
            return true;
        L6:
            if (r100.intValue() != 1) goto L7;
            return true;
        }

        public final String d() {
            Integer r100 = this.type;
            if (r100 != null) goto L6;
        L8:
            if (r100 != null) goto L11;
        L13:
            if (r100 != null) goto L16;
        L18:
            if (r100 != null) goto L21;
        L23:
            if (r100 != null) goto L26;
        L28:
            if (r100 != null) goto L31;
        L33:
            return "";
        L31:
            if (r100.intValue() != 5) goto L33;
            return "video_upload";
        L26:
            if (r100.intValue() != 4) goto L28;
            return "video_cart";
        L21:
            if (r100.intValue() != 3) goto L23;
            return "video_explain";
        L16:
            if (r100.intValue() != 2) goto L18;
            return "live_explain";
        L11:
            if (r100.intValue() != 6) goto L13;
        L12:
            return "live_cart";
        L6:
            if (r100.intValue() != 1) goto L8;
            goto L8
        }

        public b() {
            this.label = null;
            this.type = null;
            this.text = null;
        }

        public final ECUrlModel a() {
            return this.label;
        }

        public final String b() {
            return this.text;
        }

        public final Integer getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$c;", "", "", "clientTagListMap", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setClientTagListMap", "(Ljava/lang/String;)V", "", "isNotNeedChangeDetailUrl", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setNotNeedChangeDetailUrl", "(Ljava/lang/Integer;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("client_tag_list_map")
        private String clientTagListMap;

        @SerializedName("is_not_need_change_detail_url")
        private Integer isNotNeedChangeDetailUrl;

        public c() {
            this.clientTagListMap = null;
            this.isNotNeedChangeDetailUrl = 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.clientTagListMap, r101.clientTagListMap) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.isNotNeedChangeDetailUrl, r101.isNotNeedChangeDetailUrl) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.clientTagListMap;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.isNotNeedChangeDetailUrl;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ExtendInfo(clientTagListMap=" + this.clientTagListMap + ", isNotNeedChangeDetailUrl=" + this.isNotNeedChangeDetailUrl + ")";
        }

        public final String a() {
            return this.clientTagListMap;
        }

        public final Integer b() {
            return this.isNotNeedChangeDetailUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$d;", "", "", "color", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("color")
        private final String color;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.color, ((d) r100).color) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.color;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "ProductDividerLineConfig(color=" + this.color + ")";
        }

        public d() {
            this.color = null;
        }

        public final String a() {
            return this.color;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$e;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icons", "Ljava/util/List;", "getIcons", "()Ljava/util/List;", "", "reason", "Ljava/lang/Integer;", "getReason", "()Ljava/lang/Integer;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("recommend_string")
        private final String desc;

        @SerializedName("icons")
        private final List<ECUrlModel> icons;

        @SerializedName("recommend_reason")
        private final Integer reason;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L12;
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.icons, r101.icons) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.desc;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<ECUrlModel> r104 = this.icons;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.reason;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ProductRecommendInfo(desc=" + this.desc + ", icons=" + this.icons + ", reason=" + this.reason + ")";
        }

        public e() {
            this.desc = null;
            this.icons = null;
            this.reason = null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$f;", "", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/store/repository/dto/l$f$b;", "imageLabel", "Lcom/bytedance/android/ec/store/repository/dto/l$f$b;", "getImageLabel", "()Lcom/bytedance/android/ec/store/repository/dto/l$f$b;", "schema", "getSchema", "elementId", "getElementId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f {

        @SerializedName("ui_element_id")
        private final String elementId;

        @SerializedName("image_info")
        private final b imageLabel;

        @SerializedName("label")
        private final String label;

        @SerializedName("jump_url")
        private final String schema;

        @SerializedName("type")
        private final Integer type;

        public static final class a {
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$f$b;", "", "", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "Ljava/util/List;", "getGravity", "()Ljava/util/List;", "Lcom/bytedance/android/ec/store/repository/dto/l$f$c;", GXTemplateKey.FLEXBOX_MARGIN, "Lcom/bytedance/android/ec/store/repository/dto/l$f$c;", "getMargin", "()Lcom/bytedance/android/ec/store/repository/dto/l$f$c;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Map<String, Integer> f48392a = null;

            @SerializedName(GXTemplateKey.GAIAX_LAYER_GRAVITY)
            private final List<String> gravity;

            @SerializedName("image")
            private final ECUrlModel image;

            @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
            private final c margin;

            public static final class a {
            }

            static {
                f48392a = MapsKt.mapOf(new Pair[]{TuplesKt.to("left", 3), TuplesKt.to("top", 48), TuplesKt.to("right", 5), TuplesKt.to("bottom", 80), TuplesKt.to("center_vertical", 16), TuplesKt.to("center_horizontal", 1)});
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/store/repository/dto/l$f$c;", "", "", "marginLeft", "I", "getMarginLeft", "()I", "marginTop", "getMarginTop", "marginRight", "getMarginRight", "marginBottom", "getMarginBottom", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class c {

            @SerializedName("bottom")
            private final int marginBottom;

            @SerializedName("left")
            private final int marginLeft;

            @SerializedName("right")
            private final int marginRight;

            @SerializedName("top")
            private final int marginTop;

            public c() {
                this.marginLeft = 0;
                this.marginTop = 0;
                this.marginRight = 0;
                this.marginBottom = 0;
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L16;
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.label, r101.label) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.imageLabel, r101.imageLabel) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.elementId, r101.elementId) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            Integer r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.label;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            b r107 = this.imageLabel;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.schema;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.elementId;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
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

        public final String toString() {
            return "StoreCardHeaderLabelInfo(type=" + this.type + ", label=" + this.label + ", imageLabel=" + this.imageLabel + ", schema=" + this.schema + ", elementId=" + this.elementId + ")";
        }

        public f() {
            this.type = null;
            this.label = null;
            this.imageLabel = null;
            this.schema = null;
            this.elementId = null;
        }

        public final Integer getType() {
            return this.type;
        }
    }

    static {
    }

    public l() {
        List<String> r100 = CollectionsKt.emptyList();
        List<String> r101 = CollectionsKt.emptyList();
        this.productId = "";
        this.promotionId = null;
        this.promotionSource = null;
        this.name = "";
        this.middleTitle = "";
        this.shortTitle = "";
        this.goodType = 0;
        this.source = "";
        this.imgUrlList = r100;
        this.canScroll = false;
        this.price = 0L;
        this.marketPrice = null;
        this.sellNum = 0L;
        this.videoId = null;
        this.videoUrl = null;
        this.videoDuration = null;
        this.discountLabel = null;
        this.isSecKill = null;
        this.platformTextActivity = null;
        this.status = null;
        this.storeUrl = null;
        this.stockStatus = null;
        this.ritTag = null;
        this.logExtra = null;
        this.skuType = null;
        this.pricePrefix = null;
        this.pricePrefixType = null;
        this.recommendInfoList = null;
        this.currentStatus = null;
        this.jumpUrl = null;
        this.liveInfo = null;
        this.storeLogo = null;
        this.hideSales = null;
        this.saleText = null;
        this.detailUrl = null;
        this.verticalImgUrlList = r101;
        this.cartCtrlInfo = null;
        this.buyingTrack = null;
        this.cBizCombo = null;
        this.showType = null;
        this.marketingData = null;
        this.cardLabelInfoList = null;
        this.channelId = null;
        this.channelType = null;
        this.preProductInfo = null;
        this.refreshParam = null;
        this.videoInfo = null;
        this.tagListMap = null;
        this.skuInfo = null;
        this.dividerLine = null;
        this.productCardBackgroundColor = null;
        this.schema = null;
        this.timeSaleInfo = null;
        this.productCardType = 0L;
        this.extendInfo = null;
    }

    public final String A() {
        return this.productId;
    }

    public final String B() {
        return this.promotionId;
    }

    public final Long C() {
        return this.promotionSource;
    }

    public final Map<String, List<ECRitTag>> D() {
        return this.ritTag;
    }

    public final String E() {
        return this.saleText;
    }

    public final String F() {
        return this.schema;
    }

    public final Long G() {
        return this.sellNum;
    }

    public final Integer H() {
        return this.showType;
    }

    public final i I() {
        return this.skuInfo;
    }

    public final Integer J() {
        return this.skuType;
    }

    public final String K() {
        return this.source;
    }

    public final Integer L() {
        return this.status;
    }

    public final Integer M() {
        return this.stockStatus;
    }

    public final Map<String, ECTagListDTO> N() {
        return this.tagListMap;
    }

    public final o O() {
        return this.timeSaleInfo;
    }

    public final List<String> P() {
        return this.verticalImgUrlList;
    }

    public final String Q() {
        return this.videoId;
    }

    public final n R() {
        return this.videoInfo;
    }

    public final Boolean S() {
        return this.isSecKill;
    }

    public final String a() {
        return this.buyingTrack;
    }

    public final String b() {
        return this.cBizCombo;
    }

    public final boolean c() {
        return this.canScroll;
    }

    public final com.bytedance.android.ec.store.repository.dto.b d() {
        return this.cartCtrlInfo;
    }

    public final String e() {
        return this.channelId;
    }

    public final String f() {
        return this.channelType;
    }

    public final b g() {
        return this.currentStatus;
    }

    public final String h() {
        return this.detailUrl;
    }

    public final List<PromotionDiscountLabel> i() {
        return this.discountLabel;
    }

    public final d j() {
        return this.dividerLine;
    }

    public final c k() {
        return this.extendInfo;
    }

    public final Integer l() {
        return this.goodType;
    }

    public final Boolean m() {
        return this.hideSales;
    }

    public final List<String> n() {
        return this.imgUrlList;
    }

    public final v o() {
        return this.liveInfo;
    }

    public final Map<String, String> p() {
        return this.logExtra;
    }

    public final MarketingDataDTO q() {
        return this.marketingData;
    }

    public final String r() {
        return this.middleTitle;
    }

    public final String s() {
        return this.name;
    }

    public final List<ECUrlModel> t() {
        return this.platformTextActivity;
    }

    public final String u() {
        return this.preProductInfo;
    }

    public final Long v() {
        return this.price;
    }

    public final String w() {
        return this.pricePrefix;
    }

    public final Integer x() {
        return this.pricePrefixType;
    }

    public final List<String> y() {
        return this.productCardBackgroundColor;
    }

    public final Long z() {
        return this.productCardType;
    }
}
