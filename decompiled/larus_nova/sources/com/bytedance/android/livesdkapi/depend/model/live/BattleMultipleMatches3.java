package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.MultipleMatches3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R,\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMultipleMatches3;", "", "()V", "currentMatch", "", "getCurrentMatch", "()J", "setCurrentMatch", "(J)V", "currentWinnerUid", "", "getCurrentWinnerUid", "()Ljava/lang/String;", "setCurrentWinnerUid", "(Ljava/lang/String;)V", "end", "", "getEnd", "()Z", "setEnd", "(Z)V", "userInfoMap", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleMultipleMatchesUserInfo;", "getUserInfoMap", "()Ljava/util/Map;", "setUserInfoMap", "(Ljava/util/Map;)V", "winnerUid", "getWinnerUid", "setWinnerUid", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleMultipleMatches3 implements h {

    @SerializedName("current_match")
    protected long currentMatch;

    @SerializedName("current_winner_open_id")
    protected String currentWinnerUid;

    @SerializedName("end")
    protected boolean end;

    @SerializedName("user_infos")
    protected Map<Long, BattleMultipleMatchesUserInfo> userInfoMap;

    @SerializedName("winner_open_id")
    protected String winnerUid;

    public BattleMultipleMatches3() {
    }

    public final long getCurrentMatch() {
        return this.currentMatch;
    }

    public final String getCurrentWinnerUid() {
        return this.currentWinnerUid;
    }

    public final boolean getEnd() {
        return this.end;
    }

    public final Map<Long, BattleMultipleMatchesUserInfo> getUserInfoMap() {
        return this.userInfoMap;
    }

    public final String getWinnerUid() {
        return this.winnerUid;
    }

    public BattleMultipleMatches3(g r110) {
        this.userInfoMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L35;
        if (r101 != 1) goto L7;
        long r102 = r110.c();
        Long r103 = null;
        BattleMultipleMatchesUserInfo r104 = null;
    L20:
        int r105 = r110.f();
        if (r105 == (-1)) goto L27;
        if (r105 != 1) goto L23;
        r103 = Long.valueOf(r110.j());
        goto L20
    L23:
        if (r105 != 2) goto L24;
        r104 = new BattleMultipleMatchesUserInfo(r110);
        goto L20
    L24:
        am3.h.e(r110);
        goto L20
    L27:
        r110.d(r102);
        Map<Long, BattleMultipleMatchesUserInfo> r106 = this.userInfoMap;
        if (r103 == null) goto L34;
        if (r104 == null) goto L32;
        r106.put(r103, r104);
        goto L3
    L32:
        throw new IllegalStateException("Value must not be null");
    L34:
        throw new IllegalStateException("Key must not be null");
    L7:
        if (r101 != 2) goto L9;
        this.currentMatch = r110.j();
        goto L3
    L9:
        if (r101 != 3) goto L11;
        this.end = am3.h.a(r110);
        goto L3
    L11:
        if (r101 != 5001) goto L13;
        this.winnerUid = am3.h.c(r110);
        goto L3
    L13:
        if (r101 != 5002) goto L14;
        this.currentWinnerUid = am3.h.c(r110);
        goto L3
    L14:
        am3.h.e(r110);
        goto L3
    L35:
        r110.d(r100);
    }

    public final void setCurrentMatch(long r100) {
        this.currentMatch = r100;
    }

    public final void setCurrentWinnerUid(String r100) {
        this.currentWinnerUid = r100;
    }

    public final void setEnd(boolean r100) {
        this.end = r100;
    }

    public final void setUserInfoMap(Map<Long, BattleMultipleMatchesUserInfo> r100) {
        this.userInfoMap = r100;
    }

    public final void setWinnerUid(String r100) {
        this.winnerUid = r100;
    }
}
