package com.stepos.ability.sdk.client;

import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.ITaskListener;
import com.stepos.core.ability.executor.InferenceExecutor;
import com.stepos.core.ability.speech.AsrRealtimeBinderCoordinator;
import com.stepos.core.data.AudioContent;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.deepbinder.OtaInteractiveDownloadFlow;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5565a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5566b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5567c;

    public /* synthetic */ b(int i10, Object obj, Object obj2) {
        this.f5565a = i10;
        this.f5567c = obj;
        this.f5566b = obj2;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        IAgentServiceManager iAgentServiceManager;
        switch (this.f5565a) {
            case 0:
                ITaskListener iTaskListener = (ITaskListener) this.f5567c;
                String str = (String) this.f5566b;
                IAgentServiceManager it = (IAgentServiceManager) obj;
                g.f(it, "it");
                it.registerTaskListener(iTaskListener, str);
                String msg = "registerTaskListener done: key=" + str;
                g.f(msg, "msg");
                v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
                return n.f10413a;
            case 1:
                String msg2 = (String) this.f5566b;
                b bVar = (b) this.f5567c;
                ((Boolean) obj).getClass();
                v5.a aVar = v5.b.f13381a;
                try {
                    g.f(msg2, "msg");
                    aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg2, null);
                    iAgentServiceManager = d.f5572c;
                } catch (Exception e10) {
                    String msg3 = msg2 + " failed";
                    g.f(msg3, "msg");
                    aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg3, e10);
                }
                if (iAgentServiceManager != null) {
                    bVar.invoke(iAgentServiceManager);
                    return n.f10413a;
                }
                String msg4 = msg2.concat(" skipped: not bound yet");
                g.f(msg4, "msg");
                aVar.a(5, "Ability_".concat("Ability_AgentServiceClient"), msg4, null);
                return n.f10413a;
            case 2:
                return InferenceExecutor.launchMonitored$lambda$4$lambda$3((AtomicBoolean) this.f5567c, (InferenceExecutor) this.f5566b, (Throwable) obj);
            case 3:
                return AsrRealtimeBinderCoordinator.ensureReorderBuffer$lambda$4$lambda$2((AsrRealtimeBinderCoordinator) this.f5567c, (String) this.f5566b, (AudioContent) obj);
            case 4:
                return OtaInteractiveDownloadFlow.showUpdateConfirm$lambda$21((String) this.f5566b, (String) this.f5567c, (ConfirmDecisionBus.Decision) obj);
            default:
                return HandlerContext.scheduleResumeAfterDelay$lambda$2((HandlerContext) this.f5567c, (HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1) this.f5566b, (Throwable) obj);
        }
    }

    public /* synthetic */ b(int i10, String str, Object obj) {
        this.f5565a = i10;
        this.f5566b = str;
        this.f5567c = obj;
    }
}
