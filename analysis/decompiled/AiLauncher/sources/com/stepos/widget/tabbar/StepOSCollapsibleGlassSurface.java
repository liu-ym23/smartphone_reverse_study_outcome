package com.stepos.widget.tabbar;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassDelegate;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b!\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ+\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0015\u0010\nJ/\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010.\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010,R\u0014\u0010/\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u0010,R\u0014\u00100\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b0\u0010,R\u0014\u00101\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00104\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00102R\u0014\u00105\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00102R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010,R\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010,R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R*\u0010?\u001a\u0002062\u0006\u0010>\u001a\u0002068\u0000@@X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u00108\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0014\u0010E\u001a\u0002068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010A¨\u0006F"}, d2 = {"Lcom/stepos/widget/tabbar/StepOSCollapsibleGlassSurface;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LY8/t;", "requestGlassRefresh", "()V", "refreshGlass", "Landroid/graphics/Canvas;", "canvas", "", "color", "Landroid/graphics/Paint;", "layerPaint", "drawFill", "(Landroid/graphics/Canvas;ILandroid/graphics/Paint;)V", "onAttachedToWindow", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "", "cornerRadius", "F", "Landroid/graphics/drawable/Drawable;", "fallbackBackground", "Landroid/graphics/drawable/Drawable;", "fillWhite", "I", "fillBlack", "fillPlus", "fillLuminosity", "fillLighten", "fillPaint", "Landroid/graphics/Paint;", "plusPaint", "luminosityPaint", "lightenPaint", "", "refreshPosted", "Z", "lastWidth", "lastHeight", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", UxipConstants.f30680s, "isGlassEnabled", "isGlassEnabled$StepOSWidget_release", "()Z", "setGlassEnabled$StepOSWidget_release", "(Z)V", "isGlassActive$StepOSWidget_release", "isGlassActive", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class StepOSCollapsibleGlassSurface extends FrameLayout {
    private final float cornerRadius;
    private final Drawable fallbackBackground;
    private final int fillBlack;
    private final int fillLighten;
    private final int fillLuminosity;
    private final Paint fillPaint;
    private final int fillPlus;
    private final int fillWhite;
    private final GlassDelegate glassDelegate;
    private boolean isGlassEnabled;
    private int lastHeight;
    private int lastWidth;
    private final Paint lightenPaint;
    private final Paint luminosityPaint;
    private final Paint plusPaint;
    private boolean refreshPosted;
    private final Runnable refreshRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StepOSCollapsibleGlassSurface(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void drawFill(Canvas canvas, int color, Paint layerPaint) {
        int iSaveLayer;
        Canvas canvas2;
        if (Color.alpha(color) == 0) {
            return;
        }
        if (layerPaint == null) {
            iSaveLayer = canvas.save();
            canvas2 = canvas;
        } else {
            iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), layerPaint);
            canvas2 = canvas;
        }
        this.fillPaint.setColor(color);
        float fMin = Math.min(this.cornerRadius, Math.min(getWidth(), getHeight()) / 2.0f);
        canvas2.drawRoundRect(0.0f, 0.0f, getWidth(), getHeight(), fMin, fMin, this.fillPaint);
        canvas2.restoreToCount(iSaveLayer);
    }

    private final void refreshGlass() {
        super.setBackground(null);
        boolean zApply$StepOSWidget_release = false;
        if (!this.isGlassEnabled || getWidth() <= 0 || getHeight() <= 0 || getVisibility() != 0) {
            this.glassDelegate.release$StepOSWidget_release();
        } else {
            zApply$StepOSWidget_release = this.glassDelegate.apply$StepOSWidget_release(0, this.cornerRadius, getResources().getBoolean(R.bool.stepos_collapsible_tabbar_glass_light) ? y7.o.INSTANCE.j() : y7.o.INSTANCE.h());
        }
        if (!zApply$StepOSWidget_release) {
            super.setBackground(this.fallbackBackground);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$3(StepOSCollapsibleGlassSurface stepOSCollapsibleGlassSurface) {
        stepOSCollapsibleGlassSurface.refreshPosted = false;
        if (stepOSCollapsibleGlassSurface.isAttachedToWindow()) {
            stepOSCollapsibleGlassSurface.refreshGlass();
        }
    }

    private final void requestGlassRefresh() {
        if (isAttachedToWindow() && !this.refreshPosted) {
            this.refreshPosted = true;
            post(this.refreshRunnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.glassDelegate.getIsActive()) {
            drawFill(canvas, this.fillWhite, null);
            drawFill(canvas, this.fillBlack, null);
            drawFill(canvas, this.fillPlus, this.plusPaint);
            drawFill(canvas, this.fillLuminosity, this.luminosityPaint);
            drawFill(canvas, this.fillLighten, this.lightenPaint);
        }
        super.dispatchDraw(canvas);
    }

    public final boolean isGlassActive$StepOSWidget_release() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isGlassEnabled$StepOSWidget_release, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestGlassRefresh();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.glassDelegate.release$StepOSWidget_release();
        requestGlassRefresh();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.refreshRunnable);
        this.refreshPosted = false;
        this.glassDelegate.release$StepOSWidget_release();
        super.setBackground(this.fallbackBackground);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        invalidateOutline();
        if (w10 == this.lastWidth && h10 == this.lastHeight) {
            return;
        }
        this.lastWidth = w10;
        this.lastHeight = h10;
        requestGlassRefresh();
    }

    public final void setGlassEnabled$StepOSWidget_release(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        requestGlassRefresh();
    }

    public /* synthetic */ StepOSCollapsibleGlassSurface(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCollapsibleGlassSurface(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.cornerRadius = getResources().getDimension(R.dimen.stepos_collapsible_tabbar_surface_corner_radius);
        this.fallbackBackground = androidx.core.content.a.e(context, R.drawable.stepos_bg_collapsible_tabbar_surface);
        this.fillWhite = androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_glass_fill_white);
        this.fillBlack = androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_glass_fill_black);
        this.fillPlus = androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_glass_fill_plus);
        this.fillLuminosity = androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_glass_fill_luminosity);
        this.fillLighten = androidx.core.content.a.c(context, R.color.stepos_collapsible_tabbar_glass_fill_lighten);
        this.fillPaint = new Paint(1);
        Paint paint = new Paint();
        paint.setBlendMode(BlendMode.PLUS);
        this.plusPaint = paint;
        Paint paint2 = new Paint();
        paint2.setBlendMode(BlendMode.LUMINOSITY);
        this.luminosityPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setBlendMode(BlendMode.LIGHTEN);
        this.lightenPaint = paint3;
        this.refreshRunnable = new Runnable() { // from class: com.stepos.widget.tabbar.a
            @Override // java.lang.Runnable
            public final void run() {
                StepOSCollapsibleGlassSurface.refreshRunnable$lambda$3(this.f31362a);
            }
        };
        this.isGlassEnabled = true;
        setWillNotDraw(false);
        setClipToOutline(true);
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.stepos.widget.tabbar.StepOSCollapsibleGlassSurface.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), Math.min(StepOSCollapsibleGlassSurface.this.cornerRadius, Math.min(view.getWidth(), view.getHeight()) / 2.0f));
            }
        });
        setElevation(getResources().getDimension(R.dimen.stepos_collapsible_tabbar_shadow_elevation));
        super.setBackground(null);
    }
}
