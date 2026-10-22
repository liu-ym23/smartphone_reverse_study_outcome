package com.stepos.stepclaw.memory.storage.index;

import c5.s;
import c5.u;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.cache.TieredCacheConfig;
import com.stepos.stepclaw.memory.storage.index.BM25Index;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0012\n\u0002\u0010\u0006\n\u0002\b\u0006\u0018\u0000 \u0088\u00012\u00020\u0001:\u0004\u0088\u0001\u0089\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0004\b\u0010\u0010\u0011JC\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020\u0015¢\u0006\u0004\b$\u0010%JM\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\u001e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0*¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b4\u0010\u001dJ\u0017\u00106\u001a\u0004\u0018\u0001052\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\b\u0012\u0004\u0012\u00020\n0*¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\b\u0012\u0004\u0012\u00020\n0*2\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b:\u0010;J'\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0*2\b\u0010(\u001a\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020\u001b¢\u0006\u0004\b>\u0010?J'\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020B0A2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0*¢\u0006\u0004\bC\u0010DJ\r\u0010F\u001a\u00020E¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020E¢\u0006\u0004\bI\u0010JJ#\u0010N\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\n2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020L0,¢\u0006\u0004\bN\u0010OJ]\u0010S\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010Q\u001a\u00020\u001e2\b\b\u0002\u0010R\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020\u0015¢\u0006\u0004\bU\u0010VJ\r\u0010W\u001a\u00020\u0018¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\u0018¢\u0006\u0004\bY\u0010XJ\u0015\u0010Z\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\bZ\u0010[J\u0015\u0010\\\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\\\u0010]J\u0015\u0010^\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b^\u00103J\r\u0010`\u001a\u00020_¢\u0006\u0004\b`\u0010aJ\u0013\u0010c\u001a\b\u0012\u0004\u0012\u00020b0,¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\nH\u0002¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u00020\u0018H\u0002¢\u0006\u0004\bg\u0010XJ\u0017\u0010h\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\bh\u0010\u001dJ\u000f\u0010i\u001a\u00020\u001bH\u0002¢\u0006\u0004\bi\u0010?R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010jR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010kR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010lR&\u0010o\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0n0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR&\u0010r\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0q0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010pR \u0010s\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002050m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010pR \u0010t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010pR\u0016\u0010u\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010w\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010vR\u0016\u0010x\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010yR\u0016\u0010{\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010vR\u0016\u0010|\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010vR\u0016\u0010}\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010vR\u0016\u0010~\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010vR\u0019\u0010\u007f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u0013\u0010\u0083\u0001\u001a\u00020\u001e8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\"R\u0015\u0010\u0087\u0001\u001a\u00030\u0084\u00018F¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u008a\u0001"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/BM25Index;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/BM25Config;", "config", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "cacheConfig", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Lcom/stepos/stepclaw/memory/storage/index/BM25Config;Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "Lcom/stepos/stepclaw/memory/storage/index/IndexTier;", "getTierForCategory", "(Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/index/IndexTier;", "Lb5/g;", "getDynamicDateRange", "()Lb5/g;", "docId", "content", "date", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAt", "tier", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "indexDocument", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/stepos/stepclaw/memory/storage/index/IndexTier;)Z", "Lb5/a0;", "removeDocument", "(Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "evictDynamicBeforeDate", "(Ljava/lang/String;)I", "unloadDynamic", "()I", "targetSizeBytes", "compactDynamic", "(J)I", "query", "topK", "dateFrom", "dateTo", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/SearchResult;", "search", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Set;)Ljava/util/List;", "getDocument", "(Ljava/lang/String;)Ljava/lang/String;", "contains", "(Ljava/lang/String;)Z", "recordAccess", "Lcom/stepos/stepclaw/memory/storage/index/DocMeta;", "getDocMeta", "(Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/index/DocMeta;", "getAllDocIds", "()Ljava/util/Set;", "getDocIdsByTier", "(Lcom/stepos/stepclaw/memory/storage/index/IndexTier;)Ljava/util/Set;", "getDocIdsByDateRange", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;", "clear", "()V", "partitionKeys", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/storage/index/AccessStatsEntry;", "exportAccessStats", "(Ljava/util/Set;)Ljava/util/Map;", "Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;", "exportIndex", "()Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;", "snapshot", "importIndex", "(Lcom/stepos/stepclaw/memory/storage/index/IndexSnapshot;)V", "term", "Lcom/stepos/stepclaw/memory/storage/index/Posting;", "postings", "importPostings", "(Ljava/lang/String;Ljava/util/List;)V", "length", "hitCount", "lastAccessedAt", "importDocMeta", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JIJLcom/stepos/stepclaw/memory/storage/index/IndexTier;)V", "estimateMemoryUsage", "()J", "isDynamicFull", "()Z", "isPermanentFull", "isTierFull", "(Lcom/stepos/stepclaw/memory/storage/index/IndexTier;)Z", "getAvailableSpace", "(Lcom/stepos/stepclaw/memory/storage/index/IndexTier;)J", "isDynamicDateLoaded", "Lcom/stepos/stepclaw/memory/storage/index/BM25CacheStats;", "getCacheStats", "()Lcom/stepos/stepclaw/memory/storage/index/BM25CacheStats;", "Lcom/stepos/stepclaw/memory/storage/index/BM25Index$CategoryDateStats;", "categoryDateStats", "()Ljava/util/List;", "getMinRetainDate", "()Ljava/lang/String;", "evictOneDynamic", "updateDynamicDateRange", "recalculateTierSizes", "Lcom/stepos/stepclaw/memory/storage/index/BM25Config;", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "invertedIndex", "Ljava/util/Map;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docTerms", "docMetas", "docContents", "permanentSizeBytes", "J", "dynamicSizeBytes", "permanentEvictedCount", "I", "dynamicEvictedCount", "permanentHitCount", "permanentMissCount", "dynamicHitCount", "dynamicMissCount", "dynamicLoadedDateFrom", "Ljava/lang/String;", "dynamicLoadedDateTo", "getDocumentCount", "documentCount", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getAverageDocLength", "()D", "averageDocLength", "Companion", "CategoryDateStats", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BM25Index {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "BM25Index";
    private final TieredCacheConfig cacheConfig;
    private final BM25Config config;
    private final Map<String, String> docContents;
    private final Map<String, DocMeta> docMetas;
    private final Map<String, Set<String>> docTerms;
    private int dynamicEvictedCount;
    private long dynamicHitCount;
    private String dynamicLoadedDateFrom;
    private String dynamicLoadedDateTo;
    private long dynamicMissCount;
    private long dynamicSizeBytes;
    private final Map<String, List<Posting>> invertedIndex;
    private final MemoryLogger logger;
    private int permanentEvictedCount;
    private long permanentHitCount;
    private long permanentMissCount;
    private long permanentSizeBytes;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/BM25Index$CategoryDateStats;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "entries", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sizeBytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;IJ)V", "getKey", "()Ljava/lang/String;", "getEntries", "()I", "getSizeBytes", "()J", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CategoryDateStats {
        private final int entries;
        private final String key;
        private final long sizeBytes;

        public CategoryDateStats(String key, int i8, long j4) {
            kotlin.jvm.internal.p.e(key, "key");
            this.key = key;
            this.entries = i8;
            this.sizeBytes = j4;
        }

        public static /* synthetic */ CategoryDateStats copy$default(CategoryDateStats categoryDateStats, String str, int i8, long j4, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                str = categoryDateStats.key;
            }
            if ((i9 & 2) != 0) {
                i8 = categoryDateStats.entries;
            }
            if ((i9 & 4) != 0) {
                j4 = categoryDateStats.sizeBytes;
            }
            return categoryDateStats.copy(str, i8, j4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEntries() {
            return this.entries;
        }

        /* renamed from: component3, reason: from getter */
        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public final CategoryDateStats copy(String key, int entries, long sizeBytes) {
            kotlin.jvm.internal.p.e(key, "key");
            return new CategoryDateStats(key, entries, sizeBytes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CategoryDateStats)) {
                return false;
            }
            CategoryDateStats categoryDateStats = (CategoryDateStats) other;
            return kotlin.jvm.internal.p.a(this.key, categoryDateStats.key) && this.entries == categoryDateStats.entries && this.sizeBytes == categoryDateStats.sizeBytes;
        }

        public final int getEntries() {
            return this.entries;
        }

        public final String getKey() {
            return this.key;
        }

        public final long getSizeBytes() {
            return this.sizeBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.sizeBytes) + a8.b.C(this.entries, this.key.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.key;
            int i8 = this.entries;
            return a8.b.r(a8.b.u("CategoryDateStats(key=", i8, str, ", entries=", ", sizeBytes="), this.sizeBytes, ")");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J(\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/BM25Index$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "estimateStringSize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "s", "estimateDocumentSize", "docId", "content", "date", "category", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int estimateDocumentSize(String docId, String content, String date, String category) {
            return estimateStringSize(docId) + estimateStringSize(content) + estimateStringSize(date) + estimateStringSize(category) + 96;
        }

        private final int estimateStringSize(String s8) {
            return (s8.length() * 2) + 40;
        }

        private Companion() {
        }
    }

    public BM25Index() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ int compactDynamic$default(BM25Index bM25Index, long j4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j4 = (long) (bM25Index.cacheConfig.getDynamicMaxSizeBytes() * 0.8d);
        }
        return bM25Index.compactDynamic(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String compactDynamic$lambda$0(w wVar, BM25Index bM25Index) {
        return "Compacted DYNAMIC: evicted " + wVar.f3684a + ", size now " + (bM25Index.dynamicSizeBytes / 1024) + "KB";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String evictDynamicBeforeDate$lambda$2(w wVar, String str) {
        return "Evicted " + wVar.f3684a + " DYNAMIC documents before " + str;
    }

    private final boolean evictOneDynamic() {
        DocMeta docMeta;
        Object next;
        Collection<DocMeta> collectionValues = this.docMetas.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((DocMeta) obj).getTier() == IndexTier.DYNAMIC) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        String minRetainDate = getMinRetainDate();
        Object next2 = null;
        if (this.cacheConfig.getEnableLruEviction()) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj2 = arrayList.get(i8);
                i8++;
                if (((DocMeta) obj2).getDate().compareTo(minRetainDate) < 0) {
                    arrayList2.add(obj2);
                }
            }
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long lastCacheAccessTime = ((DocMeta) next).getLastCacheAccessTime();
                    do {
                        Object next3 = it.next();
                        long lastCacheAccessTime2 = ((DocMeta) next3).getLastCacheAccessTime();
                        if (lastCacheAccessTime > lastCacheAccessTime2) {
                            next = next3;
                            lastCacheAccessTime = lastCacheAccessTime2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            docMeta = (DocMeta) next;
            if (docMeta == null) {
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    next2 = it2.next();
                    if (it2.hasNext()) {
                        long lastCacheAccessTime3 = ((DocMeta) next2).getLastCacheAccessTime();
                        do {
                            Object next4 = it2.next();
                            long lastCacheAccessTime4 = ((DocMeta) next4).getLastCacheAccessTime();
                            if (lastCacheAccessTime3 > lastCacheAccessTime4) {
                                next2 = next4;
                                lastCacheAccessTime3 = lastCacheAccessTime4;
                            }
                        } while (it2.hasNext());
                    }
                }
                docMeta = (DocMeta) next2;
            }
        } else {
            int size2 = arrayList.size();
            int i9 = 0;
            while (true) {
                if (i9 >= size2) {
                    break;
                }
                Object obj3 = arrayList.get(i9);
                i9++;
                if (((DocMeta) obj3).getDate().compareTo(minRetainDate) < 0) {
                    next2 = obj3;
                    break;
                }
            }
            docMeta = (DocMeta) next2;
            if (docMeta == null) {
                docMeta = (DocMeta) c5.m.v0(arrayList);
            }
        }
        if (docMeta == null) {
            return false;
        }
        removeDocument(docMeta.getDocId());
        this.dynamicEvictedCount++;
        MemoryLogger.logD$default(this.logger, TAG, null, new a(0, docMeta), 2, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String evictOneDynamic$lambda$5(DocMeta docMeta) {
        return a8.b.p("Evicted DYNAMIC: ", docMeta.getDocId(), ", date=", docMeta.getDate());
    }

    private final String getMinRetainDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -(this.cacheConfig.getMinRetainDays() - 1));
        String str = TieredCacheConfig.INSTANCE.getDATE_FORMAT().format(calendar.getTime());
        kotlin.jvm.internal.p.d(str, "format(...)");
        return str;
    }

    public static /* synthetic */ void importDocMeta$default(BM25Index bM25Index, String str, int i8, String str2, String str3, String str4, long j4, int i9, long j8, IndexTier indexTier, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            j4 = 0;
        }
        if ((i10 & 64) != 0) {
            i9 = 0;
        }
        if ((i10 & 128) != 0) {
            j8 = 0;
        }
        if ((i10 & 256) != 0) {
            indexTier = bM25Index.getTierForCategory(str3);
        }
        bM25Index.importDocMeta(str, i8, str2, str3, str4, j4, i9, j8, indexTier);
    }

    public static /* synthetic */ boolean indexDocument$default(BM25Index bM25Index, String str, String str2, String str3, String str4, long j4, IndexTier indexTier, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            str4 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String str5 = str4;
        if ((i8 & 16) != 0) {
            j4 = System.currentTimeMillis();
        }
        return bM25Index.indexDocument(str, str2, str3, str5, j4, (i8 & 32) != 0 ? bM25Index.getTierForCategory(str5) : indexTier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexDocument$lambda$0(IndexTier indexTier, String str, int i8) {
        return "Document too large for " + indexTier + ": " + str + ", size=" + i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexDocument$lambda$1(String str) {
        return m0.f.c("Cannot evict enough space in DYNAMIC for: ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexDocument$lambda$2(String str) {
        return m0.f.c("PERMANENT cache full, cannot add: ", str);
    }

    private final void recalculateTierSizes() {
        this.permanentSizeBytes = 0L;
        this.dynamicSizeBytes = 0L;
        Iterator<DocMeta> it = this.docMetas.values().iterator();
        while (it.hasNext()) {
            if (it.next().getTier() == IndexTier.PERMANENT) {
                this.permanentSizeBytes += r1.getSizeBytes();
            } else {
                this.dynamicSizeBytes += r1.getSizeBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeDocument$lambda$0(String str, Posting it) {
        kotlin.jvm.internal.p.e(it, "it");
        return kotlin.jvm.internal.p.a(it.getDocId(), str);
    }

    public static /* synthetic */ List search$default(BM25Index bM25Index, String str, int i8, String str2, String str3, Set set, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 10;
        }
        int i10 = i8;
        String str4 = (i9 & 4) != 0 ? null : str2;
        String str5 = (i9 & 8) != 0 ? null : str3;
        if ((i9 & 16) != 0) {
            set = u.f1094a;
        }
        return bM25Index.search(str, i10, str4, str5, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String unloadDynamic$lambda$2(w wVar) {
        return a8.b.k(wVar.f3684a, "Unloaded ", " DYNAMIC documents");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateDynamicDateRange(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = r1.dynamicLoadedDateFrom
            if (r0 == 0) goto Ld
            kotlin.jvm.internal.p.b(r0)
            int r0 = r2.compareTo(r0)
            if (r0 >= 0) goto Lf
        Ld:
            r1.dynamicLoadedDateFrom = r2
        Lf:
            java.lang.String r0 = r1.dynamicLoadedDateTo
            if (r0 == 0) goto L1e
            kotlin.jvm.internal.p.b(r0)
            int r0 = r2.compareTo(r0)
            if (r0 <= 0) goto L1d
            goto L1e
        L1d:
            return
        L1e:
            r1.dynamicLoadedDateTo = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.BM25Index.updateDynamicDateRange(java.lang.String):void");
    }

    public final List<CategoryDateStats> categoryDateStats() {
        Collection<DocMeta> collectionValues = this.docMetas.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collectionValues) {
            DocMeta docMeta = (DocMeta) obj;
            String strO = a8.b.o(docMeta.getCategory(), "/", docMeta.getDate());
            Object arrayList = linkedHashMap.get(strO);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strO, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            long sizeBytes = 0;
            while (list.iterator().hasNext()) {
                sizeBytes += ((DocMeta) r1.next()).getSizeBytes();
            }
            arrayList2.add(new CategoryDateStats(str, size, sizeBytes));
        }
        return c5.m.J0(arrayList2, new Comparator() { // from class: com.stepos.stepclaw.memory.storage.index.BM25Index$categoryDateStats$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l(((BM25Index.CategoryDateStats) t9).getKey(), ((BM25Index.CategoryDateStats) t8).getKey());
            }
        });
    }

    public final void clear() {
        this.invertedIndex.clear();
        this.docTerms.clear();
        this.docMetas.clear();
        this.docContents.clear();
        this.permanentSizeBytes = 0L;
        this.dynamicSizeBytes = 0L;
        this.dynamicLoadedDateFrom = null;
        this.dynamicLoadedDateTo = null;
    }

    public final int compactDynamic(long targetSizeBytes) {
        w wVar = new w();
        while (this.dynamicSizeBytes > targetSizeBytes && evictOneDynamic()) {
            wVar.f3684a++;
        }
        if (wVar.f3684a > 0) {
            MemoryLogger.logI$default(this.logger, TAG, null, new d(wVar, 0, this), 2, null);
        }
        return wVar.f3684a;
    }

    public final boolean contains(String docId) {
        kotlin.jvm.internal.p.e(docId, "docId");
        return this.docMetas.containsKey(docId);
    }

    public final long estimateMemoryUsage() {
        long size = this.invertedIndex.size();
        Iterator<T> it = this.invertedIndex.values().iterator();
        int length = 0;
        int size2 = 0;
        while (it.hasNext()) {
            size2 += ((List) it.next()).size();
        }
        long j4 = size2;
        long size3 = this.docMetas.size();
        Iterator<T> it2 = this.docContents.values().iterator();
        while (it2.hasNext()) {
            length += ((String) it2.next()).length();
        }
        return (j4 * 24) + (size * 48) + (size3 * 96) + (length * 2);
    }

    public final int evictDynamicBeforeDate(String date) {
        kotlin.jvm.internal.p.e(date, "date");
        Collection<DocMeta> collectionValues = this.docMetas.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            DocMeta docMeta = (DocMeta) obj;
            if (docMeta.getTier() == IndexTier.DYNAMIC && docMeta.getDate().compareTo(date) < 0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(c5.o.n0(arrayList, 10));
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = arrayList.get(i9);
            i9++;
            arrayList2.add(((DocMeta) obj2).getDocId());
        }
        w wVar = new w();
        int size2 = arrayList2.size();
        while (i8 < size2) {
            Object obj3 = arrayList2.get(i8);
            i8++;
            removeDocument((String) obj3);
            this.dynamicEvictedCount++;
            wVar.f3684a++;
        }
        if (wVar.f3684a > 0) {
            MemoryLogger.logI$default(this.logger, TAG, null, new n(wVar, date, 1), 2, null);
        }
        return wVar.f3684a;
    }

    public final Map<String, AccessStatsEntry> exportAccessStats(Set<String> partitionKeys) {
        kotlin.jvm.internal.p.e(partitionKeys, "partitionKeys");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, DocMeta> entry : this.docMetas.entrySet()) {
            String key = entry.getKey();
            DocMeta value = entry.getValue();
            if (partitionKeys.contains(x5.n.N1(key, '#'))) {
                linkedHashMap.put(key, new AccessStatsEntry(value.getHitCount(), value.getLastAccessedAt()));
            }
        }
        return linkedHashMap;
    }

    public final IndexSnapshot exportIndex() {
        Map<String, List<Posting>> map = this.invertedIndex;
        LinkedHashMap linkedHashMap = new LinkedHashMap(z.T(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), c5.m.N0((Iterable) entry.getValue()));
        }
        return new IndexSnapshot(linkedHashMap, z.W(this.docMetas), z.W(this.docContents));
    }

    public final Set<String> getAllDocIds() {
        return c5.m.R0(this.docMetas.keySet());
    }

    public final long getAvailableSpace(IndexTier tier) {
        long dynamicMaxSizeBytes;
        long j4;
        kotlin.jvm.internal.p.e(tier, "tier");
        if (tier == IndexTier.PERMANENT) {
            dynamicMaxSizeBytes = this.cacheConfig.getPermanentMaxSizeBytes();
            j4 = this.permanentSizeBytes;
        } else {
            dynamicMaxSizeBytes = this.cacheConfig.getDynamicMaxSizeBytes();
            j4 = this.dynamicSizeBytes;
        }
        return dynamicMaxSizeBytes - j4;
    }

    public final double getAverageDocLength() {
        if (this.docMetas.isEmpty()) {
            return 0.0d;
        }
        Iterator<T> it = this.docMetas.values().iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((DocMeta) it.next()).getLength();
        }
        return length / this.docMetas.size();
    }

    public final BM25CacheStats getCacheStats() {
        Collection<DocMeta> collectionValues = this.docMetas.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((DocMeta) obj).getTier() == IndexTier.PERMANENT) {
                arrayList.add(obj);
            }
        }
        Collection<DocMeta> collectionValues2 = this.docMetas.values();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues2) {
            if (((DocMeta) obj2).getTier() == IndexTier.DYNAMIC) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(c5.o.n0(arrayList, 10));
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj3 = arrayList.get(i9);
            i9++;
            arrayList3.add(((DocMeta) obj3).getDate());
        }
        List listI0 = c5.m.I0(arrayList3);
        ArrayList arrayList4 = new ArrayList(c5.o.n0(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i8 < size2) {
            Object obj4 = arrayList2.get(i8);
            i8++;
            arrayList4.add(((DocMeta) obj4).getDate());
        }
        List listI02 = c5.m.I0(arrayList4);
        return new BM25CacheStats(arrayList.size(), this.permanentSizeBytes, (String) c5.m.v0(listI0), (String) c5.m.C0(listI0), this.permanentEvictedCount, this.permanentHitCount, this.permanentMissCount, arrayList2.size(), this.dynamicSizeBytes, (String) c5.m.v0(listI02), (String) c5.m.C0(listI02), this.dynamicEvictedCount, this.dynamicHitCount, this.dynamicMissCount);
    }

    public final Set<String> getDocIdsByDateRange(String dateFrom, String dateTo) {
        Collection<DocMeta> collectionValues = this.docMetas.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            DocMeta docMeta = (DocMeta) obj;
            if (dateFrom == null || docMeta.getDate().compareTo(dateFrom) >= 0) {
                if (dateTo == null || docMeta.getDate().compareTo(dateTo) <= 0) {
                    arrayList.add(obj);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(c5.o.n0(arrayList, 10));
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            arrayList2.add(((DocMeta) obj2).getDocId());
        }
        return c5.m.R0(arrayList2);
    }

    public final Set<String> getDocIdsByTier(IndexTier tier) {
        kotlin.jvm.internal.p.e(tier, "tier");
        Collection<DocMeta> collectionValues = this.docMetas.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((DocMeta) obj).getTier() == tier) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(c5.o.n0(arrayList, 10));
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            arrayList2.add(((DocMeta) obj2).getDocId());
        }
        return c5.m.R0(arrayList2);
    }

    public final DocMeta getDocMeta(String docId) {
        kotlin.jvm.internal.p.e(docId, "docId");
        return this.docMetas.get(docId);
    }

    public final String getDocument(String docId) {
        DocMeta docMeta;
        kotlin.jvm.internal.p.e(docId, "docId");
        String str = this.docContents.get(docId);
        if (str != null && (docMeta = this.docMetas.get(docId)) != null) {
            this.docMetas.put(docId, docMeta.copy((511 & 1) != 0 ? docMeta.docId : null, (511 & 2) != 0 ? docMeta.length : 0, (511 & 4) != 0 ? docMeta.date : null, (511 & 8) != 0 ? docMeta.category : null, (511 & 16) != 0 ? docMeta.createdAt : 0L, (511 & 32) != 0 ? docMeta.hitCount : 0, (511 & 64) != 0 ? docMeta.lastAccessedAt : 0L, (511 & 128) != 0 ? docMeta.tier : null, (511 & 256) != 0 ? docMeta.sizeBytes : 0, (511 & 512) != 0 ? docMeta.lastCacheAccessTime : System.currentTimeMillis()));
        }
        return str;
    }

    public final int getDocumentCount() {
        return this.docMetas.size();
    }

    public final b5.g getDynamicDateRange() {
        Calendar calendar = Calendar.getInstance();
        TieredCacheConfig.Companion companion = TieredCacheConfig.INSTANCE;
        String str = companion.getDATE_FORMAT().format(calendar.getTime());
        calendar.add(6, -(this.cacheConfig.getDynamicDefaultLoadDays() - 1));
        return new b5.g(companion.getDATE_FORMAT().format(calendar.getTime()), str);
    }

    public final IndexTier getTierForCategory(String category) {
        kotlin.jvm.internal.p.e(category, "category");
        return this.cacheConfig.getPermanentCategories().contains(category) ? IndexTier.PERMANENT : IndexTier.DYNAMIC;
    }

    public final void importDocMeta(String docId, int length, String date, String category, String content, long createdAt, int hitCount, long lastAccessedAt, IndexTier tier) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(date, "date");
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(content, "content");
        kotlin.jvm.internal.p.e(tier, "tier");
        int iEstimateDocumentSize = INSTANCE.estimateDocumentSize(docId, content, date, category);
        this.docMetas.put(docId, new DocMeta(docId, length, date, category, createdAt, hitCount, lastAccessedAt, tier, iEstimateDocumentSize, System.currentTimeMillis()));
        this.docContents.put(docId, content);
        if (tier == IndexTier.PERMANENT) {
            this.permanentSizeBytes += iEstimateDocumentSize;
        } else {
            this.dynamicSizeBytes += iEstimateDocumentSize;
            updateDynamicDateRange(date);
        }
    }

    public final void importIndex(IndexSnapshot snapshot) {
        kotlin.jvm.internal.p.e(snapshot, "snapshot");
        clear();
        for (Map.Entry<String, List<Posting>> entry : snapshot.getInvertedIndex().entrySet()) {
            String key = entry.getKey();
            List<Posting> value = entry.getValue();
            this.invertedIndex.put(key, c5.m.O0(value));
            for (Posting posting : value) {
                Map<String, Set<String>> map = this.docTerms;
                String docId = posting.getDocId();
                Set<String> linkedHashSet = map.get(docId);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>();
                    map.put(docId, linkedHashSet);
                }
                linkedHashSet.add(key);
            }
        }
        this.docMetas.putAll(snapshot.getDocMetas());
        this.docContents.putAll(snapshot.getDocContents());
        recalculateTierSizes();
    }

    public final void importPostings(String term, List<Posting> postings) {
        kotlin.jvm.internal.p.e(term, "term");
        kotlin.jvm.internal.p.e(postings, "postings");
        Map<String, List<Posting>> map = this.invertedIndex;
        List<Posting> arrayList = map.get(term);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            map.put(term, arrayList);
        }
        arrayList.addAll(postings);
        for (Posting posting : postings) {
            Map<String, Set<String>> map2 = this.docTerms;
            String docId = posting.getDocId();
            Set<String> linkedHashSet = map2.get(docId);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet<>();
                map2.put(docId, linkedHashSet);
            }
            linkedHashSet.add(term);
        }
    }

    public final boolean indexDocument(String docId, String content, String date, String category, long createdAt, IndexTier tier) {
        kotlin.jvm.internal.p.e(docId, "docId");
        kotlin.jvm.internal.p.e(content, "content");
        kotlin.jvm.internal.p.e(date, "date");
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(tier, "tier");
        int iEstimateDocumentSize = INSTANCE.estimateDocumentSize(docId, content, date, category);
        long j4 = iEstimateDocumentSize;
        if (j4 > (tier == IndexTier.PERMANENT ? this.cacheConfig.getPermanentMaxSizeBytes() : this.cacheConfig.getDynamicMaxSizeBytes()) / 2) {
            MemoryLogger.logW$default(this.logger, TAG, null, new k(tier, docId, iEstimateDocumentSize), 2, null);
            return false;
        }
        if (this.docMetas.containsKey(docId)) {
            removeDocument(docId);
        }
        if (tier == IndexTier.DYNAMIC) {
            while (this.dynamicSizeBytes + j4 > this.cacheConfig.getDynamicMaxSizeBytes()) {
                if (!evictOneDynamic()) {
                    MemoryLogger.logW$default(this.logger, TAG, null, new h(docId, 1), 2, null);
                    return false;
                }
            }
        } else if (this.permanentSizeBytes + j4 > this.cacheConfig.getPermanentMaxSizeBytes()) {
            MemoryLogger.logW$default(this.logger, TAG, null, new h(docId, 2), 2, null);
            return false;
        }
        Map<String, Integer> mapTermFrequency = Tokenizer.INSTANCE.termFrequency(content, this.config.getTokenizerConfig());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<String, Integer> entry : mapTermFrequency.entrySet()) {
            String key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            Map<String, List<Posting>> map = this.invertedIndex;
            List<Posting> arrayList = map.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(key, arrayList);
            }
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            arrayList.add(new Posting(docId, iIntValue, null, 4, null));
            linkedHashSet2.add(key);
            linkedHashSet = linkedHashSet2;
        }
        this.docTerms.put(docId, linkedHashSet);
        Map<String, DocMeta> map2 = this.docMetas;
        Collection<Integer> collectionValues = mapTermFrequency.values();
        kotlin.jvm.internal.p.e(collectionValues, "<this>");
        Iterator<T> it = collectionValues.iterator();
        int iIntValue2 = 0;
        while (it.hasNext()) {
            iIntValue2 += ((Number) it.next()).intValue();
        }
        map2.put(docId, new DocMeta(docId, iIntValue2, date, category, createdAt, 0, 0L, tier, iEstimateDocumentSize, System.currentTimeMillis(), 96, null));
        this.docContents.put(docId, content);
        if (tier == IndexTier.PERMANENT) {
            this.permanentSizeBytes += j4;
            return true;
        }
        this.dynamicSizeBytes += j4;
        updateDynamicDateRange(date);
        return true;
    }

    public final boolean isDynamicDateLoaded(String date) {
        String str;
        kotlin.jvm.internal.p.e(date, "date");
        String str2 = this.dynamicLoadedDateFrom;
        return str2 != null && (str = this.dynamicLoadedDateTo) != null && date.compareTo(str2) >= 0 && date.compareTo(str) <= 0;
    }

    public final boolean isDynamicFull() {
        return ((double) this.dynamicSizeBytes) >= ((double) this.cacheConfig.getDynamicMaxSizeBytes()) * 0.95d;
    }

    public final boolean isPermanentFull() {
        return ((double) this.permanentSizeBytes) >= ((double) this.cacheConfig.getPermanentMaxSizeBytes()) * 0.95d;
    }

    public final boolean isTierFull(IndexTier tier) {
        kotlin.jvm.internal.p.e(tier, "tier");
        return tier == IndexTier.PERMANENT ? isPermanentFull() : isDynamicFull();
    }

    public final void recordAccess(String docId) {
        kotlin.jvm.internal.p.e(docId, "docId");
        DocMeta docMeta = this.docMetas.get(docId);
        if (docMeta == null) {
            return;
        }
        this.docMetas.put(docId, docMeta.copy((511 & 1) != 0 ? docMeta.docId : null, (511 & 2) != 0 ? docMeta.length : 0, (511 & 4) != 0 ? docMeta.date : null, (511 & 8) != 0 ? docMeta.category : null, (511 & 16) != 0 ? docMeta.createdAt : 0L, (511 & 32) != 0 ? docMeta.hitCount : docMeta.getHitCount() + 1, (511 & 64) != 0 ? docMeta.lastAccessedAt : System.currentTimeMillis(), (511 & 128) != 0 ? docMeta.tier : null, (511 & 256) != 0 ? docMeta.sizeBytes : 0, (511 & 512) != 0 ? docMeta.lastCacheAccessTime : 0L));
    }

    public final void removeDocument(final String docId) {
        kotlin.jvm.internal.p.e(docId, "docId");
        DocMeta docMeta = this.docMetas.get(docId);
        if (docMeta == null) {
            return;
        }
        Set<String> setRemove = this.docTerms.remove(docId);
        if (setRemove != null) {
            for (String str : setRemove) {
                List<Posting> list = this.invertedIndex.get(str);
                if (list != null) {
                    c5.m.G0(list, new p5.l() { // from class: com.stepos.stepclaw.memory.storage.index.c
                        @Override // p5.l
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(BM25Index.removeDocument$lambda$0(docId, (Posting) obj));
                        }
                    });
                    if (list.isEmpty()) {
                        this.invertedIndex.remove(str);
                    }
                }
            }
        }
        if (docMeta.getTier() == IndexTier.PERMANENT) {
            this.permanentSizeBytes -= docMeta.getSizeBytes();
        } else {
            this.dynamicSizeBytes -= docMeta.getSizeBytes();
        }
        this.docMetas.remove(docId);
        this.docContents.remove(docId);
    }

    public final List<SearchResult> search(String query, int topK, String dateFrom, String dateTo, Set<String> categories) {
        DocMeta docMeta;
        kotlin.jvm.internal.p.e(query, "query");
        kotlin.jvm.internal.p.e(categories, "categories");
        if (!this.docMetas.isEmpty()) {
            Set<String> setExtractTerms = Tokenizer.INSTANCE.extractTerms(query, this.config.getTokenizerConfig());
            if (!setExtractTerms.isEmpty()) {
                Collection<DocMeta> collectionValues = this.docMetas.values();
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    DocMeta docMeta2 = (DocMeta) obj;
                    boolean z = (dateFrom == null || docMeta2.getDate().compareTo(dateFrom) >= 0) && (dateTo == null || docMeta2.getDate().compareTo(dateTo) <= 0);
                    boolean z2 = categories.isEmpty() || categories.contains(docMeta2.getCategory());
                    if (z && z2) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(c5.o.n0(arrayList, 10));
                int size = arrayList.size();
                int i8 = 0;
                while (i8 < size) {
                    Object obj2 = arrayList.get(i8);
                    i8++;
                    arrayList2.add(((DocMeta) obj2).getDocId());
                }
                Set setR0 = c5.m.R0(arrayList2);
                if (!setR0.isEmpty()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    double averageDocLength = getAverageDocLength();
                    if (averageDocLength < 1.0E-6d) {
                        averageDocLength = 1.0E-6d;
                    }
                    double documentCount = getDocumentCount();
                    Iterator<String> it = setExtractTerms.iterator();
                    while (it.hasNext()) {
                        List<Posting> list = this.invertedIndex.get(it.next());
                        if (list != null) {
                            double size2 = list.size();
                            double dLog = Math.log((((documentCount - size2) + 0.5d) / (size2 + 0.5d)) + 1.0d);
                            for (Posting posting : list) {
                                if (setR0.contains(posting.getDocId()) && (docMeta = this.docMetas.get(posting.getDocId())) != null) {
                                    double frequency = posting.getFrequency();
                                    Iterator<String> it2 = it;
                                    Set set = setR0;
                                    double d = 1;
                                    double k12 = (((this.config.getK1() + d) * frequency) / (((((this.config.getB() * docMeta.getLength()) / averageDocLength) + (d - this.config.getB())) * this.config.getK1()) + frequency)) * dLog;
                                    String docId = posting.getDocId();
                                    linkedHashMap = linkedHashMap;
                                    Double d9 = (Double) linkedHashMap.get(posting.getDocId());
                                    linkedHashMap.put(docId, Double.valueOf((d9 != null ? d9.doubleValue() : 0.0d) + k12));
                                    setR0 = set;
                                    it = it2;
                                }
                            }
                        }
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    for (String str : linkedHashMap.keySet()) {
                        DocMeta docMeta3 = this.docMetas.get(str);
                        if (docMeta3 != null) {
                            this.docMetas.put(str, docMeta3.copy((511 & 1) != 0 ? docMeta3.docId : null, (511 & 2) != 0 ? docMeta3.length : 0, (511 & 4) != 0 ? docMeta3.date : null, (511 & 8) != 0 ? docMeta3.category : null, (511 & 16) != 0 ? docMeta3.createdAt : 0L, (511 & 32) != 0 ? docMeta3.hitCount : 0, (511 & 64) != 0 ? docMeta3.lastAccessedAt : 0L, (511 & 128) != 0 ? docMeta3.tier : null, (511 & 256) != 0 ? docMeta3.sizeBytes : 0, (511 & 512) != 0 ? docMeta3.lastCacheAccessTime : jCurrentTimeMillis));
                            if (docMeta3.getTier() == IndexTier.PERMANENT) {
                                this.permanentHitCount++;
                            } else {
                                this.dynamicHitCount++;
                            }
                        }
                    }
                    Set setEntrySet = linkedHashMap.entrySet();
                    final Comparator comparator = new Comparator() { // from class: com.stepos.stepclaw.memory.storage.index.BM25Index$search$$inlined$compareByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t8, T t9) {
                            return a.a.l((Comparable) ((Map.Entry) t9).getValue(), (Comparable) ((Map.Entry) t8).getValue());
                        }
                    };
                    List<Map.Entry> listK0 = c5.m.K0(topK, c5.m.J0(setEntrySet, new Comparator() { // from class: com.stepos.stepclaw.memory.storage.index.BM25Index$search$$inlined$thenByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t8, T t9) {
                            int iCompare = comparator.compare(t8, t9);
                            if (iCompare != 0) {
                                return iCompare;
                            }
                            DocMeta docMeta4 = (DocMeta) this.docMetas.get(((Map.Entry) t9).getKey());
                            Long lValueOf = docMeta4 != null ? Long.valueOf(docMeta4.getCreatedAt()) : 0L;
                            DocMeta docMeta5 = (DocMeta) this.docMetas.get(((Map.Entry) t8).getKey());
                            return a.a.l(lValueOf, docMeta5 != null ? Long.valueOf(docMeta5.getCreatedAt()) : 0L);
                        }
                    }));
                    ArrayList arrayList3 = new ArrayList(c5.o.n0(listK0, 10));
                    for (Map.Entry entry : listK0) {
                        String str2 = (String) entry.getKey();
                        double dDoubleValue = ((Number) entry.getValue()).doubleValue();
                        DocMeta docMeta4 = this.docMetas.get(str2);
                        String str3 = this.docContents.get(str2);
                        if (str3 == null) {
                            str3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                        }
                        String str4 = str3;
                        long lastAccessedAt = 0;
                        long createdAt = docMeta4 != null ? docMeta4.getCreatedAt() : 0L;
                        int hitCount = docMeta4 != null ? docMeta4.getHitCount() : 0;
                        if (docMeta4 != null) {
                            lastAccessedAt = docMeta4.getLastAccessedAt();
                        }
                        arrayList3.add(new SearchResult(str2, dDoubleValue, str4, createdAt, hitCount, lastAccessedAt));
                    }
                    return arrayList3;
                }
            }
        }
        return s.f1092a;
    }

    public final int unloadDynamic() {
        Collection<DocMeta> collectionValues = this.docMetas.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((DocMeta) obj).getTier() == IndexTier.DYNAMIC) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(c5.o.n0(arrayList, 10));
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = arrayList.get(i9);
            i9++;
            arrayList2.add(((DocMeta) obj2).getDocId());
        }
        w wVar = new w();
        int size2 = arrayList2.size();
        while (i8 < size2) {
            Object obj3 = arrayList2.get(i8);
            i8++;
            removeDocument((String) obj3);
            wVar.f3684a++;
        }
        this.dynamicLoadedDateFrom = null;
        this.dynamicLoadedDateTo = null;
        MemoryLogger.logI$default(this.logger, TAG, null, new b(0, wVar), 2, null);
        return wVar.f3684a;
    }

    public BM25Index(BM25Config config, TieredCacheConfig cacheConfig, MemoryLogger logger) {
        kotlin.jvm.internal.p.e(config, "config");
        kotlin.jvm.internal.p.e(cacheConfig, "cacheConfig");
        kotlin.jvm.internal.p.e(logger, "logger");
        this.config = config;
        this.cacheConfig = cacheConfig;
        this.logger = logger;
        this.invertedIndex = new LinkedHashMap();
        this.docTerms = new LinkedHashMap();
        this.docMetas = new LinkedHashMap();
        this.docContents = new LinkedHashMap();
    }

    public /* synthetic */ BM25Index(BM25Config bM25Config, TieredCacheConfig tieredCacheConfig, MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this((i8 & 1) != 0 ? new BM25Config(0.0d, 0.0d, null, 7, null) : bM25Config, (i8 & 2) != 0 ? TieredCacheConfig.INSTANCE.getDEFAULT() : tieredCacheConfig, (i8 & 4) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
