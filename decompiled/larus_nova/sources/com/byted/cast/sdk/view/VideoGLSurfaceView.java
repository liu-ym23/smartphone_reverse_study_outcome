package com.byted.cast.sdk.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes43.dex */
public class VideoGLSurfaceView extends GLSurfaceView implements IRenderView {
    private static final String TAG = "VideoGLSurfaceView";
    private MeasureHelper mMeasureHelper;
    private VideoRenderer mRenderer;
    private IRenderView.IRenderCallback mSurfaceCallback;

    public static final class VideoRenderer implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
        private static final String TAG = "VideoRenderer";
        private static final int VERTICES_DATA_POS_OFFSET = 0;
        private static final int VERTICES_DATA_STRIDE_BYTES = 20;
        private static final int VERTICES_DATA_UV_OFFSET = 3;
        private Context mContext;
        private final String mFragmentShader;
        private float[] mMMatrix;
        private float[] mMVPMatrix;
        private int mProgram;
        private float[] mProjMatrix;
        private float mRatio;
        private IRenderView.IRenderCallback mRenderCallback;
        private float[] mSTMatrix;
        private SurfaceTexture mSurface;
        private int mTextureID;
        private float[] mVMatrix;
        private final String mVertexShader;
        private FloatBuffer mVertices;
        private final float[] mVerticesData;
        private WeakReference<VideoGLSurfaceView> mWeakSurfaceView;
        private int maPositionHandle;
        private int maTextureHandle;
        private int muMVPMatrixHandle;
        private int muSTMatrixHandle;
        private boolean updateSurface;

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurface;
        }

        private void checkGlError(String r100) {
            int r101 = GLES20.glGetError();
            if (r101 != 0) goto L6;
            return;
        L6:
            throw new RuntimeException(r100 + ": glError " + r101);
        }

        public void addRenderCallback(IRenderView.IRenderCallback r100) {
            this.mRenderCallback = r100;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r100) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.updateSurface == false) goto L6;
            this.mSurface.updateTexImage();     // Catch: Throwable -> L9
            this.mSurface.getTransformMatrix(this.mSTMatrix);     // Catch: Throwable -> L9
            this.updateSurface = false;     // Catch: Throwable -> L9
        L6:
            monitor-exit(this);     // Catch: Throwable -> L9
            GLES20.glClear(16640);
            GLES20.glUseProgram(this.mProgram);
            checkGlError("glUseProgram");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            this.mVertices.position(0);
            GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, this.mVertices);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(this.maPositionHandle);
            checkGlError("glEnableVertexAttribArray maPositionHandle");
            this.mVertices.position(3);
            GLES20.glVertexAttribPointer(this.maTextureHandle, 3, 5126, false, 20, this.mVertices);
            checkGlError("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(this.maTextureHandle);
            checkGlError("glEnableVertexAttribArray maTextureHandle");
            Matrix.setIdentityM(this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muMVPMatrixHandle, 1, false, this.mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(this.muSTMatrixHandle, 1, false, this.mSTMatrix, 0);
            GLES20.glDrawArrays(5, 0, 4);
            checkGlError("glDrawArrays");
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public synchronized void onFrameAvailable(SurfaceTexture r100) {
            monitor-enter(this);
            this.updateSurface = true;     // Catch: Throwable -> L9
            VideoGLSurfaceView r101 = this.mWeakSurfaceView.get();     // Catch: Throwable -> L9
            if (r101 == null) goto L7;
            r101.requestRender();     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void removeRenderCallback(IRenderView.IRenderCallback r100) {
            this.mRenderCallback = null;
        }

        public VideoRenderer(Context r100, VideoGLSurfaceView r101) {
            float[] r102 = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
            this.mVerticesData = r102;
            this.mVertexShader = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
            this.mFragmentShader = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
            this.mMVPMatrix = new float[16];
            this.mProjMatrix = new float[16];
            this.mMMatrix = new float[16];
            this.mVMatrix = new float[16];
            this.mSTMatrix = new float[16];
            this.mRatio = 1.0f;
            this.updateSurface = false;
            this.mContext = r100;
            this.mWeakSurfaceView = new WeakReference(r101);
            FloatBuffer r103 = ByteBuffer.allocateDirect(r102.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mVertices = r103;
            r103.put(r102).position(0);
            Matrix.setIdentityM(this.mSTMatrix, 0);
            Matrix.setIdentityM(this.mMMatrix, 0);
        }

        private int createProgram(String r100, String r101) {
            int r102 = loadShader(35633, r100);
            if (r102 != 0) goto L5;
            return 0;
        L5:
            int r103 = loadShader(35632, r101);
            if (r103 != 0) goto L8;
            return 0;
        L8:
            int r104 = GLES20.glCreateProgram();
            if (r104 == 0) goto L14;
            GLES20.glAttachShader(r104, r102);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(r104, r103);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(r104);
            int[] r105 = new int[1];
            GLES20.glGetProgramiv(r104, 35714, r105, 0);
            if (r105[0] == 1) goto L14;
            GLES20.glGetProgramInfoLog(r104);
            GLES20.glDeleteProgram(r104);
            return 0;
        L14:
            return r104;
        }

        private int loadShader(int r100, String r101) {
            int r102 = GLES20.glCreateShader(r100);
            if (r102 == 0) goto L8;
            GLES20.glShaderSource(r102, r101);
            GLES20.glCompileShader(r102);
            int[] r103 = new int[1];
            GLES20.glGetShaderiv(r102, 35713, r103, 0);
            if (r103[0] != 0) goto L9;
            GLES20.glGetShaderInfoLog(r102);
            GLES20.glDeleteShader(r102);
            return 0;
        L9:
            return r102;
        L8:
            return r102;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r110, EGLConfig r111) {
            int r112 = createProgram("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
            this.mProgram = r112;
            if (r112 != 0) goto L5;
            return;
        L5:
            this.maPositionHandle = GLES20.glGetAttribLocation(r112, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (this.maPositionHandle == (-1)) goto L35;
            this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
            checkGlError("glGetAttribLocation aTextureCoord");
            if (this.maTextureHandle == (-1)) goto L33;
            this.muMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
            checkGlError("glGetUniformLocation uMVPMatrix");
            if (this.muMVPMatrixHandle == (-1)) goto L31;
            this.muSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (this.muMVPMatrixHandle == (-1)) goto L29;
            checkGlError("glGetUniformLocation uCRatio");
            if (this.muMVPMatrixHandle == (-1)) goto L27;
            int[] r113 = new int[1];
            GLES20.glGenTextures(1, r113, 0);
            int r114 = r113[0];
            this.mTextureID = r114;
            GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, r114);
            checkGlError("glBindTexture mTextureID");
            GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
            GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
            GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
            GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
            checkGlError("glTexParameteri mTextureID");
            this.mSurface = new SurfaceTexture(this.mTextureID);
            Surface r115 = new Surface(this.mSurface);
            IRenderView.IRenderCallback r116 = this.mRenderCallback;
            if (r116 == null) goto L18;
            r116.onSurfaceTextureCreated(this.mWeakSurfaceView.get(), r115);
        L18:
            this.mSurface.setOnFrameAvailableListener(this);
            Matrix.setLookAtM(this.mVMatrix, 0, 0.0f, 0.0f, 4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            monitor-enter(this);
            this.updateSurface = false;     // Catch: Throwable -> L23
            monitor-exit(this);     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            throw th;
        L27:
            throw new RuntimeException("Could not get attrib location for uCRatio");
        L29:
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        L31:
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        L33:
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        L35:
            throw new RuntimeException("Could not get attrib location for aPosition");
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r100, int r110, int r111) {
            GLES20.glViewport(0, 0, r110, r111);
            if (r110 <= r111) goto L5;
            float r101 = r110;
            float r102 = r111;
        L6:
            float r103 = r101 / r102;
            if (r110 <= r111) goto L9;
            Matrix.orthoM(this.mProjMatrix, 0, -r103, r103, -1.0f, 1.0f, 0.0f, 10.0f);
            return;
        L9:
            Matrix.orthoM(this.mProjMatrix, 0, -1.0f, 1.0f, -r103, r103, 0.0f, 10.0f);
            return;
        L5:
            r101 = r111;
            r102 = r110;
            goto L6
        }
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public View getView() {
        return this;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoRotation(int r100) {
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mRenderer.getSurfaceTexture();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
    }

    public VideoGLSurfaceView(Context r100) {
        super(r100, null);
        init(r100);
        initView(r100);
    }

    private void init(Context r100) {
        setEGLContextClientVersion(2);
        VideoRenderer r101 = new VideoRenderer(r100, this);
        this.mRenderer = r101;
        setRenderer(r101);
        setRenderMode(0);
    }

    private void initView(Context r100) {
        this.mMeasureHelper = new MeasureHelper(this);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void addRenderCallback(IRenderView.IRenderCallback r100) {
        this.mRenderer.addRenderCallback(r100);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void removeRenderCallback(IRenderView.IRenderCallback r100) {
        this.mRenderer.removeRenderCallback(r100);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setAspectRatio(int r100) {
        this.mMeasureHelper.setAspectRatio(r100);
        requestLayout();
    }

    public VideoGLSurfaceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r100);
        initView(r100);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r100, int r101) {
        this.mMeasureHelper.doMeasure(r100, r101);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSampleAspectRatio(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L7;
        this.mMeasureHelper.setVideoSampleAspectRatio(r100, r101);
        requestLayout();
        return;
    L7:
        return;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSize(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L7;
        this.mMeasureHelper.setVideoSize(r100, r101);
        getHolder().setFixedSize(r100, r101);
        requestLayout();
        return;
    L7:
        return;
    }
}
