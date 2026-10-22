package com.stepos.agentframework.adapter.openclaw;

import C7.r;
import D7.w;
import J7.c;
import S7.n;
import S7.p;
import V4.A;
import V4.AbstractC0255b;
import V4.AbstractC0262i;
import V4.B;
import V4.C;
import V4.C0254a;
import V4.C0256c;
import V4.C0258e;
import V4.C0259f;
import V4.C0260g;
import V4.C0261h;
import V4.D;
import V4.E;
import V4.F;
import V4.G;
import V4.H;
import V4.l;
import V4.q;
import V4.u;
import V4.v;
import V4.x;
import V4.y;
import V4.z;
import android.content.Context;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.error.AdapterErrorCode;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventListener;
import com.stepos.agentframework.adapter.netcore.ExtKt;
import com.stepos.agentframework.adapter.netcore.ICancelHandle;
import com.stepos.agentframework.adapter.netcore.ICoreAgentClient;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.agentframework.adapter.netcore.Logger;
import com.stepos.agentframework.adapter.netcore.PushMessageListener;
import com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient;
import com.stepos.common.FunctionCall;
import com.stepos.statsrpk.d;
import com.zyql.agentfront.bean.CancelMessageRequest;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.MessageContent;
import com.zyql.agentfront.bean.SessionChatMessage;
import com.zyql.agentfront.bean.SessionInfo;
import com.zyql.agentfront.bean.SessionOperationRequest;
import com.zyql.agentfront.bean.SyncConversationsResponse;
import com.zyql.agentfront.bean.SyncHistoryRequest;
import com.zyql.agentfront.bean.SyncHistoryResponse;
import com.zyql.agentfront.bean.ToolCallRequest;
import com.zyql.agentfront.sdk.client.b;
import com.zyql.agentfront.sdk.client.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b*\u0001j\u0018\u0000 x2\u00020\u0001:\u0004xyz{B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u001dH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u001dH\u0096@¢\u0006\u0004\b \u0010\u001fJ\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020!H\u0096@¢\u0006\u0004\b#\u0010$J\u0018\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0096@¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0096@¢\u0006\u0004\b)\u0010(J \u0010+\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0096@¢\u0006\u0004\b+\u0010,J\u0010\u0010.\u001a\u00020-H\u0096@¢\u0006\u0004\b.\u0010/JH\u00104\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u0002002&\u00103\u001a\"\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\n01H\u0096@¢\u0006\u0004\b4\u00105J\u0018\u00107\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u000206H\u0096@¢\u0006\u0004\b7\u00108J!\u0010;\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b;\u0010<J)\u0010=\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b=\u0010>J)\u0010B\u001a\u00020A2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\bB\u0010CJ\u001f\u0010D\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010I\u001a\u00020H2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bI\u0010JJ\u001f\u0010L\u001a\u00020\n2\u0006\u0010K\u001a\u00020A2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u0002092\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\bN\u0010OJE\u0010T\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u00010%2\b\u0010@\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\n2\u0006\u0010K\u001a\u00020AH\u0002¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\nH\u0002¢\u0006\u0004\bX\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010YR\u001a\u0010Z\u001a\u00020%8\u0006X\u0086D¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R\u001a\u0010_\u001a\u00020^8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010eR\u0018\u0010f\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010h\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lRT\u0010p\u001aB\u0012\f\u0012\n n*\u0004\u0018\u00010%0%\u0012\f\u0012\n n*\u0004\u0018\u00010%0% n* \u0012\f\u0012\n n*\u0004\u0018\u00010%0%\u0012\f\u0012\n n*\u0004\u0018\u00010%0%\u0018\u00010o0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR8\u0010u\u001a&\u0012\f\u0012\n n*\u0004\u0018\u00010s0s n*\u0012\u0012\f\u0012\n n*\u0004\u0018\u00010s0s\u0018\u00010t0r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vRT\u0010w\u001aB\u0012\f\u0012\n n*\u0004\u0018\u00010%0%\u0012\f\u0012\n n*\u0004\u0018\u00010\u00190\u0019 n* \u0012\f\u0012\n n*\u0004\u0018\u00010%0%\u0012\f\u0012\n n*\u0004\u0018\u00010\u00190\u0019\u0018\u00010o0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010q¨\u0006|"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "", "timeOut", AppAgent.CONSTRUCT, "(J)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "log", "LC7/r;", "init", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "destroy", "()V", "Lcom/stepos/agentframework/adapter/netcore/PushMessageListener;", "listener", "setPushMessageCallback", "(Lcom/stepos/agentframework/adapter/netcore/PushMessageListener;)V", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "", "isAvailable", "onNetworkChanged", "(Z)V", "LV4/F;", "pauseTask", "(LV4/F;LH7/c;)Ljava/lang/Object;", "resumeTask", "LV4/y;", "LV4/z;", "syncHistory", "(LV4/y;LH7/c;)Ljava/lang/Object;", "", "sessionKey", "deleteSession", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "clearSession", "title", "renameSession", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "LV4/x;", "syncConversations", "(LH7/c;)Ljava/lang/Object;", "LV4/H;", "Lkotlin/Function4;", "", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "uploadFile", "(Landroid/content/Context;LV4/H;LS7/p;LH7/c;)Ljava/lang/Object;", "LV4/I;", "vote", "(LV4/I;LH7/c;)Ljava/lang/Object;", "Lcom/zyql/agentfront/sdk/client/b;", "client", "handleToolOutputsRequest", "(LV4/l;Lcom/zyql/agentfront/sdk/client/b;)Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "handleNormalChatRequest", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;Lcom/zyql/agentfront/sdk/client/b;)Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "messageId", AgentBusWakeContract.EXTRA_TRACE_ID, "Lcom/zyql/agentfront/bean/Message;", "buildMessage", "(LV4/l;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/Message;", "submitToolOutputs", "(LV4/l;Lcom/zyql/agentfront/sdk/client/b;)V", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;", "requestInfo", "Lcom/zyql/agentfront/sdk/client/c;", "createMessageCallback", "(Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;)Lcom/zyql/agentfront/sdk/client/c;", "message", "handleRemoteToolEvent", "(Lcom/zyql/agentfront/bean/Message;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;)V", "getOrCreateClient", "(Landroid/content/Context;)Lcom/zyql/agentfront/sdk/client/b;", Key.KEY_TOOL_CALL_ID, "conversationId", "toolName", "arguments", "handleToolCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "handlePushMessage", "(Lcom/zyql/agentfront/bean/Message;)V", "processPendingQueue", "J", "CHAT_ID", "Ljava/lang/String;", "getCHAT_ID", "()Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "logger", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "Landroid/content/Context;", "agentFrontClient", "Lcom/zyql/agentfront/sdk/client/b;", "pushMessageListener", "Lcom/stepos/agentframework/adapter/netcore/PushMessageListener;", "com/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$sdkPushMessageListener$1", "sdkPushMessageListener", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$sdkPushMessageListener$1;", "", "kotlin.jvm.PlatformType", "", "conversationAgentMap", "Ljava/util/Map;", "", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$PendingRequest;", "", "pendingQueue", "Ljava/util/List;", "activeRequests", "Companion", "OpenClawCancelHandle", "RequestInfo", "PendingRequest", "openclaw_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OpenClawCoreAgentClient implements ICoreAgentClient {
    private static final String TAG = "OpenClawCoreAgentClient";
    private b agentFrontClient;
    private Context context;
    private volatile PushMessageListener pushMessageListener;
    private final long timeOut;
    private final String CHAT_ID = "111";
    private final ApiType type = ApiType.OPENCLAW;
    private ILogger logger = Logger.INSTANCE;
    private final OpenClawCoreAgentClient$sdkPushMessageListener$1 sdkPushMessageListener = new e() { // from class: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$sdkPushMessageListener$1
        @Override // com.zyql.agentfront.sdk.client.e
        public void onPushMessage(Message message) {
            k.f(message, "message");
            this.this$0.logger.i("OpenClawCoreAgentClient", "PushMessageListener onPushMessage");
            this.this$0.handlePushMessage(message);
        }

        @Override // com.zyql.agentfront.sdk.client.e
        public void onPushToolCall(ToolCallRequest request) {
            k.f(request, "request");
            ILogger iLogger = this.this$0.logger;
            String toolCallId = request.getToolCallId();
            String originMessageId = request.getOriginMessageId();
            iLogger.i("OpenClawCoreAgentClient", a.j(B7.a.w("PushMessageListener onPushToolCall: toolCallId=", toolCallId, " msgId=", originMessageId, ", cId="), request.getConversationId(), ", traceId=", request.getTraceId()));
            this.this$0.handleToolCall(request.getOriginMessageId(), request.getToolCallId(), request.getConversationId(), request.getToolName(), request.getArguments(), request.getTraceId());
        }

        @Override // com.zyql.agentfront.sdk.client.e
        public void onPushToolCalls(List<ToolCallRequest> toolCallRequests) {
            k.f(toolCallRequests, "toolCallRequests");
            Iterator<T> it = toolCallRequests.iterator();
            while (it.hasNext()) {
                onPushToolCall((ToolCallRequest) it.next());
            }
        }
    };
    private final Map<String, String> conversationAgentMap = Collections.synchronizedMap(new LinkedHashMap());
    private final List<PendingRequest> pendingQueue = Collections.synchronizedList(new ArrayList());
    private final Map<String, Boolean> activeRequests = Collections.synchronizedMap(new LinkedHashMap());

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$OpenClawCancelHandle;", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "messageId", "", AppAgent.CONSTRUCT, "(Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient;Ljava/lang/String;)V", "cancelled", "", "cancel", "isCancelled", "openclaw_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class OpenClawCancelHandle implements ICancelHandle {
        private volatile boolean cancelled;
        private final String messageId;
        final /* synthetic */ OpenClawCoreAgentClient this$0;

        public OpenClawCancelHandle(OpenClawCoreAgentClient openClawCoreAgentClient, String messageId) {
            k.f(messageId, "messageId");
            this.this$0 = openClawCoreAgentClient;
            this.messageId = messageId;
        }

        @Override // com.stepos.agentframework.adapter.netcore.ICancelHandle
        public boolean cancel() {
            if (this.cancelled) {
                return false;
            }
            this.cancelled = true;
            Map map = this.this$0.activeRequests;
            k.e(map, "access$getActiveRequests$p(...)");
            map.put(this.messageId, Boolean.TRUE);
            this.this$0.logger.i(OpenClawCoreAgentClient.TAG, "Request cancelled: messageId=" + this.messageId);
            try {
                b bVar = this.this$0.agentFrontClient;
                if (bVar != null) {
                    bVar.g(new CancelMessageRequest(this.messageId, null, null, 6, null));
                }
                this.this$0.logger.i(OpenClawCoreAgentClient.TAG, "Request cancelled success. messageId=" + this.messageId);
                return true;
            } catch (Exception e) {
                ILogger iLogger = this.this$0.logger;
                String str = this.messageId;
                String message = e.getMessage();
                e.printStackTrace();
                r rVar = r.f317a;
                StringBuilder sbW = B7.a.w("Request cancelled failed. messageId:", str, ". msg=", message, ". e=");
                sbW.append(rVar);
                iLogger.e(OpenClawCoreAgentClient.TAG, sbW.toString());
                return true;
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.ICancelHandle
        /* renamed from: isCancelled */
        public boolean getCancelled() {
            return this.cancelled || k.b(this.this$0.activeRequests.get(this.messageId), Boolean.TRUE);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\b\u001a\u00060\u0006R\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u000f\u001a\u00060\u0006R\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\b\u0002\u0010\b\u001a\u00060\u0006R\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u000eR\u001b\u0010\b\u001a\u00060\u0006R\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;", "", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "listener", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$OpenClawCancelHandle;", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient;", "cancelHandle", AppAgent.CONSTRUCT, "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$OpenClawCancelHandle;)V", "component1", "()LV4/l;", "component2", "()Lcom/stepos/agentframework/adapter/netcore/EventListener;", "component3", "()Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$OpenClawCancelHandle;", "copy", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$OpenClawCancelHandle;)Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LV4/l;", "getRequest", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "getListener", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$OpenClawCancelHandle;", "getCancelHandle", "openclaw_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class RequestInfo {
        private final OpenClawCancelHandle cancelHandle;
        private final EventListener listener;
        private final l request;

        public RequestInfo(l request, EventListener listener, OpenClawCancelHandle cancelHandle) {
            k.f(request, "request");
            k.f(listener, "listener");
            k.f(cancelHandle, "cancelHandle");
            this.request = request;
            this.listener = listener;
            this.cancelHandle = cancelHandle;
        }

        public static /* synthetic */ RequestInfo copy$default(RequestInfo requestInfo, l lVar, EventListener eventListener, OpenClawCancelHandle openClawCancelHandle, int i, Object obj) {
            if ((i & 1) != 0) {
                lVar = requestInfo.request;
            }
            if ((i & 2) != 0) {
                eventListener = requestInfo.listener;
            }
            if ((i & 4) != 0) {
                openClawCancelHandle = requestInfo.cancelHandle;
            }
            return requestInfo.copy(lVar, eventListener, openClawCancelHandle);
        }

        /* renamed from: component1, reason: from getter */
        public final l getRequest() {
            return this.request;
        }

        /* renamed from: component2, reason: from getter */
        public final EventListener getListener() {
            return this.listener;
        }

        /* renamed from: component3, reason: from getter */
        public final OpenClawCancelHandle getCancelHandle() {
            return this.cancelHandle;
        }

        public final RequestInfo copy(l request, EventListener listener, OpenClawCancelHandle cancelHandle) {
            k.f(request, "request");
            k.f(listener, "listener");
            k.f(cancelHandle, "cancelHandle");
            return new RequestInfo(request, listener, cancelHandle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestInfo)) {
                return false;
            }
            RequestInfo requestInfo = (RequestInfo) other;
            return k.b(this.request, requestInfo.request) && k.b(this.listener, requestInfo.listener) && k.b(this.cancelHandle, requestInfo.cancelHandle);
        }

        public final OpenClawCancelHandle getCancelHandle() {
            return this.cancelHandle;
        }

        public final EventListener getListener() {
            return this.listener;
        }

        public final l getRequest() {
            return this.request;
        }

        public int hashCode() {
            return this.cancelHandle.hashCode() + ((this.listener.hashCode() + (this.request.hashCode() * 31)) * 31);
        }

        public String toString() {
            return "RequestInfo(request=" + this.request + ", listener=" + this.listener + ", cancelHandle=" + this.cancelHandle + ")";
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$chat$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "<anonymous>", "(Lm9/z;)Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$chat$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ EventListener $listener;
        final /* synthetic */ l $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(l lVar, EventListener eventListener, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$request = lVar;
            this.$listener = eventListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new AnonymousClass2(this.$request, this.$listener, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            Context context = OpenClawCoreAgentClient.this.context;
            if (context == null) {
                return null;
            }
            b orCreateClient = OpenClawCoreAgentClient.this.getOrCreateClient(context);
            this.$request.getClass();
            return OpenClawCoreAgentClient.this.handleNormalChatRequest(this.$request, this.$listener, orCreateClient);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super ICancelHandle> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$clearSession$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$clearSession$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10882 extends SuspendLambda implements n {
        final /* synthetic */ String $sessionKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10882(String str, H7.c<? super C10882> cVar) {
            super(2, cVar);
            this.$sessionKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10882(this.$sessionKey, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r rVar = r.f317a;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            b bVar = OpenClawCoreAgentClient.this.agentFrontClient;
            if (bVar == null) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "clearSession failed: client is null, sessionKey=" + this.$sessionKey);
                return rVar;
            }
            try {
                OpenClawCoreAgentClient.this.logger.i(OpenClawCoreAgentClient.TAG, "clearSession: sessionKey=" + this.$sessionKey);
                String sessionKey = this.$sessionKey;
                e eVar = b.p;
                k.f(sessionKey, "sessionKey");
                bVar.l(new SessionOperationRequest(sessionKey, 2, null, null, 4, null));
                return rVar;
            } catch (Exception e) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, B7.a.n("clearSession failed: sessionKey=", this.$sessionKey, ", error=", e.getMessage()));
                return rVar;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10882) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$createMessageCallback$1", "Lcom/zyql/agentfront/sdk/client/c;", "", "messageId", "LC7/r;", "onSuccess", "(Ljava/lang/String;)V", "error", "onError", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", "onReply", "(Lcom/zyql/agentfront/bean/Message;)V", "Lcom/zyql/agentfront/bean/ToolCallRequest;", "request", "onToolCall", "(Lcom/zyql/agentfront/bean/ToolCallRequest;)V", "openclaw_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$createMessageCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 implements com.zyql.agentfront.sdk.client.c {
        final /* synthetic */ RequestInfo $requestInfo;

        public AnonymousClass1(RequestInfo requestInfo) {
            this.$requestInfo = requestInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence onReply$lambda$1(MessageContent it) {
            k.f(it, "it");
            String text = it.getText();
            return text != null ? text : "";
        }

        @Override // com.zyql.agentfront.sdk.client.c
        public void onError(String messageId, String error) {
            k.f(messageId, "messageId");
            k.f(error, "error");
            if (this.$requestInfo.getCancelHandle().getCancelled()) {
                OpenClawCoreAgentClient.this.logger.d(OpenClawCoreAgentClient.TAG, "onError: request already cancelled, messageId=".concat(messageId));
                OpenClawCoreAgentClient.this.activeRequests.remove(messageId);
            } else {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, B7.a.n("onError: messageId=", messageId, ", error=", error));
                OpenClawCoreAgentClient.this.activeRequests.remove(messageId);
                this.$requestInfo.getListener().onFailure(this.$requestInfo.getRequest(), Integer.valueOf(AdapterErrorCode.ERROR_AGENT_INTERNAL_ERROR), error);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x0174  */
        @Override // com.zyql.agentfront.sdk.client.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReply(com.zyql.agentfront.bean.Message r21) {
            /*
                Method dump skipped, instructions count: 537
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.AnonymousClass1.onReply(com.zyql.agentfront.bean.Message):void");
        }

        @Override // com.zyql.agentfront.sdk.client.c
        public void onSuccess(String messageId) {
            k.f(messageId, "messageId");
            OpenClawCoreAgentClient.this.logger.d(OpenClawCoreAgentClient.TAG, "onSuccess: messageId=".concat(messageId));
            OpenClawCoreAgentClient.this.activeRequests.remove(messageId);
        }

        @Override // com.zyql.agentfront.sdk.client.c
        public void onToolCall(ToolCallRequest request) {
            k.f(request, "request");
            if (this.$requestInfo.getCancelHandle().getCancelled()) {
                OpenClawCoreAgentClient.this.logger.d(OpenClawCoreAgentClient.TAG, "onToolCall: request already cancelled, toolCallId=" + request.getToolCallId());
                return;
            }
            String traceId = request.getTraceId();
            ILogger iLogger = OpenClawCoreAgentClient.this.logger;
            String toolCallId = request.getToolCallId();
            String originMessageId = request.getOriginMessageId();
            String conversationId = request.getConversationId();
            String toolName = request.getToolName();
            StringBuilder sbW = B7.a.w("onToolCall: toolCallId=", toolCallId, ", originMessageId=", originMessageId, ", conversationId=");
            a.A(sbW, conversationId, ", traceId=", traceId, ",  toolName=");
            sbW.append(toolName);
            iLogger.d(OpenClawCoreAgentClient.TAG, sbW.toString());
            try {
                String toolName2 = request.getToolName();
                String toolCallId2 = request.getToolCallId();
                String toolName3 = request.getToolName();
                String arguments = request.getArguments();
                if (arguments == null) {
                    arguments = "{}";
                }
                FunctionCall functionCall = new FunctionCall(null, toolName3, arguments, toolName2, null, null, null, null, null, null, toolCallId2, null, 3057, null);
                String originMessageId2 = request.getOriginMessageId();
                String str = this.$requestInfo.getRequest().f1364a;
                String str2 = this.$requestInfo.getRequest().b;
                String conversationId2 = request.getConversationId();
                request.getConversationId();
                this.$requestInfo.getListener().onEvent(this.$requestInfo.getRequest(), new V4.k(null, "assistant", conversationId2, "tool_call", kotlin.collections.a.Q(new Pair("toolName", request.getToolName())), str, str2, 4, false, Integer.valueOf(this.$requestInfo.getRequest().h), 2, originMessageId2, null, functionCall, 1533845425));
            } catch (Exception e) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "Failed to parse tool call: " + e.getMessage());
            }
        }

        @Override // com.zyql.agentfront.sdk.client.c
        public void onToolCalls(List<ToolCallRequest> requests) {
            k.f(requests, "requests");
            Iterator<T> it = requests.iterator();
            while (it.hasNext()) {
                onToolCall((ToolCallRequest) it.next());
            }
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$deleteSession$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$deleteSession$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10892 extends SuspendLambda implements n {
        final /* synthetic */ String $sessionKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10892(String str, H7.c<? super C10892> cVar) {
            super(2, cVar);
            this.$sessionKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10892(this.$sessionKey, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r rVar = r.f317a;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            b bVar = OpenClawCoreAgentClient.this.agentFrontClient;
            if (bVar == null) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "deleteSession failed: client is null, sessionKey=" + this.$sessionKey);
                return rVar;
            }
            try {
                OpenClawCoreAgentClient.this.logger.i(OpenClawCoreAgentClient.TAG, "deleteSession: sessionKey=" + this.$sessionKey);
                String sessionKey = this.$sessionKey;
                e eVar = b.p;
                k.f(sessionKey, "sessionKey");
                bVar.l(new SessionOperationRequest(sessionKey, 1, null, null, 4, null));
                return rVar;
            } catch (Exception e) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, B7.a.n("deleteSession failed: sessionKey=", this.$sessionKey, ", error=", e.getMessage()));
                return rVar;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10892) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$pauseTask$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$pauseTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10902 extends SuspendLambda implements n {
        final /* synthetic */ F $request;
        int label;

        public C10902(F f, H7.c<? super C10902> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10902(null, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            if (OpenClawCoreAgentClient.this.agentFrontClient == null) {
                ILogger unused = OpenClawCoreAgentClient.this.logger;
                throw null;
            }
            try {
                ILogger unused2 = OpenClawCoreAgentClient.this.logger;
                throw null;
            } catch (Exception unused3) {
                ILogger unused4 = OpenClawCoreAgentClient.this.logger;
                throw null;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C10902) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$renameSession$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$renameSession$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10912 extends SuspendLambda implements n {
        final /* synthetic */ String $sessionKey;
        final /* synthetic */ String $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10912(String str, String str2, H7.c<? super C10912> cVar) {
            super(2, cVar);
            this.$sessionKey = str;
            this.$title = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10912(this.$sessionKey, this.$title, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            r rVar = r.f317a;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            b bVar = OpenClawCoreAgentClient.this.agentFrontClient;
            if (bVar == null) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "renameSession failed: client is null, sessionKey=" + this.$sessionKey);
                return rVar;
            }
            try {
                OpenClawCoreAgentClient.this.logger.i(OpenClawCoreAgentClient.TAG, "renameSession: sessionKey=" + this.$sessionKey + ", title=" + this.$title);
                String sessionKey = this.$sessionKey;
                String newTitle = this.$title;
                e eVar = b.p;
                k.f(sessionKey, "sessionKey");
                k.f(newTitle, "newTitle");
                bVar.l(new SessionOperationRequest(sessionKey, 3, newTitle, null));
                return rVar;
            } catch (Exception e) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, B7.a.n("renameSession failed: sessionKey=", this.$sessionKey, ", error=", e.getMessage()));
                return rVar;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10912) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$resumeTask$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$resumeTask$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10922 extends SuspendLambda implements n {
        final /* synthetic */ F $request;
        int label;

        public C10922(F f, H7.c<? super C10922> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10922(null, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            if (OpenClawCoreAgentClient.this.agentFrontClient == null) {
                ILogger unused = OpenClawCoreAgentClient.this.logger;
                throw null;
            }
            try {
                ILogger unused2 = OpenClawCoreAgentClient.this.logger;
                throw null;
            } catch (Exception unused3) {
                ILogger unused4 = OpenClawCoreAgentClient.this.logger;
                throw null;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C10922) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$syncConversations$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LV4/x;", "<anonymous>", "(Lm9/z;)LV4/x;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$syncConversations$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10932 extends SuspendLambda implements n {
        int label;

        public C10932(H7.c<? super C10932> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10932(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            b bVar = OpenClawCoreAgentClient.this.agentFrontClient;
            if (bVar == null) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "syncConversations failed: client is null");
                return new x(null, false, "client is null", 1);
            }
            try {
                OpenClawCoreAgentClient.this.logger.i(OpenClawCoreAgentClient.TAG, "syncConversations");
                SyncConversationsResponse syncConversationsResponseO = bVar.o();
                if (!syncConversationsResponseO.getSuccess()) {
                    return new x(null, false, syncConversationsResponseO.getErrorMessage(), 1);
                }
                List<SessionInfo> sessions = syncConversationsResponseO.getSessions();
                ArrayList arrayList = new ArrayList(w.c0(sessions, 10));
                for (SessionInfo sessionInfo : sessions) {
                    arrayList.add(new v(sessionInfo.getSessionKey(), sessionInfo.getSessionId(), sessionInfo.getTitle(), sessionInfo.getCreatedAt(), sessionInfo.getUpdatedAt()));
                }
                return new x(arrayList, true, null, 4);
            } catch (Exception e) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "syncConversations failed: error=" + e.getMessage());
                return new x(null, false, e.getMessage(), 1);
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super x> cVar) {
            return ((C10932) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$syncHistory$2", f = "OpenClawCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LV4/z;", "<anonymous>", "(Lm9/z;)LV4/z;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$syncHistory$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10942 extends SuspendLambda implements n {
        final /* synthetic */ y $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10942(y yVar, H7.c<? super C10942> cVar) {
            super(2, cVar);
            this.$request = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return OpenClawCoreAgentClient.this.new C10942(this.$request, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            b bVar = OpenClawCoreAgentClient.this.agentFrontClient;
            String str = null;
            Object[] objArr = 0;
            if (bVar == null) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, "syncHistory failed: client is null, sessionKey=" + this.$request.f1383a);
                return new z(null, false, "client is null", 1);
            }
            try {
                OpenClawCoreAgentClient.this.logger.i(OpenClawCoreAgentClient.TAG, "syncHistory: sessionKey=" + this.$request.f1383a);
                SyncHistoryResponse syncHistoryResponseP = bVar.p(new SyncHistoryRequest(this.$request.f1383a, str, 2, objArr == true ? 1 : 0));
                if (!syncHistoryResponseP.getSuccess()) {
                    return new z(null, false, syncHistoryResponseP.getErrorMessage(), 1);
                }
                List<SessionChatMessage> messages = syncHistoryResponseP.getMessages();
                ArrayList arrayList = new ArrayList(w.c0(messages, 10));
                for (SessionChatMessage sessionChatMessage : messages) {
                    arrayList.add(new u(sessionChatMessage.getId(), sessionChatMessage.getRole(), sessionChatMessage.getContent(), sessionChatMessage.getTime()));
                }
                return new z(arrayList, true, null, 4);
            } catch (Exception e) {
                OpenClawCoreAgentClient.this.logger.e(OpenClawCoreAgentClient.TAG, B7.a.n("syncHistory failed: sessionKey=", this.$request.f1383a, ", error=", e.getMessage()));
                return new z(null, false, e.getMessage(), 1);
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super z> cVar) {
            return ((C10942) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient", f = "OpenClawCoreAgentClient.kt", l = {955}, m = "vote", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10951(H7.c<? super C10951> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenClawCoreAgentClient.this.vote(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$sdkPushMessageListener$1] */
    public OpenClawCoreAgentClient(long j5) {
        this.timeOut = j5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    private final Message buildMessage(l request, String messageId, String traceId) {
        ?? arrayList;
        String type;
        MessageContent messageContent;
        List<AbstractC0262i> list = request.c;
        if (list != null) {
            arrayList = new ArrayList();
            for (AbstractC0262i abstractC0262i : list) {
                if (abstractC0262i instanceof C0260g) {
                    messageContent = new MessageContent("text", ((C0260g) abstractC0262i).b, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65532, null);
                } else if (abstractC0262i instanceof C0259f) {
                    C0259f c0259f = (C0259f) abstractC0262i;
                    c0259f.getClass();
                    messageContent = new MessageContent("image", null, null, c0259f.b, null, null, null, null, null, null, null, null, null, false, null, null, 65510, null);
                } else if (abstractC0262i instanceof C0256c) {
                    messageContent = new MessageContent(BffConstant.Type.Audio, null, null, ((C0256c) abstractC0262i).b, null, null, null, null, null, null, null, null, null, false, null, null, 65526, null);
                } else if (abstractC0262i instanceof C0261h) {
                    String str = ((C0261h) abstractC0262i).b;
                    messageContent = new MessageContent("video", null, null, str, str, null, null, null, null, null, null, null, null, false, null, null, 65510, null);
                } else if (abstractC0262i instanceof C0258e) {
                    C0258e c0258e = (C0258e) abstractC0262i;
                    messageContent = new MessageContent(BffConstant.Type.File, null, null, c0258e.b, null, null, null, null, c0258e.c, null, c0258e.e, null, null, false, null, null, 64246, null);
                } else {
                    messageContent = null;
                }
                if (messageContent != null) {
                    arrayList.add(messageContent);
                }
            }
        } else {
            arrayList = EmptyList.f4893a;
        }
        List list2 = arrayList;
        String str2 = request.e;
        if (list2.size() > 1) {
            type = "multi";
        } else {
            MessageContent messageContent2 = (MessageContent) D7.v.C0(list2);
            if (messageContent2 == null || (type = messageContent2.getType()) == null) {
                type = "text";
            }
        }
        return new Message(null, messageId, false, str2, BffConstant.Role.User, "normal", type, list2, null, null, 0, false, false, 0L, null, null, null, null, null, traceId, 524037, null);
    }

    private final com.zyql.agentfront.sdk.client.c createMessageCallback(RequestInfo requestInfo) {
        return new AnonymousClass1(requestInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b getOrCreateClient(Context context) {
        b bVar = this.agentFrontClient;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(context);
        this.agentFrontClient = bVar2;
        bVar2.n(this.sdkPushMessageListener);
        bVar2.c = new l7.b() { // from class: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$getOrCreateClient$1$1
            @Override // l7.b
            public void onBindFailed(String reason) {
                this.this$0.logger.e("OpenClawCoreAgentClient", "AgentFront bind failed: " + reason);
                if (reason == null) {
                    reason = "无法绑定 AgentFront 服务（请安装应用）";
                }
                List list = this.this$0.pendingQueue;
                k.e(list, "access$getPendingQueue$p(...)");
                OpenClawCoreAgentClient openClawCoreAgentClient = this.this$0;
                synchronized (list) {
                    try {
                        List<OpenClawCoreAgentClient.PendingRequest> list2 = openClawCoreAgentClient.pendingQueue;
                        k.e(list2, "access$getPendingQueue$p(...)");
                        for (OpenClawCoreAgentClient.PendingRequest pendingRequest : list2) {
                            pendingRequest.getRequestInfo().getListener().onFailure(pendingRequest.getRequestInfo().getRequest(), Integer.valueOf(AdapterErrorCode.ERROR_CLIENT_NOT_FOUND), reason);
                        }
                        openClawCoreAgentClient.pendingQueue.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }

            @Override // l7.b
            public void onConnected() {
                this.this$0.logger.i("OpenClawCoreAgentClient", "AgentFront connected");
                this.this$0.processPendingQueue();
            }

            @Override // l7.b
            public void onDisconnected() {
                this.this$0.logger.i("OpenClawCoreAgentClient", "AgentFront disconnected");
            }

            @Override // l7.b
            public void onRetrying(int retryCount, int maxRetry) {
                this.this$0.logger.i("OpenClawCoreAgentClient", androidx.compose.foundation.b.n(retryCount, maxRetry, "AgentFront retrying connecting: ", "/"));
            }
        };
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICancelHandle handleNormalChatRequest(l request, EventListener listener, b client) {
        String str = request.e;
        if (str != null && str.length() != 0 && request.f1364a.length() > 0) {
            Map<String, String> conversationAgentMap = this.conversationAgentMap;
            k.e(conversationAgentMap, "conversationAgentMap");
            conversationAgentMap.put(str, request.f1364a);
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        OpenClawCancelHandle openClawCancelHandle = new OpenClawCancelHandle(this, strValueOf);
        RequestInfo requestInfo = new RequestInfo(request, listener, openClawCancelHandle);
        String str2 = request.f1370j;
        Map<String, Boolean> activeRequests = this.activeRequests;
        k.e(activeRequests, "activeRequests");
        activeRequests.put(strValueOf, Boolean.FALSE);
        Message messageBuildMessage = buildMessage(request, strValueOf, str2);
        ILogger iLogger = this.logger;
        boolean zD = client.d();
        StringBuilder sbW = B7.a.w("chat: requestId=", strValueOf, ", traceId=", str2, " connected=");
        sbW.append(zD);
        iLogger.d(TAG, sbW.toString());
        if (!client.d()) {
            this.logger.i(TAG, "AgentFront not connected, queuing message: " + strValueOf);
            this.pendingQueue.add(new PendingRequest(strValueOf, str2, messageBuildMessage, requestInfo));
            try {
                client.h();
                return openClawCancelHandle;
            } catch (Exception e) {
                this.logger.e(TAG, "Failed to reconnect: " + e.getMessage());
                return openClawCancelHandle;
            }
        }
        this.logger.d(TAG, B7.a.n("Sending message, requestId=", strValueOf, ", traceId=", str2));
        try {
            client.m(messageBuildMessage, createMessageCallback(requestInfo));
            return openClawCancelHandle;
        } catch (Exception e6) {
            this.logger.e(TAG, "Failed to send message: " + e6.getMessage());
            this.activeRequests.remove(strValueOf);
            Integer numValueOf = Integer.valueOf(AdapterErrorCode.ERROR_AGENT_INTERNAL_ERROR);
            String message = e6.getMessage();
            if (message == null) {
                message = "发送消息失败";
            }
            listener.onFailure(request, numValueOf, message);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handlePushMessage(com.zyql.agentfront.bean.Message r23) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.handlePushMessage(com.zyql.agentfront.bean.Message):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence handlePushMessage$lambda$1(MessageContent it) {
        k.f(it, "it");
        String text = it.getText();
        return text != null ? text : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleRemoteToolEvent(com.zyql.agentfront.bean.Message r24, com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.RequestInfo r25) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.handleRemoteToolEvent(com.zyql.agentfront.bean.Message, com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$RequestInfo):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence handleRemoteToolEvent$lambda$1(MessageContent it) {
        k.f(it, "it");
        String text = it.getText();
        return text != null ? text : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleToolCall(String messageId, String toolCallId, String conversationId, String toolName, String arguments, String traceId) {
        String str;
        V4.k kVar;
        PushMessageListener pushMessageListener;
        this.logger.i(TAG, a.j(B7.a.w("handleToolCall: toolCallId=", toolCallId, ", toolName=", toolName, " messageId="), messageId, ", traceId=", traceId));
        try {
            try {
                FunctionCall functionCall = new FunctionCall(null, toolName, arguments == null ? "{}" : arguments, toolName, null, null, null, null, null, null, toolCallId, null, 3057, null);
                String str2 = this.conversationAgentMap.get(conversationId);
                if (str2 == null) {
                    str2 = "";
                }
                EmptyList emptyList = EmptyList.f4893a;
                System.currentTimeMillis();
                System.currentTimeMillis();
                str = "assistant";
                kVar = new V4.k(null, "assistant", conversationId, "tool_call", kotlin.collections.a.Q(new Pair("toolName", toolName)), null, null, 4, false, Integer.valueOf((int) System.currentTimeMillis()), 2, messageId, null, functionCall, 1533870001);
                kVar.k = str2;
                pushMessageListener = this.pushMessageListener;
            } catch (Exception e) {
                e = e;
                str = TAG;
            }
            try {
                if (pushMessageListener == null) {
                    this.logger.w(TAG, "handleToolCall: no PushMessageListener set, tool call not handled");
                } else {
                    this.logger.d(TAG, "handleToolCall: notifying PushMessageListener");
                    pushMessageListener.onToolCall(kVar);
                }
            } catch (Exception e6) {
                e = e6;
                this.logger.e(str, "Failed to handle tool call: " + e.getMessage());
            }
        } catch (Exception e9) {
            e = e9;
            str = TAG;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ICancelHandle handleToolOutputsRequest(l request, b client) {
        String str = request.e;
        if (str != null && str.length() != 0 && request.f1364a.length() > 0) {
            Map<String, String> conversationAgentMap = this.conversationAgentMap;
            k.e(conversationAgentMap, "conversationAgentMap");
            conversationAgentMap.put(str, request.f1364a);
        }
        String str2 = request.i;
        if (str2 == null || str2.length() == 0) {
            this.logger.w(TAG, "submitToolOutputs: request.chatId is null or empty");
            submitToolOutputs(request, client);
            return null;
        }
        this.logger.i(TAG, B7.a.n("submitToolOutputs: originalMessageId=", str2, ", agentId=", request.f1364a));
        if (!this.activeRequests.containsKey(str2)) {
            Map<String, Boolean> activeRequests = this.activeRequests;
            k.e(activeRequests, "activeRequests");
            activeRequests.put(str2, Boolean.FALSE);
        }
        OpenClawCancelHandle openClawCancelHandle = new OpenClawCancelHandle(this, str2);
        submitToolOutputs(request, client);
        return openClawCancelHandle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processPendingQueue() {
        List<PendingRequest> pendingQueue = this.pendingQueue;
        k.e(pendingQueue, "pendingQueue");
        synchronized (pendingQueue) {
            if (this.pendingQueue.isEmpty()) {
                return;
            }
            this.logger.i(TAG, "Processing pending queue, size=" + this.pendingQueue.size());
            b bVar = this.agentFrontClient;
            if (bVar == null) {
                return;
            }
            if (!bVar.d()) {
                this.logger.w(TAG, "Client not connected, cannot process pending queue");
                return;
            }
            Iterator<PendingRequest> it = this.pendingQueue.iterator();
            while (it.hasNext()) {
                PendingRequest next = it.next();
                try {
                    this.logger.d(TAG, "Sending pending message: " + next.getRequestId());
                    bVar.m(next.getMessage(), createMessageCallback(next.getRequestInfo()));
                    it.remove();
                } catch (Exception e) {
                    this.logger.e(TAG, "Failed to send pending message: " + e.getMessage());
                    EventListener listener = next.getRequestInfo().getListener();
                    l request = next.getRequestInfo().getRequest();
                    Integer numValueOf = Integer.valueOf(AdapterErrorCode.ERROR_AGENT_INTERNAL_ERROR);
                    String message = e.getMessage();
                    if (message == null) {
                        message = "发送消息失败";
                    }
                    listener.onFailure(request, numValueOf, message);
                    it.remove();
                }
            }
            this.logger.i(TAG, "Pending queue processed, remaining size=" + this.pendingQueue.size());
        }
    }

    private final void submitToolOutputs(l request, b client) {
        request.getClass();
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object batchDeleteTasks(A a3, H7.c<? super Boolean> cVar) {
        return super.batchDeleteTasks(a3, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object cancelTask(B b, H7.c<? super Boolean> cVar) {
        return super.cancelTask(b, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object chat(l lVar, EventListener eventListener, H7.c<? super ICancelHandle> cVar) {
        d.D(TAG, "request:" + ExtKt.toJson(lVar));
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(lVar, eventListener, null), cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object clearSession(String str, H7.c<? super r> cVar) throws Throwable {
        u9.d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C10882(str, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object createSession(H7.c<? super String> cVar) {
        return super.createSession(cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object deleteSession(String str, H7.c<? super r> cVar) throws Throwable {
        u9.d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C10892(str, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object deleteTask(C c, H7.c<? super Boolean> cVar) {
        return super.deleteTask(c, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void destroy() {
        this.pendingQueue.clear();
        this.conversationAgentMap.clear();
        this.pushMessageListener = null;
        b bVar = this.agentFrontClient;
        if (bVar != null) {
            try {
                bVar.i();
            } catch (Exception e) {
                this.logger.e(TAG, "Failed to destroy AgentFrontClient: " + e.getMessage());
            }
        }
        this.agentFrontClient = null;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object feedback(q qVar, H7.c<? super Boolean> cVar) {
        return super.feedback(qVar, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object getAgentDetail(AbstractC0255b abstractC0255b, H7.c<? super C0254a> cVar) {
        return super.getAgentDetail(abstractC0255b, cVar);
    }

    public final String getCHAT_ID() {
        return this.CHAT_ID;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void init(Context context, ILogger log) {
        k.f(context, "context");
        k.f(log, "log");
        this.logger = log;
        this.context = context.getApplicationContext();
        this.logger.i(TAG, "OpenClawCoreAgentClient initialized");
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object interactTask(D d, H7.c<? super Boolean> cVar) {
        return super.interactTask(d, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void onNetworkChanged(boolean isAvailable) {
        this.logger.d(TAG, "Network changed: " + isAvailable);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object pauseTask(F f, H7.c<? super Boolean> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10902(f, null), cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object readCoreFile(String str, H7.c<? super String> cVar) {
        return super.readCoreFile(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object readFile(String str, H7.c<? super String> cVar) {
        return super.readFile(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object renameSession(String str, String str2, H7.c<? super r> cVar) throws Throwable {
        u9.d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C10912(str, str2, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object renameTask(E e, H7.c<? super Boolean> cVar) {
        return super.renameTask(e, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object resumeTask(F f, H7.c<? super Boolean> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10922(f, null), cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object retryTask(G g, H7.c<? super Boolean> cVar) {
        return super.retryTask(g, cVar);
    }

    public final void setPushMessageCallback(PushMessageListener listener) {
        this.pushMessageListener = listener;
        Context context = this.context;
        if (context == null) {
            this.logger.e(TAG, "setPushMessageCallback failed. " + (listener != null) + "  ctx is null");
            return;
        }
        getOrCreateClient(context).n(listener != null ? this.sdkPushMessageListener : null);
        this.logger.d(TAG, "setPushMessageCallback: " + (listener != null));
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object syncConversations(H7.c<? super x> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10932(null), cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object syncHistory(y yVar, H7.c<? super z> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10942(yVar, null), cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object uploadFile(Context context, H h, p pVar, H7.c<? super r> cVar) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object vote(V4.I r8, H7.c<? super java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.lang.String r0 = " [Vote-4] HTTP请求成功! task_id="
            java.lang.String r1 = " [Vote-4-Response] 服务器响应成功: response="
            java.lang.String r2 = "vote request: "
            boolean r3 = r9 instanceof com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.C10951
            if (r3 == 0) goto L19
            r3 = r9
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1 r3 = (com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.C10951) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1 r3 = new com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1
            r3.<init>(r9)
        L1e:
            java.lang.Object r7 = r3.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r4 = r3.label
            r5 = 1
            java.lang.String r6 = "OpenClawCoreAgentClient"
            if (r4 == 0) goto L3d
            if (r4 != r5) goto L35
            java.lang.Object r8 = r3.L$0
            V4.I r8 = (V4.I) r8
            kotlin.b.b(r7)     // Catch: java.lang.Exception -> L33
            goto L67
        L33:
            r7 = move-exception
            goto L97
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.b.b(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r7.<init>(r2)     // Catch: java.lang.Exception -> L33
            r7.append(r8)     // Catch: java.lang.Exception -> L33
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L33
            com.stepos.statsrpk.d.D(r6, r7)     // Catch: java.lang.Exception -> L33
            com.stepos.net.HttpManager r7 = com.stepos.net.HttpManager.INSTANCE     // Catch: java.lang.Exception -> L33
            java.lang.String r2 = "__default__"
            java.lang.Class<com.stepos.agentframework.adapter.netcore.service.BffService> r4 = com.stepos.agentframework.adapter.netcore.service.BffService.class
            java.lang.Object r7 = r7.create(r4, r2)     // Catch: java.lang.Exception -> L33
            com.stepos.agentframework.adapter.netcore.service.BffService r7 = (com.stepos.agentframework.adapter.netcore.service.BffService) r7     // Catch: java.lang.Exception -> L33
            r3.L$0 = r8     // Catch: java.lang.Exception -> L33
            r3.label = r5     // Catch: java.lang.Exception -> L33
            r2 = 0
            java.lang.Object r7 = r7.vote(r2, r8, r3)     // Catch: java.lang.Exception -> L33
            if (r7 != r9) goto L67
            return r9
        L67:
            qa.L r7 = (qa.L) r7     // Catch: java.lang.Exception -> L33
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r9.<init>(r1)     // Catch: java.lang.Exception -> L33
            r9.append(r7)     // Catch: java.lang.Exception -> L33
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L33
            com.stepos.statsrpk.d.D(r6, r9)     // Catch: java.lang.Exception -> L33
            java.lang.String r8 = r8.getCom.stepos.ability.beaninternal.task.GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID java.lang.String()     // Catch: java.lang.Exception -> L33
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r9.<init>(r0)     // Catch: java.lang.Exception -> L33
            r9.append(r8)     // Catch: java.lang.Exception -> L33
            java.lang.String r8 = " 已上报到后端服务器"
            r9.append(r8)     // Catch: java.lang.Exception -> L33
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Exception -> L33
            com.stepos.statsrpk.d.D(r6, r8)     // Catch: java.lang.Exception -> L33
            F9.M r7 = r7.f5644a     // Catch: java.lang.Exception -> L33
            boolean r7 = r7.c()     // Catch: java.lang.Exception -> L33
            goto Lad
        L97:
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = " [Vote-4] HTTP请求失败: "
            r8.<init>(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.stepos.statsrpk.d.u(r6, r7)
            r7 = 0
        Lad:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.vote(V4.I, H7.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object writeCoreFile(String str, String str2, H7.c<? super Boolean> cVar) {
        return super.writeCoreFile(str, str2, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object writeFile(String str, String str2, H7.c<? super Boolean> cVar) {
        return super.writeFile(str, str2, cVar);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$PendingRequest;", "", "requestId", "", AgentBusWakeContract.EXTRA_TRACE_ID, "message", "Lcom/zyql/agentfront/bean/Message;", "requestInfo", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lcom/zyql/agentfront/bean/Message;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;)V", "getRequestId", "()Ljava/lang/String;", "getTraceId", "getMessage", "()Lcom/zyql/agentfront/bean/Message;", "getRequestInfo", "()Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$RequestInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "openclaw_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PendingRequest {
        private final Message message;
        private final String requestId;
        private final RequestInfo requestInfo;
        private final String traceId;

        public PendingRequest(String requestId, String str, Message message, RequestInfo requestInfo) {
            k.f(requestId, "requestId");
            k.f(message, "message");
            k.f(requestInfo, "requestInfo");
            this.requestId = requestId;
            this.traceId = str;
            this.message = message;
            this.requestInfo = requestInfo;
        }

        public static /* synthetic */ PendingRequest copy$default(PendingRequest pendingRequest, String str, String str2, Message message, RequestInfo requestInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pendingRequest.requestId;
            }
            if ((i & 2) != 0) {
                str2 = pendingRequest.traceId;
            }
            if ((i & 4) != 0) {
                message = pendingRequest.message;
            }
            if ((i & 8) != 0) {
                requestInfo = pendingRequest.requestInfo;
            }
            return pendingRequest.copy(str, str2, message, requestInfo);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* renamed from: component3, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final RequestInfo getRequestInfo() {
            return this.requestInfo;
        }

        public final PendingRequest copy(String requestId, String traceId, Message message, RequestInfo requestInfo) {
            k.f(requestId, "requestId");
            k.f(message, "message");
            k.f(requestInfo, "requestInfo");
            return new PendingRequest(requestId, traceId, message, requestInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingRequest)) {
                return false;
            }
            PendingRequest pendingRequest = (PendingRequest) other;
            return k.b(this.requestId, pendingRequest.requestId) && k.b(this.traceId, pendingRequest.traceId) && k.b(this.message, pendingRequest.message) && k.b(this.requestInfo, pendingRequest.requestInfo);
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getRequestId() {
            return this.requestId;
        }

        public final RequestInfo getRequestInfo() {
            return this.requestInfo;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public int hashCode() {
            int iHashCode = this.requestId.hashCode() * 31;
            String str = this.traceId;
            return ((this.message.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31) + this.requestInfo.hashCode();
        }

        public String toString() {
            String str = this.requestId;
            String str2 = this.traceId;
            Message message = this.message;
            RequestInfo requestInfo = this.requestInfo;
            StringBuilder sbW = B7.a.w("PendingRequest(requestId=", str, ", traceId=", str2, ", message=");
            sbW.append(message);
            sbW.append(", requestInfo=");
            sbW.append(requestInfo);
            sbW.append(")");
            return sbW.toString();
        }

        public /* synthetic */ PendingRequest(String str, String str2, Message message, RequestInfo requestInfo, int i, kotlin.jvm.internal.e eVar) {
            this(str, (i & 2) != 0 ? null : str2, message, requestInfo);
        }
    }
}
