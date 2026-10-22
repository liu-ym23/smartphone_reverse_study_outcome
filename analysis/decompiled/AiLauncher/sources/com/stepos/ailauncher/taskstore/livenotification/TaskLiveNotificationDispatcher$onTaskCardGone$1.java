package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1172u;
import Z8.X;
import android.content.Context;
import android.util.Log;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$onTaskCardGone$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$onTaskCardGone$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ String $taskId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$onTaskCardGone$1(Context context, String str, InterfaceC4014c<? super TaskLiveNotificationDispatcher$onTaskCardGone$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$appContext = context;
        this.$taskId = str;
    }

    public static final boolean h(String str, TaskInfoCard taskInfoCard) {
        return kotlin.jvm.internal.p.d(taskInfoCard.getTaskId(), str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$onTaskCardGone$1(this.$appContext, this.$taskId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$onTaskCardGone$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object next;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ArrayList arrayList = TaskLiveNotificationDispatcher.lastCards;
        String str = this.$taskId;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((TaskInfoCard) next).getTaskId(), str)) {
                break;
            }
        }
        TaskInfoCard taskInfoCard = (TaskInfoCard) next;
        String strC = taskInfoCard != null ? A6.c.INSTANCE.c(taskInfoCard) : null;
        TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = TaskLiveNotificationDispatcher.INSTANCE;
        List listC = C1172u.c();
        if (strC != null) {
            C4109a.a(listC.add(strC));
        }
        if (taskInfoCard != null) {
            listC.addAll(C3723k.INSTANCE.a(taskInfoCard));
        }
        Set<String> setB0 = taskLiveNotificationDispatcher.b0(C1172u.a(listC));
        ArrayList arrayList2 = TaskLiveNotificationDispatcher.lastCards;
        final String str2 = this.$taskId;
        boolean zL = Z8.A.L(arrayList2, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.L
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(TaskLiveNotificationDispatcher$onTaskCardGone$1.h(str2, (TaskInfoCard) obj2));
            }
        });
        if (zL) {
            ArrayList arrayList3 = TaskLiveNotificationDispatcher.lastCards;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : arrayList3) {
                TaskInfoCard taskInfoCard2 = (TaskInfoCard) obj2;
                if (!setB0.isEmpty() ? C3723k.INSTANCE.b(taskInfoCard2, setB0) : kotlin.jvm.internal.p.d(A6.c.INSTANCE.c(taskInfoCard2), strC)) {
                    arrayList4.add(obj2);
                }
            }
            if (A6.c.INSTANCE.d(arrayList4) == null) {
                Set<String> setA = setB0;
                if (setA.isEmpty()) {
                    Set setB = X.b();
                    if (strC != null) {
                        C4109a.a(setB.add(strC));
                    }
                    setA = X.a(setB);
                }
                Set<String> set = setA;
                TaskLiveNotificationDispatcher taskLiveNotificationDispatcher2 = TaskLiveNotificationDispatcher.INSTANCE;
                Context context = this.$appContext;
                kotlin.jvm.internal.p.f(context);
                taskLiveNotificationDispatcher2.U(context, set, true);
                Log.d("TaskLiveNotificationDispatcher", "onTaskCardGone: last task removed, session cancelled taskId=" + this.$taskId + " sessionIds=" + set);
                return Y8.t.f7040a;
            }
        }
        Log.d("TaskLiveNotificationDispatcher", "onTaskCardGone taskId=" + this.$taskId + " removedFromSnapshot=" + zL + " sessionId=" + strC + " sessionIds=" + setB0);
        TaskLiveNotificationDispatcher taskLiveNotificationDispatcher3 = TaskLiveNotificationDispatcher.INSTANCE;
        Context context2 = this.$appContext;
        kotlin.jvm.internal.p.f(context2);
        TaskLiveNotificationDispatcher.N0(taskLiveNotificationDispatcher3, context2, false, 2, null);
        return Y8.t.f7040a;
    }
}
