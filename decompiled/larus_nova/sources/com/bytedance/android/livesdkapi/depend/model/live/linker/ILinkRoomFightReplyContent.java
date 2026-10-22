package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdkapi.depend.model.live.link.IRoomBattleProcessInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\nR\u001a\u0010\u0016\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\nR\u001a\u0010\u0019\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u000fR\u001c\u0010$\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u000fR\u001a\u0010'\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010(8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b)\u0010*R\u001c\u00100\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b-\u0010.R\u001c\u00104\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkRoomFightReplyContent;", "Lvh7/c;", "", "getReplyType", "()I", "getReplyType$annotations", "()V", "replyType", "", "getInviteeRoomId", "()J", "getInviteeRoomId$annotations", "inviteeRoomId", "", "getInviteeAnchorId", "()Ljava/lang/String;", "inviteeAnchorId", "getFollowStatus", "getFollowStatus$annotations", "followStatus", "getInviteSource", "getInviteSource$annotations", "inviteSource", "getCrossType", "getCrossType$annotations", "crossType", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkRoomFightReplyGuestInfo;", "getGuestInfos", "()Ljava/util/List;", "getGuestInfos$annotations", "guestInfos", "getReplyUserId", "replyUserId", "getReplyToast", "getReplyToast$annotations", "replyToast", "getReplyOperate", "getReplyOperate$annotations", "replyOperate", "Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "getProcessStatus", "()Lcom/bytedance/android/livesdkapi/depend/model/live/link/IRoomBattleProcessInfo;", "getProcessStatus$annotations", "processStatus", "getCrossRoomKind", "()Ljava/lang/Integer;", "getCrossRoomKind$annotations", "crossRoomKind", "getInviteeLiveRoomMode", "()Ljava/lang/Long;", "getInviteeLiveRoomMode$annotations", "inviteeLiveRoomMode", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkRoomFightReplyContent extends c<ILinkRoomFightReplyContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "cross_room_kind")
        public static /* synthetic */ void getCrossRoomKind$annotations() {
        }

        @FieldName(name = "cross_type")
        public static /* synthetic */ void getCrossType$annotations() {
        }

        @FieldName(name = "follow_status")
        public static /* synthetic */ void getFollowStatus$annotations() {
        }

        @FieldName(name = "guest_infos")
        public static /* synthetic */ void getGuestInfos$annotations() {
        }

        @FieldName(name = "invite_source")
        public static /* synthetic */ void getInviteSource$annotations() {
        }

        @FieldName(name = "invitee_live_room_mode")
        public static /* synthetic */ void getInviteeLiveRoomMode$annotations() {
        }

        @FieldName(name = "invitee_room_id")
        public static /* synthetic */ void getInviteeRoomId$annotations() {
        }

        @FieldName(name = "process_info")
        public static /* synthetic */ void getProcessStatus$annotations() {
        }

        @FieldName(name = "reply_operate")
        public static /* synthetic */ void getReplyOperate$annotations() {
        }

        @FieldName(name = "reply_toast")
        public static /* synthetic */ void getReplyToast$annotations() {
        }

        @FieldName(name = "reply_type")
        public static /* synthetic */ void getReplyType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "cross_room_kind")
    Integer getCrossRoomKind();

    @FieldName(name = "cross_type")
    int getCrossType();

    @FieldName(name = "follow_status")
    long getFollowStatus();

    @FieldName(name = "guest_infos")
    List<LinkRoomFightReplyGuestInfo> getGuestInfos();

    @FieldName(name = "invite_source")
    long getInviteSource();

    String getInviteeAnchorId();

    @FieldName(name = "invitee_live_room_mode")
    Long getInviteeLiveRoomMode();

    @FieldName(name = "invitee_room_id")
    long getInviteeRoomId();

    @FieldName(name = "process_info")
    IRoomBattleProcessInfo getProcessStatus();

    @FieldName(name = "reply_operate")
    int getReplyOperate();

    @FieldName(name = "reply_toast")
    String getReplyToast();

    @FieldName(name = "reply_type")
    int getReplyType();

    String getReplyUserId();
}
