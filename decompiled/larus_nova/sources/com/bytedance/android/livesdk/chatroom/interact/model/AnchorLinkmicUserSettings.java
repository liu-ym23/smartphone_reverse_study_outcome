package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.AnchorLinkmicUserSettings")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/AnchorLinkmicUserSettings;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/interact/model/s;", "", "isTurnOn", "Z", "acceptMultiAnchorLink", "getAcceptMultiAnchorLink", "()Z", "setAcceptMultiAnchorLink", "(Z)V", "acceptNotFollowerInvite", "getAcceptNotFollowerInvite", "setAcceptNotFollowerInvite", "allowGiftToOtherAnchors", "getAllowGiftToOtherAnchors", "setAllowGiftToOtherAnchors", "isIsTurnOn", "isAcceptMultiAnchorLink", "isAcceptNotFollowerInvite", "isAllowGiftToOtherAnchors", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorLinkmicUserSettings extends FlexModelBase<s> implements s, vh7.h {

    @SerializedName("accept_multi_linkmic")
    protected boolean acceptMultiAnchorLink;

    @SerializedName("accept_not_follower_invite")
    protected boolean acceptNotFollowerInvite;

    @SerializedName("allow_gift_to_other_anchors")
    protected boolean allowGiftToOtherAnchors;

    @SerializedName("is_turn_on")
    public boolean isTurnOn;

    public AnchorLinkmicUserSettings() {
        super(s.class);
    }

    public AnchorLinkmicUserSettings(am3.g r100) {
        super(s.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isTurnOn = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.acceptMultiAnchorLink = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.acceptNotFollowerInvite = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.allowGiftToOtherAnchors = am3.h.a(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final boolean getAcceptMultiAnchorLink() {
        return this.acceptMultiAnchorLink;
    }

    public final boolean getAcceptNotFollowerInvite() {
        return this.acceptNotFollowerInvite;
    }

    public final boolean getAllowGiftToOtherAnchors() {
        return this.allowGiftToOtherAnchors;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.s
    public boolean isAcceptMultiAnchorLink() {
        return this.acceptMultiAnchorLink;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.s
    public boolean isAcceptNotFollowerInvite() {
        return this.acceptNotFollowerInvite;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.s
    public boolean isAllowGiftToOtherAnchors() {
        return this.allowGiftToOtherAnchors;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.s
    public boolean isIsTurnOn() {
        return this.isTurnOn;
    }

    public final void setAcceptMultiAnchorLink(boolean r100) {
        this.acceptMultiAnchorLink = r100;
    }

    public final void setAcceptNotFollowerInvite(boolean r100) {
        this.acceptNotFollowerInvite = r100;
    }

    public final void setAllowGiftToOtherAnchors(boolean r100) {
        this.allowGiftToOtherAnchors = r100;
    }
}
