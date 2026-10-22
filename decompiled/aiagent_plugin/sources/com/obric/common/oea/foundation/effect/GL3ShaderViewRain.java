package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.common.oea.foundation.animation.engine.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class GL3ShaderViewRain extends GLSurfaceView implements Choreographer.FrameCallback {
    private static String TAG = "GL2ShaderView";
    private Renderer mRenderer;

    private static class Renderer implements GLSurfaceView.Renderer {
        private int mAlphaHandle;
        private d mAlphaValue;
        private Bitmap mBackgroundImage;
        private Context mContext;
        private int mFBOId;
        private int mFBOPositionHandle;
        private int mFBOProgram;
        private int mFBOResolutionHandle;
        private int mFBOTextureHandle;
        private int mFBOTextureId;
        private final String mFragmentShaderFbo;
        private final String mFragmentShaderRain;
        private int mHeight;
        private int mIntensityHandle;
        private d mIntensityValue;
        private float mLastAlpha;
        private int mLastHeight;
        private float mLastIntensity;
        private float mLastSpeed;
        private int mLastWidth;
        private int mProgram;
        private int mResolutionHandle;
        private int mSpeedHandle;
        private d mSpeedValue;
        private int mTextureBgHandle;
        private int mTextureHandle;
        private int mTextureId;
        private int mTimeHandle;
        private final float[] mTriangleVerticesData;
        private int mVAOId;
        private int mVBOId;
        private FloatBuffer mVertexBuffer;
        private final String mVertexShader;
        private int mWidth;
        private int mvPositionHandle;

        public static /* synthetic */ int access$001(String r0, String r1) {
            return Log.e(r0, r1);
        }

        static /* synthetic */ d access$000(Renderer r0) {
            return r0.mAlphaValue;
        }

        static /* synthetic */ d access$100(Renderer r0) {
            return r0.mIntensityValue;
        }

        static /* synthetic */ d access$200(Renderer r0) {
            return r0.mSpeedValue;
        }

        public Renderer(Context r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            this.mVertexShader = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.mFragmentShaderFbo = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.mFragmentShaderRain = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.mLastAlpha = -1.0f;
            this.mLastIntensity = -1.0f;
            this.mLastSpeed = -1.0f;
            this.mWidth = 0;
            this.mLastWidth = 0;
            this.mHeight = 0;
            this.mLastHeight = 0;
            this.mAlphaValue = new d(1.0f);
            this.mIntensityValue = new d(1.0f);
            this.mSpeedValue = new d(0.25f);
            float[] r2 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.mTriangleVerticesData = r2;
            this.mFBOProgram = 0;
            this.mFBOId = 0;
            this.mFBOTextureId = 0;
            this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            FloatBuffer r7 = ByteBuffer.allocateDirect(r2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r2);
            this.mVertexBuffer = r7;
            r7.position(0);
        }

        public void setBackgroundImage(Bitmap r1) {
            this.mBackgroundImage = r1;
        }

        private void initFBO() {
            if (this.mFBOProgram != 0) goto L5;
            int r0 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.mFBOProgram = r0;
            this.mFBOPositionHandle = GLES30.glGetAttribLocation(r0, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mFBOTextureHandle = GLES30.glGetUniformLocation(this.mFBOProgram, "u_background");
            checkGlError("glGetAttribLocation");
            this.mFBOResolutionHandle = GLES30.glGetUniformLocation(this.mFBOProgram, "u_resolution");
            checkGlError("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.mFBOProgram);
            if (this.mFBOId != 0) goto L8;
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            this.mFBOId = r1[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.mFBOId);
            if (this.mFBOTextureId != 0) goto L11;
            int[] r2 = new int[1];
            GLES30.glGenTextures(1, r2, 0);
            this.mFBOTextureId = r2[0];
        L11:
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glTexImage2D(3553, 0, 6408, this.mWidth, this.mHeight, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.mFBOTextureId, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        private void renderFBO() {
            GLES30.glBindFramebuffer(36160, this.mFBOId);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mFBOProgram);
            GLES30.glUniform2f(this.mFBOResolutionHandle, this.mWidth, this.mHeight);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.mTextureId);
            GLES30.glUniform1i(this.mFBOTextureHandle, 0);
            GLES30.glEnableVertexAttribArray(this.mFBOPositionHandle);
            GLES30.glVertexAttribPointer(this.mFBOPositionHandle, 2, 5126, false, 0, this.mVertexBuffer);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r5, GL10.class, "com.obric.aiagent.plugin");
            if (this.mWidth == this.mLastWidth) goto L5;
        L6:
            initFBO();
            renderFBO();
        L7:
            long r0 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgram);
            GLES30.glUniform1f(this.mTimeHandle, (r0 % 1000000) / 1000.0f);
            int r7 = this.mWidth;
            if (r7 == this.mLastWidth) goto L10;
        L11:
            this.mLastWidth = r7;
            int r1 = this.mHeight;
            this.mLastHeight = r1;
            GLES30.glUniform2f(this.mResolutionHandle, r7, r1);
        L13:
            if (this.mAlphaValue.a() == this.mLastAlpha) goto L16;
            float r8 = this.mAlphaValue.a();
            this.mLastAlpha = r8;
            GLES30.glUniform1f(this.mAlphaHandle, r8);
        L16:
            if (this.mIntensityValue.a() == this.mLastIntensity) goto L19;
            float r9 = this.mIntensityValue.a();
            this.mLastIntensity = r9;
            GLES30.glUniform1f(this.mIntensityHandle, r9);
        L19:
            if (this.mSpeedValue.a() == this.mLastSpeed) goto L21;
            float r10 = this.mSpeedValue.a();
            this.mLastSpeed = r10;
            GLES30.glUniform1f(this.mSpeedHandle, r10);
        L21:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.mTextureId);
            GLES30.glUniform1i(this.mTextureBgHandle, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.mFBOTextureId);
            GLES30.glUniform1i(this.mTextureHandle, 1);
            GLES30.glBindVertexArray(this.mVAOId);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.mHeight == this.mLastHeight) goto L13;
        L5:
            if (this.mHeight == this.mLastHeight) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r3, int r4, int r5) {
            GL10 r6 = (GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.aiagent.plugin");
            this.mWidth = r4;
            this.mHeight = r5;
            GLES30.glViewport(0, 0, r4, r5);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r8, EGLConfig r9) {
            GL10 r10 = (GL10) ZeusTransformUtils.wrapperContextForParams(r8, GL10.class, "com.obric.aiagent.plugin");
            int r11 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.mProgram = r11;
            if (r11 != 0) goto L5;
            return;
        L5:
            this.mvPositionHandle = GLES30.glGetAttribLocation(r11, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureBgHandle = GLES30.glGetUniformLocation(this.mProgram, "u_background");
            checkGlError("glGetAttribLocation");
            this.mTextureHandle = GLES30.glGetUniformLocation(this.mProgram, "u_prepass");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandle = GLES30.glGetUniformLocation(this.mProgram, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mTimeHandle = GLES30.glGetUniformLocation(this.mProgram, "u_time");
            checkGlError("glGetUniformLocation");
            this.mAlphaHandle = GLES30.glGetUniformLocation(this.mProgram, "u_alpha");
            checkGlError("glGetUniformLocation");
            this.mIntensityHandle = GLES30.glGetUniformLocation(this.mProgram, "u_intensity");
            checkGlError("glGetUniformLocation");
            this.mSpeedHandle = GLES30.glGetUniformLocation(this.mProgram, "u_speed");
            checkGlError("glGetUniformLocation");
            GLES30.glUseProgram(this.mProgram);
            this.mTextureId = loadTexture(this.mContext, this.mBackgroundImage);
            int[] r12 = new int[1];
            GLES30.glGenVertexArrays(1, r12, 0);
            int r13 = r12[0];
            this.mVAOId = r13;
            GLES30.glBindVertexArray(r13);
            int[] r14 = new int[1];
            GLES30.glGenBuffers(1, r14, 0);
            int r15 = r14[0];
            this.mVBOId = r15;
            GLES30.glBindBuffer(34962, r15);
            GLES30.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mVertexBuffer, 35044);
            GLES30.glEnableVertexAttribArray(this.mvPositionHandle);
            GLES30.glVertexAttribPointer(this.mvPositionHandle, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }

        private int loadShader(int r4, String r5) {
            int r3 = GLES30.glCreateShader(r4);
            if (r3 == 0) goto L8;
            GLES30.glShaderSource(r3, r5);
            GLES30.glCompileShader(r3);
            int[] r6 = new int[1];
            GLES30.glGetShaderiv(r3, 35713, r6, 0);
            if (r6[0] != 0) goto L9;
            INVOKESTATIC_com_obric_common_oea_foundation_effect_GL3ShaderViewRain$Renderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(GL3ShaderViewRain.access$300(), "Could not compile shader " + r4 + ":");
            INVOKESTATIC_com_obric_common_oea_foundation_effect_GL3ShaderViewRain$Renderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(GL3ShaderViewRain.access$300(), GLES30.glGetShaderInfoLog(r3));
            GLES30.glDeleteShader(r3);
            return 0;
        L9:
            return r3;
        L8:
            return r3;
        }

        private int createProgram(String r3, String r4) {
            int r5 = loadShader(35633, r3);
            if (r5 != 0) goto L5;
            return 0;
        L5:
            int r6 = loadShader(35632, r4);
            if (r6 != 0) goto L8;
            return 0;
        L8:
            int r1 = GLES30.glCreateProgram();
            if (r1 == 0) goto L14;
            GLES30.glAttachShader(r1, r5);
            checkGlError("glAttachShader");
            GLES30.glAttachShader(r1, r6);
            checkGlError("glAttachShader");
            GLES30.glLinkProgram(r1);
            int[] r7 = new int[1];
            GLES30.glGetProgramiv(r1, 35714, r7, 0);
            if (r7[0] == 1) goto L14;
            INVOKESTATIC_com_obric_common_oea_foundation_effect_GL3ShaderViewRain$Renderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(GL3ShaderViewRain.access$300(), "Could not link program: ");
            INVOKESTATIC_com_obric_common_oea_foundation_effect_GL3ShaderViewRain$Renderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(GL3ShaderViewRain.access$300(), GLES30.glGetProgramInfoLog(r1));
            GLES30.glDeleteProgram(r1);
            return 0;
        L14:
            return r1;
        }

        private void checkGlError(String r4) {
            int r3 = GLES30.glGetError();
            if (r3 != 0) goto L5;
            return;
        L5:
            INVOKESTATIC_com_obric_common_oea_foundation_effect_GL3ShaderViewRain$Renderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(GL3ShaderViewRain.access$300(), r4 + ": glError " + r3);
            throw new RuntimeException(r4 + ": glError " + r3);
        }

        private static int loadTexture(Context r4, Bitmap r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            if (r0[0] == 0) goto L6;
            GLES30.glBindTexture(3553, r0[0]);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r5, 0);
            GLES30.glBindTexture(3553, 0);
            r5.recycle();
        L6:
            return r0[0];
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int INVOKESTATIC_com_obric_common_oea_foundation_effect_GL3ShaderViewRain$Renderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    static {
    }

    static /* synthetic */ String access$300() {
        return TAG;
    }

    public GL3ShaderViewRain(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public GL3ShaderViewRain(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        init();
    }

    private void init() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        Renderer r0 = new Renderer((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.mRenderer = r0;
        setRenderer(r0);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    public void setBackgroundImage(Bitmap r1) {
        this.mRenderer.setBackgroundImage(r1);
    }

    public void setShaderAlpha(float r1) {
        Renderer.access$000(this.mRenderer).a(r1);
    }

    public void setShaderIntensity(float r1) {
        Renderer.access$100(this.mRenderer).a(r1);
    }

    public void setShaderSpeed(float r1) {
        Renderer.access$200(this.mRenderer).a(r1);
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r1) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }
}
