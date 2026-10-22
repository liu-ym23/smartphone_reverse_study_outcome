package com.stepos.motionkit.fx.backend;

import C7.r;
import S7.o;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import ca.AbstractC0897f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.motionkit.MKLog;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0018¢\u0006\u0004\b!\u0010 J\u0015\u0010\"\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010\u001aJ\r\u0010#\u001a\u00020\u0018¢\u0006\u0004\b#\u0010 J\u000f\u0010%\u001a\u00020\u0018H\u0000¢\u0006\u0004\b$\u0010 J\u001d\u0010)\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\nH\u0000¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u0018\u0018\u00010;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u00107R\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00107R\u0016\u0010E\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00107R\u0016\u0010G\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0014\u0010J\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010*R\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/stepos/motionkit/fx/backend/GlesRenderer;", "", "", "shaderSource", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", "Lcom/stepos/motionkit/fx/backend/RenderTarget;", TypedValues.AttributesType.S_TARGET, AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/fx/uniform/UniformBinder;Lcom/stepos/motionkit/fx/backend/RenderTarget;)V", "Lkotlin/Function0;", "", "isCancelled", "initGL", "(LS7/a;)Z", "", "createProgram", "()I", "type", AgentBusWakeContract.EXTRA_SOURCE, "compileShader", "(ILjava/lang/String;)I", "", "elapsedMs", "LC7/r;", "drawFrame", "(J)V", "ok", "operation", "checkEgl", "(ZLjava/lang/String;)V", "releaseGL", "()V", "start", "renderFrame", "stop", "stopAndWait$motionkit_fx_release", "stopAndWait", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "whenStopped$motionkit_fx_release", "(LS7/a;)V", "whenStopped", "Ljava/lang/String;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "Lcom/stepos/motionkit/fx/backend/RenderTarget;", "Landroid/opengl/EGLDisplay;", "eglDisplay", "Landroid/opengl/EGLDisplay;", "Landroid/opengl/EGLContext;", "eglContext", "Landroid/opengl/EGLContext;", "Landroid/opengl/EGLSurface;", "eglSurface", "Landroid/opengl/EGLSurface;", "program", "I", "displayInitialized", "Z", "currentBound", "Lkotlin/Function1;", "", "onFailure", "LS7/k;", "getOnFailure$motionkit_fx_release", "()LS7/k;", "setOnFailure$motionkit_fx_release", "(LS7/k;)V", "posLoc", "timeLoc", "resLoc", "", "surfaceWidth", "F", "surfaceHeight", "vertexShaderSource", "Ljava/nio/FloatBuffer;", "quadVertices", "Ljava/nio/FloatBuffer;", "Lcom/stepos/motionkit/fx/backend/RenderSession;", "session", "Lcom/stepos/motionkit/fx/backend/RenderSession;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlesRenderer {
    private final UniformBinder binder;
    private boolean currentBound;
    private boolean displayInitialized;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private S7.k onFailure;
    private int posLoc;
    private int program;
    private final FloatBuffer quadVertices;
    private int resLoc;
    private final RenderSession session;
    private final String shaderSource;
    private float surfaceHeight;
    private float surfaceWidth;
    private final RenderTarget target;
    private int timeLoc;
    private final String vertexShaderSource;

    public GlesRenderer(String shaderSource, UniformBinder binder, RenderTarget target) {
        kotlin.jvm.internal.k.f(shaderSource, "shaderSource");
        kotlin.jvm.internal.k.f(binder, "binder");
        kotlin.jvm.internal.k.f(target, "target");
        this.shaderSource = shaderSource;
        this.binder = binder;
        this.target = target;
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        kotlin.jvm.internal.k.e(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = EGL_NO_DISPLAY;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        kotlin.jvm.internal.k.e(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.eglContext = EGL_NO_CONTEXT;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        kotlin.jvm.internal.k.e(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = EGL_NO_SURFACE;
        this.posLoc = -1;
        this.timeLoc = -1;
        this.resLoc = -1;
        this.vertexShaderSource = "#version 300 es\nin vec4 aPosition;\nvoid main() {\n    gl_Position = aPosition;\n}";
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer.position(0);
        this.quadVertices = floatBufferAsFloatBuffer;
        this.session = new RenderSession(new HandlerRenderQueue("GlesRenderer"), new RenderDriver() { // from class: com.stepos.motionkit.fx.backend.GlesRenderer$session$1
            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public void draw(long elapsedMs) {
                this.this$0.drawFrame(elapsedMs);
            }

            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public boolean initialize(S7.a isCancelled) {
                kotlin.jvm.internal.k.f(isCancelled, "isCancelled");
                return this.this$0.initGL(isCancelled);
            }

            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public void release() throws Exception {
                this.this$0.releaseGL();
            }
        }, new a(this, 1));
    }

    private final void checkEgl(boolean ok, String operation) {
        if (ok) {
            return;
        }
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12302) {
            this.currentBound = false;
        }
        AbstractC0897f.r(16);
        String string = Integer.toString(iEglGetError, 16);
        kotlin.jvm.internal.k.e(string, "toString(...)");
        throw new IllegalStateException((operation + " failed: EGL 0x" + string).toString());
    }

    private final int compileShader(int type, String source) {
        int iGlCreateShader = GLES20.glCreateShader(type);
        if (iGlCreateShader == 0) {
            throw new IllegalStateException("glCreateShader failed");
        }
        GLES20.glShaderSource(iGlCreateShader, source);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        throw new IllegalStateException(("GL shader compile failed: " + strGlGetShaderInfoLog).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int createProgram() throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "GL program link failed: "
            r1 = 35633(0x8b31, float:4.9932E-41)
            java.lang.String r2 = r6.vertexShaderSource
            int r1 = r6.compileShader(r1, r2)
            r2 = 0
            java.lang.String r3 = r6.shaderSource     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r4 = 35632(0x8b30, float:4.9931E-41)
            int r6 = r6.compileShader(r4, r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            int r3 = android.opengl.GLES20.glCreateProgram()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L62
            if (r3 == 0) goto L5a
            android.opengl.GLES20.glAttachShader(r3, r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.opengl.GLES20.glAttachShader(r3, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.opengl.GLES20.glLinkProgram(r3)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r4 = 1
            int[] r4 = new int[r4]     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r5 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r3, r5, r4, r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r2 = r4[r2]     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r2 == 0) goto L3a
            android.opengl.GLES20.glDeleteShader(r1)
            if (r6 == 0) goto L39
            android.opengl.GLES20.glDeleteShader(r6)
        L39:
            return r3
        L3a:
            java.lang.String r2 = android.opengl.GLES20.glGetProgramInfoLog(r3)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r4.append(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            throw r2     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
        L54:
            r0 = move-exception
            r2 = r6
            goto L6e
        L57:
            r0 = move-exception
            r2 = r3
            goto L68
        L5a:
            java.lang.String r0 = "glCreateProgram failed"
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            throw r2     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
        L62:
            r0 = move-exception
            goto L68
        L64:
            r0 = move-exception
            goto L6e
        L66:
            r0 = move-exception
            r6 = r2
        L68:
            if (r2 == 0) goto L6d
            android.opengl.GLES20.glDeleteProgram(r2)     // Catch: java.lang.Throwable -> L54
        L6d:
            throw r0     // Catch: java.lang.Throwable -> L54
        L6e:
            android.opengl.GLES20.glDeleteShader(r1)
            if (r2 == 0) goto L76
            android.opengl.GLES20.glDeleteShader(r2)
        L76:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.motionkit.fx.backend.GlesRenderer.createProgram():int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawFrame(long elapsedMs) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.program);
        int i = this.timeLoc;
        if (i >= 0) {
            GLES20.glUniform1f(i, elapsedMs / 1000.0f);
        }
        int i6 = this.resLoc;
        if (i6 >= 0) {
            GLES20.glUniform2f(i6, this.surfaceWidth, this.surfaceHeight);
        }
        this.binder.resolve(elapsedMs);
        this.binder.applyToGles(new o() { // from class: com.stepos.motionkit.fx.backend.b
            @Override // S7.o
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                int iIntValue = ((Integer) obj3).intValue();
                return GlesRenderer.drawFrame$lambda$6(this.f3847a, (String) obj, (float[]) obj2, iIntValue);
            }
        });
        GLES20.glDrawArrays(5, 0, 4);
        checkEgl(EGL14.eglSwapBuffers(this.eglDisplay, this.eglSurface), "eglSwapBuffers");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r drawFrame$lambda$6(GlesRenderer glesRenderer, String name, float[] values, int i) {
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(values, "values");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(glesRenderer.program, name);
        if (iGlGetUniformLocation >= 0) {
            if (i == 1) {
                GLES20.glUniform1f(iGlGetUniformLocation, values[0]);
            } else if (i == 2) {
                GLES20.glUniform2f(iGlGetUniformLocation, values[0], values[1]);
            } else if (i == 3) {
                GLES20.glUniform3f(iGlGetUniformLocation, values[0], values[1], values[2]);
            } else if (i == 4) {
                GLES20.glUniform4f(iGlGetUniformLocation, values[0], values[1], values[2], values[3]);
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean initGL(S7.a isCancelled) throws Throwable {
        Surface surface;
        if (((Boolean) isCancelled.invoke()).booleanValue() || (surface = this.target.getSurface()) == null || !surface.isValid()) {
            return false;
        }
        this.eglDisplay = EGL14.eglGetDisplay(0);
        checkEgl(!kotlin.jvm.internal.k.b(r2, EGL14.EGL_NO_DISPLAY), "eglGetDisplay");
        int[] iArr = new int[2];
        checkEgl(EGL14.eglInitialize(this.eglDisplay, iArr, 0, iArr, 1), "eglInitialize");
        this.displayInitialized = true;
        if (((Boolean) isCancelled.invoke()).booleanValue()) {
            return false;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        checkEgl(EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 4, 12352, 64, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0), "eglChooseConfig");
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (iArr2[0] <= 0 || eGLConfig == null) {
            throw new IllegalStateException("No GLES window EGLConfig");
        }
        this.eglContext = EGL14.eglCreateContext(this.eglDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
        checkEgl(!kotlin.jvm.internal.k.b(r4, EGL14.EGL_NO_CONTEXT), "eglCreateContext");
        if (((Boolean) isCancelled.invoke()).booleanValue() || !surface.isValid()) {
            return false;
        }
        this.eglSurface = EGL14.eglCreateWindowSurface(this.eglDisplay, eGLConfig, surface, new int[]{12344}, 0);
        checkEgl(!kotlin.jvm.internal.k.b(r0, EGL14.EGL_NO_SURFACE), "eglCreateWindowSurface");
        if (((Boolean) isCancelled.invoke()).booleanValue()) {
            return false;
        }
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = this.eglSurface;
        checkEgl(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext), "eglMakeCurrent");
        this.currentBound = true;
        int iCreateProgram = createProgram();
        this.program = iCreateProgram;
        this.posLoc = GLES20.glGetAttribLocation(iCreateProgram, "aPosition");
        this.timeLoc = GLES20.glGetUniformLocation(this.program, "iTime");
        this.resLoc = GLES20.glGetUniformLocation(this.program, "iResolution");
        this.surfaceWidth = this.target.getRenderWidth();
        this.surfaceHeight = this.target.getRenderHeight();
        GLES20.glEnableVertexAttribArray(this.posLoc);
        GLES20.glVertexAttribPointer(this.posLoc, 2, 5126, false, 0, (Buffer) this.quadVertices);
        return !((Boolean) isCancelled.invoke()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseGL() throws Exception {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        try {
            final int i = 0;
            releaseGL$attempt(ref$ObjectRef, this, new S7.a(this) { // from class: com.stepos.motionkit.fx.backend.c
                public final /* synthetic */ GlesRenderer b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i6 = i;
                    GlesRenderer glesRenderer = this.b;
                    switch (i6) {
                        case 0:
                            return GlesRenderer.releaseGL$lambda$8(glesRenderer);
                        case 1:
                            return GlesRenderer.releaseGL$lambda$9(glesRenderer);
                        case 2:
                            return GlesRenderer.releaseGL$lambda$10(glesRenderer);
                        case 3:
                            return GlesRenderer.releaseGL$lambda$11(glesRenderer);
                        default:
                            return GlesRenderer.releaseGL$lambda$12(glesRenderer);
                    }
                }
            });
            final int i6 = 1;
            releaseGL$attempt(ref$ObjectRef, this, new S7.a(this) { // from class: com.stepos.motionkit.fx.backend.c
                public final /* synthetic */ GlesRenderer b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i62 = i6;
                    GlesRenderer glesRenderer = this.b;
                    switch (i62) {
                        case 0:
                            return GlesRenderer.releaseGL$lambda$8(glesRenderer);
                        case 1:
                            return GlesRenderer.releaseGL$lambda$9(glesRenderer);
                        case 2:
                            return GlesRenderer.releaseGL$lambda$10(glesRenderer);
                        case 3:
                            return GlesRenderer.releaseGL$lambda$11(glesRenderer);
                        default:
                            return GlesRenderer.releaseGL$lambda$12(glesRenderer);
                    }
                }
            });
            final int i10 = 2;
            releaseGL$attempt(ref$ObjectRef, this, new S7.a(this) { // from class: com.stepos.motionkit.fx.backend.c
                public final /* synthetic */ GlesRenderer b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i62 = i10;
                    GlesRenderer glesRenderer = this.b;
                    switch (i62) {
                        case 0:
                            return GlesRenderer.releaseGL$lambda$8(glesRenderer);
                        case 1:
                            return GlesRenderer.releaseGL$lambda$9(glesRenderer);
                        case 2:
                            return GlesRenderer.releaseGL$lambda$10(glesRenderer);
                        case 3:
                            return GlesRenderer.releaseGL$lambda$11(glesRenderer);
                        default:
                            return GlesRenderer.releaseGL$lambda$12(glesRenderer);
                    }
                }
            });
            final int i11 = 3;
            releaseGL$attempt(ref$ObjectRef, this, new S7.a(this) { // from class: com.stepos.motionkit.fx.backend.c
                public final /* synthetic */ GlesRenderer b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i62 = i11;
                    GlesRenderer glesRenderer = this.b;
                    switch (i62) {
                        case 0:
                            return GlesRenderer.releaseGL$lambda$8(glesRenderer);
                        case 1:
                            return GlesRenderer.releaseGL$lambda$9(glesRenderer);
                        case 2:
                            return GlesRenderer.releaseGL$lambda$10(glesRenderer);
                        case 3:
                            return GlesRenderer.releaseGL$lambda$11(glesRenderer);
                        default:
                            return GlesRenderer.releaseGL$lambda$12(glesRenderer);
                    }
                }
            });
            final int i12 = 4;
            releaseGL$attempt(ref$ObjectRef, this, new S7.a(this) { // from class: com.stepos.motionkit.fx.backend.c
                public final /* synthetic */ GlesRenderer b;

                {
                    this.b = this;
                }

                @Override // S7.a
                public final Object invoke() {
                    int i62 = i12;
                    GlesRenderer glesRenderer = this.b;
                    switch (i62) {
                        case 0:
                            return GlesRenderer.releaseGL$lambda$8(glesRenderer);
                        case 1:
                            return GlesRenderer.releaseGL$lambda$9(glesRenderer);
                        case 2:
                            return GlesRenderer.releaseGL$lambda$10(glesRenderer);
                        case 3:
                            return GlesRenderer.releaseGL$lambda$11(glesRenderer);
                        default:
                            return GlesRenderer.releaseGL$lambda$12(glesRenderer);
                    }
                }
            });
            releaseGL$attempt(ref$ObjectRef, this, new com.stepos.ability.voicewakeup.service.f(3));
            this.program = 0;
            this.currentBound = false;
            this.displayInitialized = false;
            this.eglSurface = EGL14.EGL_NO_SURFACE;
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            Exception exc = (Exception) ref$ObjectRef.f4920a;
            if (exc != null) {
                throw exc;
            }
        } catch (Throwable th) {
            this.program = 0;
            this.currentBound = false;
            this.displayInitialized = false;
            this.eglSurface = EGL14.EGL_NO_SURFACE;
            this.eglContext = EGL14.EGL_NO_CONTEXT;
            this.eglDisplay = EGL14.EGL_NO_DISPLAY;
            throw th;
        }
    }

    private static final void releaseGL$attempt(Ref$ObjectRef<Exception> ref$ObjectRef, GlesRenderer glesRenderer, S7.a aVar) {
        try {
            aVar.invoke();
        } catch (Exception e) {
            Exception exc = (Exception) ref$ObjectRef.f4920a;
            if (exc != null) {
                S0.b.e0(exc, e);
            } else {
                ref$ObjectRef.f4920a = e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r releaseGL$lambda$10(GlesRenderer glesRenderer) {
        if (!kotlin.jvm.internal.k.b(glesRenderer.eglSurface, EGL14.EGL_NO_SURFACE)) {
            glesRenderer.checkEgl(EGL14.eglDestroySurface(glesRenderer.eglDisplay, glesRenderer.eglSurface), "eglDestroySurface");
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r releaseGL$lambda$11(GlesRenderer glesRenderer) {
        if (!kotlin.jvm.internal.k.b(glesRenderer.eglContext, EGL14.EGL_NO_CONTEXT)) {
            glesRenderer.checkEgl(EGL14.eglDestroyContext(glesRenderer.eglDisplay, glesRenderer.eglContext), "eglDestroyContext");
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r releaseGL$lambda$12(GlesRenderer glesRenderer) {
        if (glesRenderer.displayInitialized) {
            glesRenderer.checkEgl(EGL14.eglTerminate(glesRenderer.eglDisplay), "eglTerminate");
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r releaseGL$lambda$13() {
        EGL14.eglReleaseThread();
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r releaseGL$lambda$8(GlesRenderer glesRenderer) {
        int i = glesRenderer.program;
        if (i != 0 && glesRenderer.currentBound) {
            GLES20.glDeleteProgram(i);
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r releaseGL$lambda$9(GlesRenderer glesRenderer) {
        if (glesRenderer.displayInitialized) {
            EGLDisplay eGLDisplay = glesRenderer.eglDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            glesRenderer.checkEgl(EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT), "eglMakeCurrent(unbind)");
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r session$lambda$1(GlesRenderer glesRenderer, Throwable error) {
        kotlin.jvm.internal.k.f(error, "error");
        MKLog.INSTANCE.e("Surface", "GLES renderer failed; releasing this effect", error);
        S7.k kVar = glesRenderer.onFailure;
        if (kVar != null) {
            kVar.invoke(error);
        }
        return r.f317a;
    }

    /* renamed from: getOnFailure$motionkit_fx_release, reason: from getter */
    public final S7.k getOnFailure() {
        return this.onFailure;
    }

    public final void renderFrame(long elapsedMs) {
        this.session.renderFrame(elapsedMs);
    }

    public final void setOnFailure$motionkit_fx_release(S7.k kVar) {
        this.onFailure = kVar;
    }

    public final void start() {
        this.session.start();
    }

    public final void stop() {
        this.session.stop();
    }

    public final void stopAndWait$motionkit_fx_release() {
        this.session.stopAndWait();
    }

    public final void whenStopped$motionkit_fx_release(S7.a action) {
        kotlin.jvm.internal.k.f(action, "action");
        this.session.whenStopped(action);
    }
}
