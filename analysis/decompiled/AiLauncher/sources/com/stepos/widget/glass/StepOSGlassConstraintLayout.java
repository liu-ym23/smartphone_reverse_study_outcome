package com.stepos.widget.glass;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import java.util.Set;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001oB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0016\u0010\u0014J/\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0014¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0010H\u0014¢\u0006\u0004\b%\u0010\u0014J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\u00020\u00102\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010\u0014J\u0017\u00102\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020(2\u0006\u00105\u001a\u000204H\u0014¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0010H\u0014¢\u0006\u0004\b8\u0010\u0014J\u000f\u00109\u001a\u00020\u0010H\u0014¢\u0006\u0004\b9\u0010\u0014J\u000f\u0010:\u001a\u00020\u0010H\u0014¢\u0006\u0004\b:\u0010\u0014J\u000f\u0010;\u001a\u00020+H\u0014¢\u0006\u0004\b;\u0010<R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR*\u0010Q\u001a\u00020(2\u0006\u0010P\u001a\u00020(8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010G\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR,\u0010U\u001a\u00020+2\b\b\u0001\u0010P\u001a\u00020+8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010<\"\u0004\bX\u0010YR*\u0010Z\u001a\u00020(2\u0006\u0010P\u001a\u00020(8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010G\u001a\u0004\bZ\u0010R\"\u0004\b[\u0010TR\u0018\u0010\\\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R$\u0010c\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010\r\"\u0004\ba\u0010bR(\u0010h\u001a\u0004\u0018\u0001042\b\u0010P\u001a\u0004\u0018\u0001048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0011\u0010i\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bi\u0010RR\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020k0j8F¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006p"}, d2 = {"Lcom/stepos/widget/glass/StepOSGlassConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Ly7/o;", "defaultGlassEffectForTheme", "()Ly7/o;", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "LY8/t;", "applyCustomGlass", "(Lcom/stepos/widget/glass/GlassCustomizer;)V", "clearCustomGlass", "()V", "onAttachedToWindow", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "drawableStateChanged", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "x", "y", "drawableHotspotChanged", "(FF)V", "jumpDrawablesToCurrentState", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "requestGlassRefresh", "applyGlass", "releaseGlass", "effectiveRadius", "()F", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "manualLayers", "Lcom/stepos/widget/glass/ManualSurfaceLayers;", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "Lcom/stepos/widget/glass/StepOSGlassConstraintLayout$GlassRequest;", "appliedRequest", "Lcom/stepos/widget/glass/StepOSGlassConstraintLayout$GlassRequest;", "refreshPosted", "Z", "glassCustomizer", "Lcom/stepos/widget/glass/GlassCustomizer;", "Ljava/lang/Runnable;", "refreshRunnable", "Ljava/lang/Runnable;", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "glassRebuild", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", UxipConstants.f30680s, "isGlassEnabled", "()Z", "setGlassEnabled", "(Z)V", "glassCornerRadius", "F", "getGlassCornerRadius", "setGlassCornerRadius", "(F)V", "isGlassCrossWindow", "setGlassCrossWindow", "explicitGlassEffect", "Ly7/o;", "_surfaceDrawable", "Landroid/graphics/drawable/Drawable;", "getGlassEffect", "setGlassEffect", "(Ly7/o;)V", "glassEffect", "getSurfaceDrawable", "()Landroid/graphics/drawable/Drawable;", "setSurfaceDrawable", "(Landroid/graphics/drawable/Drawable;)V", "surfaceDrawable", "isGlassActive", "", "", "getGlassActiveIds", "()Ljava/util/Set;", "glassActiveIds", "GlassRequest", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSGlassConstraintLayout extends ConstraintLayout {
    private Drawable _surfaceDrawable;
    private GlassRequest appliedRequest;
    private y7.o explicitGlassEffect;
    private float glassCornerRadius;
    private GlassCustomizer glassCustomizer;
    private final GlassDelegate glassDelegate;
    private final GlassRebuildScheduler glassRebuild;
    private boolean isGlassCrossWindow;
    private boolean isGlassEnabled;
    private ManualSurfaceLayers manualLayers;
    private boolean refreshPosted;
    private final Runnable refreshRunnable;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JN\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0010J\u001a\u0010!\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0015R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u0019¨\u0006."}, d2 = {"Lcom/stepos/widget/glass/StepOSGlassConstraintLayout$GlassRequest;", "", "", "width", "height", "", "radius", "", "crossWindow", "Ly7/o;", "effect", "Lcom/stepos/widget/glass/GlassCustomizer;", "customizer", "<init>", "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)V", "component1", "()I", "component2", "component3", "()F", "component4", "()Z", "component5", "()Ly7/o;", "component6", "()Lcom/stepos/widget/glass/GlassCustomizer;", ChatTracker.CLICK_COPY, "(IIFZLy7/o;Lcom/stepos/widget/glass/GlassCustomizer;)Lcom/stepos/widget/glass/StepOSGlassConstraintLayout$GlassRequest;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getWidth", "getHeight", "F", "getRadius", "Z", "getCrossWindow", "Ly7/o;", "getEffect", "Lcom/stepos/widget/glass/GlassCustomizer;", "getCustomizer", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class GlassRequest {
        private final boolean crossWindow;
        private final GlassCustomizer customizer;
        private final y7.o effect;
        private final int height;
        private final float radius;
        private final int width;

        public GlassRequest(int i10, int i11, float f10, boolean z10, y7.o effect, GlassCustomizer glassCustomizer) {
            kotlin.jvm.internal.p.i(effect, "effect");
            this.width = i10;
            this.height = i11;
            this.radius = f10;
            this.crossWindow = z10;
            this.effect = effect;
            this.customizer = glassCustomizer;
        }

        public static /* synthetic */ GlassRequest copy$default(GlassRequest glassRequest, int i10, int i11, float f10, boolean z10, y7.o oVar, GlassCustomizer glassCustomizer, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = glassRequest.width;
            }
            if ((i12 & 2) != 0) {
                i11 = glassRequest.height;
            }
            if ((i12 & 4) != 0) {
                f10 = glassRequest.radius;
            }
            if ((i12 & 8) != 0) {
                z10 = glassRequest.crossWindow;
            }
            if ((i12 & 16) != 0) {
                oVar = glassRequest.effect;
            }
            if ((i12 & 32) != 0) {
                glassCustomizer = glassRequest.customizer;
            }
            y7.o oVar2 = oVar;
            GlassCustomizer glassCustomizer2 = glassCustomizer;
            return glassRequest.copy(i10, i11, f10, z10, oVar2, glassCustomizer2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component3, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCrossWindow() {
            return this.crossWindow;
        }

        /* renamed from: component5, reason: from getter */
        public final y7.o getEffect() {
            return this.effect;
        }

        /* renamed from: component6, reason: from getter */
        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final GlassRequest copy(int width, int height, float radius, boolean crossWindow, y7.o effect, GlassCustomizer customizer) {
            kotlin.jvm.internal.p.i(effect, "effect");
            return new GlassRequest(width, height, radius, crossWindow, effect, customizer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GlassRequest)) {
                return false;
            }
            GlassRequest glassRequest = (GlassRequest) other;
            return this.width == glassRequest.width && this.height == glassRequest.height && Float.compare(this.radius, glassRequest.radius) == 0 && this.crossWindow == glassRequest.crossWindow && kotlin.jvm.internal.p.d(this.effect, glassRequest.effect) && kotlin.jvm.internal.p.d(this.customizer, glassRequest.customizer);
        }

        public final boolean getCrossWindow() {
            return this.crossWindow;
        }

        public final GlassCustomizer getCustomizer() {
            return this.customizer;
        }

        public final y7.o getEffect() {
            return this.effect;
        }

        public final int getHeight() {
            return this.height;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            int iHashCode = ((((((((Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height)) * 31) + Float.hashCode(this.radius)) * 31) + Boolean.hashCode(this.crossWindow)) * 31) + this.effect.hashCode()) * 31;
            GlassCustomizer glassCustomizer = this.customizer;
            return iHashCode + (glassCustomizer == null ? 0 : glassCustomizer.hashCode());
        }

        public String toString() {
            return "GlassRequest(width=" + this.width + ", height=" + this.height + ", radius=" + this.radius + ", crossWindow=" + this.crossWindow + ", effect=" + this.effect + ", customizer=" + this.customizer + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassConstraintLayout(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final y7.B applyGlass$lambda$5(GlassCustomizer glassCustomizer, y7.B it) {
        kotlin.jvm.internal.p.i(it, "it");
        return glassCustomizer.customize(it);
    }

    private final y7.o defaultGlassEffectForTheme() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return GlassThemeKt.isVisuallyDark(context) ? y7.o.INSTANCE.i() : y7.o.INSTANCE.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t glassRebuild$lambda$1(StepOSGlassConstraintLayout stepOSGlassConstraintLayout) {
        stepOSGlassConstraintLayout.releaseGlass();
        stepOSGlassConstraintLayout.requestGlassRefresh();
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRunnable$lambda$0(StepOSGlassConstraintLayout stepOSGlassConstraintLayout) {
        stepOSGlassConstraintLayout.refreshPosted = false;
        if (stepOSGlassConstraintLayout.isAttachedToWindow()) {
            stepOSGlassConstraintLayout.applyGlass();
        }
    }

    public final void applyCustomGlass(GlassCustomizer customizer) {
        kotlin.jvm.internal.p.i(customizer, "customizer");
        this.glassCustomizer = customizer;
        releaseGlass();
        requestGlassRefresh();
    }

    public void applyGlass() {
        if (!this.isGlassEnabled || getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            releaseGlass();
            return;
        }
        float fEffectiveRadius = effectiveRadius();
        final GlassCustomizer glassCustomizer = this.glassCustomizer;
        GlassRequest glassRequest = new GlassRequest(getWidth(), getHeight(), fEffectiveRadius, this.isGlassCrossWindow, getGlassEffect(), glassCustomizer);
        if (kotlin.jvm.internal.p.d(this.appliedRequest, glassRequest)) {
            return;
        }
        boolean z10 = this.isGlassCrossWindow;
        if (glassCustomizer != null) {
            this.glassDelegate.applyCustom$StepOSWidget_release(z10 ? 1 : 0, fEffectiveRadius, new InterfaceC5074l() { // from class: com.stepos.widget.glass.i
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return StepOSGlassConstraintLayout.applyGlass$lambda$5(glassCustomizer, (y7.B) obj);
                }
            });
        } else {
            this.glassDelegate.apply$StepOSWidget_release(z10 ? 1 : 0, fEffectiveRadius, getGlassEffect());
        }
        this.appliedRequest = glassRequest;
        invalidate();
    }

    public final void clearCustomGlass() {
        if (this.glassCustomizer == null) {
            return;
        }
        this.glassCustomizer = null;
        releaseGlass();
        requestGlassRefresh();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int actionMasked;
        kotlin.jvm.internal.p.i(ev, "ev");
        if (getForeground() != null && ((actionMasked = ev.getActionMasked()) == 0 || actionMasked == 2)) {
            drawableHotspotChanged(ev.getX(), ev.getY());
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float x10, float y10) {
        super.drawableHotspotChanged(x10, y10);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.hotspotChanged(x10, y10);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers == null || !manualSurfaceLayers.stateChanged()) {
            return;
        }
        invalidate();
    }

    public float effectiveRadius() {
        float f10 = this.glassCornerRadius;
        return f10 > 0.0f ? f10 : Math.min(getWidth(), getHeight()) / 2.0f;
    }

    public final Set<String> getGlassActiveIds() {
        return Z8.F.r1(this.glassDelegate.getActiveIds$StepOSWidget_release());
    }

    public final float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public final y7.o getGlassEffect() {
        y7.o oVar = this.explicitGlassEffect;
        return oVar == null ? defaultGlassEffectForTheme() : oVar;
    }

    /* renamed from: getSurfaceDrawable, reason: from getter */
    public final Drawable get_surfaceDrawable() {
        return this._surfaceDrawable;
    }

    public final boolean isGlassActive() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isGlassCrossWindow, reason: from getter */
    public final boolean getIsGlassCrossWindow() {
        return this.isGlassCrossWindow;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.jumpToCurrentState();
        }
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
        this.glassRebuild.onConfigurationChanged$StepOSWidget_release(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.refreshRunnable);
        this.refreshPosted = false;
        this.glassRebuild.cancel$StepOSWidget_release();
        releaseGlass();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        ManualSurfaceLayers manualSurfaceLayers;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (!this.glassDelegate.getIsActive() && (manualSurfaceLayers = this.manualLayers) != null) {
            manualSurfaceLayers.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.updateLayoutDirection(layoutDirection);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        requestGlassRefresh();
    }

    public void releaseGlass() {
        this.glassDelegate.release$StepOSWidget_release();
        this.appliedRequest = null;
        invalidate();
    }

    public void requestGlassRefresh() {
        if (this.isGlassEnabled && isAttachedToWindow() && !this.refreshPosted) {
            this.refreshPosted = true;
            post(this.refreshRunnable);
        }
    }

    public final void setGlassCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.glassCornerRadius == f10) {
            return;
        }
        this.glassCornerRadius = f10;
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setGlassCrossWindow(boolean z10) {
        if (this.isGlassCrossWindow == z10) {
            return;
        }
        this.isGlassCrossWindow = z10;
        releaseGlass();
        requestGlassRefresh();
    }

    public final void setGlassEffect(y7.o value) {
        kotlin.jvm.internal.p.i(value, "value");
        boolean z10 = this.glassCustomizer != null;
        this.glassCustomizer = null;
        if (!kotlin.jvm.internal.p.d(this.explicitGlassEffect, value) || z10) {
            this.explicitGlassEffect = value;
            releaseGlass();
            requestGlassRefresh();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        if (z10) {
            requestGlassRefresh();
        } else {
            releaseGlass();
        }
    }

    public final void setSurfaceDrawable(Drawable drawable) {
        this._surfaceDrawable = drawable;
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        if (manualSurfaceLayers != null) {
            manualSurfaceLayers.setSurface(drawable);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        kotlin.jvm.internal.p.i(who, "who");
        ManualSurfaceLayers manualSurfaceLayers = this.manualLayers;
        return (manualSurfaceLayers != null && manualSurfaceLayers.verify(who)) || super.verifyDrawable(who);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSGlassConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposGlassConstraintLayoutStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_GlassConstraintLayout : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSGlassConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.refreshRunnable = new Runnable() { // from class: com.stepos.widget.glass.g
            @Override // java.lang.Runnable
            public final void run() {
                StepOSGlassConstraintLayout.refreshRunnable$lambda$0(this.f31228a);
            }
        };
        this.glassRebuild = new GlassRebuildScheduler(this, new InterfaceC5063a() { // from class: com.stepos.widget.glass.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSGlassConstraintLayout.glassRebuild$lambda$1(this.f31230a);
            }
        });
        this.isGlassEnabled = true;
        this.manualLayers = new ManualSurfaceLayers(this);
        setBackground(null);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSGlassConstraintLayout, i10, i11);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        y7.o oVar = GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSGlassConstraintLayout_steposGlassEffect);
        if (oVar != null) {
            setGlassEffect(oVar);
        }
        setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGlassConstraintLayout_steposGlassEnabled, true));
        setGlassCrossWindow(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGlassConstraintLayout_steposGlassCrossWindow, false));
        Y8.t tVar = Y8.t.f7040a;
        typedArrayObtainStyledAttributes.recycle();
    }
}
