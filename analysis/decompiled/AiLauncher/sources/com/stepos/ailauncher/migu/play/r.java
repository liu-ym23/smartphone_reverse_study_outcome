package com.stepos.ailauncher.migu.play;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.ailauncher.chat.view.M8;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\"\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR.\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/migu/play/r;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", UxipConstants.f30680s, "progress", "Ljava/lang/Integer;", "getProgress", "()Ljava/lang/Integer;", "setProgress", "(Ljava/lang/Integer;)V", "Landroid/graphics/Paint;", "trackPaint", "Landroid/graphics/Paint;", "progressPaint", "Landroid/graphics/RectF;", "oval", "Landroid/graphics/RectF;", "", "spinDegrees", "F", "com/stepos/ailauncher/migu/play/r$a", "spinRunnable", "Lcom/stepos/ailauncher/migu/play/r$a;", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r extends View {
    private final RectF oval;
    private Integer progress;
    private final Paint progressPaint;
    private float spinDegrees;
    private final a spinRunnable;
    private final Paint trackPaint;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/migu/play/r$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.getProgress() != null) {
                return;
            }
            r rVar = r.this;
            rVar.spinDegrees = (rVar.spinDegrees + 8.0f) % 360.0f;
            r.this.invalidate();
            r.this.postDelayed(this, 16L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        Paint paint = new Paint(1);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setColor(M8.SCRIM_COLOR);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        this.trackPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(style);
        paint2.setColor(-436207616);
        paint2.setStrokeCap(cap);
        this.progressPaint = paint2;
        this.oval = new RectF();
        this.spinRunnable = new a();
    }

    public final Integer getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.progress == null) {
            post(this.spinRunnable);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.spinRunnable);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        float fMin = Math.min(getWidth(), getHeight()) * 0.12f;
        this.trackPaint.setStrokeWidth(fMin);
        this.progressPaint.setStrokeWidth(fMin);
        float f10 = (fMin / 2.0f) + 1.0f;
        this.oval.set(f10, f10, getWidth() - f10, getHeight() - f10);
        canvas.drawArc(this.oval, 0.0f, 360.0f, false, this.trackPaint);
        if (this.progress != null) {
            canvas.drawArc(this.oval, -90.0f, (r0.intValue() * 360.0f) / 100.0f, false, this.progressPaint);
            return;
        }
        canvas.drawArc(this.oval, this.spinDegrees - 90.0f, 90.0f, false, this.progressPaint);
        if (isInEditMode()) {
            return;
        }
        removeCallbacks(this.spinRunnable);
        postDelayed(this.spinRunnable, 16L);
    }

    public final void setProgress(Integer num) {
        int iIntValue;
        if (num == null || 1 > (iIntValue = num.intValue()) || iIntValue >= 101) {
            num = null;
        }
        this.progress = num;
        invalidate();
    }

    public /* synthetic */ r(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
