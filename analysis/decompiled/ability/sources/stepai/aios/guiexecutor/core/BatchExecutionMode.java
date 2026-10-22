package stepai.aios.guiexecutor.core;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lstepai/aios/guiexecutor/core/BatchExecutionMode;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "SEQUENTIAL", "PARALLEL", "MIXED", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BatchExecutionMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ BatchExecutionMode[] $VALUES;
    public static final BatchExecutionMode SEQUENTIAL = new BatchExecutionMode("SEQUENTIAL", 0);
    public static final BatchExecutionMode PARALLEL = new BatchExecutionMode("PARALLEL", 1);
    public static final BatchExecutionMode MIXED = new BatchExecutionMode("MIXED", 2);

    private static final /* synthetic */ BatchExecutionMode[] $values() {
        return new BatchExecutionMode[]{SEQUENTIAL, PARALLEL, MIXED};
    }

    static {
        BatchExecutionMode[] batchExecutionModeArr$values = $values();
        $VALUES = batchExecutionModeArr$values;
        $ENTRIES = kotlin.enums.a.a(batchExecutionModeArr$values);
    }

    private BatchExecutionMode(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static BatchExecutionMode valueOf(String str) {
        return (BatchExecutionMode) Enum.valueOf(BatchExecutionMode.class, str);
    }

    public static BatchExecutionMode[] values() {
        return (BatchExecutionMode[]) $VALUES.clone();
    }
}
