package com.stepos.ailauncher.chat.view;

import Ua.InterfaceC1066l;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/chat/view/Y8;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/chat/view/Y8;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.SidebarDataSource$load$2", f = "SidebarDataSource.kt", l = {58, 238, 114}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SidebarDataSource$load$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super SidebarSnapshot>, Object> {
    final /* synthetic */ List<IExternalAgentBindService.SidebarAgent> $cachedAgents;
    final /* synthetic */ String $currentSessionId;
    final /* synthetic */ boolean $refreshAgents;
    final /* synthetic */ SessionHandler $sessionHandler;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Map<String, ? extends Boolean>, Y8.t> {
        final /* synthetic */ InterfaceC1066l<Map<String, Boolean>> $cont;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.view.SidebarDataSource$load$2$a$a, reason: collision with other inner class name */
        public static final class C0298a implements InterfaceC5074l<Throwable, Y8.t> {
            public static final C0298a INSTANCE = new C0298a();

            public final void a(Throwable it) {
                kotlin.jvm.internal.p.i(it, "it");
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
                a(th);
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(InterfaceC1066l<? super Map<String, Boolean>> interfaceC1066l) {
            this.$cont = interfaceC1066l;
        }

        public final void a(Map<String, Boolean> result) {
            kotlin.jvm.internal.p.i(result, "result");
            if (this.$cont.b()) {
                this.$cont.v(result, C0298a.INSTANCE);
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(Map<String, ? extends Boolean> map) {
            a(map);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SidebarDataSource$load$2(String str, boolean z10, List<IExternalAgentBindService.SidebarAgent> list, SessionHandler sessionHandler, InterfaceC4014c<? super SidebarDataSource$load$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$currentSessionId = str;
        this.$refreshAgents = z10;
        this.$cachedAgents = list;
        this.$sessionHandler = sessionHandler;
    }

    public static final boolean n(String str, SessionHandler sessionHandler, SidebarSession sidebarSession) {
        return (sidebarSession.getSendFailed() || kotlin.jvm.internal.p.d(sidebarSession.getSessionId(), str) || sidebarSession.getUpdatedAt() > sidebarSession.getCreatedAt() || sessionHandler.i2(sidebarSession.getSessionId())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String y(SidebarSession sidebarSession) {
        return sidebarSession.getSessionId();
    }

    public static final CharSequence z(SidebarSession sidebarSession) {
        return sidebarSession.getSessionId();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SidebarDataSource$load$2 sidebarDataSource$load$2 = new SidebarDataSource$load$2(this.$currentSessionId, this.$refreshAgents, this.$cachedAgents, this.$sessionHandler, interfaceC4014c);
        sidebarDataSource$load$2.L$0 = obj;
        return sidebarDataSource$load$2;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super SidebarSnapshot> interfaceC4014c) {
        return ((SidebarDataSource$load$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0263, code lost:
    
        if (r0 == r3) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:16:0x005e, B:26:0x008b, B:29:0x0091, B:30:0x0095, B:21:0x0069, B:23:0x0077), top: B:99:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0269  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.SidebarDataSource$load$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
