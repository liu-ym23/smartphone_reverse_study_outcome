package com.uxsense.search;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.base.metadata.Creation;
import j9.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\nHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\nHÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006-"}, d2 = {"Lcom/uxsense/search/MatchedCreation;", "", "creationId", "", "userId", "title", "", "authorNickname", "content", "tags", "", "matchScore", "", "matchedFields", "Lcom/uxsense/search/MatchedField;", AppAgent.CONSTRUCT, "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;FLjava/util/List;)V", "getCreationId", "()J", "getUserId", "getTitle", "()Ljava/lang/String;", "getAuthorNickname", "getContent", "getTags", "()Ljava/util/List;", "getMatchScore", "()F", "getMatchedFields", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MatchedCreation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String authorNickname;
    private final String content;
    private final long creationId;
    private final float matchScore;
    private final List<MatchedField> matchedFields;
    private final List<String> tags;
    private final String title;
    private final long userId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/uxsense/search/MatchedCreation$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromSearchResult", "Lcom/uxsense/search/MatchedCreation;", "result", "Lcom/uxsense/search/SearchResult;", "creation", "Lcom/uxsense/base/metadata/Creation;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MatchedCreation fromSearchResult(SearchResult<?> result, Creation creation) {
            k.f(result, "result");
            k.f(creation, "creation");
            return new MatchedCreation(creation.getCreationId(), creation.getUserId(), creation.getTitle(), creation.getAuthorNickname(), m.N0(200, creation.getContent()), creation.getTags(), result.getScore(), result.getMatchedFields());
        }

        private Companion() {
        }
    }

    public MatchedCreation(long j5, long j6, String title, String authorNickname, String content, List<String> tags, float f, List<MatchedField> matchedFields) {
        k.f(title, "title");
        k.f(authorNickname, "authorNickname");
        k.f(content, "content");
        k.f(tags, "tags");
        k.f(matchedFields, "matchedFields");
        this.creationId = j5;
        this.userId = j6;
        this.title = title;
        this.authorNickname = authorNickname;
        this.content = content;
        this.tags = tags;
        this.matchScore = f;
        this.matchedFields = matchedFields;
    }

    public static /* synthetic */ MatchedCreation copy$default(MatchedCreation matchedCreation, long j5, long j6, String str, String str2, String str3, List list, float f, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = matchedCreation.creationId;
        }
        long j10 = j5;
        if ((i & 2) != 0) {
            j6 = matchedCreation.userId;
        }
        return matchedCreation.copy(j10, j6, (i & 4) != 0 ? matchedCreation.title : str, (i & 8) != 0 ? matchedCreation.authorNickname : str2, (i & 16) != 0 ? matchedCreation.content : str3, (i & 32) != 0 ? matchedCreation.tags : list, (i & 64) != 0 ? matchedCreation.matchScore : f, (i & 128) != 0 ? matchedCreation.matchedFields : list2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAuthorNickname() {
        return this.authorNickname;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final List<String> component6() {
        return this.tags;
    }

    /* renamed from: component7, reason: from getter */
    public final float getMatchScore() {
        return this.matchScore;
    }

    public final List<MatchedField> component8() {
        return this.matchedFields;
    }

    public final MatchedCreation copy(long creationId, long userId, String title, String authorNickname, String content, List<String> tags, float matchScore, List<MatchedField> matchedFields) {
        k.f(title, "title");
        k.f(authorNickname, "authorNickname");
        k.f(content, "content");
        k.f(tags, "tags");
        k.f(matchedFields, "matchedFields");
        return new MatchedCreation(creationId, userId, title, authorNickname, content, tags, matchScore, matchedFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchedCreation)) {
            return false;
        }
        MatchedCreation matchedCreation = (MatchedCreation) other;
        return this.creationId == matchedCreation.creationId && this.userId == matchedCreation.userId && k.b(this.title, matchedCreation.title) && k.b(this.authorNickname, matchedCreation.authorNickname) && k.b(this.content, matchedCreation.content) && k.b(this.tags, matchedCreation.tags) && Float.compare(this.matchScore, matchedCreation.matchScore) == 0 && k.b(this.matchedFields, matchedCreation.matchedFields);
    }

    public final String getAuthorNickname() {
        return this.authorNickname;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreationId() {
        return this.creationId;
    }

    public final float getMatchScore() {
        return this.matchScore;
    }

    public final List<MatchedField> getMatchedFields() {
        return this.matchedFields;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.matchedFields.hashCode() + a.b(this.matchScore, a.e(this.tags, B7.a.c(B7.a.c(B7.a.c(a.c(Long.hashCode(this.creationId) * 31, 31, this.userId), 31, this.title), 31, this.authorNickname), 31, this.content), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MatchedCreation(creationId=");
        sb.append(this.creationId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", authorNickname=");
        sb.append(this.authorNickname);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", tags=");
        sb.append(this.tags);
        sb.append(", matchScore=");
        sb.append(this.matchScore);
        sb.append(", matchedFields=");
        return B7.a.r(sb, this.matchedFields, ')');
    }

    public MatchedCreation(long j5, long j6, String str, String str2, String str3, List list, float f, List list2, int i, e eVar) {
        this(j5, j6, str, str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? EmptyList.f4893a : list, f, (i & 128) != 0 ? EmptyList.f4893a : list2);
    }
}
