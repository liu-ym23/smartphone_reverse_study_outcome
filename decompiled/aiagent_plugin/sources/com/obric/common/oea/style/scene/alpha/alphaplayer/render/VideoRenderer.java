package com.obric.common.oea.style.scene.alpha.alphaplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.d;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: VideoRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VideoRenderer implements IRender {
    private final int FLOAT_SIZE_BYTES;
    private final int GL_TEXTURE_EXTERNAL_OES;
    private final String TAG;
    private final int TRIANGLE_VERTICES_DATA_POS_OFFSET;
    private final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES;
    private final int TRIANGLE_VERTICES_DATA_UV_OFFSET;
    private int aPositionHandle;
    private int aTextureHandle;
    private final a alphaVideoView;
    private final AtomicBoolean canDraw;
    private float[] halfRightVerticeData;
    private final float[] mVPMatrix;
    private int programID;
    private final float[] sTMatrix;
    private d scaleType;
    private IRender.a surfaceListener;
    private SurfaceTexture surfaceTexture;
    private int textureID;
    private FloatBuffer triangleVertices;
    private int uMVPMatrixHandle;
    private int uSTMatrixHandle;
    private final AtomicBoolean updateSurface;

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public VideoRenderer(a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        o.e(r5, "alphaVideoView");
        this.alphaVideoView = r5;
        this.TAG = "VideoRender";
        this.FLOAT_SIZE_BYTES = 4;
        this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 4 * 5;
        this.TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
        this.GL_TEXTURE_EXTERNAL_OES = 36197;
        this.halfRightVerticeData = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.mVPMatrix = new float[16];
        float[] r0 = new float[16];
        this.sTMatrix = r0;
        this.canDraw = new AtomicBoolean(false);
        this.updateSurface = new AtomicBoolean(false);
        this.scaleType = d.f32495c;
        FloatBuffer r6 = ByteBuffer.allocateDirect(this.halfRightVerticeData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        o.c(r6, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.triangleVertices = r6;
        r6.put(this.halfRightVerticeData).position(0);
        Matrix.setIdentityM(r0, 0);
    }

    public final a getAlphaVideoView() {
        return this.alphaVideoView;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void setScaleType(d r2) {
        o.e(r2, "scaleType");
        this.scaleType = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void measureInternal(float r4, float r5, float r6, float r7) {
        float r1 = 0;
        if (r4 > r1) goto L5;
        return;
    L5:
        if (r5 > r1) goto L7;
        return;
    L7:
        if (r6 > r1) goto L9;
        return;
    L9:
        if (r7 <= r1) goto L16;
        float[] r8 = com.obric.common.oea.style.scene.alpha.alphaplayer.b.a.a(this.scaleType, r4, r5, r6, r7);
        o.c(r8, "TextureCropUtil.calculat… videoWidth, videoHeight)");
        this.halfRightVerticeData = r8;
        FloatBuffer r9 = ByteBuffer.allocateDirect(r8.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        o.c(r9, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.triangleVertices = r9;
        r9.put(this.halfRightVerticeData).position(0);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void setSurfaceListener(IRender.a r3) {
        IRender.a r4 = (IRender.a) ZeusTransformUtils.wrapperContextForParams(r3, IRender.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "surfaceListener");
        this.surfaceListener = r4;
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m
    public void onDrawFrame(GL10 r11) {
        o.e((GL10) ZeusTransformUtils.wrapperContextForParams(r11, GL10.class, "com.obric.aiagent.plugin"), "glUnused");
        if (this.updateSurface.compareAndSet(true, false) == true) goto L21;
    L15:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.canDraw.get() == true) goto L19;
        GLES20.glFinish();
        return;
    L19:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.programID);
        checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.textureID);
        this.triangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.aPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, (Buffer) ZeusTransformUtils.preCheckCast(this.triangleVertices, Buffer.class, "com.obric.aiagent.plugin"));
        checkGlError("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.aPositionHandle);
        checkGlError("glEnableVertexAttribArray aPositionHandle");
        this.triangleVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.aTextureHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, (Buffer) ZeusTransformUtils.preCheckCast(this.triangleVertices, Buffer.class, "com.obric.aiagent.plugin"));
        checkGlError("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.aTextureHandle);
        checkGlError("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.mVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uMVPMatrixHandle, 1, false, this.mVPMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uSTMatrixHandle, 1, false, this.sTMatrix, 0);
        GLES20.glDrawArrays(5, 0, 4);
        checkGlError("glDrawArrays");
        GLES20.glFinish();
        return;
    L21:
        SurfaceTexture r12 = this.surfaceTexture;     // Catch: Exception -> L9
        if (r12 != null) goto L7;
        o.c("surfaceTexture");     // Catch: Exception -> L9
    L7:
        r12.updateTexImage();     // Catch: Exception -> L9
    L11:
        SurfaceTexture r13 = this.surfaceTexture;
        if (r13 != null) goto L14;
        o.c("surfaceTexture");
    L14:
        r13.getTransformMatrix(this.sTMatrix);
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m
    public void onSurfaceChanged(GL10 r2, int r3, int r4) {
        o.e((GL10) ZeusTransformUtils.wrapperContextForParams(r2, GL10.class, "com.obric.aiagent.plugin"), "glUnused");
        GLES20.glViewport(0, 0, r3, r4);
    }

    @Override // android.opengl.GLSurfaceView.Renderer, com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.m
    public void onSurfaceCreated(GL10 r3, EGLConfig r4) {
        o.e((GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.aiagent.plugin"), "glUnused");
        o.e(r4, "config");
        int r5 = createProgram();
        this.programID = r5;
        if (r5 != 0) goto L5;
        return;
    L5:
        this.aPositionHandle = GLES20.glGetAttribLocation(r5, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.aPositionHandle == (-1)) goto L22;
        this.aTextureHandle = GLES20.glGetAttribLocation(this.programID, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.aTextureHandle == (-1)) goto L20;
        this.uMVPMatrixHandle = GLES20.glGetUniformLocation(this.programID, "uMVPMatrix");
        checkGlError("glGetUniformLocation uMVPMatrix");
        if (this.uMVPMatrixHandle == (-1)) goto L18;
        this.uSTMatrixHandle = GLES20.glGetUniformLocation(this.programID, "uSTMatrix");
        checkGlError("glGetUniformLocation uSTMatrix");
        if (this.uSTMatrixHandle == (-1)) goto L16;
        prepareSurface();
        return;
    L16:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for uSTMatrix"), Throwable.class, "com.obric.aiagent.plugin"));
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for uMVPMatrix"), Throwable.class, "com.obric.aiagent.plugin"));
    L20:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for aTextureCoord"), Throwable.class, "com.obric.aiagent.plugin"));
    L22:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("Could not get attrib location for aPosition"), Throwable.class, "com.obric.aiagent.plugin"));
    }

    public void onSurfaceDestroyed(GL10 r3) {
        GL10 r4 = (GL10) ZeusTransformUtils.wrapperContextForParams(r3, GL10.class, "com.obric.aiagent.plugin");
        IRender.a r2 = this.surfaceListener;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    private final void prepareSurface() {
        int[] r1 = new int[1];
        GLES20.glGenTextures(1, r1, 0);
        int r2 = r1[0];
        this.textureID = r2;
        GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, r2);
        checkGlError("glBindTexture textureID");
        GLES20.glTexParameterf(this.GL_TEXTURE_EXTERNAL_OES, 10241, 9728);
        GLES20.glTexParameterf(this.GL_TEXTURE_EXTERNAL_OES, 10240, 9729);
        this.surfaceTexture = new SurfaceTexture(this.textureID);
        if (Build.VERSION.SDK_INT < 15) goto L8;
        SurfaceTexture r3 = this.surfaceTexture;
        if (r3 != null) goto L7;
        o.c("surfaceTexture");
    L7:
        r3.setDefaultBufferSize(this.alphaVideoView.getMeasuredWidth(), this.alphaVideoView.getMeasuredHeight());
    L8:
        SurfaceTexture r4 = this.surfaceTexture;
        if (r4 != null) goto L11;
        o.c("surfaceTexture");
    L11:
        r4.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) ZeusTransformUtils.preCheckCast(this, SurfaceTexture.OnFrameAvailableListener.class, "com.obric.aiagent.plugin"));
        SurfaceTexture r5 = this.surfaceTexture;
        if (r5 != null) goto L14;
        o.c("surfaceTexture");
    L14:
        Surface r6 = new Surface(r5);
        IRender.a r7 = this.surfaceListener;
        if (r7 == null) goto L17;
        r7.a(r6);
    L17:
        this.updateSurface.compareAndSet(true, false);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r3) {
        o.e(r3, "surface");
        this.updateSurface.compareAndSet(false, true);
        this.alphaVideoView.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void onFirstFrame() {
        this.canDraw.compareAndSet(false, true);
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(this.TAG, "onFirstFrame:    canDraw = " + this.canDraw.get());
        this.alphaVideoView.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void onCompletion() {
        this.canDraw.compareAndSet(true, false);
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(this.TAG, "onCompletion:   canDraw = " + this.canDraw.get());
        this.alphaVideoView.requestRender();
    }

    private final int loadShader(int r5, String r6) {
        int r0 = GLES20.glCreateShader(r5);
        if (r0 == 0) goto L8;
        GLES20.glShaderSource(r0, r6);
        GLES20.glCompileShader(r0);
        int[] r7 = new int[1];
        GLES20.glGetShaderiv(r0, 35713, r7, 0);
        if (r7[0] != 0) goto L9;
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, "Could not compile shader " + r5 + ':');
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, GLES20.glGetShaderInfoLog(r0));
        GLES20.glDeleteShader(r0);
        return 0;
    L9:
        return r0;
    L8:
        return r0;
    }

    private final int createProgram() {
        int r0 = loadShader(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r0 != 0) goto L6;
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, "Failed to compile vertex shader");
        return 0;
    L6:
        int r2 = loadShader(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r2 != 0) goto L10;
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, "Failed to compile fragment shader");
        GLES20.glDeleteShader(r0);
        return 0;
    L10:
        int r3 = GLES20.glCreateProgram();
        if (r3 == 0) goto L16;
        GLES20.glAttachShader(r3, r0);
        checkGlError("glAttachShader");
        GLES20.glAttachShader(r3, r2);
        checkGlError("glAttachShader");
        GLES20.glLinkProgram(r3);
        int[] r4 = new int[1];
        GLES20.glGetProgramiv(r3, 35714, r4, 0);
        if (r4[0] == 1) goto L16;
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, "Could not link programID: ");
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, GLES20.glGetProgramInfoLog(r3));
        GLES20.glDeleteProgram(r3);
        return 0;
    L16:
        return r3;
    }

    private final void checkGlError(String r3) {
        int r0 = GLES20.glGetError();
        if (r0 == 0) goto L6;
        INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(this.TAG, r3 + ": glError " + r0);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_common_oea_style_scene_alpha_alphaplayer_render_VideoRenderer_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
