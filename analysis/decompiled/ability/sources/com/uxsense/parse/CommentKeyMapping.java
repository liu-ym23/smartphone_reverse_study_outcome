package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Jc\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006'"}, d2 = {"Lcom/uxsense/parse/CommentKeyMapping;", "", "parentCommentId", "", "isAuthor", "nickname", "userId", "content", "ts", "hasReply", "replyCount", "likeCount", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParentCommentId", "()Ljava/lang/String;", "getNickname", "getUserId", "getContent", "getTs", "getHasReply", "getReplyCount", "getLikeCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CommentKeyMapping {
    private final String content;
    private final String hasReply;
    private final String isAuthor;
    private final String likeCount;
    private final String nickname;
    private final String parentCommentId;
    private final String replyCount;
    private final String ts;
    private final String userId;

    public CommentKeyMapping() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ CommentKeyMapping copy$default(CommentKeyMapping commentKeyMapping, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commentKeyMapping.parentCommentId;
        }
        if ((i & 2) != 0) {
            str2 = commentKeyMapping.isAuthor;
        }
        if ((i & 4) != 0) {
            str3 = commentKeyMapping.nickname;
        }
        if ((i & 8) != 0) {
            str4 = commentKeyMapping.userId;
        }
        if ((i & 16) != 0) {
            str5 = commentKeyMapping.content;
        }
        if ((i & 32) != 0) {
            str6 = commentKeyMapping.ts;
        }
        if ((i & 64) != 0) {
            str7 = commentKeyMapping.hasReply;
        }
        if ((i & 128) != 0) {
            str8 = commentKeyMapping.replyCount;
        }
        if ((i & 256) != 0) {
            str9 = commentKeyMapping.likeCount;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        String str15 = str3;
        return commentKeyMapping.copy(str, str2, str15, str4, str14, str12, str13, str10, str11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIsAuthor() {
        return this.isAuthor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTs() {
        return this.ts;
    }

    /* renamed from: component7, reason: from getter */
    public final String getHasReply() {
        return this.hasReply;
    }

    /* renamed from: component8, reason: from getter */
    public final String getReplyCount() {
        return this.replyCount;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLikeCount() {
        return this.likeCount;
    }

    public final CommentKeyMapping copy(String parentCommentId, String isAuthor, String nickname, String userId, String content, String ts, String hasReply, String replyCount, String likeCount) {
        k.f(parentCommentId, "parentCommentId");
        k.f(isAuthor, "isAuthor");
        k.f(nickname, "nickname");
        k.f(userId, "userId");
        k.f(content, "content");
        k.f(ts, "ts");
        k.f(hasReply, "hasReply");
        k.f(replyCount, "replyCount");
        k.f(likeCount, "likeCount");
        return new CommentKeyMapping(parentCommentId, isAuthor, nickname, userId, content, ts, hasReply, replyCount, likeCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommentKeyMapping)) {
            return false;
        }
        CommentKeyMapping commentKeyMapping = (CommentKeyMapping) other;
        return k.b(this.parentCommentId, commentKeyMapping.parentCommentId) && k.b(this.isAuthor, commentKeyMapping.isAuthor) && k.b(this.nickname, commentKeyMapping.nickname) && k.b(this.userId, commentKeyMapping.userId) && k.b(this.content, commentKeyMapping.content) && k.b(this.ts, commentKeyMapping.ts) && k.b(this.hasReply, commentKeyMapping.hasReply) && k.b(this.replyCount, commentKeyMapping.replyCount) && k.b(this.likeCount, commentKeyMapping.likeCount);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHasReply() {
        return this.hasReply;
    }

    public final String getLikeCount() {
        return this.likeCount;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    public final String getReplyCount() {
        return this.replyCount;
    }

    public final String getTs() {
        return this.ts;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return this.likeCount.hashCode() + B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(this.parentCommentId.hashCode() * 31, 31, this.isAuthor), 31, this.nickname), 31, this.userId), 31, this.content), 31, this.ts), 31, this.hasReply), 31, this.replyCount);
    }

    public final String isAuthor() {
        return this.isAuthor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CommentKeyMapping(parentCommentId=");
        sb.append(this.parentCommentId);
        sb.append(", isAuthor=");
        sb.append(this.isAuthor);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", ts=");
        sb.append(this.ts);
        sb.append(", hasReply=");
        sb.append(this.hasReply);
        sb.append(", replyCount=");
        sb.append(this.replyCount);
        sb.append(", likeCount=");
        return B7.a.g(')', this.likeCount, sb);
    }

    public CommentKeyMapping(String parentCommentId, String isAuthor, String nickname, String userId, String content, String ts, String hasReply, String replyCount, String likeCount) {
        k.f(parentCommentId, "parentCommentId");
        k.f(isAuthor, "isAuthor");
        k.f(nickname, "nickname");
        k.f(userId, "userId");
        k.f(content, "content");
        k.f(ts, "ts");
        k.f(hasReply, "hasReply");
        k.f(replyCount, "replyCount");
        k.f(likeCount, "likeCount");
        this.parentCommentId = parentCommentId;
        this.isAuthor = isAuthor;
        this.nickname = nickname;
        this.userId = userId;
        this.content = content;
        this.ts = ts;
        this.hasReply = hasReply;
        this.replyCount = replyCount;
        this.likeCount = likeCount;
    }

    public /* synthetic */ CommentKeyMapping(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, e eVar) {
        this((i & 1) != 0 ? "parentCommentId" : str, (i & 2) != 0 ? "isAuthor" : str2, (i & 4) != 0 ? "nickname" : str3, (i & 8) != 0 ? "userId" : str4, (i & 16) != 0 ? "content" : str5, (i & 32) != 0 ? "ts" : str6, (i & 64) != 0 ? "hasReply" : str7, (i & 128) != 0 ? "replyCount" : str8, (i & 256) != 0 ? "likeCount" : str9);
    }
}
