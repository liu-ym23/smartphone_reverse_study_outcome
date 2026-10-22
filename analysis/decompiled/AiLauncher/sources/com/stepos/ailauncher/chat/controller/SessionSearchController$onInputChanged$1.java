package com.stepos.ailauncher.chat.controller;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.controller.SessionSearchController$onInputChanged$1", f = "SessionSearchController.kt", l = {DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP, 173}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SessionSearchController$onInputChanged$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $keyword;
    int label;
    final /* synthetic */ SessionSearchController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionSearchController$onInputChanged$1(SessionSearchController sessionSearchController, String str, InterfaceC4014c<? super SessionSearchController$onInputChanged$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionSearchController;
        this.$keyword = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionSearchController$onInputChanged$1(this.this$0, this.$keyword, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionSearchController$onInputChanged$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0036, code lost:
    
        if (r6 == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r6)
            goto L39
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1a:
            kotlin.C4849c.b(r6)
            goto L2c
        L1e:
            kotlin.C4849c.b(r6)
            r5.label = r3
            r3 = 250(0xfa, double:1.235E-321)
            java.lang.Object r6 = Ua.U.a(r3, r5)
            if (r6 != r0) goto L2c
            goto L38
        L2c:
            com.stepos.ailauncher.chat.controller.SessionSearchController r6 = r5.this$0
            java.lang.String r1 = r5.$keyword
            r5.label = r2
            java.lang.Object r6 = com.stepos.ailauncher.chat.controller.SessionSearchController.j(r6, r1, r5)
            if (r6 != r0) goto L39
        L38:
            return r0
        L39:
            java.util.List r6 = (java.util.List) r6
            com.stepos.ailauncher.chat.controller.SessionSearchController r0 = r5.this$0
            java.lang.String r0 = com.stepos.ailauncher.chat.controller.SessionSearchController.f(r0)
            java.lang.String r1 = r5.$keyword
            boolean r0 = kotlin.jvm.internal.p.d(r0, r1)
            if (r0 != 0) goto L4c
            Y8.t r5 = Y8.t.f7040a
            return r5
        L4c:
            com.stepos.ailauncher.chat.controller.SessionSearchController r0 = r5.this$0
            java.lang.String r5 = r5.$keyword
            com.stepos.ailauncher.chat.controller.SessionSearchController.i(r0, r6, r5)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.controller.SessionSearchController$onInputChanged$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
