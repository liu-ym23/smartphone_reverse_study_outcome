package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jp\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/stepos/agentbus/generated/CancelResult;", "", "ok", "", "task", "Lcom/stepos/agentbus/generated/Task;", "skippedSubtaskIds", "", "", "killMethod", "killKey", "killOk", "killStatus", "error", "Lcom/stepos/agentbus/generated/ErrorShape;", AppAgent.CONSTRUCT, "(ZLcom/stepos/agentbus/generated/Task;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/stepos/agentbus/generated/ErrorShape;)V", "getOk", "()Z", "getTask", "()Lcom/stepos/agentbus/generated/Task;", "getSkippedSubtaskIds", "()Ljava/util/List;", "getKillMethod", "()Ljava/lang/String;", "getKillKey", "getKillOk", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKillStatus", "getError", "()Lcom/stepos/agentbus/generated/ErrorShape;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLcom/stepos/agentbus/generated/Task;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/stepos/agentbus/generated/ErrorShape;)Lcom/stepos/agentbus/generated/CancelResult;", "equals", "other", "hashCode", "", "toString", "Companion", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CancelResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorShape error;
    private final String killKey;
    private final String killMethod;
    private final Boolean killOk;
    private final String killStatus;
    private final boolean ok;
    private final List<String> skippedSubtaskIds;
    private final Task task;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/stepos/agentbus/generated/CancelResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "error", "Lcom/stepos/agentbus/generated/CancelResult;", "code", "", "message", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final CancelResult error(String code, String message) {
            k.f(code, "code");
            k.f(message, "message");
            return new CancelResult(false, null, EmptyList.f4893a, null, null, null, null, new ErrorShape(code, message));
        }

        private Companion() {
        }
    }

    public CancelResult(boolean z10, Task task, List list, String str, String str2, Boolean bool, String str3, ErrorShape errorShape, int i, e eVar) {
        this(z10, (i & 2) != 0 ? null : task, (i & 4) != 0 ? EmptyList.f4893a : list, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : errorShape);
    }

    public static /* synthetic */ CancelResult copy$default(CancelResult cancelResult, boolean z10, Task task, List list, String str, String str2, Boolean bool, String str3, ErrorShape errorShape, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = cancelResult.ok;
        }
        if ((i & 2) != 0) {
            task = cancelResult.task;
        }
        if ((i & 4) != 0) {
            list = cancelResult.skippedSubtaskIds;
        }
        if ((i & 8) != 0) {
            str = cancelResult.killMethod;
        }
        if ((i & 16) != 0) {
            str2 = cancelResult.killKey;
        }
        if ((i & 32) != 0) {
            bool = cancelResult.killOk;
        }
        if ((i & 64) != 0) {
            str3 = cancelResult.killStatus;
        }
        if ((i & 128) != 0) {
            errorShape = cancelResult.error;
        }
        String str4 = str3;
        ErrorShape errorShape2 = errorShape;
        String str5 = str2;
        Boolean bool2 = bool;
        return cancelResult.copy(z10, task, list, str, str5, bool2, str4, errorShape2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final Task getTask() {
        return this.task;
    }

    public final List<String> component3() {
        return this.skippedSubtaskIds;
    }

    /* renamed from: component4, reason: from getter */
    public final String getKillMethod() {
        return this.killMethod;
    }

    /* renamed from: component5, reason: from getter */
    public final String getKillKey() {
        return this.killKey;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getKillOk() {
        return this.killOk;
    }

    /* renamed from: component7, reason: from getter */
    public final String getKillStatus() {
        return this.killStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final CancelResult copy(boolean ok, Task task, List<String> skippedSubtaskIds, String killMethod, String killKey, Boolean killOk, String killStatus, ErrorShape error) {
        k.f(skippedSubtaskIds, "skippedSubtaskIds");
        return new CancelResult(ok, task, skippedSubtaskIds, killMethod, killKey, killOk, killStatus, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CancelResult)) {
            return false;
        }
        CancelResult cancelResult = (CancelResult) other;
        return this.ok == cancelResult.ok && k.b(this.task, cancelResult.task) && k.b(this.skippedSubtaskIds, cancelResult.skippedSubtaskIds) && k.b(this.killMethod, cancelResult.killMethod) && k.b(this.killKey, cancelResult.killKey) && k.b(this.killOk, cancelResult.killOk) && k.b(this.killStatus, cancelResult.killStatus) && k.b(this.error, cancelResult.error);
    }

    public final ErrorShape getError() {
        return this.error;
    }

    public final String getKillKey() {
        return this.killKey;
    }

    public final String getKillMethod() {
        return this.killMethod;
    }

    public final Boolean getKillOk() {
        return this.killOk;
    }

    public final String getKillStatus() {
        return this.killStatus;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final List<String> getSkippedSubtaskIds() {
        return this.skippedSubtaskIds;
    }

    public final Task getTask() {
        return this.task;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        Task task = this.task;
        int iE = androidx.appfunctions.metadata.a.e(this.skippedSubtaskIds, (iHashCode + (task == null ? 0 : task.hashCode())) * 31, 31);
        String str = this.killMethod;
        int iHashCode2 = (iE + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.killKey;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.killOk;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.killStatus;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode5 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "CancelResult(ok=" + this.ok + ", task=" + this.task + ", skippedSubtaskIds=" + this.skippedSubtaskIds + ", killMethod=" + this.killMethod + ", killKey=" + this.killKey + ", killOk=" + this.killOk + ", killStatus=" + this.killStatus + ", error=" + this.error + ")";
    }

    public CancelResult(boolean z10, Task task, List<String> skippedSubtaskIds, String str, String str2, Boolean bool, String str3, ErrorShape errorShape) {
        k.f(skippedSubtaskIds, "skippedSubtaskIds");
        this.ok = z10;
        this.task = task;
        this.skippedSubtaskIds = skippedSubtaskIds;
        this.killMethod = str;
        this.killKey = str2;
        this.killOk = bool;
        this.killStatus = str3;
        this.error = errorShape;
    }
}
