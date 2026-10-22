package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerInviteContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bR\u0010\u000bR(\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0004\u0010\u0005\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0014\u0010\u000e\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R(\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0005\u0012\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u000eR\u0016\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR$\u00104\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u00107\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010,\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R$\u0010:\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u000e\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\"\u0010=\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010,\u001a\u0004\b>\u0010.\"\u0004\b?\u00100R\"\u0010@\u001a\u00020*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010,\u001a\u0004\bA\u0010.\"\u0004\bB\u00100R\u0014\u0010D\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0010R\u0014\u0010F\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0010R\u0014\u0010H\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010 R(\u0010M\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010%j\n\u0012\u0004\u0012\u00020I\u0018\u0001`J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR(\u0010O\u001a\u0016\u0012\u0004\u0012\u00020I\u0018\u00010%j\n\u0012\u0004\u0012\u00020I\u0018\u0001`J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010LR\u0014\u0010Q\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010.¨\u0006S"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerInviteContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/g1;", "", "fromUserId", "J", "getFromUserId", "()J", "setFromUserId", "(J)V", "getFromUserId$annotations", "()V", "", "fromUserOpenId", "Ljava/lang/String;", "getFromUserOpenId", "()Ljava/lang/String;", "setFromUserOpenId", "(Ljava/lang/String;)V", "getFromUserOpenId$annotations", "toOpenId", "getToOpenId", "setToOpenId", "getToOpenId$annotations", "toUserId", "getToUserId", "setToUserId", "getToUserId$annotations", "", Constants.OperatorKey.KEY_VENDOR, "I", "getVendor", "()I", "setVendor", "(I)V", "secFromUserId", "mInviteSource", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "mInviteeFollowUsers", "Ljava/util/List;", "mInviterUsers", "", "mInviterWithAudience", "Z", "getMInviterWithAudience", "()Z", "setMInviterWithAudience", "(Z)V", "fromRoomId", "getFromRoomId", "setFromRoomId", "toRtcExtInfo", "getToRtcExtInfo", "setToRtcExtInfo", "rtcJoinChannel", "getRtcJoinChannel", "setRtcJoinChannel", "toLinkmicIdStr", "getToLinkmicIdStr", "setToLinkmicIdStr", "rtcPushStream", "getRtcPushStream", "setRtcPushStream", "supportMultiPkTeamMode", "getSupportMultiPkTeamMode", "setSupportMultiPkTeamMode", "get_fromUid", "_fromUid", "get_secFromUid", "_secFromUid", "getInviteSource", "inviteSource", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getInviterUsers", "()Ljava/util/List;", "inviterUsers", "getInviteeFollowUsers", "inviteeFollowUsers", "getInviterWithAudience", "inviterWithAudience", "<init>", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerInviteContent extends FlexModelBase<g1> implements g1, h {

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long fromRoomId;

    @SerializedName("from_user_id")
    protected long fromUserId;

    @SerializedName("from_open_id")
    protected String fromUserOpenId;

    @SerializedName("invite_source")
    public int mInviteSource;

    @SerializedName("invitee_followed_users")
    public List<AnchorLinkUser> mInviteeFollowUsers;

    @SerializedName("inviter_users")
    public List<AnchorLinkUser> mInviterUsers;

    @SerializedName("inviter_with_audience")
    protected boolean mInviterWithAudience;

    @SerializedName("rtc_join_channel")
    protected boolean rtcJoinChannel;

    @SerializedName("rtc_push_stream")
    protected boolean rtcPushStream;

    @SerializedName("sec_from_user_id")
    public String secFromUserId;

    @SerializedName("support_multi_pk_team_mode")
    protected boolean supportMultiPkTeamMode;

    @SerializedName("to_linkmic_id_str")
    protected String toLinkmicIdStr;

    @SerializedName("to_open_id")
    protected String toOpenId;

    @SerializedName("to_rtc_ext_info")
    protected String toRtcExtInfo;

    @SerializedName(a.KEY_TO_USER_ID)
    protected long toUserId;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    protected int f162623vendor;

    public LinkerInviteContent() {
        super(g1.class);
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getFromUserId$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getFromUserOpenId$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getToOpenId$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getToUserId$annotations() {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1
    public List<k> getInviteeFollowUsers() {
        return KotlinTypeUtilsKt.castElementType(this.mInviteeFollowUsers);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1
    public List<k> getInviterUsers() {
        return KotlinTypeUtilsKt.castElementType(this.mInviterUsers);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1
    public String get_fromUid() {
        o0.a r100 = o0.f58946a;
        Long r101 = Long.valueOf(this.fromUserId);
        String r102 = this.fromUserOpenId;
        r100.getClass();
        return o0.a.g(r101, r102);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1
    public String get_secFromUid() {
        o0.a r100 = o0.f58946a;
        String r101 = this.fromUserOpenId;
        r100.getClass();
        if (r101 != null) goto L6;
        return "0";
    L6:
        return r101;
    }

    public final long getFromRoomId() {
        return this.fromRoomId;
    }

    public final long getFromUserId() {
        return this.fromUserId;
    }

    public final String getFromUserOpenId() {
        return this.fromUserOpenId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1
    public int getInviteSource() {
        return this.mInviteSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.g1
    public boolean getInviterWithAudience() {
        return this.mInviterWithAudience;
    }

    public final boolean getMInviterWithAudience() {
        return this.mInviterWithAudience;
    }

    public final boolean getRtcJoinChannel() {
        return this.rtcJoinChannel;
    }

    public final boolean getRtcPushStream() {
        return this.rtcPushStream;
    }

    public final boolean getSupportMultiPkTeamMode() {
        return this.supportMultiPkTeamMode;
    }

    public final String getToLinkmicIdStr() {
        return this.toLinkmicIdStr;
    }

    public final String getToOpenId() {
        return this.toOpenId;
    }

    public final String getToRtcExtInfo() {
        return this.toRtcExtInfo;
    }

    public final long getToUserId() {
        return this.toUserId;
    }

    public final int getVendor() {
        return this.f162623vendor;
    }

    public LinkerInviteContent(g r100) {
        super(g1.class);
        this.mInviteeFollowUsers = new ArrayList();
        this.mInviterUsers = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L33;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 10) goto L8;
        this.mInviteSource = r100.i();
        goto L3
    L8:
        if (r102 != 15) goto L10;
        this.supportMultiPkTeamMode = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 5000) goto L12;
        this.fromUserOpenId = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5001) goto L13;
        this.toOpenId = am3.h.c(r100);
        goto L3
    L13:
        switch(r102) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            default: goto L14;
        };
    L21:
        this.rtcPushStream = am3.h.a(r100);
        goto L3
    L22:
        this.toLinkmicIdStr = am3.h.c(r100);
        goto L3
    L23:
        this.secFromUserId = am3.h.c(r100);
        goto L3
    L24:
        this.f162623vendor = (int) r100.j();
        goto L3
    L25:
        this.rtcJoinChannel = am3.h.a(r100);
        goto L3
    L26:
        this.toRtcExtInfo = am3.h.c(r100);
        goto L3
    L27:
        this.fromRoomId = r100.j();
        goto L3
    L28:
        this.fromUserId = r100.j();
        goto L3
    L14:
        switch(r102) {
            case 20: goto L20;
            case 21: goto L18;
            case 22: goto L17;
            case 23: goto L16;
            default: goto L15;
        };
    L16:
        this.toUserId = r100.j();
        goto L3
    L17:
        List<AnchorLinkUser> r104 = this.mInviterUsers;
        AnchorLinkUser r105 = new AnchorLinkUser(r100);
    L19:
        r104.add(r105);
        goto L3
    L18:
        r104 = this.mInviteeFollowUsers;
        r105 = new AnchorLinkUser(r100);
        goto L19
    L20:
        this.mInviterWithAudience = am3.h.a(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L33:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setFromRoomId(long r100) {
        this.fromRoomId = r100;
    }

    public final void setFromUserId(long r100) {
        this.fromUserId = r100;
    }

    public final void setFromUserOpenId(String r100) {
        this.fromUserOpenId = r100;
    }

    public final void setMInviterWithAudience(boolean r100) {
        this.mInviterWithAudience = r100;
    }

    public final void setRtcJoinChannel(boolean r100) {
        this.rtcJoinChannel = r100;
    }

    public final void setRtcPushStream(boolean r100) {
        this.rtcPushStream = r100;
    }

    public final void setSupportMultiPkTeamMode(boolean r100) {
        this.supportMultiPkTeamMode = r100;
    }

    public final void setToLinkmicIdStr(String r100) {
        this.toLinkmicIdStr = r100;
    }

    public final void setToOpenId(String r100) {
        this.toOpenId = r100;
    }

    public final void setToRtcExtInfo(String r100) {
        this.toRtcExtInfo = r100;
    }

    public final void setToUserId(long r100) {
        this.toUserId = r100;
    }

    public final void setVendor(int r100) {
        this.f162623vendor = r100;
    }
}
