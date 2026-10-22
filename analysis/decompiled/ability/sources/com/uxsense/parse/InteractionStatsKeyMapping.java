package com.uxsense.parse;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/uxsense/parse/InteractionStatsKeyMapping;", "", "likeCount", "", "starCount", "shareCount", "commentCount", "viewCount", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLikeCount", "()Ljava/lang/String;", "getStarCount", "getShareCount", "getCommentCount", "getViewCount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InteractionStatsKeyMapping {
    private final String commentCount;
    private final String likeCount;
    private final String shareCount;
    private final String starCount;
    private final String viewCount;

    public InteractionStatsKeyMapping() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ InteractionStatsKeyMapping copy$default(InteractionStatsKeyMapping interactionStatsKeyMapping, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = interactionStatsKeyMapping.likeCount;
        }
        if ((i & 2) != 0) {
            str2 = interactionStatsKeyMapping.starCount;
        }
        if ((i & 4) != 0) {
            str3 = interactionStatsKeyMapping.shareCount;
        }
        if ((i & 8) != 0) {
            str4 = interactionStatsKeyMapping.commentCount;
        }
        if ((i & 16) != 0) {
            str5 = interactionStatsKeyMapping.viewCount;
        }
        String str6 = str5;
        String str7 = str3;
        return interactionStatsKeyMapping.copy(str, str2, str7, str4, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLikeCount() {
        return this.likeCount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStarCount() {
        return this.starCount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getShareCount() {
        return this.shareCount;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCommentCount() {
        return this.commentCount;
    }

    /* renamed from: component5, reason: from getter */
    public final String getViewCount() {
        return this.viewCount;
    }

    public final InteractionStatsKeyMapping copy(String likeCount, String starCount, String shareCount, String commentCount, String viewCount) {
        k.f(likeCount, "likeCount");
        k.f(starCount, "starCount");
        k.f(shareCount, "shareCount");
        k.f(commentCount, "commentCount");
        k.f(viewCount, "viewCount");
        return new InteractionStatsKeyMapping(likeCount, starCount, shareCount, commentCount, viewCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionStatsKeyMapping)) {
            return false;
        }
        InteractionStatsKeyMapping interactionStatsKeyMapping = (InteractionStatsKeyMapping) other;
        return k.b(this.likeCount, interactionStatsKeyMapping.likeCount) && k.b(this.starCount, interactionStatsKeyMapping.starCount) && k.b(this.shareCount, interactionStatsKeyMapping.shareCount) && k.b(this.commentCount, interactionStatsKeyMapping.commentCount) && k.b(this.viewCount, interactionStatsKeyMapping.viewCount);
    }

    public final String getCommentCount() {
        return this.commentCount;
    }

    public final String getLikeCount() {
        return this.likeCount;
    }

    public final String getShareCount() {
        return this.shareCount;
    }

    public final String getStarCount() {
        return this.starCount;
    }

    public final String getViewCount() {
        return this.viewCount;
    }

    public int hashCode() {
        return this.viewCount.hashCode() + B7.a.c(B7.a.c(B7.a.c(this.likeCount.hashCode() * 31, 31, this.starCount), 31, this.shareCount), 31, this.commentCount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InteractionStatsKeyMapping(likeCount=");
        sb.append(this.likeCount);
        sb.append(", starCount=");
        sb.append(this.starCount);
        sb.append(", shareCount=");
        sb.append(this.shareCount);
        sb.append(", commentCount=");
        sb.append(this.commentCount);
        sb.append(", viewCount=");
        return B7.a.g(')', this.viewCount, sb);
    }

    public InteractionStatsKeyMapping(String likeCount, String starCount, String shareCount, String commentCount, String viewCount) {
        k.f(likeCount, "likeCount");
        k.f(starCount, "starCount");
        k.f(shareCount, "shareCount");
        k.f(commentCount, "commentCount");
        k.f(viewCount, "viewCount");
        this.likeCount = likeCount;
        this.starCount = starCount;
        this.shareCount = shareCount;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
    }

    public /* synthetic */ InteractionStatsKeyMapping(String str, String str2, String str3, String str4, String str5, int i, e eVar) {
        this((i & 1) != 0 ? "likeCount" : str, (i & 2) != 0 ? "starCount" : str2, (i & 4) != 0 ? "shareCount" : str3, (i & 8) != 0 ? "commentCount" : str4, (i & 16) != 0 ? "viewCount" : str5);
    }
}
