package z2;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int f16254a;

    /* renamed from: b, reason: collision with root package name */
    public final k f16255b;

    /* renamed from: c, reason: collision with root package name */
    public final j f16256c;

    /* renamed from: d, reason: collision with root package name */
    public final i f16257d;

    /* renamed from: e, reason: collision with root package name */
    public final l f16258e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f16259f;

    public h() {
        k kVar = new k();
        kVar.f16308a = 0;
        kVar.f16309b = 0;
        kVar.f16310c = 1.0f;
        kVar.f16311d = Float.NaN;
        this.f16255b = kVar;
        j jVar = new j();
        jVar.f16300a = -1;
        jVar.f16301b = 0;
        jVar.f16302c = -1;
        jVar.f16303d = Float.NaN;
        jVar.f16304e = Float.NaN;
        jVar.f16305f = Float.NaN;
        jVar.f16306g = -1;
        jVar.f16307h = null;
        jVar.i = -1;
        this.f16256c = jVar;
        i iVar = new i();
        iVar.f16261a = false;
        iVar.f16267d = -1;
        iVar.f16269e = -1;
        iVar.f16270f = -1.0f;
        iVar.f16271g = true;
        iVar.f16273h = -1;
        iVar.i = -1;
        iVar.f16276j = -1;
        iVar.f16278k = -1;
        iVar.f16280l = -1;
        iVar.f16282m = -1;
        iVar.f16284n = -1;
        iVar.f16286o = -1;
        iVar.f16288p = -1;
        iVar.f16289q = -1;
        iVar.f16290r = -1;
        iVar.f16291s = -1;
        iVar.f16292t = -1;
        iVar.f16293u = -1;
        iVar.f16294v = -1;
        iVar.f16295w = 0.5f;
        iVar.f16296x = 0.5f;
        iVar.f16297y = null;
        iVar.f16298z = -1;
        iVar.A = 0;
        iVar.B = 0.0f;
        iVar.C = -1;
        iVar.D = -1;
        iVar.E = -1;
        iVar.F = 0;
        iVar.G = 0;
        iVar.H = 0;
        iVar.I = 0;
        iVar.J = 0;
        iVar.K = 0;
        iVar.L = 0;
        iVar.M = Integer.MIN_VALUE;
        iVar.N = Integer.MIN_VALUE;
        iVar.O = Integer.MIN_VALUE;
        iVar.P = Integer.MIN_VALUE;
        iVar.Q = Integer.MIN_VALUE;
        iVar.R = Integer.MIN_VALUE;
        iVar.S = Integer.MIN_VALUE;
        iVar.T = -1.0f;
        iVar.U = -1.0f;
        iVar.V = 0;
        iVar.W = 0;
        iVar.X = 0;
        iVar.Y = 0;
        iVar.Z = 0;
        iVar.f16262a0 = 0;
        iVar.f16264b0 = 0;
        iVar.f16266c0 = 0;
        iVar.f16268d0 = 1.0f;
        iVar.e0 = 1.0f;
        iVar.f0 = -1;
        iVar.f16272g0 = 0;
        iVar.f16274h0 = -1;
        iVar.f16281l0 = false;
        iVar.f16283m0 = false;
        iVar.f16285n0 = true;
        iVar.f16287o0 = 0;
        this.f16257d = iVar;
        l lVar = new l();
        lVar.f16313a = 0.0f;
        lVar.f16314b = 0.0f;
        lVar.f16315c = 0.0f;
        lVar.f16316d = 1.0f;
        lVar.f16317e = 1.0f;
        lVar.f16318f = Float.NaN;
        lVar.f16319g = Float.NaN;
        lVar.f16320h = -1;
        lVar.i = 0.0f;
        lVar.f16321j = 0.0f;
        lVar.f16322k = 0.0f;
        lVar.f16323l = false;
        lVar.f16324m = 0.0f;
        this.f16258e = lVar;
        this.f16259f = new HashMap();
    }

    public final void a(d dVar) {
        i iVar = this.f16257d;
        dVar.f16199e = iVar.f16273h;
        dVar.f16200f = iVar.i;
        dVar.f16201g = iVar.f16276j;
        dVar.f16203h = iVar.f16278k;
        dVar.i = iVar.f16280l;
        dVar.f16206j = iVar.f16282m;
        dVar.f16208k = iVar.f16284n;
        dVar.f16210l = iVar.f16286o;
        dVar.f16212m = iVar.f16288p;
        dVar.f16214n = iVar.f16289q;
        dVar.f16216o = iVar.f16290r;
        dVar.f16222s = iVar.f16291s;
        dVar.f16223t = iVar.f16292t;
        dVar.f16224u = iVar.f16293u;
        dVar.f16225v = iVar.f16294v;
        ((ViewGroup.MarginLayoutParams) dVar).leftMargin = iVar.F;
        ((ViewGroup.MarginLayoutParams) dVar).rightMargin = iVar.G;
        ((ViewGroup.MarginLayoutParams) dVar).topMargin = iVar.H;
        ((ViewGroup.MarginLayoutParams) dVar).bottomMargin = iVar.I;
        dVar.A = iVar.R;
        dVar.B = iVar.Q;
        dVar.f16227x = iVar.N;
        dVar.f16229z = iVar.P;
        dVar.E = iVar.f16295w;
        dVar.F = iVar.f16296x;
        dVar.f16218p = iVar.f16298z;
        dVar.f16220q = iVar.A;
        dVar.f16221r = iVar.B;
        dVar.G = iVar.f16297y;
        dVar.T = iVar.C;
        dVar.U = iVar.D;
        dVar.I = iVar.T;
        dVar.H = iVar.U;
        dVar.K = iVar.W;
        dVar.J = iVar.V;
        dVar.W = iVar.f16281l0;
        dVar.X = iVar.f16283m0;
        dVar.L = iVar.X;
        dVar.M = iVar.Y;
        dVar.P = iVar.Z;
        dVar.Q = iVar.f16262a0;
        dVar.N = iVar.f16264b0;
        dVar.O = iVar.f16266c0;
        dVar.R = iVar.f16268d0;
        dVar.S = iVar.e0;
        dVar.V = iVar.E;
        dVar.f16195c = iVar.f16270f;
        dVar.f16191a = iVar.f16267d;
        dVar.f16193b = iVar.f16269e;
        ((ViewGroup.MarginLayoutParams) dVar).width = iVar.f16263b;
        ((ViewGroup.MarginLayoutParams) dVar).height = iVar.f16265c;
        String str = iVar.f16279k0;
        if (str != null) {
            dVar.Y = str;
        }
        dVar.Z = iVar.f16287o0;
        dVar.setMarginStart(iVar.K);
        dVar.setMarginEnd(iVar.J);
        dVar.a();
    }

    public final Object clone() {
        h hVar = new h();
        i iVar = hVar.f16257d;
        iVar.getClass();
        i iVar2 = this.f16257d;
        iVar.f16261a = iVar2.f16261a;
        iVar.f16263b = iVar2.f16263b;
        iVar.f16265c = iVar2.f16265c;
        iVar.f16267d = iVar2.f16267d;
        iVar.f16269e = iVar2.f16269e;
        iVar.f16270f = iVar2.f16270f;
        iVar.f16271g = iVar2.f16271g;
        iVar.f16273h = iVar2.f16273h;
        iVar.i = iVar2.i;
        iVar.f16276j = iVar2.f16276j;
        iVar.f16278k = iVar2.f16278k;
        iVar.f16280l = iVar2.f16280l;
        iVar.f16282m = iVar2.f16282m;
        iVar.f16284n = iVar2.f16284n;
        iVar.f16286o = iVar2.f16286o;
        iVar.f16288p = iVar2.f16288p;
        iVar.f16289q = iVar2.f16289q;
        iVar.f16290r = iVar2.f16290r;
        iVar.f16291s = iVar2.f16291s;
        iVar.f16292t = iVar2.f16292t;
        iVar.f16293u = iVar2.f16293u;
        iVar.f16294v = iVar2.f16294v;
        iVar.f16295w = iVar2.f16295w;
        iVar.f16296x = iVar2.f16296x;
        iVar.f16297y = iVar2.f16297y;
        iVar.f16298z = iVar2.f16298z;
        iVar.A = iVar2.A;
        iVar.B = iVar2.B;
        iVar.C = iVar2.C;
        iVar.D = iVar2.D;
        iVar.E = iVar2.E;
        iVar.F = iVar2.F;
        iVar.G = iVar2.G;
        iVar.H = iVar2.H;
        iVar.I = iVar2.I;
        iVar.J = iVar2.J;
        iVar.K = iVar2.K;
        iVar.L = iVar2.L;
        iVar.M = iVar2.M;
        iVar.N = iVar2.N;
        iVar.O = iVar2.O;
        iVar.P = iVar2.P;
        iVar.Q = iVar2.Q;
        iVar.R = iVar2.R;
        iVar.S = iVar2.S;
        iVar.T = iVar2.T;
        iVar.U = iVar2.U;
        iVar.V = iVar2.V;
        iVar.W = iVar2.W;
        iVar.X = iVar2.X;
        iVar.Y = iVar2.Y;
        iVar.Z = iVar2.Z;
        iVar.f16262a0 = iVar2.f16262a0;
        iVar.f16264b0 = iVar2.f16264b0;
        iVar.f16266c0 = iVar2.f16266c0;
        iVar.f16268d0 = iVar2.f16268d0;
        iVar.e0 = iVar2.e0;
        iVar.f0 = iVar2.f0;
        iVar.f16272g0 = iVar2.f16272g0;
        iVar.f16274h0 = iVar2.f16274h0;
        iVar.f16279k0 = iVar2.f16279k0;
        int[] iArr = iVar2.f16275i0;
        if (iArr == null || iVar2.f16277j0 != null) {
            iVar.f16275i0 = null;
        } else {
            iVar.f16275i0 = Arrays.copyOf(iArr, iArr.length);
        }
        iVar.f16277j0 = iVar2.f16277j0;
        iVar.f16281l0 = iVar2.f16281l0;
        iVar.f16283m0 = iVar2.f16283m0;
        iVar.f16285n0 = iVar2.f16285n0;
        iVar.f16287o0 = iVar2.f16287o0;
        j jVar = hVar.f16256c;
        jVar.getClass();
        j jVar2 = this.f16256c;
        jVar2.getClass();
        jVar.f16300a = jVar2.f16300a;
        jVar.f16302c = jVar2.f16302c;
        jVar.f16304e = jVar2.f16304e;
        jVar.f16303d = jVar2.f16303d;
        k kVar = this.f16255b;
        int i = kVar.f16308a;
        k kVar2 = hVar.f16255b;
        kVar2.f16308a = i;
        kVar2.f16310c = kVar.f16310c;
        kVar2.f16311d = kVar.f16311d;
        kVar2.f16309b = kVar.f16309b;
        l lVar = hVar.f16258e;
        lVar.getClass();
        l lVar2 = this.f16258e;
        lVar2.getClass();
        lVar.f16313a = lVar2.f16313a;
        lVar.f16314b = lVar2.f16314b;
        lVar.f16315c = lVar2.f16315c;
        lVar.f16316d = lVar2.f16316d;
        lVar.f16317e = lVar2.f16317e;
        lVar.f16318f = lVar2.f16318f;
        lVar.f16319g = lVar2.f16319g;
        lVar.f16320h = lVar2.f16320h;
        lVar.i = lVar2.i;
        lVar.f16321j = lVar2.f16321j;
        lVar.f16322k = lVar2.f16322k;
        lVar.f16323l = lVar2.f16323l;
        lVar.f16324m = lVar2.f16324m;
        hVar.f16254a = this.f16254a;
        return hVar;
    }
}
