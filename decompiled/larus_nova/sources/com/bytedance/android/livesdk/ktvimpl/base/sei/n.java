package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/n;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "hot", "J", "c", "()J", "rank", "d", "", "rankType", "I", "e", "()I", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", RXScreenCaptureService.KEY_INDEX, "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "songId", "f", "", "songTitle", "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", "contributorCount", "b", DyPayConstant.KEY_START_TIME, "h", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    @SerializedName("contributor_count")
    private final long contributorCount;

    @SerializedName("hot")
    private final long hot;

    @SerializedName("rank")
    private final long rank;

    @SerializedName("rank_type")
    private final int rankType;

    @SerializedName("song_id")
    private final long songId;

    @SerializedName("song_title")
    private final String songTitle;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final long startTime;

    @SerializedName("user")
    private final IBaseUser user;

    public static final class a {
    }

    static {
    }

    public n() {
        this(0, 0, 0, null, 0, "", 0, 0);
    }

    public final long b() {
        return this.contributorCount;
    }

    public final long c() {
        return this.hot;
    }

    public final long d() {
        return this.rank;
    }

    public final int e() {
        return this.rankType;
    }

    public final long f() {
        return this.songId;
    }

    public final String g() {
        return this.songTitle;
    }

    public final long h() {
        return this.startTime;
    }

    public final IBaseUser i() {
        return this.user;
    }

    public n(long r100, long r101, int r102, IBaseUser r103, long r104, String r105, long r110, long r111) {
        this.hot = r100;
        this.rank = r101;
        this.rankType = r102;
        this.user = r103;
        this.songId = r104;
        this.songTitle = r105;
        this.contributorCount = r110;
        this.startTime = r111;
    }
}
