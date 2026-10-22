package bsa;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import com.ss.android.bytedcert.camera.common.CameraFactory$WhiteBalanceType;
import com.ss.android.bytedcert.camera.common.gl.STGLRenderer;
import com.ss.android.bytedcert.dialog.controller.base.ICameraController;
import com.ss.android.bytedcert.model.LiveInfo;
import com.ss.android.cert.manager.utils.CertLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f20328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GLSurfaceView f20329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ICameraController f20330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f20331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f20332j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f20333k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f20334l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SurfaceTexture f20335m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public STGLRenderer f20336n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ByteBuffer f20337o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int[] f20338p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f20339q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20340r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f20341s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public lsa.a f20342t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f20343u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f20344v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f20345w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f20346x;

    /* JADX INFO: renamed from: bsa.a$a, reason: collision with other inner class name */
    public interface InterfaceC0355a {
        void a(boolean r100);
    }

    public interface b {
        void a(boolean r100, boolean r101, boolean r102);
    }

    public abstract void a();

    public abstract void c(com.ss.android.bytedcert.face.e r100);

    public abstract void e(com.ss.android.bytedcert.face.f r100);

    public abstract void g(CameraFactory$WhiteBalanceType r100);

    public abstract void i();

    public final int d(LiveInfo r100) {
        lsa.a r101 = this.f20342t;
        if (r101 != null) goto L6;
        return -1;
    L6:
        int r102 = r101.k(r100);
        CertLog.d("debug1  mCameraDisplay", "SetParam");
        return r102;
    }

    public int b(int[] r100, float[] r101) {
        if (this.f20342t != null) goto L6;
        return -1;
    L6:
        CertLog.d("debug1  mCameraDisplay", "SetConfig");
        int r102 = this.f20342t.j();
        if (r102 == 0) goto L10;
        return r102;
    L10:
        return this.f20342t.i(r100, r101);
    }

    public a(Context r100, ICameraController r101, f r102, GLSurfaceView r103, boolean r104, boolean r105) {
        this.f20323a = -1;
        this.f20339q = false;
        this.f20340r = 0;
        this.f20341s = false;
        this.f20342t = null;
        this.f20343u = null;
        this.f20344v = 0;
        this.f20345w = 0;
        this.f20346x = 0;
        this.f20331i = r102;
        this.f20328f = r100;
        this.f20333k = r105;
        this.f20332j = r104;
        this.f20329g = r103;
        r103.setEGLContextClientVersion(2);
        r103.setRenderer(this);
        r103.setRenderMode(0);
        ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer().put(com.ss.android.bytedcert.camera.common.gl.e.f407298a).position(0);
        this.f20330h = r101;
        this.f20334l = r101.getThemeConfig().getBeautyIntensity();
    }
}
