package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000bHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u0006/"}, d2 = {"Lcom/stepos/stepclaw/memory/search/RetrievalResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "score", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "hitCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastAccessedAt", ExtensionCallContract.SOURCE, "Lcom/stepos/stepclaw/memory/search/RetrievalSource;", "query", "<init>", "(Ljava/lang/String;Ljava/lang/String;FJLjava/lang/String;IJLcom/stepos/stepclaw/memory/search/RetrievalSource;Ljava/lang/String;)V", "getDocId", "()Ljava/lang/String;", "getContent", "getScore", "()F", "getCreatedAt", "()J", "getCategory", "getHitCount", "()I", "getLastAccessedAt", "getSource", "()Lcom/stepos/stepclaw/memory/search/RetrievalSource;", "getQuery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class RetrievalResult {
    private final String category;
    private final String content;
    private final long createdAt;
    private final String docId;
    private final int hitCount;
    private final long lastAccessedAt;
    private final String query;
    private final float score;
    private final RetrievalSource source;

    public RetrievalResult(String docId, String content, float f3, long j4, String category, int i8, long j8, RetrievalSource source, String query) {
        p.e(docId, "docId");
        p.e(content, "content");
        p.e(category, "category");
        p.e(source, "source");
        p.e(query, "query");
        this.docId = docId;
        this.content = content;
        this.score = f3;
        this.createdAt = j4;
        this.category = category;
        this.hitCount = i8;
        this.lastAccessedAt = j8;
        this.source = source;
        this.query = query;
    }

    public static /* synthetic */ RetrievalResult copy$default(RetrievalResult retrievalResult, String str, String str2, float f3, long j4, String str3, int i8, long j8, RetrievalSource retrievalSource, String str4, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = retrievalResult.docId;
        }
        if ((i9 & 2) != 0) {
            str2 = retrievalResult.content;
        }
        if ((i9 & 4) != 0) {
            f3 = retrievalResult.score;
        }
        if ((i9 & 8) != 0) {
            j4 = retrievalResult.createdAt;
        }
        if ((i9 & 16) != 0) {
            str3 = retrievalResult.category;
        }
        if ((i9 & 32) != 0) {
            i8 = retrievalResult.hitCount;
        }
        if ((i9 & 64) != 0) {
            j8 = retrievalResult.lastAccessedAt;
        }
        if ((i9 & 128) != 0) {
            retrievalSource = retrievalResult.source;
        }
        if ((i9 & 256) != 0) {
            str4 = retrievalResult.query;
        }
        long j9 = j8;
        String str5 = str3;
        long j10 = j4;
        float f7 = f3;
        return retrievalResult.copy(str, str2, f7, j10, str5, i8, j9, retrievalSource, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final float getScore() {
        return this.score;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component6, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    /* renamed from: component7, reason: from getter */
    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    /* renamed from: component8, reason: from getter */
    public final RetrievalSource getSource() {
        return this.source;
    }

    /* renamed from: component9, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final RetrievalResult copy(String docId, String content, float score, long createdAt, String category, int hitCount, long lastAccessedAt, RetrievalSource source, String query) {
        p.e(docId, "docId");
        p.e(content, "content");
        p.e(category, "category");
        p.e(source, "source");
        p.e(query, "query");
        return new RetrievalResult(docId, content, score, createdAt, category, hitCount, lastAccessedAt, source, query);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RetrievalResult)) {
            return false;
        }
        RetrievalResult retrievalResult = (RetrievalResult) other;
        return p.a(this.docId, retrievalResult.docId) && p.a(this.content, retrievalResult.content) && Float.compare(this.score, retrievalResult.score) == 0 && this.createdAt == retrievalResult.createdAt && p.a(this.category, retrievalResult.category) && this.hitCount == retrievalResult.hitCount && this.lastAccessedAt == retrievalResult.lastAccessedAt && this.source == retrievalResult.source && p.a(this.query, retrievalResult.query);
    }

    public final String getCategory() {
        return this.category;
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

    public final String getQuery() {
        return this.query;
    }

    public final float getScore() {
        return this.score;
    }

    public final RetrievalSource getSource() {
        return this.source;
    }

    public int hashCode() {
        return this.query.hashCode() + ((this.source.hashCode() + a8.b.e(a8.b.C(this.hitCount, a8.b.f(a8.b.e((Float.hashCode(this.score) + a8.b.f(this.docId.hashCode() * 31, 31, this.content)) * 31, 31, this.createdAt), 31, this.category), 31), 31, this.lastAccessedAt)) * 31);
    }

    public String toString() {
        String str = this.docId;
        String str2 = this.content;
        float f3 = this.score;
        long j4 = this.createdAt;
        String str3 = this.category;
        int i8 = this.hitCount;
        long j8 = this.lastAccessedAt;
        RetrievalSource retrievalSource = this.source;
        String str4 = this.query;
        StringBuilder sbV = a8.b.v("RetrievalResult(docId=", str, ", content=", str2, ", score=");
        sbV.append(f3);
        sbV.append(", createdAt=");
        sbV.append(j4);
        sbV.append(", category=");
        sbV.append(str3);
        sbV.append(", hitCount=");
        sbV.append(i8);
        sbV.append(", lastAccessedAt=");
        sbV.append(j8);
        sbV.append(", source=");
        sbV.append(retrievalSource);
        sbV.append(", query=");
        sbV.append(str4);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ RetrievalResult(String str, String str2, float f3, long j4, String str3, int i8, long j8, RetrievalSource retrievalSource, String str4, int i9, i iVar) {
        this(str, str2, f3, j4, str3, (i9 & 32) != 0 ? 0 : i8, (i9 & 64) != 0 ? 0L : j8, (i9 & 128) != 0 ? RetrievalSource.UNKNOWN : retrievalSource, str4);
    }
}
