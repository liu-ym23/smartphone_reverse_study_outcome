package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.util.Log;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1", f = "TaskLiveNotificationDispatcher.kt", l = {1623}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1(InterfaceC4014c<? super TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1 taskLiveNotificationDispatcher$onLocalSessionTitleChanged$1 = new TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1(interfaceC4014c);
        taskLiveNotificationDispatcher$onLocalSessionTitleChanged$1.L$0 = obj;
        return taskLiveNotificationDispatcher$onLocalSessionTitleChanged$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$onLocalSessionTitleChanged$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Context context;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(TaskStoreModule.INSTANCE.L());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            Context context2 = (Context) objB;
            if (context2 == null) {
                return Y8.t.f7040a;
            }
            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = TaskLiveNotificationDispatcher.INSTANCE;
            this.L$0 = g9.h.a(m10);
            this.L$1 = context2;
            this.label = 1;
            Object objO0 = taskLiveNotificationDispatcher.o0(this);
            if (objO0 == objG) {
                return objG;
            }
            obj = objO0;
            context = context2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            context = (Context) this.L$1;
            C4849c.b(obj);
        }
        TaskLiveNotificationDispatcher.lastSessions = (List) obj;
        Log.d("TaskLiveNotificationDispatcher", "local session title changed → recompute");
        TaskLiveNotificationDispatcher.N0(TaskLiveNotificationDispatcher.INSTANCE, context, false, 2, null);
        return Y8.t.f7040a;
    }
}
