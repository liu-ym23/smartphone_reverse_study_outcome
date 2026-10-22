package com.stepos.ailauncher.chat.widget;

import Y8.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.y;
import p9.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0001;B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R6\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006<"}, d2 = {"Lcom/stepos/ailauncher/chat/widget/FigmaSlider;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "density", "F", "trackHeight", "thumbRadius", "trackBgColor", "I", "trackProgressColor", "thumbColor", "Landroid/graphics/Paint;", "trackBgPaint", "Landroid/graphics/Paint;", "trackProgressPaint", "thumbPaint", "Landroid/graphics/RectF;", "trackRect", "Landroid/graphics/RectF;", "progressRect", "max", "getMax", "()I", "setMax", "(I)V", UxipConstants.f30680s, "progress", "getProgress", "setProgress", "Lkotlin/Function2;", "onProgressChanged", "Lp9/p;", "getOnProgressChanged", "()Lp9/p;", "setOnProgressChanged", "(Lp9/p;)V", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FigmaSlider extends View {
    private static final String TAG = "FigmaSlider";
    private final float density;
    private int max;
    private p<? super Integer, ? super Boolean, t> onProgressChanged;
    private int progress;
    private final RectF progressRect;
    private final int thumbColor;
    private final Paint thumbPaint;
    private final float thumbRadius;
    private final int trackBgColor;
    private final Paint trackBgPaint;
    private final float trackHeight;
    private final int trackProgressColor;
    private final Paint trackProgressPaint;
    private final RectF trackRect;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FigmaSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final int getMax() {
        return this.max;
    }

    public final p<Integer, Boolean, t> getOnProgressChanged() {
        return this.onProgressChanged;
    }

    public final int getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        float width = getWidth();
        float height = getHeight();
        float f10 = this.trackHeight;
        float f11 = (height - f10) / 2.0f;
        float f12 = f11 + f10;
        float f13 = f10 / 2.0f;
        this.trackRect.set(0.0f, f11, width, f12);
        canvas.drawRoundRect(this.trackRect, f13, f13, this.trackBgPaint);
        int i10 = this.max;
        float f14 = i10 > 0 ? this.progress / i10 : 0.0f;
        float f15 = ((width - (2 * f13)) * f14) + f13;
        float f16 = height / 2.0f;
        if (f14 > 0.0f) {
            this.progressRect.set(0.0f, f11, C5685n.i(f15 + f13, width), f12);
            canvas.drawRoundRect(this.progressRect, f13, f13, this.trackProgressPaint);
        }
        canvas.drawCircle(f15, f16, this.thumbRadius, this.thumbPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.resolveSize((int) ((this.thumbRadius * 2) + (8 * this.density)), heightMeasureSpec));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return super.onTouchEvent(event);
                    }
                }
            }
            y yVar = y.f34840a;
            String str = String.format("touch UP/CANCEL: final progress=%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.progress)}, 1));
            kotlin.jvm.internal.p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            getParent().requestDisallowInterceptTouchEvent(false);
            return true;
        }
        float f10 = this.trackHeight / 2.0f;
        float fM = C5685n.m((event.getX() - f10) / ((getWidth() - f10) - f10), 0.0f, 1.0f);
        int i10 = (int) (this.max * fM);
        y yVar2 = y.f34840a;
        String str2 = String.format("touch %d: x=%.1f, width=%d, fraction=%.3f, progress=%d (current=%d, max=%d)", Arrays.copyOf(new Object[]{Integer.valueOf(event.getActionMasked()), Float.valueOf(event.getX()), Integer.valueOf(getWidth()), Float.valueOf(fM), Integer.valueOf(i10), Integer.valueOf(this.progress), Integer.valueOf(this.max)}, 7));
        kotlin.jvm.internal.p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        if (i10 != this.progress) {
            setProgress(i10);
            p<? super Integer, ? super Boolean, t> pVar = this.onProgressChanged;
            if (pVar != null) {
                pVar.invoke(Integer.valueOf(this.progress), Boolean.TRUE);
            }
        }
        invalidate();
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public final void setMax(int i10) {
        this.max = i10;
    }

    public final void setOnProgressChanged(p<? super Integer, ? super Boolean, t> pVar) {
        this.onProgressChanged = pVar;
    }

    public final void setProgress(int i10) {
        int iN = C5685n.n(i10, 0, this.max);
        if (this.progress == iN) {
            return;
        }
        this.progress = iN;
        invalidate();
        p<? super Integer, ? super Boolean, t> pVar = this.onProgressChanged;
        if (pVar != null) {
            pVar.invoke(Integer.valueOf(iN), Boolean.FALSE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FigmaSlider(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        float f10 = getResources().getDisplayMetrics().density;
        this.density = f10;
        this.trackHeight = 22.0f * f10;
        this.thumbRadius = f10 * 9.0f;
        int iC = a.c(context, R$color.figma_slider_track_bg);
        this.trackBgColor = iC;
        int iC2 = a.c(context, R$color.figma_slider_track_progress);
        this.trackProgressColor = iC2;
        int iC3 = a.c(context, R$color.figma_slider_thumb);
        this.thumbColor = iC3;
        Paint paint = new Paint(1);
        paint.setColor(iC);
        this.trackBgPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(iC2);
        this.trackProgressPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setColor(iC3);
        this.thumbPaint = paint3;
        this.trackRect = new RectF();
        this.progressRect = new RectF();
        this.max = 100;
    }

    public /* synthetic */ FigmaSlider(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
