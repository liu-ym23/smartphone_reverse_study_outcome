package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.fc;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010#\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010'\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\"\u0010+\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R$\u00102\u001a\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\b\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R,\u0010:\u001a\f\u0012\u0006\b\u0001\u0012\u000204\u0018\u0001038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\b\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010>\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\b\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR\"\u0010B\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\b\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR$\u0010F\u001a\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\b\u001a\u0004\bC\u0010.\"\u0004\bD\u00100R\"\u0010J\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bI\u0010\b\u001a\u0004\bG\u0010\u0017\"\u0004\bH\u0010\u0019R\"\u0010N\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\bM\u0010\b\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010\u0019R\"\u0010U\u001a\u00020O8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bT\u0010\b\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010V\u001a\u00020O8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\b\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR$\u0010\\\u001a\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b[\u0010\b\u001a\u0004\bY\u0010.\"\u0004\bZ\u00100R$\u0010`\u001a\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b_\u0010\b\u001a\u0004\b]\u0010.\"\u0004\b^\u00100R$\u0010d\u001a\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bc\u0010\b\u001a\u0004\ba\u0010.\"\u0004\bb\u00100R\"\u0010h\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bg\u0010\b\u001a\u0004\be\u0010\f\"\u0004\bf\u0010\u000eR\"\u0010l\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bk\u0010\b\u001a\u0004\bi\u0010\f\"\u0004\bj\u0010\u000eR\"\u0010m\u001a\u00020O8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bo\u0010\b\u001a\u0004\bm\u0010Q\"\u0004\bn\u0010SR\"\u0010s\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\br\u0010\b\u001a\u0004\bp\u0010\f\"\u0004\bq\u0010\u000eR\"\u0010t\u001a\u00020O8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bv\u0010\b\u001a\u0004\bt\u0010Q\"\u0004\bu\u0010SR$\u0010}\u001a\u0004\u0018\u00010w8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b|\u0010\b\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R&\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0013\u0012\u0005\b\u0080\u0001\u0010\b\u001a\u0004\b~\u0010\u0004\"\u0004\b\u007f\u0010\u0006R&\u0010\u0085\u0001\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0084\u0001\u0010\b\u001a\u0005\b\u0082\u0001\u0010\u0017\"\u0005\b\u0083\u0001\u0010\u0019R&\u0010\u0089\u0001\u001a\u00020\n8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0088\u0001\u0010\b\u001a\u0005\b\u0086\u0001\u0010\f\"\u0005\b\u0087\u0001\u0010\u000eR+\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008a\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u008f\u0001\u0010\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R+\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0091\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0096\u0001\u0010\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R/\u0010\u009c\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0098\u0001\u0018\u0001038&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u009b\u0001\u0010\b\u001a\u0005\b\u0099\u0001\u00106\"\u0005\b\u009a\u0001\u00108R+\u0010£\u0001\u001a\u0005\u0018\u00010\u009d\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b¢\u0001\u0010\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R&\u0010§\u0001\u001a\u00020O8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b¦\u0001\u0010\b\u001a\u0005\b¤\u0001\u0010Q\"\u0005\b¥\u0001\u0010SR$\u0010ª\u0001\u001a\u0005\u0018\u00010\u009d\u00018&@&X¦\u000e¢\u0006\u0010\u001a\u0006\b¨\u0001\u0010\u009f\u0001\"\u0006\b©\u0001\u0010¡\u0001R&\u0010®\u0001\u001a\u00020\n8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u00ad\u0001\u0010\b\u001a\u0005\b«\u0001\u0010\f\"\u0005\b¬\u0001\u0010\u000eR&\u0010¯\u0001\u001a\u00020O8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b±\u0001\u0010\b\u001a\u0005\b¯\u0001\u0010Q\"\u0005\b°\u0001\u0010SR&\u0010µ\u0001\u001a\u00020,8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b´\u0001\u0010\b\u001a\u0005\b²\u0001\u0010.\"\u0005\b³\u0001\u00100R+\u0010¼\u0001\u001a\u0005\u0018\u00010¶\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b»\u0001\u0010\b\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R\u001f\u0010½\u0001\u001a\u00020O8&@&X¦\u000e¢\u0006\u000e\u001a\u0005\b½\u0001\u0010Q\"\u0005\b¾\u0001\u0010S¨\u0006¿\u0001"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/n0;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUserFlex", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUserFlex", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getUserFlex$annotations", "()V", "userFlex", "", "getLinkmicId", "()J", "setLinkmicId", "(J)V", "getLinkmicId$annotations", "linkmicId", "getModifyTime", "setModifyTime", "getModifyTime$annotations", "modifyTime", "", "getMLinkStatus", "()I", "setMLinkStatus", "(I)V", "getMLinkStatus$annotations", "mLinkStatus", "getMLinkType", "setMLinkType", "getMLinkType$annotations", "mLinkType", "getMRoleType", "setMRoleType", "getMRoleType$annotations", "mRoleType", "getUserPosition", "setUserPosition", "getUserPosition$annotations", "userPosition", "getSilenceStatus", "setSilenceStatus", "getSilenceStatus$annotations", "silenceStatus", "", "getLinkmicIdStr", "()Ljava/lang/String;", "setLinkmicIdStr", "(Ljava/lang/String;)V", "getLinkmicIdStr$annotations", "linkmicIdStr", "", "Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "getSongListFlex", "()Ljava/util/List;", "setSongListFlex", "(Ljava/util/List;)V", "getSongListFlex$annotations", "songListFlex", "getAppId", "setAppId", "getAppId$annotations", "appId", "getClientVersion", "setClientVersion", "getClientVersion$annotations", "clientVersion", "getDevicePlatform", "setDevicePlatform", "getDevicePlatform$annotations", "devicePlatform", "getListUserType", "setListUserType", "getListUserType$annotations", "listUserType", "getListUserFromType", "setListUserFromType", "getListUserFromType$annotations", "listUserFromType", "", "getHasExpired", "()Z", "setHasExpired", "(Z)V", "getHasExpired$annotations", "hasExpired", "isMutualFollow", "setMutualFollow", "isMutualFollow$annotations", "getApplyReason", "setApplyReason", "getApplyReason$annotations", "applyReason", "getLast7DaysGiftCountTxt", "setLast7DaysGiftCountTxt", "getLast7DaysGiftCountTxt$annotations", "last7DaysGiftCountTxt", "getFanTicket", "setFanTicket", "getFanTicket$annotations", "fanTicket", "getOffset", "setOffset", "getOffset$annotations", "offset", "getRank", "setRank", "getRank$annotations", "rank", "isAddPrice", "setAddPrice", "isAddPrice$annotations", "getAddPriceTime", "setAddPriceTime", "getAddPriceTime$annotations", "addPriceTime", "isAnonymous", "setAnonymous", "isAnonymous$annotations", "Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "getMicPosTagFlex", "()Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "setMicPosTagFlex", "(Lcom/bytedance/android/live/liveinteract/plantform/model/g0;)V", "getMicPosTagFlex$annotations", "micPosTagFlex", "getInvitorFlex", "setInvitorFlex", "getInvitorFlex$annotations", "invitorFlex", "getApplyType", "setApplyType", "getApplyType$annotations", "applyType", "getPaidAmount", "setPaidAmount", "getPaidAmount$annotations", "paidAmount", "Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "getJoinTeamFightInfoFlex", "()Lcom/bytedance/android/live/liveinteract/plantform/model/j0;", "setJoinTeamFightInfoFlex", "(Lcom/bytedance/android/live/liveinteract/plantform/model/j0;)V", "getJoinTeamFightInfoFlex$annotations", "joinTeamFightInfoFlex", "Lcom/bytedance/android/livesdk/message/model/fc;", "getUserHighScoreSongTagFlex", "()Lcom/bytedance/android/livesdk/message/model/fc;", "setUserHighScoreSongTagFlex", "(Lcom/bytedance/android/livesdk/message/model/fc;)V", "getUserHighScoreSongTagFlex$annotations", "userHighScoreSongTagFlex", "Lcom/bytedance/android/live/liveinteract/plantform/model/v;", "getTags", "setTags", "getTags$annotations", PromotionProductPrivilegesStruct.TAGS, "Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "getEventInfo", "()Lcom/bytedance/android/live/liveinteract/plantform/model/c0;", "setEventInfo", "(Lcom/bytedance/android/live/liveinteract/plantform/model/c0;)V", "getEventInfo$annotations", "eventInfo", "getAlreadyInvited", "setAlreadyInvited", "getAlreadyInvited$annotations", "alreadyInvited", "getEventInfoFlex", "setEventInfoFlex", "eventInfoFlex", "getOrderedSongCount", "setOrderedSongCount", "getOrderedSongCount$annotations", "orderedSongCount", "isActive", "setActive", "isActive$annotations", "getButtonText", "setButtonText", "getButtonText$annotations", "buttonText", "Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "getTag", "()Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;", "setTag", "(Lcom/bytedance/android/live/liveinteract/plantform/model/ListUserTag;)V", "getTag$annotations", "tag", "isHasApplied", "setHasApplied", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n0 extends vh7.c<n0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "add_price_time_ms")
    long getAddPriceTime();

    @FieldName(name = "already_invited")
    boolean getAlreadyInvited();

    @FieldName(name = "app_id")
    long getAppId();

    @FieldName(name = "application_reason")
    String getApplyReason();

    @FieldName(name = ILiveRoomPlayFragmentConstant.LINK_MIC_APPLY_TYPE)
    int getApplyType();

    @FieldName(name = "button_text")
    String getButtonText();

    @FieldName(name = "client_version")
    long getClientVersion();

    @FieldName(name = "device_platform")
    String getDevicePlatform();

    @FieldName(name = "event_info")
    c0 getEventInfo();

    c0 getEventInfoFlex();

    @FieldName(name = "fan_ticket")
    String getFanTicket();

    @FieldName(name = "application_has_expired")
    boolean getHasExpired();

    @FieldName(name = "invitor")
    IBaseUser getInvitorFlex();

    @FieldName(name = "join_teamfight_info")
    j0 getJoinTeamFightInfoFlex();

    @FieldName(name = "last_7_days_gift_count_text")
    String getLast7DaysGiftCountTxt();

    @FieldName(name = "linkmic_id")
    long getLinkmicId();

    @FieldName(name = "linkmic_id_str")
    String getLinkmicIdStr();

    @FieldName(name = "list_user_from_type")
    int getListUserFromType();

    @FieldName(name = "list_user_type")
    int getListUserType();

    @FieldName(name = "link_status")
    int getMLinkStatus();

    @FieldName(name = "link_type")
    int getMLinkType();

    @FieldName(name = "role_type")
    int getMRoleType();

    @FieldName(name = "mic_pos_tag_info")
    g0 getMicPosTagFlex();

    @FieldName(name = "modify_time")
    long getModifyTime();

    @FieldName(name = "offset")
    long getOffset();

    @FieldName(name = "order_song_count")
    long getOrderedSongCount();

    @FieldName(name = "paid_amount")
    long getPaidAmount();

    @FieldName(name = "rank")
    long getRank();

    @FieldName(name = "silence_status")
    int getSilenceStatus();

    @FieldName(name = "song_list")
    List<KtvMusic> getSongListFlex();

    @FieldName(name = "tag")
    ListUserTag getTag();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<v> getTags();

    @FieldName(name = "user")
    IBaseUser getUserFlex();

    @FieldName(name = "high_score_song_tag")
    fc getUserHighScoreSongTagFlex();

    @FieldName(name = "user_position")
    int getUserPosition();

    @FieldName(name = "is_active")
    boolean isActive();

    @FieldName(name = "is_add_price")
    boolean isAddPrice();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    boolean isAnonymous();

    boolean isHasApplied();

    @FieldName(name = "is_mutual_following")
    boolean isMutualFollow();

    @FieldName(name = "is_active#setter")
    void setActive(boolean r100);

    @FieldName(name = "is_add_price#setter")
    void setAddPrice(boolean r100);

    @FieldName(name = "add_price_time_ms#setter")
    void setAddPriceTime(long r100);

    @FieldName(name = "already_invited#setter")
    void setAlreadyInvited(boolean r100);

    @FieldName(name = "is_anonymous#setter")
    void setAnonymous(boolean r100);

    @FieldName(name = "app_id#setter")
    void setAppId(long r100);

    @FieldName(name = "application_reason#setter")
    void setApplyReason(String r100);

    @FieldName(name = "apply_type#setter")
    void setApplyType(int r100);

    @FieldName(name = "button_text#setter")
    void setButtonText(String r100);

    @FieldName(name = "client_version#setter")
    void setClientVersion(long r100);

    @FieldName(name = "device_platform#setter")
    void setDevicePlatform(String r100);

    @FieldName(name = "event_info#setter")
    void setEventInfo(c0 r100);

    void setEventInfoFlex(c0 r100);

    @FieldName(name = "fan_ticket#setter")
    void setFanTicket(String r100);

    void setHasApplied(boolean r100);

    @FieldName(name = "application_has_expired#setter")
    void setHasExpired(boolean r100);

    @FieldName(name = "invitor#setter")
    void setInvitorFlex(IBaseUser r100);

    @FieldName(name = "join_teamfight_info#setter")
    void setJoinTeamFightInfoFlex(j0 r100);

    @FieldName(name = "last_7_days_gift_count_text#setter")
    void setLast7DaysGiftCountTxt(String r100);

    @FieldName(name = "linkmic_id#setter")
    void setLinkmicId(long r100);

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkmicIdStr(String r100);

    @FieldName(name = "list_user_from_type#setter")
    void setListUserFromType(int r100);

    @FieldName(name = "list_user_type#setter")
    void setListUserType(int r100);

    @FieldName(name = "link_status#setter")
    void setMLinkStatus(int r100);

    @FieldName(name = "link_type#setter")
    void setMLinkType(int r100);

    @FieldName(name = "role_type#setter")
    void setMRoleType(int r100);

    @FieldName(name = "mic_pos_tag_info#setter")
    void setMicPosTagFlex(g0 r100);

    @FieldName(name = "modify_time#setter")
    void setModifyTime(long r100);

    @FieldName(name = "is_mutual_following#setter")
    void setMutualFollow(boolean r100);

    @FieldName(name = "offset#setter")
    void setOffset(long r100);

    @FieldName(name = "order_song_count#setter")
    void setOrderedSongCount(long r100);

    @FieldName(name = "paid_amount#setter")
    void setPaidAmount(long r100);

    @FieldName(name = "rank#setter")
    void setRank(long r100);

    @FieldName(name = "silence_status#setter")
    void setSilenceStatus(int r100);

    @FieldName(name = "song_list#setter")
    void setSongListFlex(List<KtvMusic> r100);

    @FieldName(name = "tag#setter")
    void setTag(ListUserTag r100);

    @FieldName(name = "tags#setter")
    void setTags(List<? extends v> r100);

    @FieldName(name = "user#setter")
    void setUserFlex(IBaseUser r100);

    @FieldName(name = "high_score_song_tag#setter")
    void setUserHighScoreSongTagFlex(fc r100);

    @FieldName(name = "user_position#setter")
    void setUserPosition(int r100);
}
