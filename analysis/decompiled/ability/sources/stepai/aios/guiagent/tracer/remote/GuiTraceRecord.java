package stepai.aios.guiagent.tracer.remote;

import B7.a;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015HÆ\u0003JÌ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020\f2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u0010HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010+\u001a\u0004\b,\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00100¨\u0006H"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/GuiTraceRecord;", "", "sessionId", "", AgentBusWakeContract.EXTRA_TRACE_ID, "taskDescription", "nodeLabel", "state", "createdAt", "", "updatedAt", "lastResultSuccess", "", "lastResultMessage", "lastErrorMessage", "totalNodes", "", "nodeIndex", "slotMapJson", "pathNodeJson", "steps", "", "Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;", "compressionEvents", "Lstepai/aios/guiagent/tracer/remote/GuiTraceCompressionEvent;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getSessionId", "()Ljava/lang/String;", "getTraceId", "getTaskDescription", "getNodeLabel", "getState", "getCreatedAt", "()J", "getUpdatedAt", "getLastResultSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLastResultMessage", "getLastErrorMessage", "getTotalNodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodeIndex", "getSlotMapJson", "getPathNodeJson", "getSteps", "()Ljava/util/List;", "getCompressionEvents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lstepai/aios/guiagent/tracer/remote/GuiTraceRecord;", "equals", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTraceRecord {
    private final List<GuiTraceCompressionEvent> compressionEvents;
    private final long createdAt;
    private final String lastErrorMessage;
    private final String lastResultMessage;
    private final Boolean lastResultSuccess;
    private final Integer nodeIndex;
    private final String nodeLabel;
    private final String pathNodeJson;
    private final String sessionId;
    private final String slotMapJson;
    private final String state;
    private final List<GuiTraceStep> steps;
    private final String taskDescription;
    private final Integer totalNodes;
    private final String traceId;
    private final long updatedAt;

    public GuiTraceRecord(String sessionId, String str, String taskDescription, String str2, String state, long j5, long j6, Boolean bool, String str3, String str4, Integer num, Integer num2, String str5, String str6, List<GuiTraceStep> steps, List<GuiTraceCompressionEvent> compressionEvents) {
        k.f(sessionId, "sessionId");
        k.f(taskDescription, "taskDescription");
        k.f(state, "state");
        k.f(steps, "steps");
        k.f(compressionEvents, "compressionEvents");
        this.sessionId = sessionId;
        this.traceId = str;
        this.taskDescription = taskDescription;
        this.nodeLabel = str2;
        this.state = state;
        this.createdAt = j5;
        this.updatedAt = j6;
        this.lastResultSuccess = bool;
        this.lastResultMessage = str3;
        this.lastErrorMessage = str4;
        this.totalNodes = num;
        this.nodeIndex = num2;
        this.slotMapJson = str5;
        this.pathNodeJson = str6;
        this.steps = steps;
        this.compressionEvents = compressionEvents;
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getNodeIndex() {
        return this.nodeIndex;
    }

    /* renamed from: component13, reason: from getter */
    public final String getSlotMapJson() {
        return this.slotMapJson;
    }

    /* renamed from: component14, reason: from getter */
    public final String getPathNodeJson() {
        return this.pathNodeJson;
    }

    public final List<GuiTraceStep> component15() {
        return this.steps;
    }

    public final List<GuiTraceCompressionEvent> component16() {
        return this.compressionEvents;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTaskDescription() {
        return this.taskDescription;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNodeLabel() {
        return this.nodeLabel;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getLastResultSuccess() {
        return this.lastResultSuccess;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLastResultMessage() {
        return this.lastResultMessage;
    }

    public final GuiTraceRecord copy(String sessionId, String traceId, String taskDescription, String nodeLabel, String state, long createdAt, long updatedAt, Boolean lastResultSuccess, String lastResultMessage, String lastErrorMessage, Integer totalNodes, Integer nodeIndex, String slotMapJson, String pathNodeJson, List<GuiTraceStep> steps, List<GuiTraceCompressionEvent> compressionEvents) {
        k.f(sessionId, "sessionId");
        k.f(taskDescription, "taskDescription");
        k.f(state, "state");
        k.f(steps, "steps");
        k.f(compressionEvents, "compressionEvents");
        return new GuiTraceRecord(sessionId, traceId, taskDescription, nodeLabel, state, createdAt, updatedAt, lastResultSuccess, lastResultMessage, lastErrorMessage, totalNodes, nodeIndex, slotMapJson, pathNodeJson, steps, compressionEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTraceRecord)) {
            return false;
        }
        GuiTraceRecord guiTraceRecord = (GuiTraceRecord) other;
        return k.b(this.sessionId, guiTraceRecord.sessionId) && k.b(this.traceId, guiTraceRecord.traceId) && k.b(this.taskDescription, guiTraceRecord.taskDescription) && k.b(this.nodeLabel, guiTraceRecord.nodeLabel) && k.b(this.state, guiTraceRecord.state) && this.createdAt == guiTraceRecord.createdAt && this.updatedAt == guiTraceRecord.updatedAt && k.b(this.lastResultSuccess, guiTraceRecord.lastResultSuccess) && k.b(this.lastResultMessage, guiTraceRecord.lastResultMessage) && k.b(this.lastErrorMessage, guiTraceRecord.lastErrorMessage) && k.b(this.totalNodes, guiTraceRecord.totalNodes) && k.b(this.nodeIndex, guiTraceRecord.nodeIndex) && k.b(this.slotMapJson, guiTraceRecord.slotMapJson) && k.b(this.pathNodeJson, guiTraceRecord.pathNodeJson) && k.b(this.steps, guiTraceRecord.steps) && k.b(this.compressionEvents, guiTraceRecord.compressionEvents);
    }

    public final List<GuiTraceCompressionEvent> getCompressionEvents() {
        return this.compressionEvents;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getLastErrorMessage() {
        return this.lastErrorMessage;
    }

    public final String getLastResultMessage() {
        return this.lastResultMessage;
    }

    public final Boolean getLastResultSuccess() {
        return this.lastResultSuccess;
    }

    public final Integer getNodeIndex() {
        return this.nodeIndex;
    }

    public final String getNodeLabel() {
        return this.nodeLabel;
    }

    public final String getPathNodeJson() {
        return this.pathNodeJson;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSlotMapJson() {
        return this.slotMapJson;
    }

    public final String getState() {
        return this.state;
    }

    public final List<GuiTraceStep> getSteps() {
        return this.steps;
    }

    public final String getTaskDescription() {
        return this.taskDescription;
    }

    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = this.sessionId.hashCode() * 31;
        String str = this.traceId;
        int iC = a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.taskDescription);
        String str2 = this.nodeLabel;
        int iC2 = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c(a.c((iC + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.state), 31, this.createdAt), 31, this.updatedAt);
        Boolean bool = this.lastResultSuccess;
        int iHashCode2 = (iC2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.lastResultMessage;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.lastErrorMessage;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.totalNodes;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.nodeIndex;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.slotMapJson;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pathNodeJson;
        return this.compressionEvents.hashCode() + androidx.appfunctions.metadata.a.e(this.steps, (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.traceId;
        String str3 = this.taskDescription;
        String str4 = this.nodeLabel;
        String str5 = this.state;
        long j5 = this.createdAt;
        long j6 = this.updatedAt;
        Boolean bool = this.lastResultSuccess;
        String str6 = this.lastResultMessage;
        String str7 = this.lastErrorMessage;
        Integer num = this.totalNodes;
        Integer num2 = this.nodeIndex;
        String str8 = this.slotMapJson;
        String str9 = this.pathNodeJson;
        List<GuiTraceStep> list = this.steps;
        List<GuiTraceCompressionEvent> list2 = this.compressionEvents;
        StringBuilder sbW = a.w("GuiTraceRecord(sessionId=", str, ", traceId=", str2, ", taskDescription=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", nodeLabel=", str4, ", state=");
        a.y(j5, str5, ", createdAt=", sbW);
        b.y(j6, ", updatedAt=", ", lastResultSuccess=", sbW);
        sbW.append(bool);
        sbW.append(", lastResultMessage=");
        sbW.append(str6);
        sbW.append(", lastErrorMessage=");
        sbW.append(str7);
        sbW.append(", totalNodes=");
        sbW.append(num);
        sbW.append(", nodeIndex=");
        sbW.append(num2);
        sbW.append(", slotMapJson=");
        sbW.append(str8);
        sbW.append(", pathNodeJson=");
        sbW.append(str9);
        sbW.append(", steps=");
        sbW.append(list);
        sbW.append(", compressionEvents=");
        return androidx.appfunctions.metadata.a.q(sbW, list2, ")");
    }

    public GuiTraceRecord(String str, String str2, String str3, String str4, String str5, long j5, long j6, Boolean bool, String str6, String str7, Integer num, Integer num2, String str8, String str9, List list, List list2, int i, e eVar) {
        this(str, str2, str3, str4, str5, j5, j6, bool, str6, str7, num, num2, str8, str9, list, (i & 32768) != 0 ? EmptyList.f4893a : list2);
    }
}
