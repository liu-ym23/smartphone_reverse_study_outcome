package com.stepos.ailauncher.taskstore.read;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.read.TaskReadStateManager$markRead$1", f = "TaskReadStateManager.kt", l = {34, 36, 37}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskReadStateManager$markRead$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ String $taskId;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskReadStateManager$markRead$1(String str, String str2, InterfaceC4014c<? super TaskReadStateManager$markRead$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$reason = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskReadStateManager$markRead$1 taskReadStateManager$markRead$1 = new TaskReadStateManager$markRead$1(this.$taskId, this.$reason, interfaceC4014c);
        taskReadStateManager$markRead$1.L$0 = obj;
        return taskReadStateManager$markRead$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskReadStateManager$markRead$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e6, code lost:
    
        if (r9.H(r10, r14) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc A[Catch: all -> 0x0027, TryCatch #0 {all -> 0x0027, blocks: (B:8:0x0022, B:36:0x00e9, B:15:0x003f, B:31:0x00b8, B:33:0x00bc, B:18:0x0052, B:25:0x008a, B:27:0x0092, B:21:0x005f), top: B:44:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.read.TaskReadStateManager$markRead$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
