package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.util.Log;
import com.stepos.agentframework.chatcore.session.list.SessionListItem;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.livenotification.TaskLiveNotificationDispatcher$onSessionsForgotten$1", f = "TaskLiveNotificationDispatcher.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class TaskLiveNotificationDispatcher$onSessionsForgotten$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ List<String> $ids;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskLiveNotificationDispatcher$onSessionsForgotten$1(List<String> list, Context context, InterfaceC4014c<? super TaskLiveNotificationDispatcher$onSessionsForgotten$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$ids = list;
        this.$appContext = context;
    }

    public static final boolean h(Set set, TaskInfoCard taskInfoCard) {
        return C3723k.INSTANCE.b(taskInfoCard, set);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskLiveNotificationDispatcher$onSessionsForgotten$1(this.$ids, this.$appContext, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TaskLiveNotificationDispatcher$onSessionsForgotten$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        final Set<String> setB0 = TaskLiveNotificationDispatcher.INSTANCE.b0(this.$ids);
        Z8.A.L(TaskLiveNotificationDispatcher.lastCards, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.K
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(TaskLiveNotificationDispatcher$onSessionsForgotten$1.h(setB0, (TaskInfoCard) obj2));
            }
        });
        List list = TaskLiveNotificationDispatcher.lastSessions;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            SessionListItem sessionListItem = (SessionListItem) obj2;
            Set<String> set = setB0;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (C3723k.INSTANCE.f((String) it.next(), sessionListItem.getSessionId())) {
                        break;
                    }
                }
            }
            arrayList.add(obj2);
        }
        TaskLiveNotificationDispatcher.lastSessions = arrayList;
        TaskLiveNotificationDispatcher taskLiveNotificationDispatcher = TaskLiveNotificationDispatcher.INSTANCE;
        TaskLiveNotificationDispatcher.lastContentSessionIds = taskLiveNotificationDispatcher.r0(TaskLiveNotificationDispatcher.lastContentSessionIds, setB0);
        TaskLiveNotificationDispatcher.lastArtifactSessionIds = taskLiveNotificationDispatcher.r0(TaskLiveNotificationDispatcher.lastArtifactSessionIds, setB0);
        TaskLiveNotificationDispatcher.cancelledIslandKeys = taskLiveNotificationDispatcher.r0(TaskLiveNotificationDispatcher.cancelledIslandKeys, setB0);
        Context context = this.$appContext;
        kotlin.jvm.internal.p.f(context);
        taskLiveNotificationDispatcher.U(context, setB0, false);
        Log.d("TaskLiveNotificationDispatcher", "onSessionsForgotten sessionIds=" + setB0);
        Context context2 = this.$appContext;
        kotlin.jvm.internal.p.f(context2);
        TaskLiveNotificationDispatcher.N0(taskLiveNotificationDispatcher, context2, false, 2, null);
        return Y8.t.f7040a;
    }
}
