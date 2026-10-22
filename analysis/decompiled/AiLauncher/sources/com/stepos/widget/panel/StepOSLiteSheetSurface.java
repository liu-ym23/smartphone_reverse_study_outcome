package com.stepos.widget.panel;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.widget.R;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J-\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u000fH\u0014¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\u000fH\u0014¢\u0006\u0004\b&\u0010\u0011J\r\u0010'\u001a\u00020\u000f¢\u0006\u0004\b'\u0010\u0011R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetSurface;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "glassAppearance", "Lcom/stepos/widget/panel/StepOSLiteSheetGlassStyle;", "loadStyle", "(I)Lcom/stepos/widget/panel/StepOSLiteSheetGlassStyle;", "resourcesFor", "(I)Landroid/content/Context;", "LY8/t;", "syncGlass", "()V", "rebuildClip", "", "position", "cornerRadius", "", "glassEnabled", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "(FFZI)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "dispatchDraw", "onAttachedToWindow", "onDetachedFromWindow", "release", "Lcom/stepos/widget/panel/StepOSLiteSheetGlass;", GlassAttachment.GPU_KIND, "Lcom/stepos/widget/panel/StepOSLiteSheetGlass;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "appearance", "I", "glassStyle", "Lcom/stepos/widget/panel/StepOSLiteSheetGlassStyle;", "Landroid/graphics/Path;", "clip", "Landroid/graphics/Path;", "Landroid/graphics/RectF;", "bounds", "Landroid/graphics/RectF;", "", "radii", "[F", "radius", "F", "expansion", x5.d.EXTRA_ENABLED, "Z", "surfaceDirty", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "syncBeforeDraw", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetSurface extends FrameLayout {
    private int appearance;
    private final RectF bounds;
    private final Path clip;
    private boolean enabled;
    private float expansion;
    private final StepOSLiteSheetGlass glass;
    private StepOSLiteSheetGlassStyle glassStyle;
    private final Paint paint;
    private final float[] radii;
    private float radius;
    private boolean surfaceDirty;
    private final ViewTreeObserver.OnPreDrawListener syncBeforeDraw;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StepOSLiteSheetSurface(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final StepOSLiteSheetGlassStyle loadStyle(int glassAppearance) {
        Context contextResourcesFor = resourcesFor(glassAppearance);
        this.paint.setColor(androidx.core.content.a.c(contextResourcesFor, R.color.stepos_lite_sheet_background));
        Resources resources = contextResourcesFor.getResources();
        return new StepOSLiteSheetGlassStyle(resources.getInteger(R.integer.stepos_lite_sheet_blur_radius), resources.getInteger(R.integer.stepos_lite_sheet_expanded_blur_radius), this.paint.getColor(), resources.getFraction(R.fraction.stepos_lite_sheet_glass_tint_alpha, 1, 1), resources.getFraction(R.fraction.stepos_lite_sheet_expanded_glass_tint_alpha, 1, 1));
    }

    private final void rebuildClip() {
        int i10;
        this.bounds.set(0.0f, 0.0f, getWidth(), getHeight());
        int i11 = 0;
        while (true) {
            if (i11 >= 4) {
                break;
            }
            this.radii[i11] = this.radius;
            i11++;
        }
        for (i10 = 4; i10 < 8; i10++) {
            this.radii[i10] = this.radius * (1.0f - this.expansion);
        }
        this.clip.reset();
        this.clip.addRoundRect(this.bounds, this.radii, Path.Direction.CW);
    }

    private final Context resourcesFor(int glassAppearance) {
        if (glassAppearance == 0) {
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            return context;
        }
        Configuration configuration = new Configuration(getResources().getConfiguration());
        configuration.uiMode = (glassAppearance == 2 ? 32 : 16) | (configuration.uiMode & (-49));
        Context contextCreateConfigurationContext = getContext().createConfigurationContext(configuration);
        kotlin.jvm.internal.p.h(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean syncBeforeDraw$lambda$1(StepOSLiteSheetSurface stepOSLiteSheetSurface) {
        if (!stepOSLiteSheetSurface.surfaceDirty) {
            return true;
        }
        stepOSLiteSheetSurface.surfaceDirty = false;
        stepOSLiteSheetSurface.rebuildClip();
        stepOSLiteSheetSurface.syncGlass();
        return true;
    }

    private final void syncGlass() {
        if (!this.enabled || !isAttachedToWindow() || getWidth() <= 0 || getHeight() <= 0) {
            this.glass.release();
            return;
        }
        StepOSLiteSheetGlass stepOSLiteSheetGlass = this.glass;
        float f10 = this.radius;
        float f11 = this.expansion;
        stepOSLiteSheetGlass.update(f10, (1.0f - f11) * f10, this.glassStyle.blurRadius(f11), this.glassStyle.tintColor(this.expansion));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        int iSave = canvas.save();
        canvas.clipPath(this.clip);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.surfaceDirty = true;
        getViewTreeObserver().addOnPreDrawListener(this.syncBeforeDraw);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getViewTreeObserver().removeOnPreDrawListener(this.syncBeforeDraw);
        release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        super.onDraw(canvas);
        if (this.glass.isActive()) {
            return;
        }
        canvas.drawPath(this.clip, this.paint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.surfaceDirty = true;
    }

    public final void release() {
        this.surfaceDirty = false;
        this.glass.release();
    }

    public final void update(float position, float cornerRadius, boolean glassEnabled, int glassAppearance) {
        float fM = 1.0f - C5685n.m(position, 0.0f, 1.0f);
        boolean z10 = this.appearance != glassAppearance;
        if (!z10 && this.expansion == fM && this.radius == cornerRadius && this.enabled == glassEnabled) {
            return;
        }
        if (z10) {
            this.appearance = glassAppearance;
            this.glassStyle = loadStyle(glassAppearance);
        }
        this.expansion = fM;
        this.radius = cornerRadius;
        this.enabled = glassEnabled;
        this.surfaceDirty = true;
        invalidate();
    }

    public /* synthetic */ StepOSLiteSheetSurface(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLiteSheetSurface(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.glass = new StepOSLiteSheetGlass(this);
        Paint paint = new Paint(1);
        paint.setColor(androidx.core.content.a.c(context, R.color.stepos_lite_sheet_background));
        this.paint = paint;
        this.glassStyle = loadStyle(this.appearance);
        this.clip = new Path();
        this.bounds = new RectF();
        this.radii = new float[8];
        this.radius = getResources().getDimension(R.dimen.stepos_lite_sheet_corner_radius);
        this.enabled = true;
        this.surfaceDirty = true;
        this.syncBeforeDraw = new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.widget.panel.s
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return StepOSLiteSheetSurface.syncBeforeDraw$lambda$1(this.f31300a);
            }
        };
        setWillNotDraw(false);
        setClickable(true);
    }
}
