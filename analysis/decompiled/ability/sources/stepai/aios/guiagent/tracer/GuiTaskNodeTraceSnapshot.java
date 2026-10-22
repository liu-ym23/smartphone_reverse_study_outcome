package stepai.aios.guiagent.tracer;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import za.d;
import za.i;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0015J\u0012\u0010!\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b!\u0010\"Jx\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0015J\u0010\u0010'\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010/\u001a\u0004\b0\u0010\u0017R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u00101\u001a\u0004\b2\u0010\u0019R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b5\u0010\u001bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00106\u001a\u0004\b7\u0010\u001eR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b8\u0010\u0015R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b9\u0010\u0015R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010:\u001a\u0004\b;\u0010\"¨\u0006<"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "", "", "sessionId", "Lza/i;", "taskInfo", "", "Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;", "steps", "", "createdAt", "updatedAt", "Lza/d;", "lastResult", "lastErrorMessage", "externalTraceId", "Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "nodeMetadata", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lza/i;Ljava/util/List;JJLza/d;Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;)V", "component1", "()Ljava/lang/String;", "component2", "()Lza/i;", "component3", "()Ljava/util/List;", "component4", "()J", "component5", "component6", "()Lza/d;", "component7", "component8", "component9", "()Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "copy", "(Ljava/lang/String;Lza/i;Ljava/util/List;JJLza/d;Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;)Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Lza/i;", "getTaskInfo", "Ljava/util/List;", "getSteps", "J", "getCreatedAt", "getUpdatedAt", "Lza/d;", "getLastResult", "getLastErrorMessage", "getExternalTraceId", "Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "getNodeMetadata", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTaskNodeTraceSnapshot {
    private final long createdAt;
    private final String externalTraceId;
    private final String lastErrorMessage;
    private final d lastResult;
    private final GuiTaskNodeMetadata nodeMetadata;
    private final String sessionId;
    private final List<GuiNodeStepTraceSnapshot> steps;
    private final i taskInfo;
    private final long updatedAt;

    public GuiTaskNodeTraceSnapshot(String sessionId, i taskInfo, List<GuiNodeStepTraceSnapshot> steps, long j5, long j6, d dVar, String str, String str2, GuiTaskNodeMetadata guiTaskNodeMetadata) {
        k.f(sessionId, "sessionId");
        k.f(taskInfo, "taskInfo");
        k.f(steps, "steps");
        this.sessionId = sessionId;
        this.taskInfo = taskInfo;
        this.steps = steps;
        this.createdAt = j5;
        this.updatedAt = j6;
        this.lastResult = dVar;
        this.lastErrorMessage = str;
        this.externalTraceId = str2;
        this.nodeMetadata = guiTaskNodeMetadata;
    }

    public static /* synthetic */ GuiTaskNodeTraceSnapshot copy$default(GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshot, String str, i iVar, List list, long j5, long j6, d dVar, String str2, String str3, GuiTaskNodeMetadata guiTaskNodeMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiTaskNodeTraceSnapshot.sessionId;
        }
        if ((i & 2) != 0) {
            iVar = guiTaskNodeTraceSnapshot.taskInfo;
        }
        if ((i & 4) != 0) {
            list = guiTaskNodeTraceSnapshot.steps;
        }
        if ((i & 8) != 0) {
            j5 = guiTaskNodeTraceSnapshot.createdAt;
        }
        if ((i & 16) != 0) {
            j6 = guiTaskNodeTraceSnapshot.updatedAt;
        }
        if ((i & 32) != 0) {
            dVar = guiTaskNodeTraceSnapshot.lastResult;
        }
        if ((i & 64) != 0) {
            str2 = guiTaskNodeTraceSnapshot.lastErrorMessage;
        }
        if ((i & 128) != 0) {
            str3 = guiTaskNodeTraceSnapshot.externalTraceId;
        }
        if ((i & 256) != 0) {
            guiTaskNodeMetadata = guiTaskNodeTraceSnapshot.nodeMetadata;
        }
        long j10 = j6;
        long j11 = j5;
        List list2 = list;
        return guiTaskNodeTraceSnapshot.copy(str, iVar, list2, j11, j10, dVar, str2, str3, guiTaskNodeMetadata);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final i getTaskInfo() {
        return this.taskInfo;
    }

    public final List<GuiNodeStepTraceSnapshot> component3() {
        return this.steps;
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
    public final d getLastResult() {
        return this.lastResult;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

    /* renamed from: component8, reason: from getter */
    public final String getExternalTraceId() {
        return this.externalTraceId;
    }

    /* renamed from: component9, reason: from getter */
    public final GuiTaskNodeMetadata getNodeMetadata() {
        return this.nodeMetadata;
    }

    public final GuiTaskNodeTraceSnapshot copy(String sessionId, i taskInfo, List<GuiNodeStepTraceSnapshot> steps, long createdAt, long updatedAt, d lastResult, String lastErrorMessage, String externalTraceId, GuiTaskNodeMetadata nodeMetadata) {
        k.f(sessionId, "sessionId");
        k.f(taskInfo, "taskInfo");
        k.f(steps, "steps");
        return new GuiTaskNodeTraceSnapshot(sessionId, taskInfo, steps, createdAt, updatedAt, lastResult, lastErrorMessage, externalTraceId, nodeMetadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskNodeTraceSnapshot)) {
            return false;
        }
        GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshot = (GuiTaskNodeTraceSnapshot) other;
        return k.b(this.sessionId, guiTaskNodeTraceSnapshot.sessionId) && k.b(this.taskInfo, guiTaskNodeTraceSnapshot.taskInfo) && k.b(this.steps, guiTaskNodeTraceSnapshot.steps) && this.createdAt == guiTaskNodeTraceSnapshot.createdAt && this.updatedAt == guiTaskNodeTraceSnapshot.updatedAt && k.b(this.lastResult, guiTaskNodeTraceSnapshot.lastResult) && k.b(this.lastErrorMessage, guiTaskNodeTraceSnapshot.lastErrorMessage) && k.b(this.externalTraceId, guiTaskNodeTraceSnapshot.externalTraceId) && k.b(this.nodeMetadata, guiTaskNodeTraceSnapshot.nodeMetadata);
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getExternalTraceId() {
        return this.externalTraceId;
    }

    public final String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

    public final d getLastResult() {
        return this.lastResult;
    }

    public final GuiTaskNodeMetadata getNodeMetadata() {
        return this.nodeMetadata;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<GuiNodeStepTraceSnapshot> getSteps() {
        return this.steps;
    }

    public final i getTaskInfo() {
        return this.taskInfo;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iC = a.c(a.c(a.e(this.steps, (this.taskInfo.hashCode() + (this.sessionId.hashCode() * 31)) * 31, 31), 31, this.createdAt), 31, this.updatedAt);
        d dVar = this.lastResult;
        int iHashCode = (iC + (dVar == null ? 0 : dVar.hashCode())) * 31;
        String str = this.lastErrorMessage;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.externalTraceId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        GuiTaskNodeMetadata guiTaskNodeMetadata = this.nodeMetadata;
        return iHashCode3 + (guiTaskNodeMetadata != null ? guiTaskNodeMetadata.hashCode() : 0);
    }

    public String toString() {
        String str = this.sessionId;
        i iVar = this.taskInfo;
        List<GuiNodeStepTraceSnapshot> list = this.steps;
        long j5 = this.createdAt;
        long j6 = this.updatedAt;
        d dVar = this.lastResult;
        String str2 = this.lastErrorMessage;
        String str3 = this.externalTraceId;
        GuiTaskNodeMetadata guiTaskNodeMetadata = this.nodeMetadata;
        StringBuilder sb = new StringBuilder("GuiTaskNodeTraceSnapshot(sessionId=");
        sb.append(str);
        sb.append(", taskInfo=");
        sb.append(iVar);
        sb.append(", steps=");
        sb.append(list);
        sb.append(", createdAt=");
        sb.append(j5);
        b.y(j6, ", updatedAt=", ", lastResult=", sb);
        sb.append(dVar);
        sb.append(", lastErrorMessage=");
        sb.append(str2);
        sb.append(", externalTraceId=");
        sb.append(str3);
        sb.append(", nodeMetadata=");
        sb.append(guiTaskNodeMetadata);
        sb.append(")");
        return sb.toString();
    }
}
