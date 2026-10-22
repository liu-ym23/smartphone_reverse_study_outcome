package com.bytedance.android.shopping.anchorv3.repository.api;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.anchorv3.repository.dto.AppointmentResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.DepositPresaleAppointResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.GroupInfoResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PreviewLikeListResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PreviewWillListResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionAutoApplyCouponResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionProductDetailResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.SearchSuggestWordResponse;
import com.bytedance.android.shopping.anchorv4.dto.business.ShopGuideInfoResponse;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.utils.k;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import jd3.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001cJÿ\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0016\b\u0003\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\"H'¢\u0006\u0004\b&\u0010'Jó\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0016\b\u0003\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b(\u0010)Jb\u00100\u001a\b\u0012\u0004\u0012\u00020/0$2\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u00022\u0016\b\u0003\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001eH'J\u008f\u0001\u00106\u001a\b\u0012\u0004\u0012\u0002050$2\b\b\u0001\u00101\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010,\u001a\u00020\u000e2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00102\u001a\u0004\u0018\u00010\u000e2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u00104\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b6\u00107JB\u0010<\u001a\b\u0012\u0004\u0012\u00020;0$2\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u00108\u001a\u00020\u000e2\b\b\u0001\u00109\u001a\u00020\u000e2\b\b\u0001\u00102\u001a\u00020\u000e2\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u0002H'Jp\u0010@\u001a\b\u0012\u0004\u0012\u00020?0$2\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u00101\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u00022\n\b\u0001\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010,\u001a\u00020\u000e2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0002H'J0\u0010B\u001a\b\u0012\u0004\u0012\u00020?0$2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0001\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001eH'Jk\u0010I\u001a\b\u0012\u0004\u0012\u00020H0$2\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010C\u001a\u00020\u00022\b\b\u0001\u0010E\u001a\u00020D2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\n\b\u0001\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010G\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\bI\u0010JJ@\u0010L\u001a\b\u0012\u0004\u0012\u00020K0$2\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u0002H'J\u008b\u0001\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0$2\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0016\b\u0003\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\n\b\u0003\u0010M\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010N\u001a\u0004\u0018\u00010\u000e2\b\b\u0003\u0010O\u001a\u00020\u000e2\n\b\u0003\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010G\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\bQ\u0010RJ@\u0010T\u001a\b\u0012\u0004\u0012\u00020S0$2\b\b\u0001\u0010-\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u001c\u001a\u00020\u0002H'J$\u0010V\u001a\b\u0012\u0004\u0012\u00020U0$2\u0014\b\u0001\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001eH'J0\u0010X\u001a\b\u0012\u0004\u0012\u00020S0$2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010W\u001a\u00020\u000eH'JV\u0010_\u001a\b\u0012\u0004\u0012\u00020^0$2\n\b\u0003\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010[\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\\\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010]\u001a\u0004\u0018\u00010\u0002H'J\u0018\u0010b\u001a\b\u0012\u0004\u0012\u00020a0$2\b\b\u0003\u0010`\u001a\u00020\u000eH'¨\u0006d"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3Api;", "", "", "userId", "userOpenId", "secUsrId", "", "promotionIds", "itemId", "secAuthorId", "enterFrom", "metaParam", "authorId", "authorOpenId", "", "width", "height", "rankId", "internalFeedAB", "sourceType", "qianChuanAb", "useNewPrice", "cpsTrack", "addressId", "marketChannel", "gpsOn", "productId", "creativeId", "promotionId", "inflowMetaParam", "", "fieldMap", "videoPageSource", "sameProductScene", "", "isPreloadReq", "Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionPackResponse;", "getShopPromotion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "getShopPromotionInner", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "accordingProductId", "source", "type", "roomId", "videoId", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionRecommendResponse;", "getShopPromotionRecommend", "awemeId", "itemType", "pageSource", "extraInfo", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PreviewWillListResponse;", "shopWillList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "scene", "action", "commissionInfo", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PreviewLikeListResponse;", "shopLikeList", "kolId", "secKolId", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/AppointmentResponse;", "appointPromotion", "queryParams", "appointPromotionWithParams", "shopId", "", "price", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionAutoApplyCouponResponse;", "applyCouponAuto", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/GroupInfoResponse;", "getGroupInfo", "tagGuaranteeHeader", "pdpNewEdition", "isShortScreen", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/PromotionProductDetailResponse;", "getPromotionDetail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "depositPresaleAppointPromotion", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/DepositPresaleAppointResponse;", "depositPresaleAppointWithParams", "reportType", "reportTrackParams", "businessId", "pd", "categoryName", "wordSource", "penetrateParams", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/SearchSuggestWordResponse;", "getSearchSuggestWords", "caller", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ShopGuideInfoResponse;", "getShopGuideIdAnchorV3", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface AnchorV3Api {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f165264a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnchorV3Api f165265a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f165266b = null;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3Api$a$a, reason: collision with other inner class name */
        public static final class C2513a implements Observer<AppointmentResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function2 f165267a;

            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "e");
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable r100) {
                Intrinsics.checkNotNullParameter(r100, "d");
            }

            public C2513a(Function2 r100) {
                this.f165267a = r100;
            }

            @Override // io.reactivex.Observer
            public final void onNext(AppointmentResponse r100) {
                AppointmentResponse r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "t");
                if (r101.getStatusCode() != 0) goto L5;
                this.f165267a.invoke(Boolean.TRUE, r101.getAppointToast());
                return;
            L5:
                this.f165267a.invoke(Boolean.FALSE, r101.getAppointToast());
                t r102 = new t();
                r102.f498466a.put("type", UploadTypeInf.API_ERROR);
                r102.f498471f = UploadTypeInf.API_ERROR;
                r102.f498466a.put("api_path", "/aweme/v1/promotion/appoint/");
                r102.f498470e = "/aweme/v1/promotion/appoint/";
                Integer r103 = Integer.valueOf(r101.getStatusCode());
                if (r103 == null) goto L8;
                int r104 = r103.intValue();
                r102.f498466a.put("status_code", r104);
                r102.f498469d = Integer.valueOf(r104);
            L8:
                r102.a();
            }
        }

        public static final class b implements Observer<AppointmentResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function3 f165268a;

            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable r100) {
                Intrinsics.checkNotNullParameter(r100, "d");
            }

            public b(Function3 r100) {
                this.f165268a = r100;
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "e");
                this.f165268a.invoke(Boolean.FALSE, "", null);
            }

            @Override // io.reactivex.Observer
            public final void onNext(AppointmentResponse r100) {
                AppointmentResponse r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "t");
                if (r101.getStatusCode() != 0) goto L5;
                this.f165268a.invoke(Boolean.TRUE, r101.getAppointToast(), r101);
                return;
            L5:
                this.f165268a.invoke(Boolean.FALSE, r101.getAppointToast(), r101);
                t r102 = new t();
                r102.f498466a.put("type", UploadTypeInf.API_ERROR);
                r102.f498471f = UploadTypeInf.API_ERROR;
                r102.f498466a.put("api_path", "/aweme/v1/promotion/appoint/");
                r102.f498470e = "/aweme/v1/promotion/appoint/";
                Integer r103 = Integer.valueOf(r101.getStatusCode());
                if (r103 == null) goto L8;
                int r104 = r103.intValue();
                r102.f498466a.put("status_code", r104);
                r102.f498469d = Integer.valueOf(r104);
            L8:
                r102.a();
            }
        }

        public static final class c implements Observer<CommerceBaseResponse> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1 f165269a;

            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "e");
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable r100) {
                Intrinsics.checkNotNullParameter(r100, "d");
            }

            public c(Function1 r100) {
                this.f165269a = r100;
            }

            @Override // io.reactivex.Observer
            public final void onNext(CommerceBaseResponse r100) {
                CommerceBaseResponse r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "t");
                if (r101.getStatusCode() != 0) goto L5;
                this.f165269a.invoke(Boolean.TRUE);
                return;
            L5:
                this.f165269a.invoke(Boolean.FALSE);
            }
        }

        public a() {
        }

        static {
            f165266b = new a();
            f165265a = (AnchorV3Api) n.f48128a.create(k.a(), AnchorV3Api.class);
        }

        public static void d(Map r100, Function3 r101) {
            Intrinsics.checkNotNullParameter(r100, "requestParams");
            Intrinsics.checkNotNullParameter(r101, "onResult");
            AnchorV3Api r102 = f165265a;
            if (r102 == null) goto L12;
            Observable<AppointmentResponse> r103 = r102.appointPromotionWithParams(r.f48132a.getCurrentUserId(), r100);
            if (r103 == null) goto L13;
            Observable<AppointmentResponse> r104 = r103.subscribeOn(Schedulers.io());
            if (r104 == null) goto L14;
            Observable<AppointmentResponse> r105 = r104.observeOn(AndroidSchedulers.mainThread());
            if (r105 == null) goto L15;
            r105.subscribe(new b(r101));
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }

        public static Observable f(String r100, String r101, String r102, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "itemId");
            Intrinsics.checkNotNullParameter(r101, "secAuthorId");
            Intrinsics.checkNotNullParameter(r102, "promotionId");
            Intrinsics.checkNotNullParameter(r110, "metaParam");
            Intrinsics.checkNotNullParameter(r111, "enterFrom");
            AnchorV3Api r103 = f165265a;
            if (r103 == null) goto L7;
            Observable<GroupInfoResponse> r104 = r103.getGroupInfo(r100, r101, r102, r110, r111);
            if (r104 == null) goto L7;
            return r104;
        L7:
            return Observable.error(new Throwable());
        }

        public static void e(String r100, String r101, String r102, String r110, String r111, Function1 r112) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "authorId");
            Intrinsics.checkNotNullParameter(r102, "productId");
            Intrinsics.checkNotNullParameter(r110, "enterFrom");
            Intrinsics.checkNotNullParameter(r111, "promotionId");
            Intrinsics.checkNotNullParameter(r112, "onResult");
            AnchorV3Api r103 = f165265a;
            if (r103 == null) goto L12;
            Observable<CommerceBaseResponse> r104 = r103.depositPresaleAppointPromotion(r100, r101, r102, r110, r111);
            if (r104 == null) goto L13;
            Observable<CommerceBaseResponse> r105 = r104.subscribeOn(Schedulers.io());
            if (r105 == null) goto L14;
            Observable<CommerceBaseResponse> r106 = r105.observeOn(AndroidSchedulers.mainThread());
            if (r106 == null) goto L15;
            r106.subscribe(new c(r112));
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }

        public static void c(String r110, String r111, String r112, String r113, String r114, String r115, int r116, String r117, Function2 r210) {
            Intrinsics.checkNotNullParameter(r110, "promotionId");
            Intrinsics.checkNotNullParameter(r111, "productId");
            Intrinsics.checkNotNullParameter(r112, "awemeId");
            Intrinsics.checkNotNullParameter(r113, "authorId");
            Intrinsics.checkNotNullParameter(r114, "secAuthorId");
            Intrinsics.checkNotNullParameter(r115, "userId");
            Intrinsics.checkNotNullParameter(r117, "metaParam");
            Intrinsics.checkNotNullParameter(r210, "onResult");
            AnchorV3Api r100 = f165265a;
            if (r100 == null) goto L12;
            Observable<AppointmentResponse> r101 = r100.appointPromotion(r110, r111, r112, r113, r114, r113, r115, r116, r117);
            if (r101 == null) goto L13;
            Observable<AppointmentResponse> r102 = r101.subscribeOn(Schedulers.io());
            if (r102 == null) goto L14;
            Observable<AppointmentResponse> r103 = r102.observeOn(AndroidSchedulers.mainThread());
            if (r103 == null) goto L15;
            r103.subscribe(new C2513a(r210));
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }

        public static Observable a(String r110, String r111, String r112, String r113, int r114, String r115, Integer r116, String r210, String r211, String r212) {
            Intrinsics.checkNotNullParameter(r110, "awemeId");
            Intrinsics.checkNotNullParameter(r111, "promotionId");
            Intrinsics.checkNotNullParameter(r112, "authorId");
            Intrinsics.checkNotNullParameter(r113, "secAuthorId");
            if (r114 != 1) goto L10;
            JSONObject r100 = new JSONObject();
            com.bytedance.android.btm.api.model.e r101 = BtmSDK.INSTANCE.getBtmPageInfo(null);
            if (r101 == null) goto L8;
            String r102 = r101.f42025a;
            if (r102 == null) goto L8;
        L9:
            r100.put("btm_show_id", r102);
        L11:
            AnchorV3Api r103 = f165265a;
            if (r103 == null) goto L22;
            if (r212 != null) goto L15;
            String r104 = "";
        L16:
            if (r100 == null) goto L18;
            String r117 = r100.toString();
        L19:
            Observable<PreviewWillListResponse> r105 = r103.shopWillList(r110, r111, r104, r112, r113, r114, r115, r116, r210, r211, r117);
            if (r105 == null) goto L22;
            return r105;
        L18:
            r117 = null;
            goto L19
        L15:
            r104 = r212;
        L22:
            return Observable.error(new Throwable());
        L8:
            r102 = "";
            goto L9
        L10:
            r100 = null;
            goto L11
        }

        public static /* synthetic */ Observable b(a r110, String r111, String r112, String r113, String r114, int r115, String r116, Integer r117, String r118, String r119) {
            r110.getClass();
            return a(r111, r112, r113, r114, r115, r116, r117, r118, null, r119);
        }
    }

    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable a(AnchorV3Api r310, String r311, String r312, String r313, List r314, String r315, String r316, String r410, String r411, String r412, String r413, Integer r414, Integer r415, String r416, Integer r417, String r418, String r419, Integer r510, String r511, String r512, String r513, Integer r514, String r515, String r516, String r517, String r518, Map r519, String r610, Integer r611, int r612) {
            Boolean r100 = null;
            if ((r612 & 4) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r612 & 8) == 0) goto L9;
            List r102 = null;
        L11:
            if ((r612 & 16) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r612 & 128) == 0) goto L17;
            String r110 = null;
        L19:
            if ((r612 & 256) == 0) goto L21;
            String r111 = null;
        L23:
            if ((r612 & 512) == 0) goto L25;
            String r112 = null;
        L27:
            if ((r612 & 1024) == 0) goto L29;
            Integer r113 = null;
        L31:
            if ((r612 & 2048) == 0) goto L33;
            Integer r114 = null;
        L35:
            if ((r612 & 4096) == 0) goto L37;
            String r115 = null;
        L39:
            if ((r612 & 8192) == 0) goto L41;
            Integer r116 = null;
        L43:
            if ((r612 & 16384) == 0) goto L45;
            String r117 = null;
        L47:
            if ((32768 & r612) == 0) goto L49;
            String r118 = null;
        L51:
            if ((65536 & r612) == 0) goto L53;
            Integer r210 = null;
        L55:
            if ((131072 & r612) == 0) goto L57;
            String r211 = null;
        L59:
            if ((262144 & r612) == 0) goto L61;
            String r212 = null;
        L63:
            if ((524288 & r612) == 0) goto L65;
            String r213 = null;
        L67:
            if ((1048576 & r612) == 0) goto L69;
            Integer r214 = null;
        L71:
            if ((2097152 & r612) == 0) goto L73;
            String r215 = null;
        L75:
            if ((4194304 & r612) == 0) goto L77;
            String r216 = null;
        L79:
            if ((8388608 & r612) == 0) goto L81;
            String r217 = null;
        L83:
            if ((16777216 & r612) == 0) goto L85;
            String r218 = null;
        L87:
            if ((33554432 & r612) == 0) goto L89;
            Map r219 = null;
        L91:
            if ((67108864 & r612) == 0) goto L93;
            String r317 = null;
        L95:
            if ((134217728 & r612) == 0) goto L97;
            Integer r318 = 0;
        L99:
            if ((r612 & 268435456) == 0) goto L102;
            r100 = Boolean.FALSE;
        L102:
            return r310.getShopPromotion(r311, r312, r101, r102, r103, r316, r410, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r317, r318, r100);
        L97:
            r318 = r611;
            goto L99
        L93:
            r317 = r610;
            goto L95
        L89:
            r219 = r519;
            goto L91
        L85:
            r218 = r518;
            goto L87
        L81:
            r217 = r517;
            goto L83
        L77:
            r216 = r516;
            goto L79
        L73:
            r215 = r515;
            goto L75
        L69:
            r214 = r514;
            goto L71
        L65:
            r213 = r513;
            goto L67
        L61:
            r212 = r512;
            goto L63
        L57:
            r211 = r511;
            goto L59
        L53:
            r210 = r510;
            goto L55
        L49:
            r118 = r419;
            goto L51
        L45:
            r117 = r418;
            goto L47
        L41:
            r116 = r417;
            goto L43
        L37:
            r115 = r416;
            goto L39
        L33:
            r114 = r415;
            goto L35
        L29:
            r113 = r414;
            goto L31
        L25:
            r112 = r413;
            goto L27
        L21:
            r111 = r412;
            goto L23
        L17:
            r110 = r411;
            goto L19
        L13:
            r103 = r315;
            goto L15
        L9:
            r102 = r314;
            goto L11
        L5:
            r101 = r313;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Observable b(AnchorV3Api r310, String r311, String r312, String r313, List r314, String r315, String r316, String r317, String r410, String r411, String r412, Integer r413, Integer r414, String r415, Integer r416, String r417, String r418, Integer r419, String r510, String r511, String r512, Integer r513, String r514, String r515, String r516, String r517, Map r518, String r519, Integer r610, int r611) {
            if ((r611 & 4) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r611 & 8) == 0) goto L9;
            List r101 = null;
        L11:
            if ((r611 & 16) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r611 & 128) == 0) goto L17;
            String r110 = null;
        L19:
            if ((r611 & 256) == 0) goto L21;
            String r111 = null;
        L23:
            if ((r611 & 512) == 0) goto L25;
            String r112 = null;
        L27:
            if ((r611 & 1024) == 0) goto L29;
            Integer r113 = null;
        L31:
            if ((r611 & 2048) == 0) goto L33;
            Integer r114 = null;
        L35:
            if ((r611 & 4096) == 0) goto L37;
            String r115 = null;
        L39:
            if ((r611 & 8192) == 0) goto L41;
            Integer r116 = null;
        L43:
            if ((r611 & 16384) == 0) goto L45;
            String r117 = null;
        L47:
            if ((32768 & r611) == 0) goto L49;
            String r118 = null;
        L51:
            if ((65536 & r611) == 0) goto L53;
            Integer r210 = null;
        L55:
            if ((131072 & r611) == 0) goto L57;
            String r211 = null;
        L59:
            if ((262144 & r611) == 0) goto L61;
            String r212 = null;
        L63:
            if ((524288 & r611) == 0) goto L65;
            String r213 = null;
        L67:
            if ((1048576 & r611) == 0) goto L69;
            Integer r214 = null;
        L71:
            if ((2097152 & r611) == 0) goto L73;
            String r215 = null;
        L75:
            if ((4194304 & r611) == 0) goto L77;
            String r216 = null;
        L79:
            if ((8388608 & r611) == 0) goto L81;
            String r217 = null;
        L83:
            if ((16777216 & r611) == 0) goto L85;
            String r218 = null;
        L87:
            if ((33554432 & r611) == 0) goto L89;
            Map r219 = null;
        L91:
            if ((67108864 & r611) == 0) goto L93;
            String r318 = null;
        L95:
            if ((r611 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L97;
            Integer r319 = 0;
        L99:
            return r310.getShopPromotionInner(r311, r312, r100, r101, r102, r316, r317, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r318, r319);
        L97:
            r319 = r610;
            goto L99
        L93:
            r318 = r519;
            goto L95
        L89:
            r219 = r518;
            goto L91
        L85:
            r218 = r517;
            goto L87
        L81:
            r217 = r516;
            goto L83
        L77:
            r216 = r515;
            goto L79
        L73:
            r215 = r514;
            goto L75
        L69:
            r214 = r513;
            goto L71
        L65:
            r213 = r512;
            goto L67
        L61:
            r212 = r511;
            goto L63
        L57:
            r211 = r510;
            goto L59
        L53:
            r210 = r419;
            goto L55
        L49:
            r118 = r418;
            goto L51
        L45:
            r117 = r417;
            goto L47
        L41:
            r116 = r416;
            goto L43
        L37:
            r115 = r415;
            goto L39
        L33:
            r114 = r414;
            goto L35
        L29:
            r113 = r413;
            goto L31
        L25:
            r112 = r412;
            goto L27
        L21:
            r111 = r411;
            goto L23
        L17:
            r110 = r410;
            goto L19
        L13:
            r102 = r315;
            goto L15
        L9:
            r101 = r314;
            goto L11
        L5:
            r100 = r313;
            goto L7
        }
    }

    static {
        f165264a = a.f165266b;
    }

    @FormUrlEncoded
    @POST("/aweme/v2/shop/coupon/apply/auto/")
    Observable<PromotionAutoApplyCouponResponse> applyCouponAuto(@Field("product_id") String r100, @Field(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID) String r101, @Field("price") long r102, @Field(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL) String r103, @Field("author_id") String r104, @Field("sec_author_id") String r105, @Field("channel_id") String r106, @Field(WsConstants.KEY_CHANNEL_TYPE) Integer r107);

    @GET("/aweme/v1/promotion/appoint/")
    Observable<AppointmentResponse> appointPromotion(@Query("promotion_id") String r100, @Query("product_id") String r101, @Query(SimilarProductParam.AWEME_ID) String r102, @Query(com.bytedance.android.ec.core.event.a.KEY_KOL_ID) String r103, @Query("sec_kol_id") String r104, @Query("author_open_id") String r105, @Query("user_open_id") String r106, @Query("op_type") int r107, @Query(com.bytedance.android.ec.core.event.a.KEY_META_PARAM) String r108);

    @GET("/aweme/v1/promotion/appoint/")
    Observable<AppointmentResponse> appointPromotionWithParams(@Query("user_open_id") String r100, @QueryMap Map<String, String> r101);

    @FormUrlEncoded
    @POST("https://lianmengapi.snssdk.com/live/campaign/deposit/reservation/")
    Observable<CommerceBaseResponse> depositPresaleAppointPromotion(@Field("room_id") String r100, @Field("author_id") String r101, @Field("product_id") String r102, @Field("enter_from") String r103, @Field("promotion_id") String r104);

    @FormUrlEncoded
    @POST("https://lianmengapi.snssdk.com/live/campaign/deposit/reservation/")
    Observable<DepositPresaleAppointResponse> depositPresaleAppointWithParams(@FieldMap Map<String, String> r100);

    @GET("/aweme/v2/shop/promotion/group/")
    Observable<GroupInfoResponse> getGroupInfo(@Query("item_id") String r100, @Query("sec_author_id") String r101, @Query("promotion_id") String r102, @Query(com.bytedance.android.ec.core.event.a.KEY_META_PARAM) String r103, @Query("enter_from") String r104);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/promotion/pack/detail/")
    Observable<PromotionProductDetailResponse> getPromotionDetail(@Field("promotion_id") String r100, @Field("enter_from") String r101, @Field(com.bytedance.android.ec.core.event.a.KEY_META_PARAM) String r102, @FieldMap Map<String, String> r103, @Field("tag_guarantee_header") String r104, @Field("pdp_new_edition") Integer r105, @Field("is_short_screen") int r106, @Field("channel_id") String r107, @Field(WsConstants.KEY_CHANNEL_TYPE) Integer r108);

    @GET("https://tsearch.snssdk.com/api/suggest_words/")
    Observable<SearchSuggestWordResponse> getSearchSuggestWords(@Query(AuthConstants.PARAM_KEY_LICENSE_BUSINESS_ID) String r100, @Query("pd") String r101, @Query("category_name") String r102, @Query("words_source") String r103, @Query(com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID) String r104, @Query("penetrate_params") String r105);

    @GET("https://aweme.snssdk.com/ecom_member/facade_douyin/shop_guide/v1/get_shop_guide_info/")
    Observable<ShopGuideInfoResponse> getShopGuideIdAnchorV3(@Query("caller") int r100);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/promotion/pack/")
    Observable<PromotionPackResponse> getShopPromotion(@Field("user_id") String r100, @Field("user_open_id") String r101, @Field("sec_user_id") String r102, @Field("promotion_ids") List<String> r103, @Field("item_id") String r104, @Field("sec_author_id") String r105, @Field("enter_from") String r106, @Field(com.bytedance.android.ec.core.event.a.KEY_META_PARAM) String r107, @Field("author_id") String r108, @Field("author_open_id") String r110, @Field("width") Integer r111, @Field("height") Integer r112, @Field(com.bytedance.android.ec.core.event.a.KEY_RANK_ID) String r113, @Field("internal_feed_ab") Integer r114, @Field("source_type") String r115, @Field("qianchuan_ab") String r116, @Field("use_new_price") Integer r117, @Field("cps_track") String r118, @Field("user_addr_id") String r119, @Field(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL) String r210, @Field("gps_on") Integer r211, @Field("product_id") String r212, @Field("creative_id") String r213, @Field("promotion_id") String r214, @Field("inflow_meta_param") String r215, @FieldMap Map<String, String> r216, @Field("video_page_source") String r217, @Field(com.bytedance.android.ec.core.event.a.KEY_SAME_PRODUCT_SCENE) Integer r218, @Field("is_preload_req") Boolean r219);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/promotion/pack/inner/")
    Observable<PromotionPackResponse> getShopPromotionInner(@Field("user_id") String r100, @Field("user_open_id") String r101, @Field("sec_user_id") String r102, @Field("promotion_ids") List<String> r103, @Field("item_id") String r104, @Field("sec_author_id") String r105, @Field("enter_from") String r106, @Field(com.bytedance.android.ec.core.event.a.KEY_META_PARAM) String r107, @Field("author_id") String r108, @Field("author_open_id") String r110, @Field("width") Integer r111, @Field("height") Integer r112, @Field(com.bytedance.android.ec.core.event.a.KEY_RANK_ID) String r113, @Field("internal_feed_ab") Integer r114, @Field("source_type") String r115, @Field("qianchuan_ab") String r116, @Field("use_new_price") Integer r117, @Field("cps_track") String r118, @Field("user_addr_id") String r119, @Field(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL) String r210, @Field("gps_on") Integer r211, @Field("product_id") String r212, @Field("creative_id") String r213, @Field("promotion_id") String r214, @Field("inflow_meta_param") String r215, @FieldMap Map<String, String> r216, @Field("video_page_source") String r217, @Field(com.bytedance.android.ec.core.event.a.KEY_SAME_PRODUCT_SCENE) Integer r218);

    @FormUrlEncoded
    @POST("/aweme/v2/shop/promotion/recommend/")
    Observable<PromotionRecommendResponse> getShopPromotionRecommend(@Field("according_product_id") String r100, @Field("source") String r101, @Field("type") String r102, @Field("room_id") String r103, @Field("video_id") String r104, @FieldMap Map<String, String> r105);

    @GET("https://report.snssdk.com/aweme/track/report")
    Observable<CommerceBaseResponse> reportTrackParams(@Query("product_id") String r100, @Query("cps_track") String r101, @Query("report_type") int r102);

    @FormUrlEncoded
    @POST("https://ecom.snssdk.com/aweme/v2/shop/like")
    Observable<PreviewLikeListResponse> shopLikeList(@Field("target_id") String r100, @Field("scene") int r101, @Field("action") int r102, @Field(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE) int r103, @Field("commission_info") String r104);

    @POST("https://ecom.snssdk.com/aweme/v2/shop/want")
    Observable<PreviewWillListResponse> shopWillList(@Query(SimilarProductParam.AWEME_ID) String r100, @Query("promotion_id") String r101, @Query("product_id") String r102, @Query("author_id") String r103, @Query("sec_author_id") String r104, @Query("type") int r105, @Query(com.bytedance.android.ec.core.event.a.KEY_META_PARAM) String r106, @Query(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE) Integer r107, @Query("item_id") String r108, @Query("page_source") String r110, @Query("extra_info") String r111);
}
