package com.stepos.stepclaw.memory.storage.index;

import a6.b0;
import a6.f0;
import a6.h1;
import a6.i0;
import a6.r0;
import a6.x1;
import b5.a0;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.cache.TieredCacheConfig;
import com.stepos.stepclaw.memory.storage.file.DailyMemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryFileManager;
import com.stepos.stepclaw.memory.storage.file.MemoryRecord;
import com.stepos.stepclaw.memory.storage.file.SingleMemoryFile;
import com.stepos.stepclaw.memory.storage.index.BM25Index;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import com.stepos.stepclaw.memory.storage.persist.FileIndexState;
import com.stepos.stepclaw.memory.storage.persist.IndexPersistence;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import com.stepos.stepclaw.memory.utils.PerfTrace;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.w;
import org.json.JSONException;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001a\u0010\u0010J\u001d\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u001e\u0010\u001fJZ\u0010 \u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010 \u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\b\b\u0002\u0010(\u001a\u00020'H\u0086@¢\u0006\u0004\b \u0010+J\u0010\u0010,\u001a\u00020!H\u0086@¢\u0006\u0004\b,\u0010\u0010J\u0010\u0010-\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b-\u0010\u0010J\u0010\u0010.\u001a\u00020!H\u0086@¢\u0006\u0004\b.\u0010\u0010J\u0010\u0010/\u001a\u00020!H\u0086@¢\u0006\u0004\b/\u0010\u0010J\u0018\u00101\u001a\u00020!2\u0006\u00100\u001a\u00020!H\u0086@¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0013¢\u0006\u0004\b3\u00104J\r\u00106\u001a\u000205¢\u0006\u0004\b6\u00107J\u0013\u00109\u001a\b\u0012\u0004\u0012\u0002080)¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\b¢\u0006\u0004\b;\u0010<J\u001e\u0010>\u001a\u00020\u000e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00150)H\u0086@¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020!H\u0086@¢\u0006\u0004\b@\u0010\u0010J\u0018\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u0015H\u0086@¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020!H\u0002¢\u0006\u0004\bD\u0010EJ'\u0010G\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\u0015H\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020!H\u0002¢\u0006\u0004\bI\u0010EJ\u001f\u0010J\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0004\bJ\u0010KJ\u001f\u0010P\u001a\u00020!2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010R\u001a\u00020!2\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bR\u0010QJ\u001f\u0010T\u001a\u00020'2\u0006\u0010M\u001a\u00020S2\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\bV\u0010WJ\u001f\u0010X\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\u000eH\u0002¢\u0006\u0004\bZ\u0010[J\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0002¢\u0006\u0004\b\\\u0010:J\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00110)2\u0006\u0010M\u001a\u00020\u0002H\u0002¢\u0006\u0004\b]\u0010^J!\u0010`\u001a\u0004\u0018\u00010\u00112\u0006\u0010_\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020!H\u0002¢\u0006\u0004\bb\u0010ER\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010d\u001a\u0004\be\u0010fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010gR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010hR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010iR\u0017\u0010k\u001a\u00020j8\u0006¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001a\u0010p\u001a\u00020o8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0014\u0010u\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010w\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00150y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u007f\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010xR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0083\u0001\u001a\u00020t8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010vR\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001¨\u0006\u0088\u0001"}, d2 = {"Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "baseDir", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "fileManager", "Lcom/stepos/stepclaw/memory/storage/index/BM25Config;", "bm25Config", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "cacheConfig", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Ljava/io/File;Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;Lcom/stepos/stepclaw/memory/storage/index/BM25Config;Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lb5/a0;", "initialize", "(Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "record", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "createdAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "date", "indexNewEntry", "(Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;JLjava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "persistIndexNow", "resolveDate", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "entryId", "buildDocId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "query", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "topK", "dateFrom", "dateTo", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "useDefaultDateRange", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/MemoryEntry;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Set;ZLf5/c;)Ljava/lang/Object;", "refreshIndex", "rebuildIndex", "unloadDynamicIndex", "reloadDynamicIndex", "additionalDays", "loadMoreDynamicHistory", "(ILf5/c;)Ljava/lang/Object;", "estimateMemoryUsage", "()J", "Lcom/stepos/stepclaw/memory/storage/index/BM25CacheStats;", "getCacheStats", "()Lcom/stepos/stepclaw/memory/storage/index/BM25CacheStats;", "Lcom/stepos/stepclaw/memory/storage/index/BM25Index$CategoryDateStats;", "getCategoryDateStats", "()Ljava/util/List;", "getCacheConfig", "()Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "docIds", "recordAccess", "(Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "compactDynamicCache", "docId", "removeDocument", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "loadPermanentIndexOptimized", "()I", "today", "loadDynamicIndexOptimized", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I", "loadPermanentIndex", "loadDynamicIndex", "(Ljava/lang/String;Ljava/lang/String;)I", "Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;", "file", "Lcom/stepos/stepclaw/memory/storage/index/IndexTier;", "tier", "indexSingleFile", "(Lcom/stepos/stepclaw/memory/storage/file/SingleMemoryFile;Lcom/stepos/stepclaw/memory/storage/index/IndexTier;)I", "indexSingleFileForced", "Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;", "indexDailyFile", "(Lcom/stepos/stepclaw/memory/storage/file/DailyMemoryFile;Lcom/stepos/stepclaw/memory/storage/index/IndexTier;)Z", "indexRecord", "(Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;)V", "indexRecordWithCreatedAt", "(Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;J)V", "scheduleCompactionIfNeeded", "()V", "scanLegacyMemoryFiles", "extractLegacyRecords", "(Ljava/io/File;)Ljava/util/List;", "line", "parseLegacyRecord", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "indexLegacyFiles", "Ljava/io/File;", "Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "getFileManager", "()Lcom/stepos/stepclaw/memory/storage/file/MemoryFileManager;", "Lcom/stepos/stepclaw/memory/storage/index/BM25Config;", "Lcom/stepos/stepclaw/memory/storage/cache/TieredCacheConfig;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Lcom/stepos/stepclaw/memory/storage/index/BM25Index;", "index", "Lcom/stepos/stepclaw/memory/storage/index/BM25Index;", "getIndex", "()Lcom/stepos/stepclaw/memory/storage/index/BM25Index;", "Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;", "persistence", "Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;", "getPersistence$step_memory_release", "()Lcom/stepos/stepclaw/memory/storage/persist/IndexPersistence;", "Li6/a;", "indexMutex", "Li6/a;", "isInitialized", "Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "pendingPersistCategories", "Ljava/util/Set;", "La6/f0;", "compactionScope", "La6/f0;", "pendingCompaction", "La6/h1;", "compactionJob", "La6/h1;", "compactionMutex", "La6/b0;", "indexDispatcher", "La6/b0;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryIndexManager {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final int DEFAULT_SEARCH_DAYS = 30;
    public static final String LEGACY_CATEGORY = "legacy";
    private static final String LEGACY_MEMORY_DIR = "memory";
    private static final String TAG = "MemoryIndexManager";
    private final File baseDir;
    private final BM25Config bm25Config;
    private final TieredCacheConfig cacheConfig;
    private volatile h1 compactionJob;
    private final i6.a compactionMutex;
    private final f0 compactionScope;
    private final MemoryFileManager fileManager;
    private final BM25Index index;
    private final b0 indexDispatcher;
    private final i6.a indexMutex;
    private volatile boolean isInitialized;
    private final MemoryLogger logger;
    private volatile boolean pendingCompaction;
    private final Set<String> pendingPersistCategories;
    private final IndexPersistence persistence;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$compactDynamicCache$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$compactDynamicCache$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p5.p {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new AnonymousClass2(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            i6.a aVar;
            MemoryIndexManager memoryIndexManager;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar3;
                this.L$1 = memoryIndexManager2;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                aVar = cVar;
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                int iCompactDynamic$default = BM25Index.compactDynamic$default(memoryIndexManager.getIndex(), 0L, 1, null);
                if (iCompactDynamic$default > 0) {
                    memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                }
                Integer num = new Integer(iCompactDynamic$default);
                ((i6.c) aVar).e(null);
                return num;
            } catch (Throwable th) {
                ((i6.c) aVar).e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager", f = "MemoryIndexManager.kt", l = {452}, m = "indexNewEntry", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryIndexManager.this.indexNewEntry(null, 0L, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00572 extends h5.i implements p5.p {
        final /* synthetic */ String $category;
        final /* synthetic */ long $createdAt;
        final /* synthetic */ MemoryRecord $record;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00572(MemoryRecord memoryRecord, long j4, String str, f5.c cVar) {
            super(2, cVar);
            this.$record = memoryRecord;
            this.$createdAt = j4;
            this.$category = str;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00572(this.$record, this.$createdAt, this.$category, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00572) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            MemoryIndexManager memoryIndexManager;
            MemoryRecord memoryRecord;
            String str;
            i6.a aVar;
            long j4;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                memoryIndexManager = MemoryIndexManager.this;
                memoryRecord = this.$record;
                long j8 = this.$createdAt;
                str = this.$category;
                this.L$0 = aVar3;
                this.L$1 = memoryIndexManager;
                this.L$2 = memoryRecord;
                this.L$3 = str;
                this.J$0 = j8;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                aVar = cVar;
                j4 = j8;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j4 = this.J$0;
                str = (String) this.L$3;
                memoryRecord = (MemoryRecord) this.L$2;
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                memoryIndexManager.indexRecordWithCreatedAt(memoryRecord, j4);
                if (memoryIndexManager.getIndex().getTierForCategory(str) == IndexTier.DYNAMIC && memoryIndexManager.getIndex().isDynamicFull()) {
                    memoryIndexManager.pendingCompaction = true;
                }
                ((i6.c) aVar).e(null);
                return a0.f883a;
            } catch (Throwable th) {
                ((i6.c) aVar).e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$initialize$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$initialize$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00582 extends h5.i implements p5.p {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C00582(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$0(String str) {
            return m0.f.d("Initializing memory index with tiered cache (today=", str, ")...");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$10(int i8) {
            return a8.b.k(i8, "Loaded ", " legacy documents from memory/");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$11(long j4, MemoryIndexManager memoryIndexManager, long j8, BM25CacheStats bM25CacheStats) {
            return "Memory index initialized in cost=" + j4 + "ms, total=" + memoryIndexManager.getIndex().getDocumentCount() + ", memory=" + j8 + "KB, cache=" + bM25CacheStats;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$2() {
            return "Loaded persisted meta, will use cached index when possible...";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$4(int i8) {
            return a8.b.k(i8, "Loaded ", " PERMANENT documents");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$6(int i8, String str, String str2) {
            StringBuilder sb = new StringBuilder("Loaded ");
            sb.append(i8);
            sb.append(" DYNAMIC documents (");
            sb.append(str);
            sb.append("..");
            return m0.f.f(sb, str2, ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$7(Set set) {
            return "Persisting changed indexes for: " + set;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00582(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00582) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v31, types: [i6.a] */
        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            i6.c cVar;
            final MemoryIndexManager memoryIndexManager;
            Object obj2;
            Boolean bool;
            String str;
            String str2;
            Boolean boolValueOf;
            Integer num;
            String str3;
            Integer num2;
            Integer num3;
            Integer num4;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            a0 a0Var = a0.f883a;
            if (i8 == 0) {
                a.a.c0(obj);
                if (MemoryIndexManager.this.isInitialized) {
                    return a0Var;
                }
                i6.a aVar2 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar2;
                this.L$1 = memoryIndexManager2;
                this.I$0 = 0;
                this.label = 1;
                cVar = (i6.c) aVar2;
                if (cVar.c(this) == aVar) {
                    return aVar;
                }
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                MemoryIndexManager memoryIndexManager3 = (MemoryIndexManager) this.L$1;
                ?? r02 = (i6.a) this.L$0;
                a.a.c0(obj);
                cVar = r02;
                memoryIndexManager = memoryIndexManager3;
            }
            try {
                if (!memoryIndexManager.isInitialized) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        String str4 = MemoryFile.INSTANCE.todayDate();
                        memoryIndexManager.pendingPersistCategories.clear();
                        MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new h(str4, 0), 2, null);
                        PerfTrace perfTrace = PerfTrace.INSTANCE;
                        if (perfTrace.getEnabled()) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            Boolean boolValueOf2 = Boolean.valueOf(memoryIndexManager.getPersistence().loadPersistedMeta());
                            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                            String str5 = ", success=" + boolValueOf2;
                            MemoryLogger logger = perfTrace.getLogger();
                            if (logger != null) {
                                bool = boolValueOf2;
                                str = MemoryIndexManager.TAG;
                                str2 = ", count=";
                                logger.logD(str, null, new PerfTrace.C00721("loadPersistedMeta", jCurrentTimeMillis3, str5, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                            } else {
                                bool = boolValueOf2;
                                str = MemoryIndexManager.TAG;
                                str2 = ", count=";
                            }
                            boolValueOf = bool;
                        } else {
                            boolValueOf = Boolean.valueOf(memoryIndexManager.getPersistence().loadPersistedMeta());
                            str = MemoryIndexManager.TAG;
                            str2 = ", count=";
                        }
                        if (boolValueOf.booleanValue()) {
                            MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new i(0), 2, null);
                        }
                        if (perfTrace.getEnabled()) {
                            long jCurrentTimeMillis4 = System.currentTimeMillis();
                            Integer num5 = new Integer(memoryIndexManager.loadPermanentIndexOptimized());
                            long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis4;
                            String str6 = str2;
                            String str7 = str6 + num5;
                            MemoryLogger logger2 = perfTrace.getLogger();
                            if (logger2 != null) {
                                num = num5;
                                str3 = str6;
                                logger2.logD(str, null, new PerfTrace.C00721("loadPermanentIndex", jCurrentTimeMillis5, str7, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                            } else {
                                num = num5;
                                str3 = str6;
                            }
                            num2 = num;
                        } else {
                            num2 = new Integer(memoryIndexManager.loadPermanentIndexOptimized());
                            str3 = str2;
                        }
                        MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new j(num2.intValue(), 0), 2, null);
                        b5.g dynamicDateRange = memoryIndexManager.getIndex().getDynamicDateRange();
                        String str8 = (String) dynamicDateRange.f892a;
                        String str9 = (String) dynamicDateRange.f893b;
                        String str10 = "loadDynamicIndex(" + str8 + ".." + str9 + ")";
                        if (perfTrace.getEnabled()) {
                            long jCurrentTimeMillis6 = System.currentTimeMillis();
                            num3 = new Integer(memoryIndexManager.loadDynamicIndexOptimized(str8, str9, str4));
                            long jCurrentTimeMillis7 = System.currentTimeMillis() - jCurrentTimeMillis6;
                            String str11 = str3 + num3;
                            MemoryLogger logger3 = perfTrace.getLogger();
                            if (logger3 != null) {
                                logger3.logD(str, null, new PerfTrace.C00721(str10, jCurrentTimeMillis7, str11, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                            }
                        } else {
                            num3 = new Integer(memoryIndexManager.loadDynamicIndexOptimized(str8, str9, str4));
                        }
                        MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new k(num3.intValue(), str8, str9), 2, null);
                        if (!memoryIndexManager.pendingPersistCategories.isEmpty()) {
                            MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new l(0, c5.m.R0(memoryIndexManager.pendingPersistCategories)), 2, null);
                            if (perfTrace.getEnabled()) {
                                long jCurrentTimeMillis8 = System.currentTimeMillis();
                                memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                                MemoryLogger logger4 = perfTrace.getLogger();
                                if (logger4 != null) {
                                    logger4.logD(str, null, new PerfTrace.AnonymousClass1("persistChangedIndexes", jCurrentTimeMillis8, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                                }
                            } else {
                                memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                            }
                        }
                        if (perfTrace.getEnabled()) {
                            long jCurrentTimeMillis9 = System.currentTimeMillis();
                            Integer num6 = new Integer(memoryIndexManager.indexLegacyFiles());
                            long jCurrentTimeMillis10 = System.currentTimeMillis() - jCurrentTimeMillis9;
                            String str12 = str3 + num6;
                            MemoryLogger logger5 = perfTrace.getLogger();
                            if (logger5 != null) {
                                num4 = num6;
                                logger5.logD(str, null, new PerfTrace.C00721("indexLegacyFiles", jCurrentTimeMillis10, str12, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                            } else {
                                num4 = num6;
                            }
                        } else {
                            num4 = new Integer(memoryIndexManager.indexLegacyFiles());
                        }
                        int iIntValue = num4.intValue();
                        if (iIntValue > 0) {
                            MemoryLogger.logI$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new j(iIntValue, 1), 2, null);
                        }
                        final long jCurrentTimeMillis11 = System.currentTimeMillis() - jCurrentTimeMillis;
                        final BM25CacheStats cacheStats = memoryIndexManager.getIndex().getCacheStats();
                        final long jEstimateMemoryUsage = memoryIndexManager.estimateMemoryUsage() / 1024;
                        MemoryLogger.logI$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.index.m
                            @Override // p5.a
                            public final Object invoke() {
                                return MemoryIndexManager.C00582.invokeSuspend$lambda$0$11(jCurrentTimeMillis11, memoryIndexManager, jEstimateMemoryUsage, cacheStats);
                            }
                        }, 2, null);
                        memoryIndexManager.isInitialized = true;
                    } catch (Throwable th) {
                        th = th;
                        obj2 = null;
                        cVar.e(obj2);
                        throw th;
                    }
                }
                cVar.e(null);
                return a0Var;
            } catch (Throwable th2) {
                th = th2;
                obj2 = null;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$loadMoreDynamicHistory$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$loadMoreDynamicHistory$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00592 extends h5.i implements p5.p {
        final /* synthetic */ int $additionalDays;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00592(int i8, f5.c cVar) {
            super(2, cVar);
            this.$additionalDays = i8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$2() {
            return "DYNAMIC cache full while loading history";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$3(w wVar, String str) {
            return "Loaded " + wVar.f3684a + " more DYNAMIC history from " + str;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00592(this.$additionalDays, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00592) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13, types: [i6.a] */
        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            MemoryIndexManager memoryIndexManager;
            i6.c cVar;
            int i8;
            g5.a aVar = g5.a.f2984a;
            int i9 = this.label;
            int i10 = 0;
            if (i9 == 0) {
                a.a.c0(obj);
                i6.a aVar2 = MemoryIndexManager.this.indexMutex;
                memoryIndexManager = MemoryIndexManager.this;
                int i11 = this.$additionalDays;
                this.L$0 = aVar2;
                this.L$1 = memoryIndexManager;
                this.I$0 = i11;
                this.I$1 = 0;
                this.label = 1;
                cVar = (i6.c) aVar2;
                if (cVar.c(this) == aVar) {
                    return aVar;
                }
                i8 = i11;
            } else {
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i8 = this.I$0;
                MemoryIndexManager memoryIndexManager2 = (MemoryIndexManager) this.L$1;
                ?? r02 = (i6.a) this.L$0;
                a.a.c0(obj);
                memoryIndexManager = memoryIndexManager2;
                cVar = r02;
            }
            try {
                String dynamicOldestDate = memoryIndexManager.getIndex().getCacheStats().getDynamicOldestDate();
                if (dynamicOldestDate != null) {
                    Calendar calendar = Calendar.getInstance();
                    Date date = MemoryIndexManager.DATE_FORMAT.parse(dynamicOldestDate);
                    if (date != null) {
                        calendar.setTime(date);
                        calendar.add(6, -i8);
                        String str = MemoryIndexManager.DATE_FORMAT.format(calendar.getTime());
                        w wVar = new w();
                        List<String> listListCategories = memoryIndexManager.getFileManager().listCategories();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : listListCategories) {
                            if (!memoryIndexManager.cacheConfig.getPermanentCategories().contains((String) obj2)) {
                                arrayList.add(obj2);
                            }
                        }
                        int size = arrayList.size();
                        int i12 = 0;
                        loop1: while (true) {
                            if (i12 < size) {
                                Object obj3 = arrayList.get(i12);
                                i12++;
                                String str2 = (String) obj3;
                                List<String> listListDates = memoryIndexManager.getFileManager().listDates(str2);
                                ArrayList arrayList2 = new ArrayList();
                                for (Object obj4 : listListDates) {
                                    String value = (String) obj4;
                                    kotlin.jvm.internal.p.b(str);
                                    kotlin.jvm.internal.p.e(value, "value");
                                    if (value.compareTo(str) >= 0 && value.compareTo(dynamicOldestDate) < 0) {
                                        arrayList2.add(obj4);
                                    }
                                }
                                int size2 = arrayList2.size();
                                int i13 = 0;
                                while (i13 < size2) {
                                    Object obj5 = arrayList2.get(i13);
                                    i13++;
                                    String str3 = (String) obj5;
                                    if (memoryIndexManager.getIndex().isDynamicFull()) {
                                        MemoryLogger.logW$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new i(1), 2, null);
                                        i10 = wVar.f3684a;
                                        break loop1;
                                    }
                                    if (memoryIndexManager.indexDailyFile(memoryIndexManager.getFileManager().getDailyFile(str2, str3), IndexTier.DYNAMIC)) {
                                        wVar.f3684a++;
                                    }
                                }
                            } else {
                                if (wVar.f3684a > 0) {
                                    memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                                }
                                MemoryLogger.logI$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new n(wVar, str, 0), 2, null);
                                i10 = wVar.f3684a;
                            }
                        }
                    }
                }
                Integer num = new Integer(i10);
                cVar.e(null);
                return num;
            } catch (Throwable th) {
                cVar.e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$persistIndexNow$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$persistIndexNow$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00602 extends h5.i implements p5.p {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C00602(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1() {
            return "persistIndexNow: index.json written";
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00602(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00602) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            MemoryIndexManager memoryIndexManager;
            i6.a aVar;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar3;
                this.L$1 = memoryIndexManager2;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                memoryIndexManager = memoryIndexManager2;
                aVar = cVar;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                ((i6.c) aVar).e(null);
                MemoryLogger.logD$default(MemoryIndexManager.this.logger, MemoryIndexManager.TAG, null, new i(2), 2, null);
                return a0.f883a;
            } catch (Throwable th) {
                ((i6.c) aVar).e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/MemoryEntry;", "<anonymous>", "(La6/f0;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$query$2", f = "MemoryIndexManager.kt", l = {520, 798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$query$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00612 extends h5.i implements p5.p {
        final /* synthetic */ Set<String> $categories;
        final /* synthetic */ String $dateFrom;
        final /* synthetic */ String $dateTo;
        final /* synthetic */ String $query;
        final /* synthetic */ int $topK;
        final /* synthetic */ boolean $useDefaultDateRange;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00612(boolean z, String str, String str2, String str3, int i8, Set<String> set, f5.c cVar) {
            super(2, cVar);
            this.$useDefaultDateRange = z;
            this.$dateFrom = str;
            this.$dateTo = str2;
            this.$query = str3;
            this.$topK = i8;
            this.$categories = set;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00612(this.$useDefaultDateRange, this.$dateFrom, this.$dateTo, this.$query, this.$topK, this.$categories, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00612) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00eb A[Catch: all -> 0x0119, TRY_LEAVE, TryCatch #0 {all -> 0x0119, blocks: (B:29:0x00ce, B:30:0x00e5, B:32:0x00eb, B:35:0x010f, B:43:0x011f, B:48:0x012b, B:49:0x0144), top: B:54:0x00ce }] */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instructions count: 349
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.C00612.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$rebuildIndex$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$rebuildIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00622 extends h5.i implements p5.p {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        public C00622(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$3(long j4) {
            return "[PERF] rebuildIndex total: cost=" + (System.currentTimeMillis() - j4) + "ms";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$4(int i8, int i9) {
            return a8.b.i(i8, i9, "Index rebuilt: permanent=", ", dynamic=");
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00622(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00622) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [i6.a] */
        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            final long jCurrentTimeMillis;
            i6.c cVar;
            MemoryIndexManager memoryIndexManager;
            Integer num;
            Integer num2;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                jCurrentTimeMillis = PerfTrace.INSTANCE.getEnabled() ? System.currentTimeMillis() : 0L;
                i6.a aVar2 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar2;
                this.L$1 = memoryIndexManager2;
                this.J$0 = jCurrentTimeMillis;
                this.I$0 = 0;
                this.label = 1;
                cVar = (i6.c) aVar2;
                if (cVar.c(this) == aVar) {
                    return aVar;
                }
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j4 = this.J$0;
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                ?? r02 = (i6.a) this.L$0;
                a.a.c0(obj);
                jCurrentTimeMillis = j4;
                cVar = r02;
            }
            try {
                memoryIndexManager.getIndex().clear();
                memoryIndexManager.getPersistence().clearFileStates();
                PerfTrace perfTrace = PerfTrace.INSTANCE;
                if (perfTrace.getEnabled()) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    Integer num3 = new Integer(memoryIndexManager.loadPermanentIndex());
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                    String str = ", count=" + num3;
                    MemoryLogger logger = perfTrace.getLogger();
                    if (logger != null) {
                        logger.logD(MemoryIndexManager.TAG, null, new PerfTrace.C00721("rebuildIndex.permanent", jCurrentTimeMillis3, str, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                    }
                    num = num3;
                } else {
                    num = new Integer(memoryIndexManager.loadPermanentIndex());
                }
                final int iIntValue = num.intValue();
                b5.g dynamicDateRange = memoryIndexManager.getIndex().getDynamicDateRange();
                String str2 = (String) dynamicDateRange.f892a;
                String str3 = (String) dynamicDateRange.f893b;
                if (perfTrace.getEnabled()) {
                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                    num2 = new Integer(memoryIndexManager.loadDynamicIndex(str2, str3));
                    long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis4;
                    String str4 = ", count=" + num2;
                    MemoryLogger logger2 = perfTrace.getLogger();
                    if (logger2 != null) {
                        logger2.logD(MemoryIndexManager.TAG, null, new PerfTrace.C00721("rebuildIndex.dynamic", jCurrentTimeMillis5, str4, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                    }
                } else {
                    num2 = new Integer(memoryIndexManager.loadDynamicIndex(str2, str3));
                }
                final int iIntValue2 = num2.intValue();
                if (perfTrace.getEnabled()) {
                    long jCurrentTimeMillis6 = System.currentTimeMillis();
                    memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                    MemoryLogger logger3 = perfTrace.getLogger();
                    if (logger3 != null) {
                        logger3.logD(MemoryIndexManager.TAG, null, new PerfTrace.AnonymousClass1("rebuildIndex.persist", jCurrentTimeMillis6, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                    }
                } else {
                    memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                }
                if (perfTrace.getEnabled()) {
                    MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.index.o
                        @Override // p5.a
                        public final Object invoke() {
                            return MemoryIndexManager.C00622.invokeSuspend$lambda$0$3(jCurrentTimeMillis);
                        }
                    }, 2, null);
                }
                MemoryLogger.logI$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.index.p
                    @Override // p5.a
                    public final Object invoke() {
                        return MemoryIndexManager.C00622.invokeSuspend$lambda$0$4(iIntValue, iIntValue2);
                    }
                }, 2, null);
                cVar.e(null);
                return a0.f883a;
            } catch (Throwable th) {
                cVar.e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$recordAccess$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$recordAccess$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00632 extends h5.i implements p5.p {
        final /* synthetic */ List<String> $docIds;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00632(List<String> list, f5.c cVar) {
            super(2, cVar);
            this.$docIds = list;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00632(this.$docIds, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00632) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            List<String> list;
            i6.a aVar;
            MemoryIndexManager memoryIndexManager;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                list = this.$docIds;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar3;
                this.L$1 = list;
                this.L$2 = memoryIndexManager2;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                aVar = cVar;
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memoryIndexManager = (MemoryIndexManager) this.L$2;
                list = (List) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    memoryIndexManager.getIndex().recordAccess((String) it.next());
                }
                ArrayList arrayList = new ArrayList(c5.o.n0(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(x5.n.N1((String) it2.next(), '#'));
                }
                memoryIndexManager.getPersistence().persistAccessStats(memoryIndexManager.getIndex(), c5.m.R0(arrayList));
                ((i6.c) aVar).e(null);
                return a0.f883a;
            } catch (Throwable th) {
                ((i6.c) aVar).e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$refreshIndex$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$refreshIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00642 extends h5.i implements p5.p {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;

        public C00642(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$3(long j4, w wVar) {
            return "[PERF] refreshIndex total: cost=" + (System.currentTimeMillis() - j4) + "ms, count=" + wVar.f3684a;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00642(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00642) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v7, types: [i6.a] */
        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            final long jCurrentTimeMillis;
            i6.c cVar;
            MemoryIndexManager memoryIndexManager;
            Integer num;
            Integer num2;
            Integer num3;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                jCurrentTimeMillis = PerfTrace.INSTANCE.getEnabled() ? System.currentTimeMillis() : 0L;
                i6.a aVar2 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar2;
                this.L$1 = memoryIndexManager2;
                this.J$0 = jCurrentTimeMillis;
                this.I$0 = 0;
                this.label = 1;
                cVar = (i6.c) aVar2;
                if (cVar.c(this) == aVar) {
                    return aVar;
                }
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                long j4 = this.J$0;
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                ?? r02 = (i6.a) this.L$0;
                a.a.c0(obj);
                jCurrentTimeMillis = j4;
                cVar = r02;
            }
            try {
                final w wVar = new w();
                int i9 = wVar.f3684a;
                PerfTrace perfTrace = PerfTrace.INSTANCE;
                if (perfTrace.getEnabled()) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    Integer num4 = new Integer(memoryIndexManager.loadPermanentIndex());
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis2;
                    String str = ", count=" + num4;
                    MemoryLogger logger = perfTrace.getLogger();
                    if (logger != null) {
                        num = num4;
                        logger.logD(MemoryIndexManager.TAG, null, new PerfTrace.C00721("refreshIndex.permanent", jCurrentTimeMillis3, str, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                    } else {
                        num = num4;
                    }
                    num2 = num;
                } else {
                    num2 = new Integer(memoryIndexManager.loadPermanentIndex());
                }
                wVar.f3684a = i9 + num2.intValue();
                b5.g dynamicDateRange = memoryIndexManager.getIndex().getDynamicDateRange();
                String str2 = (String) dynamicDateRange.f892a;
                String str3 = (String) dynamicDateRange.f893b;
                int i10 = wVar.f3684a;
                if (perfTrace.getEnabled()) {
                    long jCurrentTimeMillis4 = System.currentTimeMillis();
                    num3 = new Integer(memoryIndexManager.loadDynamicIndex(str2, str3));
                    long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis4;
                    String str4 = ", count=" + num3;
                    MemoryLogger logger2 = perfTrace.getLogger();
                    if (logger2 != null) {
                        logger2.logD(MemoryIndexManager.TAG, null, new PerfTrace.C00721("refreshIndex.dynamic", jCurrentTimeMillis5, str4, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                    }
                } else {
                    num3 = new Integer(memoryIndexManager.loadDynamicIndex(str2, str3));
                }
                int iIntValue = i10 + num3.intValue();
                wVar.f3684a = iIntValue;
                if (iIntValue > 0) {
                    if (perfTrace.getEnabled()) {
                        long jCurrentTimeMillis6 = System.currentTimeMillis();
                        memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                        MemoryLogger logger3 = perfTrace.getLogger();
                        if (logger3 != null) {
                            logger3.logD(MemoryIndexManager.TAG, null, new PerfTrace.AnonymousClass1("refreshIndex.persist", jCurrentTimeMillis6, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
                        }
                    } else {
                        memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                    }
                }
                if (perfTrace.getEnabled()) {
                    MemoryLogger.logD$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.index.q
                        @Override // p5.a
                        public final Object invoke() {
                            return MemoryIndexManager.C00642.invokeSuspend$lambda$0$3(jCurrentTimeMillis, wVar);
                        }
                    }, 2, null);
                }
                Integer num5 = new Integer(wVar.f3684a);
                cVar.e(null);
                return num5;
            } catch (Throwable th) {
                cVar.e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$reloadDynamicIndex$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$reloadDynamicIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00652 extends h5.i implements p5.p {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C00652(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$0(int i8) {
            return a8.b.k(i8, "Reloaded ", " DYNAMIC documents");
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00652(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00652) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            i6.a aVar;
            MemoryIndexManager memoryIndexManager;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar3;
                this.L$1 = memoryIndexManager2;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                aVar = cVar;
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                b5.g dynamicDateRange = memoryIndexManager.getIndex().getDynamicDateRange();
                int iLoadDynamicIndex = memoryIndexManager.loadDynamicIndex((String) dynamicDateRange.f892a, (String) dynamicDateRange.f893b);
                if (iLoadDynamicIndex > 0) {
                    memoryIndexManager.getPersistence().persistIndex(memoryIndexManager.getIndex());
                }
                MemoryLogger.logI$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new j(iLoadDynamicIndex, 2), 2, null);
                Integer num = new Integer(iLoadDynamicIndex);
                ((i6.c) aVar).e(null);
                return num;
            } catch (Throwable th) {
                ((i6.c) aVar).e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$removeDocument$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$removeDocument$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00662 extends h5.i implements p5.p {
        final /* synthetic */ String $docId;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00662(String str, f5.c cVar) {
            super(2, cVar);
            this.$docId = str;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00662(this.$docId, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00662) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            MemoryIndexManager memoryIndexManager;
            i6.a aVar;
            String str;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                memoryIndexManager = MemoryIndexManager.this;
                String str2 = this.$docId;
                this.L$0 = aVar3;
                this.L$1 = memoryIndexManager;
                this.L$2 = str2;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                aVar = cVar;
                str = str2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$2;
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                memoryIndexManager.getIndex().removeDocument(str);
                ((i6.c) aVar).e(null);
                return a0.f883a;
            } catch (Throwable th) {
                ((i6.c) aVar).e(null);
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$scheduleCompactionIfNeeded$1", f = "MemoryIndexManager.kt", l = {467, 798, 470}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$scheduleCompactionIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00671 extends h5.i implements p5.p {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public C00671(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00671(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00671) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0067 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #0 {all -> 0x0084, blocks: (B:23:0x0061, B:25:0x0067), top: B:36:0x0061 }] */
        /* JADX WARN: Type inference failed for: r10v11, types: [i6.a] */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v5 */
        /* JADX WARN: Type inference failed for: r5v4, types: [i6.a] */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                g5.a r0 = g5.a.f2984a
                int r1 = r10.label
                r2 = 0
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L38
                if (r1 == r5) goto L34
                if (r1 == r4) goto L25
                if (r1 != r3) goto L1d
                java.lang.Object r10 = r10.L$0
                i6.a r10 = (i6.a) r10
                a.a.c0(r11)     // Catch: java.lang.Throwable -> L1a
                goto L82
            L1a:
                r11 = move-exception
                goto L91
            L1d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L25:
                int r1 = r10.I$0
                java.lang.Object r4 = r10.L$1
                com.stepos.stepclaw.memory.storage.index.MemoryIndexManager r4 = (com.stepos.stepclaw.memory.storage.index.MemoryIndexManager) r4
                java.lang.Object r5 = r10.L$0
                i6.a r5 = (i6.a) r5
                a.a.c0(r11)
                r11 = r5
                goto L61
            L34:
                a.a.c0(r11)
                goto L46
            L38:
                a.a.c0(r11)
                r10.label = r5
                r7 = 100
                java.lang.Object r11 = a6.i0.g(r7, r10)
                if (r11 != r0) goto L46
                goto L80
            L46:
                com.stepos.stepclaw.memory.storage.index.MemoryIndexManager r11 = com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.this
                i6.a r11 = com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.access$getCompactionMutex$p(r11)
                com.stepos.stepclaw.memory.storage.index.MemoryIndexManager r1 = com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.this
                r10.L$0 = r11
                r10.L$1 = r1
                r10.I$0 = r2
                r10.label = r4
                i6.c r11 = (i6.c) r11
                java.lang.Object r4 = r11.c(r10)
                if (r4 != r0) goto L5f
                goto L80
            L5f:
                r4 = r1
                r1 = r2
            L61:
                boolean r5 = com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.access$getPendingCompaction$p(r4)     // Catch: java.lang.Throwable -> L84
                if (r5 == 0) goto L89
                a6.b0 r5 = com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.access$getIndexDispatcher$p(r4)     // Catch: java.lang.Throwable -> L84
                com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1 r7 = new com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$scheduleCompactionIfNeeded$1$1$1     // Catch: java.lang.Throwable -> L84
                r7.<init>(r4, r6)     // Catch: java.lang.Throwable -> L84
                r10.L$0 = r11     // Catch: java.lang.Throwable -> L84
                r10.L$1 = r6     // Catch: java.lang.Throwable -> L84
                r10.I$0 = r1     // Catch: java.lang.Throwable -> L84
                r10.I$1 = r2     // Catch: java.lang.Throwable -> L84
                r10.label = r3     // Catch: java.lang.Throwable -> L84
                java.lang.Object r10 = a6.i0.A(r5, r7, r10)     // Catch: java.lang.Throwable -> L84
                if (r10 != r0) goto L81
            L80:
                return r0
            L81:
                r10 = r11
            L82:
                r11 = r10
                goto L89
            L84:
                r10 = move-exception
                r9 = r11
                r11 = r10
                r10 = r9
                goto L91
            L89:
                i6.c r11 = (i6.c) r11
                r11.e(r6)
                b5.a0 r10 = b5.a0.f883a
                return r10
            L91:
                i6.c r10 = (i6.c) r10
                r10.e(r6)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.C00671.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$unloadDynamicIndex$2", f = "MemoryIndexManager.kt", l = {798}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$unloadDynamicIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00682 extends h5.i implements p5.p {
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        public C00682(f5.c cVar) {
            super(2, cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$0(int i8) {
            return a8.b.k(i8, "Unloaded ", " DYNAMIC documents, PERMANENT remains");
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return MemoryIndexManager.this.new C00682(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00682) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            i6.a aVar;
            MemoryIndexManager memoryIndexManager;
            g5.a aVar2 = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                i6.a aVar3 = MemoryIndexManager.this.indexMutex;
                MemoryIndexManager memoryIndexManager2 = MemoryIndexManager.this;
                this.L$0 = aVar3;
                this.L$1 = memoryIndexManager2;
                this.I$0 = 0;
                this.label = 1;
                i6.c cVar = (i6.c) aVar3;
                if (cVar.c(this) == aVar2) {
                    return aVar2;
                }
                aVar = cVar;
                memoryIndexManager = memoryIndexManager2;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memoryIndexManager = (MemoryIndexManager) this.L$1;
                aVar = (i6.a) this.L$0;
                a.a.c0(obj);
            }
            try {
                int iUnloadDynamic = memoryIndexManager.getIndex().unloadDynamic();
                MemoryLogger.logI$default(memoryIndexManager.logger, MemoryIndexManager.TAG, null, new j(iUnloadDynamic, 4), 2, null);
                return new Integer(iUnloadDynamic);
            } finally {
                ((i6.c) aVar).e(null);
            }
        }
    }

    public MemoryIndexManager(File baseDir, MemoryFileManager fileManager, BM25Config bm25Config, TieredCacheConfig cacheConfig, MemoryLogger logger) {
        kotlin.jvm.internal.p.e(baseDir, "baseDir");
        kotlin.jvm.internal.p.e(fileManager, "fileManager");
        kotlin.jvm.internal.p.e(bm25Config, "bm25Config");
        kotlin.jvm.internal.p.e(cacheConfig, "cacheConfig");
        kotlin.jvm.internal.p.e(logger, "logger");
        this.baseDir = baseDir;
        this.fileManager = fileManager;
        this.bm25Config = bm25Config;
        this.cacheConfig = cacheConfig;
        this.logger = logger;
        this.index = new BM25Index(bm25Config, null, null, 6, null);
        this.persistence = new IndexPersistence(baseDir, cacheConfig, logger);
        this.indexMutex = new i6.c();
        this.pendingPersistCategories = new LinkedHashSet();
        x1 x1VarC = i0.c();
        h6.e eVar = r0.f210a;
        h6.d dVar = h6.d.f3059c;
        this.compactionScope = i0.b(b8.h.I(x1VarC, dVar));
        this.compactionMutex = new i6.c();
        this.indexDispatcher = dVar.G(4);
    }

    private final List<MemoryRecord> extractLegacyRecords(File file) {
        boolean zExists = file.exists();
        s sVar = s.f1092a;
        if (!zExists) {
            return sVar;
        }
        String strA0 = m5.l.A0(file);
        try {
            ArrayList arrayListD0 = m5.l.D0(file);
            ArrayList arrayList = new ArrayList();
            int size = arrayListD0.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayListD0.get(i8);
                i8++;
                MemoryRecord legacyRecord = parseLegacyRecord((String) obj, strA0);
                if (legacyRecord != null) {
                    arrayList.add(legacyRecord);
                }
            }
            return arrayList;
        } catch (Exception unused) {
            MemoryLogger.logW$default(this.logger, TAG, null, new a(1, file), 2, null);
            return sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractLegacyRecords$lambda$1(File file) {
        return m0.f.c("Failed to parse legacy file: ", file.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean indexDailyFile(DailyMemoryFile file, IndexTier tier) {
        DailyMemoryFile dailyMemoryFile;
        String absolutePath = file.getFile().getAbsolutePath();
        int iBackfillMemoryIndex = file.backfillMemoryIndex();
        if (iBackfillMemoryIndex > 0) {
            dailyMemoryFile = file;
            MemoryLogger.logI$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.lightmem.evolution.c(iBackfillMemoryIndex, dailyMemoryFile, 1), 2, null);
        } else {
            dailyMemoryFile = file;
        }
        IndexPersistence indexPersistence = this.persistence;
        kotlin.jvm.internal.p.b(absolutePath);
        FileIndexState fileState = indexPersistence.getFileState(absolutePath);
        String strContentHash = dailyMemoryFile.contentHash();
        long lastModified = dailyMemoryFile.getLastModified();
        int i8 = 0;
        if (fileState != null && kotlin.jvm.internal.p.a(fileState.getHash(), strContentHash) && fileState.getLastModified() == lastModified) {
            return false;
        }
        String str = dailyMemoryFile.getCategory() + "/" + dailyMemoryFile.getDate() + "#";
        Set<String> allDocIds = this.index.getAllDocIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allDocIds) {
            if (u.c1((String) obj, str, false)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            this.index.removeDocument((String) obj2);
        }
        List<MemoryRecord> entries = dailyMemoryFile.readEntries();
        for (MemoryRecord memoryRecord : entries) {
            if (this.index.isTierFull(tier)) {
                break;
            }
            String category = memoryRecord.getCategory();
            if (x5.n.t1(category)) {
                category = dailyMemoryFile.getCategory();
            }
            BM25Index.indexDocument$default(this.index, buildDocId(category, memoryRecord.getDate(), memoryRecord.getId()), memoryRecord.getContent(), memoryRecord.getDate(), memoryRecord.getCategory(), memoryRecord.getCreatedAt(), null, 32, null);
        }
        this.persistence.updateFileState(absolutePath, strContentHash, lastModified, entries.size());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexDailyFile$lambda$0(int i8, DailyMemoryFile dailyMemoryFile) {
        return "Backfilled memoryIndex for " + i8 + " entries in " + dailyMemoryFile.getCategory() + "/" + dailyMemoryFile.getDate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int indexLegacyFiles() throws JSONException {
        int iLoadPersistedCategoryIndex;
        final List<File> listScanLegacyMemoryFiles = scanLegacyMemoryFiles();
        if (listScanLegacyMemoryFiles.isEmpty()) {
            return 0;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        final w wVar = new w();
        final w wVar2 = new w();
        for (File file : listScanLegacyMemoryFiles) {
            String absolutePath = file.getAbsolutePath();
            long jLastModified = file.lastModified();
            IndexPersistence indexPersistence = this.persistence;
            kotlin.jvm.internal.p.b(absolutePath);
            FileIndexState fileState = indexPersistence.getFileState(absolutePath);
            String strA0 = m5.l.A0(file);
            if (fileState == null || fileState.getLastModified() != jLastModified || (iLoadPersistedCategoryIndex = this.persistence.loadPersistedCategoryIndex(LEGACY_CATEGORY, this.index, strA0, strA0)) <= 0) {
                List<MemoryRecord> listExtractLegacyRecords = extractLegacyRecords(file);
                for (MemoryRecord memoryRecord : listExtractLegacyRecords) {
                    String strBuildDocId = buildDocId(LEGACY_CATEGORY, memoryRecord.getDate(), memoryRecord.getId());
                    if (!this.index.contains(strBuildDocId)) {
                        BM25Index.indexDocument$default(this.index, strBuildDocId, memoryRecord.getContent(), memoryRecord.getDate(), LEGACY_CATEGORY, memoryRecord.getCreatedAt(), null, 32, null);
                    }
                    wVar.f3684a++;
                }
                this.persistence.updateFileState(absolutePath, String.valueOf(jLastModified), jLastModified, listExtractLegacyRecords.size());
                wVar2.f3684a++;
            } else {
                wVar.f3684a += iLoadPersistedCategoryIndex;
                MemoryLogger.logD$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.search.d(file, iLoadPersistedCategoryIndex), 2, null);
            }
        }
        if (wVar2.f3684a > 0) {
            this.persistence.persistIndex(this.index);
        }
        final long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        MemoryLogger.logI$default(this.logger, TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.storage.index.e
            @Override // p5.a
            public final Object invoke() {
                return MemoryIndexManager.indexLegacyFiles$lambda$1(jCurrentTimeMillis2, wVar, wVar2, listScanLegacyMemoryFiles);
            }
        }, 2, null);
        return wVar.f3684a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexLegacyFiles$lambda$0(File file, int i8) {
        return "Legacy from cache: " + file.getName() + ", entries=" + i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexLegacyFiles$lambda$1(long j4, w wVar, w wVar2, List list) {
        return "Legacy index loaded in " + j4 + "ms: " + wVar.f3684a + " entries, " + wVar2.f3684a + "/" + list.size() + " files re-indexed";
    }

    private final void indexRecord(MemoryRecord record) {
        String strResolveDate = resolveDate(record.getCategory(), record.getDate());
        BM25Index.indexDocument$default(this.index, buildDocId(record.getCategory(), strResolveDate, record.getId()), record.getContent(), strResolveDate, record.getCategory(), record.getCreatedAt(), null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void indexRecordWithCreatedAt(MemoryRecord record, long createdAt) {
        String strResolveDate = resolveDate(record.getCategory(), record.getDate());
        BM25Index.indexDocument$default(this.index, buildDocId(record.getCategory(), strResolveDate, record.getId()), record.getContent(), strResolveDate, record.getCategory(), createdAt, null, 32, null);
    }

    private final int indexSingleFile(SingleMemoryFile file, IndexTier tier) {
        String absolutePath = file.getFile().getAbsolutePath();
        IndexPersistence indexPersistence = this.persistence;
        kotlin.jvm.internal.p.b(absolutePath);
        FileIndexState fileState = indexPersistence.getFileState(absolutePath);
        String strContentHash = file.contentHash();
        long lastModified = file.getLastModified();
        if (fileState != null && kotlin.jvm.internal.p.a(fileState.getHash(), strContentHash) && fileState.getLastModified() == lastModified) {
            return 0;
        }
        return indexSingleFileForced(file, tier);
    }

    private final int indexSingleFileForced(SingleMemoryFile file, IndexTier tier) {
        int i8;
        String absolutePath = file.getFile().getAbsolutePath();
        int iBackfillMemoryIndex = file.backfillMemoryIndex();
        if (iBackfillMemoryIndex > 0) {
            MemoryLogger.logI$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.search.d(file, iBackfillMemoryIndex, 3), 2, null);
        }
        String strContentHash = file.contentHash();
        long lastModified = file.getLastModified();
        String strN = a8.b.n(file.getCategory(), "/");
        Set<String> allDocIds = this.index.getAllDocIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = allDocIds.iterator();
        while (true) {
            i8 = 0;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (u.c1((String) next, strN, false)) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            this.index.removeDocument((String) obj);
        }
        List<MemoryRecord> entries = file.readEntries();
        MemoryLogger.logD$default(this.logger, TAG, null, new d(file, 3, entries), 2, null);
        w wVar = new w();
        Iterator<MemoryRecord> it2 = entries.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            MemoryRecord next2 = it2.next();
            if (this.index.isTierFull(tier)) {
                MemoryLogger.logW$default(this.logger, TAG, null, new d(tier, wVar, 4), 2, null);
                break;
            }
            String category = next2.getCategory();
            if (x5.n.t1(category)) {
                category = file.getCategory();
            }
            String strResolveDate = resolveDate(category, next2.getDate());
            String strBuildDocId = buildDocId(category, strResolveDate, next2.getId());
            if (BM25Index.indexDocument$default(this.index, strBuildDocId, next2.getContent(), strResolveDate, category, next2.getCreatedAt(), null, 32, null)) {
                wVar.f3684a++;
            } else {
                MemoryLogger.logW$default(this.logger, TAG, null, new h(strBuildDocId, 5), 2, null);
            }
        }
        IndexPersistence indexPersistence = this.persistence;
        kotlin.jvm.internal.p.b(absolutePath);
        indexPersistence.updateFileState(absolutePath, strContentHash, lastModified, entries.size());
        MemoryLogger.logD$default(this.logger, TAG, null, new d(file, wVar, 5), 2, null);
        return wVar.f3684a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexSingleFileForced$lambda$0(int i8, SingleMemoryFile singleMemoryFile) {
        return "Backfilled memoryIndex for " + i8 + " entries in " + singleMemoryFile.getFile().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexSingleFileForced$lambda$2(SingleMemoryFile singleMemoryFile, List list) {
        return "[DEBUG] indexSingleFileForced: category=" + singleMemoryFile.getCategory() + ", records=" + list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexSingleFileForced$lambda$3(IndexTier indexTier, w wVar) {
        return "[DEBUG] indexSingleFileForced: tier " + indexTier + " is full, indexed=" + wVar.f3684a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexSingleFileForced$lambda$5(String str) {
        return m0.f.c("[DEBUG] indexSingleFileForced: failed to index docId=", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String indexSingleFileForced$lambda$6(SingleMemoryFile singleMemoryFile, w wVar) {
        return "[DEBUG] indexSingleFileForced: done, category=" + singleMemoryFile.getCategory() + ", indexed=" + wVar.f3684a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int loadDynamicIndex(String dateFrom, String dateTo) {
        w wVar = new w();
        List<String> listListCategories = this.fileManager.listCategories();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListCategories) {
            if (!this.fileManager.isSingleFileCategory((String) obj)) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj2 = arrayList.get(i8);
            i8++;
            String str = (String) obj2;
            List<String> listListDates = this.fileManager.listDates(str);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : listListDates) {
                String str2 = (String) obj3;
                if (str2.compareTo(dateFrom) >= 0 && str2.compareTo(dateTo) <= 0) {
                    arrayList2.add(obj3);
                }
            }
            int size2 = arrayList2.size();
            int i9 = 0;
            while (i9 < size2) {
                Object obj4 = arrayList2.get(i9);
                i9++;
                String str3 = (String) obj4;
                if (this.index.isDynamicFull()) {
                    MemoryLogger.logW$default(this.logger, TAG, null, new b(2, wVar), 2, null);
                    return wVar.f3684a;
                }
                if (indexDailyFile(this.fileManager.getDailyFile(str, str3), IndexTier.DYNAMIC)) {
                    wVar.f3684a++;
                }
            }
        }
        return wVar.f3684a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndex$lambda$2(w wVar) {
        return a8.b.k(wVar.f3684a, "DYNAMIC cache full, stopping at ", " docs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int loadDynamicIndexOptimized(java.lang.String r23, final java.lang.String r24, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.loadDynamicIndexOptimized(java.lang.String, java.lang.String, java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndexOptimized$lambda$1(List list, List list2, String str, String str2) {
        return "[DEBUG] loadDynamicIndexOptimized: allCategories=" + list + ", dynamicCategories=" + list2 + ", dateRange=" + str + ".." + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndexOptimized$lambda$3(String str, List list, List list2) {
        return "[DEBUG] loadDynamicIndexOptimized: category=" + str + ", allDates=" + list + ", filteredDates=" + list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndexOptimized$lambda$4(w wVar) {
        return a8.b.k(wVar.f3684a, "DYNAMIC cache full, stopping at ", " docs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndexOptimized$lambda$5(String str, String str2, int i8) {
        StringBuilder sbV = a8.b.v("Loaded DYNAMIC from cache (fast path): ", str, "/", str2, ", entries=");
        sbV.append(i8);
        return sbV.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndexOptimized$lambda$6(String str, String str2, int i8) {
        StringBuilder sbV = a8.b.v("Loaded DYNAMIC from cache (hash match): ", str, "/", str2, ", entries=");
        sbV.append(i8);
        return sbV.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadDynamicIndexOptimized$lambda$7(String str, String str2) {
        return a8.b.q("Loaded DYNAMIC from file: ", str, "/", str2, " (will persist)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int loadPermanentIndex() {
        w wVar = new w();
        for (String str : this.cacheConfig.getPermanentCategories()) {
            if (this.index.isPermanentFull()) {
                MemoryLogger.logW$default(this.logger, TAG, null, new b(4, wVar), 2, null);
                return wVar.f3684a;
            }
            SingleMemoryFile singleFile = this.fileManager.getSingleFile(str);
            if (singleFile.getExists()) {
                int iIndexSingleFile = indexSingleFile(singleFile, IndexTier.PERMANENT);
                wVar.f3684a += iIndexSingleFile;
                MemoryLogger.logD$default(this.logger, TAG, null, new com.stepos.stepclaw.memory.embedding.h(str, iIndexSingleFile, 6), 2, null);
            }
        }
        return wVar.f3684a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndex$lambda$0(w wVar) {
        return a8.b.k(wVar.f3684a, "PERMANENT cache full, stopping at ", " entries");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndex$lambda$1(String str, int i8) {
        return "Loaded PERMANENT: " + str + ", entries=" + i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0021 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int loadPermanentIndexOptimized() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.loadPermanentIndexOptimized():int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$0(Set set) {
        return "[DEBUG] loadPermanentIndexOptimized: permanentCategories=" + set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$1(w wVar) {
        return a8.b.k(wVar.f3684a, "PERMANENT cache full, stopping at ", " entries");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$2(String str, SingleMemoryFile singleMemoryFile) {
        String absolutePath = singleMemoryFile.getFile().getAbsolutePath();
        boolean exists = singleMemoryFile.getExists();
        StringBuilder sbV = a8.b.v("[DEBUG] loadPermanentIndexOptimized: category=", str, ", file=", absolutePath, ", exists=");
        sbV.append(exists);
        return sbV.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$3(String str) {
        return m0.f.d("[DEBUG] loadPermanentIndexOptimized: SKIP category=", str, " (file not exists)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$4(int i8) {
        return a8.b.j(i8, "[DEBUG] loadPermanentIndexOptimized: tried cache (fast path), loadedCount=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$5(String str, int i8) {
        return "Loaded PERMANENT from cache (fast path): " + str + ", entries=" + i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$6(String str) {
        return m0.f.c("[DEBUG] loadPermanentIndexOptimized: cache failed, clearing fileState for ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$7(String str, int i8) {
        return "Loaded PERMANENT from cache (hash match): " + str + ", entries=" + i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$8(int i8) {
        return a8.b.j(i8, "[DEBUG] loadPermanentIndexOptimized: indexed from file, entries=");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String loadPermanentIndexOptimized$lambda$9(String str, int i8) {
        return "Loaded PERMANENT from file: " + str + ", entries=" + i8 + " (will persist)";
    }

    private final MemoryRecord parseLegacyRecord(String line, String date) {
        String str;
        Long lF1;
        String string = x5.n.T1(line).toString();
        if (!u.c1(string, MemoryFile.ENTRY_PREFIX, false)) {
            return null;
        }
        String string2 = x5.n.T1(x5.n.B1(string, MemoryFile.ENTRY_PREFIX)).toString();
        if (string2.length() == 0) {
            return null;
        }
        MemoryFile.Companion companion = MemoryFile.INSTANCE;
        x5.j jVarB = x5.l.b(companion.getTIMESTAMP_PATTERN(), string2);
        long jCurrentTimeMillis = (jVarB == null || (str = (String) ((x5.h) jVarB.a()).get(1)) == null || (lF1 = u.f1(str)) == null) ? System.currentTimeMillis() : lF1.longValue();
        String string3 = x5.n.T1(companion.getTIMESTAMP_PATTERN().f(string2)).toString();
        if (string3.length() == 0) {
            return null;
        }
        return new MemoryRecord(companion.generateEntryId(string3, LEGACY_CATEGORY, date), string3, jCurrentTimeMillis, LEGACY_CATEGORY, date, 0.0d, null, null, 0L, null, 992, null);
    }

    public static /* synthetic */ Object query$default(MemoryIndexManager memoryIndexManager, String str, int i8, String str2, String str3, Set set, boolean z, f5.c cVar, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 10;
        }
        int i10 = i8;
        String str4 = (i9 & 4) != 0 ? null : str2;
        String str5 = (i9 & 8) != 0 ? null : str3;
        if ((i9 & 16) != 0) {
            set = c5.u.f1094a;
        }
        Set set2 = set;
        if ((i9 & 32) != 0) {
            z = true;
        }
        return memoryIndexManager.query(str, i10, str4, str5, set2, z, cVar);
    }

    private final List<File> scanLegacyMemoryFiles() {
        File[] fileArrListFiles;
        File file = new File(this.baseDir, LEGACY_MEMORY_DIR);
        return (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles(new g())) != null) ? c5.l.j0(fileArrListFiles) : s.f1092a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean scanLegacyMemoryFiles$lambda$0(File file) {
        if (!file.isFile()) {
            return false;
        }
        String name = file.getName();
        kotlin.jvm.internal.p.d(name, "getName(...)");
        return x5.n.M1(name, '.', SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID).equals("md");
    }

    private final void scheduleCompactionIfNeeded() {
        if (this.pendingCompaction) {
            h1 h1Var = this.compactionJob;
            if (h1Var == null || !h1Var.a()) {
                this.compactionJob = i0.q(this.compactionScope, null, new C00671(null), 3);
            }
        }
    }

    public final String buildDocId(String category, String date, String entryId) {
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(date, "date");
        kotlin.jvm.internal.p.e(entryId, "entryId");
        return category + "/" + date + "#" + entryId;
    }

    public final Object compactDynamicCache(f5.c cVar) {
        return i0.A(this.indexDispatcher, new AnonymousClass2(null), cVar);
    }

    public final long estimateMemoryUsage() {
        return this.index.estimateMemoryUsage();
    }

    public final TieredCacheConfig getCacheConfig() {
        return this.cacheConfig;
    }

    public final BM25CacheStats getCacheStats() {
        return this.index.getCacheStats();
    }

    public final List<BM25Index.CategoryDateStats> getCategoryDateStats() {
        return this.index.categoryDateStats();
    }

    public final MemoryFileManager getFileManager() {
        return this.fileManager;
    }

    public final BM25Index getIndex() {
        return this.index;
    }

    /* renamed from: getPersistence$step_memory_release, reason: from getter */
    public final IndexPersistence getPersistence() {
        return this.persistence;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object indexNewEntry(com.stepos.stepclaw.memory.storage.file.MemoryRecord r12, long r13, java.lang.String r15, java.lang.String r16, f5.c r17) {
        /*
            r11 = this;
            r0 = r17
            boolean r2 = r0 instanceof com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.AnonymousClass1
            if (r2 == 0) goto L16
            r2 = r0
            com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$1 r2 = (com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L16
            int r3 = r3 - r4
            r2.label = r3
        L14:
            r7 = r2
            goto L1c
        L16:
            com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$1 r2 = new com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$1
            r2.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.result
            g5.a r8 = g5.a.f2984a
            int r2 = r7.label
            r9 = 1
            if (r2 == 0) goto L43
            if (r2 != r9) goto L3b
            java.lang.Object r2 = r7.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r7.L$2
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r7.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = r7.L$0
            com.stepos.stepclaw.memory.storage.file.MemoryRecord r2 = (com.stepos.stepclaw.memory.storage.file.MemoryRecord) r2
            a.a.c0(r0)
            goto L6b
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            a.a.c0(r0)
            com.stepos.stepclaw.memory.storage.file.MemoryFile$Companion r0 = com.stepos.stepclaw.memory.storage.file.MemoryFile.INSTANCE
            java.lang.String r5 = r0.normalizeCategory(r15)
            a6.b0 r10 = r11.indexDispatcher
            com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$2 r0 = new com.stepos.stepclaw.memory.storage.index.MemoryIndexManager$indexNewEntry$2
            r6 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r0.<init>(r2, r3, r5, r6)
            r1 = 0
            r7.L$0 = r1
            r7.L$1 = r1
            r7.L$2 = r1
            r7.L$3 = r1
            r7.J$0 = r13
            r7.label = r9
            java.lang.Object r0 = a6.i0.A(r10, r0, r7)
            if (r0 != r8) goto L6b
            return r8
        L6b:
            r11.scheduleCompactionIfNeeded()
            b5.a0 r0 = b5.a0.f883a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.storage.index.MemoryIndexManager.indexNewEntry(com.stepos.stepclaw.memory.storage.file.MemoryRecord, long, java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    public final Object initialize(f5.c cVar) {
        Object objA = i0.A(this.indexDispatcher, new C00582(null), cVar);
        return objA == g5.a.f2984a ? objA : a0.f883a;
    }

    public final Object loadMoreDynamicHistory(int i8, f5.c cVar) {
        return i0.A(this.indexDispatcher, new C00592(i8, null), cVar);
    }

    public final Object persistIndexNow(f5.c cVar) {
        Object objA = i0.A(this.indexDispatcher, new C00602(null), cVar);
        return objA == g5.a.f2984a ? objA : a0.f883a;
    }

    public final Object query(String str, int i8, String str2, String str3, Set<String> set, boolean z, f5.c cVar) {
        return i0.A(this.indexDispatcher, new C00612(z, str2, str3, str, i8, set, null), cVar);
    }

    public final Object rebuildIndex(f5.c cVar) {
        Object objA = i0.A(this.indexDispatcher, new C00622(null), cVar);
        return objA == g5.a.f2984a ? objA : a0.f883a;
    }

    public final Object recordAccess(List<String> list, f5.c cVar) {
        Object objA;
        boolean zIsEmpty = list.isEmpty();
        a0 a0Var = a0.f883a;
        return (!zIsEmpty && (objA = i0.A(this.indexDispatcher, new C00632(list, null), cVar)) == g5.a.f2984a) ? objA : a0Var;
    }

    public final Object refreshIndex(f5.c cVar) {
        return i0.A(this.indexDispatcher, new C00642(null), cVar);
    }

    public final Object reloadDynamicIndex(f5.c cVar) {
        return i0.A(this.indexDispatcher, new C00652(null), cVar);
    }

    public final Object removeDocument(String str, f5.c cVar) {
        Object objA = i0.A(this.indexDispatcher, new C00662(str, null), cVar);
        return objA == g5.a.f2984a ? objA : a0.f883a;
    }

    public final String resolveDate(String category, String date) {
        kotlin.jvm.internal.p.e(category, "category");
        kotlin.jvm.internal.p.e(date, "date");
        return this.cacheConfig.getPermanentCategories().contains(category) ? MemoryFile.PERMANENT_DATE : date;
    }

    public final Object unloadDynamicIndex(f5.c cVar) {
        return i0.A(this.indexDispatcher, new C00682(null), cVar);
    }

    public /* synthetic */ MemoryIndexManager(File file, MemoryFileManager memoryFileManager, BM25Config bM25Config, TieredCacheConfig tieredCacheConfig, MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this(file, memoryFileManager, (i8 & 4) != 0 ? new BM25Config(0.0d, 0.0d, null, 7, null) : bM25Config, (i8 & 8) != 0 ? TieredCacheConfig.INSTANCE.getDEFAULT() : tieredCacheConfig, (i8 & 16) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
