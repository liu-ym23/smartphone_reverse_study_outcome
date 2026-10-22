package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes2.dex */
class McpClientFeatures {

    public static final class Async extends B7.a {
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
                final int i = 5;
                arrayList.add(new Function() { // from class: io.modelcontextprotocol.client.v
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i6 = i;
                        Consumer consumer2 = consumer;
                        switch (i6) {
                            case 0:
                                return McpClientFeatures.Async.lambda$fromSync$3(consumer2, (List) obj);
                            case 1:
                                return McpClientFeatures.Async.lambda$fromSync$5(consumer2, (List) obj);
                            case 2:
                                return McpClientFeatures.Async.lambda$fromSync$7(consumer2, (List) obj);
                            case 3:
                                return McpClientFeatures.Async.lambda$fromSync$9(consumer2, (McpSchema.LoggingMessageNotification) obj);
                            case 4:
                                return McpClientFeatures.Async.lambda$fromSync$11(consumer2, (McpSchema.ProgressNotification) obj);
                            default:
                                return McpClientFeatures.Async.lambda$fromSync$1(consumer2, (List) obj);
                        }
                    }
                });
            }
            ArrayList arrayList2 = new ArrayList();
            for (final Consumer<List<McpSchema.Resource>> consumer2 : sync.resourcesChangeConsumers()) {
                final int i6 = 0;
                arrayList2.add(new Function() { // from class: io.modelcontextprotocol.client.v
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i62 = i6;
                        Consumer consumer22 = consumer2;
                        switch (i62) {
                            case 0:
                                return McpClientFeatures.Async.lambda$fromSync$3(consumer22, (List) obj);
                            case 1:
                                return McpClientFeatures.Async.lambda$fromSync$5(consumer22, (List) obj);
                            case 2:
                                return McpClientFeatures.Async.lambda$fromSync$7(consumer22, (List) obj);
                            case 3:
                                return McpClientFeatures.Async.lambda$fromSync$9(consumer22, (McpSchema.LoggingMessageNotification) obj);
                            case 4:
                                return McpClientFeatures.Async.lambda$fromSync$11(consumer22, (McpSchema.ProgressNotification) obj);
                            default:
                                return McpClientFeatures.Async.lambda$fromSync$1(consumer22, (List) obj);
                        }
                    }
                });
            }
            ArrayList arrayList3 = new ArrayList();
            for (final Consumer<List<McpSchema.ResourceContents>> consumer3 : sync.resourcesUpdateConsumers()) {
                final int i10 = 1;
                arrayList3.add(new Function() { // from class: io.modelcontextprotocol.client.v
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i62 = i10;
                        Consumer consumer22 = consumer3;
                        switch (i62) {
                            case 0:
                                return McpClientFeatures.Async.lambda$fromSync$3(consumer22, (List) obj);
                            case 1:
                                return McpClientFeatures.Async.lambda$fromSync$5(consumer22, (List) obj);
                            case 2:
                                return McpClientFeatures.Async.lambda$fromSync$7(consumer22, (List) obj);
                            case 3:
                                return McpClientFeatures.Async.lambda$fromSync$9(consumer22, (McpSchema.LoggingMessageNotification) obj);
                            case 4:
                                return McpClientFeatures.Async.lambda$fromSync$11(consumer22, (McpSchema.ProgressNotification) obj);
                            default:
                                return McpClientFeatures.Async.lambda$fromSync$1(consumer22, (List) obj);
                        }
                    }
                });
            }
            ArrayList arrayList4 = new ArrayList();
            for (final Consumer<List<McpSchema.Prompt>> consumer4 : sync.promptsChangeConsumers()) {
                final int i11 = 2;
                arrayList4.add(new Function() { // from class: io.modelcontextprotocol.client.v
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i62 = i11;
                        Consumer consumer22 = consumer4;
                        switch (i62) {
                            case 0:
                                return McpClientFeatures.Async.lambda$fromSync$3(consumer22, (List) obj);
                            case 1:
                                return McpClientFeatures.Async.lambda$fromSync$5(consumer22, (List) obj);
                            case 2:
                                return McpClientFeatures.Async.lambda$fromSync$7(consumer22, (List) obj);
                            case 3:
                                return McpClientFeatures.Async.lambda$fromSync$9(consumer22, (McpSchema.LoggingMessageNotification) obj);
                            case 4:
                                return McpClientFeatures.Async.lambda$fromSync$11(consumer22, (McpSchema.ProgressNotification) obj);
                            default:
                                return McpClientFeatures.Async.lambda$fromSync$1(consumer22, (List) obj);
                        }
                    }
                });
            }
            ArrayList arrayList5 = new ArrayList();
            for (final Consumer<McpSchema.LoggingMessageNotification> consumer5 : sync.loggingConsumers()) {
                final int i12 = 3;
                arrayList5.add(new Function() { // from class: io.modelcontextprotocol.client.v
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i62 = i12;
                        Consumer consumer22 = consumer5;
                        switch (i62) {
                            case 0:
                                return McpClientFeatures.Async.lambda$fromSync$3(consumer22, (List) obj);
                            case 1:
                                return McpClientFeatures.Async.lambda$fromSync$5(consumer22, (List) obj);
                            case 2:
                                return McpClientFeatures.Async.lambda$fromSync$7(consumer22, (List) obj);
                            case 3:
                                return McpClientFeatures.Async.lambda$fromSync$9(consumer22, (McpSchema.LoggingMessageNotification) obj);
                            case 4:
                                return McpClientFeatures.Async.lambda$fromSync$11(consumer22, (McpSchema.ProgressNotification) obj);
                            default:
                                return McpClientFeatures.Async.lambda$fromSync$1(consumer22, (List) obj);
                        }
                    }
                });
            }
            ArrayList arrayList6 = new ArrayList();
            for (final Consumer<McpSchema.ProgressNotification> consumer6 : sync.progressConsumers()) {
                final int i13 = 4;
                arrayList6.add(new Function() { // from class: io.modelcontextprotocol.client.v
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i62 = i13;
                        Consumer consumer22 = consumer6;
                        switch (i62) {
                            case 0:
                                return McpClientFeatures.Async.lambda$fromSync$3(consumer22, (List) obj);
                            case 1:
                                return McpClientFeatures.Async.lambda$fromSync$5(consumer22, (List) obj);
                            case 2:
                                return McpClientFeatures.Async.lambda$fromSync$7(consumer22, (List) obj);
                            case 3:
                                return McpClientFeatures.Async.lambda$fromSync$9(consumer22, (McpSchema.LoggingMessageNotification) obj);
                            case 4:
                                return McpClientFeatures.Async.lambda$fromSync$11(consumer22, (McpSchema.ProgressNotification) obj);
                            default:
                                return McpClientFeatures.Async.lambda$fromSync$1(consumer22, (List) obj);
                        }
                    }
                });
            }
            final int i14 = 0;
            Function function = new Function() { // from class: io.modelcontextprotocol.client.w
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i15 = i14;
                    McpClientFeatures.Sync sync2 = sync;
                    switch (i15) {
                        case 0:
                            return McpClientFeatures.Async.lambda$fromSync$13(sync2, (McpSchema.CreateMessageRequest) obj);
                        default:
                            return McpClientFeatures.Async.lambda$fromSync$15(sync2, (McpSchema.ElicitRequest) obj);
                    }
                }
            };
            final int i15 = 1;
            return new Async(sync.clientInfo(), sync.clientCapabilities(), sync.roots(), arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, function, new Function() { // from class: io.modelcontextprotocol.client.w
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i152 = i15;
                    McpClientFeatures.Sync sync2 = sync;
                    switch (i152) {
                        case 0:
                            return McpClientFeatures.Async.lambda$fromSync$13(sync2, (McpSchema.CreateMessageRequest) obj);
                        default:
                            return McpClientFeatures.Async.lambda$fromSync$15(sync2, (McpSchema.ElicitRequest) obj);
                    }
                }
            }, sync.enableCallToolSchemaCaching);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(Consumer consumer, List list) {
            return Mono.fromRunnable(new x(consumer, list, 0)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$11(Consumer consumer, McpSchema.ProgressNotification progressNotification) {
            return Mono.fromRunnable(new y(consumer, progressNotification, 0)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CreateMessageResult lambda$fromSync$12(Sync sync, McpSchema.CreateMessageRequest createMessageRequest) throws Exception {
            return sync.samplingHandler().apply(createMessageRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$13(Sync sync, McpSchema.CreateMessageRequest createMessageRequest) {
            return Mono.fromCallable(new z(sync, createMessageRequest, 0)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.ElicitResult lambda$fromSync$14(Sync sync, McpSchema.ElicitRequest elicitRequest) throws Exception {
            return sync.elicitationHandler().apply(elicitRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$15(Sync sync, McpSchema.ElicitRequest elicitRequest) {
            return Mono.fromCallable(new z(sync, elicitRequest, 1)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$3(Consumer consumer, List list) {
            return Mono.fromRunnable(new x(consumer, list, 3)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$5(Consumer consumer, List list) {
            return Mono.fromRunnable(new x(consumer, list, 2)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$7(Consumer consumer, List list) {
            return Mono.fromRunnable(new x(consumer, list, 1)).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$9(Consumer consumer, McpSchema.LoggingMessageNotification loggingMessageNotification) {
            return Mono.fromRunnable(new y(consumer, loggingMessageNotification, 1)).subscribeOn(Schedulers.boundedElastic());
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
            if (!(obj instanceof Async)) {
                return false;
            }
            Async async = (Async) obj;
            return this.enableCallToolSchemaCaching == async.enableCallToolSchemaCaching && Objects.equals(this.clientInfo, async.clientInfo) && Objects.equals(this.clientCapabilities, async.clientCapabilities) && Objects.equals(this.roots, async.roots) && Objects.equals(this.toolsChangeConsumers, async.toolsChangeConsumers) && Objects.equals(this.resourcesChangeConsumers, async.resourcesChangeConsumers) && Objects.equals(this.resourcesUpdateConsumers, async.resourcesUpdateConsumers) && Objects.equals(this.promptsChangeConsumers, async.promptsChangeConsumers) && Objects.equals(this.loggingConsumers, async.loggingConsumers) && Objects.equals(this.progressConsumers, async.progressConsumers) && Objects.equals(this.samplingHandler, async.samplingHandler) && Objects.equals(this.elicitationHandler, async.elicitationHandler);
        }

        public final int hashCode() {
            boolean z10 = this.enableCallToolSchemaCaching;
            McpSchema.Implementation implementation = this.clientInfo;
            McpSchema.ClientCapabilities clientCapabilities = this.clientCapabilities;
            Map<String, McpSchema.Root> map = this.roots;
            List<Function<List<McpSchema.Tool>, Mono<Void>>> list = this.toolsChangeConsumers;
            List<Function<List<McpSchema.Resource>, Mono<Void>>> list2 = this.resourcesChangeConsumers;
            List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list3 = this.resourcesUpdateConsumers;
            List<Function<List<McpSchema.Prompt>, Mono<Void>>> list4 = this.promptsChangeConsumers;
            List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list5 = this.loggingConsumers;
            List<Function<McpSchema.ProgressNotification, Mono<Void>>> list6 = this.progressConsumers;
            Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> function = this.samplingHandler;
            Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> function2 = this.elicitationHandler;
            return Objects.hashCode(function2) + ((Objects.hashCode(function) + com.stepos.statsrpk.service.c.b(list6, com.stepos.statsrpk.service.c.b(list5, com.stepos.statsrpk.service.c.b(list4, com.stepos.statsrpk.service.c.b(list3, com.stepos.statsrpk.service.c.b(list2, com.stepos.statsrpk.service.c.b(list, com.stepos.statsrpk.service.c.c(map, (Objects.hashCode(clientCapabilities) + ((Objects.hashCode(implementation) + (Boolean.hashCode(z10) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31)) * 31);
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
            Object[] objArr = {this.clientInfo, this.clientCapabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler, Boolean.valueOf(this.enableCallToolSchemaCaching)};
            String[] strArrSplit = "clientInfo;clientCapabilities;roots;toolsChangeConsumers;resourcesChangeConsumers;resourcesUpdateConsumers;promptsChangeConsumers;loggingConsumers;progressConsumers;samplingHandler;elicitationHandler;enableCallToolSchemaCaching".length() == 0 ? new String[0] : "clientInfo;clientCapabilities;roots;toolsChangeConsumers;resourcesChangeConsumers;resourcesUpdateConsumers;promptsChangeConsumers;loggingConsumers;progressConsumers;samplingHandler;elicitationHandler;enableCallToolSchemaCaching".split(";");
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

        public List<Function<List<McpSchema.Tool>, Mono<Void>>> toolsChangeConsumers() {
            return this.toolsChangeConsumers;
        }

        public Async(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Function<List<McpSchema.Tool>, Mono<Void>>> list, List<Function<List<McpSchema.Resource>, Mono<Void>>> list2, List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list3, List<Function<List<McpSchema.Prompt>, Mono<Void>>> list4, List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list5, Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> function, Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> function2) {
            this(implementation, clientCapabilities, map, list, list2, list3, list4, list5, Collections.EMPTY_LIST, function, function2, false);
        }
    }

    public static final class Sync extends B7.a {
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
            if (!(obj instanceof Sync)) {
                return false;
            }
            Sync sync = (Sync) obj;
            return this.enableCallToolSchemaCaching == sync.enableCallToolSchemaCaching && Objects.equals(this.clientInfo, sync.clientInfo) && Objects.equals(this.clientCapabilities, sync.clientCapabilities) && Objects.equals(this.roots, sync.roots) && Objects.equals(this.toolsChangeConsumers, sync.toolsChangeConsumers) && Objects.equals(this.resourcesChangeConsumers, sync.resourcesChangeConsumers) && Objects.equals(this.resourcesUpdateConsumers, sync.resourcesUpdateConsumers) && Objects.equals(this.promptsChangeConsumers, sync.promptsChangeConsumers) && Objects.equals(this.loggingConsumers, sync.loggingConsumers) && Objects.equals(this.progressConsumers, sync.progressConsumers) && Objects.equals(this.samplingHandler, sync.samplingHandler) && Objects.equals(this.elicitationHandler, sync.elicitationHandler);
        }

        public final int hashCode() {
            boolean z10 = this.enableCallToolSchemaCaching;
            McpSchema.Implementation implementation = this.clientInfo;
            McpSchema.ClientCapabilities clientCapabilities = this.clientCapabilities;
            Map<String, McpSchema.Root> map = this.roots;
            List<Consumer<List<McpSchema.Tool>>> list = this.toolsChangeConsumers;
            List<Consumer<List<McpSchema.Resource>>> list2 = this.resourcesChangeConsumers;
            List<Consumer<List<McpSchema.ResourceContents>>> list3 = this.resourcesUpdateConsumers;
            List<Consumer<List<McpSchema.Prompt>>> list4 = this.promptsChangeConsumers;
            List<Consumer<McpSchema.LoggingMessageNotification>> list5 = this.loggingConsumers;
            List<Consumer<McpSchema.ProgressNotification>> list6 = this.progressConsumers;
            Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> function = this.samplingHandler;
            Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> function2 = this.elicitationHandler;
            return Objects.hashCode(function2) + ((Objects.hashCode(function) + com.stepos.statsrpk.service.c.b(list6, com.stepos.statsrpk.service.c.b(list5, com.stepos.statsrpk.service.c.b(list4, com.stepos.statsrpk.service.c.b(list3, com.stepos.statsrpk.service.c.b(list2, com.stepos.statsrpk.service.c.b(list, com.stepos.statsrpk.service.c.c(map, (Objects.hashCode(clientCapabilities) + ((Objects.hashCode(implementation) + (Boolean.hashCode(z10) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31)) * 31);
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
            Object[] objArr = {this.clientInfo, this.clientCapabilities, this.roots, this.toolsChangeConsumers, this.resourcesChangeConsumers, this.resourcesUpdateConsumers, this.promptsChangeConsumers, this.loggingConsumers, this.progressConsumers, this.samplingHandler, this.elicitationHandler, Boolean.valueOf(this.enableCallToolSchemaCaching)};
            String[] strArrSplit = "clientInfo;clientCapabilities;roots;toolsChangeConsumers;resourcesChangeConsumers;resourcesUpdateConsumers;promptsChangeConsumers;loggingConsumers;progressConsumers;samplingHandler;elicitationHandler;enableCallToolSchemaCaching".length() == 0 ? new String[0] : "clientInfo;clientCapabilities;roots;toolsChangeConsumers;resourcesChangeConsumers;resourcesUpdateConsumers;promptsChangeConsumers;loggingConsumers;progressConsumers;samplingHandler;elicitationHandler;enableCallToolSchemaCaching".split(";");
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

        public List<Consumer<List<McpSchema.Tool>>> toolsChangeConsumers() {
            return this.toolsChangeConsumers;
        }

        public Sync(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Consumer<List<McpSchema.Tool>>> list, List<Consumer<List<McpSchema.Resource>>> list2, List<Consumer<List<McpSchema.ResourceContents>>> list3, List<Consumer<List<McpSchema.Prompt>>> list4, List<Consumer<McpSchema.LoggingMessageNotification>> list5, Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> function, Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> function2) {
            this(implementation, clientCapabilities, map, list, list2, list3, list4, list5, Collections.EMPTY_LIST, function, function2, false);
        }
    }
}
