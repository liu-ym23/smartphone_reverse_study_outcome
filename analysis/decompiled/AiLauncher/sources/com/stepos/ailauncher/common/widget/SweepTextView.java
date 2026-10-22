package com.stepos.ailauncher.common.widget;

import Y8.t;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.R$styleable;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ¤\u00012\u00020\u0001:\u0002¥\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0002¢\u0006\u0004\b#\u0010\"J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0014¢\u0006\u0004\b(\u0010\fJ\u000f\u0010)\u001a\u00020\nH\u0014¢\u0006\u0004\b)\u0010\fJ\u001f\u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0006H\u0014¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0006H\u0014¢\u0006\u0004\b/\u00100J/\u00105\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006H\u0014¢\u0006\u0004\b5\u00106J1\u0010<\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0014¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020>H\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bB\u0010\u0010J\u0017\u0010C\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\bC\u0010\u0015J\u0015\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0012¢\u0006\u0004\bE\u0010\u0015J\u0015\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u0012¢\u0006\u0004\bG\u0010\u0015J\u001f\u0010J\u001a\u00020\n2\u0006\u0010H\u001a\u00020\u00122\b\b\u0002\u0010I\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0012¢\u0006\u0004\bL\u0010\u0015J\u0015\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\r¢\u0006\u0004\bN\u0010\u0010J\u0015\u0010P\u001a\u00020\n2\u0006\u0010O\u001a\u00020\r¢\u0006\u0004\bP\u0010\u0010J\u001d\u0010S\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u00062\u0006\u0010R\u001a\u00020\u0006¢\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\bU\u00100J\u0015\u0010V\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\bV\u00100J\u0015\u0010X\u001a\u00020\n2\u0006\u0010W\u001a\u00020 ¢\u0006\u0004\bX\u0010YJ\u0015\u0010[\u001a\u00020\n2\u0006\u0010Z\u001a\u00020 ¢\u0006\u0004\b[\u0010YJ\u0015\u0010]\u001a\u00020\n2\u0006\u0010\\\u001a\u00020 ¢\u0006\u0004\b]\u0010YJ\u0015\u0010_\u001a\u00020\n2\u0006\u0010^\u001a\u00020 ¢\u0006\u0004\b_\u0010YJ\u0015\u0010`\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b`\u0010\u0010J\u0015\u0010b\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0006¢\u0006\u0004\bb\u00100J\u0015\u0010d\u001a\u00020\n2\u0006\u0010c\u001a\u00020\u0006¢\u0006\u0004\bd\u00100J\u0015\u0010f\u001a\u00020\n2\u0006\u0010e\u001a\u00020\r¢\u0006\u0004\bf\u0010\u0010J\u0015\u0010g\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bg\u0010\u0010J\u0015\u0010h\u001a\u00020\n2\u0006\u0010^\u001a\u00020 ¢\u0006\u0004\bh\u0010YJ%\u0010l\u001a\u00020\n2\u0006\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0006¢\u0006\u0004\bl\u0010mJ\u0015\u0010n\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\bn\u00100J\u0015\u0010o\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\bo\u00100J\u0015\u0010p\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\bp\u00100J\u0015\u0010r\u001a\u00020\n2\u0006\u0010q\u001a\u00020 ¢\u0006\u0004\br\u0010YJ\u0015\u0010t\u001a\u00020\n2\u0006\u0010s\u001a\u00020 ¢\u0006\u0004\bt\u0010YJ\u0015\u0010v\u001a\u00020\n2\u0006\u0010u\u001a\u00020 ¢\u0006\u0004\bv\u0010YR\u0014\u0010w\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010y\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010{\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010zR\u0016\u0010|\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010~\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0080\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010\u007fR\u0018\u0010\u0081\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010\u007fR\u0018\u0010\u0082\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010\u007fR\u0018\u0010\u0083\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010xR\u0018\u0010\u0084\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010xR\u0018\u0010\u0085\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010xR\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010zR\u0018\u0010\u008d\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010xR\u0018\u0010\u008e\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010xR\u0018\u0010\u008f\u0001\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010xR\u0018\u0010\u0090\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010zR\u0018\u0010\u0091\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010zR\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0095\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010}R\u0018\u0010\u0096\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010zR\u0018\u0010\u0097\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010}R\u0018\u0010\u0098\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010zR2\u0010\u009a\u0001\u001a\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0099\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0018\u0010£\u0001\u001a\u00030 \u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¢\u0001¨\u0006¦\u0001"}, d2 = {"Lcom/stepos/ailauncher/common/widget/SweepTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "syncAnimationForVisibility", "()V", "", "delayMs", "scheduleCycle", "(J)V", "startCycle", "", "clearShader", "pauseSweep", "(Z)V", "scheduleWaitFrame", "stopWaitDrive", "restartIfRunning", "canAnimateSweep", "()Z", "markShaderDirty", "ensureShader", "updateShaderMatrix", "cycleDurationMs", "()J", "", "minCycleLengthPx", "()F", "minSpeedPxPerSecond", "color", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "withAlpha", "(II)I", "onAttachedToWindow", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "(I)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "startSweep", "stopSweep", x5.d.EXTRA_ENABLED, "setSweepEnabled", "autoStart", "setSweepAutoStart", "active", "textColor", "setSweepActive", "(ZI)V", "setExternalClockDriven", "nowMs", "advanceWaitFrame", "intervalMs", "setSweepFrameIntervalMs", "colorA", "colorB", "setSweepGradientColors", "(II)V", "setSweepGradientColorA", "setSweepGradientColorB", "lengthPx", "setSweepGradientCycleLength", "(F)V", "speedPxPerSecond", "setSweepGradientSpeed", "speedDpPerSecond", "setSweepGradientSpeedDpPerSecond", "angleDegrees", "setSweepGradientAngle", "setSweepStartDelay", "direction", "setSweepDirection", "mode", "setSweepRepeatMode", "durationMs", "setSweepDuration", "setSweepRepeatDelay", "setSweepAngle", "baseColor", "edgeColor", "highlightColor", "setSweepColors", "(III)V", "setSweepBaseColor", "setSweepEdgeColor", "setSweepHighlightColor", "width", "setSweepHighlightWidth", "paddingPx", "setSweepTravelPadding", "intensity", "setSweepIntensity", "density", "F", "sweepEnabled", "Z", "sweepAutoStart", "sweepStartDelayMs", "J", "sweepDirection", "I", "sweepRepeatMode", "gradientColorA", "gradientColorB", "gradientCycleLengthPx", "gradientSpeedPxPerSecond", "gradientAngleDegrees", "Landroid/graphics/LinearGradient;", "shader", "Landroid/graphics/LinearGradient;", "Landroid/graphics/Matrix;", "shaderMatrix", "Landroid/graphics/Matrix;", "shaderDirty", "phasePx", "moveVectorX", "moveVectorY", "sweepRequested", "cycleStartPosted", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "frameIntervalMs", "frameScheduled", "lastFrameAtMs", "externalClock", "Lkotlin/Function0;", "onWaitFrameDrawn", "Lp9/a;", "getOnWaitFrameDrawn", "()Lp9/a;", "setOnWaitFrameDrawn", "(Lp9/a;)V", "Ljava/lang/Runnable;", "startCycleRunnable", "Ljava/lang/Runnable;", "waitFrameTick", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SweepTextView extends AppCompatTextView {
    private static final int DEFAULT_COLOR_A_ALPHA = 153;
    private static final int DEFAULT_COLOR_B_ALPHA = 255;
    private static final long DEFAULT_DURATION_MS = 1700;
    private static final float DEFAULT_GRADIENT_ANGLE_DEGREES = 30.0f;
    private static final float DEFAULT_GRADIENT_CYCLE_LENGTH_DP = 180.0f;
    private static final float DEFAULT_GRADIENT_SPEED_DP_PER_SECOND = 130.0f;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    private static final long MIN_DURATION_MS = 80;
    private static final float MIN_GRADIENT_CYCLE_LENGTH_DP = 12.0f;
    private static final float MIN_GRADIENT_SPEED_DP_PER_SECOND = 1.0f;
    public static final int REPEAT_MODE_RESTART = 0;
    public static final int REPEAT_MODE_REVERSE = 1;
    private ValueAnimator animator;
    private boolean cycleStartPosted;
    private final float density;
    private boolean externalClock;
    private long frameIntervalMs;
    private boolean frameScheduled;
    private float gradientAngleDegrees;
    private int gradientColorA;
    private int gradientColorB;
    private float gradientCycleLengthPx;
    private float gradientSpeedPxPerSecond;
    private long lastFrameAtMs;
    private float moveVectorX;
    private float moveVectorY;
    private InterfaceC5063a<t> onWaitFrameDrawn;
    private float phasePx;
    private LinearGradient shader;
    private boolean shaderDirty;
    private final Matrix shaderMatrix;
    private final Runnable startCycleRunnable;
    private boolean sweepAutoStart;
    private int sweepDirection;
    private boolean sweepEnabled;
    private int sweepRepeatMode;
    private boolean sweepRequested;
    private long sweepStartDelayMs;
    private final Runnable waitFrameTick;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SweepTextView(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    private final boolean canAnimateSweep() {
        return this.sweepEnabled && isAttachedToWindow() && isShown() && getWidth() > 0 && getHeight() > 0;
    }

    private final long cycleDurationMs() {
        return C5685n.g((long) ((this.gradientCycleLengthPx / this.gradientSpeedPxPerSecond) * 1000.0f), 80L);
    }

    private final void ensureShader() {
        if (this.shaderDirty || this.shader == null) {
            this.gradientCycleLengthPx = C5685n.e(this.gradientCycleLengthPx, minCycleLengthPx());
            this.gradientSpeedPxPerSecond = C5685n.e(this.gradientSpeedPxPerSecond, minSpeedPxPerSecond());
            double radians = Math.toRadians(this.gradientAngleDegrees);
            this.moveVectorX = (float) Math.cos(radians);
            this.moveVectorY = (float) Math.sin(radians);
            float f10 = this.gradientCycleLengthPx;
            float f11 = f10 * this.moveVectorX;
            float f12 = f10 * this.moveVectorY;
            int i10 = this.gradientColorA;
            this.shader = new LinearGradient(0.0f, 0.0f, f11, f12, new int[]{i10, i10, this.gradientColorB, i10, i10}, new float[]{0.0f, 0.34f, 0.5f, 0.66f, 1.0f}, Shader.TileMode.REPEAT);
            this.shaderDirty = false;
            updateShaderMatrix();
        }
    }

    private final void markShaderDirty() {
        this.shaderDirty = true;
        if (this.sweepEnabled) {
            invalidate();
        }
    }

    private final float minCycleLengthPx() {
        return this.density * 12.0f;
    }

    private final float minSpeedPxPerSecond() {
        return this.density * 1.0f;
    }

    private final void pauseSweep(boolean clearShader) {
        removeCallbacks(this.startCycleRunnable);
        this.cycleStartPosted = false;
        stopWaitDrive();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        if (clearShader) {
            this.shader = null;
            getPaint().setShader(null);
            invalidate();
        }
    }

    private final void restartIfRunning() {
        if ((this.sweepRequested || (this.sweepEnabled && this.sweepAutoStart)) && canAnimateSweep()) {
            startSweep(0L);
        }
    }

    private final void scheduleCycle(long delayMs) {
        removeCallbacks(this.startCycleRunnable);
        this.cycleStartPosted = true;
        if (delayMs == 0) {
            post(this.startCycleRunnable);
        } else {
            postDelayed(this.startCycleRunnable, delayMs);
        }
    }

    private final void scheduleWaitFrame() {
        if (!this.externalClock && !this.frameScheduled && this.frameIntervalMs > 0 && this.sweepRequested && canAnimateSweep()) {
            this.frameScheduled = true;
            postDelayed(this.waitFrameTick, this.frameIntervalMs);
        }
    }

    public static /* synthetic */ void setSweepActive$default(SweepTextView sweepTextView, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = sweepTextView.getCurrentTextColor();
        }
        sweepTextView.setSweepActive(z10, i10);
    }

    private final void startCycle() {
        if (canAnimateSweep()) {
            ensureShader();
            if (this.externalClock) {
                this.lastFrameAtMs = 0L;
                return;
            }
            if (this.frameIntervalMs > 0) {
                this.lastFrameAtMs = 0L;
                scheduleWaitFrame();
                return;
            }
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.gradientCycleLengthPx);
            valueAnimatorOfFloat.setDuration(cycleDurationMs());
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setRepeatMode(this.sweepRepeatMode != 1 ? 1 : 2);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.common.widget.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    SweepTextView.startCycle$lambda$0$0(this.f26975a, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.start();
            this.animator = valueAnimatorOfFloat;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startCycle$lambda$0$0(SweepTextView sweepTextView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        sweepTextView.phasePx = ((Float) animatedValue).floatValue();
        sweepTextView.updateShaderMatrix();
        sweepTextView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startCycleRunnable$lambda$0(SweepTextView sweepTextView) {
        sweepTextView.cycleStartPosted = false;
        sweepTextView.startCycle();
    }

    public static /* synthetic */ void startSweep$default(SweepTextView sweepTextView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        sweepTextView.startSweep(j10);
    }

    public static /* synthetic */ void stopSweep$default(SweepTextView sweepTextView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        sweepTextView.stopSweep(z10);
    }

    private final void stopWaitDrive() {
        if (this.frameScheduled) {
            removeCallbacks(this.waitFrameTick);
            this.frameScheduled = false;
        }
        this.lastFrameAtMs = 0L;
    }

    private final void syncAnimationForVisibility() {
        if (this.sweepRequested || (this.sweepEnabled && this.sweepAutoStart)) {
            if (!canAnimateSweep()) {
                pauseSweep(false);
                return;
            }
            ValueAnimator valueAnimator = this.animator;
            if ((valueAnimator == null || !valueAnimator.isRunning()) && !this.cycleStartPosted) {
                scheduleCycle(0L);
            }
        }
    }

    private final void updateShaderMatrix() {
        LinearGradient linearGradient = this.shader;
        if (linearGradient == null) {
            return;
        }
        float f10 = this.phasePx * (this.sweepDirection == 1 ? -1.0f : 1.0f);
        this.shaderMatrix.reset();
        this.shaderMatrix.setTranslate(this.moveVectorX * f10, this.moveVectorY * f10);
        linearGradient.setLocalMatrix(this.shaderMatrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void waitFrameTick$lambda$0(SweepTextView sweepTextView) {
        sweepTextView.frameScheduled = false;
        if (sweepTextView.canAnimateSweep() && sweepTextView.sweepRequested && sweepTextView.frameIntervalMs > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long j10 = sweepTextView.lastFrameAtMs;
            long jG = j10 == 0 ? sweepTextView.frameIntervalMs : C5685n.g(jUptimeMillis - j10, 1L);
            sweepTextView.lastFrameAtMs = jUptimeMillis;
            float fE = C5685n.e(sweepTextView.gradientCycleLengthPx, 1.0f);
            float f10 = sweepTextView.phasePx + ((sweepTextView.gradientSpeedPxPerSecond * jG) / 1000.0f);
            sweepTextView.phasePx = f10;
            if (sweepTextView.sweepRepeatMode == 1) {
                float f11 = 2.0f * fE;
                float f12 = f10 % f11;
                if (f12 < 0.0f) {
                    f12 += f11;
                }
                if (f12 > fE) {
                    f12 = f11 - f12;
                }
                sweepTextView.phasePx = f12;
            } else {
                float f13 = f10 % fE;
                sweepTextView.phasePx = f13;
                if (f13 < 0.0f) {
                    sweepTextView.phasePx = f13 + fE;
                }
            }
            sweepTextView.updateShaderMatrix();
            sweepTextView.invalidate();
            InterfaceC5063a<t> interfaceC5063a = sweepTextView.onWaitFrameDrawn;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            sweepTextView.scheduleWaitFrame();
        }
    }

    private final int withAlpha(int color, int alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    public final void advanceWaitFrame(long nowMs) {
        if (this.externalClock && canAnimateSweep() && this.sweepRequested) {
            long j10 = this.lastFrameAtMs;
            long jG = j10 == 0 ? 50L : C5685n.g(nowMs - j10, 1L);
            this.lastFrameAtMs = nowMs;
            float fE = C5685n.e(this.gradientCycleLengthPx, 1.0f);
            float f10 = this.phasePx + ((this.gradientSpeedPxPerSecond * jG) / 1000.0f);
            this.phasePx = f10;
            if (this.sweepRepeatMode == 1) {
                float f11 = 2.0f * fE;
                float f12 = f10 % f11;
                if (f12 < 0.0f) {
                    f12 += f11;
                }
                if (f12 > fE) {
                    f12 = f11 - f12;
                }
                this.phasePx = f12;
            } else {
                float f13 = f10 % fE;
                this.phasePx = f13;
                if (f13 < 0.0f) {
                    this.phasePx = f13 + fE;
                }
            }
            updateShaderMatrix();
            invalidate();
            InterfaceC5063a<t> interfaceC5063a = this.onWaitFrameDrawn;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
    }

    public final InterfaceC5063a<t> getOnWaitFrameDrawn() {
        return this.onWaitFrameDrawn;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.sweepEnabled && this.sweepAutoStart) {
            startSweep(this.sweepStartDelayMs);
        } else if (this.sweepRequested) {
            startSweep(0L);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        pauseSweep(true);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        if (this.sweepEnabled) {
            ensureShader();
            getPaint().setShader(this.shader);
        } else {
            getPaint().setShader(null);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        markShaderDirty();
        syncAnimationForVisibility();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        markShaderDirty();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        syncAnimationForVisibility();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        syncAnimationForVisibility();
    }

    public final void setExternalClockDriven(boolean enabled) {
        if (this.externalClock == enabled) {
            return;
        }
        this.externalClock = enabled;
        stopWaitDrive();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        this.lastFrameAtMs = 0L;
        if (!enabled && this.sweepRequested && canAnimateSweep()) {
            startCycle();
        }
    }

    public final void setOnWaitFrameDrawn(InterfaceC5063a<t> interfaceC5063a) {
        this.onWaitFrameDrawn = interfaceC5063a;
    }

    public final void setSweepActive(boolean active, int textColor) {
        setTextColor(textColor);
        if (!active) {
            setSweepEnabled(false);
            stopSweep(true);
        } else {
            setSweepGradientColors(withAlpha(textColor, DEFAULT_COLOR_A_ALPHA), withAlpha(textColor, DEFAULT_COLOR_B_ALPHA));
            setSweepEnabled(true);
            startSweep(0L);
        }
    }

    public final void setSweepAngle(float angleDegrees) {
        setSweepGradientAngle(angleDegrees);
    }

    public final void setSweepAutoStart(boolean autoStart) {
        this.sweepAutoStart = autoStart;
    }

    public final void setSweepBaseColor(int color) {
        setSweepGradientColorA(color);
    }

    public final void setSweepColors(int baseColor, int edgeColor, int highlightColor) {
        setSweepGradientColors(baseColor, highlightColor);
    }

    public final void setSweepDirection(int direction) {
        int i10 = direction != 1 ? 0 : 1;
        if (this.sweepDirection == i10) {
            return;
        }
        this.sweepDirection = i10;
        restartIfRunning();
    }

    public final void setSweepDuration(long durationMs) {
        setSweepGradientSpeed((this.gradientCycleLengthPx * 1000.0f) / C5685n.g(durationMs, 80L));
    }

    public final void setSweepEdgeColor(int color) {
        setSweepGradientColorA(color);
    }

    public final void setSweepEnabled(boolean enabled) {
        if (this.sweepEnabled == enabled) {
            return;
        }
        this.sweepEnabled = enabled;
        if (!enabled) {
            stopSweep(true);
            return;
        }
        markShaderDirty();
        if (this.sweepAutoStart || this.sweepRequested) {
            startSweep(0L);
        }
    }

    public final void setSweepFrameIntervalMs(long intervalMs) {
        long jG = C5685n.g(intervalMs, 0L);
        if (this.frameIntervalMs == jG) {
            return;
        }
        this.frameIntervalMs = jG;
        if (this.sweepRequested && canAnimateSweep()) {
            pauseSweep(false);
            if (jG <= 0) {
                startCycle();
            } else {
                this.lastFrameAtMs = 0L;
                scheduleWaitFrame();
            }
        }
    }

    public final void setSweepGradientAngle(float angleDegrees) {
        if (this.gradientAngleDegrees == angleDegrees) {
            return;
        }
        this.gradientAngleDegrees = angleDegrees;
        markShaderDirty();
    }

    public final void setSweepGradientColorA(int color) {
        if (this.gradientColorA == color) {
            return;
        }
        this.gradientColorA = color;
        markShaderDirty();
    }

    public final void setSweepGradientColorB(int color) {
        if (this.gradientColorB == color) {
            return;
        }
        this.gradientColorB = color;
        markShaderDirty();
    }

    public final void setSweepGradientColors(int colorA, int colorB) {
        if (this.gradientColorA == colorA && this.gradientColorB == colorB) {
            return;
        }
        this.gradientColorA = colorA;
        this.gradientColorB = colorB;
        markShaderDirty();
    }

    public final void setSweepGradientCycleLength(float lengthPx) {
        float fE = C5685n.e(lengthPx, minCycleLengthPx());
        if (this.gradientCycleLengthPx == fE) {
            return;
        }
        this.gradientCycleLengthPx = fE;
        markShaderDirty();
        restartIfRunning();
    }

    public final void setSweepGradientSpeed(float speedPxPerSecond) {
        float fE = C5685n.e(speedPxPerSecond, minSpeedPxPerSecond());
        if (this.gradientSpeedPxPerSecond == fE) {
            return;
        }
        this.gradientSpeedPxPerSecond = fE;
        restartIfRunning();
    }

    public final void setSweepGradientSpeedDpPerSecond(float speedDpPerSecond) {
        setSweepGradientSpeed(speedDpPerSecond * this.density);
    }

    public final void setSweepHighlightColor(int color) {
        setSweepGradientColorB(color);
    }

    public final void setSweepHighlightWidth(float width) {
    }

    public final void setSweepIntensity(float intensity) {
    }

    public final void setSweepRepeatDelay(long delayMs) {
    }

    public final void setSweepRepeatMode(int mode) {
        int i10 = mode != 1 ? 0 : 1;
        if (this.sweepRepeatMode == i10) {
            return;
        }
        this.sweepRepeatMode = i10;
        restartIfRunning();
    }

    public final void setSweepStartDelay(long delayMs) {
        this.sweepStartDelayMs = C5685n.g(delayMs, 0L);
    }

    public final void setSweepTravelPadding(float paddingPx) {
    }

    public final void startSweep(long delayMs) {
        this.sweepRequested = true;
        if (canAnimateSweep()) {
            pauseSweep(false);
            this.phasePx = 0.0f;
            updateShaderMatrix();
            scheduleCycle(C5685n.g(delayMs, 0L));
        }
    }

    public final void stopSweep(boolean clearShader) {
        this.sweepRequested = false;
        pauseSweep(clearShader);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SweepTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SweepTextView(Context context, AttributeSet attributeSet, int i10) {
        float fG;
        super(context, attributeSet, i10);
        p.i(context, "context");
        float f10 = getResources().getDisplayMetrics().density;
        this.density = f10;
        this.sweepEnabled = true;
        this.sweepAutoStart = true;
        this.gradientColorA = withAlpha(getCurrentTextColor(), DEFAULT_COLOR_A_ALPHA);
        this.gradientColorB = withAlpha(getCurrentTextColor(), DEFAULT_COLOR_B_ALPHA);
        this.gradientCycleLengthPx = 180.0f * f10;
        this.gradientSpeedPxPerSecond = f10 * 130.0f;
        this.gradientAngleDegrees = 30.0f;
        this.shaderMatrix = new Matrix();
        this.shaderDirty = true;
        this.moveVectorX = 1.0f;
        this.startCycleRunnable = new Runnable() { // from class: com.stepos.ailauncher.common.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                SweepTextView.startCycleRunnable$lambda$0(this.f26976a);
            }
        };
        this.waitFrameTick = new Runnable() { // from class: com.stepos.ailauncher.common.widget.e
            @Override // java.lang.Runnable
            public final void run() {
                SweepTextView.waitFrameTick$lambda$0(this.f26977a);
            }
        };
        int[] SweepTextView = R$styleable.SweepTextView;
        p.h(SweepTextView, "SweepTextView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SweepTextView, i10, 0);
        this.sweepEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SweepTextView_sweepEnabled, this.sweepEnabled);
        this.sweepAutoStart = typedArrayObtainStyledAttributes.getBoolean(R$styleable.SweepTextView_sweepAutoStart, this.sweepAutoStart);
        this.sweepStartDelayMs = C5685n.g(typedArrayObtainStyledAttributes.getInt(R$styleable.SweepTextView_sweepStartDelay, (int) this.sweepStartDelayMs), 0L);
        this.sweepDirection = typedArrayObtainStyledAttributes.getInt(R$styleable.SweepTextView_sweepDirection, this.sweepDirection);
        this.sweepRepeatMode = typedArrayObtainStyledAttributes.getInt(R$styleable.SweepTextView_sweepRepeatMode, this.sweepRepeatMode);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.SweepTextView_sweepBaseColor, this.gradientColorA);
        int color2 = typedArrayObtainStyledAttributes.getColor(R$styleable.SweepTextView_sweepHighlightColor, this.gradientColorB);
        this.gradientColorA = typedArrayObtainStyledAttributes.getColor(R$styleable.SweepTextView_sweepGradientColorA, color);
        this.gradientColorB = typedArrayObtainStyledAttributes.getColor(R$styleable.SweepTextView_sweepGradientColorB, color2);
        this.gradientCycleLengthPx = C5685n.e(typedArrayObtainStyledAttributes.getDimension(R$styleable.SweepTextView_sweepGradientCycleLength, this.gradientCycleLengthPx), minCycleLengthPx());
        this.gradientAngleDegrees = typedArrayObtainStyledAttributes.getFloat(R$styleable.SweepTextView_sweepGradientAngle, typedArrayObtainStyledAttributes.getFloat(R$styleable.SweepTextView_sweepAngle, this.gradientAngleDegrees));
        int i11 = R$styleable.SweepTextView_sweepGradientSpeed;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            fG = typedArrayObtainStyledAttributes.getFloat(i11, 130.0f) * f10;
        } else {
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SweepTextView_sweepDuration)) {
                fG = (this.gradientCycleLengthPx * 1000.0f) / C5685n.g(typedArrayObtainStyledAttributes.getInt(r7, 1700), 80L);
            } else {
                fG = this.gradientSpeedPxPerSecond;
            }
        }
        this.gradientSpeedPxPerSecond = C5685n.e(fG, minSpeedPxPerSecond());
        typedArrayObtainStyledAttributes.recycle();
    }

    public /* synthetic */ SweepTextView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.textViewStyle : i10);
    }
}
