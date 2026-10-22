package com.stepos.ailauncher.chat.input;

import Ua.M;
import Y8.t;
import com.stepos.ailauncher.foundation.task.TaskModule;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.input.ChatStopActions$cancelUnfinishedTasksAwait$taskIds$1", f = "ChatStopActions.kt", l = {50}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatStopActions$cancelUnfinishedTasksAwait$taskIds$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends UiTask>>, Object> {
    int label;

    public ChatStopActions$cancelUnfinishedTasksAwait$taskIds$1(InterfaceC4014c<? super ChatStopActions$cancelUnfinishedTasksAwait$taskIds$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatStopActions$cancelUnfinishedTasksAwait$taskIds$1(interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super List<UiTask>> interfaceC4014c) {
        return ((ChatStopActions$cancelUnfinishedTasksAwait$taskIds$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        TaskModule taskModule = TaskModule.INSTANCE;
        this.label = 1;
        Object objF = taskModule.f(this);
        return objF == objG ? objG : objF;
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends UiTask>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super List<UiTask>>) interfaceC4014c);
    }
}
