package com.stepos.ailauncher.taskstore.livenotification;

import Ua.Y;
import android.content.Context;
import android.util.Log;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.database.TaskStoreDatabase;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$init$1$1", f = "TaskLiveNotificationDispatcher.kt", l = {329}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$init$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Xa.c {
        final /* synthetic */ Context $appContext;

        public a(Context context) {
            this.$appContext = context;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<TaskInfoCard> list, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = TaskLiveNotificationDispatcher.INSTANCE;
            Context context = this.$appContext;
            kotlin.jvm.internal.p.f(context);
            Object objC0 = taskLiveNotificationDispatcher.c0(context, list, interfaceC4014c);
            return objC0 == C4063a.g() ? objC0 : Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$init$1$1(Context context, InterfaceC4014c<? super TaskLiveNotificationDispatcher$init$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appContext = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskLiveNotificationDispatcher$init$1$1 taskLiveNotificationDispatcher$init$1$1 = new TaskLiveNotificationDispatcher$init$1$1(this.$appContext, interfaceC4014c);
        taskLiveNotificationDispatcher$init$1$1.L$0 = obj;
        return taskLiveNotificationDispatcher$init$1$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$init$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        Ua.M m10 = (Ua.M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Context context = this.$appContext;
                Result.Companion companion = Result.INSTANCE;
                com.stepos.ailauncher.taskstore.repository.a aVarN = TaskStoreModule.INSTANCE.n();
                Xa.b bVarE = Xa.d.E(aVarN.t(), Y.b());
                a aVar = new a(context);
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.L$2 = g9.h.a(aVarN);
                this.I$0 = 0;
                this.label = 1;
                if (bVarE.collect(aVar, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("TaskLiveNotificationDispatcher", "dispatcher observe failed", thE);
            if (A5.a.INSTANCE.d(thE)) {
                TaskStoreDatabase.INSTANCE.j("dispatcher:" + thE.getMessage());
            }
        }
        return Y8.t.f7040a;
    }
}
