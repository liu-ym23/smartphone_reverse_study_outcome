package com.stepos.ailauncher.taskstore.livenotification;

import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$markSessionDismissed$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$markSessionDismissed$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $phaseName;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$markSessionDismissed$1(String str, String str2, InterfaceC4014c<? super TaskLiveNotificationDispatcher$markSessionDismissed$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$phaseName = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$markSessionDismissed$1(this.$sessionId, this.$phaseName, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$markSessionDismissed$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        TaskLiveNotificationDispatcher.INSTANCE.R0(this.$sessionId, this.$phaseName, "receiver");
        TaskLiveNotificationDispatcher.lastStates.remove(this.$sessionId);
        TaskLiveNotificationDispatcher.lastNetworkPhases.remove(this.$sessionId);
        Log.d("TaskLiveNotificationDispatcher", "markSessionDismissed sessionId=" + this.$sessionId + " phase=" + this.$phaseName);
        return Y8.t.f7040a;
    }
}
