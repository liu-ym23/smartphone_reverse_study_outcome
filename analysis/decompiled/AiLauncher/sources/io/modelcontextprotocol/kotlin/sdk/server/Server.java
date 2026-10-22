package io.modelcontextprotocol.kotlin.sdk.server;

import Ua.C1087w;
import Z8.C1173v;
import Z8.C1174w;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.CallToolRequest;
import io.modelcontextprotocol.kotlin.sdk.CallToolResult;
import io.modelcontextprotocol.kotlin.sdk.ClientCapabilities;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationRequest;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationResult;
import io.modelcontextprotocol.kotlin.sdk.CreateMessageRequest;
import io.modelcontextprotocol.kotlin.sdk.CreateMessageResult;
import io.modelcontextprotocol.kotlin.sdk.EmptyRequestResult;
import io.modelcontextprotocol.kotlin.sdk.GetPromptRequest;
import io.modelcontextprotocol.kotlin.sdk.GetPromptResult;
import io.modelcontextprotocol.kotlin.sdk.Implementation;
import io.modelcontextprotocol.kotlin.sdk.InitializeRequest;
import io.modelcontextprotocol.kotlin.sdk.InitializeResult;
import io.modelcontextprotocol.kotlin.sdk.InitializedNotification;
import io.modelcontextprotocol.kotlin.sdk.ListPromptsRequest;
import io.modelcontextprotocol.kotlin.sdk.ListPromptsResult;
import io.modelcontextprotocol.kotlin.sdk.ListResourceTemplatesRequest;
import io.modelcontextprotocol.kotlin.sdk.ListResourceTemplatesResult;
import io.modelcontextprotocol.kotlin.sdk.ListResourcesRequest;
import io.modelcontextprotocol.kotlin.sdk.ListResourcesResult;
import io.modelcontextprotocol.kotlin.sdk.ListRootsRequest;
import io.modelcontextprotocol.kotlin.sdk.ListRootsResult;
import io.modelcontextprotocol.kotlin.sdk.ListToolsRequest;
import io.modelcontextprotocol.kotlin.sdk.ListToolsResult;
import io.modelcontextprotocol.kotlin.sdk.LoggingMessageNotification;
import io.modelcontextprotocol.kotlin.sdk.Method;
import io.modelcontextprotocol.kotlin.sdk.PingRequest;
import io.modelcontextprotocol.kotlin.sdk.Prompt;
import io.modelcontextprotocol.kotlin.sdk.PromptArgument;
import io.modelcontextprotocol.kotlin.sdk.PromptListChangedNotification;
import io.modelcontextprotocol.kotlin.sdk.ReadResourceRequest;
import io.modelcontextprotocol.kotlin.sdk.ReadResourceResult;
import io.modelcontextprotocol.kotlin.sdk.RequestResult;
import io.modelcontextprotocol.kotlin.sdk.Resource;
import io.modelcontextprotocol.kotlin.sdk.ResourceListChangedNotification;
import io.modelcontextprotocol.kotlin.sdk.ResourceUpdatedNotification;
import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities;
import io.modelcontextprotocol.kotlin.sdk.Tool;
import io.modelcontextprotocol.kotlin.sdk.ToolAnnotations;
import io.modelcontextprotocol.kotlin.sdk.ToolListChangedNotification;
import io.modelcontextprotocol.kotlin.sdk.TypesKt;
import io.modelcontextprotocol.kotlin.sdk.Types_utilKt;
import io.modelcontextprotocol.kotlin.sdk.shared.Protocol;
import io.modelcontextprotocol.kotlin.sdk.shared.RequestHandlerExtra;
import io.modelcontextprotocol.kotlin.sdk.shared.RequestOptions;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0082@¢\u0006\u0004\b\u0015\u0010\u000fJ\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001b\u0010\u000fJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\u001cH\u0082@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\u0082@¢\u0006\u0004\b!\u0010\u000fJ\u001b\u0010%\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\u0004\b'\u0010&J\u000f\u0010'\u001a\u00020#H\u0016¢\u0006\u0004\b'\u0010(J9\u0010/\u001a\u00020#2\u0006\u0010*\u001a\u00020)2\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110,\u0012\u0006\u0012\u0004\u0018\u00010-0+¢\u0006\u0004\b/\u00100Jc\u0010/\u001a\u00020#2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\b\b\u0002\u00105\u001a\u0002042\n\b\u0002\u00107\u001a\u0004\u0018\u0001062\n\b\u0002\u00109\u001a\u0004\u0018\u0001082\"\u0010.\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110,\u0012\u0006\u0012\u0004\u0018\u00010-0+¢\u0006\u0004\b/\u0010:J\u001b\u0010>\u001a\u00020#2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\u00020@2\u0006\u00102\u001a\u000201¢\u0006\u0004\bA\u0010BJ\u001b\u0010E\u001a\u00020D2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002010;¢\u0006\u0004\bE\u0010FJ9\u0010J\u001a\u00020#2\u0006\u0010H\u001a\u00020G2\"\u0010I\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170,\u0012\u0006\u0012\u0004\u0018\u00010-0+¢\u0006\u0004\bJ\u0010KJW\u0010J\u001a\u00020#2\u0006\u00102\u001a\u0002012\n\b\u0002\u00103\u001a\u0004\u0018\u0001012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010;2\"\u0010I\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170,\u0012\u0006\u0012\u0004\u0018\u00010-0+¢\u0006\u0004\bJ\u0010NJ\u001b\u0010Q\u001a\u00020#2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020O0;¢\u0006\u0004\bQ\u0010?J\u0015\u0010R\u001a\u00020@2\u0006\u00102\u001a\u000201¢\u0006\u0004\bR\u0010BJ\u001b\u0010T\u001a\u00020D2\f\u0010S\u001a\b\u0012\u0004\u0012\u0002010;¢\u0006\u0004\bT\u0010FJS\u0010X\u001a\u00020#2\u0006\u0010U\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\b\b\u0002\u0010V\u001a\u0002012\"\u0010W\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0,\u0012\u0006\u0012\u0004\u0018\u00010-0+¢\u0006\u0004\bX\u0010YJ\u001b\u0010\\\u001a\u00020#2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020Z0;¢\u0006\u0004\b\\\u0010?J\u0015\u0010]\u001a\u00020@2\u0006\u0010U\u001a\u000201¢\u0006\u0004\b]\u0010BJ\u001b\u0010_\u001a\u00020D2\f\u0010^\u001a\b\u0012\u0004\u0012\u0002010;¢\u0006\u0004\b_\u0010FJ\u0010\u0010a\u001a\u00020`H\u0086@¢\u0006\u0004\ba\u0010\u000fJ$\u0010f\u001a\u00020e2\u0006\u0010c\u001a\u00020b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010dH\u0086@¢\u0006\u0004\bf\u0010gJ&\u0010j\u001a\u00020i2\b\b\u0002\u0010c\u001a\u00020h2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010dH\u0086@¢\u0006\u0004\bj\u0010kJ,\u0010p\u001a\u00020o2\u0006\u0010l\u001a\u0002012\u0006\u0010n\u001a\u00020m2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010dH\u0086@¢\u0006\u0004\bp\u0010qJ\u0018\u0010s\u001a\u00020#2\u0006\u0010c\u001a\u00020rH\u0086@¢\u0006\u0004\bs\u0010tJ\u0018\u0010v\u001a\u00020#2\u0006\u0010c\u001a\u00020uH\u0086@¢\u0006\u0004\bv\u0010wJ\u0010\u0010x\u001a\u00020#H\u0086@¢\u0006\u0004\bx\u0010\u000fJ\u0010\u0010y\u001a\u00020#H\u0086@¢\u0006\u0004\by\u0010\u000fJ\u0010\u0010z\u001a\u00020#H\u0086@¢\u0006\u0004\bz\u0010\u000fJ\u0017\u0010}\u001a\u00020#2\u0006\u0010|\u001a\u00020{H\u0014¢\u0006\u0004\b}\u0010~J\u0017\u0010\u007f\u001a\u00020#2\u0006\u0010|\u001a\u00020{H\u0014¢\u0006\u0004\b\u007f\u0010~J\u0019\u0010\u0080\u0001\u001a\u00020#2\u0006\u0010|\u001a\u00020{H\u0016¢\u0006\u0005\b\u0080\u0001\u0010~R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010\u0081\u0001R\u001f\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R0\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R.\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u0081\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R!\u0010\u0094\u0001\u001a\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020<0\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R!\u0010\u0096\u0001\u001a\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020O0\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0093\u0001R!\u0010\u0098\u0001\u001a\u000f\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020Z0\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0093\u0001¨\u0006\u0099\u0001"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/server/Server;", "Lio/modelcontextprotocol/kotlin/sdk/shared/Protocol;", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "serverInfo", "Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;", "options", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lio/modelcontextprotocol/kotlin/sdk/server/ServerOptions;)V", "Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;", "request", "Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;", "handleInitialize", "(Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListToolsResult;", "handleListTools", "(Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResult;", "handleCallTool", "(Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListPromptsResult;", "handleListPrompts", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult;", "handleGetPrompt", "(Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourcesResult;", "handleListResources", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceResult;", "handleReadResource", "(Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult;", "handleListResourceTemplates", "Lkotlin/Function0;", "LY8/t;", "block", "onInitialized", "(Lp9/a;)V", "onClose", "()V", "Lio/modelcontextprotocol/kotlin/sdk/Tool;", "tool", "Lkotlin/Function2;", "Le9/c;", "", "handler", "addTool", "(Lio/modelcontextprotocol/kotlin/sdk/Tool;Lp9/p;)V", "", "name", "description", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;", "inputSchema", "Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;", "outputSchema", "Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "toolAnnotations", "(Ljava/lang/String;Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/Tool$Input;Lio/modelcontextprotocol/kotlin/sdk/Tool$Output;Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;Lp9/p;)V", "", "Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredTool;", "toolsToAdd", "addTools", "(Ljava/util/List;)V", "", "removeTool", "(Ljava/lang/String;)Z", "toolNames", "", "removeTools", "(Ljava/util/List;)I", "Lio/modelcontextprotocol/kotlin/sdk/Prompt;", HighlightArgsBundle.KEY_PROMPT, "promptProvider", "addPrompt", "(Lio/modelcontextprotocol/kotlin/sdk/Prompt;Lp9/p;)V", "Lio/modelcontextprotocol/kotlin/sdk/PromptArgument;", "arguments", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lp9/p;)V", "Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredPrompt;", "promptsToAdd", "addPrompts", "removePrompt", "promptNames", "removePrompts", "uri", "mimeType", "readHandler", "addResource", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/p;)V", "Lio/modelcontextprotocol/kotlin/sdk/server/RegisteredResource;", "resourcesToAdd", "addResources", "removeResource", "uris", "removeResources", "Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult;", McpSchema.METHOD_PING, "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "params", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;", "createMessage", "(Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lqb/D;", "Lio/modelcontextprotocol/kotlin/sdk/ListRootsResult;", "listRoots", "(Lqb/D;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "message", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;", "requestedSchema", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "createElicitation", "(Ljava/lang/String;Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest$RequestedSchema;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "sendLoggingMessage", "(Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;", "sendResourceUpdated", "(Lio/modelcontextprotocol/kotlin/sdk/ResourceUpdatedNotification;Le9/c;)Ljava/lang/Object;", "sendResourceListChanged", "sendToolListChanged", "sendPromptListChanged", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "method", "assertCapabilityForMethod", "(Lio/modelcontextprotocol/kotlin/sdk/Method;)V", "assertNotificationCapability", "assertRequestHandlerCapability", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "_onInitialized", "Lp9/a;", "_onClose", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", UxipConstants.f30680s, "clientCapabilities", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "getClientCapabilities", "()Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "clientVersion", "getClientVersion", "()Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "capabilities", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "", "getTools", "()Ljava/util/Map;", "tools", "getPrompts", "prompts", "getResources", "resources", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class Server extends Protocol {
    private InterfaceC5063a<Y8.t> _onClose;
    private InterfaceC5063a<Y8.t> _onInitialized;
    private volatile /* synthetic */ Object _prompts;
    private volatile /* synthetic */ Object _resources;
    private volatile /* synthetic */ Object _tools;
    private final ServerCapabilities capabilities;
    private ClientCapabilities clientCapabilities;
    private Implementation clientVersion;
    private final Implementation serverInfo;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _tools$FU = AtomicReferenceFieldUpdater.newUpdater(Server.class, Object.class, "_tools");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _prompts$FU = AtomicReferenceFieldUpdater.newUpdater(Server.class, Object.class, "_prompts");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _resources$FU = AtomicReferenceFieldUpdater.newUpdater(Server.class, Object.class, "_resources");

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$10", f = "Server.kt", l = {154}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$10, reason: invalid class name */
    public static final class AnonymousClass10 extends SuspendLambda implements p9.q<ListResourceTemplatesRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        int label;

        public AnonymousClass10(InterfaceC4014c<? super AnonymousClass10> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ListResourceTemplatesRequest listResourceTemplatesRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            return Server.this.new AnonymousClass10(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.label = 1;
            Object objHandleListResourceTemplates = server.handleListResourceTemplates(this);
            return objHandleListResourceTemplates == objG ? objG : objHandleListResourceTemplates;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "request", "Lio/modelcontextprotocol/kotlin/sdk/InitializeRequest;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$2", f = "Server.kt", l = {118}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.q<InitializeRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(InitializeRequest initializeRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = Server.this.new AnonymousClass2(interfaceC4014c);
            anonymousClass2.L$0 = initializeRequest;
            return anonymousClass2.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InitializeRequest initializeRequest = (InitializeRequest) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.L$0 = g9.h.a(initializeRequest);
            this.label = 1;
            Object objHandleInitialize = server.handleInitialize(initializeRequest, this);
            return objHandleInitialize == objG ? objG : objHandleInitialize;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/ListToolsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$4", f = "Server.kt", l = {128}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.q<ListToolsRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        int label;

        public AnonymousClass4(InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ListToolsRequest listToolsRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            return Server.this.new AnonymousClass4(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.label = 1;
            Object objHandleListTools = server.handleListTools(this);
            return objHandleListTools == objG ? objG : objHandleListTools;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "request", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$5", f = "Server.kt", l = {131}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$5, reason: invalid class name */
    public static final class AnonymousClass5 extends SuspendLambda implements p9.q<CallToolRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass5(InterfaceC4014c<? super AnonymousClass5> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(CallToolRequest callToolRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            AnonymousClass5 anonymousClass5 = Server.this.new AnonymousClass5(interfaceC4014c);
            anonymousClass5.L$0 = callToolRequest;
            return anonymousClass5.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CallToolRequest callToolRequest = (CallToolRequest) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.L$0 = g9.h.a(callToolRequest);
            this.label = 1;
            Object objHandleCallTool = server.handleCallTool(callToolRequest, this);
            return objHandleCallTool == objG ? objG : objHandleCallTool;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/ListPromptsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$6", f = "Server.kt", l = {138}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$6, reason: invalid class name */
    public static final class AnonymousClass6 extends SuspendLambda implements p9.q<ListPromptsRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        int label;

        public AnonymousClass6(InterfaceC4014c<? super AnonymousClass6> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ListPromptsRequest listPromptsRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            return Server.this.new AnonymousClass6(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.label = 1;
            Object objHandleListPrompts = server.handleListPrompts(this);
            return objHandleListPrompts == objG ? objG : objHandleListPrompts;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "request", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$7", f = "Server.kt", l = {141}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$7, reason: invalid class name */
    public static final class AnonymousClass7 extends SuspendLambda implements p9.q<GetPromptRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass7(InterfaceC4014c<? super AnonymousClass7> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(GetPromptRequest getPromptRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            AnonymousClass7 anonymousClass7 = Server.this.new AnonymousClass7(interfaceC4014c);
            anonymousClass7.L$0 = getPromptRequest;
            return anonymousClass7.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            GetPromptRequest getPromptRequest = (GetPromptRequest) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.L$0 = g9.h.a(getPromptRequest);
            this.label = 1;
            Object objHandleGetPrompt = server.handleGetPrompt(getPromptRequest, this);
            return objHandleGetPrompt == objG ? objG : objHandleGetPrompt;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/ListResourcesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$8", f = "Server.kt", l = {148}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$8, reason: invalid class name */
    public static final class AnonymousClass8 extends SuspendLambda implements p9.q<ListResourcesRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        int label;

        public AnonymousClass8(InterfaceC4014c<? super AnonymousClass8> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ListResourcesRequest listResourcesRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            return Server.this.new AnonymousClass8(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.label = 1;
            Object objHandleListResources = server.handleListResources(this);
            return objHandleListResources == objG ? objG : objHandleListResources;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "request", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.server.Server$9", f = "Server.kt", l = {151}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.server.Server$9, reason: invalid class name */
    public static final class AnonymousClass9 extends SuspendLambda implements p9.q<ReadResourceRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass9(InterfaceC4014c<? super AnonymousClass9> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ReadResourceRequest readResourceRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            AnonymousClass9 anonymousClass9 = Server.this.new AnonymousClass9(interfaceC4014c);
            anonymousClass9.L$0 = readResourceRequest;
            return anonymousClass9.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReadResourceRequest readResourceRequest = (ReadResourceRequest) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            Server server = Server.this;
            this.L$0 = g9.h.a(readResourceRequest);
            this.label = 1;
            Object objHandleReadResource = server.handleReadResource(readResourceRequest, this);
            return objHandleReadResource == objG ? objG : objHandleReadResource;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Server(Implementation serverInfo, ServerOptions options) {
        super(options);
        kotlin.jvm.internal.p.i(serverInfo, "serverInfo");
        kotlin.jvm.internal.p.i(options, "options");
        this.serverInfo = serverInfo;
        this._onInitialized = new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.P
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Y8.t.f7040a;
            }
        };
        this._onClose = new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.Q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Y8.t.f7040a;
            }
        };
        ServerCapabilities capabilities = options.getCapabilities();
        this.capabilities = capabilities;
        this._tools = Pa.a.b();
        this._prompts = Pa.a.b();
        this._resources = Pa.a.b();
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.T
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server._init_$lambda$2(this.f33782a);
            }
        });
        setRequestHandler(kotlin.jvm.internal.t.m(InitializeRequest.class), Method.Defined.Initialize, new AnonymousClass2(null));
        setNotificationHandler(Method.Defined.NotificationsInitialized, new InterfaceC5074l() { // from class: io.modelcontextprotocol.kotlin.sdk.server.U
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Server._init_$lambda$3(this.f33783a, (InitializedNotification) obj);
            }
        });
        if (capabilities.getTools() != null) {
            setRequestHandler(kotlin.jvm.internal.t.m(ListToolsRequest.class), Method.Defined.ToolsList, new AnonymousClass4(null));
            setRequestHandler(kotlin.jvm.internal.t.m(CallToolRequest.class), Method.Defined.ToolsCall, new AnonymousClass5(null));
        }
        if (capabilities.getPrompts() != null) {
            setRequestHandler(kotlin.jvm.internal.t.m(ListPromptsRequest.class), Method.Defined.PromptsList, new AnonymousClass6(null));
            setRequestHandler(kotlin.jvm.internal.t.m(GetPromptRequest.class), Method.Defined.PromptsGet, new AnonymousClass7(null));
        }
        if (capabilities.getResources() != null) {
            setRequestHandler(kotlin.jvm.internal.t.m(ListResourcesRequest.class), Method.Defined.ResourcesList, new AnonymousClass8(null));
            setRequestHandler(kotlin.jvm.internal.t.m(ReadResourceRequest.class), Method.Defined.ResourcesRead, new AnonymousClass9(null));
            setRequestHandler(kotlin.jvm.internal.t.m(ListResourceTemplatesRequest.class), Method.Defined.ResourcesTemplatesList, new AnonymousClass10(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$2(Server server) {
        return "Initializing MCP server with capabilities: " + server.capabilities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Ua.Q _init_$lambda$3(Server server, InitializedNotification it) {
        kotlin.jvm.internal.p.i(it, "it");
        server._onInitialized.invoke();
        return C1087w.a(Y8.t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addPrompt$default(Server server, String str, String str2, List list, p9.p pVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPrompt");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            list = null;
        }
        server.addPrompt(str, str2, list, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addPrompt$lambda$23(Prompt prompt) {
        return "Failed to add prompt '" + prompt.getName() + "': Server does not support prompts capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addPrompt$lambda$24(Prompt prompt) {
        return "Registering prompt: " + prompt.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addPrompts$lambda$26() {
        return "Failed to add prompts: Server does not support prompts capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addPrompts$lambda$27(List list) {
        return "Registering " + list.size() + " prompts";
    }

    public static /* synthetic */ void addResource$default(Server server, String str, String str2, String str3, String str4, p9.p pVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addResource");
        }
        if ((i10 & 8) != 0) {
            str4 = "text/html";
        }
        server.addResource(str, str2, str3, str4, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addResource$lambda$39(String str) {
        return "Failed to add resource '" + str + "': Server does not support resources capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addResource$lambda$40(String str, String str2) {
        return "Registering resource: " + str + " (" + str2 + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addResources$lambda$42() {
        return "Failed to add resources: Server does not support resources capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addResources$lambda$43(List list) {
        return "Registering " + list.size() + " resources";
    }

    public static /* synthetic */ void addTool$default(Server server, String str, String str2, Tool.Input input, Tool.Output output, ToolAnnotations toolAnnotations, p9.p pVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addTool");
        }
        if ((i10 & 4) != 0) {
            input = new Tool.Input(null, null, 3, null);
        }
        server.addTool(str, str2, input, (i10 & 8) != 0 ? null : output, (i10 & 16) != 0 ? null : toolAnnotations, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addTool$lambda$7(Tool tool) {
        return "Failed to add tool '" + tool.getName() + "': Server does not support tools capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addTool$lambda$8(Tool tool) {
        return "Registering tool: " + tool.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addTools$lambda$10() {
        return "Failed to add tools: Server does not support tools capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addTools$lambda$11(List list) {
        return "Registering " + list.size() + " tools";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object assertCapabilityForMethod$lambda$80(Method method) {
        return "Asserting capability for method: " + method.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object assertCapabilityForMethod$lambda$81() {
        return "Client capability assertion failed: sampling not supported";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object assertNotificationCapability$lambda$82(Method method) {
        return "Asserting notification capability for method: " + method.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object assertNotificationCapability$lambda$83() {
        return "Server capability assertion failed: logging not supported";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object assertRequestHandlerCapability$lambda$84(Method method) {
        return "Asserting request handler capability for method: " + method.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object assertRequestHandlerCapability$lambda$85() {
        return "Server capability assertion failed: sampling not supported";
    }

    public static /* synthetic */ Object createElicitation$default(Server server, String str, CreateElicitationRequest.RequestedSchema requestedSchema, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createElicitation");
        }
        if ((i10 & 4) != 0) {
            requestOptions = null;
        }
        return server.createElicitation(str, requestedSchema, requestOptions, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createElicitation$lambda$57(String str) {
        return "Creating elicitation with message: " + str;
    }

    public static /* synthetic */ Object createMessage$default(Server server, CreateMessageRequest createMessageRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMessage");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return server.createMessage(createMessageRequest, requestOptions, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createMessage$lambda$55(CreateMessageRequest createMessageRequest) {
        return "Creating message with params: " + createMessageRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleCallTool(final CallToolRequest callToolRequest, InterfaceC4014c<? super CallToolResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.V
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleCallTool$lambda$66(callToolRequest);
            }
        });
        RegisteredTool registeredTool = (RegisteredTool) ((Pa.d) this._tools).get(callToolRequest.getName());
        if (registeredTool != null) {
            ServerKt.logger.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.X
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.handleCallTool$lambda$69(callToolRequest);
                }
            });
            return registeredTool.getHandler().invoke(callToolRequest, interfaceC4014c);
        }
        ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.W
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleCallTool$lambda$68$lambda$67(callToolRequest);
            }
        });
        throw new IllegalArgumentException("Tool not found: " + callToolRequest.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleCallTool$lambda$66(CallToolRequest callToolRequest) {
        return "Handling tool call request for tool: " + callToolRequest.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleCallTool$lambda$68$lambda$67(CallToolRequest callToolRequest) {
        return "Tool not found: " + callToolRequest.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleCallTool$lambda$69(CallToolRequest callToolRequest) {
        return "Executing tool " + callToolRequest.getName() + " with input: " + callToolRequest.getArguments();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleGetPrompt(final GetPromptRequest getPromptRequest, InterfaceC4014c<? super GetPromptResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleGetPrompt$lambda$72(getPromptRequest);
            }
        });
        RegisteredPrompt registeredPrompt = getPrompts().get(getPromptRequest.getName());
        if (registeredPrompt != null) {
            return registeredPrompt.getMessageProvider().invoke(getPromptRequest, interfaceC4014c);
        }
        ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.A
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleGetPrompt$lambda$74$lambda$73(getPromptRequest);
            }
        });
        throw new IllegalArgumentException("Prompt not found: " + getPromptRequest.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleGetPrompt$lambda$72(GetPromptRequest getPromptRequest) {
        return "Handling get prompt request for: " + getPromptRequest.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleGetPrompt$lambda$74$lambda$73(GetPromptRequest getPromptRequest) {
        return "Prompt not found: " + getPromptRequest.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleInitialize(final InitializeRequest initializeRequest, InterfaceC4014c<? super InitializeResult> interfaceC4014c) {
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.d0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleInitialize$lambda$63(initializeRequest);
            }
        });
        this.clientCapabilities = initializeRequest.getCapabilities();
        this.clientVersion = initializeRequest.getClientInfo();
        final String protocolVersion = initializeRequest.getProtocolVersion();
        if (!Z8.r.R(TypesKt.getSUPPORTED_PROTOCOL_VERSIONS(), protocolVersion)) {
            ServerKt.logger.e(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.o0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.handleInitialize$lambda$64(protocolVersion);
                }
            });
            protocolVersion = "2024-11-05";
        }
        return new InitializeResult(protocolVersion, this.capabilities, this.serverInfo, (qb.D) null, 8, (kotlin.jvm.internal.i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleInitialize$lambda$63(InitializeRequest initializeRequest) {
        return "Handling initialize request from client " + initializeRequest.getClientInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleInitialize$lambda$64(String str) {
        return "Client requested unsupported protocol version " + str + ", falling back to 2024-11-05";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleListPrompts(InterfaceC4014c<? super ListPromptsResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.C
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleListPrompts$lambda$70();
            }
        });
        Collection<RegisteredPrompt> collectionValues = getPrompts().values();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(((RegisteredPrompt) it.next()).getPrompt());
        }
        return new ListPromptsResult(arrayList, (String) null, (qb.D) null, 6, (kotlin.jvm.internal.i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleListPrompts$lambda$70() {
        return "Handling list prompts request";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleListResourceTemplates(InterfaceC4014c<? super ListResourceTemplatesResult> interfaceC4014c) {
        return new ListResourceTemplatesResult(C1173v.m(), (String) null, (qb.D) null, 6, (kotlin.jvm.internal.i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleListResources(InterfaceC4014c<? super ListResourcesResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.t0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleListResources$lambda$75();
            }
        });
        Collection<RegisteredResource> collectionValues = getResources().values();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(((RegisteredResource) it.next()).getResource());
        }
        return new ListResourcesResult(arrayList, (String) null, (qb.D) null, 6, (kotlin.jvm.internal.i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleListResources$lambda$75() {
        return "Handling list resources request";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleListTools(InterfaceC4014c<? super ListToolsResult> interfaceC4014c) {
        Collection<RegisteredTool> collectionValues = getTools().values();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(((RegisteredTool) it.next()).getTool());
        }
        return new ListToolsResult(arrayList, (String) null, (qb.D) null, 4, (kotlin.jvm.internal.i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleReadResource(final ReadResourceRequest readResourceRequest, InterfaceC4014c<? super ReadResourceResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleReadResource$lambda$77(readResourceRequest);
            }
        });
        RegisteredResource registeredResource = getResources().get(readResourceRequest.getUri());
        if (registeredResource != null) {
            return registeredResource.getReadHandler().invoke(readResourceRequest, interfaceC4014c);
        }
        ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.handleReadResource$lambda$79$lambda$78(readResourceRequest);
            }
        });
        throw new IllegalArgumentException("Resource not found: " + readResourceRequest.getUri());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleReadResource$lambda$77(ReadResourceRequest readResourceRequest) {
        return "Handling read resource request for: " + readResourceRequest.getUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handleReadResource$lambda$79$lambda$78(ReadResourceRequest readResourceRequest) {
        return "Resource not found: " + readResourceRequest.getUri();
    }

    public static /* synthetic */ Object listRoots$default(Server server, qb.D d10, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRoots");
        }
        if ((i10 & 1) != 0) {
            d10 = Types_utilKt.getEmptyJsonObject();
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return server.listRoots(d10, requestOptions, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object listRoots$lambda$56(qb.D d10) {
        return "Listing roots with params: " + d10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onClose$lambda$5(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        interfaceC5063a.invoke();
        interfaceC5063a2.invoke();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onClose$lambda$6() {
        return "Server connection closing";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t onInitialized$lambda$4(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        interfaceC5063a.invoke();
        interfaceC5063a2.invoke();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removePrompt$lambda$30(String str) {
        return "Failed to remove prompt '" + str + "': Server does not support prompts capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removePrompt$lambda$31(String str) {
        return "Removing prompt: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removePrompt$lambda$33(boolean z10, String str) {
        if (z10) {
            return "Prompt removed: " + str;
        }
        return "Prompt not found: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removePrompts$lambda$34() {
        return "Failed to remove prompts: Server does not support prompts capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removePrompts$lambda$35(List list) {
        return "Removing " + list.size() + " prompts";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removePrompts$lambda$38(int i10) {
        if (i10 <= 0) {
            return "No prompts were removed";
        }
        return "Removed " + i10 + " prompts";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeResource$lambda$46(String str) {
        return "Failed to remove resource '" + str + "': Server does not support resources capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeResource$lambda$47(String str) {
        return "Removing resource: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeResource$lambda$49(boolean z10, String str) {
        if (z10) {
            return "Resource removed: " + str;
        }
        return "Resource not found: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeResources$lambda$50() {
        return "Failed to remove resources: Server does not support resources capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeResources$lambda$51(List list) {
        return "Removing " + list.size() + " resources";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeResources$lambda$54(int i10) {
        if (i10 <= 0) {
            return "No resources were removed";
        }
        return "Removed " + i10 + " resources";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeTool$lambda$14(String str) {
        return "Failed to remove tool '" + str + "': Server does not support tools capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeTool$lambda$15(String str) {
        return "Removing tool: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeTool$lambda$17(boolean z10, String str) {
        if (z10) {
            return "Tool removed: " + str;
        }
        return "Tool not found: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeTools$lambda$18() {
        return "Failed to remove tools: Server does not support tools capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeTools$lambda$19(List list) {
        return "Removing " + list.size() + " tools";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeTools$lambda$22(int i10) {
        if (i10 <= 0) {
            return "No tools were removed";
        }
        return "Removed " + i10 + " tools";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object sendLoggingMessage$lambda$58(LoggingMessageNotification loggingMessageNotification) {
        return "Sending logging message: " + loggingMessageNotification.getData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object sendPromptListChanged$lambda$62() {
        return "Sending prompt list changed notification";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object sendResourceListChanged$lambda$60() {
        return "Sending resource list changed notification";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object sendResourceUpdated$lambda$59(ResourceUpdatedNotification resourceUpdatedNotification) {
        return "Sending resource updated notification for: " + resourceUpdatedNotification.getUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object sendToolListChanged$lambda$61() {
        return "Sending tool list changed notification";
    }

    public final void addPrompt(final Prompt prompt, p9.p<? super GetPromptRequest, ? super InterfaceC4014c<? super GetPromptResult>, ? extends Object> promptProvider) {
        Object obj;
        kotlin.jvm.internal.p.i(prompt, "prompt");
        kotlin.jvm.internal.p.i(promptProvider, "promptProvider");
        if (this.capabilities.getPrompts() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.G
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.addPrompt$lambda$23(prompt);
                }
            });
            throw new IllegalStateException("Server does not support prompts capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.S
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.addPrompt$lambda$24(prompt);
            }
        });
        do {
            obj = this._prompts;
        } while (!_prompts$FU.compareAndSet(this, obj, ((Pa.d) obj).put((Pa.d) prompt.getName(), (String) new RegisteredPrompt(prompt, promptProvider))));
    }

    public final void addPrompts(final List<RegisteredPrompt> promptsToAdd) {
        Object obj;
        Pa.d dVar;
        LinkedHashMap linkedHashMap;
        kotlin.jvm.internal.p.i(promptsToAdd, "promptsToAdd");
        if (this.capabilities.getPrompts() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.K
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.addPrompts$lambda$26();
                }
            });
            throw new IllegalStateException("Server does not support prompts capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.L
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.addPrompts$lambda$27(promptsToAdd);
            }
        });
        do {
            obj = this._prompts;
            dVar = (Pa.d) obj;
            List<RegisteredPrompt> list = promptsToAdd;
            linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(((RegisteredPrompt) obj2).getPrompt().getName(), obj2);
            }
        } while (!_prompts$FU.compareAndSet(this, obj, dVar.putAll((Map) linkedHashMap)));
    }

    public final void addResource(final String uri, final String name, String description, String mimeType, p9.p<? super ReadResourceRequest, ? super InterfaceC4014c<? super ReadResourceResult>, ? extends Object> readHandler) {
        Object obj;
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(mimeType, "mimeType");
        kotlin.jvm.internal.p.i(readHandler, "readHandler");
        if (this.capabilities.getResources() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.r0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.addResource$lambda$39(name);
                }
            });
            throw new IllegalStateException("Server does not support resources capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.s0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.addResource$lambda$40(name, uri);
            }
        });
        do {
            obj = this._resources;
        } while (!_resources$FU.compareAndSet(this, obj, ((Pa.d) obj).put((Pa.d) uri, (String) new RegisteredResource(new Resource(uri, name, description, mimeType), readHandler))));
    }

    public final void addResources(final List<RegisteredResource> resourcesToAdd) {
        Object obj;
        Pa.d dVar;
        LinkedHashMap linkedHashMap;
        kotlin.jvm.internal.p.i(resourcesToAdd, "resourcesToAdd");
        if (this.capabilities.getResources() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.I
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.addResources$lambda$42();
                }
            });
            throw new IllegalStateException("Server does not support resources capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.J
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.addResources$lambda$43(resourcesToAdd);
            }
        });
        do {
            obj = this._resources;
            dVar = (Pa.d) obj;
            List<RegisteredResource> list = resourcesToAdd;
            linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(((RegisteredResource) obj2).getResource().getUri(), obj2);
            }
        } while (!_resources$FU.compareAndSet(this, obj, dVar.putAll((Map) linkedHashMap)));
    }

    public final void addTool(final Tool tool, p9.p<? super CallToolRequest, ? super InterfaceC4014c<? super CallToolResult>, ? extends Object> handler) {
        Object obj;
        kotlin.jvm.internal.p.i(tool, "tool");
        kotlin.jvm.internal.p.i(handler, "handler");
        if (this.capabilities.getTools() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.h0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.addTool$lambda$7(tool);
                }
            });
            throw new IllegalStateException("Server does not support tools capability. Enable it in ServerOptions.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.i0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.addTool$lambda$8(tool);
            }
        });
        do {
            obj = this._tools;
        } while (!_tools$FU.compareAndSet(this, obj, ((Pa.d) obj).put((Pa.d) tool.getName(), (String) new RegisteredTool(tool, handler))));
    }

    public final void addTools(final List<RegisteredTool> toolsToAdd) {
        Object obj;
        Pa.d dVar;
        LinkedHashMap linkedHashMap;
        kotlin.jvm.internal.p.i(toolsToAdd, "toolsToAdd");
        if (this.capabilities.getTools() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.q
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.addTools$lambda$10();
                }
            });
            throw new IllegalStateException("Server does not support tools capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.addTools$lambda$11(toolsToAdd);
            }
        });
        do {
            obj = this._tools;
            dVar = (Pa.d) obj;
            List<RegisteredTool> list = toolsToAdd;
            linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(((RegisteredTool) obj2).getTool().getName(), obj2);
            }
        } while (!_tools$FU.compareAndSet(this, obj, dVar.putAll((Map) linkedHashMap)));
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public void assertCapabilityForMethod(final Method method) {
        kotlin.jvm.internal.p.i(method, "method");
        ServerKt.logger.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.p0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.assertCapabilityForMethod$lambda$80(method);
            }
        });
        String value = method.getValue();
        switch (value.hashCode()) {
            case -597942244:
                if (value.equals(McpSchema.METHOD_ROOTS_LIST)) {
                    ClientCapabilities clientCapabilities = this.clientCapabilities;
                    if ((clientCapabilities != null ? clientCapabilities.getRoots() : null) != null) {
                        return;
                    }
                    throw new IllegalStateException("Client does not support listing roots (required for " + method.getValue() + ')');
                }
                return;
            case 3441010:
                value.equals(McpSchema.METHOD_PING);
                return;
            case 473012035:
                if (value.equals(McpSchema.METHOD_SAMPLING_CREATE_MESSAGE)) {
                    ClientCapabilities clientCapabilities2 = this.clientCapabilities;
                    if ((clientCapabilities2 != null ? clientCapabilities2.getSampling() : null) != null) {
                        return;
                    }
                    ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.q0
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return Server.assertCapabilityForMethod$lambda$81();
                        }
                    });
                    throw new IllegalStateException("Client does not support sampling (required for " + method.getValue() + ')');
                }
                return;
            case 2003080258:
                if (value.equals(McpSchema.METHOD_ELICITATION_CREATE)) {
                    ClientCapabilities clientCapabilities3 = this.clientCapabilities;
                    if ((clientCapabilities3 != null ? clientCapabilities3.getElicitation() : null) != null) {
                        return;
                    }
                    throw new IllegalStateException("Client does not support elicitation (required for " + method.getValue() + ')');
                }
                return;
            default:
                return;
        }
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public void assertNotificationCapability(final Method method) {
        String str;
        kotlin.jvm.internal.p.i(method, "method");
        ServerKt.logger.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.f0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.assertNotificationCapability$lambda$82(method);
            }
        });
        String value = method.getValue();
        switch (value.hashCode()) {
            case 349405418:
                str = "notifications/cancelled";
                value.equals(str);
                return;
            case 1016936794:
                if (value.equals(McpSchema.METHOD_NOTIFICATION_PROMPTS_LIST_CHANGED) && this.capabilities.getPrompts() == null) {
                    throw new IllegalStateException("Server does not support notifying of prompt list changes (required for " + method.getValue() + ')');
                }
                return;
            case 1038541902:
                if (value.equals(McpSchema.METHOD_NOTIFICATION_TOOLS_LIST_CHANGED) && this.capabilities.getTools() == null) {
                    throw new IllegalStateException("Server does not support notifying of tool list changes (required for " + method.getValue() + ')');
                }
                return;
            case 1330211296:
                if (value.equals(McpSchema.METHOD_NOTIFICATION_MESSAGE) && this.capabilities.getLogging() == null) {
                    ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.g0
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return Server.assertNotificationCapability$lambda$83();
                        }
                    });
                    throw new IllegalStateException("Server does not support logging (required for " + method.getValue() + ')');
                }
                return;
            case 1817582788:
                if (!value.equals(McpSchema.METHOD_NOTIFICATION_RESOURCES_LIST_CHANGED)) {
                    return;
                }
                break;
            case 1987810666:
                if (!value.equals(McpSchema.METHOD_NOTIFICATION_RESOURCES_UPDATED)) {
                    return;
                }
                break;
            case 2042860404:
                str = McpSchema.METHOD_NOTIFICATION_PROGRESS;
                value.equals(str);
                return;
            default:
                return;
        }
        if (this.capabilities.getResources() != null) {
            return;
        }
        throw new IllegalStateException("Server does not support notifying about resources (required for " + method.getValue() + ')');
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0124 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void assertRequestHandlerCapability(final io.modelcontextprotocol.kotlin.sdk.Method r4) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.server.Server.assertRequestHandlerCapability(io.modelcontextprotocol.kotlin.sdk.Method):void");
    }

    public final Object createElicitation(final String str, CreateElicitationRequest.RequestedSchema requestedSchema, RequestOptions requestOptions, InterfaceC4014c<? super CreateElicitationResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.n0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.createElicitation$lambda$57(str);
            }
        });
        return request(new CreateElicitationRequest(str, requestedSchema, null, 4, null), requestOptions, interfaceC4014c);
    }

    public final Object createMessage(final CreateMessageRequest createMessageRequest, RequestOptions requestOptions, InterfaceC4014c<? super CreateMessageResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.createMessage$lambda$55(createMessageRequest);
            }
        });
        return request(createMessageRequest, requestOptions, interfaceC4014c);
    }

    public final ClientCapabilities getClientCapabilities() {
        return this.clientCapabilities;
    }

    public final Implementation getClientVersion() {
        return this.clientVersion;
    }

    public final Map<String, RegisteredPrompt> getPrompts() {
        return (Map) this._prompts;
    }

    public final Map<String, RegisteredResource> getResources() {
        return (Map) this._resources;
    }

    public final Map<String, RegisteredTool> getTools() {
        return (Map) this._tools;
    }

    public final Object listRoots(final qb.D d10, RequestOptions requestOptions, InterfaceC4014c<? super ListRootsResult> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.listRoots$lambda$56(d10);
            }
        });
        return request(new ListRootsRequest(d10), requestOptions, interfaceC4014c);
    }

    public final void onClose(final InterfaceC5063a<Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        final InterfaceC5063a<Y8.t> interfaceC5063a = this._onClose;
        this._onClose = new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.B
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.onClose$lambda$5(interfaceC5063a, block);
            }
        };
    }

    public final void onInitialized(final InterfaceC5063a<Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        final InterfaceC5063a<Y8.t> interfaceC5063a = this._onInitialized;
        this._onInitialized = new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.onInitialized$lambda$4(interfaceC5063a, block);
            }
        };
    }

    public final Object ping(InterfaceC4014c<? super EmptyRequestResult> interfaceC4014c) {
        return Protocol.request$default(this, new PingRequest(), null, interfaceC4014c, 2, null);
    }

    public final boolean removePrompt(final String name) {
        Object obj;
        Pa.d dVar;
        kotlin.jvm.internal.p.i(name, "name");
        if (this.capabilities.getPrompts() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.w
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.removePrompt$lambda$30(name);
                }
            });
            throw new IllegalStateException("Server does not support prompts capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.x
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removePrompt$lambda$31(name);
            }
        });
        do {
            obj = this._prompts;
            dVar = (Pa.d) obj;
        } while (!_prompts$FU.compareAndSet(this, obj, dVar.remove((Pa.d) name)));
        final boolean zContainsKey = dVar.containsKey(name);
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removePrompt$lambda$33(zContainsKey, name);
            }
        });
        return zContainsKey;
    }

    public final int removePrompts(final List<String> promptNames) {
        Object obj;
        Pa.d dVar;
        List<String> list;
        kotlin.jvm.internal.p.i(promptNames, "promptNames");
        if (this.capabilities.getPrompts() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.b0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.removePrompts$lambda$34();
                }
            });
            throw new IllegalStateException("Server does not support prompts capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.c0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removePrompts$lambda$35(promptNames);
            }
        });
        do {
            obj = this._prompts;
            dVar = (Pa.d) obj;
            list = promptNames;
        } while (!_prompts$FU.compareAndSet(this, obj, Pa.a.a(dVar, Pa.a.d(list))));
        final int i10 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (dVar.containsKey((String) it.next()) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.e0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removePrompts$lambda$38(i10);
            }
        });
        return i10;
    }

    public final boolean removeResource(final String uri) {
        Object obj;
        Pa.d dVar;
        kotlin.jvm.internal.p.i(uri, "uri");
        if (this.capabilities.getResources() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.M
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.removeResource$lambda$46(uri);
                }
            });
            throw new IllegalStateException("Server does not support resources capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.N
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeResource$lambda$47(uri);
            }
        });
        do {
            obj = this._resources;
            dVar = (Pa.d) obj;
        } while (!_resources$FU.compareAndSet(this, obj, dVar.remove((Pa.d) uri)));
        final boolean zContainsKey = dVar.containsKey(uri);
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.O
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeResource$lambda$49(zContainsKey, uri);
            }
        });
        return zContainsKey;
    }

    public final int removeResources(final List<String> uris) {
        Object obj;
        Pa.d dVar;
        List<String> list;
        kotlin.jvm.internal.p.i(uris, "uris");
        if (this.capabilities.getResources() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.j0
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.removeResources$lambda$50();
                }
            });
            throw new IllegalStateException("Server does not support resources capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.k0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeResources$lambda$51(uris);
            }
        });
        do {
            obj = this._resources;
            dVar = (Pa.d) obj;
            list = uris;
        } while (!_resources$FU.compareAndSet(this, obj, Pa.a.a(dVar, Pa.a.d(list))));
        final int i10 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (dVar.containsKey((String) it.next()) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.l0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeResources$lambda$54(i10);
            }
        });
        return i10;
    }

    public final boolean removeTool(final String name) {
        Object obj;
        Pa.d dVar;
        kotlin.jvm.internal.p.i(name, "name");
        if (this.capabilities.getTools() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.l
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.removeTool$lambda$14(name);
                }
            });
            throw new IllegalStateException("Server does not support tools capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeTool$lambda$15(name);
            }
        });
        do {
            obj = this._tools;
            dVar = (Pa.d) obj;
        } while (!_tools$FU.compareAndSet(this, obj, dVar.remove((Pa.d) name)));
        final boolean zContainsKey = dVar.containsKey(name);
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeTool$lambda$17(zContainsKey, name);
            }
        });
        return zContainsKey;
    }

    public final int removeTools(final List<String> toolNames) {
        Object obj;
        Pa.d dVar;
        List<String> list;
        kotlin.jvm.internal.p.i(toolNames, "toolNames");
        if (this.capabilities.getTools() == null) {
            ServerKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.Y
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Server.removeTools$lambda$18();
                }
            });
            throw new IllegalStateException("Server does not support tools capability.");
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.Z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeTools$lambda$19(toolNames);
            }
        });
        do {
            obj = this._tools;
            dVar = (Pa.d) obj;
            list = toolNames;
        } while (!_tools$FU.compareAndSet(this, obj, Pa.a.a(dVar, Pa.a.d(list))));
        final int i10 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (dVar.containsKey((String) it.next()) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.a0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.removeTools$lambda$22(i10);
            }
        });
        return i10;
    }

    public final Object sendLoggingMessage(final LoggingMessageNotification loggingMessageNotification, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ServerKt.logger.f(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.m0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.sendLoggingMessage$lambda$58(loggingMessageNotification);
            }
        });
        Object objNotification = notification(loggingMessageNotification, interfaceC4014c);
        return objNotification == C4063a.g() ? objNotification : Y8.t.f7040a;
    }

    public final Object sendPromptListChanged(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.v
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.sendPromptListChanged$lambda$62();
            }
        });
        Object objNotification = notification(new PromptListChangedNotification(), interfaceC4014c);
        return objNotification == C4063a.g() ? objNotification : Y8.t.f7040a;
    }

    public final Object sendResourceListChanged(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.u0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.sendResourceListChanged$lambda$60();
            }
        });
        Object objNotification = notification(new ResourceListChangedNotification(), interfaceC4014c);
        return objNotification == C4063a.g() ? objNotification : Y8.t.f7040a;
    }

    public final Object sendResourceUpdated(final ResourceUpdatedNotification resourceUpdatedNotification, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.u
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.sendResourceUpdated$lambda$59(resourceUpdatedNotification);
            }
        });
        Object objNotification = notification(resourceUpdatedNotification, interfaceC4014c);
        return objNotification == C4063a.g() ? objNotification : Y8.t.f7040a;
    }

    public final Object sendToolListChanged(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        ServerKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.sendToolListChanged$lambda$61();
            }
        });
        Object objNotification = notification(new ToolListChangedNotification(), interfaceC4014c);
        return objNotification == C4063a.g() ? objNotification : Y8.t.f7040a;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public void onClose() {
        ServerKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.server.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Server.onClose$lambda$6();
            }
        });
        this._onClose.invoke();
    }

    public final void addPrompt(String name, String description, List<PromptArgument> arguments, p9.p<? super GetPromptRequest, ? super InterfaceC4014c<? super GetPromptResult>, ? extends Object> promptProvider) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(promptProvider, "promptProvider");
        addPrompt(new Prompt(name, description, arguments), promptProvider);
    }

    public final void addTool(String name, String description, Tool.Input inputSchema, Tool.Output outputSchema, ToolAnnotations toolAnnotations, p9.p<? super CallToolRequest, ? super InterfaceC4014c<? super CallToolResult>, ? extends Object> handler) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(inputSchema, "inputSchema");
        kotlin.jvm.internal.p.i(handler, "handler");
        addTool(new Tool(name, description, inputSchema, outputSchema, toolAnnotations), handler);
    }
}
