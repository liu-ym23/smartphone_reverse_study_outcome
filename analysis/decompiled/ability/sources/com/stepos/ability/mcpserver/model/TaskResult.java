package com.stepos.ability.mcpserver.model;

import androidx.constraintlayout.core.dsl.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/stepos/ability/mcpserver/model/TaskResult;", "", "success", "", "result", "errorCode", "", "errorMsg", "", AppAgent.CONSTRUCT, "(ZLjava/lang/Object;ILjava/lang/String;)V", "getSuccess", "()Z", "getResult", "()Ljava/lang/Object;", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int errorCode;
    private final String errorMsg;
    private final Object result;
    private final boolean success;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"Lcom/stepos/ability/mcpserver/model/TaskResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "ok", "Lcom/stepos/ability/mcpserver/model/TaskResult;", "result", "error", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "denied", "toolName", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final TaskResult denied(String toolName) {
            k.f(toolName, "toolName");
            return new TaskResult(false, null, 403, "Permission denied: ".concat(toolName), 2, null);
        }

        public final TaskResult error(int code, String msg) {
            return new TaskResult(false, null, code, msg, 2, null);
        }

        public final TaskResult ok(Object result) {
            return new TaskResult(true, result, 0, null, 12, null);
        }

        private Companion() {
        }
    }

    public TaskResult(boolean z10, Object obj, int i, String str) {
        this.success = z10;
        this.result = obj;
        this.errorCode = i;
        this.errorMsg = str;
    }

    public static /* synthetic */ TaskResult copy$default(TaskResult taskResult, boolean z10, Object obj, int i, String str, int i6, Object obj2) {
        if ((i6 & 1) != 0) {
            z10 = taskResult.success;
        }
        if ((i6 & 2) != 0) {
            obj = taskResult.result;
        }
        if ((i6 & 4) != 0) {
            i = taskResult.errorCode;
        }
        if ((i6 & 8) != 0) {
            str = taskResult.errorMsg;
        }
        return taskResult.copy(z10, obj, i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getResult() {
        return this.result;
    }

    /* renamed from: component3, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final TaskResult copy(boolean success, Object result, int errorCode, String errorMsg) {
        return new TaskResult(success, result, errorCode, errorMsg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResult)) {
            return false;
        }
        TaskResult taskResult = (TaskResult) other;
        return this.success == taskResult.success && k.b(this.result, taskResult.result) && this.errorCode == taskResult.errorCode && k.b(this.errorMsg, taskResult.errorMsg);
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Object getResult() {
        return this.result;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        Object obj = this.result;
        int iA = a.a(this.errorCode, (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31, 31);
        String str = this.errorMsg;
        return iA + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TaskResult(success=" + this.success + ", result=" + this.result + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
    }

    public /* synthetic */ TaskResult(boolean z10, Object obj, int i, String str, int i6, e eVar) {
        this(z10, (i6 & 2) != 0 ? null : obj, (i6 & 4) != 0 ? 0 : i, (i6 & 8) != 0 ? null : str);
    }
}
