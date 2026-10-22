package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0017J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J\u0018\u0010(\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0017H\u0002J\u0006\u0010)\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Landroidx/compose/foundation/lazy/layout/Averages;", "", "<init>", "()V", "compositionTimeNanos", "", "getCompositionTimeNanos", "()J", "setCompositionTimeNanos", "(J)V", "resumeTimeNanos", "getResumeTimeNanos", "setResumeTimeNanos", "pauseTimeNanos", "getPauseTimeNanos", "setPauseTimeNanos", "applyTimeNanos", "getApplyTimeNanos", "setApplyTimeNanos", "measureTimeNanos", "getMeasureTimeNanos", "setMeasureTimeNanos", "nestedPrefetchCount", "", "getNestedPrefetchCount", "()I", "setNestedPrefetchCount", "(I)V", "saveCompositionTimeNanos", "", "timeNanos", "saveResumeTimeNanos", "savePauseTimeNanos", "saveApplyTimeNanos", "saveMeasureTimeNanos", "saveNestedPrefetchCount", "count", "calculateAverageTime", "new", "current", "calculateAverageCount", "clearMeasureTime", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Averages {
    public static final int $stable = 8;
    private long applyTimeNanos;
    private long compositionTimeNanos;
    private long measureTimeNanos;
    private int nestedPrefetchCount;
    private long pauseTimeNanos;
    private long resumeTimeNanos;

    public final void clearMeasureTime() {
        this.measureTimeNanos = 0;
    }

    public Averages() {
        this.nestedPrefetchCount = -1;
    }

    public final long getApplyTimeNanos() {
        return this.applyTimeNanos;
    }

    public final long getCompositionTimeNanos() {
        return this.compositionTimeNanos;
    }

    public final long getMeasureTimeNanos() {
        return this.measureTimeNanos;
    }

    public final int getNestedPrefetchCount() {
        return this.nestedPrefetchCount;
    }

    public final long getPauseTimeNanos() {
        return this.pauseTimeNanos;
    }

    public final long getResumeTimeNanos() {
        return this.resumeTimeNanos;
    }

    public final void saveApplyTimeNanos(long r100) {
        this.applyTimeNanos = calculateAverageTime(r100, this.applyTimeNanos);
    }

    public final void saveCompositionTimeNanos(long r100) {
        this.compositionTimeNanos = calculateAverageTime(r100, this.compositionTimeNanos);
    }

    public final void saveMeasureTimeNanos(long r100) {
        this.measureTimeNanos = calculateAverageTime(r100, this.measureTimeNanos);
    }

    public final void saveNestedPrefetchCount(int r100) {
        this.nestedPrefetchCount = calculateAverageCount(r100, this.nestedPrefetchCount);
    }

    public final void savePauseTimeNanos(long r100) {
        this.pauseTimeNanos = calculateAverageTime(r100, this.pauseTimeNanos);
    }

    public final void saveResumeTimeNanos(long r100) {
        this.resumeTimeNanos = calculateAverageTime(r100, this.resumeTimeNanos);
    }

    public final void setApplyTimeNanos(long r100) {
        this.applyTimeNanos = r100;
    }

    public final void setCompositionTimeNanos(long r100) {
        this.compositionTimeNanos = r100;
    }

    public final void setMeasureTimeNanos(long r100) {
        this.measureTimeNanos = r100;
    }

    public final void setNestedPrefetchCount(int r100) {
        this.nestedPrefetchCount = r100;
    }

    public final void setPauseTimeNanos(long r100) {
        this.pauseTimeNanos = r100;
    }

    public final void setResumeTimeNanos(long r100) {
        this.resumeTimeNanos = r100;
    }

    private final int calculateAverageCount(int r100, int r101) {
        if (r101 != (-1)) goto L6;
        return r100;
    L6:
        return ((r101 * 3) + r100) / 4;
    }

    private final long calculateAverageTime(long r100, long r101) {
        if (r101 == 0) goto L7;
        long r102 = 4;
        return (r100 / r102) + ((r101 / r102) * ((long) 3));
    L7:
        return r100;
    }
}
