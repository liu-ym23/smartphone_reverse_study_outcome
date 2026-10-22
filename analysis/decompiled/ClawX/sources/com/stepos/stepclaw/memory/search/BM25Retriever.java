package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/memory/search/BM25Retriever;", "Lcom/stepos/stepclaw/memory/search/MemoryRetriever;", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "indexManager", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "query", "category", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "topK", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "retrieve", "(Ljava/lang/String;Ljava/lang/String;ILf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BM25Retriever implements MemoryRetriever {
    private static final String TAG = "BM25Retriever";
    private final MemoryIndexManager indexManager;
    private final MemoryLogger logger;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.BM25Retriever", f = "BM25Retriever.kt", l = {48, 50}, m = "retrieve", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.BM25Retriever$retrieve$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
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
            return BM25Retriever.this.retrieve(null, null, 0, this);
        }
    }

    public BM25Retriever(MemoryIndexManager indexManager, MemoryLogger logger) {
        p.e(indexManager, "indexManager");
        p.e(logger, "logger");
        this.indexManager = indexManager;
        this.logger = logger;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    @Override // com.stepos.stepclaw.memory.search.MemoryRetriever
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object retrieve(java.lang.String r25, java.lang.String r26, int r27, f5.c r28) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.BM25Retriever.retrieve(java.lang.String, java.lang.String, int, f5.c):java.lang.Object");
    }

    public /* synthetic */ BM25Retriever(MemoryIndexManager memoryIndexManager, MemoryLogger memoryLogger, int i8, i iVar) {
        this(memoryIndexManager, (i8 & 2) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
