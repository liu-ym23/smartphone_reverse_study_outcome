package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {
    private static final int IMAGE_DIVIDER = 2;
    private static String TAG = "GL2ShaderView";
    private Renderer mRenderer;

    private class Renderer implements GLSurfaceView.Renderer {
        private static final String TAG = "GL3BlurRenderer";
        private Bitmap mBackgroundImage;
        private int mBlurOffsetHandleMix;
        private int mBlurOffsetHandleScaleDown;
        private int mBlurOffsetHandleScaleUp;
        private float mBlurRadius;
        private Rect mClipBounds;
        private int mDirection;
        private int mDirectionHandleMix;
        private int mDirectionHandleScaleDown;
        private int mDirectionHandleScaleUp;
        private int mFBOId;
        private int mFBOId_1;
        private int mFBOId_2;
        private int mFBOId_Clip;
        private int mFBOId_Mix;
        private int mFBOId_Pang;
        private int mFBOTextureId;
        private int mFBOTextureId_1;
        private int mFBOTextureId_2;
        private int mFBOTextureId_Clip;
        private int mFBOTextureId_Mix;
        private int mFBOTextureId_Pang;
        int mFboH;
        int mFboH_2;
        int mFboW;
        int mFboW_2;
        private final String mFragmentShaderClip;
        private final String mFragmentShaderMix;
        private final String mFragmentShaderPreprocessing;
        private final String mFragmentShaderScaleDown;
        private final String mFragmentShaderScaleUp;
        private int mHeight;
        private Bitmap mLastBackgroundImage;
        private Rect mLastClipBounds;
        private int mLastHeight;
        private int mLastWidth;
        private int mPositionHandleClip;
        private int mPositionHandleMix;
        private int mPositionHandlePreprocessing;
        private int mPositionHandleScaleDown;
        private int mPositionHandleScaleUp;
        private int mProgramClip;
        private int mProgramMix;
        private int mProgramPreprocessing;
        private int mProgramScaleDown;
        private int mProgramScaleUp;
        private int mRectHandleClip;
        private int mResolutionHandleClip;
        private int mResolutionHandleMix;
        private int mResolutionHandlePreprocessing;
        private int mResolutionHandleScaleDown;
        private int mResolutionHandleScaleUp;
        private int mRevertHandlePreprocessing;
        private int mTextureAHandleMix;
        private int mTextureBHandleMix;
        private int mTextureHandleClip;
        private int mTextureHandlePreprocessing;
        private int mTextureHandleScaleDown;
        private int mTextureHandleScaleUp;
        private int mTextureId;
        private final float[] mTriangleVerticesData;
        private int mUvOffsetHandlePreprocessing;
        private float mUvOffsetX;
        private float mUvOffsetY;
        private int mVAOIdClip;
        private int mVAOIdMix;
        private int mVAOIdPreprocessing;
        private int mVAOIdScaleDown;
        private int mVAOIdScaleUp;
        private int mVBOIdClip;
        private int mVBOIdMix;
        private int mVBOIdPreprocessing;
        private int mVBOIdScaleDown;
        private int mVBOIdScaleUp;
        private FloatBuffer mVertexBuffer;
        private final String mVertexShader;
        private int mWidth;
        final /* synthetic */ GL3ShaderViewProgressBlur this$0;

        public Renderer(GL3ShaderViewProgressBlur r5) {
            this.this$0 = r5;
            this.mVertexShader = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.mFragmentShaderPreprocessing = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n";
            this.mFragmentShaderClip = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n";
            this.mFragmentShaderScaleDown = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n";
            this.mFragmentShaderScaleUp = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n";
            this.mFragmentShaderMix = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n";
            this.mTextureId = 0;
            this.mWidth = 0;
            this.mLastWidth = 0;
            this.mHeight = 0;
            this.mLastHeight = 0;
            this.mUvOffsetX = 0.0f;
            this.mUvOffsetY = 0.0f;
            float[] r0 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.mTriangleVerticesData = r0;
            this.mFBOId = 0;
            this.mFBOTextureId = 0;
            this.mFBOId_Clip = 0;
            this.mFBOTextureId_Clip = 0;
            this.mFBOId_Mix = 0;
            this.mFBOTextureId_Mix = 0;
            this.mFBOId_1 = 0;
            this.mFBOTextureId_1 = 0;
            this.mFBOId_Pang = 0;
            this.mFBOTextureId_Pang = 0;
            this.mFBOId_2 = 0;
            this.mFBOTextureId_2 = 0;
            this.mBlurRadius = 60.0f;
            this.mDirection = 0;
            this.mClipBounds = new Rect(0, 0, 1264, 400);
            this.mLastClipBounds = new Rect(0, 0, 1264, 400);
            FloatBuffer r1 = ByteBuffer.allocateDirect(r0.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r0);
            this.mVertexBuffer = r1;
            r1.position(0);
        }

        public void setBackgroundImage(Bitmap r1) {
            this.mBackgroundImage = r1;
        }

        public void setBlurRadius(float r2) {
            this.mBlurRadius = r2 * 20.0f;
        }

        public void setClipRect(Rect r1) {
            this.mClipBounds.set(r1);
        }

        public void setUvOffsets(float r2, float r3) {
            this.mUvOffsetX = (-r2) / this.mWidth;
            this.mUvOffsetY = (-r3) / this.mHeight;
        }

        public void setDirection(int r1) {
            this.mDirection = r1;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r11) {
            if (this.mWidth != 0) goto L5;
            return;
        L5:
            if (this.mHeight != 0) goto L8;
            return;
        L8:
            if (this.mBackgroundImage == this.mLastBackgroundImage) goto L13;
            int r12 = this.mTextureId;
            if (r12 == 0) goto L12;
            GLES30.glDeleteTextures(1, new int[]{r12}, 0);
        L12:
            this.mTextureId = loadTexture(this.mBackgroundImage);
        L13:
            renderPreprocessing(this.mTextureId, this.mFBOId, true, this.mUvOffsetX, this.mUvOffsetY);
            if (this.mLastClipBounds.width() == this.mClipBounds.width()) goto L16;
        L17:
            onClipBoundsChanged();
        L18:
            renderClip(this.mFBOTextureId, this.mFBOId_Clip);
            float r13 = this.mBlurRadius / 30.0f;
            renderBlurScaleDown(this.mFBOTextureId_Clip, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderBlurScaleDown(this.mFBOTextureId_1, this.mFBOId_2, r13, this.mFboW_2, this.mFboH_2);
            renderBlurScaleUp(this.mFBOTextureId_2, this.mFBOId_1, r13, this.mFboW, this.mFboH);
            renderMix(this.mFBOTextureId_Clip, this.mFBOTextureId_1, this.mFBOId_Mix, r13);
            renderPreprocessing(this.mFBOTextureId, 0, false, 0.0f, 0.0f);
            renderClip(this.mFBOTextureId_Mix, 0);
            this.mLastWidth = this.mWidth;
            this.mLastHeight = this.mHeight;
            this.mLastBackgroundImage = this.mBackgroundImage;
            this.mLastClipBounds.set(this.mClipBounds);
            return;
        L16:
            if (this.mLastClipBounds.height() == this.mClipBounds.height()) goto L18;
            goto L17
        }

        private void renderPreprocessing(int r6, int r7, boolean r8, float r9, float r10) {
            GLES30.glViewport(0, 0, this.mWidth, this.mHeight);
            if (r7 == 0) goto L5;
            GLES30.glBindFramebuffer(36160, r7);
        L5:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramPreprocessing);
            GLES30.glUniform2f(this.mResolutionHandlePreprocessing, this.mWidth, this.mHeight);
            GLES30.glUniform1i(this.mRevertHandlePreprocessing, r8 ? 1 : 0);
            GLES30.glUniform2f(this.mUvOffsetHandlePreprocessing, r9, r10);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.mTextureHandlePreprocessing, 0);
            GLES30.glBindVertexArray(this.mVAOIdPreprocessing);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r7 == 0) goto L9;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        private void renderBlurScaleDown(int r5, int r6, float r7, int r8, int r9) {
            GLES30.glViewport(0, 0, r8, r9);
            GLES30.glBindFramebuffer(36160, r6);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramScaleDown);
            GLES30.glUniform2f(this.mResolutionHandleScaleDown, r8, r9);
            GLES30.glUniform1f(this.mBlurOffsetHandleScaleDown, r7);
            int r10 = this.mDirection;
            if (r10 != 0) goto L6;
            GLES30.glUniform4f(this.mDirectionHandleScaleDown, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r5);
            GLES30.glUniform1i(this.mTextureHandleScaleDown, 0);
            GLES30.glBindVertexArray(this.mVAOIdScaleDown);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r6 == 0) goto L12;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L12:
            return;
        L6:
            if (r10 != 1) goto L8;
            GLES30.glUniform4f(this.mDirectionHandleScaleDown, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        private void renderBlurScaleUp(int r4, int r5, float r6, int r7, int r8) {
            GLES30.glViewport(0, 0, r7, r8);
            GLES30.glBindFramebuffer(36160, r5);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramScaleUp);
            GLES30.glUniform2f(this.mResolutionHandleScaleUp, r7, r8);
            GLES30.glUniform1f(this.mBlurOffsetHandleScaleUp, r6);
            int r9 = this.mDirection;
            if (r9 != 0) goto L6;
            GLES30.glUniform4f(this.mDirectionHandleScaleUp, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r4);
            GLES30.glUniform1i(this.mTextureHandleScaleUp, 0);
            GLES30.glBindVertexArray(this.mVAOIdScaleUp);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L6:
            if (r9 != 1) goto L8;
            GLES30.glUniform4f(this.mDirectionHandleScaleUp, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        private void renderClip(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.mClipBounds.width(), this.mClipBounds.height());
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
        L6:
            GLES30.glUseProgram(this.mProgramClip);
            float r2 = this.mClipBounds.left / this.mWidth;
            float r3 = (this.mHeight - this.mClipBounds.bottom) / this.mHeight;
            float r4 = this.mClipBounds.width() / this.mWidth;
            float r5 = this.mClipBounds.height();
            int r6 = this.mHeight;
            float r7 = r5 / r6;
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(this.mResolutionHandleClip, this.mClipBounds.width(), this.mClipBounds.height());
            GLES30.glUniform4f(this.mRectHandleClip, r2, r3, r4, r7);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.mTextureHandleClip, 0);
            GLES30.glBindVertexArray(this.mVAOIdClip);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.mResolutionHandleClip, this.mWidth, r6);
            GLES30.glUniform4f(this.mRectHandleClip, (-r2) / r4, (-r3) / r7, 1.0f / r4, 1.0f / r7);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.mWidth, this.mHeight);
            goto L6
        }

        private void renderMix(int r6, int r7, int r8, float r9) {
            GLES30.glViewport(0, 0, this.mClipBounds.width(), this.mClipBounds.height());
            GLES30.glBindFramebuffer(36160, r8);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.mProgramMix);
            GLES30.glUniform2f(this.mResolutionHandleMix, this.mClipBounds.width(), this.mClipBounds.height());
            GLES30.glUniform1f(this.mBlurOffsetHandleMix, r9);
            int r10 = this.mDirection;
            if (r10 != 0) goto L5;
            GLES30.glUniform4f(this.mDirectionHandleMix, 0.0f, 0.0f, 0.0f, 1.0f);
        L7:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r6);
            GLES30.glUniform1i(this.mTextureAHandleMix, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r7);
            GLES30.glUniform1i(this.mTextureBHandleMix, 1);
            GLES30.glBindVertexArray(this.mVAOIdMix);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L5:
            if (r10 != 1) goto L7;
            GLES30.glUniform4f(this.mDirectionHandleMix, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L7
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r2, int r3, int r4) {
            this.mWidth = r3;
            this.mHeight = r4;
            if (r3 == 0) goto L19;
            if (r4 != 0) goto L7;
            return;
        L7:
            if (r3 == this.mLastWidth) goto L9;
        L11:
            int r5 = this.mFBOId;
            if (r5 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r5}, 0);
        L14:
            int r6 = this.mFBOTextureId;
            if (r6 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r6}, 0);
        L17:
            int[] r7 = createFBO(this.mWidth, this.mHeight);
            this.mFBOId = r7[0];
            this.mFBOTextureId = r7[1];
            onClipBoundsChanged();
            return;
        L9:
            if (r4 != this.mLastHeight) goto L11;
            return;
        }

        public void onClipBoundsChanged() {
            int r0 = this.mFBOId_Clip;
            if (r0 == 0) goto L5;
            GLES30.glDeleteFramebuffers(1, new int[]{r0}, 0);
        L5:
            int r1 = this.mFBOTextureId_Clip;
            if (r1 == 0) goto L8;
            GLES30.glDeleteTextures(1, new int[]{r1}, 0);
        L8:
            int r2 = this.mFBOId_Mix;
            if (r2 == 0) goto L11;
            GLES30.glDeleteFramebuffers(1, new int[]{r2}, 0);
        L11:
            int r3 = this.mFBOTextureId_Mix;
            if (r3 == 0) goto L14;
            GLES30.glDeleteTextures(1, new int[]{r3}, 0);
        L14:
            int r4 = this.mFBOId_1;
            if (r4 == 0) goto L17;
            GLES30.glDeleteFramebuffers(1, new int[]{r4}, 0);
        L17:
            int r5 = this.mFBOTextureId_1;
            if (r5 == 0) goto L20;
            GLES30.glDeleteTextures(1, new int[]{r5}, 0);
        L20:
            int r6 = this.mFBOId_Pang;
            if (r6 == 0) goto L23;
            GLES30.glDeleteFramebuffers(1, new int[]{r6}, 0);
        L23:
            int r7 = this.mFBOTextureId_Pang;
            if (r7 == 0) goto L26;
            GLES30.glDeleteTextures(1, new int[]{r7}, 0);
        L26:
            int r8 = this.mFBOId_2;
            if (r8 == 0) goto L29;
            GLES30.glDeleteFramebuffers(1, new int[]{r8}, 0);
        L29:
            int r9 = this.mFBOTextureId_2;
            if (r9 == 0) goto L32;
            GLES30.glDeleteTextures(1, new int[]{r9}, 0);
        L32:
            int[] r10 = createFBO(this.mClipBounds.width(), this.mClipBounds.height());
            this.mFBOId_Clip = r10[0];
            this.mFBOTextureId_Clip = r10[1];
            int[] r11 = createFBO(this.mClipBounds.width(), this.mClipBounds.height());
            this.mFBOId_Mix = r11[0];
            this.mFBOTextureId_Mix = r11[1];
            this.mFboW = this.mClipBounds.width() / 2;
            int r12 = this.mClipBounds.height() / 2;
            this.mFboH = r12;
            int[] r13 = createFBO(this.mFboW, r12);
            this.mFBOId_1 = r13[0];
            this.mFBOTextureId_1 = r13[1];
            int[] r14 = createFBO(this.mFboW, this.mFboH);
            this.mFBOId_Pang = r14[0];
            this.mFBOTextureId_Pang = r14[1];
            this.mFboW_2 = (int) Math.ceil(this.mFboW / 2.0f);
            int r15 = (int) Math.ceil(this.mFboH / 2.0f);
            this.mFboH_2 = r15;
            int[] r16 = createFBO(this.mFboW_2, r15);
            this.mFBOId_2 = r16[0];
            this.mFBOTextureId_2 = r16[1];
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            int r13 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.mProgramPreprocessing = r13;
            this.mPositionHandlePreprocessing = GLES30.glGetAttribLocation(r13, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mRevertHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_revert");
            checkGlError("glGetUniformLocation");
            this.mUvOffsetHandlePreprocessing = GLES30.glGetUniformLocation(this.mProgramPreprocessing, "u_uvOffset");
            checkGlError("glGetUniformLocation");
            int[] r4 = loadVao(this.mProgramPreprocessing, this.mPositionHandlePreprocessing);
            this.mVAOIdPreprocessing = r4[0];
            this.mVBOIdPreprocessing = r4[1];
            int r5 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
            this.mProgramScaleDown = r5;
            this.mPositionHandleScaleDown = GLES30.glGetAttribLocation(r5, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mDirectionHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_direction");
            checkGlError("glGetUniformLocation");
            this.mBlurOffsetHandleScaleDown = GLES30.glGetUniformLocation(this.mProgramScaleDown, "u_blurOffset");
            checkGlError("glGetUniformLocation");
            int[] r6 = loadVao(this.mProgramScaleDown, this.mPositionHandleScaleDown);
            this.mVAOIdScaleDown = r6[0];
            this.mVBOIdScaleDown = r6[1];
            int r7 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.mProgramScaleUp = r7;
            this.mPositionHandleScaleUp = GLES30.glGetAttribLocation(r7, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mDirectionHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_direction");
            checkGlError("glGetUniformLocation");
            this.mBlurOffsetHandleScaleUp = GLES30.glGetUniformLocation(this.mProgramScaleUp, "u_blurOffset");
            checkGlError("glGetUniformLocation");
            int[] r8 = loadVao(this.mProgramScaleUp, this.mPositionHandleScaleUp);
            this.mVAOIdScaleUp = r8[0];
            this.mVBOIdScaleUp = r8[1];
            int r9 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
            this.mProgramClip = r9;
            this.mPositionHandleClip = GLES30.glGetAttribLocation(r9, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureHandleClip = GLES30.glGetUniformLocation(this.mProgramClip, "u_background");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleClip = GLES30.glGetUniformLocation(this.mProgramClip, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mRectHandleClip = GLES30.glGetUniformLocation(this.mProgramClip, "u_clip");
            checkGlError("glGetUniformLocation");
            int[] r10 = loadVao(this.mProgramClip, this.mPositionHandleClip);
            this.mVAOIdClip = r10[0];
            this.mVBOIdClip = r10[1];
            int r14 = createProgram("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
            this.mProgramMix = r14;
            this.mPositionHandleMix = GLES30.glGetAttribLocation(r14, "vPosition");
            checkGlError("glGetAttribLocation");
            this.mTextureAHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_background");
            checkGlError("glGetAttribLocation");
            this.mTextureBHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_foreground");
            checkGlError("glGetAttribLocation");
            this.mResolutionHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_resolution");
            checkGlError("glGetUniformLocation");
            this.mDirectionHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_direction");
            checkGlError("glGetUniformLocation");
            this.mBlurOffsetHandleMix = GLES30.glGetUniformLocation(this.mProgramMix, "u_blurOffset");
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
            GLES30.glTexParameteri(3553, 10242, 33648);
            GLES30.glTexParameteri(3553, 10243, 33648);
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
            GLES30.glTexParameteri(3553, 10241, 9728);
            GLES30.glTexParameteri(3553, 10240, 9728);
            GLES30.glTexParameteri(3553, 10242, 10497);
            GLES30.glTexParameteri(3553, 10243, 10497);
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

    public GL3ShaderViewProgressBlur(Context r2) {
        super(r2, null);
    }

    public GL3ShaderViewProgressBlur(Context r1, AttributeSet r2) {
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

    public void setClipRect(Rect r1) {
        this.mRenderer.setClipRect(r1);
    }

    public void setUvOffsets(float r1, float r2) {
        this.mRenderer.setUvOffsets(r1, r2);
    }

    public void setDirection(int r1) {
        this.mRenderer.setDirection(r1);
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
