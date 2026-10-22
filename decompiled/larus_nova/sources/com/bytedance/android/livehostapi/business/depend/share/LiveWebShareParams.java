package com.bytedance.android.livehostapi.business.depend.share;

import android.view.View;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.livehostapi.utils.LiveObjectAdapter;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.share.LiveWebShareMode;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b2\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R,\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010<\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR,\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00104\"\u0004\bP\u00106R \u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR \u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR \u0010W\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\u001e\u0010Z\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR\u001e\u0010]\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010?\"\u0004\b^\u0010AR\u001e\u0010_\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010?\"\u0004\b`\u0010AR\u001e\u0010a\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010?\"\u0004\bb\u0010AR \u0010c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR\u001e\u0010f\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010?\"\u0004\bh\u0010AR\"\u0010i\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00100\u001a\u0004\bj\u0010-\"\u0004\bk\u0010/R \u0010l\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR,\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00104\"\u0004\bt\u00106R \u0010u\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\bR\u001e\u0010x\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010?\"\u0004\bz\u0010AR\u001e\u0010{\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010?\"\u0004\b}\u0010AR\u001f\u0010~\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010?\"\u0005\b\u0080\u0001\u0010AR#\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR#\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR!\u0010\u0087\u0001\u001a\u00020+8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u00109\"\u0005\b\u0089\u0001\u0010;R,\u0010\u008a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u008b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R$\u0010\u0090\u0001\u001a\u00030\u0091\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R-\u0010\u0096\u0001\u001a\f\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010\u008b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u008d\u0001\"\u0006\b\u0099\u0001\u0010\u008f\u0001R,\u0010\u009a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u008b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u008d\u0001\"\u0006\b\u009c\u0001\u0010\u008f\u0001RE\u0010\u009d\u0001\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u009e\u0001j\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u009f\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R,\u0010¤\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u008b\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010\u008d\u0001\"\u0006\b¦\u0001\u0010\u008f\u0001R(\u0010§\u0001\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0003\u0010¬\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R#\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010\u0006\"\u0005\b¯\u0001\u0010\bR!\u0010°\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010\u0006\"\u0005\b²\u0001\u0010\bR#\u0010³\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u0006\"\u0005\bµ\u0001\u0010\bRE\u0010¶\u0001\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u009e\u0001j\u0011\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u009f\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010¡\u0001\"\u0006\b¸\u0001\u0010£\u0001R#\u0010¹\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010\u0006\"\u0005\b»\u0001\u0010\bR!\u0010¼\u0001\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010?\"\u0005\b¾\u0001\u0010AR#\u0010¿\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010\u0006\"\u0005\bÁ\u0001\u0010\bR#\u0010Â\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010\u0006\"\u0005\bÄ\u0001\u0010\bR#\u0010Å\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010\u0006\"\u0005\bÇ\u0001\u0010\bR!\u0010È\u0001\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010?\"\u0005\bÊ\u0001\u0010AR#\u0010Ë\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010\u0006\"\u0005\bÍ\u0001\u0010\bR#\u0010Î\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\u0006\"\u0005\bÐ\u0001\u0010\b¨\u0006Ñ\u0001"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/LiveWebShareParams;", "", "()V", "aweType", "", "getAweType", "()Ljava/lang/String;", "setAweType", "(Ljava/lang/String;)V", "backgroundInfo", "Lcom/bytedance/android/livehostapi/business/depend/share/BackgroundInfo;", "getBackgroundInfo", "()Lcom/bytedance/android/livehostapi/business/depend/share/BackgroundInfo;", "setBackgroundInfo", "(Lcom/bytedance/android/livehostapi/business/depend/share/BackgroundInfo;)V", "bgUrl", "getBgUrl", "setBgUrl", "businessParams", "getBusinessParams", "setBusinessParams", "checkBoxConfig", "Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfig;", "getCheckBoxConfig", "()Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfig;", "setCheckBoxConfig", "(Lcom/bytedance/android/livehostapi/business/depend/share/CheckBoxConfig;)V", "commandShareParams", "Lcom/bytedance/android/livehostapi/business/depend/share/CommandShareParams;", "getCommandShareParams", "()Lcom/bytedance/android/livehostapi/business/depend/share/CommandShareParams;", "setCommandShareParams", "(Lcom/bytedance/android/livehostapi/business/depend/share/CommandShareParams;)V", "content", "getContent", "setContent", "customParams", "getCustomParams", "setCustomParams", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "disableForward", "", "getDisableForward", "()Ljava/lang/Integer;", "setDisableForward", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ecomShareTrackParams", "", "getEcomShareTrackParams", "()Ljava/util/Map;", "setEcomShareTrackParams", "(Ljava/util/Map;)V", "hideContacts", "getHideContacts", "()I", "setHideContacts", "(I)V", "hideDim", "", "getHideDim", "()Z", "setHideDim", "(Z)V", "hideShareItems", "getHideShareItems", "setHideShareItems", "hint", "getHint", "setHint", "hybridView", "Landroid/view/View;", "getHybridView", "()Landroid/view/View;", "setHybridView", "(Landroid/view/View;)V", "imExtra", "getImExtra", "setImExtra", "imImageUrl", "getImImageUrl", "setImImageUrl", "image", "getImage", "setImage", "image_url", "getImage_url", "setImage_url", "innerUrl", "getInnerUrl", "setInnerUrl", "isHalfScreen", "setHalfScreen", "isLiveShare", "setLiveShare", "isPreLive", "setPreLive", "itemId", "getItemId", "setItemId", "jumpSchemaDirectly", "getJumpSchemaDirectly", "setJumpSchemaDirectly", "liveShareType", "getLiveShareType", "setLiveShareType", "logMap", "Lcom/bytedance/android/livehostapi/business/depend/share/MobEventMap;", "getLogMap", "()Lcom/bytedance/android/livehostapi/business/depend/share/MobEventMap;", "setLogMap", "(Lcom/bytedance/android/livehostapi/business/depend/share/MobEventMap;)V", "logParams", "getLogParams", "setLogParams", "msgTrack", "getMsgTrack", "setMsgTrack", "needLogin", "getNeedLogin", "setNeedLogin", "needPoster", "getNeedPoster", "setNeedPoster", "needShareCallback", "getNeedShareCallback", "setNeedShareCallback", "picUrl", "getPicUrl", "setPicUrl", "platform", "getPlatform", "setPlatform", CommonConstant.KEY_QR_CODE, "getQrCode", "setQrCode", "qrcodeForbidChannels", "", "getQrcodeForbidChannels", "()Ljava/util/List;", "setQrcodeForbidChannels", "(Ljava/util/List;)V", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "shareChannels", "Lcom/bytedance/android/livesdkapi/depend/model/share/LiveWebShareMode;", "getShareChannels", "setShareChannels", "shareEntriesForbidList", "getShareEntriesForbidList", "setShareEntriesForbidList", "shareExtraParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getShareExtraParams", "()Ljava/util/HashMap;", "setShareExtraParams", "(Ljava/util/HashMap;)V", "shareItems", "getShareItems", "setShareItems", "skipPermission", "getSkipPermission", "()Ljava/lang/Boolean;", "setSkipPermission", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "takeBlessingVideoUrl", "getTakeBlessingVideoUrl", "setTakeBlessingVideoUrl", "tips", "getTips", "setTips", "title", "getTitle", d.f25925o, "trackParams", "getTrackParams", "setTrackParams", "type", "getType", "setType", "ugShare", "getUgShare", "setUgShare", "uiExtra", "getUiExtra", "setUiExtra", "url", "getUrl", "setUrl", "urlExtra", "getUrlExtra", "setUrlExtra", "useReturnData", "getUseReturnData", "setUseReturnData", "webUrlV2", "getWebUrlV2", "setWebUrlV2", "webUrlV2Version", "getWebUrlV2Version", "setWebUrlV2Version", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveWebShareParams {

    @SerializedName("awe_type")
    private String aweType;

    @SerializedName("background_info")
    private BackgroundInfo backgroundInfo;

    @SerializedName("bg_url")
    private String bgUrl;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_BUSINESS_PARAMS)
    private String businessParams;

    @SerializedName("checkbox_config")
    private CheckBoxConfig checkBoxConfig;

    @SerializedName("command_share_params")
    private CommandShareParams commandShareParams;

    @SerializedName("content")
    private String content;

    @SerializedName("custom_params")
    private String customParams;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("disable_forward")
    private Integer disableForward;

    @SerializedName("ecom_share_track_params")
    private Map<String, String> ecomShareTrackParams;

    @SerializedName("hideContacts")
    private int hideContacts;

    @SerializedName("hide_dim")
    private boolean hideDim;

    @SerializedName("hideShareItems")
    private int hideShareItems;

    @SerializedName("hint")
    private String hint;
    private transient View hybridView;

    @SerializedName("im_extra")
    @JsonAdapter(LiveObjectAdapter.class)
    private Map<String, ? extends Object> imExtra;

    @SerializedName("im_image_url")
    private String imImageUrl;

    @SerializedName("image")
    private String image;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("innerUrl")
    private String innerUrl;

    @SerializedName("is_half_screen")
    private boolean isHalfScreen;

    @SerializedName("is_live_share")
    private boolean isLiveShare;

    @SerializedName("is_pre_live")
    private boolean isPreLive;

    @SerializedName("item_id")
    private String itemId;

    @SerializedName("jump_schema_directly")
    private boolean jumpSchemaDirectly;

    @SerializedName("live_share_type")
    private Integer liveShareType;

    @SerializedName("mob_event_map")
    private MobEventMap logMap;

    @SerializedName("logParams")
    private Map<String, String> logParams;

    @SerializedName("msg_track")
    private String msgTrack;

    @SerializedName("needLogin")
    private boolean needLogin;

    @SerializedName("need_poster")
    private boolean needPoster;

    @SerializedName("need_share_callback")
    private boolean needShareCallback;

    @SerializedName("pic_url")
    private String picUrl;

    @SerializedName("platform")
    private String platform;

    @SerializedName("qrcode")
    private int qrCode;

    @SerializedName("qrcodeForbidChannels")
    private List<String> qrcodeForbidChannels;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("shareChannels")
    private List<LiveWebShareMode> shareChannels;

    @SerializedName("shareEntriesForbidList")
    private List<String> shareEntriesForbidList;

    @SerializedName("live_share_extra_params")
    private HashMap<String, Object> shareExtraParams;

    @SerializedName("shareitems")
    private List<String> shareItems;

    @SerializedName("skip_permission")
    private Boolean skipPermission;

    @SerializedName("take_blessing_video_url")
    private String takeBlessingVideoUrl;

    @SerializedName("tips")
    private String tips;

    @SerializedName("title")
    private String title;

    @SerializedName("track_params")
    private HashMap<String, String> trackParams;

    @SerializedName("type")
    private String type;

    @SerializedName("ug_share")
    private boolean ugShare;

    @SerializedName("ui_extra")
    private String uiExtra;

    @SerializedName("url")
    private String url;

    @SerializedName("url_extra")
    private String urlExtra;

    @SerializedName("use_return_data")
    private boolean useReturnData;

    @SerializedName("web_url_v2")
    private String webUrlV2;

    @SerializedName("web_url_v2_version")
    private String webUrlV2Version;

    public LiveWebShareParams() {
        this.isLiveShare = true;
        this.liveShareType = 0;
        this.isHalfScreen = true;
        this.urlExtra = "";
        this.skipPermission = Boolean.TRUE;
        this.businessParams = "";
        this.tips = "";
        this.innerUrl = "";
    }

    public final String getAweType() {
        return this.aweType;
    }

    public final BackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    public final String getBgUrl() {
        return this.bgUrl;
    }

    public final String getBusinessParams() {
        return this.businessParams;
    }

    public final CheckBoxConfig getCheckBoxConfig() {
        return this.checkBoxConfig;
    }

    public final CommandShareParams getCommandShareParams() {
        return this.commandShareParams;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCustomParams() {
        return this.customParams;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Integer getDisableForward() {
        return this.disableForward;
    }

    public final Map<String, String> getEcomShareTrackParams() {
        return this.ecomShareTrackParams;
    }

    public final int getHideContacts() {
        return this.hideContacts;
    }

    public final boolean getHideDim() {
        return this.hideDim;
    }

    public final int getHideShareItems() {
        return this.hideShareItems;
    }

    public final String getHint() {
        return this.hint;
    }

    public final View getHybridView() {
        return this.hybridView;
    }

    public final Map<String, Object> getImExtra() {
        return this.imExtra;
    }

    public final String getImImageUrl() {
        return this.imImageUrl;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getImage_url() {
        return this.image_url;
    }

    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final boolean getJumpSchemaDirectly() {
        return this.jumpSchemaDirectly;
    }

    public final Integer getLiveShareType() {
        return this.liveShareType;
    }

    public final MobEventMap getLogMap() {
        return this.logMap;
    }

    public final Map<String, String> getLogParams() {
        return this.logParams;
    }

    public final String getMsgTrack() {
        return this.msgTrack;
    }

    public final boolean getNeedLogin() {
        return this.needLogin;
    }

    public final boolean getNeedPoster() {
        return this.needPoster;
    }

    public final boolean getNeedShareCallback() {
        return this.needShareCallback;
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final int getQrCode() {
        return this.qrCode;
    }

    public final List<String> getQrcodeForbidChannels() {
        return this.qrcodeForbidChannels;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final List<LiveWebShareMode> getShareChannels() {
        return this.shareChannels;
    }

    public final List<String> getShareEntriesForbidList() {
        return this.shareEntriesForbidList;
    }

    public final HashMap<String, Object> getShareExtraParams() {
        return this.shareExtraParams;
    }

    public final List<String> getShareItems() {
        return this.shareItems;
    }

    public final Boolean getSkipPermission() {
        return this.skipPermission;
    }

    public final String getTakeBlessingVideoUrl() {
        return this.takeBlessingVideoUrl;
    }

    public final String getTips() {
        return this.tips;
    }

    public final String getTitle() {
        return this.title;
    }

    public final HashMap<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getUgShare() {
        return this.ugShare;
    }

    public final String getUiExtra() {
        return this.uiExtra;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUrlExtra() {
        return this.urlExtra;
    }

    public final boolean getUseReturnData() {
        return this.useReturnData;
    }

    public final String getWebUrlV2() {
        return this.webUrlV2;
    }

    public final String getWebUrlV2Version() {
        return this.webUrlV2Version;
    }

    public final boolean isHalfScreen() {
        return this.isHalfScreen;
    }

    public final boolean isLiveShare() {
        return this.isLiveShare;
    }

    public final boolean isPreLive() {
        return this.isPreLive;
    }

    public final void setAweType(String r100) {
        this.aweType = r100;
    }

    public final void setBackgroundInfo(BackgroundInfo r100) {
        this.backgroundInfo = r100;
    }

    public final void setBgUrl(String r100) {
        this.bgUrl = r100;
    }

    public final void setBusinessParams(String r100) {
        this.businessParams = r100;
    }

    public final void setCheckBoxConfig(CheckBoxConfig r100) {
        this.checkBoxConfig = r100;
    }

    public final void setCommandShareParams(CommandShareParams r100) {
        this.commandShareParams = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setCustomParams(String r100) {
        this.customParams = r100;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setDisableForward(Integer r100) {
        this.disableForward = r100;
    }

    public final void setEcomShareTrackParams(Map<String, String> r100) {
        this.ecomShareTrackParams = r100;
    }

    public final void setHalfScreen(boolean r100) {
        this.isHalfScreen = r100;
    }

    public final void setHideContacts(int r100) {
        this.hideContacts = r100;
    }

    public final void setHideDim(boolean r100) {
        this.hideDim = r100;
    }

    public final void setHideShareItems(int r100) {
        this.hideShareItems = r100;
    }

    public final void setHint(String r100) {
        this.hint = r100;
    }

    public final void setHybridView(View r100) {
        this.hybridView = r100;
    }

    public final void setImExtra(Map<String, ? extends Object> r100) {
        this.imExtra = r100;
    }

    public final void setImImageUrl(String r100) {
        this.imImageUrl = r100;
    }

    public final void setImage(String r100) {
        this.image = r100;
    }

    public final void setImage_url(String r100) {
        this.image_url = r100;
    }

    public final void setInnerUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.innerUrl = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setJumpSchemaDirectly(boolean r100) {
        this.jumpSchemaDirectly = r100;
    }

    public final void setLiveShare(boolean r100) {
        this.isLiveShare = r100;
    }

    public final void setLiveShareType(Integer r100) {
        this.liveShareType = r100;
    }

    public final void setLogMap(MobEventMap r100) {
        this.logMap = r100;
    }

    public final void setLogParams(Map<String, String> r100) {
        this.logParams = r100;
    }

    public final void setMsgTrack(String r100) {
        this.msgTrack = r100;
    }

    public final void setNeedLogin(boolean r100) {
        this.needLogin = r100;
    }

    public final void setNeedPoster(boolean r100) {
        this.needPoster = r100;
    }

    public final void setNeedShareCallback(boolean r100) {
        this.needShareCallback = r100;
    }

    public final void setPicUrl(String r100) {
        this.picUrl = r100;
    }

    public final void setPlatform(String r100) {
        this.platform = r100;
    }

    public final void setPreLive(boolean r100) {
        this.isPreLive = r100;
    }

    public final void setQrCode(int r100) {
        this.qrCode = r100;
    }

    public final void setQrcodeForbidChannels(List<String> r100) {
        this.qrcodeForbidChannels = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setShareChannels(List<LiveWebShareMode> r100) {
        this.shareChannels = r100;
    }

    public final void setShareEntriesForbidList(List<String> r100) {
        this.shareEntriesForbidList = r100;
    }

    public final void setShareExtraParams(HashMap<String, Object> r100) {
        this.shareExtraParams = r100;
    }

    public final void setShareItems(List<String> r100) {
        this.shareItems = r100;
    }

    public final void setSkipPermission(Boolean r100) {
        this.skipPermission = r100;
    }

    public final void setTakeBlessingVideoUrl(String r100) {
        this.takeBlessingVideoUrl = r100;
    }

    public final void setTips(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tips = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setTrackParams(HashMap<String, String> r100) {
        this.trackParams = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setUgShare(boolean r100) {
        this.ugShare = r100;
    }

    public final void setUiExtra(String r100) {
        this.uiExtra = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setUrlExtra(String r100) {
        this.urlExtra = r100;
    }

    public final void setUseReturnData(boolean r100) {
        this.useReturnData = r100;
    }

    public final void setWebUrlV2(String r100) {
        this.webUrlV2 = r100;
    }

    public final void setWebUrlV2Version(String r100) {
        this.webUrlV2Version = r100;
    }
}
