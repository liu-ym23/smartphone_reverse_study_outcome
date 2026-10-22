package com.uxsense.search;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.User;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/uxsense/search/MatchedUser;", "", "userId", "", "nickname", "", "uuid", "bio", "matchScore", "", "matchedFields", "", "Lcom/uxsense/search/MatchedField;", AppAgent.CONSTRUCT, "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/util/List;)V", "getUserId", "()J", "getNickname", "()Ljava/lang/String;", "getUuid", "getBio", "getMatchScore", "()F", "getMatchedFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MatchedUser {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bio;
    private final float matchScore;
    private final List<MatchedField> matchedFields;
    private final String nickname;
    private final long userId;
    private final String uuid;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/uxsense/search/MatchedUser$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromSearchResult", "Lcom/uxsense/search/MatchedUser;", "result", "Lcom/uxsense/search/SearchResult;", BffConstant.Role.User, "Lcom/uxsense/base/metadata/User;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MatchedUser fromSearchResult(SearchResult<?> result, User user) {
            k.f(result, "result");
            k.f(user, "user");
            return new MatchedUser(user.getUserId(), user.getNickname(), user.getUuid(), user.getBio(), result.getScore(), result.getMatchedFields());
        }

        private Companion() {
        }
    }

    public MatchedUser(long j5, String nickname, String uuid, String bio, float f, List<MatchedField> matchedFields) {
        k.f(nickname, "nickname");
        k.f(uuid, "uuid");
        k.f(bio, "bio");
        k.f(matchedFields, "matchedFields");
        this.userId = j5;
        this.nickname = nickname;
        this.uuid = uuid;
        this.bio = bio;
        this.matchScore = f;
        this.matchedFields = matchedFields;
    }

    public static /* synthetic */ MatchedUser copy$default(MatchedUser matchedUser, long j5, String str, String str2, String str3, float f, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = matchedUser.userId;
        }
        long j6 = j5;
        if ((i & 2) != 0) {
            str = matchedUser.nickname;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = matchedUser.uuid;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = matchedUser.bio;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            f = matchedUser.matchScore;
        }
        float f7 = f;
        if ((i & 32) != 0) {
            list = matchedUser.matchedFields;
        }
        return matchedUser.copy(j6, str4, str5, str6, f7, list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBio() {
        return this.bio;
    }

    /* renamed from: component5, reason: from getter */
    public final float getMatchScore() {
        return this.matchScore;
    }

    public final List<MatchedField> component6() {
        return this.matchedFields;
    }

    public final MatchedUser copy(long userId, String nickname, String uuid, String bio, float matchScore, List<MatchedField> matchedFields) {
        k.f(nickname, "nickname");
        k.f(uuid, "uuid");
        k.f(bio, "bio");
        k.f(matchedFields, "matchedFields");
        return new MatchedUser(userId, nickname, uuid, bio, matchScore, matchedFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchedUser)) {
            return false;
        }
        MatchedUser matchedUser = (MatchedUser) other;
        return this.userId == matchedUser.userId && k.b(this.nickname, matchedUser.nickname) && k.b(this.uuid, matchedUser.uuid) && k.b(this.bio, matchedUser.bio) && Float.compare(this.matchScore, matchedUser.matchScore) == 0 && k.b(this.matchedFields, matchedUser.matchedFields);
    }

    public final String getBio() {
        return this.bio;
    }

    public final float getMatchScore() {
        return this.matchScore;
    }

    public final List<MatchedField> getMatchedFields() {
        return this.matchedFields;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.matchedFields.hashCode() + a.b(this.matchScore, B7.a.c(B7.a.c(B7.a.c(Long.hashCode(this.userId) * 31, 31, this.nickname), 31, this.uuid), 31, this.bio), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MatchedUser(userId=");
        sb.append(this.userId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", uuid=");
        sb.append(this.uuid);
        sb.append(", bio=");
        sb.append(this.bio);
        sb.append(", matchScore=");
        sb.append(this.matchScore);
        sb.append(", matchedFields=");
        return B7.a.r(sb, this.matchedFields, ')');
    }

    public MatchedUser(long j5, String str, String str2, String str3, float f, List list, int i, e eVar) {
        this(j5, str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, f, (i & 32) != 0 ? EmptyList.f4893a : list);
    }
}
