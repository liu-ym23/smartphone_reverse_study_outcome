package com.bytedance.android.shopping.anchorv4.nav;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\bx\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0015\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010*J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010w\u001a\u00020\u0015HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010z\u001a\u00020\tHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\rHÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00108J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010?J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008f\u0001\u001a\u00020\tHÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\rHÆ\u0003J\u009c\u0003\u0010\u0093\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\u00152\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0094\u0001J\u0016\u0010\u0095\u0001\u001a\u00020\u00152\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001HÖ\u0003J\u0013\u0010\u0098\u0001\u001a\u00020\u00002\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001J\n\u0010\u009b\u0001\u001a\u00020\rHÖ\u0001J\n\u0010\u009c\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00100R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00100R\u001a\u0010%\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u001c\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00100\"\u0004\bB\u00102R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00100\"\u0004\bD\u00102R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010K\"\u0004\bL\u0010MR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00100\"\u0004\bO\u00102R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00100\"\u0004\bQ\u00102R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00100\"\u0004\bS\u00102R\u0018\u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u0016\u0010!\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010KR\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00100R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00100\"\u0004\bX\u00102R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00100\"\u0004\b^\u00102R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010Z\"\u0004\b`\u0010\\R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u00100\"\u0004\bb\u00102R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00100\"\u0004\bd\u00102R\u001a\u0010#\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010;\u001a\u0004\be\u00108R\u0013\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u00100R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u00100R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u00100R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00100\"\u0004\bj\u00102R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00100\"\u0004\bl\u00102R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00100\"\u0004\bn\u00102R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u00100R\u0016\u0010\u001f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010H¨\u0006\u009d\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;", "Ljava/io/Serializable;", "productId", "", "promotionId", "itemId", "authorId", "secAuthorId", "promotionSource", "", "shopId", "liveRoomId", "followStatus", "", "sourcePage", "enterMethod", "sourceMethod", "carrierSource", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "isLuban", "", "marketChannel", "requestAdditions", "productMinPrice", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "title", "shareTemplate", "firstImage", "Lcom/bytedance/android/ec/model/ECUrlModel;", "visitorCount", "metaParamWithoutSceneId", "millionDiscount", "detailUrlWithoutSceneId", "shareButtonAnimation", "ngroupBuyToken", "displayShareTouchPoint", "sharePanelSchema", "shareMonitorName", "clickFrom", "ecomSceneId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "getCarrierSource", "setCarrierSource", "getChannelId", "setChannelId", "getChannelType", "()Ljava/lang/Integer;", "setChannelType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickFrom", "getDetailUrlWithoutSceneId", "getDisplayShareTouchPoint", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEcomSceneId", "setEcomSceneId", "getEnterMethod", "setEnterMethod", "getFirstImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getFollowStatus", "()I", "setFollowStatus", "(I)V", "()Z", "setLuban", "(Z)V", "getItemId", "setItemId", "getLiveRoomId", "setLiveRoomId", "getMarketChannel", "setMarketChannel", "getMetaParamWithoutSceneId", "getMillionDiscount", "getNgroupBuyToken", "getProductId", "setProductId", "getProductMinPrice", "()J", "setProductMinPrice", "(J)V", "getPromotionId", "setPromotionId", "getPromotionSource", "setPromotionSource", "getRequestAdditions", "setRequestAdditions", "getSecAuthorId", "setSecAuthorId", "getShareButtonAnimation", "getShareMonitorName", "getSharePanelSchema", "getShareTemplate", "getShopId", "setShopId", "getSourceMethod", "setSourceMethod", "getSourcePage", "setSourcePage", "getTitle", "getVisitorCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;ZLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/nav/ShareMeta;", "equals", "other", "", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareMeta implements Serializable {
    private ECAdLogExtra adLogExtra;
    private String authorId;
    private String carrierSource;
    private String channelId;
    private Integer channelType;
    private final String clickFrom;

    @SerializedName("detail_url_without_scene_id")
    private final String detailUrlWithoutSceneId;

    @SerializedName("display_share_touch_point")
    private final Boolean displayShareTouchPoint;
    private String ecomSceneId;
    private String enterMethod;

    @SerializedName("first_image")
    private final ECUrlModel firstImage;
    private int followStatus;
    private boolean isLuban;
    private String itemId;
    private String liveRoomId;
    private String marketChannel;

    @SerializedName("meta_param_without_scene_id")
    private final String metaParamWithoutSceneId;

    @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_MILLION_DISCOUNT)
    private final boolean millionDiscount;

    @SerializedName("ngroup_buy_token")
    private final String ngroupBuyToken;
    private String productId;
    private long productMinPrice;
    private String promotionId;
    private long promotionSource;
    private String requestAdditions;
    private String secAuthorId;

    @SerializedName("share_button_animation")
    private final Integer shareButtonAnimation;
    private final String shareMonitorName;

    @SerializedName("share_panel_schema")
    private final String sharePanelSchema;

    @SerializedName("share_template")
    private final String shareTemplate;
    private String shopId;
    private String sourceMethod;
    private String sourcePage;

    @SerializedName("title")
    private final String title;

    @SerializedName("visitor_count")
    private final int visitorCount;

    public ShareMeta() {
        this(null, null, null, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, 0, null, null, null, null, null, 0, null, false, null, null, null, null, null, null, null, null, -1, 3, null);
    }

    public static /* synthetic */ ShareMeta copy$default(ShareMeta r110, String r111, String r112, String r210, String r211, String r212, long r213, String r214, String r215, int r216, String r217, String r218, String r310, String r311, ECAdLogExtra r312, boolean r313, String r314, String r315, long r316, String r317, Integer r318, String r410, String r411, ECUrlModel r412, int r413, String r414, boolean r415, String r416, Integer r417, String r418, Boolean r419, String r510, String r511, String r512, String r513, int r514, int r515, Object r516) {
        if ((r514 & 1) == 0) goto L5;
        String r100 = r110.productId;
    L7:
        if ((r514 & 2) == 0) goto L9;
        String r101 = r110.promotionId;
    L11:
        if ((r514 & 4) == 0) goto L13;
        String r102 = r110.itemId;
    L15:
        if ((r514 & 8) == 0) goto L17;
        String r103 = r110.authorId;
    L19:
        if ((r514 & 16) == 0) goto L21;
        String r104 = r110.secAuthorId;
    L23:
        if ((r514 & 32) == 0) goto L25;
        long r105 = r110.promotionSource;
    L27:
        if ((r514 & 64) == 0) goto L29;
        String r106 = r110.shopId;
    L31:
        if ((r514 & 128) == 0) goto L33;
        String r113 = r110.liveRoomId;
    L35:
        if ((r514 & 256) == 0) goto L37;
        int r114 = r110.followStatus;
    L39:
        if ((r514 & 512) == 0) goto L41;
        String r115 = r110.sourcePage;
    L43:
        if ((r514 & 1024) == 0) goto L45;
        String r116 = r110.enterMethod;
    L47:
        if ((r514 & 2048) == 0) goto L49;
        String r117 = r110.sourceMethod;
    L51:
        if ((r514 & 4096) == 0) goto L53;
        String r118 = r110.carrierSource;
    L54:
        String r319 = r118;
        if ((r514 & 8192) == 0) goto L57;
        ECAdLogExtra r119 = r110.adLogExtra;
    L58:
        ECAdLogExtra r320 = r119;
        if ((r514 & 16384) == 0) goto L61;
        boolean r120 = r110.isLuban;
    L62:
        boolean r321 = r120;
        if ((r514 & 32768) == 0) goto L65;
        String r121 = r110.marketChannel;
    L66:
        String r322 = r121;
        if ((r514 & 65536) == 0) goto L69;
        String r122 = r110.requestAdditions;
    L70:
        String r323 = r117;
        String r324 = r122;
        if ((r514 & 131072) == 0) goto L73;
        long r123 = r110.productMinPrice;
    L74:
        long r325 = r123;
        if ((r514 & 262144) == 0) goto L77;
        String r124 = r110.channelId;
    L79:
        if ((524288 & r514) == 0) goto L81;
        Integer r125 = r110.channelType;
    L82:
        Integer r326 = r125;
        if ((r514 & 1048576) == 0) goto L85;
        String r126 = r110.title;
    L86:
        String r420 = r126;
        if ((r514 & 2097152) == 0) goto L89;
        String r127 = r110.shareTemplate;
    L90:
        String r421 = r127;
        if ((r514 & 4194304) == 0) goto L93;
        ECUrlModel r128 = r110.firstImage;
    L94:
        ECUrlModel r422 = r128;
        if ((r514 & 8388608) == 0) goto L97;
        int r129 = r110.visitorCount;
    L98:
        int r423 = r129;
        if ((r514 & 16777216) == 0) goto L101;
        String r130 = r110.metaParamWithoutSceneId;
    L102:
        String r424 = r130;
        if ((r514 & 33554432) == 0) goto L105;
        boolean r131 = r110.millionDiscount;
    L106:
        boolean r425 = r131;
        if ((r514 & 67108864) == 0) goto L109;
        String r132 = r110.detailUrlWithoutSceneId;
    L110:
        String r426 = r132;
        if ((r514 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r133 = r110.shareButtonAnimation;
    L114:
        Integer r427 = r133;
        if ((r514 & 268435456) == 0) goto L117;
        String r134 = r110.ngroupBuyToken;
    L118:
        String r428 = r134;
        if ((r514 & 536870912) == 0) goto L121;
        Boolean r135 = r110.displayShareTouchPoint;
    L122:
        Boolean r429 = r135;
        if ((r514 & 1073741824) == 0) goto L125;
        String r136 = r110.sharePanelSchema;
    L127:
        if ((r514 & Integer.MIN_VALUE) == 0) goto L129;
        String r107 = r110.shareMonitorName;
    L130:
        String r517 = r107;
        if ((r515 & 1) == 0) goto L133;
        String r108 = r110.clickFrom;
    L134:
        String r518 = r108;
        if ((r515 & 2) == 0) goto L137;
        String r109 = r110.ecomSceneId;
    L139:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r323, r319, r320, r321, r322, r324, r325, r124, r326, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r136, r517, r518, r109);
    L137:
        r109 = r513;
        goto L139
    L133:
        r108 = r512;
        goto L134
    L129:
        r107 = r511;
        goto L130
    L125:
        r136 = r510;
        goto L127
    L121:
        r135 = r419;
        goto L122
    L117:
        r134 = r418;
        goto L118
    L113:
        r133 = r417;
        goto L114
    L109:
        r132 = r416;
        goto L110
    L105:
        r131 = r415;
        goto L106
    L101:
        r130 = r414;
        goto L102
    L97:
        r129 = r413;
        goto L98
    L93:
        r128 = r412;
        goto L94
    L89:
        r127 = r411;
        goto L90
    L85:
        r126 = r410;
        goto L86
    L81:
        r125 = r318;
        goto L82
    L77:
        r124 = r317;
        goto L79
    L73:
        r123 = r316;
        goto L74
    L69:
        r122 = r315;
        goto L70
    L65:
        r121 = r314;
        goto L66
    L61:
        r120 = r313;
        goto L62
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
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
        return this.productId;
    }

    public final String component10() {
        return this.sourcePage;
    }

    public final String component11() {
        return this.enterMethod;
    }

    public final String component12() {
        return this.sourceMethod;
    }

    public final String component13() {
        return this.carrierSource;
    }

    public final ECAdLogExtra component14() {
        return this.adLogExtra;
    }

    public final boolean component15() {
        return this.isLuban;
    }

    public final String component16() {
        return this.marketChannel;
    }

    public final String component17() {
        return this.requestAdditions;
    }

    public final long component18() {
        return this.productMinPrice;
    }

    public final String component19() {
        return this.channelId;
    }

    public final String component2() {
        return this.promotionId;
    }

    public final Integer component20() {
        return this.channelType;
    }

    public final String component21() {
        return this.title;
    }

    public final String component22() {
        return this.shareTemplate;
    }

    public final ECUrlModel component23() {
        return this.firstImage;
    }

    public final int component24() {
        return this.visitorCount;
    }

    public final String component25() {
        return this.metaParamWithoutSceneId;
    }

    public final boolean component26() {
        return this.millionDiscount;
    }

    public final String component27() {
        return this.detailUrlWithoutSceneId;
    }

    public final Integer component28() {
        return this.shareButtonAnimation;
    }

    public final String component29() {
        return this.ngroupBuyToken;
    }

    public final String component3() {
        return this.itemId;
    }

    public final Boolean component30() {
        return this.displayShareTouchPoint;
    }

    public final String component31() {
        return this.sharePanelSchema;
    }

    public final String component32() {
        return this.shareMonitorName;
    }

    public final String component33() {
        return this.clickFrom;
    }

    public final String component34() {
        return this.ecomSceneId;
    }

    public final String component4() {
        return this.authorId;
    }

    public final String component5() {
        return this.secAuthorId;
    }

    public final long component6() {
        return this.promotionSource;
    }

    public final String component7() {
        return this.shopId;
    }

    public final String component8() {
        return this.liveRoomId;
    }

    public final int component9() {
        return this.followStatus;
    }

    public final ShareMeta copy(String r310, String r410, String r411, String r412, String r413, long r414, String r415, String r416, int r417, String r418, String r510, String r511, String r512, ECAdLogExtra r513, boolean r514, String r515, String r516, long r517, String r518, Integer r610, String r611, String r612, ECUrlModel r613, int r614, String r615, boolean r616, String r617, Integer r618, String r619, Boolean r710, String r711, String r712, String r713, String r714) {
        return new ShareMeta(r310, r410, r411, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShareMeta) == false) goto L74;
        ShareMeta r101 = (ShareMeta) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L16;
        return false;
    L16:
        if (this.promotionSource == r101.promotionSource) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.liveRoomId, r101.liveRoomId) == true) goto L22;
        return false;
    L22:
        if (this.followStatus == r101.followStatus) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.sourceMethod, r101.sourceMethod) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.carrierSource, r101.carrierSource) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.adLogExtra, r101.adLogExtra) == true) goto L34;
        return false;
    L34:
        if (this.isLuban == r101.isLuban) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.marketChannel, r101.marketChannel) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.requestAdditions, r101.requestAdditions) == true) goto L40;
        return false;
    L40:
        if (this.productMinPrice == r101.productMinPrice) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.shareTemplate, r101.shareTemplate) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.firstImage, r101.firstImage) == true) goto L52;
        return false;
    L52:
        if (this.visitorCount == r101.visitorCount) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.metaParamWithoutSceneId, r101.metaParamWithoutSceneId) == true) goto L56;
        return false;
    L56:
        if (this.millionDiscount == r101.millionDiscount) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.detailUrlWithoutSceneId, r101.detailUrlWithoutSceneId) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.shareButtonAnimation, r101.shareButtonAnimation) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.ngroupBuyToken, r101.ngroupBuyToken) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.displayShareTouchPoint, r101.displayShareTouchPoint) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.sharePanelSchema, r101.sharePanelSchema) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.shareMonitorName, r101.shareMonitorName) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.clickFrom, r101.clickFrom) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.ecomSceneId, r101.ecomSceneId) == true) goto L112;
        return false;
    L112:
        return true;
    L74:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v102 */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promotionId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.itemId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.authorId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.secAuthorId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.promotionSource;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        String r118 = this.shopId;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.liveRoomId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (((r120 + r122) * 31) + this.followStatus) * 31;
        String r124 = this.sourcePage;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.enterMethod;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.sourceMethod;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.carrierSource;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        ECAdLogExtra r136 = this.adLogExtra;
        if (r136 == null) goto L49;
        int r137 = r136.hashCode();
    L50:
        int r138 = (r135 + r137) * 31;
        boolean r139 = this.isLuban;
        ?? r140 = 1;
        ?? r141 = r139;
        if (r139 == false) goto L53;
        r141 = 1;
    L53:
        int r142 = (r138 + r141) * 31;
        String r143 = this.marketChannel;
        if (r143 == null) goto L56;
        int r144 = r143.hashCode();
    L57:
        int r145 = (r142 + r144) * 31;
        String r146 = this.requestAdditions;
        if (r146 == null) goto L60;
        int r147 = r146.hashCode();
    L61:
        long r148 = this.productMinPrice;
        int r149 = (((r145 + r147) * 31) + ((int) (r148 ^ (r148 >>> 32)))) * 31;
        String r150 = this.channelId;
        if (r150 == null) goto L64;
        int r151 = r150.hashCode();
    L65:
        int r152 = (r149 + r151) * 31;
        Integer r153 = this.channelType;
        if (r153 == null) goto L68;
        int r154 = r153.hashCode();
    L69:
        int r155 = (r152 + r154) * 31;
        String r156 = this.title;
        if (r156 == null) goto L72;
        int r157 = r156.hashCode();
    L73:
        int r158 = (r155 + r157) * 31;
        String r159 = this.shareTemplate;
        if (r159 == null) goto L76;
        int r160 = r159.hashCode();
    L77:
        int r161 = (r158 + r160) * 31;
        ECUrlModel r162 = this.firstImage;
        if (r162 == null) goto L80;
        int r163 = r162.hashCode();
    L81:
        int r164 = (((r161 + r163) * 31) + this.visitorCount) * 31;
        String r165 = this.metaParamWithoutSceneId;
        if (r165 == null) goto L84;
        int r166 = r165.hashCode();
    L85:
        int r167 = (r164 + r166) * 31;
        boolean r168 = this.millionDiscount;
        if (r168 == true) goto L89;
        r140 = r168;
    L89:
        int r169 = (r167 + r140) * 31;
        String r170 = this.detailUrlWithoutSceneId;
        if (r170 == null) goto L92;
        int r171 = r170.hashCode();
    L93:
        int r172 = (r169 + r171) * 31;
        Integer r173 = this.shareButtonAnimation;
        if (r173 == null) goto L96;
        int r174 = r173.hashCode();
    L97:
        int r175 = (r172 + r174) * 31;
        String r176 = this.ngroupBuyToken;
        if (r176 == null) goto L100;
        int r177 = r176.hashCode();
    L101:
        int r178 = (r175 + r177) * 31;
        Boolean r179 = this.displayShareTouchPoint;
        if (r179 == null) goto L104;
        int r180 = r179.hashCode();
    L105:
        int r181 = (r178 + r180) * 31;
        String r182 = this.sharePanelSchema;
        if (r182 == null) goto L108;
        int r183 = r182.hashCode();
    L109:
        int r184 = (r181 + r183) * 31;
        String r185 = this.shareMonitorName;
        if (r185 == null) goto L112;
        int r186 = r185.hashCode();
    L113:
        int r187 = (r184 + r186) * 31;
        String r188 = this.clickFrom;
        if (r188 == null) goto L116;
        int r189 = r188.hashCode();
    L117:
        int r190 = (r187 + r189) * 31;
        String r191 = this.ecomSceneId;
        if (r191 == null) goto L121;
        r101 = r191.hashCode();
    L121:
        return r190 + r101;
    L116:
        r189 = 0;
        goto L117
    L112:
        r186 = 0;
        goto L113
    L108:
        r183 = 0;
        goto L109
    L104:
        r180 = 0;
        goto L105
    L100:
        r177 = 0;
        goto L101
    L96:
        r174 = 0;
        goto L97
    L92:
        r171 = 0;
        goto L93
    L84:
        r166 = 0;
        goto L85
    L80:
        r163 = 0;
        goto L81
    L76:
        r160 = 0;
        goto L77
    L72:
        r157 = 0;
        goto L73
    L68:
        r154 = 0;
        goto L69
    L64:
        r151 = 0;
        goto L65
    L60:
        r147 = 0;
        goto L61
    L56:
        r144 = 0;
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
        return "ShareMeta(productId=" + this.productId + ", promotionId=" + this.promotionId + ", itemId=" + this.itemId + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", promotionSource=" + this.promotionSource + ", shopId=" + this.shopId + ", liveRoomId=" + this.liveRoomId + ", followStatus=" + this.followStatus + ", sourcePage=" + this.sourcePage + ", enterMethod=" + this.enterMethod + ", sourceMethod=" + this.sourceMethod + ", carrierSource=" + this.carrierSource + ", adLogExtra=" + this.adLogExtra + ", isLuban=" + this.isLuban + ", marketChannel=" + this.marketChannel + ", requestAdditions=" + this.requestAdditions + ", productMinPrice=" + this.productMinPrice + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", title=" + this.title + ", shareTemplate=" + this.shareTemplate + ", firstImage=" + this.firstImage + ", visitorCount=" + this.visitorCount + ", metaParamWithoutSceneId=" + this.metaParamWithoutSceneId + ", millionDiscount=" + this.millionDiscount + ", detailUrlWithoutSceneId=" + this.detailUrlWithoutSceneId + ", shareButtonAnimation=" + this.shareButtonAnimation + ", ngroupBuyToken=" + this.ngroupBuyToken + ", displayShareTouchPoint=" + this.displayShareTouchPoint + ", sharePanelSchema=" + this.sharePanelSchema + ", shareMonitorName=" + this.shareMonitorName + ", clickFrom=" + this.clickFrom + ", ecomSceneId=" + this.ecomSceneId + ")";
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getCarrierSource() {
        return this.carrierSource;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final String getDetailUrlWithoutSceneId() {
        return this.detailUrlWithoutSceneId;
    }

    public final Boolean getDisplayShareTouchPoint() {
        return this.displayShareTouchPoint;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final ECUrlModel getFirstImage() {
        return this.firstImage;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final String getMarketChannel() {
        return this.marketChannel;
    }

    public final String getMetaParamWithoutSceneId() {
        return this.metaParamWithoutSceneId;
    }

    public final boolean getMillionDiscount() {
        return this.millionDiscount;
    }

    public final String getNgroupBuyToken() {
        return this.ngroupBuyToken;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getProductMinPrice() {
        return this.productMinPrice;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final Integer getShareButtonAnimation() {
        return this.shareButtonAnimation;
    }

    public final String getShareMonitorName() {
        return this.shareMonitorName;
    }

    public final String getSharePanelSchema() {
        return this.sharePanelSchema;
    }

    public final String getShareTemplate() {
        return this.shareTemplate;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSourceMethod() {
        return this.sourceMethod;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getVisitorCount() {
        return this.visitorCount;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final ShareMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getProductId();
    L6:
        this.productId = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getPromotionId();
    L10:
        this.promotionId = r103;
        if (r100 == null) goto L13;
        String r104 = r100.getItemId();
    L14:
        this.itemId = r104;
        if (r100 == null) goto L17;
        String r105 = r100.getAuthorId();
    L18:
        this.authorId = r105;
        if (r100 == null) goto L21;
        String r106 = r100.getSecAuthorId();
    L22:
        this.secAuthorId = r106;
        if (r100 == null) goto L25;
        Long r107 = Long.valueOf(r100.getPromotionSource());
    L26:
        this.promotionSource = k.h(r107);
        if (r100 == null) goto L29;
        String r108 = r100.getShopId();
    L30:
        this.shopId = r108;
        if (r100 == null) goto L33;
        String r109 = r100.getLiveRoomId();
    L34:
        this.liveRoomId = r109;
        if (r100 == null) goto L37;
        Integer r110 = Integer.valueOf(r100.getFollowStatus());
    L38:
        this.followStatus = k.f(r110);
        if (r100 == null) goto L41;
        String r111 = r100.getSourcePage();
    L42:
        this.sourcePage = r111;
        if (r100 == null) goto L45;
        String r112 = r100.getEnterMethod();
    L46:
        this.enterMethod = r112;
        if (r100 == null) goto L49;
        String r113 = r100.getSourceMethod();
    L50:
        this.sourceMethod = r113;
        if (r100 == null) goto L53;
        String r114 = r100.getCarrierSource();
    L54:
        this.carrierSource = r114;
        if (r100 == null) goto L57;
        ECAdLogExtra r115 = r100.getAdLogExtra();
    L58:
        this.adLogExtra = r115;
        if (r100 == null) goto L61;
        Boolean r116 = Boolean.valueOf(r100.isLuban());
    L62:
        this.isLuban = k.i(r116);
        if (r100 == null) goto L65;
        String r117 = r100.getMarketingChannel();
    L66:
        this.marketChannel = r117;
        if (r100 == null) goto L69;
        String r118 = r100.getRequestAdditions();
    L70:
        this.requestAdditions = r118;
        if (r100 == null) goto L73;
        Long r119 = r100.getProductMinPrice();
    L74:
        this.productMinPrice = k.h(r119);
        if (r100 == null) goto L77;
        String r120 = r100.getChannelId();
    L78:
        String r121 = "";
        Intrinsics.checkNotNullParameter("", "default");
        if (r120 != null) goto L81;
        r120 = "";
    L81:
        this.channelId = r120;
        if (r100 == null) goto L84;
        Integer r122 = r100.getChannelType();
    L85:
        this.channelType = r122;
        if (r100 == null) goto L88;
        r101 = r100.getEcomSceneId();
    L88:
        Intrinsics.checkNotNullParameter("", "default");
        if (r101 == null) goto L92;
        r121 = r101;
    L92:
        this.ecomSceneId = r121;
        return this;
    L84:
        r122 = null;
        goto L85
    L77:
        r120 = null;
        goto L78
    L73:
        r119 = null;
        goto L74
    L69:
        r118 = null;
        goto L70
    L65:
        r117 = null;
        goto L66
    L61:
        r116 = null;
        goto L62
    L57:
        r115 = null;
        goto L58
    L53:
        r114 = null;
        goto L54
    L49:
        r113 = null;
        goto L50
    L45:
        r112 = null;
        goto L46
    L41:
        r111 = null;
        goto L42
    L37:
        r110 = null;
        goto L38
    L33:
        r109 = null;
        goto L34
    L29:
        r108 = null;
        goto L30
    L25:
        r107 = null;
        goto L26
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setAdLogExtra(ECAdLogExtra r100) {
        this.adLogExtra = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setCarrierSource(String r100) {
        this.carrierSource = r100;
    }

    public final void setChannelId(String r100) {
        this.channelId = r100;
    }

    public final void setChannelType(Integer r100) {
        this.channelType = r100;
    }

    public final void setEcomSceneId(String r100) {
        this.ecomSceneId = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setFollowStatus(int r100) {
        this.followStatus = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setLuban(boolean r100) {
        this.isLuban = r100;
    }

    public final void setMarketChannel(String r100) {
        this.marketChannel = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setProductMinPrice(long r100) {
        this.productMinPrice = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setPromotionSource(long r100) {
        this.promotionSource = r100;
    }

    public final void setRequestAdditions(String r100) {
        this.requestAdditions = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setSourceMethod(String r100) {
        this.sourceMethod = r100;
    }

    public final void setSourcePage(String r100) {
        this.sourcePage = r100;
    }

    public ShareMeta(String r100, String r101, String r102, String r103, String r104, long r105, String r110, String r111, int r112, String r113, String r114, String r115, String r116, ECAdLogExtra r117, boolean r118, String r210, String r211, long r212, String r213, Integer r214, String r215, String r216, ECUrlModel r217, int r218, String r310, boolean r311, String r312, Integer r313, String r314, Boolean r315, String r316, String r317, String r318, String r319) {
        this.productId = r100;
        this.promotionId = r101;
        this.itemId = r102;
        this.authorId = r103;
        this.secAuthorId = r104;
        this.promotionSource = r105;
        this.shopId = r110;
        this.liveRoomId = r111;
        this.followStatus = r112;
        this.sourcePage = r113;
        this.enterMethod = r114;
        this.sourceMethod = r115;
        this.carrierSource = r116;
        this.adLogExtra = r117;
        this.isLuban = r118;
        this.marketChannel = r210;
        this.requestAdditions = r211;
        this.productMinPrice = r212;
        this.channelId = r213;
        this.channelType = r214;
        this.title = r215;
        this.shareTemplate = r216;
        this.firstImage = r217;
        this.visitorCount = r218;
        this.metaParamWithoutSceneId = r310;
        this.millionDiscount = r311;
        this.detailUrlWithoutSceneId = r312;
        this.shareButtonAnimation = r313;
        this.ngroupBuyToken = r314;
        this.displayShareTouchPoint = r315;
        this.sharePanelSchema = r316;
        this.shareMonitorName = r317;
        this.clickFrom = r318;
        this.ecomSceneId = r319;
    }

    public /* synthetic */ ShareMeta(String r310, String r311, String r312, String r410, String r411, long r412, String r413, String r414, int r415, String r416, String r417, String r418, String r510, ECAdLogExtra r511, boolean r512, String r513, String r514, long r515, String r516, Integer r517, String r518, String r610, ECUrlModel r611, int r612, String r613, boolean r614, String r615, Integer r616, String r617, Boolean r618, String r619, String r710, String r711, String r712, int r713, int r714, DefaultConstructorMarker r715) {
        if ((r713 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r713 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r713 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r713 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r713 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r713 & 32) == 0) goto L25;
        long r110 = 0;
    L27:
        if ((r713 & 64) == 0) goto L29;
        String r105 = null;
    L31:
        if ((r713 & 128) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r713 & 256) == 0) goto L37;
        int r112 = 0;
    L39:
        if ((r713 & 512) == 0) goto L41;
        String r113 = null;
    L43:
        if ((r713 & 1024) == 0) goto L45;
        String r106 = null;
    L47:
        if ((r713 & 2048) == 0) goto L49;
        String r107 = null;
    L51:
        if ((r713 & 4096) == 0) goto L53;
        String r108 = null;
    L55:
        if ((r713 & 8192) == 0) goto L57;
        ECAdLogExtra r114 = null;
    L58:
        ECAdLogExtra r115 = r114;
        if ((r713 & 16384) == 0) goto L61;
        boolean r116 = false;
    L63:
        if ((r713 & 32768) == 0) goto L65;
        String r117 = null;
    L67:
        if ((r713 & 65536) == 0) goto L69;
        String r118 = null;
    L71:
        if ((r713 & 131072) == 0) goto L73;
        long r119 = 0;
    L75:
        if ((r713 & 262144) == 0) goto L77;
        String r210 = null;
    L79:
        if ((r713 & 524288) == 0) goto L81;
        boolean r211 = false;
        Integer r212 = 0;
    L83:
        if ((r713 & 1048576) == 0) goto L85;
        String r213 = null;
    L87:
        if ((r713 & 2097152) == 0) goto L89;
        String r214 = null;
    L91:
        if ((r713 & 4194304) == 0) goto L93;
        ECUrlModel r215 = null;
    L95:
        if ((r713 & 8388608) == 0) goto L97;
        int r216 = 0;
    L99:
        if ((r713 & 16777216) == 0) goto L101;
        String r217 = null;
    L103:
        if ((r713 & 33554432) != 0) goto L107;
        r211 = r614;
    L107:
        if ((r713 & 67108864) == 0) goto L109;
        String r218 = null;
    L111:
        if ((r713 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r313 = null;
    L115:
        if ((r713 & 268435456) == 0) goto L117;
        String r314 = null;
    L119:
        if ((r713 & 536870912) == 0) goto L121;
        Boolean r315 = null;
    L123:
        if ((r713 & 1073741824) == 0) goto L125;
        String r316 = null;
    L127:
        if ((r713 & Integer.MIN_VALUE) == 0) goto L129;
        String r109 = null;
    L131:
        if ((r714 & 1) == 0) goto L133;
        String r317 = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    L135:
        if ((r714 & 2) == 0) goto L137;
        String r318 = "";
    L138:
        this(r100, r101, r102, r103, r104, r110, r105, r111, r112, r113, r106, r107, r108, r115, r116, r117, r118, r119, r210, r212, r213, r214, r215, r216, r217, r211, r218, r313, r314, r315, r316, r109, r317, r318);
        return;
    L137:
        r318 = r712;
        goto L138
    L133:
        r317 = r711;
        goto L135
    L129:
        r109 = r710;
        goto L131
    L125:
        r316 = r619;
        goto L127
    L121:
        r315 = r618;
        goto L123
    L117:
        r314 = r617;
        goto L119
    L113:
        r313 = r616;
        goto L115
    L109:
        r218 = r615;
        goto L111
    L101:
        r217 = r613;
        goto L103
    L97:
        r216 = r612;
        goto L99
    L93:
        r215 = r611;
        goto L95
    L89:
        r214 = r610;
        goto L91
    L85:
        r213 = r518;
        goto L87
    L81:
        r211 = false;
        r212 = r517;
        goto L83
    L77:
        r210 = r516;
        goto L79
    L73:
        r119 = r515;
        goto L75
    L69:
        r118 = r514;
        goto L71
    L65:
        r117 = r513;
        goto L67
    L61:
        r116 = r512;
        goto L63
    L57:
        r114 = r511;
        goto L58
    L53:
        r108 = r510;
        goto L55
    L49:
        r107 = r418;
        goto L51
    L45:
        r106 = r417;
        goto L47
    L41:
        r113 = r416;
        goto L43
    L37:
        r112 = r415;
        goto L39
    L33:
        r111 = r414;
        goto L35
    L29:
        r105 = r413;
        goto L31
    L25:
        r110 = r412;
        goto L27
    L21:
        r104 = r411;
        goto L23
    L17:
        r103 = r410;
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
