package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$onRiskDismissed$1", f = "TaskLiveNotificationDispatcher.kt", l = {1743}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$onRiskDismissed$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $aliasSessionId;
    final /* synthetic */ Context $appContext;
    final /* synthetic */ boolean $justAnswered;
    final /* synthetic */ String $requestId;
    final /* synthetic */ Ua.M $s;
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$onRiskDismissed$1(boolean z10, String str, Ua.M m10, Context context, String str2, String str3, InterfaceC4014c<? super TaskLiveNotificationDispatcher$onRiskDismissed$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$justAnswered = z10;
        this.$sessionId = str;
        this.$s = m10;
        this.$appContext = context;
        this.$aliasSessionId = str2;
        this.$requestId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$onRiskDismissed$1(this.$justAnswered, this.$sessionId, this.$s, this.$appContext, this.$aliasSessionId, this.$requestId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$onRiskDismissed$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            if (this.$justAnswered) {
                Log.d("TaskLiveNotificationDispatcher", "risk answered → drop 待授权 overlay sessionId=" + this.$sessionId);
                TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = TaskLiveNotificationDispatcher.INSTANCE;
                Ua.M m10 = this.$s;
                Context context = this.$appContext;
                kotlin.jvm.internal.p.f(context);
                taskLiveNotificationDispatcher.S(m10, context, this.$sessionId);
                Context context2 = this.$appContext;
                kotlin.jvm.internal.p.f(context2);
                TaskLiveNotificationDispatcher.N0(taskLiveNotificationDispatcher, context2, false, 2, null);
            }
            this.label = 1;
            if (Ua.U.a(2000L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        TaskLiveNotificationDispatcher.riskTransitionJobs.remove(this.$sessionId);
        if (!x.INSTANCE.m(new String[]{this.$sessionId, this.$aliasSessionId}, this.$requestId)) {
            Log.d("TaskLiveNotificationDispatcher", "risk transition skipped: already removed sessionId=" + this.$sessionId);
            return Y8.t.f7040a;
        }
        if (TaskLiveNotificationDispatcher.riskAfterglows.get(this.$sessionId) == null) {
            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher2 = TaskLiveNotificationDispatcher.INSTANCE;
            Ua.M m11 = this.$s;
            Context context3 = this.$appContext;
            kotlin.jvm.internal.p.f(context3);
            taskLiveNotificationDispatcher2.S(m11, context3, this.$sessionId);
        }
        String str = (String) TaskLiveNotificationDispatcher.dismissedSessions.remove(this.$sessionId);
        Log.d("TaskLiveNotificationDispatcher", "onRiskDismissed sessionId=" + this.$sessionId + " removedDismissed=" + str + " (delayed 2000ms) → recompute");
        TaskLiveNotificationDispatcher taskLiveNotificationDispatcher3 = TaskLiveNotificationDispatcher.INSTANCE;
        Context context4 = this.$appContext;
        kotlin.jvm.internal.p.f(context4);
        TaskLiveNotificationDispatcher.N0(taskLiveNotificationDispatcher3, context4, false, 2, null);
        return Y8.t.f7040a;
    }
}
