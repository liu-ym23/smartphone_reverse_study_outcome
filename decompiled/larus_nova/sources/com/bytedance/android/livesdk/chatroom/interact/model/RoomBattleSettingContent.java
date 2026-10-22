package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.live.liveinteract.multiscene.RoomBattleThemeParam;
import com.bytedance.android.livesdk.chatroom.model.interact.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/RoomBattleSettingContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/interact/model/a0;", "", "toString", "", "battleDuration", "J", "getBattleDuration", "()J", "setBattleDuration", "(J)V", "", "acceptInvite", "Z", "getAcceptInvite", "()Z", "setAcceptInvite", "(Z)V", "onlyAcceptFollowingInvite", "getOnlyAcceptFollowingInvite", "setOnlyAcceptFollowingInvite", "acceptInviteLessThanThreeUser", "getAcceptInviteLessThanThreeUser", "setAcceptInviteLessThanThreeUser", "Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "roomBattleThemeParam", "Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "getRoomBattleThemeParam", "()Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "setRoomBattleThemeParam", "(Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;)V", "introContent", "Ljava/lang/String;", "getIntroContent", "()Ljava/lang/String;", "setIntroContent", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBattleSettingContent extends FlexModelBase<a0> implements a0, vh7.h {

    @SerializedName("accept_invite")
    protected boolean acceptInvite;

    @SerializedName("not_accept_less_than_three_linked_invite")
    protected boolean acceptInviteLessThanThreeUser;

    @SerializedName("battle_duration")
    protected long battleDuration;

    @SerializedName("introduction_content")
    protected String introContent;

    @SerializedName("only_accept_following_invite")
    protected boolean onlyAcceptFollowingInvite;

    @SerializedName("room_battle_theme_param")
    protected RoomBattleThemeParam roomBattleThemeParam;

    public RoomBattleSettingContent() {
        super(a0.class);
    }

    public String toString() {
        return "RoomBattleSettingContent(battleDuration=" + getBattleDuration() + ", acceptInvite=" + getAcceptInvite() + ", onlyAcceptFollowingInvite=" + getOnlyAcceptFollowingInvite() + ", acceptInviteLessThanThreeUser=" + getAcceptInviteLessThanThreeUser() + ", roomBattleThemeParam=" + getRoomBattleThemeParam() + ')';
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public /* bridge */ /* synthetic */ m1 getRoomBattleThemeParam() {
        return getRoomBattleThemeParam();
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public boolean getAcceptInvite() {
        return this.acceptInvite;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public boolean getAcceptInviteLessThanThreeUser() {
        return this.acceptInviteLessThanThreeUser;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public long getBattleDuration() {
        return this.battleDuration;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public String getIntroContent() {
        return this.introContent;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public boolean getOnlyAcceptFollowingInvite() {
        return this.onlyAcceptFollowingInvite;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public RoomBattleThemeParam getRoomBattleThemeParam() {
        return this.roomBattleThemeParam;
    }

    public RoomBattleSettingContent(am3.g r100) {
        super(a0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.introContent = am3.h.c(r100);
        goto L3
    L9:
        this.roomBattleThemeParam = new RoomBattleThemeParam(r100);
        goto L3
    L10:
        this.acceptInviteLessThanThreeUser = am3.h.a(r100);
        goto L3
    L11:
        this.onlyAcceptFollowingInvite = am3.h.a(r100);
        goto L3
    L12:
        this.acceptInvite = am3.h.a(r100);
        goto L3
    L13:
        this.battleDuration = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public void setAcceptInvite(boolean r100) {
        this.acceptInvite = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public void setAcceptInviteLessThanThreeUser(boolean r100) {
        this.acceptInviteLessThanThreeUser = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public void setBattleDuration(long r100) {
        this.battleDuration = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public void setIntroContent(String r100) {
        this.introContent = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.interact.model.a0
    public void setOnlyAcceptFollowingInvite(boolean r100) {
        this.onlyAcceptFollowingInvite = r100;
    }

    public void setRoomBattleThemeParam(RoomBattleThemeParam r100) {
        this.roomBattleThemeParam = r100;
    }
}
