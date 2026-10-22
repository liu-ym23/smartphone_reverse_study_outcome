package stepai.aios.guiexecutor.core;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/aios/guiexecutor/core/GuiExecutorConfig;", "", "maxConcurrentCommands", "", "defaultTimeout", "", "batchExecutionMode", "Lstepai/aios/guiexecutor/core/BatchExecutionMode;", "failFastOnBatch", "", "enableMetrics", AppAgent.CONSTRUCT, "(IJLstepai/aios/guiexecutor/core/BatchExecutionMode;ZZ)V", "getMaxConcurrentCommands", "()I", "getDefaultTimeout", "()J", "getBatchExecutionMode", "()Lstepai/aios/guiexecutor/core/BatchExecutionMode;", "getFailFastOnBatch", "()Z", "getEnableMetrics", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiExecutorConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BatchExecutionMode batchExecutionMode;
    private final long defaultTimeout;
    private final boolean enableMetrics;
    private final boolean failFastOnBatch;
    private final int maxConcurrentCommands;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lstepai/aios/guiexecutor/core/GuiExecutorConfig$Companion;", "", AppAgent.CONSTRUCT, "()V", "default", "Lstepai/aios/guiexecutor/core/GuiExecutorConfig;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: default, reason: not valid java name */
        public final GuiExecutorConfig m7370default() {
            return new GuiExecutorConfig(0, 0L, null, false, false, 31, null);
        }

        private Companion() {
        }
    }

    public GuiExecutorConfig() {
        this(0, 0L, null, false, false, 31, null);
    }

    public static /* synthetic */ GuiExecutorConfig copy$default(GuiExecutorConfig guiExecutorConfig, int i, long j5, BatchExecutionMode batchExecutionMode, boolean z10, boolean z11, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = guiExecutorConfig.maxConcurrentCommands;
        }
        if ((i6 & 2) != 0) {
            j5 = guiExecutorConfig.defaultTimeout;
        }
        if ((i6 & 4) != 0) {
            batchExecutionMode = guiExecutorConfig.batchExecutionMode;
        }
        if ((i6 & 8) != 0) {
            z10 = guiExecutorConfig.failFastOnBatch;
        }
        if ((i6 & 16) != 0) {
            z11 = guiExecutorConfig.enableMetrics;
        }
        boolean z12 = z11;
        BatchExecutionMode batchExecutionMode2 = batchExecutionMode;
        return guiExecutorConfig.copy(i, j5, batchExecutionMode2, z10, z12);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxConcurrentCommands() {
        return this.maxConcurrentCommands;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDefaultTimeout() {
        return this.defaultTimeout;
    }

    /* renamed from: component3, reason: from getter */
    public final BatchExecutionMode getBatchExecutionMode() {
        return this.batchExecutionMode;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFailFastOnBatch() {
        return this.failFastOnBatch;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnableMetrics() {
        return this.enableMetrics;
    }

    public final GuiExecutorConfig copy(int maxConcurrentCommands, long defaultTimeout, BatchExecutionMode batchExecutionMode, boolean failFastOnBatch, boolean enableMetrics) {
        k.f(batchExecutionMode, "batchExecutionMode");
        return new GuiExecutorConfig(maxConcurrentCommands, defaultTimeout, batchExecutionMode, failFastOnBatch, enableMetrics);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiExecutorConfig)) {
            return false;
        }
        GuiExecutorConfig guiExecutorConfig = (GuiExecutorConfig) other;
        return this.maxConcurrentCommands == guiExecutorConfig.maxConcurrentCommands && this.defaultTimeout == guiExecutorConfig.defaultTimeout && this.batchExecutionMode == guiExecutorConfig.batchExecutionMode && this.failFastOnBatch == guiExecutorConfig.failFastOnBatch && this.enableMetrics == guiExecutorConfig.enableMetrics;
    }

    public final BatchExecutionMode getBatchExecutionMode() {
        return this.batchExecutionMode;
    }

    public final long getDefaultTimeout() {
        return this.defaultTimeout;
    }

    public final boolean getEnableMetrics() {
        return this.enableMetrics;
    }

    public final boolean getFailFastOnBatch() {
        return this.failFastOnBatch;
    }

    public final int getMaxConcurrentCommands() {
        return this.maxConcurrentCommands;
    }

    public int hashCode() {
        return Boolean.hashCode(this.enableMetrics) + a.d((this.batchExecutionMode.hashCode() + a.c(Integer.hashCode(this.maxConcurrentCommands) * 31, 31, this.defaultTimeout)) * 31, 31, this.failFastOnBatch);
    }

    public String toString() {
        return "GuiExecutorConfig(maxConcurrentCommands=" + this.maxConcurrentCommands + ", defaultTimeout=" + this.defaultTimeout + ", batchExecutionMode=" + this.batchExecutionMode + ", failFastOnBatch=" + this.failFastOnBatch + ", enableMetrics=" + this.enableMetrics + ")";
    }

    public GuiExecutorConfig(int i, long j5, BatchExecutionMode batchExecutionMode, boolean z10, boolean z11) {
        k.f(batchExecutionMode, "batchExecutionMode");
        this.maxConcurrentCommands = i;
        this.defaultTimeout = j5;
        this.batchExecutionMode = batchExecutionMode;
        this.failFastOnBatch = z10;
        this.enableMetrics = z11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuiExecutorConfig(int i, long j5, BatchExecutionMode batchExecutionMode, boolean z10, boolean z11, int i6, e eVar) {
        boolean z12;
        boolean z13;
        BatchExecutionMode batchExecutionMode2;
        i = (i6 & 1) != 0 ? 5 : i;
        j5 = (i6 & 2) != 0 ? 10000L : j5;
        batchExecutionMode = (i6 & 4) != 0 ? BatchExecutionMode.SEQUENTIAL : batchExecutionMode;
        z10 = (i6 & 8) != 0 ? true : z10;
        if ((i6 & 16) != 0) {
            z12 = true;
            batchExecutionMode2 = batchExecutionMode;
            z13 = z10;
        } else {
            z12 = z11;
            z13 = z10;
            batchExecutionMode2 = batchExecutionMode;
        }
        this(i, j5, batchExecutionMode2, z13, z12);
    }
}
