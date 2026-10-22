package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.InviteResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b-\u0010.R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\bR\u0018\u0010'\u001a\u00060\u0004j\u0002`%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u0018\u0010*\u001a\u00060\u0004j\u0002`(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0012R\u0014\u0010,\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010 ¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/LinkInviteResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/m0;", "", "", "cannotPkAnchorIds", "Ljava/util/List;", "getCannotPkAnchorIds", "()Ljava/util/List;", "setCannotPkAnchorIds", "(Ljava/util/List;)V", "", "cannotPkAnchorOpenIds", "getCannotPkAnchorOpenIds", "setCannotPkAnchorOpenIds", "mChannelId", "J", "getMChannelId", "()J", "setMChannelId", "(J)V", "", NativeDownloadModel.JsonKey.SCENE, "I", "getMScene", "()I", "setMScene", "(I)V", "", "mInviteeWithAudience", "Z", "getMInviteeWithAudience", "()Z", "setMInviteeWithAudience", "(Z)V", "get_cannotPkAnchorIds", "_cannotPkAnchorIds", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", RemoteMessageConst.Notification.CHANNEL_ID, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getScene", "scene", "getInviteeWithAudience", "inviteeWithAudience", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkInviteResult extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.m0> implements com.bytedance.android.livesdk.link.model.bridge.m0, vh7.h {

    @SerializedName("can_not_pass_anchor_ids")
    protected List<Long> cannotPkAnchorIds;

    @SerializedName("can_not_pass_anchor_open_ids")
    protected List<String> cannotPkAnchorOpenIds;

    @SerializedName("channel_id")
    protected long mChannelId;

    @SerializedName("invitee_with_audience")
    protected boolean mInviteeWithAudience;

    @SerializedName("scene")
    protected int mScene;

    public LinkInviteResult() {
        super(com.bytedance.android.livesdk.link.model.bridge.m0.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m0
    public long getScene() {
        return this.mScene;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m0
    public List<String> get_cannotPkAnchorIds() {
        com.bytedance.android.live.base.model.user.o0.a r100 = com.bytedance.android.live.base.model.user.o0.f58946a;
        List<String> r101 = this.cannotPkAnchorOpenIds;
        r100.getClass();
        return com.bytedance.android.live.base.model.user.o0.a.h(r101);
    }

    public final List<Long> getCannotPkAnchorIds() {
        return this.cannotPkAnchorIds;
    }

    public final List<String> getCannotPkAnchorOpenIds() {
        return this.cannotPkAnchorOpenIds;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m0
    public long getChannelId() {
        return this.mChannelId;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m0
    public boolean getInviteeWithAudience() {
        return this.mInviteeWithAudience;
    }

    public final long getMChannelId() {
        return this.mChannelId;
    }

    public final boolean getMInviteeWithAudience() {
        return this.mInviteeWithAudience;
    }

    public final int getMScene() {
        return this.mScene;
    }

    public LinkInviteResult(am3.g r100) {
        super(com.bytedance.android.livesdk.link.model.bridge.m0.class);
        this.cannotPkAnchorIds = new ArrayList();
        this.cannotPkAnchorOpenIds = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.mChannelId = r100.j();
        goto L3
    L8:
        if (r102 != 4) goto L10;
        this.mScene = (int) r100.j();
        goto L3
    L10:
        if (r102 != 18) goto L12;
        this.mInviteeWithAudience = am3.h.a(r100);
        goto L3
    L12:
        if (r102 == 20) goto L17;
        if (r102 != 5000) goto L15;
        List r104 = this.cannotPkAnchorOpenIds;
        Comparable r105 = am3.h.c(r100);
    L18:
        r104.add(r105);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r104 = this.cannotPkAnchorIds;
        r105 = Long.valueOf(r100.j());
        goto L18
    L22:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setCannotPkAnchorIds(List<Long> r100) {
        this.cannotPkAnchorIds = r100;
    }

    public final void setCannotPkAnchorOpenIds(List<String> r100) {
        this.cannotPkAnchorOpenIds = r100;
    }

    public final void setMChannelId(long r100) {
        this.mChannelId = r100;
    }

    public final void setMInviteeWithAudience(boolean r100) {
        this.mInviteeWithAudience = r100;
    }

    public final void setMScene(int r100) {
        this.mScene = r100;
    }
}
