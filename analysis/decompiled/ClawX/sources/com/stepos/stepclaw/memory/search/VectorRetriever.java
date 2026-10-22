package com.stepos.stepclaw.memory.search;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.embedding.EmbeddingClient;
import com.stepos.stepclaw.memory.embedding.EmbeddingProvider;
import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ.\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/search/VectorRetriever;", "Lcom/stepos/stepclaw/memory/search/MemoryRetriever;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "client", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "embeddingStorage", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "query", "category", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "topK", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "retrieve", "(Ljava/lang/String;Ljava/lang/String;ILf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorRetriever implements MemoryRetriever {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "VectorRetriever";
    private final EmbeddingClient client;
    private final EmbeddingStorage embeddingStorage;
    private final MemoryLogger logger;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/stepclaw/memory/search/VectorRetriever$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "TAG", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cosineSimilarity", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "a", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "b", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final float cosineSimilarity(float[] a9, float[] b9) {
            p.e(a9, "a");
            p.e(b9, "b");
            if (a9.length == b9.length && a9.length != 0) {
                int length = a9.length;
                float f3 = 0.0f;
                float f7 = 0.0f;
                float f9 = 0.0f;
                for (int i8 = 0; i8 < length; i8++) {
                    float f10 = a9[i8];
                    float f11 = b9[i8];
                    f9 += f10 * f11;
                    f3 += f10 * f10;
                    f7 += f11 * f11;
                }
                float fSqrt = ((float) Math.sqrt(f3)) * ((float) Math.sqrt(f7));
                if (fSqrt != 0.0f) {
                    return v.m(f9 / fSqrt);
                }
            }
            return 0.0f;
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.search.VectorRetriever", f = "VectorRetriever.kt", l = {66}, m = "retrieve", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.search.VectorRetriever$retrieve$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return VectorRetriever.this.retrieve(null, null, 0, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\"\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"com/stepos/stepclaw/memory/search/VectorRetriever$retrieve$Scored", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "entry", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;", "score", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;F)V", "getEntry", "()Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;", "getScore", "()F", "component1", "component2", "copy", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage$EmbeddingEntry;F)Lcom/stepos/stepclaw/memory/search/VectorRetriever$retrieve$Scored;", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Scored {
        private final EmbeddingStorage.EmbeddingEntry entry;
        private final float score;

        public Scored(EmbeddingStorage.EmbeddingEntry entry, float f3) {
            p.e(entry, "entry");
            this.entry = entry;
            this.score = f3;
        }

        public static /* synthetic */ Scored copy$default(Scored scored, EmbeddingStorage.EmbeddingEntry embeddingEntry, float f3, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                embeddingEntry = scored.entry;
            }
            if ((i8 & 2) != 0) {
                f3 = scored.score;
            }
            return scored.copy(embeddingEntry, f3);
        }

        /* renamed from: component1, reason: from getter */
        public final EmbeddingStorage.EmbeddingEntry getEntry() {
            return this.entry;
        }

        /* renamed from: component2, reason: from getter */
        public final float getScore() {
            return this.score;
        }

        public final Scored copy(EmbeddingStorage.EmbeddingEntry entry, float score) {
            p.e(entry, "entry");
            return new Scored(entry, score);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Scored)) {
                return false;
            }
            Scored scored = (Scored) other;
            return p.a(this.entry, scored.entry) && Float.compare(this.score, scored.score) == 0;
        }

        public final EmbeddingStorage.EmbeddingEntry getEntry() {
            return this.entry;
        }

        public final float getScore() {
            return this.score;
        }

        public int hashCode() {
            return Float.hashCode(this.score) + (this.entry.hashCode() * 31);
        }

        public String toString() {
            return "Scored(entry=" + this.entry + ", score=" + this.score + ")";
        }
    }

    public VectorRetriever(EmbeddingClient client, EmbeddingStorage embeddingStorage, MemoryLogger logger) {
        p.e(client, "client");
        p.e(embeddingStorage, "embeddingStorage");
        p.e(logger, "logger");
        this.client = client;
        this.embeddingStorage = embeddingStorage;
        this.logger = logger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String retrieve$lambda$0(EmbeddingProvider embeddingProvider, String str) {
        return a8.b.q("skip vector retrieval: provider '", embeddingProvider.getId(), "' isAvailable=false; falling through to BM25 (category=", str, ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String retrieve$lambda$1(String str, EmbeddingProvider embeddingProvider, Exception exc) {
        String id = embeddingProvider.getId();
        String message = exc.getMessage();
        StringBuilder sbV = a8.b.v("embed(query) failed for category=", str, " provider=", id, ": ");
        sbV.append(message);
        return sbV.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d A[Catch: Exception -> 0x0153, TRY_LEAVE, TryCatch #1 {Exception -> 0x0153, blocks: (B:29:0x0094, B:32:0x009d), top: B:59:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.stepclaw.memory.search.MemoryRetriever
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object retrieve(java.lang.String r23, java.lang.String r24, int r25, f5.c r26) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.search.VectorRetriever.retrieve(java.lang.String, java.lang.String, int, f5.c):java.lang.Object");
    }

    public /* synthetic */ VectorRetriever(EmbeddingClient embeddingClient, EmbeddingStorage embeddingStorage, MemoryLogger memoryLogger, int i8, i iVar) {
        this(embeddingClient, embeddingStorage, (i8 & 4) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
