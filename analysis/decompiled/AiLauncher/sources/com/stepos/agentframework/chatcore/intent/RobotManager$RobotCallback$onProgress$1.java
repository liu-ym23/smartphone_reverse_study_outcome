package com.stepos.agentframework.chatcore.intent;

import Ua.M;
import android.graphics.Bitmap;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.intent.RobotManager$RobotCallback$onProgress$1", f = "RobotManager.kt", l = {436}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class RobotManager$RobotCallback$onProgress$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ GuiTaskProgress $progress;
    int label;
    final /* synthetic */ RobotManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotManager$RobotCallback$onProgress$1(RobotManager robotManager, GuiTaskProgress guiTaskProgress, InterfaceC4014c<? super RobotManager$RobotCallback$onProgress$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = robotManager;
        this.$progress = guiTaskProgress;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RobotManager$RobotCallback$onProgress$1(this.this$0, this.$progress, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((RobotManager$RobotCallback$onProgress$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RobotManager$RobotCallback$onProgress$1 robotManager$RobotCallback$onProgress$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            RobotManager robotManager = this.this$0;
            String taskId = this.$progress.getTaskId();
            String taskName = this.$progress.getTaskName();
            String action = this.$progress.getAction();
            String bitmapId = this.$progress.getBitmapId();
            Bitmap bitmap = this.$progress.getBitmap();
            String message = this.$progress.getMessage();
            this.label = 1;
            robotManager$RobotCallback$onProgress$1 = this;
            if (robotManager.s(taskId, taskName, action, bitmapId, bitmap, message, robotManager$RobotCallback$onProgress$1) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            robotManager$RobotCallback$onProgress$1 = this;
        }
        String action2 = robotManager$RobotCallback$onProgress$1.$progress.getAction();
        J4.a aVar = J4.a.INSTANCE;
        if (kotlin.jvm.internal.p.d(action2, aVar.d()) || kotlin.jvm.internal.p.d(robotManager$RobotCallback$onProgress$1.$progress.getAction(), aVar.b()) || kotlin.jvm.internal.p.d(robotManager$RobotCallback$onProgress$1.$progress.getAction(), aVar.a())) {
            robotManager$RobotCallback$onProgress$1.this$0.F(robotManager$RobotCallback$onProgress$1.$progress.getTaskId());
        }
        return Y8.t.f7040a;
    }
}
