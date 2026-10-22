package io.modelcontextprotocol.server;

import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
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

/* loaded from: classes3.dex */
public class McpServerFeatures {

    public static final class Async extends B7.a {
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
            sync.resources().forEach(new x(map, z10, 0));
            HashMap map2 = new HashMap();
            sync.resourceTemplates().forEach(new x(map2, z10, 1));
            HashMap map3 = new HashMap();
            sync.prompts().forEach(new x(map3, z10, 2));
            HashMap map4 = new HashMap();
            sync.completions().forEach(new x(map4, z10, 3));
            ArrayList arrayList2 = new ArrayList();
            Iterator<BiConsumer<McpSyncServerExchange, List<McpSchema.Root>>> it2 = sync.rootsChangeConsumers().iterator();
            while (it2.hasNext()) {
                arrayList2.add(new A(it2.next(), 2));
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
        public static /* synthetic */ Mono lambda$fromSync$5(final BiConsumer biConsumer, final McpAsyncServerExchange mcpAsyncServerExchange, final List list) {
            return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.server.w
                @Override // java.lang.Runnable
                public final void run() {
                    McpServerFeatures.Async.lambda$fromSync$4(biConsumer, mcpAsyncServerExchange, list);
                }
            }).subscribeOn(Schedulers.boundedElastic());
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
            return Objects.hashCode(str) + com.stepos.statsrpk.service.c.b(list2, com.stepos.statsrpk.service.c.c(map4, com.stepos.statsrpk.service.c.c(map3, com.stepos.statsrpk.service.c.c(map2, com.stepos.statsrpk.service.c.c(map, com.stepos.statsrpk.service.c.b(list, (Objects.hashCode(serverCapabilities) + (Objects.hashCode(implementation) * 31)) * 31, 31), 31), 31), 31), 31), 31);
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, Async.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public List<AsyncToolSpecification> tools() {
            return this.tools;
        }
    }

    public static final class AsyncCompletionSpecification extends B7.a {
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
            return new AsyncCompletionSpecification(syncCompletionSpecification.referenceKey(), new y(syncCompletionSpecification, z10, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CompleteResult lambda$fromSync$0(SyncCompletionSpecification syncCompletionSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CompleteRequest completeRequest) throws Exception {
            return syncCompletionSpecification.completionHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), completeRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncCompletionSpecification syncCompletionSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CompleteRequest completeRequest) {
            Mono monoFromCallable = Mono.fromCallable(new z(syncCompletionSpecification, mcpAsyncServerExchange, completeRequest, 0));
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, AsyncCompletionSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class AsyncPromptSpecification extends B7.a {
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
            return new AsyncPromptSpecification(syncPromptSpecification.prompt(), new y(syncPromptSpecification, z10, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.GetPromptResult lambda$fromSync$0(SyncPromptSpecification syncPromptSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.GetPromptRequest getPromptRequest) throws Exception {
            return syncPromptSpecification.promptHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), getPromptRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncPromptSpecification syncPromptSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.GetPromptRequest getPromptRequest) {
            Mono monoFromCallable = Mono.fromCallable(new z(syncPromptSpecification, mcpAsyncServerExchange, getPromptRequest, 1));
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, AsyncPromptSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class AsyncResourceSpecification extends B7.a {
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
            return new AsyncResourceSpecification(syncResourceSpecification.resource(), new y(syncResourceSpecification, z10, 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.ReadResourceResult lambda$fromSync$0(SyncResourceSpecification syncResourceSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) throws Exception {
            return syncResourceSpecification.readHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), readResourceRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncResourceSpecification syncResourceSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
            Mono monoFromCallable = Mono.fromCallable(new z(syncResourceSpecification, mcpAsyncServerExchange, readResourceRequest, 2));
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, AsyncResourceSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class AsyncResourceTemplateSpecification extends B7.a {
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
            return new AsyncResourceTemplateSpecification(syncResourceTemplateSpecification.resourceTemplate(), new y(syncResourceTemplateSpecification, z10, 3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.ReadResourceResult lambda$fromSync$0(SyncResourceTemplateSpecification syncResourceTemplateSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) throws Exception {
            return syncResourceTemplateSpecification.readHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), readResourceRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(SyncResourceTemplateSpecification syncResourceTemplateSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.ReadResourceRequest readResourceRequest) {
            Mono monoFromCallable = Mono.fromCallable(new z(syncResourceTemplateSpecification, mcpAsyncServerExchange, readResourceRequest, 3));
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, AsyncResourceTemplateSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class AsyncToolSpecification extends B7.a {

        @Deprecated
        private final BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> call;
        private final BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler;
        private final McpSchema.Tool tool;

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

        public AsyncToolSpecification(McpSchema.Tool tool, @Deprecated BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> biFunction, BiFunction<McpAsyncServerExchange, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction2) {
            this.tool = tool;
            this.call = biFunction;
            this.callHandler = biFunction2;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static AsyncToolSpecification fromSync(SyncToolSpecification syncToolSpecification) {
            return fromSync(syncToolSpecification, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CallToolResult lambda$fromSync$1(SyncToolSpecification syncToolSpecification, McpAsyncServerExchange mcpAsyncServerExchange, Map map) throws Exception {
            return syncToolSpecification.call().apply(new McpSyncServerExchange(mcpAsyncServerExchange), map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$2(SyncToolSpecification syncToolSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, Map map) {
            Mono monoFromCallable = Mono.fromCallable(new z(syncToolSpecification, mcpAsyncServerExchange, map, 4));
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CallToolResult lambda$fromSync$3(SyncToolSpecification syncToolSpecification, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) throws Exception {
            return syncToolSpecification.callHandler().apply(new McpSyncServerExchange(mcpAsyncServerExchange), callToolRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$4(SyncToolSpecification syncToolSpecification, boolean z10, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest) {
            Mono monoFromCallable = Mono.fromCallable(new z(syncToolSpecification, mcpAsyncServerExchange, callToolRequest, 5));
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, AsyncToolSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public McpSchema.Tool tool() {
            return this.tool;
        }

        @Deprecated
        public AsyncToolSpecification(McpSchema.Tool tool, BiFunction<McpAsyncServerExchange, Map<String, Object>, Mono<McpSchema.CallToolResult>> biFunction) {
            this(tool, biFunction, new A(biFunction, 0));
        }

        public static AsyncToolSpecification fromSync(final SyncToolSpecification syncToolSpecification, final boolean z10) {
            BiFunction biFunction = null;
            if (syncToolSpecification == null) {
                return null;
            }
            if (syncToolSpecification.call() != null) {
                final int i = 0;
                biFunction = new BiFunction() { // from class: io.modelcontextprotocol.server.B
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        McpAsyncServerExchange mcpAsyncServerExchange = (McpAsyncServerExchange) obj;
                        switch (i) {
                            case 0:
                                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$2(syncToolSpecification, z10, mcpAsyncServerExchange, (Map) obj2);
                            default:
                                return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$4(syncToolSpecification, z10, mcpAsyncServerExchange, (McpSchema.CallToolRequest) obj2);
                        }
                    }
                };
            }
            final int i6 = 1;
            return new AsyncToolSpecification(syncToolSpecification.tool(), biFunction, new BiFunction() { // from class: io.modelcontextprotocol.server.B
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    McpAsyncServerExchange mcpAsyncServerExchange = (McpAsyncServerExchange) obj;
                    switch (i6) {
                        case 0:
                            return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$2(syncToolSpecification, z10, mcpAsyncServerExchange, (Map) obj2);
                        default:
                            return McpServerFeatures.AsyncToolSpecification.lambda$fromSync$4(syncToolSpecification, z10, mcpAsyncServerExchange, (McpSchema.CallToolRequest) obj2);
                    }
                }
            });
        }
    }

    public static final class Sync extends B7.a {
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
            return Objects.hashCode(str) + com.stepos.statsrpk.service.c.b(list2, com.stepos.statsrpk.service.c.c(map4, com.stepos.statsrpk.service.c.c(map3, com.stepos.statsrpk.service.c.c(map2, com.stepos.statsrpk.service.c.c(map, com.stepos.statsrpk.service.c.b(list, (Objects.hashCode(serverCapabilities) + (Objects.hashCode(implementation) * 31)) * 31, 31), 31), 31), 31), 31), 31);
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, Sync.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public List<SyncToolSpecification> tools() {
            return this.tools;
        }
    }

    public static final class SyncCompletionSpecification extends B7.a {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SyncCompletionSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class SyncPromptSpecification extends B7.a {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SyncPromptSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class SyncResourceSpecification extends B7.a {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SyncResourceSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class SyncResourceTemplateSpecification extends B7.a {
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SyncResourceTemplateSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class SyncToolSpecification extends B7.a {

        @Deprecated
        private final BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> call;
        private final BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler;
        private final McpSchema.Tool tool;

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

        public SyncToolSpecification(McpSchema.Tool tool, @Deprecated BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> biFunction, BiFunction<McpSyncServerExchange, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction2) {
            this.tool = tool;
            this.call = biFunction;
            this.callHandler = biFunction2;
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
            StringBuilder sb = new StringBuilder();
            com.stepos.statsrpk.service.c.q(sb, SyncToolSpecification.class, "[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append("=");
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public McpSchema.Tool tool() {
            return this.tool;
        }

        @Deprecated
        public SyncToolSpecification(McpSchema.Tool tool, BiFunction<McpSyncServerExchange, Map<String, Object>, McpSchema.CallToolResult> biFunction) {
            this(tool, biFunction, new A(biFunction, 1));
        }
    }
}
