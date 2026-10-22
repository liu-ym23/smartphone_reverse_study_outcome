package com.stepos.ailauncher.chat.controller;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$markSessionCompletedTasksRead$1", f = "SessionCenterListController.kt", l = {947}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionCenterListController$markSessionCompletedTasksRead$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $sessionId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SessionCenterListController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCenterListController$markSessionCompletedTasksRead$1(SessionCenterListController sessionCenterListController, String str, InterfaceC4014c<? super SessionCenterListController$markSessionCompletedTasksRead$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionCenterListController;
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SessionCenterListController$markSessionCompletedTasksRead$1 sessionCenterListController$markSessionCompletedTasksRead$1 = new SessionCenterListController$markSessionCompletedTasksRead$1(this.this$0, this.$sessionId, interfaceC4014c);
        sessionCenterListController$markSessionCompletedTasksRead$1.L$0 = obj;
        return sessionCenterListController$markSessionCompletedTasksRead$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionCenterListController$markSessionCompletedTasksRead$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r11.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L23
            if (r2 != r3) goto L1b
            java.lang.Object r0 = r11.L$1
            Ua.M r0 = (Ua.M) r0
            kotlin.C4849c.b(r12)     // Catch: java.lang.Throwable -> L18
            goto L4d
        L18:
            r0 = move-exception
            r12 = r0
            goto L5e
        L1b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L23:
            kotlin.C4849c.b(r12)
            java.lang.String r12 = r11.$sessionId
            kotlin.Result$a r2 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
            D5.a r2 = D5.a.INSTANCE     // Catch: java.lang.Throwable -> L18
            java.lang.Class<com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService> r5 = com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService.class
            java.lang.Object r2 = r2.a(r5)     // Catch: java.lang.Throwable -> L18
            com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService r2 = (com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService) r2     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L54
            java.lang.Object r5 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L18
            r11.L$0 = r5     // Catch: java.lang.Throwable -> L18
            java.lang.Object r0 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L18
            r11.L$1 = r0     // Catch: java.lang.Throwable -> L18
            r11.I$0 = r4     // Catch: java.lang.Throwable -> L18
            r11.label = r3     // Catch: java.lang.Throwable -> L18
            java.lang.Object r12 = r2.markSessionCompletedTasksRead(r12, r11)     // Catch: java.lang.Throwable -> L18
            if (r12 != r1) goto L4d
            return r1
        L4d:
            java.lang.Number r12 = (java.lang.Number) r12     // Catch: java.lang.Throwable -> L18
            int r12 = r12.intValue()     // Catch: java.lang.Throwable -> L18
            goto L55
        L54:
            r12 = r4
        L55:
            java.lang.Integer r12 = g9.C4109a.f(r12)     // Catch: java.lang.Throwable -> L18
            java.lang.Object r12 = kotlin.Result.b(r12)     // Catch: java.lang.Throwable -> L18
            goto L68
        L5e:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.C4849c.a(r12)
            java.lang.Object r12 = kotlin.Result.b(r12)
        L68:
            java.lang.String r0 = r11.$sessionId
            java.lang.Throwable r7 = kotlin.Result.e(r12)
            if (r7 == 0) goto L8e
            kotlin.jvm.internal.y r1 = kotlin.jvm.internal.y.f34840a
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            java.lang.String r1 = "Mark completed tasks read failed sessionId=%s"
            java.lang.String r6 = java.lang.String.format(r1, r0)
            java.lang.String r0 = "format(...)"
            kotlin.jvm.internal.p.h(r6, r0)
            r9 = 8
            r10 = 0
            java.lang.String r5 = "SessionCenterList"
            r8 = 0
            h8.C4148a.t(r5, r6, r7, r8, r9, r10)
        L8e:
            java.lang.Integer r0 = g9.C4109a.f(r4)
            boolean r1 = kotlin.Result.g(r12)
            if (r1 == 0) goto L99
            r12 = r0
        L99:
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            if (r12 <= 0) goto La8
            com.stepos.ailauncher.chat.controller.SessionCenterListController r11 = r11.this$0
            r12 = 3
            r0 = 0
            com.stepos.ailauncher.chat.controller.SessionCenterListController.x0(r11, r4, r0, r12, r0)
        La8:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SessionCenterListController$markSessionCompletedTasksRead$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
