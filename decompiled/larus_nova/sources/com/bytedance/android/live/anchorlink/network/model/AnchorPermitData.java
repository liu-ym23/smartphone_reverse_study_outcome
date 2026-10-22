package com.bytedance.android.live.anchorlink.network.model;

import am3.g;
import com.bytedance.android.livesdk.link.model.bridge.m;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.linkmic.PermitResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\"\u0010(\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\"\u0010+\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017¨\u00060"}, d2 = {"Lcom/bytedance/android/live/anchorlink/network/model/AnchorPermitData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/m;", "", "accessKey", "Ljava/lang/String;", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "", "canJoinChannelDirectly", "Z", "getCanJoinChannelDirectly", "()Z", "setCanJoinChannelDirectly", "(Z)V", "", "confluenceType", "I", "getConfluenceType", "()I", "setConfluenceType", "(I)V", "rtcAppId", "getRtcAppId", "setRtcAppId", "", "fromUid", "J", "getFromUid", "()J", "setFromUid", "(J)V", "toUid", "getToUid", "setToUid", "fromRoomId", "getFromRoomId", "setFromRoomId", "toRoomId", "getToRoomId", "setToRoomId", "linkMicType", "getLinkMicType", "setLinkMicType", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPermitData extends FlexModelBase<m> implements m, h {

    @SerializedName("access_key")
    protected String accessKey;

    @SerializedName("joinable")
    protected boolean canJoinChannelDirectly;

    @SerializedName("confluence_type")
    protected int confluenceType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long fromRoomId;

    @SerializedName("from_uid")
    protected long fromUid;

    @SerializedName("link_mic_type")
    protected int linkMicType;

    @SerializedName("rtc_app_id")
    protected String rtcAppId;

    @SerializedName("to_room_id")
    protected long toRoomId;

    @SerializedName("to_uid")
    protected long toUid;

    public AnchorPermitData() {
        super(m.class);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final boolean getCanJoinChannelDirectly() {
        return this.canJoinChannelDirectly;
    }

    public final int getConfluenceType() {
        return this.confluenceType;
    }

    public final long getFromRoomId() {
        return this.fromRoomId;
    }

    public final long getFromUid() {
        return this.fromUid;
    }

    public final int getLinkMicType() {
        return this.linkMicType;
    }

    public final String getRtcAppId() {
        return this.rtcAppId;
    }

    public final long getToRoomId() {
        return this.toRoomId;
    }

    public final long getToUid() {
        return this.toUid;
    }

    public AnchorPermitData(g r100) {
        super(m.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.accessKey = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 6) goto L10;
        this.rtcAppId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.canJoinChannelDirectly = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.confluenceType = r100.i();
        goto L3
    L13:
        switch(r102) {
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            default: goto L14;
        };
    L15:
        this.linkMicType = r100.i();
        goto L3
    L16:
        this.toRoomId = r100.j();
        goto L3
    L17:
        this.fromRoomId = r100.j();
        goto L3
    L18:
        this.toUid = r100.j();
        goto L3
    L19:
        this.fromUid = r100.j();
        goto L3
    L14:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setAccessKey(String r100) {
        this.accessKey = r100;
    }

    public final void setCanJoinChannelDirectly(boolean r100) {
        this.canJoinChannelDirectly = r100;
    }

    public final void setConfluenceType(int r100) {
        this.confluenceType = r100;
    }

    public final void setFromRoomId(long r100) {
        this.fromRoomId = r100;
    }

    public final void setFromUid(long r100) {
        this.fromUid = r100;
    }

    public final void setLinkMicType(int r100) {
        this.linkMicType = r100;
    }

    public final void setRtcAppId(String r100) {
        this.rtcAppId = r100;
    }

    public final void setToRoomId(long r100) {
        this.toRoomId = r100;
    }

    public final void setToUid(long r100) {
        this.toUid = r100;
    }
}
