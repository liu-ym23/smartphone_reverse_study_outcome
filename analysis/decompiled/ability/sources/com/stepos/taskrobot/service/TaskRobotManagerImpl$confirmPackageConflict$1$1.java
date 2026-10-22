package com.stepos.taskrobot.service;

import C7.r;
import J7.c;
import S7.n;
import com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "com.stepos.taskrobot.service.TaskRobotManagerImpl$confirmPackageConflict$1$1", f = "TaskRobotManagerImpl.kt", l = {476}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
/* loaded from: classes3.dex */
public final class TaskRobotManagerImpl$confirmPackageConflict$1$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f4045a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskRobotManagerImpl$confirmPackageConflict$1$1(String str, int i, H7.c cVar) {
        super(2, cVar);
        this.b = str;
        this.c = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new TaskRobotManagerImpl$confirmPackageConflict$1$1(this.b, this.c, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((TaskRobotManagerImpl$confirmPackageConflict$1$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.f4045a;
        if (i == 0) {
            b.b(obj);
            SystemSdkBridge systemSdkBridge = SystemSdkBridge.INSTANCE;
            String str = this.b;
            if (str == null) {
                str = "";
            }
            this.f4045a = 1;
            if (systemSdkBridge.confirmPackageConflict(str, this.c, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return r.f317a;
    }
}
