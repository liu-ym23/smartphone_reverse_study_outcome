package com.stepos.ailauncher.taskstore.repository;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$saveResultSnapshot$2", f = "TaskInfoCardRepositoryImpl.kt", l = {297, 300, 302}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl$saveResultSnapshot$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {
    final /* synthetic */ List<TaskInfoPart> $parts;
    final /* synthetic */ String $taskId;
    final /* synthetic */ Integer $version;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ TaskInfoCardRepositoryImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardRepositoryImpl$saveResultSnapshot$2(Integer num, TaskInfoCardRepositoryImpl taskInfoCardRepositoryImpl, String str, List<TaskInfoPart> list, InterfaceC4014c<? super TaskInfoCardRepositoryImpl$saveResultSnapshot$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$version = num;
        this.this$0 = taskInfoCardRepositoryImpl;
        this.$taskId = str;
        this.$parts = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardRepositoryImpl$saveResultSnapshot$2(this.$version, this.this$0, this.$taskId, this.$parts, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((TaskInfoCardRepositoryImpl$saveResultSnapshot$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        if (r12 == r0) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[PHI: r12
      0x0069: PHI (r12v11 java.lang.Object) = (r12v7 java.lang.Object), (r12v0 java.lang.Object) binds: [B:22:0x0066, B:10:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ae  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.label
            r2 = -1
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2d
            if (r1 == r5) goto L29
            if (r1 == r4) goto L25
            if (r1 != r3) goto L1d
            int r0 = r11.I$0
            java.lang.Object r11 = r11.L$0
            java.lang.String r11 = (java.lang.String) r11
            kotlin.C4849c.b(r12)
            goto La1
        L1d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L25:
            kotlin.C4849c.b(r12)
            goto L69
        L29:
            kotlin.C4849c.b(r12)
            goto L4b
        L2d:
            kotlin.C4849c.b(r12)
            java.lang.Integer r12 = r11.$version
            if (r12 == 0) goto L58
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl r12 = r11.this$0
            com.stepos.ailauncher.taskstore.database.d r12 = com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.w(r12)
            java.lang.String r1 = r11.$taskId
            java.lang.Integer r6 = r11.$version
            int r6 = r6.intValue()
            r11.label = r5
            java.lang.Object r12 = r12.b(r1, r6, r11)
            if (r12 != r0) goto L4b
            goto L9f
        L4b:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L58
            java.lang.Integer r11 = g9.C4109a.f(r2)
            return r11
        L58:
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl r12 = r11.this$0
            com.stepos.ailauncher.taskstore.database.d r12 = com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.w(r12)
            java.lang.String r1 = r11.$taskId
            r11.label = r4
            java.lang.Object r12 = r12.a(r1, r11)
            if (r12 != r0) goto L69
            goto L9f
        L69:
            java.lang.Number r12 = (java.lang.Number) r12
            int r6 = r12.intValue()
            com.stepos.ailauncher.taskstore.database.TaskInfoConverters r12 = com.stepos.ailauncher.taskstore.database.TaskInfoConverters.INSTANCE
            java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoPart> r1 = r11.$parts
            java.lang.String r12 = r12.m(r1)
            if (r12 != 0) goto L7b
            java.lang.String r12 = ""
        L7b:
            r8 = r12
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl r12 = r11.this$0
            com.stepos.ailauncher.taskstore.database.d r12 = com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.w(r12)
            com.stepos.ailauncher.taskstore.database.i r4 = new com.stepos.ailauncher.taskstore.database.i
            java.lang.String r5 = r11.$taskId
            java.lang.Integer r7 = r11.$version
            long r9 = java.lang.System.currentTimeMillis()
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.Object r1 = g9.h.a(r8)
            r11.L$0 = r1
            r11.I$0 = r6
            r11.label = r3
            java.lang.Object r12 = r12.c(r4, r11)
            if (r12 != r0) goto La0
        L9f:
            return r0
        La0:
            r0 = r6
        La1:
            java.lang.Number r12 = (java.lang.Number) r12
            long r11 = r12.longValue()
            r3 = -1
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 != 0) goto Lae
            goto Laf
        Lae:
            r2 = r0
        Laf:
            java.lang.Integer r11 = g9.C4109a.f(r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$saveResultSnapshot$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
