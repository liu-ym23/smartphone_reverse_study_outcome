package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.crypto.platform.PlatformConst;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.manager.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RippleEffectView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RippleEffectView extends View {
    private static final c CAPTURE_SPEC = null;
    public static final a Companion = null;
    private static final e.d DEFAULT_EASING = null;
    private static final List<b> DISABLED_DEVICE_PROFILES = null;
    private static final float MIN_VIEW_INTENSITY = 0.9f;
    private static final String RIPPLE_COLOR_SHADER_AGSL = "\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uTravelDistance;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n\n            const vec3 RIPPLE_BLUE = vec3(0.051, 0.447, 1.0);\n            const vec3 RIPPLE_CYAN = vec3(0.608, 0.863, 1.0);\n            const float FREQUENCY = 4.0;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float CREST_ALPHA = 0.44;\n            const float SHOULDER_ALPHA = 0.16;\n            const float HALO_ALPHA = 0.09;\n            const float RIPPLE_LINE_ALPHA = 0.18;\n            const float TRAIL_ALPHA = 0.12;\n            const float WASH_ALPHA = 0.04;\n            const float DISPLACEMENT_ALPHA = 0.08;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float crest = exp(-ringOffset * ringOffset * 5.5);\n                float shoulder = exp(-ringOffset * ringOffset * 1.25);\n                float haloOffset = (dist - waveFront) / (uPulseWidth * 1.8);\n                float halo = exp(-haloOffset * haloOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n                float behindFront = max(waveFront - dist, 0.0) / max(uPulseWidth, 1.0);\n                float washDecayDistance = uPulseWidth * max(uTrailDecayLength * 1.7, 0.001);\n                float wash = passedFront * exp(-max(waveFront - dist, 0.0) / washDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n                float rippleLineWave = pow(0.5 + 0.5 * sin(behindFront * 13.0 + totalWave * 0.65), 3.0);\n                float rippleLines = trail * rippleLineWave * exp(-behindFront / max(uTrailDecayLength * 1.2, 0.001));\n\n                float displacementMask = max(shoulder, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float crestShape = clamp(crest * frontActivation, 0.0, 1.0);\n                float shoulderShape = clamp(shoulder * frontActivation, 0.0, 1.0);\n                float haloShape = clamp(halo * frontActivation, 0.0, 1.0);\n                float trailShape = clamp(trail * frontActivation, 0.0, 1.0);\n                float rippleLineShape = clamp(rippleLines * frontActivation, 0.0, 1.0);\n                float washShape = clamp(\n                    wash\n                        * frontActivation\n                        * smoothstep(0.02, 0.18, uProgress)\n                        * (1.0 - smoothstep(0.78, 1.0, uProgress)),\n                    0.0,\n                    1.0);\n\n                // 颜色层：使用豆包光晕主蓝色。清晰 crest + 细纹拖尾负责涟漪感，\n                // 低 alpha halo / wash 只补偿 View 没有 ±depth 形变时的视觉裁薄。\n                float waveBoost = smoothstep(-0.2, 1.0, totalWave);\n                vec3 waveColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.28 + 0.38 * waveBoost);\n                vec3 haloColor = mix(RIPPLE_BLUE, RIPPLE_CYAN, 0.18);\n                float waveAlpha = (\n                    crestShape * CREST_ALPHA\n                    + shoulderShape * SHOULDER_ALPHA\n                    + haloShape * HALO_ALPHA\n                    + rippleLineShape * RIPPLE_LINE_ALPHA\n                    + trailShape * TRAIL_ALPHA\n                    + washShape * WASH_ALPHA\n                    + displacementMask * DISPLACEMENT_ALPHA\n                ) * uWaveGlowIntensity;\n                float alpha = clamp(waveAlpha, 0.0, 0.54);\n\n                vec3 color = mix(\n                    haloColor,\n                    waveColor,\n                    clamp(crestShape + rippleLineShape * 0.75 + shoulderShape * 0.35, 0.0, 1.0));\n                return vec4(color * alpha, alpha);\n            }\n        ";
    private static final float VIEW_INTENSITY_MULTIPLIER = 1.65f;
    private static final float VIEW_ORIGIN_OVERFLOW_MULTIPLIER = 0.95f;
    private static final float VIEW_PULSE_WIDTH_MULTIPLIER = 1.65f;
    private static final c WAKE_UP_SPEC = null;
    private c activeSpec;
    private d animationManager;
    private float originX;
    private float originY;
    private int playGeneration;
    private float progress;
    private float pulseWidth;
    private final RuntimeShader rippleShader;
    private final Paint shaderPaint;
    private final boolean shouldRender;
    private float travelDistance;
    private float viewIntensity;

    /* JADX INFO: compiled from: RippleEffectView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final boolean a() {
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(RippleEffectView.access$getDISABLED_DEVICE_PROFILES$cp(), Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
        L7:
            Iterator r5 = r4.iterator();
        L9:
            if (r5.hasNext() == false) goto L18;
            if (((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")).a() == false) goto L9;
            return false;
        L18:
            return true;
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: compiled from: RippleEffectView.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f18914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f18915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f18916d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f18913a, r6.f18913a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f18914b, r6.f18914b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f18915c, r6.f18915c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f18916d, r6.f18916d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f18913a.hashCode() * 31) + this.f18914b.hashCode()) * 31) + this.f18915c.hashCode()) * 31) + this.f18916d.hashCode();
        }

        public String toString() {
            return "DeviceProfile(manufacturer=" + this.f18913a + ", brand=" + this.f18914b + ", model=" + this.f18915c + ", device=" + this.f18916d + ')';
        }

        public b(String r2, String r3, String r4, String r5) {
            o.e(r2, "manufacturer");
            o.e(r3, PlatformConst.BUNDLE_KEY_BRAND);
            o.e(r4, "model");
            o.e(r5, "device");
            this.f18913a = r2;
            this.f18914b = r3;
            this.f18915c = r4;
            this.f18916d = r5;
        }

        public final boolean a() {
            String r0 = Build.MANUFACTURER;
            o.c(r0, "MANUFACTURER");
            if (o.a(com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.a.a(r0), this.f18913a) == false) goto L11;
            String r1 = Build.BRAND;
            o.c(r1, "BRAND");
            if (o.a(com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.a.a(r1), this.f18914b) == false) goto L11;
            String r2 = Build.MODEL;
            o.c(r2, "MODEL");
            if (o.a(com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.a.a(r2), this.f18915c) == false) goto L11;
            String r3 = Build.DEVICE;
            o.c(r3, "DEVICE");
            if (o.a(com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.a.a(r3), this.f18916d) == false) goto L11;
            return true;
        L11:
            return false;
        }
    }

    /* JADX INFO: compiled from: RippleEffectView.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f18917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f18918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f18919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f18920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f18921e;
        private final float f;
        private final long g;
        private final float h;
        private final float i;
        private final float j;
        private final float k;
        private final float l;
        private final float m;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
            if (Float.compare(this.f18917a, r10.f18917a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f18918b, r10.f18918b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f18919c, r10.f18919c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f18920d, r10.f18920d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f18921e, r10.f18921e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f, r10.f) == 0) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (Float.compare(this.h, r10.h) == 0) goto L33;
            return false;
        L33:
            if (Float.compare(this.i, r10.i) == 0) goto L36;
            return false;
        L36:
            if (Float.compare(this.j, r10.j) == 0) goto L39;
            return false;
        L39:
            if (Float.compare(this.k, r10.k) == 0) goto L42;
            return false;
        L42:
            if (Float.compare(this.l, r10.l) == 0) goto L45;
            return false;
        L45:
            if (Float.compare(this.m, r10.m) == 0) goto L47;
            return false;
        L47:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((((((((Float.hashCode(this.f18917a) * 31) + Float.hashCode(this.f18918b)) * 31) + Float.hashCode(this.f18919c)) * 31) + Float.hashCode(this.f18920d)) * 31) + Float.hashCode(this.f18921e)) * 31) + Float.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + Float.hashCode(this.i)) * 31) + Float.hashCode(this.j)) * 31) + Float.hashCode(this.k)) * 31) + Float.hashCode(this.l)) * 31) + Float.hashCode(this.m);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("RippleSpec(originFractionX=").append(this.f18917a).append(", originFractionY=").append(this.f18918b).append(", amplitudeDp=").append(this.f18919c).append(", amplitudeRamp=").append(this.f18920d).append(", pulseWidthDp=").append(this.f18921e).append(", travelDistanceMultiplier=").append(this.f).append(", durationMs=").append(this.g).append(", screenDimIntensity=").append(this.h).append(", waveGlowIntensity=").append(this.i).append(", trailDecayLength=").append(this.j).append(", edgeGlowRadiusDp=").append(this.k).append(", edgeGlowColorIntensity=");
            r0.append(this.l).append(", edgeGlowIntensity=").append(this.m).append(')');
            return r0.toString();
        }

        public c(float r1, float r2, float r3, float r4, float r5, float r6, long r7, float r9, float r10, float r11, float r12, float r13, float r14) {
            this.f18917a = r1;
            this.f18918b = r2;
            this.f18919c = r3;
            this.f18920d = r4;
            this.f18921e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
        }

        public final float a() {
            return this.f18917a;
        }

        public final float b() {
            return this.f18918b;
        }

        public final float c() {
            return this.f18921e;
        }

        public final float d() {
            return this.f;
        }

        public final long e() {
            return this.g;
        }

        public final float f() {
            return this.i;
        }

        public final float g() {
            return this.j;
        }
    }

    public RippleEffectView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public RippleEffectView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$-Ef5iectIlLJT2Rp1fB2xju0czs, reason: not valid java name */
    public static /* synthetic */ x m246lambda$Ef5iectIlLJT2Rp1fB2xju0czs(int r0, RippleEffectView r1, String r2, Object r3, Object r4) {
        return playRipple$lambda$1(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$aqDJX-gLTVUenGR2x4Z0N3MunV0, reason: not valid java name */
    public static /* synthetic */ x m247lambda$aqDJXgLTVUenGR2x4Z0N3MunV0(Runnable r0, int r1, RippleEffectView r2, boolean r3, Throwable r4) {
        return playRipple$lambda$2(r0, r1, r2, r3, r4);
    }

    public final void playCaptureEffect() {
        playCaptureEffect$default(this, null, 1, null);
    }

    public final void playWakeUpEffect() {
        playWakeUpEffect$default(this, null, 1, null);
    }

    public /* synthetic */ RippleEffectView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ List access$getDISABLED_DEVICE_PROFILES$cp() {
        return DISABLED_DEVICE_PROFILES;
    }

    public RippleEffectView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        RuntimeShader r8 = new RuntimeShader(RIPPLE_COLOR_SHADER_AGSL);
        this.rippleShader = r8;
        Paint r9 = new Paint(1);
        r9.setShader((Shader) ZeusTransformUtils.preCheckCast(r8, Shader.class, "com.obric.aiagent.plugin"));
        this.shaderPaint = r9;
        this.activeSpec = WAKE_UP_SPEC;
        this.shouldRender = Companion.a();
        this.viewIntensity = 1.0f;
        hideWhenIdle();
        setLayerType(2, null);
    }

    private final void setProgress(float r3) {
        float r4 = n.a(r3, 0.0f, 1.0f);
        if (this.progress != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.progress = r4;
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ void playWakeUpEffect$default(RippleEffectView r1, Runnable r2, int r3, Object r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.playWakeUpEffect(r5);
    }

    public final void playWakeUpEffect(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        playRipple(WAKE_UP_SPEC, r4);
    }

    public static /* synthetic */ void playCaptureEffect$default(RippleEffectView r1, Runnable r2, int r3, Object r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.playCaptureEffect(r5);
    }

    public final void playCaptureEffect(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        playRipple(CAPTURE_SPEC, r4);
    }

    public final void stop() {
        d r0 = this.animationManager;
        this.animationManager = null;
        this.playGeneration++;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        setProgress(0.0f);
        hideWhenIdle();
    }

    public final boolean isPlaying() {
        if (this.animationManager == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.animationManager == null) goto L6;
        updateGeometry(this.activeSpec);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        o.e(r5, "canvas");
        super.onDraw(r5);
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        if (getWidth() > 0) goto L7;
        return;
    L7:
        if (getHeight() <= 0) goto L13;
        this.rippleShader.setFloatUniform("uResolution", getWidth(), getHeight());
        this.rippleShader.setFloatUniform("uOrigin", this.originX, this.originY);
        this.rippleShader.setFloatUniform("uProgress", this.progress);
        this.rippleShader.setFloatUniform("uTravelDistance", this.travelDistance);
        this.rippleShader.setFloatUniform("uPulseWidth", this.pulseWidth);
        this.rippleShader.setFloatUniform("uWaveGlowIntensity", this.viewIntensity);
        this.rippleShader.setFloatUniform("uTrailDecayLength", this.activeSpec.g());
        r5.drawPaint(this.shaderPaint);
        return;
    }

    private final void playRipple(c r13, Runnable r14) {
        final Runnable r15 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r14, Runnable.class, "com.obric.aiagent.plugin");
        if (this.shouldRender == true) goto L7;
        if (r15 == null) goto L9;
        r15.run();
        return;
    L9:
        return;
    L7:
        final int r0 = nextGeneration();
        cancelRunningAnimation();
        this.activeSpec = r13;
        updateGeometry(r13);
        setProgress(0.0f);
        setVisibility(0);
        this.animationManager = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a().a(1.0f), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a((int) r13.e(), 0, DEFAULT_EASING), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$RippleEffectView$Ef5iectIlLJT2Rp1fB2xju0czs(r0, this)).a(new $$Lambda$RippleEffectView$aqDJXgLTVUenGR2x4Z0N3MunV0(r15, r0, this)).a().a();
    }

    private static final x playRipple$lambda$1(int r1, RippleEffectView r2, String r3, Object r4, Object r5) {
        o.e(r3, "<unused var>");
        o.e(r4, "value");
        o.e(r5, "<unused var>");
        if (r1 != r2.playGeneration) goto L5;
        r2.setProgress(n.a(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue(), 0.0f, 1.0f));
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    private static final x playRipple$lambda$2(Runnable r0, int r1, RippleEffectView r2, boolean r3, Throwable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r0, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.run();
    L6:
        if (r1 != r2.playGeneration) goto L8;
        r2.cleanupAnimation(r1);
        return x.f38692a;
    L8:
        return x.f38692a;
    }

    private final void updateGeometry(c r7) {
        float r0 = getWidth();
        float r1 = getHeight();
        this.pulseWidth = com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a.a.a.a(r7.c()) * 1.65f;
        this.originX = r7.a() * r0;
        this.originY = compensateClippedOrigin(r7.b() * r1, r1);
        this.travelDistance = ((float) Math.hypot(r0, r1)) * r7.d();
        this.viewIntensity = n.a(r7.f() * 1.65f, MIN_VIEW_INTENSITY);
    }

    private final float compensateClippedOrigin(float r2, float r3) {
        float r1 = this.pulseWidth * VIEW_ORIGIN_OVERFLOW_MULTIPLIER;
        if (r2 <= r3) goto L6;
        return r3 + n.b(r2 - r3, r1);
    L6:
        if (r2 < 0.0f) goto L8;
        return r2;
    L8:
        return -n.b(0.0f - r2, r1);
    }

    private final void cancelRunningAnimation() {
        d r0 = this.animationManager;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        this.animationManager = null;
    }

    private final int nextGeneration() {
        int r0 = this.playGeneration + 1;
        this.playGeneration = r0;
        return r0;
    }

    private final void cleanupAnimation(int r2) {
        if (r2 == this.playGeneration) goto L5;
        return;
    L5:
        this.animationManager = null;
        setProgress(0.0f);
        hideWhenIdle();
    }

    private final void hideWhenIdle() {
        if (this.shouldRender == false) goto L5;
        int r0 = 4;
    L6:
        setVisibility(r0);
        return;
    L5:
        r0 = 8;
        goto L6
    }

    static {
        Companion = new a(null);
        WAKE_UP_SPEC = new c(0.5f, 1.2f, 70.0f, 0.5f, 70.0f, 2.2f, 1500, 0.0f, 1.0f, 2.0f, 1.0f, 1.0f, 0.0f);
        CAPTURE_SPEC = new c(0.5f, 0.5f, 10.0f, 0.2f, 70.0f, 1.0f, 1500, 0.16f, 0.3f, 1.5f, 1.0f, 0.5f, 1.0f);
        DEFAULT_EASING = e.d.k;
        DISABLED_DEVICE_PROFILES = p.a(new b("shenqijiyuan", "nubia", "p0210", IFeatureServiceKt.PRODUCT_NERIDA));
    }
}
