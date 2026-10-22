package ub;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements IRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f24909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f24910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f24911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f24912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f24913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f24914g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FloatBuffer f24915h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f24916i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float[] f24917j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f24920m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f24921n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f24922o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f24923p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f24924q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f24925r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SurfaceTexture f24926s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public IRender.SurfaceListener f24927t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ScaleType f24928u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final IAlphaVideoView f24929v;

    public a(IAlphaVideoView r10) {
        q.g(r10, "alphaVideoView");
        this.f24929v = r10;
        this.f24908a = "VideoRender";
        this.f24909b = 4;
        this.f24910c = 4 * 5;
        this.f24912e = 3;
        this.f24913f = 36197;
        this.f24914g = new float[]{-1.0f, -1.0f, 0.0f, 0.5f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f24916i = new float[16];
        float[] r11 = new float[16];
        this.f24917j = r11;
        this.f24924q = new AtomicBoolean(false);
        this.f24925r = new AtomicBoolean(false);
        this.f24928u = ScaleType.ScaleAspectFill;
        FloatBuffer r12 = ByteBuffer.allocateDirect(this.f24914g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        q.f(r12, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.f24915h = r12;
        r12.put(this.f24914g).position(0);
        Matrix.setIdentityM(r11, 0);
    }

    public final void a(String r10) {
        int r11 = GLES20.glGetError();
        if (r11 == 0) goto L6;
        Log.e(this.f24908a, r10 + ": glError " + r11);
        return;
    }

    public final int b() {
        int r10 = c(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\n\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}");
        if (r10 != 0) goto L6;
        Log.e(this.f24908a, "Failed to compile vertex shader");
        return 0;
    L6:
        int r11 = c(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\n\nvoid main() {\n    vec4 color = texture2D(sTexture, vTextureCoord);\n    vec4 color2Map = vec4(1.0, 1.0, 1.0, 1.0);\n    if (vTextureCoord.x >= 0.5) {\n        color2Map = texture2D(sTexture, vec2(vTextureCoord.x - 0.5, vTextureCoord.y));\n        gl_FragColor = vec4(color.r, color.g, color.b, color2Map.g);\n    } else {\n        gl_FragColor = vec4(color.r, color.g, color.b, color.a);\n    }\n}");
        if (r11 != 0) goto L10;
        Log.e(this.f24908a, "Failed to compile fragment shader");
        GLES20.glDeleteShader(r10);
        return 0;
    L10:
        int r12 = GLES20.glCreateProgram();
        if (r12 == 0) goto L16;
        GLES20.glAttachShader(r12, r10);
        a("glAttachShader");
        GLES20.glAttachShader(r12, r11);
        a("glAttachShader");
        GLES20.glLinkProgram(r12);
        int[] r13 = new int[1];
        GLES20.glGetProgramiv(r12, 35714, r13, 0);
        if (r13[0] == 1) goto L16;
        Log.e(this.f24908a, "Could not link programID: ");
        Log.e(this.f24908a, GLES20.glGetProgramInfoLog(r12));
        GLES20.glDeleteProgram(r12);
        return 0;
    L16:
        return r12;
    }

    public final int c(int r10, String r11) {
        int r12 = GLES20.glCreateShader(r10);
        if (r12 == 0) goto L8;
        GLES20.glShaderSource(r12, r11);
        GLES20.glCompileShader(r12);
        int[] r13 = new int[1];
        GLES20.glGetShaderiv(r12, 35713, r13, 0);
        if (r13[0] != 0) goto L9;
        Log.e(this.f24908a, "Could not compile shader " + r10 + ':');
        Log.e(this.f24908a, GLES20.glGetShaderInfoLog(r12));
        GLES20.glDeleteShader(r12);
        return 0;
    L9:
        return r12;
    L8:
        return r12;
    }

    public final void d() {
        int[] r10 = new int[1];
        GLES20.glGenTextures(1, r10, 0);
        int r11 = r10[0];
        this.f24919l = r11;
        GLES20.glBindTexture(this.f24913f, r11);
        a("glBindTexture textureID");
        GLES20.glTexParameterf(this.f24913f, 10241, 9728);
        GLES20.glTexParameterf(this.f24913f, 10240, 9729);
        SurfaceTexture r12 = new SurfaceTexture(this.f24919l);
        this.f24926s = r12;
        r12.setDefaultBufferSize(this.f24929v.getMeasuredWidth(), this.f24929v.getMeasuredHeight());
        SurfaceTexture r13 = this.f24926s;
        if (r13 != null) goto L5;
        q.y("surfaceTexture");
    L5:
        r13.setOnFrameAvailableListener(this);
        SurfaceTexture r14 = this.f24926s;
        if (r14 != null) goto L8;
        q.y("surfaceTexture");
    L8:
        Surface r15 = new Surface(r14);
        IRender.SurfaceListener r16 = this.f24927t;
        if (r16 == null) goto L11;
        r16.onSurfacePrepared(r15);
    L11:
        this.f24925r.compareAndSet(true, false);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void measureInternal(float r10, float r11, float r12, float r13) {
        float r14 = 0;
        if (r10 > r14) goto L5;
        return;
    L5:
        if (r11 > r14) goto L7;
        return;
    L7:
        if (r12 > r14) goto L9;
        return;
    L9:
        if (r13 <= r14) goto L16;
        float[] r15 = vb.a.a(this.f24928u, r10, r11, r12, r13);
        q.f(r15, "TextureCropUtil.calculat… videoWidth, videoHeight)");
        this.f24914g = r15;
        FloatBuffer r16 = ByteBuffer.allocateDirect(r15.length * this.f24909b).order(ByteOrder.nativeOrder()).asFloatBuffer();
        q.f(r16, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.f24915h = r16;
        r16.put(this.f24914g).position(0);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void onCompletion() {
        this.f24924q.compareAndSet(true, false);
        Log.i(this.f24908a, "onCompletion:   canDraw = " + this.f24924q.get());
        this.f24929v.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer, android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r10) {
        q.g(r10, "glUnused");
        if (this.f24925r.compareAndSet(true, false) == true) goto L22;
    L16:
        GLES20.glClear(16640);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.f24924q.get() == true) goto L20;
        GLES20.glFinish();
        return;
    L20:
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glUseProgram(this.f24918k);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f24913f, this.f24919l);
        this.f24915h.position(this.f24911d);
        GLES20.glVertexAttribPointer(this.f24922o, 3, 5126, false, this.f24910c, this.f24915h);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f24922o);
        a("glEnableVertexAttribArray aPositionHandle");
        this.f24915h.position(this.f24912e);
        GLES20.glVertexAttribPointer(this.f24923p, 3, 5126, false, this.f24910c, this.f24915h);
        a("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f24923p);
        a("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.f24916i, 0);
        GLES20.glUniformMatrix4fv(this.f24920m, 1, false, this.f24916i, 0);
        GLES20.glUniformMatrix4fv(this.f24921n, 1, false, this.f24917j, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
        return;
    L22:
        SurfaceTexture r11 = this.f24926s;     // Catch: Exception -> L7
        if (r11 != null) goto L9;
        q.y("surfaceTexture");     // Catch: Exception -> L7
    L9:
        r11.updateTexImage();     // Catch: Exception -> L7
    L12:
        SurfaceTexture r12 = this.f24926s;
        if (r12 != null) goto L15;
        q.y("surfaceTexture");
    L15:
        r12.getTransformMatrix(this.f24917j);
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void onFirstFrame() {
        this.f24924q.compareAndSet(false, true);
        Log.i(this.f24908a, "onFirstFrame:    canDraw = " + this.f24924q.get());
        this.f24929v.requestRender();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r10) {
        q.g(r10, "surface");
        this.f24925r.compareAndSet(false, true);
        this.f24929v.requestRender();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r10, int r11, int r12) {
        q.g(r10, "glUnused");
        GLES20.glViewport(0, 0, r11, r12);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer, android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r10, EGLConfig r11) {
        q.g(r10, "glUnused");
        q.g(r11, "config");
        int r12 = b();
        this.f24918k = r12;
        if (r12 != 0) goto L5;
        return;
    L5:
        this.f24922o = GLES20.glGetAttribLocation(r12, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.f24922o == (-1)) goto L22;
        this.f24923p = GLES20.glGetAttribLocation(this.f24918k, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.f24923p == (-1)) goto L20;
        this.f24920m = GLES20.glGetUniformLocation(this.f24918k, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.f24920m == (-1)) goto L18;
        this.f24921n = GLES20.glGetUniformLocation(this.f24918k, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.f24921n == (-1)) goto L16;
        d();
        return;
    L16:
        throw new RuntimeException("Could not get attrib location for uSTMatrix");
    L18:
        throw new RuntimeException("Could not get attrib location for uMVPMatrix");
    L20:
        throw new RuntimeException("Could not get attrib location for aTextureCoord");
    L22:
        throw new RuntimeException("Could not get attrib location for aPosition");
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.Renderer
    public void onSurfaceDestroyed(GL10 r10) {
        IRender.SurfaceListener r11 = this.f24927t;
        if (r11 == null) goto L6;
        r11.onSurfaceDestroyed();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void setScaleType(ScaleType r10) {
        q.g(r10, "scaleType");
        this.f24928u = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender
    public void setSurfaceListener(IRender.SurfaceListener r10) {
        q.g(r10, "surfaceListener");
        this.f24927t = r10;
    }
}
