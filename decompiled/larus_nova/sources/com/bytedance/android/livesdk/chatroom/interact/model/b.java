package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.BattleUserSettings")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/b;", "", "", "isTurnOn", "Z", "()Z", "setTurnOn", "(Z)V", "acceptNotFollowerInvite", "getAcceptNotFollowerInvite", "setAcceptNotFollowerInvite", "acceptFollowedInvite", "getAcceptFollowedInvite", "setAcceptFollowedInvite", "acceptHourlyRankInvite", "getAcceptHourlyRankInvite", "setAcceptHourlyRankInvite", "allowGiftToOtherAnchors", "getAllowGiftToOtherAnchors", "setAllowGiftToOtherAnchors", "acceptPopularityRankInvite", "getAcceptPopularityRankInvite", "setAcceptPopularityRankInvite", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("accept_friend_invite")
    protected boolean acceptFollowedInvite;

    @SerializedName("accept_hourly_rank_invite")
    protected boolean acceptHourlyRankInvite;

    @SerializedName("accept_not_follower_invite")
    protected boolean acceptNotFollowerInvite;

    @SerializedName("accept_popularity_rank_invite")
    protected boolean acceptPopularityRankInvite;

    @SerializedName("allow_gift_to_other_anchors")
    protected boolean allowGiftToOtherAnchors;

    @SerializedName("is_turn_on")
    protected boolean isTurnOn;

    public b() {
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.acceptPopularityRankInvite = am3.h.a(r100);
        goto L3
    L8:
        this.acceptHourlyRankInvite = am3.h.a(r100);
        goto L3
    L9:
        this.acceptFollowedInvite = am3.h.a(r100);
        goto L3
    L10:
        this.allowGiftToOtherAnchors = am3.h.a(r100);
        goto L3
    L11:
        this.acceptNotFollowerInvite = am3.h.a(r100);
        goto L3
    L12:
        this.isTurnOn = am3.h.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
