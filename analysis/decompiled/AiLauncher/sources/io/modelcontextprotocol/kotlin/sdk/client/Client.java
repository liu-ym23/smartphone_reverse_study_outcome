package io.modelcontextprotocol.kotlin.sdk.client;

import Z8.C1173v;
import Z8.C1174w;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.modelcontextprotocol.kotlin.sdk.CallToolRequest;
import io.modelcontextprotocol.kotlin.sdk.CallToolResultBase;
import io.modelcontextprotocol.kotlin.sdk.ClientCapabilities;
import io.modelcontextprotocol.kotlin.sdk.CompleteRequest;
import io.modelcontextprotocol.kotlin.sdk.CompleteResult;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationRequest;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationResult;
import io.modelcontextprotocol.kotlin.sdk.EmptyRequestResult;
import io.modelcontextprotocol.kotlin.sdk.GetPromptRequest;
import io.modelcontextprotocol.kotlin.sdk.GetPromptResult;
import io.modelcontextprotocol.kotlin.sdk.Implementation;
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
import io.modelcontextprotocol.kotlin.sdk.LoggingLevel;
import io.modelcontextprotocol.kotlin.sdk.LoggingMessageNotification;
import io.modelcontextprotocol.kotlin.sdk.Method;
import io.modelcontextprotocol.kotlin.sdk.PingRequest;
import io.modelcontextprotocol.kotlin.sdk.ReadResourceRequest;
import io.modelcontextprotocol.kotlin.sdk.ReadResourceResult;
import io.modelcontextprotocol.kotlin.sdk.RequestResult;
import io.modelcontextprotocol.kotlin.sdk.Root;
import io.modelcontextprotocol.kotlin.sdk.RootsListChangedNotification;
import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities;
import io.modelcontextprotocol.kotlin.sdk.SubscribeRequest;
import io.modelcontextprotocol.kotlin.sdk.UnsubscribeRequest;
import io.modelcontextprotocol.kotlin.sdk.shared.Protocol;
import io.modelcontextprotocol.kotlin.sdk.shared.RequestHandlerExtra;
import io.modelcontextprotocol.kotlin.sdk.shared.RequestOptions;
import io.modelcontextprotocol.kotlin.sdk.shared.Transport;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import qb.C5168A;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0082@¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J\u001c\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ&\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b!\u0010\"J$\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020#2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b%\u0010&J&\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020'2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b*\u0010+J(\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010(\u001a\u00020,2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b.\u0010/J(\u00102\u001a\u0004\u0018\u0001012\b\b\u0002\u0010(\u001a\u0002002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b2\u00103J&\u00106\u001a\u0004\u0018\u0001052\u0006\u0010(\u001a\u0002042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b6\u00107J&\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010(\u001a\u0002082\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b:\u0010;J$\u0010=\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020<2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b=\u0010>J$\u0010@\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020?2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b@\u0010AJF\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010B\u001a\u00020\u000b2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010D0C2\b\b\u0002\u0010G\u001a\u00020F2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\bI\u0010JJ0\u0010I\u001a\u0004\u0018\u00010H2\u0006\u0010(\u001a\u00020K2\b\b\u0002\u0010G\u001a\u00020F2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\bI\u0010LJ(\u0010O\u001a\u0004\u0018\u00010N2\b\b\u0002\u0010(\u001a\u00020M2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0086@¢\u0006\u0004\bO\u0010PJ\u001d\u0010R\u001a\u00020\u000e2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b¢\u0006\u0004\bR\u0010\u0010J\u001b\u0010V\u001a\u00020\u000e2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0S¢\u0006\u0004\bV\u0010WJ\u0015\u0010X\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u000b¢\u0006\u0004\bX\u0010YJ\u001b\u0010\\\u001a\u00020[2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000b0S¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b^\u0010\nJ!\u0010c\u001a\u00020\u000e2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020a0_¢\u0006\u0004\bc\u0010dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010eR(\u0010h\u001a\u0004\u0018\u00010f2\b\u0010g\u001a\u0004\u0018\u00010f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR(\u0010l\u001a\u0004\u0018\u00010\u00022\b\u0010g\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bl\u0010e\u001a\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010q¨\u0006r"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/client/Client;", "Lio/modelcontextprotocol/kotlin/sdk/shared/Protocol;", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "clientInfo", "Lio/modelcontextprotocol/kotlin/sdk/client/ClientOptions;", "options", "<init>", "(Lio/modelcontextprotocol/kotlin/sdk/Implementation;Lio/modelcontextprotocol/kotlin/sdk/client/ClientOptions;)V", "Lio/modelcontextprotocol/kotlin/sdk/ListRootsResult;", "handleListRoots", "(Le9/c;)Ljava/lang/Object;", "", "capability", "method", "LY8/t;", "assertCapability", "(Ljava/lang/String;Ljava/lang/String;)V", "Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;", "transport", Constants.METHOD_CONNECT, "(Lio/modelcontextprotocol/kotlin/sdk/shared/Transport;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/Method;", "assertCapabilityForMethod", "(Lio/modelcontextprotocol/kotlin/sdk/Method;)V", "assertNotificationCapability", "assertRequestHandlerCapability", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;", "Lio/modelcontextprotocol/kotlin/sdk/EmptyRequestResult;", McpSchema.METHOD_PING, "(Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "params", "Lio/modelcontextprotocol/kotlin/sdk/CompleteResult;", "complete", "(Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;", "level", "setLoggingLevel", "(Lio/modelcontextprotocol/kotlin/sdk/LoggingLevel;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;", "request", "Lio/modelcontextprotocol/kotlin/sdk/GetPromptResult;", "getPrompt", "(Lio/modelcontextprotocol/kotlin/sdk/GetPromptRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListPromptsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListPromptsResult;", "listPrompts", "(Lio/modelcontextprotocol/kotlin/sdk/ListPromptsRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourcesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourcesResult;", "listResources", "(Lio/modelcontextprotocol/kotlin/sdk/ListResourcesRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesResult;", "listResourceTemplates", "(Lio/modelcontextprotocol/kotlin/sdk/ListResourceTemplatesRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ReadResourceResult;", "readResource", "(Lio/modelcontextprotocol/kotlin/sdk/ReadResourceRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/SubscribeRequest;", "subscribeResource", "(Lio/modelcontextprotocol/kotlin/sdk/SubscribeRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/UnsubscribeRequest;", "unsubscribeResource", "(Lio/modelcontextprotocol/kotlin/sdk/UnsubscribeRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "name", "", "", "arguments", "", "compatibility", "Lio/modelcontextprotocol/kotlin/sdk/CallToolResultBase;", "callTool", "(Ljava/lang/String;Ljava/util/Map;ZLio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "(Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;ZLio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "Lio/modelcontextprotocol/kotlin/sdk/ListToolsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/ListToolsResult;", "listTools", "(Lio/modelcontextprotocol/kotlin/sdk/ListToolsRequest;Lio/modelcontextprotocol/kotlin/sdk/shared/RequestOptions;Le9/c;)Ljava/lang/Object;", "uri", "addRoot", "", "Lio/modelcontextprotocol/kotlin/sdk/Root;", "rootsToAdd", "addRoots", "(Ljava/util/List;)V", "removeRoot", "(Ljava/lang/String;)Z", "uris", "", "removeRoots", "(Ljava/util/List;)I", "sendRootsListChanged", "Lkotlin/Function1;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "handler", "setElicitationHandler", "(Lp9/l;)V", "Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", UxipConstants.f30680s, "serverCapabilities", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "getServerCapabilities", "()Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "serverVersion", "getServerVersion", "()Lio/modelcontextprotocol/kotlin/sdk/Implementation;", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "capabilities", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public class Client extends Protocol {
    private static final /* synthetic */ AtomicReferenceFieldUpdater roots$FU = AtomicReferenceFieldUpdater.newUpdater(Client.class, Object.class, "roots");
    private final ClientCapabilities capabilities;
    private final Implementation clientInfo;
    private volatile /* synthetic */ Object roots;
    private ServerCapabilities serverCapabilities;
    private Implementation serverVersion;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/ListRootsRequest;", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.Client$2", f = "Client.kt", l = {114}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.Client$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.q<ListRootsRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ListRootsRequest listRootsRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            return Client.this.new AnonymousClass2(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
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
            Client client = Client.this;
            this.label = 1;
            Object objHandleListRoots = client.handleListRoots(this);
            return objHandleListRoots == objG ? objG : objHandleListRoots;
        }
    }

    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.Client", f = "Client.kt", l = {141, 149, com.stepos.ailauncher.chat.wake.circle.F.LOOP_END_FRAME, 162}, m = "connect$suspendImpl")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.Client$connect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Client.connect$suspendImpl(Client.this, (Transport) null, (InterfaceC4014c<? super Y8.t>) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lio/modelcontextprotocol/kotlin/sdk/RequestResult;", "request", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationRequest;", "<unused var>", "Lio/modelcontextprotocol/kotlin/sdk/shared/RequestHandlerExtra;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "io.modelcontextprotocol.kotlin.sdk.client.Client$setElicitationHandler$3", f = "Client.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.modelcontextprotocol.kotlin.sdk.client.Client$setElicitationHandler$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.q<CreateElicitationRequest, RequestHandlerExtra, InterfaceC4014c<? super RequestResult>, Object> {
        final /* synthetic */ InterfaceC5074l<CreateElicitationRequest, CreateElicitationResult> $handler;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(InterfaceC5074l<? super CreateElicitationRequest, CreateElicitationResult> interfaceC5074l, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = interfaceC5074l;
        }

        @Override // p9.q
        public final Object invoke(CreateElicitationRequest createElicitationRequest, RequestHandlerExtra requestHandlerExtra, InterfaceC4014c<? super RequestResult> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$handler, interfaceC4014c);
            anonymousClass3.L$0 = createElicitationRequest;
            return anonymousClass3.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CreateElicitationRequest createElicitationRequest = (CreateElicitationRequest) this.L$0;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return this.$handler.invoke(createElicitationRequest);
        }
    }

    public /* synthetic */ Client(Implementation implementation, ClientOptions clientOptions, int i10, kotlin.jvm.internal.i iVar) {
        this(implementation, (i10 & 2) != 0 ? new ClientOptions(null, false, 3, null) : clientOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$0(Client client) {
        return "Initializing MCP client with capabilities: " + client.capabilities;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addRoot$lambda$2(String str) {
        return "Failed to add root '" + str + "': Client does not support roots capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addRoot$lambda$3(String str, String str2) {
        return "Adding root: " + str + " (" + str2 + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addRoots$lambda$5() {
        return "Failed to add roots: Client does not support roots capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object addRoots$lambda$6(List list) {
        return "Adding " + list.size() + " roots";
    }

    public static /* synthetic */ Object callTool$default(Client client, String str, Map map, boolean z10, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callTool");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            requestOptions = null;
        }
        return client.callTool(str, map, z11, requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object complete$default(Client client, CompleteRequest completeRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: complete");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.complete(completeRequest, requestOptions, interfaceC4014c);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(2:4|(1:6)(1:8))(0)|7|9|54|(1:(1:(1:(1:(3:15|49|(2:51|52)(1:53))(2:16|17))(4:18|19|40|41))(4:23|24|35|(1:37)(2:42|43)))(1:26))(3:27|(1:30)|48)|55|31|(3:34|35|(0)(0))|48|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0107, code lost:
    
        if (r4.notification(r5, r6) == r2) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0128, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        r4 = r3;
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012b, code lost:
    
        r6.L$0 = g9.h.a(r4);
        r6.L$1 = g9.h.a(r3);
        r6.L$2 = r0;
        r6.L$3 = null;
        r6.label = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0142, code lost:
    
        if (r4.close(r6) != r2) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dc A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:19:0x005f, B:24:0x0073, B:35:0x00cc, B:37:0x00dc, B:42:0x010d, B:43:0x0127), top: B:54:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010d A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {all -> 0x0064, blocks: (B:19:0x005f, B:24:0x0073, B:35:0x00cc, B:37:0x00dc, B:42:0x010d, B:43:0x0127), top: B:54:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [io.modelcontextprotocol.kotlin.sdk.shared.Protocol, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object connect$suspendImpl(io.modelcontextprotocol.kotlin.sdk.client.Client r18, io.modelcontextprotocol.kotlin.sdk.shared.Transport r19, e9.InterfaceC4014c<? super Y8.t> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.modelcontextprotocol.kotlin.sdk.client.Client.connect$suspendImpl(io.modelcontextprotocol.kotlin.sdk.client.Client, io.modelcontextprotocol.kotlin.sdk.shared.Transport, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object getPrompt$default(Client client, GetPromptRequest getPromptRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrompt");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.getPrompt(getPromptRequest, requestOptions, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object handleListRoots(InterfaceC4014c<? super ListRootsResult> interfaceC4014c) {
        return new ListRootsResult(Z8.F.m1(((Pa.d) this.roots).values()), (qb.D) null, 2, (kotlin.jvm.internal.i) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object listPrompts$default(Client client, ListPromptsRequest listPromptsRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listPrompts");
        }
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if ((i10 & 1) != 0) {
            listPromptsRequest = new ListPromptsRequest(str, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.listPrompts(listPromptsRequest, requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object listResourceTemplates$default(Client client, ListResourceTemplatesRequest listResourceTemplatesRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listResourceTemplates");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.listResourceTemplates(listResourceTemplatesRequest, requestOptions, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object listResources$default(Client client, ListResourcesRequest listResourcesRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listResources");
        }
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if ((i10 & 1) != 0) {
            listResourcesRequest = new ListResourcesRequest(str, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.listResources(listResourcesRequest, requestOptions, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object listTools$default(Client client, ListToolsRequest listToolsRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listTools");
        }
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        if ((i10 & 1) != 0) {
            listToolsRequest = new ListToolsRequest(str, objArr2 == true ? 1 : 0, 3, objArr == true ? 1 : 0);
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.listTools(listToolsRequest, requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object ping$default(Client client, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ping");
        }
        if ((i10 & 1) != 0) {
            requestOptions = null;
        }
        return client.ping(requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object readResource$default(Client client, ReadResourceRequest readResourceRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readResource");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.readResource(readResourceRequest, requestOptions, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeRoot$lambda$10(String str) {
        return "Removing root: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeRoot$lambda$12(boolean z10, String str) {
        if (z10) {
            return "Root removed: " + str;
        }
        return "Root not found: " + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeRoot$lambda$9(String str) {
        return "Failed to remove root '" + str + "': Client does not support roots capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeRoots$lambda$13() {
        return "Failed to remove roots: Client does not support roots capability";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeRoots$lambda$14(List list) {
        return "Removing " + list.size() + " roots";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object removeRoots$lambda$17(int i10) {
        if (i10 <= 0) {
            return "No roots were removed";
        }
        return "Removed " + i10 + " roots";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object setElicitationHandler$lambda$18() {
        return "Failed to set elicitation handler: Client does not support elicitation";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object setElicitationHandler$lambda$19() {
        return "Setting the elicitation handler";
    }

    public static /* synthetic */ Object setLoggingLevel$default(Client client, LoggingLevel loggingLevel, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLoggingLevel");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.setLoggingLevel(loggingLevel, requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object subscribeResource$default(Client client, SubscribeRequest subscribeRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeResource");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.subscribeResource(subscribeRequest, requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object unsubscribeResource$default(Client client, UnsubscribeRequest unsubscribeRequest, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unsubscribeResource");
        }
        if ((i10 & 2) != 0) {
            requestOptions = null;
        }
        return client.unsubscribeResource(unsubscribeRequest, requestOptions, interfaceC4014c);
    }

    public final void addRoot(final String uri, final String name) {
        Object obj;
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(name, "name");
        if (this.capabilities.getRoots() == null) {
            ClientKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Client.addRoot$lambda$2(name);
                }
            });
            throw new IllegalStateException("Client does not support roots capability.");
        }
        ClientKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.addRoot$lambda$3(name, uri);
            }
        });
        do {
            obj = this.roots;
        } while (!roots$FU.compareAndSet(this, obj, ((Pa.d) obj).put((Pa.d) uri, (String) new Root(uri, name))));
    }

    public final void addRoots(final List<Root> rootsToAdd) {
        Object obj;
        Pa.d dVar;
        LinkedHashMap linkedHashMap;
        kotlin.jvm.internal.p.i(rootsToAdd, "rootsToAdd");
        if (this.capabilities.getRoots() == null) {
            ClientKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Client.addRoots$lambda$5();
                }
            });
            throw new IllegalStateException("Client does not support roots capability.");
        }
        ClientKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.addRoots$lambda$6(rootsToAdd);
            }
        });
        do {
            obj = this.roots;
            dVar = (Pa.d) obj;
            List<Root> list = rootsToAdd;
            linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap.put(((Root) obj2).getUri(), obj2);
            }
        } while (!roots$FU.compareAndSet(this, obj, dVar.putAll((Map) linkedHashMap)));
    }

    public final void assertCapability(String capability, String method) {
        kotlin.jvm.internal.p.i(capability, "capability");
        kotlin.jvm.internal.p.i(method, "method");
        ServerCapabilities serverCapabilities = this.serverCapabilities;
        switch (capability.hashCode()) {
            case -1983070683:
                if (!capability.equals("resources")) {
                    return;
                }
                if ((serverCapabilities != null ? serverCapabilities.getResources() : null) != null) {
                    return;
                }
                break;
            case -309210225:
                if (!capability.equals("prompts")) {
                    return;
                }
                if ((serverCapabilities != null ? serverCapabilities.getPrompts() : null) != null) {
                    return;
                }
                break;
            case 110545371:
                if (!capability.equals("tools")) {
                    return;
                }
                if ((serverCapabilities != null ? serverCapabilities.getTools() : null) != null) {
                    return;
                }
                break;
            case 342281055:
                if (!capability.equals("logging")) {
                    return;
                }
                if ((serverCapabilities != null ? serverCapabilities.getLogging() : null) != null) {
                    return;
                }
                break;
            default:
                return;
        }
        throw new IllegalStateException("Server does not support " + capability + " (required for " + method + ')');
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public void assertCapabilityForMethod(Method method) {
        ServerCapabilities.Resources resources;
        kotlin.jvm.internal.p.i(method, "method");
        if (method == Method.Defined.LoggingSetLevel) {
            ServerCapabilities serverCapabilities = this.serverCapabilities;
            if ((serverCapabilities != null ? serverCapabilities.getLogging() : null) != null) {
                return;
            }
            throw new IllegalStateException("Server does not support logging (required for " + method + ')');
        }
        if (method == Method.Defined.PromptsGet || method == Method.Defined.PromptsList || method == Method.Defined.CompletionComplete) {
            ServerCapabilities serverCapabilities2 = this.serverCapabilities;
            if ((serverCapabilities2 != null ? serverCapabilities2.getPrompts() : null) != null) {
                return;
            }
            throw new IllegalStateException("Server does not support prompts (required for " + method + ')');
        }
        if (method != Method.Defined.ResourcesList && method != Method.Defined.ResourcesTemplatesList && method != Method.Defined.ResourcesRead && method != Method.Defined.ResourcesSubscribe && method != Method.Defined.ResourcesUnsubscribe) {
            if (method != Method.Defined.ToolsCall && method != Method.Defined.ToolsList) {
                Method.Defined.Companion companion = Method.Defined.INSTANCE;
                return;
            }
            ServerCapabilities serverCapabilities3 = this.serverCapabilities;
            if ((serverCapabilities3 != null ? serverCapabilities3.getTools() : null) != null) {
                return;
            }
            throw new IllegalStateException("Server does not support tools (required for " + method + ')');
        }
        ServerCapabilities serverCapabilities4 = this.serverCapabilities;
        if (serverCapabilities4 == null || (resources = serverCapabilities4.getResources()) == null) {
            throw new IllegalStateException(("Server does not support resources (required for " + method + ')').toString());
        }
        if (method != Method.Defined.ResourcesSubscribe || kotlin.jvm.internal.p.d(resources.getSubscribe(), Boolean.TRUE)) {
            return;
        }
        throw new IllegalStateException("Server does not support resource subscriptions (required for " + method + ')');
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public void assertNotificationCapability(Method method) {
        kotlin.jvm.internal.p.i(method, "method");
        if (method != Method.Defined.NotificationsRootsListChanged) {
            if (method != Method.Defined.NotificationsInitialized) {
                Method.Defined.Companion companion = Method.Defined.INSTANCE;
                return;
            }
            return;
        }
        ClientCapabilities.Roots roots = this.capabilities.getRoots();
        if (roots != null ? kotlin.jvm.internal.p.d(roots.getListChanged(), Boolean.TRUE) : false) {
            return;
        }
        throw new IllegalStateException("Client does not support roots list changed notifications (required for " + method + ')');
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public void assertRequestHandlerCapability(Method method) {
        kotlin.jvm.internal.p.i(method, "method");
        if (method == Method.Defined.SamplingCreateMessage) {
            if (this.capabilities.getSampling() != null) {
                return;
            }
            throw new IllegalStateException("Client does not support sampling capability (required for " + method + ')');
        }
        if (method == Method.Defined.RootsList) {
            if (this.capabilities.getRoots() != null) {
                return;
            }
            throw new IllegalStateException("Client does not support roots capability (required for " + method + ')');
        }
        if (method == Method.Defined.ElicitationCreate && this.capabilities.getElicitation() == null) {
            throw new IllegalStateException("Client does not support elicitation capability (required for " + method + ')');
        }
    }

    public final Object callTool(CallToolRequest callToolRequest, boolean z10, RequestOptions requestOptions, InterfaceC4014c<? super CallToolResultBase> interfaceC4014c) throws Throwable {
        if (z10) {
            Object objRequest = request(callToolRequest, requestOptions, interfaceC4014c);
            return objRequest == C4063a.g() ? objRequest : (CallToolResultBase) objRequest;
        }
        Object objRequest2 = request(callToolRequest, requestOptions, interfaceC4014c);
        return objRequest2 == C4063a.g() ? objRequest2 : (CallToolResultBase) objRequest2;
    }

    public final Object complete(CompleteRequest completeRequest, RequestOptions requestOptions, InterfaceC4014c<? super CompleteResult> interfaceC4014c) {
        return request(completeRequest, requestOptions, interfaceC4014c);
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.shared.Protocol
    public Object connect(Transport transport, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return connect$suspendImpl(this, transport, interfaceC4014c);
    }

    public final Object getPrompt(GetPromptRequest getPromptRequest, RequestOptions requestOptions, InterfaceC4014c<? super GetPromptResult> interfaceC4014c) {
        return request(getPromptRequest, requestOptions, interfaceC4014c);
    }

    public final ServerCapabilities getServerCapabilities() {
        return this.serverCapabilities;
    }

    public final Implementation getServerVersion() {
        return this.serverVersion;
    }

    public final Object listPrompts(ListPromptsRequest listPromptsRequest, RequestOptions requestOptions, InterfaceC4014c<? super ListPromptsResult> interfaceC4014c) {
        return request(listPromptsRequest, requestOptions, interfaceC4014c);
    }

    public final Object listResourceTemplates(ListResourceTemplatesRequest listResourceTemplatesRequest, RequestOptions requestOptions, InterfaceC4014c<? super ListResourceTemplatesResult> interfaceC4014c) {
        return request(listResourceTemplatesRequest, requestOptions, interfaceC4014c);
    }

    public final Object listResources(ListResourcesRequest listResourcesRequest, RequestOptions requestOptions, InterfaceC4014c<? super ListResourcesResult> interfaceC4014c) {
        return request(listResourcesRequest, requestOptions, interfaceC4014c);
    }

    public final Object listTools(ListToolsRequest listToolsRequest, RequestOptions requestOptions, InterfaceC4014c<? super ListToolsResult> interfaceC4014c) {
        return request(listToolsRequest, requestOptions, interfaceC4014c);
    }

    public final Object ping(RequestOptions requestOptions, InterfaceC4014c<? super EmptyRequestResult> interfaceC4014c) {
        return request(new PingRequest(), requestOptions, interfaceC4014c);
    }

    public final Object readResource(ReadResourceRequest readResourceRequest, RequestOptions requestOptions, InterfaceC4014c<? super ReadResourceResult> interfaceC4014c) {
        return request(readResourceRequest, requestOptions, interfaceC4014c);
    }

    public final boolean removeRoot(final String uri) {
        Object obj;
        Pa.d dVar;
        kotlin.jvm.internal.p.i(uri, "uri");
        if (this.capabilities.getRoots() == null) {
            ClientKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.f
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Client.removeRoot$lambda$9(uri);
                }
            });
            throw new IllegalStateException("Client does not support roots capability.");
        }
        ClientKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.removeRoot$lambda$10(uri);
            }
        });
        do {
            obj = this.roots;
            dVar = (Pa.d) obj;
        } while (!roots$FU.compareAndSet(this, obj, dVar.remove((Pa.d) uri)));
        final boolean zContainsKey = dVar.containsKey(uri);
        ClientKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.removeRoot$lambda$12(zContainsKey, uri);
            }
        });
        return zContainsKey;
    }

    public final int removeRoots(final List<String> uris) {
        Object obj;
        Pa.d dVar;
        List<String> list;
        kotlin.jvm.internal.p.i(uris, "uris");
        if (this.capabilities.getRoots() == null) {
            ClientKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.j
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Client.removeRoots$lambda$13();
                }
            });
            throw new IllegalStateException("Client does not support roots capability.");
        }
        ClientKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.removeRoots$lambda$14(uris);
            }
        });
        do {
            obj = this.roots;
            dVar = (Pa.d) obj;
            list = uris;
        } while (!roots$FU.compareAndSet(this, obj, Pa.a.a(dVar, Pa.a.d(list))));
        final int i10 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (dVar.containsKey((String) it.next()) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        ClientKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.removeRoots$lambda$17(i10);
            }
        });
        return i10;
    }

    public final Object sendRootsListChanged(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objNotification = notification(new RootsListChangedNotification(), interfaceC4014c);
        return objNotification == C4063a.g() ? objNotification : Y8.t.f7040a;
    }

    public final void setElicitationHandler(InterfaceC5074l<? super CreateElicitationRequest, CreateElicitationResult> handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        if (this.capabilities.getElicitation() == null) {
            ClientKt.logger.d(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.m
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Client.setElicitationHandler$lambda$18();
                }
            });
            throw new IllegalStateException("Client does not support elicitation.");
        }
        ClientKt.logger.c(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client.setElicitationHandler$lambda$19();
            }
        });
        setRequestHandler(kotlin.jvm.internal.t.m(CreateElicitationRequest.class), Method.Defined.ElicitationCreate, new AnonymousClass3(handler, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object setLoggingLevel(LoggingLevel loggingLevel, RequestOptions requestOptions, InterfaceC4014c<? super EmptyRequestResult> interfaceC4014c) {
        return request(new LoggingMessageNotification.SetLevelRequest(loggingLevel, null, 2, 0 == true ? 1 : 0), requestOptions, interfaceC4014c);
    }

    public final Object subscribeResource(SubscribeRequest subscribeRequest, RequestOptions requestOptions, InterfaceC4014c<? super EmptyRequestResult> interfaceC4014c) {
        return request(subscribeRequest, requestOptions, interfaceC4014c);
    }

    public final Object unsubscribeResource(UnsubscribeRequest unsubscribeRequest, RequestOptions requestOptions, InterfaceC4014c<? super EmptyRequestResult> interfaceC4014c) {
        return request(unsubscribeRequest, requestOptions, interfaceC4014c);
    }

    public static /* synthetic */ Object callTool$default(Client client, CallToolRequest callToolRequest, boolean z10, RequestOptions requestOptions, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callTool");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            requestOptions = null;
        }
        return client.callTool(callToolRequest, z10, requestOptions, interfaceC4014c);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Client(Implementation clientInfo, ClientOptions options) {
        super(options);
        kotlin.jvm.internal.p.i(clientInfo, "clientInfo");
        kotlin.jvm.internal.p.i(options, "options");
        this.clientInfo = clientInfo;
        ClientCapabilities capabilities = options.getCapabilities();
        this.capabilities = capabilities;
        this.roots = Pa.a.b();
        ClientKt.logger.g(new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.client.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Client._init_$lambda$0(this.f33762a);
            }
        });
        if (capabilities.getRoots() != null) {
            setRequestHandler(kotlin.jvm.internal.t.m(ListRootsRequest.class), Method.Defined.RootsList, new AnonymousClass2(null));
        }
    }

    public final Object callTool(String str, Map<String, ? extends Object> map, boolean z10, RequestOptions requestOptions, InterfaceC4014c<? super CallToolResultBase> interfaceC4014c) {
        qb.i iVarC;
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                iVarC = qb.j.c((String) value);
            } else if (value instanceof Number) {
                iVarC = qb.j.b((Number) value);
            } else if (value instanceof Boolean) {
                iVarC = qb.j.a((Boolean) value);
            } else if (value instanceof qb.i) {
                iVarC = (qb.i) value;
            } else if (value == null) {
                iVarC = C5168A.INSTANCE;
            } else {
                iVarC = qb.j.c(value.toString());
            }
            linkedHashMap.put(key, iVarC);
        }
        return callTool(new CallToolRequest(str, new qb.D(linkedHashMap), null, 4, null), z10, requestOptions, interfaceC4014c);
    }
}
