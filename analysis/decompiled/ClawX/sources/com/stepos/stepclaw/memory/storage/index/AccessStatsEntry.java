package com.stepos.stepclaw.memory.storage.index;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/AccessStatsEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hitCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "lastAccessedAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(IJ)V", "getHitCount", "()I", "getLastAccessedAt", "()J", "component1", "component2", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AccessStatsEntry {
    private final int hitCount;
    private final long lastAccessedAt;

    public AccessStatsEntry() {
        this(0, 0L, 3, null);
    }

    public static /* synthetic */ AccessStatsEntry copy$default(AccessStatsEntry accessStatsEntry, int i8, long j4, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = accessStatsEntry.hitCount;
        }
        if ((i9 & 2) != 0) {
            j4 = accessStatsEntry.lastAccessedAt;
        }
        return accessStatsEntry.copy(i8, j4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHitCount() {
        return this.hitCount;
    }

    /* renamed from: component2, reason: from getter */
    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    public final AccessStatsEntry copy(int hitCount, long lastAccessedAt) {
        return new AccessStatsEntry(hitCount, lastAccessedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AccessStatsEntry)) {
            return false;
        }
        AccessStatsEntry accessStatsEntry = (AccessStatsEntry) other;
        return this.hitCount == accessStatsEntry.hitCount && this.lastAccessedAt == accessStatsEntry.lastAccessedAt;
    }

    public final int getHitCount() {
        return this.hitCount;
    }

    public final long getLastAccessedAt() {
        return this.lastAccessedAt;
    }

    public int hashCode() {
        return Long.hashCode(this.lastAccessedAt) + (Integer.hashCode(this.hitCount) * 31);
    }

    public String toString() {
        return "AccessStatsEntry(hitCount=" + this.hitCount + ", lastAccessedAt=" + this.lastAccessedAt + ")";
    }

    public AccessStatsEntry(int i8, long j4) {
        this.hitCount = i8;
        this.lastAccessedAt = j4;
    }

    public /* synthetic */ AccessStatsEntry(int i8, long j4, int i9, kotlin.jvm.internal.i iVar) {
        this((i9 & 1) != 0 ? 0 : i8, (i9 & 2) != 0 ? 0L : j4);
    }
}
