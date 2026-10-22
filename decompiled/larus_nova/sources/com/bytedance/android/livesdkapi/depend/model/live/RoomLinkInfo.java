package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LinkMic")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomLinkInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomLinkInfoBase;", "()V", "battleSetting", "Lcom/bytedance/android/livesdkapi/depend/model/live/LinkMicBattleSetting;", RemoteMessageConst.Notification.CHANNEL_ID, "", "guestId", "linkmicAnchorCount", "rivalAnchorOpenId", "", "toString", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomLinkInfo extends FlexModelBase<IRoomLinkInfoBase> implements IRoomLinkInfoBase, h {

    @SerializedName("battle_settings")
    public LinkMicBattleSetting battleSetting;

    @SerializedName("channel_id")
    public long channelId;

    @SerializedName("rival_anchor_id")
    public long guestId;

    @SerializedName("linkmic_anchor_count")
    public long linkmicAnchorCount;

    @SerializedName("rival_anchor_open_id")
    public String rivalAnchorOpenId;

    public RoomLinkInfo() {
        super(IRoomLinkInfoBase.class);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("RoomLinkInfo{channelId=");
        r100.append(this.channelId);
        r100.append(", battleSetting=");
        r100.append(this.battleSetting);
        r100.append(", guestId=");
        o0.a r101 = o0.f58946a;
        Long r102 = Long.valueOf(this.guestId);
        String r103 = this.rivalAnchorOpenId;
        r101.getClass();
        r100.append(o0.a.g(r102, r103));
        r100.append('}');
        return r100.toString();
    }

    public RoomLinkInfo(g r100) {
        super(IRoomLinkInfoBase.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.channelId = r100.j();
        goto L3
    L8:
        if (r102 != 5000) goto L10;
        this.rivalAnchorOpenId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.battleSetting = new LinkMicBattleSetting(r100);
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this.guestId = r100.j();
        goto L3
    L14:
        if (r102 != 6) goto L15;
        this.linkmicAnchorCount = r100.j();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }
}
