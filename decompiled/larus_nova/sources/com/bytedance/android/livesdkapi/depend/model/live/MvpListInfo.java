package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.BattleArmy")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MvpListInfo;", "", "()V", "anchorId", "", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "rankList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/MvpListInfo$MvpExtra;", "getRankList", "()Ljava/util/List;", "setRankList", "(Ljava/util/List;)V", "MvpExtra", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MvpListInfo implements h {

    @SerializedName("anchor_open_id")
    protected String anchorId;

    @SerializedName(PbRequest.SwitchType.RANK_LIST)
    protected List<MvpExtra> rankList;

    @ProtoMessage("webcast.data.BattleArmy.RankUser")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/MvpListInfo$MvpExtra;", "", "()V", "avatar", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAvatar", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAvatar", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", InstantPlayContext.NICKNAME, "", "getNickname", "()Ljava/lang/String;", "setNickname", "(Ljava/lang/String;)V", a.KEY_SCORE, "", "getScore", "()I", "setScore", "(I)V", "userId", "getUserId", "setUserId", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MvpExtra implements h {

        @SerializedName("avatar_thumb")
        protected ImageModel avatar;

        @SerializedName(InstantPlayContext.NICKNAME)
        protected String nickname;

        @SerializedName(a.KEY_SCORE)
        protected int score;

        @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
        protected String userId;

        public MvpExtra() {
        }

        public final ImageModel getAvatar() {
            return this.avatar;
        }

        public final String getNickname() {
            return this.nickname;
        }

        public final int getScore() {
            return this.score;
        }

        public final String getUserId() {
            return this.userId;
        }

        public MvpExtra(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 2) goto L8;
            this.nickname = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 3) goto L10;
            this.avatar = x.a(r100);
            goto L3
        L10:
            if (r102 != 4) goto L12;
            this.score = (int) r100.j();
            goto L3
        L12:
            if (r102 != 5000) goto L13;
            this.userId = am3.h.c(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }

        public final void setAvatar(ImageModel r100) {
            this.avatar = r100;
        }

        public final void setNickname(String r100) {
            this.nickname = r100;
        }

        public final void setScore(int r100) {
            this.score = r100;
        }

        public final void setUserId(String r100) {
            this.userId = r100;
        }
    }

    public MvpListInfo() {
    }

    public MvpListInfo(g r100) {
        this.rankList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 2) goto L8;
        this.rankList.add(new MvpExtra(r100));
        goto L3
    L8:
        if (r102 != 5000) goto L9;
        this.anchorId = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final List<MvpExtra> getRankList() {
        return this.rankList;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setRankList(List<MvpExtra> r100) {
        this.rankList = r100;
    }
}
