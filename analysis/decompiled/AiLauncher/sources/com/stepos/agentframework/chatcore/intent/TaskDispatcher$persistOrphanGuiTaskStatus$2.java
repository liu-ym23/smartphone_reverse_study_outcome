package com.stepos.agentframework.chatcore.intent;

import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.intent.TaskDispatcher$persistOrphanGuiTaskStatus$2", f = "TaskDispatcher.kt", l = {486, 492, 503}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class TaskDispatcher$persistOrphanGuiTaskStatus$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $action;
    final /* synthetic */ String $dbStatus;
    final /* synthetic */ String $message;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $taskName;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskDispatcher$persistOrphanGuiTaskStatus$2(String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super TaskDispatcher$persistOrphanGuiTaskStatus$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$dbStatus = str2;
        this.$action = str3;
        this.$message = str4;
        this.$taskName = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskDispatcher$persistOrphanGuiTaskStatus$2(this.$taskId, this.$dbStatus, this.$action, this.$message, this.$taskName, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskDispatcher$persistOrphanGuiTaskStatus$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (com.stepos.agentframework.chatcore.session.J0.b(r2, r20) == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        if (com.stepos.agentframework.chatcore.session.J0.b(r6, r20) == r1) goto L45;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.TaskDispatcher$persistOrphanGuiTaskStatus$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
