package com.stepos.stepclaw.memory;

import a6.a2;
import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.MemoryDumpCommandHandler;
import com.stepos.stepclaw.memory.embedding.EmbeddingClient;
import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionLog;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionPipelineResult;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionRecaller;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.lightmem.local.LocalInferSupportState;
import com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine;
import com.stepos.stepclaw.memory.lightmem.remote.AsyncTaskStatus;
import com.stepos.stepclaw.memory.lightmem.remote.AsyncTaskStatusKt;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionDeleteMemory;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineEvolutionModelsKt;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineSearchGroup;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerMessageItem;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateGroupMessage;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import com.stepos.stepclaw.memory.search.MemoryEntry;
import com.stepos.stepclaw.memory.search.MemorySearchConfig;
import com.stepos.stepclaw.memory.search.SearchPipeline;
import com.stepos.stepclaw.memory.search.SearchPipelineResult;
import com.stepos.stepclaw.memory.storage.MemoryStorage;
import com.stepos.stepclaw.memory.storage.cache.TieredCacheConfig;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.index.BM25Index;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import com.stepos.stepclaw.memory.upload.MemoryUploadService;
import com.stepos.stepclaw.memory.upload.UploadBatchResult;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.PerfTrace;
import com.stepos.stepclaw.service.command.CommandHandler;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0012J+\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0012J+\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001a\u0010\u000fJ+\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001b\u0010\u000fJ+\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001c\u0010\u000fJ+\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001d\u0010\u000fJ+\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001e\u0010\u000fJ+\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001f\u0010\u000fJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0012J+\u0010!\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b!\u0010\u000fJ+\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\"\u0010\u000fJ+\u0010#\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b#\u0010\u000fJ+\u0010$\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0002¢\u0006\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u001a\u0010+\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(¨\u0006."}, d2 = {"Lcom/stepos/stepclaw/memory/MemoryDumpCommandHandler;", "Lcom/stepos/stepclaw/service/command/CommandHandler;", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/io/PrintWriter;", "writer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "args", "Lb5/a0;", "handle", "(Landroid/content/Context;Ljava/io/PrintWriter;[Ljava/lang/String;)V", "dumpEmbedModel$step_memory_release", "(Ljava/io/PrintWriter;[Ljava/lang/String;)V", "dumpEmbedModel", "dumpInfo", "(Ljava/io/PrintWriter;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "bytes", "formatSize", "(J)Ljava/lang/String;", "dumpConfig", "dumpQuery", "dumpHelp", "dumpDebug", "dumpPipeline", "dumpEmbed", "dumpOfflineTriggerPoll", "dumpOfflineUpdatePoll", "dumpOfflineTrigger", "dumpOfflineUpdateSubmit", "dumpOfflineEvolution", "dumpLocalInfer", "dumpAuto", "dumpUpload", "commandName", "Ljava/lang/String;", "getCommandName", "()Ljava/lang/String;", "description", "getDescription", "usage", "getUsage", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryDumpCommandHandler implements CommandHandler {
    private static final long DUMP_OFFLINE_POLL_HTTP_TIMEOUT_MS = 15000;
    private static final long DUMP_OFFLINE_TRIGGER_HTTP_TIMEOUT_MS = 8000;
    private static final String TAG = "MemoryDump";
    private final String commandName = "mem";
    private final String description = "Dump MemoryEngine state (index info, search config, query pipeline)";
    private final String usage = "mem [info|config|query <text>|offline_trigger|...]";

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineEvolution$1", f = "MemoryDumpCommandHandler.kt", l = {685}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineEvolution$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.i implements p5.p {
        final /* synthetic */ String $fileName;
        final /* synthetic */ AndroidMemoryLogger $logger;
        final /* synthetic */ String $sessionSuffix;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, AndroidMemoryLogger androidMemoryLogger, f5.c cVar) {
            super(2, cVar);
            this.$sessionSuffix = str;
            this.$fileName = str2;
            this.$logger = androidMemoryLogger;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0() {
            return "offline_evolution (dumpsys): pipeline returned null (not initialized)";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2(StringBuilder sb) {
            String string = sb.toString();
            kotlin.jvm.internal.p.d(string, "toString(...)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$3() {
            return "offline_evolution (dumpsys) failed";
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass1(this.$sessionSuffix, this.$fileName, this.$logger, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            a0 a0Var = a0.f883a;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
                    String str = "dumpsys-offline-evolution-" + this.$sessionSuffix;
                    String str2 = this.$fileName;
                    this.label = 1;
                    obj = memoryEngine.runOfflineEvolutionEpisodicPipeline(str, str2, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                OfflineEvolutionPipelineResult offlineEvolutionPipelineResult = (OfflineEvolutionPipelineResult) obj;
                if (offlineEvolutionPipelineResult == null) {
                    this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new b(0));
                    return a0Var;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("offline_evolution done: trigger=" + offlineEvolutionPipelineResult.getTriggerResponse().getStatus() + " ");
                sb.append("groups=" + offlineEvolutionPipelineResult.getTriggerResponse().getSearch_groups().size() + " ");
                OfflineUpdateResponse updateResponse = offlineEvolutionPipelineResult.getUpdateResponse();
                if (updateResponse != null) {
                    sb.append("update=" + updateResponse.getStatus() + " ");
                }
                sb.append("memoryIndexMap=" + offlineEvolutionPipelineResult.getMemoryIndexToDocId().size());
                this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new c(0, sb));
                return a0Var;
            } catch (Exception e9) {
                this.$logger.logE(MemoryDumpCommandHandler.TAG, null, e9, new b(1));
                return a0Var;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineTrigger$4", f = "MemoryDumpCommandHandler.kt", l = {519}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineTrigger$4, reason: invalid class name */
    public static final class AnonymousClass4 extends h5.i implements p5.p {
        final /* synthetic */ LightMemClient $c;
        final /* synthetic */ String $fileName;
        final /* synthetic */ AndroidMemoryLogger $logger;
        final /* synthetic */ OfflineEvolutionService $service;
        final /* synthetic */ long $startTime;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str, AndroidMemoryLogger androidMemoryLogger, OfflineEvolutionService offlineEvolutionService, LightMemClient lightMemClient, long j4, f5.c cVar) {
            super(2, cVar);
            this.$fileName = str;
            this.$logger = androidMemoryLogger;
            this.$service = offlineEvolutionService;
            this.$c = lightMemClient;
            this.$startTime = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(String str) {
            return m0.f.d("[dumpOfflineTrigger-async] loading pending from file=", str, "...");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1() {
            return "[dumpOfflineTrigger-async] loading all pending episodic...";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2() {
            return "[dumpOfflineTrigger-async] no pending episodic entries";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$3(List list) {
            return a8.b.k(list.size(), "[dumpOfflineTrigger-async] loaded ", " pending entries, calling offlineTriggerFirst...");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$4(long j4, OfflineTriggerResponse offlineTriggerResponse) {
            return "[dumpOfflineTrigger-async] SUCCESS after " + j4 + "ms: status=" + offlineTriggerResponse.getStatus() + ", unique_id=" + AsyncTaskStatusKt.effectiveUniqueId(offlineTriggerResponse) + ", search_groups=" + offlineTriggerResponse.getSearch_groups().size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$5(OfflineTriggerResponse offlineTriggerResponse) {
            return m0.f.c("[dumpOfflineTrigger-async] message: ", offlineTriggerResponse.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$6(OfflineTriggerResponse offlineTriggerResponse) {
            return m0.f.c("[dumpOfflineTrigger-async] memory: ", offlineTriggerResponse.getMemory());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$7$0(int i8, OfflineSearchGroup offlineSearchGroup) {
            int group_id = offlineSearchGroup.getGroup_id();
            String strQ1 = x5.n.Q1(100, offlineSearchGroup.getCluster_summary());
            int size = offlineSearchGroup.getCluster_memories().size();
            int size2 = offlineSearchGroup.getSearch().size();
            StringBuilder sbT = a8.b.t("[dumpOfflineTrigger-async] search_group[", i8, "]: group_id=", group_id, ", cluster_summary=");
            sbT.append(strQ1);
            sbT.append(", cluster_memories=");
            sbT.append(size);
            sbT.append(", search=");
            sbT.append(size2);
            return sbT.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$8(long j4, Exception exc) {
            String simpleName = exc.getClass().getSimpleName();
            String message = exc.getMessage();
            StringBuilder sb = new StringBuilder("[dumpOfflineTrigger-async] FAILED after ");
            sb.append(j4);
            sb.append("ms: ");
            sb.append(simpleName);
            return m0.f.f(sb, " - ", message);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass4(this.$fileName, this.$logger, this.$service, this.$c, this.$startTime, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass4) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            List<OfflineTriggerMessageItem> listLoadAllPendingEpisodic;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            a0 a0Var = a0.f883a;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    String str = this.$fileName;
                    if (str != null) {
                        this.$logger.logD(MemoryDumpCommandHandler.TAG, null, new d(str, 0));
                        listLoadAllPendingEpisodic = this.$service.loadPendingFromFile(this.$fileName);
                    } else {
                        this.$logger.logD(MemoryDumpCommandHandler.TAG, null, new b(2));
                        listLoadAllPendingEpisodic = this.$service.loadAllPendingEpisodic();
                    }
                    if (listLoadAllPendingEpisodic.isEmpty()) {
                        this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new b(3));
                        return a0Var;
                    }
                    this.$logger.logD(MemoryDumpCommandHandler.TAG, null, new e(0, listLoadAllPendingEpisodic));
                    OfflineTriggerFirstRequest offlineTriggerFirstRequest = new OfflineTriggerFirstRequest(listLoadAllPendingEpisodic, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                    LightMemClient lightMemClient = this.$c;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 1;
                    obj = lightMemClient.offlineTriggerFirst(offlineTriggerFirstRequest, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                final OfflineTriggerResponse offlineTriggerResponse = (OfflineTriggerResponse) obj;
                long jCurrentTimeMillis = System.currentTimeMillis() - this.$startTime;
                this.$service.cacheTriggerResponse(offlineTriggerResponse);
                this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new f(0, jCurrentTimeMillis, offlineTriggerResponse));
                final int i9 = 0;
                this.$logger.logD(MemoryDumpCommandHandler.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.g
                    @Override // p5.a
                    public final Object invoke() {
                        int i10 = i9;
                        OfflineTriggerResponse offlineTriggerResponse2 = offlineTriggerResponse;
                        switch (i10) {
                            case 0:
                                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$5(offlineTriggerResponse2);
                            default:
                                return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$6(offlineTriggerResponse2);
                        }
                    }
                });
                if (!x5.n.t1(offlineTriggerResponse.getMemory())) {
                    final int i10 = 1;
                    this.$logger.logD(MemoryDumpCommandHandler.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.g
                        @Override // p5.a
                        public final Object invoke() {
                            int i102 = i10;
                            OfflineTriggerResponse offlineTriggerResponse2 = offlineTriggerResponse;
                            switch (i102) {
                                case 0:
                                    return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$5(offlineTriggerResponse2);
                                default:
                                    return MemoryDumpCommandHandler.AnonymousClass4.invokeSuspend$lambda$6(offlineTriggerResponse2);
                            }
                        }
                    });
                }
                List<OfflineSearchGroup> search_groups = offlineTriggerResponse.getSearch_groups();
                AndroidMemoryLogger androidMemoryLogger = this.$logger;
                int i11 = 0;
                for (Object obj2 : search_groups) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        c5.n.m0();
                        throw null;
                    }
                    androidMemoryLogger.logD(MemoryDumpCommandHandler.TAG, null, new h((OfflineSearchGroup) obj2, i11, 0));
                    i11 = i12;
                }
                return a0Var;
            } catch (Exception e9) {
                this.$logger.logE(MemoryDumpCommandHandler.TAG, null, e9, new f(1, System.currentTimeMillis() - this.$startTime, e9));
                return a0Var;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdatePoll$1", f = "MemoryDumpCommandHandler.kt", l = {433, 438}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdatePoll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00311 extends h5.i implements p5.p {
        final /* synthetic */ Map<Long, String> $indexMap;
        final /* synthetic */ OfflineUpdateResponse $resp;
        final /* synthetic */ OfflineEvolutionService $service;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00311(OfflineEvolutionService offlineEvolutionService, OfflineUpdateResponse offlineUpdateResponse, Map<Long, String> map, f5.c cVar) {
            super(2, cVar);
            this.$service = offlineEvolutionService;
            this.$resp = offlineUpdateResponse;
            this.$indexMap = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(boolean z) {
            return "[dumpOfflineUpdatePoll] apply done: result=" + z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(int i8) {
            return a8.b.k(i8, "[dumpOfflineUpdatePoll] marked ", " episodic entries as evolved");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2() {
            return "[dumpOfflineUpdatePoll] cached trigger data cleared";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$3(Exception exc) {
            return m0.f.c("[dumpOfflineUpdatePoll] apply failed: ", exc.getMessage());
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00311(this.$service, this.$resp, this.$indexMap, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00311) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
        
            if (r9 == r0) goto L22;
         */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                g5.a r0 = g5.a.f2984a
                int r1 = r8.label
                r2 = 2
                r3 = 1
                java.lang.String r4 = "MemoryDump"
                r5 = 0
                if (r1 == 0) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                a.a.c0(r9)     // Catch: java.lang.Exception -> L13
                goto L58
            L13:
                r8 = move-exception
                goto L82
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1d:
                a.a.c0(r9)     // Catch: java.lang.Exception -> L13
                goto L35
            L21:
                a.a.c0(r9)
                com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService r9 = r8.$service     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse r1 = r8.$resp     // Catch: java.lang.Exception -> L13
                java.util.Map<java.lang.Long, java.lang.String> r6 = r8.$indexMap     // Catch: java.lang.Exception -> L13
                java.lang.String r7 = "dumpsys-update-poll"
                r8.label = r3     // Catch: java.lang.Exception -> L13
                java.lang.Object r9 = r9.applyEvolutionResult(r1, r6, r7, r8)     // Catch: java.lang.Exception -> L13
                if (r9 != r0) goto L35
                goto L57
            L35:
                java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Exception -> L13
                boolean r9 = r9.booleanValue()     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.MemoryEngine r1 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r1 = r1.getDumpLogger$step_memory_release()     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.i r6 = new com.stepos.stepclaw.memory.i     // Catch: java.lang.Exception -> L13
                r6.<init>()     // Catch: java.lang.Exception -> L13
                r1.logI(r4, r5, r6)     // Catch: java.lang.Exception -> L13
                if (r9 == 0) goto L6d
                com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService r1 = r8.$service     // Catch: java.lang.Exception -> L13
                r8.Z$0 = r9     // Catch: java.lang.Exception -> L13
                r8.label = r2     // Catch: java.lang.Exception -> L13
                java.lang.Object r9 = com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService.markPendingAsEvolved$default(r1, r5, r8, r3, r5)     // Catch: java.lang.Exception -> L13
                if (r9 != r0) goto L58
            L57:
                return r0
            L58:
                java.lang.Number r9 = (java.lang.Number) r9     // Catch: java.lang.Exception -> L13
                int r9 = r9.intValue()     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.MemoryEngine r0 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r0 = r0.getDumpLogger$step_memory_release()     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.j r1 = new com.stepos.stepclaw.memory.j     // Catch: java.lang.Exception -> L13
                r2 = 0
                r1.<init>(r9, r2)     // Catch: java.lang.Exception -> L13
                r0.logI(r4, r5, r1)     // Catch: java.lang.Exception -> L13
            L6d:
                com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService r8 = r8.$service     // Catch: java.lang.Exception -> L13
                r8.clearCachedTriggerData()     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.MemoryEngine r8 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r8 = r8.getDumpLogger$step_memory_release()     // Catch: java.lang.Exception -> L13
                com.stepos.stepclaw.memory.b r9 = new com.stepos.stepclaw.memory.b     // Catch: java.lang.Exception -> L13
                r0 = 4
                r9.<init>(r0)     // Catch: java.lang.Exception -> L13
                r8.logI(r4, r5, r9)     // Catch: java.lang.Exception -> L13
                goto L91
            L82:
                com.stepos.stepclaw.memory.MemoryEngine r9 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r9 = r9.getDumpLogger$step_memory_release()
                com.stepos.stepclaw.memory.k r0 = new com.stepos.stepclaw.memory.k
                r1 = 0
                r0.<init>(r8, r1)
                r9.logE(r4, r5, r8, r0)
            L91:
                b5.a0 r8 = b5.a0.f883a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryDumpCommandHandler.C00311.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$3", f = "MemoryDumpCommandHandler.kt", l = {634}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$3, reason: invalid class name */
    public static final class AnonymousClass3 extends h5.i implements p5.p {
        final /* synthetic */ LightMemClient $c;
        final /* synthetic */ AndroidMemoryLogger $logger;
        final /* synthetic */ OfflineUpdateFirstRequest $req;
        final /* synthetic */ OfflineEvolutionService $service;
        long J$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(LightMemClient lightMemClient, OfflineUpdateFirstRequest offlineUpdateFirstRequest, AndroidMemoryLogger androidMemoryLogger, OfflineEvolutionService offlineEvolutionService, f5.c cVar) {
            super(2, cVar);
            this.$c = lightMemClient;
            this.$req = offlineUpdateFirstRequest;
            this.$logger = androidMemoryLogger;
            this.$service = offlineEvolutionService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(long j4, OfflineUpdateResponse offlineUpdateResponse) {
            String status = offlineUpdateResponse.getStatus();
            String strEffectiveTaskStatus = AsyncTaskStatusKt.effectiveTaskStatus(offlineUpdateResponse);
            String strEffectiveUniqueId = AsyncTaskStatusKt.effectiveUniqueId(offlineUpdateResponse);
            int size = offlineUpdateResponse.getEvolution_groups().size();
            StringBuilder sb = new StringBuilder("[dumpOfflineUpdateSubmit] HTTP done in ");
            sb.append(j4);
            sb.append("ms: status=");
            sb.append(status);
            a8.b.A(sb, ", task_status=", strEffectiveTaskStatus, ", unique_id=", strEffectiveUniqueId);
            sb.append(", evolution_groups=");
            sb.append(size);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(OfflineUpdateResponse offlineUpdateResponse) {
            return m0.f.c("[dumpOfflineUpdateSubmit] message: ", offlineUpdateResponse.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2(OfflineUpdateResponse offlineUpdateResponse) {
            return m0.f.c("[dumpOfflineUpdateSubmit] error_detail: ", offlineUpdateResponse.getError_detail());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$3(Exception exc) {
            return a8.b.p("[dumpOfflineUpdateSubmit] failed: ", exc.getClass().getSimpleName(), " - ", exc.getMessage());
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass3(this.$c, this.$req, this.$logger, this.$service, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass3) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            long j4;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    LightMemClient lightMemClient = this.$c;
                    OfflineUpdateFirstRequest offlineUpdateFirstRequest = this.$req;
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    obj = lightMemClient.offlineUpdateFirst(offlineUpdateFirstRequest, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                    j4 = jCurrentTimeMillis;
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j4 = this.J$0;
                    a.a.c0(obj);
                }
                final OfflineUpdateResponse offlineUpdateResponse = (OfflineUpdateResponse) obj;
                this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new f(2, System.currentTimeMillis() - j4, offlineUpdateResponse));
                if (!x5.n.t1(AsyncTaskStatusKt.effectiveUniqueId(offlineUpdateResponse))) {
                    this.$service.cacheUpdateUniqueId(AsyncTaskStatusKt.effectiveUniqueId(offlineUpdateResponse));
                }
                if (!x5.n.t1(offlineUpdateResponse.getMessage())) {
                    final int i9 = 0;
                    this.$logger.logD(MemoryDumpCommandHandler.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.l
                        @Override // p5.a
                        public final Object invoke() {
                            int i10 = i9;
                            OfflineUpdateResponse offlineUpdateResponse2 = offlineUpdateResponse;
                            switch (i10) {
                                case 0:
                                    return MemoryDumpCommandHandler.AnonymousClass3.invokeSuspend$lambda$1(offlineUpdateResponse2);
                                default:
                                    return MemoryDumpCommandHandler.AnonymousClass3.invokeSuspend$lambda$2(offlineUpdateResponse2);
                            }
                        }
                    });
                }
                if (!x5.n.t1(offlineUpdateResponse.getError_detail())) {
                    final int i10 = 1;
                    this.$logger.logW(MemoryDumpCommandHandler.TAG, null, new p5.a() { // from class: com.stepos.stepclaw.memory.l
                        @Override // p5.a
                        public final Object invoke() {
                            int i102 = i10;
                            OfflineUpdateResponse offlineUpdateResponse2 = offlineUpdateResponse;
                            switch (i102) {
                                case 0:
                                    return MemoryDumpCommandHandler.AnonymousClass3.invokeSuspend$lambda$1(offlineUpdateResponse2);
                                default:
                                    return MemoryDumpCommandHandler.AnonymousClass3.invokeSuspend$lambda$2(offlineUpdateResponse2);
                            }
                        }
                    });
                }
            } catch (Exception e9) {
                this.$logger.logE(MemoryDumpCommandHandler.TAG, null, e9, new k(e9, 1));
            }
            return a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpUpload$1", f = "MemoryDumpCommandHandler.kt", l = {885}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpUpload$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00321 extends h5.i implements p5.p {
        final /* synthetic */ AndroidMemoryLogger $logger;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00321(AndroidMemoryLogger androidMemoryLogger, f5.c cVar) {
            super(2, cVar);
            this.$logger = androidMemoryLogger;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0() {
            return "upload (dumpsys force): service returned null";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(UploadBatchResult uploadBatchResult) {
            int totalFiles = uploadBatchResult.getTotalFiles();
            int successCount = uploadBatchResult.getSuccessCount();
            int failedCount = uploadBatchResult.getFailedCount();
            StringBuilder sbT = a8.b.t("upload done: total=", totalFiles, ", success=", successCount, ", failed=");
            sbT.append(failedCount);
            return sbT.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2() {
            return "upload (dumpsys force) failed";
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00321(this.$logger, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00321) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            a0 a0Var = a0.f883a;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
                    this.label = 1;
                    obj = memoryEngine.forceUploadMemories(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                UploadBatchResult uploadBatchResult = (UploadBatchResult) obj;
                if (uploadBatchResult == null) {
                    this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new b(5));
                    return a0Var;
                }
                this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new m(uploadBatchResult, 0));
                return a0Var;
            } catch (Exception e9) {
                this.$logger.logE(MemoryDumpCommandHandler.TAG, null, e9, new b(6));
                return a0Var;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpUpload$2", f = "MemoryDumpCommandHandler.kt", l = {919}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpUpload$2, reason: invalid class name */
    public static final class AnonymousClass2 extends h5.i implements p5.p {
        final /* synthetic */ AndroidMemoryLogger $logger;
        final /* synthetic */ MemoryUploadService $svc;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MemoryUploadService memoryUploadService, AndroidMemoryLogger androidMemoryLogger, f5.c cVar) {
            super(2, cVar);
            this.$svc = memoryUploadService;
            this.$logger = androidMemoryLogger;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0() {
            return "upload (dumpsys): already done or skipped";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(UploadBatchResult uploadBatchResult) {
            int totalFiles = uploadBatchResult.getTotalFiles();
            int successCount = uploadBatchResult.getSuccessCount();
            int failedCount = uploadBatchResult.getFailedCount();
            StringBuilder sbT = a8.b.t("upload done: total=", totalFiles, ", success=", successCount, ", failed=");
            sbT.append(failedCount);
            return sbT.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2() {
            return "upload (dumpsys) failed";
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass2(this.$svc, this.$logger, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            a0 a0Var = a0.f883a;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    MemoryUploadService memoryUploadService = this.$svc;
                    this.label = 1;
                    obj = memoryUploadService.uploadIfNeeded(this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                UploadBatchResult uploadBatchResult = (UploadBatchResult) obj;
                if (uploadBatchResult == null) {
                    this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new b(7));
                    return a0Var;
                }
                this.$logger.logI(MemoryDumpCommandHandler.TAG, null, new m(uploadBatchResult, 1));
                return a0Var;
            } catch (Exception e9) {
                this.$logger.logE(MemoryDumpCommandHandler.TAG, null, e9, new b(8));
                return a0Var;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
    
        if (r1.equals(com.stepos.stepclaw.SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void dumpAuto(java.io.PrintWriter r2, java.lang.String[] r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L17
            r1 = 2
            java.lang.Object r1 = c5.l.f0(r3, r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L17
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.p.d(r1, r3)
            goto L18
        L17:
            r1 = 0
        L18:
            if (r1 == 0) goto L61
            int r3 = r1.hashCode()
            if (r3 == 0) goto L53
            r0 = 3551(0xddf, float:4.976E-42)
            if (r3 == r0) goto L3f
            r0 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r0) goto L2a
            goto L5b
        L2a:
            java.lang.String r3 = "off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L33
            goto L5b
        L33:
            com.stepos.stepclaw.memory.MemoryEngine r1 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE
            r3 = 0
            r1.setAutoRecallCaptureEnabled(r3)
            java.lang.String r1 = "auto: OFF (autoRecall + autoCapture disabled)"
            r2.println(r1)
            return
        L3f:
            java.lang.String r3 = "on"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L5b
            com.stepos.stepclaw.memory.MemoryEngine r1 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE
            r3 = 1
            r1.setAutoRecallCaptureEnabled(r3)
            java.lang.String r1 = "auto: ON (autoRecall + autoCapture enabled)"
            r2.println(r1)
            return
        L53:
            java.lang.String r3 = ""
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L61
        L5b:
            java.lang.String r1 = "Usage: mem auto [on|off]"
            r2.println(r1)
            return
        L61:
            com.stepos.stepclaw.memory.MemoryEngine r1 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE
            boolean r1 = r1.getAutoRecallCaptureEnabled()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "autoRecallCapture="
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.println(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryDumpCommandHandler.dumpAuto(java.io.PrintWriter, java.lang.String[]):void");
    }

    private final void dumpConfig(PrintWriter writer) {
        MemorySearchConfig searchConfig = MemoryEngine.INSTANCE.getSearchConfig();
        writer.println("=== MemorySearchConfig ===");
        writer.println("categories           = " + searchConfig.getCategories());
        writer.println("maxQueryLength       = " + searchConfig.getMaxQueryLength());
        writer.println("topKPerCategory      = " + searchConfig.getTopKPerCategory());
        writer.println("rrfK                 = " + searchConfig.getRrfK());
        writer.println("enableVectorRetrieval= " + searchConfig.getEnableVectorRetrieval());
        writer.println("enableHalfLifeRerank = " + searchConfig.getEnableHalfLifeRerank());
        writer.println("halfLifeSMin         = " + searchConfig.getHalfLifeSMin());
        writer.println("halfLifeSMax         = " + searchConfig.getHalfLifeSMax());
        writer.println("halfLifeBeta         = " + searchConfig.getHalfLifeBeta());
        writer.println("memoryFactorWeight   = " + searchConfig.getMemoryFactorWeight());
        writer.println("scoreThresholds:");
        for (Map.Entry entry : c5.m.J0(searchConfig.getScoreThresholds().entrySet(), new Comparator() { // from class: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpConfig$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l((String) ((Map.Entry) t8).getKey(), (String) ((Map.Entry) t9).getKey());
            }
        })) {
            writer.println("  " + ((String) entry.getKey()) + " = " + ((Number) entry.getValue()).floatValue());
        }
        writer.println("defaultScoreThreshold = " + searchConfig.getDefaultScoreThreshold());
        writer.println("maxEntries           = " + searchConfig.getMaxEntries());
        writer.println("maxFormatTokens      = " + searchConfig.getMaxFormatTokens());
        writer.println("categoryTokenWeights:");
        for (Map.Entry entry2 : c5.m.J0(searchConfig.getCategoryTokenWeights().entrySet(), new Comparator() { // from class: com.stepos.stepclaw.memory.MemoryDumpCommandHandler$dumpConfig$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return a.a.l((String) ((Map.Entry) t8).getKey(), (String) ((Map.Entry) t9).getKey());
            }
        })) {
            writer.println("  " + ((String) entry2.getKey()) + " = " + ((Number) entry2.getValue()).floatValue());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        if (r6.equals(com.stepos.stepclaw.SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID) == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void dumpDebug(java.io.PrintWriter r5, java.lang.String[] r6) {
        /*
            r4 = this;
            com.stepos.stepclaw.memory.MemoryEngine r4 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE
            com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r0 = r4.getDumpLogger$step_memory_release()
            if (r6 == 0) goto L1d
            r1 = 2
            java.lang.Object r6 = c5.l.f0(r6, r1)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L1d
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.p.d(r6, r1)
            goto L1e
        L1d:
            r6 = 0
        L1e:
            java.lang.String r1 = "(not set)"
            if (r6 == 0) goto L9e
            int r2 = r6.hashCode()
            if (r2 == 0) goto L90
            r3 = 3551(0xddf, float:4.976E-42)
            if (r2 == r3) goto L45
            r0 = 109935(0x1ad6f, float:1.54052E-40)
            if (r2 == r0) goto L32
            goto L98
        L32:
            java.lang.String r0 = "off"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L3b
            goto L98
        L3b:
            r6 = 0
            r4.setDebug(r6)
            java.lang.String r4 = "debug: OFF"
            r5.println(r4)
            return
        L45:
            java.lang.String r2 = "on"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L98
            r6 = 1
            r4.setDebug(r6)
            boolean r4 = r0.getPersistEnabled()
            java.lang.String r6 = r0.getPersistDir()
            if (r6 == 0) goto L63
            boolean r0 = x5.n.t1(r6)
            if (r0 == 0) goto L62
            goto L63
        L62:
            r1 = r6
        L63:
            com.stepos.stepclaw.memory.utils.PerfTrace r6 = com.stepos.stepclaw.memory.utils.PerfTrace.INSTANCE
            boolean r6 = r6.getEnabled()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "debug: ON  (persist="
            r0.<init>(r2)
            r0.append(r4)
            java.lang.String r4 = ", persistDir="
            r0.append(r4)
            r0.append(r1)
            java.lang.String r4 = ", perf="
            r0.append(r4)
            r0.append(r6)
            java.lang.String r4 = ")"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.println(r4)
            return
        L90:
            java.lang.String r4 = ""
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L9e
        L98:
            java.lang.String r4 = "Usage: mem debug [on|off]"
            r5.println(r4)
            return
        L9e:
            boolean r4 = r0.getDebugEnable()
            boolean r6 = r0.getPersistEnabled()
            java.lang.String r0 = r0.getPersistDir()
            if (r0 == 0) goto Lb4
            boolean r2 = x5.n.t1(r0)
            if (r2 == 0) goto Lb3
            goto Lb4
        Lb3:
            r1 = r0
        Lb4:
            com.stepos.stepclaw.memory.utils.PerfTrace r0 = com.stepos.stepclaw.memory.utils.PerfTrace.INSTANCE
            boolean r0 = r0.getEnabled()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "debug="
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r4 = "  persist="
            r2.append(r4)
            r2.append(r6)
            java.lang.String r4 = "  persistDir="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r4 = "  perf="
            r2.append(r4)
            r2.append(r0)
            java.lang.String r4 = r2.toString()
            r5.println(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryDumpCommandHandler.dumpDebug(java.io.PrintWriter, java.lang.String[]):void");
    }

    private final void dumpEmbed(PrintWriter writer, String[] args) {
        String strA0;
        if (args == null || (strA0 = c5.m.A0(c5.m.t0(c5.l.b0(args)), " ", null, null, null, 62)) == null) {
            strA0 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (x5.n.t1(strA0)) {
            writer.println("Usage: mem embed <text>");
            return;
        }
        EmbeddingClient dumpEmbeddingClient$step_memory_release = MemoryEngine.INSTANCE.getDumpEmbeddingClient$step_memory_release();
        if (dumpEmbeddingClient$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        writer.println("=== MemoryEngine Embed ===");
        writer.println("text: ".concat(strA0));
        String baseUrl = dumpEmbeddingClient$step_memory_release.getBaseUrl();
        if (x5.n.t1(baseUrl)) {
            baseUrl = "(not configured)";
        }
        writer.println("baseUrl: " + ((Object) baseUrl));
        try {
            List list = (List) i0.u(f5.i.f2626a, new MemoryDumpCommandHandler$dumpEmbed$embeddings$1(dumpEmbeddingClient$step_memory_release, strA0, null));
            if (list.isEmpty()) {
                writer.println("Result: empty response");
                return;
            }
            float[] fArr = (float[]) list.get(0);
            writer.println("dim: " + fArr.length);
            writer.println("values[0..4]: [" + c5.m.A0(c5.l.i0(fArr), ", ", null, null, new a(0), 30) + "]");
        } catch (Exception e9) {
            writer.println("embed failed: " + e9.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpEmbed$lambda$1(float f3) {
        return String.format("%.6f", Arrays.copyOf(new Object[]{Float.valueOf(f3)}, 1));
    }

    private final void dumpHelp(PrintWriter writer) {
        writer.println("=== MemoryEngine Dump Help ===");
        writer.println("  mem info               - 打印记忆 index 分层统计（分类、条目数、大小、时间范围）及 debug 开关状态");
        writer.println("  mem config             - 打印当前 MemorySearchConfig 所有参数");
        writer.println("  mem query <text>       - 对 <text> 执行 BM25 搜索并打印结果（跳过 LLM 改写）");
        writer.println("  mem pipeline <text>    - 对 <text> 执行完整 SearchPipeline（QueryRewrite+Retrieval+Rerank+Format）");
        writer.println("  mem embed <text>       - 调用远端 embed() 并打印向量维度与前5个值（验证 API 连通性）");
        writer.println("  mem embedmodel [list|use <id>|status] - 查看/切换 embedding provider；切换不持久化");
        writer.println("  mem debug [on|off]     - 查看或切换 debug 模式（开启后输出详细日志 + 性能计时）");
        writer.println("  mem offline_trigger [<file>] - 仅 LightMem offline_trigger 首包；可指定 episodic 日文件，不传则全量 pending（测试用，需网络）");
        writer.println("  mem offline_trigger_poll [<id>] - 仅轮询 POST /offline_trigger；省略 <id> 用 stepmem/.offline_async_debug.properties 中上次保存的 trigger unique_id");
        writer.println("  mem offline_update_submit  - 读取最新 trigger_response 日志，BM25 召回后首次提交 offline_update（不轮询）");
        writer.println("  mem offline_update_poll [<id>] - 仅轮询 POST /offline_update；省略 <id> 用上次保存的 offline_update unique_id");
        writer.println("  mem offline_evolution [<file>] - 完整离线演化 pipeline（trigger→BM25→update→落库）；可指定日文件，不传则全量 pending（后台执行）");
        writer.println("  mem localinfer [on|off|check] - 查看或切换本地推理辅助召回开关；check 子命令查询设备支持状态");
        writer.println("  mem upload             - 执行一次性自动上传记忆文件到云端（已完成则跳过）");
        writer.println("  mem upload force       - 强制全量重新上传（忽略完成标记）");
        writer.println("  mem upload status      - 查看上传完成状态及待上传文件列表");
        writer.println("  mem auto [on|off]      - 查看或切换 autoRecall/autoCapture 功能开关（默认关闭）");
    }

    private final void dumpInfo(PrintWriter writer) {
        String str;
        List<String> categories;
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        AndroidMemoryLogger dumpLogger$step_memory_release = memoryEngine.getDumpLogger$step_memory_release();
        writer.println("=== MemoryEngine Info ===");
        boolean debugEnable = dumpLogger$step_memory_release.getDebugEnable();
        boolean persistEnabled = dumpLogger$step_memory_release.getPersistEnabled();
        String persistDir = dumpLogger$step_memory_release.getPersistDir();
        String str2 = "(not set)";
        if (persistDir != null) {
            if (x5.n.t1(persistDir)) {
                persistDir = "(not set)";
            }
            str2 = persistDir;
        }
        writer.println("debug=" + debugEnable + "  persist=" + persistEnabled + "  persistDir=" + str2 + "  perf=" + PerfTrace.INSTANCE.getEnabled());
        boolean autoRecallCaptureEnabled = memoryEngine.getAutoRecallCaptureEnabled();
        StringBuilder sb = new StringBuilder("autoRecallCapture=");
        sb.append(autoRecallCaptureEnabled);
        writer.println(sb.toString());
        LocalInferenceEngine dumpLocalInferenceEngine$step_memory_release = memoryEngine.getDumpLocalInferenceEngine$step_memory_release();
        boolean memoryEnabled = dumpLocalInferenceEngine$step_memory_release.getMemoryEnabled();
        boolean embeddingEnabled = dumpLocalInferenceEngine$step_memory_release.getEmbeddingEnabled();
        if (dumpLocalInferenceEngine$step_memory_release.isReady()) {
            str = "ready";
        } else if (dumpLocalInferenceEngine$step_memory_release.getSupportState() != null) {
            str = "unsupported(" + dumpLocalInferenceEngine$step_memory_release.getSupportState() + ")";
        } else {
            str = "loading";
        }
        writer.println("localInfer memory=" + memoryEnabled + " embedding=" + embeddingEnabled + "  engine=" + str);
        writer.println();
        MemoryIndexManager dumpIndexManager$step_memory_release = memoryEngine.getDumpIndexManager$step_memory_release();
        if (dumpIndexManager$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        TieredCacheConfig cacheConfig = dumpIndexManager$step_memory_release.getCacheConfig();
        MemoryStorage dumpStorage$step_memory_release = memoryEngine.getDumpStorage$step_memory_release();
        if (dumpStorage$step_memory_release == null || (categories = dumpStorage$step_memory_release.getCategories()) == null) {
            categories = c5.s.f1092a;
        }
        writer.println("Categories (" + categories.size() + "):");
        for (String str3 : c5.m.I0(categories)) {
            writer.println("  [" + (cacheConfig.getPermanentCategories().contains(str3) ? "PERMANENT" : "DYNAMIC") + "] " + str3);
        }
        OfflineEvolutionService dumpOfflineEvolutionService$step_memory_release = memoryEngine.getDumpOfflineEvolutionService$step_memory_release();
        if (dumpOfflineEvolutionService$step_memory_release != null) {
            int iCountPendingEpisodic = dumpOfflineEvolutionService$step_memory_release.countPendingEpisodic();
            writer.println();
            writer.println("Episodic evolution: pending=" + iCountPendingEpisodic);
        }
        List<BM25Index.CategoryDateStats> categoryDateStats = dumpIndexManager$step_memory_release.getCategoryDateStats();
        Iterator<T> it = categoryDateStats.iterator();
        int entries = 0;
        int entries2 = 0;
        while (it.hasNext()) {
            entries2 += ((BM25Index.CategoryDateStats) it.next()).getEntries();
        }
        Iterator<T> it2 = categoryDateStats.iterator();
        long memBytes = 0;
        long sizeBytes = 0;
        while (it2.hasNext()) {
            sizeBytes += ((BM25Index.CategoryDateStats) it2.next()).getSizeBytes();
        }
        String size = formatSize(sizeBytes);
        writer.println();
        StringBuilder sbT = a8.b.t("BM25 index (", categoryDateStats.size(), " partitions, ", entries2, " entries, ");
        sbT.append(size);
        sbT.append("):");
        writer.println(sbT.toString());
        for (BM25Index.CategoryDateStats categoryDateStats2 : categoryDateStats) {
            String key = categoryDateStats2.getKey();
            int entries3 = categoryDateStats2.getEntries();
            String size2 = formatSize(categoryDateStats2.getSizeBytes());
            StringBuilder sbU = a8.b.u("  ", entries3, key, ": ", " entries, ");
            sbU.append(size2);
            writer.println(sbU.toString());
        }
        EmbeddingStorage dumpEmbeddingStorage$step_memory_release = memoryEngine.getDumpEmbeddingStorage$step_memory_release();
        if (dumpEmbeddingStorage$step_memory_release != null) {
            List<EmbeddingStorage.BinStats> listCacheStats = dumpEmbeddingStorage$step_memory_release.cacheStats();
            Iterator<T> it3 = listCacheStats.iterator();
            while (it3.hasNext()) {
                entries += ((EmbeddingStorage.BinStats) it3.next()).getEntries();
            }
            Iterator<T> it4 = listCacheStats.iterator();
            while (it4.hasNext()) {
                memBytes += ((EmbeddingStorage.BinStats) it4.next()).getMemBytes();
            }
            writer.println();
            int size3 = listCacheStats.size();
            String size4 = formatSize(memBytes);
            StringBuilder sbT2 = a8.b.t("Embedding cache (", size3, " bins, ", entries, " entries, ");
            sbT2.append(size4);
            sbT2.append("):");
            writer.println(sbT2.toString());
            for (EmbeddingStorage.BinStats binStats : listCacheStats) {
                String key2 = binStats.getKey();
                int entries4 = binStats.getEntries();
                String size5 = formatSize(binStats.getMemBytes());
                StringBuilder sbU2 = a8.b.u("  ", entries4, key2, ": ", " entries, ");
                sbU2.append(size5);
                writer.println(sbU2.toString());
            }
        }
    }

    private final void dumpLocalInfer(PrintWriter writer, String[] args) {
        String lowerCase;
        String lowerCase2;
        String str;
        String str2;
        LocalInferenceEngine dumpLocalInferenceEngine$step_memory_release = MemoryEngine.INSTANCE.getDumpLocalInferenceEngine$step_memory_release();
        if (args == null || (str2 = (String) c5.l.f0(args, 2)) == null) {
            lowerCase = null;
        } else {
            lowerCase = str2.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.d(lowerCase, "toLowerCase(...)");
        }
        if (args == null || (str = (String) c5.l.f0(args, 3)) == null) {
            lowerCase2 = null;
        } else {
            lowerCase2 = str.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.d(lowerCase2, "toLowerCase(...)");
        }
        if (kotlin.jvm.internal.p.a(lowerCase, "on") && lowerCase2 == null) {
            dumpLocalInferenceEngine$step_memory_release.setMemoryEnabled(true);
            dumpLocalInferenceEngine$step_memory_release.setEmbeddingEnabled(true);
            dumpLocalInfer$rebuild();
            writer.println("localinfer: ON (memory+embedding)  engine=" + (dumpLocalInferenceEngine$step_memory_release.isReady() ? "ready" : "not-ready") + "  pipeline=rebuilt");
            return;
        }
        if (kotlin.jvm.internal.p.a(lowerCase, "off") && lowerCase2 == null) {
            dumpLocalInferenceEngine$step_memory_release.setMemoryEnabled(false);
            dumpLocalInferenceEngine$step_memory_release.setEmbeddingEnabled(false);
            dumpLocalInfer$rebuild();
            writer.println("localinfer: OFF (memory+embedding)  pipeline=rebuilt");
            return;
        }
        if (kotlin.jvm.internal.p.a(lowerCase, "memory") && kotlin.jvm.internal.p.a(lowerCase2, "on")) {
            dumpLocalInferenceEngine$step_memory_release.setMemoryEnabled(true);
            dumpLocalInfer$rebuild();
            writer.println("localinfer: memory ON  pipeline=rebuilt");
            return;
        }
        if (kotlin.jvm.internal.p.a(lowerCase, "memory") && kotlin.jvm.internal.p.a(lowerCase2, "off")) {
            dumpLocalInferenceEngine$step_memory_release.setMemoryEnabled(false);
            dumpLocalInfer$rebuild();
            writer.println("localinfer: memory OFF  pipeline=rebuilt");
            return;
        }
        if (kotlin.jvm.internal.p.a(lowerCase, "embedding") && kotlin.jvm.internal.p.a(lowerCase2, "on")) {
            dumpLocalInferenceEngine$step_memory_release.setEmbeddingEnabled(true);
            writer.println("localinfer: embedding ON");
            return;
        }
        if (kotlin.jvm.internal.p.a(lowerCase, "embedding") && kotlin.jvm.internal.p.a(lowerCase2, "off")) {
            dumpLocalInferenceEngine$step_memory_release.setEmbeddingEnabled(false);
            writer.println("localinfer: embedding OFF");
            return;
        }
        if (!kotlin.jvm.internal.p.a(lowerCase, "check")) {
            if (lowerCase == null || lowerCase.equals(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
                dumpLocalInfer$printStatus(writer, dumpLocalInferenceEngine$step_memory_release);
                return;
            } else {
                writer.println("Usage: mem localinfer [on|off|check|memory on|off|embedding on|off]");
                return;
            }
        }
        LocalInferSupportState supportState = dumpLocalInferenceEngine$step_memory_release.getSupportState();
        if (supportState != null) {
            writer.println("localinfer check: " + supportState + " (code=" + supportState.getCode() + ", cached=true)");
            return;
        }
        Context applicationContext = dumpLocalInferenceEngine$step_memory_release.getApplicationContext();
        if (applicationContext == null) {
            writer.println("localinfer check: not checked yet (init not called)");
            return;
        }
        h6.e eVar = r0.f210a;
        LocalInferSupportState localInferSupportState = (LocalInferSupportState) i0.u(h6.d.f3059c, new MemoryDumpCommandHandler$dumpLocalInfer$support$1(dumpLocalInferenceEngine$step_memory_release, applicationContext, null));
        writer.println("localinfer check: " + localInferSupportState + " (code=" + localInferSupportState.getCode() + ")");
    }

    private static final void dumpLocalInfer$printStatus(PrintWriter printWriter, LocalInferenceEngine localInferenceEngine) {
        String str;
        boolean memoryEnabled = localInferenceEngine.getMemoryEnabled();
        boolean embeddingEnabled = localInferenceEngine.getEmbeddingEnabled();
        if (localInferenceEngine.isReady()) {
            str = "ready";
        } else if (localInferenceEngine.getSupportState() != null) {
            str = "unsupported(" + localInferenceEngine.getSupportState() + ")";
        } else {
            str = "loading";
        }
        printWriter.println("localinfer memory=" + memoryEnabled + " embedding=" + embeddingEnabled + "  engine=" + str);
    }

    private static final void dumpLocalInfer$rebuild() {
        MemoryEngine.INSTANCE.rebuildSearchPipeline$step_memory_release();
    }

    private final void dumpOfflineEvolution(PrintWriter writer, String[] args) {
        String str;
        if (args == null || (str = (String) c5.l.f0(args, 2)) == null || x5.n.t1(str)) {
            str = null;
        }
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        File dumpStorageRoot$step_memory_release = memoryEngine.getDumpStorageRoot$step_memory_release();
        LightMemClient dumpClient$step_memory_release = memoryEngine.getDumpClient$step_memory_release();
        f0 dumpScope$step_memory_release = memoryEngine.getDumpScope$step_memory_release();
        if (dumpClient$step_memory_release == null || dumpStorageRoot$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        writer.println("=== MemoryEngine offline_evolution (full pipeline) ===");
        writer.println("storageRoot: " + dumpStorageRoot$step_memory_release.getAbsolutePath());
        writer.println("lightmem baseUrl: " + dumpClient$step_memory_release.getBaseUrl());
        writer.println("mode: " + (str != null ? "file=".concat(str) : "all pending episodic"));
        if (dumpScope$step_memory_release == null) {
            writer.println("CoroutineScope not initialized; cannot run pipeline.");
            return;
        }
        writer.println("Pipeline runs in background (multi-step HTTP + BM25; dumpsys would binder-timeout if blocked). Filter progress: adb logcat -s OfflineEvo (steps [0/5]..[5/5]); errors may also appear under MemoryDump.");
        writer.flush();
        OfflineEvolutionLog.INSTANCE.step(0, 5, "dumpsys: full pipeline started async (then [1/5]..[5/5])");
        AndroidMemoryLogger dumpLogger$step_memory_release = memoryEngine.getDumpLogger$step_memory_release();
        String strA1 = str != null ? x5.u.a1(x5.n.C1(str, MemoryFile.EXTENSION), "/", "_") : "all";
        h6.e eVar = r0.f210a;
        i0.q(dumpScope$step_memory_release, h6.d.f3059c, new AnonymousClass1(strA1, str, dumpLogger$step_memory_release, null), 2);
    }

    private final void dumpOfflineTrigger(PrintWriter writer, String[] args) {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i8 = 2;
        String str2 = (args == null || (str = (String) c5.l.f0(args, 2)) == null || x5.n.t1(str)) ? null : str;
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        AndroidMemoryLogger dumpLogger$step_memory_release = memoryEngine.getDumpLogger$step_memory_release();
        dumpLogger$step_memory_release.logD(TAG, null, new d(str2, i8));
        LightMemClient dumpClient$step_memory_release = memoryEngine.getDumpClient$step_memory_release();
        File dumpStorageRoot$step_memory_release = memoryEngine.getDumpStorageRoot$step_memory_release();
        f0 dumpScope$step_memory_release = memoryEngine.getDumpScope$step_memory_release();
        OfflineEvolutionService dumpOfflineEvolutionService$step_memory_release = memoryEngine.getDumpOfflineEvolutionService$step_memory_release();
        if (dumpClient$step_memory_release == null || dumpStorageRoot$step_memory_release == null || dumpOfflineEvolutionService$step_memory_release == null) {
            dumpLogger$step_memory_release.logW(TAG, null, new s(dumpClient$step_memory_release, dumpStorageRoot$step_memory_release, dumpOfflineEvolutionService$step_memory_release, 1));
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        writer.println("=== MemoryEngine offline_trigger (first POST only) ===");
        writer.println("storageRoot: " + dumpStorageRoot$step_memory_release.getAbsolutePath());
        writer.println("lightmem baseUrl: " + dumpClient$step_memory_release.getBaseUrl());
        writer.println("mode: " + (str2 != null ? "file=".concat(str2) : "all pending episodic"));
        if (dumpScope$step_memory_release == null) {
            writer.println("CoroutineScope not initialized; cannot run async.");
            return;
        }
        writer.println();
        writer.println("HTTP runs in background (server may be slow, dumpsys would binder-timeout if blocked).");
        writer.println("Watch progress: adb logcat -s LightMemClient MemoryEngine");
        writer.flush();
        dumpLogger$step_memory_release.logD(TAG, null, new b(10));
        h6.e eVar = r0.f210a;
        i0.q(dumpScope$step_memory_release, h6.d.f3059c, new AnonymousClass4(str2, dumpLogger$step_memory_release, dumpOfflineEvolutionService$step_memory_release, dumpClient$step_memory_release, jCurrentTimeMillis, null), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dumpOfflineTrigger$lambda$1(String str) {
        if (str == null) {
            str = "(all pending)";
        }
        return "[dumpOfflineTrigger] start, fileName=".concat(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dumpOfflineTrigger$lambda$2(LightMemClient lightMemClient, File file, OfflineEvolutionService offlineEvolutionService) {
        return "[dumpOfflineTrigger] not initialized: client=" + (lightMemClient != null) + ", root=" + (file != null) + ", service=" + (offlineEvolutionService != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dumpOfflineTrigger$lambda$3() {
        return "[dumpOfflineTrigger] launching async coroutine...";
    }

    private final void dumpOfflineTriggerPoll(PrintWriter writer, String[] args) {
        String strA0;
        String string = (args == null || (strA0 = c5.m.A0(c5.m.t0(c5.l.b0(args)), " ", null, null, null, 62)) == null) ? null : x5.n.T1(strA0).toString();
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        File dumpStorageRoot$step_memory_release = memoryEngine.getDumpStorageRoot$step_memory_release();
        LightMemClient dumpClient$step_memory_release = memoryEngine.getDumpClient$step_memory_release();
        OfflineEvolutionService dumpOfflineEvolutionService$step_memory_release = memoryEngine.getDumpOfflineEvolutionService$step_memory_release();
        if (dumpClient$step_memory_release == null || dumpStorageRoot$step_memory_release == null || dumpOfflineEvolutionService$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        if (x5.n.t1(string)) {
            String lastTriggerUniqueId = dumpOfflineEvolutionService$step_memory_release.readLastTriggerUniqueId();
            if (lastTriggerUniqueId != null) {
                str = lastTriggerUniqueId;
            }
            string = str;
        }
        if (x5.n.t1(string)) {
            writer.println("Usage: mem offline_trigger_poll [<unique_id>]");
            writer.println("If <unique_id> is omitted, uses last cached id from memory");
            writer.println("(cached after mem offline_trigger, offline_evolution, or runOfflineEvolutionEpisodicPipeline)");
            return;
        }
        writer.println("=== MemoryEngine offline_trigger_poll (test) ===");
        writer.println("lightmem baseUrl: " + dumpClient$step_memory_release.getBaseUrl());
        writer.println("unique_id: ".concat(string));
        writer.flush();
        try {
            OfflineTriggerResponse offlineTriggerResponse = (OfflineTriggerResponse) i0.u(f5.i.f2626a, new MemoryDumpCommandHandler$dumpOfflineTriggerPoll$resp$1(dumpClient$step_memory_release, string, null));
            writer.println("status: " + offlineTriggerResponse.getStatus());
            writer.println("message: " + offlineTriggerResponse.getMessage());
            writer.println("task_status: " + AsyncTaskStatusKt.effectiveTaskStatus(offlineTriggerResponse));
            writer.println("unique_id(effective): " + AsyncTaskStatusKt.effectiveUniqueId(offlineTriggerResponse));
            if (!x5.n.t1(offlineTriggerResponse.getError_detail())) {
                writer.println("error_detail: " + offlineTriggerResponse.getError_detail());
            }
            writer.println("search_groups (" + offlineTriggerResponse.getSearch_groups().size() + "):");
            int i8 = 0;
            for (Object obj : offlineTriggerResponse.getSearch_groups()) {
                int i9 = i8 + 1;
                if (i8 < 0) {
                    c5.n.m0();
                    throw null;
                }
                OfflineSearchGroup offlineSearchGroup = (OfflineSearchGroup) obj;
                writer.println("  [" + i8 + "] group_id=" + offlineSearchGroup.getGroup_id() + " search_queries=" + offlineSearchGroup.getSearch().size());
                i8 = i9;
            }
            if (AsyncTaskStatus.INSTANCE.shouldConsumeOfflineTriggerSearchGroups(offlineTriggerResponse)) {
                dumpOfflineEvolutionService$step_memory_release.cacheTriggerResponse(offlineTriggerResponse);
                writer.println();
                writer.println("trigger response cached in memory for offline_update_submit");
            }
        } catch (a2 unused) {
            writer.println("offline_trigger_poll: timed out after 15000ms");
        } catch (Exception e9) {
            writer.println("offline_trigger_poll failed: " + e9.getClass().getSimpleName() + " - " + e9.getMessage());
        }
    }

    private final void dumpOfflineUpdatePoll(PrintWriter writer, String[] args) {
        String strA0;
        f5.i iVar = f5.i.f2626a;
        String string = (args == null || (strA0 = c5.m.A0(c5.m.t0(c5.l.b0(args)), " ", null, null, null, 62)) == null) ? null : x5.n.T1(strA0).toString();
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        File dumpStorageRoot$step_memory_release = memoryEngine.getDumpStorageRoot$step_memory_release();
        LightMemClient dumpClient$step_memory_release = memoryEngine.getDumpClient$step_memory_release();
        f0 dumpScope$step_memory_release = memoryEngine.getDumpScope$step_memory_release();
        OfflineEvolutionService dumpOfflineEvolutionService$step_memory_release = memoryEngine.getDumpOfflineEvolutionService$step_memory_release();
        if (dumpClient$step_memory_release == null || dumpStorageRoot$step_memory_release == null || dumpOfflineEvolutionService$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        if (x5.n.t1(string)) {
            String lastUpdateUniqueId = dumpOfflineEvolutionService$step_memory_release.readLastUpdateUniqueId();
            if (lastUpdateUniqueId != null) {
                str = lastUpdateUniqueId;
            }
            string = str;
        }
        if (x5.n.t1(string)) {
            writer.println("Usage: mem offline_update_poll [<unique_id>]");
            writer.println("If <unique_id> is omitted, uses last cached id from memory");
            writer.println("(cached when pipeline submits offline_update)");
            return;
        }
        writer.println("=== MemoryEngine offline_update_poll (test) ===");
        writer.println("lightmem baseUrl: " + dumpClient$step_memory_release.getBaseUrl());
        writer.println("unique_id: ".concat(string));
        writer.flush();
        try {
            OfflineUpdateResponse offlineUpdateResponse = (OfflineUpdateResponse) i0.u(iVar, new MemoryDumpCommandHandler$dumpOfflineUpdatePoll$resp$1(dumpClient$step_memory_release, string, null));
            writer.println("status: " + offlineUpdateResponse.getStatus());
            writer.println("message: " + offlineUpdateResponse.getMessage());
            writer.println("task_status: " + AsyncTaskStatusKt.effectiveTaskStatus(offlineUpdateResponse));
            writer.println("unique_id(effective): " + AsyncTaskStatusKt.effectiveUniqueId(offlineUpdateResponse));
            if (!x5.n.t1(offlineUpdateResponse.getError_detail())) {
                writer.println("error_detail: " + offlineUpdateResponse.getError_detail());
            }
            writer.println("evolution_groups (" + offlineUpdateResponse.getEvolution_groups().size() + "):");
            Iterator it = offlineUpdateResponse.getEvolution_groups().iterator();
            int i8 = 0;
            while (it.hasNext()) {
                int i9 = i8 + 1;
                OfflineEvolutionGroup offlineEvolutionGroup = (OfflineEvolutionGroup) it.next();
                Map<String, List<CatchMemoryItem>> add_memories = offlineEvolutionGroup.getAdd_memories();
                String strA02 = c5.m.A0(add_memories.entrySet(), null, null, null, new a(1), 31);
                writer.println("  [" + i8 + "] group_id=" + offlineEvolutionGroup.getGroup_id() + ": add(" + strA02 + "), delete=" + offlineEvolutionGroup.getDelete_memories().size());
                Iterator<Map.Entry<String, List<CatchMemoryItem>>> it2 = add_memories.entrySet().iterator();
                while (true) {
                    int i10 = 80;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry<String, List<CatchMemoryItem>> next = it2.next();
                    String key = next.getKey();
                    int i11 = 0;
                    for (CatchMemoryItem catchMemoryItem : next.getValue()) {
                        writer.println("    add." + key + "[" + i11 + "]: content=" + x5.n.Q1(i10, catchMemoryItem.getContent()) + ", confidence=" + catchMemoryItem.getConfidence());
                        i11++;
                        it = it;
                        i10 = 80;
                    }
                }
                Iterator it3 = it;
                int i12 = 0;
                for (OfflineEvolutionDeleteMemory offlineEvolutionDeleteMemory : offlineEvolutionGroup.getDelete_memories()) {
                    writer.println("    delete[" + i12 + "]: memory_index=" + offlineEvolutionDeleteMemory.getMemory_index() + ", memory_type=" + offlineEvolutionDeleteMemory.getMemory_type() + ", content=" + x5.n.Q1(80, offlineEvolutionDeleteMemory.getContent()));
                    i12++;
                }
                i8 = i9;
                it = it3;
            }
            writer.flush();
            AsyncTaskStatus asyncTaskStatus = AsyncTaskStatus.INSTANCE;
            if (!asyncTaskStatus.shouldApplyOfflineUpdateResult(offlineUpdateResponse)) {
                if (asyncTaskStatus.isUpdateFailed(offlineUpdateResponse)) {
                    writer.println();
                    writer.println("task_status=failed; not applying.");
                    dumpOfflineEvolutionService$step_memory_release.clearCachedTriggerData();
                    writer.println("cached trigger data cleared");
                    return;
                }
                writer.println();
                writer.println("task_status=" + AsyncTaskStatusKt.effectiveTaskStatus(offlineUpdateResponse) + "; still in progress, not applying yet.");
                writer.println("Run 'mem offline_update_poll' again later.");
                return;
            }
            Map<Long, String> mapLoadMemoryIndexToDocIdMap = dumpOfflineEvolutionService$step_memory_release.loadMemoryIndexToDocIdMap();
            writer.println();
            writer.println("task_status=completed, applying results (add + delete)...");
            writer.println("memoryIndexToDocId map loaded: " + mapLoadMemoryIndexToDocIdMap.size() + " entries");
            writer.flush();
            if (dumpScope$step_memory_release != null) {
                writer.println("Applying in background. Watch: adb logcat -s MemoryEngine");
                h6.e eVar = r0.f210a;
                i0.q(dumpScope$step_memory_release, h6.d.f3059c, new C00311(dumpOfflineEvolutionService$step_memory_release, offlineUpdateResponse, mapLoadMemoryIndexToDocIdMap, null), 2);
                return;
            }
            writer.println("CoroutineScope not initialized; running synchronously.");
            boolean zBooleanValue = ((Boolean) i0.u(iVar, new MemoryDumpCommandHandler$dumpOfflineUpdatePoll$applied$1(dumpOfflineEvolutionService$step_memory_release, offlineUpdateResponse, mapLoadMemoryIndexToDocIdMap, null))).booleanValue();
            writer.println("apply done: result=" + zBooleanValue);
            if (zBooleanValue) {
                writer.println("marked " + ((Number) i0.u(iVar, new MemoryDumpCommandHandler$dumpOfflineUpdatePoll$markedCount$1(dumpOfflineEvolutionService$step_memory_release, null))).intValue() + " episodic entries as evolved");
            }
            dumpOfflineEvolutionService$step_memory_release.clearCachedTriggerData();
            writer.println("cached trigger data cleared");
        } catch (a2 unused) {
            writer.println("offline_update_poll: timed out after 15000ms");
        } catch (Exception e9) {
            writer.println("offline_update_poll failed: " + e9.getClass().getSimpleName() + " - " + e9.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence dumpOfflineUpdatePoll$lambda$1(Map.Entry it) {
        kotlin.jvm.internal.p.e(it, "it");
        return it.getKey() + "=" + ((List) it.getValue()).size();
    }

    private final void dumpOfflineUpdateSubmit(PrintWriter writer) {
        List<OfflineUpdateGroupMessage> messages;
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        File dumpStorageRoot$step_memory_release = memoryEngine.getDumpStorageRoot$step_memory_release();
        LightMemClient dumpClient$step_memory_release = memoryEngine.getDumpClient$step_memory_release();
        MemoryIndexManager dumpIndexManager$step_memory_release = memoryEngine.getDumpIndexManager$step_memory_release();
        f0 dumpScope$step_memory_release = memoryEngine.getDumpScope$step_memory_release();
        OfflineEvolutionService dumpOfflineEvolutionService$step_memory_release = memoryEngine.getDumpOfflineEvolutionService$step_memory_release();
        if (dumpClient$step_memory_release == null || dumpStorageRoot$step_memory_release == null || dumpIndexManager$step_memory_release == null || dumpOfflineEvolutionService$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        writer.println("=== MemoryEngine offline_update_submit ===");
        writer.println("storageRoot: " + dumpStorageRoot$step_memory_release.getAbsolutePath());
        writer.println("lightmem baseUrl: " + dumpClient$step_memory_release.getBaseUrl());
        OfflineTriggerResponse cachedTriggerResponse = dumpOfflineEvolutionService$step_memory_release.getCachedTriggerResponse();
        if (cachedTriggerResponse == null) {
            writer.println("No cached trigger response in memory.");
            writer.println("Run 'mem offline_trigger_poll' first to get and cache trigger response.");
            return;
        }
        writer.println("Using cached trigger response from memory");
        writer.println("trigger status: " + cachedTriggerResponse.getStatus());
        writer.println("trigger task_status: " + AsyncTaskStatusKt.effectiveTaskStatus(cachedTriggerResponse));
        writer.println("trigger unique_id: " + AsyncTaskStatusKt.effectiveUniqueId(cachedTriggerResponse));
        writer.println("search_groups: " + cachedTriggerResponse.getSearch_groups().size());
        if (cachedTriggerResponse.getSearch_groups().isEmpty()) {
            writer.println("No search_groups in trigger response, nothing to submit.");
            return;
        }
        writer.println();
        writer.println("Running BM25 recall...");
        writer.flush();
        OfflineEvolutionRecaller.OfflineUpdateBuildResult offlineUpdateBuildResult = (OfflineEvolutionRecaller.OfflineUpdateBuildResult) i0.u(f5.i.f2626a, new MemoryDumpCommandHandler$dumpOfflineUpdateSubmit$built$1(dumpIndexManager$step_memory_release, cachedTriggerResponse, c5.m.R0(memoryEngine.getSearchConfig().getCategories()), null));
        long jMemoryBucketItemCount = 0;
        while (offlineUpdateBuildResult.getMessages().iterator().hasNext()) {
            jMemoryBucketItemCount += OfflineEvolutionModelsKt.memoryBucketItemCount(((OfflineUpdateGroupMessage) r1.next()).getSearch_memories());
        }
        writer.println("BM25 recall done: " + offlineUpdateBuildResult.getMessages().size() + " groups, " + jMemoryBucketItemCount + " total memories");
        int size = offlineUpdateBuildResult.getMemoryIndexToDocId().size();
        StringBuilder sb = new StringBuilder("memoryIndexToDocId map size: ");
        sb.append(size);
        writer.println(sb.toString());
        dumpOfflineEvolutionService$step_memory_release.persistMemoryIndexToDocIdMap(offlineUpdateBuildResult.getMemoryIndexToDocId());
        writer.println("memoryIndexToDocId persisted to memory");
        if (!offlineUpdateBuildResult.getMessages().isEmpty() && ((messages = offlineUpdateBuildResult.getMessages()) == null || !messages.isEmpty())) {
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                if (!OfflineEvolutionModelsKt.memoryBucketsHaveNoItems(((OfflineUpdateGroupMessage) it.next()).getSearch_memories())) {
                    OfflineUpdateFirstRequest offlineUpdateFirstRequest = new OfflineUpdateFirstRequest(AsyncTaskStatusKt.effectiveUniqueId(cachedTriggerResponse), offlineUpdateBuildResult.getMessages(), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                    writer.println();
                    writer.println("Submitting offline_update (first request, no polling)...");
                    writer.println("unique_id: " + offlineUpdateFirstRequest.getUnique_id());
                    writer.flush();
                    if (dumpScope$step_memory_release == null) {
                        writer.println("CoroutineScope not initialized; cannot run async.");
                        return;
                    }
                    writer.println();
                    writer.println("HTTP runs in background. Watch progress: adb logcat -s LightMemClient MemoryEngine");
                    writer.println("Then use 'mem offline_update_poll' to check result.");
                    writer.flush();
                    AndroidMemoryLogger dumpLogger$step_memory_release = MemoryEngine.INSTANCE.getDumpLogger$step_memory_release();
                    dumpOfflineEvolutionService$step_memory_release.cacheUpdateUniqueId(offlineUpdateFirstRequest.getUnique_id());
                    dumpLogger$step_memory_release.logI(TAG, null, new c(6, offlineUpdateFirstRequest));
                    h6.e eVar = r0.f210a;
                    i0.q(dumpScope$step_memory_release, h6.d.f3059c, new AnonymousClass3(dumpClient$step_memory_release, offlineUpdateFirstRequest, dumpLogger$step_memory_release, dumpOfflineEvolutionService$step_memory_release, null), 2);
                    return;
                }
            }
        }
        writer.println("No usable BM25 hits; skip offline_update submit.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dumpOfflineUpdateSubmit$lambda$2(OfflineUpdateFirstRequest offlineUpdateFirstRequest) {
        return "[dumpOfflineUpdateSubmit] submitting offline_update, unique_id=" + offlineUpdateFirstRequest.getUnique_id() + ", groups=" + offlineUpdateFirstRequest.getMessages().size();
    }

    private final void dumpPipeline(PrintWriter writer, String[] args) {
        String strA0;
        if (args == null || (strA0 = c5.m.A0(c5.m.t0(c5.l.b0(args)), " ", null, null, null, 62)) == null) {
            strA0 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (x5.n.t1(strA0)) {
            writer.println("Usage: mem pipeline <text>");
            return;
        }
        SearchPipeline dumpSearchPipeline$step_memory_release = MemoryEngine.INSTANCE.getDumpSearchPipeline$step_memory_release();
        if (dumpSearchPipeline$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        writer.println("=== MemoryEngine Pipeline ===");
        writer.println("query: ".concat(strA0));
        writer.println();
        SearchPipelineResult searchPipelineResult = (SearchPipelineResult) i0.u(f5.i.f2626a, new MemoryDumpCommandHandler$dumpPipeline$pipelineResult$1(dumpSearchPipeline$step_memory_release, strA0, null));
        if (searchPipelineResult.isFailure()) {
            writer.println("(pipeline failed: " + ((SearchPipelineResult.Failed) searchPipelineResult).getError().getMessage() + ")");
            return;
        }
        String text = searchPipelineResult.getText();
        if (x5.n.t1(text)) {
            writer.println("(empty — no memories recalled)");
        } else {
            writer.println(text);
        }
    }

    private final void dumpQuery(PrintWriter writer, String[] args) {
        String strA0;
        if (args == null || (strA0 = c5.m.A0(c5.m.t0(c5.l.b0(args)), " ", null, null, null, 62)) == null) {
            strA0 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (x5.n.t1(strA0)) {
            writer.println("Usage: mem query <text>");
            return;
        }
        writer.println("=== MemoryEngine Query ===");
        writer.println("query: ".concat(strA0));
        MemoryIndexManager dumpIndexManager$step_memory_release = MemoryEngine.INSTANCE.getDumpIndexManager$step_memory_release();
        if (dumpIndexManager$step_memory_release == null) {
            writer.println("[MemoryEngine] not initialized");
            return;
        }
        writer.println();
        List list = (List) i0.u(f5.i.f2626a, new MemoryDumpCommandHandler$dumpQuery$results$1(dumpIndexManager$step_memory_release, strA0, null));
        if (list.isEmpty()) {
            writer.println("No results found for query: ".concat(strA0));
            return;
        }
        writer.println("Results (" + list.size() + "):");
        int i8 = 0;
        for (Object obj : list) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                c5.n.m0();
                throw null;
            }
            MemoryEntry memoryEntry = (MemoryEntry) obj;
            String strZ0 = x5.u.Z0(x5.n.Q1(100, memoryEntry.getContent()), '\n', ' ');
            String category = memoryEntry.getCategory();
            String date = memoryEntry.getDate();
            String str = String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(memoryEntry.getScore())}, 1));
            String id = memoryEntry.getId();
            StringBuilder sb = new StringBuilder("#");
            sb.append(i9);
            sb.append(" [");
            sb.append(category);
            sb.append("][");
            a8.b.A(sb, date, "] score=", str, " id=");
            sb.append(id);
            writer.println(sb.toString());
            writer.println("   ".concat(strZ0));
            i8 = i9;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cf, code lost:
    
        if (r14.equals(com.stepos.stepclaw.SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID) == false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void dumpUpload(java.io.PrintWriter r13, java.lang.String[] r14) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryDumpCommandHandler.dumpUpload(java.io.PrintWriter, java.lang.String[]):void");
    }

    private final String formatSize(long bytes) {
        if (bytes >= 1048576) {
            return String.format("%.2fMB", Arrays.copyOf(new Object[]{Double.valueOf((bytes / 1024.0d) / 1024.0d)}, 1));
        }
        return (bytes / 1024) + "KB";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String handle$lambda$0(IOException iOException) {
        return m0.f.c("dump output closed (EPIPE / client disconnected): ", iOException.getMessage());
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0145, code lost:
    
        if (r1.equals(com.stepos.stepclaw.SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014c, code lost:
    
        if (r1.equals("status") == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0154, code lost:
    
        r7 = r2.isActiveEmbeddingProviderAvailable();
        r9 = r2.getRebuildInFlight();
        r8.println("=== MemoryEngine EmbedModel Status ===");
        r8.println("active=".concat(r3));
        r8.println("available=" + r7);
        r8.println("rebuilding=" + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x018c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dumpEmbedModel$step_memory_release(java.io.PrintWriter r8, java.lang.String[] r9) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryDumpCommandHandler.dumpEmbedModel$step_memory_release(java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public String getCommandName() {
        return this.commandName;
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public String getDescription() {
        return this.description;
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public String getUsage() {
        return this.usage;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00ec A[Catch: IOException -> 0x00fe, TryCatch #0 {IOException -> 0x00fe, blocks: (B:5:0x0011, B:8:0x001a, B:9:0x001e, B:68:0x00ec, B:70:0x00fa, B:11:0x0023, B:14:0x002d, B:15:0x0032, B:18:0x003c, B:19:0x0041, B:22:0x004b, B:23:0x0050, B:26:0x005a, B:27:0x005f, B:30:0x0069, B:31:0x006e, B:33:0x0074, B:34:0x0079, B:37:0x0083, B:38:0x0088, B:41:0x0091, B:42:0x0096, B:45:0x009f, B:46:0x00a3, B:49:0x00ac, B:50:0x00b0, B:53:0x00b9, B:54:0x00bd, B:57:0x00c6, B:58:0x00ca, B:61:0x00d3, B:62:0x00d7, B:65:0x00e0, B:66:0x00e4, B:69:0x00f7), top: B:75:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.stepclaw.service.command.CommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void handle(android.content.Context r4, java.io.PrintWriter r5, java.lang.String[] r6) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryDumpCommandHandler.handle(android.content.Context, java.io.PrintWriter, java.lang.String[]):void");
    }

    @Override // com.stepos.stepclaw.service.command.CommandHandler
    public /* bridge */ void printHelp(PrintWriter printWriter) {
        super.printHelp(printWriter);
    }
}
