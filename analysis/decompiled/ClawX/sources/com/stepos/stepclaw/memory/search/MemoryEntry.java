package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u000fHÆ\u0003Jc\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\fHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/stepos/stepclaw/memory/search/MemoryEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "date", "score", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hitCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastAccessedAt", ExtensionCallContract.SOURCE, "Lcom/stepos/stepclaw/memory/search/RetrievalSource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;DIJLcom/stepos/stepclaw/memory/search/RetrievalSource;)V", "getId", "()Ljava/lang/String;", "getContent", "getCreatedAt", "()J", "getCategory", "getDate", "getScore", "()D", "getHitCount", "()I", "getLastAccessedAt", "getSource", "()Lcom/stepos/stepclaw/memory/search/RetrievalSource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MemoryEntry {
    private final String category;
    private final String content;
    private final long createdAt;
    private final String date;
    private final int hitCount;
    private final String id;
    private final long lastAccessedAt;
    private final double score;
    private final RetrievalSource source;

    public MemoryEntry(String id, String content, long j4, String category, String date, double d, int i8, long j8, RetrievalSource source) {
        p.e(id, "id");
        p.e(content, "content");
        p.e(category, "category");
        p.e(date, "date");
        p.e(source, "source");
        this.id = id;
        this.content = content;
        this.createdAt = j4;
        this.category = category;
        this.date = date;
        this.score = d;
        this.hitCount = i8;
        this.lastAccessedAt = j8;
        this.source = source;
    }

    public static /* synthetic */ MemoryEntry copy$default(MemoryEntry memoryEntry, String str, String str2, long j4, String str3, String str4, double d, int i8, long j8, RetrievalSource retrievalSource, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            str = memoryEntry.id;
        }
        if ((i9 & 2) != 0) {
            str2 = memoryEntry.content;
        }
        if ((i9 & 4) != 0) {
            j4 = memoryEntry.createdAt;
        }
        if ((i9 & 8) != 0) {
            str3 = memoryEntry.category;
        }
        if ((i9 & 16) != 0) {
            str4 = memoryEntry.date;
        }
        if ((i9 & 32) != 0) {
            d = memoryEntry.score;
        }
        if ((i9 & 64) != 0) {
            i8 = memoryEntry.hitCount;
        }
        if ((i9 & 128) != 0) {
            j8 = memoryEntry.lastAccessedAt;
        }
        if ((i9 & 256) != 0) {
            retrievalSource = memoryEntry.source;
        }
        int i10 = i8;
        double d9 = d;
        String str5 = str3;
        long j9 = j4;
        return memoryEntry.copy(str, str2, j9, str5, str4, d9, i10, j8, retrievalSource);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component6, reason: from getter */
    public final double getScore() {
        return this.score;
    }

    /* renamed from: component7, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    /* renamed from: component8, reason: from getter */
    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    /* renamed from: component9, reason: from getter */
    public final RetrievalSource getSource() {
        return this.source;
    }

    public final MemoryEntry copy(String id, String content, long createdAt, String category, String date, double score, int hitCount, long lastAccessedAt, RetrievalSource source) {
        p.e(id, "id");
        p.e(content, "content");
        p.e(category, "category");
        p.e(date, "date");
        p.e(source, "source");
        return new MemoryEntry(id, content, createdAt, category, date, score, hitCount, lastAccessedAt, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryEntry)) {
            return false;
        }
        MemoryEntry memoryEntry = (MemoryEntry) other;
        return p.a(this.id, memoryEntry.id) && p.a(this.content, memoryEntry.content) && this.createdAt == memoryEntry.createdAt && p.a(this.category, memoryEntry.category) && p.a(this.date, memoryEntry.date) && Double.compare(this.score, memoryEntry.score) == 0 && this.hitCount == memoryEntry.hitCount && this.lastAccessedAt == memoryEntry.lastAccessedAt && this.source == memoryEntry.source;
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

    public final String getDate() {
        return this.date;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    public final double getScore() {
        return this.score;
    }

    public final RetrievalSource getSource() {
        return this.source;
    }

    public int hashCode() {
        return this.source.hashCode() + a8.b.e(a8.b.C(this.hitCount, (Double.hashCode(this.score) + a8.b.f(a8.b.f(a8.b.e(a8.b.f(this.id.hashCode() * 31, 31, this.content), 31, this.createdAt), 31, this.category), 31, this.date)) * 31, 31), 31, this.lastAccessedAt);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.content;
        long j4 = this.createdAt;
        String str3 = this.category;
        String str4 = this.date;
        double d = this.score;
        int i8 = this.hitCount;
        long j8 = this.lastAccessedAt;
        RetrievalSource retrievalSource = this.source;
        StringBuilder sbV = a8.b.v("MemoryEntry(id=", str, ", content=", str2, ", createdAt=");
        sbV.append(j4);
        sbV.append(", category=");
        sbV.append(str3);
        sbV.append(", date=");
        sbV.append(str4);
        sbV.append(", score=");
        sbV.append(d);
        sbV.append(", hitCount=");
        sbV.append(i8);
        sbV.append(", lastAccessedAt=");
        sbV.append(j8);
        sbV.append(", source=");
        sbV.append(retrievalSource);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ MemoryEntry(String str, String str2, long j4, String str3, String str4, double d, int i8, long j8, RetrievalSource retrievalSource, int i9, i iVar) {
        this(str, str2, (i9 & 4) != 0 ? 0L : j4, (i9 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i9 & 16) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str4, (i9 & 32) != 0 ? 0.0d : d, (i9 & 64) != 0 ? 0 : i8, (i9 & 128) != 0 ? 0L : j8, (i9 & 256) != 0 ? RetrievalSource.UNKNOWN : retrievalSource);
    }
}
