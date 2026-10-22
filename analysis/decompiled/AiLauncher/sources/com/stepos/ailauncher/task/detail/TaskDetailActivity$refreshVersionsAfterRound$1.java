package com.stepos.ailauncher.task.detail;

import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.detail.TaskDetailActivity$refreshVersionsAfterRound$1", f = "TaskDetailActivity.kt", l = {318}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskDetailActivity$refreshVersionsAfterRound$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $fileId;
    int label;
    final /* synthetic */ TaskDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskDetailActivity$refreshVersionsAfterRound$1(TaskDetailActivity taskDetailActivity, String str, InterfaceC4014c<? super TaskDetailActivity$refreshVersionsAfterRound$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = taskDetailActivity;
        this.$fileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskDetailActivity$refreshVersionsAfterRound$1(this.this$0, this.$fileId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskDetailActivity$refreshVersionsAfterRound$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            TaskDetailActivity taskDetailActivity = this.this$0;
            String str = this.$fileId;
            this.label = 1;
            obj = taskDetailActivity.I2(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        List list = (List) obj;
        if (list != null && list.size() > this.this$0.versions.size()) {
            C4148a.k("TaskDetailActivity", "refreshVersionsAfterRound → versions=" + this.this$0.versions.size() + "→" + list.size() + ", show latest", false, 4, null);
            this.this$0.versions = list;
            this.this$0.F3(C1173v.o(list));
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }
}
