package com.bytedance.android.livesdk.rank.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.ranklist.RanklistRoomResponse.Rank")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR$\u0010*\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001d¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/rank/model/a;", "", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "getUser", "()Lcom/bytedance/android/live/base/model/user/User;", "d", "(Lcom/bytedance/android/live/base/model/user/User;)V", "", "fanTicketCount", "J", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "", "rank", "I", "getRank", "()I", "c", "(I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "delta", "getDelta", "setDelta", "", "isHidden", "Z", "()Z", "b", "(Z)V", "scoreDescription", "getScoreDescription", "setScoreDescription", "exactlyScore", "getExactlyScore", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("delta")
    protected long delta;

    @SerializedName("gap_description")
    protected String description;

    @SerializedName("exactly_score")
    protected String exactlyScore;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected long fanTicketCount;

    @SerializedName("is_hidden")
    protected boolean isHidden;

    @SerializedName("rank")
    protected int rank;

    @SerializedName("score_description")
    protected String scoreDescription;

    @SerializedName("user")
    protected User user;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.rank.model.a$a, reason: collision with other inner class name */
    public static final class C2398a {
    }

    static {
    }

    public final String toString() {
        return "CurrentRankItem{user=" + this.user + ", fanTicketCount=" + this.fanTicketCount + ", rank=" + this.rank + ", description='" + this.description + "', delta=" + this.delta + ", isHidden=" + this.isHidden + ", isTopFans=false, isAnchorTop=false}";
    }

    public a() {
        new HashMap();
    }

    public a(am3.g r100) {
        new HashMap();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L6;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.exactlyScore = am3.h.c(r100);
        goto L3
    L8:
        this.scoreDescription = am3.h.c(r100);
        goto L3
    L9:
        this.isHidden = am3.h.a(r100);
        goto L3
    L10:
        this.delta = r100.j();
        goto L3
    L11:
        this.description = am3.h.c(r100);
        goto L3
    L12:
        this.rank = (int) r100.j();
        goto L3
    L13:
        this.fanTicketCount = r100.j();
        goto L3
    L14:
        this.user = new User(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void a(String r100) {
        this.exactlyScore = r100;
    }

    public final void b(boolean r100) {
        this.isHidden = r100;
    }

    public final void c(int r100) {
        this.rank = r100;
    }

    public final void d(User r100) {
        this.user = r100;
    }
}
