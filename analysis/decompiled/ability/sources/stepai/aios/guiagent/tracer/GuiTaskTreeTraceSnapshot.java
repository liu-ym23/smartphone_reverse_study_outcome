package stepai.aios.guiagent.tracer;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jj\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0005HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00060"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "", "treeId", "", "totalNodes", "", "nodeTraces", "", "Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "createdAt", "", "updatedAt", FlowType.COMPLETED, "", "success", "failureReason", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;JJZLjava/lang/Boolean;Ljava/lang/String;)V", "getTreeId", "()Ljava/lang/String;", "getTotalNodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodeTraces", "()Ljava/util/List;", "getCreatedAt", "()J", "getUpdatedAt", "getCompleted", "()Z", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailureReason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;JJZLjava/lang/Boolean;Ljava/lang/String;)Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTaskTreeTraceSnapshot {
    private final boolean completed;
    private final long createdAt;
    private final String failureReason;
    private final List<GuiTaskNodeTraceSnapshot> nodeTraces;
    private final Boolean success;
    private final Integer totalNodes;
    private final String treeId;
    private final long updatedAt;

    public GuiTaskTreeTraceSnapshot(String treeId, Integer num, List<GuiTaskNodeTraceSnapshot> nodeTraces, long j5, long j6, boolean z10, Boolean bool, String str) {
        k.f(treeId, "treeId");
        k.f(nodeTraces, "nodeTraces");
        this.treeId = treeId;
        this.totalNodes = num;
        this.nodeTraces = nodeTraces;
        this.createdAt = j5;
        this.updatedAt = j6;
        this.completed = z10;
        this.success = bool;
        this.failureReason = str;
    }

    public static /* synthetic */ GuiTaskTreeTraceSnapshot copy$default(GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot, String str, Integer num, List list, long j5, long j6, boolean z10, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiTaskTreeTraceSnapshot.treeId;
        }
        if ((i & 2) != 0) {
            num = guiTaskTreeTraceSnapshot.totalNodes;
        }
        if ((i & 4) != 0) {
            list = guiTaskTreeTraceSnapshot.nodeTraces;
        }
        if ((i & 8) != 0) {
            j5 = guiTaskTreeTraceSnapshot.createdAt;
        }
        if ((i & 16) != 0) {
            j6 = guiTaskTreeTraceSnapshot.updatedAt;
        }
        if ((i & 32) != 0) {
            z10 = guiTaskTreeTraceSnapshot.completed;
        }
        if ((i & 64) != 0) {
            bool = guiTaskTreeTraceSnapshot.success;
        }
        if ((i & 128) != 0) {
            str2 = guiTaskTreeTraceSnapshot.failureReason;
        }
        String str3 = str2;
        boolean z11 = z10;
        long j10 = j6;
        long j11 = j5;
        List list2 = list;
        return guiTaskTreeTraceSnapshot.copy(str, num, list2, j11, j10, z11, bool, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTreeId() {
        return this.treeId;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    public final List<GuiTaskNodeTraceSnapshot> component3() {
        return this.nodeTraces;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component8, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    public final GuiTaskTreeTraceSnapshot copy(String treeId, Integer totalNodes, List<GuiTaskNodeTraceSnapshot> nodeTraces, long createdAt, long updatedAt, boolean completed, Boolean success, String failureReason) {
        k.f(treeId, "treeId");
        k.f(nodeTraces, "nodeTraces");
        return new GuiTaskTreeTraceSnapshot(treeId, totalNodes, nodeTraces, createdAt, updatedAt, completed, success, failureReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskTreeTraceSnapshot)) {
            return false;
        }
        GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot = (GuiTaskTreeTraceSnapshot) other;
        return k.b(this.treeId, guiTaskTreeTraceSnapshot.treeId) && k.b(this.totalNodes, guiTaskTreeTraceSnapshot.totalNodes) && k.b(this.nodeTraces, guiTaskTreeTraceSnapshot.nodeTraces) && this.createdAt == guiTaskTreeTraceSnapshot.createdAt && this.updatedAt == guiTaskTreeTraceSnapshot.updatedAt && this.completed == guiTaskTreeTraceSnapshot.completed && k.b(this.success, guiTaskTreeTraceSnapshot.success) && k.b(this.failureReason, guiTaskTreeTraceSnapshot.failureReason);
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final List<GuiTaskNodeTraceSnapshot> getNodeTraces() {
        return this.nodeTraces;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    public final String getTreeId() {
        return this.treeId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = this.treeId.hashCode() * 31;
        Integer num = this.totalNodes;
        int iD = a.d(a.c(a.c(a.e(this.nodeTraces, (iHashCode + (num == null ? 0 : num.hashCode())) * 31, 31), 31, this.createdAt), 31, this.updatedAt), 31, this.completed);
        Boolean bool = this.success;
        int iHashCode2 = (iD + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.failureReason;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        String str = this.treeId;
        Integer num = this.totalNodes;
        List<GuiTaskNodeTraceSnapshot> list = this.nodeTraces;
        long j5 = this.createdAt;
        long j6 = this.updatedAt;
        boolean z10 = this.completed;
        Boolean bool = this.success;
        String str2 = this.failureReason;
        StringBuilder sb = new StringBuilder("GuiTaskTreeTraceSnapshot(treeId=");
        sb.append(str);
        sb.append(", totalNodes=");
        sb.append(num);
        sb.append(", nodeTraces=");
        sb.append(list);
        sb.append(", createdAt=");
        sb.append(j5);
        b.y(j6, ", updatedAt=", ", completed=", sb);
        sb.append(z10);
        sb.append(", success=");
        sb.append(bool);
        sb.append(", failureReason=");
        return B7.a.q(sb, str2, ")");
    }
}
