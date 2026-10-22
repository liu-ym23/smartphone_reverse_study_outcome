package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\u000fR\u001c\u0010 \u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\u0004\u0018\u00010!8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0006\u001a\u0004\b&\u0010#¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/aa;", "Lvh7/c;", "", "getMatchType", "()I", "getMatchType$annotations", "()V", "matchType", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "getProcessInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "getProcessInfo$annotations", "processInfo", "", "getRivalUserCount", "()Ljava/lang/Long;", "getRivalUserCount$annotations", "rivalUserCount", "getRivalChatRoomRank", "getRivalChatRoomRank$annotations", "rivalChatRoomRank", "getRivalFollowStatus", "getRivalFollowStatus$annotations", "rivalFollowStatus", "getInviteSource", "getInviteSource$annotations", "inviteSource", "get_rivalAnchorId", "get_rivalAnchorId$annotations", "_rivalAnchorId", "get_operatorUserId", "get_operatorUserId$annotations", "_operatorUserId", "", "get_rivalAnchorOpenId", "()Ljava/lang/String;", "get_rivalAnchorOpenId$annotations", "_rivalAnchorOpenId", "get_operatorOpenId", "get_operatorOpenId$annotations", "_operatorOpenId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface aa extends vh7.c<aa> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "invite_source")
    Long getInviteSource();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    int getMatchType();

    @FieldName(name = "process_info")
    IRoomBattleProcessInfo getProcessInfo();

    @FieldName(name = "rival_chat_room_rank")
    Long getRivalChatRoomRank();

    @FieldName(name = "rival_follow_status")
    Long getRivalFollowStatus();

    @FieldName(name = "rival_user_count")
    Long getRivalUserCount();

    @FieldName(name = "operator_open_id")
    String get_operatorOpenId();

    @FieldName(name = "operator_user_id")
    Long get_operatorUserId();

    @FieldName(name = "rival_anchor_id")
    Long get_rivalAnchorId();

    @FieldName(name = "rival_open_id")
    String get_rivalAnchorOpenId();
}
