package com.uxsense.search;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.base.metadata.Comment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001)BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006*"}, d2 = {"Lcom/uxsense/search/MatchedComment;", "", "commentId", "", "creationId", "userId", "nickname", "", "content", "matchScore", "", "matchedFields", "", "Lcom/uxsense/search/MatchedField;", AppAgent.CONSTRUCT, "(JJJLjava/lang/String;Ljava/lang/String;FLjava/util/List;)V", "getCommentId", "()J", "getCreationId", "getUserId", "getNickname", "()Ljava/lang/String;", "getContent", "getMatchScore", "()F", "getMatchedFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MatchedComment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long commentId;
    private final String content;
    private final long creationId;
    private final float matchScore;
    private final List<MatchedField> matchedFields;
    private final String nickname;
    private final long userId;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/uxsense/search/MatchedComment$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromSearchResult", "Lcom/uxsense/search/MatchedComment;", "result", "Lcom/uxsense/search/SearchResult;", "comment", "Lcom/uxsense/base/metadata/Comment;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MatchedComment fromSearchResult(SearchResult<?> result, Comment comment) {
            k.f(result, "result");
            k.f(comment, "comment");
            return new MatchedComment(comment.getCommentId(), comment.getCreationId(), comment.getUserId(), comment.getNickname(), comment.getContent(), result.getScore(), result.getMatchedFields());
        }

        private Companion() {
        }
    }

    public MatchedComment(long j5, long j6, long j10, String str, String str2, float f, List list, int i, e eVar) {
        this(j5, j6, j10, str, str2, f, (i & 64) != 0 ? EmptyList.f4893a : list);
    }

    public static /* synthetic */ MatchedComment copy$default(MatchedComment matchedComment, long j5, long j6, long j10, String str, String str2, float f, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = matchedComment.commentId;
        }
        long j11 = j5;
        if ((i & 2) != 0) {
            j6 = matchedComment.creationId;
        }
        return matchedComment.copy(j11, j6, (i & 4) != 0 ? matchedComment.userId : j10, (i & 8) != 0 ? matchedComment.nickname : str, (i & 16) != 0 ? matchedComment.content : str2, (i & 32) != 0 ? matchedComment.matchScore : f, (i & 64) != 0 ? matchedComment.matchedFields : list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getCommentId() {
        return this.commentId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getCreationId() {
        return this.creationId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component6, reason: from getter */
    public final float getMatchScore() {
        return this.matchScore;
    }

    public final List<MatchedField> component7() {
        return this.matchedFields;
    }

    public final MatchedComment copy(long commentId, long creationId, long userId, String nickname, String content, float matchScore, List<MatchedField> matchedFields) {
        k.f(nickname, "nickname");
        k.f(content, "content");
        k.f(matchedFields, "matchedFields");
        return new MatchedComment(commentId, creationId, userId, nickname, content, matchScore, matchedFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchedComment)) {
            return false;
        }
        MatchedComment matchedComment = (MatchedComment) other;
        return this.commentId == matchedComment.commentId && this.creationId == matchedComment.creationId && this.userId == matchedComment.userId && k.b(this.nickname, matchedComment.nickname) && k.b(this.content, matchedComment.content) && Float.compare(this.matchScore, matchedComment.matchScore) == 0 && k.b(this.matchedFields, matchedComment.matchedFields);
    }

    public final long getCommentId() {
        return this.commentId;
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

    public final String getNickname() {
        return this.nickname;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.matchedFields.hashCode() + a.b(this.matchScore, B7.a.c(B7.a.c(a.c(a.c(Long.hashCode(this.commentId) * 31, 31, this.creationId), 31, this.userId), 31, this.nickname), 31, this.content), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MatchedComment(commentId=");
        sb.append(this.commentId);
        sb.append(", creationId=");
        sb.append(this.creationId);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", matchScore=");
        sb.append(this.matchScore);
        sb.append(", matchedFields=");
        return B7.a.r(sb, this.matchedFields, ')');
    }

    public MatchedComment(long j5, long j6, long j10, String nickname, String content, float f, List<MatchedField> matchedFields) {
        k.f(nickname, "nickname");
        k.f(content, "content");
        k.f(matchedFields, "matchedFields");
        this.commentId = j5;
        this.creationId = j6;
        this.userId = j10;
        this.nickname = nickname;
        this.content = content;
        this.matchScore = f;
        this.matchedFields = matchedFields;
    }
}
