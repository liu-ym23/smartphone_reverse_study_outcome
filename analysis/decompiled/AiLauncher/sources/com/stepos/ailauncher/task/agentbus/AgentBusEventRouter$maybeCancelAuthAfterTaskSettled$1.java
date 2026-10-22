package com.stepos.ailauncher.task.agentbus;

import Ua.C1056g;
import Ua.I;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1173v;
import com.stepos.agentframework.chatcore.session.list.SessionActivityTracker;
import com.stepos.ailauncher.agent.ability.RiskCardHandoffCoordinator;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1", f = "AgentBusEventRouter.kt", l = {782}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ TaskInfoCard $card;
    final /* synthetic */ List<String> $keys;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1(TaskInfoCard taskInfoCard, List<String> list, InterfaceC4014c<? super AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$card = taskInfoCard;
        this.$keys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1(this.$card, this.$keys, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10;
        Object objG = C4063a.g();
        int i11 = this.label;
        if (i11 == 0) {
            C4849c.b(obj);
            I iB = Y.b();
            AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1 agentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1 = new AgentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1(this.$keys, null);
            this.label = 1;
            obj = C1056g.j(iB, agentBusEventRouter$maybeCancelAuthAfterTaskSettled$1$siblings$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        List list = (List) obj;
        boolean z10 = list instanceof Collection;
        if (!z10 || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((TaskInfoCard) it.next()).getStatus().isTerminal()) {
                    String taskId = this.$card.getTaskId();
                    TaskInfoStatus status = this.$card.getStatus();
                    if (z10 && list.isEmpty()) {
                        i10 = 0;
                    } else {
                        Iterator it2 = list.iterator();
                        i10 = 0;
                        while (it2.hasNext()) {
                            if (!((TaskInfoCard) it2.next()).getStatus().isTerminal() && (i10 = i10 + 1) < 0) {
                                C1173v.v();
                            }
                        }
                    }
                    C4148a.k("AILauncher-AgentBus", "keep risk: session still active after " + taskId + " " + status + " active=" + i10, false, 4, null);
                    return t.f7040a;
                }
            }
        }
        SessionActivityTracker sessionActivityTracker = SessionActivityTracker.INSTANCE;
        String[] strArr = (String[]) this.$keys.toArray(new String[0]);
        if (sessionActivityTracker.g((String[]) Arrays.copyOf(strArr, strArr.length))) {
            C4148a.k("AILauncher-AgentBus", "keep risk: artifact reedit in progress after " + this.$card.getTaskId() + " " + this.$card.getStatus() + " keys=" + this.$keys, false, 4, null);
            return t.f7040a;
        }
        List<String> list2 = this.$keys;
        TaskInfoCard taskInfoCard = this.$card;
        for (String str : list2) {
            RiskCardHandoffCoordinator.INSTANCE.p(str, "task settled " + taskInfoCard.getTaskId() + " " + taskInfoCard.getStatus());
        }
        return t.f7040a;
    }
}
