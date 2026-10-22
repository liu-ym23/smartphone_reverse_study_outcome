package com.stepos.activeview.texture;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.TextureView;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.stepos.activeview.elements.GLImageView;
import com.stepos.activeview.utils.LogUtil;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Property;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* loaded from: classes.dex */
public class GLImageRender implements TextureView.SurfaceTextureListener {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAG_SHADER = "precision highp float;\n//TODO 若变量前面加上flat描述， 则该变量就不会经过差值，否则所有传到片段着色器中的变量都是经过了差值计算的\n//纹理坐标\nvarying vec2 vTextCoord;\nuniform sampler2D uSampler;\n//中心点\nuniform vec2 uCenter;\n//光圈半径\nuniform float uApertureR;\n//模糊系数\nuniform float uBlur;\n//经过差值后的时间t\nuniform float uT;\n\nfloat formatTextureCoord(float x){\n    if(x < 0.0){\n        return 0.0;\n    }else if(x > 1.0){\n        return 1.0;\n    }else{\n        return x;\n    }\n}\n\n//模糊处理\nvec4 getBlurColor(float cellNum, float density){\n    //加大原本点的权重\n    vec4 result = texture2D(uSampler, vTextCoord) ;\n    float num = 1.0;\n    //包含最后一个点，避免平均图像会向左偏移\n    for(float i = -cellNum / 2.0; i < cellNum / 2.0 + 0.01; i += 1.0){\n        for(float j = -cellNum / 2.0; j < cellNum / 2.0 + 0.01; j += 1.0){\n            vec4 color = texture2D(uSampler, vec2(formatTextureCoord(vTextCoord.x + i * uBlur/ density), formatTextureCoord(vTextCoord.y + j * uBlur / density)));\n            result = result + color;\n            num ++;\n        }\n    }\n    result /= num;\n    return result;\n}\n\n//光圈处理, 调用模糊处理后的颜色\nvec4 getApertureColor(){\n    //设置颜色\n    if(length(uCenter - vec2(gl_FragCoord.x, gl_FragCoord.y)) > uApertureR){\n        return vec4(0, 0, 0, 0);\n    }else{\n       if(uBlur > 0.0)\n           return getBlurColor(10.0, 96.0);\n       else\n           return texture2D(uSampler, vTextCoord);\n    }\n}\n\nvoid main()\n{\n    //设置颜色\n    gl_FragColor = getApertureColor();\n}";
    private static final int INT_SIZE_BYTES = 4;
    private static final int UNVALID_HANDLER = -1;
    private static final String VERT_SHADER = "//起点位置\nattribute vec2 aVertexStartPosition;\n//终点位置\nattribute vec2 aVertexEndPosition;\n//经过差值后的时间t\nuniform float uT;\n//纹理坐标\nattribute vec2 aTextCoord;\n//传递给片段着色器的纹理坐标, 实际上只需要传递本顶点的坐标， 片段着色器中的纹理坐标是已经经过计算了的\nvarying vec2 vTextCoord;\nuniform mat4 uModelViewMatrix;\nuniform mat4 uProjectionMatrix;\n\n//飘动处理\nvec3 afterWave(){\n    return vec3(aVertexStartPosition + (aVertexEndPosition - aVertexStartPosition)*uT, 0);\n}\n\nvoid main()\n{\n  vec3 nowPosition = afterWave();\n  gl_Position = uProjectionMatrix * uModelViewMatrix * vec4(nowPosition, 1.0);\n  vTextCoord = aTextCoord;\n}";
    private static EglCore mEglCore;
    private static Handler sDrawHandler;
    private static HandlerThread sDrawThread;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private float[][][] mEndCanvasPoints;
    private FloatBuffer mEndVertCoordBuffer;
    private int mHeight;
    private float[] mModelViewMatrix;
    private float[] mProjectionMatrix;
    private float[][][] mStartCanvasPoints;
    private FloatBuffer mStartVertCoordBuffer;
    private FloatBuffer mTextureCoordBuffer;
    private GLImageView mView;
    private int mWidth;
    private WindowSurface mWindowSurface;
    private int mTextureId = -1;
    private int mProgram = -1;
    private int mIndicisBufferHandler = -1;
    private int mVertShaderHandler = -1;
    private int mFragShaderHandler = -1;
    private Bitmap mBitmap = null;
    private int[] mIndices = null;
    private float mFraction = Property.DEFAULT_FLOAT_VALUE;
    private float mBlur = Property.DEFAULT_FLOAT_VALUE;
    private float[] mCenterLocation = null;
    private float mApertureR = 1.0f;
    private boolean mPrepareToDestroy = false;
    private int uModelViewMatrix = -1;
    private int uProjectionMatrix = -1;
    private boolean mIsDirty = false;
    private Runnable mRunnable = new Runnable() { // from class: com.stepos.activeview.texture.GLImageRender.5
        @Override // java.lang.Runnable
        public void run() {
            GLImageRender.this.invalidateInternal();
        }
    };

    private void camera() {
        GLES20.glUniformMatrix4fv(this.uModelViewMatrix, 1, false, this.mModelViewMatrix, 0);
        GLES20.glUniformMatrix4fv(this.uProjectionMatrix, 1, false, this.mProjectionMatrix, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createProgram() {
        if (this.mProgram != -1 || this.mWidth == 0 || this.mHeight == 0) {
            return;
        }
        this.mProgram = GLES20.glCreateProgram();
        this.mVertShaderHandler = loadShader(35633, VERT_SHADER);
        this.mFragShaderHandler = loadShader(35632, FRAG_SHADER);
        GLES20.glLinkProgram(this.mProgram);
        GLES20.glGetProgramiv(this.mProgram, 35714, new int[1], 0);
        GLES20.glUseProgram(this.mProgram);
        GLES20.glEnable(2929);
        GLES20.glEnable(3553);
        GLES20.glClear(16640);
        GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
        initData();
        this.mPrepareToDestroy = false;
    }

    private void draw() {
        if (this.mProgram != -1) {
            if (this.mBitmap == null) {
                GLES20.glClearColor(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
                GLES20.glClear(16640);
                this.mWindowSurface.swapBuffers();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            GLES20.glBindTexture(3553, this.mTextureId);
            camera();
            GLES20.glBindBuffer(34963, this.mIndicisBufferHandler);
            load2dCoord(this.mTextureCoordBuffer, "aTextCoord");
            loadCenterPosition();
            loadApertureR();
            loadBlur();
            loadT(this.mFraction);
            load2dCoord(this.mStartVertCoordBuffer, "aVertexStartPosition");
            load2dCoord(this.mEndVertCoordBuffer, "aVertexEndPosition");
            LogUtil.i("load2dCoord:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            GLES20.glClearColor(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            GLES20.glClear(16640);
            GLES20.glDrawElements(4, this.mIndices.length, 5125, 0);
            LogUtil.i("glDrawElements:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.mWindowSurface.swapBuffers();
            LogUtil.i("eglSwapBuffers:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    private float[][][] getCells(int i4, int i5, Rect rect) {
        float f4 = (rect.right - rect.left) / i5;
        float f5 = (rect.top - rect.bottom) / i4;
        float[][][] fArr = (float[][][]) Array.newInstance((Class<?>) Float.TYPE, i4 + 1, i5 + 1, 2);
        for (int i6 = 0; i6 <= i4; i6++) {
            float[][] fArr2 = fArr[i6];
            for (int i7 = 0; i7 <= i5; i7++) {
                float[] fArr3 = fArr2[i7];
                fArr3[0] = (i7 * f4) + rect.left;
                fArr3[1] = (i6 * f5) + rect.bottom;
            }
        }
        return fArr;
    }

    private FloatBuffer getDataBuffer(float[] fArr) {
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        return floatBufferAsFloatBuffer;
    }

    private static Handler getDrawThreadHandler() {
        if (sDrawHandler == null) {
            HandlerThread handlerThread = new HandlerThread("GLImageDrawThread");
            sDrawThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(sDrawThread.getLooper());
            sDrawHandler = handler;
            handler.post(new Runnable() { // from class: com.stepos.activeview.texture.GLImageRender.1
                @Override // java.lang.Runnable
                public void run() {
                    GLImageRender.mEglCore = new EglCore(null, 2);
                }
            });
        }
        return sDrawHandler;
    }

    private int[] getIndices(float[][][] fArr) {
        int[] iArr = new int[(fArr[0].length - 1) * (fArr.length - 1) * 6];
        int i4 = 0;
        for (int i5 = 0; i5 < fArr.length - 1; i5++) {
            int length = fArr[i5].length;
            int i6 = 0;
            while (i6 < length - 1) {
                int i7 = length * i5;
                int i8 = i7 + i6;
                int i9 = (i5 + 1) * length;
                int i10 = i9 + i6;
                i6++;
                int i11 = i9 + i6;
                iArr[i4] = i11;
                iArr[i4 + 1] = i10;
                iArr[i4 + 2] = i8;
                iArr[i4 + 3] = i7 + i6;
                int i12 = i4 + 5;
                iArr[i4 + 4] = i11;
                i4 += 6;
                iArr[i12] = i8;
            }
        }
        return iArr;
    }

    private void initData() {
        if (this.mStartCanvasPoints == null) {
            float[] fArr = {Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE};
            int i4 = this.mWidth;
            float[][] fArr2 = {fArr, new float[]{i4, Property.DEFAULT_FLOAT_VALUE}};
            int i5 = this.mHeight;
            float[][][] fArr3 = {fArr2, new float[][]{new float[]{Property.DEFAULT_FLOAT_VALUE, i5}, new float[]{i4, i5}}};
            this.mEndCanvasPoints = fArr3;
            this.mStartCanvasPoints = fArr3;
        }
        loadTexture();
        loadCameraMatrix();
        int[] indices = getIndices(this.mStartCanvasPoints);
        this.mIndices = indices;
        loadIndices(indices);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (this.mPrepareToDestroy || this.mIsDirty) {
            return;
        }
        this.mIsDirty = true;
        if (Thread.currentThread() != sDrawThread) {
            getDrawThreadHandler().post(this.mRunnable);
        } else {
            invalidateInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateInternal() {
        this.mIsDirty = false;
        if (this.mPrepareToDestroy) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        WindowSurface windowSurface = this.mWindowSurface;
        if (windowSurface != null) {
            try {
                windowSurface.makeCurrent();
                draw();
            } catch (RuntimeException e4) {
                e4.printStackTrace();
            }
        }
        LogUtil.i("invalidateInternal elapse:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " this:" + hashCode());
    }

    private void load2dCoord(FloatBuffer floatBuffer, String str) {
        floatBuffer.position(0);
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, str);
        GLES20.glVertexAttribPointer(iGlGetAttribLocation, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
    }

    private void loadApertureR() {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "uApertureR");
        float f4 = this.mApertureR;
        int i4 = this.mWidth;
        int i5 = this.mHeight;
        GLES20.glUniform1f(iGlGetUniformLocation, f4 * ((float) Math.pow((((i5 / 2) * i5) / 2) + (((i4 / 2) * i4) / 2), 0.5d)));
    }

    private void loadBlur() {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgram, "uBlur"), this.mBlur);
    }

    private void loadCameraMatrix() {
        int i4;
        if (this.mModelViewMatrix == null) {
            this.mModelViewMatrix = new float[16];
            this.uModelViewMatrix = GLES20.glGetUniformLocation(this.mProgram, "uModelViewMatrix");
            Matrix.setRotateM(this.mModelViewMatrix, 0, Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            float[] fArr = this.mModelViewMatrix;
            int i5 = this.mWidth;
            int i6 = this.mHeight;
            Matrix.setLookAtM(fArr, 0, i5 / 2.0f, i6 / 2.0f, 1.0f, i5 / 2.0f, i6 / 2.0f, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE);
            float[] fArr2 = new float[16];
            this.mProjectionMatrix = fArr2;
            Matrix.setRotateM(fArr2, 0, Property.DEFAULT_FLOAT_VALUE, 1.0f, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            int i7 = this.mWidth;
            if (i7 != 0 && (i4 = this.mHeight) != 0) {
                Matrix.orthoM(this.mProjectionMatrix, 0, (-i7) / 2.0f, i7 / 2.0f, (-i4) / 2.0f, i4 / 2.0f, -100.0f, 100.0f);
            }
            this.uProjectionMatrix = GLES20.glGetUniformLocation(this.mProgram, "uProjectionMatrix");
        }
    }

    private void loadCenterPosition() {
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "uCenter");
        float[] fArr = this.mCenterLocation;
        GLES20.glUniform2f(iGlGetUniformLocation, fArr[0], fArr[1]);
    }

    private void loadIndices(int[] iArr) {
        IntBuffer dataBuffer = getDataBuffer(iArr);
        int[] iArr2 = new int[1];
        GLES20.glGenBuffers(1, iArr2, 0);
        GLES20.glBindBuffer(34963, iArr2[0]);
        GLES20.glBufferData(34963, iArr.length * 4, dataBuffer, 35044);
        this.mIndicisBufferHandler = iArr2[0];
    }

    private int loadShader(int i4, String str) {
        if (this.mProgram == -1) {
            return -1;
        }
        int iGlCreateShader = GLES20.glCreateShader(i4);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
                GLES20.glDeleteShader(iGlCreateShader);
                LogUtil.e("Could not compile shader " + i4 + AwarenessDataItem.USERID_SPLITTER + strGlGetShaderInfoLog);
            }
        }
        GLES20.glAttachShader(this.mProgram, iGlCreateShader);
        return iGlCreateShader;
    }

    private void loadT(float f4) {
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.mProgram, "uT"), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadTexture() {
        float[][][] fArr = this.mStartCanvasPoints;
        this.mTextureCoordBuffer = getDataBuffer(points2Vertices(getCells(fArr.length - 1, fArr[0].length - 1, new Rect(0, 0, this.mBitmapWidth, this.mBitmapHeight)), true, this.mBitmapWidth, this.mBitmapHeight));
        int i4 = this.mTextureId;
        if (i4 != -1) {
            GLES20.glDeleteTextures(1, new int[]{i4}, 0);
            this.mTextureId = -1;
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            LogUtil.e("loadTexture mBitmap is null or recycled");
            return;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mTextureId = iArr[0];
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mTextureId);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, BmLocated.HALF_RIGHT_BOTTOM, 9728.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, this.mBitmap, 0);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.mProgram, "uSampler"), 0);
    }

    private float[] points2Vertices(float[][][] fArr, boolean z4, int i4, int i5) {
        float[] fArr2 = new float[fArr.length * fArr[0].length * 2];
        int i6 = 0;
        for (float[][] fArr3 : fArr) {
            for (float[] fArr4 : fArr3) {
                if (z4) {
                    int i7 = i6 + 1;
                    fArr2[i6] = fArr4[0] / i4;
                    i6 += 2;
                    fArr2[i7] = fArr4[1] / i5;
                } else {
                    int i8 = i6 + 1;
                    fArr2[i6] = fArr4[0];
                    i6 += 2;
                    fArr2[i8] = fArr4[1];
                }
            }
        }
        return fArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        int i4 = this.mProgram;
        if (i4 != -1) {
            GLES20.glDetachShader(i4, this.mFragShaderHandler);
            GLES20.glDeleteShader(this.mFragShaderHandler);
            GLES20.glDetachShader(this.mProgram, this.mVertShaderHandler);
            GLES20.glDeleteShader(this.mVertShaderHandler);
            GLES20.glDeleteProgram(this.mProgram);
            this.mWindowSurface.release();
            this.mWindowSurface = null;
            this.mProgram = -1;
            int i5 = this.mTextureId;
            if (i5 != -1) {
                GLES20.glDeleteTextures(1, new int[]{i5}, 0);
                this.mTextureId = -1;
            }
            int i6 = this.mIndicisBufferHandler;
            if (i6 != -1) {
                GLES20.glDeleteBuffers(1, new int[]{i6}, 0);
                this.mIndicisBufferHandler = -1;
            }
            this.uModelViewMatrix = -1;
            this.uProjectionMatrix = -1;
            this.mModelViewMatrix = null;
            this.mProjectionMatrix = null;
        }
    }

    public float getBlur() {
        return this.mBlur;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int i4, final int i5) {
        getDrawThreadHandler().post(new Runnable() { // from class: com.stepos.activeview.texture.GLImageRender.2
            @Override // java.lang.Runnable
            public void run() {
                GLImageRender.this.mWindowSurface = new WindowSurface(GLImageRender.mEglCore, surfaceTexture);
                GLImageRender.this.mWindowSurface.makeCurrent();
                GLImageRender.this.mWidth = i4;
                GLImageRender.this.mHeight = i5;
                GLImageRender.this.mCenterLocation = new float[]{r0.mWidth / 2.0f, GLImageRender.this.mHeight / 2.0f};
                if (GLImageRender.this.mStartCanvasPoints == null) {
                    float[][][] fArr = {new float[][]{new float[]{Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE}, new float[]{GLImageRender.this.mWidth, Property.DEFAULT_FLOAT_VALUE}}, new float[][]{new float[]{Property.DEFAULT_FLOAT_VALUE, GLImageRender.this.mHeight}, new float[]{GLImageRender.this.mWidth, GLImageRender.this.mHeight}}};
                    GLImageRender.this.setPoints(fArr, fArr, Property.DEFAULT_FLOAT_VALUE);
                }
                GLImageRender.this.createProgram();
                if (GLImageRender.this.mTextureId == -1 && GLImageRender.this.mBitmap != null) {
                    GLImageRender.this.loadTexture();
                }
                GLImageRender.this.invalidate();
                GLImageRender.this.mView.post(new Runnable() { // from class: com.stepos.activeview.texture.GLImageRender.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GLImageRender.this.mView.setAlpha(1.0f);
                    }
                });
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mPrepareToDestroy = true;
        getDrawThreadHandler().post(new Runnable() { // from class: com.stepos.activeview.texture.GLImageRender.3
            @Override // java.lang.Runnable
            public void run() {
                GLImageRender.this.release();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
        this.mCenterLocation = new float[]{i4 / 2.0f, i5 / 2.0f};
        this.mApertureR = 1.0f;
        invalidate();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setApertureData(float f4, float[] fArr) {
        this.mApertureR = f4;
        if (fArr == null || fArr.length != 2) {
            fArr = new float[]{this.mWidth / 2, this.mHeight / 2};
        }
        this.mCenterLocation = fArr;
        invalidate();
    }

    public void setBlur(float f4) {
        this.mBlur = f4;
        invalidate();
    }

    public void setImageBitmap(final Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        getDrawThreadHandler().post(new Runnable() { // from class: com.stepos.activeview.texture.GLImageRender.4
            @Override // java.lang.Runnable
            public void run() {
                GLImageRender.this.mBitmap = bitmap;
                GLImageRender gLImageRender = GLImageRender.this;
                gLImageRender.mBitmapWidth = gLImageRender.mBitmap.getWidth();
                GLImageRender gLImageRender2 = GLImageRender.this;
                gLImageRender2.mBitmapHeight = gLImageRender2.mBitmap.getHeight();
                if (GLImageRender.this.mWindowSurface != null) {
                    GLImageRender.this.mWindowSurface.makeCurrent();
                    GLImageRender.this.loadTexture();
                    GLImageRender.this.invalidate();
                }
            }
        });
    }

    public void setPoints(float[][][] fArr, float[][][] fArr2, float f4) {
        this.mFraction = f4;
        float[][][] fArr3 = this.mStartCanvasPoints;
        if (fArr != fArr3 || fArr2 != this.mEndCanvasPoints) {
            if (fArr != fArr3) {
                this.mStartCanvasPoints = fArr;
                this.mStartVertCoordBuffer = getDataBuffer(points2Vertices(fArr, false, 0, 0));
            }
            if (fArr2 != this.mEndCanvasPoints) {
                this.mEndCanvasPoints = fArr2;
                this.mEndVertCoordBuffer = getDataBuffer(points2Vertices(fArr2, false, 0, 0));
            }
        }
        invalidate();
    }

    public void setView(GLImageView gLImageView) {
        this.mView = gLImageView;
    }

    private IntBuffer getDataBuffer(int[] iArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.allocateDirect(iArr.length * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        intBufferAsIntBuffer.put(iArr).position(0);
        return intBufferAsIntBuffer;
    }
}
