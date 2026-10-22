package stepai.aios.guiagent.tracer.remote;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J~\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\tHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00067"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;", "", "treeId", "", "title", "createdAt", "", "updatedAt", "totalNodes", "", "nodeCount", FlowType.COMPLETED, "", "success", "failureReason", "nodes", "", "Lstepai/aios/guiagent/tracer/remote/GuiTraceRecord;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;IZLjava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)V", "getTreeId", "()Ljava/lang/String;", "getTitle", "getCreatedAt", "()J", "getUpdatedAt", "getTotalNodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodeCount", "()I", "getCompleted", "()Z", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailureReason", "getNodes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;IZLjava/lang/Boolean;Ljava/lang/String;Ljava/util/List;)Lstepai/aios/guiagent/tracer/remote/GuiTraceTreeRecord;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTraceTreeRecord {
    private final boolean completed;
    private final long createdAt;
    private final String failureReason;
    private final int nodeCount;
    private final List<GuiTraceRecord> nodes;
    private final Boolean success;
    private final String title;
    private final Integer totalNodes;
    private final String treeId;
    private final long updatedAt;

    public GuiTraceTreeRecord(String treeId, String title, long j5, long j6, Integer num, int i, boolean z10, Boolean bool, String str, List<GuiTraceRecord> nodes) {
        k.f(treeId, "treeId");
        k.f(title, "title");
        k.f(nodes, "nodes");
        this.treeId = treeId;
        this.title = title;
        this.createdAt = j5;
        this.updatedAt = j6;
        this.totalNodes = num;
        this.nodeCount = i;
        this.completed = z10;
        this.success = bool;
        this.failureReason = str;
        this.nodes = nodes;
    }

    public static /* synthetic */ GuiTraceTreeRecord copy$default(GuiTraceTreeRecord guiTraceTreeRecord, String str, String str2, long j5, long j6, Integer num, int i, boolean z10, Boolean bool, String str3, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = guiTraceTreeRecord.treeId;
        }
        if ((i6 & 2) != 0) {
            str2 = guiTraceTreeRecord.title;
        }
        if ((i6 & 4) != 0) {
            j5 = guiTraceTreeRecord.createdAt;
        }
        if ((i6 & 8) != 0) {
            j6 = guiTraceTreeRecord.updatedAt;
        }
        if ((i6 & 16) != 0) {
            num = guiTraceTreeRecord.totalNodes;
        }
        if ((i6 & 32) != 0) {
            i = guiTraceTreeRecord.nodeCount;
        }
        if ((i6 & 64) != 0) {
            z10 = guiTraceTreeRecord.completed;
        }
        if ((i6 & 128) != 0) {
            bool = guiTraceTreeRecord.success;
        }
        if ((i6 & 256) != 0) {
            str3 = guiTraceTreeRecord.failureReason;
        }
        if ((i6 & 512) != 0) {
            list = guiTraceTreeRecord.nodes;
        }
        String str4 = str3;
        List list2 = list;
        long j10 = j6;
        long j11 = j5;
        return guiTraceTreeRecord.copy(str, str2, j11, j10, num, i, z10, bool, str4, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTreeId() {
        return this.treeId;
    }

    public final List<GuiTraceRecord> component10() {
        return this.nodes;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    /* renamed from: component6, reason: from getter */
    public final int getNodeCount() {
        return this.nodeCount;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCompleted() {
        return this.completed;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    public final GuiTraceTreeRecord copy(String treeId, String title, long createdAt, long updatedAt, Integer totalNodes, int nodeCount, boolean completed, Boolean success, String failureReason, List<GuiTraceRecord> nodes) {
        k.f(treeId, "treeId");
        k.f(title, "title");
        k.f(nodes, "nodes");
        return new GuiTraceTreeRecord(treeId, title, createdAt, updatedAt, totalNodes, nodeCount, completed, success, failureReason, nodes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTraceTreeRecord)) {
            return false;
        }
        GuiTraceTreeRecord guiTraceTreeRecord = (GuiTraceTreeRecord) other;
        return k.b(this.treeId, guiTraceTreeRecord.treeId) && k.b(this.title, guiTraceTreeRecord.title) && this.createdAt == guiTraceTreeRecord.createdAt && this.updatedAt == guiTraceTreeRecord.updatedAt && k.b(this.totalNodes, guiTraceTreeRecord.totalNodes) && this.nodeCount == guiTraceTreeRecord.nodeCount && this.completed == guiTraceTreeRecord.completed && k.b(this.success, guiTraceTreeRecord.success) && k.b(this.failureReason, guiTraceTreeRecord.failureReason) && k.b(this.nodes, guiTraceTreeRecord.nodes);
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

    public final int getNodeCount() {
        return this.nodeCount;
    }

    public final List<GuiTraceRecord> getNodes() {
        return this.nodes;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getTitle() {
        return this.title;
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
        int iC = a.c(a.c(B7.a.c(this.treeId.hashCode() * 31, 31, this.title), 31, this.createdAt), 31, this.updatedAt);
        Integer num = this.totalNodes;
        int iD = a.d(androidx.constraintlayout.core.dsl.a.a(this.nodeCount, (iC + (num == null ? 0 : num.hashCode())) * 31, 31), 31, this.completed);
        Boolean bool = this.success;
        int iHashCode = (iD + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.failureReason;
        return this.nodes.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.treeId;
        String str2 = this.title;
        long j5 = this.createdAt;
        long j6 = this.updatedAt;
        Integer num = this.totalNodes;
        int i = this.nodeCount;
        boolean z10 = this.completed;
        Boolean bool = this.success;
        String str3 = this.failureReason;
        List<GuiTraceRecord> list = this.nodes;
        StringBuilder sbW = B7.a.w("GuiTraceTreeRecord(treeId=", str, ", title=", str2, ", createdAt=");
        sbW.append(j5);
        b.y(j6, ", updatedAt=", ", totalNodes=", sbW);
        sbW.append(num);
        sbW.append(", nodeCount=");
        sbW.append(i);
        sbW.append(", completed=");
        sbW.append(z10);
        sbW.append(", success=");
        sbW.append(bool);
        sbW.append(", failureReason=");
        sbW.append(str3);
        sbW.append(", nodes=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }
}
