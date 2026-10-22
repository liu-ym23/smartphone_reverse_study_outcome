package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerReplyContent;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001e\u0010\u0011\u001a\u00060\fj\u0002`\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u001c\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001d\u0010\u000fR\u001c\u0010$\u001a\u0004\u0018\u00010 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0007\u001a\u0004\b!\u0010\"R\u001a\u0010)\u001a\u00020%8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0007\u001a\u0004\b&\u0010'R\u001c\u0010.\u001a\u0004\u0018\u00010*8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0007\u001a\u0004\b+\u0010,R\u001a\u00103\u001a\u00020/8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b0\u00101R\u001a\u00106\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0007\u001a\u0004\b4\u0010\u0005RB\u0010>\u001a*\u0012\b\u0012\u00060\fj\u0002`8\u0012\u0004\u0012\u000209\u0018\u000107j\u0014\u0012\b\u0012\u00060\fj\u0002`8\u0012\u0004\u0012\u000209\u0018\u0001`:8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b;\u0010<R\u001a\u0010A\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0007\u001a\u0004\b?\u0010\u000fR\u001a\u0010D\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bB\u0010\u0005R\u001a\u0010G\u001a\u00020/8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0007\u001a\u0004\bE\u00101R\u001a\u0010J\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0007\u001a\u0004\bH\u0010\u0005R\u001a\u0010O\u001a\u00020K8&X§\u0004¢\u0006\f\u0012\u0004\bN\u0010\u0007\u001a\u0004\bL\u0010MR\u001a\u0010T\u001a\u00020P8&X§\u0004¢\u0006\f\u0012\u0004\bS\u0010\u0007\u001a\u0004\bQ\u0010RR6\u0010]\u001a\u0016\u0012\u0004\u0012\u00020V\u0018\u00010Uj\n\u0012\u0004\u0012\u00020V\u0018\u0001`W8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\\\u0010\u0007\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010`\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0007\u001a\u0004\b^\u0010\u000fR\u001c\u0010c\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\bb\u0010\u0007\u001a\u0004\ba\u0010\u0005R\u001c\u0010h\u001a\u0004\u0018\u00010d8&X§\u0004¢\u0006\f\u0012\u0004\bg\u0010\u0007\u001a\u0004\be\u0010fR\u001c\u0010m\u001a\u0004\u0018\u00010i8&X§\u0004¢\u0006\f\u0012\u0004\bl\u0010\u0007\u001a\u0004\bj\u0010kR$\u0010t\u001a\u0004\u0018\u00010n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bs\u0010\u0007\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010w\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\bv\u0010\u0007\u001a\u0004\bu\u0010\u0005R\u001a\u0010z\u001a\u00020/8&X§\u0004¢\u0006\f\u0012\u0004\by\u0010\u0007\u001a\u0004\bx\u00101R\u001a\u0010}\u001a\u00020/8&X§\u0004¢\u0006\f\u0012\u0004\b|\u0010\u0007\u001a\u0004\b{\u00101R\u001d\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u007f\u0010\u0007\u001a\u0004\b~\u0010\u0005¨\u0006\u0081\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/k6;", "Lvh7/e;", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerReplyContent;", "", "getFromUid", "()Ljava/lang/String;", "getFromUid$annotations", "()V", "fromUid", "getToUid", "getToUid$annotations", "toUid", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "getFromRoomId", "()J", "getFromRoomId$annotations", "fromRoomId", "Lcom/bytedance/android/livesdk/link/model/j5;", "getFromLinkmicInfo", "()Lcom/bytedance/android/livesdk/link/model/j5;", "getFromLinkmicInfo$annotations", "fromLinkmicInfo", "getToLinkmicInfo", "getToLinkmicInfo$annotations", "toLinkmicInfo", "getLinkType", "getLinkType$annotations", "linkType", "getReplyStatus", "getReplyStatus$annotations", "replyStatus", "Lcom/bytedance/android/livesdk/link/model/m6;", "getLinkerSetting", "()Lcom/bytedance/android/livesdk/link/model/m6;", "getLinkerSetting$annotations", "linkerSetting", "", "getBizJoinChannel", "()Z", "getBizJoinChannel$annotations", "bizJoinChannel", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo$annotations", "multiChannelInfo", "", "getMultiPkMode", "()I", "getMultiPkMode$annotations", "multiPkMode", "getToast", "getToast$annotations", "toast", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LinkerId;", "Lcom/bytedance/android/livesdk/link/model/b9;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "getMatchType", "getMatchType$annotations", "matchType", "getKickedUsersniqueId", "getKickedUsersniqueId$annotations", "kickedUsersniqueId", "getSwitchToScene", "getSwitchToScene$annotations", "switchToScene", "getBattleConfigSettingStr", "getBattleConfigSettingStr$annotations", "battleConfigSettingStr", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getReplyVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getReplyVersionInfo$annotations", "replyVersionInfo", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo$annotations", "layoutInfo", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "getLinkUsers$annotations", "linkUsers", "getVersion", "getVersion$annotations", "version", "getClientAttachedInfoStr", "getClientAttachedInfoStr$annotations", "clientAttachedInfoStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "getPreRtcInfo$annotations", "preRtcInfo", "getBattleAttachedInfoStr", "getBattleAttachedInfoStr$annotations", "battleAttachedInfoStr", "getToBizType", "getToBizType$annotations", "toBizType", "getBizType", "getBizType$annotations", "bizType", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k6 extends vh7.e<ILinkerReplyContent>, ILinkerReplyContent {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerReplyContent, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerReplyContent, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfoStr();

    @FieldName(name = "battle_config_setting")
    String getBattleConfigSettingStr();

    @FieldName(name = "biz_join_channel")
    boolean getBizJoinChannel();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "client_attached_info")
    String getClientAttachedInfoStr();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_user_linkmic_info")
    j5 getFromLinkmicInfo();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    long getFromRoomId();

    @FieldName(name = "from_open_id")
    String getFromUid();

    @FieldName(name = "kicked_users_unique_id")
    String getKickedUsersniqueId();

    @FieldName(name = "layout_info")
    m getLayoutInfo();

    @FieldName(name = "link_type")
    long getLinkType();

    @FieldName(name = "linked_users")
    List<p> getLinkUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, b9> getLinkerContentMap();

    @FieldName(name = "linker_setting")
    m6 getLinkerSetting();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    long getMatchType();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_pk_mode")
    int getMultiPkMode();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();

    @FieldName(name = "reply_status")
    long getReplyStatus();

    @FieldName(name = "reply_version_info")
    com.bytedance.android.livesdk.link.model.bridge.k2 getReplyVersionInfo();

    @FieldName(name = "switch_to_scene")
    int getSwitchToScene();

    @FieldName(name = "to_biz_type")
    int getToBizType();

    @FieldName(name = "to_user_linkmic_info")
    j5 getToLinkmicInfo();

    @FieldName(name = "to_open_id")
    String getToUid();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "linked_users#setter")
    void setLinkUsers(List<? extends p> r100);

    @FieldName(name = "pre_rtc_info#setter")
    void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r100);
}
