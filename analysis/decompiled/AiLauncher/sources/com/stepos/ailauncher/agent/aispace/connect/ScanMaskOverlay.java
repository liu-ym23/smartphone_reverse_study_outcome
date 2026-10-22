package com.stepos.ailauncher.agent.aispace.connect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/ScanMaskOverlay;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/Paint;", "maskPaint", "Landroid/graphics/Paint;", "clearPaint", "", "density", "F", "windowPx", "cornerRadiusPx", "verticalOffsetPx", "Landroid/graphics/RectF;", "holeRect", "Landroid/graphics/RectF;", "Companion", Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScanMaskOverlay extends View {
    private static final float CORNER_RADIUS_DP = 38.0f;
    private static final int MASK_COLOR = -1728053248;
    private static final float SCAN_WINDOW_DP = 264.0f;
    private static final float VERTICAL_OFFSET_DP = 10.0f;
    private final Paint clearPaint;
    private final float cornerRadiusPx;
    private final float density;
    private final RectF holeRect;
    private final Paint maskPaint;
    private final float verticalOffsetPx;
    private final float windowPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanMaskOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        Paint paint = new Paint();
        paint.setColor(MASK_COLOR);
        this.maskPaint = paint;
        Paint paint2 = new Paint();
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint2.setAntiAlias(true);
        this.clearPaint = paint2;
        float f10 = context.getResources().getDisplayMetrics().density;
        this.density = f10;
        this.windowPx = SCAN_WINDOW_DP * f10;
        this.cornerRadiusPx = CORNER_RADIUS_DP * f10;
        this.verticalOffsetPx = f10 * 10.0f;
        this.holeRect = new RectF();
        setLayerType(2, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        float width = getWidth();
        float height = getHeight();
        float f10 = width / 2.0f;
        float f11 = (height / 2.0f) - this.verticalOffsetPx;
        RectF rectF = this.holeRect;
        float f12 = this.windowPx;
        rectF.set(f10 - (f12 / 2.0f), f11 - (f12 / 2.0f), f10 + (f12 / 2.0f), f11 + (f12 / 2.0f));
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null);
        canvas.drawRect(0.0f, 0.0f, width, height, this.maskPaint);
        RectF rectF2 = this.holeRect;
        float f13 = this.cornerRadiusPx;
        canvas.drawRoundRect(rectF2, f13, f13, this.clearPaint);
        canvas.restoreToCount(iSaveLayer);
    }
}
