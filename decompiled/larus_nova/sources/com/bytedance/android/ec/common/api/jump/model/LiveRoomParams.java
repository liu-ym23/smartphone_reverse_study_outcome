package com.bytedance.android.ec.common.api.jump.model;

import com.bytedance.android.ec.model.response.n1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.anchorv3.utils.n;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bd\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0088\u0001B\u009f\u0002\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\u0006\u0010-\u001a\u00020\u0005\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0007\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014\u0012\b\b\u0002\u00108\u001a\u00020\u0005\u0012\b\b\u0002\u00109\u001a\u00020\u0005\u0012\b\b\u0002\u0010:\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u000e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0014\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014\u0012\u0006\u0010?\u001a\u00020\u001f¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bJ\b\u0010\r\u001a\u00020\u0007H\u0016J\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0014HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0014HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bHÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0014HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014HÆ\u0003J\t\u0010)\u001a\u00020\u001fHÆ\u0003J¿\u0002\u0010@\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020\u00052\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\b\b\u0002\u0010/\u001a\u00020\u00052\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00142\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u000e\b\u0002\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00109\u001a\u00020\u00052\b\b\u0002\u0010:\u001a\u00020\u00052\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b2\u0010\b\u0002\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00142\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00142\b\b\u0002\u0010?\u001a\u00020\u001fHÆ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001J\t\u0010B\u001a\u00020\u001fHÖ\u0001J\u0013\u0010D\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001d\u0010I\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010*\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010J\u001a\u0004\bK\u0010HR\u0017\u0010+\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b+\u0010J\u001a\u0004\bL\u0010HR\u0017\u0010,\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b,\u0010J\u001a\u0004\bM\u0010HR\u0017\u0010-\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b-\u0010J\u001a\u0004\bN\u0010HR\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006¢\u0006\f\n\u0004\b.\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010/\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b/\u0010J\u001a\u0004\bR\u0010HR#\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b0\u0010S\u001a\u0004\bT\u0010UR#\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b1\u0010S\u001a\u0004\bV\u0010UR\u0019\u00102\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b2\u0010W\u001a\u0004\bX\u0010YR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00148\u0006¢\u0006\f\n\u0004\b3\u0010O\u001a\u0004\bZ\u0010QR\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0006¢\u0006\f\n\u0004\b4\u0010O\u001a\u0004\b[\u0010QR\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00148\u0006¢\u0006\f\n\u0004\b5\u0010O\u001a\u0004\b\\\u0010QR\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00148\u0006¢\u0006\f\n\u0004\b6\u0010O\u001a\u0004\b6\u0010QR\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00148\u0006¢\u0006\f\n\u0004\b7\u0010O\u001a\u0004\b]\u0010QR\u0017\u00108\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b8\u0010J\u001a\u0004\b^\u0010HR\u0017\u00109\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b9\u0010J\u001a\u0004\b_\u0010HR\u0017\u0010:\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b:\u0010J\u001a\u0004\b`\u0010HR#\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b;\u0010S\u001a\u0004\ba\u0010UR\u001f\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u00148\u0006¢\u0006\f\n\u0004\b<\u0010O\u001a\u0004\bb\u0010QR\u0019\u0010=\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b=\u0010W\u001a\u0004\bc\u0010YR\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00148\u0006¢\u0006\f\n\u0004\b>\u0010O\u001a\u0004\bd\u0010QR\u0017\u0010?\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b?\u0010e\u001a\u0004\b?\u0010fR\u0011\u0010h\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bg\u0010HR\u0011\u0010j\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bi\u0010HR\u0013\u0010l\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bk\u0010HR\u0011\u0010n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bm\u0010HR\u0011\u0010p\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bo\u0010HR\u0011\u0010r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bq\u0010HR\u0013\u0010t\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bs\u0010HR\u0013\u0010v\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bu\u0010HR\u0013\u0010x\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\bw\u0010HR\u0013\u0010z\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\by\u0010HR\u0013\u0010|\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b{\u0010HR\u0013\u0010~\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b}\u0010HR\u0014\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u007f\u0010HR\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010HR\u0015\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010HR\u0016\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001f8F¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/android/ec/common/api/jump/model/LiveRoomParams;", "Lcom/bytedance/android/ec/common/api/jump/model/a;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/common/api/jump/model/d;", "Lcom/bytedance/android/ec/common/api/jump/model/c;", "", "getSourcePage", "Lorg/json/JSONObject;", "entranceInfo", "", "isDisplayRoom", "", "getEcomLiveParamsEventParams", "addToCartEntranceInfo", "", "generaInitialData", "component1", "component2", "component3", "component4", "Lkotlin/Function0;", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "", "component12", "component13", "", "component14", "component15", "component16", "component17", "component18", "Lcom/bytedance/android/ec/model/response/n1;", "component19", "component20", "component21", "component22", "roomId", "roomUniqueKey", "authorId", "secAuthorId", "screenType", "ecomSceneId", "reportParams", "ecomLiveParams", "passThroughLogData", "hourlyPurchaseShopId", "shouldShowAddressNotice", "hasShowNoticeInShop", "isHourArrivedRoom", "roomType", "displayRoomId", "displayAnchorId", "displaySecAnchorId", "displayReportParams", "roomInfo", "multiRoomData", "instantType", "isShowCart", "copy", "toString", "hashCode", "other", "equals", "searchParams$delegate", "Lkotlin/Lazy;", "getSearchParams", "()Ljava/lang/String;", "searchParams", "Ljava/lang/String;", "getRoomId", "getRoomUniqueKey", "getAuthorId", "getSecAuthorId", "Lkotlin/jvm/functions/Function0;", "getScreenType", "()Lkotlin/jvm/functions/Function0;", "getEcomSceneId", "Ljava/util/Map;", "getReportParams", "()Ljava/util/Map;", "getEcomLiveParams", "Lorg/json/JSONObject;", "getPassThroughLogData", "()Lorg/json/JSONObject;", "getHourlyPurchaseShopId", "getShouldShowAddressNotice", "getHasShowNoticeInShop", "getRoomType", "getDisplayRoomId", "getDisplayAnchorId", "getDisplaySecAnchorId", "getDisplayReportParams", "getRoomInfo", "getMultiRoomData", "getInstantType", "I", "()I", "getFollowStatus", "followStatus", "getDisplayFollowStatus", "displayFollowStatus", "getGroupId", "groupId", "getEnterFromMerge", "enterFromMerge", "getEnterMethod", "enterMethod", "getActionType", ReportConstant.COMMON_ACTION_TYPE, "getRequestId", "requestId", "getLiveRecommendInfo", "liveRecommendInfo", "getSearchId", "searchId", "getSearchType", "searchType", "getLiveTrackerParams", "liveTrackerParams", "getCreativeId", "creativeId", "getLogExtra", "logExtra", "isOtherChannel", "getAwemeAdType", "awemeAdType", "isEcomNew", "()Ljava/lang/Integer;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function0;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomParams extends com.bytedance.android.ec.common.api.jump.model.a implements Serializable, d, c {
    private final String authorId;
    private final String displayAnchorId;
    private final Map<String, String> displayReportParams;
    private final String displayRoomId;
    private final String displaySecAnchorId;
    private final Map<String, String> ecomLiveParams;
    private final String ecomSceneId;
    private final Function0<Unit> hasShowNoticeInShop;
    private final Function0<String> hourlyPurchaseShopId;
    private final Function0<Integer> instantType;
    private final Function0<Boolean> isHourArrivedRoom;
    private final int isShowCart;
    private final JSONObject multiRoomData;
    private final JSONObject passThroughLogData;
    private final Map<String, String> reportParams;
    private final String roomId;
    private final Function0<n1> roomInfo;
    private final Function0<Integer> roomType;
    private final String roomUniqueKey;
    private final Function0<String> screenType;
    private final Lazy searchParams$delegate;
    private final String secAuthorId;
    private final Function0<Boolean> shouldShowAddressNotice;

    public static final class a implements com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f42830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f42831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f42832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f42833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function0<String> f42834e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f42835f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, String> f42836g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Map<String, String> f42837h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final JSONObject f42838i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Function0<String> f42839j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Function0<Boolean> f42840k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Function0<Unit> f42841l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function0<Boolean> f42842m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function0<Integer> f42843n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f42844o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f42845p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f42846q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Map<String, String> f42847r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Function0<n1> f42848s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final JSONObject f42849t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final Function0<Integer> f42850u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f42851v;

        @Override // com.bytedance.android.ec.common.api.jump.model.a.InterfaceC0780a
        public final <T extends com.bytedance.android.ec.common.api.jump.model.a> T a(KClass<T> r210) {
            Intrinsics.checkNotNullParameter(r210, "modelClass");
            if (Intrinsics.areEqual(r210, Reflection.getOrCreateKotlinClass(LiveRoomParams.class)) == false) goto L7;
            return new LiveRoomParams(this.f42830a, this.f42831b, this.f42832c, this.f42833d, this.f42834e, this.f42835f, this.f42836g, this.f42837h, this.f42838i, this.f42839j, this.f42840k, this.f42841l, this.f42842m, this.f42843n, this.f42844o, this.f42845p, this.f42846q, this.f42847r, this.f42848s, this.f42849t, this.f42850u, this.f42851v);
        L7:
            return (T) JvmClassMappingKt.getJavaClass(r210).newInstance();
        }

        public a(String r110, String r111, String r112, String r210, Map r211, Map r212) {
            LiveRoomParams$Factory$1 r100 = LiveRoomParams$Factory$1.INSTANCE;
            LiveRoomParams$Factory$2 r101 = LiveRoomParams$Factory$2.INSTANCE;
            LiveRoomParams$Factory$3 r102 = LiveRoomParams$Factory$3.INSTANCE;
            LiveRoomParams$Factory$4 r113 = LiveRoomParams$Factory$4.INSTANCE;
            LiveRoomParams$Factory$5 r114 = LiveRoomParams$Factory$5.INSTANCE;
            LiveRoomParams$Factory$6 r115 = LiveRoomParams$Factory$6.INSTANCE;
            LiveRoomParams$Factory$7 r116 = LiveRoomParams$Factory$7.INSTANCE;
            LiveRoomParams$Factory$8 r117 = LiveRoomParams$Factory$8.INSTANCE;
            Intrinsics.checkNotNullParameter(r110, "roomId");
            Intrinsics.checkNotNullParameter("", "roomUniqueKey");
            Intrinsics.checkNotNullParameter(r111, "authorId");
            Intrinsics.checkNotNullParameter(r112, "secAuthorId");
            Intrinsics.checkNotNullParameter(r100, "screenType");
            Intrinsics.checkNotNullParameter(r210, "ecomSceneId");
            Intrinsics.checkNotNullParameter(r211, "reportParams");
            Intrinsics.checkNotNullParameter(r212, "ecomLiveParams");
            Intrinsics.checkNotNullParameter(r101, "hourlyPurchaseShopId");
            Intrinsics.checkNotNullParameter(r102, "shouldShowAddressNotice");
            Intrinsics.checkNotNullParameter(r113, "hasShowNoticeInShop");
            Intrinsics.checkNotNullParameter(r114, "isHourArrivedRoom");
            Intrinsics.checkNotNullParameter(r115, "roomType");
            Intrinsics.checkNotNullParameter(r110, "displayRoomId");
            Intrinsics.checkNotNullParameter(r111, "displayAnchorId");
            Intrinsics.checkNotNullParameter(r112, "displaySecAnchorId");
            Intrinsics.checkNotNullParameter(r211, "displayReportParams");
            Intrinsics.checkNotNullParameter(r116, "roomInfo");
            Intrinsics.checkNotNullParameter(r117, "instantType");
            this.f42830a = r110;
            this.f42831b = "";
            this.f42832c = r111;
            this.f42833d = r112;
            this.f42834e = r100;
            this.f42835f = r210;
            this.f42836g = r211;
            this.f42837h = r212;
            this.f42838i = null;
            this.f42839j = r101;
            this.f42840k = r102;
            this.f42841l = r113;
            this.f42842m = r114;
            this.f42843n = r115;
            this.f42844o = r110;
            this.f42845p = r111;
            this.f42846q = r112;
            this.f42847r = r211;
            this.f42848s = r116;
            this.f42849t = null;
            this.f42850u = r117;
            this.f42851v = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveRoomParams copy$default(LiveRoomParams r110, String r111, String r112, String r210, String r211, Function0 r212, String r213, Map r214, Map r215, JSONObject r216, Function0 r217, Function0 r218, Function0 r219, Function0 r310, Function0 r311, String r312, String r313, String r314, Map r315, Function0 r316, JSONObject r317, Function0 r318, int r319, int r410, Object r411) {
        if ((r410 & 1) == 0) goto L5;
        String r100 = r110.roomId;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r101 = r110.roomUniqueKey;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r102 = r110.authorId;
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r103 = r110.secAuthorId;
    L19:
        if ((r410 & 16) == 0) goto L21;
        Function0 r104 = r110.screenType;
    L23:
        if ((r410 & 32) == 0) goto L25;
        String r105 = r110.ecomSceneId;
    L27:
        if ((r410 & 64) == 0) goto L29;
        Map r106 = r110.reportParams;
    L31:
        if ((r410 & 128) == 0) goto L33;
        Map r107 = r110.ecomLiveParams;
    L35:
        if ((r410 & 256) == 0) goto L37;
        JSONObject r113 = r110.passThroughLogData;
    L39:
        if ((r410 & 512) == 0) goto L41;
        Function0 r114 = r110.hourlyPurchaseShopId;
    L43:
        if ((r410 & 1024) == 0) goto L45;
        Function0 r115 = r110.shouldShowAddressNotice;
    L47:
        if ((r410 & 2048) == 0) goto L49;
        Function0 r116 = r110.hasShowNoticeInShop;
    L51:
        if ((r410 & 4096) == 0) goto L53;
        Function0 r117 = r110.isHourArrivedRoom;
    L55:
        if ((r410 & 8192) == 0) goto L57;
        Function0 r118 = r110.roomType;
    L58:
        Function0 r320 = r118;
        if ((r410 & 16384) == 0) goto L61;
        String r119 = r110.displayRoomId;
    L62:
        String r321 = r119;
        if ((r410 & 32768) == 0) goto L65;
        String r120 = r110.displayAnchorId;
    L66:
        String r322 = r120;
        if ((r410 & 65536) == 0) goto L69;
        String r121 = r110.displaySecAnchorId;
    L70:
        String r323 = r121;
        if ((r410 & 131072) == 0) goto L73;
        Map r122 = r110.displayReportParams;
    L74:
        Map r324 = r122;
        if ((r410 & 262144) == 0) goto L77;
        Function0 r123 = r110.roomInfo;
    L78:
        Function0 r325 = r123;
        if ((r410 & 524288) == 0) goto L81;
        JSONObject r124 = r110.multiRoomData;
    L82:
        JSONObject r326 = r124;
        if ((r410 & 1048576) == 0) goto L85;
        Function0 r125 = r110.instantType;
    L87:
        if ((r410 & 2097152) == 0) goto L89;
        int r108 = r110.isShowCart;
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

    public final String component1() {
        return this.roomId;
    }

    public final Function0<String> component10() {
        return this.hourlyPurchaseShopId;
    }

    public final Function0<Boolean> component11() {
        return this.shouldShowAddressNotice;
    }

    public final Function0<Unit> component12() {
        return this.hasShowNoticeInShop;
    }

    public final Function0<Boolean> component13() {
        return this.isHourArrivedRoom;
    }

    public final Function0<Integer> component14() {
        return this.roomType;
    }

    public final String component15() {
        return this.displayRoomId;
    }

    public final String component16() {
        return this.displayAnchorId;
    }

    public final String component17() {
        return this.displaySecAnchorId;
    }

    public final Map<String, String> component18() {
        return this.displayReportParams;
    }

    public final Function0<n1> component19() {
        return this.roomInfo;
    }

    public final String component2() {
        return this.roomUniqueKey;
    }

    public final JSONObject component20() {
        return this.multiRoomData;
    }

    public final Function0<Integer> component21() {
        return this.instantType;
    }

    public final int component22() {
        return this.isShowCart;
    }

    public final String component3() {
        return this.authorId;
    }

    public final String component4() {
        return this.secAuthorId;
    }

    public final Function0<String> component5() {
        return this.screenType;
    }

    public final String component6() {
        return this.ecomSceneId;
    }

    public final Map<String, String> component7() {
        return this.reportParams;
    }

    public final Map<String, String> component8() {
        return this.ecomLiveParams;
    }

    public final JSONObject component9() {
        return this.passThroughLogData;
    }

    public final LiveRoomParams copy(String r210, String r211, String r212, String r213, Function0<String> r310, String r311, Map<String, String> r312, Map<String, String> r313, JSONObject r314, Function0<String> r315, Function0<Boolean> r316, Function0<Unit> r317, Function0<Boolean> r318, Function0<Integer> r319, String r410, String r411, String r412, Map<String, String> r413, Function0<n1> r414, JSONObject r415, Function0<Integer> r416, int r417) {
        Intrinsics.checkNotNullParameter(r210, "roomId");
        Intrinsics.checkNotNullParameter(r211, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r212, "authorId");
        Intrinsics.checkNotNullParameter(r213, "secAuthorId");
        Intrinsics.checkNotNullParameter(r310, "screenType");
        Intrinsics.checkNotNullParameter(r311, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r312, "reportParams");
        Intrinsics.checkNotNullParameter(r313, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r315, "hourlyPurchaseShopId");
        Intrinsics.checkNotNullParameter(r316, "shouldShowAddressNotice");
        Intrinsics.checkNotNullParameter(r317, "hasShowNoticeInShop");
        Intrinsics.checkNotNullParameter(r318, "isHourArrivedRoom");
        Intrinsics.checkNotNullParameter(r319, "roomType");
        Intrinsics.checkNotNullParameter(r410, "displayRoomId");
        Intrinsics.checkNotNullParameter(r411, "displayAnchorId");
        Intrinsics.checkNotNullParameter(r412, "displaySecAnchorId");
        Intrinsics.checkNotNullParameter(r413, "displayReportParams");
        Intrinsics.checkNotNullParameter(r414, "roomInfo");
        Intrinsics.checkNotNullParameter(r416, "instantType");
        return new LiveRoomParams(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveRoomParams) == false) goto L50;
        LiveRoomParams r101 = (LiveRoomParams) r100;
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomUniqueKey, r101.roomUniqueKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.screenType, r101.screenType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ecomSceneId, r101.ecomSceneId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.reportParams, r101.reportParams) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ecomLiveParams, r101.ecomLiveParams) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.passThroughLogData, r101.passThroughLogData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hourlyPurchaseShopId, r101.hourlyPurchaseShopId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shouldShowAddressNotice, r101.shouldShowAddressNotice) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.hasShowNoticeInShop, r101.hasShowNoticeInShop) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isHourArrivedRoom, r101.isHourArrivedRoom) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.roomType, r101.roomType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.displayRoomId, r101.displayRoomId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.displayAnchorId, r101.displayAnchorId) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.displaySecAnchorId, r101.displaySecAnchorId) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.displayReportParams, r101.displayReportParams) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.roomInfo, r101.roomInfo) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.multiRoomData, r101.multiRoomData) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.instantType, r101.instantType) == true) goto L48;
        return false;
    L48:
        if (this.isShowCart == r101.isShowCart) goto L76;
        return false;
    L76:
        return true;
    L50:
        return false;
    }

    public final Map<String, Object> generaInitialData() {
        Pair[] r100 = new Pair[7];
        r100[0] = TuplesKt.to("room_id", this.roomId);
        r100[1] = TuplesKt.to("author_id", this.authorId);
        r100[2] = TuplesKt.to("sec_author_id", this.secAuthorId);
        r100[3] = TuplesKt.to("is_followed", getFollowStatus());
        Map r101 = MapsKt.toMutableMap(this.ecomLiveParams);
        JSONObject r102 = this.passThroughLogData;
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.toString();
    L6:
        String r105 = "";
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r101.put("pass_through_log_data", r104);
        JSONObject r106 = this.multiRoomData;
        if (r106 == null) goto L12;
        r103 = r106.toString();
    L12:
        if (r103 == null) goto L15;
        r105 = r103;
    L15:
        r101.put("multi_room_data", r105);
        Unit r107 = Unit.INSTANCE;
        r100[4] = TuplesKt.to(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r101);
        r100[5] = TuplesKt.to("ecom_scene_id", this.ecomSceneId);
        r100[6] = TuplesKt.to("report_params", this.reportParams);
        return MapsKt.mutableMapOf(r100);
    L5:
        r104 = null;
        goto L6
    }

    public final String getSearchParams() {
        return (String) this.searchParams$delegate.getValue();
    }

    public int hashCode() {
        String r100 = this.roomId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomUniqueKey;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.authorId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secAuthorId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<String> r113 = this.screenType;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.ecomSceneId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.reportParams;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.ecomLiveParams;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        JSONObject r125 = this.passThroughLogData;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Function0<String> r128 = this.hourlyPurchaseShopId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Function0<Boolean> r131 = this.shouldShowAddressNotice;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Function0<Unit> r134 = this.hasShowNoticeInShop;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Function0<Boolean> r137 = this.isHourArrivedRoom;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Function0<Integer> r140 = this.roomType;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.displayRoomId;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.displayAnchorId;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.displaySecAnchorId;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Map<String, String> r152 = this.displayReportParams;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Function0<n1> r155 = this.roomInfo;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        JSONObject r158 = this.multiRoomData;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Function0<Integer> r161 = this.instantType;
        if (r161 == null) goto L86;
        r101 = r161.hashCode();
    L86:
        return ((r160 + r101) * 31) + this.isShowCart;
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
        return "LiveRoomParams(roomId=" + this.roomId + ", roomUniqueKey=" + this.roomUniqueKey + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", screenType=" + this.screenType + ", ecomSceneId=" + this.ecomSceneId + ", reportParams=" + this.reportParams + ", ecomLiveParams=" + this.ecomLiveParams + ", passThroughLogData=" + this.passThroughLogData + ", hourlyPurchaseShopId=" + this.hourlyPurchaseShopId + ", shouldShowAddressNotice=" + this.shouldShowAddressNotice + ", hasShowNoticeInShop=" + this.hasShowNoticeInShop + ", isHourArrivedRoom=" + this.isHourArrivedRoom + ", roomType=" + this.roomType + ", displayRoomId=" + this.displayRoomId + ", displayAnchorId=" + this.displayAnchorId + ", displaySecAnchorId=" + this.displaySecAnchorId + ", displayReportParams=" + this.displayReportParams + ", roomInfo=" + this.roomInfo + ", multiRoomData=" + this.multiRoomData + ", instantType=" + this.instantType + ", isShowCart=" + this.isShowCart + ")";
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.c
    public JSONObject addToCartEntranceInfo() {
        JSONObject r100 = new JSONObject();
        r100.putOpt(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, getEnterFromMerge());     // Catch: Exception -> L21
        r100.putOpt(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, getEnterMethod());     // Catch: Exception -> L21
        r100.putOpt(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");     // Catch: Exception -> L21
        r100.putOpt("carrier_type", "live_add_to_cart");     // Catch: Exception -> L21
        r100.putOpt("room_id", this.roomId);     // Catch: Exception -> L21
        r100.putOpt("anchor_id", this.authorId);     // Catch: Exception -> L21
        r100.putOpt("follow_status", getFollowStatus());     // Catch: Exception -> L21
        r100.putOpt("request_id", getRequestId());     // Catch: Exception -> L21
        r100.putOpt("group_id", getGroupId());     // Catch: Exception -> L21
        r100.putOpt("enter_from_merge", getEnterFromMerge());     // Catch: Exception -> L21
        r100.putOpt("enter_method", getEnterMethod());     // Catch: Exception -> L21
        r100.putOpt("action_type", getActionType());     // Catch: Exception -> L21
        r100.putOpt("creative_id", getCreativeId());     // Catch: Exception -> L21
        r100.putOpt("is_other_channel", isOtherChannel());     // Catch: Exception -> L21
        r100.putOpt("live_tracker_params", getLiveTrackerParams());     // Catch: Exception -> L21
        r100.putOpt("add_cart_source", "live");     // Catch: Exception -> L21
        String r101 = this.reportParams.get("search_params");     // Catch: Exception -> L21
        if (r101 == null) goto L6;
        r100.putOpt("search_params", r101);     // Catch: Exception -> L21
    L7:
        r100.putOpt("log_extra", getLogExtra());     // Catch: Exception -> L21
        JSONObject r102 = this.passThroughLogData;     // Catch: Exception -> L21
        if (r102 == null) goto L15;
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L21
    L11:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();     // Catch: Exception -> L21
        Object r105 = r102.opt(r104);     // Catch: Exception -> L21
        if (r105 == null) goto L11;
        r100.putOpt(r104, r105.toString());     // Catch: Exception -> L21
    L15:
        r100.put("ecom_scene_id", this.ecomSceneId);     // Catch: Exception -> L21
        r100.put("display_room_id", this.displayRoomId);     // Catch: Exception -> L21
        r100.put("display_anchor_id", this.displayAnchorId);     // Catch: Exception -> L21
        r100.put("display_sec_anchor_id", this.displaySecAnchorId);     // Catch: Exception -> L21
        r100.put("display_follow_status", getDisplayFollowStatus());     // Catch: Exception -> L21
        n1 r106 = this.roomInfo.invoke();     // Catch: Exception -> L21
        if (r106 == null) goto L23;
        List<Long> r107 = r106.a();     // Catch: Exception -> L21
        if (r107 == null) goto L23;
        int r108 = n.f165314a;     // Catch: Exception -> L21
        r100.put("ecom_linkmic_room_ids", n.a.f165315a.toJson(r107));     // Catch: Exception -> L21
    L23:
        return r100;
    L6:
        r100.putOpt("search_params", getSearchParams());     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ye.a.b(e);
        goto L23
    }

    @Override // com.bytedance.android.ec.common.api.jump.model.d
    public JSONObject entranceInfo() {
        JSONObject r100 = new JSONObject();
        LiveRoomParams r101 = (LiveRoomParams) getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r101 == null) goto L45;
        Map<String, String> r102 = r101.reportParams;
        if (r102 == null) goto L45;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L45;
        Map.Entry<String, String> r104 = r103.next();
        r100.put(r104.getKey(), r104.getValue());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        ye.a.b(e);
    L45:
        r100.put("enter_from", "live");     // Catch: Exception -> L20
        if (r101 == null) goto L17;
        String r105 = r101.getSourcePage();     // Catch: Exception -> L20
    L18:
        r100.put("category_name", r105);     // Catch: Exception -> L20
    L22:
        Iterator<Map.Entry<String, String>> r106 = getEcomLiveParamsEventParams().entrySet().iterator();
    L24:
        if (r106.hasNext() == false) goto L43;
        Map.Entry<String, String> r107 = r106.next();
        r100.put(r107.getKey(), r107.getValue());     // Catch: Exception -> L28
    L28:
        e = move-exception;
        ye.a.b(e);
        goto L24
    L43:
        r100.put("ecom_scene_id", this.ecomSceneId);     // Catch: Exception -> L36
        r100.put("display_room_id", this.displayRoomId);     // Catch: Exception -> L36
        r100.put("display_anchor_id", this.displayAnchorId);     // Catch: Exception -> L36
        r100.put("display_sec_anchor_id", this.displaySecAnchorId);     // Catch: Exception -> L36
        r100.put("display_follow_status", getDisplayFollowStatus());     // Catch: Exception -> L36
        n1 r108 = this.roomInfo.invoke();     // Catch: Exception -> L36
        if (r108 == null) goto L38;
        List<Long> r109 = r108.a();     // Catch: Exception -> L36
        if (r109 == null) goto L38;
        int r110 = n.f165314a;     // Catch: Exception -> L36
        r100.put("ecom_linkmic_room_ids", n.a.f165315a.toJson(r109));     // Catch: Exception -> L36
    L38:
        return r100;
    L36:
        e = move-exception;
        ye.a.b(e);
        goto L38
    L17:
        r105 = null;
    L20:
        e = move-exception;
        ye.a.b(e);
        goto L22
    }

    public final String getActionType() {
        String r100 = this.reportParams.get("action_type");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getAwemeAdType() {
        return this.reportParams.get("aweme_ad_type");
    }

    public final String getCreativeId() {
        return this.reportParams.get("creative_id");
    }

    public final String getDisplayFollowStatus() {
        String r100 = this.displayReportParams.get("follow_status");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final Map<String, String> getEcomLiveParamsEventParams() {
        HashMap r100 = new HashMap(this.ecomLiveParams);
        r100.remove("jump_schema");
        r100.remove("pass_through_log_data");
        r100.remove("multi_room_data");
        r100.remove("single_room_data");
        return r100;
    }

    public final String getEnterFromMerge() {
        String r100 = this.reportParams.get("enter_from_merge");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getEnterMethod() {
        String r100 = this.reportParams.get("enter_method");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getFollowStatus() {
        String r100 = this.reportParams.get("follow_status");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getGroupId() {
        return this.reportParams.get("group_id");
    }

    public final String getLiveRecommendInfo() {
        return this.reportParams.get(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
    }

    public final String getLiveTrackerParams() {
        return this.reportParams.get("live_tracker_params");
    }

    public final String getLogExtra() {
        return this.reportParams.get("log_extra");
    }

    public final String getRequestId() {
        return this.reportParams.get("request_id");
    }

    public final String getSearchId() {
        return this.reportParams.get("search_id");
    }

    public final String getSearchType() {
        return this.reportParams.get("search_type");
    }

    public final String getSourcePage() {
        return getEnterFromMerge() + "_temai_" + getEnterMethod();
    }

    public final boolean isDisplayRoom() {
        return Intrinsics.areEqual(this.roomId, this.displayRoomId);
    }

    public final Integer isEcomNew() {
        String r100 = this.reportParams.get("is_ecom_new");
        if (r100 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r100);
    }

    public final String isOtherChannel() {
        return this.reportParams.get("is_other_channel");
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getDisplayAnchorId() {
        return this.displayAnchorId;
    }

    public final Map<String, String> getDisplayReportParams() {
        return this.displayReportParams;
    }

    public final String getDisplayRoomId() {
        return this.displayRoomId;
    }

    public final String getDisplaySecAnchorId() {
        return this.displaySecAnchorId;
    }

    public final Map<String, String> getEcomLiveParams() {
        return this.ecomLiveParams;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final Function0<Unit> getHasShowNoticeInShop() {
        return this.hasShowNoticeInShop;
    }

    public final Function0<String> getHourlyPurchaseShopId() {
        return this.hourlyPurchaseShopId;
    }

    public final Function0<Integer> getInstantType() {
        return this.instantType;
    }

    public final JSONObject getMultiRoomData() {
        return this.multiRoomData;
    }

    public final JSONObject getPassThroughLogData() {
        return this.passThroughLogData;
    }

    public final Map<String, String> getReportParams() {
        return this.reportParams;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Function0<n1> getRoomInfo() {
        return this.roomInfo;
    }

    public final Function0<Integer> getRoomType() {
        return this.roomType;
    }

    public final String getRoomUniqueKey() {
        return this.roomUniqueKey;
    }

    public final Function0<String> getScreenType() {
        return this.screenType;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final Function0<Boolean> getShouldShowAddressNotice() {
        return this.shouldShowAddressNotice;
    }

    public final Function0<Boolean> isHourArrivedRoom() {
        return this.isHourArrivedRoom;
    }

    public final int isShowCart() {
        return this.isShowCart;
    }

    public LiveRoomParams(String r110, String r111, String r112, String r210, Function0<String> r211, String r212, Map<String, String> r213, Map<String, String> r214, JSONObject r215, Function0<String> r216, Function0<Boolean> r217, Function0<Unit> r218, Function0<Boolean> r219, Function0<Integer> r310, String r311, String r312, String r313, Map<String, String> r314, Function0<n1> r315, JSONObject r316, Function0<Integer> r317, int r318) {
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r111, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r112, "authorId");
        Intrinsics.checkNotNullParameter(r210, "secAuthorId");
        Intrinsics.checkNotNullParameter(r211, "screenType");
        Intrinsics.checkNotNullParameter(r212, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r213, "reportParams");
        Intrinsics.checkNotNullParameter(r214, "ecomLiveParams");
        Intrinsics.checkNotNullParameter(r216, "hourlyPurchaseShopId");
        Intrinsics.checkNotNullParameter(r217, "shouldShowAddressNotice");
        Intrinsics.checkNotNullParameter(r218, "hasShowNoticeInShop");
        Intrinsics.checkNotNullParameter(r219, "isHourArrivedRoom");
        Intrinsics.checkNotNullParameter(r310, "roomType");
        Intrinsics.checkNotNullParameter(r311, "displayRoomId");
        Intrinsics.checkNotNullParameter(r312, "displayAnchorId");
        Intrinsics.checkNotNullParameter(r313, "displaySecAnchorId");
        Intrinsics.checkNotNullParameter(r314, "displayReportParams");
        Intrinsics.checkNotNullParameter(r315, "roomInfo");
        Intrinsics.checkNotNullParameter(r317, "instantType");
        this.roomId = r110;
        this.roomUniqueKey = r111;
        this.authorId = r112;
        this.secAuthorId = r210;
        this.screenType = r211;
        this.ecomSceneId = r212;
        this.reportParams = r213;
        this.ecomLiveParams = r214;
        this.passThroughLogData = r215;
        this.hourlyPurchaseShopId = r216;
        this.shouldShowAddressNotice = r217;
        this.hasShowNoticeInShop = r218;
        this.isHourArrivedRoom = r219;
        this.roomType = r310;
        this.displayRoomId = r311;
        this.displayAnchorId = r312;
        this.displaySecAnchorId = r313;
        this.displayReportParams = r314;
        this.roomInfo = r315;
        this.multiRoomData = r316;
        this.instantType = r317;
        this.isShowCart = r318;
        this.searchParams$delegate = LazyKt.lazy(new LiveRoomParams$searchParams$2(this));
    }

    public /* synthetic */ LiveRoomParams(String r210, String r211, String r212, String r213, Function0 r310, String r311, Map r312, Map r313, JSONObject r314, Function0 r315, Function0 r316, Function0 r317, Function0 r318, Function0 r319, String r410, String r411, String r412, Map r413, Function0 r414, JSONObject r415, Function0 r416, int r417, int r418, DefaultConstructorMarker r419) {
        if ((r418 & 256) == 0) goto L5;
        JSONObject r110 = null;
    L7:
        if ((r418 & 16384) == 0) goto L9;
        String r111 = r210;
    L11:
        if ((32768 & r418) == 0) goto L13;
        String r112 = r212;
    L15:
        if ((65536 & r418) == 0) goto L17;
        String r113 = r213;
    L19:
        if ((131072 & r418) == 0) goto L21;
        Map r214 = r312;
    L23:
        if ((r418 & 1048576) == 0) goto L25;
        Function0 r215 = AnonymousClass1.INSTANCE;
    L26:
        this(r210, r211, r212, r213, r310, r311, r312, r313, r110, r315, r316, r317, r318, r319, r111, r112, r113, r214, r414, r415, r215, r417);
        return;
    L25:
        r215 = r416;
        goto L26
    L21:
        r214 = r413;
        goto L23
    L17:
        r113 = r412;
        goto L19
    L13:
        r112 = r411;
        goto L15
    L9:
        r111 = r410;
        goto L11
    L5:
        r110 = r314;
        goto L7
    }
}
