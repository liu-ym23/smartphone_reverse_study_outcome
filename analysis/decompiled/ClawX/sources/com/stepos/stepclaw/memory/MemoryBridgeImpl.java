package com.stepos.stepclaw.memory;

import a6.f0;
import android.app.Application;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.StepOSHeadersProvider;
import com.stepos.stepclaw.bridge.memory.MemoryBridge;
import com.stepos.stepclaw.bridge.memory.MemoryMessage;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.remote.MessageItem;
import com.stepos.stepclaw.memory.search.MemorySearchConfig;
import com.stepos.stepclaw.provider.contract.OperationResult;
import com.stepos.stepclaw.service.command.CommandHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import kotlinx.serialization.internal.CollectionDescriptorsKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JI\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\n2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J5\u0010$\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010#\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\rH\u0096@¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u00101J#\u00105\u001a\u00020\n2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020302H\u0016¢\u0006\u0004\b5\u00106J3\u0010;\u001a\u00020\n2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\r2\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d09H\u0016¢\u0006\u0004\b;\u0010<J!\u0010?\u001a\u00020\n2\u0006\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b?\u0010@J;\u0010E\u001a\u00020\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\b\u0010B\u001a\u0004\u0018\u00010\r2\b\u0010C\u001a\u0004\u0018\u00010\r2\b\u0010D\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bE\u0010FJ'\u0010G\u001a\u00020\n2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\b\u0010C\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bG\u0010HJ\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016¢\u0006\u0004\bI\u0010'J8\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010L\u001a\u0004\u0018\u00010J2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0096@¢\u0006\u0004\bM\u0010NJB\u0010Q\u001a\u00020\r2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010L\u001a\u0004\u0018\u00010J2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0096@¢\u0006\u0004\bQ\u0010RJ&\u0010T\u001a\u0004\u0018\u00010\u00042\b\u0010C\u001a\u0004\u0018\u00010\r2\b\u0010S\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\bT\u0010UJ\u000f\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Lcom/stepos/stepclaw/memory/MemoryBridgeImpl;", "Lcom/stepos/stepclaw/bridge/memory/MemoryBridge;", "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "toMessageItem", "(Ljava/lang/Object;)Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "debug", "Lb5/a0;", "setDebug", "(Z)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "newUrl", "updateBaseUrl", "(Ljava/lang/String;)V", "Landroid/app/Application;", "application", ConfigIpcContract.KEY_BASE_URL, "La6/f0;", "scope", "baseDir", "enableVectorFeature", "defaultEmbeddingProviderId", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "headersProvider", "init", "(Landroid/app/Application;Ljava/lang/String;La6/f0;Ljava/lang/String;ZLjava/lang/String;Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "categories", "backfillEmbeddings", "(Ljava/util/List;)V", ConfigIpcContract.KEY_API_KEY, "apiKeys", ConfigIpcContract.KEY_MODEL, "updateEmbeddingConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "listEmbeddingProviderIds", "()Ljava/util/List;", "activeEmbeddingProviderId", "()Ljava/lang/String;", "isActiveEmbeddingProviderAvailable", "()Z", "providerId", "switchEmbeddingProvider", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "config", "updateSearchConfig", "(Ljava/lang/Object;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "thresholds", "updateSearchScoreThresholds", "(Ljava/util/Map;)V", OperationResult.EXTRA_MESSAGE, "sessionKey", "Lkotlin/Function0;", "historyProvider", "beforeSendMessage", "(Ljava/lang/String;Ljava/lang/String;Lp5/a;)V", "toolName", "argsJson", "beforeToolCall", "(Ljava/lang/String;Ljava/lang/String;)V", "messages", "prompt", "sessionId", "traceId", "autoRecall", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "autoCapture", "(Ljava/util/List;Ljava/lang/String;)V", "getStepMemCategories", "Ljava/util/Date;", "fromDate", "toDate", "readStepMem", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "groupByCategory", "flattenContent", "readStepMemAsString", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/List;ZZLf5/c;)Ljava/lang/Object;", "episodicFileName", "runOfflineEvolutionEpisodicPipeline", "(Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/service/command/CommandHandler;", "getMemoryDumpCommandHandler", "()Lcom/stepos/stepclaw/service/command/CommandHandler;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@b.a
/* loaded from: classes.dex */
public final class MemoryBridgeImpl implements MemoryBridge {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/stepos/stepclaw/memory/MemoryBridgeImpl$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "create", "Lcom/stepos/stepclaw/bridge/memory/MemoryBridge;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final MemoryBridge create() {
            return new MemoryBridgeImpl(null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ MemoryBridgeImpl(kotlin.jvm.internal.i iVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List beforeSendMessage$lambda$0(p5.a aVar, MemoryBridgeImpl memoryBridgeImpl) {
        Iterable iterable = (Iterable) aVar.invoke();
        ArrayList arrayList = new ArrayList(c5.o.n0(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(memoryBridgeImpl.toMessageItem(it.next()));
        }
        return arrayList;
    }

    public static final MemoryBridge create() {
        return INSTANCE.create();
    }

    private final MessageItem toMessageItem(Object obj) {
        String strF;
        if (obj instanceof MessageItem) {
            return (MessageItem) obj;
        }
        if (obj instanceof MemoryMessage) {
            MemoryMessage memoryMessage = (MemoryMessage) obj;
            return new MessageItem(memoryMessage.getRole(), memoryMessage.getContent(), (String) null, 4, (kotlin.jvm.internal.i) null);
        }
        kotlin.jvm.internal.h hVarA = z.a(obj.getClass());
        Map map = kotlin.jvm.internal.h.f3673b;
        Class jClass = hVarA.f3674a;
        kotlin.jvm.internal.p.e(jClass, "jClass");
        String strF2 = null;
        if (!jClass.isAnonymousClass() && !jClass.isLocalClass()) {
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (strF = kotlin.jvm.internal.p.f(componentType.getName())) != null) {
                    strF2 = strF.concat("Array");
                }
                if (strF2 == null) {
                    strF2 = CollectionDescriptorsKt.ARRAY_NAME;
                }
            } else {
                strF2 = kotlin.jvm.internal.p.f(jClass.getName());
                if (strF2 == null) {
                    strF2 = jClass.getCanonicalName();
                }
            }
        }
        throw new IllegalArgumentException(m0.f.d("Unsupported memory message type: ", strF2, "; expected MessageItem or MemoryMessage"));
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public String activeEmbeddingProviderId() {
        return MemoryEngine.INSTANCE.activeEmbeddingProviderId();
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void autoCapture(List<? extends Object> messages, String sessionId) {
        kotlin.jvm.internal.p.e(messages, "messages");
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        ArrayList arrayList = new ArrayList(c5.o.n0(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(toMessageItem(it.next()));
        }
        memoryEngine.autoCapture(arrayList, sessionId);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public String autoRecall(List<? extends Object> messages, String prompt, String sessionId, String traceId) {
        kotlin.jvm.internal.p.e(messages, "messages");
        MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
        ArrayList arrayList = new ArrayList(c5.o.n0(messages, 10));
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            arrayList.add(toMessageItem(it.next()));
        }
        return memoryEngine.autoRecall(arrayList, prompt, sessionId, traceId);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void backfillEmbeddings(List<String> categories) {
        kotlin.jvm.internal.p.e(categories, "categories");
        MemoryEngine.INSTANCE.backfillEmbeddings(categories);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void beforeSendMessage(String message, String sessionKey, p5.a historyProvider) {
        kotlin.jvm.internal.p.e(message, "message");
        kotlin.jvm.internal.p.e(sessionKey, "sessionKey");
        kotlin.jvm.internal.p.e(historyProvider, "historyProvider");
        MemoryEngine.INSTANCE.beforeSendMessage(message, sessionKey, new t(historyProvider, 1, this));
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void beforeToolCall(String toolName, String argsJson) {
        kotlin.jvm.internal.p.e(toolName, "toolName");
        MemoryEngine.INSTANCE.beforeToolCall(toolName, argsJson);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public CommandHandler getMemoryDumpCommandHandler() {
        return new MemoryDumpCommandHandler();
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public List<String> getStepMemCategories() {
        return MemoryEngine.INSTANCE.getStepMemCategories();
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void init(Application application, String baseUrl, f0 scope, String baseDir, boolean enableVectorFeature, String defaultEmbeddingProviderId, StepOSHeadersProvider headersProvider) throws IOException {
        kotlin.jvm.internal.p.e(application, "application");
        kotlin.jvm.internal.p.e(baseUrl, "baseUrl");
        kotlin.jvm.internal.p.e(scope, "scope");
        kotlin.jvm.internal.p.e(baseDir, "baseDir");
        kotlin.jvm.internal.p.e(defaultEmbeddingProviderId, "defaultEmbeddingProviderId");
        MemoryEngine.INSTANCE.init(application, new LightMemClient(baseUrl, headersProvider, null, 4, null), scope, baseDir, enableVectorFeature, defaultEmbeddingProviderId, headersProvider);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public boolean isActiveEmbeddingProviderAvailable() {
        return MemoryEngine.INSTANCE.isActiveEmbeddingProviderAvailable();
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public List<String> listEmbeddingProviderIds() {
        return MemoryEngine.INSTANCE.listEmbeddingProviderIds();
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public Object readStepMem(Date date, Date date2, List<String> list, f5.c cVar) {
        return MemoryEngine.INSTANCE.readStepMem(date, date2, list, cVar);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public Object readStepMemAsString(Date date, Date date2, List<String> list, boolean z, boolean z2, f5.c cVar) {
        return MemoryEngine.INSTANCE.readStepMemAsString(date, date2, list, z, z2, cVar);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public Object runOfflineEvolutionEpisodicPipeline(String str, String str2, f5.c cVar) {
        return MemoryEngine.INSTANCE.runOfflineEvolutionEpisodicPipeline(str, str2, cVar);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void setDebug(boolean debug) {
        MemoryEngine.INSTANCE.setDebug(debug);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public Object switchEmbeddingProvider(String str, f5.c cVar) {
        return MemoryEngine.INSTANCE.switchEmbeddingProvider(str, cVar);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void updateBaseUrl(String newUrl) {
        kotlin.jvm.internal.p.e(newUrl, "newUrl");
        MemoryEngine.INSTANCE.updateBaseUrl(newUrl);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void updateEmbeddingConfig(String baseUrl, String apiKey, List<String> apiKeys, String model) {
        kotlin.jvm.internal.p.e(baseUrl, "baseUrl");
        kotlin.jvm.internal.p.e(apiKey, "apiKey");
        kotlin.jvm.internal.p.e(apiKeys, "apiKeys");
        kotlin.jvm.internal.p.e(model, "model");
        MemoryEngine.INSTANCE.updateEmbeddingConfig(baseUrl, apiKey, apiKeys, model);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void updateSearchConfig(Object config) {
        kotlin.jvm.internal.p.e(config, "config");
        MemoryEngine.INSTANCE.updateSearchConfig((MemorySearchConfig) config);
    }

    @Override // com.stepos.stepclaw.bridge.memory.MemoryBridge
    public void updateSearchScoreThresholds(Map<String, Float> thresholds) {
        kotlin.jvm.internal.p.e(thresholds, "thresholds");
        MemoryEngine.INSTANCE.updateSearchScoreThresholds(thresholds);
    }

    private MemoryBridgeImpl() {
    }
}
