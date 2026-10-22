package bsa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.os.Build;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.camera.common.gl.GlUtil;
import com.ss.android.bytedcert.camera.common.gl.STGLRenderer;
import com.ss.android.bytedcert.dialog.controller.base.ICameraController;
import com.ss.android.bytedcert.utils.Accelerometer;
import com.ss.android.cert.manager.BytedCertSdkManager;
import com.ss.android.cert.manager.ablity.SettingsDelegate;
import com.ss.android.cert.manager.utils.CertLog;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends bsa.a {
    public boolean A;
    public com.ss.android.bytedcert.camera.common.gl.b B;
    public int C;
    public int D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final fsa.a f20347y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.ss.android.bytedcert.camera.common.gl.a f20348z;

    public class a implements dsa.a.InterfaceC5706a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20349a;

        public final void b() {
            b r100 = this.f20349a;
            if (r100.f20347y != null) goto L5;
            return;
        L5:
            if (r100.A == true) goto L7;
            return;
        L7:
            if (r100.f20339q == false) goto L9;
            return;
        L9:
            if (r100.f20341s == false) goto L11;
            return;
        L11:
            if (r100.f20336n == null) goto L19;
            CertLog.d("CameraDevice", "changePreviewSize");
            r100.f20339q = true;
            r100.f20347y.j();
            r100.f20329g.queueEvent(new d(r100));
            return;
        }

        public a(b r100) {
            this.f20349a = r100;
        }

        public final void a(boolean r100) {
            this.f20349a.A = r100;
            CertLog.d("CameraDevice", "on camera open, result " + r100);
        }
    }

    /* JADX INFO: renamed from: bsa.b$b, reason: collision with other inner class name */
    public class RunnableC0356b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20350a;

        @Override // java.lang.Runnable
        public final void run() {
            b r100 = this.f20350a;     // Catch: Throwable -> L6
            r100.f20337o = null;     // Catch: Throwable -> L6
            r100.k();     // Catch: Throwable -> L6
            STGLRenderer r101 = this.f20350a.f20336n;     // Catch: Throwable -> L6
            if (r101 == null) goto L9;
            r101.e();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public RunnableC0356b(b r100) {
            this.f20350a = r100;
        }
    }

    @Override // bsa.a
    public final void i() {
        this.f20341s = false;
        this.f20347y.a(this.f20328f, true, new a(this));
        this.C = 0;
    }

    @Override // bsa.a
    public final void a() {
        this.f20329g.queueEvent(new RunnableC0356b(this));
        this.f20329g.onPause();
        this.f20341s = true;
        this.f20347y.close();
        this.A = false;
    }

    public final void k() {
        SurfaceTexture r100 = this.f20335m;
        if (r100 == null) goto L5;
        r100.setOnFrameAvailableListener(null);
        this.f20335m.release();
        this.f20335m = null;
    L5:
        int r101 = this.f20323a;
        if (r101 == (-1)) goto L8;
        GLES20.glDeleteTextures(1, new int[]{r101}, 0);
    L8:
        this.f20323a = -1;
        int[] r102 = this.f20338p;
        if (r102 == null) goto L11;
        GLES20.glDeleteTextures(1, r102, 0);
        this.f20338p = null;
    L11:
        com.ss.android.bytedcert.camera.common.gl.b r103 = this.B;
        if (r103 == null) goto L21;
        int r104 = r103.f407288a;
        if (r104 == 0) goto L16;
        GLES20.glDeleteProgram(r104);
        r103.f407288a = 0;
    L16:
        int r105 = r103.f407292e;
        if (r105 == 0) goto L19;
        GLES20.glDeleteTextures(1, new int[]{r105}, 0);
        r103.f407292e = 0;
    L19:
        this.B = null;
        return;
    }

    public static void j(b r100) {
        r100.getClass();
        CertLog.d("CameraDevice", "setUpCamera:is sec camera:" + r100.f20347y.d());
        if (r100.f20347y.d() == false) goto L24;
        if (r100.f20323a != (-1)) goto L7;
    L10:
        r100.k();
        com.ss.android.bytedcert.camera.common.gl.b r101 = new com.ss.android.bytedcert.camera.common.gl.b();
        r100.B = r101;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int r102 = com.ss.android.bytedcert.camera.common.gl.b.b(35633, "attribute vec4 aPosition;\nattribute vec4 aTexCoord;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = aPosition;\n    textureCoordinate = aTexCoord.xy;\n}");
        int r103 = com.ss.android.bytedcert.camera.common.gl.b.b(35632, "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() {\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        if (r102 == 0) goto L21;
        if (r103 == 0) goto L21;
        int r104 = GLES20.glCreateProgram();
        if (r104 == 0) goto L21;
        GLES20.glAttachShader(r104, r102);
        GLES20.glAttachShader(r104, r103);
        GLES20.glLinkProgram(r104);
        int[] r105 = new int[1];
        GLES20.glGetProgramiv(r104, 35714, r105, 0);
        if (r105[0] == 1) goto L20;
        GLES20.glGetProgramInfoLog(r104);
        GLES20.glDeleteProgram(r104);
        goto L21
    L20:
        GLES20.glDeleteShader(r102);
        GLES20.glDeleteShader(r103);
    L22:
        r101.f407288a = r104;
        r101.f407289b = GLES20.glGetAttribLocation(r104, "aPosition");
        r101.f407290c = GLES20.glGetAttribLocation(r101.f407288a, "aTexCoord");
        r101.f407291d = GLES20.glGetUniformLocation(r101.f407288a, "inputImageTexture");
        int[] r106 = new int[1];
        GLES20.glGenTextures(1, r106, 0);
        int r107 = r106[0];
        r101.f407292e = r107;
        GLES20.glBindTexture(3553, r107);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        r100.f20323a = r101.f407292e;
        r100.B.f407295h = r100.f20326d / r100.f20327e;
    L31:
        boolean r108 = r100.f20347y.e();
        r100.f20336n.a(r100.f20347y.getOrientation(), r108);
        CertLog.d("CameraDevice", "height " + r100.f20325c + ",width " + r100.f20324b + ",sFlip " + r108);
        return;
    L21:
        r104 = 0;
        goto L22
    L7:
        if (r100.B == null) goto L10;
        if (r100.f20335m == null) goto L31;
    L24:
        if (r100.f20323a != (-1)) goto L26;
    L29:
        r100.k();
        r100.f20323a = com.ss.android.bytedcert.camera.common.gl.d.a();
        SurfaceTexture r109 = new SurfaceTexture(r100.f20323a);
        r100.f20335m = r109;
        r109.setOnFrameAvailableListener(new c(r100));
        GLES20.glEnable(3024);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glEnable(2929);
    L30:
        r100.f20347y.c(r100.f20335m, Math.max(r100.f20324b, r100.f20325c), Math.min(r100.f20324b, r100.f20325c));
        goto L31
    L26:
        if (r100.f20335m == null) goto L29;
        if (r100.B == null) goto L30;
        goto L29
    }

    @Override // bsa.a
    public final void c(com.ss.android.bytedcert.face.e r100) {
        fsa.a r101 = this.f20347y;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.b("depth_detect", r100);
    }

    @Override // bsa.a
    public final void e(com.ss.android.bytedcert.face.f r100) {
        fsa.a r101 = this.f20347y;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.b("white_balance_detect", r100);
    }

    @Override // bsa.a
    public final void g(CameraFactory$WhiteBalanceType r100) {
        fsa.a r101 = this.f20347y;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.b("switch_white_balance", r100);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r210) {
        if (this.C > 10) goto L13;
        StringBuilder r100 = new StringBuilder("onDrawFrame, is paused:");
        r100.append(this.f20341s);
        r100.append(",\nis camera opened:");
        r100.append(this.A);
        r100.append(",\nis camera changing:");
        r100.append(this.f20339q);
        r100.append(",\ngl surface:");
        if (this.f20335m != null) goto L7;
        String r101 = "null";
    L8:
        r100.append(r101);
        r100.append(",\ngl render:");
        if (this.f20336n != null) goto L11;
        String r102 = "null";
    L12:
        r100.append(r102);
        r100.append(",\nis camera opened:");
        r100.append(this.A);
        r100.append(",\nis sec camera:");
        r100.append(this.f20347y.d());
        CertLog.d("CameraDevice", r100.toString());
        goto L13
    L11:
        r102 = "valid";
        goto L12
    L7:
        r101 = "valid";
    L13:
        ICameraController r103 = this.f20330h;
        if (r103 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        this.f20341s = r104;
        if (this.f20339q == true) goto L137;
        if (r104 == false) goto L24;
        return;
    L24:
        if (this.f20336n != null) goto L27;
        return;
    L27:
        if (this.A == true) goto L30;
        return;
    L30:
        if (this.f20347y.d() == true) goto L35;
        if (this.f20335m != null) goto L35;
        return;
    L35:
        if (this.f20337o != null) goto L38;
        this.f20337o = ByteBuffer.allocate((this.f20325c * this.f20324b) * 4);
    L38:
        if (this.f20338p != null) goto L40;
        int[] r105 = new int[1];
        this.f20338p = r105;
        GlUtil.b(this.f20324b, this.f20325c, r105);
    L40:
        int r106 = this.f20323a;
        float r107 = 1.0f;
        if (this.f20347y.d() == false) goto L98;
        com.ss.android.bytedcert.camera.common.gl.a r108 = this.f20348z;
        Object r109 = r108.f407286a;
        monitor-enter(r109);
        byte[] r110 = r108.f407287b;     // Catch: Throwable -> L95
        r108.f407287b = null;     // Catch: Throwable -> L95
        monitor-exit(r109);     // Catch: Throwable -> L95
        if (r110 == null) goto L94;
        System.currentTimeMillis();
        if (r110.length != 0) goto L131;
    L56:
        Bitmap r111 = null;
    L57:
        if (r111 == null) goto L94;
        if (this.B == null) goto L94;
        if (this.f20324b == r111.getWidth()) goto L63;
    L64:
        this.f20324b = r111.getWidth();
        int r112 = r111.getHeight();
        this.f20325c = r112;
        this.f20337o = ByteBuffer.allocate((r112 * this.f20324b) * 4);
    L65:
        r111.copyPixelsToBuffer(this.f20337o);
        this.f20337o.position(0);
        this.B.getClass();
        GLES20.glBindTexture(3553, r106);
        GLES20.glTexImage2D(3553, 0, 6408, r111.getWidth(), r111.getHeight(), 0, 6408, 5121, null);
        GLUtils.texSubImage2D(3553, 0, 0, 0, r111);     // Catch: Throwable -> L68
    L69:
        GLES20.glBindTexture(3553, 0);
        com.ss.android.bytedcert.camera.common.gl.b.a("uploadBitmapToTexture");
        com.ss.android.bytedcert.camera.common.gl.b r113 = this.B;
        int r114 = this.f20324b;
        int r115 = this.f20325c;
        if (r113.f407288a != 0) goto L72;
    L93:
        r111.recycle();
        goto L94
    L72:
        if (r113.f407289b < 0) goto L93;
        if (r113.f407290c < 0) goto L93;
        if (r113.f407291d < 0) goto L93;
        GLES20.glClear(16384);
        if (r113.f407293f == r114) goto L81;
    L82:
        r113.f407293f = r114;
        r113.f407294g = r115;
        float r116 = r114 / r115;
        float r117 = r113.f407295h;
        float r118 = -1.0f;
        if (r116 <= r117) goto L85;
        float r119 = r117 / r116;
        float r120 = r119 * (-1.0f);
        float r121 = r119 * 1.0f;
    L86:
        r113.f407296i.clear();
        r113.f407296i.put(new float[]{r118, r120, r107, r120, r118, r121, r107, r121});
        r113.f407296i.position(0);
    L88:
        if (r113.f407293f == 0) goto L93;
        if (r113.f407294g == 0) goto L93;
        GLES20.glUseProgram(r113.f407288a);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, r106);
        GLES20.glUniform1i(r113.f407291d, 0);
        r113.f407296i.position(0);
        GLES20.glEnableVertexAttribArray(r113.f407289b);
        GLES20.glVertexAttribPointer(r113.f407289b, 2, 5126, false, 0, r113.f407296i);
        r113.f407297j.position(0);
        GLES20.glEnableVertexAttribArray(r113.f407290c);
        GLES20.glVertexAttribPointer(r113.f407290c, 2, 5126, false, 0, r113.f407297j);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(r113.f407289b);
        GLES20.glDisableVertexAttribArray(r113.f407290c);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        com.ss.android.bytedcert.camera.common.gl.b.a("onDrawFrame");
        goto L93
    L85:
        float r122 = r116 / r117;
        r107 = r122 * 1.0f;
        r118 = r122 * (-1.0f);
        r120 = -1.0f;
        r121 = 1.0f;
        goto L86
    L81:
        if (r113.f407294g == r115) goto L88;
    L68:
        GLUtils.texImage2D(3553, 0, r111, 0);
        goto L69
    L63:
        if (this.f20325c == r111.getHeight()) goto L65;
    L131:
        if (Build.VERSION.SDK_INT < 28) goto L53;
        r111 = ImageDecoder.decodeBitmap(ImageDecoder.createSource(ByteBuffer.wrap(r110)), new com.ss.android.bytedcert.camera.common.gl.c());     // Catch: Throwable -> L55
    L130:
    L53:
        BitmapFactory.Options r123 = new BitmapFactory.Options();     // Catch: Throwable -> L55
        r123.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L55
        r111 = BitmapFactory.decodeByteArray(r110, 0, r110.length, r123);     // Catch: Throwable -> L55
    L94:
        byte[] r124 = r110;
    L104:
        if (this.f20342t != null) goto L106;
        int r125 = 1;
    L126:
        GLES20.glViewport(0, 0, this.f20326d, this.f20327e);
        this.f20336n.h(r106, this.f20334l);
        int r126 = this.C + r125;
        this.C = r126;
        if (r126 != r125) goto L139;
        rsa.c.a(new rsa.c.a("flow_step", com.ss.android.bytedcert.face.a.b("camera", "frame_1", null)));
        return;
    L139:
        return;
    L106:
        if (this.f20343u != null) goto L108;
    L111:
        int r127 = this.f20324b;
        this.f20344v = r127;
        int r128 = this.f20325c;
        this.f20345w = r128;
        this.f20343u = new byte[(r127 * r128) * 4];
    L113:
        if (Accelerometer.f407643d != null) goto L115;
        Accelerometer.f407643d = Accelerometer.CLOCKWISE_ANGLE.Deg90;
    L115:
        int r129 = Accelerometer.f407643d.getValue();
        int r130 = r129 - 1;
        if (r130 >= 0) goto L118;
        int r131 = r129 ^ 3;
    L120:
        if (this.D == 0) goto L122;
    L124:
        this.f20342t.a(this.f20337o.array(), r131, r124, this.f20344v, this.f20345w);
        r125 = 1;
        this.D++;
        goto L126
    L122:
        if (this.f20347y.d() == true) goto L124;
        this.f20342t.j();
        goto L124
    L118:
        r131 = r130;
        goto L120
    L108:
        if (this.f20345w != this.f20325c) goto L111;
        if (this.f20344v == this.f20324b) goto L113;
    L95:
        th = move-exception;
        throw th;
    L98:
        this.f20335m.updateTexImage();
        System.currentTimeMillis();
        if (this.f20332j == false) goto L101;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    L102:
        GLES20.glClear(16640);
        this.f20337o.rewind();
        r106 = this.f20336n.i(this.f20323a, this.f20337o);
        r124 = null;
        goto L104
    L101:
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        goto L102
    L137:
        return;
    L16:
        if (r103.isGLPause() == true) goto L19;
        r104 = false;
        goto L20
    }

    @Override // bsa.a
    public final int b(int[] r100, float[] r101) {
        lsa.a r102 = this.f20342t;
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.i(r100, r101);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        if (this.f20341s == false) goto L5;
        return;
    L5:
        CertLog.d("CameraDevice", "onSurfaceCreated");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
        if (this.f20341s == false) goto L5;
        return;
    L5:
        if (this.f20336n == null) goto L19;
        com.ss.android.bytedcert.camera.common.gl.b r103 = this.B;
        if (r103 == null) goto L10;
        r103.f407295h = r101 / r102;
    L10:
        this.f20326d = r101;
        this.f20327e = r102;
        boolean r104 = false;
        GLES20.glViewport(0, 0, r101, r102);
        if (this.f20333k == false) goto L13;
        STGLRenderer r105 = this.f20336n;
        r105.f407275f = 0;
        int r106 = this.f20324b;
        float r107 = ((r106 - 360) * 0.5f) / r106;
        int r108 = this.f20325c;
        float r109 = ((r108 - 360) * 0.5f) / r108;
        r105.k(r107, r109, 1.0f - r107, 1.0f - r109);
        this.f20336n.j();
    L13:
        this.f20336n.d(this.f20326d, this.f20327e, this.f20324b, this.f20325c);
        STGLRenderer r110 = this.f20336n;
        if (this.f20334l <= 0) goto L16;
        r104 = true;
    L16:
        r110.f(r104, this.f20324b, this.f20325c);
        System.currentTimeMillis();
        CertLog.d("CameraDevice", "onSurfaceChanged, width:" + r101 + ",height:" + r102);
        return;
    }

    public b(Context r100, ICameraController r101, f r102, GLSurfaceView r103, boolean r104, boolean r105) {
        super(r100, r101, r102, r103, r104, r105);
        this.C = 0;
        this.D = 0;
        Object r106 = BytedCertSdkManager.getInstance().getSettingsDelegate().getSetting(SettingsDelegate.SettingsKey.USE_MI_SEC_CAMERA);
        if ((r106 instanceof Boolean) == true) goto L5;
    L7:
        fsa.a r107 = new fsa.a(r100, r104);
    L8:
        this.f20347y = r107;
        this.f20348z = new com.ss.android.bytedcert.camera.common.gl.a();
        if (r104 == false) goto L11;
        this.f20324b = 720;
        this.f20325c = 1280;
        return;
    L11:
        this.f20324b = 480;
        this.f20325c = 640;
        return;
    L5:
        if (((Boolean) r106).booleanValue() == false) goto L7;
        r107 = new com.ss.android.bytedcert.camera.refactor.mi.c(r100, r104);
        goto L8
    }
}
