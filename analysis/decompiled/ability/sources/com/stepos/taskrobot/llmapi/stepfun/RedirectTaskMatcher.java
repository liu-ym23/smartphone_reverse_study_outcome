package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/RedirectTaskMatcher;", "", AppAgent.CONSTRUCT, "()V", "findTaskId", "", "snapshots", "", "Lcom/stepos/taskrobot/llmapi/stepfun/RedirectTaskMatcher$TaskSnapshot;", "packageName", "TaskSnapshot", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RedirectTaskMatcher {
    public static final RedirectTaskMatcher INSTANCE = new RedirectTaskMatcher();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/RedirectTaskMatcher$TaskSnapshot;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", "targetPackageName", "state", "Lstepai/aios/guiagent/model/SessionState;", "topPackageOnDisplay", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/model/SessionState;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getTargetPackageName", "getState", "()Lstepai/aios/guiagent/model/SessionState;", "getTopPackageOnDisplay", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TaskSnapshot {
        private final SessionState state;
        private final String targetPackageName;
        private final String taskId;
        private final String topPackageOnDisplay;

        public TaskSnapshot(String taskId, String str, SessionState state, String str2) {
            kotlin.jvm.internal.k.f(taskId, "taskId");
            kotlin.jvm.internal.k.f(state, "state");
            this.taskId = taskId;
            this.targetPackageName = str;
            this.state = state;
            this.topPackageOnDisplay = str2;
        }

        public static /* synthetic */ TaskSnapshot copy$default(TaskSnapshot taskSnapshot, String str, String str2, SessionState sessionState, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskSnapshot.taskId;
            }
            if ((i & 2) != 0) {
                str2 = taskSnapshot.targetPackageName;
            }
            if ((i & 4) != 0) {
                sessionState = taskSnapshot.state;
            }
            if ((i & 8) != 0) {
                str3 = taskSnapshot.topPackageOnDisplay;
            }
            return taskSnapshot.copy(str, str2, sessionState, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTargetPackageName() {
            return this.targetPackageName;
        }

        /* renamed from: component3, reason: from getter */
        public final SessionState getState() {
            return this.state;
        }

        /* renamed from: component4, reason: from getter */
        public final String getTopPackageOnDisplay() {
            return this.topPackageOnDisplay;
        }

        public final TaskSnapshot copy(String taskId, String targetPackageName, SessionState state, String topPackageOnDisplay) {
            kotlin.jvm.internal.k.f(taskId, "taskId");
            kotlin.jvm.internal.k.f(state, "state");
            return new TaskSnapshot(taskId, targetPackageName, state, topPackageOnDisplay);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskSnapshot)) {
                return false;
            }
            TaskSnapshot taskSnapshot = (TaskSnapshot) other;
            return kotlin.jvm.internal.k.b(this.taskId, taskSnapshot.taskId) && kotlin.jvm.internal.k.b(this.targetPackageName, taskSnapshot.targetPackageName) && this.state == taskSnapshot.state && kotlin.jvm.internal.k.b(this.topPackageOnDisplay, taskSnapshot.topPackageOnDisplay);
        }

        public final SessionState getState() {
            return this.state;
        }

        public final String getTargetPackageName() {
            return this.targetPackageName;
        }

        public final String getTaskId() {
            return this.taskId;
        }

        public final String getTopPackageOnDisplay() {
            return this.topPackageOnDisplay;
        }

        public int hashCode() {
            int iHashCode = this.taskId.hashCode() * 31;
            String str = this.targetPackageName;
            int iHashCode2 = (this.state.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31;
            String str2 = this.topPackageOnDisplay;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            String str = this.taskId;
            String str2 = this.targetPackageName;
            SessionState sessionState = this.state;
            String str3 = this.topPackageOnDisplay;
            StringBuilder sbW = B7.a.w("TaskSnapshot(taskId=", str, ", targetPackageName=", str2, ", state=");
            sbW.append(sessionState);
            sbW.append(", topPackageOnDisplay=");
            sbW.append(str3);
            sbW.append(")");
            return sbW.toString();
        }
    }

    private RedirectTaskMatcher() {
    }

    public final String findTaskId(List<TaskSnapshot> snapshots, String packageName) {
        Object next;
        Object next2;
        kotlin.jvm.internal.k.f(snapshots, "snapshots");
        kotlin.jvm.internal.k.f(packageName, "packageName");
        ArrayList arrayList = new ArrayList();
        for (Object obj : snapshots) {
            if (!((TaskSnapshot) obj).getState().a()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.k.b(((TaskSnapshot) next).getTopPackageOnDisplay(), packageName)) {
                break;
            }
        }
        TaskSnapshot taskSnapshot = (TaskSnapshot) next;
        if (taskSnapshot != null) {
            return taskSnapshot.getTaskId();
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (kotlin.jvm.internal.k.b(((TaskSnapshot) next2).getTargetPackageName(), packageName)) {
                break;
            }
        }
        TaskSnapshot taskSnapshot2 = (TaskSnapshot) next2;
        if (taskSnapshot2 != null) {
            return taskSnapshot2.getTaskId();
        }
        return null;
    }
}
