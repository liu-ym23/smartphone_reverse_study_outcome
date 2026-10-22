package sa;

import android.graphics.Path;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import f6.h;
import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import jb.v;
import m0.e;
import n3.q0;
import nc.t0;
import r3.f;
import stepos.support.v7.app.a0;
import stepos.support.v7.widget.k0;
import u1.g0;
import u1.w1;
import u5.k;
import u5.l;
import w5.g;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements k0, q0, f, h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12169c;

    /* renamed from: f, reason: collision with root package name */
    public Object f12170f;

    public c(int i) {
        this.f12169c = i;
        switch (i) {
            case 9:
                this.f12170f = new AtomicInteger(0);
                break;
            default:
                this.f12170f = new w1(u1.f.f13778b);
                break;
        }
    }

    public static void f(Runnable runnable) {
        ((ThreadPoolExecutor) b.f12168a.f12170f).execute(runnable);
    }

    public void a(g0 g0Var) {
        if (!g0Var.G()) {
            r1.a.b("DepthSortedSet.add called on an unattached node");
        }
        ((w1) this.f12170f).add(g0Var);
    }

    @Override // r3.f
    public void b(NestedScrollView nestedScrollView) {
        ((StepOSScrollBarView) this.f12170f).a(true);
    }

    public void c(Path path) {
        float[] fArr = (float[]) this.f12170f;
        path.cubicTo(fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7]);
        path.cubicTo(fArr[8], fArr[9], fArr[10], fArr[11], fArr[12], fArr[13]);
    }

    public void d(CancellationException cancellationException) {
        e eVar = (e) this.f12170f;
        int i = eVar.f8160g;
        kc.f[] fVarArr = new kc.f[i];
        for (int i3 = 0; i3 < i; i3++) {
            fVarArr[i3] = ((u.h) eVar.f8158c[i3]).f13472b;
        }
        for (int i10 = 0; i10 < i; i10++) {
            fVarArr[i10].f(cancellationException);
        }
        if (eVar.f8160g == 0) {
            return;
        }
        od.f.e("uncancelled requests present");
    }

    public g e() {
        w5.c cVarG;
        ab.c cVar = (ab.c) this.f12170f;
        w5.e eVar = (w5.e) cVar.f385d;
        synchronized (eVar) {
            cVar.c(true);
            cVarG = eVar.g(((w5.b) cVar.f383b).f15234a);
        }
        if (cVarG != null) {
            return new g(cVarG);
        }
        return null;
    }

    @Override // f6.h
    public Object g(t5.f fVar) {
        t0 t0Var = ((l) this.f12170f).f14067j;
        k kVar = new k(0);
        kVar.f14065f = t0Var;
        VarHandle.storeStoreFence();
        return nc.k0.i(kVar, fVar);
    }

    @Override // n3.q0
    public void h() {
        switch (this.f12169c) {
            case 2:
                ((View) ((a0) this.f12170f).f12271f.getParent()).invalidate();
                break;
            default:
                ((View) ((stepos.support.v7.app.t0) this.f12170f).f12482d.getParent()).invalidate();
                break;
        }
    }

    public boolean i(g0 g0Var) {
        if (!g0Var.G()) {
            r1.a.b("DepthSortedSet.remove called on an unattached node");
        }
        return ((w1) this.f12170f).remove(g0Var);
    }

    public void j() {
        e eVar = (e) this.f12170f;
        int i = 0;
        int i3 = new ec.g(0, eVar.f8160g - 1, 1).f3759f;
        if (i3 >= 0) {
            while (true) {
                ((u.h) eVar.f8158c[i]).f13472b.resumeWith(v.f6774a);
                if (i == i3) {
                    break;
                } else {
                    i++;
                }
            }
        }
        eVar.g();
    }

    public void k() {
        float[] fArr = (float[]) this.f12170f;
        float f5 = fArr[0];
        float f10 = fArr[1];
        fArr[0] = fArr[12];
        fArr[1] = fArr[13];
        fArr[12] = f5;
        fArr[13] = f10;
        float f11 = fArr[2];
        float f12 = fArr[3];
        fArr[2] = fArr[10];
        fArr[3] = fArr[11];
        fArr[10] = f11;
        fArr[11] = f12;
        float f13 = fArr[4];
        float f14 = fArr[5];
        fArr[4] = fArr[8];
        fArr[5] = fArr[9];
        fArr[8] = f13;
        fArr[9] = f14;
    }

    @Override // stepos.support.v7.widget.k0
    public void onScrollChange(View view, int i, int i3, int i10, int i11) {
        se.e eVar = (se.e) this.f12170f;
        se.e.a(eVar, view, eVar.f12209d, eVar.f12214j);
    }

    public String toString() {
        switch (this.f12169c) {
            case 6:
                return ((w1) this.f12170f).toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ c(Object obj, int i) {
        this.f12169c = i;
        this.f12170f = obj;
    }

    public /* synthetic */ c(int i, boolean z10) {
        this.f12169c = i;
    }
}
