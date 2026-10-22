package Aa;

import stepai.aios.guiagent.config.ResolvedTaskConfig;
import stepai.aios.guiexecutor.core.DefaultGuiExecutor;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ResolvedTaskConfig f168a;
    public final DefaultGuiExecutor b;
    public final stepai.aios.guiagent.pipeline.util.a c;

    public e(ResolvedTaskConfig resolvedTaskConfig, DefaultGuiExecutor defaultGuiExecutor, stepai.aios.guiagent.pipeline.util.a aVar) {
        this.f168a = resolvedTaskConfig;
        this.b = defaultGuiExecutor;
        this.c = aVar;
    }

    public final ResolvedTaskConfig a() {
        return this.f168a;
    }

    public final stepai.aios.guiagent.pipeline.util.a b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f168a.equals(eVar.f168a) && this.b.equals(eVar.b) && this.c.equals(eVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.f168a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TaskRuntime(config=" + this.f168a + ", guiExecutor=" + this.b + ", guiInterruptionAdapter=" + this.c + ")";
    }
}
