package com.obric.agent.intents.findphone;

import android.graphics.Color;
import android.graphics.RuntimeShader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FluidColorfulBlobShader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FluidColorfulBlobShader extends RuntimeShader {
    private static final float BASE_RADIUS = 0.6f;
    private static final float BREATH_AMPLITUDE = 0.03f;
    public static final b Companion = null;
    private static final a DAY = null;
    private static final float GLOBAL_ANGLE_SPEED = -0.3f;
    private static final a NIGHT = null;
    public static final String SHADER = "\n            uniform float2 uResolution;\n            uniform float4 uBlob0;\n            uniform float4 uBlob1;\n            uniform float4 uBlob2;\n            uniform float4 uBlob3;\n            layout(color) uniform half4 uColor0;\n            layout(color) uniform half4 uColor1;\n            layout(color) uniform half4 uColor2;\n            layout(color) uniform half4 uColor3;\n            layout(color) uniform half4 uBackground;\n\n            float interleavedGradientNoise(float2 fragCoord) {\n                float2 pixel = floor(fragCoord);\n                return fract(52.9829189 * fract(0.06711056 * pixel.x + 0.00583715 * pixel.y));\n            }\n\n            float3 computeBlobContribution(float2 uv, float4 blob, half4 color,\n                                           inout float3 accColor, inout float accWeight) {\n                float2 delta = uv - blob.xy;\n                float weightBase = exp(dot(delta, delta) * blob.z);\n                float weight = weightBase * color.a;\n                accColor += color.rgb * weight;\n                accWeight += weight;\n                return accColor;\n            }\n\n            float3 getBaseColor(float2 uv) {\n                float3 accColor = float3(0.0);\n                float accWeight = 0.0;\n\n                computeBlobContribution(uv, uBlob0, uColor0, accColor, accWeight);\n                computeBlobContribution(uv, uBlob1, uColor1, accColor, accWeight);\n                computeBlobContribution(uv, uBlob2, uColor2, accColor, accWeight);\n                computeBlobContribution(uv, uBlob3, uColor3, accColor, accWeight);\n\n                float3 blobContent = accColor / (accWeight + 0.0001);\n                float alpha = smoothstep(0.0, 0.85, accWeight);\n\n                return mix(uBackground.rgb, blobContent, alpha);\n            }\n\n            float4 main(float2 fragCoord) {\n                float2 uv = (fragCoord - 0.5 * uResolution) / uResolution.y;\n                float3 baseColor = getBaseColor(uv);\n                float dither = interleavedGradientNoise(fragCoord) - 0.5;\n                float3 finalColor = saturate(baseColor + dither / 255.0);\n                return float4(finalColor, 1.0);\n            }\n        ";
    private static final float SPREAD_BASE = 0.4f;
    private static final List<b.a> blobSpecs = null;
    private float time;

    /* JADX INFO: compiled from: FluidColorfulBlobShader.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f14683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f14684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f14685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f14686d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f14687e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f14683a == r6.f14683a) goto L12;
            return false;
        L12:
            if (this.f14684b == r6.f14684b) goto L15;
            return false;
        L15:
            if (this.f14685c == r6.f14685c) goto L18;
            return false;
        L18:
            if (this.f14686d == r6.f14686d) goto L21;
            return false;
        L21:
            if (this.f14687e == r6.f14687e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f14683a) * 31) + Integer.hashCode(this.f14684b)) * 31) + Integer.hashCode(this.f14685c)) * 31) + Integer.hashCode(this.f14686d)) * 31) + Integer.hashCode(this.f14687e);
        }

        public String toString() {
            return "ColorTheme(background=" + this.f14683a + ", color0=" + this.f14684b + ", color1=" + this.f14685c + ", color2=" + this.f14686d + ", color3=" + this.f14687e + ')';
        }

        public a(int r1, int r2, int r3, int r4, int r5) {
            this.f14683a = r1;
            this.f14684b = r2;
            this.f14685c = r3;
            this.f14686d = r4;
            this.f14687e = r5;
        }

        public final int a() {
            return this.f14683a;
        }

        public final int b() {
            return this.f14684b;
        }

        public final int c() {
            return this.f14685c;
        }

        public final int d() {
            return this.f14686d;
        }

        public final int e() {
            return this.f14687e;
        }
    }

    /* JADX INFO: compiled from: FluidColorfulBlobShader.kt */
    public static final class b {

        /* JADX INFO: compiled from: FluidColorfulBlobShader.kt */
        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f14688a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final float f14689b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final float f14690c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final float f14691d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final float f14692e;
            private final float f;
            private final float g;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14688a, r6.f14688a) == true) goto L12;
                return false;
            L12:
                if (Float.compare(this.f14689b, r6.f14689b) == 0) goto L15;
                return false;
            L15:
                if (Float.compare(this.f14690c, r6.f14690c) == 0) goto L18;
                return false;
            L18:
                if (Float.compare(this.f14691d, r6.f14691d) == 0) goto L21;
                return false;
            L21:
                if (Float.compare(this.f14692e, r6.f14692e) == 0) goto L24;
                return false;
            L24:
                if (Float.compare(this.f, r6.f) == 0) goto L27;
                return false;
            L27:
                if (Float.compare(this.g, r6.g) == 0) goto L29;
                return false;
            L29:
                return true;
            }

            public int hashCode() {
                return (((((((((((this.f14688a.hashCode() * 31) + Float.hashCode(this.f14689b)) * 31) + Float.hashCode(this.f14690c)) * 31) + Float.hashCode(this.f14691d)) * 31) + Float.hashCode(this.f14692e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g);
            }

            public String toString() {
                return "BlobSpec(uniformName=" + this.f14688a + ", phaseAngle=" + this.f14689b + ", radiusWeight=" + this.f14690c + ", orbitFrequency=" + this.f14691d + ", orbitPhase=" + this.f14692e + ", sizeFrequency=" + this.f + ", sizePhase=" + this.g + ')';
            }

            public a(String r2, float r3, float r4, float r5, float r6, float r7, float r8) {
                o.e(r2, "uniformName");
                this.f14688a = r2;
                this.f14689b = r3;
                this.f14690c = r4;
                this.f14691d = r5;
                this.f14692e = r6;
                this.f = r7;
                this.g = r8;
            }

            public final String a() {
                return this.f14688a;
            }

            public final float b() {
                return this.f14689b;
            }

            public final float c() {
                return this.f14690c;
            }

            public final float d() {
                return this.f14691d;
            }

            public final float e() {
                return this.f14692e;
            }

            public final float f() {
                return this.f;
            }

            public final float g() {
                return this.g;
            }
        }

        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public static final /* synthetic */ float a(b r0, float r1) {
            return r0.a(r1);
        }

        public final a a() {
            return FluidColorfulBlobShader.access$getDAY$cp();
        }

        public final a b() {
            return FluidColorfulBlobShader.access$getNIGHT$cp();
        }

        private final float a(float r5) {
            return (float) a(Math.sin(r5) * 43758.5453123d);
        }

        private final double a(double r3) {
            return r3 - Math.floor(r3);
        }
    }

    public static final /* synthetic */ a access$getDAY$cp() {
        return DAY;
    }

    public static final /* synthetic */ a access$getNIGHT$cp() {
        return NIGHT;
    }

    public FluidColorfulBlobShader() {
        super("\n            uniform float2 uResolution;\n            uniform float4 uBlob0;\n            uniform float4 uBlob1;\n            uniform float4 uBlob2;\n            uniform float4 uBlob3;\n            layout(color) uniform half4 uColor0;\n            layout(color) uniform half4 uColor1;\n            layout(color) uniform half4 uColor2;\n            layout(color) uniform half4 uColor3;\n            layout(color) uniform half4 uBackground;\n\n            float interleavedGradientNoise(float2 fragCoord) {\n                float2 pixel = floor(fragCoord);\n                return fract(52.9829189 * fract(0.06711056 * pixel.x + 0.00583715 * pixel.y));\n            }\n\n            float3 computeBlobContribution(float2 uv, float4 blob, half4 color,\n                                           inout float3 accColor, inout float accWeight) {\n                float2 delta = uv - blob.xy;\n                float weightBase = exp(dot(delta, delta) * blob.z);\n                float weight = weightBase * color.a;\n                accColor += color.rgb * weight;\n                accWeight += weight;\n                return accColor;\n            }\n\n            float3 getBaseColor(float2 uv) {\n                float3 accColor = float3(0.0);\n                float accWeight = 0.0;\n\n                computeBlobContribution(uv, uBlob0, uColor0, accColor, accWeight);\n                computeBlobContribution(uv, uBlob1, uColor1, accColor, accWeight);\n                computeBlobContribution(uv, uBlob2, uColor2, accColor, accWeight);\n                computeBlobContribution(uv, uBlob3, uColor3, accColor, accWeight);\n\n                float3 blobContent = accColor / (accWeight + 0.0001);\n                float alpha = smoothstep(0.0, 0.85, accWeight);\n\n                return mix(uBackground.rgb, blobContent, alpha);\n            }\n\n            float4 main(float2 fragCoord) {\n                float2 uv = (fragCoord - 0.5 * uResolution) / uResolution.y;\n                float3 baseColor = getBaseColor(uv);\n                float dither = interleavedGradientNoise(fragCoord) - 0.5;\n                float3 finalColor = saturate(baseColor + dither / 255.0);\n                return float4(finalColor, 1.0);\n            }\n        ");
    }

    static {
        b r0 = new b(null);
        Companion = r0;
        DAY = new a(Color.parseColor("#FAFAFA"), Color.parseColor("#4D3CAEFF"), Color.parseColor("#14FF004D"), Color.parseColor("#0D66FFBA"), Color.parseColor("#59FFE3C9"));
        NIGHT = new a(Color.parseColor("#000000"), Color.parseColor("#333CAEFF"), Color.parseColor("#0FFF004D"), Color.parseColor("#0A66FFBA"), Color.parseColor("#33FFE3C9"));
        blobSpecs = p.b(new b.a[]{new b.a("uBlob0", -2.0f, 1.0f, 1.2f, 0.0f, b.a(r0, 0.0f) + 0.8f, 0.0f), new b.a("uBlob1", -0.5f, 0.8f, 1.4f, 10.0f, b.a(r0, 1.0f) + 0.8f, 20.0f), new b.a("uBlob2", 1.0f, SPREAD_BASE, 1.6f, 20.0f, b.a(r0, 2.0f) + 0.8f, 40.0f), new b.a("uBlob3", 2.0f, 1.5f, 1.8f, 30.0f, b.a(r0, 3.0f) + 0.8f, 60.0f)});
    }

    public final void setResolution(float r2, float r3) {
        setFloatUniform("uResolution", r2, r3);
    }

    public final float getTime() {
        return this.time;
    }

    public final void setTime(float r1) {
        this.time = r1;
        updateBlobUniforms(r1);
    }

    public final void applyTheme(a r3) {
        o.e(r3, "theme");
        setColorUniform("uBackground", r3.a());
        setColorUniform("uColor0", r3.b());
        setColorUniform("uColor1", r3.c());
        setColorUniform("uColor2", r3.d());
        setColorUniform("uColor3", r3.e());
    }

    private final void updateBlobUniforms(float r6) {
        float r0 = GLOBAL_ANGLE_SPEED * r6;
        Iterator<b.a> r1 = blobSpecs.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        updateBlobUniform((b.a) ZeusTransformUtils.preCheckCast(r1.next(), b.a.class, "com.obric.aiagent.plugin"), r6, r0);
        goto L4
    }

    private final void updateBlobUniform(b.a r11, float r12, float r13) {
        float r0 = (((float) Math.sin((r11.d() * r12) + r11.e())) * BREATH_AMPLITUDE) + SPREAD_BASE;
        double r2 = r13 + r11.b();
        float r6 = ((float) Math.cos(r2)) * r0;
        float r7 = ((float) Math.sin(r2)) * r0;
        float r14 = ((((float) Math.cos((r12 * r11.f()) + r11.g())) * BREATH_AMPLITUDE) + BASE_RADIUS) * r11.c();
        setFloatUniform(r11.a(), r6, r7, (-2.0f) / (r14 * r14), 0.0f);
    }
}
