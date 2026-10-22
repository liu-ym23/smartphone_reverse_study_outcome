package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {
    private static final int IMAGE_DIVIDER = 4;
    private static String TAG = "GL2ShaderView";
    private Renderer mRenderer;

    private class Renderer implements GLSurfaceView.Renderer {
        private static final String TAG = "GL3BlurRenderer";
        private int mAlphaHandleMix;
        private Bitmap mBackgroundImage;
        private int mBlurOffsetHandleScaleDown;
        private int mBlurOffsetHandleScaleUp;
        private float mBlurRadius;
        private int mFBOId_2;
        private int mFBOId_4;
        private int mFBOId_8;
        private int mFBOId_Pang;
        private int mFBOId_Ping;
        private int mFBOTextureId_2;
        private int mFBOTextureId_4;
        private int mFBOTextureId_8;
        private int mFBOTextureId_Pang;
        private int mFBOTextureId_Ping;
        int mFboH;
        int mFboH_2;
        int mFboH_4;
        int mFboH_8;
        int mFboW;
        int mFboW_2;
        int mFboW_4;
        int mFboW_8;
        private final String mFragmentShaderMix;
        private final String mFragmentShaderPreprocessing;
        private final String mFragmentShaderScaleDown;
        private final String mFragmentShaderScaleUp;
        private int mHeight;
        private float mInputBlurRadius;
        private Bitmap mLastBackgroundImage;
        private int mLastHeight;
        private int mLastWidth;
        private int mPositionHandleMix;
        private int mPositionHandlePreprocessing;
        private int mPositionHandleScaleDown;
        private int mPositionHandleScaleUp;
        private int mProgramMix;
        private int mProgramPreprocessing;
        private int mProgramScaleDown;
        private int mProgramScaleUp;
        private int mResolutionHandleMix;
        private int mResolutionHandlePreprocessing;
        private int mResolutionHandleScaleDown;
        private int mResolutionHandleScaleUp;
        private int mRevertHandleMix;
        private int mRevertHandlePreprocessing;
        private int mSnapshotTextureId;
        private int mTextureAHandleMix;
        private int mTextureBHandleMix;
        private int mTextureHandlePreprocessing;
        private int mTextureHandleScaleDown;
        private int mTextureHandleScaleUp;
        private int mTextureId;
        private final float[] mTriangleVerticesData;
        private int mVAOIdMix;
        private int mVAOIdPreprocessing;
        private int mVAOIdScaleDown;
        private int mVAOIdScaleUp;
        private int mVBOIdMix;
        private int mVBOIdPreprocessing;
        private int mVBOIdScaleDown;
        private int mVBOIdScaleUp;
        private FloatBuffer mVertexBuffer;
        private final String mVertexShader;
        private int mWidth;
        final /* synthetic */ GL3ShaderViewKawaseBlur this$0;

        public Renderer(GL3ShaderViewKawaseBlur r4) {
            this.this$0 = r4;
            this.mVertexShader = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.mFragmentShaderPreprocessing = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n";
            this.mFragmentShaderMix = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n";
            this.mFragmentShaderScaleDown = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n";
            this.mFragmentShaderScaleUp = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n";
            this.mTextureId = 0;
            this.mSnapshotTextureId = 0;
            this.mWidth = 0;
            this.mLastWidth = 0;
            this.mHeight = 0;
            this.mLastHeight = 0;
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.mTriangleVerticesData = r0;
            this.mFBOId_Ping = 0;
            this.mFBOTextureId_Ping = 0;
            this.mFBOId_Pang = 0;
            this.mFBOTextureId_Pang = 0;
            this.mFBOId_2 = 0;
            this.mFBOTextureId_2 = 0;
            this.mFBOId_4 = 0;
            this.mFBOTextureId_4 = 0;
            this.mFBOId_8 = 0;
            this.mFBOTextureId_8 = 0;
            this.mBlurRadius = 0.0f;
            this.mInputBlurRadius = 0.0f;
            FloatBuffer r1 = ByteBuffer.allocateDirect(r0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.mVertexBuffer = r1;
            r1.position(0);
        }

        public void setBackgroundImage(Bitmap r1) {
            this.mBackgroundImage = r1;
        }

        public void setBlurRadius(float r2) {
            if (this.mInputBlurRadius == r2) goto L6;
            this.mInputBlurRadius = r2;
            this.mBlurRadius = r2 * 10.0f;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r17) {
            int r0 = this.mWidth;
            if (r0 == 0) goto L41;
            int r1 = this.mHeight;
            if (r1 == 0) goto L42;
            boolean r3 = true;
            if (r0 == this.mLastWidth) goto L10;
        L13:
            boolean r2 = true;
        L15:
            if (this.mBackgroundImage == this.mLastBackgroundImage) goto L20;
            int r4 = this.mTextureId;
            if (r4 == 0) goto L19;
            GLES30.glDeleteTextures(1, new int[]{r4}, 0);
        L19:
            this.mTextureId = loadTexture(this.mBackgroundImage);
        L21:
            if (r3 == false) goto L26;
            renderPreprocessing(this.mTextureId, this.mFBOId_Ping);
            if (this.mSnapshotTextureId != 0) goto L25;
            this.mSnapshotTextureId = genTexture(this.mFboW, this.mFboH);
        L25:
            GLES30.glBindFramebuffer(36160, this.mFBOId_Ping);
            GLES30.glBindTexture(3553, this.mSnapshotTextureId);
            GLES30.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.mFboW, this.mFboH);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glBindTexture(3553, 0);
        L26:
            float r5 = this.mBlurRadius;
            if (r5 < 150.0f) goto L30;
            float r8 = r5 / 120.0f;
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_2, r8, this.mFboW_2, this.mFboH_2);
            renderBlurScaleDown(this.mFBOTextureId_2, this.mFBOId_4, r8, this.mFboW_4, this.mFboH_4);
            renderBlurScaleDown(this.mFBOTextureId_4, this.mFBOId_8, r8, this.mFboW_8, this.mFboH_8);
            renderBlurScaleUp(this.mFBOTextureId_8, this.mFBOId_4, r8, this.mFboW_4, this.mFboH_4);
            renderBlurScaleUp(this.mFBOTextureId_4, this.mFBOId_2, r8, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r8, this.mFboW, this.mFboH);
            renderPreprocessing(this.mFBOTextureId_Ping, 0);
        L39:
            this.mLastWidth = this.mWidth;
            this.mLastHeight = this.mHeight;
            this.mLastBackgroundImage = this.mBackgroundImage;
            return;
        L30:
            if (r5 < 120.0f) goto L33;
            float r7 = r5 / 120.0f;
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_2, r7, this.mFboW_2, this.mFboH_2);
            renderBlurScaleDown(this.mFBOTextureId_2, this.mFBOId_4, r7, this.mFboW_4, this.mFboH_4);
            renderBlurScaleDown(this.mFBOTextureId_4, this.mFBOId_8, r7, this.mFboW_8, this.mFboH_8);
            renderBlurScaleUp(this.mFBOTextureId_8, this.mFBOId_4, r7, this.mFboW_4, this.mFboH_4);
            renderBlurScaleUp(this.mFBOTextureId_4, this.mFBOId_2, r7, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Pang, r7, this.mFboW, this.mFboH);
            float r9 = this.mBlurRadius / 30.0f;
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_2, r9, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r9, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Ping, this.mFBOId_2, r9, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r9, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Ping, this.mFBOId_2, r9, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r9, this.mFboW, this.mFboH);
            renderMix(this.mFBOTextureId_Ping, this.mFBOTextureId_Pang, 0, 1.0f - ((150.0f - this.mBlurRadius) / 30.0f), false);
            goto L39
        L33:
            if (r5 < 30.0f) goto L36;
            float r10 = r5 / 30.0f;
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_2, r10, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r10, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Ping, this.mFBOId_2, r10, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r10, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Ping, this.mFBOId_2, r10, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r10, this.mFboW, this.mFboH);
            renderPreprocessing(this.mFBOTextureId_Ping, 0);
            goto L39
        L36:
            if (r5 < 15.0f) goto L38;
            float r11 = r5 / 15.0f;
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_Ping, r11, this.mFboW, this.mFboH);
            renderBlurScaleUp(this.mFBOTextureId_Ping, this.mFBOId_Pang, r11, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Pang, this.mFBOId_Ping, r11, this.mFboW, this.mFboH);
            renderBlurScaleUp(this.mFBOTextureId_Ping, this.mFBOId_Pang, r11, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Pang, this.mFBOId_Ping, r11, this.mFboW, this.mFboH);
            renderBlurScaleUp(this.mFBOTextureId_Ping, this.mFBOId_Pang, r11, this.mFboW, this.mFboH);
            float r12 = this.mBlurRadius / 30.0f;
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_2, r12, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r12, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Ping, this.mFBOId_2, r12, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r12, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Ping, this.mFBOId_2, r12, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_Ping, r12, this.mFboW, this.mFboH);
            renderMix(this.mFBOTextureId_Pang, this.mFBOTextureId_Ping, 0, 1.0f - ((30.0f - this.mBlurRadius) / 15.0f), false);
            goto L39
        L38:
            renderBlurScaleDown(this.mSnapshotTextureId, this.mFBOId_Ping, 1.0f, this.mFboW, this.mFboH);
            renderBlurScaleUp(this.mFBOTextureId_Ping, this.mFBOId_Pang, 1.0f, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Pang, this.mFBOId_Ping, 1.0f, this.mFboW, this.mFboH);
            renderBlurScaleUp(this.mFBOTextureId_Ping, this.mFBOId_Pang, 1.0f, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_Pang, this.mFBOId_Ping, 1.0f, this.mFboW, this.mFboH);
            renderBlurScaleUp(this.mFBOTextureId_Ping, this.mFBOId_Pang, 1.0f, this.mFboW, this.mFboH);
            renderMix(this.mTextureId, this.mFBOTextureId_Pang, 0, this.mBlurRadius / 15.0f, true);
            goto L39
        L20:
            r3 = r2;
            goto L21
        L10:
            if (r1 != this.mLastHeight) goto L13;
            r2 = false;
            goto L15
        L42:
            return;
        }

        private void renderPreprocessing(int r6, int r7) {
            if (r7 == 0) goto L5;
            GLES30.glViewport(0, 0, this.mFboW, this.mFboH);
            GLES30.glBindFramebuffer(36160, r7);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramPreprocessing);
            if (r7 == 0) goto L9;
            GLES30.glUniform2f(this.mResolutionHandlePreprocessing, this.mFboW, this.mFboH);
            GLES30.glUniform1i(this.mRevertHandlePreprocessing, 1);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.mTextureHandlePreprocessing, 0);
            GLES30.glBindVertexArray(this.mVAOIdPreprocessing);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r7 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.mResolutionHandlePreprocessing, this.mWidth, this.mHeight);
            GLES30.glUniform1i(this.mRevertHandlePreprocessing, 0);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.mWidth, this.mHeight);
            goto L6
        }

        private void renderBlurScaleDown(int r4, int r5, float r6, int r7, int r8) {
            GLES30.glViewport(0, 0, r7, r8);
            GLES30.glBindFramebuffer(36160, r5);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramScaleDown);
            GLES30.glUniform2f(this.mResolutionHandleScaleDown, r7, r8);
            GLES30.glUniform1f(this.mBlurOffsetHandleScaleDown, r6);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r4);
            GLES30.glUniform1i(this.mTextureHandleScaleDown, 0);
            GLES30.glBindVertexArray(this.mVAOIdScaleDown);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r5 == 0) goto L6;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        private void renderBlurScaleUp(int r3, int r4, float r5, int r6, int r7) {
            GLES30.glViewport(0, 0, r6, r7);
            GLES30.glBindFramebuffer(36160, r4);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramScaleUp);
            GLES30.glUniform2f(this.mResolutionHandleScaleUp, r6, r7);
            GLES30.glUniform1f(this.mBlurOffsetHandleScaleUp, r5);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r3);
            GLES30.glUniform1i(this.mTextureHandleScaleUp, 0);
            GLES30.glBindVertexArray(this.mVAOIdScaleUp);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        private void renderMix(int r6, int r7, int r8, float r9, boolean r10) {
            if (r8 == 0) goto L5;
            GLES30.glViewport(0, 0, this.mFboW, this.mFboH);
            GLES30.glBindFramebuffer(36160, r8);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramMix);
            if (r8 == 0) goto L9;
            GLES30.glUniform2f(this.mResolutionHandleMix, this.mFboW, this.mFboH);
        L10:
            GLES30.glUniform1i(this.mRevertHandleMix, r10 ? 1 : 0);
            GLES30.glUniform1f(this.mAlphaHandleMix, r9);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.mTextureAHandleMix, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r7);
            GLES30.glUniform1i(this.mTextureBHandleMix, 1);
            GLES30.glBindVertexArray(this.mVAOIdMix);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r8 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.mResolutionHandleMix, this.mWidth, this.mHeight);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.mWidth, this.mHeight);
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r4, int r5, int r6) {
            this.mWidth = r5;
            this.mHeight = r6;
            if (r5 == 0) goto L43;
            if (r6 != 0) goto L7;
            return;
        L7:
            if (r5 == this.mLastWidth) goto L9;
        L11:
            int r7 = this.mFBOId_Ping;
            if (r7 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r7}, 0);
        L14:
            int r8 = this.mFBOTextureId_Ping;
            if (r8 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r8}, 0);
        L17:
            int r9 = this.mFBOId_Pang;
            if (r9 == 0) goto L20;
            GLES30.glDeleteFramebuffers(1, new int[]{r9}, 0);
        L20:
            int r10 = this.mFBOTextureId_Pang;
            if (r10 == 0) goto L23;
            GLES30.glDeleteTextures(1, new int[]{r10}, 0);
        L23:
            int r11 = this.mFBOId_2;
            if (r11 == 0) goto L26;
            GLES30.glDeleteFramebuffers(1, new int[]{r11}, 0);
        L26:
            int r12 = this.mFBOTextureId_2;
            if (r12 == 0) goto L29;
            GLES30.glDeleteTextures(1, new int[]{r12}, 0);
        L29:
            int r13 = this.mFBOId_4;
            if (r13 == 0) goto L32;
            GLES30.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L32:
            int r14 = this.mFBOTextureId_4;
            if (r14 == 0) goto L35;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L35:
            int r15 = this.mFBOId_8;
            if (r15 == 0) goto L38;
            GLES30.glDeleteFramebuffers(1, new int[]{r15}, 0);
        L38:
            int r16 = this.mFBOTextureId_8;
            if (r16 == 0) goto L41;
            GLES30.glDeleteTextures(1, new int[]{r16}, 0);
        L41:
            int r17 = this.mWidth / 4;
            this.mFboW = r17;
            int r0 = this.mHeight / 4;
            this.mFboH = r0;
            int[] r18 = createFBO(r17, r0);
            this.mFBOId_Ping = r18[0];
            this.mFBOTextureId_Ping = r18[1];
            int[] r19 = createFBO(this.mFboW, this.mFboH);
            this.mFBOId_Pang = r19[0];
            this.mFBOTextureId_Pang = r19[1];
            this.mFboW_2 = (int) Math.ceil(this.mFboW / 2.0f);
            int r20 = (int) Math.ceil(this.mFboH / 2.0f);
            this.mFboH_2 = r20;
            int[] r21 = createFBO(this.mFboW_2, r20);
            this.mFBOId_2 = r21[0];
            this.mFBOTextureId_2 = r21[1];
            this.mFboW_4 = (int) Math.ceil(this.mFboW_2 / 2.0f);
            int r22 = (int) Math.ceil(this.mFboH_2 / 2.0f);
            this.mFboH_4 = r22;
            int[] r23 = createFBO(this.mFboW_4, r22);
            this.mFBOId_4 = r23[0];
            this.mFBOTextureId_4 = r23[1];
            this.mFboW_8 = (int) Math.ceil(this.mFboW_4 / 2.0f);
            int r24 = (int) Math.ceil(this.mFboH_4 / 2.0f);
            this.mFboH_8 = r24;
            int[] r25 = createFBO(this.mFboW_8, r24);
            this.mFBOId_8 = r25[0];
            this.mFBOTextureId_8 = r25[1];
            return;
        L9:
            if (r6 != this.mLastHeight) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            int r13 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.mProgramPreprocessing = r13;
            this.mPositionHandlePreprocessing = GLES30.glGetAttribLocation(r13, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mRevertHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_revert");
            checkGlError("glGetUniformLocation");
            int[] r4 = loadVao(this.mProgramPreprocessing, this.mPositionHandlePreprocessing);
            this.mVAOIdPreprocessing = r4[0];
            this.mVBOIdPreprocessing = r4[1];
            int r5 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
            this.mProgramScaleDown = r5;
            this.mPositionHandleScaleDown = GLES30.glGetAttribLocation(r5, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mBlurOffsetHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_blurOffset");
            checkGlError("glGetUniformLocation");
            int[] r6 = loadVao(this.mProgramScaleDown, this.mPositionHandleScaleDown);
            this.mVAOIdScaleDown = r6[0];
            this.mVBOIdScaleDown = r6[1];
            int r7 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.mProgramScaleUp = r7;
            this.mPositionHandleScaleUp = GLES30.glGetAttribLocation(r7, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mBlurOffsetHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_blurOffset");
            checkGlError("glGetUniformLocation");
            int[] r8 = loadVao(this.mProgramScaleUp, this.mPositionHandleScaleUp);
            this.mVAOIdScaleUp = r8[0];
            this.mVBOIdScaleUp = r8[1];
            int r14 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
            this.mProgramMix = r14;
            this.mPositionHandleMix = GLES30.glGetAttribLocation(r14, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureAHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_background");
            checkGlError("glGetAttribLocation");
            this.mTextureBHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_foreground");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mRevertHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_revert");
            checkGlError("glGetUniformLocation");
            this.mAlphaHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_alpha");
            checkGlError("glGetUniformLocation");
            int[] r15 = loadVao(this.mProgramMix, this.mPositionHandleMix);
            this.mVAOIdMix = r15[0];
            this.mVBOIdMix = r15[1];
        }

        private int loadShader(int r3, String r4) {
            int r2 = GLES30.glCreateShader(r3);
            if (r2 == 0) goto L8;
            GLES30.glShaderSource(r2, r4);
            GLES30.glCompileShader(r2);
            int[] r5 = new int[1];
            GLES30.glGetShaderiv(r2, 35713, r5, 0);
            if (r5[0] != 0) goto L9;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Could not compile shader " + r3 + SimContactsConstants.ANR_SEP);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, GLES30.glGetShaderInfoLog(r2));
            GLES30.glDeleteShader(r2);
            return 0;
        L9:
            return r2;
        L8:
            return r2;
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
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Could not link program: ");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, GLES30.glGetProgramInfoLog(r1));
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
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r4 + ": glError " + r3);
            throw new RuntimeException(r4 + ": glError " + r3);
        }

        private int[] createFBO(int r17, int r18) {
            int[] r1 = new int[1];
            GLES30.glGenFramebuffers(1, r1, 0);
            GLES30.glBindFramebuffer(36160, r1[0]);
            int[] r3 = new int[1];
            GLES30.glGenTextures(1, r3, 0);
            GLES30.glBindTexture(3553, r3[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r17, r18, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r3[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r1[0], r3[0]};
        }

        private int[] loadVao(int r13, int r14) {
            GLES30.glUseProgram(r13);
            int[] r0 = new int[1];
            GLES30.glGenVertexArrays(1, r0, 0);
            int r1 = r0[0];
            GLES30.glBindVertexArray(r1);
            int[] r2 = new int[1];
            GLES30.glGenBuffers(1, r2, 0);
            int r3 = r2[0];
            GLES30.glBindBuffer(34962, r3);
            GLES30.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mVertexBuffer, 35044);
            GLES30.glEnableVertexAttribArray(r14);
            GLES30.glVertexAttribPointer(r14, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r1, r3};
        }

        private int loadTexture(Bitmap r4) {
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            int r3 = r0[0];
            if (r3 == 0) goto L6;
            GLES30.glBindTexture(3553, r3);
            GLUtils.texImage2D(3553, 0, r4, 0);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r0[0];
        }

        private int genTexture(int r13, int r14) {
            int[] r0 = new int[1];
            GLES30.glGenTextures(1, r0, 0);
            GLES30.glBindTexture(3553, r0[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r13, r14, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            return r0[0];
        }
    }

    static {
    }

    public GL3ShaderViewKawaseBlur(Context r2) {
        super(r2, null);
    }

    public GL3ShaderViewKawaseBlur(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        Renderer r0 = new Renderer(this);
        this.mRenderer = r0;
        setRenderer(r0);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    public void setBackgroundImage(Bitmap r1) {
        this.mRenderer.setBackgroundImage(r1);
    }

    public void setBlurRadius(float r1) {
        this.mRenderer.setBlurRadius(r1);
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
