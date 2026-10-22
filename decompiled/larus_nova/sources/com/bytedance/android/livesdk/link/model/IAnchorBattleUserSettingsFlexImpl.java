package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.BattleUserSettings")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\"\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bE\u0010FR\u001b\u0010\u0006\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010!\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010 R\u001b\u0010$\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010 R\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0005\u001a\u0004\b+\u0010\u0007R\u001b\u0010/\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007R\u001b\u00102\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007R+\u00108\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u00107R+\u0010<\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0005\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u00107R+\u0010@\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u00107R+\u0010D\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\u0005\u001a\u0004\bB\u0010\u0007\"\u0004\bC\u00107¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorBattleUserSettingsFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/h;", "", "isTurnOn$delegate", "Ljava/lang/Object;", "isTurnOn", "()Z", "acceptNotFollowerInvite$delegate", "getAcceptNotFollowerInvite", "acceptNotFollowerInvite", "allowGiftToOtherAnchorsInLinkmic$delegate", "getAllowGiftToOtherAnchorsInLinkmic", "allowGiftToOtherAnchorsInLinkmic", "allowGiftToOtherAnchorsInPK$delegate", "getAllowGiftToOtherAnchorsInPK", "allowGiftToOtherAnchorsInPK", "acceptFollowedInvite$delegate", "getAcceptFollowedInvite", "acceptFollowedInvite", "acceptHourlyRankInvite$delegate", "getAcceptHourlyRankInvite", "acceptHourlyRankInvite", "allowGiftToOtherAnchors$delegate", "getAllowGiftToOtherAnchors", "allowGiftToOtherAnchors", "acceptPopularityRankInvite$delegate", "getAcceptPopularityRankInvite", "acceptPopularityRankInvite", "", "inviteRejectTemporary$delegate", "getInviteRejectTemporary", "()J", "inviteRejectTemporary", "inviteRejectPermanent$delegate", "getInviteRejectPermanent", "inviteRejectPermanent", "", "inviteRejectTemporaryText$delegate", "getInviteRejectTemporaryText", "()Ljava/lang/String;", "inviteRejectTemporaryText", "pkAutoConfirm$delegate", "getPkAutoConfirm", "pkAutoConfirm", "pkAcceptVolumeUp$delegate", "getPkAcceptVolumeUp", "pkAcceptVolumeUp", "acceptUnionRecommendInvite$delegate", "getAcceptUnionRecommendInvite", "acceptUnionRecommendInvite", "<set-?>", "autoStartPropCard$delegate", "getAutoStartPropCard", "setAutoStartPropCard", "(Z)V", "autoStartPropCard", "autoStartStealDragon$delegate", "getAutoStartStealDragon", "setAutoStartStealDragon", "autoStartStealDragon", "acceptFindPeopleInvite$delegate", "getAcceptFindPeopleInvite", "setAcceptFindPeopleInvite", "acceptFindPeopleInvite", "acceptTeamTask$delegate", "getAcceptTeamTask", "setAcceptTeamTask", "acceptTeamTask", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAnchorBattleUserSettingsFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("accept_find_people_invite")
    protected boolean _$$acceptFindPeopleInvite;

    @SerializedName("accept_friend_invite")
    protected boolean _$$acceptFollowedInvite;

    @SerializedName("accept_hourly_rank_invite")
    protected boolean _$$acceptHourlyRankInvite;

    @SerializedName("accept_not_follower_invite")
    protected boolean _$$acceptNotFollowerInvite;

    @SerializedName("accept_popularity_rank_invite")
    protected boolean _$$acceptPopularityRankInvite;

    @SerializedName("accept_team_task")
    protected boolean _$$acceptTeamTask;

    @SerializedName("accept_union_recommend_invite")
    protected boolean _$$acceptUnionRecommendInvite;

    @SerializedName("allow_gift_to_other_anchors")
    protected boolean _$$allowGiftToOtherAnchors;

    @SerializedName("linkmic_allow_gift_to_other_anchors")
    protected boolean _$$allowGiftToOtherAnchorsInLinkmic;

    @SerializedName("pk_allow_gift_to_other_anchors")
    protected boolean _$$allowGiftToOtherAnchorsInPK;

    @SerializedName("auto_start_prop_card")
    protected boolean _$$autoStartPropCard;

    @SerializedName("auto_start_steal_dragon")
    protected boolean _$$autoStartStealDragon;

    @SerializedName("invite_reject_permanent_total")
    protected long _$$inviteRejectPermanent;

    @SerializedName("invite_reject_temporary_total")
    protected long _$$inviteRejectTemporary;

    @SerializedName("invite_reject_temporary_text")
    protected String _$$inviteRejectTemporaryText;

    @SerializedName("is_turn_on")
    protected boolean _$$isTurnOn;

    @SerializedName("pk_accept_volume_up")
    protected boolean _$$pkAcceptVolumeUp;

    @SerializedName("pk_auto_confirm")
    protected boolean _$$pkAutoConfirm;

    public IAnchorBattleUserSettingsFlexImpl() {
        super(h.class);
        this._$$isTurnOn = false;
        this._$$acceptNotFollowerInvite = false;
        this._$$allowGiftToOtherAnchorsInLinkmic = false;
        this._$$allowGiftToOtherAnchorsInPK = false;
        this._$$acceptFollowedInvite = false;
        this._$$acceptHourlyRankInvite = false;
        this._$$allowGiftToOtherAnchors = false;
        this._$$acceptPopularityRankInvite = false;
        this._$$inviteRejectTemporaryText = "";
        this._$$pkAutoConfirm = false;
        this._$$pkAcceptVolumeUp = false;
        this._$$acceptUnionRecommendInvite = false;
        this._$$autoStartPropCard = false;
        this._$$autoStartStealDragon = false;
        this._$$acceptFindPeopleInvite = false;
        this._$$acceptTeamTask = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptFindPeopleInvite() {
        return this._$$acceptFindPeopleInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptFollowedInvite() {
        return this._$$acceptFollowedInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptHourlyRankInvite() {
        return this._$$acceptHourlyRankInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptNotFollowerInvite() {
        return this._$$acceptNotFollowerInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptPopularityRankInvite() {
        return this._$$acceptPopularityRankInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptTeamTask() {
        return this._$$acceptTeamTask;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAcceptUnionRecommendInvite() {
        return this._$$acceptUnionRecommendInvite;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAllowGiftToOtherAnchors() {
        return this._$$allowGiftToOtherAnchors;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAllowGiftToOtherAnchorsInLinkmic() {
        return this._$$allowGiftToOtherAnchorsInLinkmic;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAllowGiftToOtherAnchorsInPK() {
        return this._$$allowGiftToOtherAnchorsInPK;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAutoStartPropCard() {
        return this._$$autoStartPropCard;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getAutoStartStealDragon() {
        return this._$$autoStartStealDragon;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final long getInviteRejectPermanent() {
        return this._$$inviteRejectPermanent;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final long getInviteRejectTemporary() {
        return this._$$inviteRejectTemporary;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final String getInviteRejectTemporaryText() {
        return this._$$inviteRejectTemporaryText;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getPkAcceptVolumeUp() {
        return this._$$pkAcceptVolumeUp;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean getPkAutoConfirm() {
        return this._$$pkAutoConfirm;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final boolean isTurnOn() {
        return this._$$isTurnOn;
    }

    public IAnchorBattleUserSettingsFlexImpl(am3.g r100) {
        super(h.class);
        setThreadSafe(false);
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L26;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            case 13: goto L13;
            case 14: goto L12;
            case 15: goto L11;
            case 16: goto L10;
            case 17: goto L7;
            case 18: goto L9;
            case 19: goto L8;
            default: goto L7;
        };
    L8:
        this._$$acceptTeamTask = am3.h.a(r100);
        r102 = r102 | 65536;
        goto L3
    L9:
        this._$$acceptFindPeopleInvite = am3.h.a(r100);
        r102 = r102 | 32768;
        goto L3
    L10:
        this._$$autoStartStealDragon = am3.h.a(r100);
        r102 = r102 | 16384;
        goto L3
    L11:
        this._$$autoStartPropCard = am3.h.a(r100);
        r102 = r102 | 8192;
        goto L3
    L12:
        this._$$allowGiftToOtherAnchorsInPK = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L13:
        this._$$allowGiftToOtherAnchorsInLinkmic = am3.h.a(r100);
        r102 = r102 | 4;
        goto L3
    L14:
        this._$$acceptUnionRecommendInvite = am3.h.a(r100);
        r102 = r102 | 4096;
        goto L3
    L15:
        this._$$pkAutoConfirm = am3.h.a(r100);
        r102 = r102 | 1024;
        goto L3
    L16:
        this._$$pkAcceptVolumeUp = am3.h.a(r100);
        r102 = r102 | 2048;
        goto L3
    L17:
        this._$$inviteRejectTemporaryText = am3.h.c(r100);
        goto L3
    L18:
        this._$$inviteRejectTemporary = r100.j();
        r102 = r102 | 256;
        goto L3
    L19:
        this._$$inviteRejectPermanent = r100.j();
        r102 = r102 | 512;
        goto L3
    L20:
        this._$$acceptPopularityRankInvite = am3.h.a(r100);
        r102 = r102 | 128;
        goto L3
    L21:
        this._$$acceptHourlyRankInvite = am3.h.a(r100);
        r102 = r102 | 32;
        goto L3
    L22:
        this._$$acceptFollowedInvite = am3.h.a(r100);
        r102 = r102 | 16;
        goto L3
    L23:
        this._$$allowGiftToOtherAnchors = am3.h.a(r100);
        r102 = r102 | 64;
        goto L3
    L24:
        this._$$acceptNotFollowerInvite = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L25:
        this._$$isTurnOn = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L26:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & 1) != 0) goto L30;
        this._$$isTurnOn = false;
    L30:
        if ((r102 & 2) != 0) goto L33;
        this._$$acceptNotFollowerInvite = false;
    L33:
        if ((r102 & 4) != 0) goto L36;
        this._$$allowGiftToOtherAnchorsInLinkmic = false;
    L36:
        if ((r102 & 8) != 0) goto L39;
        this._$$allowGiftToOtherAnchorsInPK = false;
    L39:
        if ((r102 & 16) != 0) goto L42;
        this._$$acceptFollowedInvite = false;
    L42:
        if ((r102 & 32) != 0) goto L45;
        this._$$acceptHourlyRankInvite = false;
    L45:
        if ((r102 & 64) != 0) goto L48;
        this._$$allowGiftToOtherAnchors = false;
    L48:
        if ((r102 & 128) != 0) goto L51;
        this._$$acceptPopularityRankInvite = false;
    L51:
        if (this._$$inviteRejectTemporaryText != null) goto L54;
        this._$$inviteRejectTemporaryText = "";
    L54:
        if ((r102 & 1024) != 0) goto L57;
        this._$$pkAutoConfirm = false;
    L57:
        if ((r102 & 2048) != 0) goto L60;
        this._$$pkAcceptVolumeUp = false;
    L60:
        if ((r102 & 4096) != 0) goto L63;
        this._$$acceptUnionRecommendInvite = false;
    L63:
        if ((r102 & 8192) != 0) goto L66;
        this._$$autoStartPropCard = false;
    L66:
        if ((r102 & 16384) != 0) goto L69;
        this._$$autoStartStealDragon = false;
    L69:
        if ((r102 & 32768) != 0) goto L72;
        this._$$acceptFindPeopleInvite = false;
    L72:
        if ((r102 & 65536) != 0) goto L115;
        this._$$acceptTeamTask = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final void setAcceptFindPeopleInvite(boolean r100) {
        this._$$acceptFindPeopleInvite = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final void setAcceptTeamTask(boolean r100) {
        this._$$acceptTeamTask = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final void setAutoStartPropCard(boolean r100) {
        this._$$autoStartPropCard = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.h
    public final void setAutoStartStealDragon(boolean r100) {
        this._$$autoStartStealDragon = r100;
    }
}
