package stepai.aios.guiagent.tracer;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTraceUpdate;", "", "nodeTrace", "Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "taskTreeTrace", "Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", AppAgent.CONSTRUCT, "(Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;)V", "getNodeTrace", "()Lstepai/aios/guiagent/tracer/GuiTaskNodeTraceSnapshot;", "getTaskTreeTrace", "()Lstepai/aios/guiagent/tracer/GuiTaskTreeTraceSnapshot;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTraceUpdate {
    private final GuiTaskNodeTraceSnapshot nodeTrace;
    private final GuiTaskTreeTraceSnapshot taskTreeTrace;

    public GuiTraceUpdate(GuiTaskNodeTraceSnapshot nodeTrace, GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot) {
        k.f(nodeTrace, "nodeTrace");
        this.nodeTrace = nodeTrace;
        this.taskTreeTrace = guiTaskTreeTraceSnapshot;
    }

    public static /* synthetic */ GuiTraceUpdate copy$default(GuiTraceUpdate guiTraceUpdate, GuiTaskNodeTraceSnapshot guiTaskNodeTraceSnapshot, GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot, int i, Object obj) {
        if ((i & 1) != 0) {
            guiTaskNodeTraceSnapshot = guiTraceUpdate.nodeTrace;
        }
        if ((i & 2) != 0) {
            guiTaskTreeTraceSnapshot = guiTraceUpdate.taskTreeTrace;
        }
        return guiTraceUpdate.copy(guiTaskNodeTraceSnapshot, guiTaskTreeTraceSnapshot);
    }

    /* renamed from: component1, reason: from getter */
    public final GuiTaskNodeTraceSnapshot getNodeTrace() {
        return this.nodeTrace;
    }

    /* renamed from: component2, reason: from getter */
    public final GuiTaskTreeTraceSnapshot getTaskTreeTrace() {
        return this.taskTreeTrace;
    }

    public final GuiTraceUpdate copy(GuiTaskNodeTraceSnapshot nodeTrace, GuiTaskTreeTraceSnapshot taskTreeTrace) {
        k.f(nodeTrace, "nodeTrace");
        return new GuiTraceUpdate(nodeTrace, taskTreeTrace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTraceUpdate)) {
            return false;
        }
        GuiTraceUpdate guiTraceUpdate = (GuiTraceUpdate) other;
        return k.b(this.nodeTrace, guiTraceUpdate.nodeTrace) && k.b(this.taskTreeTrace, guiTraceUpdate.taskTreeTrace);
    }

    public final GuiTaskNodeTraceSnapshot getNodeTrace() {
        return this.nodeTrace;
    }

    public final GuiTaskTreeTraceSnapshot getTaskTreeTrace() {
        return this.taskTreeTrace;
    }

    public int hashCode() {
        int iHashCode = this.nodeTrace.hashCode() * 31;
        GuiTaskTreeTraceSnapshot guiTaskTreeTraceSnapshot = this.taskTreeTrace;
        return iHashCode + (guiTaskTreeTraceSnapshot == null ? 0 : guiTaskTreeTraceSnapshot.hashCode());
    }

    public String toString() {
        return "GuiTraceUpdate(nodeTrace=" + this.nodeTrace + ", taskTreeTrace=" + this.taskTreeTrace + ")";
    }
}
