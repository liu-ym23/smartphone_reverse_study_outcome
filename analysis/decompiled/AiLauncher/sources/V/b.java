package V;

import D.A;
import D.B;
import D.C0761b0;
import D.r0;
import U.C1043y;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.processing.util.GLUtils;
import java.util.Map;

/* loaded from: classes.dex */
public final class b extends C1043y {

    /* renamed from: n, reason: collision with root package name */
    public int f6421n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f6422o = -1;

    /* renamed from: p, reason: collision with root package name */
    public final A f6423p;

    /* renamed from: q, reason: collision with root package name */
    public final A f6424q;

    public b(A a10, A a11) {
        this.f6423p = a10;
        this.f6424q = a11;
    }

    public static float[] u(Size size, Size size2, A a10) {
        float[] fArrL = GLUtils.l();
        float[] fArrL2 = GLUtils.l();
        float[] fArrL3 = GLUtils.l();
        Matrix.scaleM(fArrL, 0, size.getWidth() / size2.getWidth(), size.getHeight() / size2.getHeight(), 1.0f);
        if (a10.c().f1411a.floatValue() != 0.0f || a10.c().f1412b.floatValue() != 0.0f) {
            Matrix.translateM(fArrL2, 0, a10.b().f1411a.floatValue() / a10.c().f1411a.floatValue(), a10.b().f1412b.floatValue() / a10.c().f1412b.floatValue(), 0.0f);
        }
        Matrix.multiplyMM(fArrL3, 0, fArrL, 0, fArrL2, 0);
        return fArrL3;
    }

    @Override // U.C1043y
    public W.d h(B b10, Map<GLUtils.InputFormat, U.B> map) {
        W.d dVarH = super.h(b10, map);
        this.f6421n = GLUtils.p();
        this.f6422o = GLUtils.p();
        return dVarH;
    }

    @Override // U.C1043y
    public void k() {
        super.k();
        this.f6421n = -1;
        this.f6422o = -1;
    }

    public int t(boolean z10) {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        return z10 ? this.f6421n : this.f6422o;
    }

    public void v(long j10, Surface surface, r0 r0Var, SurfaceTexture surfaceTexture, SurfaceTexture surfaceTexture2) {
        GLUtils.i(this.f6151a, true);
        GLUtils.h(this.f6153c);
        W.f fVarF = f(surface);
        if (fVarF == GLUtils.f11678l) {
            fVarF = c(surface);
            if (fVarF == null) {
                return;
            } else {
                this.f6152b.put(surface, fVarF);
            }
        }
        W.f fVar = fVarF;
        if (surface != this.f6159i) {
            i(fVar.a());
            this.f6159i = surface;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        w(fVar, r0Var, surfaceTexture, this.f6423p, this.f6421n, true);
        w(fVar, r0Var, surfaceTexture2, this.f6424q, this.f6422o, false);
        EGLExt.eglPresentationTimeANDROID(this.f6154d, fVar.a(), j10);
        if (EGL14.eglSwapBuffers(this.f6154d, fVar.a())) {
            return;
        }
        C0761b0.o("DualOpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        m(surface, false);
    }

    public final void w(W.f fVar, r0 r0Var, SurfaceTexture surfaceTexture, A a10, int i10, boolean z10) {
        s(i10);
        GLES20.glViewport(0, 0, fVar.c(), fVar.b());
        GLES20.glScissor(0, 0, fVar.c(), fVar.b());
        float[] fArr = new float[16];
        surfaceTexture.getTransformMatrix(fArr);
        float[] fArr2 = new float[16];
        r0Var.x(fArr2, fArr, z10);
        GLUtils.e eVar = (GLUtils.e) B0.h.f(this.f6161k);
        if (eVar instanceof GLUtils.f) {
            ((GLUtils.f) eVar).h(fArr2);
        }
        eVar.e(u(new Size((int) (fVar.c() * a10.c().f1411a.floatValue()), (int) (fVar.b() * a10.c().f1412b.floatValue())), new Size(fVar.c(), fVar.b()), a10));
        eVar.d(a10.a());
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 771);
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.g("glDrawArrays");
        GLES20.glDisable(3042);
    }
}
