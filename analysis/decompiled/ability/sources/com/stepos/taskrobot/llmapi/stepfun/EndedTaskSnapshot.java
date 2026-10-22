package com.stepos.taskrobot.llmapi.stepfun;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ@\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskSnapshot;", ExifInterface.GPS_DIRECTION_TRUE, "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "message", "callback", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getTaskName", "()Ljava/lang/String;", "getAction", "getMessage", "getCallback", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/stepos/taskrobot/llmapi/stepfun/EndedTaskSnapshot;", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EndedTaskSnapshot<T> {
    private final String action;
    private final T callback;
    private final String message;
    private final String taskName;

    public EndedTaskSnapshot(String taskName, String action, String str, T t9) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(action, "action");
        this.taskName = taskName;
        this.action = action;
        this.message = str;
        this.callback = t9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EndedTaskSnapshot copy$default(EndedTaskSnapshot endedTaskSnapshot, String str, String str2, String str3, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = endedTaskSnapshot.taskName;
        }
        if ((i & 2) != 0) {
            str2 = endedTaskSnapshot.action;
        }
        if ((i & 4) != 0) {
            str3 = endedTaskSnapshot.message;
        }
        if ((i & 8) != 0) {
            obj = endedTaskSnapshot.callback;
        }
        return endedTaskSnapshot.copy(str, str2, str3, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final T component4() {
        return this.callback;
    }

    public final EndedTaskSnapshot<T> copy(String taskName, String action, String message, T callback) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(action, "action");
        return new EndedTaskSnapshot<>(taskName, action, message, callback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EndedTaskSnapshot)) {
            return false;
        }
        EndedTaskSnapshot endedTaskSnapshot = (EndedTaskSnapshot) other;
        return kotlin.jvm.internal.k.b(this.taskName, endedTaskSnapshot.taskName) && kotlin.jvm.internal.k.b(this.action, endedTaskSnapshot.action) && kotlin.jvm.internal.k.b(this.message, endedTaskSnapshot.message) && kotlin.jvm.internal.k.b(this.callback, endedTaskSnapshot.callback);
    }

    public final String getAction() {
        return this.action;
    }

    public final T getCallback() {
        return this.callback;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public int hashCode() {
        int iC = B7.a.c(this.taskName.hashCode() * 31, 31, this.action);
        String str = this.message;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        T t9 = this.callback;
        return iHashCode + (t9 != null ? t9.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskName;
        String str2 = this.action;
        String str3 = this.message;
        T t9 = this.callback;
        StringBuilder sbW = B7.a.w("EndedTaskSnapshot(taskName=", str, ", action=", str2, ", message=");
        sbW.append(str3);
        sbW.append(", callback=");
        sbW.append(t9);
        sbW.append(")");
        return sbW.toString();
    }
}
