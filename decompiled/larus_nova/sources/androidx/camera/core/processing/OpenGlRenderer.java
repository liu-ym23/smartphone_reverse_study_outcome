package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.core.processing.util.GraphicDeviceInfo;
import androidx.camera.core.processing.util.OutputSurface;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class OpenGlRenderer {
    private static final String TAG = "OpenGlRenderer";
    protected GLUtils.InputFormat mCurrentInputformat;
    protected GLUtils.Program2D mCurrentProgram;
    protected Surface mCurrentSurface;
    protected EGLConfig mEglConfig;
    protected EGLContext mEglContext;
    protected EGLDisplay mEglDisplay;
    private int mExternalTextureId;
    protected Thread mGlThread;
    protected final AtomicBoolean mInitialized;
    protected final Map<Surface, OutputSurface> mOutputSurfaceMap;
    protected Map<GLUtils.InputFormat, GLUtils.Program2D> mProgramHandles;
    protected int[] mSurfaceAttrib;
    protected EGLSurface mTempSurface;

    private void createTempSurface() {
        EGLDisplay r100 = this.mEglDisplay;
        EGLConfig r101 = this.mEglConfig;
        Objects.requireNonNull(r101);
        this.mTempSurface = GLUtils.createPBufferSurface(r100, r101, 1, 1);
    }

    private void releaseInternal() {
        Iterator<GLUtils.Program2D> r100 = this.mProgramHandles.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().delete();
        goto L4
    L6:
        this.mProgramHandles = Collections.emptyMap();
        this.mCurrentProgram = null;
        if (Objects.equals(this.mEglDisplay, EGL14.EGL_NO_DISPLAY) == true) goto L23;
        EGLDisplay r101 = this.mEglDisplay;
        EGLSurface r102 = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(r101, r102, r102, EGL14.EGL_NO_CONTEXT);
        Iterator<OutputSurface> r103 = this.mOutputSurfaceMap.values().iterator();
    L10:
        if (r103.hasNext() == false) goto L16;
        OutputSurface r104 = r103.next();
        if (Objects.equals(r104.getEglSurface(), EGL14.EGL_NO_SURFACE) == true) goto L10;
        if (EGL14.eglDestroySurface(this.mEglDisplay, r104.getEglSurface()) == true) goto L10;
        GLUtils.checkEglErrorOrLog("eglDestroySurface");
        goto L10
    L16:
        this.mOutputSurfaceMap.clear();
        if (Objects.equals(this.mTempSurface, EGL14.EGL_NO_SURFACE) == true) goto L20;
        EGL14.eglDestroySurface(this.mEglDisplay, this.mTempSurface);
        this.mTempSurface = EGL14.EGL_NO_SURFACE;
    L20:
        if (Objects.equals(this.mEglContext, EGL14.EGL_NO_CONTEXT) == true) goto L22;
        EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
    L22:
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEglDisplay);
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
    L23:
        this.mEglConfig = null;
        this.mExternalTextureId = -1;
        this.mCurrentInputformat = GLUtils.InputFormat.UNKNOWN;
        this.mCurrentSurface = null;
        this.mGlThread = null;
    }

    public int getTextureName() {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        return this.mExternalTextureId;
    }

    public void release() {
        if (this.mInitialized.getAndSet(false) == true) goto L5;
        return;
    L5:
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        releaseInternal();
    }

    public OpenGlRenderer() {
        this.mInitialized = new AtomicBoolean(false);
        this.mOutputSurfaceMap = new HashMap();
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
        this.mSurfaceAttrib = GLUtils.EMPTY_ATTRIBS;
        this.mTempSurface = EGL14.EGL_NO_SURFACE;
        this.mProgramHandles = Collections.emptyMap();
        this.mCurrentProgram = null;
        this.mCurrentInputformat = GLUtils.InputFormat.UNKNOWN;
        this.mExternalTextureId = -1;
    }

    private void activateExternalTexture(int r100) {
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, r100);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
    }

    private Pair<String, String> getExtensionsBeforeInitialized(DynamicRange r100) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, false);
        createEglContext(r100, null);     // Catch: Throwable -> L13 IllegalStateException -> L15
        createTempSurface();     // Catch: Throwable -> L13 IllegalStateException -> L15
        makeCurrent(this.mTempSurface);     // Catch: Throwable -> L13 IllegalStateException -> L15
        String r101 = GLES20.glGetString(7939);     // Catch: Throwable -> L13 IllegalStateException -> L15
        String r102 = EGL14.eglQueryString(this.mEglDisplay, 12373);     // Catch: Throwable -> L13 IllegalStateException -> L15
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        Pair<String, String> r103 = new Pair(r101, r102);     // Catch: Throwable -> L13 IllegalStateException -> L15
        releaseInternal();
        return r103;
    L13:
        th = move-exception;
        releaseInternal();
        throw th;
    L15:
        e = move-exception;
        Logger.w(TAG, "Failed to get GL or EGL extensions: " + e.getMessage(), e);     // Catch: Throwable -> L13
        Pair<String, String> r104 = new Pair("", "");     // Catch: Throwable -> L13
        releaseInternal();
        return r104;
    }

    public OutputSurface createOutputSurfaceInternal(Surface r100) {
        EGLDisplay r101 = this.mEglDisplay;     // Catch: Throwable -> L5 IllegalStateException -> L7
        EGLConfig r102 = this.mEglConfig;     // Catch: Throwable -> L5 IllegalStateException -> L7
        Objects.requireNonNull(r102);     // Catch: Throwable -> L5 IllegalStateException -> L7
        EGLConfig r103 = r102;     // Catch: Throwable -> L5 IllegalStateException -> L7
        EGLSurface r104 = GLUtils.createWindowSurface(r101, r102, r100, this.mSurfaceAttrib);     // Catch: Throwable -> L5 IllegalStateException -> L7
        Size r105 = GLUtils.getSurfaceSize(this.mEglDisplay, r104);
        return OutputSurface.of(r104, r105.getWidth(), r105.getHeight());
    L5:
        e = move-exception;
        Logger.w(TAG, "Failed to create EGL surface: " + e.getMessage(), e);
        return null;
    }

    public OutputSurface getOutSurfaceOrThrow(Surface r100) {
        Preconditions.checkState(this.mOutputSurfaceMap.containsKey(r100), "The surface is not registered.");
        OutputSurface r101 = this.mOutputSurfaceMap.get(r100);
        Objects.requireNonNull(r101);
        return r101;
    }

    public GraphicDeviceInfo init(DynamicRange r100) {
        return init(r100, Collections.emptyMap());
    }

    public void makeCurrent(EGLSurface r100) {
        Preconditions.checkNotNull(this.mEglDisplay);
        Preconditions.checkNotNull(this.mEglContext);
        if (EGL14.eglMakeCurrent(this.mEglDisplay, r100, r100, this.mEglContext) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("eglMakeCurrent failed");
    }

    public void registerOutputSurface(Surface r100) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        if (this.mOutputSurfaceMap.containsKey(r100) == true) goto L6;
        this.mOutputSurfaceMap.put(r100, GLUtils.NO_OUTPUT_SURFACE);
        return;
    }

    public void setInputFormat(GLUtils.InputFormat r100) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        if (this.mCurrentInputformat == r100) goto L6;
        this.mCurrentInputformat = r100;
        useAndConfigureProgramWithTexture(this.mExternalTextureId);
        return;
    }

    public void unregisterOutputSurface(Surface r100) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        removeOutputSurfaceInternal(r100, true);
    }

    public void useAndConfigureProgramWithTexture(int r100) {
        GLUtils.Program2D r101 = this.mProgramHandles.get(this.mCurrentInputformat);
        if (r101 == null) goto L10;
        if (this.mCurrentProgram == r101) goto L7;
        this.mCurrentProgram = r101;
        r101.use();
        Objects.toString(this.mCurrentInputformat);
        Objects.toString(this.mCurrentProgram);
    L7:
        activateExternalTexture(r100);
        return;
    L10:
        throw new IllegalStateException("Unable to configure program for input format: " + this.mCurrentInputformat);
    }

    private void createEglContext(DynamicRange r210, GraphicDeviceInfo.Builder r211) {
        EGLDisplay r100 = EGL14.eglGetDisplay(0);
        this.mEglDisplay = r100;
        if (Objects.equals(r100, EGL14.EGL_NO_DISPLAY) == true) goto L37;
        int[] r101 = new int[2];
        if (EGL14.eglInitialize(this.mEglDisplay, r101, 0, r101, 1) == false) goto L34;
        if (r211 == null) goto L9;
        r211.setEglVersion(r101[0] + "." + r101[1]);
    L9:
        if (r210.is10BitHdr() == false) goto L11;
        int r102 = 10;
    L13:
        if (r210.is10BitHdr() == false) goto L15;
        int r103 = 2;
    L17:
        if (r210.is10BitHdr() == false) goto L19;
        int r104 = 64;
    L21:
        if (r210.is10BitHdr() == false) goto L23;
        int r110 = -1;
    L24:
        int r111 = 3;
        int[] r112 = {12324, r102, 12323, r102, 12322, r102, 12321, r103, 12325, 0, 12326, 0, 12352, r104, 12610, r110, 12339, 5, 12344};
        EGLConfig[] r105 = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.mEglDisplay, r112, 0, r105, 0, 1, new int[1], 0) == false) goto L33;
        EGLConfig r106 = r105[0];
        int[] r107 = new int[3];
        r107[0] = 12440;
        if (r210.is10BitHdr() == true) goto L30;
        r111 = 2;
    L30:
        r107[1] = r111;
        r107[2] = 12344;
        EGLContext r108 = EGL14.eglCreateContext(this.mEglDisplay, r106, EGL14.EGL_NO_CONTEXT, r107, 0);
        GLUtils.checkEglErrorOrThrow("eglCreateContext");
        this.mEglConfig = r106;
        this.mEglContext = r108;
        EGL14.eglQueryContext(this.mEglDisplay, r108, 12440, new int[1], 0);
        return;
    L33:
        throw new IllegalStateException("Unable to find a suitable EGLConfig");
    L23:
        r110 = 1;
        goto L24
    L19:
        r104 = 4;
        goto L21
    L15:
        r103 = 8;
        goto L17
    L11:
        r102 = 8;
        goto L13
    L34:
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        throw new IllegalStateException("Unable to initialize EGL14");
    L37:
        throw new IllegalStateException("Unable to get EGL14 display");
    }

    public GraphicDeviceInfo init(DynamicRange r100, Map<GLUtils.InputFormat, ShaderProvider> r101) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, false);
        GraphicDeviceInfo.Builder r102 = GraphicDeviceInfo.builder();
    L14:
        e = move-exception;
        releaseInternal();
        throw e;
    L4:
        if (r100.is10BitHdr() == false) goto L9;
        Pair<String, String> r103 = getExtensionsBeforeInitialized(r100);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        String r104 = (String) Preconditions.checkNotNull(r103.first);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        String r105 = (String) Preconditions.checkNotNull(r103.second);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        if (r104.contains("GL_EXT_YUV_target") == true) goto L8;
        Logger.w(TAG, "Device does not support GL_EXT_YUV_target. Fallback to SDR.");     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r100 = DynamicRange.SDR;     // Catch: IllegalArgumentException -> L12 Throwable -> L14
    L8:
        this.mSurfaceAttrib = GLUtils.chooseSurfaceAttrib(r105, r100);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r102.setGlExtensions(r104);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r102.setEglExtensions(r105);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
    L9:
        createEglContext(r100, r102);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        createTempSurface();     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        makeCurrent(this.mTempSurface);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        r102.setGlVersion(GLUtils.getGlVersionNumber());     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        this.mProgramHandles = GLUtils.createPrograms(r100, r101);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        int r106 = GLUtils.createTexture();     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        this.mExternalTextureId = r106;     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        useAndConfigureProgramWithTexture(r106);     // Catch: IllegalArgumentException -> L12 Throwable -> L14
        this.mGlThread = ThreadMethodProxy.currentThread();
        this.mInitialized.set(true);
        return r102.build();
    }

    public void removeOutputSurfaceInternal(Surface r100, boolean r101) {
        if (this.mCurrentSurface != r100) goto L5;
        this.mCurrentSurface = null;
        makeCurrent(this.mTempSurface);
    L5:
        if (r101 == false) goto L7;
        OutputSurface r102 = this.mOutputSurfaceMap.remove(r100);
    L8:
        if (r102 != null) goto L10;
        return;
    L10:
        if (r102 == GLUtils.NO_OUTPUT_SURFACE) goto L19;
        EGL14.eglDestroySurface(this.mEglDisplay, r102.getEglSurface());     // Catch: RuntimeException -> L13
        return;
    L13:
        e = move-exception;
        Logger.w(TAG, "Failed to destroy EGL surface: " + e.getMessage(), e);
        return;
    L19:
        return;
    L7:
        r102 = this.mOutputSurfaceMap.put(r100, GLUtils.NO_OUTPUT_SURFACE);
        goto L8
    }

    public Bitmap snapshot(Size r100, float[] r101) {
        ByteBuffer r102 = ByteBuffer.allocateDirect((r100.getWidth() * r100.getHeight()) * 4);
        snapshot(r102, r100, r101);
        Bitmap r103 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        r102.rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(r103, r102, r100.getWidth() * 4);
        return r103;
    }

    private void snapshot(ByteBuffer r110, Size r111, float[] r112) {
        if (r110.capacity() != ((r111.getWidth() * r111.getHeight()) * 4)) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkArgument(r100, "ByteBuffer capacity is not equal to width * height * 4.");
        Preconditions.checkArgument(r110.isDirect(), "ByteBuffer is not direct.");
        int r101 = GLUtils.generateTexture();
        GLES20.glActiveTexture(33985);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(3553, r101);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, r111.getWidth(), r111.getHeight(), 0, 6407, 5121, null);
        GLUtils.checkGlErrorOrThrow("glTexImage2D");
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int r102 = GLUtils.generateFbo();
        GLES20.glBindFramebuffer(36160, r102);
        GLUtils.checkGlErrorOrThrow("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r101, 0);
        GLUtils.checkGlErrorOrThrow("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
        this.mCurrentSurface = null;
        GLES20.glViewport(0, 0, r111.getWidth(), r111.getHeight());
        GLES20.glScissor(0, 0, r111.getWidth(), r111.getHeight());
        GLUtils.Program2D r103 = (GLUtils.Program2D) Preconditions.checkNotNull(this.mCurrentProgram);
        if ((r103 instanceof GLUtils.SamplerShaderProgram) == false) goto L9;
        ((GLUtils.SamplerShaderProgram) r103).updateTextureMatrix(r112);
    L9:
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        GLES20.glReadPixels(0, 0, r111.getWidth(), r111.getHeight(), 6408, 5121, r110);
        GLUtils.checkGlErrorOrThrow("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        GLUtils.deleteTexture(r101);
        GLUtils.deleteFbo(r102);
        activateExternalTexture(this.mExternalTextureId);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public void render(long r100, float[] r101, Surface r102) {
        GLUtils.checkInitializedOrThrow(this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow(this.mGlThread);
        OutputSurface r103 = getOutSurfaceOrThrow(r102);
        if (r103 != GLUtils.NO_OUTPUT_SURFACE) goto L9;
        r103 = createOutputSurfaceInternal(r102);
        if (r103 != null) goto L7;
        return;
    L7:
        this.mOutputSurfaceMap.put(r102, r103);
    L9:
        if (r102 == this.mCurrentSurface) goto L11;
        makeCurrent(r103.getEglSurface());
        this.mCurrentSurface = r102;
        GLES20.glViewport(0, 0, r103.getWidth(), r103.getHeight());
        GLES20.glScissor(0, 0, r103.getWidth(), r103.getHeight());
    L11:
        GLUtils.Program2D r104 = (GLUtils.Program2D) Preconditions.checkNotNull(this.mCurrentProgram);
        if ((r104 instanceof GLUtils.SamplerShaderProgram) == false) goto L14;
        ((GLUtils.SamplerShaderProgram) r104).updateTextureMatrix(r101);
    L14:
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, r103.getEglSurface(), r100);
        if (EGL14.eglSwapBuffers(this.mEglDisplay, r103.getEglSurface()) == true) goto L18;
        Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(r102, false);
        return;
    }
}
