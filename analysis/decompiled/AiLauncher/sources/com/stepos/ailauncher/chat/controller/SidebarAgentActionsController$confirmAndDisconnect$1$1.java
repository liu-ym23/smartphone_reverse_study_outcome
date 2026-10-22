package com.stepos.ailauncher.chat.controller;

import Ua.C1056g;
import android.content.Context;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.controller.SidebarAgentActionsController;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SidebarAgentActionsController$confirmAndDisconnect$1$1", f = "SidebarAgentActionsController.kt", l = {148}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarAgentActionsController$confirmAndDisconnect$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ SidebarAgentItem $agent;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ SidebarAgentActionsController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SidebarAgentActionsController$confirmAndDisconnect$1$1(SidebarAgentActionsController sidebarAgentActionsController, Context context, SidebarAgentItem sidebarAgentItem, InterfaceC4014c<? super SidebarAgentActionsController$confirmAndDisconnect$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sidebarAgentActionsController;
        this.$context = context;
        this.$agent = sidebarAgentItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SidebarAgentActionsController$confirmAndDisconnect$1$1(this.this$0, this.$context, this.$agent, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SidebarAgentActionsController$confirmAndDisconnect$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Ua.I iB = Ua.Y.b();
            SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1 sidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1 = new SidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1(this.$agent, null);
            this.label = 1;
            obj = C1056g.j(iB, sidebarAgentActionsController$confirmAndDisconnect$1$1$ok$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.this$0.x(this.$context, ((Boolean) obj).booleanValue() ? R$string.sidebar_agent_disconnect_done : R$string.sidebar_agent_disconnect_failed);
        SidebarAgentActionsController.a aVar = this.this$0.host;
        if (aVar != null) {
            aVar.h();
        }
        return Y8.t.f7040a;
    }
}
