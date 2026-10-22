package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PublicAreaCommon")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001{B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010x\u001a\u00020\u000bJ\b\u0010E\u001a\u00020\u000bH\u0016J\u0010\u0010y\u001a\u00020z2\u0006\u0010E\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001e\u0010%\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001e\u0010(\u001a\u00020)8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\rR \u00100\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR,\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR\u001a\u0010A\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR\u001a\u0010C\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR\u000e\u0010E\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010F\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\u001e\u0010H\u001a\u00020)8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010-R,\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010<\"\u0004\bM\u0010>R \u0010N\u001a\u0004\u0018\u00010O8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001e\u0010T\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\r\"\u0004\bV\u0010\u000fR\u001e\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\r\"\u0004\bY\u0010\u000fR \u0010Z\u001a\u0004\u0018\u00010[8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001e\u0010`\u001a\u00020)8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010I\"\u0004\bb\u0010-R\u001e\u0010c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0007\"\u0004\be\u0010\tR,\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010:8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010<\"\u0004\bh\u0010>R\u001e\u0010i\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0007\"\u0004\bk\u0010\tR \u0010l\u001a\u0004\u0018\u00010m8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0007\"\u0004\bt\u0010\tR\u001e\u0010u\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\r\"\u0004\bw\u0010\u000f¨\u0006|"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/message/IPublicAreaCommon;", "()V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()I", "setActionType", "(I)V", "batchRefresh", "", "getBatchRefresh", "()Z", "setBatchRefresh", "(Z)V", "bottomPinInfo", "Lcom/bytedance/android/livesdkapi/message/BottomPinInfo;", "getBottomPinInfo", "()Lcom/bytedance/android/livesdkapi/message/BottomPinInfo;", "setBottomPinInfo", "(Lcom/bytedance/android/livesdkapi/message/BottomPinInfo;)V", "chatMentionInfo", "Lcom/bytedance/android/livesdkapi/message/ChatMentionInfo;", "getChatMentionInfo", "()Lcom/bytedance/android/livesdkapi/message/ChatMentionInfo;", "setChatMentionInfo", "(Lcom/bytedance/android/livesdkapi/message/ChatMentionInfo;)V", "defaultClickSchemaUrl", "", "getDefaultClickSchemaUrl", "()Ljava/lang/String;", "setDefaultClickSchemaUrl", "(Ljava/lang/String;)V", "forbidProfile", "getForbidProfile", "setForbidProfile", "forceInsert", "getForceInsert", "setForceInsert", "forceInsertionPriority", "", "getForceInsertionPriority", "()Ljava/lang/Long;", "setForceInsertionPriority", "(J)V", "hasTailButton", "getHasTailButton", "hoverInfo", "Lcom/bytedance/android/livesdkapi/message/HoverInfo;", "getHoverInfo", "()Lcom/bytedance/android/livesdkapi/message/HoverInfo;", "setHoverInfo", "(Lcom/bytedance/android/livesdkapi/message/HoverInfo;)V", "individualPriority", "getIndividualPriority", "setIndividualPriority", "individualStrategyResult", "", "getIndividualStrategyResult", "()Ljava/util/Map;", "setIndividualStrategyResult", "(Ljava/util/Map;)V", "isAiMsg", "setAiMsg", "isFirstAggregateHistoryMessage", "setFirstAggregateHistoryMessage", "isFirstFetchBatchMsg", "setFirstFetchBatchMsg", "isFromRtcRoom", "isLikeComment", "setLikeComment", "isSelected", "()J", "setSelected", "lightInteractMobParams", "getLightInteractMobParams", "setLightInteractMobParams", "personalizedInfo", "Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo;", "getPersonalizedInfo", "()Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo;", "setPersonalizedInfo", "(Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo;)V", "shouldLogLightInteractMob", "getShouldLogLightInteractMob", "setShouldLogLightInteractMob", "showInDanmaku", "getShowInDanmaku", "setShowInDanmaku", "suffixText", "Lcom/bytedance/android/livesdkapi/message/SuffixText;", "getSuffixText", "()Lcom/bytedance/android/livesdkapi/message/SuffixText;", "setSuffixText", "(Lcom/bytedance/android/livesdkapi/message/SuffixText;)V", "supportPin", "getSupportPin", "setSupportPin", "tailInteractType", "getTailInteractType", "setTailInteractType", "trackingParams", "getTrackingParams", "setTrackingParams", "userConsume", "getUserConsume", "setUserConsume", "userLabel", "Lcom/bytedance/android/live/base/model/ImageModel;", "getUserLabel", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setUserLabel", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "userSendGiftCount", "getUserSendGiftCount", "setUserSendGiftCount", "withUserFeatureLabel", "getWithUserFeatureLabel", "setWithUserFeatureLabel", "canPin", "setFromRtcRoom", "", "Companion", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicAreaCommon extends FlexModelBase<IPublicAreaCommon> implements IPublicAreaCommon, h {
    public static final Companion Companion = null;
    private static long SUPPORT_PIN;

    @SerializedName("im_action")
    protected int actionType;

    @SerializedName("batch_refresh")
    protected boolean batchRefresh;

    @SerializedName("bottom_pin_config")
    protected BottomPinInfo bottomPinInfo;

    @SerializedName("mention_info")
    protected ChatMentionInfo chatMentionInfo;

    @SerializedName("default_click_schema_url")
    protected String defaultClickSchemaUrl;

    @SerializedName("forbidden_profile")
    protected boolean forbidProfile;

    @SerializedName("forced_insert")
    protected boolean forceInsert;

    @SerializedName("force_insertion_priority")
    protected long forceInsertionPriority;

    @SerializedName("hover_info")
    protected HoverInfo hoverInfo;

    @SerializedName("individual_priority")
    protected int individualPriority;

    @SerializedName("individual_strategy_result")
    protected Map<String, String> individualStrategyResult;

    @SerializedName("is_ai_msg")
    protected boolean isAiMsg;
    private boolean isFirstAggregateHistoryMessage;
    private boolean isFirstFetchBatchMsg;
    private boolean isFromRtcRoom;

    @SerializedName("is_like_comment")
    protected boolean isLikeComment;

    @SerializedName("is_featured")
    protected long isSelected;

    @SerializedName("light_interact_mob_params")
    protected Map<String, String> lightInteractMobParams;

    @SerializedName("personalized_display_info")
    protected PersonalizedDisplayInfo personalizedInfo;

    @SerializedName("should_log_light_interact_mob")
    protected boolean shouldLogLightInteractMob;

    @SerializedName("show_in_danmaku")
    protected boolean showInDanmaku;

    @SerializedName("suffix_text")
    protected SuffixText suffixText;

    @SerializedName("support_pin")
    protected long supportPin;

    @SerializedName("tail_interact_type")
    protected int tailInteractType;

    @SerializedName("tracking_params")
    protected Map<String, String> trackingParams;

    @SerializedName("user_consume_in_room")
    protected int userConsume;

    @SerializedName("user_label")
    protected ImageModel userLabel;

    @SerializedName("user_send_gift_cnt_in_room")
    protected int userSendGiftCount;

    @SerializedName("with_user_feature_label")
    protected boolean withUserFeatureLabel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/PublicAreaCommon$Companion;", "", "()V", "SUPPORT_PIN", "", "getSUPPORT_PIN", "()J", "setSUPPORT_PIN", "(J)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public final long getSUPPORT_PIN() {
            return PublicAreaCommon.access$getSUPPORT_PIN$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setSUPPORT_PIN(long r100) {
            PublicAreaCommon.access$setSUPPORT_PIN$cp(r100);
        }
    }

    public PublicAreaCommon() {
        super(IPublicAreaCommon.class);
    }

    static {
        Companion = new Companion(null);
        SUPPORT_PIN = 1;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public Long getForceInsertionPriority() {
        return Long.valueOf(this.forceInsertionPriority);
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean getHasTailButton() {
        if (this.tailInteractType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean canPin() {
        if (getSupportPin() != SUPPORT_PIN) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public /* bridge */ /* synthetic */ k getUserLabel() {
        return getUserLabel();
    }

    public static final /* synthetic */ long access$getSUPPORT_PIN$cp() {
        return SUPPORT_PIN;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public int getActionType() {
        return this.actionType;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean getBatchRefresh() {
        return this.batchRefresh;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public BottomPinInfo getBottomPinInfo() {
        return this.bottomPinInfo;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public ChatMentionInfo getChatMentionInfo() {
        return this.chatMentionInfo;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public String getDefaultClickSchemaUrl() {
        return this.defaultClickSchemaUrl;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean getForbidProfile() {
        return this.forbidProfile;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean getForceInsert() {
        return this.forceInsert;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public HoverInfo getHoverInfo() {
        return this.hoverInfo;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public int getIndividualPriority() {
        return this.individualPriority;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public Map<String, String> getIndividualStrategyResult() {
        return this.individualStrategyResult;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public Map<String, String> getLightInteractMobParams() {
        return this.lightInteractMobParams;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public PersonalizedDisplayInfo getPersonalizedInfo() {
        return this.personalizedInfo;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean getShouldLogLightInteractMob() {
        return this.shouldLogLightInteractMob;
    }

    public final boolean getShowInDanmaku() {
        return this.showInDanmaku;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public SuffixText getSuffixText() {
        return this.suffixText;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public long getSupportPin() {
        return this.supportPin;
    }

    public final int getTailInteractType() {
        return this.tailInteractType;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public Map<String, String> getTrackingParams() {
        return this.trackingParams;
    }

    public final int getUserConsume() {
        return this.userConsume;
    }

    public final int getUserSendGiftCount() {
        return this.userSendGiftCount;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean getWithUserFeatureLabel() {
        return this.withUserFeatureLabel;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean isAiMsg() {
        return this.isAiMsg;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean isFirstAggregateHistoryMessage() {
        return this.isFirstAggregateHistoryMessage;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean isFirstFetchBatchMsg() {
        return this.isFirstFetchBatchMsg;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRtcRoomMessage
    public boolean isFromRtcRoom() {
        return this.isFromRtcRoom;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public boolean isLikeComment() {
        return this.isLikeComment;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public long isSelected() {
        return this.isSelected;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public ImageModel getUserLabel() {
        return this.userLabel;
    }

    public PublicAreaCommon(g r110) {
        super(IPublicAreaCommon.class);
        this.individualStrategyResult = new HashMap();
        this.trackingParams = new HashMap();
        this.lightInteractMobParams = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L79;
        g.a r102 = decodeExtensionFields(r101, r110);
        String r103 = null;
        switch(r101) {
            case 1: goto L78;
            case 2: goto L77;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L7;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L7;
            case 14: goto L37;
            case 15: goto L36;
            case 16: goto L35;
            case 17: goto L34;
            case 18: goto L33;
            case 19: goto L32;
            case 20: goto L31;
            case 21: goto L30;
            case 22: goto L29;
            case 23: goto L13;
            case 24: goto L12;
            case 25: goto L11;
            case 26: goto L10;
            case 27: goto L9;
            case 28: goto L8;
            default: goto L7;
        };
    L8:
        this.withUserFeatureLabel = am3.h.a(r110);
        goto L3
    L9:
        this.forceInsert = am3.h.a(r110);
        goto L3
    L10:
        this.bottomPinInfo = new BottomPinInfo(r110);
        goto L3
    L11:
        this.defaultClickSchemaUrl = am3.h.c(r110);
        goto L3
    L12:
        this.tailInteractType = r110.i();
        goto L3
    L13:
        long r111 = r110.c();
        String r104 = null;
    L14:
        int r105 = r110.f();
        if (r105 == (-1)) goto L21;
        if (r105 != 1) goto L17;
        r103 = am3.h.c(r110);
        goto L14
    L17:
        if (r105 != 2) goto L18;
        r104 = am3.h.c(r110);
        goto L14
    L18:
        am3.h.e(r110);
        goto L14
    L21:
        r110.d(r111);
        Map<String, String> r106 = this.lightInteractMobParams;
        if (r103 == null) goto L28;
        if (r104 == null) goto L26;
    L70:
        r106.put(r103, r104);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L29:
        this.shouldLogLightInteractMob = am3.h.a(r110);
        goto L3
    L30:
        this.isAiMsg = am3.h.a(r110);
        goto L3
    L31:
        this.batchRefresh = am3.h.a(r110);
        goto L3
    L32:
        this.isLikeComment = am3.h.a(r110);
        goto L3
    L33:
        this.showInDanmaku = am3.h.a(r110);
        goto L3
    L34:
        this.hoverInfo = _HoverInfo_ProtoDecoder.decodeStatic(r110);
        goto L3
    L35:
        this.chatMentionInfo = new ChatMentionInfo(r110);
        goto L3
    L36:
        this.forceInsertionPriority = r110.j();
        goto L3
    L37:
        this.personalizedInfo = new PersonalizedDisplayInfo(r110);
        goto L3
    L38:
        this.isSelected = r110.j();
        goto L3
    L39:
        long r112 = r110.c();
        r104 = null;
    L40:
        int r107 = r110.f();
        if (r107 == (-1)) goto L47;
        if (r107 != 1) goto L43;
        r103 = am3.h.c(r110);
        goto L40
    L43:
        if (r107 != 2) goto L44;
        r104 = am3.h.c(r110);
        goto L40
    L44:
        am3.h.e(r110);
        goto L40
    L47:
        r110.d(r112);
        r106 = this.trackingParams;
        if (r103 == null) goto L54;
        if (r104 != null) goto L70;
        throw new IllegalStateException("Value must not be null");
    L54:
        throw new IllegalStateException("Key must not be null");
    L55:
        this.forbidProfile = am3.h.a(r110);
        goto L3
    L56:
        this.actionType = r110.i();
        goto L3
    L57:
        this.suffixText = new SuffixText(r110);
        goto L3
    L58:
        this.supportPin = r110.j();
        goto L3
    L59:
        long r113 = r110.c();
        r104 = null;
    L60:
        int r108 = r110.f();
        if (r108 == (-1)) goto L67;
        if (r108 != 1) goto L63;
        r103 = am3.h.c(r110);
        goto L60
    L63:
        if (r108 != 2) goto L64;
        r104 = am3.h.c(r110);
        goto L60
    L64:
        am3.h.e(r110);
        goto L60
    L67:
        r110.d(r113);
        r106 = this.individualStrategyResult;
        if (r103 == null) goto L74;
        if (r104 != null) goto L70;
        throw new IllegalStateException("Value must not be null");
    L74:
        throw new IllegalStateException("Key must not be null");
    L75:
        this.individualPriority = (int) r110.j();
        goto L3
    L76:
        this.userSendGiftCount = (int) r110.j();
        goto L3
    L77:
        this.userConsume = (int) r110.j();
        goto L3
    L78:
        this.userLabel = x.a(r110);
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L79:
        r110.d(r100);
        setThreadSafe(true);
    }

    public static final /* synthetic */ void access$setSUPPORT_PIN$cp(long r100) {
        SUPPORT_PIN = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public void setActionType(int r100) {
        this.actionType = r100;
    }

    public void setAiMsg(boolean r100) {
        this.isAiMsg = r100;
    }

    public void setBatchRefresh(boolean r100) {
        this.batchRefresh = r100;
    }

    public void setBottomPinInfo(BottomPinInfo r100) {
        this.bottomPinInfo = r100;
    }

    public void setChatMentionInfo(ChatMentionInfo r100) {
        this.chatMentionInfo = r100;
    }

    public void setDefaultClickSchemaUrl(String r100) {
        this.defaultClickSchemaUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public void setFirstAggregateHistoryMessage(boolean r100) {
        this.isFirstAggregateHistoryMessage = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public void setFirstFetchBatchMsg(boolean r100) {
        this.isFirstFetchBatchMsg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public void setForbidProfile(boolean r100) {
        this.forbidProfile = r100;
    }

    public void setForceInsert(boolean r100) {
        this.forceInsert = r100;
    }

    public void setForceInsertionPriority(long r100) {
        this.forceInsertionPriority = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.IRtcRoomMessage
    public void setFromRtcRoom(boolean r100) {
        this.isFromRtcRoom = r100;
    }

    public void setHoverInfo(HoverInfo r100) {
        this.hoverInfo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.IPublicAreaCommon
    public void setIndividualPriority(int r100) {
        this.individualPriority = r100;
    }

    public void setIndividualStrategyResult(Map<String, String> r100) {
        this.individualStrategyResult = r100;
    }

    public void setLightInteractMobParams(Map<String, String> r100) {
        this.lightInteractMobParams = r100;
    }

    public void setLikeComment(boolean r100) {
        this.isLikeComment = r100;
    }

    public void setPersonalizedInfo(PersonalizedDisplayInfo r100) {
        this.personalizedInfo = r100;
    }

    public void setSelected(long r100) {
        this.isSelected = r100;
    }

    public void setShouldLogLightInteractMob(boolean r100) {
        this.shouldLogLightInteractMob = r100;
    }

    public final void setShowInDanmaku(boolean r100) {
        this.showInDanmaku = r100;
    }

    public void setSuffixText(SuffixText r100) {
        this.suffixText = r100;
    }

    public void setSupportPin(long r100) {
        this.supportPin = r100;
    }

    public final void setTailInteractType(int r100) {
        this.tailInteractType = r100;
    }

    public void setTrackingParams(Map<String, String> r100) {
        this.trackingParams = r100;
    }

    public final void setUserConsume(int r100) {
        this.userConsume = r100;
    }

    public void setUserLabel(ImageModel r100) {
        this.userLabel = r100;
    }

    public final void setUserSendGiftCount(int r100) {
        this.userSendGiftCount = r100;
    }

    public void setWithUserFeatureLabel(boolean r100) {
        this.withUserFeatureLabel = r100;
    }
}
