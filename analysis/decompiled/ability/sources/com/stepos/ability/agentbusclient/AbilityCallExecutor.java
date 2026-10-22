package com.stepos.ability.agentbusclient;

import C7.r;
import D7.q;
import J7.c;
import S7.n;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.agentbusclient.AbilityCallExecutor;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.TaskError;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.common.TaskStatus;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.ability.sdk.client.f;
import com.stepos.ability.sdk.client.g;
import com.stepos.ability.sdk.client.h;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import dagger.hilt.android.qualifiers.ApplicationContext;
import j9.m;
import j9.t;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import m9.r0;
import org.json.JSONObject;
import u9.d;
import w0.C2085f;
import z2.l;

@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 42\u00020\u0001:\u0003564B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0015\u001a\u00020\u00062\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u0004\u0018\u00010\t*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u00020\t*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010&J4\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0086@¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;", "", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ParsedCall;", "parsed", "", "", "awaitToolTaskResult", "(Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ParsedCall;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/agentbusclient/PendingAuth;", "pending", "resultJson", "Landroid/os/Bundle;", "taskBundle", "LC7/r;", "publishResume", "(Lcom/stepos/ability/agentbusclient/PendingAuth;Ljava/lang/String;Landroid/os/Bundle;LH7/c;)Ljava/lang/Object;", "args", "parseArgs", "(Ljava/util/Map;)Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ParsedCall;", "code", "message", "errorPayload", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "key", TypedValues.Custom.S_STRING, "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "", "long", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Long;", "readTraceId", "(Ljava/util/Map;)Ljava/lang/String;", "json", "Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ToolTaskResponse;", "parseGuiTaskResponse", "(Ljava/lang/String;)Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ToolTaskResponse;", "execute", "(Ljava/util/Map;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Lcom/stepos/ability/agentbusclient/ResumeSender;", "resumeSender", "Lcom/stepos/ability/agentbusclient/ResumeSender;", "getResumeSender", "()Lcom/stepos/ability/agentbusclient/ResumeSender;", "setResumeSender", "(Lcom/stepos/ability/agentbusclient/ResumeSender;)V", "Lm9/z;", "resumeScope", "Lm9/z;", "Companion", "ParsedCall", "ToolTaskResponse", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityCallExecutor {
    private static final Companion Companion = new Companion(null);
    private static final long DEFAULT_TIMEOUT_MS = 600000;
    private static final String GUI_AGENT_METHOD = "gui_agent";
    private static final String GUI_TOOL_ID = "0";
    private static final String TAG = "AbilityCallExecutor";
    private static final Set<Integer> TERMINAL_STATUSES;
    private final Context context;
    private final InterfaceC1733z resumeScope;
    private volatile ResumeSender resumeSender;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "DEFAULT_TIMEOUT_MS", "", "TERMINAL_STATUSES", "", "", "GUI_TOOL_ID", "GUI_AGENT_METHOD", "isSuccessTerminal", "", "task", "Lcom/stepos/ability/bean/Task;", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TaskStatus.values().length];
                try {
                    C2085f c2085f = TaskStatus.b;
                    iArr[4] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    C2085f c2085f2 = TaskStatus.b;
                    iArr[6] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSuccessTerminal(Task task) {
            Object next;
            C2085f c2085f = TaskStatus.b;
            int status = task.getStatus();
            c2085f.getClass();
            Iterator<E> it = TaskStatus.f3077q.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((TaskStatus) next).f3078a == status) {
                    break;
                }
            }
            TaskStatus taskStatus = (TaskStatus) next;
            int i = taskStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[taskStatus.ordinal()];
            return i == 1 || (i == 2 && task.getTaskType() == 1);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0016\u001a\u00020\u0003H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ParsedCall;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "paramsJson", Key.KEY_TOOL_CALL_ID, "toolId", AgentBusWakeContract.EXTRA_TRACE_ID, "sessionId", "timeoutMs", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getMethod", "()Ljava/lang/String;", "getParamsJson", "getToolCallId", "getToolId", "getTraceId", "getSessionId", "getTimeoutMs", "()J", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ParsedCall {
        private final String method;
        private final String paramsJson;
        private final String sessionId;
        private final long timeoutMs;
        private final String toolCallId;
        private final String toolId;
        private final String traceId;

        public ParsedCall(String method, String paramsJson, String toolCallId, String toolId, String traceId, String sessionId, long j5) {
            k.f(method, "method");
            k.f(paramsJson, "paramsJson");
            k.f(toolCallId, "toolCallId");
            k.f(toolId, "toolId");
            k.f(traceId, "traceId");
            k.f(sessionId, "sessionId");
            this.method = method;
            this.paramsJson = paramsJson;
            this.toolCallId = toolCallId;
            this.toolId = toolId;
            this.traceId = traceId;
            this.sessionId = sessionId;
            this.timeoutMs = j5;
        }

        public static /* synthetic */ ParsedCall copy$default(ParsedCall parsedCall, String str, String str2, String str3, String str4, String str5, String str6, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parsedCall.method;
            }
            if ((i & 2) != 0) {
                str2 = parsedCall.paramsJson;
            }
            if ((i & 4) != 0) {
                str3 = parsedCall.toolCallId;
            }
            if ((i & 8) != 0) {
                str4 = parsedCall.toolId;
            }
            if ((i & 16) != 0) {
                str5 = parsedCall.traceId;
            }
            if ((i & 32) != 0) {
                str6 = parsedCall.sessionId;
            }
            if ((i & 64) != 0) {
                j5 = parsedCall.timeoutMs;
            }
            long j6 = j5;
            String str7 = str5;
            String str8 = str6;
            return parsedCall.copy(str, str2, str3, str4, str7, str8, j6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMethod() {
            return this.method;
        }

        /* renamed from: component2, reason: from getter */
        public final String getParamsJson() {
            return this.paramsJson;
        }

        /* renamed from: component3, reason: from getter */
        public final String getToolCallId() {
            return this.toolCallId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getToolId() {
            return this.toolId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        /* renamed from: component6, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component7, reason: from getter */
        public final long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final ParsedCall copy(String method, String paramsJson, String toolCallId, String toolId, String traceId, String sessionId, long timeoutMs) {
            k.f(method, "method");
            k.f(paramsJson, "paramsJson");
            k.f(toolCallId, "toolCallId");
            k.f(toolId, "toolId");
            k.f(traceId, "traceId");
            k.f(sessionId, "sessionId");
            return new ParsedCall(method, paramsJson, toolCallId, toolId, traceId, sessionId, timeoutMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedCall)) {
                return false;
            }
            ParsedCall parsedCall = (ParsedCall) other;
            return k.b(this.method, parsedCall.method) && k.b(this.paramsJson, parsedCall.paramsJson) && k.b(this.toolCallId, parsedCall.toolCallId) && k.b(this.toolId, parsedCall.toolId) && k.b(this.traceId, parsedCall.traceId) && k.b(this.sessionId, parsedCall.sessionId) && this.timeoutMs == parsedCall.timeoutMs;
        }

        public final String getMethod() {
            return this.method;
        }

        public final String getParamsJson() {
            return this.paramsJson;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final String getToolCallId() {
            return this.toolCallId;
        }

        public final String getToolId() {
            return this.toolId;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public int hashCode() {
            return Long.hashCode(this.timeoutMs) + B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(this.method.hashCode() * 31, 31, this.paramsJson), 31, this.toolCallId), 31, this.toolId), 31, this.traceId), 31, this.sessionId);
        }

        public String toString() {
            String str = this.method;
            String str2 = this.toolCallId;
            String str3 = this.toolId;
            String str4 = this.traceId;
            String str5 = this.sessionId;
            long j5 = this.timeoutMs;
            boolean z10 = !m.s0(this.paramsJson);
            StringBuilder sbW = B7.a.w("ParsedCall(method=", str, ", toolCallId=", str2, ", toolId=");
            androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", traceId=", str4, ", sessionId=");
            B7.a.y(j5, str5, ", timeoutMs=", sbW);
            sbW.append(", hasParams=");
            sbW.append(z10);
            sbW.append(")");
            return sbW.toString();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityCallExecutor$ToolTaskResponse;", "", "success", "", "content", "", "errorCode", "errorMessage", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getContent", "()Ljava/lang/String;", "getErrorCode", "getErrorMessage", "toAgentBusPayload", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ToolTaskResponse {
        private final String content;
        private final String errorCode;
        private final String errorMessage;
        private final boolean success;

        public ToolTaskResponse() {
            this(false, null, null, null, 15, null);
        }

        public static /* synthetic */ ToolTaskResponse copy$default(ToolTaskResponse toolTaskResponse, boolean z10, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                z10 = toolTaskResponse.success;
            }
            if ((i & 2) != 0) {
                str = toolTaskResponse.content;
            }
            if ((i & 4) != 0) {
                str2 = toolTaskResponse.errorCode;
            }
            if ((i & 8) != 0) {
                str3 = toolTaskResponse.errorMessage;
            }
            return toolTaskResponse.copy(z10, str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component2, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component3, reason: from getter */
        public final String getErrorCode() {
            return this.errorCode;
        }

        /* renamed from: component4, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final ToolTaskResponse copy(boolean success, String content, String errorCode, String errorMessage) {
            return new ToolTaskResponse(success, content, errorCode, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolTaskResponse)) {
                return false;
            }
            ToolTaskResponse toolTaskResponse = (ToolTaskResponse) other;
            return this.success == toolTaskResponse.success && k.b(this.content, toolTaskResponse.content) && k.b(this.errorCode, toolTaskResponse.errorCode) && k.b(this.errorMessage, toolTaskResponse.errorMessage);
        }

        public final String getContent() {
            return this.content;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.success) * 31;
            String str = this.content;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.errorCode;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.errorMessage;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        public final Map<String, Object> toAgentBusPayload() {
            if (this.success) {
                MapBuilder mapBuilder = new MapBuilder();
                mapBuilder.put("ok", Boolean.TRUE);
                Object objFlatten = ToolResponseContentFlattener.INSTANCE.flatten(this.content);
                if (objFlatten != null) {
                    mapBuilder.put("content", objFlatten);
                }
                return mapBuilder.b();
            }
            Pair pair = new Pair("ok", Boolean.FALSE);
            String str = this.errorCode;
            if (str == null) {
                str = "ABILITY_CALL_FAILED";
            }
            Pair pair2 = new Pair("errorCode", str);
            String str2 = this.errorMessage;
            if (str2 == null) {
                str2 = "ability.call failed";
            }
            return kotlin.collections.a.R(pair, pair2, new Pair("errorMessage", str2));
        }

        public String toString() {
            boolean z10 = this.success;
            String str = this.content;
            String str2 = this.errorCode;
            String str3 = this.errorMessage;
            StringBuilder sb = new StringBuilder("ToolTaskResponse(success=");
            sb.append(z10);
            sb.append(", content=");
            sb.append(str);
            sb.append(", errorCode=");
            return androidx.appfunctions.metadata.a.p(sb, str2, ", errorMessage=", str3, ")");
        }

        public ToolTaskResponse(boolean z10, String str, String str2, String str3) {
            this.success = z10;
            this.content = str;
            this.errorCode = str2;
            this.errorMessage = str3;
        }

        public /* synthetic */ ToolTaskResponse(boolean z10, String str, String str2, String str3, int i, e eVar) {
            this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }
    }

    @c(c = "com.stepos.ability.agentbusclient.AbilityCallExecutor", f = "AbilityCallExecutor.kt", l = {70}, m = "execute", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbilityCallExecutor.this.execute(null, this);
        }
    }

    @c(c = "com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$2", f = "AbilityCallExecutor.kt", l = {71}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "", "", "", "<anonymous>", "(Lm9/z;)Ljava/util/Map;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ ParsedCall $parsed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ParsedCall parsedCall, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$parsed = parsedCall;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AbilityCallExecutor.this.new AnonymousClass2(this.$parsed, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            AbilityCallExecutor abilityCallExecutor = AbilityCallExecutor.this;
            ParsedCall parsedCall = this.$parsed;
            this.label = 1;
            Object objAwaitToolTaskResult = abilityCallExecutor.awaitToolTaskResult(parsedCall, this);
            return objAwaitToolTaskResult == coroutineSingletons ? coroutineSingletons : objAwaitToolTaskResult;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Map<String, ? extends Object>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    static {
        TaskStatus.b.getClass();
        TERMINAL_STATUSES = TaskStatus.e;
    }

    @Inject
    public AbilityCallExecutor(@ApplicationContext Context context) {
        k.f(context, "context");
        this.context = context;
        r0 r0VarC = AbstractC1683A.c();
        d dVar = AbstractC1691I.f5315a;
        this.resumeScope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        AgentServiceClient.init$default(AgentServiceClient.INSTANCE, context, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitToolTaskResult(final ParsedCall parsedCall, H7.c<? super Map<String, ? extends Object>> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final AtomicBoolean atomicBoolean3 = new AtomicBoolean(false);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final AtomicReference atomicReference = new AtomicReference(null);
        ref$ObjectRef.f4920a = new ITaskListener.Stub() { // from class: com.stepos.ability.agentbusclient.AbilityCallExecutor$awaitToolTaskResult$2$1
            @Override // com.stepos.ability.ITaskListener
            public void onExplainUpdated(String taskId, ExplainSnapshot snapshot) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onInfoDismissed(String taskId, String requestId, String reason, String chatSessionId) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onInfoRequested(String taskId, String requestId, String inputType, String message, String payloadJson, long timeoutMs, String chatSessionId) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onPackageConflict(int conflictKind, String newTaskId, String newTaskName, String runningTaskId, String packageName, String hint) {
            }

            @Override // com.stepos.ability.ITaskListener
            public void onRequestRelaunch(String taskId, String chatSessionId, String reason) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v11, types: [kotlin.Result$Failure] */
            @Override // com.stepos.ability.ITaskListener
            public void onTaskEvent(Task task) {
                String codeString;
                String strI;
                Map<String, Object> mapErrorPayload;
                AbilityCallExecutor.ToolTaskResponse toolTaskResponseA;
                if (task == null || !k.b(task.getTaskId(), parsedCall.getToolCallId())) {
                    return;
                }
                Bundle bundle = task.getBundle();
                String string = bundle != null ? bundle.getString(Key.KEY_TOOL_CALL_RESPONSE) : null;
                int status = task.getStatus();
                C2085f c2085f = TaskStatus.b;
                if (status == 13) {
                    Map<String, ? extends Object> mapFromJson = FunctionCallResultAgentBusMapper.INSTANCE.fromJson(string);
                    atomicReference.set(PendingAuthParser.INSTANCE.parse(mapFromJson, parsedCall.getToolCallId(), parsedCall.getSessionId(), parsedCall.getMethod(), parsedCall.getTraceId()));
                    AbilityCallExecutor.awaitToolTaskResult$lambda$0$completeInvoke(atomicBoolean, c1718k, mapFromJson);
                    return;
                }
                if (AbilityCallExecutor.TERMINAL_STATUSES.contains(Integer.valueOf(task.getStatus()))) {
                    if (atomicBoolean3.compareAndSet(false, true)) {
                        boolean zIsSuccessTerminal = AbilityCallExecutor.Companion.isSuccessTerminal(task);
                        Log.i("AbilityCallExecutor", "onTaskEvent ok=" + zIsSuccessTerminal);
                        if (task.getTaskType() == 0) {
                            Map<String, Object> mapFromJson2 = FunctionCallResultAgentBusMapper.INSTANCE.fromJson(string);
                            PendingAuth pendingAuth = atomicReference.get();
                            AbilityCallExecutor.awaitToolTaskResult$lambda$0$closeListener(atomicBoolean2, this, ref$ObjectRef);
                            if (pendingAuth != null) {
                                AbstractC1683A.n(this.resumeScope, null, new AbilityCallExecutor$awaitToolTaskResult$2$1$onTaskEvent$1(this, pendingAuth, string, bundle, null), 3);
                                return;
                            } else {
                                AbilityCallExecutor.awaitToolTaskResult$lambda$0$completeInvoke(atomicBoolean, c1718k, mapFromJson2);
                                return;
                            }
                        }
                        AbilityCallExecutor.awaitToolTaskResult$lambda$0$closeListener(atomicBoolean2, this, ref$ObjectRef);
                        AtomicBoolean atomicBoolean4 = atomicBoolean;
                        InterfaceC1717j interfaceC1717j = c1718k;
                        if (zIsSuccessTerminal) {
                            Bundle bundle2 = task.getBundle();
                            String string2 = bundle2 != null ? bundle2.getString("message") : null;
                            Log.i("AbilityCallExecutor", "tool task message=<redacted> hasMessage=" + (!(string2 == null || m.s0(string2))));
                            if (string2 != null && !m.s0(string2)) {
                                try {
                                    toolTaskResponseA = this.parseGuiTaskResponse(string2);
                                } catch (Throwable th) {
                                    toolTaskResponseA = b.a(th);
                                }
                                toolTaskResponse = toolTaskResponseA instanceof Result.Failure ? null : toolTaskResponseA;
                            }
                            if (toolTaskResponse != null) {
                                Log.i("AbilityCallExecutor", "onTaskEvent toolResult=<redacted> success=" + toolTaskResponse.getSuccess());
                                mapErrorPayload = toolTaskResponse.toAgentBusPayload();
                            } else {
                                mapErrorPayload = kotlin.collections.a.Q(new Pair("ok", Boolean.TRUE));
                            }
                        } else {
                            AbilityCallExecutor abilityCallExecutor = this;
                            TaskError error = task.getError();
                            if (error == null || (codeString = error.getCodeString()) == null) {
                                codeString = "ABILITY_CALL_FAILED";
                            }
                            TaskError error2 = task.getError();
                            if (error2 == null || (strI = error2.getErrorMessage()) == null) {
                                strI = androidx.appfunctions.metadata.a.i(task.getStatus(), "tool task failed (status=", ")");
                            }
                            mapErrorPayload = abilityCallExecutor.errorPayload(codeString, strI);
                        }
                        AbilityCallExecutor.awaitToolTaskResult$lambda$0$completeInvoke(atomicBoolean4, interfaceC1717j, mapErrorPayload);
                    }
                }
            }

            @Override // com.stepos.ability.ITaskListener
            public void onToolCallEvent(ToolCallEvent event) {
            }
        };
        c1718k.j(new S7.k() { // from class: com.stepos.ability.agentbusclient.AbilityCallExecutor$awaitToolTaskResult$2$2
            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                if (atomicBoolean.get()) {
                    return;
                }
                AbilityCallExecutor.awaitToolTaskResult$lambda$0$closeListener(atomicBoolean2, this, ref$ObjectRef);
                try {
                    AgentServiceClient.INSTANCE.cancelTask(parsedCall.getToolCallId());
                } catch (Throwable th2) {
                    b.a(th2);
                }
            }
        });
        AgentServiceClient agentServiceClient = AgentServiceClient.INSTANCE;
        Object obj = ref$ObjectRef.f4920a;
        if (obj == null) {
            k.n("listener");
            throw null;
        }
        agentServiceClient.registerTaskListener((ITaskListener) obj);
        Bundle bundle = new Bundle();
        bundle.putString(Key.KEY_CALL_SOURCE, "CLOUD");
        if (parsedCall.getTraceId().length() > 0) {
            bundle.putString(Key.KEY_TRACE_ID, parsedCall.getTraceId());
        }
        if (parsedCall.getSessionId().length() > 0) {
            bundle.putString("session_id", parsedCall.getSessionId());
            Log.i(TAG, "AgentBus sessionId: " + parsedCall.getSessionId());
        } else {
            Log.w(TAG, "AgentBus sessionId is EMPTY!");
        }
        if (parsedCall.getToolId().length() > 0) {
            bundle.putString(Key.KEY_TOOL_ID, parsedCall.getToolId());
        }
        if (parsedCall.getTimeoutMs() > 0) {
            bundle.putLong(Key.KEY_TIMEOUT_MS, parsedCall.getTimeoutMs());
        }
        if (k.b(parsedCall.getToolId(), "0") || k.b(parsedCall.getMethod(), GUI_AGENT_METHOD)) {
            String toolCallId = parsedCall.getToolCallId();
            String method = parsedCall.getMethod();
            String toolId = parsedCall.getToolId();
            boolean z10 = !m.s0(parsedCall.getParamsJson());
            StringBuilder sbW = B7.a.w("route to submitGuiTask: toolCallId=", toolCallId, " method=", method, " toolId=");
            sbW.append(toolId);
            sbW.append(" hasParams=");
            sbW.append(z10);
            Log.i(TAG, sbW.toString());
            agentServiceClient.submitGuiTask(new g(parsedCall.getToolCallId(), parsedCall.getParamsJson(), new f(parsedCall.getToolCallId(), bundle)));
        } else {
            String toolCallId2 = parsedCall.getToolCallId();
            String method2 = parsedCall.getMethod();
            String toolId2 = parsedCall.getToolId();
            StringBuilder sbW2 = B7.a.w("route to submitToolTask: toolCallId=", toolCallId2, " method=", method2, " toolId=");
            sbW2.append(toolId2);
            Log.i(TAG, sbW2.toString());
            agentServiceClient.submitToolTask(new h(parsedCall.getMethod(), parsedCall.getToolCallId(), parsedCall.getParamsJson(), t.g0(parsedCall.getToolId()), new f(parsedCall.getToolCallId(), bundle)));
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void awaitToolTaskResult$lambda$0$closeListener(AtomicBoolean atomicBoolean, AbilityCallExecutor abilityCallExecutor, Ref$ObjectRef<ITaskListener> ref$ObjectRef) {
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                AgentServiceClient agentServiceClient = AgentServiceClient.INSTANCE;
                Object obj = ref$ObjectRef.f4920a;
                if (obj != null) {
                    agentServiceClient.unRegisterTaskListener((ITaskListener) obj);
                } else {
                    k.n("listener");
                    throw null;
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void awaitToolTaskResult$lambda$0$completeInvoke(AtomicBoolean atomicBoolean, InterfaceC1717j interfaceC1717j, Map<String, ? extends Object> map) {
        if (atomicBoolean.compareAndSet(false, true) && interfaceC1717j.isActive()) {
            interfaceC1717j.resumeWith(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> errorPayload(String code, String message) {
        return kotlin.collections.a.R(new Pair("ok", Boolean.FALSE), new Pair("errorCode", code), new Pair("errorMessage", message));
    }

    /* renamed from: long, reason: not valid java name */
    private final Long m7330long(Map<String, ? extends Object> map, String str) {
        Object obj = map.get(str);
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            return t.g0((String) obj);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.ability.agentbusclient.AbilityCallExecutor.ParsedCall parseArgs(java.util.Map<java.lang.String, ? extends java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityCallExecutor.parseArgs(java.util.Map):com.stepos.ability.agentbusclient.AbilityCallExecutor$ParsedCall");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ToolTaskResponse parseGuiTaskResponse(String json) {
        new JSONObject(json);
        return new ToolTaskResponse(true, json, null, null, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010b A[PHI: r12
      0x010b: PHI (r12v6 java.lang.String) = (r12v5 java.lang.String), (r12v12 java.lang.String) binds: [B:47:0x00e0, B:52:0x00f0] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object publishResume(com.stepos.ability.agentbusclient.PendingAuth r20, java.lang.String r21, android.os.Bundle r22, H7.c<? super C7.r> r23) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityCallExecutor.publishResume(com.stepos.ability.agentbusclient.PendingAuth, java.lang.String, android.os.Bundle, H7.c):java.lang.Object");
    }

    private final String readTraceId(Map<String, ? extends Object> map) {
        String strString = string(map, AgentBusWakeContract.EXTRA_TRACE_ID);
        if (strString != null) {
            return strString;
        }
        Object obj = map.get("params");
        Map map2 = obj instanceof Map ? (Map) obj : null;
        Iterator it = q.j0(new Map[]{map, map2}).iterator();
        while (it.hasNext()) {
            Object obj2 = ((Map) it.next()).get("_meta");
            Map map3 = obj2 instanceof Map ? (Map) obj2 : null;
            Object obj3 = map3 != null ? map3.get("trace") : null;
            Map map4 = obj3 instanceof Map ? (Map) obj3 : null;
            Object obj4 = map4 != null ? map4.get(AgentBusWakeContract.EXTRA_TRACE_ID) : null;
            String str = obj4 instanceof String ? (String) obj4 : null;
            if (str != null) {
                if (str.length() <= 0) {
                    str = null;
                }
                if (str != null) {
                    return str;
                }
            }
        }
        Object obj5 = map2 != null ? map2.get(AgentBusWakeContract.EXTRA_TRACE_ID) : null;
        String str2 = obj5 instanceof String ? (String) obj5 : null;
        if (str2 == null) {
            return "";
        }
        String str3 = str2.length() > 0 ? str2 : null;
        return str3 != null ? str3 : "";
    }

    private final String string(Map<String, ? extends Object> map, String str) {
        Object obj = map.get(str);
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 == null || str2.length() <= 0) {
            return null;
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(java.util.Map<java.lang.String, ? extends java.lang.Object> r8, H7.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ability.agentbusclient.AbilityCallExecutor.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$1 r0 = (com.stepos.ability.agentbusclient.AbilityCallExecutor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$1 r0 = new com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            java.lang.String r3 = "AbilityCallExecutor"
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r8 = r0.L$1
            com.stepos.ability.agentbusclient.AbilityCallExecutor$ParsedCall r8 = (com.stepos.ability.agentbusclient.AbilityCallExecutor.ParsedCall) r8
            java.lang.Object r0 = r0.L$0
            java.util.Map r0 = (java.util.Map) r0
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            goto L7d
        L31:
            r9 = move-exception
            goto L80
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.b.b(r9)
            com.stepos.ability.agentbusclient.AbilityCallExecutor$ParsedCall r8 = r7.parseArgs(r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "submitToolTask "
            r9.<init>(r2)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            android.util.Log.i(r3, r9)
            java.lang.String r9 = r8.getMethod()
            boolean r9 = j9.m.s0(r9)
            if (r9 == 0) goto L66
            java.lang.String r8 = "INVALID_REQUEST"
            java.lang.String r9 = "missing method in ability.call params"
            java.util.Map r7 = r7.errorPayload(r8, r9)
            return r7
        L66:
            long r5 = r8.getTimeoutMs()     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$2 r9 = new com.stepos.ability.agentbusclient.AbilityCallExecutor$execute$2     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            r2 = 0
            r9.<init>(r8, r2)     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            r0.label = r4     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            java.lang.Object r9 = kotlinx.coroutines.a.o(r5, r9, r0)     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            if (r9 != r1) goto L7d
            return r1
        L7d:
            java.util.Map r9 = (java.util.Map) r9     // Catch: java.lang.Throwable -> L31 kotlinx.coroutines.TimeoutCancellationException -> La4
            return r9
        L80:
            java.lang.String r8 = r8.getToolCallId()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "execute failed toolCallId="
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            android.util.Log.e(r3, r8, r9)
            java.lang.String r8 = r9.getMessage()
            if (r8 != 0) goto L9d
            java.lang.String r8 = "ability.call failed"
        L9d:
            java.lang.String r9 = "ABILITY_CALL_FAILED"
            java.util.Map r7 = r7.errorPayload(r9, r8)
            goto Lb6
        La4:
            long r8 = r8.getTimeoutMs()
            java.lang.String r0 = "tool task timed out after "
            java.lang.String r1 = "ms"
            java.lang.String r8 = androidx.compose.foundation.b.q(r8, r0, r1)
            java.lang.String r9 = "STEPCLAW_INVOKE_TIMEOUT"
            java.util.Map r7 = r7.errorPayload(r9, r8)
        Lb6:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityCallExecutor.execute(java.util.Map, H7.c):java.lang.Object");
    }

    public final ResumeSender getResumeSender() {
        return this.resumeSender;
    }

    public final void setResumeSender(ResumeSender resumeSender) {
        this.resumeSender = resumeSender;
    }
}
