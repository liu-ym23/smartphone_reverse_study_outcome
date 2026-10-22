package com.stepos.ability.agentbusclient;

import C7.r;
import D7.v;
import H7.c;
import P3.d;
import S7.n;
import S7.o;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusBindingBase;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.agentbus.generated.InvocationContext;
import com.uxsense.ApexSDK;
import j9.m;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.InterfaceC1733z;
import m9.c0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.t;
import w9.e;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003}~\u007fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u001a\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\bJ0\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0086@¢\u0006\u0004\b\u0018\u0010\u0015J0\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0086@¢\u0006\u0004\b\u0019\u0010\u0015J$\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\bJ\u000f\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b!\u0010 J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001bH\u0082@¢\u0006\u0004\b#\u0010$J,\u0010(\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100%H\u0082@¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001bH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u001bH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001bH\u0002¢\u0006\u0004\b.\u0010+J3\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001002\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\b1\u00102J%\u00103\u001a\u00020\u00102\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\b3\u00104J%\u00105\u001a\u00020\u00102\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\b5\u00104J\u001b\u00107\u001a\u0004\u0018\u00010\u00102\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b7\u00108J'\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001002\b\u00106\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b9\u0010:J%\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001002\u0006\u0010;\u001a\u00020\u001bH\u0002¢\u0006\u0004\b<\u0010=J3\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001002\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\b?\u00102J\u0019\u0010@\u001a\u0004\u0018\u00010\u00102\u0006\u0010;\u001a\u00020\u001bH\u0002¢\u0006\u0004\b@\u0010AJ'\u0010B\u001a\u0004\u0018\u00010\u00102\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\bB\u00104J%\u0010C\u001a\u00020\u00102\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\bC\u00104J6\u0010F\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0082@¢\u0006\u0004\bF\u0010GJ0\u0010J\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010H\u0082@¢\u0006\u0004\bJ\u0010KJ!\u0010L\u001a\u00020\u001b*\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002¢\u0006\u0004\bL\u0010MR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010NR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020P0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR^\u0010V\u001aL\u0012\u0004\u0012\u00020\u0010\u0012B\u0012@\b\u0001\u0012\u0004\u0012\u00020T\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00120U\u0012\u0006\u0012\u0004\u0018\u00010\u00010S0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010RR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00100W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR$\u0010Z\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010 \"\u0004\b]\u0010^R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u0004\u0018\u00010b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\be\u0010[R\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020\f0i8\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001d\u0010o\u001a\b\u0012\u0004\u0012\u00020n0i8\u0006¢\u0006\f\n\u0004\bo\u0010k\u001a\u0004\bp\u0010mR\u001b\u0010r\u001a\u00060qR\u00020\u00008\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001b\u0010w\u001a\u00060vR\u00020\u00008\u0006¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u0011\u0010{\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b{\u0010|¨\u0006\u0080\u0001"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;", "", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNode;", "impl", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AbilityAgentBusNode;)V", "LC7/r;", "start", "()V", "stop", "", "timeoutMs", "", "awaitConnected", "(JLH7/c;)Ljava/lang/Object;", "reconnect", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "params", "sendReq", "(Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", NotificationCompat.CATEGORY_EVENT, "payload", "sendEvent", "sendNodeEvent", "frameId", "Lorg/json/JSONObject;", "awaitResponse", "(Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "registerInvokeHandlers", "buildClientExtra", "()Ljava/lang/String;", "buildConnectParamsExtra", TypedValues.AttributesType.S_FRAME, "dispatchFrame", "(Lorg/json/JSONObject;LH7/c;)Ljava/lang/Object;", "", "added", "removed", "updateCapsInternal", "(Ljava/util/List;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "handleInvokeRequest", "(Lorg/json/JSONObject;)V", "isCancelFrame", "(Lorg/json/JSONObject;)Z", "handleCancelFrame", "result", "Lkotlin/Pair;", "extractHandlerFailure", "(Ljava/util/Map;)Lkotlin/Pair;", "extractErrorCode", "(Ljava/util/Map;)Ljava/lang/String;", "extractErrorMessage", "content", "extractTextFromContent", "(Ljava/lang/Object;)Ljava/lang/String;", "extractFailureFromContent", "(Ljava/lang/Object;)Lkotlin/Pair;", "obj", "extractFailureFromContentJson", "(Lorg/json/JSONObject;)Lkotlin/Pair;", "map", "extractFailureFromContentMap", "extractTextFromContentJson", "(Lorg/json/JSONObject;)Ljava/lang/String;", "extractTextFromContentMap", "buildInvokeResultJson", "invocationId", "nodeId", "sendInvokeOk", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "code", "message", "sendInvokeError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "toJsonObject", "(Ljava/util/Map;)Lorg/json/JSONObject;", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNode;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lm9/c0;", "runningInvokes", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function3;", "Lcom/stepos/agentbus/generated/InvocationContext;", "LH7/c;", "registeredTools", "", "caps", "Ljava/util/Set;", "packageName", "Ljava/lang/String;", "getPackageName", "setPackageName", "(Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicLong;", "capsRevision", "Ljava/util/concurrent/atomic/AtomicLong;", "Lw9/e;", "invokeSemaphore", "Lw9/e;", "defaultFailureCode", "Lcom/stepos/agentbus/generated/AgentBusBindingBase;", "base", "Lcom/stepos/agentbus/generated/AgentBusBindingBase;", "Lp9/t;", "connected", "Lp9/t;", "getConnected", "()Lp9/t;", "Lcom/stepos/agentbus/generated/AgentBusBindingBase$ConnectionStatus;", "status", "getStatus", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$HealthApi;", "health", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$HealthApi;", "getHealth", "()Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$HealthApi;", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$ToolsApi;", "tools", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$ToolsApi;", "getTools", "()Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$ToolsApi;", "isConnected", "()Z", "HealthApi", "ToolsApi", "InvocationContextImpl", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityAgentBusNodeAgentBusBinding {
    private final AgentBusBindingBase base;
    private final Set<String> caps;
    private final AtomicLong capsRevision;
    private final t connected;
    private final String defaultFailureCode;
    private final HealthApi health;
    private final AbilityAgentBusNode impl;
    private final e invokeSemaphore;
    private volatile String packageName;
    private final ConcurrentHashMap<String, o> registeredTools;
    private final ConcurrentHashMap<String, c0> runningInvokes;
    private final t status;
    private final ToolsApi tools;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$HealthApi;", "", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;)V", "Lp9/t;", "Lcom/stepos/agentbus/generated/HealthStatus;", "getService", "()Lp9/t;", NotificationCompat.CATEGORY_SERVICE, "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class HealthApi {
        public HealthApi() {
        }

        public final t getService() {
            return AbilityAgentBusNodeAgentBusBinding.this.base.getServiceHealth();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\b\u0010\tJ&\u0010\r\u001a\u00020\u00072\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$InvocationContextImpl;", "Lcom/stepos/agentbus/generated/InvocationContext;", "", "invocationId", "nodeId", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;Ljava/lang/String;Ljava/lang/String;)V", "LC7/r;", "ensureActive", "(LH7/c;)Ljava/lang/Object;", "", "", "progress", "reportProgress", "(Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "Ljava/lang/String;", "getInvocationId", "()Ljava/lang/String;", "getNodeId", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class InvocationContextImpl implements InvocationContext {
        private final String invocationId;
        private final String nodeId;
        final /* synthetic */ AbilityAgentBusNodeAgentBusBinding this$0;

        public InvocationContextImpl(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String invocationId, String nodeId) {
            k.f(invocationId, "invocationId");
            k.f(nodeId, "nodeId");
            this.this$0 = abilityAgentBusNodeAgentBusBinding;
            this.invocationId = invocationId;
            this.nodeId = nodeId;
        }

        @Override // com.stepos.agentbus.generated.InvocationContext
        public Object ensureActive(c<? super r> cVar) {
            kotlinx.coroutines.a.g(cVar.getContext());
            return r.f317a;
        }

        @Override // com.stepos.agentbus.generated.InvocationContext
        public String getInvocationId() {
            return this.invocationId;
        }

        @Override // com.stepos.agentbus.generated.InvocationContext
        public String getNodeId() {
            return this.nodeId;
        }

        @Override // com.stepos.agentbus.generated.InvocationContext
        public Object reportProgress(Map<String, ? extends Object> map, c<? super r> cVar) {
            LinkedHashMap linkedHashMapA0 = kotlin.collections.a.a0(map);
            linkedHashMapA0.put("invocationId", getInvocationId());
            Object objSendNodeEvent = this.this$0.base.sendNodeEvent("stepclaw.invoke.progress", linkedHashMapA0, cVar);
            return objSendNodeEvent == CoroutineSingletons.f4909a ? objSendNodeEvent : r.f317a;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042D\u0010\n\u001a@\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding$ToolsApi;", "", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;)V", "", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/Function3;", "Lcom/stepos/agentbus/generated/InvocationContext;", "", "LH7/c;", "handler", "LC7/r;", "register", "(Ljava/lang/String;LS7/o;)V", "unregister", "(Ljava/lang/String;)V", "", "added", "removed", "updateCaps", "(Ljava/util/List;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "", "listed", "()Ljava/util/Set;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class ToolsApi {
        public ToolsApi() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Object updateCaps$default(ToolsApi toolsApi, List list, List list2, c cVar, int i, Object obj) {
            if ((i & 2) != 0) {
                list2 = EmptyList.f4893a;
            }
            return toolsApi.updateCaps(list, list2, cVar);
        }

        public final Set<String> listed() {
            Set setKeySet = AbilityAgentBusNodeAgentBusBinding.this.registeredTools.keySet();
            k.e(setKeySet, "<get-keys>(...)");
            return v.j1(setKeySet);
        }

        public final void register(String name, o handler) {
            k.f(name, "name");
            k.f(handler, "handler");
            AbilityAgentBusNodeAgentBusBinding.this.registeredTools.put(name, handler);
            AbilityAgentBusNodeAgentBusBinding.this.caps.add(name);
            if (AbilityAgentBusNodeAgentBusBinding.this.isConnected()) {
                AbilityAgentBusNodeAgentBusBinding.this.base.launchOnScope(new AbilityAgentBusNodeAgentBusBinding$ToolsApi$register$1(AbilityAgentBusNodeAgentBusBinding.this, name, null));
            }
        }

        public final void unregister(String name) {
            k.f(name, "name");
            AbilityAgentBusNodeAgentBusBinding.this.registeredTools.remove(name);
            AbilityAgentBusNodeAgentBusBinding.this.caps.remove(name);
            if (AbilityAgentBusNodeAgentBusBinding.this.isConnected()) {
                AbilityAgentBusNodeAgentBusBinding.this.base.launchOnScope(new AbilityAgentBusNodeAgentBusBinding$ToolsApi$unregister$1(AbilityAgentBusNodeAgentBusBinding.this, name, null));
            }
        }

        public final Object updateCaps(List<String> list, List<String> list2, c<? super r> cVar) {
            AbilityAgentBusNodeAgentBusBinding.this.caps.addAll(list);
            AbilityAgentBusNodeAgentBusBinding.this.caps.removeAll(v.j1(list2));
            Object objUpdateCapsInternal = AbilityAgentBusNodeAgentBusBinding.this.updateCapsInternal(list, list2, cVar);
            return objUpdateCapsInternal == CoroutineSingletons.f4909a ? objUpdateCapsInternal : r.f317a;
        }
    }

    @J7.c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$handleCancelFrame$1", f = "AbilityAgentBusNodeAgentBusBinding.kt", l = {244}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$handleCancelFrame$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ String $invocationId;
        final /* synthetic */ String $reason;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$invocationId = str;
            this.$reason = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<r> create(Object obj, c<?> cVar) {
            return AbilityAgentBusNodeAgentBusBinding.this.new AnonymousClass1(this.$invocationId, this.$reason, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    b.b(obj);
                    AbilityAgentBusNode abilityAgentBusNode = AbilityAgentBusNodeAgentBusBinding.this.impl;
                    String str = this.$invocationId;
                    k.c(str);
                    String str2 = this.$reason;
                    k.c(str2);
                    this.label = 1;
                    if (abilityAgentBusNode.onCancel(str, str2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
            } catch (Throwable unused) {
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$1", f = "AbilityAgentBusNodeAgentBusBinding.kt", l = {190}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10231 extends SuspendLambda implements n {
        final /* synthetic */ String $invocationId;
        final /* synthetic */ String $nodeIdStr;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10231(String str, String str2, c<? super C10231> cVar) {
            super(2, cVar);
            this.$invocationId = str;
            this.$nodeIdStr = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<r> create(Object obj, c<?> cVar) {
            return AbilityAgentBusNodeAgentBusBinding.this.new C10231(this.$invocationId, this.$nodeIdStr, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding = AbilityAgentBusNodeAgentBusBinding.this;
                String str = this.$invocationId;
                k.c(str);
                String str2 = this.$nodeIdStr;
                k.c(str2);
                this.label = 1;
                if (abilityAgentBusNodeAgentBusBinding.sendInvokeError(str, str2, "STEPCLAW_RATE_LIMITED", "node max concurrent invokes (0) reached", this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, c<? super r> cVar) {
            return ((C10231) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$registerInvokeHandlers$1", f = "AbilityAgentBusNodeAgentBusBinding.kt", l = {138}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n"}, d2 = {"<anonymous>", "", "", "", "Lcom/stepos/agentbus/generated/InvocationContext;", "args"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$registerInvokeHandlers$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10241 extends SuspendLambda implements o {
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;

        public C10241(c<? super C10241> cVar) {
            super(3, cVar);
        }

        @Override // S7.o
        public final Object invoke(InvocationContext invocationContext, Map<String, ? extends Object> map, c<? super Map<String, ? extends Object>> cVar) {
            C10241 c10241 = AbilityAgentBusNodeAgentBusBinding.this.new C10241(cVar);
            c10241.L$0 = map;
            return c10241.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map map = (Map) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            String strOptString = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD) || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD)) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD);
            String strOptString2 = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has("invokeParamsJson") || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull("invokeParamsJson")) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString("invokeParamsJson");
            String strOptString3 = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has(Key.KEY_TOOL_CALL_ID) || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull(Key.KEY_TOOL_CALL_ID)) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString(Key.KEY_TOOL_CALL_ID);
            String strOptString4 = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has("toolId") || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull("toolId")) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString("toolId");
            String strOptString5 = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has(AgentBusWakeContract.EXTRA_TRACE_ID) || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull(AgentBusWakeContract.EXTRA_TRACE_ID)) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString(AgentBusWakeContract.EXTRA_TRACE_ID);
            String strOptString6 = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has("sessionId") || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull("sessionId")) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString("sessionId");
            String strOptString7 = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has("serviceName") || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull("serviceName")) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString("serviceName");
            Long l = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has("timeoutMs") || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull("timeoutMs")) ? null : new Long(AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optLong("timeoutMs"));
            AbilityAgentBusNode abilityAgentBusNode = AbilityAgentBusNodeAgentBusBinding.this.impl;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.L$5 = null;
            this.L$6 = null;
            this.L$7 = null;
            this.L$8 = null;
            this.label = 1;
            Object objAbilityCall = abilityAgentBusNode.abilityCall(strOptString, strOptString2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, l, this);
            return objAbilityCall == coroutineSingletons ? coroutineSingletons : objAbilityCall;
        }
    }

    @J7.c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$registerInvokeHandlers$2", f = "AbilityAgentBusNodeAgentBusBinding.kt", l = {142}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n"}, d2 = {"<anonymous>", "", "", "", "Lcom/stepos/agentbus/generated/InvocationContext;", "args"}, k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding$registerInvokeHandlers$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements o {
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(3, cVar);
        }

        @Override // S7.o
        public final Object invoke(InvocationContext invocationContext, Map<String, ? extends Object> map, c<? super Map<String, ? extends Object>> cVar) {
            AnonymousClass2 anonymousClass2 = AbilityAgentBusNodeAgentBusBinding.this.new AnonymousClass2(cVar);
            anonymousClass2.L$0 = map;
            return anonymousClass2.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Map map = (Map) this.L$0;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            String strOptString = (!AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).has("appNamesJson") || AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).isNull("appNamesJson")) ? null : AbilityAgentBusNodeAgentBusBinding.this.toJsonObject(map).optString("appNamesJson");
            AbilityAgentBusNode abilityAgentBusNode = AbilityAgentBusNodeAgentBusBinding.this.impl;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            Object objAbilityList = abilityAgentBusNode.abilityList(strOptString, this);
            return objAbilityList == coroutineSingletons ? coroutineSingletons : objAbilityList;
        }
    }

    public AbilityAgentBusNodeAgentBusBinding(AbilityAgentBusNode impl) {
        k.f(impl, "impl");
        this.impl = impl;
        this.runningInvokes = new ConcurrentHashMap<>();
        this.registeredTools = new ConcurrentHashMap<>();
        HashSet hashSet = new HashSet();
        hashSet.addAll(H4.o.N(AbilityAgentBusNodeKt.ABILITY_CALL_COMMAND, AbilityAgentBusNodeKt.ABILITY_LIST_COMMAND));
        this.caps = hashSet;
        this.capsRevision = new AtomicLong(0L);
        this.invokeSemaphore = null;
        this.defaultFailureCode = "10002";
        d dVar = new d(27);
        AbilityAgentBusNodeAgentBusBinding$base$2 abilityAgentBusNodeAgentBusBinding$base$2 = new AbilityAgentBusNodeAgentBusBinding$base$2(this);
        final int i = 0;
        S7.a aVar = new S7.a(this) { // from class: com.stepos.ability.agentbusclient.a
            public final /* synthetic */ AbilityAgentBusNodeAgentBusBinding b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding = this.b;
                switch (i6) {
                    case 0:
                        return abilityAgentBusNodeAgentBusBinding.buildClientExtra();
                    default:
                        return abilityAgentBusNodeAgentBusBinding.buildConnectParamsExtra();
                }
            }
        };
        final int i6 = 1;
        AgentBusBindingBase agentBusBindingBase = new AgentBusBindingBase("agentbus", dVar, "Ability AgentBus bridge", ApexSDK.VERSION, "node", "n-", 1000L, 3, 3, abilityAgentBusNodeAgentBusBinding$base$2, aVar, new S7.a(this) { // from class: com.stepos.ability.agentbusclient.a
            public final /* synthetic */ AbilityAgentBusNodeAgentBusBinding b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding = this.b;
                switch (i62) {
                    case 0:
                        return abilityAgentBusNodeAgentBusBinding.buildClientExtra();
                    default:
                        return abilityAgentBusNodeAgentBusBinding.buildConnectParamsExtra();
                }
            }
        }, 0L, 4096, null);
        this.base = agentBusBindingBase;
        this.connected = agentBusBindingBase.getConnected();
        this.status = agentBusBindingBase.getStatus();
        this.health = new HealthApi();
        this.tools = new ToolsApi();
    }

    public static /* synthetic */ Object awaitConnected$default(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, long j5, c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = 5000;
        }
        return abilityAgentBusNodeAgentBusBinding.awaitConnected(j5, cVar);
    }

    public static /* synthetic */ Object awaitResponse$default(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String str, long j5, c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 10000;
        }
        return abilityAgentBusNodeAgentBusBinding.awaitResponse(str, j5, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String base$lambda$0() {
        return "com.stepos.ability.agentbus";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildClientExtra() {
        String strM;
        String str = this.packageName;
        return (str == null || (strM = B7.a.m(",\"packageName\":\"", str, "\"")) == null) ? "" : strM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildConnectParamsExtra() {
        String string = new JSONArray((Collection<?>) v.f1(this.caps)).toString();
        k.e(string, "toString(...)");
        return ",\"caps\":".concat(string);
    }

    private final String buildInvokeResultJson(Map<String, ? extends Object> params) {
        return androidx.appfunctions.metadata.a.m("{\"type\":\"req\",\"id\":", this.base.jsonEscape(androidx.compose.foundation.b.p(System.nanoTime(), "iv-res-")), ",\"method\":\"node.invoke.result\",\"params\":", this.base.toJsonString(params), "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchFrame(JSONObject jSONObject, c<? super r> cVar) {
        if (k.b(jSONObject.optString(NotificationCompat.CATEGORY_EVENT), "node.invoke.request")) {
            handleInvokeRequest(jSONObject);
        } else if (isCancelFrame(jSONObject)) {
            handleCancelFrame(jSONObject);
        }
        return r.f317a;
    }

    private final String extractErrorCode(Map<String, ? extends Object> result) {
        String string;
        String string2;
        String string3;
        Object obj = result.get("errorCode");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        Object obj2 = result.get("errorCode");
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        if (number != null && (string3 = number.toString()) != null) {
            if (string3.length() <= 0) {
                string3 = null;
            }
            if (string3 != null) {
                return string3;
            }
        }
        Object obj3 = result.get("error");
        Map map = obj3 instanceof Map ? (Map) obj3 : null;
        Object obj4 = map != null ? map.get("code") : null;
        String str2 = obj4 instanceof String ? (String) obj4 : null;
        if (str2 != null) {
            if (str2.length() <= 0) {
                str2 = null;
            }
            if (str2 != null) {
                return str2;
            }
        }
        Object obj5 = map != null ? map.get("code") : null;
        Number number2 = obj5 instanceof Number ? (Number) obj5 : null;
        if (number2 != null && (string2 = number2.toString()) != null) {
            if (string2.length() <= 0) {
                string2 = null;
            }
            if (string2 != null) {
                return string2;
            }
        }
        Object obj6 = result.get("meta");
        Map map2 = obj6 instanceof Map ? (Map) obj6 : null;
        Object obj7 = map2 != null ? map2.get("code") : null;
        String str3 = obj7 instanceof String ? (String) obj7 : null;
        if (str3 != null) {
            if (str3.length() <= 0) {
                str3 = null;
            }
            if (str3 != null) {
                return str3;
            }
        }
        Object obj8 = map2 != null ? map2.get("code") : null;
        Number number3 = obj8 instanceof Number ? (Number) obj8 : null;
        if (number3 != null && (string = number3.toString()) != null) {
            String str4 = string.length() > 0 ? string : null;
            if (str4 != null) {
                return str4;
            }
        }
        return this.defaultFailureCode;
    }

    private final String extractErrorMessage(Map<String, ? extends Object> result) {
        Object obj = result.get("errorMessage");
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        Object obj2 = result.get("error");
        Map map = obj2 instanceof Map ? (Map) obj2 : null;
        Object obj3 = map != null ? map.get("message") : null;
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        if (str2 != null) {
            String str3 = str2.length() > 0 ? str2 : null;
            if (str3 != null) {
                return str3;
            }
        }
        String strExtractTextFromContent = extractTextFromContent(result.get("content"));
        return strExtractTextFromContent != null ? strExtractTextFromContent : "ability call failed";
    }

    private final Pair<String, String> extractFailureFromContent(Object content) {
        Object objA;
        if (content instanceof String) {
            String string = m.R0((String) content).toString();
            if (j9.t.e0(string, "{", false)) {
                try {
                    objA = new JSONObject(string);
                } catch (Throwable th) {
                    objA = b.a(th);
                }
                if (objA instanceof Result.Failure) {
                    objA = null;
                }
                JSONObject jSONObject = (JSONObject) objA;
                if (jSONObject != null) {
                    return extractFailureFromContentJson(jSONObject);
                }
            }
        } else if (content instanceof Map) {
            k.d(content, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            return extractFailureFromContentMap((Map) content);
        }
        return null;
    }

    private final Pair<String, String> extractFailureFromContentJson(JSONObject obj) {
        String strOptString;
        String str = null;
        if (!obj.optBoolean("isError", false)) {
            JSONArray jSONArrayOptJSONArray = obj.optJSONArray("content");
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString("text");
                    k.c(strOptString2);
                    if (m.h0(strOptString2, "Execution Error", true)) {
                        return new Pair<>(this.defaultFailureCode, strOptString2);
                    }
                }
            }
            return null;
        }
        String strOptString3 = obj.optString("code");
        k.c(strOptString3);
        if (strOptString3.length() <= 0) {
            strOptString3 = null;
        }
        if (strOptString3 == null) {
            JSONObject jSONObjectOptJSONObject2 = obj.optJSONObject("meta");
            if (jSONObjectOptJSONObject2 != null && (strOptString = jSONObjectOptJSONObject2.optString("code")) != null && strOptString.length() > 0) {
                str = strOptString;
            }
            strOptString3 = str == null ? this.defaultFailureCode : str;
        }
        String strExtractTextFromContentJson = extractTextFromContentJson(obj);
        if (strExtractTextFromContentJson == null) {
            strExtractTextFromContentJson = "ability call failed";
        }
        return new Pair<>(strOptString3, strExtractTextFromContentJson);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.String, java.lang.String> extractFailureFromContentMap(java.util.Map<java.lang.String, ? extends java.lang.Object> r4) {
        /*
            r3 = this;
            java.lang.String r0 = "isError"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.lang.Boolean
            r2 = 0
            if (r1 == 0) goto Le
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            goto Lf
        Le:
            r0 = r2
        Lf:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.k.b(r0, r1)
            if (r0 == 0) goto L4e
            java.lang.String r0 = "meta"
            java.lang.Object r0 = r4.get(r0)
            boolean r1 = r0 instanceof java.util.Map
            if (r1 == 0) goto L24
            java.util.Map r0 = (java.util.Map) r0
            goto L25
        L24:
            r0 = r2
        L25:
            if (r0 == 0) goto L3e
            java.lang.String r1 = "code"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L3e
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L3e
            int r1 = r0.length()
            if (r1 <= 0) goto L3c
            r2 = r0
        L3c:
            if (r2 != 0) goto L40
        L3e:
            java.lang.String r2 = r3.defaultFailureCode
        L40:
            java.lang.String r3 = r3.extractTextFromContentMap(r4)
            if (r3 != 0) goto L48
            java.lang.String r3 = "ability call failed"
        L48:
            kotlin.Pair r4 = new kotlin.Pair
            r4.<init>(r2, r3)
            return r4
        L4e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityAgentBusNodeAgentBusBinding.extractFailureFromContentMap(java.util.Map):kotlin.Pair");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<String, String> extractHandlerFailure(Map<String, ? extends Object> result) {
        Object obj = result.get("ok");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (k.b(bool, Boolean.FALSE)) {
            return new Pair<>(extractErrorCode(result), extractErrorMessage(result));
        }
        Boolean bool2 = Boolean.TRUE;
        if (k.b(bool, bool2)) {
            return null;
        }
        if (bool != null) {
            throw new NoWhenBranchMatchedException();
        }
        Object obj2 = result.get("isError");
        return k.b(obj2 instanceof Boolean ? (Boolean) obj2 : null, bool2) ? new Pair<>(extractErrorCode(result), extractErrorMessage(result)) : extractFailureFromContent(result.get("content"));
    }

    private final String extractTextFromContent(Object content) {
        Object objA;
        if (!(content instanceof String)) {
            if (content instanceof Map) {
                k.d(content, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                return extractTextFromContentMap((Map) content);
            }
            if (content instanceof List) {
                Object objC0 = v.C0((List) content);
                Map map = objC0 instanceof Map ? (Map) objC0 : null;
                Object obj = map != null ? map.get("text") : null;
                String str = obj instanceof String ? (String) obj : null;
                if (str != null && str.length() > 0) {
                    return str;
                }
            }
            return null;
        }
        String string = m.R0((String) content).toString();
        if (j9.t.e0(string, "{", false) || j9.t.e0(string, "[", false)) {
            try {
                objA = extractTextFromContentJson(new JSONObject(string));
            } catch (Throwable th) {
                objA = b.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            String str2 = (String) objA;
            if (str2 != null) {
                return str2;
            }
        }
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    private final String extractTextFromContentJson(JSONObject obj) {
        JSONArray jSONArrayOptJSONArray = obj.optJSONArray("content");
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("text") : null;
                if (strOptString == null) {
                    strOptString = "";
                }
                if (strOptString.length() > 0) {
                    return strOptString;
                }
            }
        }
        String strOptString2 = obj.optString("text");
        k.c(strOptString2);
        if (strOptString2.length() > 0) {
            return strOptString2;
        }
        return null;
    }

    private final String extractTextFromContentMap(Map<String, ? extends Object> map) {
        Object obj = map.get("content");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            for (Object obj2 : list) {
                Map map2 = obj2 instanceof Map ? (Map) obj2 : null;
                Object obj3 = map2 != null ? map2.get("text") : null;
                String str = obj3 instanceof String ? (String) obj3 : null;
                if (str != null && str.length() != 0) {
                    return str;
                }
            }
        }
        Object obj4 = map.get("text");
        if (obj4 instanceof String) {
            return (String) obj4;
        }
        return null;
    }

    private final void handleCancelFrame(JSONObject frame) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = frame.optJSONObject("params");
        if ((jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("payload")) == null) && (jSONObjectOptJSONObject = frame.optJSONObject("params")) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("invocationId");
        if (strOptString.length() == 0) {
            strOptString = jSONObjectOptJSONObject.optString("id");
        }
        String strOptString2 = jSONObjectOptJSONObject.optString("reason", "agent.cancel");
        k.c(strOptString);
        if (strOptString.length() == 0) {
            return;
        }
        c0 c0VarRemove = this.runningInvokes.remove(strOptString);
        if (c0VarRemove != null) {
            c0VarRemove.cancel(null);
        }
        this.base.launchOnScope(new AnonymousClass1(strOptString, strOptString2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleInvokeRequest(JSONObject frame) {
        JSONObject jSONObjectOptJSONObject = frame.optJSONObject("payload");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("id");
        String strOptString2 = jSONObjectOptJSONObject.optString("nodeId");
        String strOptString3 = jSONObjectOptJSONObject.optString("command");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("params");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        }
        Map<String, Object> mapJsonObjectToMap = this.base.jsonObjectToMap(jSONObjectOptJSONObject2);
        e eVar = this.invokeSemaphore;
        if (eVar != 0 && !((kotlinx.coroutines.sync.b) eVar).d()) {
            this.base.launchOnScope(new C10231(strOptString, strOptString2, null));
        } else {
            this.runningInvokes.put(strOptString, this.base.launchOnScope(new AbilityAgentBusNodeAgentBusBinding$handleInvokeRequest$job$1(this, strOptString3, strOptString, strOptString2, mapJsonObjectToMap, eVar, null)));
        }
    }

    private final boolean isCancelFrame(JSONObject frame) {
        if (k.b(frame.optString(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD), "stepclaw.invoke.cancel")) {
            return true;
        }
        if (!k.b(frame.optString(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD), "node.event")) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject = frame.optJSONObject("params");
        return k.b(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(NotificationCompat.CATEGORY_EVENT) : null, "stepclaw.invoke.cancel");
    }

    private final void registerInvokeHandlers() {
        this.tools.register(AbilityAgentBusNodeKt.ABILITY_CALL_COMMAND, new C10241(null));
        this.tools.register(AbilityAgentBusNodeKt.ABILITY_LIST_COMMAND, new AnonymousClass2(null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendEvent$default(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String str, Map map, c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        return abilityAgentBusNodeAgentBusBinding.sendEvent(str, map, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendInvokeError(String str, String str2, String str3, String str4, c<? super r> cVar) throws Throwable {
        Object objWriteRawFrame = this.base.writeRawFrame(buildInvokeResultJson(kotlin.collections.a.R(new Pair("id", str), new Pair("nodeId", str2), new Pair("ok", Boolean.FALSE), new Pair("error", kotlin.collections.a.R(new Pair("code", str3), new Pair("message", str4))))), cVar);
        return objWriteRawFrame == CoroutineSingletons.f4909a ? objWriteRawFrame : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object sendInvokeOk(String str, String str2, Map<String, ? extends Object> map, c<? super r> cVar) throws Throwable {
        Object objWriteRawFrame = this.base.writeRawFrame(buildInvokeResultJson(kotlin.collections.a.R(new Pair("id", str), new Pair("nodeId", str2), new Pair("ok", Boolean.TRUE), new Pair("payload", map))), cVar);
        return objWriteRawFrame == CoroutineSingletons.f4909a ? objWriteRawFrame : r.f317a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendNodeEvent$default(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String str, Map map, c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        return abilityAgentBusNodeAgentBusBinding.sendNodeEvent(str, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendReq$default(AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding, String str, Map map, c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        return abilityAgentBusNodeAgentBusBinding.sendReq(str, map, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject toJsonObject(Map<String, ? extends Object> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), this.base.toJsonValue(entry.getValue()));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCapsInternal(List<String> list, List<String> list2, c<? super r> cVar) {
        Object objSendNodeEvent = this.base.sendNodeEvent("stepclaw.caps.update", kotlin.collections.a.R(new Pair("nodeId", "com.stepos.ability.agentbus"), new Pair("added", list), new Pair("removed", list2), new Pair("revision", new Long(this.capsRevision.incrementAndGet()))), cVar);
        return objSendNodeEvent == CoroutineSingletons.f4909a ? objSendNodeEvent : r.f317a;
    }

    public final Object awaitConnected(long j5, c<? super Boolean> cVar) {
        return this.base.awaitConnected(j5, cVar);
    }

    public final Object awaitResponse(String str, long j5, c<? super JSONObject> cVar) {
        return this.base.awaitResponse(str, j5, cVar);
    }

    public final t getConnected() {
        return this.connected;
    }

    public final HealthApi getHealth() {
        return this.health;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final t getStatus() {
        return this.status;
    }

    public final ToolsApi getTools() {
        return this.tools;
    }

    public final boolean isConnected() {
        return this.base.isConnected();
    }

    public final void reconnect() {
        this.base.reconnect();
    }

    public final Object sendEvent(String str, Map<String, ? extends Object> map, c<? super String> cVar) {
        return this.base.sendEvent(str, map, cVar);
    }

    public final Object sendNodeEvent(String str, Map<String, ? extends Object> map, c<? super String> cVar) {
        return this.base.sendNodeEvent(str, map, cVar);
    }

    public final Object sendReq(String str, Map<String, ? extends Object> map, c<? super String> cVar) {
        return this.base.sendReq(str, map, cVar);
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void start() {
        registerInvokeHandlers();
        this.base.start();
    }

    public final void stop() {
        this.base.stop();
    }
}
