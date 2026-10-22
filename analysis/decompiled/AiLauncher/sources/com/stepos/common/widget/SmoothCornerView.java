package com.stepos.common.widget;

import O6.u;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$styleable;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 h2\u00020\u0001:\u0002ijB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u000f\u0010\u001b\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u0017J#\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 R$\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010*\u001a\u00020)2\u0006\u0010\"\u001a\u00020)8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020)2\u0006\u0010\"\u001a\u00020)8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b.\u0010+\"\u0004\b/\u0010-R*\u00100\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010(\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u00106\u001a\u0002052\u0006\u0010\"\u001a\u0002058F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010=\u001a\u0004\u0018\u00010<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010(R*\u0010@\u001a\u00020)2\u0006\u0010\"\u001a\u00020)8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010+\u001a\u0004\bA\u0010B\"\u0004\bC\u0010-R*\u0010D\u001a\u00020)2\u0006\u0010\"\u001a\u00020)8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010+\u001a\u0004\bE\u0010B\"\u0004\bF\u0010-R*\u0010G\u001a\u00020)2\u0006\u0010\"\u001a\u00020)8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010+\u001a\u0004\bH\u0010B\"\u0004\bI\u0010-R*\u0010J\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0017\u0010Q\u001a\u00020P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR*\u0010U\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010(\u001a\u0004\bV\u00102\"\u0004\bW\u00104R\"\u0010X\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010+\u001a\u0004\bY\u0010B\"\u0004\bZ\u0010-R\u0017\u0010\\\u001a\u00020[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R$\u0010b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u00102\"\u0004\ba\u00104R\u0011\u0010d\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\bc\u0010BR$\u0010g\u001a\u00020)2\u0006\u0010\"\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\be\u0010B\"\u0004\bf\u0010-¨\u0006k"}, d2 = {"Lcom/stepos/common/widget/SmoothCornerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "draw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "c", "e", Const.INTENT_KEY_UMID, "", "useNativeRoundCornerWhileParamsInvalid", "force", "f", "(ZZ)V", "Landroid/graphics/Path;", UxipConstants.f30680s, "path", "Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "needRegenPath", "Z", "", "widthFloat", "F", "setWidthFloat", "(F)V", "heightFloat", "setHeightFloat", "smoothCornerEnable", "getSmoothCornerEnable", "()Z", "setSmoothCornerEnable", "(Z)V", "Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "renderMode", "Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "getRenderMode", "()Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "setRenderMode", "(Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;)V", "Landroid/view/ViewOutlineProvider;", "defaultOutlineProvider", "Landroid/view/ViewOutlineProvider;", "defaultClipToOutline", "smoothness", "getSmoothness", "()F", "setSmoothness", "radius", "getRadius", "setRadius", "strokeWidthExt", "getStrokeWidthExt", "setStrokeWidthExt", "strokeColor", "I", "getStrokeColor", "()I", "setStrokeColor", "(I)V", "Landroid/graphics/Paint;", "strokePaint", "Landroid/graphics/Paint;", "getStrokePaint", "()Landroid/graphics/Paint;", "autoFitRadius", "getAutoFitRadius", "setAutoFitRadius", "radiusRatio", "getRadiusRatio", "setRadiusRatio", "Landroid/database/ContentObserver;", "mContentObserver", "Landroid/database/ContentObserver;", "getMContentObserver", "()Landroid/database/ContentObserver;", "getExactMode", "setExactMode", "exactMode", "getMaxSmoothRadius", "maxSmoothRadius", "getRadiusDp", "setRadiusDp", "radiusDp", "Companion", Const.INTENT_KEY_APIKEY, "SmoothGenMode", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public class SmoothCornerView extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean autoFitRadius;
    private final boolean defaultClipToOutline;
    private final ViewOutlineProvider defaultOutlineProvider;
    private float heightFloat;
    private final ContentObserver mContentObserver;
    private boolean needRegenPath;
    private Path path;
    private float radius;
    private float radiusRatio;
    private SmoothGenMode renderMode;
    private boolean smoothCornerEnable;
    private float smoothness;
    private int strokeColor;
    private final Paint strokePaint;
    private float strokeWidthExt;
    private float widthFloat;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/common/widget/SmoothCornerView$SmoothGenMode;", "", "(Ljava/lang/String;I)V", "ClipPath", "ClearPixel", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum SmoothGenMode {
        ClipPath,
        ClearPixel
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\tR\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/common/widget/SmoothCornerView$a;", "", "<init>", "()V", "Landroid/content/Context;", "", "pxValue", "density", Const.INTENT_KEY_UMID, "(Landroid/content/Context;FF)F", "dpValue", Const.INTENT_KEY_APIKEY, "c", "(Landroid/content/Context;)F", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.stepos.common.widget.SmoothCornerView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ float b(Companion companion, Context context, float f10, float f11, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                f11 = companion.c(context);
            }
            return companion.a(context, f10, f11);
        }

        public static /* synthetic */ float e(Companion companion, Context context, float f10, float f11, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                f11 = companion.c(context);
            }
            return companion.d(context, f10, f11);
        }

        public final float a(Context context, float f10, float f11) {
            p.i(context, "<this>");
            return f10 * f11;
        }

        public final float c(Context context) {
            p.i(context, "<this>");
            return context.getResources().getDisplayMetrics().density;
        }

        public final float d(Context context, float f10, float f11) {
            p.i(context, "<this>");
            return f10 / f11;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SmoothGenMode.values().length];
            try {
                iArr[SmoothGenMode.ClipPath.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SmoothGenMode.ClearPixel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/common/widget/SmoothCornerView$c", "Landroid/database/ContentObserver;", "", "selfChange", "LY8/t;", "onChange", "(Z)V", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends ContentObserver {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, Handler handler) {
            super(handler);
            this.$context = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            SmoothCornerView.this.setRadiusRatio(O6.c.a(this.$context));
            SmoothCornerView.this.needRegenPath = true;
            SmoothCornerView.this.invalidate();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/common/widget/SmoothCornerView$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "StepOSCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends ViewOutlineProvider {
        public d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            p.i(view, "view");
            p.i(outline, "outline");
            SmoothCornerView smoothCornerView = SmoothCornerView.this;
            SmoothCornerView.g(smoothCornerView, smoothCornerView.getAutoFitRadius(), false, 2, null);
            outline.setPath(SmoothCornerView.this.path);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    public static /* synthetic */ void g(SmoothCornerView smoothCornerView, boolean z10, boolean z11, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trySmoothPath");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        smoothCornerView.f(z10, z11);
    }

    private final void setHeightFloat(float f10) {
        if (this.heightFloat == f10) {
            return;
        }
        this.heightFloat = f10;
        this.needRegenPath = true;
    }

    private final void setPath(Path path) {
        this.path = path;
        c();
    }

    private final void setWidthFloat(float f10) {
        if (this.widthFloat == f10) {
            return;
        }
        this.widthFloat = f10;
        this.needRegenPath = true;
    }

    public final void c() {
        int i10 = b.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i10 == 1) {
            this.path.setFillType(Path.FillType.WINDING);
        } else {
            if (i10 != 2) {
                return;
            }
            this.path.setFillType(Path.FillType.INVERSE_WINDING);
        }
    }

    public final void d() {
        int i10 = b.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i10 == 1) {
            invalidateOutline();
        } else {
            if (i10 != 2) {
                return;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        p.i(canvas, "canvas");
        if (!this.smoothCornerEnable) {
            super.draw(canvas);
            return;
        }
        super.draw(canvas);
        if (getRenderMode() == SmoothGenMode.ClearPixel) {
            float fMin = this.autoFitRadius ? this.radiusRatio * Math.min(this.widthFloat, this.heightFloat) : getRadius();
            f(this.autoFitRadius, false);
            canvas.drawPath(this.path, u.INSTANCE.c());
            float f10 = 2;
            Path pathA = u.a((this.strokePaint.getStrokeWidth() / f10) + 0.0f, (this.strokePaint.getStrokeWidth() / f10) + 0.0f, this.widthFloat - (this.strokePaint.getStrokeWidth() / f10), this.heightFloat - (this.strokePaint.getStrokeWidth() / f10), this.smoothness, fMin - (this.strokePaint.getStrokeWidth() / f10), this.autoFitRadius);
            pathA.setFillType(Path.FillType.WINDING);
            canvas.drawPath(pathA, this.strokePaint);
        }
    }

    public final void e() {
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor(O6.c.CURRENT_LAUNCHER_ICON_CORNER_SIZE_KEY), false, this.mContentObserver);
    }

    public final void f(boolean useNativeRoundCornerWhileParamsInvalid, boolean force) {
        if (this.needRegenPath || force) {
            setPath(u.a(0.0f, 0.0f, this.widthFloat, this.heightFloat, this.smoothness, this.autoFitRadius ? this.radiusRatio * Math.min(this.widthFloat, this.heightFloat) : getRadius(), useNativeRoundCornerWhileParamsInvalid));
            this.needRegenPath = false;
        }
    }

    public final boolean getAutoFitRadius() {
        return this.autoFitRadius;
    }

    public final boolean getExactMode() {
        return getLayerType() == 2;
    }

    public final ContentObserver getMContentObserver() {
        return this.mContentObserver;
    }

    public final float getMaxSmoothRadius() {
        return u.INSTANCE.e(this.widthFloat, this.heightFloat, this.smoothness);
    }

    public final float getRadius() {
        return C5685n.m(this.radius, 0.0f, getMaxSmoothRadius());
    }

    public final float getRadiusDp() {
        Companion companion = INSTANCE;
        Context context = getContext();
        p.h(context, "context");
        return Companion.e(companion, context, getRadius(), 0.0f, 2, null);
    }

    public final float getRadiusRatio() {
        return this.radiusRatio;
    }

    public final SmoothGenMode getRenderMode() {
        return this.strokePaint.getStrokeWidth() > 0.0f ? SmoothGenMode.ClearPixel : this.renderMode;
    }

    public final boolean getSmoothCornerEnable() {
        return this.smoothCornerEnable;
    }

    public final float getSmoothness() {
        return this.smoothness;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final Paint getStrokePaint() {
        return this.strokePaint;
    }

    public final float getStrokeWidthExt() {
        return this.strokeWidthExt;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().getContentResolver().unregisterContentObserver(this.mContentObserver);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        setWidthFloat(w10);
        setHeightFloat(h10);
        if (getRenderMode() == SmoothGenMode.ClearPixel) {
            g(this, this.autoFitRadius, false, 2, null);
        }
    }

    public final void setAutoFitRadius(boolean z10) {
        if (z10 != this.autoFitRadius) {
            this.autoFitRadius = z10;
            d();
        }
    }

    public final void setExactMode(boolean z10) {
        if (z10) {
            setLayerType(2, null);
        } else {
            setLayerType(0, null);
        }
    }

    public final void setRadius(float f10) {
        if (f10 == this.radius) {
            return;
        }
        this.needRegenPath = true;
        this.radius = f10;
        d();
    }

    public final void setRadiusDp(float f10) {
        Companion companion = INSTANCE;
        Context context = getContext();
        p.h(context, "context");
        setRadius(Companion.b(companion, context, f10, 0.0f, 2, null));
    }

    public final void setRadiusRatio(float f10) {
        this.radiusRatio = f10;
    }

    public final void setRenderMode(SmoothGenMode value) {
        p.i(value, "value");
        this.renderMode = value;
        int i10 = b.$EnumSwitchMapping$0[getRenderMode().ordinal()];
        if (i10 == 1) {
            setClipToOutline(true);
            setOutlineProvider(new d());
        } else if (i10 == 2) {
            setWillNotDraw(false);
            setClipToOutline(this.defaultClipToOutline);
            setOutlineProvider(this.defaultOutlineProvider);
        }
        c();
        f(this.autoFitRadius, true);
        invalidate();
        invalidateOutline();
    }

    public final void setSmoothCornerEnable(boolean z10) {
        if (this.smoothCornerEnable != z10) {
            this.smoothCornerEnable = z10;
            this.needRegenPath = true;
            invalidate();
        }
    }

    public final void setSmoothness(float f10) {
        float fM = C5685n.m(f10, 0.0f, 1.0f);
        if (fM == this.smoothness) {
            return;
        }
        this.needRegenPath = true;
        this.smoothness = fM;
        d();
    }

    public final void setStrokeColor(int i10) {
        if (i10 != this.strokeColor) {
            this.strokeColor = i10;
            this.strokePaint.setColor(i10);
            d();
        }
    }

    public final void setStrokeWidthExt(float f10) {
        if (f10 == this.strokeWidthExt) {
            return;
        }
        this.strokeWidthExt = f10;
        this.strokePaint.setStrokeWidth(f10);
        d();
    }

    public /* synthetic */ SmoothCornerView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothCornerView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.path = new Path();
        this.smoothCornerEnable = true;
        this.renderMode = SmoothGenMode.ClearPixel;
        this.defaultOutlineProvider = getOutlineProvider();
        this.defaultClipToOutline = getClipToOutline();
        int[] iArr = R$styleable.SmoothCornerView;
        this.smoothness = context.obtainStyledAttributes(attributeSet, iArr, i10, i11).getFloat(R$styleable.SmoothCornerView_steposCornerSmoothness, 0.2f);
        this.radius = context.obtainStyledAttributes(attributeSet, iArr, i10, i11).getDimension(R$styleable.SmoothCornerView_steposCornerRadius, getResources().getDimension(R$dimen.fd_sys_radius_corner_none));
        this.strokeWidthExt = context.obtainStyledAttributes(attributeSet, iArr, i10, i11).getDimension(R$styleable.SmoothCornerView_steposCornerStrokeWidth, 0.0f);
        this.strokeColor = context.obtainStyledAttributes(attributeSet, iArr, i10, i11).getColor(R$styleable.SmoothCornerView_steposCornerStrokeColor, getResources().getColor(R$color.fd_sys_color_outline_variant_default));
        Paint paint = new Paint();
        paint.setStrokeWidth(this.strokeWidthExt);
        paint.setColor(this.strokeColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.strokePaint = paint;
        this.autoFitRadius = context.obtainStyledAttributes(attributeSet, iArr, i10, i11).getBoolean(R$styleable.SmoothCornerView_steposAutoFitRadius, false);
        this.mContentObserver = new c(context, getHandler());
        setRenderMode(SmoothGenMode.ClipPath);
        setExactMode(true);
        this.radiusRatio = O6.c.a(context);
    }
}
