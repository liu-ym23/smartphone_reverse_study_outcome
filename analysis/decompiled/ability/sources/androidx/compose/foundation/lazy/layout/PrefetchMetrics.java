package androidx.compose.foundation.lazy.layout;

import S7.a;
import androidx.collection.MutableObjectLongMap;
import androidx.collection.ObjectLongMapKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\u000f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0080\b¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\u0012\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0080\b¢\u0006\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "", AppAgent.CONSTRUCT, "()V", "", "new", "current", "calculateAverageTime", "(JJ)J", "contentType", "Lkotlin/Function0;", "LC7/r;", "doComposition", "recordCompositionTiming$foundation_release", "(Ljava/lang/Object;LS7/a;)V", "recordCompositionTiming", "doMeasure", "recordMeasureTiming$foundation_release", "recordMeasureTiming", "Landroidx/collection/MutableObjectLongMap;", "averageCompositionTimeNanosByContentType", "Landroidx/collection/MutableObjectLongMap;", "getAverageCompositionTimeNanosByContentType", "()Landroidx/collection/MutableObjectLongMap;", "averageMeasureTimeNanosByContentType", "getAverageMeasureTimeNanosByContentType", "<set-?>", "averageCompositionTimeNanos", "J", "getAverageCompositionTimeNanos", "()J", "averageMeasureTimeNanos", "getAverageMeasureTimeNanos", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrefetchMetrics {
    public static final int $stable = 8;
    private long averageCompositionTimeNanos;
    private long averageMeasureTimeNanos;
    private final MutableObjectLongMap<Object> averageCompositionTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();
    private final MutableObjectLongMap<Object> averageMeasureTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();

    /* JADX INFO: Access modifiers changed from: private */
    public final long calculateAverageTime(long j5, long current) {
        if (current == 0) {
            return j5;
        }
        long j6 = 4;
        return (j5 / j6) + ((current / j6) * 3);
    }

    public final long getAverageCompositionTimeNanos() {
        return this.averageCompositionTimeNanos;
    }

    public final MutableObjectLongMap<Object> getAverageCompositionTimeNanosByContentType() {
        return this.averageCompositionTimeNanosByContentType;
    }

    public final long getAverageMeasureTimeNanos() {
        return this.averageMeasureTimeNanos;
    }

    public final MutableObjectLongMap<Object> getAverageMeasureTimeNanosByContentType() {
        return this.averageMeasureTimeNanosByContentType;
    }

    public final void recordCompositionTiming$foundation_release(Object contentType, a doComposition) {
        long jNanoTime = System.nanoTime();
        doComposition.invoke();
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        if (contentType != null) {
            getAverageCompositionTimeNanosByContentType().set(contentType, calculateAverageTime(jNanoTime2, getAverageCompositionTimeNanosByContentType().getOrDefault(contentType, 0L)));
        }
        this.averageCompositionTimeNanos = calculateAverageTime(jNanoTime2, getAverageCompositionTimeNanos());
    }

    public final void recordMeasureTiming$foundation_release(Object contentType, a doMeasure) {
        long jNanoTime = System.nanoTime();
        doMeasure.invoke();
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        if (contentType != null) {
            getAverageMeasureTimeNanosByContentType().set(contentType, calculateAverageTime(jNanoTime2, getAverageMeasureTimeNanosByContentType().getOrDefault(contentType, 0L)));
        }
        this.averageMeasureTimeNanos = calculateAverageTime(jNanoTime2, getAverageMeasureTimeNanos());
    }
}
