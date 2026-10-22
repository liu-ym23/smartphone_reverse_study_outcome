package com.stepos.ability.agentbusclient;

import C7.r;
import H7.c;
import S7.o;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.api.init.IInit;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ability/agentbusclient/AgentBusClientInit;", "Lcom/stepos/ability/api/init/IInit;", "Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;", "abilityCallExecutor", "Lcom/stepos/ability/agentbusclient/AbilityListExecutor;", "abilityListExecutor", AppAgent.CONSTRUCT, "(Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;Lcom/stepos/ability/agentbusclient/AbilityListExecutor;)V", "Landroid/content/Context;", "context", "LC7/r;", "init", "(Landroid/content/Context;)V", "Lcom/stepos/ability/agentbusclient/AbilityCallExecutor;", "Lcom/stepos/ability/agentbusclient/AbilityListExecutor;", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;", "binding", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusClientInit implements IInit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AgentBusClientInit";
    private final AbilityCallExecutor abilityCallExecutor;
    private final AbilityListExecutor abilityListExecutor;
    private AbilityAgentBusNodeAgentBusBinding binding;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stepos/ability/agentbusclient/AgentBusClientInit$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "shouldSkipNodeRegistration", "", "processName", "packageName", "shouldSkipNodeRegistration$agentbus_client_release", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final boolean shouldSkipNodeRegistration$agentbus_client_release(String processName, String packageName) {
            return (processName == null || packageName == null || processName.equals(packageName)) ? false : true;
        }

        private Companion() {
        }
    }

    @Inject
    public AgentBusClientInit(AbilityCallExecutor abilityCallExecutor, AbilityListExecutor abilityListExecutor) {
        k.f(abilityCallExecutor, "abilityCallExecutor");
        k.f(abilityListExecutor, "abilityListExecutor");
        this.abilityCallExecutor = abilityCallExecutor;
        this.abilityListExecutor = abilityListExecutor;
    }

    @Override // com.stepos.ability.api.init.IInit
    public void init(Context context) {
        String processName;
        k.f(context, "context");
        try {
            processName = Application.getProcessName();
        } catch (Throwable unused) {
            processName = null;
        }
        if (INSTANCE.shouldSkipNodeRegistration$agentbus_client_release(processName, context.getPackageName())) {
            Log.d(TAG, "init: skip AgentBus NODE in non-main process (" + processName + ")");
            return;
        }
        if (this.binding != null) {
            return;
        }
        Log.i(TAG, "init AgentBus NODE (caps=ability.call, ability.list)");
        final AbilityAgentBusNodeAgentBusBinding agentBusBinding = AbilityAgentBusNodeAgentBusBindingKt.toAgentBusBinding(new AbilityAgentBusNode(this.abilityCallExecutor, this.abilityListExecutor));
        this.abilityCallExecutor.setResumeSender(new ResumeSender(new AwaitReq() { // from class: com.stepos.ability.agentbusclient.AgentBusClientInit$init$1$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ability.agentbusclient.AgentBusClientInit$init$1$1$1, reason: invalid class name */
            public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements o {
                public AnonymousClass1(Object obj) {
                    super(3, obj, AbilityAgentBusNodeAgentBusBinding.class, "sendReq", "sendReq(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
                }

                @Override // S7.o
                public final Object invoke(String str, Map<String, ? extends Object> map, c<? super String> cVar) {
                    return ((AbilityAgentBusNodeAgentBusBinding) this.receiver).sendReq(str, map, cVar);
                }
            }

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ability.agentbusclient.AgentBusClientInit$init$1$1$2, reason: invalid class name */
            public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements o {
                public AnonymousClass2(Object obj) {
                    super(3, obj, AbilityAgentBusNodeAgentBusBinding.class, "awaitResponse", "awaitResponse(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((String) obj, ((Number) obj2).longValue(), (c<? super JSONObject>) obj3);
                }

                public final Object invoke(String str, long j5, c<? super JSONObject> cVar) {
                    return ((AbilityAgentBusNodeAgentBusBinding) this.receiver).awaitResponse(str, j5, cVar);
                }
            }

            @Override // com.stepos.ability.agentbusclient.AwaitReq
            public final Object invoke(String str, Map<String, ? extends Object> map, c<? super r> cVar) {
                Object objAwait = ResumeReceipt.INSTANCE.await(new AnonymousClass1(agentBusBinding), new AnonymousClass2(agentBusBinding), str, map, (16 & 16) != 0 ? 60000L : 0L, cVar);
                return objAwait == CoroutineSingletons.f4909a ? objAwait : r.f317a;
            }
        }));
        agentBusBinding.start();
        this.binding = agentBusBinding;
    }
}
