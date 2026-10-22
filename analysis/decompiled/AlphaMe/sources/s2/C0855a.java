package s2;

import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.Trace;
import com.airbnb.lottie.h;
import com.google.android.material.internal.o;
import com.stepos.renderfilter.functor.DrawGlInfo;

/* renamed from: s2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0855a extends d {

    /* renamed from: g, reason: collision with root package name */
    public static final Matrix f14227g = new Matrix();

    /* renamed from: f, reason: collision with root package name */
    public o f14228f;

    @Override // s2.d
    public final u2.c a(u2.c cVar, DrawGlInfo drawGlInfo) {
        Trace.beginSection("BackdropContentMaker");
        super.a(null, drawGlInfo);
        Trace.beginSection("makeContent");
        this.f14228f.b(10497);
        int i4 = drawGlInfo.mLeft;
        int i5 = drawGlInfo.height;
        int i6 = drawGlInfo.mBottom;
        GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, i4, i5 - i6, drawGlInfo.mRight - i4, i6 - drawGlInfo.mTop);
        o oVar = this.f14228f;
        Trace.endSection();
        Trace.endSection();
        return oVar;
    }

    @Override // s2.d
    public final void b() {
    }

    @Override // s2.d
    public final void c() {
        h.k(this.f14228f);
        this.f14228f = null;
    }

    @Override // s2.d
    public final void d() {
        h.k(this.f14228f);
        this.f14228f = new o(this.f14251b, this.f14252c);
    }
}
