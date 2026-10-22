package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/DocMeta;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "length", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "date", "category", "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hitCount", "lastAccessedAt", "tier", "Lcom/stepos/stepclaw/memory/storage/index/IndexTier;", "sizeBytes", "lastCacheAccessTime", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JIJLcom/stepos/stepclaw/memory/storage/index/IndexTier;IJ)V", "getDocId", "()Ljava/lang/String;", "getLength", "()I", "getDate", "getCategory", "getCreatedAt", "()J", "getHitCount", "getLastAccessedAt", "getTier", "()Lcom/stepos/stepclaw/memory/storage/index/IndexTier;", "getSizeBytes", "getLastCacheAccessTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DocMeta {
    private final String category;
    private final long createdAt;
    private final String date;
    private final String docId;
    private final int hitCount;
    private final long lastAccessedAt;
    private final long lastCacheAccessTime;
    private final int length;
    private final int sizeBytes;
    private final IndexTier tier;

    public DocMeta(String docId, int i8, String date, String category, long j4, int i9, long j8, IndexTier tier, int i10, long j9) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(date, "date");
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(tier, "tier");
        this.docId = docId;
        this.length = i8;
        this.date = date;
        this.category = category;
        this.createdAt = j4;
        this.hitCount = i9;
        this.lastAccessedAt = j8;
        this.tier = tier;
        this.sizeBytes = i10;
        this.lastCacheAccessTime = j9;
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocId() {
        return this.docId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getLastCacheAccessTime() {
        return this.lastCacheAccessTime;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLength() {
        return this.length;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
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
    public final IndexTier getTier() {
        return this.tier;
    }

    /* renamed from: component9, reason: from getter */
    public final int getSizeBytes() {
        return this.sizeBytes;
    }

    public final DocMeta copy(String docId, int length, String date, String category, long createdAt, int hitCount, long lastAccessedAt, IndexTier tier, int sizeBytes, long lastCacheAccessTime) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(date, "date");
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(tier, "tier");
        return new DocMeta(docId, length, date, category, createdAt, hitCount, lastAccessedAt, tier, sizeBytes, lastCacheAccessTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocMeta)) {
            return false;
        }
        DocMeta docMeta = (DocMeta) other;
        return kotlin.jvm.internal.p.a(this.docId, docMeta.docId) && this.length == docMeta.length && kotlin.jvm.internal.p.a(this.date, docMeta.date) && kotlin.jvm.internal.p.a(this.category, docMeta.category) && this.createdAt == docMeta.createdAt && this.hitCount == docMeta.hitCount && this.lastAccessedAt == docMeta.lastAccessedAt && this.tier == docMeta.tier && this.sizeBytes == docMeta.sizeBytes && this.lastCacheAccessTime == docMeta.lastCacheAccessTime;
    }

    public final String getCategory() {
        return this.category;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getDate() {
        return this.date;
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

    public final long getLastCacheAccessTime() {
        return this.lastCacheAccessTime;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getSizeBytes() {
        return this.sizeBytes;
    }

    public final IndexTier getTier() {
        return this.tier;
    }

    public int hashCode() {
        return Long.hashCode(this.lastCacheAccessTime) + a8.b.C(this.sizeBytes, (this.tier.hashCode() + a8.b.e(a8.b.C(this.hitCount, a8.b.e(a8.b.f(a8.b.f(a8.b.C(this.length, this.docId.hashCode() * 31, 31), 31, this.date), 31, this.category), 31, this.createdAt), 31), 31, this.lastAccessedAt)) * 31, 31);
    }

    public String toString() {
        String str = this.docId;
        int i8 = this.length;
        String str2 = this.date;
        String str3 = this.category;
        long j4 = this.createdAt;
        int i9 = this.hitCount;
        long j8 = this.lastAccessedAt;
        IndexTier indexTier = this.tier;
        int i10 = this.sizeBytes;
        long j9 = this.lastCacheAccessTime;
        StringBuilder sbU = a8.b.u("DocMeta(docId=", i8, str, ", length=", ", date=");
        a8.b.A(sbU, str2, ", category=", str3, ", createdAt=");
        sbU.append(j4);
        sbU.append(", hitCount=");
        sbU.append(i9);
        sbU.append(", lastAccessedAt=");
        sbU.append(j8);
        sbU.append(", tier=");
        sbU.append(indexTier);
        sbU.append(", sizeBytes=");
        sbU.append(i10);
        sbU.append(", lastCacheAccessTime=");
        return a8.b.r(sbU, j9, ")");
    }

    public /* synthetic */ DocMeta(String str, int i8, String str2, String str3, long j4, int i9, long j8, IndexTier indexTier, int i10, long j9, int i11, kotlin.jvm.internal.i iVar) {
        this(str, i8, str2, (i11 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i11 & 16) != 0 ? 0L : j4, (i11 & 32) != 0 ? 0 : i9, (i11 & 64) != 0 ? 0L : j8, (i11 & 128) != 0 ? IndexTier.DYNAMIC : indexTier, (i11 & 256) != 0 ? 0 : i10, (i11 & 512) != 0 ? System.currentTimeMillis() : j9);
    }
}
