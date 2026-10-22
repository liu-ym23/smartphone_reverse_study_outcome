package com.stepos.agentframework.chatcore.intent;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.intent.RobotManager", f = "RobotManager.kt", l = {205}, m = "saveRobotCaptureImageToFile", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RobotManager$saveRobotCaptureImageToFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RobotManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotManager$saveRobotCaptureImageToFile$1(RobotManager robotManager, InterfaceC4014c<? super RobotManager$saveRobotCaptureImageToFile$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = robotManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.z(null, null, this);
    }
}
