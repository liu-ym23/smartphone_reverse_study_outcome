package com.stepos.ailauncher.chat.controller;

import Ua.C1056g;
import com.stepos.agentframework.chatcore.session.LatestRoundIds;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.AgentSpaceController$trackSidebarCardClick$1", f = "AgentSpaceController.kt", l = {2621}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentSpaceController$trackSidebarCardClick$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agentName;
    final /* synthetic */ String $agentType;
    final /* synthetic */ String $entryType;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSpaceController$trackSidebarCardClick$1(String str, String str2, String str3, String str4, InterfaceC4014c<? super AgentSpaceController$trackSidebarCardClick$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$entryType = str2;
        this.$agentName = str3;
        this.$agentType = str4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSpaceController$trackSidebarCardClick$1(this.$sessionId, this.$entryType, this.$agentName, this.$agentType, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSpaceController$trackSidebarCardClick$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            AgentSpaceController$trackSidebarCardClick$1$ids$1 agentSpaceController$trackSidebarCardClick$1$ids$1 = new AgentSpaceController$trackSidebarCardClick$1$ids$1(this.$sessionId, null);
            this.label = 1;
            obj = C1056g.j(iB, agentSpaceController$trackSidebarCardClick$1$ids$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        LatestRoundIds latestRoundIds = (LatestRoundIds) obj;
        com.stepos.ailauncher.chat.trace.f.INSTANCE.f(this.$sessionId, latestRoundIds != null ? latestRoundIds.getChatId() : null, latestRoundIds != null ? latestRoundIds.getMessageId() : null, this.$entryType, this.$agentName, this.$agentType);
        return Y8.t.f7040a;
    }
}
