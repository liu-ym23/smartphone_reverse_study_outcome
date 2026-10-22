package com.stepos.ailauncher.taskstore.livenotification;

import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$persistFailedDismissedCards$1", f = "TaskLiveNotificationDispatcher.kt", l = {1993}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$persistFailedDismissedCards$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ List<TaskInfoCard> $persistCards;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$persistFailedDismissedCards$1(List<TaskInfoCard> list, InterfaceC4014c<? super TaskLiveNotificationDispatcher$persistFailedDismissedCards$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$persistCards = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskLiveNotificationDispatcher$persistFailedDismissedCards$1 taskLiveNotificationDispatcher$persistFailedDismissedCards$1 = new TaskLiveNotificationDispatcher$persistFailedDismissedCards$1(this.$persistCards, interfaceC4014c);
        taskLiveNotificationDispatcher$persistFailedDismissedCards$1.L$0 = obj;
        return taskLiveNotificationDispatcher$persistFailedDismissedCards$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$persistFailedDismissedCards$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a6 -> B:31:0x00a9). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = r12.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r12.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            int r2 = r12.I$0
            java.lang.Object r5 = r12.L$6
            Ua.M r5 = (Ua.M) r5
            java.lang.Object r5 = r12.L$5
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r5
            java.lang.Object r6 = r12.L$3
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r12.L$2
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.Object r8 = r12.L$1
            com.stepos.ailauncher.taskstore.repository.a r8 = (com.stepos.ailauncher.taskstore.repository.a) r8
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L2b
            goto La9
        L2b:
            r13 = move-exception
            goto Lb8
        L2e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L36:
            kotlin.C4849c.b(r13)
            kotlin.Result$a r13 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.stepos.ailauncher.taskstore.TaskStoreModule r13 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE     // Catch: java.lang.Throwable -> L46
            com.stepos.ailauncher.taskstore.repository.a r13 = r13.n()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> L46
            goto L51
        L46:
            r13 = move-exception
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        L51:
            boolean r2 = kotlin.Result.g(r13)
            if (r2 == 0) goto L58
            r13 = 0
        L58:
            com.stepos.ailauncher.taskstore.repository.a r13 = (com.stepos.ailauncher.taskstore.repository.a) r13
            if (r13 != 0) goto L5f
            Y8.t r12 = Y8.t.f7040a
            return r12
        L5f:
            java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r2 = r12.$persistCards
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r5 = r2.iterator()
            r8 = r13
            r7 = r2
            r2 = r4
            r6 = r5
        L6b:
            boolean r13 = r6.hasNext()
            if (r13 == 0) goto Le4
            java.lang.Object r13 = r6.next()
            r5 = r13
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r5
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2b
            java.lang.String r9 = r5.getTaskId()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r10 = "FAILED"
            r12.L$0 = r0     // Catch: java.lang.Throwable -> L2b
            r12.L$1 = r8     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r11 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L2b
            r12.L$2 = r11     // Catch: java.lang.Throwable -> L2b
            r12.L$3 = r6     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r13 = g9.h.a(r13)     // Catch: java.lang.Throwable -> L2b
            r12.L$4 = r13     // Catch: java.lang.Throwable -> L2b
            r12.L$5 = r5     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r13 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L2b
            r12.L$6 = r13     // Catch: java.lang.Throwable -> L2b
            r12.I$0 = r2     // Catch: java.lang.Throwable -> L2b
            r12.I$1 = r4     // Catch: java.lang.Throwable -> L2b
            r12.I$2 = r4     // Catch: java.lang.Throwable -> L2b
            r12.label = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r13 = r8.k(r9, r10, r12)     // Catch: java.lang.Throwable -> L2b
            if (r13 != r1) goto La9
            return r1
        La9:
            java.lang.Number r13 = (java.lang.Number) r13     // Catch: java.lang.Throwable -> L2b
            int r13 = r13.intValue()     // Catch: java.lang.Throwable -> L2b
            java.lang.Integer r13 = g9.C4109a.f(r13)     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r13 = kotlin.Result.b(r13)     // Catch: java.lang.Throwable -> L2b
            goto Lc2
        Lb8:
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r13 = kotlin.C4849c.a(r13)
            java.lang.Object r13 = kotlin.Result.b(r13)
        Lc2:
            java.lang.Throwable r13 = kotlin.Result.e(r13)
            if (r13 == 0) goto L6b
            java.lang.String r5 = r5.getTaskId()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "setNotificationDismissed failed taskId="
            r9.append(r10)
            r9.append(r5)
            java.lang.String r5 = r9.toString()
            java.lang.String r9 = "TaskLiveNotificationDispatcher"
            android.util.Log.w(r9, r5, r13)
            goto L6b
        Le4:
            Y8.t r12 = Y8.t.f7040a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$persistFailedDismissedCards$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
