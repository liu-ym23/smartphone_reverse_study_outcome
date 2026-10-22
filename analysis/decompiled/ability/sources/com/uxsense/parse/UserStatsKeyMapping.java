package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/uxsense/parse/UserStatsKeyMapping;", "", "followersCount", "", "followingCount", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getFollowersCount", "()Ljava/lang/String;", "getFollowingCount", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserStatsKeyMapping {
    private final String followersCount;
    private final String followingCount;

    /* JADX WARN: Multi-variable type inference failed */
    public UserStatsKeyMapping() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UserStatsKeyMapping copy$default(UserStatsKeyMapping userStatsKeyMapping, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userStatsKeyMapping.followersCount;
        }
        if ((i & 2) != 0) {
            str2 = userStatsKeyMapping.followingCount;
        }
        return userStatsKeyMapping.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFollowersCount() {
        return this.followersCount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFollowingCount() {
        return this.followingCount;
    }

    public final UserStatsKeyMapping copy(String followersCount, String followingCount) {
        k.f(followersCount, "followersCount");
        k.f(followingCount, "followingCount");
        return new UserStatsKeyMapping(followersCount, followingCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserStatsKeyMapping)) {
            return false;
        }
        UserStatsKeyMapping userStatsKeyMapping = (UserStatsKeyMapping) other;
        return k.b(this.followersCount, userStatsKeyMapping.followersCount) && k.b(this.followingCount, userStatsKeyMapping.followingCount);
    }

    public final String getFollowersCount() {
        return this.followersCount;
    }

    public final String getFollowingCount() {
        return this.followingCount;
    }

    public int hashCode() {
        return this.followingCount.hashCode() + (this.followersCount.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserStatsKeyMapping(followersCount=");
        sb.append(this.followersCount);
        sb.append(", followingCount=");
        return B7.a.g(')', this.followingCount, sb);
    }

    public UserStatsKeyMapping(String followersCount, String followingCount) {
        k.f(followersCount, "followersCount");
        k.f(followingCount, "followingCount");
        this.followersCount = followersCount;
        this.followingCount = followingCount;
    }

    public /* synthetic */ UserStatsKeyMapping(String str, String str2, int i, e eVar) {
        this((i & 1) != 0 ? "followersCount" : str, (i & 2) != 0 ? "followingCount" : str2);
    }
}
