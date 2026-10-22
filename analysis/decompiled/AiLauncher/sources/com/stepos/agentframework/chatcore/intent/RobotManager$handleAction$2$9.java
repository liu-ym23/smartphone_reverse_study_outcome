package com.stepos.agentframework.chatcore.intent;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.intent.RobotManager$handleAction$2$9", f = "RobotManager.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class RobotManager$handleAction$2$9 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $message;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $taskName;
    int label;
    final /* synthetic */ RobotManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotManager$handleAction$2$9(String str, String str2, String str3, RobotManager robotManager, InterfaceC4014c<? super RobotManager$handleAction$2$9> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$taskName = str2;
        this.$message = str3;
        this.this$0 = robotManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RobotManager$handleAction$2$9(this.$taskId, this.$taskName, this.$message, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RobotManager$handleAction$2$9) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.A(new TaskRobotAction(J4.a.INSTANCE.m(), this.$taskId, this.$taskName, null, null, this.$message, null, null, 216, null));
        return Y8.t.f7040a;
    }
}
