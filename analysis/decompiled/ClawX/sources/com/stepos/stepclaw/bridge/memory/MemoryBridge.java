package com.stepos.stepclaw.bridge.memory;

import a6.f0;
import android.app.Application;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.framework.ImplementedBy;
import com.stepos.stepclaw.base.net.StepOSHeadersProvider;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.memory.embedding.EmbeddingClient;
import com.stepos.stepclaw.provider.contract.OperationResult;
import com.stepos.stepclaw.service.command.CommandHandler;
import f5.c;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@ImplementedBy(implClass = "com.stepos.stepclaw.memory.MemoryBridgeImpl")
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJO\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ;\u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u0007H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H&¢\u0006\u0004\b \u0010!J\u0011\u0010\"\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H¦@¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0001H&¢\u0006\u0004\b*\u0010+J#\u0010/\u001a\u00020\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-0,H&¢\u0006\u0004\b/\u00100J3\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001703H&¢\u0006\u0004\b5\u00106J!\u00109\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b9\u0010:JA\u0010?\u001a\u00020\u00072\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b?\u0010@J)\u0010A\u001a\u00020\u00042\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H&¢\u0006\u0004\bC\u0010!J>\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010D2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H¦@¢\u0006\u0004\bG\u0010HJL\u0010K\u001a\u00020\u00072\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010D2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\b\b\u0002\u0010I\u001a\u00020\u00022\b\b\u0002\u0010J\u001a\u00020\u0002H¦@¢\u0006\u0004\bK\u0010LJ*\u0010N\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0007H¦@¢\u0006\u0004\bN\u0010OJ\u000f\u0010Q\u001a\u00020PH&¢\u0006\u0004\bQ\u0010R¨\u0006SÀ\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/bridge/memory/MemoryBridge;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "debug", "Lb5/a0;", "setDebug", "(Z)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "newUrl", "updateBaseUrl", "(Ljava/lang/String;)V", "Landroid/app/Application;", "application", ConfigIpcContract.KEY_BASE_URL, "La6/f0;", "scope", "baseDir", "enableVectorFeature", "defaultEmbeddingProviderId", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "headersProvider", "init", "(Landroid/app/Application;Ljava/lang/String;La6/f0;Ljava/lang/String;ZLjava/lang/String;Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", "backfillEmbeddings", "(Ljava/util/List;)V", ConfigIpcContract.KEY_API_KEY, "apiKeys", ConfigIpcContract.KEY_MODEL, "updateEmbeddingConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "listEmbeddingProviderIds", "()Ljava/util/List;", "activeEmbeddingProviderId", "()Ljava/lang/String;", "isActiveEmbeddingProviderAvailable", "()Z", "providerId", "switchEmbeddingProvider", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "config", "updateSearchConfig", "(Ljava/lang/Object;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "thresholds", "updateSearchScoreThresholds", "(Ljava/util/Map;)V", OperationResult.EXTRA_MESSAGE, "sessionKey", "Lkotlin/Function0;", "historyProvider", "beforeSendMessage", "(Ljava/lang/String;Ljava/lang/String;Lp5/a;)V", "toolName", "argsJson", "beforeToolCall", "(Ljava/lang/String;Ljava/lang/String;)V", "messages", "prompt", "sessionId", "traceId", "autoRecall", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "autoCapture", "(Ljava/util/List;Ljava/lang/String;)V", "getStepMemCategories", "Ljava/util/Date;", "fromDate", "toDate", "readStepMem", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "groupByCategory", "flattenContent", "readStepMemAsString", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/List;ZZLf5/c;)Ljava/lang/Object;", "episodicFileName", "runOfflineEvolutionEpisodicPipeline", "(Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/service/command/CommandHandler;", "getMemoryDumpCommandHandler", "()Lcom/stepos/stepclaw/service/command/CommandHandler;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MemoryBridge {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void autoCapture$default(MemoryBridge memoryBridge, List list, String str, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoCapture");
        }
        if ((i8 & 2) != 0) {
            str = null;
        }
        memoryBridge.autoCapture(list, str);
    }

    static /* synthetic */ String autoRecall$default(MemoryBridge memoryBridge, List list, String str, String str2, String str3, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: autoRecall");
        }
        if ((i8 & 2) != 0) {
            str = null;
        }
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        if ((i8 & 8) != 0) {
            str3 = null;
        }
        return memoryBridge.autoRecall(list, str, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void backfillEmbeddings$default(MemoryBridge memoryBridge, List list, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: backfillEmbeddings");
        }
        if ((i8 & 1) != 0) {
            list = s.f1092a;
        }
        memoryBridge.backfillEmbeddings(list);
    }

    static /* synthetic */ void init$default(MemoryBridge memoryBridge, Application application, String str, f0 f0Var, String str2, boolean z, String str3, StepOSHeadersProvider stepOSHeadersProvider, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i8 & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i8 & 32) != 0) {
            str3 = "local-stepinfer-emb";
        }
        memoryBridge.init(application, str, f0Var, str2, z2, str3, (i8 & 64) != 0 ? null : stepOSHeadersProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object readStepMem$default(MemoryBridge memoryBridge, Date date, Date date2, List list, c cVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readStepMem");
        }
        if ((i8 & 1) != 0) {
            date = null;
        }
        if ((i8 & 2) != 0) {
            date2 = null;
        }
        if ((i8 & 4) != 0) {
            list = s.f1092a;
        }
        return memoryBridge.readStepMem(date, date2, list, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object readStepMemAsString$default(MemoryBridge memoryBridge, Date date, Date date2, List list, boolean z, boolean z2, c cVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readStepMemAsString");
        }
        if ((i8 & 1) != 0) {
            date = null;
        }
        if ((i8 & 2) != 0) {
            date2 = null;
        }
        if ((i8 & 4) != 0) {
            list = s.f1092a;
        }
        if ((i8 & 8) != 0) {
            z = false;
        }
        if ((i8 & 16) != 0) {
            z2 = true;
        }
        return memoryBridge.readStepMemAsString(date, date2, list, z, z2, cVar);
    }

    static /* synthetic */ Object runOfflineEvolutionEpisodicPipeline$default(MemoryBridge memoryBridge, String str, String str2, c cVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runOfflineEvolutionEpisodicPipeline");
        }
        if ((i8 & 1) != 0) {
            str = null;
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        return memoryBridge.runOfflineEvolutionEpisodicPipeline(str, str2, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateEmbeddingConfig$default(MemoryBridge memoryBridge, String str, String str2, List list, String str3, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateEmbeddingConfig");
        }
        if ((i8 & 2) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if ((i8 & 4) != 0) {
            list = s.f1092a;
        }
        if ((i8 & 8) != 0) {
            str3 = EmbeddingClient.DEFAULT_MODEL;
        }
        memoryBridge.updateEmbeddingConfig(str, str2, list, str3);
    }

    String activeEmbeddingProviderId();

    void autoCapture(List<? extends Object> messages, String sessionId);

    String autoRecall(List<? extends Object> messages, String prompt, String sessionId, String traceId);

    void backfillEmbeddings(List<String> categories);

    void beforeSendMessage(String message, String sessionKey, a historyProvider);

    void beforeToolCall(String toolName, String argsJson);

    CommandHandler getMemoryDumpCommandHandler();

    List<String> getStepMemCategories();

    void init(Application application, String baseUrl, f0 scope, String baseDir, boolean enableVectorFeature, String defaultEmbeddingProviderId, StepOSHeadersProvider headersProvider);

    boolean isActiveEmbeddingProviderAvailable();

    List<String> listEmbeddingProviderIds();

    Object readStepMem(Date date, Date date2, List<String> list, c cVar);

    Object readStepMemAsString(Date date, Date date2, List<String> list, boolean z, boolean z2, c cVar);

    Object runOfflineEvolutionEpisodicPipeline(String str, String str2, c cVar);

    void setDebug(boolean debug);

    Object switchEmbeddingProvider(String str, c cVar);

    void updateBaseUrl(String newUrl);

    void updateEmbeddingConfig(String baseUrl, String apiKey, List<String> apiKeys, String model);

    void updateSearchConfig(Object config);

    void updateSearchScoreThresholds(Map<String, Float> thresholds);
}
