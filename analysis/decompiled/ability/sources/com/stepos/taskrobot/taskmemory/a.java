package com.stepos.taskrobot.taskmemory;

import m9.AbstractC1683A;
import m9.AbstractC1691I;
import u9.c;
import u9.d;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4061a = new a();

    static {
        d dVar = AbstractC1691I.f5315a;
        AbstractC1683A.b(c.f6743a.limitedParallelism(1).plus(AbstractC1683A.c()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.stepos.taskrobot.taskmemory.entity.TaskEntity r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$3
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$3 r0 = (com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$3) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$3 r0 = new com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$3
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f4056a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)     // Catch: java.lang.Exception -> L65
            goto L5e
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            r0.c = r2     // Catch: java.lang.Exception -> L65
            m9.k r4 = new m9.k     // Catch: java.lang.Exception -> L65
            H7.c r0 = U7.a.I(r0)     // Catch: java.lang.Exception -> L65
            r4.<init>(r2, r0)     // Catch: java.lang.Exception -> L65
            r4.y()     // Catch: java.lang.Exception -> L65
            s6.a r0 = com.stepos.taskrobot.taskmemory.AppTaskDatabase.Companion     // Catch: java.lang.Exception -> L65
            android.app.Application r1 = S0.b.p     // Catch: java.lang.Exception -> L65
            kotlin.jvm.internal.k.c(r1)     // Catch: java.lang.Exception -> L65
            com.stepos.taskrobot.taskmemory.AppTaskDatabase r0 = r0.b(r1)     // Catch: java.lang.Exception -> L65
            m9.W r1 = m9.C1704W.f5321a     // Catch: java.lang.Exception -> L65
            com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$4$1 r2 = new com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTask$4$1     // Catch: java.lang.Exception -> L65
            r3 = 0
            r2.<init>(r5, r0, r4, r3)     // Catch: java.lang.Exception -> L65
            r5 = 3
            m9.AbstractC1683A.n(r1, r3, r2, r5)     // Catch: java.lang.Exception -> L65
            java.lang.Object r4 = r4.x()     // Catch: java.lang.Exception -> L65
            if (r4 != r6) goto L5e
            return r6
        L5e:
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> L65
            long r4 = r4.longValue()     // Catch: java.lang.Exception -> L65
            goto L7f
        L65:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "insertTask 数据库插入失败 "
            r5.<init>(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "AppTaskDatabaseManager"
            android.util.Log.d(r5, r4)
            r4 = -1
        L7f:
            java.lang.Long r6 = new java.lang.Long
            r6.<init>(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.taskmemory.a.a(com.stepos.taskrobot.taskmemory.entity.TaskEntity, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.stepos.taskrobot.taskmemory.entity.TaskStepEntity r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$1 r0 = (com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$1 r0 = new com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f4058a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)     // Catch: java.lang.Exception -> L4c
            goto L45
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            u9.d r4 = m9.AbstractC1691I.f5315a     // Catch: java.lang.Exception -> L4c
            u9.c r4 = u9.c.f6743a     // Catch: java.lang.Exception -> L4c
            com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$2 r1 = new com.stepos.taskrobot.taskmemory.AppTaskDatabaseManager$insertTaskStep$2     // Catch: java.lang.Exception -> L4c
            r3 = 0
            r1.<init>(r5, r3)     // Catch: java.lang.Exception -> L4c
            r0.c = r2     // Catch: java.lang.Exception -> L4c
            java.lang.Object r4 = m9.AbstractC1683A.w(r4, r1, r0)     // Catch: java.lang.Exception -> L4c
            if (r4 != r6) goto L45
            return r6
        L45:
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> L4c
            long r4 = r4.longValue()     // Catch: java.lang.Exception -> L4c
            goto L66
        L4c:
            r4 = move-exception
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "insertTaskStep 数据库插入失败: "
            r5.<init>(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "AppTaskDatabaseManager"
            android.util.Log.e(r5, r4)
            r4 = -1
        L66:
            java.lang.Long r6 = new java.lang.Long
            r6.<init>(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.taskmemory.a.b(com.stepos.taskrobot.taskmemory.entity.TaskStepEntity, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
