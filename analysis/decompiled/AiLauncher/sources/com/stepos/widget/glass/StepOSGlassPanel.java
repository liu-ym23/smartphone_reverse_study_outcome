package com.stepos.widget.glass;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.a0;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.motionkit.fx.material.capability.BlurGradient;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import f.C4027a;
import kotlin.Metadata;
import n9.C4946a;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 r2\u00020\u0001:\u0001rB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\rH\u0014¢\u0006\u0004\b'\u0010\u0011J\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010\u0011J\u0017\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020$H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b-\u0010.J/\u00103\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010!J/\u00106\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u0010!J\u0017\u00108\u001a\u00020\r2\u0006\u00107\u001a\u00020$H\u0016¢\u0006\u0004\b8\u0010+R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010?R*\u0010K\u001a\u00020$2\u0006\u0010J\u001a\u00020$8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010B\u001a\u0004\bK\u0010L\"\u0004\bM\u0010+R*\u0010N\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010?\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\u0017R,\u0010R\u001a\u00020F2\b\b\u0001\u0010J\u001a\u00020F8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010H\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR,\u0010W\u001a\u00020F2\b\b\u0001\u0010J\u001a\u00020F8G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010H\u001a\u0004\bX\u0010T\"\u0004\bY\u0010VR*\u0010Z\u001a\u00020$2\u0006\u0010J\u001a\u00020$8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010B\u001a\u0004\bZ\u0010L\"\u0004\b[\u0010+R*\u0010\\\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010?\u001a\u0004\b]\u0010P\"\u0004\b^\u0010\u0017R*\u0010_\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010?\u001a\u0004\b`\u0010P\"\u0004\ba\u0010\u0017R4\u0010b\u001a\u0004\u0018\u00010\"2\b\u0010J\u001a\u0004\u0018\u00010\"8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\bb\u0010=\u0012\u0004\bf\u0010\u0011\u001a\u0004\bc\u0010d\"\u0004\be\u0010.R*\u0010g\u001a\u00020$2\u0006\u0010J\u001a\u00020$8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010B\u001a\u0004\bg\u0010L\"\u0004\bh\u0010+R\u0011\u0010i\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\bi\u0010LR\u0014\u0010k\u001a\u00020$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bj\u0010LR4\u0010q\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010l2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010l8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bm\u0010n\"\u0004\bo\u0010p¨\u0006s"}, d2 = {"Lcom/stepos/widget/glass/StepOSGlassPanel;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Landroidx/core/view/a0;", "insets", "LY8/t;", "applyBottomSystemBarInset", "(Landroidx/core/view/a0;)V", "refreshGlass", "()V", "clearAppliedGlass", "onAttachedToWindow", "onDetachedFromWindow", "resId", "setScrimResource", "(I)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/drawable/Drawable;", "who", "", "verifyDrawable", "(Landroid/graphics/drawable/Drawable;)Z", "drawableStateChanged", "jumpDrawablesToCurrentState", "isVisible", "onVisibilityAggregated", "(Z)V", "background", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "left", "top", "right", "bottom", "setPadding", "start", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "setPaddingRelative", "fitSystemWindows", "setFitsSystemWindows", "Lcom/stepos/widget/glass/GlassDelegate;", "glassDelegate", "Lcom/stepos/widget/glass/GlassDelegate;", "fallbackBackground", "Landroid/graphics/drawable/Drawable;", "hostPaddingBottom", "I", "appliedBottomInset", "internalWrite", "Z", "constructed", "appliedBlurUniform", "Ljava/lang/Boolean;", "", "appliedBlurRadius", "F", "appliedGlassScope", UxipConstants.f30680s, "isGlassEnabled", "()Z", "setGlassEnabled", "glassScope", "getGlassScope", "()I", "setGlassScope", "glassCornerRadius", "getGlassCornerRadius", "()F", "setGlassCornerRadius", "(F)V", "glassBlurRadius", "getGlassBlurRadius", "setGlassBlurRadius", "isBlurUniform", "setBlurUniform", "blurDirection", "getBlurDirection", "setBlurDirection", "blurScale", "getBlurScale", "setBlurScale", "scrimDrawable", "getScrimDrawable", "()Landroid/graphics/drawable/Drawable;", "setScrimDrawable", "getScrimDrawable$annotations", "isScrimEnabled", "setScrimEnabled", "isGlassActive", "isCoverPending$StepOSWidget_release", "isCoverPending", "Lkotlin/Function0;", "getOnCoverRevealedListener$StepOSWidget_release", "()Lp9/a;", "setOnCoverRevealedListener$StepOSWidget_release", "(Lp9/a;)V", "onCoverRevealedListener", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSGlassPanel extends FrameLayout {
    public static final int BLUR_DIRECTION_BOTTOM_TO_TOP = 2;
    public static final int BLUR_DIRECTION_LEFT_TO_RIGHT = 3;
    public static final int BLUR_DIRECTION_NONE = 0;
    public static final int BLUR_DIRECTION_RIGHT_TO_LEFT = 4;
    public static final int BLUR_DIRECTION_TOP_TO_BOTTOM = 1;
    public static final int GRADIENT_SCALE_DEFAULT = -1;
    public static final int SCOPE_CROSS_WINDOW = 1;
    public static final int SCOPE_IN_WINDOW = 0;
    private static final String TAG = "StepOSGlassPanel";
    private float appliedBlurRadius;
    private Boolean appliedBlurUniform;
    private int appliedBottomInset;
    private int appliedGlassScope;
    private int blurDirection;
    private int blurScale;
    private boolean constructed;
    private Drawable fallbackBackground;
    private float glassBlurRadius;
    private float glassCornerRadius;
    private final GlassDelegate glassDelegate;
    private int glassScope;
    private int hostPaddingBottom;
    private boolean internalWrite;
    private boolean isBlurUniform;
    private boolean isGlassEnabled;
    private boolean isScrimEnabled;
    private Drawable scrimDrawable;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] BLUR_DIRECTION_ALL = {0, 1, 2, 3, 4};

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/stepos/widget/glass/StepOSGlassPanel$Companion;", "", "<init>", "()V", "SCOPE_IN_WINDOW", "", "SCOPE_CROSS_WINDOW", "BLUR_DIRECTION_NONE", "BLUR_DIRECTION_TOP_TO_BOTTOM", "BLUR_DIRECTION_BOTTOM_TO_TOP", "BLUR_DIRECTION_LEFT_TO_RIGHT", "BLUR_DIRECTION_RIGHT_TO_LEFT", "BLUR_DIRECTION_ALL", "", "getBLUR_DIRECTION_ALL$StepOSWidget_release", "()[I", "GRADIENT_SCALE_DEFAULT", "TAG", "", "blurGradientOf", "Lcom/stepos/motionkit/fx/material/capability/BlurGradient;", "direction", "blurGradientOf$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final BlurGradient blurGradientOf$StepOSWidget_release(int direction) {
            return direction != 0 ? direction != 1 ? direction != 2 ? direction != 3 ? direction != 4 ? BlurGradient.TOP_TO_BOTTOM : BlurGradient.RIGHT_TO_LEFT : BlurGradient.LEFT_TO_RIGHT : BlurGradient.BOTTOM_TO_TOP : BlurGradient.TOP_TO_BOTTOM : BlurGradient.NONE;
        }

        public final int[] getBLUR_DIRECTION_ALL$StepOSWidget_release() {
            return StepOSGlassPanel.BLUR_DIRECTION_ALL;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassPanel(Context context) {
        this(context, null, 0, 0, 14, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.core.view.a0 _init_$lambda$6(StepOSGlassPanel stepOSGlassPanel, View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        stepOSGlassPanel.applyBottomSystemBarInset(insets);
        return insets;
    }

    private final void applyBottomSystemBarInset(androidx.core.view.a0 insets) {
        int i10 = getFitsSystemWindows() ? insets.f(a0.o.g()).f41980d : 0;
        if (i10 == this.appliedBottomInset && getPaddingBottom() == this.hostPaddingBottom + i10) {
            return;
        }
        this.appliedBottomInset = i10;
        this.internalWrite = true;
        try {
            super.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), this.hostPaddingBottom + i10);
        } finally {
            this.internalWrite = false;
        }
    }

    private final void clearAppliedGlass() {
        this.appliedBlurUniform = null;
        this.appliedBlurRadius = Float.NaN;
        this.appliedGlassScope = Integer.MIN_VALUE;
    }

    public static /* synthetic */ void getScrimDrawable$annotations() {
    }

    private final void refreshGlass() {
        boolean zApplyGradientBlur$StepOSWidget_release;
        if (this.constructed && isAttachedToWindow()) {
            if (this.isGlassEnabled && this.glassDelegate.getIsActive() && kotlin.jvm.internal.p.d(this.appliedBlurUniform, Boolean.valueOf(this.isBlurUniform)) && this.appliedBlurRadius == this.glassBlurRadius && this.appliedGlassScope == this.glassScope) {
                this.glassDelegate.updateCornerRadius$StepOSWidget_release(this.glassCornerRadius);
                return;
            }
            this.internalWrite = true;
            try {
                if (this.isGlassEnabled) {
                    this.glassDelegate.showCover$StepOSWidget_release();
                    invalidate();
                }
                super.setBackground(null);
                if (this.isGlassEnabled) {
                    if (this.isBlurUniform) {
                        zApplyGradientBlur$StepOSWidget_release = GlassDelegate.applyBlurOnly$StepOSWidget_release$default(this.glassDelegate, this.glassScope, this.glassCornerRadius, this.glassBlurRadius, 0, 8, null);
                    } else {
                        GlassDelegate glassDelegate = this.glassDelegate;
                        int i10 = this.glassScope;
                        float f10 = this.glassCornerRadius;
                        float f11 = this.glassBlurRadius;
                        BlurGradient blurGradientBlurGradientOf$StepOSWidget_release = INSTANCE.blurGradientOf$StepOSWidget_release(this.blurDirection);
                        Integer numValueOf = Integer.valueOf(this.blurScale);
                        if (numValueOf.intValue() == -1) {
                            numValueOf = null;
                        }
                        zApplyGradientBlur$StepOSWidget_release = glassDelegate.applyGradientBlur$StepOSWidget_release(i10, f10, f11, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 8) != 0 ? BlurGradient.TOP_TO_BOTTOM : blurGradientBlurGradientOf$StepOSWidget_release, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 16) != 0 ? null : numValueOf, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 32) != 0 ? 0 : 0, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 64) != 0 ? 0 : 0, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 128) != 0 ? 0 : 0, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 256) != 0 ? 0.5f : 0.0f, (AMapException.CODE_AMAP_INVALID_USER_SCODE & 512) != 0 ? BlurGradient.TOP_TO_BOTTOM : null);
                    }
                    if (zApplyGradientBlur$StepOSWidget_release) {
                        this.appliedBlurUniform = Boolean.valueOf(this.isBlurUniform);
                        this.appliedBlurRadius = this.glassBlurRadius;
                        this.appliedGlassScope = this.glassScope;
                    } else {
                        clearAppliedGlass();
                    }
                } else {
                    this.glassDelegate.release$StepOSWidget_release();
                    clearAppliedGlass();
                    zApplyGradientBlur$StepOSWidget_release = false;
                }
                this.internalWrite = false;
                if (zApplyGradientBlur$StepOSWidget_release) {
                    this.glassDelegate.scheduleCoverReveal$StepOSWidget_release();
                } else {
                    this.glassDelegate.cancelCover$StepOSWidget_release();
                    super.setBackground(this.fallbackBackground);
                }
            } catch (Throwable th) {
                this.internalWrite = false;
                throw th;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.glassDelegate.getCoverPending()) {
            this.glassDelegate.drawCoverIfPending$StepOSWidget_release(canvas, this.glassCornerRadius, this.fallbackBackground);
        }
        if (this.isScrimEnabled && (drawable = this.scrimDrawable) != null) {
            drawable.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.scrimDrawable;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final int getBlurDirection() {
        return this.blurDirection;
    }

    public final int getBlurScale() {
        return this.blurScale;
    }

    public final float getGlassBlurRadius() {
        return this.glassBlurRadius;
    }

    public final float getGlassCornerRadius() {
        return this.glassCornerRadius;
    }

    public final int getGlassScope() {
        return this.glassScope;
    }

    public final InterfaceC5063a<Y8.t> getOnCoverRevealedListener$StepOSWidget_release() {
        return this.glassDelegate.getOnCoverRevealedListener$StepOSWidget_release();
    }

    public final Drawable getScrimDrawable() {
        return this.scrimDrawable;
    }

    /* renamed from: isBlurUniform, reason: from getter */
    public final boolean getIsBlurUniform() {
        return this.isBlurUniform;
    }

    public final boolean isCoverPending$StepOSWidget_release() {
        return this.glassDelegate.getCoverPending();
    }

    public final boolean isGlassActive() {
        return this.glassDelegate.getIsActive();
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isScrimEnabled, reason: from getter */
    public final boolean getIsScrimEnabled() {
        return this.isScrimEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.scrimDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, "attach #" + System.identityHashCode(this) + " enabled=" + this.isGlassEnabled + " uniform=" + this.isBlurUniform + " " + getWidth() + "x" + getHeight());
        if (this.glassDelegate.getIsActive()) {
            return;
        }
        if (getWidth() <= 0 || getHeight() <= 0) {
            Log.i(TAG, "attach skipped: 0x0, defer to onSizeChanged");
        } else {
            refreshGlass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Log.i(TAG, "detach #" + System.identityHashCode(this) + " " + getWidth() + "x" + getHeight());
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
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        Drawable drawable = this.scrimDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, w10, h10);
        }
        if (w10 <= 0 || h10 <= 0) {
            return;
        }
        refreshGlass();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        Drawable drawable = this.scrimDrawable;
        if (drawable != null) {
            drawable.setVisible(isVisible, false);
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
            Log.w(TAG, "setBackground() 被忽略：玻璃正生效，background 由 MotionKit 独占，挂上去会把模糊冲掉。已记为降级兜底背景，玻璃降级时自动生效。");
        } else {
            super.setBackground(background);
        }
    }

    public final void setBlurDirection(int i10) {
        if (!Z8.r.P(BLUR_DIRECTION_ALL, i10)) {
            throw new IllegalArgumentException(("blurDirection must be one of BLUR_DIRECTION_* but was " + i10).toString());
        }
        if (this.blurDirection == i10) {
            return;
        }
        this.blurDirection = i10;
        refreshGlass();
    }

    public final void setBlurScale(int i10) {
        if (i10 != -1 && (i10 < 0 || i10 >= 4)) {
            throw new IllegalArgumentException(("blurScale must be GRADIENT_SCALE_DEFAULT(-1) or 0..3 but was " + i10).toString());
        }
        if (this.blurScale == i10) {
            return;
        }
        this.blurScale = i10;
        refreshGlass();
    }

    public final void setBlurUniform(boolean z10) {
        if (this.isBlurUniform == z10) {
            return;
        }
        this.isBlurUniform = z10;
        refreshGlass();
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        super.setFitsSystemWindows(fitSystemWindows);
        if (this.constructed && isAttachedToWindow()) {
            requestApplyInsets();
        }
    }

    public final void setGlassBlurRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("glassBlurRadius must be >= 0 but was " + f10).toString());
        }
        if (this.glassBlurRadius == f10) {
            return;
        }
        this.glassBlurRadius = f10;
        refreshGlass();
    }

    public final void setGlassCornerRadius(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f10).toString());
        }
        if (this.glassCornerRadius == f10) {
            return;
        }
        this.glassCornerRadius = f10;
        if (this.constructed && isAttachedToWindow()) {
            if (!this.glassDelegate.getIsActive()) {
                refreshGlass();
                return;
            }
            this.internalWrite = true;
            try {
                this.glassDelegate.updateCornerRadius$StepOSWidget_release(f10);
            } finally {
                this.internalWrite = false;
            }
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        refreshGlass();
    }

    public final void setGlassScope(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException(("glassScope must be SCOPE_IN_WINDOW(0) or SCOPE_CROSS_WINDOW(1) but was " + i10).toString());
        }
        if (this.glassScope == i10) {
            return;
        }
        this.glassScope = i10;
        refreshGlass();
    }

    public final void setOnCoverRevealedListener$StepOSWidget_release(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.glassDelegate.setOnCoverRevealedListener$StepOSWidget_release(interfaceC5063a);
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        if (!this.constructed || this.internalWrite) {
            super.setPadding(left, top, right, bottom);
        } else {
            this.hostPaddingBottom = bottom;
            super.setPadding(left, top, right, bottom + this.appliedBottomInset);
        }
    }

    @Override // android.view.View
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        if (!this.constructed || this.internalWrite) {
            super.setPaddingRelative(start, top, end, bottom);
        } else {
            this.hostPaddingBottom = bottom;
            super.setPaddingRelative(start, top, end, bottom + this.appliedBottomInset);
        }
    }

    public final void setScrimDrawable(Drawable drawable) {
        Drawable drawable2 = this.scrimDrawable;
        if (drawable2 == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
        this.scrimDrawable = drawableMutate;
        if (drawableMutate != null) {
            drawableMutate.setBounds(0, 0, getWidth(), getHeight());
            drawableMutate.setLayoutDirection(getLayoutDirection());
            if (drawableMutate.isStateful()) {
                drawableMutate.setState(getDrawableState());
            }
            drawableMutate.setVisible(getVisibility() == 0, false);
            drawableMutate.setCallback(this);
        }
        invalidate();
    }

    public final void setScrimEnabled(boolean z10) {
        if (this.isScrimEnabled == z10) {
            return;
        }
        this.isScrimEnabled = z10;
        invalidate();
    }

    public final void setScrimResource(int resId) {
        setScrimDrawable(resId == 0 ? null : C4027a.b(getContext(), resId));
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable who) {
        kotlin.jvm.internal.p.i(who, "who");
        return who == this.scrimDrawable || super.verifyDrawable(who);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSGlassPanel(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSGlassPanel(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposGlassPanelStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_GlassPanel : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSGlassPanel(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.p.i(context, "context");
        this.glassDelegate = new GlassDelegate(this);
        this.appliedBlurRadius = Float.NaN;
        this.appliedGlassScope = Integer.MIN_VALUE;
        this.isGlassEnabled = true;
        this.blurDirection = 1;
        this.blurScale = -1;
        this.isScrimEnabled = true;
        this.fallbackBackground = getBackground();
        this.hostPaddingBottom = getPaddingBottom();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSGlassPanel, i10, i11);
        try {
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGlassPanel_steposGlassEnabled, true));
            setGlassScope(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGlassPanel_steposGlassScope, 0));
            setGlassCornerRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.StepOSGlassPanel_steposGlassCornerRadius, getResources().getDimension(R.dimen.stepos_glass_panel_corner_radius)));
            setGlassBlurRadius(typedArrayObtainStyledAttributes.getFloat(R.styleable.StepOSGlassPanel_steposGlassBlurRadius, s0.h.g(getResources(), R.dimen.stepos_glass_panel_blur_radius_end)));
            setScrimDrawable(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSGlassPanel_steposGlassScrim));
            setScrimEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGlassPanel_steposGlassScrimEnabled, true));
            setBlurUniform(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSGlassPanel_steposGlassBlurUniform, false));
            setBlurDirection(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGlassPanel_steposGlassBlurDirection, 1));
            setBlurScale(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSGlassPanel_steposGlassBlurScale, -1));
            Y8.t tVar = Y8.t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            super.setBackground(null);
            this.constructed = true;
            androidx.core.view.N.u0(this, new androidx.core.view.A() { // from class: com.stepos.widget.glass.p
                @Override // androidx.core.view.A
                public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                    return StepOSGlassPanel._init_$lambda$6(this.f31241a, view, a0Var);
                }
            });
        } finally {
        }
    }
}
