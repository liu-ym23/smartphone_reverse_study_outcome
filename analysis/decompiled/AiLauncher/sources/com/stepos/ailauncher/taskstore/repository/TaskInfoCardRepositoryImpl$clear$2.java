package com.stepos.ailauncher.taskstore.repository;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$clear$2", f = "TaskInfoCardRepositoryImpl.kt", l = {289, 290, 291}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$clear$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$clear$2(TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$clear$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = taskInfoCardRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardRepositoryImpl$clear$2(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((TaskInfoCardRepositoryImpl$clear$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        if (r7.J(r4, r6) != r0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[LOOP:0: B:19:0x006e->B:21:0x0074, LOOP_END] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r6 = r6.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.C4849c.b(r7)
            goto L91
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L22:
            java.lang.Object r1 = r6.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.C4849c.b(r7)
            goto L5a
        L2a:
            kotlin.C4849c.b(r7)
            goto L46
        L2e:
            kotlin.C4849c.b(r7)
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl r7 = r6.this$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r7 = com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.v(r7)
            com.stepos.ailauncher.taskstore.TaskStoreModule r1 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE
            java.lang.String r1 = r1.k()
            r6.label = r4
            java.lang.Object r7 = r7.z(r1, r6)
            if (r7 != r0) goto L46
            goto L90
        L46:
            r1 = r7
            java.util.List r1 = (java.util.List) r1
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl r7 = r6.this$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r7 = com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.v(r7)
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.d(r6)
            if (r7 != r0) goto L5a
            goto L90
        L5a:
            com.stepos.ailauncher.taskstore.TaskStoreModule r7 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = Z8.C1174w.x(r3, r5)
            r4.<init>(r5)
            java.util.Iterator r3 = r3.iterator()
        L6e:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L82
            java.lang.Object r5 = r3.next()
            com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r5 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r5
            java.lang.String r5 = r5.getTaskId()
            r4.add(r5)
            goto L6e
        L82:
            java.lang.Object r1 = g9.h.a(r1)
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r6 = r7.J(r4, r6)
            if (r6 != r0) goto L91
        L90:
            return r0
        L91:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$clear$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
