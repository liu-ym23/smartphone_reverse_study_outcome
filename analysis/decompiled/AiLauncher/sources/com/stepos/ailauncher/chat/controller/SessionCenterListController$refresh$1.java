package com.stepos.ailauncher.chat.controller;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionCenterListController$refresh$1", f = "SessionCenterListController.kt", l = {477, 490}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionCenterListController$refresh$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $loadAgents;
    final /* synthetic */ InterfaceC5063a<Y8.t> $onUpdated;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SessionCenterListController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionCenterListController$refresh$1(SessionCenterListController sessionCenterListController, boolean z10, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC4014c<? super SessionCenterListController$refresh$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionCenterListController;
        this.$loadAgents = z10;
        this.$onUpdated = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionCenterListController$refresh$1(this.this$0, this.$loadAgents, this.$onUpdated, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionCenterListController$refresh$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
    
        if (r11 == r0) goto L51;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SessionCenterListController$refresh$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
