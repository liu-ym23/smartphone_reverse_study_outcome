package com.stepos.stepclaw.edge.intercept;

import a6.f0;
import a6.h1;
import a6.i0;
import a6.r0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.edge.intercept.handlers.AgentHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.GatewayHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.MessageHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.SessionHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.SubagentHookHandler;
import com.stepos.stepclaw.edge.intercept.handlers.ToolHookHandler;
import g5.a;
import h5.c;
import h5.e;
import h5.i;
import h6.d;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import kotlin.Metadata;
import m0.f;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/InterceptHttpServer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PORT, "<init>", "(I)V", "Ljava/net/Socket;", "client", "Lb5/a0;", "handleClient", "(Ljava/net/Socket;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "method", "path", "body", "routeRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Ljava/io/PrintWriter;", "writer", "status", "sendResponse", "(Ljava/io/PrintWriter;ILjava/lang/String;)V", "La6/f0;", "scope", "start", "(La6/f0;)V", "stop", "()V", "I", "Lcom/stepos/stepclaw/edge/intercept/handlers/AgentHookHandler;", "agentHookHandler", "Lcom/stepos/stepclaw/edge/intercept/handlers/AgentHookHandler;", "Lcom/stepos/stepclaw/edge/intercept/handlers/MessageHookHandler;", "messageHookHandler", "Lcom/stepos/stepclaw/edge/intercept/handlers/MessageHookHandler;", "Lcom/stepos/stepclaw/edge/intercept/handlers/ToolHookHandler;", "toolHookHandler", "Lcom/stepos/stepclaw/edge/intercept/handlers/ToolHookHandler;", "Lcom/stepos/stepclaw/edge/intercept/handlers/SessionHookHandler;", "sessionHookHandler", "Lcom/stepos/stepclaw/edge/intercept/handlers/SessionHookHandler;", "Lcom/stepos/stepclaw/edge/intercept/handlers/GatewayHookHandler;", "gatewayHookHandler", "Lcom/stepos/stepclaw/edge/intercept/handlers/GatewayHookHandler;", "Lcom/stepos/stepclaw/edge/intercept/handlers/SubagentHookHandler;", "subagentHookHandler", "Lcom/stepos/stepclaw/edge/intercept/handlers/SubagentHookHandler;", "Ljava/net/ServerSocket;", "serverSocket", "Ljava/net/ServerSocket;", "La6/h1;", "serverJob", "La6/h1;", "Companion", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InterceptHttpServer {
    public static final int DEFAULT_PORT = 18790;
    private static final String TAG = "InterceptHttpServer";
    private final AgentHookHandler agentHookHandler;
    private final GatewayHookHandler gatewayHookHandler;
    private final MessageHookHandler messageHookHandler;
    private final int port;
    private h1 serverJob;
    private ServerSocket serverSocket;
    private final SessionHookHandler sessionHookHandler;
    private final SubagentHookHandler subagentHookHandler;
    private final ToolHookHandler toolHookHandler;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.edge.intercept.InterceptHttpServer", f = "InterceptHttpServer.kt", l = {133}, m = "handleClient", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.edge.intercept.InterceptHttpServer$handleClient$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InterceptHttpServer.this.handleClient(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.edge.intercept.InterceptHttpServer$start$1", f = "InterceptHttpServer.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.edge.intercept.InterceptHttpServer$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00181 extends i implements p {
        private /* synthetic */ Object L$0;
        int label;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.stepos.stepclaw.edge.intercept.InterceptHttpServer$start$1$1", f = "InterceptHttpServer.kt", l = {57}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.stepclaw.edge.intercept.InterceptHttpServer$start$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00001 extends i implements p {
            final /* synthetic */ Socket $client;
            int label;
            final /* synthetic */ InterceptHttpServer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00001(InterceptHttpServer interceptHttpServer, Socket socket, f5.c cVar) {
                super(2, cVar);
                this.this$0 = interceptHttpServer;
                this.$client = socket;
            }

            @Override // h5.a
            public final f5.c create(Object obj, f5.c cVar) {
                return new C00001(this.this$0, this.$client, cVar);
            }

            @Override // p5.p
            public final Object invoke(f0 f0Var, f5.c cVar) {
                return ((C00001) create(f0Var, cVar)).invokeSuspend(a0.f883a);
            }

            @Override // h5.a
            public final Object invokeSuspend(Object obj) {
                a aVar = a.f2984a;
                int i8 = this.label;
                if (i8 == 0) {
                    a.a.c0(obj);
                    InterceptHttpServer interceptHttpServer = this.this$0;
                    Socket socket = this.$client;
                    kotlin.jvm.internal.p.b(socket);
                    this.label = 1;
                    if (interceptHttpServer.handleClient(socket, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                return a0.f883a;
            }
        }

        public C00181(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            C00181 c00181 = InterceptHttpServer.this.new C00181(cVar);
            c00181.L$0 = obj;
            return c00181;
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00181) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            f0 f0Var = (f0) this.L$0;
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            try {
                ServerSocket serverSocket = new ServerSocket(InterceptHttpServer.this.port, 50, InetAddress.getByName("127.0.0.1"));
                InterceptHttpServer.this.serverSocket = serverSocket;
                ALog.i$default(InterceptHttpServer.TAG, "Intercept HTTP server started on 127.0.0.1:" + InterceptHttpServer.this.port, null, 4, null);
                while (!serverSocket.isClosed()) {
                    try {
                        Socket socketAccept = serverSocket.accept();
                        h6.e eVar = r0.f210a;
                        i0.q(f0Var, d.f3059c, new C00001(InterceptHttpServer.this, socketAccept, null), 2);
                    } catch (Exception unused) {
                        if (serverSocket.isClosed()) {
                            break;
                        }
                    }
                }
            } catch (Exception e9) {
                ALog.e(InterceptHttpServer.TAG, "Failed to start intercept HTTP server: " + e9.getMessage(), e9);
            }
            return a0.f883a;
        }
    }

    public InterceptHttpServer() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleClient(java.net.Socket r21, f5.c r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.edge.intercept.InterceptHttpServer.handleClient(java.net.Socket, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final Object routeRequest(String str, String str2, String str3, f5.c cVar) {
        if (kotlin.jvm.internal.p.a(str, "GET") && kotlin.jvm.internal.p.a(str2, "/health")) {
            return "{\"status\":\"ok\",\"service\":\"stepclaw-hooks\"}";
        }
        if (!kotlin.jvm.internal.p.a(str, "POST")) {
            return f.d("{\"error\":\"method not allowed\",\"method\":\"", str, "\"}");
        }
        switch (str2.hashCode()) {
            case -1943660722:
                if (str2.equals("/hooks/subagent_spawned")) {
                    return this.subagentHookHandler.handleSubagentSpawned(str3);
                }
                break;
            case -1935012251:
                if (str2.equals("/hooks/before_prompt_build")) {
                    return this.agentHookHandler.handleBeforePromptBuild(str3);
                }
                break;
            case -1794668668:
                if (str2.equals("/hooks/session_end")) {
                    return this.sessionHookHandler.handleSessionEnd(str3);
                }
                break;
            case -1644301557:
                if (str2.equals("/hooks/tool_result_persist")) {
                    return this.toolHookHandler.handleToolResultPersist(str3);
                }
                break;
            case -967177142:
                if (str2.equals("/hooks/llm_input")) {
                    return this.agentHookHandler.handleLlmInput(str3);
                }
                break;
            case -755088141:
                if (str2.equals("/hooks/agent_end")) {
                    return this.agentHookHandler.handleAgentEnd(str3);
                }
                break;
            case -399579330:
                if (str2.equals("/hooks/message_sent")) {
                    return this.messageHookHandler.handleMessageSent(str3);
                }
                break;
            case -123935981:
                if (str2.equals("/hooks/subagent_spawning")) {
                    return this.subagentHookHandler.handleSubagentSpawning(str3);
                }
                break;
            case 260633729:
                if (str2.equals("/hooks/llm_output")) {
                    return this.agentHookHandler.handleLlmOutput(str3);
                }
                break;
            case 286472075:
                if (str2.equals("/hooks/gateway_stop")) {
                    return this.gatewayHookHandler.handleGatewayStop(str3);
                }
                break;
            case 290686457:
                if (str2.equals("/hooks/gateway_start")) {
                    return this.gatewayHookHandler.handleGatewayStart(str3);
                }
                break;
            case 576131542:
                if (str2.equals("/hooks/before_agent_start")) {
                    return this.agentHookHandler.handleBeforeAgentStart(str3);
                }
                break;
            case 675939669:
                if (str2.equals("/hooks/before_message_write")) {
                    return this.toolHookHandler.handleBeforeMessageWrite(str3);
                }
                break;
            case 775338835:
                if (str2.equals("/hooks/before_tool_call")) {
                    return this.toolHookHandler.handleBeforeToolCall(str3);
                }
                break;
            case 963352196:
                if (str2.equals("/hooks/before_model_resolve")) {
                    return this.agentHookHandler.handleBeforeModelResolve(str3);
                }
                break;
            case 1030799790:
                if (str2.equals("/hooks/subagent_ended")) {
                    return this.subagentHookHandler.handleSubagentEnded(str3);
                }
                break;
            case 1057600724:
                if (str2.equals("/hooks/after_tool_call")) {
                    return this.toolHookHandler.handleAfterToolCall(str3);
                }
                break;
            case 1303402237:
                if (str2.equals("/hooks/before_reset")) {
                    return this.sessionHookHandler.handleBeforeReset(str3);
                }
                break;
            case 1619312263:
                if (str2.equals("/hooks/message_received")) {
                    return this.messageHookHandler.handleMessageReceived(str3);
                }
                break;
            case 1728645399:
                if (str2.equals("/hooks/before_compaction")) {
                    return this.sessionHookHandler.handleBeforeCompaction(str3);
                }
                break;
            case 1781152244:
                if (str2.equals("/hooks/message_sending")) {
                    return this.messageHookHandler.handleMessageSending(str3);
                }
                break;
            case 1888829366:
                if (str2.equals("/hooks/after_compaction")) {
                    return this.sessionHookHandler.handleAfterCompaction(str3);
                }
                break;
            case 1891648886:
                if (str2.equals("/hooks/cron_session_start")) {
                    return this.agentHookHandler.handleCronSessionStart(str3);
                }
                break;
            case 1909617127:
                if (str2.equals("/hooks/tool_client_correlation")) {
                    return this.toolHookHandler.handleToolClientCorrelation(str3);
                }
                break;
            case 1913371851:
                if (str2.equals("/hooks/session_start")) {
                    return this.sessionHookHandler.handleSessionStart(str3);
                }
                break;
            case 2109771312:
                if (str2.equals("/hooks/subagent_delivery_target")) {
                    return this.subagentHookHandler.handleSubagentDeliveryTarget(str3);
                }
                break;
        }
        return f.d("{\"error\":\"not found\",\"path\":\"", str2, "\"}");
    }

    private final void sendResponse(PrintWriter writer, int status, String body) {
        writer.print("HTTP/1.1 " + status + " " + (status != 200 ? status != 404 ? status != 405 ? "Error" : "Method Not Allowed" : "Not Found" : "OK") + "\r\n");
        writer.print("Content-Type: application/json\r\n");
        byte[] bytes = body.getBytes(x5.a.f6276a);
        kotlin.jvm.internal.p.d(bytes, "getBytes(...)");
        writer.print("Content-Length: " + bytes.length + "\r\n");
        writer.print("Connection: close\r\n");
        writer.print("\r\n");
        writer.print(body);
    }

    public final void start(f0 scope) {
        kotlin.jvm.internal.p.e(scope, "scope");
        h6.e eVar = r0.f210a;
        this.serverJob = i0.q(scope, d.f3059c, new C00181(null), 2);
    }

    public final void stop() throws IOException {
        try {
            ServerSocket serverSocket = this.serverSocket;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception unused) {
        }
        h1 h1Var = this.serverJob;
        if (h1Var != null) {
            h1Var.e(null);
        }
        this.serverJob = null;
        this.serverSocket = null;
        ALog.i$default(TAG, "Intercept HTTP server stopped", null, 4, null);
    }

    public InterceptHttpServer(int i8) {
        this.port = i8;
        this.agentHookHandler = new AgentHookHandler();
        this.messageHookHandler = new MessageHookHandler();
        this.toolHookHandler = new ToolHookHandler();
        this.sessionHookHandler = new SessionHookHandler();
        this.gatewayHookHandler = new GatewayHookHandler();
        this.subagentHookHandler = new SubagentHookHandler();
    }

    public /* synthetic */ InterceptHttpServer(int i8, int i9, kotlin.jvm.internal.i iVar) {
        this((i9 & 1) != 0 ? DEFAULT_PORT : i8);
    }
}
