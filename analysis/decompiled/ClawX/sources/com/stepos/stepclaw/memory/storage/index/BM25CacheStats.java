package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010.\u001a\u00020\u0007H\u0016J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u009d\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u0016R\u0011\u0010(\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006B"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/BM25CacheStats;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "permanentDocumentCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "permanentSizeBytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "permanentOldestDate", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "permanentNewestDate", "permanentEvictedCount", "permanentHitCount", "permanentMissCount", "dynamicDocumentCount", "dynamicSizeBytes", "dynamicOldestDate", "dynamicNewestDate", "dynamicEvictedCount", "dynamicHitCount", "dynamicMissCount", "<init>", "(IJLjava/lang/String;Ljava/lang/String;IJJIJLjava/lang/String;Ljava/lang/String;IJJ)V", "getPermanentDocumentCount", "()I", "getPermanentSizeBytes", "()J", "getPermanentOldestDate", "()Ljava/lang/String;", "getPermanentNewestDate", "getPermanentEvictedCount", "getPermanentHitCount", "getPermanentMissCount", "getDynamicDocumentCount", "getDynamicSizeBytes", "getDynamicOldestDate", "getDynamicNewestDate", "getDynamicEvictedCount", "getDynamicHitCount", "getDynamicMissCount", "totalDocumentCount", "getTotalDocumentCount", "totalSizeBytes", "getTotalSizeBytes", "totalSizeInMB", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getTotalSizeInMB", "()D", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BM25CacheStats {

    /* renamed from: dynamicDocumentCount, reason: from kotlin metadata and from toString */
    private final int dynamic;
    private final int dynamicEvictedCount;
    private final long dynamicHitCount;
    private final long dynamicMissCount;
    private final String dynamicNewestDate;
    private final String dynamicOldestDate;
    private final long dynamicSizeBytes;

    /* renamed from: permanentDocumentCount, reason: from kotlin metadata and from toString */
    private final int permanent;
    private final int permanentEvictedCount;
    private final long permanentHitCount;
    private final long permanentMissCount;
    private final String permanentNewestDate;
    private final String permanentOldestDate;
    private final long permanentSizeBytes;

    public BM25CacheStats(int i8, long j4, String str, String str2, int i9, long j8, long j9, int i10, long j10, String str3, String str4, int i11, long j11, long j12) {
        this.permanent = i8;
        this.permanentSizeBytes = j4;
        this.permanentOldestDate = str;
        this.permanentNewestDate = str2;
        this.permanentEvictedCount = i9;
        this.permanentHitCount = j8;
        this.permanentMissCount = j9;
        this.dynamic = i10;
        this.dynamicSizeBytes = j10;
        this.dynamicOldestDate = str3;
        this.dynamicNewestDate = str4;
        this.dynamicEvictedCount = i11;
        this.dynamicHitCount = j11;
        this.dynamicMissCount = j12;
    }

    public static /* synthetic */ BM25CacheStats copy$default(BM25CacheStats bM25CacheStats, int i8, long j4, String str, String str2, int i9, long j8, long j9, int i10, long j10, String str3, String str4, int i11, long j11, long j12, int i12, Object obj) {
        long j13;
        long j14;
        int i13 = (i12 & 1) != 0 ? bM25CacheStats.permanent : i8;
        long j15 = (i12 & 2) != 0 ? bM25CacheStats.permanentSizeBytes : j4;
        String str5 = (i12 & 4) != 0 ? bM25CacheStats.permanentOldestDate : str;
        String str6 = (i12 & 8) != 0 ? bM25CacheStats.permanentNewestDate : str2;
        int i14 = (i12 & 16) != 0 ? bM25CacheStats.permanentEvictedCount : i9;
        long j16 = (i12 & 32) != 0 ? bM25CacheStats.permanentHitCount : j8;
        long j17 = (i12 & 64) != 0 ? bM25CacheStats.permanentMissCount : j9;
        int i15 = (i12 & 128) != 0 ? bM25CacheStats.dynamic : i10;
        long j18 = (i12 & 256) != 0 ? bM25CacheStats.dynamicSizeBytes : j10;
        String str7 = (i12 & 512) != 0 ? bM25CacheStats.dynamicOldestDate : str3;
        int i16 = i13;
        String str8 = (i12 & 1024) != 0 ? bM25CacheStats.dynamicNewestDate : str4;
        int i17 = (i12 & 2048) != 0 ? bM25CacheStats.dynamicEvictedCount : i11;
        long j19 = j15;
        long j20 = (i12 & 4096) != 0 ? bM25CacheStats.dynamicHitCount : j11;
        if ((i12 & 8192) != 0) {
            j14 = j20;
            j13 = bM25CacheStats.dynamicMissCount;
        } else {
            j13 = j12;
            j14 = j20;
        }
        return bM25CacheStats.copy(i16, j19, str5, str6, i14, j16, j17, i15, j18, str7, str8, i17, j14, j13);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPermanent() {
        return this.permanent;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDynamicOldestDate() {
        return this.dynamicOldestDate;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDynamicNewestDate() {
        return this.dynamicNewestDate;
    }

    /* renamed from: component12, reason: from getter */
    public final int getDynamicEvictedCount() {
        return this.dynamicEvictedCount;
    }

    /* renamed from: component13, reason: from getter */
    public final long getDynamicHitCount() {
        return this.dynamicHitCount;
    }

    /* renamed from: component14, reason: from getter */
    public final long getDynamicMissCount() {
        return this.dynamicMissCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPermanentSizeBytes() {
        return this.permanentSizeBytes;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPermanentOldestDate() {
        return this.permanentOldestDate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPermanentNewestDate() {
        return this.permanentNewestDate;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPermanentEvictedCount() {
        return this.permanentEvictedCount;
    }

    /* renamed from: component6, reason: from getter */
    public final long getPermanentHitCount() {
        return this.permanentHitCount;
    }

    /* renamed from: component7, reason: from getter */
    public final long getPermanentMissCount() {
        return this.permanentMissCount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getDynamic() {
        return this.dynamic;
    }

    /* renamed from: component9, reason: from getter */
    public final long getDynamicSizeBytes() {
        return this.dynamicSizeBytes;
    }

    public final BM25CacheStats copy(int permanentDocumentCount, long permanentSizeBytes, String permanentOldestDate, String permanentNewestDate, int permanentEvictedCount, long permanentHitCount, long permanentMissCount, int dynamicDocumentCount, long dynamicSizeBytes, String dynamicOldestDate, String dynamicNewestDate, int dynamicEvictedCount, long dynamicHitCount, long dynamicMissCount) {
        return new BM25CacheStats(permanentDocumentCount, permanentSizeBytes, permanentOldestDate, permanentNewestDate, permanentEvictedCount, permanentHitCount, permanentMissCount, dynamicDocumentCount, dynamicSizeBytes, dynamicOldestDate, dynamicNewestDate, dynamicEvictedCount, dynamicHitCount, dynamicMissCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BM25CacheStats)) {
            return false;
        }
        BM25CacheStats bM25CacheStats = (BM25CacheStats) other;
        return this.permanent == bM25CacheStats.permanent && this.permanentSizeBytes == bM25CacheStats.permanentSizeBytes && kotlin.jvm.internal.p.a(this.permanentOldestDate, bM25CacheStats.permanentOldestDate) && kotlin.jvm.internal.p.a(this.permanentNewestDate, bM25CacheStats.permanentNewestDate) && this.permanentEvictedCount == bM25CacheStats.permanentEvictedCount && this.permanentHitCount == bM25CacheStats.permanentHitCount && this.permanentMissCount == bM25CacheStats.permanentMissCount && this.dynamic == bM25CacheStats.dynamic && this.dynamicSizeBytes == bM25CacheStats.dynamicSizeBytes && kotlin.jvm.internal.p.a(this.dynamicOldestDate, bM25CacheStats.dynamicOldestDate) && kotlin.jvm.internal.p.a(this.dynamicNewestDate, bM25CacheStats.dynamicNewestDate) && this.dynamicEvictedCount == bM25CacheStats.dynamicEvictedCount && this.dynamicHitCount == bM25CacheStats.dynamicHitCount && this.dynamicMissCount == bM25CacheStats.dynamicMissCount;
    }

    public final int getDynamicDocumentCount() {
        return this.dynamic;
    }

    public final int getDynamicEvictedCount() {
        return this.dynamicEvictedCount;
    }

    public final long getDynamicHitCount() {
        return this.dynamicHitCount;
    }

    public final long getDynamicMissCount() {
        return this.dynamicMissCount;
    }

    public final String getDynamicNewestDate() {
        return this.dynamicNewestDate;
    }

    public final String getDynamicOldestDate() {
        return this.dynamicOldestDate;
    }

    public final long getDynamicSizeBytes() {
        return this.dynamicSizeBytes;
    }

    public final int getPermanentDocumentCount() {
        return this.permanent;
    }

    public final int getPermanentEvictedCount() {
        return this.permanentEvictedCount;
    }

    public final long getPermanentHitCount() {
        return this.permanentHitCount;
    }

    public final long getPermanentMissCount() {
        return this.permanentMissCount;
    }

    public final String getPermanentNewestDate() {
        return this.permanentNewestDate;
    }

    public final String getPermanentOldestDate() {
        return this.permanentOldestDate;
    }

    public final long getPermanentSizeBytes() {
        return this.permanentSizeBytes;
    }

    public final int getTotalDocumentCount() {
        return this.permanent + this.dynamic;
    }

    public final long getTotalSizeBytes() {
        return this.permanentSizeBytes + this.dynamicSizeBytes;
    }

    public final double getTotalSizeInMB() {
        return getTotalSizeBytes() / 1048576.0d;
    }

    public int hashCode() {
        int iE = a8.b.e(Integer.hashCode(this.permanent) * 31, 31, this.permanentSizeBytes);
        String str = this.permanentOldestDate;
        int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.permanentNewestDate;
        int iE2 = a8.b.e(a8.b.C(this.dynamic, a8.b.e(a8.b.e(a8.b.C(this.permanentEvictedCount, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31, this.permanentHitCount), 31, this.permanentMissCount), 31), 31, this.dynamicSizeBytes);
        String str3 = this.dynamicOldestDate;
        int iHashCode2 = (iE2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.dynamicNewestDate;
        return Long.hashCode(this.dynamicMissCount) + a8.b.e(a8.b.C(this.dynamicEvictedCount, (iHashCode2 + (str4 != null ? str4.hashCode() : 0)) * 31, 31), 31, this.dynamicHitCount);
    }

    public String toString() {
        return "CacheStats(total=" + getTotalDocumentCount() + "docs/" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(getTotalSizeInMB())}, 1)) + "MB, permanent=" + this.permanent + "/" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf((this.permanentSizeBytes / 1024.0d) / 1024.0d)}, 1)) + "MB, dynamic=" + this.dynamic + "/" + String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf((this.dynamicSizeBytes / 1024.0d) / 1024.0d)}, 1)) + "MB)";
    }
}
