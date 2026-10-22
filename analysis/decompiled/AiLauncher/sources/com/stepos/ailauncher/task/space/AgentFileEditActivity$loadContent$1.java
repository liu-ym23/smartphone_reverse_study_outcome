package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.AgentFileEditActivity$loadContent$1", f = "AgentFileEditActivity.kt", l = {114, 115}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileEditActivity$loadContent$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ AgentFileEditActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileEditActivity$loadContent$1(AgentFileEditActivity agentFileEditActivity, InterfaceC4014c<? super AgentFileEditActivity$loadContent$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentFileEditActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileEditActivity$loadContent$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentFileEditActivity$loadContent$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r6 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        if (r6 == r0) goto L22;
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
            r4 = 0
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.C4849c.b(r6)
            goto L46
        L13:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1b:
            kotlin.C4849c.b(r6)
            goto L2d
        L1f:
            kotlin.C4849c.b(r6)
            com.stepos.ailauncher.task.space.AgentFileEditActivity r6 = r5.this$0
            r5.label = r3
            java.lang.Object r6 = com.stepos.ailauncher.task.space.AgentFileEditActivity.J(r6, r5)
            if (r6 != r0) goto L2d
            goto L45
        L2d:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L3b
            int r1 = r6.length()
            if (r1 <= 0) goto L38
            goto L39
        L38:
            r6 = r4
        L39:
            if (r6 != 0) goto L5a
        L3b:
            com.stepos.ailauncher.task.space.AgentFileEditActivity r6 = r5.this$0
            r5.label = r2
            java.lang.Object r6 = com.stepos.ailauncher.task.space.AgentFileEditActivity.K(r6, r5)
            if (r6 != r0) goto L46
        L45:
            return r0
        L46:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L51
            int r0 = r6.length()
            if (r0 <= 0) goto L51
            goto L52
        L51:
            r6 = r4
        L52:
            if (r6 != 0) goto L5a
            com.stepos.ailauncher.task.space.AgentFileEditActivity r6 = r5.this$0
            java.lang.String r6 = com.stepos.ailauncher.task.space.AgentFileEditActivity.D(r6)
        L5a:
            com.stepos.ailauncher.task.space.AgentFileEditActivity r0 = r5.this$0
            com.stepos.ailauncher.task.space.AgentFileEditActivity.M(r0, r6)
            com.stepos.ailauncher.task.space.AgentFileEditActivity r0 = r5.this$0
            r6.a r0 = com.stepos.ailauncher.task.space.AgentFileEditActivity.C(r0)
            if (r0 != 0) goto L6d
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.p.A(r0)
            goto L6e
        L6d:
            r4 = r0
        L6e:
            android.widget.EditText r0 = r4.etContent
            r0.setText(r6)
            com.stepos.ailauncher.task.space.AgentFileEditActivity r6 = r5.this$0
            r0 = 0
            com.stepos.ailauncher.task.space.AgentFileEditActivity.L(r6, r0)
            com.stepos.ailauncher.task.space.AgentFileEditActivity r5 = r5.this$0
            com.stepos.ailauncher.task.space.AgentFileEditActivity.Q(r5)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.AgentFileEditActivity$loadContent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
