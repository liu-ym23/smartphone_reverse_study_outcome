package com.bytedance.android.live.base.model.feed;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.annotation.IgnoreStyleCheck;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.ad.AdExtra;
import com.bytedance.android.live.base.model.banner.OperationBanner;
import com.bytedance.android.live.base.model.banner.OperationCard;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.base.model.u;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.d;
import com.bytedance.android.livesdk.config.feed.LiveFeedAdParams;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode._Episode_ProtoDecoder;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay._PaidLiveData_ProtoDecoder;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.android.tools.pbadapter.annotation.AfterProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.ProtoField;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import dt2.g;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.FeedItem")
@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0017\u0018\u0000 ¢\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004:\u0004£\u0001¤\u0001B\b¢\u0006\u0005\b¡\u0001\u0010bJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0000J\n\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\u0017\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u001e\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b3\u0010\u001dR\u0018\u00104\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u0010\u001aR\u0018\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bM\u0010\u001aR\u0016\u0010N\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bN\u00100R\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bR\u0010\u0018R\u0016\u0010T\u001a\u00020S8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bY\u0010\u0018R\u0018\u0010Z\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bZ\u0010\u001aR\u0018\u0010[\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u001e\u0010`\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b`\u0010\u001a\u0012\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bc\u0010\u001aR\u0016\u0010d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bd\u0010\u001aR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bf\u0010gR$\u0010\f\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0016\u0010m\u001a\u00020S8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bm\u0010UR\u0018\u0010n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001e\u0010q\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bq\u0010\u001dR*\u0010s\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010\u001d\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\"\u0010x\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u00100\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\"\u0010}\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b}\u00100\u001a\u0004\b}\u0010z\"\u0004\b~\u0010|R\u0016\u0010\u007f\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u007f\u00100R(\u0010\u0080\u0001\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0080\u0001\u0010U\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R*\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u00100R(\u0010\u008d\u0001\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b\u008d\u0001\u0010\u0018\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0006@\u0006X\u0087\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R.\u0010\u0095\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u0010\u001d\u001a\u0005\b\u0096\u0001\u0010u\"\u0005\b\u0097\u0001\u0010wR.\u0010\u009d\u0001\u001a\u0004\u0018\u00010#2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010#8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0014\u0010 \u0001\u001a\u00020\u00078F¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001¨\u0006¥\u0001"}, d2 = {"Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Lcom/bytedance/android/live/base/model/feed/ItemWrapper;", "Lcom/bytedance/android/live/base/model/Item;", "", "", "", "saasInnerFeedDebugLogic", "", "mockValue", "saasProcessMockValue", "source", "setRoomFrom", MapController.ITEM_LAYER_TAG, "logPb", "requestId", "toString", "o", "", "equals", "", "hashCode", "init", "clone", "type", "I", "resId", "Ljava/lang/String;", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "liveRecommendInfo", "Lcom/google/gson/JsonObject;", "data", "Lcom/google/gson/JsonObject;", "adRawString", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "_room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Lcom/bytedance/android/live/base/model/banner/b;", "bannerContainer", "Lcom/bytedance/android/live/base/model/banner/b;", "Lcom/bytedance/android/live/base/model/banner/c;", "rankRoundBanner", "Lcom/bytedance/android/live/base/model/banner/c;", "Lcom/bytedance/android/live/base/model/a;", "cateCell", "Lcom/bytedance/android/live/base/model/a;", "isRecommendCard", "Z", "isPseudoLiving", "Lcom/bytedance/android/live/base/model/tab/a;", "tabs", "liveReason", "Lcom/bytedance/android/live/base/model/follow/ScheduledLiveItem;", "scheduledLive", "Lcom/bytedance/android/live/base/model/follow/ScheduledLiveItem;", "Lcom/bytedance/android/live/base/model/follow/PlaceHolder;", "placeHolder", "Lcom/bytedance/android/live/base/model/follow/PlaceHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "Lcom/bytedance/android/live/base/model/Appointment;", ActivityVO.APPOINTMENT, "Lcom/bytedance/android/live/base/model/Appointment;", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "feedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "Lcom/bytedance/android/live/base/model/feed/WidgetGuide;", "widgetGuide", "Lcom/bytedance/android/live/base/model/feed/WidgetGuide;", "Lcom/bytedance/android/live/base/model/banner/OperationBanner;", "operationBanner", "Lcom/bytedance/android/live/base/model/banner/OperationBanner;", "Lcom/bytedance/android/live/base/model/banner/OperationCard;", "operationCard", "Lcom/bytedance/android/live/base/model/banner/OperationCard;", "supplyType", "isAd", "Lcom/bytedance/android/live/base/model/ad/AdExtra;", "adExtra", "Lcom/bytedance/android/live/base/model/ad/AdExtra;", "contentCategory", "", "latestWatchTime", "J", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveData;", "paidLiveCard", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveData;", "cameraType", "itemPitayaParam", "liveStatus", "Ljava/lang/Integer;", "Lcom/bytedance/android/live/base/model/user/User;", "userInfo", "Lcom/bytedance/android/live/base/model/user/User;", "itemLogPb", "getItemLogPb$annotations", "()V", "searchReqId", "searchId", "Lorg/json/JSONObject;", "adJSONObject", "Lorg/json/JSONObject;", "Lcom/bytedance/android/live/base/model/Item;", "getItem", "()Lcom/bytedance/android/live/base/model/Item;", "setItem", "(Lcom/bytedance/android/live/base/model/Item;)V", "lastPlayTime", "object", "Ljava/lang/Object;", "Lcom/bytedance/android/live/base/model/banner/a;", PromotionProductPrivilegesStruct.BANNERS, "", "liveHistoryItems", "getLiveHistoryItems", "()Ljava/util/List;", "setLiveHistoryItems", "(Ljava/util/List;)V", "hasMoreHistoryItems", "getHasMoreHistoryItems", "()Z", "setHasMoreHistoryItems", "(Z)V", "isHideBucketItem", "setHideBucketItem", "needLogWhenRemove", "feedFetchCount", "getFeedFetchCount", "()J", "setFeedFetchCount", "(J)V", "Lcom/bytedance/android/live/base/model/feed/FeedItem$HistoryStatus;", "historyStatus", "Lcom/bytedance/android/live/base/model/feed/FeedItem$HistoryStatus;", "getHistoryStatus", "()Lcom/bytedance/android/live/base/model/feed/FeedItem$HistoryStatus;", "setHistoryStatus", "(Lcom/bytedance/android/live/base/model/feed/FeedItem$HistoryStatus;)V", "repeatDisable", "pullType", "getPullType", "()I", "setPullType", "(I)V", "Lcom/bytedance/android/live/base/model/feed/b;", "replaceExtra", "Lcom/bytedance/android/live/base/model/feed/b;", "skylightList", "getSkylightList", "setSkylightList", "value", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "room", "getFeedbackId", "()Ljava/lang/String;", "feedbackId", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HistoryStatus", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FeedItem implements ItemWrapper<Item>, Cloneable, h {
    public static final a Companion = null;

    @ProtoField("data")
    protected transient Room _room;

    @SerializedName("ad_extra")
    public AdExtra adExtra;

    @IgnoreStyleCheck
    public transient JSONObject adJSONObject;

    @SerializedName("ad")
    public String adRawString;

    @SerializedName(ActivityVO.APPOINTMENT)
    public Appointment appointment;

    @SerializedName("banner")
    public com.bytedance.android.live.base.model.banner.b bannerContainer;
    public transient List<com.bytedance.android.live.base.model.banner.a> banners;

    @SerializedName("camera_type")
    public int cameraType;

    @SerializedName("cate_cell")
    public com.bytedance.android.live.base.model.a cateCell;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTER_CONTENT_CATEGORY)
    public int contentCategory;

    @SerializedName("data")
    @IgnoreProtoDecode
    public JsonObject data;

    @SerializedName("episode")
    public Episode episode;
    private long feedFetchCount;

    @SerializedName("live_feedback_card")
    public FeedbackCard feedbackCard;
    private transient boolean hasMoreHistoryItems;
    private transient HistoryStatus historyStatus;

    @SerializedName("is_ad")
    public boolean isAd;
    private boolean isHideBucketItem;

    @SerializedName("is_pseudo_living")
    public boolean isPseudoLiving;

    @SerializedName("is_recommend_card")
    public boolean isRecommendCard;
    private transient Item item;

    @SerializedName(ILiveRoomPlayFragmentConstant.ITEM_LOG_PB)
    public String itemLogPb;

    @SerializedName("item_pitaya_param")
    public String itemPitayaParam;
    public long lastPlayTime;

    @SerializedName("latest_watch_time")
    public long latestWatchTime;
    private transient List<FeedItem> liveHistoryItems;

    @SerializedName("live_reason")
    public String liveReason;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO)
    public String liveRecommendInfo;

    @SerializedName("live_status")
    public Integer liveStatus;
    public transient String logPb;
    public boolean needLogWhenRemove;

    @IgnoreStyleCheck
    public transient Object object;

    @SerializedName("operation_banner")
    public OperationBanner operationBanner;

    @SerializedName("operation_card")
    public OperationCard operationCard;

    @SerializedName("paid_live_card")
    public PaidLiveData paidLiveCard;

    @SerializedName(GXTemplateKey.GAIAX_PLACEHOLDER)
    public PlaceHolder placeHolder;
    private transient int pullType;

    @SerializedName("rank_round_banner")
    public com.bytedance.android.live.base.model.banner.c rankRoundBanner;
    public transient boolean repeatDisable;
    public b replaceExtra;

    @SerializedName("rid")
    public String resId;

    @SerializedName("UserLiveRecord")
    public ScheduledLiveItem scheduledLive;

    @IgnoreStyleCheck
    public transient String searchId;

    @IgnoreStyleCheck
    public transient String searchReqId;
    private List<Room> skylightList;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SOURCE)
    public String supplyType;

    @SerializedName("tabs")
    public List<com.bytedance.android.live.base.model.tab.a> tabs;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<String> tags;

    @SerializedName("type")
    public int type;

    @SerializedName("user_info")
    public User userInfo;

    @SerializedName("widget_guide")
    public WidgetGuide widgetGuide;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/base/model/feed/FeedItem$HistoryStatus;", "", "EMPTY", "NO_LOGIN", "NO_PERiMISSION", EffectConstants.NORMAL, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HistoryStatus extends Enum<HistoryStatus> {
        public static final HistoryStatus EMPTY = null;
        public static final HistoryStatus NORMAL = null;
        public static final HistoryStatus NO_LOGIN = null;
        public static final HistoryStatus NO_PERiMISSION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HistoryStatus[] f58831a = null;

        static {
            HistoryStatus r100 = new HistoryStatus("EMPTY", 0);
            EMPTY = r100;
            HistoryStatus r101 = new HistoryStatus("NO_LOGIN", 1);
            NO_LOGIN = r101;
            HistoryStatus r102 = new HistoryStatus("NO_PERiMISSION", 2);
            NO_PERiMISSION = r102;
            HistoryStatus r103 = new HistoryStatus(EffectConstants.NORMAL, 3);
            NORMAL = r103;
            f58831a = new HistoryStatus[]{r100, r101, r102, r103};
        }

        public static HistoryStatus valueOf(String r100) {
            return (HistoryStatus) r27.a.a(HistoryStatus.class, r100);
        }

        public static HistoryStatus[] values() {
            return (HistoryStatus[]) f58831a.clone();
        }

        public HistoryStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getItemLogPb$annotations() {
    }

    private final void saasInnerFeedDebugLogic() {
        String r100 = g.f470001a.getValue();
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.adRawString = saasProcessMockValue(r100);
    L5:
        String r101 = dt2.h.f470002a.getValue();
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.itemLogPb = r101;
        return;
    }

    public final Item getItem() {
        Item r100 = this.item;
        if (r100 == null) goto L5;
        return r100;
    L5:
        int r101 = this.type;
        if (r101 != 1) goto L8;
    L23:
        this.item = getRoom();
        saasInnerFeedDebugLogic();
    L25:
        return this.item;
    L8:
        if (r101 == 2) goto L23;
        if (r101 == 4) goto L23;
        if (r101 == 27) goto L23;
        if (r101 == 5) goto L23;
        if (r101 == 12) goto L23;
        if (r101 == 11) goto L23;
        if (r101 != 3) goto L25;
        this.item = getRoom();
        goto L25
    }

    public final Room getRoom() {
        Room r100 = this._room;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Room r101 = (Room) GsonProtectorUtils.fromJson(GsonHelper.get(), this.data, Room.class);
        this._room = r101;
        return r101;
    }

    public int hashCode() {
        int r100 = this.type;
        Object r101 = null;
        if (r100 != 11) goto L10;
        Object[] r102 = new Object[1];
        PlaceHolder r103 = this.placeHolder;
        if (r103 == null) goto L7;
        r101 = r103.getMsg();
    L7:
        r102[0] = r101;
        return Arrays.hashCode(r102);
    L10:
        if (r100 != 12) goto L17;
        Object[] r104 = new Object[1];
        ScheduledLiveItem r105 = this.scheduledLive;
        if (r105 == null) goto L14;
        r101 = Long.valueOf(r105.getUserId());
    L14:
        r104[0] = r101;
        return Arrays.hashCode(r104);
    L17:
        return Arrays.hashCode(new Object[]{getItem()});
    }

    @AfterProtoDecode
    public final void init() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
    L20:
        this.item = getRoom();
        saasInnerFeedDebugLogic();
        return;
    L5:
        if (r100 == 2) goto L20;
        if (r100 == 4) goto L20;
        if (r100 == 27) goto L20;
        if (r100 == 5) goto L20;
        if (r100 == 12) goto L20;
        if (r100 == 11) goto L20;
        if (r100 != 3) goto L22;
        this.item = getRoom();
        return;
    }

    public FeedItem() {
        this.searchReqId = "";
        this.searchId = "";
        this.feedFetchCount = -1;
        this.historyStatus = HistoryStatus.NORMAL;
        this.pullType = -1;
    }

    public Object clone() {
        return super.clone();
    }

    public final String getFeedbackId() {
        if (getRoom() == null) goto L10;
        Room r100 = getRoom();
        Intrinsics.checkNotNull(r100);
        if (r100.mFeedbackCard == null) goto L10;
        Room r101 = getRoom();
        Intrinsics.checkNotNull(r101);
        FeedbackCard r102 = r101.mFeedbackCard;
        Intrinsics.checkNotNull(r102);
        if (r102.feedbackId == null) goto L10;
        Room r103 = getRoom();
        Intrinsics.checkNotNull(r103);
        FeedbackCard r104 = r103.mFeedbackCard;
        Intrinsics.checkNotNull(r104);
        return String.valueOf(r104.feedbackId);
    L10:
        FeedbackCard r105 = this.feedbackCard;
        if (r105 == null) goto L15;
        Intrinsics.checkNotNull(r105);
        if (r105.feedbackId == null) goto L15;
        FeedbackCard r106 = this.feedbackCard;
        Intrinsics.checkNotNull(r106);
        return String.valueOf(r106.feedbackId);
    L15:
        return "";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.live.base.model.feed.ItemWrapper
    public Item item() {
        return getItem();
    }

    public String toString() {
        if (getItem() != null) goto L6;
        return "null";
    L6:
        return String.valueOf(getItem());
    }

    public final long getFeedFetchCount() {
        return this.feedFetchCount;
    }

    public final boolean getHasMoreHistoryItems() {
        return this.hasMoreHistoryItems;
    }

    public final HistoryStatus getHistoryStatus() {
        return this.historyStatus;
    }

    public final List<FeedItem> getLiveHistoryItems() {
        return this.liveHistoryItems;
    }

    public final int getPullType() {
        return this.pullType;
    }

    public final List<Room> getSkylightList() {
        return this.skylightList;
    }

    public final boolean isHideBucketItem() {
        return this.isHideBucketItem;
    }

    @Override // com.bytedance.android.live.base.model.feed.ItemWrapper
    public String logPb() {
        return this.logPb;
    }

    @Override // com.bytedance.android.live.base.model.feed.ItemWrapper
    public String requestId() {
        return this.resId;
    }

    @Override // com.bytedance.android.live.base.model.feed.ItemWrapper
    public /* bridge */ /* synthetic */ Item item() {
        return item();
    }

    public FeedItem(am3.g r100) {
        this.tags = new ArrayList();
        this.tabs = new ArrayList();
        this.searchReqId = "";
        this.searchId = "";
        this.feedFetchCount = -1;
        this.historyStatus = HistoryStatus.NORMAL;
        this.pullType = -1;
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L40;
        switch(r102) {
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            case 9: goto L30;
            case 10: goto L6;
            case 11: goto L29;
            case 12: goto L28;
            case 13: goto L27;
            case 14: goto L26;
            case 15: goto L25;
            case 16: goto L24;
            case 17: goto L6;
            case 18: goto L23;
            case 19: goto L22;
            case 20: goto L21;
            case 21: goto L6;
            case 22: goto L6;
            case 23: goto L20;
            case 24: goto L19;
            case 25: goto L18;
            case 26: goto L6;
            case 27: goto L17;
            case 28: goto L16;
            case 29: goto L6;
            case 30: goto L15;
            case 31: goto L14;
            case 32: goto L13;
            case 33: goto L12;
            case 34: goto L6;
            case 35: goto L11;
            case 36: goto L10;
            case 37: goto L9;
            case 38: goto L6;
            case 39: goto L8;
            case 40: goto L7;
            default: goto L6;
        };
    L7:
        this.widgetGuide = new WidgetGuide(r100);
        goto L3
    L8:
        this.itemLogPb = am3.h.c(r100);
        goto L3
    L9:
        this.itemPitayaParam = am3.h.c(r100);
        goto L3
    L10:
        this.cameraType = r100.i();
        goto L3
    L11:
        this.paidLiveCard = _PaidLiveData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L12:
        this.latestWatchTime = r100.j();
        goto L3
    L13:
        this.supplyType = am3.h.c(r100);
        goto L3
    L14:
        this.liveRecommendInfo = am3.h.c(r100);
        goto L3
    L15:
        this.contentCategory = r100.i();
        goto L3
    L16:
        this.operationCard = new OperationCard(r100);
        goto L3
    L17:
        this.operationBanner = new OperationBanner(r100);
        goto L3
    L18:
        this.adExtra = new AdExtra(r100);
        goto L3
    L19:
        this.isAd = am3.h.a(r100);
        goto L3
    L20:
        this.feedbackCard = new FeedbackCard(r100);
        goto L3
    L21:
        this.userInfo = new User(r100);
        goto L3
    L22:
        this.liveStatus = Integer.valueOf(r100.i());
        goto L3
    L23:
        this.appointment = u.a(r100);
        goto L3
    L24:
        this.episode = _Episode_ProtoDecoder.decodeStatic(r100);
        goto L3
    L25:
        this.scheduledLive = new ScheduledLiveItem(r100);
        goto L3
    L26:
        this.placeHolder = new PlaceHolder(r100);
        goto L3
    L27:
        this.liveReason = am3.h.c(r100);
        goto L3
    L28:
        this.isPseudoLiving = am3.h.a(r100);
        goto L3
    L29:
        List r103 = this.tabs;
        Object r104 = new com.bytedance.android.live.base.model.tab.a(r100);
    L36:
        r103.add(r104);
        goto L3
    L30:
        this.isRecommendCard = am3.h.a(r100);
        goto L3
    L31:
        this.cateCell = new com.bytedance.android.live.base.model.a(r100);
        goto L3
    L32:
        this.rankRoundBanner = new com.bytedance.android.live.base.model.banner.c(r100);
        goto L3
    L33:
        this.bannerContainer = new com.bytedance.android.live.base.model.banner.b(r100);
        goto L3
    L34:
        this.adRawString = am3.h.c(r100);
        goto L3
    L35:
        r103 = this.tags;
        r104 = am3.h.c(r100);
        goto L36
    L37:
        this._room = new Room(r100);
        goto L3
    L38:
        this.resId = am3.h.c(r100);
        goto L3
    L39:
        this.type = (int) r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L40:
        r100.d(r101);
    }

    private final String saasProcessMockValue(String r110) {
        LiveFeedAdParams r111 = (LiveFeedAdParams) GsonProtectorUtils.fromJson(GsonHelper.get(), r110, LiveFeedAdParams.class);
        SecureRandom r100 = new SecureRandom();
        String r101 = r111.getAdId();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "mockadid_" + r100.nextInt(1000);
    L5:
        String r102 = r101;
        String r103 = r111.getCreativeId();
        if (TextUtils.isEmpty(r103) == false) goto L8;
        String r104 = "mockcid_" + r100.nextInt(1000);
    L10:
        return GsonProtectorUtils.toJson(GsonHelper.get(), new LiveFeedAdParams(r102, r104, r111.getLogExtra(), r111.getLiveSDKInfoExtra(), r111.getEcpm(), r111.getCouponApiParams()));
    L8:
        r104 = r103;
        goto L10
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((true ^ Intrinsics.areEqual(getClass(), r100.getClass())) == true) goto L35;
        FeedItem r101 = (FeedItem) r100;
        int r102 = this.type;
        Object r103 = null;
        if (r102 != 11) goto L21;
        PlaceHolder r104 = this.placeHolder;
        if (r104 == null) goto L14;
        String r105 = r104.getMsg();
    L15:
        PlaceHolder r106 = r101.placeHolder;
        if (r106 == null) goto L19;
        r103 = r106.getMsg();
    L19:
        return d.a(r105, r103);
    L14:
        r105 = null;
        goto L15
    L21:
        if (r102 != 12) goto L32;
        ScheduledLiveItem r107 = this.scheduledLive;
        if (r107 == null) goto L25;
        Long r108 = Long.valueOf(r107.getUserId());
    L26:
        ScheduledLiveItem r109 = r101.scheduledLive;
        if (r109 == null) goto L30;
        r103 = Long.valueOf(r109.getUserId());
    L30:
        return d.a(r108, r103);
    L25:
        r108 = null;
        goto L26
    L32:
        return d.a(getItem(), r101.getItem());
    L35:
        return false;
    }

    public final void setFeedFetchCount(long r100) {
        this.feedFetchCount = r100;
    }

    public final void setHasMoreHistoryItems(boolean r100) {
        this.hasMoreHistoryItems = r100;
    }

    public final void setHideBucketItem(boolean r100) {
        this.isHideBucketItem = r100;
    }

    public final void setHistoryStatus(HistoryStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.historyStatus = r100;
    }

    public final void setItem(Item r100) {
        this.item = r100;
    }

    public final void setLiveHistoryItems(List<FeedItem> r100) {
        this.liveHistoryItems = r100;
    }

    public final void setPullType(int r100) {
        this.pullType = r100;
    }

    public final void setRoom(Room r100) {
        this._room = r100;
    }

    public final void setRoomFrom(FeedItem r100) {
        Room r101 = null;
        if (r100 == null) goto L5;
        JsonObject r102 = r100.data;
    L6:
        this.data = r102;
        if (r100 == null) goto L9;
        r101 = r100.getRoom();
    L9:
        setRoom(r101);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void setSkylightList(List<Room> r100) {
        this.skylightList = r100;
    }
}
