package com.bytedance.android.live.network.response;

import com.bytedance.android.livesdk.chatroom.model.interact.a0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/network/response/PlayModeInfo;", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;", "battleInfo", "Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;", "getBattleInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;", "setBattleInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/a0;)V", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "teamFightInfo", "Lcom/bytedance/android/live/liveinteract/multiscene/a;", "getTeamFightInfo", "()Lcom/bytedance/android/live/liveinteract/multiscene/a;", "setTeamFightInfo", "(Lcom/bytedance/android/live/liveinteract/multiscene/a;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayModeInfo implements h {

    @SerializedName("guest_battle_info")
    protected a0 battleInfo;

    @SerializedName("teamfight_info")
    protected com.bytedance.android.live.liveinteract.multiscene.a teamFightInfo;

    public PlayModeInfo() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.liveinteract.multiscene.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.chatroom.model.interact.a0, java.lang.Object] */
    public PlayModeInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.battleInfo = vh7.f.a(r100, a0.class);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.teamFightInfo = vh7.f.a(r100, com.bytedance.android.live.liveinteract.multiscene.a.class);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final a0 getBattleInfo() {
        return this.battleInfo;
    }

    public final com.bytedance.android.live.liveinteract.multiscene.a getTeamFightInfo() {
        return this.teamFightInfo;
    }

    public final void setBattleInfo(a0 r100) {
        this.battleInfo = r100;
    }

    public final void setTeamFightInfo(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        this.teamFightInfo = r100;
    }
}
