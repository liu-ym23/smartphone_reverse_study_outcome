package io.modelcontextprotocol.server;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class McpServerFeatures {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Async extends androidx.activity.b {
        private final Map<McpSchema.CompleteReference, AsyncCompletionSpecification> completions;
        private final String instructions;
        private final Map<String, AsyncPromptSpecification> prompts;
        private final Map<String, AsyncResourceTemplateSpecification> resourceTemplates;
        private final Map<String, AsyncResourceSpecification> resources;
        private final List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> rootsChangeConsumers;
        private final McpSchema.ServerCapabilities serverCapabilities;
        private final McpSchema.Implementation serverInfo;
        private final List<AsyncToolSpecification> tools;

        public Async(McpSchema.Implementation implementation, McpSchema.ServerCapabilities serverCapabilities, List<AsyncToolSpecification> list, Map<String, AsyncResourceSpecification> map, Map<String, AsyncResourceTemplateSpecification> map2, Map<String, AsyncPromptSpecification> map3, Map<McpSchema.CompleteReference, AsyncCompletionSpecification> map4, List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> list2, String str) {
            McpSchema.ServerCapabilities.ResourceCapabilities resourceCapabilities;
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            if (serverCapabilities == null) {
                McpSchema.ServerCapabilities.LoggingCapabilities loggingCapabilities = new McpSchema.ServerCapabilities.LoggingCapabilities();
                McpSchema.ServerCapabilities.PromptCapabilities promptCapabilities = !Utils.isEmpty(map3) ? new McpSchema.ServerCapabilities.PromptCapabilities(Boolean.FALSE) : null;
                if (Utils.isEmpty(map)) {
                    resourceCapabilities = null;
                } else {
                    Boolean bool = Boolean.FALSE;
                    resourceCapabilities = new McpSchema.ServerCapabilities.ResourceCapabilities(bool, bool);
                }
                serverCapabilities = new McpSchema.ServerCapabilities(null, null, loggingCapabilities, promptCapabilities, resourceCapabilities, Utils.isEmpty(list) ? null : new McpSchema.ServerCapabilities.ToolCapabilities(Boolean.FALSE));
            }
            this.serverCapabilities = serverCapabilities;
            this.tools = list == null ? Collections.EMPTY_LIST : list;
            this.resources = map == null ? Collections.EMPTY_MAP : map;
            this.resourceTemplates = map2 == null ? Collections.EMPTY_MAP : map2;
            this.prompts = map3 == null ? Collections.EMPTY_MAP : map3;
            this.completions = map4 != null ? map4 : Collections.EMPTY_MAP;
            this.rootsChangeConsumers = list2 != null ? list2 : Collections.EMPTY_LIST;
            this.instructions = str;
        }

        public static Async fromSync(Sync sync, boolean z10) {
            ArrayList arrayList = new ArrayList();
            Iterator<SyncToolSpecification> it = sync.tools().iterator();
            while (it.hasNext()) {
                arrayList.add(AsyncToolSpecification.fromSync(it.next(), z10));
            }
            HashMap map = new HashMap();
            Map<String, SyncResourceSpecification> mapResources = sync.resources();
            v vVar = new v(0);
            vVar.f6327f = map;
            vVar.f6328g = z10;
            VarHandle.storeStoreFence();
            mapResources.forEach(vVar);
            HashMap map2 = new HashMap();
            Map<String, SyncResourceTemplateSpecification> mapResourceTemplates = sync.resourceTemplates();
            v vVar2 = new v(1);
            vVar2.f6327f = map2;
            vVar2.f6328g = z10;
            VarHandle.storeStoreFence();
            mapResourceTemplates.forEach(vVar2);
            HashMap map3 = new HashMap();
            Map<String, SyncPromptSpecification> mapPrompts = sync.prompts();
            int i = 2;
            v vVar3 = new v(i);
            vVar3.f6327f = map3;
            vVar3.f6328g = z10;
            VarHandle.storeStoreFence();
            mapPrompts.forEach(vVar3);
            HashMap map4 = new HashMap();
            Map<McpSchema.CompleteReference, SyncCompletionSpecification> mapCompletions = sync.completions();
            v vVar4 = new v(3);
            vVar4.f6327f = map4;
            vVar4.f6328g = z10;
            VarHandle.storeStoreFence();
            mapCompletions.forEach(vVar4);
            ArrayList arrayList2 = new ArrayList();
            for (BiConsumer<McpSyncServerExchange, List<McpSchema.Root>> biConsumer : sync.rootsChangeConsumers()) {
                y yVar = new y(i);
                yVar.f6337f = biConsumer;
                VarHandle.storeStoreFence();
                arrayList2.add(yVar);
            }
            return new Async(sync.serverInfo(), sync.serverCapabilities(), arrayList, map, map2, map3, map4, arrayList2, sync.instructions());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fromSync$0(Map map, boolean z10, String str, SyncResourceSpecification syncResourceSpecification) {
            map.put(str, AsyncResourceSpecification.fromSync(syncResourceSpecification, z10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fromSync$1(Map map, boolean z10, String str, SyncResourceTemplateSpecification syncResourceTemplateSpecification) {
            map.put(str, AsyncResourceTemplateSpecification.fromSync(syncResourceTemplateSpecification, z10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fromSync$2(Map map, boolean z10, String str, SyncPromptSpecification syncPromptSpecification) {
            map.put(str, AsyncPromptSpecification.fromSync(syncPromptSpecification, z10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fromSync$3(Map map, boolean z10, McpSchema.CompleteReference completeReference, SyncCompletionSpecification syncCompletionSpecification) {
            map.put(completeReference, AsyncCompletionSpecification.fromSync(syncCompletionSpecification, z10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$fromSync$4(BiConsumer biConsumer, McpAsyncServerExchange mcpAsyncServerExchange, List list) {
            biConsumer.accept(new McpSyncServerExchange(mcpAsyncServerExchange), list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$5(BiConsumer biConsumer, McpAsyncServerExchange mcpAsyncServerExchange, List list) {
            u uVar = new u();
            uVar.f6323c = biConsumer;
            uVar.f6324f = mcpAsyncServerExchange;
            uVar.f6325g = list;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(uVar).subscribeOn(Schedulers.boundedElastic());
        }

        public Map<McpSchema.CompleteReference, AsyncCompletionSpecification> completions() {
            return this.completions;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Async)) {
                return false;
            }
            Async async = (Async) obj;
            return Objects.equals(this.serverInfo, async.serverInfo) && Objects.equals(this.serverCapabilities, async.serverCapabilities) && Objects.equals(this.tools, async.tools) && Objects.equals(this.resources, async.resources) && Objects.equals(this.resourceTemplates, async.resourceTemplates) && Objects.equals(this.prompts, async.prompts) && Objects.equals(this.completions, async.completions) && Objects.equals(this.rootsChangeConsumers, async.rootsChangeConsumers) && Objects.equals(this.instructions, async.instructions);
        }

        public final int hashCode() {
            McpSchema.Implementation implementation = this.serverInfo;
            McpSchema.ServerCapabilities serverCapabilities = this.serverCapabilities;
            List<AsyncToolSpecification> list = this.tools;
            Map<String, AsyncResourceSpecification> map = this.resources;
            Map<String, AsyncResourceTemplateSpecification> map2 = this.resourceTemplates;
            Map<String, AsyncPromptSpecification> map3 = this.prompts;
            Map<McpSchema.CompleteReference, AsyncCompletionSpecification> map4 = this.completions;
            List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> list2 = this.rootsChangeConsumers;
            String str = this.instructions;
            return Objects.hashCode(str) + androidx.activity.b.x(list2, androidx.activity.b.f(map4, androidx.activity.b.f(map3, androidx.activity.b.f(map2, androidx.activity.b.f(map, androidx.activity.b.x(list, (Objects.hashCode(serverCapabilities) + (Objects.hashCode(implementation) * 31)) * 31, 31), 31), 31), 31), 31), 31);
        }

        public String instructions() {
            return this.instructions;
        }

        public Map<String, AsyncPromptSpecification> prompts() {
            return this.prompts;
        }

        public Map<String, AsyncResourceTemplateSpecification> resourceTemplates() {
            return this.resourceTemplates;
        }

        public Map<String, AsyncResourceSpecification> resources() {
            return this.resources;
        }

        public List<BiFunction<McpAsyncServerExchange, List<McpSchema.Root>, Mono<Void>>> rootsChangeConsumers() {
            return this.rootsChangeConsumers;
        }

        public McpSchema.ServerCapabilities serverCapabilities() {
            return this.serverCapabilities;
        }

        public McpSchema.Implementation serverInfo() {
            return this.serverInfo;
        }

        public final String toString() {
            Object[] objArr = {this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.rootsChangeConsumers, this.instructions};
            String[] strArrSplit = "serverInfo;serverCapabilities;tools;resources;resourceTemplates;prompts;completions;rootsChangeConsumers;instructions".length() == 0 ? new String[0] : "serverInfo;serverCapabilities;tools;resources;resourceTemplates;prompts;completions;rootsChangeConsumers;instructions".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Async.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public List<AsyncToolSpecification> tools() {
            return this.tools;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class AsyncCompletionSpecification extends androidx.activity.b {
        private final BiFunction<McpAsyncServerExchange, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> completionHandler;
        private final McpSchema.CompleteReference referenceKey;

        public AsyncCompletionSpecification(McpSchema.CompleteReference completeReference, BiFunction<McpAsyncServerExchange, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> biFunction) {
            this.referenceKey = completeReference;
            this.completionHandler = biFunction;
        }

        public static AsyncCompletionSpecification fromSync(SyncCompletionSpecification syncCompletionSpecification, boolean z10) {
            if (syncCompletionSpecification == null) {
                return null;
            }
            McpSchema.CompleteReference completeReferenceReferenceKey = syncCompletionSpecification.referenceKey();
            w wVar = new w(0);
            wVar.f6331g = syncCompletionSpecification;
            wVar.f6330f = z10;
            VarHandle.storeStoreFence();
            return new AsyncCompletionSpecification(completeReferenceReferenceKey, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CompleteResult lambda$fromSync$0(SyncCompletionSpecification syncCompletionSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CompleteRequest completeRequest) {
            return syncCompletionSpecification.completionHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), completeRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncCompletionSpecification syncCompletionSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CompleteRequest completeRequest) {
            x xVar = new x(0);
            xVar.f6334g = syncCompletionSpecification;
            xVar.f6333f = mcpAsyncServerExchange;
            xVar.f6335h = completeRequest;
            VarHandle.storeStoreFence();
            Mono monoFromCallable = Mono.fromCallable(xVar);
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        public BiFunction<McpAsyncServerExchange, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> completionHandler() {
            return this.completionHandler;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncCompletionSpecification)) {
                return false;
            }
            AsyncCompletionSpecification asyncCompletionSpecification = (AsyncCompletionSpecification) obj;
            return Objects.equals(this.referenceKey, asyncCompletionSpecification.referenceKey) && Objects.equals(this.completionHandler, asyncCompletionSpecification.completionHandler);
        }

        public final int hashCode() {
            McpSchema.CompleteReference completeReference = this.referenceKey;
            BiFunction<McpAsyncServerExchange, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> biFunction = this.completionHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(completeReference) * 31);
        }

        public McpSchema.CompleteReference referenceKey() {
            return this.referenceKey;
        }

        public final String toString() {
            Object[] objArr = {this.referenceKey, this.completionHandler};
            String[] strArrSplit = "referenceKey;completionHandler".length() == 0 ? new String[0] : "referenceKey;completionHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AsyncCompletionSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class AsyncPromptSpecification extends androidx.activity.b {
        private final McpSchema.Prompt prompt;
        private final BiFunction<McpAsyncServerExchange, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> promptHandler;

        public AsyncPromptSpecification(McpSchema.Prompt prompt, BiFunction<McpAsyncServerExchange, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> biFunction) {
            this.prompt = prompt;
            this.promptHandler = biFunction;
        }

        public static AsyncPromptSpecification fromSync(SyncPromptSpecification syncPromptSpecification, boolean z10) {
            if (syncPromptSpecification == null) {
                return null;
            }
            McpSchema.Prompt prompt = syncPromptSpecification.prompt();
            w wVar = new w(1);
            wVar.f6331g = syncPromptSpecification;
            wVar.f6330f = z10;
            VarHandle.storeStoreFence();
            return new AsyncPromptSpecification(prompt, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.GetPromptResult lambda$fromSync$0(SyncPromptSpecification syncPromptSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.GetPromptRequest getPromptRequest) {
            return syncPromptSpecification.promptHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), getPromptRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncPromptSpecification syncPromptSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.GetPromptRequest getPromptRequest) {
            x xVar = new x(1);
            xVar.f6334g = syncPromptSpecification;
            xVar.f6333f = mcpAsyncServerExchange;
            xVar.f6335h = getPromptRequest;
            VarHandle.storeStoreFence();
            Mono monoFromCallable = Mono.fromCallable(xVar);
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncPromptSpecification)) {
                return false;
            }
            AsyncPromptSpecification asyncPromptSpecification = (AsyncPromptSpecification) obj;
            return Objects.equals(this.prompt, asyncPromptSpecification.prompt) && Objects.equals(this.promptHandler, asyncPromptSpecification.promptHandler);
        }

        public final int hashCode() {
            McpSchema.Prompt prompt = this.prompt;
            BiFunction<McpAsyncServerExchange, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> biFunction = this.promptHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(prompt) * 31);
        }

        public McpSchema.Prompt prompt() {
            return this.prompt;
        }

        public BiFunction<McpAsyncServerExchange, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> promptHandler() {
            return this.promptHandler;
        }

        public final String toString() {
            Object[] objArr = {this.prompt, this.promptHandler};
            String[] strArrSplit = "prompt;promptHandler".length() == 0 ? new String[0] : "prompt;promptHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AsyncPromptSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class AsyncResourceSpecification extends androidx.activity.b {
        private final BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler;
        private final McpSchema.Resource resource;

        public AsyncResourceSpecification(McpSchema.Resource resource, BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> biFunction) {
            this.resource = resource;
            this.readHandler = biFunction;
        }

        public static AsyncResourceSpecification fromSync(SyncResourceSpecification syncResourceSpecification, boolean z10) {
            if (syncResourceSpecification == null) {
                return null;
            }
            McpSchema.Resource resource = syncResourceSpecification.resource();
            w wVar = new w(2);
            wVar.f6331g = syncResourceSpecification;
            wVar.f6330f = z10;
            VarHandle.storeStoreFence();
            return new AsyncResourceSpecification(resource, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.ReadResourceResult lambda$fromSync$0(SyncResourceSpecification syncResourceSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
            return syncResourceSpecification.readHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), readResourceRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncResourceSpecification syncResourceSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
            x xVar = new x(2);
            xVar.f6334g = syncResourceSpecification;
            xVar.f6333f = mcpAsyncServerExchange;
            xVar.f6335h = readResourceRequest;
            VarHandle.storeStoreFence();
            Mono monoFromCallable = Mono.fromCallable(xVar);
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncResourceSpecification)) {
                return false;
            }
            AsyncResourceSpecification asyncResourceSpecification = (AsyncResourceSpecification) obj;
            return Objects.equals(this.resource, asyncResourceSpecification.resource) && Objects.equals(this.readHandler, asyncResourceSpecification.readHandler);
        }

        public final int hashCode() {
            McpSchema.Resource resource = this.resource;
            BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> biFunction = this.readHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(resource) * 31);
        }

        public BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler() {
            return this.readHandler;
        }

        public McpSchema.Resource resource() {
            return this.resource;
        }

        public final String toString() {
            Object[] objArr = {this.resource, this.readHandler};
            String[] strArrSplit = "resource;readHandler".length() == 0 ? new String[0] : "resource;readHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AsyncResourceSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class AsyncResourceTemplateSpecification extends androidx.activity.b {
        private final BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler;
        private final McpSchema.ResourceTemplate resourceTemplate;

        public AsyncResourceTemplateSpecification(McpSchema.ResourceTemplate resourceTemplate, BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> biFunction) {
            this.resourceTemplate = resourceTemplate;
            this.readHandler = biFunction;
        }

        public static AsyncResourceTemplateSpecification fromSync(SyncResourceTemplateSpecification syncResourceTemplateSpecification, boolean z10) {
            if (syncResourceTemplateSpecification == null) {
                return null;
            }
            McpSchema.ResourceTemplate resourceTemplate = syncResourceTemplateSpecification.resourceTemplate();
            w wVar = new w(3);
            wVar.f6331g = syncResourceTemplateSpecification;
            wVar.f6330f = z10;
            VarHandle.storeStoreFence();
            return new AsyncResourceTemplateSpecification(resourceTemplate, wVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.ReadResourceResult lambda$fromSync$0(SyncResourceTemplateSpecification syncResourceTemplateSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
            return syncResourceTemplateSpecification.readHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), readResourceRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncResourceTemplateSpecification syncResourceTemplateSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
            x xVar = new x(3);
            xVar.f6334g = syncResourceTemplateSpecification;
            xVar.f6333f = mcpAsyncServerExchange;
            xVar.f6335h = readResourceRequest;
            VarHandle.storeStoreFence();
            Mono monoFromCallable = Mono.fromCallable(xVar);
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncResourceTemplateSpecification)) {
                return false;
            }
            AsyncResourceTemplateSpecification asyncResourceTemplateSpecification = (AsyncResourceTemplateSpecification) obj;
            return Objects.equals(this.resourceTemplate, asyncResourceTemplateSpecification.resourceTemplate) && Objects.equals(this.readHandler, asyncResourceTemplateSpecification.readHandler);
        }

        public final int hashCode() {
            McpSchema.ResourceTemplate resourceTemplate = this.resourceTemplate;
            BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> biFunction = this.readHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(resourceTemplate) * 31);
        }

        public BiFunction<McpAsyncServerExchange, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler() {
            return this.readHandler;
        }

        public McpSchema.ResourceTemplate resourceTemplate() {
            return this.resourceTemplate;
        }

        public final String toString() {
            Object[] objArr = {this.resourceTemplate, this.readHandler};
            String[] strArrSplit = "resourceTemplate;readHandler".length() == 0 ? new String[0] : "resourceTemplate;readHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AsyncResourceTemplateSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Sync extends androidx.activity.b {
        private final Map<McpSchema.CompleteReference, SyncCompletionSpecification> completions;
        private final String instructions;
        private final Map<String, SyncPromptSpecification> prompts;
        private final Map<String, SyncResourceTemplateSpecification> resourceTemplates;
        private final Map<String, SyncResourceSpecification> resources;
        private final List<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> rootsChangeConsumers;
        private final McpSchema.ServerCapabilities serverCapabilities;
        private final McpSchema.Implementation serverInfo;
        private final List<SyncToolSpecification> tools;

        public Sync(McpSchema.Implementation implementation, McpSchema.ServerCapabilities serverCapabilities, List<SyncToolSpecification> list, Map<String, SyncResourceSpecification> map, Map<String, SyncResourceTemplateSpecification> map2, Map<String, SyncPromptSpecification> map3, Map<McpSchema.CompleteReference, SyncCompletionSpecification> map4, List<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> list2, String str) {
            McpSchema.ServerCapabilities.ResourceCapabilities resourceCapabilities;
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            if (serverCapabilities == null) {
                McpSchema.ServerCapabilities.LoggingCapabilities loggingCapabilities = new McpSchema.ServerCapabilities.LoggingCapabilities();
                McpSchema.ServerCapabilities.PromptCapabilities promptCapabilities = !Utils.isEmpty(map3) ? new McpSchema.ServerCapabilities.PromptCapabilities(Boolean.FALSE) : null;
                if (Utils.isEmpty(map)) {
                    resourceCapabilities = null;
                } else {
                    Boolean bool = Boolean.FALSE;
                    resourceCapabilities = new McpSchema.ServerCapabilities.ResourceCapabilities(bool, bool);
                }
                serverCapabilities = new McpSchema.ServerCapabilities(null, null, loggingCapabilities, promptCapabilities, resourceCapabilities, Utils.isEmpty(list) ? null : new McpSchema.ServerCapabilities.ToolCapabilities(Boolean.FALSE));
            }
            this.serverCapabilities = serverCapabilities;
            this.tools = list == null ? new ArrayList<>() : list;
            this.resources = map == null ? new HashMap<>() : map;
            this.resourceTemplates = map2 == null ? Collections.EMPTY_MAP : map2;
            this.prompts = map3 == null ? new HashMap<>() : map3;
            this.completions = map4 != null ? map4 : new HashMap<>();
            this.rootsChangeConsumers = list2 != null ? list2 : new ArrayList<>();
            this.instructions = str;
        }

        public Map<McpSchema.CompleteReference, SyncCompletionSpecification> completions() {
            return this.completions;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Sync)) {
                return false;
            }
            Sync sync = (Sync) obj;
            return Objects.equals(this.serverInfo, sync.serverInfo) && Objects.equals(this.serverCapabilities, sync.serverCapabilities) && Objects.equals(this.tools, sync.tools) && Objects.equals(this.resources, sync.resources) && Objects.equals(this.resourceTemplates, sync.resourceTemplates) && Objects.equals(this.prompts, sync.prompts) && Objects.equals(this.completions, sync.completions) && Objects.equals(this.rootsChangeConsumers, sync.rootsChangeConsumers) && Objects.equals(this.instructions, sync.instructions);
        }

        public final int hashCode() {
            McpSchema.Implementation implementation = this.serverInfo;
            McpSchema.ServerCapabilities serverCapabilities = this.serverCapabilities;
            List<SyncToolSpecification> list = this.tools;
            Map<String, SyncResourceSpecification> map = this.resources;
            Map<String, SyncResourceTemplateSpecification> map2 = this.resourceTemplates;
            Map<String, SyncPromptSpecification> map3 = this.prompts;
            Map<McpSchema.CompleteReference, SyncCompletionSpecification> map4 = this.completions;
            List<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> list2 = this.rootsChangeConsumers;
            String str = this.instructions;
            return Objects.hashCode(str) + androidx.activity.b.x(list2, androidx.activity.b.f(map4, androidx.activity.b.f(map3, androidx.activity.b.f(map2, androidx.activity.b.f(map, androidx.activity.b.x(list, (Objects.hashCode(serverCapabilities) + (Objects.hashCode(implementation) * 31)) * 31, 31), 31), 31), 31), 31), 31);
        }

        public String instructions() {
            return this.instructions;
        }

        public Map<String, SyncPromptSpecification> prompts() {
            return this.prompts;
        }

        public Map<String, SyncResourceTemplateSpecification> resourceTemplates() {
            return this.resourceTemplates;
        }

        public Map<String, SyncResourceSpecification> resources() {
            return this.resources;
        }

        public List<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> rootsChangeConsumers() {
            return this.rootsChangeConsumers;
        }

        public McpSchema.ServerCapabilities serverCapabilities() {
            return this.serverCapabilities;
        }

        public McpSchema.Implementation serverInfo() {
            return this.serverInfo;
        }

        public final String toString() {
            Object[] objArr = {this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.rootsChangeConsumers, this.instructions};
            String[] strArrSplit = "serverInfo;serverCapabilities;tools;resources;resourceTemplates;prompts;completions;rootsChangeConsumers;instructions".length() == 0 ? new String[0] : "serverInfo;serverCapabilities;tools;resources;resourceTemplates;prompts;completions;rootsChangeConsumers;instructions".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, Sync.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public List<SyncToolSpecification> tools() {
            return this.tools;
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SyncCompletionSpecification extends androidx.activity.b {
        private final BiFunction<McpSyncServerExchange, McpSchema.CompleteRequest, McpSchema.CompleteResult> completionHandler;
        private final McpSchema.CompleteReference referenceKey;

        public SyncCompletionSpecification(McpSchema.CompleteReference completeReference, BiFunction<McpSyncServerExchange, McpSchema.CompleteRequest, McpSchema.CompleteResult> biFunction) {
            this.referenceKey = completeReference;
            this.completionHandler = biFunction;
        }

        public BiFunction<McpSyncServerExchange, McpSchema.CompleteRequest, McpSchema.CompleteResult> completionHandler() {
            return this.completionHandler;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SyncCompletionSpecification)) {
                return false;
            }
            SyncCompletionSpecification syncCompletionSpecification = (SyncCompletionSpecification) obj;
            return Objects.equals(this.referenceKey, syncCompletionSpecification.referenceKey) && Objects.equals(this.completionHandler, syncCompletionSpecification.completionHandler);
        }

        public final int hashCode() {
            McpSchema.CompleteReference completeReference = this.referenceKey;
            BiFunction<McpSyncServerExchange, McpSchema.CompleteRequest, McpSchema.CompleteResult> biFunction = this.completionHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(completeReference) * 31);
        }

        public McpSchema.CompleteReference referenceKey() {
            return this.referenceKey;
        }

        public final String toString() {
            Object[] objArr = {this.referenceKey, this.completionHandler};
            String[] strArrSplit = "referenceKey;completionHandler".length() == 0 ? new String[0] : "referenceKey;completionHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SyncCompletionSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SyncPromptSpecification extends androidx.activity.b {
        private final McpSchema.Prompt prompt;
        private final BiFunction<McpSyncServerExchange, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> promptHandler;

        public SyncPromptSpecification(McpSchema.Prompt prompt, BiFunction<McpSyncServerExchange, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> biFunction) {
            this.prompt = prompt;
            this.promptHandler = biFunction;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SyncPromptSpecification)) {
                return false;
            }
            SyncPromptSpecification syncPromptSpecification = (SyncPromptSpecification) obj;
            return Objects.equals(this.prompt, syncPromptSpecification.prompt) && Objects.equals(this.promptHandler, syncPromptSpecification.promptHandler);
        }

        public final int hashCode() {
            McpSchema.Prompt prompt = this.prompt;
            BiFunction<McpSyncServerExchange, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> biFunction = this.promptHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(prompt) * 31);
        }

        public McpSchema.Prompt prompt() {
            return this.prompt;
        }

        public BiFunction<McpSyncServerExchange, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> promptHandler() {
            return this.promptHandler;
        }

        public final String toString() {
            Object[] objArr = {this.prompt, this.promptHandler};
            String[] strArrSplit = "prompt;promptHandler".length() == 0 ? new String[0] : "prompt;promptHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SyncPromptSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SyncResourceSpecification extends androidx.activity.b {
        private final BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler;
        private final McpSchema.Resource resource;

        public SyncResourceSpecification(McpSchema.Resource resource, BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> biFunction) {
            this.resource = resource;
            this.readHandler = biFunction;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SyncResourceSpecification)) {
                return false;
            }
            SyncResourceSpecification syncResourceSpecification = (SyncResourceSpecification) obj;
            return Objects.equals(this.resource, syncResourceSpecification.resource) && Objects.equals(this.readHandler, syncResourceSpecification.readHandler);
        }

        public final int hashCode() {
            McpSchema.Resource resource = this.resource;
            BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> biFunction = this.readHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(resource) * 31);
        }

        public BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler() {
            return this.readHandler;
        }

        public McpSchema.Resource resource() {
            return this.resource;
        }

        public final String toString() {
            Object[] objArr = {this.resource, this.readHandler};
            String[] strArrSplit = "resource;readHandler".length() == 0 ? new String[0] : "resource;readHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SyncResourceSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SyncResourceTemplateSpecification extends androidx.activity.b {
        private final BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler;
        private final McpSchema.ResourceTemplate resourceTemplate;

        public SyncResourceTemplateSpecification(McpSchema.ResourceTemplate resourceTemplate, BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> biFunction) {
            this.resourceTemplate = resourceTemplate;
            this.readHandler = biFunction;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SyncResourceTemplateSpecification)) {
                return false;
            }
            SyncResourceTemplateSpecification syncResourceTemplateSpecification = (SyncResourceTemplateSpecification) obj;
            return Objects.equals(this.resourceTemplate, syncResourceTemplateSpecification.resourceTemplate) && Objects.equals(this.readHandler, syncResourceTemplateSpecification.readHandler);
        }

        public final int hashCode() {
            McpSchema.ResourceTemplate resourceTemplate = this.resourceTemplate;
            BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> biFunction = this.readHandler;
            return Objects.hashCode(biFunction) + (Objects.hashCode(resourceTemplate) * 31);
        }

        public BiFunction<McpSyncServerExchange, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler() {
            return this.readHandler;
        }

        public McpSchema.ResourceTemplate resourceTemplate() {
            return this.resourceTemplate;
        }

        public final String toString() {
            Object[] objArr = {this.resourceTemplate, this.readHandler};
            String[] strArrSplit = "resourceTemplate;readHandler".length() == 0 ? new String[0] : "resourceTemplate;readHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SyncResourceTemplateSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class AsyncToolSpecification extends androidx.activity.b {

        @Deprecated
        private final BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> call;
        private final BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler;
        private final McpSchema.Tool tool;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler;
            private McpSchema.Tool tool;

            public AsyncToolSpecification build() {
                Assert.notNull(this.tool, "Tool must not be null");
                Assert.notNull(this.callHandler, "Call handler function must not be null");
                return new AsyncToolSpecification(this.tool, null, this.callHandler);
            }

            public Builder callHandler(BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
                this.callHandler = biFunction;
                return this;
            }

            public Builder tool(McpSchema.Tool tool) {
                this.tool = tool;
                return this;
            }
        }

        @Deprecated
        public AsyncToolSpecification(McpSchema.Tool tool, BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> biFunction) {
            y yVar = new y(0);
            yVar.f6337f = biFunction;
            VarHandle.storeStoreFence();
            this(tool, biFunction, yVar);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static AsyncToolSpecification fromSync(SyncToolSpecification syncToolSpecification, boolean z10) {
            z zVar = null;
            if (syncToolSpecification == null) {
                return null;
            }
            if (syncToolSpecification.call() != null) {
                zVar = new z(0);
                zVar.f6339f = syncToolSpecification;
                zVar.f6340g = z10;
                VarHandle.storeStoreFence();
            }
            z zVar2 = new z(1);
            zVar2.f6339f = syncToolSpecification;
            zVar2.f6340g = z10;
            VarHandle.storeStoreFence();
            return new AsyncToolSpecification(syncToolSpecification.tool(), zVar, zVar2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CallToolResult lambda$fromSync$1(SyncToolSpecification syncToolSpecification, McpAsyncServerExchange mcpAsyncServerExchange, Map map) {
            return syncToolSpecification.call().apply(new McpSyncServerExchange(mcpAsyncServerExchange), map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$2(SyncToolSpecification syncToolSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, Map map) {
            x xVar = new x(4);
            xVar.f6334g = syncToolSpecification;
            xVar.f6333f = mcpAsyncServerExchange;
            xVar.f6335h = map;
            VarHandle.storeStoreFence();
            Mono monoFromCallable = Mono.fromCallable(xVar);
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CallToolResult lambda$fromSync$3(SyncToolSpecification syncToolSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
            return syncToolSpecification.callHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), callToolRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$4(SyncToolSpecification syncToolSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
            x xVar = new x(5);
            xVar.f6334g = syncToolSpecification;
            xVar.f6333f = mcpAsyncServerExchange;
            xVar.f6335h = callToolRequest;
            VarHandle.storeStoreFence();
            Mono monoFromCallable = Mono.fromCallable(xVar);
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$new$0(BiFunction biFunction, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
            return (Mono) biFunction.apply(mcpAsyncServerExchange, callToolRequest.arguments());
        }

        @Deprecated
        public BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> call() {
            return this.call;
        }

        public BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler() {
            return this.callHandler;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncToolSpecification)) {
                return false;
            }
            AsyncToolSpecification asyncToolSpecification = (AsyncToolSpecification) obj;
            return Objects.equals(this.tool, asyncToolSpecification.tool) && Objects.equals(this.call, asyncToolSpecification.call) && Objects.equals(this.callHandler, asyncToolSpecification.callHandler);
        }

        public final int hashCode() {
            McpSchema.Tool tool = this.tool;
            BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> biFunction = this.call;
            BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction2 = this.callHandler;
            return Objects.hashCode(biFunction2) + ((Objects.hashCode(biFunction) + (Objects.hashCode(tool) * 31)) * 31);
        }

        public final String toString() {
            Object[] objArr = {this.tool, this.call, this.callHandler};
            String[] strArrSplit = "tool;call;callHandler".length() == 0 ? new String[0] : "tool;call;callHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, AsyncToolSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public McpSchema.Tool tool() {
            return this.tool;
        }

        public AsyncToolSpecification(McpSchema.Tool tool, @Deprecated BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> biFunction, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction2) {
            this.tool = tool;
            this.call = biFunction;
            this.callHandler = biFunction2;
        }

        public static AsyncToolSpecification fromSync(SyncToolSpecification syncToolSpecification) {
            return fromSync(syncToolSpecification, false);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class SyncToolSpecification extends androidx.activity.b {

        @Deprecated
        private final BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> call;
        private final BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler;
        private final McpSchema.Tool tool;

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class Builder {
            private BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler;
            private McpSchema.Tool tool;

            public SyncToolSpecification build() {
                Assert.notNull(this.tool, "Tool must not be null");
                Assert.notNull(this.callHandler, "CallTool function must not be null");
                return new SyncToolSpecification(this.tool, null, this.callHandler);
            }

            public Builder callHandler(BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction) {
                this.callHandler = biFunction;
                return this;
            }

            public Builder tool(McpSchema.Tool tool) {
                this.tool = tool;
                return this;
            }
        }

        @Deprecated
        public SyncToolSpecification(McpSchema.Tool tool, BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> biFunction) {
            y yVar = new y(1);
            yVar.f6337f = biFunction;
            VarHandle.storeStoreFence();
            this(tool, biFunction, yVar);
        }

        public static Builder builder() {
            return new Builder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CallToolResult lambda$new$0(BiFunction biFunction, McpSyncServerExchange mcpSyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
            return (McpSchema.CallToolResult) biFunction.apply(mcpSyncServerExchange, callToolRequest.arguments());
        }

        @Deprecated
        public BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> call() {
            return this.call;
        }

        public BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler() {
            return this.callHandler;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof SyncToolSpecification)) {
                return false;
            }
            SyncToolSpecification syncToolSpecification = (SyncToolSpecification) obj;
            return Objects.equals(this.tool, syncToolSpecification.tool) && Objects.equals(this.call, syncToolSpecification.call) && Objects.equals(this.callHandler, syncToolSpecification.callHandler);
        }

        public final int hashCode() {
            McpSchema.Tool tool = this.tool;
            BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> biFunction = this.call;
            BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction2 = this.callHandler;
            return Objects.hashCode(biFunction2) + ((Objects.hashCode(biFunction) + (Objects.hashCode(tool) * 31)) * 31);
        }

        public final String toString() {
            Object[] objArr = {this.tool, this.call, this.callHandler};
            String[] strArrSplit = "tool;call;callHandler".length() == 0 ? new String[0] : "tool;call;callHandler".split(";");
            StringBuilder sb2 = new StringBuilder();
            androidx.activity.b.t(sb2, SyncToolSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb2.append(strArrSplit[i]);
                sb2.append("=");
                sb2.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("]");
            return sb2.toString();
        }

        public McpSchema.Tool tool() {
            return this.tool;
        }

        public SyncToolSpecification(McpSchema.Tool tool, @Deprecated BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> biFunction, BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction2) {
            this.tool = tool;
            this.call = biFunction;
            this.callHandler = biFunction2;
        }
    }
}
