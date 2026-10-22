package com.stepos.ailauncher.taskstore.sync;

import Y8.t;
import com.stepos.agentframework.chatcore.SessionHandler;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.TaskCancelRequest;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.sync.TaskSyncManager$cancelTask$2", f = "TaskSyncManager.kt", l = {345}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskSyncManager$cancelTask$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Boolean>, Object> {
    final /* synthetic */ String $taskId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskSyncManager$cancelTask$2(String str, InterfaceC4014c<? super TaskSyncManager$cancelTask$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.$taskId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new TaskSyncManager$cancelTask$2(this.$taskId, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((TaskSyncManager$cancelTask$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        SessionHandler sessionHandlerZ = TaskSyncManager.INSTANCE.z();
        TaskCancelRequest taskCancelRequest = new TaskCancelRequest(this.$taskId, null, null, null, null, 30, null);
        this.label = 1;
        Object objB4 = sessionHandlerZ.b4(taskCancelRequest, this);
        return objB4 == objG ? objG : objB4;
    }
}
