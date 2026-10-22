package com.stepos.ailauncher.taskstore.widget;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView$dispatchInteractTask$1", f = "TaskInfoCardMediumView.kt", l = {705}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardMediumView$dispatchInteractTask$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Map<String, Object> $answers;
    final /* synthetic */ String $taskId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardMediumView$dispatchInteractTask$1(String str, Map<String, ? extends Object> map, InterfaceC4014c<? super TaskInfoCardMediumView$dispatchInteractTask$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$answers = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskInfoCardMediumView$dispatchInteractTask$1 taskInfoCardMediumView$dispatchInteractTask$1 = new TaskInfoCardMediumView$dispatchInteractTask$1(this.$taskId, this.$answers, interfaceC4014c);
        taskInfoCardMediumView$dispatchInteractTask$1.L$0 = obj;
        return taskInfoCardMediumView$dispatchInteractTask$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskInfoCardMediumView$dispatchInteractTask$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = r14.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r14.label
            java.lang.String r3 = " answers="
            java.lang.String r4 = "TaskInfoCardMediumView"
            r5 = 1
            if (r2 == 0) goto L31
            if (r2 != r5) goto L29
            java.lang.Object r0 = r14.L$3
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r0 = r14.L$2
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r1 = r14.L$1
            java.lang.String r1 = (java.lang.String) r1
            kotlin.C4849c.b(r15)     // Catch: java.lang.Throwable -> L24
            r11 = r14
            goto L60
        L24:
            r0 = move-exception
            r15 = r0
            r11 = r14
            goto L98
        L29:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L31:
            kotlin.C4849c.b(r15)
            java.lang.String r7 = r14.$taskId
            java.util.Map<java.lang.String, java.lang.Object> r8 = r14.$answers
            kotlin.Result$a r15 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L95
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager r6 = com.stepos.ailauncher.taskstore.sync.TaskSyncManager.INSTANCE     // Catch: java.lang.Throwable -> L95
            java.lang.Object r15 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L95
            r14.L$0 = r15     // Catch: java.lang.Throwable -> L95
            r14.L$1 = r7     // Catch: java.lang.Throwable -> L95
            r14.L$2 = r8     // Catch: java.lang.Throwable -> L95
            java.lang.Object r15 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L95
            r14.L$3 = r15     // Catch: java.lang.Throwable -> L95
            r15 = 0
            r14.I$0 = r15     // Catch: java.lang.Throwable -> L95
            r14.label = r5     // Catch: java.lang.Throwable -> L95
            r9 = 0
            r10 = 0
            r12 = 12
            r13 = 0
            r11 = r14
            java.lang.Object r15 = com.stepos.ailauncher.taskstore.sync.TaskSyncManager.w(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L92
            if (r15 != r1) goto L5e
            return r1
        L5e:
            r1 = r7
            r0 = r8
        L60:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch: java.lang.Throwable -> L92
            boolean r14 = r15.booleanValue()     // Catch: java.lang.Throwable -> L92
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92
            r15.<init>()     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = "dispatchInteractTask: taskId="
            r15.append(r2)     // Catch: java.lang.Throwable -> L92
            r15.append(r1)     // Catch: java.lang.Throwable -> L92
            r15.append(r3)     // Catch: java.lang.Throwable -> L92
            r15.append(r0)     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = " ok="
            r15.append(r0)     // Catch: java.lang.Throwable -> L92
            r15.append(r14)     // Catch: java.lang.Throwable -> L92
            java.lang.String r14 = r15.toString()     // Catch: java.lang.Throwable -> L92
            int r14 = h8.C4148a.j(r4, r14, r5)     // Catch: java.lang.Throwable -> L92
            java.lang.Integer r14 = g9.C4109a.f(r14)     // Catch: java.lang.Throwable -> L92
            java.lang.Object r14 = kotlin.Result.b(r14)     // Catch: java.lang.Throwable -> L92
            goto La2
        L92:
            r0 = move-exception
        L93:
            r15 = r0
            goto L98
        L95:
            r0 = move-exception
            r11 = r14
            goto L93
        L98:
            kotlin.Result$a r14 = kotlin.Result.INSTANCE
            java.lang.Object r14 = kotlin.C4849c.a(r15)
            java.lang.Object r14 = kotlin.Result.b(r14)
        La2:
            java.lang.String r15 = r11.$taskId
            java.util.Map<java.lang.String, java.lang.Object> r0 = r11.$answers
            java.lang.Throwable r14 = kotlin.Result.e(r14)
            if (r14 == 0) goto Lc6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "dispatchInteractTask: failed taskId="
            r1.append(r2)
            r1.append(r15)
            r1.append(r3)
            r1.append(r0)
            java.lang.String r15 = r1.toString()
            h8.C4148a.r(r4, r15, r14, r5)
        Lc6:
            Y8.t r14 = Y8.t.f7040a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView$dispatchInteractTask$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
