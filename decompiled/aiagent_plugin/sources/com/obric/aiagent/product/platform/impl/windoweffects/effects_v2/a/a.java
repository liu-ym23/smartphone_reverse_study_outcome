package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a;

import android.content.Context;
import android.graphics.Point;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import bytedanceos.api.DisplayManagerSmt;
import bytedanceos.api.TransactionSmt;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.manager.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.util.ArrayList;

/* JADX INFO: compiled from: RippleEffect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "RippleEffect";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0414a f18900a = null;
    private static final b h = null;
    private static final b i = null;
    private static final e.d j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f18901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowManager f18902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f18903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IBinder f18904e;
    private final f f;
    private volatile int g;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RippleEffect.kt */
    public static final class C0414a {
        public /* synthetic */ C0414a(h r1) {
            this();
        }

        private C0414a() {
        }
    }

    /* JADX INFO: compiled from: RippleEffect.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f18905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f18906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f18907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f18908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final float f18909e;
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
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (Float.compare(this.f18905a, r10.f18905a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f18906b, r10.f18906b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f18907c, r10.f18907c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.f18908d, r10.f18908d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.f18909e, r10.f18909e) == 0) goto L24;
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
            return (((((((((((((((((((((((Float.hashCode(this.f18905a) * 31) + Float.hashCode(this.f18906b)) * 31) + Float.hashCode(this.f18907c)) * 31) + Float.hashCode(this.f18908d)) * 31) + Float.hashCode(this.f18909e)) * 31) + Float.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31) + Float.hashCode(this.i)) * 31) + Float.hashCode(this.j)) * 31) + Float.hashCode(this.k)) * 31) + Float.hashCode(this.l)) * 31) + Float.hashCode(this.m);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("RippleSpec(originFractionX=").append(this.f18905a).append(", originFractionY=").append(this.f18906b).append(", amplitudeDp=").append(this.f18907c).append(", amplitudeRamp=").append(this.f18908d).append(", pulseWidthDp=").append(this.f18909e).append(", travelDistanceMultiplier=").append(this.f).append(", durationMs=").append(this.g).append(", screenDimIntensity=").append(this.h).append(", waveGlowIntensity=").append(this.i).append(", trailDecayLength=").append(this.j).append(", edgeGlowRadiusDp=").append(this.k).append(", edgeGlowColorIntensity=");
            r0.append(this.l).append(", edgeGlowIntensity=").append(this.m).append(')');
            return r0.toString();
        }

        public b(float r1, float r2, float r3, float r4, float r5, float r6, long r7, float r9, float r10, float r11, float r12, float r13, float r14) {
            this.f18905a = r1;
            this.f18906b = r2;
            this.f18907c = r3;
            this.f18908d = r4;
            this.f18909e = r5;
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
            return this.f18905a;
        }

        public final float b() {
            return this.f18906b;
        }

        public final float c() {
            return this.f18907c;
        }

        public final float d() {
            return this.f18908d;
        }

        public final float e() {
            return this.f18909e;
        }

        public final float f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }

        public final float h() {
            return this.h;
        }

        public final float i() {
            return this.i;
        }

        public final float j() {
            return this.j;
        }

        public final float k() {
            return this.k;
        }

        public final float l() {
            return this.l;
        }

        public final float m() {
            return this.m;
        }
    }

    /* JADX INFO: compiled from: RippleEffect.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f18911b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f18910a == r6.f18910a) goto L12;
            return false;
        L12:
            if (this.f18911b == r6.f18911b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f18910a) * 31) + Integer.hashCode(this.f18911b);
        }

        public String toString() {
            return "ScreenSize(width=" + this.f18910a + ", height=" + this.f18911b + ')';
        }

        public c(int r1, int r2) {
            this.f18910a = r1;
            this.f18911b = r2;
        }

        public final int a() {
            return this.f18910a;
        }

        public final int b() {
            return this.f18911b;
        }
    }

    /* JADX INFO: renamed from: lambda$4hvJdb2aAHZacc6RH6Kc-bAu_-s, reason: not valid java name */
    public static /* synthetic */ x m244lambda$4hvJdb2aAHZacc6RH6KcbAu_s(int r0, a r1, z.f r2, IBinder r3, b r4, float r5, float r6, float r7, String r8, Object r9, Object r10) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ x lambda$VtSIN6YWou_MYmYAyc_dy_5zI44(Runnable r0, int r1, a r2, IBinder r3, boolean r4, Throwable r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean lambda$XcTknFYdkRMqrRct1lt1p2ZD1Nk() {
        return h();
    }

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        this.f18901b = r5;
        Object r6 = r5.getSystemService("window");
        if (ZeusTransformUtils.instanceOf(r6, WindowManager.class) == false) goto L5;
        WindowManager r7 = (WindowManager) ZeusTransformUtils.preCheckCast(r6, WindowManager.class, "com.obric.aiagent.plugin");
    L6:
        this.f18902c = r7;
        this.f = g.a($$Lambda$a$XcTknFYdkRMqrRct1lt1p2ZD1Nk.INSTANCE);
        return;
    L5:
        r7 = null;
        goto L6
    }

    private final boolean c() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean h() {
        return ObricProductSdk.INSTANCE.featureService().isGlobalEffectStopLayerEffective();
    }

    public final boolean a() {
        boolean r2 = true;
        if (this.f18904e == null) goto L26;
        return true;
    L26:
        n.a r3 = n.f38560a;     // Catch: Throwable -> L8
        Object r4 = n.f(DisplayManagerSmt.getInstance().getDisplayToken(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f18901b, 0));     // Catch: Throwable -> L8
    L10:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L14;
        ILogDepend.Companion.w(TAG, "Failed to get display token", r5);
    L14:
        if (n.a(r4) == false) goto L20;
        n.a r6 = n.f38560a;
        IBinder r7 = (IBinder) ZeusTransformUtils.preCheckCast(r4, IBinder.class, "com.obric.aiagent.plugin");
        this.f18904e = r7;
        if (r7 != null) goto L19;
        r2 = false;
    L19:
        Object r8 = n.f(Boolean.valueOf(r2));
    L22:
        if (n.b(r8) == false) goto L25;
        r8 = false;
    L25:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L20:
        r8 = n.f(r4);
    L8:
        th = move-exception;
        n.a r9 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L10
    }

    public final void a(boolean r3, String r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        o.e(r4, "windowLayerName");
        a(h, r3, r4, r6);
    }

    public final void b(boolean r3, String r4, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        o.e(r4, "windowLayerName");
        a(i, r3, r4, r6);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a$c] */
    private final void a(final b r24, boolean r25, String r26, Runnable r27) {
        final Runnable r10 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r27, Runnable.class, "com.obric.aiagent.plugin");
        final IBinder r11 = d();
        if (r11 != null) goto L8;
        ILogDepend.Companion.w(TAG, "playRipple: displayToken is null");
        if (r10 == null) goto L10;
        r10.run();
        return;
    L10:
        return;
    L8:
        final int r12 = f();
        e();
        final z.f r8 = new z.f();
        r8.f38504a = g();
        ILogDepend.Companion.i(TAG, "playRipple: screenWidth=" + ((c) ZeusTransformUtils.preCheckCast(r8.f38504a, c.class, "com.obric.aiagent.plugin")).a() + ", screenHeight=" + ((c) ZeusTransformUtils.preCheckCast(r8.f38504a, c.class, "com.obric.aiagent.plugin")).b() + ", globalEffectStopLayerEffective=" + c() + ", skipWindowLayer=" + r25 + ", windowLayerName=" + r26);
        final float r13 = com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a.a.a.a(r24.c());
        final float r14 = com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a.a.a.a(r24.e());
        final float r15 = com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a.a.a.a(r24.k());
        TransactionSmt.getInstance().setAnimationProperty(r11, a(r24.g(), r25, r26));
        TransactionSmt.getInstance().setAnimationProperty(r11, a(r24, (c) ZeusTransformUtils.preCheckCast(r8.f38504a, c.class, "com.obric.aiagent.plugin"), 0.0f, r13, r14, r15));
        TransactionSmt.getInstance().startAnimation(r11);
        this.f18903d = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a().a(1.0f), 0.0f, 1.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.g.b.a((int) r24.g(), 0, j), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$a$4hvJdb2aAHZacc6RH6KcbAu_s(r12, this, r8, r11, r24, r13, r14, r15)).a(new $$Lambda$a$VtSIN6YWou_MYmYAyc_dy_5zI44(r10, r12, this, r11)).a().a();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a$c, java.lang.Object] */
    private static final x a(int r12, a r13, z.f r14, IBinder r15, b r16, float r17, float r18, float r19, String r20, Object r21, Object r22) {
        IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r15, IBinder.class, "com.obric.aiagent.plugin");
        o.e(r20, "<unused var>");
        o.e(r21, "value");
        o.e(r22, "<unused var>");
        if (r12 != r13.g) goto L5;
        float r8 = d.l.n.a(((Float) ZeusTransformUtils.preCheckCast(r21, Float.class, "com.obric.aiagent.plugin")).floatValue(), 0.0f, 1.0f);
        ?? r1 = r13.g();
        if (o.a(r1, r14.f38504a) == true) goto L9;
        r14.f38504a = r1;
        ILogDepend.Companion.i(TAG, "playRipple: screenSize changed, screenWidth=" + ((c) ZeusTransformUtils.preCheckCast(r14.f38504a, c.class, "com.obric.aiagent.plugin")).a() + ", screenHeight=" + ((c) ZeusTransformUtils.preCheckCast(r14.f38504a, c.class, "com.obric.aiagent.plugin")).b());
    L9:
        TransactionSmt.getInstance().setAnimationProperty(r2, r13.a(r16, (c) ZeusTransformUtils.preCheckCast(r14.f38504a, c.class, "com.obric.aiagent.plugin"), r8, r17, r18, r19));
        return x.f38692a;
    L5:
        return x.f38692a;
    }

    private static final x a(Runnable r0, int r1, a r2, IBinder r3, boolean r4, Throwable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r0, Runnable.class, "com.obric.aiagent.plugin");
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L6;
        r6.run();
    L6:
        if (r1 != r2.g) goto L8;
        r2.a(r7, r1);
        return x.f38692a;
    L8:
        return x.f38692a;
    }

    public final void b() {
        d r0 = this.f18903d;
        this.f18903d = null;
        this.g++;
        if (r0 == null) goto L5;
        r0.a(false);
    L5:
        IBinder r2 = this.f18904e;
        if (r2 == null) goto L9;
        TransactionSmt.getInstance().stopAnimation(r2);
        return;
    }

    private final IBinder d() {
        if (this.f18904e != null) goto L5;
        a();
    L5:
        IBinder r3 = this.f18904e;
        if (r3 != null) goto L8;
        ILogDepend.Companion.w(TAG, "Display token not initialized");
    L8:
        return r3;
    }

    private final ArrayList<Pair<String, String>> a(long r5, boolean r7, String r8) {
        ArrayList<Pair<String, String>> r6 = p.d(new Pair[]{new Pair("shader", "\n            uniform vec2 uResolution;\n            uniform vec2 uOrigin;\n            uniform float uProgress;\n            uniform float uScreenDimIntensity;\n            uniform float uTravelDistance;\n            uniform float uAmplitude;\n            uniform float uAmplitudeRamp;\n            uniform float uDeformationIntensity;\n            uniform float uPulseWidth;\n            uniform float uWaveGlowIntensity;\n            uniform float uTrailDecayLength;\n            uniform float uEdgeGlowRadius;\n            uniform float uEdgeGlowColorIntensity;\n            uniform float uEdgeGlowIntensity;\n            uniform shader uScreen;\n\n            const vec3 RIPPLE_TINT = vec3(0.18, 0.34, 0.72);\n            const vec3 FILL_GLOW_COLOR = vec3(0.03, 0.08, 0.18);\n            const float FREQUENCY = 4.0;\n            const float SCREEN_DIM_FADE_IN_END = 0.2;\n            const float SCREEN_DIM_FADE_OUT_START = 0.6;\n            const vec3 EDGE_GLOW_COLOR = vec3(0.72, 0.88, 1.0);\n            const float EDGE_GLOW_THRESHOLD = 0.1;\n            const float EDGE_GLOW_SOFTNESS = 0.08;\n            const float TRAIL_DISPLACEMENT = 0.32;\n            const float INTERIOR_GLOW_FALLOFF = 2.4;\n            const float FILL_GLOW_DECAY = 3.5;\n\n            // 锚定谐波：扣掉 t=0 的初始值，避免开场跳变。\n            float harmonic(float t, float ratio, float phase, float weight) {\n                return (sin(t * ratio + phase) - sin(phase)) * weight;\n            }\n\n            float luminance(vec3 color) {\n                return dot(color, vec3(0.299, 0.587, 0.114));\n            }\n\n            float localContrastEdge(vec2 position, float radiusPx, float centerLuma) {\n                vec2 texel = vec2(max(radiusPx, 0.5));\n\n                float minLuma = centerLuma;\n                float maxLuma = centerLuma;\n\n                float luma = luminance(uScreen.eval(clamp(position + texel * vec2(-1.0, 0.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(1.0, 0.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(0.0, -1.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n                luma = luminance(uScreen.eval(clamp(position + texel * vec2(0.0, 1.0), vec2(0.0), uResolution)).rgb);\n                minLuma = min(minLuma, luma);\n                maxLuma = max(maxLuma, luma);\n\n                return maxLuma - minLuma;\n            }\n\n            vec4 main(vec2 fragCoord) {\n                vec2 position = fragCoord;\n                vec2 delta = position - uOrigin;\n                float dist = length(delta);\n                vec2 dir = dist > 0.0001 ? delta / dist : vec2(0.0, 1.0);\n\n                // 波形包络：前沿高斯环 + 已经过区域的指数拖尾。\n                float waveFront = uProgress * uTravelDistance;\n                float ringOffset = (dist - waveFront) / uPulseWidth;\n                float ring = exp(-ringOffset * ringOffset);\n                float frontActivation = smoothstep(0.0, uPulseWidth * 0.9, waveFront);\n                float passedFront = smoothstep(-uPulseWidth * 0.5, uPulseWidth * 1.5, waveFront - dist);\n                float trailDecayDistance = uPulseWidth * max(uTrailDecayLength, 0.001);\n                float trail = passedFront * exp(-max(waveFront - dist, 0.0) / trailDecayDistance);\n\n                // 按半径延迟波相位，让波纹从 origin 向外传播。\n                float waveTime = max(0.0, uProgress - dist / max(uTravelDistance, 1.0));\n                float w = waveTime * FREQUENCY;\n                float totalWave = sin(w)\n                                + harmonic(w, 0.82, -1.45, 0.52)\n                                + harmonic(w, 1.27,  0.72, 0.28);\n\n                // 按包络做径向位移；AGSL 采样使用像素坐标，区别于 WebGL 的归一化坐标。\n                float displacementMask = max(ring, trail * TRAIL_DISPLACEMENT) * frontActivation;\n                float displacement = (totalWave * uAmplitude + dist * uAmplitudeRamp * abs(totalWave))\n                                     * displacementMask\n                                     * uDeformationIntensity;\n                vec2 warpedPos = clamp(position + dir * displacement, vec2(0.0), uResolution);\n\n                // 颜色层：形变后的原图 + 波纹染色 + 内部填充 glow。\n                vec3 screenColor = uScreen.eval(warpedPos).rgb;\n                float screenDim = uScreenDimIntensity\n                                * smoothstep(0.0, SCREEN_DIM_FADE_IN_END, uProgress)\n                                * (1.0 - smoothstep(SCREEN_DIM_FADE_OUT_START, 1.0, uProgress));\n                vec3 baseColor = screenColor * (1.0 - screenDim);\n                vec3 rippleTint = RIPPLE_TINT * (0.45 + 0.55 * max(totalWave, 0.0));\n                float interiorGlow = exp(-pow(dist / (waveFront + 1.0), INTERIOR_GLOW_FALLOFF));\n                vec3 fillGlow = FILL_GLOW_COLOR * interiorGlow * exp(-uProgress * FILL_GLOW_DECAY);\n\n                vec3 edgeGlow = vec3(0.0);\n                if (uEdgeGlowIntensity > 0.0) {\n                    float highlightFade = 1.0 - smoothstep(0.78, 1.0, uProgress);\n                    float highlightMask = clamp(ring * 0.85 + trail * 0.12, 0.0, 1.0)\n                                        * frontActivation\n                                        * highlightFade;\n                    float centerLuma = luminance(screenColor);\n                    float edgeFine = localContrastEdge(warpedPos, uEdgeGlowRadius, centerLuma);\n                    float edgeWide = localContrastEdge(warpedPos, uEdgeGlowRadius * 2.4, centerLuma) * 0.65;\n                    float edgeCore = smoothstep(\n                        EDGE_GLOW_THRESHOLD,\n                        EDGE_GLOW_THRESHOLD + EDGE_GLOW_SOFTNESS,\n                        edgeFine);\n                    float edgeHalo = smoothstep(\n                        EDGE_GLOW_THRESHOLD,\n                        EDGE_GLOW_THRESHOLD + EDGE_GLOW_SOFTNESS,\n                        edgeWide);\n                    float edgeMask = clamp(edgeCore * (1.0 + edgeHalo * 0.45), 0.0, 1.0);\n                    edgeMask = pow(edgeMask, 1.05);\n                    edgeGlow = EDGE_GLOW_COLOR * uEdgeGlowColorIntensity * edgeMask * highlightMask * uEdgeGlowIntensity;\n                }\n\n                vec3 waveGlow = rippleTint * (ring + trail);\n                vec3 color = baseColor + (waveGlow + fillGlow) * uWaveGlowIntensity + edgeGlow;\n\n                return vec4(color, 1.0);\n            }\n        "), new Pair("duration", String.valueOf(r5))});
        if (r7 == true) goto L5;
    L7:
        return r6;
    L5:
        if (c() == false) goto L7;
        r6.add(new Pair("part", "1"));
        r6.add(new Pair("stop_layer", r8));
        goto L7
    }

    private final void a(ArrayList<Pair<String, String>> r2, float r3) {
        r2.add(new Pair("uniform_float", String.valueOf(r3)));
    }

    private final void e() {
        d r0 = this.f18903d;
        if (r0 == null) goto L5;
        r0.a(true);
    L5:
        this.f18903d = null;
    }

    private final int f() {
        this.g++;
        return this.g;
    }

    private final ArrayList<Pair<String, String>> a(b r8, c r9, float r10, float r11, float r12, float r13) {
        float r0 = r9.a();
        float r14 = r9.b();
        float r1 = r8.a() * r0;
        float r2 = r8.b() * r14;
        float r3 = ((float) Math.hypot(r0, r14)) * r8.f();
        float r5 = 1.0f;
        if (r0 > r14) goto L5;
    L8:
        ArrayList<Pair<String, String>> r4 = new ArrayList(16);
        a(r4, r0);
        a(r4, r14);
        a(r4, r1);
        a(r4, r2);
        a(r4, r10);
        a(r4, r8.h());
        a(r4, r3);
        a(r4, r11);
        a(r4, r8.d());
        a(r4, r5);
        a(r4, r12);
        a(r4, r8.i());
        a(r4, r8.j());
        a(r4, r13);
        a(r4, r8.l());
        a(r4, r8.m());
        return r4;
    L5:
        if (c() == true) goto L8;
        r5 = 0.0f;
        goto L8
    }

    private final c g() {
        Point r1 = new Point();
        n.a r2 = n.f38560a;     // Catch: Throwable -> L11
        WindowManager r3 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f18902c;     // Catch: Throwable -> L11
        if (r3 == null) goto L8;
        Display r4 = r3.getDefaultDisplay();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        r4.getRealSize(r1);     // Catch: Throwable -> L11
        x r5 = x.f38692a;     // Catch: Throwable -> L11
    L9:
        Object r6 = n.f(r5);     // Catch: Throwable -> L11
    L13:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L17;
        ILogDepend.Companion.w(TAG, "getRealScreenSize failed, fallback to displayMetrics", r7);
    L17:
        if (r1.x > 0) goto L19;
    L22:
        DisplayMetrics r8 = ZeusTransformUtils.getResources(this.f18901b, "com.obric.aiagent.plugin").getDisplayMetrics();
        return new c(r8.widthPixels, r8.heightPixels);
    L19:
        if (r1.y <= 0) goto L22;
        return new c(r1.x, r1.y);
    L8:
        r5 = null;
    L11:
        th = move-exception;
        n.a r9 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L13
    }

    private final void a(IBinder r3, int r4) {
        IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        if (r4 == this.g) goto L5;
        return;
    L5:
        TransactionSmt.getInstance().stopAnimation(r5);
        this.f18903d = null;
    }

    static {
        f18900a = new C0414a(null);
        h = new b(0.5f, 1.2f, 70.0f, 0.5f, 70.0f, 2.2f, 1500, 0.0f, 1.0f, 2.0f, 1.0f, 1.0f, 0.0f);
        i = new b(0.5f, 0.5f, 10.0f, 0.2f, 70.0f, 1.0f, 1500, 0.16f, 0.3f, 1.5f, 1.0f, 0.5f, 1.0f);
        j = e.d.k;
    }
}
