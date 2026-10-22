package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import com.mdisdk.Task;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$Companion$create$job$1", f = "ZyqlGuiAgentTask.kt", l = {452, 467}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class ZyqlGuiAgentTask$Companion$create$job$1 extends SuspendLambda implements S7.n {
    final /* synthetic */ Context $context;
    final /* synthetic */ ZyqlGuiAgentTask $guiTask;
    final /* synthetic */ Task $mdiTask;
    final /* synthetic */ String $openAppName;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $taskName;
    final /* synthetic */ int $taskType;
    long J$0;
    long J$1;
    long J$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZyqlGuiAgentTask$Companion$create$job$1(ZyqlGuiAgentTask zyqlGuiAgentTask, Context context, String str, String str2, int i, Task task, String str3, H7.c<? super ZyqlGuiAgentTask$Companion$create$job$1> cVar) {
        super(2, cVar);
        this.$guiTask = zyqlGuiAgentTask;
        this.$context = context;
        this.$openAppName = str;
        this.$taskName = str2;
        this.$taskType = i;
        this.$mdiTask = task;
        this.$taskId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        ZyqlGuiAgentTask$Companion$create$job$1 zyqlGuiAgentTask$Companion$create$job$1 = new ZyqlGuiAgentTask$Companion$create$job$1(this.$guiTask, this.$context, this.$openAppName, this.$taskName, this.$taskType, this.$mdiTask, this.$taskId, cVar);
        zyqlGuiAgentTask$Companion$create$job$1.L$0 = obj;
        return zyqlGuiAgentTask$Companion$create$job$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00dd, code lost:
    
        if (r1 == r2) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0147  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask$Companion$create$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ZyqlGuiAgentTask$Companion$create$job$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
