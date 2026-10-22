package io.modelcontextprotocol.client;

import io.modelcontextprotocol.client.LifecycleInitializer;
import io.modelcontextprotocol.client.McpClientFeatures;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.json.schema.JsonSchemaValidator;
import io.modelcontextprotocol.spec.McpClientSession;
import io.modelcontextprotocol.spec.McpClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.util.Assert;
import io.modelcontextprotocol.util.Utils;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.ContextView;

/* loaded from: classes4.dex */
public class McpAsyncClient {
    private final McpSchema.ClientCapabilities clientCapabilities;
    private final McpSchema.Implementation clientInfo;
    private Function<McpSchema.ElicitRequest, Mono<McpSchema.ElicitResult>> elicitationHandler;
    private final boolean enableCallToolSchemaCaching;
    private final LifecycleInitializer initializer;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ConcurrentHashMap<String, McpSchema.Root> roots;
    private Function<McpSchema.CreateMessageRequest, Mono<McpSchema.CreateMessageResult>> samplingHandler;
    private final ConcurrentHashMap<String, Map<String, Object>> toolsOutputSchemaCache;
    private final McpClientTransport transport;
    private static final vc.c logger = vc.e.l(McpAsyncClient.class);
    private static final TypeRef<Void> VOID_TYPE_REFERENCE = new TypeRef<Void>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.1
    };
    public static final TypeRef<Object> OBJECT_TYPE_REF = new TypeRef<Object>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.2
    };
    public static final TypeRef<McpSchema.PaginatedRequest> PAGINATED_REQUEST_TYPE_REF = new TypeRef<McpSchema.PaginatedRequest>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.3
    };
    public static final TypeRef<McpSchema.InitializeResult> INITIALIZE_RESULT_TYPE_REF = new TypeRef<McpSchema.InitializeResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.4
    };
    public static final TypeRef<McpSchema.CreateMessageRequest> CREATE_MESSAGE_REQUEST_TYPE_REF = new TypeRef<McpSchema.CreateMessageRequest>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.5
    };
    public static final TypeRef<McpSchema.LoggingMessageNotification> LOGGING_MESSAGE_NOTIFICATION_TYPE_REF = new TypeRef<McpSchema.LoggingMessageNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.6
    };
    public static final TypeRef<McpSchema.ProgressNotification> PROGRESS_NOTIFICATION_TYPE_REF = new TypeRef<McpSchema.ProgressNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.7
    };
    private static final TypeRef<McpSchema.CallToolResult> CALL_TOOL_RESULT_TYPE_REF = new TypeRef<McpSchema.CallToolResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.9
    };
    private static final TypeRef<McpSchema.ListToolsResult> LIST_TOOLS_RESULT_TYPE_REF = new TypeRef<McpSchema.ListToolsResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.10
    };
    private static final TypeRef<McpSchema.ListResourcesResult> LIST_RESOURCES_RESULT_TYPE_REF = new TypeRef<McpSchema.ListResourcesResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.11
    };
    private static final TypeRef<McpSchema.ReadResourceResult> READ_RESOURCE_RESULT_TYPE_REF = new TypeRef<McpSchema.ReadResourceResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.12
    };
    private static final TypeRef<McpSchema.ListResourceTemplatesResult> LIST_RESOURCE_TEMPLATES_RESULT_TYPE_REF = new TypeRef<McpSchema.ListResourceTemplatesResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.13
    };
    private static final TypeRef<McpSchema.ListPromptsResult> LIST_PROMPTS_RESULT_TYPE_REF = new TypeRef<McpSchema.ListPromptsResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.15
    };
    private static final TypeRef<McpSchema.GetPromptResult> GET_PROMPT_RESULT_TYPE_REF = new TypeRef<McpSchema.GetPromptResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.16
    };
    private static final TypeRef<McpSchema.CompleteResult> COMPLETION_COMPLETE_RESULT_TYPE_REF = new TypeRef<McpSchema.CompleteResult>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.17
    };

    public McpAsyncClient(final McpClientTransport mcpClientTransport, final Duration duration, Duration duration2, JsonSchemaValidator jsonSchemaValidator, McpClientFeatures.Async async) {
        Assert.notNull(mcpClientTransport, "Transport must not be null");
        Assert.notNull(duration, "Request timeout must not be null");
        Assert.notNull(duration2, "Initialization timeout must not be null");
        McpSchema.Implementation implementationClientInfo = async.clientInfo();
        this.clientInfo = implementationClientInfo;
        McpSchema.ClientCapabilities clientCapabilities = async.clientCapabilities();
        this.clientCapabilities = clientCapabilities;
        this.transport = mcpClientTransport;
        this.roots = new ConcurrentHashMap<>(async.roots());
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.toolsOutputSchemaCache = new ConcurrentHashMap<>();
        this.enableCallToolSchemaCaching = async.enableCallToolSchemaCaching();
        final HashMap map = new HashMap();
        map.put(McpSchema.METHOD_PING, new McpClientSession.RequestHandler() { // from class: io.modelcontextprotocol.client.K
            @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
            public final Mono handle(Object obj) {
                return McpAsyncClient.o0(obj);
            }
        });
        if (clientCapabilities.roots() != null) {
            map.put(McpSchema.METHOD_ROOTS_LIST, rootsListRequestHandler());
        }
        if (clientCapabilities.sampling() != null) {
            if (async.samplingHandler() == null) {
                throw new IllegalArgumentException("Sampling handler must not be null when client capabilities include sampling");
            }
            this.samplingHandler = async.samplingHandler();
            map.put(McpSchema.METHOD_SAMPLING_CREATE_MESSAGE, samplingCreateMessageHandler());
        }
        if (clientCapabilities.elicitation() != null) {
            if (async.elicitationHandler() == null) {
                throw new IllegalArgumentException("Elicitation handler must not be null when client capabilities include elicitation");
            }
            this.elicitationHandler = async.elicitationHandler();
            map.put(McpSchema.METHOD_ELICITATION_CREATE, elicitationCreateHandler());
        }
        final HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Function() { // from class: io.modelcontextprotocol.client.L
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.F
                    @Override // java.lang.Runnable
                    public final void run() {
                        McpAsyncClient.logger.t("Tools changed: {}", list);
                    }
                });
            }
        });
        if (!Utils.isEmpty(async.toolsChangeConsumers())) {
            arrayList.addAll(async.toolsChangeConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_TOOLS_LIST_CHANGED, asyncToolsChangeNotificationHandler(arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Function() { // from class: io.modelcontextprotocol.client.M
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        McpAsyncClient.logger.t("Resources changed: {}", list);
                    }
                });
            }
        });
        if (!Utils.isEmpty(async.resourcesChangeConsumers())) {
            arrayList2.addAll(async.resourcesChangeConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_RESOURCES_LIST_CHANGED, asyncResourcesChangeNotificationHandler(arrayList2));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new Function() { // from class: io.modelcontextprotocol.client.N
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        McpAsyncClient.logger.t("Resources updated: {}", list);
                    }
                });
            }
        });
        if (!Utils.isEmpty(async.resourcesUpdateConsumers())) {
            arrayList3.addAll(async.resourcesUpdateConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_RESOURCES_UPDATED, asyncResourcesUpdatedNotificationHandler(arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new Function() { // from class: io.modelcontextprotocol.client.O
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.i0
                    @Override // java.lang.Runnable
                    public final void run() {
                        McpAsyncClient.logger.t("Prompts changed: {}", list);
                    }
                });
            }
        });
        if (!Utils.isEmpty(async.promptsChangeConsumers())) {
            arrayList4.addAll(async.promptsChangeConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_PROMPTS_LIST_CHANGED, asyncPromptsChangeNotificationHandler(arrayList4));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new Function() { // from class: io.modelcontextprotocol.client.P
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.z0
                    @Override // java.lang.Runnable
                    public final void run() {
                        McpAsyncClient.logger.t("Logging: {}", loggingMessageNotification);
                    }
                });
            }
        });
        if (!Utils.isEmpty(async.loggingConsumers())) {
            arrayList5.addAll(async.loggingConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_MESSAGE, asyncLoggingNotificationHandler(arrayList5));
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new Function() { // from class: io.modelcontextprotocol.client.Q
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.client.E
                    @Override // java.lang.Runnable
                    public final void run() {
                        McpAsyncClient.logger.t("Progress: {}", progressNotification);
                    }
                });
            }
        });
        if (!Utils.isEmpty(async.progressConsumers())) {
            arrayList6.addAll(async.progressConsumers());
        }
        map2.put(McpSchema.METHOD_NOTIFICATION_PROGRESS, asyncProgressNotificationHandler(arrayList6));
        final LifecycleInitializer lifecycleInitializer = new LifecycleInitializer(clientCapabilities, implementationClientInfo, mcpClientTransport.protocolVersions(), duration2, new Function() { // from class: io.modelcontextprotocol.client.U
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.i0(duration, mcpClientTransport, map, map2, (ContextView) obj);
            }
        }, new Function() { // from class: io.modelcontextprotocol.client.T
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33561a.lambda$new$17((LifecycleInitializer.Initialization) obj);
            }
        });
        this.initializer = lifecycleInitializer;
        Objects.requireNonNull(lifecycleInitializer);
        mcpClientTransport.setExceptionHandler(new Consumer() { // from class: io.modelcontextprotocol.client.V
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                lifecycleInitializer.handleException((Throwable) obj);
            }
        });
    }

    public static /* synthetic */ McpSchema.ListToolsResult D(McpSchema.ListToolsResult listToolsResult, McpSchema.ListToolsResult listToolsResult2) {
        listToolsResult.tools().addAll(listToolsResult2.tools());
        return listToolsResult;
    }

    public static /* synthetic */ boolean E(McpSchema.Tool tool) {
        return tool.outputSchema() != null;
    }

    public static /* synthetic */ qc.b F(McpSchema.ReadResourceResult readResourceResult, Function function) {
        return (qc.b) function.apply(readResourceResult.contents());
    }

    public static /* synthetic */ qc.b H(McpSchema.LoggingMessageNotification loggingMessageNotification, Function function) {
        return (qc.b) function.apply(loggingMessageNotification);
    }

    public static /* synthetic */ qc.b N(Throwable th) {
        logger.error("Error handling resource update notification", th);
        return Mono.empty();
    }

    public static /* synthetic */ McpSchema.ListResourceTemplatesResult P(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult) {
        return new McpSchema.ListResourceTemplatesResult(Collections.unmodifiableList(listResourceTemplatesResult.resourceTemplates()), null);
    }

    public static /* synthetic */ qc.b S(Throwable th) {
        logger.error("Error handling resources list change notification", th);
        return Mono.empty();
    }

    public static /* synthetic */ McpSchema.ListResourcesResult U(McpSchema.ListResourcesResult listResourcesResult) {
        return new McpSchema.ListResourcesResult(Collections.unmodifiableList(listResourcesResult.resources()), null);
    }

    public static /* synthetic */ qc.b V(McpSchema.ProgressNotification progressNotification, Function function) {
        return (qc.b) function.apply(progressNotification);
    }

    public static /* synthetic */ McpSchema.ListResourceTemplatesResult X(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult, McpSchema.ListResourceTemplatesResult listResourceTemplatesResult2) {
        listResourceTemplatesResult.resourceTemplates().addAll(listResourceTemplatesResult2.resourceTemplates());
        return listResourceTemplatesResult;
    }

    private McpClientSession.NotificationHandler asyncLoggingNotificationHandler(final List<Function<McpSchema.LoggingMessageNotification, Mono<Void>>> list) {
        return new McpClientSession.NotificationHandler() { // from class: io.modelcontextprotocol.client.k0
            @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
            public final Mono handle(Object obj) {
                return this.f33606a.lambda$asyncLoggingNotificationHandler$69(list, obj);
            }
        };
    }

    private McpClientSession.NotificationHandler asyncProgressNotificationHandler(final List<Function<McpSchema.ProgressNotification, Mono<Void>>> list) {
        return new McpClientSession.NotificationHandler() { // from class: io.modelcontextprotocol.client.F0
            @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
            public final Mono handle(Object obj) {
                return this.f33539a.lambda$asyncProgressNotificationHandler$72(list, obj);
            }
        };
    }

    private McpClientSession.NotificationHandler asyncPromptsChangeNotificationHandler(final List<Function<List<McpSchema.Prompt>, Mono<Void>>> list) {
        return new McpClientSession.NotificationHandler() { // from class: io.modelcontextprotocol.client.J
            @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
            public final Mono handle(Object obj) {
                return this.f33546a.lambda$asyncPromptsChangeNotificationHandler$67(list, obj);
            }
        };
    }

    private McpClientSession.NotificationHandler asyncResourcesChangeNotificationHandler(final List<Function<List<McpSchema.Resource>, Mono<Void>>> list) {
        return new McpClientSession.NotificationHandler() { // from class: io.modelcontextprotocol.client.A
            @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
            public final Mono handle(Object obj) {
                return this.f33529a.lambda$asyncResourcesChangeNotificationHandler$54(list, obj);
            }
        };
    }

    private McpClientSession.NotificationHandler asyncResourcesUpdatedNotificationHandler(final List<Function<List<McpSchema.ResourceContents>, Mono<Void>>> list) {
        return new McpClientSession.NotificationHandler() { // from class: io.modelcontextprotocol.client.h0
            @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
            public final Mono handle(Object obj) {
                return this.f33597a.lambda$asyncResourcesUpdatedNotificationHandler$58(list, obj);
            }
        };
    }

    private McpClientSession.NotificationHandler asyncToolsChangeNotificationHandler(final List<Function<List<McpSchema.Tool>, Mono<Void>>> list) {
        return new McpClientSession.NotificationHandler() { // from class: io.modelcontextprotocol.client.q0
            @Override // io.modelcontextprotocol.spec.McpClientSession.NotificationHandler
            public final Mono handle(Object obj) {
                return this.f33617a.lambda$asyncToolsChangeNotificationHandler$39(list, obj);
            }
        };
    }

    public static /* synthetic */ boolean c(McpSchema.Tool tool) {
        return tool.outputSchema() != null;
    }

    private McpClientSession.RequestHandler<McpSchema.ElicitResult> elicitationCreateHandler() {
        return new McpClientSession.RequestHandler() { // from class: io.modelcontextprotocol.client.j0
            @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
            public final Mono handle(Object obj) {
                return this.f33603a.lambda$elicitationCreateHandler$26(obj);
            }
        };
    }

    public static /* synthetic */ qc.b g(Throwable th) {
        logger.error("Error handling tools list change notification", th);
        return Mono.empty();
    }

    public static /* synthetic */ McpSchema.ListResourcesResult g0(McpSchema.ListResourcesResult listResourcesResult, McpSchema.ListResourcesResult listResourcesResult2) {
        listResourcesResult.resources().addAll(listResourcesResult2.resources());
        return listResourcesResult;
    }

    public static /* synthetic */ Mono i(String str, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? Mono.error(new IllegalStateException("Server does not provide the resources capability")) : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_TEMPLATES_LIST, new McpSchema.PaginatedRequest(str), LIST_RESOURCE_TEMPLATES_RESULT_TYPE_REF);
    }

    public static /* synthetic */ McpClientSession i0(Duration duration, McpClientTransport mcpClientTransport, Map map, Map map2, final ContextView contextView) {
        return new McpClientSession(duration, mcpClientTransport, map, map2, new Function() { // from class: io.modelcontextprotocol.client.B0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Mono) obj).contextWrite(contextView);
            }
        });
    }

    public static /* synthetic */ qc.b j0(McpSchema.ListResourcesResult listResourcesResult, Function function) {
        return (qc.b) function.apply(listResourcesResult.resources());
    }

    public static /* synthetic */ qc.b k(Throwable th) {
        logger.error("Error handling prompts list change notification", th);
        return Mono.empty();
    }

    public static /* synthetic */ McpSchema.ListToolsResult l(McpSchema.ListToolsResult listToolsResult) {
        return new McpSchema.ListToolsResult(Collections.unmodifiableList(listToolsResult.tools()), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncLoggingNotificationHandler$69(List list, Object obj) {
        final McpSchema.LoggingMessageNotification loggingMessageNotification = (McpSchema.LoggingMessageNotification) this.transport.unmarshalFrom(obj, LOGGING_MESSAGE_NOTIFICATION_TYPE_REF);
        return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.client.z
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return McpAsyncClient.H(loggingMessageNotification, (Function) obj2);
            }
        }).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncProgressNotificationHandler$72(List list, Object obj) {
        final McpSchema.ProgressNotification progressNotification = (McpSchema.ProgressNotification) this.transport.unmarshalFrom(obj, PROGRESS_NOTIFICATION_TYPE_REF);
        return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.client.W
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return McpAsyncClient.V(progressNotification, (Function) obj2);
            }
        }).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncPromptsChangeNotificationHandler$67(final List list, Object obj) {
        return listPrompts().flatMap(new Function() { // from class: io.modelcontextprotocol.client.G
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.client.b0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.v0(listPromptsResult, (Function) obj3);
                    }
                }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.client.c0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.k((Throwable) obj3);
                    }
                }).then();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncResourcesChangeNotificationHandler$54(final List list, Object obj) {
        return listResources().flatMap(new Function() { // from class: io.modelcontextprotocol.client.n
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.client.r0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.j0(listResourcesResult, (Function) obj3);
                    }
                }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.client.s0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.S((Throwable) obj3);
                    }
                }).then();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncResourcesUpdatedNotificationHandler$58(final List list, Object obj) {
        return readResource(new McpSchema.ReadResourceRequest(((McpSchema.ResourcesUpdatedNotification) this.transport.unmarshalFrom(obj, new TypeRef<McpSchema.ResourcesUpdatedNotification>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.14
        })).uri())).flatMap(new Function() { // from class: io.modelcontextprotocol.client.X
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.client.C
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.F(readResourceResult, (Function) obj3);
                    }
                }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.client.D
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.N((Throwable) obj3);
                    }
                }).then();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$asyncToolsChangeNotificationHandler$39(final List list, Object obj) {
        return listTools().flatMap(new Function() { // from class: io.modelcontextprotocol.client.y
            @Override // java.util.function.Function
            public final Object apply(Object obj2) {
                return Flux.fromIterable(list).flatMap(new Function() { // from class: io.modelcontextprotocol.client.H0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.t(listToolsResult, (Function) obj3);
                    }
                }).onErrorResume(new Function() { // from class: io.modelcontextprotocol.client.l
                    @Override // java.util.function.Function
                    public final Object apply(Object obj3) {
                        return McpAsyncClient.g((Throwable) obj3);
                    }
                }).then();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$callTool$27(McpSchema.CallToolRequest callToolRequest, McpSchema.CallToolResult callToolResult) {
        return Mono.just(validateToolResult(callToolRequest.name(), callToolResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$callTool$28(final McpSchema.CallToolRequest callToolRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().tools() == null ? Mono.error(new IllegalStateException("Server does not provide tools capability")) : initialization.mcpSession().sendRequest(McpSchema.METHOD_TOOLS_CALL, callToolRequest, CALL_TOOL_RESULT_TYPE_REF).flatMap(new Function() { // from class: io.modelcontextprotocol.client.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33609a.lambda$callTool$27(callToolRequest, (McpSchema.CallToolResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$closeGracefully$20() {
        return this.initializer.closeGracefully().then(this.transport.closeGracefully());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$elicitationCreateHandler$26(Object obj) {
        return this.elicitationHandler.apply((McpSchema.ElicitRequest) this.transport.unmarshalFrom(obj, new TypeRef<McpSchema.ElicitRequest>() { // from class: io.modelcontextprotocol.client.McpAsyncClient.8
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$listPrompts$59(McpSchema.ListPromptsResult listPromptsResult) {
        return listPromptsResult.nextCursor() != null ? listPrompts(listPromptsResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$listResourceTemplates$45(McpSchema.ListResourceTemplatesResult listResourceTemplatesResult) {
        return listResourceTemplatesResult.nextCursor() != null ? listResourceTemplates(listResourceTemplatesResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$listResources$40(McpSchema.ListResourcesResult listResourcesResult) {
        return listResourcesResult.nextCursor() != null ? listResources(listResourcesResult.nextCursor()) : Mono.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ qc.b lambda$listTools$29(McpSchema.ListToolsResult listToolsResult) {
        String strNextCursor = listToolsResult.nextCursor();
        return (strNextCursor == null || strNextCursor.isEmpty()) ? Mono.empty() : listTools(strNextCursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listToolsInternal$34(McpSchema.Tool tool) {
        this.toolsOutputSchemaCache.put(tool.name(), tool.outputSchema());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listToolsInternal$35(McpSchema.ListToolsResult listToolsResult) {
        if (!this.enableCallToolSchemaCaching || listToolsResult.tools() == null) {
            return;
        }
        listToolsResult.tools().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.client.w
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return McpAsyncClient.c((McpSchema.Tool) obj);
            }
        }).forEach(new Consumer() { // from class: io.modelcontextprotocol.client.x
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33729a.lambda$listToolsInternal$34((McpSchema.Tool) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$15(McpSchema.Tool tool) {
        this.toolsOutputSchemaCache.put(tool.name(), tool.outputSchema());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$16(McpSchema.ListToolsResult listToolsResult) {
        listToolsResult.tools().forEach(new Consumer() { // from class: io.modelcontextprotocol.client.e0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                McpSchema.Tool tool = (McpSchema.Tool) obj;
                McpAsyncClient.logger.a("Tool {} schema: {}", tool.name(), tool.outputSchema());
            }
        });
        if (!this.enableCallToolSchemaCaching || listToolsResult.tools() == null) {
            return;
        }
        listToolsResult.tools().stream().filter(new Predicate() { // from class: io.modelcontextprotocol.client.f0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return McpAsyncClient.E((McpSchema.Tool) obj);
            }
        }).forEach(new Consumer() { // from class: io.modelcontextprotocol.client.g0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33593a.lambda$new$15((McpSchema.Tool) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$new$17(LifecycleInitializer.Initialization initialization) {
        return (initialization.initializeResult().capabilities().tools() == null || !this.enableCallToolSchemaCaching) ? Mono.empty() : lambda$listTools$32(initialization, McpSchema.FIRST_PAGE).doOnNext(new Consumer() { // from class: io.modelcontextprotocol.client.p0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33615a.lambda$new$16((McpSchema.ListToolsResult) obj);
            }
        }).then();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$rootsListRequestHandler$24(Object obj) {
        return Mono.just(new McpSchema.ListRootsResult(this.roots.values().stream().toList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Mono lambda$samplingCreateMessageHandler$25(Object obj) {
        return this.samplingHandler.apply((McpSchema.CreateMessageRequest) this.transport.unmarshalFrom(obj, CREATE_MESSAGE_REQUEST_TYPE_REF));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: listToolsInternal, reason: merged with bridge method [inline-methods] */
    public Mono<McpSchema.ListToolsResult> lambda$listTools$32(LifecycleInitializer.Initialization initialization, String str) {
        return initialization.initializeResult().capabilities().tools() == null ? Mono.error(new IllegalStateException("Server does not provide tools capability")) : initialization.mcpSession().sendRequest(McpSchema.METHOD_TOOLS_LIST, new McpSchema.PaginatedRequest(str), LIST_TOOLS_RESULT_TYPE_REF).doOnNext(new Consumer() { // from class: io.modelcontextprotocol.client.S
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f33558a.lambda$listToolsInternal$35((McpSchema.ListToolsResult) obj);
            }
        });
    }

    public static /* synthetic */ McpSchema.ListPromptsResult m(McpSchema.ListPromptsResult listPromptsResult) {
        return new McpSchema.ListPromptsResult(Collections.unmodifiableList(listPromptsResult.prompts()), null);
    }

    public static /* synthetic */ McpSchema.ListPromptsResult m0(McpSchema.ListPromptsResult listPromptsResult, McpSchema.ListPromptsResult listPromptsResult2) {
        listPromptsResult.prompts().addAll(listPromptsResult2.prompts());
        return listPromptsResult;
    }

    public static /* synthetic */ Mono o0(Object obj) {
        logger.t("Received ping: {}", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return Mono.just(Collections.EMPTY_MAP);
    }

    public static /* synthetic */ Mono q(String str, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? Mono.error(new IllegalStateException("Server does not provide the resources capability")) : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_LIST, new McpSchema.PaginatedRequest(str), LIST_RESOURCES_RESULT_TYPE_REF);
    }

    private McpClientSession.RequestHandler<McpSchema.ListRootsResult> rootsListRequestHandler() {
        return new McpClientSession.RequestHandler() { // from class: io.modelcontextprotocol.client.x0
            @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
            public final Mono handle(Object obj) {
                return this.f33730a.lambda$rootsListRequestHandler$24(obj);
            }
        };
    }

    public static /* synthetic */ Mono s(McpSchema.LoggingLevel loggingLevel, LifecycleInitializer.Initialization initialization) {
        if (initialization.initializeResult().capabilities().logging() == null) {
            return Mono.error(new IllegalStateException("Server's Logging capabilities are not enabled!"));
        }
        return initialization.mcpSession().sendRequest(McpSchema.METHOD_LOGGING_SET_LEVEL, new McpSchema.SetLevelRequest(loggingLevel), OBJECT_TYPE_REF).then();
    }

    private McpClientSession.RequestHandler<McpSchema.CreateMessageResult> samplingCreateMessageHandler() {
        return new McpClientSession.RequestHandler() { // from class: io.modelcontextprotocol.client.y0
            @Override // io.modelcontextprotocol.spec.McpClientSession.RequestHandler
            public final Mono handle(Object obj) {
                return this.f33732a.lambda$samplingCreateMessageHandler$25(obj);
            }
        };
    }

    public static /* synthetic */ qc.b t(McpSchema.ListToolsResult listToolsResult, Function function) {
        return (qc.b) function.apply(listToolsResult.tools());
    }

    public static /* synthetic */ Mono u(McpSchema.ReadResourceRequest readResourceRequest, LifecycleInitializer.Initialization initialization) {
        return initialization.initializeResult().capabilities().resources() == null ? Mono.error(new IllegalStateException("Server does not provide the resources capability")) : initialization.mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_READ, readResourceRequest, READ_RESOURCE_RESULT_TYPE_REF);
    }

    public static /* synthetic */ qc.b v0(McpSchema.ListPromptsResult listPromptsResult, Function function) {
        return (qc.b) function.apply(listPromptsResult.prompts());
    }

    private McpSchema.CallToolResult validateToolResult(String str, McpSchema.CallToolResult callToolResult) {
        if (!this.enableCallToolSchemaCaching || callToolResult == null || callToolResult.isError() == Boolean.TRUE) {
            return callToolResult;
        }
        Map<String, Object> map = this.toolsOutputSchemaCache.get(str);
        if (map == null) {
            logger.j("Calling a tool with no outputSchema is not expected to return result with structured content, but got: {}", callToolResult.structuredContent());
            return callToolResult;
        }
        JsonSchemaValidator.ValidationResponse validationResponseValidate = this.jsonSchemaValidator.validate(map, callToolResult.structuredContent());
        if (validationResponseValidate.valid()) {
            return callToolResult;
        }
        logger.j("Tool call result validation failed: {}", validationResponseValidate.errorMessage());
        throw new IllegalArgumentException("Tool call result validation failed: " + validationResponseValidate.errorMessage());
    }

    public Mono<Void> addRoot(McpSchema.Root root) {
        if (root == null) {
            return Mono.error(new IllegalArgumentException("Root must not be null"));
        }
        if (this.clientCapabilities.roots() == null) {
            return Mono.error(new IllegalStateException("Client must be configured with roots capabilities"));
        }
        if (this.roots.containsKey(root.uri())) {
            return Mono.error(new IllegalStateException("Root with uri '" + root.uri() + "' already exists"));
        }
        this.roots.put(root.uri(), root);
        vc.c cVar = logger;
        cVar.t("Added root: {}", root);
        if (this.clientCapabilities.roots().listChanged().booleanValue()) {
            if (isInitialized()) {
                return rootsListChangedNotification();
            }
            cVar.warn("Client is not initialized, ignore sending a roots list changed notification");
        }
        return Mono.empty();
    }

    public Mono<McpSchema.CallToolResult> callTool(final McpSchema.CallToolRequest callToolRequest) {
        return this.initializer.withInitialization("calling tool", new Function() { // from class: io.modelcontextprotocol.client.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33604a.lambda$callTool$28(callToolRequest, (LifecycleInitializer.Initialization) obj);
            }
        });
    }

    public void close() {
        this.initializer.close();
        this.transport.close();
    }

    public Mono<Void> closeGracefully() {
        return Mono.defer(new Supplier() { // from class: io.modelcontextprotocol.client.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f33590a.lambda$closeGracefully$20();
            }
        });
    }

    public Mono<McpSchema.CompleteResult> completeCompletion(final McpSchema.CompleteRequest completeRequest) {
        return this.initializer.withInitialization("complete completions", new Function() { // from class: io.modelcontextprotocol.client.G0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendRequest(McpSchema.METHOD_COMPLETION_COMPLETE, completeRequest, McpAsyncClient.COMPLETION_COMPLETE_RESULT_TYPE_REF);
            }
        });
    }

    public McpSchema.ClientCapabilities getClientCapabilities() {
        return this.clientCapabilities;
    }

    public McpSchema.Implementation getClientInfo() {
        return this.clientInfo;
    }

    public McpSchema.InitializeResult getCurrentInitializationResult() {
        return this.initializer.currentInitializationResult();
    }

    public Mono<McpSchema.GetPromptResult> getPrompt(final McpSchema.GetPromptRequest getPromptRequest) {
        return this.initializer.withInitialization("getting prompts", new Function() { // from class: io.modelcontextprotocol.client.q
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendRequest(McpSchema.METHOD_PROMPT_GET, getPromptRequest, McpAsyncClient.GET_PROMPT_RESULT_TYPE_REF);
            }
        });
    }

    public McpSchema.ServerCapabilities getServerCapabilities() {
        McpSchema.InitializeResult initializeResultCurrentInitializationResult = this.initializer.currentInitializationResult();
        if (initializeResultCurrentInitializationResult != null) {
            return initializeResultCurrentInitializationResult.capabilities();
        }
        return null;
    }

    public McpSchema.Implementation getServerInfo() {
        McpSchema.InitializeResult initializeResultCurrentInitializationResult = this.initializer.currentInitializationResult();
        if (initializeResultCurrentInitializationResult != null) {
            return initializeResultCurrentInitializationResult.serverInfo();
        }
        return null;
    }

    public String getServerInstructions() {
        McpSchema.InitializeResult initializeResultCurrentInitializationResult = this.initializer.currentInitializationResult();
        if (initializeResultCurrentInitializationResult != null) {
            return initializeResultCurrentInitializationResult.instructions();
        }
        return null;
    }

    public Mono<McpSchema.InitializeResult> initialize() {
        return this.initializer.withInitialization("by explicit API call", new Function() { // from class: io.modelcontextprotocol.client.E0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Mono.just(((LifecycleInitializer.Initialization) obj).initializeResult());
            }
        });
    }

    public boolean isInitialized() {
        return this.initializer.isInitialized();
    }

    public Mono<McpSchema.ListPromptsResult> listPrompts() {
        return listPrompts(McpSchema.FIRST_PAGE).expand(new Function() { // from class: io.modelcontextprotocol.client.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33619a.lambda$listPrompts$59((McpSchema.ListPromptsResult) obj);
            }
        }).reduce(new McpSchema.ListPromptsResult(new ArrayList(), null), new BiFunction() { // from class: io.modelcontextprotocol.client.s
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return McpAsyncClient.m0((McpSchema.ListPromptsResult) obj, (McpSchema.ListPromptsResult) obj2);
            }
        }).map(new Function() { // from class: io.modelcontextprotocol.client.t
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.m((McpSchema.ListPromptsResult) obj);
            }
        });
    }

    public Mono<McpSchema.ListResourceTemplatesResult> listResourceTemplates() {
        return listResourceTemplates(McpSchema.FIRST_PAGE).expand(new Function() { // from class: io.modelcontextprotocol.client.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33608a.lambda$listResourceTemplates$45((McpSchema.ListResourceTemplatesResult) obj);
            }
        }).reduce(new McpSchema.ListResourceTemplatesResult(new ArrayList(), null), new BiFunction() { // from class: io.modelcontextprotocol.client.m0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return McpAsyncClient.X((McpSchema.ListResourceTemplatesResult) obj, (McpSchema.ListResourceTemplatesResult) obj2);
            }
        }).map(new Function() { // from class: io.modelcontextprotocol.client.n0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.P((McpSchema.ListResourceTemplatesResult) obj);
            }
        });
    }

    public Mono<McpSchema.ListResourcesResult> listResources() {
        return listResources(McpSchema.FIRST_PAGE).expand(new Function() { // from class: io.modelcontextprotocol.client.u0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33727a.lambda$listResources$40((McpSchema.ListResourcesResult) obj);
            }
        }).reduce(new McpSchema.ListResourcesResult(new ArrayList(), null), new BiFunction() { // from class: io.modelcontextprotocol.client.v0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return McpAsyncClient.g0((McpSchema.ListResourcesResult) obj, (McpSchema.ListResourcesResult) obj2);
            }
        }).map(new Function() { // from class: io.modelcontextprotocol.client.w0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.U((McpSchema.ListResourcesResult) obj);
            }
        });
    }

    public Mono<McpSchema.ListToolsResult> listTools() {
        return listTools(McpSchema.FIRST_PAGE).expand(new Function() { // from class: io.modelcontextprotocol.client.Y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33579a.lambda$listTools$29((McpSchema.ListToolsResult) obj);
            }
        }).reduce(new McpSchema.ListToolsResult(new ArrayList(), null), new BiFunction() { // from class: io.modelcontextprotocol.client.Z
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return McpAsyncClient.D((McpSchema.ListToolsResult) obj, (McpSchema.ListToolsResult) obj2);
            }
        }).map(new Function() { // from class: io.modelcontextprotocol.client.a0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.l((McpSchema.ListToolsResult) obj);
            }
        });
    }

    public Mono<Object> ping() {
        return this.initializer.withInitialization("pinging the server", new Function() { // from class: io.modelcontextprotocol.client.u
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendRequest(McpSchema.METHOD_PING, null, McpAsyncClient.OBJECT_TYPE_REF);
            }
        });
    }

    public Mono<McpSchema.ReadResourceResult> readResource(McpSchema.Resource resource) {
        return readResource(new McpSchema.ReadResourceRequest(resource.uri()));
    }

    public Mono<Void> removeRoot(String str) {
        if (str == null) {
            return Mono.error(new IllegalArgumentException("Root uri must not be null"));
        }
        if (this.clientCapabilities.roots() == null) {
            return Mono.error(new IllegalStateException("Client must be configured with roots capabilities"));
        }
        if (this.roots.remove(str) == null) {
            return Mono.error(new IllegalStateException("Root with uri '" + str + "' not found"));
        }
        vc.c cVar = logger;
        cVar.t("Removed Root: {}", str);
        if (this.clientCapabilities.roots().listChanged().booleanValue()) {
            if (isInitialized()) {
                return rootsListChangedNotification();
            }
            cVar.warn("Client is not initialized, ignore sending a roots list changed notification");
        }
        return Mono.empty();
    }

    public Mono<Void> rootsListChangedNotification() {
        return this.initializer.withInitialization("sending roots list changed notification", new Function() { // from class: io.modelcontextprotocol.client.D0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendNotification(McpSchema.METHOD_NOTIFICATION_ROOTS_LIST_CHANGED);
            }
        });
    }

    public Mono<Void> setLoggingLevel(final McpSchema.LoggingLevel loggingLevel) {
        return loggingLevel == null ? Mono.error(new IllegalArgumentException("Logging level must not be null")) : this.initializer.withInitialization("setting logging level", new Function() { // from class: io.modelcontextprotocol.client.C0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.s(loggingLevel, (LifecycleInitializer.Initialization) obj);
            }
        });
    }

    public void setProtocolVersions(List<String> list) {
        this.initializer.setProtocolVersions(list);
    }

    public Mono<Void> subscribeResource(final McpSchema.SubscribeRequest subscribeRequest) {
        return this.initializer.withInitialization("subscribing to resources", new Function() { // from class: io.modelcontextprotocol.client.p
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_SUBSCRIBE, subscribeRequest, McpAsyncClient.VOID_TYPE_REFERENCE);
            }
        });
    }

    public Mono<Void> unsubscribeResource(final McpSchema.UnsubscribeRequest unsubscribeRequest) {
        return this.initializer.withInitialization("unsubscribing from resources", new Function() { // from class: io.modelcontextprotocol.client.I
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendRequest(McpSchema.METHOD_RESOURCES_UNSUBSCRIBE, unsubscribeRequest, McpAsyncClient.VOID_TYPE_REFERENCE);
            }
        });
    }

    public Mono<McpSchema.ReadResourceResult> readResource(final McpSchema.ReadResourceRequest readResourceRequest) {
        return this.initializer.withInitialization("reading resources", new Function() { // from class: io.modelcontextprotocol.client.o0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.u(readResourceRequest, (LifecycleInitializer.Initialization) obj);
            }
        });
    }

    public Mono<McpSchema.ListToolsResult> listTools(final String str) {
        return this.initializer.withInitialization("listing tools", new Function() { // from class: io.modelcontextprotocol.client.A0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f33531a.lambda$listTools$32(str, (LifecycleInitializer.Initialization) obj);
            }
        });
    }

    public Mono<McpSchema.ListPromptsResult> listPrompts(final String str) {
        return this.initializer.withInitialization("listing prompts", new Function() { // from class: io.modelcontextprotocol.client.B
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((LifecycleInitializer.Initialization) obj).mcpSession().sendRequest(McpSchema.METHOD_PROMPT_LIST, new McpSchema.PaginatedRequest(str), McpAsyncClient.LIST_PROMPTS_RESULT_TYPE_REF);
            }
        });
    }

    public Mono<McpSchema.ListResourceTemplatesResult> listResourceTemplates(final String str) {
        return this.initializer.withInitialization("listing resource templates", new Function() { // from class: io.modelcontextprotocol.client.H
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.i(str, (LifecycleInitializer.Initialization) obj);
            }
        });
    }

    public Mono<McpSchema.ListResourcesResult> listResources(final String str) {
        return this.initializer.withInitialization("listing resources", new Function() { // from class: io.modelcontextprotocol.client.v
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return McpAsyncClient.q(str, (LifecycleInitializer.Initialization) obj);
            }
        });
    }
}
