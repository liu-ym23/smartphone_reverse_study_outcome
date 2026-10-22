package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomChannelInfo")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\bi\u00102R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR$\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R*\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b+\u0010,\u0012\u0004\b1\u00102\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00103\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.\"\u0004\b\u001b\u00100R\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\"\u00108\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0019\u001a\u0004\bF\u0010\u001a\"\u0004\bG\u0010\u001cR\"\u0010H\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0019\u001a\u0004\bI\u0010\u001a\"\u0004\bJ\u0010\u001cR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0012\u001a\u0004\bS\u0010\u0014\"\u0004\bT\u0010\u0016R$\u0010V\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010\\\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR*\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010&\u001a\u0004\bd\u0010(\"\u0004\be\u0010*R$\u0010f\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u0010,\u001a\u0004\bg\u0010.\"\u0004\bh\u00100¨\u0006k"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "", "", "mode", "I", "getMode", "()I", "setMode", "(I)V", "", RemoteMessageConst.Notification.CHANNEL_ID, "J", "getChannelId", "()J", "setChannelId", "(J)V", "", "token", "Ljava/lang/String;", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "", "isOwner", "Z", "()Z", "setOwner", "(Z)V", "memberCount", "getMemberCount", "setMemberCount", "channelName", "getChannelName", "setChannelName", "", "Lcom/bytedance/android/live/base/model/user/User;", "topUserList", "Ljava/util/List;", "getTopUserList", "()Ljava/util/List;", "setTopUserList", "(Ljava/util/List;)V", "needApprovalUser", "Lcom/bytedance/android/live/base/model/user/User;", "getNeedApprovalUser", "()Lcom/bytedance/android/live/base/model/user/User;", "setNeedApprovalUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", "getNeedApprovalUser$annotations", "()V", "owner", "getOwner", "maxMemberCount", "getMaxMemberCount", "setMaxMemberCount", "createType", "getCreateType", "setCreateType", "createAppId", "getCreateAppId", "setCreateAppId", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/SecretChatInfo;", "secretChatInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/SecretChatInfo;", "getSecretChatInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/SecretChatInfo;", "setSecretChatInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/SecretChatInfo;)V", "enableAnnouncement", "getEnableAnnouncement", "setEnableAnnouncement", "disableInvite", "getDisableInvite", "setDisableInvite", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/FansChannelCreateInfo;", "fansChannelCreateInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/FansChannelCreateInfo;", "getFansChannelCreateInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/FansChannelCreateInfo;", "setFansChannelCreateInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/FansChannelCreateInfo;)V", "inviteDisableToast", "getInviteDisableToast", "setInviteDisableToast", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelRtcExtInfo;", "rtcInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelRtcExtInfo;", "getRtcInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelRtcExtInfo;", "setRtcInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelRtcExtInfo;)V", "channelState", "Ljava/lang/Long;", "getChannelState", "()Ljava/lang/Long;", "setChannelState", "(Ljava/lang/Long;)V", "Lpy/k;", "avatarThumb", "getAvatarThumb", "setAvatarThumb", "groupLiveMember", "getGroupLiveMember", "setGroupLiveMember", "<init>", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomChannelInfo implements h {
    public static final Companion Companion = null;
    public static final int MODE_AUDIO_AND_TEXT = 1;
    public static final int MODE_NORMAL_TEXT = 0;

    @SerializedName("avatar_thumb")
    protected List<? extends k> avatarThumb;

    @SerializedName("channel_id")
    protected long channelId;

    @SerializedName(OpenFeedConstantKt.KEY_CHANNEL_NAME)
    protected String channelName;

    @SerializedName("channel_state")
    protected Long channelState;

    @SerializedName("create_app_id")
    protected long createAppId;

    @SerializedName("create_type")
    protected long createType;

    @SerializedName("disable_member_invite")
    protected boolean disableInvite;

    @SerializedName("enable_announcement")
    protected boolean enableAnnouncement;

    @SerializedName("fans_create_info")
    protected FansChannelCreateInfo fansChannelCreateInfo;

    @SerializedName("group_live_member")
    protected User groupLiveMember;

    @SerializedName("invite_disable_toast")
    protected String inviteDisableToast;

    @SerializedName("is_owner")
    protected boolean isOwner;

    @SerializedName("max_member_count")
    protected long maxMemberCount;

    @SerializedName("member_count")
    protected long memberCount;

    @SerializedName("room_channel_mode")
    protected int mode;

    @SerializedName("need_approval_user")
    protected User needApprovalUser;

    @SerializedName("owner")
    protected User owner;

    @SerializedName("rtc_ext_info")
    protected RoomChannelRtcExtInfo rtcInfo;

    @SerializedName("secret_chat_info")
    protected SecretChatInfo secretChatInfo;

    @SerializedName("token")
    protected String token;

    @SerializedName("top_user")
    protected List<? extends User> topUserList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo$Companion;", "", "()V", "MODE_AUDIO_AND_TEXT", "", "MODE_NORMAL_TEXT", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getNeedApprovalUser$annotations() {
    }

    public RoomChannelInfo() {
        this.channelState = 0L;
    }

    public final List<k> getAvatarThumb() {
        return this.avatarThumb;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final Long getChannelState() {
        return this.channelState;
    }

    public final long getCreateAppId() {
        return this.createAppId;
    }

    public final long getCreateType() {
        return this.createType;
    }

    public final boolean getDisableInvite() {
        return this.disableInvite;
    }

    public final boolean getEnableAnnouncement() {
        return this.enableAnnouncement;
    }

    public final FansChannelCreateInfo getFansChannelCreateInfo() {
        return this.fansChannelCreateInfo;
    }

    public final User getGroupLiveMember() {
        return this.groupLiveMember;
    }

    public final String getInviteDisableToast() {
        return this.inviteDisableToast;
    }

    public final long getMaxMemberCount() {
        return this.maxMemberCount;
    }

    public final long getMemberCount() {
        return this.memberCount;
    }

    public final int getMode() {
        return this.mode;
    }

    public final User getNeedApprovalUser() {
        return this.needApprovalUser;
    }

    public final User getOwner() {
        return this.owner;
    }

    public final RoomChannelRtcExtInfo getRtcInfo() {
        return this.rtcInfo;
    }

    public final SecretChatInfo getSecretChatInfo() {
        return this.secretChatInfo;
    }

    public final String getToken() {
        return this.token;
    }

    public final List<User> getTopUserList() {
        return this.topUserList;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public RoomChannelInfo(g r100) {
        this.topUserList = new ArrayList();
        this.avatarThumb = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L34;
        if (r102 != 14) goto L8;
        this.enableAnnouncement = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 200) goto L9;
        this.rtcInfo = new RoomChannelRtcExtInfo(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            default: goto L10;
        };
    L19:
        this.secretChatInfo = new SecretChatInfo(r100);
        goto L3
    L20:
        this.createType = r100.j();
        goto L3
    L21:
        this.maxMemberCount = r100.j();
        goto L3
    L22:
        this.owner = new User(r100);
        goto L3
    L23:
        this.needApprovalUser = new User(r100);
        goto L3
    L24:
        this.mode = r100.i();
        goto L3
    L25:
        this.channelName = am3.h.c(r100);
        goto L3
    L26:
        List r103 = this.topUserList;
        Object r104 = new User(r100);
    L27:
        r103.add(r104);
        goto L3
    L28:
        this.memberCount = r100.j();
        goto L3
    L29:
        this.isOwner = am3.h.a(r100);
        goto L3
    L30:
        this.token = am3.h.c(r100);
        goto L3
    L31:
        this.channelId = r100.j();
        goto L3
    L10:
        switch(r102) {
            case 16: goto L18;
            case 17: goto L17;
            case 18: goto L16;
            case 19: goto L15;
            case 20: goto L14;
            case 21: goto L13;
            case 22: goto L12;
            default: goto L11;
        };
    L12:
        this.groupLiveMember = new User(r100);
        goto L3
    L13:
        r103 = this.avatarThumb;
        r104 = f.a(r100, k.class);
        goto L27
    L14:
        this.channelState = Long.valueOf(r100.j());
        goto L3
    L15:
        this.createAppId = r100.j();
        goto L3
    L16:
        this.inviteDisableToast = am3.h.c(r100);
        goto L3
    L17:
        this.disableInvite = am3.h.a(r100);
        goto L3
    L18:
        this.fansChannelCreateInfo = new FansChannelCreateInfo(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L34:
        r100.d(r101);
        if (this.channelState != null) goto L86;
        this.channelState = 0L;
        return;
    }

    public final void setAvatarThumb(List<? extends k> r100) {
        this.avatarThumb = r100;
    }

    public final void setChannelId(long r100) {
        this.channelId = r100;
    }

    public final void setChannelName(String r100) {
        this.channelName = r100;
    }

    public final void setChannelState(Long r100) {
        this.channelState = r100;
    }

    public final void setCreateAppId(long r100) {
        this.createAppId = r100;
    }

    public final void setCreateType(long r100) {
        this.createType = r100;
    }

    public final void setDisableInvite(boolean r100) {
        this.disableInvite = r100;
    }

    public final void setEnableAnnouncement(boolean r100) {
        this.enableAnnouncement = r100;
    }

    public final void setFansChannelCreateInfo(FansChannelCreateInfo r100) {
        this.fansChannelCreateInfo = r100;
    }

    public final void setGroupLiveMember(User r100) {
        this.groupLiveMember = r100;
    }

    public final void setInviteDisableToast(String r100) {
        this.inviteDisableToast = r100;
    }

    public final void setMaxMemberCount(long r100) {
        this.maxMemberCount = r100;
    }

    public final void setMemberCount(long r100) {
        this.memberCount = r100;
    }

    public final void setMode(int r100) {
        this.mode = r100;
    }

    public final void setNeedApprovalUser(User r100) {
        this.needApprovalUser = r100;
    }

    public final void setOwner(User r100) {
        this.owner = r100;
    }

    public final void setRtcInfo(RoomChannelRtcExtInfo r100) {
        this.rtcInfo = r100;
    }

    public final void setSecretChatInfo(SecretChatInfo r100) {
        this.secretChatInfo = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }

    public final void setTopUserList(List<? extends User> r100) {
        this.topUserList = r100;
    }

    public final void setOwner(boolean r100) {
        this.isOwner = r100;
    }
}
