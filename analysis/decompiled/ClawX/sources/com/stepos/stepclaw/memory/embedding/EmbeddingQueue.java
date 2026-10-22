package com.stepos.stepclaw.memory.embedding;

import a6.f0;
import a6.i0;
import a6.r0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import java.util.List;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingQueue;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "logger", "<init>", "(Lcom/stepos/stepclaw/memory/utils/MemoryLogger;)V", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingTask;", "task", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "client", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "storage", "Lb5/a0;", "processTask", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingTask;Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;Lf5/c;)Ljava/lang/Object;", "enqueue", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingTask;)V", "La6/f0;", "scope", "start", "(La6/f0;Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;)V", "stop", "()V", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "Lc6/g;", "channel", "Lc6/g;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EmbeddingQueue {
    private static final String TAG = "EmbeddingQueue";
    private final c6.g channel;
    private final MemoryLogger logger;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.embedding.EmbeddingQueue", f = "EmbeddingQueue.kt", l = {72}, m = "processTask", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.embedding.EmbeddingQueue$processTask$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
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
            return EmbeddingQueue.this.processTask(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.embedding.EmbeddingQueue$start$1", f = "EmbeddingQueue.kt", l = {49, 50}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.embedding.EmbeddingQueue$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00421 extends h5.i implements p {
        final /* synthetic */ EmbeddingClient $client;
        final /* synthetic */ EmbeddingStorage $storage;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00421(EmbeddingClient embeddingClient, EmbeddingStorage embeddingStorage, f5.c cVar) {
            super(2, cVar);
            this.$client = embeddingClient;
            this.$storage = embeddingStorage;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0() {
            return "EmbeddingQueue channel closed, consumer exiting";
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return EmbeddingQueue.this.new C00421(this.$client, this.$storage, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00421) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        
            if (r5.processTask(r10, r6, r7, r9) == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[Catch: l -> 0x0068, TRY_LEAVE, TryCatch #0 {l -> 0x0068, blocks: (B:7:0x0015, B:16:0x0037, B:20:0x0047, B:22:0x004f, B:12:0x0026, B:15:0x002d), top: B:28:0x0007 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:8:0x0018). Please report as a decompilation issue!!! */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                g5.a r0 = g5.a.f2984a
                int r1 = r9.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2a
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                java.lang.Object r1 = r9.L$1
                com.stepos.stepclaw.memory.embedding.EmbeddingTask r1 = (com.stepos.stepclaw.memory.embedding.EmbeddingTask) r1
                java.lang.Object r1 = r9.L$0
                c6.b r1 = (c6.b) r1
                a.a.c0(r10)     // Catch: c6.l -> L68
            L18:
                r10 = r1
                goto L37
            L1a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L22:
                java.lang.Object r1 = r9.L$0
                c6.b r1 = (c6.b) r1
                a.a.c0(r10)     // Catch: c6.l -> L68
                goto L47
            L2a:
                a.a.c0(r10)
                com.stepos.stepclaw.memory.embedding.EmbeddingQueue r10 = com.stepos.stepclaw.memory.embedding.EmbeddingQueue.this     // Catch: c6.l -> L68
                c6.g r10 = com.stepos.stepclaw.memory.embedding.EmbeddingQueue.access$getChannel$p(r10)     // Catch: c6.l -> L68
                c6.b r10 = r10.iterator()     // Catch: c6.l -> L68
            L37:
                r9.L$0 = r10     // Catch: c6.l -> L68
                r9.L$1 = r2     // Catch: c6.l -> L68
                r9.label = r4     // Catch: c6.l -> L68
                java.lang.Object r1 = r10.a(r9)     // Catch: c6.l -> L68
                if (r1 != r0) goto L44
                goto L67
            L44:
                r8 = r1
                r1 = r10
                r10 = r8
            L47:
                java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: c6.l -> L68
                boolean r10 = r10.booleanValue()     // Catch: c6.l -> L68
                if (r10 == 0) goto L7c
                java.lang.Object r10 = r1.c()     // Catch: c6.l -> L68
                com.stepos.stepclaw.memory.embedding.EmbeddingTask r10 = (com.stepos.stepclaw.memory.embedding.EmbeddingTask) r10     // Catch: c6.l -> L68
                com.stepos.stepclaw.memory.embedding.EmbeddingQueue r5 = com.stepos.stepclaw.memory.embedding.EmbeddingQueue.this     // Catch: c6.l -> L68
                com.stepos.stepclaw.memory.embedding.EmbeddingClient r6 = r9.$client     // Catch: c6.l -> L68
                com.stepos.stepclaw.memory.embedding.EmbeddingStorage r7 = r9.$storage     // Catch: c6.l -> L68
                r9.L$0 = r1     // Catch: c6.l -> L68
                r9.L$1 = r2     // Catch: c6.l -> L68
                r9.label = r3     // Catch: c6.l -> L68
                java.lang.Object r10 = com.stepos.stepclaw.memory.embedding.EmbeddingQueue.access$processTask(r5, r10, r6, r7, r9)     // Catch: c6.l -> L68
                if (r10 != r0) goto L18
            L67:
                return r0
            L68:
                com.stepos.stepclaw.memory.embedding.EmbeddingQueue r9 = com.stepos.stepclaw.memory.embedding.EmbeddingQueue.this
                com.stepos.stepclaw.memory.utils.MemoryLogger r0 = com.stepos.stepclaw.memory.embedding.EmbeddingQueue.access$getLogger$p(r9)
                com.stepos.stepclaw.memory.embedding.a r3 = new com.stepos.stepclaw.memory.embedding.a
                r9 = 2
                r3.<init>(r9)
                r4 = 2
                r5 = 0
                java.lang.String r1 = "EmbeddingQueue"
                r2 = 0
                com.stepos.stepclaw.memory.utils.MemoryLogger.logD$default(r0, r1, r2, r3, r4, r5)
            L7c:
                b5.a0 r9 = b5.a0.f883a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.embedding.EmbeddingQueue.C00421.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmbeddingQueue() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091 A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:25:0x0089, B:27:0x0091, B:31:0x00a4, B:33:0x00ae, B:34:0x00b4, B:22:0x006b), top: B:38:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4 A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:25:0x0089, B:27:0x0091, B:31:0x00a4, B:33:0x00ae, B:34:0x00b4, B:22:0x006b), top: B:38:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processTask(com.stepos.stepclaw.memory.embedding.EmbeddingTask r23, com.stepos.stepclaw.memory.embedding.EmbeddingClient r24, com.stepos.stepclaw.memory.embedding.EmbeddingStorage r25, f5.c r26) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.embedding.EmbeddingQueue.processTask(com.stepos.stepclaw.memory.embedding.EmbeddingTask, com.stepos.stepclaw.memory.embedding.EmbeddingClient, com.stepos.stepclaw.memory.embedding.EmbeddingStorage, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processTask$lambda$0(EmbeddingProvider embeddingProvider, EmbeddingTask embeddingTask) {
        return a8.b.q("skip embed: provider '", embeddingProvider.getId(), "' isAvailable=false, docId=", embeddingTask.getDocId(), " (will be filled by next backfill)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processTask$lambda$1(EmbeddingTask embeddingTask) {
        return m0.f.c("embed returned empty for docId=", embeddingTask.getDocId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processTask$lambda$3(EmbeddingTask embeddingTask, List list) {
        return "embedded docId=" + embeddingTask.getDocId() + " dim=" + ((float[]) list.get(0)).length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String processTask$lambda$4(EmbeddingTask embeddingTask, Exception exc) {
        return a8.b.p("embed failed for docId=", embeddingTask.getDocId(), ": ", exc.getMessage());
    }

    public final void enqueue(EmbeddingTask task) {
        kotlin.jvm.internal.p.e(task, "task");
        this.channel.k(task);
    }

    public final void start(f0 scope, EmbeddingClient client, EmbeddingStorage storage) {
        kotlin.jvm.internal.p.e(scope, "scope");
        kotlin.jvm.internal.p.e(client, "client");
        kotlin.jvm.internal.p.e(storage, "storage");
        h6.e eVar = r0.f210a;
        i0.q(scope, h6.d.f3059c, new C00421(client, storage, null), 2);
    }

    public final void stop() {
        this.channel.f(null);
    }

    public EmbeddingQueue(MemoryLogger logger) {
        kotlin.jvm.internal.p.e(logger, "logger");
        this.logger = logger;
        this.channel = c6.j.a(Integer.MAX_VALUE, null, 6);
    }

    public /* synthetic */ EmbeddingQueue(MemoryLogger memoryLogger, int i8, kotlin.jvm.internal.i iVar) {
        this((i8 & 1) != 0 ? new AndroidMemoryLogger() : memoryLogger);
    }
}
