package com.stepos.ailauncher.chat.controller;

import android.content.Context;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.audit.ContentAuditClient;
import com.stepos.agentframework.chatcore.audit.g;
import com.stepos.ailauncher.chat.R$string;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SidebarSessionActionsController$renameSession$1", f = "SidebarSessionActionsController.kt", l = {228}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarSessionActionsController$renameSession$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SessionHandler $handler;
    final /* synthetic */ String $newTitle;
    final /* synthetic */ String $sessionId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SidebarSessionActionsController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SidebarSessionActionsController$renameSession$1(SidebarSessionActionsController sidebarSessionActionsController, Context context, SessionHandler sessionHandler, String str, String str2, InterfaceC4014c<? super SidebarSessionActionsController$renameSession$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sidebarSessionActionsController;
        this.$context = context;
        this.$handler = sessionHandler;
        this.$sessionId = str;
        this.$newTitle = str2;
    }

    public static final Y8.t h(SidebarSessionActionsController sidebarSessionActionsController, Context context, boolean z10) {
        sidebarSessionActionsController.u(context, true, R$string.chat_history_rename_save_failed);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SidebarSessionActionsController$renameSession$1 sidebarSessionActionsController$renameSession$1 = new SidebarSessionActionsController$renameSession$1(this.this$0, this.$context, this.$handler, this.$sessionId, this.$newTitle, interfaceC4014c);
        sidebarSessionActionsController$renameSession$1.L$0 = obj;
        return sidebarSessionActionsController$renameSession$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SidebarSessionActionsController$renameSession$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                SessionHandler sessionHandler = this.$handler;
                String str = this.$newTitle;
                Result.Companion companion = Result.INSTANCE;
                ContentAuditClient contentAuditClient = ContentAuditClient.INSTANCE;
                String agentId = sessionHandler.getConfiguration().getSessionConfig().getAgentId();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = contentAuditClient.g(agentId, str, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(C4109a.a(kotlin.jvm.internal.p.d(((com.stepos.agentframework.chatcore.audit.g) obj).a(), g.a.INSTANCE)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(SidebarSessionActionsController.TAG, "Audit title rename failed, treat as pass", thE, false, 8, null);
        }
        Boolean boolA = C4109a.a(false);
        if (Result.g(objB)) {
            objB = boolA;
        }
        if (((Boolean) objB).booleanValue()) {
            this.this$0.u(this.$context, false, R$string.chat_history_rename_save_failed);
            return Y8.t.f7040a;
        }
        SessionHandler sessionHandler2 = this.$handler;
        String str2 = this.$sessionId;
        String str3 = this.$newTitle;
        final SidebarSessionActionsController sidebarSessionActionsController = this.this$0;
        final Context context = this.$context;
        sessionHandler2.l3(str2, str3, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.controller.u1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return SidebarSessionActionsController$renameSession$1.h(sidebarSessionActionsController, context, ((Boolean) obj2).booleanValue());
            }
        });
        return Y8.t.f7040a;
    }
}
