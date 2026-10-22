package com.stepos.stepclaw.memory.embedding;

import a6.f0;
import a6.i0;
import a6.r0;
import b5.a0;
import c5.t;
import c5.u;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import com.stepos.stepclaw.memory.storage.file.MemoryRecord;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import k4.v;
import k4.z;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.x;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0004\\]^_B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ=\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u001b\u0010&\u001a\u00020%2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0004\b&\u0010'J\u0018\u0010)\u001a\u00020(2\u0006\u0010\u000e\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b+\u0010\"J\u000f\u0010,\u001a\u0004\u0018\u00010%¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0016¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020%¢\u0006\u0004\b0\u00101J@\u00108\u001a\u00020%2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\n2\u0006\u00105\u001a\u0002042\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040#2\b\b\u0002\u00107\u001a\u00020%H\u0086@¢\u0006\u0004\b8\u00109J#\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010:\u001a\u00020\u0002H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010?\u001a\u0004\u0018\u00010\u001b2\u0006\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u001f\u0010A\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010DJ\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040#2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\bE\u0010FJ%\u0010H\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040GH\u0002¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010KJ%\u0010M\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0GH\u0002¢\u0006\u0004\bM\u0010NJ%\u0010P\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0002¢\u0006\u0004\bP\u0010QR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010R\u001a\u0004\bS\u0010TR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010UR\u0014\u0010V\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR,\u0010Z\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0Y0X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006`"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "baseDir", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "modelName", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/io/File;Ljava/lang/String;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$BinStats;", "cacheStats", "()Ljava/util/List;", "category", "date", "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAt", "content", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embedding", "Lb5/a0;", "append", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;[F)V", "maxLoadBytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;", "loadRecent", "(Ljava/lang/String;J)Ljava/util/Map;", "loadAll", "(Ljava/lang/String;)Ljava/util/Map;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "delete", "(Ljava/lang/String;)Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docIds", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "deleteAll", "(Ljava/util/Set;)I", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$CompactionResult;", "compact", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "needsCompaction", "peekFormatVersion", "()Ljava/lang/Integer;", "writeFormatVersion", "()V", "wipeAll", "()I", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "records", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "client", "permanentCategories", "batchSize", "embedAndStore", "(Ljava/util/List;Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;Ljava/util/Set;ILf5/c;)Ljava/lang/Object;", "file", "loadBinFile", "(Ljava/io/File;)Ljava/util/Map;", "Ljava/io/DataInputStream;", "din", "parseEntry", "(Ljava/io/DataInputStream;)Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;", "binFile", "(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;", "tombstoneFile", "(Ljava/lang/String;)Ljava/io/File;", "loadTombstones", "(Ljava/lang/String;)Ljava/util/Set;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "appendTombstones", "(Ljava/lang/String;Ljava/util/Collection;)Z", "evictFromCache", "(Ljava/lang/String;Ljava/lang/String;)V", "entries", "writeBinFile", "(Ljava/io/File;Ljava/util/Collection;)V", "remaining", "rewriteTombstones", "(Ljava/lang/String;Ljava/util/Set;)V", "Ljava/lang/String;", "getModelName", "()Ljava/lang/String;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "embeddingsDir", "Ljava/io/File;", "Ljava/util/concurrent/ConcurrentHashMap;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "entryCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Companion", "BinStats", "EmbeddingEntry", "CompactionResult", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EmbeddingStorage {
    public static final float COMPACTION_RATIO_THRESHOLD = 0.3f;
    public static final int COMPACTION_TOMBSTONE_THRESHOLD = 50;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long DEFAULT_MAX_LOAD_BYTES = 52428800;
    public static final int EMBEDDING_FORMAT_VERSION = 2;
    public static final String FORMAT_VERSION_FILE = ".format-version";
    private static final byte NULL_BYTE = 0;
    private static final String TAG = "EmbeddingStorage";
    private final File embeddingsDir;
    private final ConcurrentHashMap<String, Map<String, EmbeddingEntry>> entryCache;
    private final MemoryLogger logger;
    private final String modelName;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$BinStats;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "entries", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memBytes", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;IJ)V", "getKey", "()Ljava/lang/String;", "getEntries", "()I", "getMemBytes", "()J", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BinStats {
        private final int entries;
        private final String key;
        private final long memBytes;

        public BinStats(String key, int i8, long j4) {
            p.e(key, "key");
            this.key = key;
            this.entries = i8;
            this.memBytes = j4;
        }

        public static /* synthetic */ BinStats copy$default(BinStats binStats, String str, int i8, long j4, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                str = binStats.key;
            }
            if ((i9 & 2) != 0) {
                i8 = binStats.entries;
            }
            if ((i9 & 4) != 0) {
                j4 = binStats.memBytes;
            }
            return binStats.copy(str, i8, j4);
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
        public final long getMemBytes() {
            return this.memBytes;
        }

        public final BinStats copy(String key, int entries, long memBytes) {
            p.e(key, "key");
            return new BinStats(key, entries, memBytes);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BinStats)) {
                return false;
            }
            BinStats binStats = (BinStats) other;
            return p.a(this.key, binStats.key) && this.entries == binStats.entries && this.memBytes == binStats.memBytes;
        }

        public final int getEntries() {
            return this.entries;
        }

        public final String getKey() {
            return this.key;
        }

        public final long getMemBytes() {
            return this.memBytes;
        }

        public int hashCode() {
            return Long.hashCode(this.memBytes) + a8.b.C(this.entries, this.key.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.key;
            int i8 = this.entries;
            return a8.b.r(a8.b.u("BinStats(key=", i8, str, ", entries=", ", memBytes="), this.memBytes, ")");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$CompactionResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filesProcessed", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "entriesRemoved", "bytesSaved", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(IIJ)V", "getFilesProcessed", "()I", "getEntriesRemoved", "getBytesSaved", "()J", "component1", "component2", "component3", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CompactionResult {
        private final long bytesSaved;
        private final int entriesRemoved;
        private final int filesProcessed;

        public CompactionResult(int i8, int i9, long j4) {
            this.filesProcessed = i8;
            this.entriesRemoved = i9;
            this.bytesSaved = j4;
        }

        public static /* synthetic */ CompactionResult copy$default(CompactionResult compactionResult, int i8, int i9, long j4, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                i8 = compactionResult.filesProcessed;
            }
            if ((i10 & 2) != 0) {
                i9 = compactionResult.entriesRemoved;
            }
            if ((i10 & 4) != 0) {
                j4 = compactionResult.bytesSaved;
            }
            return compactionResult.copy(i8, i9, j4);
        }

        /* renamed from: component1, reason: from getter */
        public final int getFilesProcessed() {
            return this.filesProcessed;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEntriesRemoved() {
            return this.entriesRemoved;
        }

        /* renamed from: component3, reason: from getter */
        public final long getBytesSaved() {
            return this.bytesSaved;
        }

        public final CompactionResult copy(int filesProcessed, int entriesRemoved, long bytesSaved) {
            return new CompactionResult(filesProcessed, entriesRemoved, bytesSaved);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompactionResult)) {
                return false;
            }
            CompactionResult compactionResult = (CompactionResult) other;
            return this.filesProcessed == compactionResult.filesProcessed && this.entriesRemoved == compactionResult.entriesRemoved && this.bytesSaved == compactionResult.bytesSaved;
        }

        public final long getBytesSaved() {
            return this.bytesSaved;
        }

        public final int getEntriesRemoved() {
            return this.entriesRemoved;
        }

        public final int getFilesProcessed() {
            return this.filesProcessed;
        }

        public int hashCode() {
            return Long.hashCode(this.bytesSaved) + a8.b.C(this.entriesRemoved, Integer.hashCode(this.filesProcessed) * 31, 31);
        }

        public String toString() {
            int i8 = this.filesProcessed;
            int i9 = this.entriesRemoved;
            return a8.b.r(a8.b.t("CompactionResult(filesProcessed=", i8, ", entriesRemoved=", i9, ", bytesSaved="), this.bytesSaved, ")");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "NULL_BYTE", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "DEFAULT_MAX_LOAD_BYTES", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "COMPACTION_TOMBSTONE_THRESHOLD", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "COMPACTION_RATIO_THRESHOLD", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "EMBEDDING_FORMAT_VERSION", "FORMAT_VERSION_FILE", "rootDir", "Ljava/io/File;", "baseDir", "cleanupLegacyDirs", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "knownProviderIds", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Set<String> cleanupLegacyDirs(File baseDir, Set<String> knownProviderIds) {
            File[] fileArrListFiles;
            p.e(baseDir, "baseDir");
            p.e(knownProviderIds, "knownProviderIds");
            File fileRootDir = rootDir(baseDir);
            boolean zIsDirectory = fileRootDir.isDirectory();
            u uVar = u.f1094a;
            if (!zIsDirectory || (fileArrListFiles = fileRootDir.listFiles(new i(2))) == null) {
                return uVar;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (File file : fileArrListFiles) {
                if (!knownProviderIds.contains(file.getName()) && m5.l.z0(file)) {
                    linkedHashSet.add(file.getName());
                }
            }
            return linkedHashSet;
        }

        public final File rootDir(File baseDir) {
            p.e(baseDir, "baseDir");
            return new File(baseDir, "stepmem/embeddings");
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", "embedding", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;JLjava/lang/String;[F)V", "getDocId", "()Ljava/lang/String;", "getCreatedAt", "()J", "getContent", "getEmbedding", "()[F", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "component1", "component2", "component3", "component4", "copy", "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class EmbeddingEntry {
        private final String content;
        private final long createdAt;
        private final String docId;
        private final float[] embedding;

        public EmbeddingEntry(String docId, long j4, String content, float[] embedding) {
            p.e(docId, "docId");
            p.e(content, "content");
            p.e(embedding, "embedding");
            this.docId = docId;
            this.createdAt = j4;
            this.content = content;
            this.embedding = embedding;
        }

        public static /* synthetic */ EmbeddingEntry copy$default(EmbeddingEntry embeddingEntry, String str, long j4, String str2, float[] fArr, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = embeddingEntry.docId;
            }
            if ((i8 & 2) != 0) {
                j4 = embeddingEntry.createdAt;
            }
            if ((i8 & 4) != 0) {
                str2 = embeddingEntry.content;
            }
            if ((i8 & 8) != 0) {
                fArr = embeddingEntry.embedding;
            }
            return embeddingEntry.copy(str, j4, str2, fArr);
        }

        /* renamed from: component1, reason: from getter */
        public final String getDocId() {
            return this.docId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getCreatedAt() {
            return this.createdAt;
        }

        /* renamed from: component3, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component4, reason: from getter */
        public final float[] getEmbedding() {
            return this.embedding;
        }

        public final EmbeddingEntry copy(String docId, long createdAt, String content, float[] embedding) {
            p.e(docId, "docId");
            p.e(content, "content");
            p.e(embedding, "embedding");
            return new EmbeddingEntry(docId, createdAt, content, embedding);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!EmbeddingEntry.class.equals(other != null ? other.getClass() : null)) {
                return false;
            }
            p.c(other, "null cannot be cast to non-null type com.stepos.stepclaw.memory.embedding.EmbeddingStorage.EmbeddingEntry");
            EmbeddingEntry embeddingEntry = (EmbeddingEntry) other;
            return this.createdAt == embeddingEntry.createdAt && p.a(this.docId, embeddingEntry.docId) && p.a(this.content, embeddingEntry.content) && Arrays.equals(this.embedding, embeddingEntry.embedding);
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

        public final float[] getEmbedding() {
            return this.embedding;
        }

        public int hashCode() {
            return Arrays.hashCode(this.embedding) + a8.b.f(a8.b.f(Long.hashCode(this.createdAt) * 31, 31, this.docId), 31, this.content);
        }

        public String toString() {
            String str = this.docId;
            long j4 = this.createdAt;
            String str2 = this.content;
            String string = Arrays.toString(this.embedding);
            StringBuilder sb = new StringBuilder("EmbeddingEntry(docId=");
            sb.append(str);
            sb.append(", createdAt=");
            sb.append(j4);
            a8.b.A(sb, ", content=", str2, ", embedding=", string);
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$CompactionResult;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$CompactionResult;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.embedding.EmbeddingStorage$compact$2", f = "EmbeddingStorage.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.embedding.EmbeddingStorage$compact$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p5.p {
        final /* synthetic */ String $category;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, f5.c cVar) {
            super(2, cVar);
            this.$category = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(File file) {
            if (file.isFile()) {
                String name = file.getName();
                p.d(name, "getName(...)");
                if (x5.u.V0(name, ".bin", false)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$3(File file, Exception exc) {
            return a8.b.p("compact: failed to rewrite ", file.getName(), ": ", exc.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$4(String str, w wVar, w wVar2, x xVar) {
            int i8 = wVar.f3684a;
            int i9 = wVar2.f3684a;
            long j4 = xVar.f3685a / 1024;
            StringBuilder sbU = a8.b.u("compact(", i8, str, "): files=", ", removed=");
            sbU.append(i9);
            sbU.append(", saved=");
            sbU.append(j4);
            sbU.append("KB");
            return sbU.toString();
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return EmbeddingStorage.this.new AnonymousClass2(this.$category, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            Set linkedHashSet;
            Set set;
            File[] fileArr;
            File file;
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            Set setLoadTombstones = EmbeddingStorage.this.loadTombstones(this.$category);
            int i8 = 0;
            if (setLoadTombstones.isEmpty()) {
                return new CompactionResult(0, 0, 0L);
            }
            File[] fileArrListFiles = new File(EmbeddingStorage.this.embeddingsDir, this.$category).listFiles(new i(i8));
            if (fileArrListFiles == null) {
                return new CompactionResult(0, 0, 0L);
            }
            final w wVar = new w();
            final w wVar2 = new w();
            final x xVar = new x();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            int length = fileArrListFiles.length;
            int i9 = 0;
            while (i9 < length) {
                File file2 = fileArrListFiles[i9];
                EmbeddingStorage embeddingStorage = EmbeddingStorage.this;
                p.b(file2);
                Map mapLoadBinFile = embeddingStorage.loadBinFile(file2);
                LinkedHashSet linkedHashSetX0 = c5.m.x0(mapLoadBinFile.keySet(), setLoadTombstones);
                if (linkedHashSetX0.isEmpty()) {
                    set = setLoadTombstones;
                    fileArr = fileArrListFiles;
                } else {
                    long length2 = file2.length();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Iterator it = mapLoadBinFile.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (!linkedHashSetX0.contains((String) entry.getKey())) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                            it = it;
                        }
                    }
                    if (linkedHashMap.isEmpty()) {
                        file2.delete();
                        fileArr = fileArrListFiles;
                        xVar.f3685a += length2;
                        set = setLoadTombstones;
                    } else {
                        fileArr = fileArrListFiles;
                        set = setLoadTombstones;
                        File file3 = new File(file2.getParent(), a8.b.n(file2.getName(), ".compact.tmp"));
                        try {
                            EmbeddingStorage.this.writeBinFile(file3, linkedHashMap.values());
                            if (!file3.renameTo(file2)) {
                                FileInputStream fileInputStream = new FileInputStream(file3);
                                try {
                                    file = file3;
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
                                        try {
                                            v.u(fileInputStream, fileOutputStream);
                                            fileOutputStream.close();
                                            try {
                                                fileInputStream.close();
                                                file.delete();
                                            } catch (Exception e9) {
                                                e = e9;
                                                MemoryLogger.logW$default(EmbeddingStorage.this.logger, EmbeddingStorage.TAG, null, new j(file2, e, 0), 2, null);
                                                file.delete();
                                                i9++;
                                                fileArrListFiles = fileArr;
                                                setLoadTombstones = set;
                                            }
                                        } finally {
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        Throwable th2 = th;
                                        try {
                                            throw th2;
                                        } catch (Throwable th3) {
                                            z.h(fileInputStream, th2);
                                            throw th3;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    file = file3;
                                }
                            }
                            xVar.f3685a = (length2 - file2.length()) + xVar.f3685a;
                        } catch (Exception e10) {
                            e = e10;
                            file = file3;
                        }
                    }
                    String strO = a8.b.o(this.$category, "/", m5.l.A0(file2));
                    if (linkedHashMap.isEmpty()) {
                        EmbeddingStorage.this.entryCache.remove(strO);
                    } else {
                        EmbeddingStorage.this.entryCache.put(strO, new ConcurrentHashMap(linkedHashMap));
                    }
                    linkedHashSet2.addAll(linkedHashSetX0);
                    wVar2.f3684a = linkedHashSetX0.size() + wVar2.f3684a;
                    wVar.f3684a++;
                }
                i9++;
                fileArrListFiles = fileArr;
                setLoadTombstones = set;
            }
            Set set2 = setLoadTombstones;
            if (!linkedHashSet2.isEmpty()) {
                if (linkedHashSet2.isEmpty()) {
                    linkedHashSet = c5.m.R0(set2);
                } else {
                    linkedHashSet = new LinkedHashSet();
                    for (Object obj2 : set2) {
                        if (!linkedHashSet2.contains(obj2)) {
                            linkedHashSet.add(obj2);
                        }
                    }
                }
                EmbeddingStorage.this.rewriteTombstones(this.$category, linkedHashSet);
            }
            MemoryLogger memoryLogger = EmbeddingStorage.this.logger;
            final String str = this.$category;
            MemoryLogger.logI$default(memoryLogger, EmbeddingStorage.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.embedding.k
                @Override // p5.a
                public final Object invoke() {
                    return EmbeddingStorage.AnonymousClass2.invokeSuspend$lambda$4(str, wVar, wVar2, xVar);
                }
            }, 2, null);
            return new CompactionResult(wVar.f3684a, wVar2.f3684a, xVar.f3685a);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.embedding.EmbeddingStorage$embedAndStore$2", f = "EmbeddingStorage.kt", l = {664}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.embedding.EmbeddingStorage$embedAndStore$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00432 extends h5.i implements p5.p {
        final /* synthetic */ int $batchSize;
        final /* synthetic */ EmbeddingClient $client;
        final /* synthetic */ Set<String> $permanentCategories;
        final /* synthetic */ List<MemoryRecord> $records;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ EmbeddingStorage this$0;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J,\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"com/stepos/stepclaw/memory/embedding/EmbeddingStorage$embedAndStore$2$PendingRecord", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "record", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "docId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "dateKey", "<init>", "(Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;Ljava/lang/String;Ljava/lang/String;)V", "getRecord", "()Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "getDocId", "()Ljava/lang/String;", "getDateKey", "component1", "component2", "component3", "copy", "(Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$embedAndStore$2$PendingRecord;", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.stepclaw.memory.embedding.EmbeddingStorage$embedAndStore$2$PendingRecord */
        public static final /* data */ class PendingRecord {
            private final String dateKey;
            private final String docId;
            private final MemoryRecord record;

            public PendingRecord(MemoryRecord record, String docId, String dateKey) {
                p.e(record, "record");
                p.e(docId, "docId");
                p.e(dateKey, "dateKey");
                this.record = record;
                this.docId = docId;
                this.dateKey = dateKey;
            }

            public static /* synthetic */ PendingRecord copy$default(PendingRecord pendingRecord, MemoryRecord memoryRecord, String str, String str2, int i8, Object obj) {
                if ((i8 & 1) != 0) {
                    memoryRecord = pendingRecord.record;
                }
                if ((i8 & 2) != 0) {
                    str = pendingRecord.docId;
                }
                if ((i8 & 4) != 0) {
                    str2 = pendingRecord.dateKey;
                }
                return pendingRecord.copy(memoryRecord, str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final MemoryRecord getRecord() {
                return this.record;
            }

            /* renamed from: component2, reason: from getter */
            public final String getDocId() {
                return this.docId;
            }

            /* renamed from: component3, reason: from getter */
            public final String getDateKey() {
                return this.dateKey;
            }

            public final PendingRecord copy(MemoryRecord record, String docId, String dateKey) {
                p.e(record, "record");
                p.e(docId, "docId");
                p.e(dateKey, "dateKey");
                return new PendingRecord(record, docId, dateKey);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PendingRecord)) {
                    return false;
                }
                PendingRecord pendingRecord = (PendingRecord) other;
                return p.a(this.record, pendingRecord.record) && p.a(this.docId, pendingRecord.docId) && p.a(this.dateKey, pendingRecord.dateKey);
            }

            public final String getDateKey() {
                return this.dateKey;
            }

            public final String getDocId() {
                return this.docId;
            }

            public final MemoryRecord getRecord() {
                return this.record;
            }

            public int hashCode() {
                return this.dateKey.hashCode() + a8.b.f(this.record.hashCode() * 31, 31, this.docId);
            }

            public String toString() {
                MemoryRecord memoryRecord = this.record;
                String str = this.docId;
                String str2 = this.dateKey;
                StringBuilder sb = new StringBuilder("PendingRecord(record=");
                sb.append(memoryRecord);
                sb.append(", docId=");
                sb.append(str);
                sb.append(", dateKey=");
                return m0.f.f(sb, str2, ")");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00432(List<MemoryRecord> list, EmbeddingStorage embeddingStorage, Set<String> set, int i8, EmbeddingClient embeddingClient, f5.c cVar) {
            super(2, cVar);
            this.$records = list;
            this.this$0 = embeddingStorage;
            this.$permanentCategories = set;
            this.$batchSize = i8;
            this.$client = embeddingClient;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(List list) {
            return a8.b.k(list.size(), "embedAndStore: all ", " records already embedded, skipping");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2(List list, List list2) {
            return "embedAndStore: " + list.size() + "/" + list2.size() + " records need embedding";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$4(List list, Exception exc) {
            return "embedAndStore batch failed (" + list.size() + " items): " + exc.getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$5(List list, List list2) {
            return "embedAndStore: response size " + list.size() + " != batch size " + list2.size() + ", skipping batch";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$7(w wVar) {
            return a8.b.k(wVar.f3684a, "embedAndStore: done, wrote ", " embeddings");
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00432(this.$records, this.this$0, this.$permanentCategories, this.$batchSize, this.$client, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00432) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0182  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01d3  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01e8  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x024f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x01c4 -> B:65:0x01c7). Please report as a decompilation issue!!! */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 619
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.embedding.EmbeddingStorage.C00432.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public EmbeddingStorage(File baseDir, String modelName, MemoryLogger logger) {
        p.e(baseDir, "baseDir");
        p.e(modelName, "modelName");
        p.e(logger, "logger");
        this.modelName = modelName;
        this.logger = logger;
        if (x5.n.t1(modelName)) {
            throw new IllegalArgumentException("EmbeddingStorage.modelName must not be blank");
        }
        this.embeddingsDir = new File(baseDir, m0.f.c("stepmem/embeddings/", modelName));
        this.entryCache = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String append$lambda$3(String str, String str2, Exception exc) {
        String message = exc.getMessage();
        StringBuilder sbV = a8.b.v("append failed for ", str, "/", str2, ": ");
        sbV.append(message);
        return sbV.toString();
    }

    private final boolean appendTombstones(String category, Collection<String> docIds) {
        if (docIds.isEmpty()) {
            return true;
        }
        File file = tombstoneFile(category);
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            m5.l.w0(file, c5.m.A0(docIds, "\n", null, "\n", null, 58), x5.a.f6276a);
            return true;
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new c(category, e9, 1), 2, null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appendTombstones$lambda$0(String str, Exception exc) {
        return a8.b.p("appendTombstones(", str, "): ", exc.getMessage());
    }

    private final File binFile(String category, String date) {
        return new File(this.embeddingsDir, category + "/" + date + ".bin");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String delete$lambda$0(String str) {
        return m0.f.c("delete: tombstone written, docId=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String deleteAll$lambda$1(w wVar, Set set) {
        return "deleteAll: " + wVar.f3684a + "/" + set.size() + " tombstones written";
    }

    public static /* synthetic */ Object embedAndStore$default(EmbeddingStorage embeddingStorage, List list, EmbeddingClient embeddingClient, Set set, int i8, f5.c cVar, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            set = u.f1094a;
        }
        Set set2 = set;
        if ((i9 & 8) != 0) {
            i8 = 32;
        }
        return embeddingStorage.embedAndStore(list, embeddingClient, set2, i8, cVar);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.stepos.stepclaw.memory.embedding.e] */
    private final void evictFromCache(String category, final String docId) {
        String strO = a8.b.o(category, "/", x5.n.O1(x5.n.L1(docId, "/"), "#"));
        ConcurrentHashMap<String, Map<String, EmbeddingEntry>> concurrentHashMap = this.entryCache;
        final ?? r02 = new p5.p() { // from class: com.stepos.stepclaw.memory.embedding.e
            @Override // p5.p
            public final Object invoke(Object obj, Object obj2) {
                return EmbeddingStorage.evictFromCache$lambda$0(docId, (String) obj, (Map) obj2);
            }
        };
        concurrentHashMap.computeIfPresent(strO, new BiFunction() { // from class: com.stepos.stepclaw.memory.embedding.f
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return EmbeddingStorage.evictFromCache$lambda$1(r02, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map evictFromCache$lambda$0(String str, String str2, Map map) {
        p.e(str2, "<unused var>");
        p.e(map, "map");
        map.remove(str);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map evictFromCache$lambda$1(p5.p pVar, Object obj, Object obj2) {
        return (Map) pVar.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, EmbeddingEntry> loadBinFile(File file) throws IOException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file), 8192));
            while (true) {
                try {
                    EmbeddingEntry entry = parseEntry(dataInputStream);
                    if (entry == null) {
                        dataInputStream.close();
                        return linkedHashMap;
                    }
                    linkedHashMap.put(entry.getDocId(), entry);
                } finally {
                }
            }
        } catch (EOFException unused) {
            return linkedHashMap;
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new j(file, e9, 1), 2, null);
            return linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadBinFile$lambda$1(File file, Exception exc) {
        return a8.b.p("loadBinFile: error reading ", file.getName(), ": ", exc.getMessage());
    }

    public static /* synthetic */ Map loadRecent$default(EmbeddingStorage embeddingStorage, String str, long j4, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            j4 = DEFAULT_MAX_LOAD_BYTES;
        }
        return embeddingStorage.loadRecent(str, j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadRecent$lambda$0(File file) {
        if (file.isFile()) {
            String name = file.getName();
            p.d(name, "getName(...)");
            if (x5.u.V0(name, ".bin", false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> loadTombstones(String category) throws IOException {
        Set<String> setA0;
        File file = tombstoneFile(category);
        boolean zIsFile = file.isFile();
        u uVar = u.f1094a;
        if (!zIsFile) {
            return uVar;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), x5.a.f6276a), 8192);
            try {
                w5.f fVar = new w5.f(new w5.g(new w5.g(new w5.a(new c5.k(2, bufferedReader)), new d(0), 1), new d(1), 0));
                if (fVar.hasNext()) {
                    Object next = fVar.next();
                    if (fVar.hasNext()) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        linkedHashSet.add(next);
                        while (fVar.hasNext()) {
                            linkedHashSet.add(fVar.next());
                        }
                        setA0 = linkedHashSet;
                    } else {
                        setA0 = a.a.a0(next);
                    }
                } else {
                    setA0 = uVar;
                }
                bufferedReader.close();
                return setA0;
            } finally {
            }
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new c(category, e9, 2), 2, null);
            return uVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadTombstones$lambda$0$0(String it) {
        p.e(it, "it");
        return x5.n.T1(it).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadTombstones$lambda$0$1(String it) {
        p.e(it, "it");
        return it.length() > 0 && !x5.u.c1(it, "#", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadTombstones$lambda$1(String str, Exception exc) {
        return a8.b.p("loadTombstones(", str, "): ", exc.getMessage());
    }

    private final EmbeddingEntry parseEntry(DataInputStream din) throws IOException {
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                int i8 = din.read();
                if (i8 == -1) {
                    break;
                }
                if (i8 != 0) {
                    arrayList.add(Byte.valueOf((byte) i8));
                } else {
                    byte[] bArrL0 = c5.m.L0(arrayList);
                    Charset charset = x5.a.f6276a;
                    String str = new String(bArrL0, charset);
                    if (str.length() != 0) {
                        long j4 = din.readLong();
                        int i9 = din.readInt();
                        if (i9 < 0 || i9 >= 1000001) {
                            MemoryLogger.logW$default(this.logger, TAG, null, new h(i9, str, 0), 2, null);
                            return null;
                        }
                        byte[] bArr = new byte[i9];
                        din.readFully(bArr);
                        String str2 = new String(bArr, charset);
                        int i10 = din.readInt();
                        if (1 > i10 || i10 >= 65537) {
                            MemoryLogger.logW$default(this.logger, TAG, null, new h(i10, str, 1), 2, null);
                            return null;
                        }
                        float[] fArr = new float[i10];
                        for (int i11 = 0; i11 < i10; i11++) {
                            fArr[i11] = din.readFloat();
                        }
                        return new EmbeddingEntry(str, j4, str2, fArr);
                    }
                }
            }
        } catch (EOFException unused) {
        } catch (IllegalArgumentException e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new l(4, e9), 2, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parseEntry$lambda$0(int i8, String str) {
        return "parseEntry: suspicious contentLen=" + i8 + " for docId=" + str + ", skipping";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parseEntry$lambda$1(int i8, String str) {
        return "parseEntry: suspicious dim=" + i8 + " for docId=" + str + ", skipping";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String parseEntry$lambda$2(IllegalArgumentException illegalArgumentException) {
        return m0.f.c("parseEntry: malformed entry, skipping: ", illegalArgumentException.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String peekFormatVersion$lambda$0(Exception exc) {
        return m0.f.c("peekFormatVersion failed: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rewriteTombstones(String category, Set<String> remaining) {
        File file = tombstoneFile(category);
        try {
            if (remaining.isEmpty()) {
                file.delete();
            } else {
                m5.l.G0(file, c5.m.A0(remaining, "\n", null, "\n", null, 58), x5.a.f6276a);
            }
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new c(category, e9, 0), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String rewriteTombstones$lambda$0(String str, Exception exc) {
        return a8.b.p("rewriteTombstones(", str, "): ", exc.getMessage());
    }

    private final File tombstoneFile(String category) {
        return new File(this.embeddingsDir, a8.b.n(category, "/tombstones.txt"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String wipeAll$lambda$1(Exception exc) {
        return m0.f.c("wipeAll: walkBottomUp failed: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String wipeAll$lambda$2(w wVar, EmbeddingStorage embeddingStorage) {
        return "wipeAll: removed " + wVar.f3684a + " files under " + embeddingStorage.embeddingsDir.getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeBinFile(File file, Collection<EmbeddingEntry> entries) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            try {
                for (EmbeddingEntry embeddingEntry : entries) {
                    String docId = embeddingEntry.getDocId();
                    Charset charset = x5.a.f6276a;
                    byte[] bytes = docId.getBytes(charset);
                    p.d(bytes, "getBytes(...)");
                    dataOutputStream.write(bytes);
                    dataOutputStream.write(0);
                    dataOutputStream.writeLong(embeddingEntry.getCreatedAt());
                    byte[] bytes2 = embeddingEntry.getContent().getBytes(charset);
                    p.d(bytes2, "getBytes(...)");
                    dataOutputStream.writeInt(bytes2.length);
                    dataOutputStream.write(bytes2);
                    dataOutputStream.writeInt(embeddingEntry.getEmbedding().length);
                    for (float f3 : embeddingEntry.getEmbedding()) {
                        dataOutputStream.writeFloat(f3);
                    }
                }
                dataOutputStream.close();
                fileOutputStream.close();
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeFormatVersion$lambda$0(Exception exc) {
        return m0.f.c("writeFormatVersion failed: ", exc.getMessage());
    }

    public final void append(String category, String date, String docId, long createdAt, String content, float[] embedding) throws IOException {
        Map<String, EmbeddingEntry> mapPutIfAbsent;
        p.e(category, "category");
        p.e(date, "date");
        p.e(docId, "docId");
        p.e(content, "content");
        p.e(embedding, "embedding");
        File fileBinFile = binFile(category, date);
        File parentFile = fileBinFile.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            File file = new File(fileBinFile.getParent(), fileBinFile.getName() + ".tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                try {
                    Charset charset = x5.a.f6276a;
                    byte[] bytes = docId.getBytes(charset);
                    p.d(bytes, "getBytes(...)");
                    dataOutputStream.write(bytes);
                    dataOutputStream.write(0);
                    dataOutputStream.writeLong(createdAt);
                    byte[] bytes2 = content.getBytes(charset);
                    p.d(bytes2, "getBytes(...)");
                    dataOutputStream.writeInt(bytes2.length);
                    dataOutputStream.write(bytes2);
                    dataOutputStream.writeInt(embedding.length);
                    for (float f3 : embedding) {
                        dataOutputStream.writeFloat(f3);
                    }
                    dataOutputStream.close();
                    fileOutputStream.close();
                    fileOutputStream = new FileOutputStream(fileBinFile, true);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            v.u(fileInputStream, fileOutputStream);
                            fileInputStream.close();
                            fileOutputStream.close();
                            file.delete();
                            String str = category + "/" + date;
                            ConcurrentHashMap<String, Map<String, EmbeddingEntry>> concurrentHashMap = this.entryCache;
                            Map<String, EmbeddingEntry> concurrentHashMap2 = concurrentHashMap.get(str);
                            if (concurrentHashMap2 == null && (mapPutIfAbsent = concurrentHashMap.putIfAbsent(str, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
                                concurrentHashMap2 = mapPutIfAbsent;
                            }
                            concurrentHashMap2.put(docId, new EmbeddingEntry(docId, createdAt, content, embedding));
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new g(category, date, e9, 0), 2, null);
        }
    }

    public final List<BinStats> cacheStats() {
        ConcurrentHashMap<String, Map<String, EmbeddingEntry>> concurrentHashMap = this.entryCache;
        ArrayList arrayList = new ArrayList(concurrentHashMap.size());
        for (Map.Entry<String, Map<String, EmbeddingEntry>> entry : concurrentHashMap.entrySet()) {
            String key = entry.getKey();
            Map<String, EmbeddingEntry> value = entry.getValue();
            long jH = 0;
            for (EmbeddingEntry embeddingEntry : value.values()) {
                String docId = embeddingEntry.getDocId();
                Charset charset = x5.a.f6276a;
                p.d(docId.getBytes(charset), "getBytes(...)");
                long length = r5.length + 8;
                p.d(embeddingEntry.getContent().getBytes(charset), "getBytes(...)");
                jH = a8.b.h(embeddingEntry.getEmbedding().length, 4L, length + r5.length, jH);
            }
            arrayList.add(new BinStats(key, value.size(), jH));
        }
        return c5.m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.memory.embedding.EmbeddingStorage$cacheStats$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l(((EmbeddingStorage.BinStats) t9).getKey(), ((EmbeddingStorage.BinStats) t8).getKey());
            }
        });
    }

    public final Object compact(String str, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new AnonymousClass2(str, null), cVar);
    }

    public final boolean delete(String docId) {
        p.e(docId, "docId");
        String strO1 = x5.n.O1(docId, "/");
        if (!appendTombstones(strO1, a.a.S(docId))) {
            return false;
        }
        evictFromCache(strO1, docId);
        MemoryLogger.logD$default(this.logger, TAG, null, new l(3, docId), 2, null);
        return true;
    }

    public final int deleteAll(Set<String> docIds) {
        p.e(docIds, "docIds");
        if (docIds.isEmpty()) {
            return 0;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : docIds) {
            String strO1 = x5.n.O1((String) obj, "/");
            Object arrayList = linkedHashMap.get(strO1);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strO1, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        w wVar = new w();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (appendTombstones(str, list)) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    evictFromCache(str, (String) it.next());
                    wVar.f3684a++;
                }
            }
        }
        MemoryLogger.logD$default(this.logger, TAG, null, new m(wVar, 7, docIds), 2, null);
        return wVar.f3684a;
    }

    public final Object embedAndStore(List<MemoryRecord> list, EmbeddingClient embeddingClient, Set<String> set, int i8, f5.c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(h6.d.f3059c, new C00432(list, this, set, i8, embeddingClient, null), cVar);
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final Map<String, EmbeddingEntry> loadAll(String category) {
        p.e(category, "category");
        return loadRecent(category, Util.VLI_MAX);
    }

    public final Map<String, EmbeddingEntry> loadRecent(String category, long maxLoadBytes) throws IOException {
        Object[] objArrListFiles;
        Map<String, EmbeddingEntry> mapPutIfAbsent;
        p.e(category, "category");
        File file = new File(this.embeddingsDir, category);
        if (file.exists() && file.isDirectory() && (objArrListFiles = file.listFiles(new i(1))) != null) {
            Comparator comparator = new Comparator() { // from class: com.stepos.stepclaw.memory.embedding.EmbeddingStorage$loadRecent$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t8, T t9) {
                    return a.a.l(((File) t9).getName(), ((File) t8).getName());
                }
            };
            if (objArrListFiles.length != 0) {
                objArrListFiles = Arrays.copyOf(objArrListFiles, objArrListFiles.length);
                p.d(objArrListFiles, "copyOf(...)");
                if (objArrListFiles.length > 1) {
                    Arrays.sort(objArrListFiles, comparator);
                }
            }
            List<File> listS = c5.l.S(objArrListFiles);
            if (!listS.isEmpty()) {
                Set<String> setLoadTombstones = loadTombstones(category);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                long length = 0;
                for (File file2 : listS) {
                    if (length >= maxLoadBytes) {
                        break;
                    }
                    p.b(file2);
                    String strO = a8.b.o(category, "/", m5.l.A0(file2));
                    ConcurrentHashMap<String, Map<String, EmbeddingEntry>> concurrentHashMap = this.entryCache;
                    Map<String, EmbeddingEntry> concurrentHashMap2 = concurrentHashMap.get(strO);
                    if (concurrentHashMap2 == null && (mapPutIfAbsent = concurrentHashMap.putIfAbsent(strO, (concurrentHashMap2 = new ConcurrentHashMap<>(loadBinFile(file2))))) != null) {
                        concurrentHashMap2 = mapPutIfAbsent;
                    }
                    linkedHashMap.putAll(concurrentHashMap2);
                    length += file2.length();
                }
                if (!setLoadTombstones.isEmpty()) {
                    linkedHashMap.keySet().removeAll(setLoadTombstones);
                }
                return linkedHashMap;
            }
        }
        return t.f1093a;
    }

    public final boolean needsCompaction(String category) throws IOException {
        p.e(category, "category");
        Set<String> setLoadTombstones = loadTombstones(category);
        if (!setLoadTombstones.isEmpty()) {
            if (setLoadTombstones.size() >= 50) {
                return true;
            }
            Set<Map.Entry<String, Map<String, EmbeddingEntry>>> setEntrySet = this.entryCache.entrySet();
            p.d(setEntrySet, "<get-entries>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : setEntrySet) {
                Object key = ((Map.Entry) obj).getKey();
                p.d(key, "<get-key>(...)");
                if (x5.u.c1((String) key, category.concat("/"), false)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            int size2 = 0;
            int i8 = 0;
            while (i8 < size) {
                Object obj2 = arrayList.get(i8);
                i8++;
                size2 += ((Map) ((Map.Entry) obj2).getValue()).size();
            }
            if (size2 > 0 && setLoadTombstones.size() / size2 >= 0.3f) {
                return true;
            }
        }
        return false;
    }

    public final Integer peekFormatVersion() {
        File file = new File(this.embeddingsDir, FORMAT_VERSION_FILE);
        if (!file.isFile()) {
            return null;
        }
        try {
            return x5.u.d1(x5.n.T1(m5.l.E0(file, x5.a.f6276a)).toString());
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new b(e9, 2), 2, null);
            return null;
        }
    }

    public final int wipeAll() {
        w wVar = new w();
        if (this.embeddingsDir.exists()) {
            try {
                File file = this.embeddingsDir;
                p.e(file, "<this>");
                m5.h hVar = new m5.h(new m5.j(file, m5.k.f3924b, null));
                while (hVar.hasNext()) {
                    File file2 = (File) hVar.next();
                    if (!p.a(file2, this.embeddingsDir) && file2.exists() && file2.delete()) {
                        wVar.f3684a++;
                    }
                }
            } catch (Exception e9) {
                MemoryLogger.logW$default(this.logger, TAG, null, new b(e9, 1), 2, null);
            }
        }
        this.entryCache.clear();
        MemoryLogger.logI$default(this.logger, TAG, null, new m(wVar, 6, this), 2, null);
        return wVar.f3684a;
    }

    public final void writeFormatVersion() {
        try {
            this.embeddingsDir.mkdirs();
            m5.l.G0(new File(this.embeddingsDir, FORMAT_VERSION_FILE), "2", x5.a.f6276a);
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new b(e9, 0), 2, null);
        }
    }

    public /* synthetic */ EmbeddingStorage(File file, String str, MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this(file, str, (i8 & 4) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
