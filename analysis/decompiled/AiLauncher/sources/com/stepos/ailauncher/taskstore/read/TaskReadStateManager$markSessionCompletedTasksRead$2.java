package com.stepos.ailauncher.taskstore.read;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)I"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.read.TaskReadStateManager$markSessionCompletedTasksRead$2", f = "TaskReadStateManager.kt", l = {61, 68, 69, 74}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskReadStateManager$markSessionCompletedTasksRead$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super Integer>, Object> {
    final /* synthetic */ String $normalizedSessionId;
    final /* synthetic */ String $reason;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskReadStateManager$markSessionCompletedTasksRead$2(String str, String str2, InterfaceC4014c<? super TaskReadStateManager$markSessionCompletedTasksRead$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$normalizedSessionId = str;
        this.$reason = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskReadStateManager$markSessionCompletedTasksRead$2 taskReadStateManager$markSessionCompletedTasksRead$2 = new TaskReadStateManager$markSessionCompletedTasksRead$2(this.$normalizedSessionId, this.$reason, interfaceC4014c);
        taskReadStateManager$markSessionCompletedTasksRead$2.L$0 = obj;
        return taskReadStateManager$markSessionCompletedTasksRead$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return ((TaskReadStateManager$markSessionCompletedTasksRead$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01ca A[Catch: all -> 0x022f, TryCatch #2 {all -> 0x022f, blocks: (B:64:0x02ad, B:47:0x0223, B:49:0x0227, B:37:0x0170, B:41:0x01c2, B:43:0x01ca, B:57:0x025f, B:59:0x0270), top: B:81:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0227 A[Catch: all -> 0x022f, TryCatch #2 {all -> 0x022f, blocks: (B:64:0x02ad, B:47:0x0223, B:49:0x0227, B:37:0x0170, B:41:0x01c2, B:43:0x01ca, B:57:0x025f, B:59:0x0270), top: B:81:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025f A[Catch: all -> 0x022f, TryCatch #2 {all -> 0x022f, blocks: (B:64:0x02ad, B:47:0x0223, B:49:0x0227, B:37:0x0170, B:41:0x01c2, B:43:0x01ca, B:57:0x025f, B:59:0x0270), top: B:81:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0217 -> B:81:0x0223). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0244 -> B:54:0x0253). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.read.TaskReadStateManager$markSessionCompletedTasksRead$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
