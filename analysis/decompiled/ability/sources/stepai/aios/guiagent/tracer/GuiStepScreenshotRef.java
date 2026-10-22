package stepai.aios.guiagent.tracer;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiStepScreenshotRef;", "", "sessionId", "", "stepId", "fileName", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getStepId", "getFileName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiStepScreenshotRef {
    private final String fileName;
    private final String sessionId;
    private final String stepId;

    public GuiStepScreenshotRef(String sessionId, String stepId, String fileName) {
        k.f(sessionId, "sessionId");
        k.f(stepId, "stepId");
        k.f(fileName, "fileName");
        this.sessionId = sessionId;
        this.stepId = stepId;
        this.fileName = fileName;
    }

    public static /* synthetic */ GuiStepScreenshotRef copy$default(GuiStepScreenshotRef guiStepScreenshotRef, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiStepScreenshotRef.sessionId;
        }
        if ((i & 2) != 0) {
            str2 = guiStepScreenshotRef.stepId;
        }
        if ((i & 4) != 0) {
            str3 = guiStepScreenshotRef.fileName;
        }
        return guiStepScreenshotRef.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStepId() {
        return this.stepId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final GuiStepScreenshotRef copy(String sessionId, String stepId, String fileName) {
        k.f(sessionId, "sessionId");
        k.f(stepId, "stepId");
        k.f(fileName, "fileName");
        return new GuiStepScreenshotRef(sessionId, stepId, fileName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiStepScreenshotRef)) {
            return false;
        }
        GuiStepScreenshotRef guiStepScreenshotRef = (GuiStepScreenshotRef) other;
        return k.b(this.sessionId, guiStepScreenshotRef.sessionId) && k.b(this.stepId, guiStepScreenshotRef.stepId) && k.b(this.fileName, guiStepScreenshotRef.fileName);
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public int hashCode() {
        return this.fileName.hashCode() + a.c(this.sessionId.hashCode() * 31, 31, this.stepId);
    }

    public String toString() {
        String str = this.sessionId;
        String str2 = this.stepId;
        return a.q(a.w("GuiStepScreenshotRef(sessionId=", str, ", stepId=", str2, ", fileName="), this.fileName, ")");
    }
}
