package com.uxsense.base.metadata;

import A9.d;
import B9.C0177d;
import B9.L;
import B9.d0;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0002:9BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000b\u0010\fB[\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003¢\u0006\u0004\b$\u0010#J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010!J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003¢\u0006\u0004\b&\u0010#JT\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u0010!R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00104\u001a\u0004\b5\u0010#R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u00104\u001a\u0004\b6\u0010#R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b7\u0010!R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\n\u00104\u001a\u0004\b8\u0010#¨\u0006;"}, d2 = {"Lcom/uxsense/base/metadata/UserStats;", "", "", "followersCount", "", "Lcom/uxsense/base/metadata/FollowersBucket;", "followersBucket", "followersPageIds", "followingCount", "Lcom/uxsense/base/metadata/FollowingUser;", "followings", AppAgent.CONSTRUCT, "(JLjava/util/List;Ljava/util/List;JLjava/util/List;)V", "", "seen0", "LB9/d0;", "serializationConstructorMarker", "(IJLjava/util/List;Ljava/util/List;JLjava/util/List;LB9/d0;)V", "self", "LA9/d;", "output", "Lz9/g;", "serialDesc", "LC7/r;", "write$Self$uxsense_release", "(Lcom/uxsense/base/metadata/UserStats;LA9/d;Lz9/g;)V", "write$Self", "hours", "followersGainedInLastHours", "(I)J", "followersLostInLastHours", "followersNetGainInLastHours", "component1", "()J", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "copy", "(JLjava/util/List;Ljava/util/List;JLjava/util/List;)Lcom/uxsense/base/metadata/UserStats;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getFollowersCount", "Ljava/util/List;", "getFollowersBucket", "getFollowersPageIds", "getFollowingCount", "getFollowings", "Companion", "$serializer", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserStats {
    private static final f[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<FollowersBucket> followersBucket;
    private final long followersCount;
    private final List<Long> followersPageIds;
    private final long followingCount;
    private final List<FollowingUser> followings;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/uxsense/base/metadata/UserStats$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lx9/b;", "Lcom/uxsense/base/metadata/UserStats;", "serializer", "()Lx9/b;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final b serializer() {
            return UserStats$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        $childSerializers = new f[]{null, kotlin.a.b(lazyThreadSafetyMode, new a(8)), kotlin.a.b(lazyThreadSafetyMode, new a(9)), null, kotlin.a.b(lazyThreadSafetyMode, new a(10))};
    }

    public UserStats() {
        this(0L, (List) null, (List) null, 0L, (List) null, 31, (e) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_() {
        return new C0177d(FollowersBucket$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$4() {
        return new C0177d(L.f223a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ b _childSerializers$_anonymous_$5() {
        return new C0177d(FollowingUser$$serializer.INSTANCE);
    }

    public static /* synthetic */ UserStats copy$default(UserStats userStats, long j5, List list, List list2, long j6, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = userStats.followersCount;
        }
        long j10 = j5;
        if ((i & 2) != 0) {
            list = userStats.followersBucket;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            list2 = userStats.followersPageIds;
        }
        List list5 = list2;
        if ((i & 8) != 0) {
            j6 = userStats.followingCount;
        }
        long j11 = j6;
        if ((i & 16) != 0) {
            list3 = userStats.followings;
        }
        return userStats.copy(j10, list4, list5, j11, list3);
    }

    public static final void write$Self$uxsense_release(UserStats self, d output, g serialDesc) {
        f[] fVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.followersCount != 0) {
            output.encodeLongElement(serialDesc, 0, self.followersCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !k.b(self.followersBucket, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 1, (x9.f) fVarArr[1].getF4884a(), self.followersBucket);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !k.b(self.followersPageIds, EmptyList.f4893a)) {
            output.encodeSerializableElement(serialDesc, 2, (x9.f) fVarArr[2].getF4884a(), self.followersPageIds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.followingCount != 0) {
            output.encodeLongElement(serialDesc, 3, self.followingCount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && k.b(self.followings, EmptyList.f4893a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 4, (x9.f) fVarArr[4].getF4884a(), self.followings);
    }

    /* renamed from: component1, reason: from getter */
    public final long getFollowersCount() {
        return this.followersCount;
    }

    public final List<FollowersBucket> component2() {
        return this.followersBucket;
    }

    public final List<Long> component3() {
        return this.followersPageIds;
    }

    /* renamed from: component4, reason: from getter */
    public final long getFollowingCount() {
        return this.followingCount;
    }

    public final List<FollowingUser> component5() {
        return this.followings;
    }

    public final UserStats copy(long followersCount, List<FollowersBucket> followersBucket, List<Long> followersPageIds, long followingCount, List<FollowingUser> followings) {
        k.f(followersBucket, "followersBucket");
        k.f(followersPageIds, "followersPageIds");
        k.f(followings, "followings");
        return new UserStats(followersCount, followersBucket, followersPageIds, followingCount, followings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserStats)) {
            return false;
        }
        UserStats userStats = (UserStats) other;
        return this.followersCount == userStats.followersCount && k.b(this.followersBucket, userStats.followersBucket) && k.b(this.followersPageIds, userStats.followersPageIds) && this.followingCount == userStats.followingCount && k.b(this.followings, userStats.followings);
    }

    public final long followersGainedInLastHours(int hours) {
        long gainedCount = 0;
        if (!this.followersBucket.isEmpty() && hours > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - (hours * 3600000);
            List<FollowersBucket> list = this.followersBucket;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((FollowersBucket) obj).getTimestamp() >= jCurrentTimeMillis) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                gainedCount += ((FollowersBucket) it.next()).getGainedCount();
            }
        }
        return gainedCount;
    }

    public final long followersLostInLastHours(int hours) {
        long lostCount = 0;
        if (!this.followersBucket.isEmpty() && hours > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - (hours * 3600000);
            List<FollowersBucket> list = this.followersBucket;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((FollowersBucket) obj).getTimestamp() >= jCurrentTimeMillis) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                lostCount += ((FollowersBucket) it.next()).getLostCount();
            }
        }
        return lostCount;
    }

    public final long followersNetGainInLastHours(int hours) {
        return followersGainedInLastHours(hours) - followersLostInLastHours(hours);
    }

    public final List<FollowersBucket> getFollowersBucket() {
        return this.followersBucket;
    }

    public final long getFollowersCount() {
        return this.followersCount;
    }

    public final List<Long> getFollowersPageIds() {
        return this.followersPageIds;
    }

    public final long getFollowingCount() {
        return this.followingCount;
    }

    public final List<FollowingUser> getFollowings() {
        return this.followings;
    }

    public int hashCode() {
        return this.followings.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.e(this.followersPageIds, androidx.appfunctions.metadata.a.e(this.followersBucket, Long.hashCode(this.followersCount) * 31, 31), 31), 31, this.followingCount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserStats(followersCount=");
        sb.append(this.followersCount);
        sb.append(", followersBucket=");
        sb.append(this.followersBucket);
        sb.append(", followersPageIds=");
        sb.append(this.followersPageIds);
        sb.append(", followingCount=");
        sb.append(this.followingCount);
        sb.append(", followings=");
        return B7.a.r(sb, this.followings, ')');
    }

    public UserStats(int i, long j5, List list, List list2, long j6, List list3, d0 d0Var) {
        if ((i & 1) == 0) {
            this.followersCount = 0L;
        } else {
            this.followersCount = j5;
        }
        if ((i & 2) == 0) {
            this.followersBucket = EmptyList.f4893a;
        } else {
            this.followersBucket = list;
        }
        if ((i & 4) == 0) {
            this.followersPageIds = EmptyList.f4893a;
        } else {
            this.followersPageIds = list2;
        }
        if ((i & 8) == 0) {
            this.followingCount = 0L;
        } else {
            this.followingCount = j6;
        }
        if ((i & 16) == 0) {
            this.followings = EmptyList.f4893a;
        } else {
            this.followings = list3;
        }
    }

    public UserStats(long j5, List<FollowersBucket> followersBucket, List<Long> followersPageIds, long j6, List<FollowingUser> followings) {
        k.f(followersBucket, "followersBucket");
        k.f(followersPageIds, "followersPageIds");
        k.f(followings, "followings");
        this.followersCount = j5;
        this.followersBucket = followersBucket;
        this.followersPageIds = followersPageIds;
        this.followingCount = j6;
        this.followings = followings;
    }

    public UserStats(long j5, List list, List list2, long j6, List list3, int i, e eVar) {
        this((i & 1) != 0 ? 0L : j5, (i & 2) != 0 ? EmptyList.f4893a : list, (i & 4) != 0 ? EmptyList.f4893a : list2, (i & 8) != 0 ? 0L : j6, (i & 16) != 0 ? EmptyList.f4893a : list3);
    }
}
