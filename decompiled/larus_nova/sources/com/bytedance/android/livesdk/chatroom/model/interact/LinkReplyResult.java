package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.ReplyResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bW\u0010XR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R0\u00104\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u000203\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0016\u001a\u0004\b;\u0010\u0018\"\u0004\b<\u0010\u001aR$\u0010=\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018\"\u0004\b?\u0010\u001aR\"\u0010@\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R$\u0010C\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0016\u001a\u0004\bD\u0010\u0018\"\u0004\bE\u0010\u001aR\u0016\u0010G\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0018R\u0018\u0010K\u001a\u00060!j\u0002`H8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0016\u0010M\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0018R\u0016\u0010Q\u001a\u0004\u0018\u00010N8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR<\u0010V\u001a*\u0012\b\u0012\u00060!j\u0002`R\u0012\u0004\u0012\u00020S\u0018\u000102j\u0014\u0012\b\u0012\u00060!j\u0002`R\u0012\u0004\u0012\u00020S\u0018\u0001`T8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u00107¨\u0006Y"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkReplyResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "", "mLinkMicId", "I", "getMLinkMicId", "()I", "setMLinkMicId", "(I)V", "", "canJoinChannelDirectly", "Z", "getCanJoinChannelDirectly", "()Z", "setCanJoinChannelDirectly", "(Z)V", "confluenceType", "getConfluenceType", "setConfluenceType", "", "rtcAppId", "Ljava/lang/String;", "getRtcAppId", "()Ljava/lang/String;", "setRtcAppId", "(Ljava/lang/String;)V", "mRtcExtInfo", "getMRtcExtInfo", "setMRtcExtInfo", "mLinkMicIdStr", "getMLinkMicIdStr", "setMLinkMicIdStr", "", "rivalLinkmicId", "J", "getRivalLinkmicId", "()J", "setRivalLinkmicId", "(J)V", "rivalLinkmicIdStr", "getRivalLinkmicIdStr", "setRivalLinkmicIdStr", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "mMultiChannelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "getMMultiChannelInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;", "setMMultiChannelInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/MultiChannelInfo;)V", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "mLinkerContentMap", "Ljava/util/Map;", "getMLinkerContentMap", "()Ljava/util/Map;", "setMLinkerContentMap", "(Ljava/util/Map;)V", "kickedUsersniqueId", "getKickedUsersniqueId", "setKickedUsersniqueId", "accessKey", "getAccessKey", "setAccessKey", "bizJoinChannel", "getBizJoinChannel", "setBizJoinChannel", "inviteUid", "getInviteUid", "setInviteUid", "getLinkMicIdStr", "linkMicIdStr", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLinkMicId", "()Ljava/lang/Long;", "linkMicId", "getRtcExtInfo", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "multiChannelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/LinkerId;", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "linkerContentMap", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkReplyResult extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.d1> implements com.bytedance.android.livesdk.link.model.bridge.d1, vh7.h {

    @SerializedName("access_key")
    protected String accessKey;

    @SerializedName("biz_join_channel")
    protected boolean bizJoinChannel;

    @SerializedName("joinable")
    protected boolean canJoinChannelDirectly;

    @SerializedName("confluence_type")
    protected int confluenceType;
    private String inviteUid;

    @SerializedName("kicked_users_unique_id")
    protected String kickedUsersniqueId;

    @SerializedName("link_mic_id")
    protected int mLinkMicId;

    @SerializedName("linkmic_id_str")
    protected String mLinkMicIdStr;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends RoomLinkerContent> mLinkerContentMap;

    @SerializedName("multi_channel_info")
    protected MultiChannelInfo mMultiChannelInfo;

    @SerializedName("rtc_ext_info")
    protected String mRtcExtInfo;

    @SerializedName("rival_linkmic_id")
    protected long rivalLinkmicId;

    @SerializedName("rival_linkmic_id_str")
    protected String rivalLinkmicIdStr;

    @SerializedName("rtc_app_id")
    protected String rtcAppId;

    public LinkReplyResult() {
        super(com.bytedance.android.livesdk.link.model.bridge.d1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1
    public Long getLinkMicId() {
        return Long.valueOf(this.mLinkMicId);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean getBizJoinChannel() {
        return this.bizJoinChannel;
    }

    public final boolean getCanJoinChannelDirectly() {
        return this.canJoinChannelDirectly;
    }

    public final int getConfluenceType() {
        return this.confluenceType;
    }

    public final String getInviteUid() {
        return this.inviteUid;
    }

    public final String getKickedUsersniqueId() {
        return this.kickedUsersniqueId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1
    public String getLinkMicIdStr() {
        return this.mLinkMicIdStr;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1
    public Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap() {
        return this.mLinkerContentMap;
    }

    public final int getMLinkMicId() {
        return this.mLinkMicId;
    }

    public final String getMLinkMicIdStr() {
        return this.mLinkMicIdStr;
    }

    public final Map<Long, RoomLinkerContent> getMLinkerContentMap() {
        return this.mLinkerContentMap;
    }

    public final MultiChannelInfo getMMultiChannelInfo() {
        return this.mMultiChannelInfo;
    }

    public final String getMRtcExtInfo() {
        return this.mRtcExtInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1
    public com.bytedance.android.livesdk.link.model.bridge.s1 getMultiChannelInfo() {
        return this.mMultiChannelInfo;
    }

    public final long getRivalLinkmicId() {
        return this.rivalLinkmicId;
    }

    public final String getRivalLinkmicIdStr() {
        return this.rivalLinkmicIdStr;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1
    public String getRtcExtInfo() {
        return this.mRtcExtInfo;
    }

    public LinkReplyResult(am3.g r110) {
        super(com.bytedance.android.livesdk.link.model.bridge.d1.class);
        this.mLinkerContentMap = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L43;
        am3.g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 20) goto L8;
        this.mMultiChannelInfo = new MultiChannelInfo(r110);
        goto L3
    L8:
        if (r101 != 21) goto L10;
        long r103 = r110.c();
        Long r104 = null;
        RoomLinkerContent r105 = null;
    L26:
        int r106 = r110.f();
        if (r106 == (-1)) goto L34;
        if (r106 != 1) goto L30;
        r104 = Long.valueOf(r110.j());
        goto L26
    L30:
        if (r106 != 2) goto L31;
        r105 = com.bytedance.android.live.liveinteract.plantform.model.p1.a(r110);
        goto L26
    L31:
        am3.h.e(r110);
        goto L26
    L34:
        r110.d(r103);
        Map<Long, ? extends RoomLinkerContent> r107 = this.mLinkerContentMap;
        if (r104 == null) goto L41;
        if (r105 == null) goto L39;
        r107.put(r104, r105);
        goto L3
    L39:
        throw new IllegalStateException("Value must not be null");
    L41:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r101 != 23) goto L11;
        this.kickedUsersniqueId = am3.h.c(r110);
        goto L3
    L11:
        switch(r101) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L12;
        };
    L18:
        this.rtcAppId = am3.h.c(r110);
        goto L3
    L19:
        this.mRtcExtInfo = am3.h.c(r110);
        goto L3
    L20:
        this.confluenceType = r110.i();
        goto L3
    L21:
        this.canJoinChannelDirectly = am3.h.a(r110);
        goto L3
    L22:
        this.mLinkMicId = (int) r110.j();
        goto L3
    L23:
        this.accessKey = am3.h.c(r110);
        goto L3
    L12:
        switch(r101) {
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            default: goto L13;
        };
    L14:
        this.bizJoinChannel = am3.h.a(r110);
        goto L3
    L15:
        this.rivalLinkmicIdStr = am3.h.c(r110);
        goto L3
    L16:
        this.rivalLinkmicId = r110.j();
        goto L3
    L17:
        this.mLinkMicIdStr = am3.h.c(r110);
        goto L3
    L13:
        am3.h.d(r102, r110);
        goto L3
    L43:
        r110.d(r100);
        setThreadSafe(true);
    }

    public final void setAccessKey(String r100) {
        this.accessKey = r100;
    }

    public final void setBizJoinChannel(boolean r100) {
        this.bizJoinChannel = r100;
    }

    public final void setCanJoinChannelDirectly(boolean r100) {
        this.canJoinChannelDirectly = r100;
    }

    public final void setConfluenceType(int r100) {
        this.confluenceType = r100;
    }

    public final void setInviteUid(String r100) {
        this.inviteUid = r100;
    }

    public final void setKickedUsersniqueId(String r100) {
        this.kickedUsersniqueId = r100;
    }

    public final void setMLinkMicId(int r100) {
        this.mLinkMicId = r100;
    }

    public final void setMLinkMicIdStr(String r100) {
        this.mLinkMicIdStr = r100;
    }

    public final void setMLinkerContentMap(Map<Long, ? extends RoomLinkerContent> r100) {
        this.mLinkerContentMap = r100;
    }

    public final void setMMultiChannelInfo(MultiChannelInfo r100) {
        this.mMultiChannelInfo = r100;
    }

    public final void setMRtcExtInfo(String r100) {
        this.mRtcExtInfo = r100;
    }

    public final void setRivalLinkmicId(long r100) {
        this.rivalLinkmicId = r100;
    }

    public final void setRivalLinkmicIdStr(String r100) {
        this.rivalLinkmicIdStr = r100;
    }

    public final void setRtcAppId(String r100) {
        this.rtcAppId = r100;
    }
}
