package com.bytedance.android.gamecp.common.model.live;

import am3.g;
import com.bytedance.android.gamecp.host_api.model.ImageModelLive;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.api.feed.RankRoundBanner.Item.Rank")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/live/c;", "", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "avatar", "Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "getAvatar", "()Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;", "setAvatar", "(Lcom/bytedance/android/gamecp/host_api/model/ImageModelLive;)V", "", "rank", "I", "getRank", "()I", "setRank", "(I)V", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScore", "setScore", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("user_avatar")
    protected ImageModelLive avatar;

    @SerializedName("rank")
    protected int rank;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected int score;

    @SerializedName("user_id")
    protected long userId;

    public c() {
    }

    public c(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.avatar = new ImageModelLive(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.score = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.userId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.rank = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
