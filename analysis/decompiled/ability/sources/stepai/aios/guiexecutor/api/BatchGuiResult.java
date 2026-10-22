package stepai.aios.guiexecutor.api;

import H4.o;
import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0003JM\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006)"}, d2 = {"Lstepai/aios/guiexecutor/api/BatchGuiResult;", "", "results", "", "Lstepai/aios/guiexecutor/api/GuiResult;", "totalExecutionTime", "", "successCount", "", "failureCount", "metadata", "", "", AppAgent.CONSTRUCT, "(Ljava/util/List;JIILjava/util/Map;)V", "getResults", "()Ljava/util/List;", "getTotalExecutionTime", "()J", "getSuccessCount", "()I", "getFailureCount", "getMetadata", "()Ljava/util/Map;", "success", "", "getSuccess", "()Z", "partialSuccess", "getPartialSuccess", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BatchGuiResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int failureCount;
    private final Map<String, Object> metadata;
    private final List<GuiResult> results;
    private final int successCount;
    private final long totalExecutionTime;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lstepai/aios/guiexecutor/api/BatchGuiResult$Companion;", "", AppAgent.CONSTRUCT, "()V", TypedValues.TransitionType.S_FROM, "Lstepai/aios/guiexecutor/api/BatchGuiResult;", "results", "", "Lstepai/aios/guiexecutor/api/GuiResult;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final BatchGuiResult from(List<GuiResult> results) {
            int i;
            k.f(results, "results");
            List<GuiResult> list = results;
            boolean z10 = list instanceof Collection;
            int i6 = 0;
            if (z10 && list.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = list.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    if (((GuiResult) it.next()).getSuccess() && (i10 = i10 + 1) < 0) {
                        o.W();
                        throw null;
                    }
                }
                i = i10;
            }
            if (!z10 || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (!((GuiResult) it2.next()).getSuccess() && (i6 = i6 + 1) < 0) {
                        o.W();
                        throw null;
                    }
                }
            }
            int i11 = i6;
            Iterator<T> it3 = list.iterator();
            long executionTime = 0;
            while (it3.hasNext()) {
                executionTime += ((GuiResult) it3.next()).getExecutionTime();
            }
            return new BatchGuiResult(results, executionTime, i, i11, null, 16, null);
        }

        private Companion() {
        }
    }

    public BatchGuiResult(List<GuiResult> results, long j5, int i, int i6, Map<String, ? extends Object> metadata) {
        k.f(results, "results");
        k.f(metadata, "metadata");
        this.results = results;
        this.totalExecutionTime = j5;
        this.successCount = i;
        this.failureCount = i6;
        this.metadata = metadata;
    }

    public static /* synthetic */ BatchGuiResult copy$default(BatchGuiResult batchGuiResult, List list, long j5, int i, int i6, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = batchGuiResult.results;
        }
        if ((i10 & 2) != 0) {
            j5 = batchGuiResult.totalExecutionTime;
        }
        if ((i10 & 4) != 0) {
            i = batchGuiResult.successCount;
        }
        if ((i10 & 8) != 0) {
            i6 = batchGuiResult.failureCount;
        }
        if ((i10 & 16) != 0) {
            map = batchGuiResult.metadata;
        }
        Map map2 = map;
        int i11 = i;
        return batchGuiResult.copy(list, j5, i11, i6, map2);
    }

    public final List<GuiResult> component1() {
        return this.results;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTotalExecutionTime() {
        return this.totalExecutionTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFailureCount() {
        return this.failureCount;
    }

    public final Map<String, Object> component5() {
        return this.metadata;
    }

    public final BatchGuiResult copy(List<GuiResult> results, long totalExecutionTime, int successCount, int failureCount, Map<String, ? extends Object> metadata) {
        k.f(results, "results");
        k.f(metadata, "metadata");
        return new BatchGuiResult(results, totalExecutionTime, successCount, failureCount, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchGuiResult)) {
            return false;
        }
        BatchGuiResult batchGuiResult = (BatchGuiResult) other;
        return k.b(this.results, batchGuiResult.results) && this.totalExecutionTime == batchGuiResult.totalExecutionTime && this.successCount == batchGuiResult.successCount && this.failureCount == batchGuiResult.failureCount && k.b(this.metadata, batchGuiResult.metadata);
    }

    public final int getFailureCount() {
        return this.failureCount;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final boolean getPartialSuccess() {
        return this.successCount > 0 && this.failureCount > 0;
    }

    public final List<GuiResult> getResults() {
        return this.results;
    }

    public final boolean getSuccess() {
        return this.failureCount == 0;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final long getTotalExecutionTime() {
        return this.totalExecutionTime;
    }

    public int hashCode() {
        return this.metadata.hashCode() + a.a(this.failureCount, a.a(this.successCount, androidx.appfunctions.metadata.a.c(this.results.hashCode() * 31, 31, this.totalExecutionTime), 31), 31);
    }

    public String toString() {
        return "BatchGuiResult(results=" + this.results + ", totalExecutionTime=" + this.totalExecutionTime + ", successCount=" + this.successCount + ", failureCount=" + this.failureCount + ", metadata=" + this.metadata + ")";
    }

    public /* synthetic */ BatchGuiResult(List list, long j5, int i, int i6, Map map, int i10, e eVar) {
        this(list, j5, i, i6, (i10 & 16) != 0 ? kotlin.collections.a.M() : map);
    }
}
