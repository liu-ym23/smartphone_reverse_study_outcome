package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u0004\u001a\u000e\u0012\b\u0012\u00060\u0003R\u00020\u0000\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/f;", "", "", "Lcom/bytedance/android/live/broadcastgame/opengame/network/f$a;", "rankList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setRankList", "(Ljava/util/List;)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName(PbRequest.SwitchType.RANK_LIST)
    private List<a> rankList;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/network/f$a;", "", "", "userId", "J", "getUserId", "()J", "setUserId", "(J)V", "", "nickName", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "avatarUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAvatarUrl", "diamonds", "b", "setDiamonds", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class a {

        @SerializedName("avatar_url")
        private String avatarUrl;

        @SerializedName("diamonds")
        private long diamonds;

        @SerializedName("nick_name")
        private String nickName;

        @SerializedName("user_id")
        private long userId;

        public final String a() {
            return this.avatarUrl;
        }

        public final long b() {
            return this.diamonds;
        }

        public final String c() {
            return this.nickName;
        }
    }

    public f() {
    }

    public final List<a> a() {
        return this.rankList;
    }
}
