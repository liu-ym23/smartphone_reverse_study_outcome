package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006$"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/SearchResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "score", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hitCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastAccessedAt", "<init>", "(Ljava/lang/String;DLjava/lang/String;JIJ)V", "getDocId", "()Ljava/lang/String;", "getScore", "()D", "getContent", "getCreatedAt", "()J", "getHitCount", "()I", "getLastAccessedAt", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SearchResult {
    private final String content;
    private final long createdAt;
    private final String docId;
    private final int hitCount;
    private final long lastAccessedAt;
    private final double score;

    public SearchResult(String docId, double d, String content, long j4, int i8, long j8) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(content, "content");
        this.docId = docId;
        this.score = d;
        this.content = content;
        this.createdAt = j4;
        this.hitCount = i8;
        this.lastAccessedAt = j8;
    }

    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, String str, double d, String str2, long j4, int i8, long j8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = searchResult.docId;
        }
        if ((i9 & 2) != 0) {
            d = searchResult.score;
        }
        if ((i9 & 4) != 0) {
            str2 = searchResult.content;
        }
        if ((i9 & 8) != 0) {
            j4 = searchResult.createdAt;
        }
        if ((i9 & 16) != 0) {
            i8 = searchResult.hitCount;
        }
        if ((i9 & 32) != 0) {
            j8 = searchResult.lastAccessedAt;
        }
        int i10 = i8;
        String str3 = str2;
        return searchResult.copy(str, d, str3, j4, i10, j8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* renamed from: component2, reason: from getter */
    public final double getScore() {
        return this.score;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    /* renamed from: component6, reason: from getter */
    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    public final SearchResult copy(String docId, double score, String content, long createdAt, int hitCount, long lastAccessedAt) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(content, "content");
        return new SearchResult(docId, score, content, createdAt, hitCount, lastAccessedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return kotlin.jvm.internal.p.a(this.docId, searchResult.docId) && Double.compare(this.score, searchResult.score) == 0 && kotlin.jvm.internal.p.a(this.content, searchResult.content) && this.createdAt == searchResult.createdAt && this.hitCount == searchResult.hitCount && this.lastAccessedAt == searchResult.lastAccessedAt;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDocId() {
        return this.docId;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    public final double getScore() {
        return this.score;
    }

    public int hashCode() {
        return Long.hashCode(this.lastAccessedAt) + a8.b.C(this.hitCount, a8.b.e(a8.b.f((Double.hashCode(this.score) + (this.docId.hashCode() * 31)) * 31, 31, this.content), 31, this.createdAt), 31);
    }

    public String toString() {
        return "SearchResult(docId=" + this.docId + ", score=" + this.score + ", content=" + this.content + ", createdAt=" + this.createdAt + ", hitCount=" + this.hitCount + ", lastAccessedAt=" + this.lastAccessedAt + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ SearchResult(java.lang.String r11, double r12, java.lang.String r14, long r15, int r17, long r18, int r20, kotlin.jvm.internal.i r21) {
        /*
            r10 = this;
            r0 = r20 & 4
            if (r0 == 0) goto L6
            java.lang.String r14 = ""
        L6:
            r4 = r14
            r14 = r20 & 8
            r0 = 0
            if (r14 == 0) goto Lf
            r5 = r0
            goto L10
        Lf:
            r5 = r15
        L10:
            r14 = r20 & 16
            if (r14 == 0) goto L17
            r14 = 0
            r7 = r14
            goto L19
        L17:
            r7 = r17
        L19:
            r14 = r20 & 32
            if (r14 == 0) goto L22
            r8 = r0
            r2 = r12
            r0 = r10
            r1 = r11
            goto L27
        L22:
            r8 = r18
            r0 = r10
            r1 = r11
            r2 = r12
        L27:
            r0.<init>(r1, r2, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.SearchResult.<init>(java.lang.String, double, java.lang.String, long, int, long, int, kotlin.jvm.internal.i):void");
    }
}
