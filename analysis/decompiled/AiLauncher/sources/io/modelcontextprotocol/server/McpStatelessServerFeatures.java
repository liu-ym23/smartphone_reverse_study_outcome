package io.modelcontextprotocol.server;

import io.modelcontextprotocol.client.transport.C4515e0;
import io.modelcontextprotocol.common.McpTransportContext;
import io.modelcontextprotocol.server.McpStatelessServerFeatures;
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
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes4.dex */
public class McpStatelessServerFeatures {

    public static final class Async extends W8.a {
        private final Map<McpSchema.CompleteReference, AsyncCompletionSpecification> completions;
        private final String instructions;
        private final Map<String, AsyncPromptSpecification> prompts;
        private final Map<String, AsyncResourceTemplateSpecification> resourceTemplates;
        private final Map<String, AsyncResourceSpecification> resources;
        private final McpSchema.ServerCapabilities serverCapabilities;
        private final McpSchema.Implementation serverInfo;
        private final List<AsyncToolSpecification> tools;

        public Async(McpSchema.Implementation implementation, McpSchema.ServerCapabilities serverCapabilities, List<AsyncToolSpecification> list, Map<String, AsyncResourceSpecification> map, Map<String, AsyncResourceTemplateSpecification> map2, Map<String, AsyncPromptSpecification> map3, Map<McpSchema.CompleteReference, AsyncCompletionSpecification> map4, String str) {
            McpSchema.ServerCapabilities.ResourceCapabilities resourceCapabilities;
            Assert.notNull(implementation, "Server info must not be null");
            this.serverInfo = implementation;
            if (serverCapabilities == null) {
                McpSchema.ServerCapabilities.PromptCapabilities promptCapabilities = !Utils.isEmpty(map3) ? new McpSchema.ServerCapabilities.PromptCapabilities(Boolean.FALSE) : null;
                if (Utils.isEmpty(map)) {
                    resourceCapabilities = null;
                } else {
                    Boolean bool = Boolean.FALSE;
                    resourceCapabilities = new McpSchema.ServerCapabilities.ResourceCapabilities(bool, bool);
                }
                serverCapabilities = new McpSchema.ServerCapabilities(null, null, null, promptCapabilities, resourceCapabilities, Utils.isEmpty(list) ? null : new McpSchema.ServerCapabilities.ToolCapabilities(Boolean.FALSE));
            }
            this.serverCapabilities = serverCapabilities;
            this.tools = list == null ? Collections.EMPTY_LIST : list;
            this.resources = map == null ? Collections.EMPTY_MAP : map;
            this.resourceTemplates = map2 == null ? Collections.EMPTY_MAP : map2;
            this.prompts = map3 == null ? Collections.EMPTY_MAP : map3;
            this.completions = map4 != null ? map4 : Collections.EMPTY_MAP;
            this.instructions = str;
        }

        private /* synthetic */ boolean e(Object obj) {
            if (!(obj instanceof Async)) {
                return false;
            }
            Async async = (Async) obj;
            return Objects.equals(this.serverInfo, async.serverInfo) && Objects.equals(this.serverCapabilities, async.serverCapabilities) && Objects.equals(this.tools, async.tools) && Objects.equals(this.resources, async.resources) && Objects.equals(this.resourceTemplates, async.resourceTemplates) && Objects.equals(this.prompts, async.prompts) && Objects.equals(this.completions, async.completions) && Objects.equals(this.instructions, async.instructions);
        }

        private /* synthetic */ Object[] f() {
            return new Object[]{this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.instructions};
        }

        public static Async fromSync(Sync sync, final boolean z10) {
            ArrayList arrayList = new ArrayList();
            Iterator<SyncToolSpecification> it = sync.tools().iterator();
            while (it.hasNext()) {
                arrayList.add(AsyncToolSpecification.fromSync(it.next(), z10));
            }
            final HashMap map = new HashMap();
            sync.resources().forEach(new BiConsumer() { // from class: io.modelcontextprotocol.server.n1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    map.put((String) obj, McpStatelessServerFeatures.AsyncResourceSpecification.fromSync((McpStatelessServerFeatures.SyncResourceSpecification) obj2, z10));
                }
            });
            final HashMap map2 = new HashMap();
            sync.resourceTemplates().forEach(new BiConsumer() { // from class: io.modelcontextprotocol.server.o1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    map2.put((String) obj, McpStatelessServerFeatures.AsyncResourceTemplateSpecification.fromSync((McpStatelessServerFeatures.SyncResourceTemplateSpecification) obj2, z10));
                }
            });
            final HashMap map3 = new HashMap();
            sync.prompts().forEach(new BiConsumer() { // from class: io.modelcontextprotocol.server.p1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    map3.put((String) obj, McpStatelessServerFeatures.AsyncPromptSpecification.fromSync((McpStatelessServerFeatures.SyncPromptSpecification) obj2, z10));
                }
            });
            final HashMap map4 = new HashMap();
            sync.completions().forEach(new BiConsumer() { // from class: io.modelcontextprotocol.server.q1
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    map4.put((McpSchema.CompleteReference) obj, McpStatelessServerFeatures.AsyncCompletionSpecification.fromSync((McpStatelessServerFeatures.SyncCompletionSpecification) obj2, z10));
                }
            });
            return new Async(sync.serverInfo(), sync.serverCapabilities(), arrayList, map, map2, map3, map4, sync.instructions());
        }

        public Map<McpSchema.CompleteReference, AsyncCompletionSpecification> completions() {
            return this.completions;
        }

        public final boolean equals(Object obj) {
            return e(obj);
        }

        public final int hashCode() {
            return r1.a(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.instructions);
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

        public McpSchema.ServerCapabilities serverCapabilities() {
            return this.serverCapabilities;
        }

        public McpSchema.Implementation serverInfo() {
            return this.serverInfo;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(f(), Async.class, "serverInfo;serverCapabilities;tools;resources;resourceTemplates;prompts;completions;instructions");
        }

        public List<AsyncToolSpecification> tools() {
            return this.tools;
        }
    }

    public static final class AsyncCompletionSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> completionHandler;
        private final McpSchema.CompleteReference referenceKey;

        public AsyncCompletionSpecification(McpSchema.CompleteReference completeReference, BiFunction<McpTransportContext, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> biFunction) {
            this.referenceKey = completeReference;
            this.completionHandler = biFunction;
        }

        public static /* synthetic */ Mono a(final SyncCompletionSpecification syncCompletionSpecification, boolean z10, final McpTransportContext mcpTransportContext, final McpSchema.CompleteRequest completeRequest) {
            Mono monoFromCallable = Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.server.t1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return syncCompletionSpecification.completionHandler().apply(mcpTransportContext, completeRequest);
                }
            });
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        private /* synthetic */ boolean c(Object obj) {
            if (!(obj instanceof AsyncCompletionSpecification)) {
                return false;
            }
            AsyncCompletionSpecification asyncCompletionSpecification = (AsyncCompletionSpecification) obj;
            return Objects.equals(this.referenceKey, asyncCompletionSpecification.referenceKey) && Objects.equals(this.completionHandler, asyncCompletionSpecification.completionHandler);
        }

        private /* synthetic */ Object[] d() {
            return new Object[]{this.referenceKey, this.completionHandler};
        }

        public static AsyncCompletionSpecification fromSync(final SyncCompletionSpecification syncCompletionSpecification, final boolean z10) {
            if (syncCompletionSpecification == null) {
                return null;
            }
            return new AsyncCompletionSpecification(syncCompletionSpecification.referenceKey(), new BiFunction() { // from class: io.modelcontextprotocol.server.s1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return McpStatelessServerFeatures.AsyncCompletionSpecification.a(syncCompletionSpecification, z10, (McpTransportContext) obj, (McpSchema.CompleteRequest) obj2);
                }
            });
        }

        public BiFunction<McpTransportContext, McpSchema.CompleteRequest, Mono<McpSchema.CompleteResult>> completionHandler() {
            return this.completionHandler;
        }

        public final boolean equals(Object obj) {
            return c(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.referenceKey, this.completionHandler);
        }

        public McpSchema.CompleteReference referenceKey() {
            return this.referenceKey;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(d(), AsyncCompletionSpecification.class, "referenceKey;completionHandler");
        }
    }

    public static final class AsyncPromptSpecification extends W8.a {
        private final McpSchema.Prompt prompt;
        private final BiFunction<McpTransportContext, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> promptHandler;

        public AsyncPromptSpecification(McpSchema.Prompt prompt, BiFunction<McpTransportContext, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> biFunction) {
            this.prompt = prompt;
            this.promptHandler = biFunction;
        }

        public static /* synthetic */ Mono b(final SyncPromptSpecification syncPromptSpecification, boolean z10, final McpTransportContext mcpTransportContext, final McpSchema.GetPromptRequest getPromptRequest) {
            Mono monoFromCallable = Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.server.u1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return syncPromptSpecification.promptHandler().apply(mcpTransportContext, getPromptRequest);
                }
            });
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        private /* synthetic */ boolean c(Object obj) {
            if (!(obj instanceof AsyncPromptSpecification)) {
                return false;
            }
            AsyncPromptSpecification asyncPromptSpecification = (AsyncPromptSpecification) obj;
            return Objects.equals(this.prompt, asyncPromptSpecification.prompt) && Objects.equals(this.promptHandler, asyncPromptSpecification.promptHandler);
        }

        private /* synthetic */ Object[] d() {
            return new Object[]{this.prompt, this.promptHandler};
        }

        public static AsyncPromptSpecification fromSync(final SyncPromptSpecification syncPromptSpecification, final boolean z10) {
            if (syncPromptSpecification == null) {
                return null;
            }
            return new AsyncPromptSpecification(syncPromptSpecification.prompt(), new BiFunction() { // from class: io.modelcontextprotocol.server.v1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return McpStatelessServerFeatures.AsyncPromptSpecification.b(syncPromptSpecification, z10, (McpTransportContext) obj, (McpSchema.GetPromptRequest) obj2);
                }
            });
        }

        public final boolean equals(Object obj) {
            return c(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.prompt, this.promptHandler);
        }

        public McpSchema.Prompt prompt() {
            return this.prompt;
        }

        public BiFunction<McpTransportContext, McpSchema.GetPromptRequest, Mono<McpSchema.GetPromptResult>> promptHandler() {
            return this.promptHandler;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(d(), AsyncPromptSpecification.class, "prompt;promptHandler");
        }
    }

    public static final class AsyncResourceSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler;
        private final McpSchema.Resource resource;

        public AsyncResourceSpecification(McpSchema.Resource resource, BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> biFunction) {
            this.resource = resource;
            this.readHandler = biFunction;
        }

        public static /* synthetic */ Mono b(final SyncResourceSpecification syncResourceSpecification, boolean z10, final McpTransportContext mcpTransportContext, final McpSchema.ReadResourceRequest readResourceRequest) {
            Mono monoFromCallable = Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.server.w1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return syncResourceSpecification.readHandler().apply(mcpTransportContext, readResourceRequest);
                }
            });
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        private /* synthetic */ boolean c(Object obj) {
            if (!(obj instanceof AsyncResourceSpecification)) {
                return false;
            }
            AsyncResourceSpecification asyncResourceSpecification = (AsyncResourceSpecification) obj;
            return Objects.equals(this.resource, asyncResourceSpecification.resource) && Objects.equals(this.readHandler, asyncResourceSpecification.readHandler);
        }

        private /* synthetic */ Object[] d() {
            return new Object[]{this.resource, this.readHandler};
        }

        public static AsyncResourceSpecification fromSync(final SyncResourceSpecification syncResourceSpecification, final boolean z10) {
            if (syncResourceSpecification == null) {
                return null;
            }
            return new AsyncResourceSpecification(syncResourceSpecification.resource(), new BiFunction() { // from class: io.modelcontextprotocol.server.x1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return McpStatelessServerFeatures.AsyncResourceSpecification.b(syncResourceSpecification, z10, (McpTransportContext) obj, (McpSchema.ReadResourceRequest) obj2);
                }
            });
        }

        public final boolean equals(Object obj) {
            return c(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.resource, this.readHandler);
        }

        public BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler() {
            return this.readHandler;
        }

        public McpSchema.Resource resource() {
            return this.resource;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(d(), AsyncResourceSpecification.class, "resource;readHandler");
        }
    }

    public static final class AsyncResourceTemplateSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler;
        private final McpSchema.ResourceTemplate resourceTemplate;

        public AsyncResourceTemplateSpecification(McpSchema.ResourceTemplate resourceTemplate, BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> biFunction) {
            this.resourceTemplate = resourceTemplate;
            this.readHandler = biFunction;
        }

        public static /* synthetic */ Mono b(final SyncResourceTemplateSpecification syncResourceTemplateSpecification, boolean z10, final McpTransportContext mcpTransportContext, final McpSchema.ReadResourceRequest readResourceRequest) {
            Mono monoFromCallable = Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.server.z1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return syncResourceTemplateSpecification.readHandler().apply(mcpTransportContext, readResourceRequest);
                }
            });
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        private /* synthetic */ boolean c(Object obj) {
            if (!(obj instanceof AsyncResourceTemplateSpecification)) {
                return false;
            }
            AsyncResourceTemplateSpecification asyncResourceTemplateSpecification = (AsyncResourceTemplateSpecification) obj;
            return Objects.equals(this.resourceTemplate, asyncResourceTemplateSpecification.resourceTemplate) && Objects.equals(this.readHandler, asyncResourceTemplateSpecification.readHandler);
        }

        private /* synthetic */ Object[] d() {
            return new Object[]{this.resourceTemplate, this.readHandler};
        }

        public static AsyncResourceTemplateSpecification fromSync(final SyncResourceTemplateSpecification syncResourceTemplateSpecification, final boolean z10) {
            if (syncResourceTemplateSpecification == null) {
                return null;
            }
            return new AsyncResourceTemplateSpecification(syncResourceTemplateSpecification.resourceTemplate(), new BiFunction() { // from class: io.modelcontextprotocol.server.y1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return McpStatelessServerFeatures.AsyncResourceTemplateSpecification.b(syncResourceTemplateSpecification, z10, (McpTransportContext) obj, (McpSchema.ReadResourceRequest) obj2);
                }
            });
        }

        public final boolean equals(Object obj) {
            return c(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.resourceTemplate, this.readHandler);
        }

        public BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, Mono<McpSchema.ReadResourceResult>> readHandler() {
            return this.readHandler;
        }

        public McpSchema.ResourceTemplate resourceTemplate() {
            return this.resourceTemplate;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(d(), AsyncResourceTemplateSpecification.class, "resourceTemplate;readHandler");
        }
    }

    public static final class AsyncToolSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler;
        private final McpSchema.Tool tool;

        public static class Builder {
            private BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler;
            private McpSchema.Tool tool;

            public AsyncToolSpecification build() {
                Assert.notNull(this.tool, "Tool must not be null");
                Assert.notNull(this.callHandler, "Call handler function must not be null");
                return new AsyncToolSpecification(this.tool, this.callHandler);
            }

            public Builder callHandler(BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
                this.callHandler = biFunction;
                return this;
            }

            public Builder tool(McpSchema.Tool tool) {
                this.tool = tool;
                return this;
            }
        }

        public AsyncToolSpecification(McpSchema.Tool tool, BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> biFunction) {
            this.tool = tool;
            this.callHandler = biFunction;
        }

        public static /* synthetic */ Mono b(final SyncToolSpecification syncToolSpecification, boolean z10, final McpTransportContext mcpTransportContext, final McpSchema.CallToolRequest callToolRequest) {
            Mono monoFromCallable = Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.server.A1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return syncToolSpecification.callHandler().apply(mcpTransportContext, callToolRequest);
                }
            });
            return z10 ? monoFromCallable : monoFromCallable.subscribeOn(Schedulers.boundedElastic());
        }

        public static Builder builder() {
            return new Builder();
        }

        private /* synthetic */ boolean c(Object obj) {
            if (!(obj instanceof AsyncToolSpecification)) {
                return false;
            }
            AsyncToolSpecification asyncToolSpecification = (AsyncToolSpecification) obj;
            return Objects.equals(this.tool, asyncToolSpecification.tool) && Objects.equals(this.callHandler, asyncToolSpecification.callHandler);
        }

        private /* synthetic */ Object[] d() {
            return new Object[]{this.tool, this.callHandler};
        }

        public static AsyncToolSpecification fromSync(SyncToolSpecification syncToolSpecification) {
            return fromSync(syncToolSpecification, false);
        }

        public BiFunction<McpTransportContext, McpSchema.CallToolRequest, Mono<McpSchema.CallToolResult>> callHandler() {
            return this.callHandler;
        }

        public final boolean equals(Object obj) {
            return c(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.tool, this.callHandler);
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(d(), AsyncToolSpecification.class, "tool;callHandler");
        }

        public McpSchema.Tool tool() {
            return this.tool;
        }

        public static AsyncToolSpecification fromSync(final SyncToolSpecification syncToolSpecification, final boolean z10) {
            if (syncToolSpecification == null) {
                return null;
            }
            return new AsyncToolSpecification(syncToolSpecification.tool(), new BiFunction() { // from class: io.modelcontextprotocol.server.B1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return McpStatelessServerFeatures.AsyncToolSpecification.b(syncToolSpecification, z10, (McpTransportContext) obj, (McpSchema.CallToolRequest) obj2);
                }
            });
        }
    }

    public static final class Sync extends W8.a {
        private final Map<McpSchema.CompleteReference, SyncCompletionSpecification> completions;
        private final String instructions;
        private final Map<String, SyncPromptSpecification> prompts;
        private final Map<String, SyncResourceTemplateSpecification> resourceTemplates;
        private final Map<String, SyncResourceSpecification> resources;
        private final McpSchema.ServerCapabilities serverCapabilities;
        private final McpSchema.Implementation serverInfo;
        private final List<SyncToolSpecification> tools;

        public Sync(McpSchema.Implementation implementation, McpSchema.ServerCapabilities serverCapabilities, List<SyncToolSpecification> list, Map<String, SyncResourceSpecification> map, Map<String, SyncResourceTemplateSpecification> map2, Map<String, SyncPromptSpecification> map3, Map<McpSchema.CompleteReference, SyncCompletionSpecification> map4, String str) {
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
            this.instructions = str;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof Sync)) {
                return false;
            }
            Sync sync = (Sync) obj;
            return Objects.equals(this.serverInfo, sync.serverInfo) && Objects.equals(this.serverCapabilities, sync.serverCapabilities) && Objects.equals(this.tools, sync.tools) && Objects.equals(this.resources, sync.resources) && Objects.equals(this.resourceTemplates, sync.resourceTemplates) && Objects.equals(this.prompts, sync.prompts) && Objects.equals(this.completions, sync.completions) && Objects.equals(this.instructions, sync.instructions);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.instructions};
        }

        public Map<McpSchema.CompleteReference, SyncCompletionSpecification> completions() {
            return this.completions;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return r1.a(this.serverInfo, this.serverCapabilities, this.tools, this.resources, this.resourceTemplates, this.prompts, this.completions, this.instructions);
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

        public McpSchema.ServerCapabilities serverCapabilities() {
            return this.serverCapabilities;
        }

        public McpSchema.Implementation serverInfo() {
            return this.serverInfo;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(b(), Sync.class, "serverInfo;serverCapabilities;tools;resources;resourceTemplates;prompts;completions;instructions");
        }

        public List<SyncToolSpecification> tools() {
            return this.tools;
        }
    }

    public static final class SyncCompletionSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.CompleteRequest, McpSchema.CompleteResult> completionHandler;
        private final McpSchema.CompleteReference referenceKey;

        public SyncCompletionSpecification(McpSchema.CompleteReference completeReference, BiFunction<McpTransportContext, McpSchema.CompleteRequest, McpSchema.CompleteResult> biFunction) {
            this.referenceKey = completeReference;
            this.completionHandler = biFunction;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SyncCompletionSpecification)) {
                return false;
            }
            SyncCompletionSpecification syncCompletionSpecification = (SyncCompletionSpecification) obj;
            return Objects.equals(this.referenceKey, syncCompletionSpecification.referenceKey) && Objects.equals(this.completionHandler, syncCompletionSpecification.completionHandler);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.referenceKey, this.completionHandler};
        }

        public BiFunction<McpTransportContext, McpSchema.CompleteRequest, McpSchema.CompleteResult> completionHandler() {
            return this.completionHandler;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.referenceKey, this.completionHandler);
        }

        public McpSchema.CompleteReference referenceKey() {
            return this.referenceKey;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(b(), SyncCompletionSpecification.class, "referenceKey;completionHandler");
        }
    }

    public static final class SyncPromptSpecification extends W8.a {
        private final McpSchema.Prompt prompt;
        private final BiFunction<McpTransportContext, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> promptHandler;

        public SyncPromptSpecification(McpSchema.Prompt prompt, BiFunction<McpTransportContext, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> biFunction) {
            this.prompt = prompt;
            this.promptHandler = biFunction;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SyncPromptSpecification)) {
                return false;
            }
            SyncPromptSpecification syncPromptSpecification = (SyncPromptSpecification) obj;
            return Objects.equals(this.prompt, syncPromptSpecification.prompt) && Objects.equals(this.promptHandler, syncPromptSpecification.promptHandler);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.prompt, this.promptHandler};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.prompt, this.promptHandler);
        }

        public McpSchema.Prompt prompt() {
            return this.prompt;
        }

        public BiFunction<McpTransportContext, McpSchema.GetPromptRequest, McpSchema.GetPromptResult> promptHandler() {
            return this.promptHandler;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(b(), SyncPromptSpecification.class, "prompt;promptHandler");
        }
    }

    public static final class SyncResourceSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler;
        private final McpSchema.Resource resource;

        public SyncResourceSpecification(McpSchema.Resource resource, BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> biFunction) {
            this.resource = resource;
            this.readHandler = biFunction;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SyncResourceSpecification)) {
                return false;
            }
            SyncResourceSpecification syncResourceSpecification = (SyncResourceSpecification) obj;
            return Objects.equals(this.resource, syncResourceSpecification.resource) && Objects.equals(this.readHandler, syncResourceSpecification.readHandler);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.resource, this.readHandler};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.resource, this.readHandler);
        }

        public BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler() {
            return this.readHandler;
        }

        public McpSchema.Resource resource() {
            return this.resource;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(b(), SyncResourceSpecification.class, "resource;readHandler");
        }
    }

    public static final class SyncResourceTemplateSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler;
        private final McpSchema.ResourceTemplate resourceTemplate;

        public SyncResourceTemplateSpecification(McpSchema.ResourceTemplate resourceTemplate, BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> biFunction) {
            this.resourceTemplate = resourceTemplate;
            this.readHandler = biFunction;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SyncResourceTemplateSpecification)) {
                return false;
            }
            SyncResourceTemplateSpecification syncResourceTemplateSpecification = (SyncResourceTemplateSpecification) obj;
            return Objects.equals(this.resourceTemplate, syncResourceTemplateSpecification.resourceTemplate) && Objects.equals(this.readHandler, syncResourceTemplateSpecification.readHandler);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.resourceTemplate, this.readHandler};
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.resourceTemplate, this.readHandler);
        }

        public BiFunction<McpTransportContext, McpSchema.ReadResourceRequest, McpSchema.ReadResourceResult> readHandler() {
            return this.readHandler;
        }

        public McpSchema.ResourceTemplate resourceTemplate() {
            return this.resourceTemplate;
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(b(), SyncResourceTemplateSpecification.class, "resourceTemplate;readHandler");
        }
    }

    public static final class SyncToolSpecification extends W8.a {
        private final BiFunction<McpTransportContext, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler;
        private final McpSchema.Tool tool;

        public static class Builder {
            private BiFunction<McpTransportContext, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler;
            private McpSchema.Tool tool;

            public SyncToolSpecification build() {
                Assert.notNull(this.tool, "Tool must not be null");
                Assert.notNull(this.callHandler, "CallTool function must not be null");
                return new SyncToolSpecification(this.tool, this.callHandler);
            }

            public Builder callHandler(BiFunction<McpTransportContext, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction) {
                this.callHandler = biFunction;
                return this;
            }

            public Builder tool(McpSchema.Tool tool) {
                this.tool = tool;
                return this;
            }
        }

        public SyncToolSpecification(McpSchema.Tool tool, BiFunction<McpTransportContext, McpSchema.CallToolRequest, McpSchema.CallToolResult> biFunction) {
            this.tool = tool;
            this.callHandler = biFunction;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof SyncToolSpecification)) {
                return false;
            }
            SyncToolSpecification syncToolSpecification = (SyncToolSpecification) obj;
            return Objects.equals(this.tool, syncToolSpecification.tool) && Objects.equals(this.callHandler, syncToolSpecification.callHandler);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.tool, this.callHandler};
        }

        public static Builder builder() {
            return new Builder();
        }

        public BiFunction<McpTransportContext, McpSchema.CallToolRequest, McpSchema.CallToolResult> callHandler() {
            return this.callHandler;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return C4515e0.a(this.tool, this.callHandler);
        }

        public final String toString() {
            return io.modelcontextprotocol.client.b1.a(b(), SyncToolSpecification.class, "tool;callHandler");
        }

        public McpSchema.Tool tool() {
            return this.tool;
        }
    }
}
