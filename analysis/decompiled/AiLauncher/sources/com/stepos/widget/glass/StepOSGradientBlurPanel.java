package com.stepos.widget.glass;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.StepOSGlassPanel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b)\u0018\u0000 V2\u00020\u0001:\u0002WVB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0016\u0010\rJ\u000f\u0010\u0017\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u0019\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R*\u0010+\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R*\u00100\u001a\u00020/2\u0006\u0010*\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00106\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u001aR*\u0010;\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00107\u001a\u0004\b<\u00109\"\u0004\b=\u0010\u001aR*\u0010>\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00107\u001a\u0004\b?\u00109\"\u0004\b@\u0010\u001aR*\u0010A\u001a\u00020/2\u0006\u0010*\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bA\u00101\u001a\u0004\bB\u00103\"\u0004\bC\u00105R*\u0010D\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010 \u001a\u0004\bD\u0010,\"\u0004\bE\u0010.R,\u0010F\u001a\u00020\u00062\b\b\u0001\u0010*\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00107\u001a\u0004\bG\u00109\"\u0004\bH\u0010\u001aR,\u0010I\u001a\u00020\u00062\b\b\u0001\u0010*\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u00109\"\u0004\bK\u0010\u001aR,\u0010L\u001a\u00020\u00062\b\b\u0001\u0010*\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bL\u00107\u001a\u0004\bM\u00109\"\u0004\bN\u0010\u001aR*\u0010O\u001a\u00020/2\u0006\u0010*\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u00101\u001a\u0004\bP\u00103\"\u0004\bQ\u00105R*\u0010R\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u00107\u001a\u0004\bS\u00109\"\u0004\bT\u0010\u001aR\u0011\u0010U\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bU\u0010,¨\u0006X"}, d2 = {"Lcom/stepos/widget/glass/StepOSGradientBlurPanel;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "refreshBlur", "()V", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "onDetachedFromWindow", "resId", "setScrimStartColorResource", "(I)V", "setScrimMiddleColorResource", "setScrimEndColorResource", "setBlurRadiusResource", "", "internalWrite", "Z", "constructed", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "fallbackBackground", "Landroid/graphics/drawable/Drawable;", "Lcom/stepos/widget/glass/StepOSGradientBlurPanel$AppliedBlurParams;", "appliedParams", "Lcom/stepos/widget/glass/StepOSGradientBlurPanel$AppliedBlurParams;", UxipConstants.f30680s, "isBlurEnabled", "()Z", "setBlurEnabled", "(Z)V", "", "blurRadius", "F", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "blurDirection", "I", "getBlurDirection", "()I", "setBlurDirection", "blurScale", "getBlurScale", "setBlurScale", "blurScope", "getBlurScope", "setBlurScope", "blurCornerRadius", "getBlurCornerRadius", "setBlurCornerRadius", "isScrimEnabled", "setScrimEnabled", "scrimStartColor", "getScrimStartColor", "setScrimStartColor", "scrimMiddleColor", "getScrimMiddleColor", "setScrimMiddleColor", "scrimEndColor", "getScrimEndColor", "setScrimEndColor", "scrimMidpoint", "getScrimMidpoint", "setScrimMidpoint", "scrimDirection", "getScrimDirection", "setScrimDirection", "isBlurActive", "Companion", "AppliedBlurParams", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSGradientBlurPanel extends FrameLayout {
    private static final String TAG = "StepOSGradientBlurPanel";
    private AppliedBlurParams appliedParams;
    private float blurCornerRadius;
    private int blurDirection;
    private float blurRadius;
    private int blurScale;
    private int blurScope;
    private boolean constructed;
    private Drawable fallbackBackground;
    private final GlassDelegate glassDelegate;
    private boolean internalWrite;
    private boolean isBlurEnabled;
    private boolean isScrimEnabled;
    private int scrimDirection;
    private int scrimEndColor;
    private int scrimMiddleColor;
    private float scrimMidpoint;
    private int scrimStartColor;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0005\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003Jm\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u00052\b\b\u0003\u0010\u000b\u001a\u00020\u00052\b\b\u0003\u0010\f\u001a\u00020\u00052\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006."}, d2 = {"Lcom/stepos/widget/glass/StepOSGradientBlurPanel$AppliedBlurParams;", "", "radius", "", "direction", "", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "scope", "scrimEnabled", "", "scrimStartColor", "scrimMiddleColor", "scrimEndColor", "scrimMidpoint", "scrimDirection", "<init>", "(FIIIZIIIFI)V", "getRadius", "()F", "getDirection", "()I", "getScale", "getScope", "getScrimEnabled", "()Z", "getScrimStartColor", "getScrimMiddleColor", "getScrimEndColor", "getScrimMidpoint", "getScrimDirection", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class AppliedBlurParams {
        private final int direction;
        private final float radius;
        private final int scale;
        private final int scope;
        private final int scrimDirection;
        private final boolean scrimEnabled;
        private final int scrimEndColor;
        private final int scrimMiddleColor;
        private final float scrimMidpoint;
        private final int scrimStartColor;

        public AppliedBlurParams(float f10, int i10, int i11, int i12, boolean z10, int i13, int i14, int i15, float f11, int i16) {
            this.radius = f10;
            this.direction = i10;
            this.scale = i11;
            this.scope = i12;
            this.scrimEnabled = z10;
            this.scrimStartColor = i13;
            this.scrimMiddleColor = i14;
            this.scrimEndColor = i15;
            this.scrimMidpoint = f11;
            this.scrimDirection = i16;
        }

        public static /* synthetic */ AppliedBlurParams copy$default(AppliedBlurParams appliedBlurParams, float f10, int i10, int i11, int i12, boolean z10, int i13, int i14, int i15, float f11, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                f10 = appliedBlurParams.radius;
            }
            if ((i17 & 2) != 0) {
                i10 = appliedBlurParams.direction;
            }
            if ((i17 & 4) != 0) {
                i11 = appliedBlurParams.scale;
            }
            if ((i17 & 8) != 0) {
                i12 = appliedBlurParams.scope;
            }
            if ((i17 & 16) != 0) {
                z10 = appliedBlurParams.scrimEnabled;
            }
            if ((i17 & 32) != 0) {
                i13 = appliedBlurParams.scrimStartColor;
            }
            if ((i17 & 64) != 0) {
                i14 = appliedBlurParams.scrimMiddleColor;
            }
            if ((i17 & 128) != 0) {
                i15 = appliedBlurParams.scrimEndColor;
            }
            if ((i17 & 256) != 0) {
                f11 = appliedBlurParams.scrimMidpoint;
            }
            if ((i17 & 512) != 0) {
                i16 = appliedBlurParams.scrimDirection;
            }
            float f12 = f11;
            int i18 = i16;
            int i19 = i14;
            int i20 = i15;
            boolean z11 = z10;
            int i21 = i13;
            return appliedBlurParams.copy(f10, i10, i11, i12, z11, i21, i19, i20, f12, i18);
        }

        /* renamed from: component1, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* renamed from: component10, reason: from getter */
        public final int getScrimDirection() {
            return this.scrimDirection;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDirection() {
            return this.direction;
        }

        /* renamed from: component3, reason: from getter */
        public final int getScale() {
            return this.scale;
        }

        /* renamed from: component4, reason: from getter */
        public final int getScope() {
            return this.scope;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getScrimEnabled() {
            return this.scrimEnabled;
        }

        /* renamed from: component6, reason: from getter */
        public final int getScrimStartColor() {
            return this.scrimStartColor;
        }

        /* renamed from: component7, reason: from getter */
        public final int getScrimMiddleColor() {
            return this.scrimMiddleColor;
        }

        /* renamed from: component8, reason: from getter */
        public final int getScrimEndColor() {
            return this.scrimEndColor;
        }

        /* renamed from: component9, reason: from getter */
        public final float getScrimMidpoint() {
            return this.scrimMidpoint;
        }

        public final AppliedBlurParams copy(float radius, int direction, int scale, int scope, boolean scrimEnabled, int scrimStartColor, int scrimMiddleColor, int scrimEndColor, float scrimMidpoint, int scrimDirection) {
            return new AppliedBlurParams(radius, direction, scale, scope, scrimEnabled, scrimStartColor, scrimMiddleColor, scrimEndColor, scrimMidpoint, scrimDirection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppliedBlurParams)) {
                return false;
            }
            AppliedBlurParams appliedBlurParams = (AppliedBlurParams) other;
            return Float.compare(this.radius, appliedBlurParams.radius) == 0 && this.direction == appliedBlurParams.direction && this.scale == appliedBlurParams.scale && this.scope == appliedBlurParams.scope && this.scrimEnabled == appliedBlurParams.scrimEnabled && this.scrimStartColor == appliedBlurParams.scrimStartColor && this.scrimMiddleColor == appliedBlurParams.scrimMiddleColor && this.scrimEndColor == appliedBlurParams.scrimEndColor && Float.compare(this.scrimMidpoint, appliedBlurParams.scrimMidpoint) == 0 && this.scrimDirection == appliedBlurParams.scrimDirection;
        }

        public final int getDirection() {
            return this.direction;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final int getScale() {
            return this.scale;
        }

        public final int getScope() {
            return this.scope;
        }

        public final int getScrimDirection() {
            return this.scrimDirection;
        }

        public final boolean getScrimEnabled() {
            return this.scrimEnabled;
        }

        public final int getScrimEndColor() {
            return this.scrimEndColor;
        }

        public final int getScrimMiddleColor() {
            return this.scrimMiddleColor;
        }

        public final float getScrimMidpoint() {
            return this.scrimMidpoint;
        }

        public final int getScrimStartColor() {
            return this.scrimStartColor;
        }

        public int hashCode() {
            return (((((((((((((((((Float.hashCode(this.radius) * 31) + Integer.hashCode(this.direction)) * 31) + Integer.hashCode(this.scale)) * 31) + Integer.hashCode(this.scope)) * 31) + Boolean.hashCode(this.scrimEnabled)) * 31) + Integer.hashCode(this.scrimStartColor)) * 31) + Integer.hashCode(this.scrimMiddleColor)) * 31) + Integer.hashCode(this.scrimEndColor)) * 31) + Float.hashCode(this.scrimMidpoint)) * 31) + Integer.hashCode(this.scrimDirection);
        }

        public String toString() {
            return "AppliedBlurParams(radius=" + this.radius + ", direction=" + this.direction + ", scale=" + this.scale + ", scope=" + this.scope + ", scrimEnabled=" + this.scrimEnabled + ", scrimStartColor=" + this.scrimStartColor + ", scrimMiddleColor=" + this.scrimMiddleColor + ", scrimEndColor=" + this.scrimEndColor + ", scrimMidpoint=" + this.scrimMidpoint + ", scrimDirection=" + this.scrimDirection + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGradientBlurPanel(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final void refreshBlur() {
        if (!this.isBlurEnabled) {
            this.glassDelegate.cancelCover$StepOSWidget_release();
            this.internalWrite = true;
            try {
                this.glassDelegate.release$StepOSWidget_release();
                super.setBackground(this.fallbackBackground);
                this.internalWrite = false;
                this.appliedParams = null;
                return;
            } finally {
                this.internalWrite = false;
            }
        }
        if (isAttachedToWindow()) {
            if (getWidth() <= 0 || getHeight() <= 0) {
                post(new Runnable() { // from class: com.stepos.widget.glass.n0
                    @Override // java.lang.Runnable
                    public final void run() {
                        StepOSGradientBlurPanel.refreshBlur$lambda$8(this.f31239a);
                    }
                });
                return;
            }
            AppliedBlurParams appliedBlurParams = new AppliedBlurParams(this.blurRadius, this.blurDirection, this.blurScale, this.blurScope, this.isScrimEnabled, this.scrimStartColor, this.scrimMiddleColor, this.scrimEndColor, this.scrimMidpoint, this.scrimDirection);
            if (kotlin.jvm.internal.p.d(appliedBlurParams, this.appliedParams)) {
                if (this.glassDelegate.getHasHandle$StepOSWidget_release()) {
                    this.glassDelegate.updateCornerRadius$StepOSWidget_release(this.blurCornerRadius);
                    return;
                }
                return;
            }
            if (this.fallbackBackground != null) {
                this.glassDelegate.showCover$StepOSWidget_release();
                invalidate();
            }
            this.internalWrite = true;
            try {
                super.setBackground(null);
                GlassDelegate glassDelegate = this.glassDelegate;
                int i10 = this.blurScope;
                float f10 = this.blurCornerRadius;
                float f11 = this.blurRadius;
                StepOSGlassPanel.Companion companion = StepOSGlassPanel.INSTANCE;
                BlurGradient blurGradientBlurGradientOf$StepOSWidget_release = companion.blurGradientOf$StepOSWidget_release(this.blurDirection);
                Integer numValueOf = Integer.valueOf(this.blurScale);
                Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
                boolean z10 = this.isScrimEnabled;
                boolean zApplyGradientBlur$StepOSWidget_release = glassDelegate.applyGradientBlur$StepOSWidget_release(i10, f10, f11, blurGradientBlurGradientOf$StepOSWidget_release, num, z10 ? this.scrimStartColor : 0, z10 ? this.scrimMiddleColor : 0, z10 ? this.scrimEndColor : 0, this.scrimMidpoint, companion.blurGradientOf$StepOSWidget_release(this.scrimDirection));
                this.appliedParams = zApplyGradientBlur$StepOSWidget_release ? appliedBlurParams : null;
                if (!zApplyGradientBlur$StepOSWidget_release || this.fallbackBackground == null) {
                    this.glassDelegate.cancelCover$StepOSWidget_release();
                } else {
                    this.glassDelegate.scheduleCoverReveal$StepOSWidget_release();
                }
                if (!zApplyGradientBlur$StepOSWidget_release) {
                    super.setBackground(this.fallbackBackground);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshBlur$lambda$8(StepOSGradientBlurPanel stepOSGradientBlurPanel) {
        if (stepOSGradientBlurPanel.isAttachedToWindow()) {
            stepOSGradientBlurPanel.refreshBlur();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.glassDelegate.getCoverPending()) {
            this.glassDelegate.drawCoverIfPending$StepOSWidget_release(canvas, this.blurCornerRadius, this.fallbackBackground);
        }
        super.dispatchDraw(canvas);
    }

    public final float getBlurCornerRadius() {
        return this.blurCornerRadius;
    }

    public final int getBlurDirection() {
        return this.blurDirection;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final int getBlurScale() {
        return this.blurScale;
    }

    public final int getBlurScope() {
        return this.blurScope;
    }

    public final int getScrimDirection() {
        return this.scrimDirection;
    }

    public final int getScrimEndColor() {
        return this.scrimEndColor;
    }

    public final int getScrimMiddleColor() {
        return this.scrimMiddleColor;
    }

    public final float getScrimMidpoint() {
        return this.scrimMidpoint;
    }

    public final int getScrimStartColor() {
        return this.scrimStartColor;
    }

    public final boolean isBlurActive() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isBlurEnabled, reason: from getter */
    public final boolean getIsBlurEnabled() {
        return this.isBlurEnabled;
    }

    /* renamed from: isScrimEnabled, reason: from getter */
    public final boolean getIsScrimEnabled() {
        return this.isScrimEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.glassDelegate.getIsActive()) {
            return;
        }
        refreshBlur();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.glassDelegate.cancelCover$StepOSWidget_release();
        this.internalWrite = true;
        try {
            this.glassDelegate.release$StepOSWidget_release();
            super.setBackground(this.fallbackBackground);
            this.internalWrite = false;
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            this.internalWrite = false;
            throw th;
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (!this.constructed || this.internalWrite) {
            super.setBackground(background);
            return;
        }
        this.fallbackBackground = background;
        if (this.glassDelegate.getIsActive()) {
            Log.w(TAG, "setBackground() 被忽略：模糊正生效，background 由 MotionKit 独占，挂上去会把模糊冲掉。已记为降级兜底背景，降级时自动生效。");
        } else {
            super.setBackground(background);
        }
    }

    public final void setBlurCornerRadius(float f10) {
        if (f10 < 0.0f || Float.isNaN(f10)) {
            throw new IllegalArgumentException(("blurCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.blurCornerRadius == f10) {
            return;
        }
        this.blurCornerRadius = f10;
        if (this.glassDelegate.getHasHandle$StepOSWidget_release()) {
            this.glassDelegate.updateCornerRadius$StepOSWidget_release(f10);
        } else {
            refreshBlur();
        }
    }

    public final void setBlurDirection(int i10) {
        if (!Z8.r.P(StepOSGlassPanel.INSTANCE.getBLUR_DIRECTION_ALL$StepOSWidget_release(), i10)) {
            throw new IllegalArgumentException(("blurDirection must be one of BLUR_DIRECTION_* but was " + i10).toString());
        }
        if (this.blurDirection == i10) {
            return;
        }
        this.blurDirection = i10;
        refreshBlur();
    }

    public final void setBlurEnabled(boolean z10) {
        if (this.isBlurEnabled == z10) {
            return;
        }
        this.isBlurEnabled = z10;
        refreshBlur();
    }

    public final void setBlurRadius(float f10) {
        if (f10 < 0.0f || Float.isNaN(f10)) {
            throw new IllegalArgumentException(("blurRadius must be >= 0 but was " + f10).toString());
        }
        if (this.blurRadius == f10) {
            return;
        }
        this.blurRadius = f10;
        refreshBlur();
    }

    public final void setBlurRadiusResource(int resId) {
        setBlurRadius(s0.h.g(getResources(), resId));
    }

    public final void setBlurScale(int i10) {
        if (i10 != -1 && (i10 < 0 || i10 >= 4)) {
            throw new IllegalArgumentException(("blurScale must be GRADIENT_SCALE_DEFAULT(-1) or 0..3 but was " + i10).toString());
        }
        if (this.blurScale == i10) {
            return;
        }
        this.blurScale = i10;
        refreshBlur();
    }

    public final void setBlurScope(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(("blurScope must be SCOPE_IN_WINDOW or SCOPE_CROSS_WINDOW but was " + i10).toString());
        }
        if (this.blurScope == i10) {
            return;
        }
        this.blurScope = i10;
        refreshBlur();
    }

    public final void setScrimDirection(int i10) {
        if (!Z8.r.P(StepOSGlassPanel.INSTANCE.getBLUR_DIRECTION_ALL$StepOSWidget_release(), i10)) {
            throw new IllegalArgumentException(("scrimDirection must be one of BLUR_DIRECTION_* but was " + i10).toString());
        }
        if (this.scrimDirection == i10) {
            return;
        }
        this.scrimDirection = i10;
        refreshBlur();
    }

    public final void setScrimEnabled(boolean z10) {
        if (this.isScrimEnabled == z10) {
            return;
        }
        this.isScrimEnabled = z10;
        refreshBlur();
    }

    public final void setScrimEndColor(int i10) {
        if (this.scrimEndColor == i10) {
            return;
        }
        this.scrimEndColor = i10;
        refreshBlur();
    }

    public final void setScrimEndColorResource(int resId) {
        setScrimEndColor(resId == 0 ? 0 : androidx.core.content.a.c(getContext(), resId));
    }

    public final void setScrimMiddleColor(int i10) {
        if (this.scrimMiddleColor == i10) {
            return;
        }
        this.scrimMiddleColor = i10;
        refreshBlur();
    }

    public final void setScrimMiddleColorResource(int resId) {
        setScrimMiddleColor(resId == 0 ? 0 : androidx.core.content.a.c(getContext(), resId));
    }

    public final void setScrimMidpoint(float f10) {
        if (0.0f > f10 || f10 > 1.0f || Float.isNaN(f10)) {
            throw new IllegalArgumentException(("scrimMidpoint must be in 0..1 but was " + f10).toString());
        }
        if (this.scrimMidpoint == f10) {
            return;
        }
        this.scrimMidpoint = f10;
        refreshBlur();
    }

    public final void setScrimStartColor(int i10) {
        if (this.scrimStartColor == i10) {
            return;
        }
        this.scrimStartColor = i10;
        refreshBlur();
    }

    public final void setScrimStartColorResource(int resId) {
        setScrimStartColor(resId == 0 ? 0 : androidx.core.content.a.c(getContext(), resId));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGradientBlurPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGradientBlurPanel(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSGradientBlurPanel(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposGradientBlurPanelStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_GradientBlurPanel : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSGradientBlurPanel(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.isBlurEnabled = true;
        this.blurDirection = 1;
        this.blurScale = -1;
        this.isScrimEnabled = true;
        this.scrimMidpoint = 0.5f;
        this.scrimDirection = 1;
        this.fallbackBackground = super.getBackground();
        this.internalWrite = true;
        try {
            super.setBackground(null);
            this.internalWrite = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSGradientBlurPanel, i10, i11);
            kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            setBlurEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGradientBlurPanel_steposGradientBlurEnabled, true));
            setBlurRadius(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSGradientBlurPanel_steposGradientBlurRadius, s0.h.g(getResources(), R.dimen.stepos_gradient_blur_radius_end)));
            setBlurDirection(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGradientBlurPanel_steposGradientBlurDirection, 1));
            setBlurScale(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGradientBlurPanel_steposGradientBlurScale, -1));
            setBlurScope(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGradientBlurPanel_steposGradientBlurScope, 0));
            setBlurCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSGradientBlurPanel_steposGradientBlurCornerRadius, 0.0f));
            setScrimEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGradientBlurPanel_steposGradientScrimEnabled, true));
            setScrimStartColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSGradientBlurPanel_steposGradientScrimStartColor, 0));
            setScrimMiddleColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSGradientBlurPanel_steposGradientScrimMiddleColor, 0));
            setScrimEndColor(typedArrayObtainStyledAttributes.getColor(R.styleable.StepOSGradientBlurPanel_steposGradientScrimEndColor, 0));
            setScrimMidpoint(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSGradientBlurPanel_steposGradientScrimMidpoint, 0.5f));
            setScrimDirection(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGradientBlurPanel_steposGradientScrimDirection, 1));
            Y8.t tVar = Y8.t.f7040a;
            typedArrayObtainStyledAttributes.recycle();
            this.constructed = true;
            if (this.isBlurEnabled) {
                refreshBlur();
            }
        } catch (Throwable th) {
            this.internalWrite = false;
            throw th;
        }
    }
}
