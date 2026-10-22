package com.stepos.ailauncher.chat.controller;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.ActiveConversationManager$startPeriodicRefresh$1$1", f = "ActiveConversationManager.kt", l = {141}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ActiveConversationManager$startPeriodicRefresh$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ActiveConversationManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveConversationManager$startPeriodicRefresh$1$1(ActiveConversationManager activeConversationManager, InterfaceC4014c<? super ActiveConversationManager$startPeriodicRefresh$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = activeConversationManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        ActiveConversationManager$startPeriodicRefresh$1$1 activeConversationManager$startPeriodicRefresh$1$1 = new ActiveConversationManager$startPeriodicRefresh$1$1(this.this$0, interfaceC4014c);
        activeConversationManager$startPeriodicRefresh$1$1.L$0 = obj;
        return activeConversationManager$startPeriodicRefresh$1$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ActiveConversationManager$startPeriodicRefresh$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:14:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r6.label
            r3 = 1
            if (r2 == 0) goto L1b
            if (r2 != r3) goto L13
            kotlin.C4849c.b(r7)
            goto L32
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1b:
            kotlin.C4849c.b(r7)
        L1e:
            boolean r7 = kotlinx.coroutines.d.h(r0)
            if (r7 == 0) goto L38
            r6.L$0 = r0
            r6.label = r3
            r4 = 1800000(0x1b7740, double:8.89318E-318)
            java.lang.Object r7 = Ua.U.a(r4, r6)
            if (r7 != r1) goto L32
            return r1
        L32:
            com.stepos.ailauncher.chat.controller.ActiveConversationManager r7 = r6.this$0
            com.stepos.ailauncher.chat.controller.ActiveConversationManager.c(r7)
            goto L1e
        L38:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.ActiveConversationManager$startPeriodicRefresh$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
