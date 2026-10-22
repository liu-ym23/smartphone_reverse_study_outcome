package com.bytedance.android.live.revenuelink.connect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revenuelink/connect/ConnectAutoRejectType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "ERROR_IN_MESSAGE", "ERROR_IN_SYSTEM", "MOSAIC_STATUS", "IS_PLAYING_GAME", "MODE_VIDEO_TALK", "MODE_IN_ROOM_AUDIO_INTERACT", "IS_LINK_WITH_AUDIENCE", "PRECISION_MATCHING", "PK_NOTIFYING", "REJECT_IN_INVITING", "REJECT_IN_BE_INVITING", "REJECT_IN_APPLYING", "LINKING_NOT_MULTI_INVITE", "CHANNEL_ID_SAME", "MULTI_INVITE_NOT_LINKING", "MULTI_INVITE_PK_WITH_AUDIENCE", "MULTI_INVITE_LINK_ANCHOR_CNT", "REJECT_IN_MATCHING_INVITE", "revenue-link-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ConnectAutoRejectType extends Enum<ConnectAutoRejectType> {
    public static final ConnectAutoRejectType CHANNEL_ID_SAME = null;
    public static final ConnectAutoRejectType ERROR_IN_MESSAGE = null;
    public static final ConnectAutoRejectType ERROR_IN_SYSTEM = null;
    public static final ConnectAutoRejectType IS_LINK_WITH_AUDIENCE = null;
    public static final ConnectAutoRejectType IS_PLAYING_GAME = null;
    public static final ConnectAutoRejectType LINKING_NOT_MULTI_INVITE = null;
    public static final ConnectAutoRejectType MODE_IN_ROOM_AUDIO_INTERACT = null;
    public static final ConnectAutoRejectType MODE_VIDEO_TALK = null;
    public static final ConnectAutoRejectType MOSAIC_STATUS = null;
    public static final ConnectAutoRejectType MULTI_INVITE_LINK_ANCHOR_CNT = null;
    public static final ConnectAutoRejectType MULTI_INVITE_NOT_LINKING = null;
    public static final ConnectAutoRejectType MULTI_INVITE_PK_WITH_AUDIENCE = null;
    public static final ConnectAutoRejectType PK_NOTIFYING = null;
    public static final ConnectAutoRejectType PRECISION_MATCHING = null;
    public static final ConnectAutoRejectType REJECT_IN_APPLYING = null;
    public static final ConnectAutoRejectType REJECT_IN_BE_INVITING = null;
    public static final ConnectAutoRejectType REJECT_IN_INVITING = null;
    public static final ConnectAutoRejectType REJECT_IN_MATCHING_INVITE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConnectAutoRejectType[] f91723a = null;
    private final String type;

    public static ConnectAutoRejectType valueOf(String r100) {
        return (ConnectAutoRejectType) r27.a.a(ConnectAutoRejectType.class, r100);
    }

    public static ConnectAutoRejectType[] values() {
        return (ConnectAutoRejectType[]) f91723a.clone();
    }

    static {
        ConnectAutoRejectType r100 = new ConnectAutoRejectType("ERROR_IN_MESSAGE", 0, "error_in_message");
        ERROR_IN_MESSAGE = r100;
        ConnectAutoRejectType r101 = new ConnectAutoRejectType("ERROR_IN_SYSTEM", 1, "error_in_system");
        ERROR_IN_SYSTEM = r101;
        ConnectAutoRejectType r102 = new ConnectAutoRejectType("MOSAIC_STATUS", 2, "mosaic_status");
        MOSAIC_STATUS = r102;
        ConnectAutoRejectType r103 = new ConnectAutoRejectType("IS_PLAYING_GAME", 3, "isPlayingGame");
        IS_PLAYING_GAME = r103;
        ConnectAutoRejectType r104 = new ConnectAutoRejectType("MODE_VIDEO_TALK", 4, "mode_video_talk");
        MODE_VIDEO_TALK = r104;
        ConnectAutoRejectType r105 = new ConnectAutoRejectType("MODE_IN_ROOM_AUDIO_INTERACT", 5, "mode_in_room_audio_interact");
        MODE_IN_ROOM_AUDIO_INTERACT = r105;
        ConnectAutoRejectType r106 = new ConnectAutoRejectType("IS_LINK_WITH_AUDIENCE", 6, "is_link_with_audience");
        IS_LINK_WITH_AUDIENCE = r106;
        ConnectAutoRejectType r107 = new ConnectAutoRejectType("PRECISION_MATCHING", 7, "precision_match");
        PRECISION_MATCHING = r107;
        ConnectAutoRejectType r108 = new ConnectAutoRejectType("PK_NOTIFYING", 8, "pk_notifying");
        PK_NOTIFYING = r108;
        ConnectAutoRejectType r109 = new ConnectAutoRejectType("REJECT_IN_INVITING", 9, "reject_in_inviting");
        REJECT_IN_INVITING = r109;
        ConnectAutoRejectType r110 = new ConnectAutoRejectType("REJECT_IN_BE_INVITING", 10, "reject_in_be_inviting");
        REJECT_IN_BE_INVITING = r110;
        ConnectAutoRejectType r111 = new ConnectAutoRejectType("REJECT_IN_APPLYING", 11, "reject_in_applying");
        REJECT_IN_APPLYING = r111;
        ConnectAutoRejectType r112 = new ConnectAutoRejectType("LINKING_NOT_MULTI_INVITE", 12, "linking_not_multi_invite");
        LINKING_NOT_MULTI_INVITE = r112;
        ConnectAutoRejectType r113 = new ConnectAutoRejectType("CHANNEL_ID_SAME", 13, "channel_id_same");
        CHANNEL_ID_SAME = r113;
        ConnectAutoRejectType r114 = new ConnectAutoRejectType("MULTI_INVITE_NOT_LINKING", 14, "multi_invite_not_linking");
        MULTI_INVITE_NOT_LINKING = r114;
        ConnectAutoRejectType r115 = new ConnectAutoRejectType("MULTI_INVITE_PK_WITH_AUDIENCE", 15, "multi_invite_pk_with_audience");
        MULTI_INVITE_PK_WITH_AUDIENCE = r115;
        ConnectAutoRejectType r116 = new ConnectAutoRejectType("MULTI_INVITE_LINK_ANCHOR_CNT", 16, "multi_invite_link_anchor_cnt");
        MULTI_INVITE_LINK_ANCHOR_CNT = r116;
        ConnectAutoRejectType r117 = new ConnectAutoRejectType("REJECT_IN_MATCHING_INVITE", 17, "reject_in_match_invite");
        REJECT_IN_MATCHING_INVITE = r117;
        f91723a = new ConnectAutoRejectType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117};
    }

    public final String getType() {
        return this.type;
    }

    public ConnectAutoRejectType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
