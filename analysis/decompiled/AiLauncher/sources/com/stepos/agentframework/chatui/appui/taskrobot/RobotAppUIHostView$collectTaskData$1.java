package com.stepos.agentframework.chatui.appui.taskrobot;

import Ua.M;
import com.stepos.agentframework.chatcore.intent.RobotManager;
import com.stepos.agentframework.chatcore.intent.TaskRobotAction;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView$collectTaskData$1", f = "RobotAppUIHostView.kt", l = {420}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class RobotAppUIHostView$collectTaskData$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ RobotAppUIHostView this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ RobotAppUIHostView this$0;

        public a(RobotAppUIHostView robotAppUIHostView) {
            this.this$0 = robotAppUIHostView;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(TaskRobotAction taskRobotAction, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            String taskId = taskRobotAction.getTaskId();
            String flag = this.this$0.getFlag();
            kotlin.jvm.internal.p.f(flag);
            if (kotlin.jvm.internal.p.d(taskId, flag)) {
                this.this$0.Z(taskRobotAction);
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAppUIHostView$collectTaskData$1(RobotAppUIHostView robotAppUIHostView, InterfaceC4014c<? super RobotAppUIHostView$collectTaskData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = robotAppUIHostView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RobotAppUIHostView$collectTaskData$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RobotAppUIHostView$collectTaskData$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.o<TaskRobotAction> oVarY = RobotManager.INSTANCE.a().y();
            a aVar = new a(this.this$0);
            this.label = 1;
            if (oVarY.collect(aVar, this) == objG) {
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
