package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes4.dex */
class McpClientFeatures {

    public static final class Async extends W8.a {
        private final McpSchema.ClientCapabilities clientCapabilities;
        private final McpSchema.Implementation clientInfo;
        private final Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> elicitationHandler;
        private final boolean enableCallToolSchemaCaching;
        private final List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> loggingConsumers;
        private final List<Function<McpSchema.ProgressNotification, Mono<Void>>> progressConsumers;
        private final List<Function<List<McpSchema.Prompt>, Mono<Void>>> promptsChangeConsumers;
        private final List<Function<List<McpSchema.Resource>, Mono<Void>>> resourcesChangeConsumers;
        private final List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> resourcesUpdateConsumers;
        private final Map<String, McpSchema.Root> roots;
        private final Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> samplingHandler;
        private final List<Function<List<McpSchema.Tool>, Mono<Void>>> toolsChangeConsumers;

        public Async(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Function<List<McpSchema.Tool>, Mono<Void>>> list, List<Function<List<McpSchema.Resource>, Mono<Void>>> list2, List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list3, List<Function<List<McpSchema.Prompt>, Mono<Void>>> list4, List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list5, List<Function<McpSchema.ProgressNotification, Mono<Void>>> list6, Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> function, Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> function2, boolean z10) {
            Assert.notNull(implementation, "Client info must not be null");
            this.clientInfo = implementation;
            if (clientCapabilities == null) {
                clientCapabilities = new McpSchema.ClientCapabilities(null, !Utils.isEmpty(map) ? new McpSchema.ClientCapabilities.RootCapabilities(Boolean.FALSE) : null, function != null ? new McpSchema.ClientCapabilities.Sampling() : null, function2 != null ? new McpSchema.ClientCapabilities.Elicitation() : null);
            }
            this.clientCapabilities = clientCapabilities;
            this.roots = map != null ? new ConcurrentHashMap(map) : new ConcurrentHashMap();
            this.toolsChangeConsumers = list == null ? Collections.EMPTY_LIST : list;
            this.resourcesChangeConsumers = list2 == null ? Collections.EMPTY_LIST : list2;
            this.resourcesUpdateConsumers = list3 == null ? Collections.EMPTY_LIST : list3;
            this.promptsChangeConsumers = list4 == null ? Collections.EMPTY_LIST : list4;
            this.loggingConsumers = list5 == null ? Collections.EMPTY_LIST : list5;
            this.progressConsumers = list6 == null ? Collections.EMPTY_LIST : list6;
            this.samplingHandler = function;
            this.elicitationHandler = function2;
            this.enableCallToolSchemaCaching = z10;
        }

        public static Async fromSync(final Sync sync) {
            ArrayList arrayList = new ArrayList();
            for (final Consumer<List<McpSchema.Tool>> consumer : sync.toolsChangeConsumers()) {
                arrayList.add(new Function() { // from class: io.modelcontextprotocol.client.Y0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.Q0
                            @Override // java.lang.Runnable
                            public final void run() {
                                consumer.accept(list);
                            }
                        }).subscribeOn(Schedulers.boundedElastic());
                    }
                });
            }
            ArrayList arrayList2 = new ArrayList();
            for (final Consumer<List<McpSchema.Resource>> consumer2 : sync.resourcesChangeConsumers()) {
                arrayList2.add(new Function() { // from class: io.modelcontextprotocol.client.Z0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.U0
                            @Override // java.lang.Runnable
                            public final void run() {
                                consumer.accept(list);
                            }
                        }).subscribeOn(Schedulers.boundedElastic());
                    }
                });
            }
            ArrayList arrayList3 = new ArrayList();
            for (final Consumer<List<McpSchema.ResourceContents>> consumer3 : sync.resourcesUpdateConsumers()) {
                arrayList3.add(new Function() { // from class: io.modelcontextprotocol.client.K0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.S0
                            @Override // java.lang.Runnable
                            public final void run() {
                                consumer.accept(list);
                            }
                        }).subscribeOn(Schedulers.boundedElastic());
                    }
                });
            }
            ArrayList arrayList4 = new ArrayList();
            for (final Consumer<List<McpSchema.Prompt>> consumer4 : sync.promptsChangeConsumers()) {
                arrayList4.add(new Function() { // from class: io.modelcontextprotocol.client.L0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.R0
                            @Override // java.lang.Runnable
                            public final void run() {
                                consumer.accept(list);
                            }
                        }).subscribeOn(Schedulers.boundedElastic());
                    }
                });
            }
            ArrayList arrayList5 = new ArrayList();
            for (final Consumer<McpSchema.LoggingMessageNotification> consumer5 : sync.loggingConsumers()) {
                arrayList5.add(new Function() { // from class: io.modelcontextprotocol.client.M0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.W0
                            @Override // java.lang.Runnable
                            public final void run() {
                                consumer.accept(loggingMessageNotification);
                            }
                        }).subscribeOn(Schedulers.boundedElastic());
                    }
                });
            }
            ArrayList arrayList6 = new ArrayList();
            for (final Consumer<McpSchema.ProgressNotification> consumer6 : sync.progressConsumers()) {
                arrayList6.add(new Function() { // from class: io.modelcontextprotocol.client.N0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.T0
                            @Override // java.lang.Runnable
                            public final void run() {
                                consumer.accept(progressNotification);
                            }
                        }).subscribeOn(Schedulers.boundedElastic());
                    }
                });
            }
            return new Async(sync.clientInfo(), sync.clientCapabilities(), sync.roots(), arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, new Function() { // from class: io.modelcontextprotocol.client.O0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.client.V0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return sync.samplingHandler().apply(createMessageRequest);
                        }
                    }).subscribeOn(Schedulers.boundedElastic());
                }
            }, new Function() { // from class: io.modelcontextprotocol.client.P0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Mono.fromCallable(new Callable() { // from class: io.modelcontextprotocol.client.X0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return sync.elicitationHandler().apply(elicitRequest);
                        }
                    }).subscribeOn(Schedulers.boundedElastic());
                }
            }, sync.enableCallToolSchemaCaching);
        }

        public McpSchema.ClientCapabilities clientCapabilities() {
            return this.clientCapabilities;
        }

        public McpSchema.Implementation clientInfo() {
            return this.clientInfo;
        }

        public Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> elicitationHandler() {
            return this.elicitationHandler;
        }

        public boolean enableCallToolSchemaCaching() {
            return this.enableCallToolSchemaCaching;
        }

        public final boolean equals(Object obj) {
            return q(obj);
        }

        public final int hashCode() {
            return a1.a(this.enableCallToolSchemaCaching, this.clientInfo, this.clientCapabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler);
        }

        public List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> loggingConsumers() {
            return this.loggingConsumers;
        }

        public List<Function<McpSchema.ProgressNotification, Mono<Void>>> progressConsumers() {
            return this.progressConsumers;
        }

        public List<Function<List<McpSchema.Prompt>, Mono<Void>>> promptsChangeConsumers() {
            return this.promptsChangeConsumers;
        }

        public final /* synthetic */ boolean q(Object obj) {
            if (!(obj instanceof Async)) {
                return false;
            }
            Async async = (Async) obj;
            return this.enableCallToolSchemaCaching == async.enableCallToolSchemaCaching && Objects.equals(this.clientInfo, async.clientInfo) && Objects.equals(this.clientCapabilities, async.clientCapabilities) && Objects.equals(this.roots, async.roots) && Objects.equals(this.toolsChangeConsumers, async.toolsChangeConsumers) && Objects.equals(this.resourcesChangeConsumers, async.resourcesChangeConsumers) && Objects.equals(this.resourcesUpdateConsumers, async.resourcesUpdateConsumers) && Objects.equals(this.promptsChangeConsumers, async.promptsChangeConsumers) && Objects.equals(this.loggingConsumers, async.loggingConsumers) && Objects.equals(this.progressConsumers, async.progressConsumers) && Objects.equals(this.samplingHandler, async.samplingHandler) && Objects.equals(this.elicitationHandler, async.elicitationHandler);
        }

        public final /* synthetic */ Object[] r() {
            return new Object[]{this.clientInfo, this.clientCapabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler, Boolean.valueOf(this.enableCallToolSchemaCaching)};
        }

        public List<Function<List<McpSchema.Resource>, Mono<Void>>> resourcesChangeConsumers() {
            return this.resourcesChangeConsumers;
        }

        public List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> resourcesUpdateConsumers() {
            return this.resourcesUpdateConsumers;
        }

        public Map<String, McpSchema.Root> roots() {
            return this.roots;
        }

        public Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> samplingHandler() {
            return this.samplingHandler;
        }

        public final String toString() {
            return b1.a(r(), Async.class, "clientInfo;clientCapabilities;roots;toolsChangeConsumers;resourcesChangeConsumers;resourcesUpdateConsumers;promptsChangeConsumers;loggingConsumers;progressConsumers;samplingHandler;elicitationHandler;enableCallToolSchemaCaching");
        }

        public List<Function<List<McpSchema.Tool>, Mono<Void>>> toolsChangeConsumers() {
            return this.toolsChangeConsumers;
        }

        public Async(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Function<List<McpSchema.Tool>, Mono<Void>>> list, List<Function<List<McpSchema.Resource>, Mono<Void>>> list2, List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list3, List<Function<List<McpSchema.Prompt>, Mono<Void>>> list4, List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list5, Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> function, Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> function2) {
            this(implementation, clientCapabilities, map, list, list2, list3, list4, list5, Collections.EMPTY_LIST, function, function2, false);
        }
    }

    public static final class Sync extends W8.a {
        private final McpSchema.ClientCapabilities clientCapabilities;
        private final McpSchema.Implementation clientInfo;
        private final Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> elicitationHandler;
        private final boolean enableCallToolSchemaCaching;
        private final List<Consumer<McpSchema.LoggingMessageNotification>> loggingConsumers;
        private final List<Consumer<McpSchema.ProgressNotification>> progressConsumers;
        private final List<Consumer<List<McpSchema.Prompt>>> promptsChangeConsumers;
        private final List<Consumer<List<McpSchema.Resource>>> resourcesChangeConsumers;
        private final List<Consumer<List<McpSchema.ResourceContents>>> resourcesUpdateConsumers;
        private final Map<String, McpSchema.Root> roots;
        private final Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> samplingHandler;
        private final List<Consumer<List<McpSchema.Tool>>> toolsChangeConsumers;

        public Sync(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Consumer<List<McpSchema.Tool>>> list, List<Consumer<List<McpSchema.Resource>>> list2, List<Consumer<List<McpSchema.ResourceContents>>> list3, List<Consumer<List<McpSchema.Prompt>>> list4, List<Consumer<McpSchema.LoggingMessageNotification>> list5, List<Consumer<McpSchema.ProgressNotification>> list6, Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> function, Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> function2, boolean z10) {
            Assert.notNull(implementation, "Client info must not be null");
            this.clientInfo = implementation;
            if (clientCapabilities == null) {
                clientCapabilities = new McpSchema.ClientCapabilities(null, !Utils.isEmpty(map) ? new McpSchema.ClientCapabilities.RootCapabilities(Boolean.FALSE) : null, function != null ? new McpSchema.ClientCapabilities.Sampling() : null, function2 != null ? new McpSchema.ClientCapabilities.Elicitation() : null);
            }
            this.clientCapabilities = clientCapabilities;
            this.roots = map != null ? new HashMap(map) : new HashMap();
            this.toolsChangeConsumers = list == null ? Collections.EMPTY_LIST : list;
            this.resourcesChangeConsumers = list2 == null ? Collections.EMPTY_LIST : list2;
            this.resourcesUpdateConsumers = list3 == null ? Collections.EMPTY_LIST : list3;
            this.promptsChangeConsumers = list4 == null ? Collections.EMPTY_LIST : list4;
            this.loggingConsumers = list5 == null ? Collections.EMPTY_LIST : list5;
            this.progressConsumers = list6 == null ? Collections.EMPTY_LIST : list6;
            this.samplingHandler = function;
            this.elicitationHandler = function2;
            this.enableCallToolSchemaCaching = z10;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof Sync)) {
                return false;
            }
            Sync sync = (Sync) obj;
            return this.enableCallToolSchemaCaching == sync.enableCallToolSchemaCaching && Objects.equals(this.clientInfo, sync.clientInfo) && Objects.equals(this.clientCapabilities, sync.clientCapabilities) && Objects.equals(this.roots, sync.roots) && Objects.equals(this.toolsChangeConsumers, sync.toolsChangeConsumers) && Objects.equals(this.resourcesChangeConsumers, sync.resourcesChangeConsumers) && Objects.equals(this.resourcesUpdateConsumers, sync.resourcesUpdateConsumers) && Objects.equals(this.promptsChangeConsumers, sync.promptsChangeConsumers) && Objects.equals(this.loggingConsumers, sync.loggingConsumers) && Objects.equals(this.progressConsumers, sync.progressConsumers) && Objects.equals(this.samplingHandler, sync.samplingHandler) && Objects.equals(this.elicitationHandler, sync.elicitationHandler);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.clientInfo, this.clientCapabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler, Boolean.valueOf(this.enableCallToolSchemaCaching)};
        }

        public McpSchema.ClientCapabilities clientCapabilities() {
            return this.clientCapabilities;
        }

        public McpSchema.Implementation clientInfo() {
            return this.clientInfo;
        }

        public Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> elicitationHandler() {
            return this.elicitationHandler;
        }

        public boolean enableCallToolSchemaCaching() {
            return this.enableCallToolSchemaCaching;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public final int hashCode() {
            return a1.a(this.enableCallToolSchemaCaching, this.clientInfo, this.clientCapabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler);
        }

        public List<Consumer<McpSchema.LoggingMessageNotification>> loggingConsumers() {
            return this.loggingConsumers;
        }

        public List<Consumer<McpSchema.ProgressNotification>> progressConsumers() {
            return this.progressConsumers;
        }

        public List<Consumer<List<McpSchema.Prompt>>> promptsChangeConsumers() {
            return this.promptsChangeConsumers;
        }

        public List<Consumer<List<McpSchema.Resource>>> resourcesChangeConsumers() {
            return this.resourcesChangeConsumers;
        }

        public List<Consumer<List<McpSchema.ResourceContents>>> resourcesUpdateConsumers() {
            return this.resourcesUpdateConsumers;
        }

        public Map<String, McpSchema.Root> roots() {
            return this.roots;
        }

        public Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> samplingHandler() {
            return this.samplingHandler;
        }

        public final String toString() {
            return b1.a(b(), Sync.class, "clientInfo;clientCapabilities;roots;toolsChangeConsumers;resourcesChangeConsumers;resourcesUpdateConsumers;promptsChangeConsumers;loggingConsumers;progressConsumers;samplingHandler;elicitationHandler;enableCallToolSchemaCaching");
        }

        public List<Consumer<List<McpSchema.Tool>>> toolsChangeConsumers() {
            return this.toolsChangeConsumers;
        }

        public Sync(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Consumer<List<McpSchema.Tool>>> list, List<Consumer<List<McpSchema.Resource>>> list2, List<Consumer<List<McpSchema.ResourceContents>>> list3, List<Consumer<List<McpSchema.Prompt>>> list4, List<Consumer<McpSchema.LoggingMessageNotification>> list5, Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> function, Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> function2) {
            this(implementation, clientCapabilities, map, list, list2, list3, list4, list5, Collections.EMPTY_LIST, function, function2, false);
        }
    }
}
