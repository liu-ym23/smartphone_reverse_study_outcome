package com.mdisdk.gles;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import io.modelcontextprotocol.spec.McpSchema;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0003J\u001d\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u0003J\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u000f¢\u0006\u0004\b \u0010\u0003J\r\u0010!\u001a\u00020\u000f¢\u0006\u0004\b!\u0010\u0003R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/mdisdk/gles/EglCore;", "", AppAgent.CONSTRUCT, "()V", "Landroid/opengl/EGLConfig;", "chooseConfig", "()Landroid/opengl/EGLConfig;", "config", "Landroid/opengl/EGLContext;", "createContext", "(Landroid/opengl/EGLConfig;)Landroid/opengl/EGLContext;", "", "condition", "", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "checkEglError", "(ZLjava/lang/String;)V", McpSchema.METHOD_INITIALIZE, "", "width", "height", "createPbufferSurface", "(II)V", "Landroid/view/Surface;", "surface", "createWindowSurface", "(Landroid/view/Surface;)V", "destroyWindowSurface", "makeCurrent", "isUsingPbuffer", "()Z", "swapBuffers", "release", "Landroid/opengl/EGLDisplay;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "eglContext", "Landroid/opengl/EGLContext;", "Landroid/opengl/EGLSurface;", "eglSurface", "Landroid/opengl/EGLSurface;", "eglConfig", "Landroid/opengl/EGLConfig;", "isPbufferSurface", "Z", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EglCore {
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private boolean isPbufferSurface;

    public EglCore() {
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        k.e(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = EGL_NO_DISPLAY;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        k.e(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.eglContext = EGL_NO_CONTEXT;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        k.e(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = EGL_NO_SURFACE;
        this.isPbufferSurface = true;
    }

    private final void checkEglError(boolean condition, String msg) {
        if (condition) {
            return;
        }
        int iEglGetError = EGL14.eglGetError();
        StringBuilder sbX = androidx.appfunctions.metadata.a.x(msg, " (EGL error: 0x");
        sbX.append(Integer.toHexString(iEglGetError));
        sbX.append(')');
        throw new RuntimeException(sbX.toString());
    }

    private final EGLConfig chooseConfig() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        checkEglError(EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 5, 12352, 4, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0), "Unable to find EGL config");
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLConfig != null) {
            return eGLConfig;
        }
        throw new RuntimeException("No EGL config found");
    }

    private final EGLContext createContext(EGLConfig config) {
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.eglDisplay, config, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
        checkEglError(eGLContextEglCreateContext != EGL14.EGL_NO_CONTEXT, "Failed to create EGL context");
        k.c(eGLContextEglCreateContext);
        return eGLContextEglCreateContext;
    }

    public final void createPbufferSurface(int width, int height) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, width, 12374, height, 12344}, 0);
        k.e(eGLSurfaceEglCreatePbufferSurface, "eglCreatePbufferSurface(...)");
        this.eglSurface = eGLSurfaceEglCreatePbufferSurface;
        checkEglError(eGLSurfaceEglCreatePbufferSurface != EGL14.EGL_NO_SURFACE, "Failed to create pbuffer surface");
        this.isPbufferSurface = true;
    }

    public final void createWindowSurface(Surface surface) {
        k.f(surface, "surface");
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surface, new int[]{12344}, 0);
        k.e(eGLSurfaceEglCreateWindowSurface, "eglCreateWindowSurface(...)");
        this.eglSurface = eGLSurfaceEglCreateWindowSurface;
        checkEglError(eGLSurfaceEglCreateWindowSurface != EGL14.EGL_NO_SURFACE, "Failed to create window surface");
        this.isPbufferSurface = false;
    }

    public final void destroyWindowSurface() {
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(this.eglDisplay, eGLSurface);
            EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
            k.e(EGL_NO_SURFACE, "EGL_NO_SURFACE");
            this.eglSurface = EGL_NO_SURFACE;
        }
    }

    public final void initialize() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        k.e(eGLDisplayEglGetDisplay, "eglGetDisplay(...)");
        this.eglDisplay = eGLDisplayEglGetDisplay;
        checkEglError(eGLDisplayEglGetDisplay != EGL14.EGL_NO_DISPLAY, "Unable to get EGL display");
        int[] iArr = new int[2];
        checkEglError(EGL14.eglInitialize(this.eglDisplay, iArr, 0, iArr, 1), "Unable to initialize EGL");
        EGLConfig eGLConfigChooseConfig = chooseConfig();
        this.eglConfig = eGLConfigChooseConfig;
        k.c(eGLConfigChooseConfig);
        this.eglContext = createContext(eGLConfigChooseConfig);
    }

    /* renamed from: isUsingPbuffer, reason: from getter */
    public final boolean getIsPbufferSurface() {
        return this.isPbufferSurface;
    }

    public final void makeCurrent() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglSurface;
        checkEglError(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext), "eglMakeCurrent failed");
    }

    public final void release() {
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface2 = this.eglSurface;
            if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.eglDisplay, eGLSurface2);
            }
            EGLContext eGLContext = this.eglContext;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.eglDisplay, eGLContext);
            }
            EGL14.eglTerminate(this.eglDisplay);
        }
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        k.e(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = EGL_NO_DISPLAY;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        k.e(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.eglContext = EGL_NO_CONTEXT;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        k.e(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = EGL_NO_SURFACE;
    }

    public final void swapBuffers() {
        if (getIsPbufferSurface()) {
            return;
        }
        EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface);
    }
}
