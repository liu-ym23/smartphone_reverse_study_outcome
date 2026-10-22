package stepai.aios.guiagent.tracer;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import za.g;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000eJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010\u0010R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0012R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b'\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b(\u0010\u000e¨\u0006)"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;", "", "", "stepId", "Lza/g;", "stepInfo", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "screenshotRef", "", "updatedAt", "llmTraceId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lza/g;Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;JLjava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "()Lza/g;", "component3", "()Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "component4", "()J", "component5", "copy", "(Ljava/lang/String;Lza/g;Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;JLjava/lang/String;)Lstepai/aios/guiagent/tracer/GuiNodeStepTraceSnapshot;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStepId", "Lza/g;", "getStepInfo", "Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "getScreenshotRef", "J", "getUpdatedAt", "getLlmTraceId", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiNodeStepTraceSnapshot {
    private final String llmTraceId;
    private final GuiStepScreenshotRef screenshotRef;
    private final String stepId;
    private final g stepInfo;
    private final long updatedAt;

    public GuiNodeStepTraceSnapshot(String stepId, g stepInfo, GuiStepScreenshotRef guiStepScreenshotRef, long j5, String llmTraceId) {
        k.f(stepId, "stepId");
        k.f(stepInfo, "stepInfo");
        k.f(llmTraceId, "llmTraceId");
        this.stepId = stepId;
        this.stepInfo = stepInfo;
        this.screenshotRef = guiStepScreenshotRef;
        this.updatedAt = j5;
        this.llmTraceId = llmTraceId;
    }

    public static /* synthetic */ GuiNodeStepTraceSnapshot copy$default(GuiNodeStepTraceSnapshot guiNodeStepTraceSnapshot, String str, g gVar, GuiStepScreenshotRef guiStepScreenshotRef, long j5, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiNodeStepTraceSnapshot.stepId;
        }
        if ((i & 2) != 0) {
            gVar = guiNodeStepTraceSnapshot.stepInfo;
        }
        if ((i & 4) != 0) {
            guiStepScreenshotRef = guiNodeStepTraceSnapshot.screenshotRef;
        }
        if ((i & 8) != 0) {
            j5 = guiNodeStepTraceSnapshot.updatedAt;
        }
        if ((i & 16) != 0) {
            str2 = guiNodeStepTraceSnapshot.llmTraceId;
        }
        String str3 = str2;
        GuiStepScreenshotRef guiStepScreenshotRef2 = guiStepScreenshotRef;
        return guiNodeStepTraceSnapshot.copy(str, gVar, guiStepScreenshotRef2, j5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStepId() {
        return this.stepId;
    }

    /* renamed from: component2, reason: from getter */
    public final g getStepInfo() {
        return this.stepInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final GuiStepScreenshotRef getScreenshotRef() {
        return this.screenshotRef;
    }

    /* renamed from: component4, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLlmTraceId() {
        return this.llmTraceId;
    }

    public final GuiNodeStepTraceSnapshot copy(String stepId, g stepInfo, GuiStepScreenshotRef screenshotRef, long updatedAt, String llmTraceId) {
        k.f(stepId, "stepId");
        k.f(stepInfo, "stepInfo");
        k.f(llmTraceId, "llmTraceId");
        return new GuiNodeStepTraceSnapshot(stepId, stepInfo, screenshotRef, updatedAt, llmTraceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiNodeStepTraceSnapshot)) {
            return false;
        }
        GuiNodeStepTraceSnapshot guiNodeStepTraceSnapshot = (GuiNodeStepTraceSnapshot) other;
        return k.b(this.stepId, guiNodeStepTraceSnapshot.stepId) && k.b(this.stepInfo, guiNodeStepTraceSnapshot.stepInfo) && k.b(this.screenshotRef, guiNodeStepTraceSnapshot.screenshotRef) && this.updatedAt == guiNodeStepTraceSnapshot.updatedAt && k.b(this.llmTraceId, guiNodeStepTraceSnapshot.llmTraceId);
    }

    public final String getLlmTraceId() {
        return this.llmTraceId;
    }

    public final GuiStepScreenshotRef getScreenshotRef() {
        return this.screenshotRef;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public final g getStepInfo() {
        return this.stepInfo;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = (this.stepInfo.hashCode() + (this.stepId.hashCode() * 31)) * 31;
        GuiStepScreenshotRef guiStepScreenshotRef = this.screenshotRef;
        return this.llmTraceId.hashCode() + a.c((iHashCode + (guiStepScreenshotRef == null ? 0 : guiStepScreenshotRef.hashCode())) * 31, 31, this.updatedAt);
    }

    public String toString() {
        String str = this.stepId;
        g gVar = this.stepInfo;
        GuiStepScreenshotRef guiStepScreenshotRef = this.screenshotRef;
        long j5 = this.updatedAt;
        String str2 = this.llmTraceId;
        StringBuilder sb = new StringBuilder("GuiNodeStepTraceSnapshot(stepId=");
        sb.append(str);
        sb.append(", stepInfo=");
        sb.append(gVar);
        sb.append(", screenshotRef=");
        sb.append(guiStepScreenshotRef);
        sb.append(", updatedAt=");
        sb.append(j5);
        return androidx.constraintlayout.core.dsl.a.j(sb, ", llmTraceId=", str2, ")");
    }
}
