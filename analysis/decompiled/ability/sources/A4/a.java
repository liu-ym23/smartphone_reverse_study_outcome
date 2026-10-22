package A4;

import D7.v;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.NotificationCompat;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.api.task.registry.ITaskRegistry;
import com.stepos.ability.bean.ExplainSnapshot;
import com.stepos.ability.bean.Task;
import com.stepos.ability.bean.ToolCallEvent;
import com.stepos.ability.common.TaskStatus;
import j9.m;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class a implements ITaskListener {

    /* renamed from: a, reason: collision with root package name */
    public final ITaskRegistry f96a;

    public a(ITaskRegistry taskRegistry) {
        kotlin.jvm.internal.k.f(taskRegistry, "taskRegistry");
        this.f96a = taskRegistry;
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void clear() {
        k.f106a.clear();
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), "listeners cleared", null);
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onExplainUpdated(String taskId, ExplainSnapshot snapshot) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(snapshot, "snapshot");
        for (Map.Entry entry : k.f106a.entrySet()) {
            String str = (String) entry.getKey();
            k.c.execute(new h((j) entry.getValue(), taskId, snapshot, str));
        }
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onInfoDismissed(final String taskId, final String requestId, final String reason, final String chatSessionId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(reason, "reason");
        kotlin.jvm.internal.k.f(chatSessionId, "chatSessionId");
        ConcurrentHashMap concurrentHashMap = k.f106a;
        StringBuilder sbW = B7.a.w("publishInfoDismissed: taskId=", taskId, ", requestId=", requestId, ", reason=");
        sbW.append(reason);
        sbW.append(", chatSessionId=");
        sbW.append(chatSessionId);
        String msg = sbW.toString();
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
        for (Map.Entry entry : k.f106a.entrySet()) {
            final String str = (String) entry.getKey();
            final j jVar = (j) entry.getValue();
            k.c.execute(new Runnable() { // from class: A4.c
                @Override // java.lang.Runnable
                public final void run() {
                    j jVar2 = jVar;
                    try {
                        jVar2.f105a.onInfoDismissed(taskId, requestId, reason, chatSessionId);
                    } catch (Throwable th) {
                        k.b(str, "publishInfoDismissed", th);
                    }
                }
            });
        }
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onInfoRequested(final String taskId, final String requestId, final String inputType, String str, String str2, final long j5, String str3) {
        final String chatSessionId = str3;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(requestId, "requestId");
        kotlin.jvm.internal.k.f(inputType, "inputType");
        final String message = str;
        kotlin.jvm.internal.k.f(message, "message");
        final String payloadJson = str2;
        kotlin.jvm.internal.k.f(payloadJson, "payloadJson");
        kotlin.jvm.internal.k.f(chatSessionId, "chatSessionId");
        ConcurrentHashMap concurrentHashMap = k.f106a;
        int size = concurrentHashMap.size();
        StringBuilder sbW = B7.a.w("publishInfoRequested: taskId=", taskId, ", requestId=", requestId, ", chatSessionId=");
        sbW.append(chatSessionId);
        sbW.append(", size=");
        sbW.append(size);
        String msg = sbW.toString();
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            final String str4 = (String) entry.getKey();
            final j jVar = (j) entry.getValue();
            k.c.execute(new Runnable() { // from class: A4.d
                @Override // java.lang.Runnable
                public final void run() {
                    j jVar2 = jVar;
                    try {
                        jVar2.f105a.onInfoRequested(taskId, requestId, inputType, message, payloadJson, j5, chatSessionId);
                    } catch (Throwable th) {
                        k.b(str4, "publishInfoRequested", th);
                    }
                }
            });
            message = str;
            payloadJson = str2;
            chatSessionId = str3;
        }
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onPackageConflict(final int i, final String newTaskId, final String newTaskName, final String runningTaskId, final String packageName, String str) {
        kotlin.jvm.internal.k.f(newTaskId, "newTaskId");
        kotlin.jvm.internal.k.f(newTaskName, "newTaskName");
        kotlin.jvm.internal.k.f(runningTaskId, "runningTaskId");
        kotlin.jvm.internal.k.f(packageName, "packageName");
        final String hint = str;
        kotlin.jvm.internal.k.f(hint, "hint");
        ConcurrentHashMap concurrentHashMap = k.f106a;
        StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "publishPackageConflict: kind=", ", new=", newTaskId, ", newName=");
        androidx.constraintlayout.core.dsl.a.A(sbK, newTaskName, ", running=", runningTaskId, ", pkg=");
        sbK.append(packageName);
        String msg = sbK.toString();
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
        for (Map.Entry entry : k.f106a.entrySet()) {
            final String str2 = (String) entry.getKey();
            final j jVar = (j) entry.getValue();
            k.c.execute(new Runnable() { // from class: A4.f
                @Override // java.lang.Runnable
                public final void run() {
                    j jVar2 = jVar;
                    try {
                        jVar2.f105a.onPackageConflict(i, newTaskId, newTaskName, runningTaskId, packageName, hint);
                    } catch (Throwable th) {
                        k.b(str2, "publishPackageConflict", th);
                    }
                }
            });
            hint = str;
        }
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onRequestRelaunch(String taskId, String chatSessionId, String reason) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(chatSessionId, "chatSessionId");
        kotlin.jvm.internal.k.f(reason, "reason");
        ConcurrentHashMap concurrentHashMap = k.f106a;
        int size = concurrentHashMap.size();
        StringBuilder sbW = B7.a.w("[RELAUNCH] publishRequestRelaunch: taskId=", taskId, ", sessionId=", chatSessionId, ", reason=");
        sbW.append(reason);
        sbW.append(", size=");
        sbW.append(size);
        String msg = sbW.toString();
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getKey();
            k.c.execute(new g((j) entry.getValue(), taskId, chatSessionId, reason, str));
        }
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onTaskEvent(Task task, boolean z10) {
        kotlin.jvm.internal.k.f(task, "task");
        String msg = "onTaskEvent: task=" + task;
        kotlin.jvm.internal.k.f(msg, "msg");
        String strConcat = "Ability_".concat("TaskListener");
        P3.b bVar = P3.c.f1086a;
        bVar.invoke(3, strConcat, msg, null);
        TaskStatus.b.getClass();
        boolean zContains = TaskStatus.e.contains(Integer.valueOf(task.getStatus()));
        ITaskRegistry iTaskRegistry = this.f96a;
        if (zContains) {
            iTaskRegistry.unregister(task.getTaskId());
        } else {
            if (v.u0(TaskStatus.d, iTaskRegistry.getStatus(task.getTaskId())) && TaskStatus.c.contains(Integer.valueOf(task.getStatus())) && task.getStatus() != 2) {
                String msg2 = "onTaskEvent: keep TAKE_OVER, drop substatus=" + task.getStatus() + " taskId=" + task.getTaskId();
                kotlin.jvm.internal.k.f(msg2, "msg");
                bVar.invoke(3, "Ability_".concat("TaskListener"), msg2, null);
            } else {
                iTaskRegistry.updateStatus(task.getTaskId(), task.getStatus());
            }
        }
        ConcurrentHashMap concurrentHashMap = k.f106a;
        String msg3 = "publishTaskEvent: task=" + task + " taskListeners size:" + concurrentHashMap.size() + " publishToTaskListener:" + z10;
        kotlin.jvm.internal.k.f(msg3, "msg");
        bVar.invoke(3, "Ability_".concat("TaskListenerManager"), msg3, null);
        if (z10) {
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                k.c.execute(new e((String) entry.getKey(), task, (j) entry.getValue()));
            }
        }
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void onToolCallEvent(ToolCallEvent event) {
        kotlin.jvm.internal.k.f(event, "event");
        for (Map.Entry entry : k.f106a.entrySet()) {
            String str = (String) entry.getKey();
            k.c.execute(new e((j) entry.getValue(), event, str, 0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [A4.i, android.os.IBinder$DeathRecipient] */
    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void registerTaskListener(com.stepos.ability.ITaskListener aidlTaskListener, final String key) throws RemoteException {
        Object objPutIfAbsent;
        kotlin.jvm.internal.k.f(aidlTaskListener, "aidlTaskListener");
        kotlin.jvm.internal.k.f(key, "key");
        if (m.s0(key)) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = k.f106a;
        P3.b bVar = P3.c.f1086a;
        ConcurrentHashMap concurrentHashMap2 = k.f106a;
        if (m.s0(key)) {
            return;
        }
        final String strA = k.a(key);
        j jVar = (j) concurrentHashMap2.remove(key);
        if (jVar != null) {
            try {
                jVar.f105a.asBinder().unlinkToDeath(jVar.b, 0);
            } catch (Exception unused) {
            }
        }
        ?? r5 = new IBinder.DeathRecipient() { // from class: A4.i
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                ConcurrentHashMap concurrentHashMap3 = k.f106a;
                String str = key;
                concurrentHashMap3.remove(str);
                Set set = (Set) k.b.get(strA);
                if (set != null) {
                    set.remove(str);
                }
                String msg = "listener removed (binder died): ".concat(str);
                kotlin.jvm.internal.k.f(msg, "msg");
                P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
            }
        };
        try {
            aidlTaskListener.asBinder().linkToDeath(r5, 0);
        } catch (Exception e) {
            bVar.invoke(5, "Ability_".concat("TaskListenerManager"), androidx.constraintlayout.core.dsl.a.h("linkToDeath failed: ", e.getMessage(), NotificationCompat.CATEGORY_MESSAGE), null);
        }
        concurrentHashMap2.put(key, new j(aidlTaskListener, r5));
        ConcurrentHashMap concurrentHashMap3 = k.b;
        Object objNewKeySet = concurrentHashMap3.get(strA);
        if (objNewKeySet == null && (objPutIfAbsent = concurrentHashMap3.putIfAbsent(strA, (objNewKeySet = ConcurrentHashMap.newKeySet()))) != null) {
            objNewKeySet = objPutIfAbsent;
        }
        ((Set) objNewKeySet).add(key);
        String msg = "registerTaskListener ok: key=" + key + ", total=" + concurrentHashMap2.size();
        kotlin.jvm.internal.k.f(msg, "msg");
        bVar.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
    }

    @Override // com.stepos.ability.api.task.listener.ITaskListener
    public final void unRegisterTaskListener(String key) {
        kotlin.jvm.internal.k.f(key, "key");
        ConcurrentHashMap concurrentHashMap = k.b;
        ConcurrentHashMap concurrentHashMap2 = k.f106a;
        if (m.s0(key)) {
            return;
        }
        if (m.i0(key, '#')) {
            String strA = k.a(key);
            j jVar = (j) concurrentHashMap2.remove(key);
            if (jVar != null) {
                try {
                    jVar.f105a.asBinder().unlinkToDeath(jVar.b, 0);
                } catch (Exception unused) {
                }
            }
            Set set = (Set) concurrentHashMap.get(strA);
            if (set != null) {
                set.remove(key);
            }
        } else {
            Set set2 = (Set) concurrentHashMap.remove(key);
            if (set2 != null) {
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    j jVar2 = (j) concurrentHashMap2.remove((String) it.next());
                    if (jVar2 != null) {
                        try {
                            jVar2.f105a.asBinder().unlinkToDeath(jVar2.b, 0);
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        }
        String msg = "unRegisterTaskListener: key=" + key + ", total=" + concurrentHashMap2.size();
        kotlin.jvm.internal.k.f(msg, "msg");
        P3.c.f1086a.invoke(3, "Ability_".concat("TaskListenerManager"), msg, null);
    }
}
