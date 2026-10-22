package com.stepos.stepclaw.memory.lightmem.evolution;

import a6.f0;
import a6.i0;
import a6.r0;
import b5.a0;
import c5.m;
import c5.s;
import c5.t;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.remote.AsyncTaskStatusKt;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionDeleteMemory;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerMessageItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import com.stepos.stepclaw.memory.storage.MemoryStorage;
import com.stepos.stepclaw.memory.storage.file.DailyMemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFileManager;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.w;
import kotlin.jvm.internal.y;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import m5.l;
import p5.p;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 a2\u00020\u0001:\u0002abBI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ*\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0004\b(\u0010)J6\u00100\u001a\u00020/2\u0006\u0010+\u001a\u00020*2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00170,2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0086@¢\u0006\u0004\b0\u00101J!\u00103\u001a\u00020%2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00170,¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00170,¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b9\u00108J\u0015\u0010;\u001a\u00020%2\u0006\u0010+\u001a\u00020:¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u00020%2\u0006\u0010=\u001a\u00020\u0017¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u0004\u0018\u00010:¢\u0006\u0004\b@\u0010AJ\r\u0010B\u001a\u00020%¢\u0006\u0004\bB\u0010CJ\r\u0010D\u001a\u00020\u001b¢\u0006\u0004\bD\u0010\u001dJ;\u0010M\u001a\u00020%2\u0006\u0010F\u001a\u00020E2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00140G2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020-0I2\u0006\u0010L\u001a\u00020KH\u0002¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020-2\u0006\u0010O\u001a\u00020\u0017H\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\bH\u0002¢\u0006\u0004\bR\u0010SR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010TR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010UR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010VR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010WR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010XR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010YR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010ZR$\u0010[\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0017\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006c"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "client", "Lcom/stepos/stepclaw/memory/storage/MemoryStorage;", "storage", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "indexManager", "Ljava/io/File;", "storageRoot", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "Lkotlin/Function0;", "Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", "searchConfig", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "embeddingStorage", "<init>", "(Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;Lcom/stepos/stepclaw/memory/storage/MemoryStorage;Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;Ljava/io/File;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;Lp5/a;Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem;", "loadAllPendingEpisodic", "()Ljava/util/List;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fileName", "loadPendingFromFile", "(Ljava/lang/String;)Ljava/util/List;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "countPendingEpisodic", "()I", "sessionId", "episodicFileName", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionPipelineResult;", "runPipeline", "(Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "La6/f0;", "scope", "Lb5/a0;", "maybeAutoTrigger", "(La6/f0;Ljava/lang/String;)V", "markPendingAsEvolved", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "response", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memoryIndexToDocId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "applyEvolutionResult", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;Ljava/util/Map;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "map", "persistMemoryIndexToDocIdMap", "(Ljava/util/Map;)V", "loadMemoryIndexToDocIdMap", "()Ljava/util/Map;", "readLastTriggerUniqueId", "()Ljava/lang/String;", "readLastUpdateUniqueId", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "cacheTriggerResponse", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;)V", "uniqueId", "cacheUpdateUniqueId", "(Ljava/lang/String;)V", "getCachedTriggerResponse", "()Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "clearCachedTriggerData", "()V", "clearStaleCaches", "Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;", "daily", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "result", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seenMemoryIndexes", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService$EpisodicLoadStats;", "stats", "collectPendingFromDaily", "(Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;Ljava/util/List;Ljava/util/Set;Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService$EpisodicLoadStats;)V", "iso8601", "parseCreateAtToEpochSeconds", "(Ljava/lang/String;)J", "memoryIndexMapFile", "()Ljava/io/File;", "Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "Lcom/stepos/stepclaw/memory/storage/MemoryStorage;", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "Ljava/io/File;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Lp5/a;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "lastMemoryIndexToDocId", "Ljava/util/Map;", "cachedTriggerResponse", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "lastUpdateUniqueId", "Ljava/lang/String;", "Companion", "EpisodicLoadStats", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OfflineEvolutionService {
    private static final int MAX_POLLS = 10;
    public static final int PENDING_THRESHOLD = 64;
    private static final long POLL_INTERVAL_MS = 120000;
    private static final String TAG = "OfflineEvoService";
    private volatile OfflineTriggerResponse cachedTriggerResponse;
    private final LightMemClient client;
    private final EmbeddingStorage embeddingStorage;
    private final MemoryIndexManager indexManager;
    private volatile Map<Long, String> lastMemoryIndexToDocId;
    private volatile String lastUpdateUniqueId;
    private final MemoryLogger logger;
    private final p5.a searchConfig;
    private final MemoryStorage storage;
    private final File storageRoot;
    private static final Json episodicLineJson = JsonKt.Json$default(null, new com.stepos.stepclaw.gateway.d(6), 1, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService$EpisodicLoadStats;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "totalLines", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getTotalLines", "()I", "setTotalLines", "(I)V", "skippedEmpty", "getSkippedEmpty", "setSkippedEmpty", "skippedNonJson", "getSkippedNonJson", "setSkippedNonJson", "skippedBlankContent", "getSkippedBlankContent", "setSkippedBlankContent", "skippedNonPending", "getSkippedNonPending", "setSkippedNonPending", "skippedDuplicate", "getSkippedDuplicate", "setSkippedDuplicate", "parseErrors", "getParseErrors", "setParseErrors", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class EpisodicLoadStats {
        private int parseErrors;
        private int skippedBlankContent;
        private int skippedDuplicate;
        private int skippedEmpty;
        private int skippedNonJson;
        private int skippedNonPending;
        private int totalLines;

        public final int getParseErrors() {
            return this.parseErrors;
        }

        public final int getSkippedBlankContent() {
            return this.skippedBlankContent;
        }

        public final int getSkippedDuplicate() {
            return this.skippedDuplicate;
        }

        public final int getSkippedEmpty() {
            return this.skippedEmpty;
        }

        public final int getSkippedNonJson() {
            return this.skippedNonJson;
        }

        public final int getSkippedNonPending() {
            return this.skippedNonPending;
        }

        public final int getTotalLines() {
            return this.totalLines;
        }

        public final void setParseErrors(int i8) {
            this.parseErrors = i8;
        }

        public final void setSkippedBlankContent(int i8) {
            this.skippedBlankContent = i8;
        }

        public final void setSkippedDuplicate(int i8) {
            this.skippedDuplicate = i8;
        }

        public final void setSkippedEmpty(int i8) {
            this.skippedEmpty = i8;
        }

        public final void setSkippedNonJson(int i8) {
            this.skippedNonJson = i8;
        }

        public final void setSkippedNonPending(int i8) {
            this.skippedNonPending = i8;
        }

        public final void setTotalLines(int i8) {
            this.totalLines = i8;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService", f = "OfflineEvolutionService.kt", l = {479, 482, 513, 516, 526}, m = "applyEvolutionResult", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$applyEvolutionResult$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
        int I$8;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineEvolutionService.this.applyEvolutionResult(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService", f = "OfflineEvolutionService.kt", l = {411}, m = "markPendingAsEvolved", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$markPendingAsEvolved$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00491 extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00491(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineEvolutionService.this.markPendingAsEvolved(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$maybeAutoTrigger$2", f = "OfflineEvolutionService.kt", l = {396}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$maybeAutoTrigger$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p {
        final /* synthetic */ String $sessionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, f5.c cVar) {
            super(2, cVar);
            this.$sessionId = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(OfflineEvolutionPipelineResult offlineEvolutionPipelineResult) {
            return "[maybeAutoTrigger] pipeline finished: " + offlineEvolutionPipelineResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(Exception exc) {
            return m0.f.c("[maybeAutoTrigger] failed: ", exc.getMessage());
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return OfflineEvolutionService.this.new AnonymousClass2(this.$sessionId, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            AnonymousClass2 anonymousClass2;
            OfflineEvolutionService offlineEvolutionService;
            String str;
            Exception exc;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                try {
                    offlineEvolutionService = OfflineEvolutionService.this;
                    String str2 = this.$sessionId;
                    if (str2 == null) {
                        str2 = "auto-evolution";
                    }
                    str = str2;
                    this.label = 1;
                    anonymousClass2 = this;
                } catch (Exception e9) {
                    e = e9;
                    anonymousClass2 = this;
                    exc = e;
                    OfflineEvolutionService.this.logger.logE(OfflineEvolutionService.TAG, anonymousClass2.$sessionId, exc, new i(exc, 0));
                    return a0.f883a;
                }
                try {
                    obj = OfflineEvolutionService.runPipeline$default(offlineEvolutionService, str, null, anonymousClass2, 2, null);
                    if (obj == aVar) {
                        return aVar;
                    }
                } catch (Exception e10) {
                    e = e10;
                    exc = e;
                    OfflineEvolutionService.this.logger.logE(OfflineEvolutionService.TAG, anonymousClass2.$sessionId, exc, new i(exc, 0));
                    return a0.f883a;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    a.a.c0(obj);
                    anonymousClass2 = this;
                } catch (Exception e11) {
                    exc = e11;
                    anonymousClass2 = this;
                    OfflineEvolutionService.this.logger.logE(OfflineEvolutionService.TAG, anonymousClass2.$sessionId, exc, new i(exc, 0));
                    return a0.f883a;
                }
            }
            OfflineEvolutionService.this.logger.logI(OfflineEvolutionService.TAG, anonymousClass2.$sessionId, new h(0, (OfflineEvolutionPipelineResult) obj));
            return a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService", f = "OfflineEvolutionService.kt", l = {257, 286, 289, 323, 348, 364, 375}, m = "runPipeline", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$runPipeline$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00501 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C00501(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OfflineEvolutionService.this.runPipeline(null, null, this);
        }
    }

    public OfflineEvolutionService(LightMemClient client, MemoryStorage storage, MemoryIndexManager indexManager, File storageRoot, MemoryLogger logger, p5.a searchConfig, EmbeddingStorage embeddingStorage) {
        kotlin.jvm.internal.p.e(client, "client");
        kotlin.jvm.internal.p.e(storage, "storage");
        kotlin.jvm.internal.p.e(indexManager, "indexManager");
        kotlin.jvm.internal.p.e(storageRoot, "storageRoot");
        kotlin.jvm.internal.p.e(logger, "logger");
        kotlin.jvm.internal.p.e(searchConfig, "searchConfig");
        this.client = client;
        this.storage = storage;
        this.indexManager = indexManager;
        this.storageRoot = storageRoot;
        this.logger = logger;
        this.searchConfig = searchConfig;
        this.embeddingStorage = embeddingStorage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applyEvolutionResult$lambda$2(OfflineEvolutionDeleteMemory offlineEvolutionDeleteMemory) {
        return a8.b.l(offlineEvolutionDeleteMemory.getMemory_index(), "delete_memories: unknown memory_index=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applyEvolutionResult$lambda$3(String str) {
        return m0.f.c("evolution delete: embedding tombstone write failed for docId=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applyEvolutionResult$lambda$4(String str) {
        return m0.f.c("evolution delete: deprecated docId=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applyEvolutionResult$lambda$5(String str) {
        return m0.f.c("evolution delete: file entry not found, orphan healed at index/embedding only docId=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applyEvolutionResult$lambda$7(Long l3, String str) {
        return "add_memories: skip duplicate memoryIndex=" + l3 + " cat=" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String applyEvolutionResult$lambda$8(String str) {
        return m0.f.c("[applyEvolutionResult] done: ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String cacheTriggerResponse$lambda$0(OfflineTriggerResponse offlineTriggerResponse) {
        return "[cacheTriggerResponse] cached trigger response, unique_id=" + AsyncTaskStatusKt.effectiveUniqueId(offlineTriggerResponse) + ", search_groups=" + offlineTriggerResponse.getSearch_groups().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String clearCachedTriggerData$lambda$0() {
        return "[clearCachedTriggerData] cleared cached trigger response, memoryIndexToDocId, and lastUpdateUniqueId";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String clearStaleCaches$lambda$0(Exception exc) {
        return m0.f.c("clearStaleCaches: delete memoryIndexMapFile failed: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String clearStaleCaches$lambda$1(w wVar) {
        return a8.b.k(wVar.f3684a, "[clearStaleCaches] removed ", " stale offline files, in-memory caches reset");
    }

    private final void collectPendingFromDaily(DailyMemoryFile daily, List<OfflineTriggerMessageItem> result, Set<Long> seenMemoryIndexes, EpisodicLoadStats stats) {
        DailyMemoryFile dailyMemoryFile;
        int iBackfillMemoryIndex = daily.backfillMemoryIndex();
        if (iBackfillMemoryIndex > 0) {
            dailyMemoryFile = daily;
            MemoryLogger.logI$default(this.logger, TAG, null, new c(iBackfillMemoryIndex, dailyMemoryFile, 0), 2, null);
        } else {
            dailyMemoryFile = daily;
        }
        for (String str : n.y1(dailyMemoryFile.readRawContent())) {
            stats.setTotalLines(stats.getTotalLines() + 1);
            String string = n.T1(str).toString();
            if (string.length() == 0) {
                stats.setSkippedEmpty(stats.getSkippedEmpty() + 1);
            } else if (u.c1(string, "{", false)) {
                try {
                    Json json = episodicLineJson;
                    json.getSerializersModule();
                    CatchMemoryItem catchMemoryItem = (CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string);
                    if (n.t1(catchMemoryItem.getContent())) {
                        stats.setSkippedBlankContent(stats.getSkippedBlankContent() + 1);
                    } else {
                        String strNormalizeState = EpisodicMemoryEvolutionState.INSTANCE.normalizeState(catchMemoryItem.getState());
                        if (kotlin.jvm.internal.p.a(strNormalizeState, EpisodicMemoryEvolutionState.PENDING)) {
                            Long memoryIndex = catchMemoryItem.getMemoryIndex();
                            if (memoryIndex == null) {
                                stats.setParseErrors(stats.getParseErrors() + 1);
                                MemoryLogger.logW$default(this.logger, TAG, null, new a4.b(16), 2, null);
                            } else if (seenMemoryIndexes.contains(memoryIndex)) {
                                stats.setSkippedDuplicate(stats.getSkippedDuplicate() + 1);
                            } else {
                                seenMemoryIndexes.add(memoryIndex);
                                try {
                                    result.add(new OfflineTriggerMessageItem(catchMemoryItem.getContent(), catchMemoryItem.getConfidence(), parseCreateAtToEpochSeconds(catchMemoryItem.getCreateAt()), memoryIndex.longValue(), strNormalizeState));
                                } catch (Exception e9) {
                                    e = e9;
                                    stats.setParseErrors(stats.getParseErrors() + 1);
                                    MemoryLogger.logW$default(this.logger, TAG, null, new d(stats, 0, e), 2, null);
                                }
                            }
                        } else {
                            stats.setSkippedNonPending(stats.getSkippedNonPending() + 1);
                        }
                    }
                } catch (Exception e10) {
                    e = e10;
                }
            } else {
                stats.setSkippedNonJson(stats.getSkippedNonJson() + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String collectPendingFromDaily$lambda$0(int i8, DailyMemoryFile dailyMemoryFile) {
        return "[collectPendingFromDaily] backfilled " + i8 + " entries with memoryIndex in " + dailyMemoryFile.getDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String collectPendingFromDaily$lambda$1() {
        return "[collectPendingFromDaily] memoryIndex is null after backfill, skipping";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String collectPendingFromDaily$lambda$2(EpisodicLoadStats episodicLoadStats, Exception exc) {
        return "[collectPendingFromDaily] parse error at line " + episodicLoadStats.getTotalLines() + ": " + exc.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 episodicLineJson$lambda$0(JsonBuilder Json) {
        kotlin.jvm.internal.p.e(Json, "$this$Json");
        Json.setIgnoreUnknownKeys(true);
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadAllPendingEpisodic$lambda$0(OfflineEvolutionService offlineEvolutionService) {
        return m0.f.c("[loadAllPendingEpisodic] start, storageRoot=", offlineEvolutionService.storageRoot.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadAllPendingEpisodic$lambda$1(List list) {
        return a8.b.k(list.size(), "[loadAllPendingEpisodic] episodic dates: ", " files");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadAllPendingEpisodic$lambda$3(EpisodicLoadStats episodicLoadStats, List list) {
        int totalLines = episodicLoadStats.getTotalLines();
        int size = list.size();
        int skippedEmpty = episodicLoadStats.getSkippedEmpty();
        int skippedNonJson = episodicLoadStats.getSkippedNonJson();
        int skippedBlankContent = episodicLoadStats.getSkippedBlankContent();
        int skippedNonPending = episodicLoadStats.getSkippedNonPending();
        int skippedDuplicate = episodicLoadStats.getSkippedDuplicate();
        int parseErrors = episodicLoadStats.getParseErrors();
        StringBuilder sbT = a8.b.t("[loadAllPendingEpisodic] done: lines=", totalLines, " result=", size, " skipped(empty=");
        a8.b.z(sbT, skippedEmpty, ", nonJson=", skippedNonJson, ", blank=");
        a8.b.z(sbT, skippedBlankContent, ", nonPending=", skippedNonPending, ", dup=");
        sbT.append(skippedDuplicate);
        sbT.append("), parseErrors=");
        sbT.append(parseErrors);
        return sbT.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPendingFromFile$lambda$0(File file) {
        return m0.f.c("[loadPendingFromFile] file=", file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPendingFromFile$lambda$1(File file) {
        return m0.f.c("[loadPendingFromFile] file not found: ", file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPendingFromFile$lambda$3(String str, EpisodicLoadStats episodicLoadStats, List list) {
        int totalLines = episodicLoadStats.getTotalLines();
        int size = list.size();
        int skippedNonPending = episodicLoadStats.getSkippedNonPending();
        int skippedDuplicate = episodicLoadStats.getSkippedDuplicate();
        int parseErrors = episodicLoadStats.getParseErrors();
        StringBuilder sbU = a8.b.u("[loadPendingFromFile] done: file=", totalLines, str, ", lines=", " result=");
        a8.b.z(sbU, size, " skipped(nonPending=", skippedNonPending, ", dup=");
        sbU.append(skippedDuplicate);
        sbU.append("), parseErrors=");
        sbU.append(parseErrors);
        return sbU.toString();
    }

    public static /* synthetic */ Object markPendingAsEvolved$default(OfflineEvolutionService offlineEvolutionService, String str, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        return offlineEvolutionService.markPendingAsEvolved(str, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String markPendingAsEvolved$lambda$1(String str, int i8) {
        return "[markPendingAsEvolved] " + str + ": " + i8 + " entries pending → evolved";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String maybeAutoTrigger$lambda$0() {
        return "[maybeAutoTrigger] threshold reached (>= 64), starting evolution pipeline";
    }

    private final File memoryIndexMapFile() {
        return new File(this.storageRoot, "stepmem/.offline_memory_index_map.json");
    }

    private final long parseCreateAtToEpochSeconds(String iso8601) {
        if (n.t1(iso8601)) {
            return System.currentTimeMillis() / 1000;
        }
        try {
            return Instant.parse(iso8601).getEpochSecond();
        } catch (Exception unused) {
            return System.currentTimeMillis() / 1000;
        }
    }

    public static /* synthetic */ Object runPipeline$default(OfflineEvolutionService offlineEvolutionService, String str, String str2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        return offlineEvolutionService.runPipeline(str, str2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$1() {
        return "runPipeline: no pending episodic entries";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$10(OfflineUpdateResponse offlineUpdateResponse) {
        return m0.f.c("offline_update: skip apply (requires task_status=completed), got ", AsyncTaskStatusKt.effectiveTaskStatus(offlineUpdateResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$11(int i8) {
        return a8.b.k(i8, "[runPipeline] pipeline succeeded, marked ", " pending → evolved");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$12() {
        return "[runPipeline] pipeline did not apply results, keeping entries as pending for retry";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$13(OfflineUpdateResponse offlineUpdateResponse, boolean z) {
        return "offline evolution pipeline done: updateStatus=" + offlineUpdateResponse.getStatus() + " appliedLocal=" + z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$2() {
        return "offline_trigger: request failed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$3() {
        return "offline_trigger failed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$4(y yVar) {
        return a8.b.p("offline_trigger not success: status=", ((OfflineTriggerResponse) yVar.f3686a).getStatus(), " msg=", ((OfflineTriggerResponse) yVar.f3686a).getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$6(w wVar) {
        return a8.b.k(wVar.f3684a, "offline_trigger poll#", " failed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$8() {
        return "offline_update: terminal or request failed";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runPipeline$lambda$9() {
        return "offline_update failed";
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0693, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x031e, code lost:
    
        r5 = r0.storage;
        r7.L$0 = null;
        r7.L$1 = r1;
        r7.L$2 = r2;
        r7.L$3 = r3;
        r7.L$4 = r4;
        r11 = r41;
        r7.L$5 = r11;
        r7.L$6 = null;
        r7.L$7 = r8;
        r7.L$8 = null;
        r7.L$9 = null;
        r7.L$10 = null;
        r7.L$11 = null;
        r7.L$12 = null;
        r7.L$13 = null;
        r7.I$0 = r6;
        r7.I$1 = r15;
        r7.I$2 = r14;
        r7.I$3 = r13;
        r7.I$4 = r12;
        r7.I$5 = r19;
        r19 = r1;
        r7.I$6 = r17;
        r7.I$7 = r42;
        r7.I$8 = r18;
        r7.label = 1;
        r5 = r5.markDocumentAsDeprecated(r8, r7);
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0364, code lost:
    
        if (r5 != r1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0369, code lost:
    
        r43 = r1;
        r41 = r5;
        r1 = r6;
        r16 = r9;
        r6 = r14;
        r9 = r15;
        r5 = r4;
        r14 = r12;
        r15 = r13;
        r12 = r17;
        r17 = r18;
        r4 = r3;
        r13 = r19;
        r10 = r42;
        r3 = r2;
        r2 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x04ea, code lost:
    
        r42 = r12;
        r19 = r13;
        r43 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x04f1, code lost:
    
        r11 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x04f4, code lost:
    
        r10 = com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem.copy$default(r29, null, 0.0d, null, null, com.stepos.stepclaw.memory.lightmem.evolution.EpisodicMemoryEvolutionState.EVOLVED, null, null, 111, null);
        r12 = r1.storage;
        r7.L$0 = null;
        r7.L$1 = r8;
        r7.L$2 = r2;
        r7.L$3 = r3;
        r7.L$4 = null;
        r7.L$5 = r4;
        r7.L$6 = r0;
        r7.L$7 = null;
        r7.L$8 = r9;
        r7.L$9 = null;
        r7.L$10 = r11;
        r7.L$11 = null;
        r7.L$12 = r10;
        r7.L$13 = null;
        r7.I$0 = r6;
        r7.I$1 = r15;
        r14 = r43;
        r7.I$2 = r14;
        r13 = r19;
        r7.I$3 = r13;
        r19 = r0;
        r7.I$4 = r42;
        r7.I$5 = r41;
        r7.I$6 = r18;
        r7.I$7 = r17;
        r7.I$8 = r28;
        r7.label = 3;
        r23 = r2;
        r25 = r7;
        r22 = r10;
        r21 = r11;
        r2 = com.stepos.stepclaw.memory.storage.MemoryStorage.writeMemory$default(r12, r21, r22, r23, null, r25, 8, null);
        r7 = r16;
        r20 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0566, code lost:
    
        if (r2 != r7) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x056b, code lost:
    
        r24 = r5;
        r5 = r6;
        r43 = r7;
        r12 = r15;
        r11 = r17;
        r0 = r18;
        r15 = r19;
        r10 = r25;
        r7 = r41;
        r6 = r42;
        r41 = r2;
        r2 = r23;
        r23 = r28;
     */
    /* JADX WARN: Path cross not found for [B:57:0x03d7, B:60:0x03ef], limit reached: 125 */
    /* JADX WARN: Removed duplicated region for block: B:107:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0650  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x03f7 -> B:42:0x02e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x041d -> B:42:0x02e2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0445 -> B:65:0x0460). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0466 -> B:68:0x0488). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x05ef -> B:91:0x05fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0613 -> B:92:0x0610). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object applyEvolutionResult(com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse r41, java.util.Map<java.lang.Long, java.lang.String> r42, java.lang.String r43, f5.c r44) {
        /*
            Method dump skipped, instructions count: 1781
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService.applyEvolutionResult(com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse, java.util.Map, java.lang.String, f5.c):java.lang.Object");
    }

    public final void cacheTriggerResponse(OfflineTriggerResponse response) {
        kotlin.jvm.internal.p.e(response, "response");
        this.cachedTriggerResponse = response;
        MemoryLogger.logD$default(this.logger, TAG, null, new h(2, response), 2, null);
    }

    public final void cacheUpdateUniqueId(String uniqueId) {
        kotlin.jvm.internal.p.e(uniqueId, "uniqueId");
        String string = n.T1(uniqueId).toString();
        if (string.length() <= 0) {
            string = null;
        }
        this.lastUpdateUniqueId = string;
    }

    public final void clearCachedTriggerData() {
        this.cachedTriggerResponse = null;
        this.lastMemoryIndexToDocId = null;
        this.lastUpdateUniqueId = null;
        MemoryLogger.logD$default(this.logger, TAG, null, new a4.b(17), 2, null);
    }

    public final int clearStaleCaches() {
        w wVar = new w();
        try {
            if (memoryIndexMapFile().delete()) {
                wVar.f3684a++;
            }
        } catch (Exception e9) {
            MemoryLogger.logW$default(this.logger, TAG, null, new i(e9, 1), 2, null);
        }
        this.cachedTriggerResponse = null;
        this.lastMemoryIndexToDocId = null;
        this.lastUpdateUniqueId = null;
        MemoryLogger.logI$default(this.logger, TAG, null, new a(1, wVar), 2, null);
        return wVar.f3684a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int countPendingEpisodic() {
        MemoryFileManager memoryFileManager = new MemoryFileManager(this.storageRoot, null, 2, 0 == true ? 1 : 0);
        Iterator<String> it = memoryFileManager.listDates("episodic").iterator();
        int i8 = 0;
        while (it.hasNext()) {
            DailyMemoryFile dailyFile = memoryFileManager.getDailyFile("episodic", it.next());
            if (dailyFile.getExists()) {
                Iterator it2 = n.y1(dailyFile.readRawContent()).iterator();
                while (it2.hasNext()) {
                    String string = n.T1((String) it2.next()).toString();
                    if (string.length() != 0 && u.c1(string, "{", false)) {
                        try {
                            Json json = episodicLineJson;
                            json.getSerializersModule();
                            if (kotlin.jvm.internal.p.a(EpisodicMemoryEvolutionState.INSTANCE.normalizeState(((CatchMemoryItem) json.decodeFromString(CatchMemoryItem.INSTANCE.serializer(), string)).getState()), EpisodicMemoryEvolutionState.PENDING)) {
                                i8++;
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return i8;
    }

    public final OfflineTriggerResponse getCachedTriggerResponse() {
        return this.cachedTriggerResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<OfflineTriggerMessageItem> loadAllPendingEpisodic() {
        MemoryLogger.logD$default(this.logger, TAG, null, new h(3, this), 2, null);
        MemoryFileManager memoryFileManager = new MemoryFileManager(this.storageRoot, null, 2, 0 == true ? 1 : 0);
        List<String> listListDates = memoryFileManager.listDates("episodic");
        MemoryLogger.logD$default(this.logger, TAG, null, new h(5, listListDates), 2, null);
        EpisodicLoadStats episodicLoadStats = new EpisodicLoadStats();
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it = listListDates.iterator();
        while (it.hasNext()) {
            DailyMemoryFile dailyFile = memoryFileManager.getDailyFile("episodic", it.next());
            if (dailyFile.getExists()) {
                collectPendingFromDaily(dailyFile, arrayList, linkedHashSet, episodicLoadStats);
            }
        }
        List<OfflineTriggerMessageItem> listJ0 = m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$loadAllPendingEpisodic$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l(Long.valueOf(((OfflineTriggerMessageItem) t8).getCreate_at()), Long.valueOf(((OfflineTriggerMessageItem) t9).getCreate_at()));
            }
        });
        MemoryLogger.logD$default(this.logger, TAG, null, new d(episodicLoadStats, 1, listJ0), 2, null);
        return listJ0;
    }

    public final Map<Long, String> loadMemoryIndexToDocIdMap() {
        String content;
        t tVar = t.f1093a;
        Map<Long, String> map = this.lastMemoryIndexToDocId;
        if (map != null) {
            return map;
        }
        try {
            File fileMemoryIndexMapFile = memoryIndexMapFile();
            if (fileMemoryIndexMapFile.isFile()) {
                Object toJsonElement = Json.INSTANCE.parseToJsonElement(l.E0(fileMemoryIndexMapFile, x5.a.f6276a));
                if (toJsonElement instanceof JsonObject) {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : ((Map) toJsonElement).entrySet()) {
                        String str = (String) entry.getKey();
                        JsonElement jsonElement = (JsonElement) entry.getValue();
                        Long lF1 = u.f1(str);
                        b5.g gVar = null;
                        if (lF1 != null) {
                            JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
                            if (jsonPrimitive != null && (content = jsonPrimitive.getContent()) != null) {
                                gVar = new b5.g(lF1, content);
                            }
                        }
                        if (gVar != null) {
                            arrayList.add(gVar);
                        }
                    }
                    return z.V(arrayList);
                }
            }
        } catch (Exception unused) {
        }
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<OfflineTriggerMessageItem> loadPendingFromFile(final String fileName) {
        kotlin.jvm.internal.p.e(fileName, "fileName");
        final File file = new File(new File(this.storageRoot, "stepmem/episodic"), fileName);
        final int i8 = 0;
        MemoryLogger.logD$default(this.logger, TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.lightmem.evolution.f
            @Override // p5.a
            public final Object invoke() {
                int i9 = i8;
                File file2 = file;
                switch (i9) {
                    case 0:
                        return OfflineEvolutionService.loadPendingFromFile$lambda$0(file2);
                    default:
                        return OfflineEvolutionService.loadPendingFromFile$lambda$1(file2);
                }
            }
        }, 2, null);
        if (!file.exists()) {
            MemoryLogger memoryLogger = this.logger;
            final int i9 = 1;
            MemoryLogger.logW$default(memoryLogger, TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.lightmem.evolution.f
                @Override // p5.a
                public final Object invoke() {
                    int i92 = i9;
                    File file2 = file;
                    switch (i92) {
                        case 0:
                            return OfflineEvolutionService.loadPendingFromFile$lambda$0(file2);
                        default:
                            return OfflineEvolutionService.loadPendingFromFile$lambda$1(file2);
                    }
                }
            }, 2, null);
            return s.f1092a;
        }
        DailyMemoryFile dailyFile = new MemoryFileManager(this.storageRoot, null, 2, 0 == true ? 1 : 0).getDailyFile("episodic", n.C1(fileName, MemoryFile.EXTENSION));
        final EpisodicLoadStats episodicLoadStats = new EpisodicLoadStats();
        ArrayList arrayList = new ArrayList();
        collectPendingFromDaily(dailyFile, arrayList, new LinkedHashSet(), episodicLoadStats);
        final List<OfflineTriggerMessageItem> listJ0 = m.J0(arrayList, new Comparator() { // from class: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$loadPendingFromFile$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l(Long.valueOf(((OfflineTriggerMessageItem) t8).getCreate_at()), Long.valueOf(((OfflineTriggerMessageItem) t9).getCreate_at()));
            }
        });
        MemoryLogger.logD$default(this.logger, TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.lightmem.evolution.g
            @Override // p5.a
            public final Object invoke() {
                return OfflineEvolutionService.loadPendingFromFile$lambda$3(fileName, episodicLoadStats, listJ0);
            }
        }, 2, null);
        return listJ0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object markPendingAsEvolved(java.lang.String r8, f5.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService.C00491
            if (r0 == 0) goto L14
            r0 = r9
            com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$markPendingAsEvolved$1 r0 = (com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService.C00491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$markPendingAsEvolved$1 r0 = new com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService$markPendingAsEvolved$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.result
            g5.a r0 = g5.a.f2984a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r8 = r6.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r6.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r6.L$0
            java.lang.String r0 = (java.lang.String) r0
            a.a.c0(r9)
            goto L78
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            a.a.c0(r9)
            r9 = 0
            if (r8 == 0) goto L54
            java.lang.CharSequence r8 = x5.n.T1(r8)
            java.lang.String r8 = r8.toString()
            if (r8 == 0) goto L54
            int r1 = r8.length()
            if (r1 <= 0) goto L54
            goto L55
        L54:
            r8 = r9
        L55:
            if (r8 == 0) goto L5f
            java.lang.String r1 = ".jsonl"
            java.lang.String r8 = x5.n.C1(r8, r1)
            r5 = r8
            goto L60
        L5f:
            r5 = r9
        L60:
            com.stepos.stepclaw.memory.storage.MemoryStorage r1 = r7.storage
            r6.L$0 = r9
            r6.L$1 = r9
            r6.L$2 = r5
            r6.label = r2
            java.lang.String r2 = "episodic"
            java.lang.String r3 = "pending"
            java.lang.String r4 = "evolved"
            java.lang.Object r9 = r1.bulkUpdateState(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L77
            return r0
        L77:
            r8 = r5
        L78:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 <= 0) goto L94
            if (r8 != 0) goto L84
            java.lang.String r8 = "all"
        L84:
            com.stepos.stepclaw.memory.utils.MemoryLogger r0 = r7.logger
            com.stepos.stepclaw.memory.embedding.h r3 = new com.stepos.stepclaw.memory.embedding.h
            r7 = 2
            r3.<init>(r8, r9, r7)
            r4 = 2
            r5 = 0
            java.lang.String r1 = "OfflineEvoService"
            r2 = 0
            com.stepos.stepclaw.memory.utils.MemoryLogger.logD$default(r0, r1, r2, r3, r4, r5)
        L94:
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService.markPendingAsEvolved(java.lang.String, f5.c):java.lang.Object");
    }

    public final void maybeAutoTrigger(f0 scope, String sessionId) {
        kotlin.jvm.internal.p.e(scope, "scope");
        this.logger.logI(TAG, sessionId, new a4.b(18));
        h6.e eVar = r0.f210a;
        i0.q(scope, h6.d.f3059c, new AnonymousClass2(sessionId, null), 2);
    }

    public final void persistMemoryIndexToDocIdMap(Map<Long, String> map) {
        kotlin.jvm.internal.p.e(map, "map");
        this.lastMemoryIndexToDocId = map;
        try {
            File fileMemoryIndexMapFile = memoryIndexMapFile();
            File parentFile = fileMemoryIndexMapFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            for (Map.Entry<Long, String> entry : map.entrySet()) {
                jsonObjectBuilder.put(String.valueOf(entry.getKey().longValue()), JsonElementKt.JsonPrimitive(entry.getValue()));
            }
            l.G0(fileMemoryIndexMapFile, Json.INSTANCE.encodeToString(JsonElement.INSTANCE.serializer(), jsonObjectBuilder.build()), x5.a.f6276a);
        } catch (Exception unused) {
        }
    }

    public final String readLastTriggerUniqueId() {
        String strEffectiveUniqueId;
        OfflineTriggerResponse offlineTriggerResponse = this.cachedTriggerResponse;
        if (offlineTriggerResponse == null || (strEffectiveUniqueId = AsyncTaskStatusKt.effectiveUniqueId(offlineTriggerResponse)) == null || n.t1(strEffectiveUniqueId)) {
            return null;
        }
        return strEffectiveUniqueId;
    }

    public final String readLastUpdateUniqueId() {
        String str = this.lastUpdateUniqueId;
        if (str == null || n.t1(str)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x05f8, code lost:
    
        if (r0 == r5) goto L152;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x038a A[Catch: Exception -> 0x038f, TryCatch #1 {Exception -> 0x038f, blocks: (B:87:0x037a, B:89:0x038a, B:92:0x0396), top: B:188:0x037a }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03dc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0378 -> B:188:0x037a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runPipeline(java.lang.String r29, java.lang.String r30, f5.c r31) {
        /*
            Method dump skipped, instructions count: 1998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService.runPipeline(java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    public /* synthetic */ OfflineEvolutionService(LightMemClient lightMemClient, MemoryStorage memoryStorage, MemoryIndexManager memoryIndexManager, File file, MemoryLogger memoryLogger, p5.a aVar, EmbeddingStorage embeddingStorage, int i8, kotlin.jvm.internal.i iVar) {
        this(lightMemClient, memoryStorage, memoryIndexManager, file, memoryLogger, aVar, (i8 & 64) != 0 ? null : embeddingStorage);
    }
}
