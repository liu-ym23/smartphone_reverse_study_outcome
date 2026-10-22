package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\bg\u0018\u0000 Ì\u00012\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0002Í\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&R\u001c\u0010\u000f\u001a\u00020\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\u00020\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u001e\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010'\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010*\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010/\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00100\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R\u0014\u00102\u001a\u00020\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010$R\u001e\u00105\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R\u0016\u00107\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u001c\u00108\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R(\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190:8&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010B\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\u0014\u0010D\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\fR\"\u0010J\u001a\b\u0012\u0004\u0012\u00020\n0E8&@&X¦\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010M\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u001c\u0010P\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\bN\u0010\u001b\"\u0004\bO\u0010\u001dR\"\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190E8&@&X¦\u000e¢\u0006\f\u001a\u0004\bQ\u0010G\"\u0004\bR\u0010IR\u0014\u0010U\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\fR\u0016\u0010W\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0012R\u001c\u0010Z\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&R\u001c\u0010]\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\b[\u0010\u001b\"\u0004\b\\\u0010\u001dR\u001e\u0010`\u001a\u0004\u0018\u00010\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b^\u0010\f\"\u0004\b_\u0010\u000eR\u0014\u0010b\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\fR\u0014\u0010d\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u001bR\"\u0010h\u001a\b\u0012\u0004\u0012\u00020e0E8&@&X¦\u000e¢\u0006\f\u001a\u0004\bf\u0010G\"\u0004\bg\u0010IR\u001c\u0010i\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\bi\u0010,\"\u0004\bj\u0010.R\u001c\u0010m\u001a\u00020\u00198&@&X¦\u000e¢\u0006\f\u001a\u0004\bk\u0010\u001b\"\u0004\bl\u0010\u001dR\u0016\u0010q\u001a\u0004\u0018\u00010n8&X¦\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u001e\u0010w\u001a\u0004\u0018\u00010r8&@&X¦\u000e¢\u0006\f\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001c\u0010x\u001a\u00020\u00048&@&X¦\u000e¢\u0006\f\u001a\u0004\bx\u0010,\"\u0004\by\u0010.R\u001e\u0010\u007f\u001a\u0004\u0018\u00010z8&@&X¦\u000e¢\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0016\u0010\u0080\u0001\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010,R\u001a\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0085\u0001\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010,R\u0016\u0010\u0086\u0001\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010,R\u0016\u0010\u0088\u0001\u001a\u00020\"8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010$R\u001f\u0010\u0089\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010,\"\u0005\b\u008a\u0001\u0010.R\u0016\u0010\u008b\u0001\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010,R\u0016\u0010\u008d\u0001\u001a\u00020\n8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\fR\u001f\u0010\u008e\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010,\"\u0005\b\u008f\u0001\u0010.R!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0090\u0001\u0010\u0012\"\u0005\b\u0091\u0001\u0010\u0014R\u0016\u0010\u0094\u0001\u001a\u00020\u00198&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010\u001bR\u0016\u0010\u0096\u0001\u001a\u00020\"8&X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010$R%\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190E8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010G\"\u0005\b\u0098\u0001\u0010IR$\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009a\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001a\u0010£\u0001\u001a\u0005\u0018\u00010 \u00018&X¦\u0004¢\u0006\b\u001a\u0006\b¡\u0001\u0010¢\u0001R\u0016\u0010¥\u0001\u001a\u00020\u00048&X¦\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010,R\u001f\u0010¨\u0001\u001a\u00020\u00198&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¦\u0001\u0010\u001b\"\u0005\b§\u0001\u0010\u001dR\u001a\u0010¬\u0001\u001a\u0005\u0018\u00010©\u00018&X¦\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u001a\u0010°\u0001\u001a\u0005\u0018\u00010\u00ad\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010´\u0001\u001a\u0005\u0018\u00010±\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u001f\u0010·\u0001\u001a\u00020\"8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bµ\u0001\u0010$\"\u0005\b¶\u0001\u0010&R\u001a\u0010»\u0001\u001a\u0005\u0018\u00010¸\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b¹\u0001\u0010º\u0001R\u001f\u0010¾\u0001\u001a\u00020\"8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b¼\u0001\u0010$\"\u0005\b½\u0001\u0010&R\u001c\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190E8&X¦\u0004¢\u0006\u0007\u001a\u0005\b¿\u0001\u0010GR\u0018\u0010Â\u0001\u001a\u0004\u0018\u00010\u00108&X¦\u0004¢\u0006\u0007\u001a\u0005\bÁ\u0001\u0010\u0012R\u001f\u0010Ã\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÃ\u0001\u0010,\"\u0005\bÄ\u0001\u0010.R\u001f\u0010Å\u0001\u001a\u00020\u00048&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÅ\u0001\u0010,\"\u0005\bÆ\u0001\u0010.R\u0016\u0010È\u0001\u001a\u00020\u00198&X¦\u0004¢\u0006\u0007\u001a\u0005\bÇ\u0001\u0010\u001bR\u001f\u0010Ë\u0001\u001a\u00020\n8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\bÉ\u0001\u0010\f\"\u0005\bÊ\u0001\u0010\u000e¨\u0006Î\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/h1;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/gift/model/i1;", "Lcom/bytedance/android/livesdk/gift/model/h2;", "", "enableWebp", "", "enableImageFormatOpt", "enableDomain", "enableDomainOpt", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "image", "getDescribe", "setDescribe", "describe", "", "getDuration", "()J", "setDuration", "(J)V", "duration", "getId", "setId", "id", "", "getType", "()I", "setType", "(I)V", "type", "getDiamondCount", "setDiamondCount", "diamondCount", "getRepeat", "()Z", "setRepeat", "(Z)V", SalesInfoStruct.REPEAT, "isForLinkMic", "getActionType", ReportConstant.COMMON_ACTION_TYPE, "getLeftLogo", "setLeftLogo", "leftLogo", "getDynamicImgForSelected", "dynamicImgForSelected", "isDisplayedOnPanel", "setDisplayedOnPanel", "", "getSpecialEffects", "()Ljava/util/Map;", "setSpecialEffects", "(Ljava/util/Map;)V", "specialEffects", "getPrimaryEffectId", "setPrimaryEffectId", "primaryEffectId", "getSchemeUrl", "schemeUrl", "", "getTriggerWords", "()Ljava/util/List;", "setTriggerWords", "(Ljava/util/List;)V", "triggerWords", "getAfterSendAction", "setAfterSendAction", "afterSendAction", "getReqExtraType", "setReqExtraType", "reqExtraType", "getAssetIds", "setAssetIds", "assetIds", "getTopBarText", "topBarText", "getTopRightAvatar", "topRightAvatar", "getItemType", "setItemType", "itemType", "getNowTimeDiffSeconds", "setNowTimeDiffSeconds", "nowTimeDiffSeconds", "getBannerScheme", "setBannerScheme", "bannerScheme", "getManual", "manual", "getGoldenBeanCount", "goldenBeanCount", "Lcom/bytedance/android/livesdk/gift/model/h0;", "getGiftGroupList", "setGiftGroupList", "giftGroupList", "isForFansClub", "setForFansClub", "getGiftEndingTime", "setGiftEndingTime", "giftEndingTime", "Lcom/bytedance/android/livesdk/gift/model/c2;", "getGiftTip", "()Lcom/bytedance/android/livesdk/gift/model/c2;", "giftTip", "Lcom/bytedance/android/livesdk/gift/model/k0;", "getGiftPreviewInfo", "()Lcom/bytedance/android/livesdk/gift/model/k0;", "setGiftPreviewInfo", "(Lcom/bytedance/android/livesdk/gift/model/k0;)V", "giftPreviewInfo", "isFreeDisplay", "setFreeDisplay", "Lcom/bytedance/android/livesdk/gift/model/l;", "getComboHint", "()Lcom/bytedance/android/livesdk/gift/model/l;", "setComboHint", "(Lcom/bytedance/android/livesdk/gift/model/l;)V", "comboHint", "isSupportLongPressCombo", "Lcom/bytedance/android/livesdk/gift/model/e0;", "getGiftBanner", "()Lcom/bytedance/android/livesdk/gift/model/e0;", "giftBanner", "isCnyGift", "isRepeat", "getSweepLightCount", "sweepLightCount", "isHasSweepLight", "setHasSweepLight", "isGray", "getGrayAction", "grayAction", "isForFirstRecharge", "setForFirstRecharge", "getWebpImage", "setWebpImage", "webpImage", "getSortScore", "sortScore", "getMysteryShopStatus", "mysteryShopStatus", "getOptionalAssetIds", "setOptionalAssetIds", "optionalAssetIds", "Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "getGiftMsgBoard", "()Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;", "setGiftMsgBoard", "(Lcom/bytedance/android/livesdk/gift/model/GiftMsgBoard;)V", "giftMsgBoard", "Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/m;", "getEmojiInteractResource", "()Lcom/bytedance/android/live/liveinteract/videotalk/emoji/model/m;", "emojiInteractResource", "getTrayDynamicImgFlippable", "trayDynamicImgFlippable", "getSelectedDynamicEffect", "setSelectedDynamicEffect", "selectedDynamicEffect", "Lcom/bytedance/android/livesdk/gift/model/e2;", "getGiftTouchLabel", "()Lcom/bytedance/android/livesdk/gift/model/e2;", "giftTouchLabel", "Lcom/bytedance/android/livesdk/gift/model/r0;", "getGiftUnselectedBottomInfo", "()Lcom/bytedance/android/livesdk/gift/model/r0;", "giftUnselectedBottomInfo", "Lcom/bytedance/android/livesdk/gift/model/f0;", "getGiftConfirmInfo", "()Lcom/bytedance/android/livesdk/gift/model/f0;", "giftConfirmInfo", "getBizType", "setBizType", "bizType", "Lcom/bytedance/android/livesdk/gift/model/t0;", "getGoodsBizItem", "()Lcom/bytedance/android/livesdk/gift/model/t0;", "goodsBizItem", "getGiftSource", "setGiftSource", "giftSource", "getRequiredAssets", "requiredAssets", "getRightTopSelectedLabel", "rightTopSelectedLabel", "isTransformFromLiteGift", "setTransformFromLiteGift", "isDomainOptEnable", "setDomainOptEnable", "getTopicId", "topicId", "getSortExtra", "setSortExtra", "sortExtra", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h1 extends vh7.c<h1>, i1, h2 {
    public static final int ACTION_CLOSE_COMBO = 1;
    public static final int ACTION_CLOSE_PANEL = 2;
    public static final int ACTION_DEFAULT = 0;
    public static final a Companion = null;
    public static final int DEFAULT_DURATION = 3000;
    public static final int GiftSourcePlatform = 0;
    public static final int GiftSourceUGC = 1;
    public static final int ITEM_TYPE_IMAGE = 2;
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final long REQUEST_EXTRA_AFTER_SEND_GIFT = 8;
    public static final long REQUEST_EXTRA_WHEN_OPEN_GIFTDIALOG = 1;
    public static final long REQUEST_EXTRA_WHEN_SELECT_GIFT = 2;
    public static final int REWARD_UNLOCKED = 3;
    public static final int REWARD_UNLOCKING = 2;
    public static final int SEND_TYPE_BIG_GIFT_MERGE_SEND = 5;
    public static final int SEND_TYPE_DEFAULT = 0;
    public static final int SEND_TYPE_GROUP_SEND = 2;
    public static final int SEND_TYPE_NORMAL = 1;
    public static final int SEND_TYPE_NORMAL_SEND = 4;
    public static final int SEND_TYPE_TOUCH_AND_HOLD = 3;
    public static final int SHOP_UNRELATED = 0;
    public static final int TASK_TO_UNLOCK = 1;
    public static final int TYPE_BLIND_BOX = 12;
    public static final int TYPE_FREE_CELL = 9;
    public static final int TYPE_GAME = 11;
    public static final int TYPE_GOLDEN_BEAN = 10;
    public static final int TYPE_INTERACT_GIFT = 13;
    public static final int TYPE_MEMBER_GIFT = 14;
    public static final int TYPE_MIDDLE = 8;
    public static final int TYPE_MULTI_INTERACT = 15;
    public static final int TYPE_NORMAL_ANIMATION = 1;
    public static final int TYPE_RED_PACKET = 3;
    public static final int TYPE_SPECIAL_ANIMATION = 2;
    public static final int TYPE_STICKER = 4;
    public static final int TYPE_TASK_GIFT = 5;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126383a = null;

        public a() {
        }

        static {
            f126383a = new a();
        }
    }

    static {
        Companion = a.f126383a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    void enableDomainOpt(boolean r100);

    void enableImageFormatOpt(boolean r100);

    int getActionType();

    int getAfterSendAction();

    List<Long> getAssetIds();

    String getBannerScheme();

    int getBizType();

    /* synthetic */ a5 getBottomText();

    l getComboHint();

    String getDescribe();

    int getDiamondCount();

    long getDuration();

    py.k getDynamicImgForSelected();

    com.bytedance.android.live.liveinteract.videotalk.emoji.model.m getEmojiInteractResource();

    e0 getGiftBanner();

    f0 getGiftConfirmInfo();

    long getGiftEndingTime();

    List<h0> getGiftGroupList();

    GiftMsgBoard getGiftMsgBoard();

    k0 getGiftPreviewInfo();

    int getGiftSource();

    c2 getGiftTip();

    e2 getGiftTouchLabel();

    r0 getGiftUnselectedBottomInfo();

    long getGoldenBeanCount();

    t0 getGoodsBizItem();

    String getGrayAction();

    long getId();

    py.k getImage();

    int getItemType();

    py.k getLeftLogo();

    /* synthetic */ String getLiveUserPngInfo();

    String getManual();

    int getMysteryShopStatus();

    String getName();

    long getNowTimeDiffSeconds();

    List<Long> getOptionalAssetIds();

    long getPrimaryEffectId();

    boolean getRepeat();

    long getReqExtraType();

    List<Long> getRequiredAssets();

    py.k getRightTopSelectedLabel();

    String getSchemeUrl();

    long getSelectedDynamicEffect();

    String getSortExtra();

    long getSortScore();

    Map<String, Long> getSpecialEffects();

    int getSweepLightCount();

    String getTopBarText();

    py.k getTopRightAvatar();

    long getTopicId();

    boolean getTrayDynamicImgFlippable();

    List<String> getTriggerWords();

    int getType();

    py.k getWebpImage();

    boolean isCnyGift();

    boolean isDisplayedOnPanel();

    boolean isDomainOptEnable();

    boolean isForFansClub();

    boolean isForFirstRecharge();

    boolean isForLinkMic();

    boolean isFreeDisplay();

    boolean isGray();

    boolean isHasSweepLight();

    boolean isRepeat();

    boolean isSupportLongPressCombo();

    boolean isTransformFromLiteGift();

    void setAfterSendAction(int r100);

    void setAssetIds(List<Long> r100);

    void setBannerScheme(String r100);

    void setBizType(int r100);

    void setComboHint(l r100);

    void setDescribe(String r100);

    void setDiamondCount(int r100);

    void setDisplayedOnPanel(boolean r100);

    void setDomainOptEnable(boolean r100);

    void setDuration(long r100);

    void setForFansClub(boolean r100);

    void setForFirstRecharge(boolean r100);

    void setFreeDisplay(boolean r100);

    void setGiftEndingTime(long r100);

    void setGiftGroupList(List<? extends h0> r100);

    void setGiftMsgBoard(GiftMsgBoard r100);

    void setGiftPreviewInfo(k0 r100);

    void setGiftSource(int r100);

    void setHasSweepLight(boolean r100);

    void setId(long r100);

    void setImage(py.k r100);

    void setItemType(int r100);

    void setLeftLogo(py.k r100);

    void setName(String r100);

    void setNowTimeDiffSeconds(long r100);

    void setOptionalAssetIds(List<Long> r100);

    void setPrimaryEffectId(long r100);

    void setRepeat(boolean r100);

    void setReqExtraType(long r100);

    void setSelectedDynamicEffect(long r100);

    void setSortExtra(String r100);

    void setSpecialEffects(Map<String, Long> r100);

    void setTransformFromLiteGift(boolean r100);

    void setTriggerWords(List<String> r100);

    void setType(int r100);

    void setWebpImage(py.k r100);
}
