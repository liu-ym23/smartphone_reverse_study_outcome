package com.stepos.motionkit;

import android.os.SystemClock;
import androidx.compose.material3.MenuKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001d\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/stepos/motionkit/PerformanceMonitor;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "onFrame", "reset", "Lcom/stepos/motionkit/FloatRingBuffer;", "frameTimes", "Lcom/stepos/motionkit/FloatRingBuffer;", "", "lastFrameNanos", "J", "frameCount", "droppedFrames", "", "getFps", "()F", "fps", "getAverageFrameTimeMs", "averageFrameTimeMs", "getMaxFrameTimeMs", "maxFrameTimeMs", "getTotalFrames", "()J", "totalFrames", "getTotalDroppedFrames", "totalDroppedFrames", "getDropRate", "dropRate", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PerformanceMonitor {
    private long droppedFrames;
    private long frameCount;
    private final FloatRingBuffer frameTimes = new FloatRingBuffer(MenuKt.InTransitionDuration);
    private long lastFrameNanos;

    public final float getAverageFrameTimeMs() {
        return this.frameTimes.average();
    }

    public final float getDropRate() {
        long j5 = this.frameCount;
        if (j5 > 0) {
            return this.droppedFrames / j5;
        }
        return 0.0f;
    }

    public final float getFps() {
        float fAverage = this.frameTimes.average();
        if (fAverage > 0.0f) {
            return 1000.0f / fAverage;
        }
        return 0.0f;
    }

    public final float getMaxFrameTimeMs() {
        return this.frameTimes.max();
    }

    /* renamed from: getTotalDroppedFrames, reason: from getter */
    public final long getDroppedFrames() {
        return this.droppedFrames;
    }

    /* renamed from: getTotalFrames, reason: from getter */
    public final long getFrameCount() {
        return this.frameCount;
    }

    public final void onFrame() {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (this.lastFrameNanos != 0) {
            float f = (jElapsedRealtimeNanos - r2) / 1000000.0f;
            this.frameTimes.push(f);
            if (f > 18.0f) {
                this.droppedFrames++;
            }
        }
        this.lastFrameNanos = jElapsedRealtimeNanos;
        this.frameCount++;
    }

    public final void reset() {
        this.frameTimes.clear();
        this.lastFrameNanos = 0L;
        this.frameCount = 0L;
        this.droppedFrames = 0L;
    }
}
