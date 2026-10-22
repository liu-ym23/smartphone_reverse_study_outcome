package com.stepos.agentframework.chatcore.intent;

import Ua.M;
import android.graphics.Bitmap;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.intent.TaskDispatcher$persistOrphanGuiTaskStatus$1", f = "TaskDispatcher.kt", l = {454, 456, 462, 473}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class TaskDispatcher$persistOrphanGuiTaskStatus$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $taskName;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskDispatcher$persistOrphanGuiTaskStatus$1(String str, Bitmap bitmap, String str2, InterfaceC4014c<? super TaskDispatcher$persistOrphanGuiTaskStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$bitmap = bitmap;
        this.$taskName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskDispatcher$persistOrphanGuiTaskStatus$1(this.$taskId, this.$bitmap, this.$taskName, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskDispatcher$persistOrphanGuiTaskStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e1, code lost:
    
        if (com.stepos.agentframework.chatcore.session.J0.b(r5, r22) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0136, code lost:
    
        if (com.stepos.agentframework.chatcore.session.J0.b(r7, r22) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.TaskDispatcher$persistOrphanGuiTaskStatus$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
