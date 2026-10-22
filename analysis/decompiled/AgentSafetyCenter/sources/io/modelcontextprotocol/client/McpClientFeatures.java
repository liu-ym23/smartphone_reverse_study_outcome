package io.modelcontextprotocol.client;

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
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class McpClientFeatures {

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Async extends androidx.activity.b {
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

        public static Async fromSync(Sync sync) {
            int i;
            int i3;
            ArrayList arrayList = new ArrayList();
            for (Consumer<List<McpSchema.Tool>> consumer : sync.toolsChangeConsumers()) {
                v vVar = new v(4);
                vVar.f6220b = consumer;
                VarHandle.storeStoreFence();
                arrayList.add(vVar);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Consumer<List<McpSchema.Resource>> consumer2 : sync.resourcesChangeConsumers()) {
                v vVar2 = new v(5);
                vVar2.f6220b = consumer2;
                VarHandle.storeStoreFence();
                arrayList2.add(vVar2);
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<Consumer<List<McpSchema.ResourceContents>>> it = sync.resourcesUpdateConsumers().iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                Consumer<List<McpSchema.ResourceContents>> next = it.next();
                v vVar3 = new v(i);
                vVar3.f6220b = next;
                VarHandle.storeStoreFence();
                arrayList3.add(vVar3);
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator<Consumer<List<McpSchema.Prompt>>> it2 = sync.promptsChangeConsumers().iterator();
            while (true) {
                i3 = 1;
                if (!it2.hasNext()) {
                    break;
                }
                Consumer<List<McpSchema.Prompt>> next2 = it2.next();
                v vVar4 = new v(i3);
                vVar4.f6220b = next2;
                VarHandle.storeStoreFence();
                arrayList4.add(vVar4);
            }
            ArrayList arrayList5 = new ArrayList();
            for (Consumer<McpSchema.LoggingMessageNotification> consumer3 : sync.loggingConsumers()) {
                v vVar5 = new v(2);
                vVar5.f6220b = consumer3;
                VarHandle.storeStoreFence();
                arrayList5.add(vVar5);
            }
            ArrayList arrayList6 = new ArrayList();
            for (Consumer<McpSchema.ProgressNotification> consumer4 : sync.progressConsumers()) {
                v vVar6 = new v(3);
                vVar6.f6220b = consumer4;
                VarHandle.storeStoreFence();
                arrayList6.add(vVar6);
            }
            w wVar = new w(i);
            wVar.f6222b = sync;
            VarHandle.storeStoreFence();
            w wVar2 = new w(i3);
            wVar2.f6222b = sync;
            VarHandle.storeStoreFence();
            return new Async(sync.clientInfo(), sync.clientCapabilities(), sync.roots(), arrayList, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, wVar, wVar2, sync.enableCallToolSchemaCaching);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$1(Consumer consumer, List list) {
            x xVar = new x(0);
            xVar.f6224f = consumer;
            xVar.f6225g = list;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(xVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$11(Consumer consumer, McpSchema.ProgressNotification progressNotification) {
            y yVar = new y(0);
            yVar.f6227f = consumer;
            yVar.f6228g = progressNotification;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(yVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.CreateMessageResult lambda$fromSync$12(Sync sync, McpSchema.CreateMessageRequest createMessageRequest) {
            return sync.samplingHandler().apply(createMessageRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$13(Sync sync, McpSchema.CreateMessageRequest createMessageRequest) {
            z zVar = new z(0);
            zVar.f6230f = sync;
            zVar.f6231g = createMessageRequest;
            VarHandle.storeStoreFence();
            return Mono.fromCallable(zVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ McpSchema.ElicitResult lambda$fromSync$14(Sync sync, McpSchema.ElicitRequest elicitRequest) {
            return sync.elicitationHandler().apply(elicitRequest);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$15(Sync sync, McpSchema.ElicitRequest elicitRequest) {
            z zVar = new z(1);
            zVar.f6230f = sync;
            zVar.f6231g = elicitRequest;
            VarHandle.storeStoreFence();
            return Mono.fromCallable(zVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$3(Consumer consumer, List list) {
            x xVar = new x(3);
            xVar.f6224f = consumer;
            xVar.f6225g = list;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(xVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$5(Consumer consumer, List list) {
            x xVar = new x(2);
            xVar.f6224f = consumer;
            xVar.f6225g = list;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(xVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$7(Consumer consumer, List list) {
            x xVar = new x(1);
            xVar.f6224f = consumer;
            xVar.f6225g = list;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(xVar).subscribeOn(Schedulers.boundedElastic());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Mono lambda$fromSync$9(Consumer consumer, McpSchema.LoggingMessageNotification loggingMessageNotification) {
            y yVar = new y(1);
            yVar.f6227f = consumer;
            yVar.f6228g = loggingMessageNotification;
            VarHandle.storeStoreFence();
            return Mono.fromRunnable(yVar).subscribeOn(Schedulers.boundedElastic());
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
            return Objects.hashCode(function2) + ((Objects.hashCode(function) + androidx.activity.b.x(list6, androidx.activity.b.x(list5, androidx.activity.b.x(list4, androidx.activity.b.x(list3, androidx.activity.b.x(list2, androidx.activity.b.x(list, androidx.activity.b.f(map, (Objects.hashCode(clientCapabilities) + ((Objects.hashCode(implementation) + (Boolean.hashCode(z10) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31)) * 31);
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

        public List<Function<List<McpSchema.Tool>, Mono<Void>>> toolsChangeConsumers() {
            return this.toolsChangeConsumers;
        }

        public Async(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Function<List<McpSchema.Tool>, Mono<Void>>> list, List<Function<List<McpSchema.Resource>, Mono<Void>>> list2, List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list3, List<Function<List<McpSchema.Prompt>, Mono<Void>>> list4, List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list5, Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> function, Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> function2) {
            this(implementation, clientCapabilities, map, list, list2, list3, list4, list5, Collections.EMPTY_LIST, function, function2, false);
        }
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Sync extends androidx.activity.b {
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
            return Objects.hashCode(function2) + ((Objects.hashCode(function) + androidx.activity.b.x(list6, androidx.activity.b.x(list5, androidx.activity.b.x(list4, androidx.activity.b.x(list3, androidx.activity.b.x(list2, androidx.activity.b.x(list, androidx.activity.b.f(map, (Objects.hashCode(clientCapabilities) + ((Objects.hashCode(implementation) + (Boolean.hashCode(z10) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31)) * 31);
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

        public List<Consumer<List<McpSchema.Tool>>> toolsChangeConsumers() {
            return this.toolsChangeConsumers;
        }

        public Sync(McpSchema.Implementation implementation, McpSchema.ClientCapabilities clientCapabilities, Map<String, McpSchema.Root> map, List<Consumer<List<McpSchema.Tool>>> list, List<Consumer<List<McpSchema.Resource>>> list2, List<Consumer<List<McpSchema.ResourceContents>>> list3, List<Consumer<List<McpSchema.Prompt>>> list4, List<Consumer<McpSchema.LoggingMessageNotification>> list5, Function<McpSchema.CreateMessageRequest, McpSchema.CreateMessageResult> function, Function<McpSchema.ElicitRequest, McpSchema.ElicitResult> function2) {
            this(implementation, clientCapabilities, map, list, list2, list3, list4, list5, Collections.EMPTY_LIST, function, function2, false);
        }
    }
}
