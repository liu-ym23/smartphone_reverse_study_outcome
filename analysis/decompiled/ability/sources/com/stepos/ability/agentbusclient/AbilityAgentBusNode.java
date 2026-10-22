package com.stepos.ability.agentbusclient;

import C7.r;
import J7.c;
import android.util.Log;
import androidx.compose.material3.MenuKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import j9.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J~\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001e¨\u0006 "}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityAgentBusNode;", "", "Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;", "abilityCallExecutor", "Lcom/stepos/ability/agentbusclient/AbilityListExecutor;", "abilityListExecutor", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;Lcom/stepos/ability/agentbusclient/AbilityListExecutor;)V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "invokeParamsJson", Key.KEY_TOOL_CALL_ID, "toolId", AgentBusWakeContract.EXTRA_TRACE_ID, "sessionId", "serviceName", "", "timeoutMs", "", "abilityCall", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;LH7/c;)Ljava/lang/Object;", "appNamesJson", "abilityList", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "invocationId", "reason", "LC7/r;", "onCancel", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;", "Lcom/stepos/ability/agentbusclient/AbilityListExecutor;", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityAgentBusNode {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "AbilityAgentBusNode";
    private final AbilityCallExecutor abilityCallExecutor;
    private final AbilityListExecutor abilityListExecutor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/ability/agentbusclient/AbilityAgentBusNode$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    @c(c = "com.stepos.ability.agentbusclient.AbilityAgentBusNode", f = "AbilityAgentBusNode.kt", l = {57}, m = "abilityCall", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.agentbusclient.AbilityAgentBusNode$abilityCall$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbilityAgentBusNode.this.abilityCall(null, null, null, null, null, null, null, null, this);
        }
    }

    public AbilityAgentBusNode(AbilityCallExecutor abilityCallExecutor, AbilityListExecutor abilityListExecutor) {
        k.f(abilityCallExecutor, "abilityCallExecutor");
        k.f(abilityListExecutor, "abilityListExecutor");
        this.abilityCallExecutor = abilityCallExecutor;
        this.abilityListExecutor = abilityListExecutor;
    }

    public static /* synthetic */ Object abilityCall$default(AbilityAgentBusNode abilityAgentBusNode, String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            str6 = null;
        }
        if ((i & 64) != 0) {
            str7 = null;
        }
        if ((i & 128) != 0) {
            l = null;
        }
        return abilityAgentBusNode.abilityCall(str, str2, str3, str4, str5, str6, str7, l, cVar);
    }

    public static /* synthetic */ Object abilityList$default(AbilityAgentBusNode abilityAgentBusNode, String str, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return abilityAgentBusNode.abilityList(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object abilityCall(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.Long r24, H7.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r25) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.AbilityAgentBusNode.abilityCall(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, H7.c):java.lang.Object");
    }

    public final Object abilityList(String str, H7.c<? super Map<String, ? extends Object>> cVar) {
        Log.i(TAG, "abilityList appNamesJson=" + (str != null ? m.N0(MenuKt.InTransitionDuration, str) : null));
        return this.abilityListExecutor.execute(str, cVar);
    }

    public final Object onCancel(String str, String str2, H7.c<? super r> cVar) {
        Log.i(TAG, "ability.call cancelled invocationId=" + str + " reason=" + str2);
        return r.f317a;
    }
}
