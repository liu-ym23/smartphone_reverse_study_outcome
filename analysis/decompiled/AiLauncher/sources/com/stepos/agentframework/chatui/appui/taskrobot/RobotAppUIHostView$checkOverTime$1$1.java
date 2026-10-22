package com.stepos.agentframework.chatui.appui.taskrobot;

import Ua.M;
import com.stepos.agentframework.chatcore.session.J0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.RobotInfo;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatui.appui.taskrobot.RobotAppUIHostView$checkOverTime$1$1", f = "RobotAppUIHostView.kt", l = {264}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class RobotAppUIHostView$checkOverTime$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ RobotInfo $info;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotAppUIHostView$checkOverTime$1$1(RobotInfo robotInfo, InterfaceC4014c<? super RobotAppUIHostView$checkOverTime$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$info = robotInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RobotAppUIHostView$checkOverTime$1$1(this.$info, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RobotAppUIHostView$checkOverTime$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            RobotInfo robotInfo = this.$info;
            this.label = 1;
            if (J0.b(robotInfo, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
