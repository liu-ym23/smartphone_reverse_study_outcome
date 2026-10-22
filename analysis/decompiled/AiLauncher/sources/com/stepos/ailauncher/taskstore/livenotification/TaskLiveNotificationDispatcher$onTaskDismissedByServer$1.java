package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.util.Log;
import com.stepos.agentframework.chatcore.session.list.SessionAuthorizationState;
import com.stepos.agentframework.chatcore.session.list.SessionListItem;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$onTaskDismissedByServer$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$onTaskDismissedByServer$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$onTaskDismissedByServer$1(String str, Context context, InterfaceC4014c<? super TaskLiveNotificationDispatcher$onTaskDismissedByServer$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$taskId = str;
        this.$appContext = context;
    }

    public static final boolean h(String str, TaskInfoCard taskInfoCard) {
        return kotlin.jvm.internal.p.d(taskInfoCard.getTaskId(), str);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TaskLiveNotificationDispatcher$onTaskDismissedByServer$1 taskLiveNotificationDispatcher$onTaskDismissedByServer$1 = new TaskLiveNotificationDispatcher$onTaskDismissedByServer$1(this.$taskId, this.$appContext, interfaceC4014c);
        taskLiveNotificationDispatcher$onTaskDismissedByServer$1.L$0 = obj;
        return taskLiveNotificationDispatcher$onTaskDismissedByServer$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$onTaskDismissedByServer$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        Object next;
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ArrayList arrayList = TaskLiveNotificationDispatcher.lastCards;
        String str = this.$taskId;
        Iterator it = arrayList.iterator();
        while (true) {
            obj2 = null;
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
        if (strC == null || La.H.x0(strC)) {
            Log.d("TaskLiveNotificationDispatcher", "onTaskDismissedByServer: no owning session for taskId=" + this.$taskId);
            return Y8.t.f7040a;
        }
        ArrayList arrayList2 = TaskLiveNotificationDispatcher.lastCards;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            if (kotlin.jvm.internal.p.d(A6.c.INSTANCE.c((TaskInfoCard) obj3), strC)) {
                arrayList3.add(obj3);
            }
        }
        String str2 = this.$taskId;
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : arrayList3) {
            if (!kotlin.jvm.internal.p.d(((TaskInfoCard) obj4).getTaskId(), str2)) {
                arrayList4.add(obj4);
            }
        }
        A6.c cVar = A6.c.INSTANCE;
        SessionActivityState sessionActivityStateD = cVar.d(arrayList4);
        boolean z10 = false;
        if (sessionActivityStateD != null) {
            ArrayList arrayList5 = TaskLiveNotificationDispatcher.lastCards;
            final String str3 = this.$taskId;
            Z8.A.L(arrayList5, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.M
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj5) {
                    return Boolean.valueOf(TaskLiveNotificationDispatcher$onTaskDismissedByServer$1.h(str3, (TaskInfoCard) obj5));
                }
            });
            Log.d("TaskLiveNotificationDispatcher", "onTaskDismissedByServer: session still active sessionId=" + strC);
            TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = TaskLiveNotificationDispatcher.INSTANCE;
            Context context = this.$appContext;
            kotlin.jvm.internal.p.f(context);
            TaskLiveNotificationDispatcher.N0(taskLiveNotificationDispatcher, context, false, 2, null);
            return Y8.t.f7040a;
        }
        SessionActivityState sessionActivityStateD2 = cVar.d(arrayList3);
        Iterator it2 = TaskLiveNotificationDispatcher.lastSessions.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (kotlin.jvm.internal.p.d(((SessionListItem) next2).getSessionId(), strC)) {
                obj2 = next2;
                break;
            }
        }
        SessionListItem sessionListItem = (SessionListItem) obj2;
        if (sessionListItem != null && sessionListItem.getAuthorizationState() != SessionAuthorizationState.NONE) {
            z10 = true;
        }
        SessionActivityState sessionActivityStateF = A6.c.f(cVar, sessionActivityStateD2, z10, null, false, 12, null);
        if (sessionActivityStateF != null) {
            TaskLiveNotificationDispatcher.INSTANCE.R0(strC, sessionActivityStateF.name(), "server_dismiss");
        }
        TaskLiveNotificationDispatcher.lastStates.remove(strC);
        TaskLiveNotificationDispatcher.lastNetworkPhases.remove(strC);
        Context context2 = this.$appContext;
        try {
            Result.Companion companion = Result.INSTANCE;
            A a10 = A.INSTANCE;
            kotlin.jvm.internal.p.f(context2);
            a10.f(context2, strC);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w("TaskLiveNotificationDispatcher", "cancel failed sessionId=" + strC, thE);
        }
        Log.d("TaskLiveNotificationDispatcher", "onTaskDismissedByServer: session dismissed sessionId=" + strC + " phase=" + sessionActivityStateF);
        return Y8.t.f7040a;
    }
}
