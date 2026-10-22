package stepai.aios.guiexecutor.core;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiExecutorStatus;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lstepai/aios/guiexecutor/core/ExecutionStats;", "", "totalExecutions", "", "activeCommands", "status", "Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", AppAgent.CONSTRUCT, "(IILstepai/aios/guiexecutor/api/GuiExecutorStatus;)V", "getTotalExecutions", "()I", "getActiveCommands", "getStatus", "()Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ExecutionStats {
    private final int activeCommands;
    private final GuiExecutorStatus status;
    private final int totalExecutions;

    public ExecutionStats(int i, int i6, GuiExecutorStatus status) {
        k.f(status, "status");
        this.totalExecutions = i;
        this.activeCommands = i6;
        this.status = status;
    }

    public static /* synthetic */ ExecutionStats copy$default(ExecutionStats executionStats, int i, int i6, GuiExecutorStatus guiExecutorStatus, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = executionStats.totalExecutions;
        }
        if ((i10 & 2) != 0) {
            i6 = executionStats.activeCommands;
        }
        if ((i10 & 4) != 0) {
            guiExecutorStatus = executionStats.status;
        }
        return executionStats.copy(i, i6, guiExecutorStatus);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTotalExecutions() {
        return this.totalExecutions;
    }

    /* renamed from: component2, reason: from getter */
    public final int getActiveCommands() {
        return this.activeCommands;
    }

    /* renamed from: component3, reason: from getter */
    public final GuiExecutorStatus getStatus() {
        return this.status;
    }

    public final ExecutionStats copy(int totalExecutions, int activeCommands, GuiExecutorStatus status) {
        k.f(status, "status");
        return new ExecutionStats(totalExecutions, activeCommands, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExecutionStats)) {
            return false;
        }
        ExecutionStats executionStats = (ExecutionStats) other;
        return this.totalExecutions == executionStats.totalExecutions && this.activeCommands == executionStats.activeCommands && this.status == executionStats.status;
    }

    public final int getActiveCommands() {
        return this.activeCommands;
    }

    public final GuiExecutorStatus getStatus() {
        return this.status;
    }

    public final int getTotalExecutions() {
        return this.totalExecutions;
    }

    public int hashCode() {
        return this.status.hashCode() + a.a(this.activeCommands, Integer.hashCode(this.totalExecutions) * 31, 31);
    }

    public String toString() {
        int i = this.totalExecutions;
        int i6 = this.activeCommands;
        GuiExecutorStatus guiExecutorStatus = this.status;
        StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "ExecutionStats(totalExecutions=", i6, ", activeCommands=", ", status=");
        sbS.append(guiExecutorStatus);
        sbS.append(")");
        return sbS.toString();
    }
}
