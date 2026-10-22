package com.android.server.display;

import android.R;
import android.content.Context;
import android.graphics.BLASTBufferQueue;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManagerInternal;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Slog;
import android.view.DisplayInfo;
import android.view.Surface;
import android.view.SurfaceControl;
import android.window.ScreenCapture;
import com.android.internal.policy.TransitionAnimation;
import com.android.server.LocalServices;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import libcore.io.Streams;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: loaded from: classes2.dex */
final class ColorFade {
    private static final int COLOR_FADE_LAYER = 1073741825;
    private static final boolean DEBUG = true;
    private static final int DEJANK_FRAMES = 3;
    private static final int EGL_GL_COLORSPACE_DISPLAY_P3_PASSTHROUGH_EXT = 13456;
    private static final int EGL_GL_COLORSPACE_KHR = 12445;
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    public static final int MODE_COOL_DOWN = 1;
    public static final int MODE_FADE = 2;
    public static final int MODE_WARM_UP = 0;
    private static final String TAG = "ColorFade";
    private BLASTBufferQueue mBLASTBufferQueue;
    private SurfaceControl mBLASTSurfaceControl;
    private boolean mCreatedResources;
    private int mDisplayHeight;
    private final int mDisplayId;
    private int mDisplayLayerStack;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private int mDisplayWidth;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private final int[] mGLBuffers;
    private int mGammaLoc;
    private boolean mLastWasProtectedContent;
    private boolean mLastWasWideColor;
    private int mMode;
    private int mOpacityLoc;
    private boolean mPrepared;
    private int mProgram;
    private final float[] mProjMatrix;
    private int mProjMatrixLoc;
    private Surface mSurface;
    private float mSurfaceAlpha;
    private SurfaceControl mSurfaceControl;
    private NaturalSurfaceLayout mSurfaceLayout;
    private boolean mSurfaceVisible;
    private final FloatBuffer mTexCoordBuffer;
    private int mTexCoordLoc;
    private final float[] mTexMatrix;
    private int mTexMatrixLoc;
    private final int[] mTexNames;
    private boolean mTexNamesGenerated;
    private int mTexUnitLoc;
    private final SurfaceControl.Transaction mTransaction;
    private final FloatBuffer mVertexBuffer;
    private int mVertexLoc;

    private static final class NaturalSurfaceLayout implements DisplayManagerInternal.DisplayTransactionListener {
        private final int mDisplayId;
        private final DisplayManagerInternal mDisplayManagerInternal;
        private SurfaceControl mSurfaceControl;

        public NaturalSurfaceLayout(DisplayManagerInternal displayManagerInternal, int displayId, SurfaceControl surfaceControl) {
            this.mDisplayManagerInternal = displayManagerInternal;
            this.mDisplayId = displayId;
            this.mSurfaceControl = surfaceControl;
            this.mDisplayManagerInternal.registerDisplayTransactionListener(this);
        }

        public void dispose() {
            monitor-enter(this);
            this.mSurfaceControl = null;     // Catch: Throwable -> L8
            monitor-exit(this);     // Catch: Throwable -> L8
            this.mDisplayManagerInternal.unregisterDisplayTransactionListener(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void onDisplayTransaction(SurfaceControl.Transaction t) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mSurfaceControl != null) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            DisplayInfo displayInfo = this.mDisplayManagerInternal.getDisplayInfo(this.mDisplayId);     // Catch: Throwable -> L7
            if (displayInfo != null) goto L14;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L14:
            switch(displayInfo.rotation) {
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                default: goto L20;
            };     // Catch: Throwable -> L7
        L16:
            t.setPosition(this.mSurfaceControl, displayInfo.logicalWidth, 0.0f);     // Catch: Throwable -> L7
            t.setMatrix(this.mSurfaceControl, 0.0f, 1.0f, -1.0f, 0.0f);     // Catch: Throwable -> L7
            goto L20
        L17:
            t.setPosition(this.mSurfaceControl, displayInfo.logicalWidth, displayInfo.logicalHeight);     // Catch: Throwable -> L7
            t.setMatrix(this.mSurfaceControl, -1.0f, 0.0f, 0.0f, -1.0f);     // Catch: Throwable -> L7
            goto L20
        L18:
            t.setPosition(this.mSurfaceControl, 0.0f, displayInfo.logicalHeight);     // Catch: Throwable -> L7
            t.setMatrix(this.mSurfaceControl, 0.0f, -1.0f, 1.0f, 0.0f);     // Catch: Throwable -> L7
            goto L20
        L19:
            t.setPosition(this.mSurfaceControl, 0.0f, 0.0f);     // Catch: Throwable -> L7
            t.setMatrix(this.mSurfaceControl, 1.0f, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L7
        L20:
            monitor-exit(this);     // Catch: Throwable -> L7
        }
    }

    public ColorFade(int displayId) {
        this(displayId, (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class));
    }

    ColorFade(int displayId, DisplayManagerInternal displayManagerInternal) {
        this.mTexNames = new int[1];
        this.mTexMatrix = new float[16];
        this.mProjMatrix = new float[16];
        this.mGLBuffers = new int[2];
        this.mVertexBuffer = createNativeFloatBuffer(8);
        this.mTexCoordBuffer = createNativeFloatBuffer(8);
        this.mTransaction = new SurfaceControl.Transaction();
        this.mDisplayId = displayId;
        this.mDisplayManagerInternal = displayManagerInternal;
    }

    public boolean prepare(Context context, int mode) {
        Slog.d(TAG, "prepare: mode=" + mode);
        this.mMode = mode;
        DisplayInfo displayInfo = this.mDisplayManagerInternal.getDisplayInfo(this.mDisplayId);
        if (displayInfo != null) goto L5;
        return false;
    L5:
        this.mDisplayLayerStack = displayInfo.layerStack;
        this.mDisplayWidth = displayInfo.getNaturalWidth();
        this.mDisplayHeight = displayInfo.getNaturalHeight();
        if (displayInfo.colorMode != 9) goto L8;
        boolean isWideColor = true;
    L9:
        this.mPrepared = true;
        ScreenCapture.ScreenshotHardwareBuffer hardwareBuffer = captureScreen();
        if (hardwareBuffer != null) goto L13;
        dismiss();
        return false;
    L13:
        boolean isProtected = TransitionAnimation.hasProtectedContent(hardwareBuffer.getHardwareBuffer());
        if (createSurfaceControl(hardwareBuffer.containsSecureLayers()) == true) goto L18;
        dismiss();
        return false;
    L18:
        if (this.mMode != 2) goto L21;
        return true;
    L21:
        if (createEglContext(isProtected) == true) goto L23;
    L51:
        dismiss();
        return false;
    L23:
        if (createEglSurface(isProtected, isWideColor) == false) goto L51;
        if (setScreenshotTextureAndSetViewport(hardwareBuffer, displayInfo.rotation) == false) goto L51;
        if (attachEglContext() == true) goto L53;
        return false;
    L53:
    L44:
        th = move-exception;
        detachEglContext();
        throw th;
    L31:
        if (initGLShaders(context) == true) goto L33;
    L46:
        detachEglContext();     // Catch: Throwable -> L44
        dismiss();     // Catch: Throwable -> L44
        detachEglContext();
        return false;
    L33:
        if (initGLBuffers() == false) goto L46;
        if (checkGlErrors("prepare") == true) goto L46;
        detachEglContext();
        this.mCreatedResources = true;
        this.mLastWasProtectedContent = isProtected;
        this.mLastWasWideColor = isWideColor;
        if (mode != 1) goto L43;
        int i = 0;
    L41:
        if (i >= 3) goto L43;
        draw(1.0f);
        i = i + 1;
    L43:
        return true;
    L8:
        isWideColor = false;
        goto L9
    }

    private String readFile(Context context, int resourceId) {
        InputStream stream = context.getResources().openRawResource(resourceId);     // Catch: IOException -> L4
        return new String(Streams.readFully(new InputStreamReader(stream)));
    L4:
        e = move-exception;
        Slog.e(TAG, "Unrecognized shader " + Integer.toString(resourceId));
        throw new RuntimeException(e);
    }

    private int loadShader(Context context, int resourceId, int type) {
        String source = readFile(context, resourceId);
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, source);
        GLES20.glCompileShader(shader);
        int[] compiled = new int[1];
        GLES20.glGetShaderiv(shader, 35713, compiled, 0);
        if (compiled[0] != 0) goto L6;
        Slog.e(TAG, "Could not compile shader " + shader + ", " + type + ":");
        Slog.e(TAG, GLES20.glGetShaderSource(shader));
        Slog.e(TAG, GLES20.glGetShaderInfoLog(shader));
        GLES20.glDeleteShader(shader);
        return 0;
    L6:
        return shader;
    }

    private boolean initGLShaders(Context context) {
        int vshader = loadShader(context, R.raw.default_ringtone_vibration_effect, 35633);
        int fshader = loadShader(context, R.raw.color_fade_vert, 35632);
        GLES20.glReleaseShaderCompiler();
        if (vshader == 0) goto L8;
        if (fshader == 0) goto L8;
        this.mProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.mProgram, vshader);
        GLES20.glAttachShader(this.mProgram, fshader);
        GLES20.glDeleteShader(vshader);
        GLES20.glDeleteShader(fshader);
        GLES20.glLinkProgram(this.mProgram);
        this.mVertexLoc = GLES20.glGetAttribLocation(this.mProgram, "position");
        this.mTexCoordLoc = GLES20.glGetAttribLocation(this.mProgram, "uv");
        this.mProjMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "proj_matrix");
        this.mTexMatrixLoc = GLES20.glGetUniformLocation(this.mProgram, "tex_matrix");
        this.mOpacityLoc = GLES20.glGetUniformLocation(this.mProgram, "opacity");
        this.mGammaLoc = GLES20.glGetUniformLocation(this.mProgram, "gamma");
        this.mTexUnitLoc = GLES20.glGetUniformLocation(this.mProgram, "texUnit");
        GLES20.glUseProgram(this.mProgram);
        GLES20.glUniform1i(this.mTexUnitLoc, 0);
        GLES20.glUseProgram(0);
        return true;
    L8:
        return false;
    }

    private void destroyGLShaders() {
        GLES20.glDeleteProgram(this.mProgram);
        checkGlErrors("glDeleteProgram");
    }

    private boolean initGLBuffers() {
        setQuad(this.mVertexBuffer, 0.0f, 0.0f, this.mDisplayWidth, this.mDisplayHeight);
        GLES20.glBindTexture(36197, this.mTexNames[0]);
        GLES20.glTexParameteri(36197, TarConstants.DEFAULT_BLKSIZE, 9728);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glBindTexture(36197, 0);
        GLES20.glGenBuffers(2, this.mGLBuffers, 0);
        GLES20.glBindBuffer(34962, this.mGLBuffers[0]);
        GLES20.glBufferData(34962, this.mVertexBuffer.capacity() * 4, this.mVertexBuffer, 35044);
        GLES20.glBindBuffer(34962, this.mGLBuffers[1]);
        GLES20.glBufferData(34962, this.mTexCoordBuffer.capacity() * 4, this.mTexCoordBuffer, 35044);
        GLES20.glBindBuffer(34962, 0);
        return true;
    }

    private void destroyGLBuffers() {
        GLES20.glDeleteBuffers(2, this.mGLBuffers, 0);
        checkGlErrors("glDeleteBuffers");
    }

    private static void setQuad(FloatBuffer vtx, float x, float y, float w, float h) {
        Slog.d(TAG, "setQuad: x=" + x + ", y=" + y + ", w=" + w + ", h=" + h);
        vtx.put(0, x);
        vtx.put(1, y);
        vtx.put(2, x);
        vtx.put(3, y + h);
        vtx.put(4, x + w);
        vtx.put(5, y + h);
        vtx.put(6, x + w);
        vtx.put(7, y);
    }

    public void dismissResources() {
        Slog.d(TAG, "dismissResources");
        if (this.mCreatedResources == false) goto L10;
        attachEglContext();
        destroyScreenshotTexture();     // Catch: Throwable -> L7
        destroyGLShaders();     // Catch: Throwable -> L7
        destroyGLBuffers();     // Catch: Throwable -> L7
        destroyEglSurface();     // Catch: Throwable -> L7
        detachEglContext();
        GLES20.glFlush();
        this.mCreatedResources = false;
        return;
    L7:
        th = move-exception;
        detachEglContext();
        throw th;
    }

    public void dismiss() {
        Slog.d(TAG, "dismiss");
        if (this.mPrepared == false) goto L6;
        dismissResources();
        destroySurface();
        this.mPrepared = false;
        return;
    }

    public void destroy() {
        Slog.d(TAG, "destroy");
        if (this.mPrepared == true) goto L5;
        return;
    L5:
        if (this.mCreatedResources == false) goto L12;
        attachEglContext();
        destroyScreenshotTexture();     // Catch: Throwable -> L9
        destroyGLShaders();     // Catch: Throwable -> L9
        destroyGLBuffers();     // Catch: Throwable -> L9
        destroyEglSurface();     // Catch: Throwable -> L9
        detachEglContext();
    L9:
        th = move-exception;
        detachEglContext();
        throw th;
    L12:
        destroyEglContext();
        destroySurface();
    }

    public boolean draw(float level) {
        Slog.d(TAG, "drawFrame: level=" + level);
        if (this.mPrepared == true) goto L6;
        return false;
    L6:
        if (this.mMode != 2) goto L10;
        return showSurface(1.0f - level);
    L10:
        if (attachEglContext() == true) goto L27;
        return false;
    L27:
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);     // Catch: Throwable -> L24
        GLES20.glClear(16384);     // Catch: Throwable -> L24
        double one_minus_level = 1.0f - level;     // Catch: Throwable -> L24
        double cos = Math.cos(3.141592653589793d * one_minus_level);     // Catch: Throwable -> L24
        if (cos >= 0.0d) goto L16;
        double sign = -1.0d;
    L17:
        float opacity = ((float) (-Math.pow(one_minus_level, 2.0d))) + 1.0f;     // Catch: Throwable -> L24
        float gamma = (float) (((((sign * 0.5d) * Math.pow(cos, 2.0d)) + 0.5d) * 0.9d) + 0.1d);     // Catch: Throwable -> L24
        drawFaded(opacity, 1.0f / gamma);     // Catch: Throwable -> L24
        if (checkGlErrors("drawFrame") == false) goto L21;
        detachEglContext();
        return false;
    L21:
        EGL14.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);     // Catch: Throwable -> L24
        detachEglContext();
        return showSurface(1.0f);
    L16:
        sign = 1.0d;
    L24:
        th = move-exception;
        detachEglContext();
        throw th;
    }

    private void drawFaded(float opacity, float gamma) {
        Slog.d(TAG, "drawFaded: opacity=" + opacity + ", gamma=" + gamma);
        GLES20.glUseProgram(this.mProgram);
        GLES20.glUniformMatrix4fv(this.mProjMatrixLoc, 1, false, this.mProjMatrix, 0);
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, this.mTexMatrix, 0);
        GLES20.glUniform1f(this.mOpacityLoc, opacity);
        GLES20.glUniform1f(this.mGammaLoc, gamma);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTexNames[0]);
        GLES20.glBindBuffer(34962, this.mGLBuffers[0]);
        GLES20.glEnableVertexAttribArray(this.mVertexLoc);
        GLES20.glVertexAttribPointer(this.mVertexLoc, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.mGLBuffers[1]);
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, 0);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindBuffer(34962, 0);
    }

    private void ortho(float left, float right, float bottom, float top, float znear, float zfar) {
        this.mProjMatrix[0] = 2.0f / (right - left);
        this.mProjMatrix[1] = 0.0f;
        this.mProjMatrix[2] = 0.0f;
        this.mProjMatrix[3] = 0.0f;
        this.mProjMatrix[4] = 0.0f;
        this.mProjMatrix[5] = 2.0f / (top - bottom);
        this.mProjMatrix[6] = 0.0f;
        this.mProjMatrix[7] = 0.0f;
        this.mProjMatrix[8] = 0.0f;
        this.mProjMatrix[9] = 0.0f;
        this.mProjMatrix[10] = (-2.0f) / (zfar - znear);
        this.mProjMatrix[11] = 0.0f;
        this.mProjMatrix[12] = (-(right + left)) / (right - left);
        this.mProjMatrix[13] = (-(top + bottom)) / (top - bottom);
        this.mProjMatrix[14] = (-(zfar + znear)) / (zfar - znear);
        this.mProjMatrix[15] = 1.0f;
    }

    private boolean setScreenshotTextureAndSetViewport(ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer, int rotation) {
        if (attachEglContext() == true) goto L34;
        return false;
    L34:
    L12:
        th = move-exception;
        detachEglContext();
        throw th;
    L6:
        if (this.mTexNamesGenerated == true) goto L14;
        GLES20.glGenTextures(1, this.mTexNames, 0);     // Catch: Throwable -> L12
        if (checkGlErrors("glGenTextures") == false) goto L11;
        detachEglContext();
        return false;
    L11:
        this.mTexNamesGenerated = true;     // Catch: Throwable -> L12
    L14:
        SurfaceTexture st = new SurfaceTexture(this.mTexNames[0]);     // Catch: Throwable -> L12
        Surface s = new Surface(st);     // Catch: Throwable -> L12
        s.attachAndQueueBufferWithColorSpace(screenshotBuffer.getHardwareBuffer(), screenshotBuffer.getColorSpace());     // Catch: Throwable -> L29
        st.updateTexImage();     // Catch: Throwable -> L29
        st.getTransformMatrix(this.mTexMatrix);     // Catch: Throwable -> L29
        s.release();     // Catch: Throwable -> L12
        st.release();     // Catch: Throwable -> L12
        int indexDelta = 2;
        if (rotation == 1) goto L26;
        if (rotation != 2) goto L23;
        indexDelta = 4;
        goto L26
    L23:
        if (rotation != 3) goto L25;
        indexDelta = 6;
        goto L26
    L25:
        indexDelta = 0;
    L26:
        this.mTexCoordBuffer.put(indexDelta, 0.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put(indexDelta + 1, 0.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put((indexDelta + 2) % 8, 0.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put((indexDelta + 3) % 8, 1.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put((indexDelta + 4) % 8, 1.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put((indexDelta + 5) % 8, 1.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put((indexDelta + 6) % 8, 1.0f);     // Catch: Throwable -> L12
        this.mTexCoordBuffer.put((indexDelta + 7) % 8, 0.0f);     // Catch: Throwable -> L12
        GLES20.glViewport(0, 0, this.mDisplayWidth, this.mDisplayHeight);     // Catch: Throwable -> L12
        ortho(0.0f, this.mDisplayWidth, 0.0f, this.mDisplayHeight, -1.0f, 1.0f);     // Catch: Throwable -> L12
        detachEglContext();
        return true;
    L29:
        th = move-exception;
        s.release();     // Catch: Throwable -> L12
        st.release();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    }

    private void destroyScreenshotTexture() {
        if (this.mTexNamesGenerated == false) goto L6;
        this.mTexNamesGenerated = false;
        GLES20.glDeleteTextures(1, this.mTexNames, 0);
        checkGlErrors("glDeleteTextures");
        return;
    }

    private ScreenCapture.ScreenshotHardwareBuffer captureScreen() {
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = this.mDisplayManagerInternal.systemScreenshot(this.mDisplayId);
        if (screenshotBuffer != null) goto L6;
        Slog.e(TAG, "Failed to take screenshot. Buffer is null");
        return null;
    L6:
        return screenshotBuffer;
    }

    private boolean createSurfaceControl(boolean isSecure) {
        if (this.mSurfaceControl == null) goto L37;
        this.mTransaction.setSecure(this.mSurfaceControl, isSecure).apply();
        return true;
    L37:
        SurfaceControl.Builder builder = new SurfaceControl.Builder().setName(TAG).setSecure(isSecure).setCallsite("ColorFade.createSurface");     // Catch: Surface.OutOfResourcesException -> L10
        if (this.mMode != 2) goto L12;
        builder.setColorLayer();     // Catch: Surface.OutOfResourcesException -> L10
    L13:
        this.mSurfaceControl = builder.build();     // Catch: Surface.OutOfResourcesException -> L10
        StringBuilder r5 = new StringBuilder();     // Catch: Surface.OutOfResourcesException -> L10
        r5.append("build mSurfaceControl=");     // Catch: Surface.OutOfResourcesException -> L10
        String r8 = "";
        if (this.mSurfaceControl == null) goto L17;
        String r7 = this.mSurfaceControl.toString();     // Catch: Surface.OutOfResourcesException -> L10
    L18:
        r5.append(r7);     // Catch: Surface.OutOfResourcesException -> L10
        r5.append(",native=0x");     // Catch: Surface.OutOfResourcesException -> L10
        long r9 = 0;
        if (this.mSurfaceControl == null) goto L21;
        long r11 = this.mSurfaceControl.mNativeObject;     // Catch: Surface.OutOfResourcesException -> L10
    L22:
        r5.append(Long.toHexString(r11));     // Catch: Surface.OutOfResourcesException -> L10
        Slog.i(TAG, r5.toString());     // Catch: Surface.OutOfResourcesException -> L10
        this.mTransaction.setLayerStack(this.mSurfaceControl, this.mDisplayLayerStack);
        this.mTransaction.setWindowCrop(this.mSurfaceControl, this.mDisplayWidth, this.mDisplayHeight);
        this.mSurfaceLayout = new NaturalSurfaceLayout(this.mDisplayManagerInternal, this.mDisplayId, this.mSurfaceControl);
        this.mSurfaceLayout.onDisplayTransaction(this.mTransaction);
        this.mTransaction.apply();
        if (this.mMode == 2) goto L34;
        SurfaceControl.Builder b = new SurfaceControl.Builder().setName("ColorFade BLAST").setParent(this.mSurfaceControl).setHidden(false).setSecure(isSecure).setBLASTLayer();
        this.mBLASTSurfaceControl = b.build();
        StringBuilder r4 = new StringBuilder();
        r4.append("build mBLASTSurfaceControl=");
        if (this.mBLASTSurfaceControl == null) goto L29;
        r8 = this.mBLASTSurfaceControl.toString();
    L29:
        r4.append(r8);
        r4.append(",native=0x");
        if (this.mBLASTBufferQueue == null) goto L33;
        r9 = this.mBLASTBufferQueue.mNativeObject;
    L33:
        r4.append(Long.toHexString(r9));
        Slog.i(TAG, r4.toString());
        this.mBLASTBufferQueue = new BLASTBufferQueue(TAG, true);
        this.mBLASTBufferQueue.update(this.mBLASTSurfaceControl, this.mDisplayWidth, this.mDisplayHeight, -3);
        this.mSurface = this.mBLASTBufferQueue.createSurface();
    L34:
        return true;
    L21:
        r11 = 0;
        goto L22
    L17:
        r7 = "";
        goto L18
    L12:
        builder.setContainerLayer();     // Catch: Surface.OutOfResourcesException -> L10
    L10:
        ex = move-exception;
        Slog.e(TAG, "Unable to create surface.", ex);
        return false;
    }

    private boolean createEglContext(boolean isProtected) {
        if (this.mEglDisplay != null) goto L13;
        this.mEglDisplay = EGL14.eglGetDisplay(0);
        if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY) goto L8;
        logEglError("eglGetDisplay");
        return false;
    L8:
        int[] version = new int[2];
        if (EGL14.eglInitialize(this.mEglDisplay, version, 0, version, 1) == true) goto L13;
        this.mEglDisplay = null;
        logEglError("eglInitialize");
        return false;
    L13:
        if (this.mEglConfig != null) goto L24;
        int[] eglConfigAttribList = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344};
        int[] numEglConfigs = new int[1];
        EGLConfig[] eglConfigs = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEglDisplay, eglConfigAttribList, 0, eglConfigs, 0, eglConfigs.length, numEglConfigs, 0) == true) goto L19;
        logEglError("eglChooseConfig");
        return false;
    L19:
        if (numEglConfigs[0] > 0) goto L22;
        Slog.e(TAG, "no valid config found");
        return false;
    L22:
        this.mEglConfig = eglConfigs[0];
    L24:
        if (this.mEglContext == null) goto L29;
        if (isProtected == this.mLastWasProtectedContent) goto L29;
        EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
        this.mEglContext = null;
    L29:
        if (this.mEglContext != null) goto L37;
        int[] eglContextAttribList = {12440, 2, 12344, 12344, 12344};
        if (isProtected == false) goto L33;
        eglContextAttribList[2] = EGL_PROTECTED_CONTENT_EXT;
        eglContextAttribList[3] = 1;
    L33:
        this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, this.mEglConfig, EGL14.EGL_NO_CONTEXT, eglContextAttribList, 0);
        if (this.mEglContext != null) goto L37;
        logEglError("eglCreateContext");
        return false;
    L37:
        return true;
    }

    private boolean createEglSurface(boolean isProtected, boolean isWideColor) {
        if (isProtected == this.mLastWasProtectedContent) goto L5;
    L8:
        boolean didContentAttributesChange = true;
    L10:
        if (this.mEglSurface == null) goto L14;
        if (didContentAttributesChange == false) goto L14;
        EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
        this.mEglSurface = null;
    L14:
        if (this.mEglSurface != null) goto L24;
        int[] eglSurfaceAttribList = {12344, 12344, 12344, 12344, 12344};
        int index = 0;
        if (isWideColor == false) goto L18;
        int index2 = 0 + 1;
        eglSurfaceAttribList[0] = EGL_GL_COLORSPACE_KHR;
        index = index2 + 1;
        eglSurfaceAttribList[index2] = EGL_GL_COLORSPACE_DISPLAY_P3_PASSTHROUGH_EXT;
    L18:
        if (isProtected == false) goto L20;
        eglSurfaceAttribList[index] = EGL_PROTECTED_CONTENT_EXT;
        eglSurfaceAttribList[index + 1] = 1;
    L20:
        this.mEglSurface = EGL14.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, this.mSurface, eglSurfaceAttribList, 0);
        if (this.mEglSurface != null) goto L24;
        logEglError("eglCreateWindowSurface");
        return false;
    L24:
        return true;
    L5:
        if (isWideColor != this.mLastWasWideColor) goto L8;
        didContentAttributesChange = false;
        goto L10
    }

    private void destroyEglSurface() {
        if (this.mEglSurface != null) goto L5;
        return;
    L5:
        if (EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface) == true) goto L7;
        logEglError("eglDestroySurface");
    L7:
        this.mEglSurface = null;
    }

    private void destroySurface() {
        if (this.mSurfaceControl == null) goto L15;
        this.mSurfaceLayout.dispose();
        this.mSurfaceLayout = null;
        Slog.d(TAG, "destory mSurfaceControl=" + this.mSurfaceControl.toString() + ",native=0x" + Long.toHexString(this.mSurfaceControl.mNativeObject));
        if (this.mSurface == null) goto L8;
        this.mSurface.release();
        this.mSurface = null;
    L8:
        if (this.mBLASTBufferQueue == null) goto L11;
        this.mBLASTBufferQueue.destroy();
        this.mBLASTBufferQueue = null;
    L11:
        if (this.mBLASTSurfaceControl == null) goto L13;
        Slog.d(TAG, "destory mBLASTSurfaceControl=" + this.mBLASTSurfaceControl.toString() + ",native=0x" + Long.toHexString(this.mBLASTSurfaceControl.mNativeObject));
        this.mBLASTSurfaceControl.release();
        this.mBLASTSurfaceControl = null;
    L13:
        this.mTransaction.remove(this.mSurfaceControl).apply();
        this.mSurfaceControl = null;
        this.mSurfaceVisible = false;
        this.mSurfaceAlpha = 0.0f;
        return;
    }

    private boolean showSurface(float alpha) {
        if (this.mSurfaceVisible == true) goto L5;
    L6:
        this.mTransaction.setLayer(this.mSurfaceControl, 1073741825).setAlpha(this.mSurfaceControl, alpha).show(this.mSurfaceControl).apply();
        this.mSurfaceVisible = true;
        this.mSurfaceAlpha = alpha;
    L7:
        return true;
    L5:
        if (this.mSurfaceAlpha == alpha) goto L7;
        goto L6
    }

    private boolean attachEglContext() {
        if (this.mEglSurface != null) goto L6;
        return false;
    L6:
        if (EGL14.eglMakeCurrent(this.mEglDisplay, this.mEglSurface, this.mEglSurface, this.mEglContext) == true) goto L9;
        logEglError("eglMakeCurrent");
        return false;
    L9:
        return true;
    }

    private void detachEglContext() {
        if (this.mEglDisplay == null) goto L6;
        EGL14.eglMakeCurrent(this.mEglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        return;
    }

    private void destroyEglContext() {
        if (this.mEglDisplay != null) goto L5;
        return;
    L5:
        if (this.mEglContext == null) goto L9;
        EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
        return;
    }

    private static FloatBuffer createNativeFloatBuffer(int size) {
        ByteBuffer bb = ByteBuffer.allocateDirect(size * 4);
        bb.order(ByteOrder.nativeOrder());
        return bb.asFloatBuffer();
    }

    private static void logEglError(String func) {
        Slog.e(TAG, func + " failed: error " + EGL14.eglGetError(), new Throwable());
    }

    private static boolean checkGlErrors(String func) {
        return checkGlErrors(func, true);
    }

    private static boolean checkGlErrors(String func, boolean log) {
        boolean hadError = false;
    L3:
        int error = GLES20.glGetError();
        if (error == 0) goto L8;
        if (log == false) goto L7;
        Slog.e(TAG, func + " failed: error " + error, new Throwable());
    L7:
        hadError = true;
        goto L3
    L8:
        return hadError;
    }

    public void dump(PrintWriter pw) {
        pw.println();
        pw.println("Color Fade State:");
        pw.println("  mPrepared=" + this.mPrepared);
        pw.println("  mMode=" + this.mMode);
        pw.println("  mDisplayLayerStack=" + this.mDisplayLayerStack);
        pw.println("  mDisplayWidth=" + this.mDisplayWidth);
        pw.println("  mDisplayHeight=" + this.mDisplayHeight);
        pw.println("  mSurfaceVisible=" + this.mSurfaceVisible);
        pw.println("  mSurfaceAlpha=" + this.mSurfaceAlpha);
        if (this.mSurfaceControl == null) goto L6;
        pw.println("  mSurfaceControl=" + this.mSurfaceControl.toString());
    L6:
        if (this.mBLASTBufferQueue == null) goto L9;
        String output = this.mBLASTBufferQueue.dumpState();
        pw.println(output);
        return;
    }
}
