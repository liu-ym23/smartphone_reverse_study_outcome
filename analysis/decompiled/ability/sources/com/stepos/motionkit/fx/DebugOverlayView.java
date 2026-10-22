package com.stepos.motionkit.fx;

import H4.o;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.MotionHost;
import com.stepos.motionkit.PerformanceMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/motionkit/fx/DebugOverlayView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Lcom/stepos/motionkit/MotionHost;", "host", AppAgent.CONSTRUCT, "(Landroid/content/Context;Lcom/stepos/motionkit/MotionHost;)V", "Landroid/graphics/Canvas;", "canvas", "LC7/r;", "onDraw", "(Landroid/graphics/Canvas;)V", "Lcom/stepos/motionkit/MotionHost;", "Landroid/graphics/Paint;", "textPaint", "Landroid/graphics/Paint;", "bgPaint", "", "", "lines", "Ljava/util/List;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DebugOverlayView extends View {
    private final Paint bgPaint;
    private final MotionHost host;
    private final List<String> lines;
    private final Paint textPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugOverlayView(Context context, MotionHost host) {
        super(context);
        k.f(context, "context");
        k.f(host, "host");
        this.host = host;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextSize(28.0f);
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setShadowLayer(2.0f, 1.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
        this.textPaint = paint;
        Paint paint2 = new Paint();
        paint2.setColor(Color.argb(160, 0, 0, 0));
        this.bgPaint = paint2;
        this.lines = new ArrayList();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        k.f(canvas, "canvas");
        PerformanceMonitor performanceMonitor = this.host.getPerformanceMonitor();
        this.lines.clear();
        this.lines.add(String.format("FPS: %.1f", Arrays.copyOf(new Object[]{Float.valueOf(performanceMonitor.getFps())}, 1)));
        this.lines.add(String.format("Frame: %.2f ms (max %.2f)", Arrays.copyOf(new Object[]{Float.valueOf(performanceMonitor.getAverageFrameTimeMs()), Float.valueOf(performanceMonitor.getMaxFrameTimeMs())}, 2)));
        this.lines.add(String.format("Dropped: %d (%.1f%%)", Arrays.copyOf(new Object[]{Long.valueOf(performanceMonitor.getDroppedFrames()), Float.valueOf(performanceMonitor.getDropRate() * 100)}, 2)));
        this.lines.add(String.format("Active: %s", Arrays.copyOf(new Object[]{this.host.isActive() ? "YES" : "NO"}, 1)));
        canvas.drawRoundRect(8.0f, 8.0f, 380.0f, (2 * 12.0f) + (this.lines.size() * 36.0f) + 8.0f, 8.0f, 8.0f, this.bgPaint);
        int i = 0;
        for (Object obj : this.lines) {
            int i6 = i + 1;
            if (i < 0) {
                o.X();
                throw null;
            }
            canvas.drawText((String) obj, 20.0f, (i6 * 36.0f) + 20.0f, this.textPaint);
            i = i6;
        }
        postInvalidateDelayed(500L);
    }
}
