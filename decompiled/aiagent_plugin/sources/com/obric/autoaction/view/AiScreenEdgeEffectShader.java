package com.obric.autoaction.view;

import android.graphics.RuntimeShader;
import d.h.b.h;

/* JADX INFO: compiled from: AiScreenEdgeEffectShader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AiScreenEdgeEffectShader extends RuntimeShader {
    public static final a Companion = null;
    public static final String SHADER = "\n            uniform vec2 uResolution;\n            uniform half uDensity;\n            uniform half uAlpha;\n            uniform half uSoftness;\n            uniform half uColorfulness;\n            layout(color) uniform half4 uColor;\n            \n            uniform half2 uBlobPos[5];\n            uniform half3 uBlobColors[5];\n\n\n            const half SCREEN_CORNER_RADIUS = 44.0;\n            const half EDGE_HARD_WIDTH = 3.0;\n            const half EDGE_SOFT_WIDTH = 40.0;\n            const half EDGE_SOFT_POWER = 4.0;\n            const half EDGE_GLOW_BOOST = 0.3;\n\n            float sdRoundedBox(vec2 p, vec2 size, float radius) {\n                vec2 d = abs(p) - size * 0.5 + radius;\n                return min(max(d.x, d.y), 0.0) + length(max(d, 0.0)) - radius;\n            }\n            \n            half3 generateGradient(half2 uv) {\n                half2 normalizedUV = uv + 0.5;\n                half3 color = half3(0.0);\n                half totalWeight = 0.0;\n                \n                for (int i = 0; i < 5; i++) {\n                    half2 pos = uBlobPos[i]; \n                    half2 delta = normalizedUV - pos;\n                    \n                    half dist2 = dot(delta, delta);\n                    half invDist = inversesqrt(dist2 + 0.001);\n                    half weight = invDist * invDist * invDist;\n                    \n                    color += uBlobColors[i] * weight;\n                    totalWeight += weight;\n                }\n                \n                return color / totalWeight;\n            }\n            \n            half4 main(vec2 p) {\n                // 1. 几何计算阶段：使用 float 防止溢出\n                vec2 center = uResolution * 0.5;\n                \n                // 将 uDensity 转为 float 参与坐标计算\n                float densityF = float(uDensity); \n                float rectSDF = sdRoundedBox(p - center, uResolution, SCREEN_CORNER_RADIUS * densityF);\n                \n                if (rectSDF < -EDGE_SOFT_WIDTH * densityF * 1.2) {\n                    return half4(0.0);\n                }\n                \n                // 2. 渲染计算阶段：距离已经算出来了，数值很小，转为 half 提速\n                half sdf = half(rectSDF);\n                \n                half softMask = clamp(exp(EDGE_SOFT_POWER * sdf / (EDGE_SOFT_WIDTH * uDensity)), 0.0, 1.0);\n                \n                half hardEdgeWidth = EDGE_HARD_WIDTH * uDensity;\n                half halfWidth = hardEdgeWidth * 0.5;\n                half hardMask = clamp(smoothstep(-halfWidth - 1.0, -halfWidth + 1.0, sdf + halfWidth) - \n                                       smoothstep(-halfWidth - 1.0, -halfWidth + 1.0, sdf - halfWidth), 0.0, 1.0);\n                \n                half mask = mix(hardMask, softMask, uSoftness) * (1.0 + EDGE_GLOW_BOOST) * uAlpha;\n                \n                if (mask < 0.005) {\n                    return half4(0.0);\n                }\n                \n                // UV 计算：输入是 float，输出归一化到 small half\n                half2 uv = half2((p - center) / uResolution.y);\n                \n                half3 gradient = generateGradient(uv);\n                \n                half3 finalColor = mix(uColor.rgb * uColor.a, gradient, uColorfulness);\n                \n                return half4(finalColor * mask, mask);\n            }\n        ";
    private final float[] blobColors;
    private final float[] blobPositions;

    /* JADX INFO: compiled from: AiScreenEdgeEffectShader.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AiScreenEdgeEffectShader() {
        super("\n            uniform vec2 uResolution;\n            uniform half uDensity;\n            uniform half uAlpha;\n            uniform half uSoftness;\n            uniform half uColorfulness;\n            layout(color) uniform half4 uColor;\n            \n            uniform half2 uBlobPos[5];\n            uniform half3 uBlobColors[5];\n\n\n            const half SCREEN_CORNER_RADIUS = 44.0;\n            const half EDGE_HARD_WIDTH = 3.0;\n            const half EDGE_SOFT_WIDTH = 40.0;\n            const half EDGE_SOFT_POWER = 4.0;\n            const half EDGE_GLOW_BOOST = 0.3;\n\n            float sdRoundedBox(vec2 p, vec2 size, float radius) {\n                vec2 d = abs(p) - size * 0.5 + radius;\n                return min(max(d.x, d.y), 0.0) + length(max(d, 0.0)) - radius;\n            }\n            \n            half3 generateGradient(half2 uv) {\n                half2 normalizedUV = uv + 0.5;\n                half3 color = half3(0.0);\n                half totalWeight = 0.0;\n                \n                for (int i = 0; i < 5; i++) {\n                    half2 pos = uBlobPos[i]; \n                    half2 delta = normalizedUV - pos;\n                    \n                    half dist2 = dot(delta, delta);\n                    half invDist = inversesqrt(dist2 + 0.001);\n                    half weight = invDist * invDist * invDist;\n                    \n                    color += uBlobColors[i] * weight;\n                    totalWeight += weight;\n                }\n                \n                return color / totalWeight;\n            }\n            \n            half4 main(vec2 p) {\n                // 1. 几何计算阶段：使用 float 防止溢出\n                vec2 center = uResolution * 0.5;\n                \n                // 将 uDensity 转为 float 参与坐标计算\n                float densityF = float(uDensity); \n                float rectSDF = sdRoundedBox(p - center, uResolution, SCREEN_CORNER_RADIUS * densityF);\n                \n                if (rectSDF < -EDGE_SOFT_WIDTH * densityF * 1.2) {\n                    return half4(0.0);\n                }\n                \n                // 2. 渲染计算阶段：距离已经算出来了，数值很小，转为 half 提速\n                half sdf = half(rectSDF);\n                \n                half softMask = clamp(exp(EDGE_SOFT_POWER * sdf / (EDGE_SOFT_WIDTH * uDensity)), 0.0, 1.0);\n                \n                half hardEdgeWidth = EDGE_HARD_WIDTH * uDensity;\n                half halfWidth = hardEdgeWidth * 0.5;\n                half hardMask = clamp(smoothstep(-halfWidth - 1.0, -halfWidth + 1.0, sdf + halfWidth) - \n                                       smoothstep(-halfWidth - 1.0, -halfWidth + 1.0, sdf - halfWidth), 0.0, 1.0);\n                \n                half mask = mix(hardMask, softMask, uSoftness) * (1.0 + EDGE_GLOW_BOOST) * uAlpha;\n                \n                if (mask < 0.005) {\n                    return half4(0.0);\n                }\n                \n                // UV 计算：输入是 float，输出归一化到 small half\n                half2 uv = half2((p - center) / uResolution.y);\n                \n                half3 gradient = generateGradient(uv);\n                \n                half3 finalColor = mix(uColor.rgb * uColor.a, gradient, uColorfulness);\n                \n                return half4(finalColor * mask, mask);\n            }\n        ");
        this.blobPositions = new float[10];
        float[] r0 = {1.0f, 0.71f, 0.573f, 1.0f, 0.71f, 0.839f, 1.0f, 0.835f, 0.753f, 0.976f, 0.71f, 0.996f, 1.0f, 0.553f, 0.627f};
        this.blobColors = r0;
        setFloatUniform("uBlobColors", r0);
    }

    public final void setResolution(float r2, float r3) {
        setFloatUniform("uResolution", r2, r3);
    }

    public final void setTime(float r9) {
        float r10 = (r9 + 41.5f) * 0.5f;
        int r1 = 0;
    L4:
        if (r1 >= 5) goto L6;
        float r2 = r1;
        float r3 = 0.37f * r2;
        float r4 = (((float) Math.sin((((((0.33333334f * r2) % 1.0f) * 0.9f) + 0.6f) * r10) + r3)) * 0.5f) + 0.5f;
        float r5 = (((float) Math.cos((((((r2 + 1.0f) * 0.25f) % 1.0f) + 0.8f) * r10) + (r3 * 1.5f))) * 0.5f) + 0.5f;
        float[] r6 = this.blobPositions;
        int r7 = r1 * 2;
        r6[r7] = r4;
        r6[r7 + 1] = r5;
        r1 = r1 + 1;
        goto L4
    L6:
        setFloatUniform("uBlobPos", this.blobPositions);
    }

    public final void setDensity(float r2) {
        setFloatUniform("uDensity", r2);
    }

    public final void setAlpha(float r2) {
        setFloatUniform("uAlpha", r2);
    }

    public final void setSoftness(float r2) {
        setFloatUniform("uSoftness", r2);
    }

    public final void setColorfulness(float r2) {
        setFloatUniform("uColorfulness", r2);
    }

    public final void setColor(int r2) {
        setColorUniform("uColor", r2);
    }
}
