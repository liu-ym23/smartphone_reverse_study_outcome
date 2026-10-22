package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.intent.RobotManager;
import com.stepos.agentframework.chatcore.intent.TaskRobotAction;
import com.stepos.ailauncher.chat.manager.C2706l;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.task.TaskModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerGuiActionListener$1", f = "AgentBusEventRouter.kt", l = {1275}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$registerGuiActionListener$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    int label;

    public AgentBusEventRouter$registerGuiActionListener$1(InterfaceC4014c<? super AgentBusEventRouter$registerGuiActionListener$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusEventRouter$registerGuiActionListener$1(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$registerGuiActionListener$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<TaskRobotAction> oVarY = RobotManager.INSTANCE.a().y();
            Xa.c<? super TaskRobotAction> cVar = new Xa.c() { // from class: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerGuiActionListener$1.1

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
                @InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerGuiActionListener$1$1$1", f = "AgentBusEventRouter.kt", l = {1292}, m = "invokeSuspend", v = 1)
                /* renamed from: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$registerGuiActionListener$1$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C03301 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
                    final /* synthetic */ String $sid;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C03301(String str, InterfaceC4014c<? super C03301> interfaceC4014c) {
                        super(2, interfaceC4014c);
                        this.$sid = str;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                        return new C03301(this.$sid, interfaceC4014c);
                    }

                    @Override // p9.p
                    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                        return ((C03301) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objG = C4063a.g();
                        int i10 = this.label;
                        if (i10 == 0) {
                            C4849c.b(obj);
                            TaskModule taskModule = TaskModule.INSTANCE;
                            String str = this.$sid;
                            this.label = 1;
                            if (taskModule.c(str, this) == objG) {
                                return objG;
                            }
                        } else {
                            if (i10 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            C4849c.b(obj);
                        }
                        return t.f7040a;
                    }
                }

                @Override // Xa.c
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object emit(TaskRobotAction taskRobotAction, InterfaceC4014c<? super t> interfaceC4014c) {
                    if (kotlin.jvm.internal.p.d(taskRobotAction.getAction(), J4.a.INSTANCE.l())) {
                        U5.b.INSTANCE.s(SpriteEventAction.GUI_OPERATE);
                    }
                    if (kotlin.jvm.internal.p.d(taskRobotAction.getAction(), "user_cancel")) {
                        String message = taskRobotAction.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        Function2.a(new C03301(message, null));
                        SessionHandler sessionHandlerE = C2706l.INSTANCE.a().e(message);
                        if (sessionHandlerE != null) {
                            sessionHandlerE.X3();
                        }
                    }
                    C4148a.k("AILauncher-AgentBus", "RobotManager: " + taskRobotAction.getTaskId() + " action:" + taskRobotAction.getAction(), false, 4, null);
                    return t.f7040a;
                }
            };
            this.label = 1;
            if (oVarY.collect(cVar, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
