package com.stepos.widget.tabbar;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.widget.glass.GlassDelegate;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\b*\u00012\b\u0001\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJI\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\bJ/\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010-R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010.R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010/R\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010/R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010-R\u0016\u00101\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010.R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabIndicatorView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "syncGlass", "()V", "", "cornerRadius", "blurRadius", "", "color", "tintColor", "", "glassEnabled", "plusBlendEnabled", "applyStyle$StepOSWidget_release", "(FFIIZZ)V", "applyStyle", "releaseGlass$StepOSWidget_release", "releaseGlass", "onAttachedToWindow", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "visibility", "setVisibility", "(I)V", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Landroid/graphics/Paint;", "fillPaint", "Landroid/graphics/Paint;", "plusLayerPaint", "F", "I", "Z", "appliedBlurRadius", "appliedTintColor", "com/stepos/widget/tabbar/StepOSTabIndicatorView$roundedOutlineProvider$1", "roundedOutlineProvider", "Lcom/stepos/widget/tabbar/StepOSTabIndicatorView$roundedOutlineProvider$1;", "isGlassActive$StepOSWidget_release", "()Z", "isGlassActive", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSTabIndicatorView extends View {
    private static final Companion Companion = new Companion(null);
    private static final float NO_GLASS = -1.0f;
    private float appliedBlurRadius;
    private int appliedTintColor;
    private float blurRadius;
    private float cornerRadius;
    private final Paint fillPaint;
    private final GlassDelegate glassDelegate;
    private boolean glassEnabled;
    private boolean plusBlendEnabled;
    private final Paint plusLayerPaint;
    private final StepOSTabIndicatorView$roundedOutlineProvider$1 roundedOutlineProvider;
    private int tintColor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSTabIndicatorView$Companion;", "", "<init>", "()V", "NO_GLASS", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.view.ViewOutlineProvider, com.stepos.widget.tabbar.StepOSTabIndicatorView$roundedOutlineProvider$1] */
    public StepOSTabIndicatorView(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.fillPaint = new Paint(1);
        Paint paint = new Paint(1);
        paint.setBlendMode(BlendMode.PLUS);
        this.plusLayerPaint = paint;
        this.glassEnabled = true;
        this.appliedBlurRadius = -1.0f;
        ?? r32 = new ViewOutlineProvider() { // from class: com.stepos.widget.tabbar.StepOSTabIndicatorView$roundedOutlineProvider$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Math.min(this.this$0.cornerRadius, Math.min(view.getWidth(), view.getHeight()) / 2.0f));
            }
        };
        this.roundedOutlineProvider = r32;
        setBackground(null);
        setClickable(false);
        setFocusable(false);
        setImportantForAccessibility(2);
        setOutlineProvider(r32);
    }

    public static /* synthetic */ void applyStyle$StepOSWidget_release$default(StepOSTabIndicatorView stepOSTabIndicatorView, float f10, float f11, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            z11 = false;
        }
        stepOSTabIndicatorView.applyStyle$StepOSWidget_release(f10, f11, i10, i11, z10, z11);
    }

    private final void syncGlass() {
        boolean zApplyBlurOnly$StepOSWidget_release;
        if (this.blurRadius > 0.0f && this.glassEnabled && isAttachedToWindow() && getVisibility() == 0) {
            float f10 = this.appliedBlurRadius;
            float f11 = this.blurRadius;
            if (f10 == f11 && this.appliedTintColor == this.tintColor) {
                this.glassDelegate.updateCornerRadius$StepOSWidget_release(this.cornerRadius);
                zApplyBlurOnly$StepOSWidget_release = this.glassDelegate.getIsActive();
            } else {
                this.appliedBlurRadius = f11;
                int i10 = this.tintColor;
                this.appliedTintColor = i10;
                zApplyBlurOnly$StepOSWidget_release = this.glassDelegate.applyBlurOnly$StepOSWidget_release(0, this.cornerRadius, f11, i10);
            }
        } else {
            releaseGlass$StepOSWidget_release();
            zApplyBlurOnly$StepOSWidget_release = false;
        }
        if (getClipToOutline() != zApplyBlurOnly$StepOSWidget_release) {
            setClipToOutline(zApplyBlurOnly$StepOSWidget_release);
        }
        boolean z10 = (!this.plusBlendEnabled || zApplyBlurOnly$StepOSWidget_release || Color.alpha(this.fillPaint.getColor()) == 0) ? false : true;
        int i11 = z10 ? 2 : 0;
        if (getLayerType() != i11) {
            setLayerType(i11, z10 ? this.plusLayerPaint : null);
        }
        invalidate();
    }

    public final void applyStyle$StepOSWidget_release(float cornerRadius, float blurRadius, int color, int tintColor, boolean glassEnabled, boolean plusBlendEnabled) {
        this.cornerRadius = cornerRadius;
        this.blurRadius = blurRadius;
        this.tintColor = tintColor;
        this.glassEnabled = glassEnabled;
        this.plusBlendEnabled = plusBlendEnabled;
        this.fillPaint.setColor(color);
        syncGlass();
        invalidateOutline();
        invalidate();
    }

    public final boolean isGlassActive$StepOSWidget_release() {
        return this.glassDelegate.getIsActive();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        syncGlass();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        releaseGlass$StepOSWidget_release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (Color.alpha(this.fillPaint.getColor()) == 0) {
            return;
        }
        if (this.glassDelegate.getIsActive() && Color.alpha(this.fillPaint.getColor()) == 255) {
            return;
        }
        float width = getWidth();
        float height = getHeight();
        float f10 = this.cornerRadius;
        canvas.drawRoundRect(0.0f, 0.0f, width, height, f10, f10, this.fillPaint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        invalidateOutline();
    }

    public final void releaseGlass$StepOSWidget_release() {
        this.glassDelegate.release$StepOSWidget_release();
        this.appliedBlurRadius = -1.0f;
        this.appliedTintColor = 0;
        if (getClipToOutline()) {
            setClipToOutline(false);
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        boolean z10 = getVisibility() != visibility;
        super.setVisibility(visibility);
        if (z10) {
            syncGlass();
        }
    }
}
