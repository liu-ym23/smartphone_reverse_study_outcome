package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import Z8.C1173v;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1", f = "AgentBusEventRouter.kt", l = {783}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super List<? extends TaskInfoCard>>, Object> {
    final /* synthetic */ List<String> $keys;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1(List<String> list, InterfaceC4014c<? super AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$keys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1 agentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1 = new AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1(this.$keys, interfaceC4014c);
        agentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1.L$0 = obj;
        return agentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c) {
        return ((AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                List<String> list = this.$keys;
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = aVarN.i(list, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b((List) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("AILauncher-AgentBus", "maybeCancelAuth: load session cards failed", thE, false, 8, null);
        }
        return Result.g(objB) ? C1173v.m() : objB;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends TaskInfoCard>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<TaskInfoCard>>) interfaceC4014c);
    }
}
