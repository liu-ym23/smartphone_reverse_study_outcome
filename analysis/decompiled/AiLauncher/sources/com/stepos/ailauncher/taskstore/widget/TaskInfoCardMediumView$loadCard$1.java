package com.stepos.ailauncher.taskstore.widget;

import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView$loadCard$1", f = "TaskInfoCardMediumView.kt", l = {261}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskInfoCardMediumView$loadCard$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super TaskInfoCard>, Object> {
    final /* synthetic */ String $taskId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskInfoCardMediumView$loadCard$1(String str, InterfaceC4014c<? super TaskInfoCardMediumView$loadCard$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskInfoCardMediumView$loadCard$1(this.$taskId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super TaskInfoCard> interfaceC4014c) {
        return ((TaskInfoCardMediumView$loadCard$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
        String str = this.$taskId;
        this.label = 1;
        Object objQ = aVarN.q(str, this);
        return objQ == objG ? objG : objQ;
    }
}
