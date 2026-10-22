package stepai.aios.guiagent.tracer.remote;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u008f\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014¨\u00066"}, d2 = {"Lstepai/aios/guiagent/tracer/remote/GuiTraceStep;", "", "stepId", "", "stepIndex", "", "actionType", "state", "title", "message", "updatedAt", "", "screenshotFileName", "llmTraceId", "llmExtra", "modelRequestExtra", AgentBusWakeContract.EXTRA_SOURCE, AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getStepId", "()Ljava/lang/String;", "getStepIndex", "()I", "getActionType", "getState", "getTitle", "getMessage", "getUpdatedAt", "()J", "getScreenshotFileName", "getLlmTraceId", "getLlmExtra", "setLlmExtra", "(Ljava/lang/String;)V", "getModelRequestExtra", "getSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTraceStep {
    private final String actionType;
    private String llmExtra;
    private final String llmTraceId;
    private final String message;
    private final String modelRequestExtra;
    private final String screenshotFileName;
    private final String source;
    private final String state;
    private final String stepId;
    private final int stepIndex;
    private final String title;
    private final long updatedAt;

    public GuiTraceStep(String stepId, int i, String str, String state, String title, String str2, long j5, String str3, String str4, String str5, String str6, String str7) {
        k.f(stepId, "stepId");
        k.f(state, "state");
        k.f(title, "title");
        this.stepId = stepId;
        this.stepIndex = i;
        this.actionType = str;
        this.state = state;
        this.title = title;
        this.message = str2;
        this.updatedAt = j5;
        this.screenshotFileName = str3;
        this.llmTraceId = str4;
        this.llmExtra = str5;
        this.modelRequestExtra = str6;
        this.source = str7;
    }

    public static /* synthetic */ GuiTraceStep copy$default(GuiTraceStep guiTraceStep, String str, int i, String str2, String str3, String str4, String str5, long j5, String str6, String str7, String str8, String str9, String str10, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = guiTraceStep.stepId;
        }
        return guiTraceStep.copy(str, (i6 & 2) != 0 ? guiTraceStep.stepIndex : i, (i6 & 4) != 0 ? guiTraceStep.actionType : str2, (i6 & 8) != 0 ? guiTraceStep.state : str3, (i6 & 16) != 0 ? guiTraceStep.title : str4, (i6 & 32) != 0 ? guiTraceStep.message : str5, (i6 & 64) != 0 ? guiTraceStep.updatedAt : j5, (i6 & 128) != 0 ? guiTraceStep.screenshotFileName : str6, (i6 & 256) != 0 ? guiTraceStep.llmTraceId : str7, (i6 & 512) != 0 ? guiTraceStep.llmExtra : str8, (i6 & 1024) != 0 ? guiTraceStep.modelRequestExtra : str9, (i6 & 2048) != 0 ? guiTraceStep.source : str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStepId() {
        return this.stepId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLlmExtra() {
        return this.llmExtra;
    }

    /* renamed from: component11, reason: from getter */
    public final String getModelRequestExtra() {
        return this.modelRequestExtra;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStepIndex() {
        return this.stepIndex;
    }

    /* renamed from: component3, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component8, reason: from getter */
    public final String getScreenshotFileName() {
        return this.screenshotFileName;
    }

    /* renamed from: component9, reason: from getter */
    public final String getLlmTraceId() {
        return this.llmTraceId;
    }

    public final GuiTraceStep copy(String stepId, int stepIndex, String actionType, String state, String title, String message, long updatedAt, String screenshotFileName, String llmTraceId, String llmExtra, String modelRequestExtra, String source) {
        k.f(stepId, "stepId");
        k.f(state, "state");
        k.f(title, "title");
        return new GuiTraceStep(stepId, stepIndex, actionType, state, title, message, updatedAt, screenshotFileName, llmTraceId, llmExtra, modelRequestExtra, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTraceStep)) {
            return false;
        }
        GuiTraceStep guiTraceStep = (GuiTraceStep) other;
        return k.b(this.stepId, guiTraceStep.stepId) && this.stepIndex == guiTraceStep.stepIndex && k.b(this.actionType, guiTraceStep.actionType) && k.b(this.state, guiTraceStep.state) && k.b(this.title, guiTraceStep.title) && k.b(this.message, guiTraceStep.message) && this.updatedAt == guiTraceStep.updatedAt && k.b(this.screenshotFileName, guiTraceStep.screenshotFileName) && k.b(this.llmTraceId, guiTraceStep.llmTraceId) && k.b(this.llmExtra, guiTraceStep.llmExtra) && k.b(this.modelRequestExtra, guiTraceStep.modelRequestExtra) && k.b(this.source, guiTraceStep.source);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getLlmExtra() {
        return this.llmExtra;
    }

    public final String getLlmTraceId() {
        return this.llmTraceId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getModelRequestExtra() {
        return this.modelRequestExtra;
    }

    public final String getScreenshotFileName() {
        return this.screenshotFileName;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public final int getStepIndex() {
        return this.stepIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iA = a.a(this.stepIndex, this.stepId.hashCode() * 31, 31);
        String str = this.actionType;
        int iC = B7.a.c(B7.a.c((iA + (str == null ? 0 : str.hashCode())) * 31, 31, this.state), 31, this.title);
        String str2 = this.message;
        int iC2 = androidx.appfunctions.metadata.a.c((iC + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.updatedAt);
        String str3 = this.screenshotFileName;
        int iHashCode = (iC2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.llmTraceId;
        int iHashCode2 = (iHashCode + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.llmExtra;
        int iHashCode3 = (iHashCode2 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.modelRequestExtra;
        int iHashCode4 = (iHashCode3 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.source;
        return iHashCode4 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setLlmExtra(String str) {
        this.llmExtra = str;
    }

    public String toString() {
        String str = this.stepId;
        int i = this.stepIndex;
        String str2 = this.actionType;
        String str3 = this.state;
        String str4 = this.title;
        String str5 = this.message;
        long j5 = this.updatedAt;
        String str6 = this.screenshotFileName;
        String str7 = this.llmTraceId;
        String str8 = this.llmExtra;
        String str9 = this.modelRequestExtra;
        String str10 = this.source;
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "GuiTraceStep(stepId=", str, ", stepIndex=", ", actionType=");
        a.A(sbT, str2, ", state=", str3, ", title=");
        a.A(sbT, str4, ", message=", str5, ", updatedAt=");
        sbT.append(j5);
        sbT.append(", screenshotFileName=");
        sbT.append(str6);
        a.A(sbT, ", llmTraceId=", str7, ", llmExtra=", str8);
        a.A(sbT, ", modelRequestExtra=", str9, ", source=", str10);
        sbT.append(")");
        return sbT.toString();
    }

    public /* synthetic */ GuiTraceStep(String str, int i, String str2, String str3, String str4, String str5, long j5, String str6, String str7, String str8, String str9, String str10, int i6, e eVar) {
        this(str, i, str2, str3, str4, str5, j5, str6, str7, (i6 & 512) != 0 ? null : str8, (i6 & 1024) != 0 ? null : str9, (i6 & 2048) != 0 ? null : str10);
    }
}
