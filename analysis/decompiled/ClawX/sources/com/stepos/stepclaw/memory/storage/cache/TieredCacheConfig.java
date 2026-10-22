package com.stepos.stepclaw.memory.storage.cache;

import a8.b;
import c5.l;
import com.stepos.stepclaw.SecurePrefs;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010¨\u0006'"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "permanentMaxSizeBytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "permanentCategories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "dynamicMaxSizeBytes", "dynamicDefaultLoadDays", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "enableLruEviction", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "minRetainDays", "<init>", "(JLjava/util/Set;JIZI)V", "getPermanentMaxSizeBytes", "()J", "getPermanentCategories", "()Ljava/util/Set;", "getDynamicMaxSizeBytes", "getDynamicDefaultLoadDays", "()I", "getEnableLruEviction", "()Z", "getMinRetainDays", "totalMaxSizeBytes", "getTotalMaxSizeBytes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TieredCacheConfig {
    private final int dynamicDefaultLoadDays;
    private final long dynamicMaxSizeBytes;
    private final boolean enableLruEviction;
    private final int minRetainDays;
    private final Set<String> permanentCategories;
    private final long permanentMaxSizeBytes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TieredCacheConfig DEFAULT = new TieredCacheConfig(0, null, 0, 0, false, 0, 63, null);
    private static final TieredCacheConfig LIGHT = new TieredCacheConfig(3145728, null, 5242880, 3, false, 0, 50, null);
    private static final TieredCacheConfig FULL = new TieredCacheConfig(8388608, null, 15728640, 14, false, 0, 50, null);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "DEFAULT", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "getDEFAULT", "()Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "LIGHT", "getLIGHT", "FULL", "getFULL", "DATE_FORMAT", "Ljava/text/SimpleDateFormat;", "getDATE_FORMAT", "()Ljava/text/SimpleDateFormat;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SimpleDateFormat getDATE_FORMAT() {
            return TieredCacheConfig.DATE_FORMAT;
        }

        public final TieredCacheConfig getDEFAULT() {
            return TieredCacheConfig.DEFAULT;
        }

        public final TieredCacheConfig getFULL() {
            return TieredCacheConfig.FULL;
        }

        public final TieredCacheConfig getLIGHT() {
            return TieredCacheConfig.LIGHT;
        }

        private Companion() {
        }
    }

    public TieredCacheConfig() {
        this(0L, null, 0L, 0, false, 0, 63, null);
    }

    public static /* synthetic */ TieredCacheConfig copy$default(TieredCacheConfig tieredCacheConfig, long j4, Set set, long j8, int i8, boolean z, int i9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j4 = tieredCacheConfig.permanentMaxSizeBytes;
        }
        long j9 = j4;
        if ((i10 & 2) != 0) {
            set = tieredCacheConfig.permanentCategories;
        }
        Set set2 = set;
        if ((i10 & 4) != 0) {
            j8 = tieredCacheConfig.dynamicMaxSizeBytes;
        }
        long j10 = j8;
        if ((i10 & 8) != 0) {
            i8 = tieredCacheConfig.dynamicDefaultLoadDays;
        }
        return tieredCacheConfig.copy(j9, set2, j10, i8, (i10 & 16) != 0 ? tieredCacheConfig.enableLruEviction : z, (i10 & 32) != 0 ? tieredCacheConfig.minRetainDays : i9);
    }

    /* renamed from: component1, reason: from getter */
    public final long getPermanentMaxSizeBytes() {
        return this.permanentMaxSizeBytes;
    }

    public final Set<String> component2() {
        return this.permanentCategories;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDynamicMaxSizeBytes() {
        return this.dynamicMaxSizeBytes;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDynamicDefaultLoadDays() {
        return this.dynamicDefaultLoadDays;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnableLruEviction() {
        return this.enableLruEviction;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMinRetainDays() {
        return this.minRetainDays;
    }

    public final TieredCacheConfig copy(long permanentMaxSizeBytes, Set<String> permanentCategories, long dynamicMaxSizeBytes, int dynamicDefaultLoadDays, boolean enableLruEviction, int minRetainDays) {
        p.e(permanentCategories, "permanentCategories");
        return new TieredCacheConfig(permanentMaxSizeBytes, permanentCategories, dynamicMaxSizeBytes, dynamicDefaultLoadDays, enableLruEviction, minRetainDays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TieredCacheConfig)) {
            return false;
        }
        TieredCacheConfig tieredCacheConfig = (TieredCacheConfig) other;
        return this.permanentMaxSizeBytes == tieredCacheConfig.permanentMaxSizeBytes && p.a(this.permanentCategories, tieredCacheConfig.permanentCategories) && this.dynamicMaxSizeBytes == tieredCacheConfig.dynamicMaxSizeBytes && this.dynamicDefaultLoadDays == tieredCacheConfig.dynamicDefaultLoadDays && this.enableLruEviction == tieredCacheConfig.enableLruEviction && this.minRetainDays == tieredCacheConfig.minRetainDays;
    }

    public final int getDynamicDefaultLoadDays() {
        return this.dynamicDefaultLoadDays;
    }

    public final long getDynamicMaxSizeBytes() {
        return this.dynamicMaxSizeBytes;
    }

    public final boolean getEnableLruEviction() {
        return this.enableLruEviction;
    }

    public final int getMinRetainDays() {
        return this.minRetainDays;
    }

    public final Set<String> getPermanentCategories() {
        return this.permanentCategories;
    }

    public final long getPermanentMaxSizeBytes() {
        return this.permanentMaxSizeBytes;
    }

    public final long getTotalMaxSizeBytes() {
        return this.permanentMaxSizeBytes + this.dynamicMaxSizeBytes;
    }

    public int hashCode() {
        return Integer.hashCode(this.minRetainDays) + b.g(b.C(this.dynamicDefaultLoadDays, b.e((this.permanentCategories.hashCode() + (Long.hashCode(this.permanentMaxSizeBytes) * 31)) * 31, 31, this.dynamicMaxSizeBytes), 31), 31, this.enableLruEviction);
    }

    public String toString() {
        long j4 = this.permanentMaxSizeBytes;
        Set<String> set = this.permanentCategories;
        long j8 = this.dynamicMaxSizeBytes;
        int i8 = this.dynamicDefaultLoadDays;
        boolean z = this.enableLruEviction;
        int i9 = this.minRetainDays;
        StringBuilder sb = new StringBuilder("TieredCacheConfig(permanentMaxSizeBytes=");
        sb.append(j4);
        sb.append(", permanentCategories=");
        sb.append(set);
        sb.append(", dynamicMaxSizeBytes=");
        sb.append(j8);
        sb.append(", dynamicDefaultLoadDays=");
        sb.append(i8);
        sb.append(", enableLruEviction=");
        sb.append(z);
        sb.append(", minRetainDays=");
        return f.e(sb, i9, ")");
    }

    public TieredCacheConfig(long j4, Set<String> permanentCategories, long j8, int i8, boolean z, int i9) {
        p.e(permanentCategories, "permanentCategories");
        this.permanentMaxSizeBytes = j4;
        this.permanentCategories = permanentCategories;
        this.dynamicMaxSizeBytes = j8;
        this.dynamicDefaultLoadDays = i8;
        this.enableLruEviction = z;
        this.minRetainDays = i9;
    }

    public TieredCacheConfig(long j4, Set set, long j8, int i8, boolean z, int i9, int i10, i iVar) {
        this((i10 & 1) != 0 ? 5242880L : j4, (i10 & 2) != 0 ? l.k0(new String[]{"user_profile", "agent_identity"}) : set, (i10 & 4) != 0 ? 10485760L : j8, (i10 & 8) != 0 ? 7 : i8, (i10 & 16) != 0 ? true : z, (i10 & 32) != 0 ? 1 : i9);
    }
}
