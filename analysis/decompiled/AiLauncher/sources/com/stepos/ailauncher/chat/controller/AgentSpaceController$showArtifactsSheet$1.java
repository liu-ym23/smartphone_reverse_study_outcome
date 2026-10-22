package com.stepos.ailauncher.chat.controller;

import Ua.C1056g;
import android.content.Context;
import android.view.View;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.AgentArtifactsSheet;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.AgentSpaceController$showArtifactsSheet$1", f = "AgentSpaceController.kt", l = {1763}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentSpaceController$showArtifactsSheet$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<SessionArtifact> $artifacts;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ AgentSpaceController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceController$showArtifactsSheet$1(AgentSpaceController agentSpaceController, List<SessionArtifact> list, String str, InterfaceC4014c<? super AgentSpaceController$showArtifactsSheet$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSpaceController;
        this.$artifacts = list;
        this.$sessionId = str;
    }

    public static final Y8.t i(String str, Map map, SessionArtifact sessionArtifact, int i10) {
        M5.c cVar = M5.c.INSTANCE;
        String str2 = (String) map.get(sessionArtifact.getTaskId());
        if (str2 == null) {
            str2 = "completed";
        }
        M5.c.d(cVar, sessionArtifact, str, M5.c.SOURCE_ARTIFACT_SHEET, null, str2, cVar.e(sessionArtifact.getFileName(), sessionArtifact.getMimeType()), String.valueOf(i10), 8, null);
        return Y8.t.f7040a;
    }

    public static final Y8.t n(AgentSpaceController agentSpaceController, List list, String str, SessionArtifact sessionArtifact) {
        agentSpaceController.pendingArtifactsRestore = list;
        ChatTracker chatTracker = ChatTracker.INSTANCE;
        chatTracker.b(str, sessionArtifact.getTaskId(), chatTracker.f(sessionArtifact.getFileName(), sessionArtifact.getMimeType()));
        M5.c cVar = M5.c.INSTANCE;
        M5.c.b(cVar, sessionArtifact, str, M5.c.SOURCE_ARTIFACT_SHEET, null, cVar.e(sessionArtifact.getFileName(), sessionArtifact.getMimeType()), 8, null);
        agentSpaceController.m3(sessionArtifact);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSpaceController$showArtifactsSheet$1(this.this$0, this.$artifacts, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSpaceController$showArtifactsSheet$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            AgentSpaceController$showArtifactsSheet$1$statusByTask$1 agentSpaceController$showArtifactsSheet$1$statusByTask$1 = new AgentSpaceController$showArtifactsSheet$1$statusByTask$1(this.$artifacts, null);
            this.label = 1;
            obj = C1056g.j(iB, agentSpaceController$showArtifactsSheet$1$statusByTask$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        final Map map = (Map) obj;
        AgentSpaceController agentSpaceController = this.this$0;
        AgentArtifactsSheet agentArtifactsSheet = AgentArtifactsSheet.INSTANCE;
        Context contextZ1 = agentSpaceController.z1();
        kotlin.jvm.internal.p.h(contextZ1, "access$getContext(...)");
        View rootView = this.this$0.view.getRootView();
        kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
        List<SessionArtifact> list = this.$artifacts;
        final String str = this.$sessionId;
        p9.p<? super SessionArtifact, ? super Integer, Y8.t> pVar = new p9.p() { // from class: com.stepos.ailauncher.chat.controller.H0
            @Override // p9.p
            public final Object invoke(Object obj2, Object obj3) {
                return AgentSpaceController$showArtifactsSheet$1.i(str, map, (SessionArtifact) obj2, ((Integer) obj3).intValue());
            }
        };
        final AgentSpaceController agentSpaceController2 = this.this$0;
        final List<SessionArtifact> list2 = this.$artifacts;
        final String str2 = this.$sessionId;
        agentSpaceController.artifactsSheet = agentArtifactsSheet.m(contextZ1, rootView, list, pVar, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.I0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return AgentSpaceController$showArtifactsSheet$1.n(agentSpaceController2, list2, str2, (SessionArtifact) obj2);
            }
        });
        return Y8.t.f7040a;
    }
}
