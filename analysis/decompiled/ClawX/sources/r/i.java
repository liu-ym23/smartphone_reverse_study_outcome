package r;

import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f4978a;

    /* renamed from: b, reason: collision with root package name */
    public final l f4979b;

    /* renamed from: c, reason: collision with root package name */
    public final k f4980c;
    public final j d;

    /* renamed from: e, reason: collision with root package name */
    public final m f4981e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f4982f;

    public i() {
        l lVar = new l();
        lVar.f5029a = 0;
        lVar.f5030b = 0;
        lVar.f5031c = 1.0f;
        lVar.d = Float.NaN;
        this.f4979b = lVar;
        k kVar = new k();
        kVar.f5021a = -1;
        kVar.f5022b = 0;
        kVar.f5023c = -1;
        kVar.d = Float.NaN;
        kVar.f5024e = Float.NaN;
        kVar.f5025f = Float.NaN;
        kVar.f5026g = -1;
        kVar.f5027h = null;
        kVar.f5028i = -1;
        this.f4980c = kVar;
        j jVar = new j();
        jVar.f4984a = false;
        jVar.d = -1;
        jVar.f4991e = -1;
        jVar.f4993f = -1.0f;
        jVar.f4995g = -1;
        jVar.f4997h = -1;
        jVar.f4999i = -1;
        jVar.f5001j = -1;
        jVar.f5003k = -1;
        jVar.f5004l = -1;
        jVar.f5006m = -1;
        jVar.f5008n = -1;
        jVar.f5010o = -1;
        jVar.f5011p = -1;
        jVar.f5012q = -1;
        jVar.f5013r = -1;
        jVar.f5014s = -1;
        jVar.f5015t = -1;
        jVar.f5016u = -1;
        jVar.f5017v = 0.5f;
        jVar.f5018w = 0.5f;
        jVar.f5019x = null;
        jVar.y = -1;
        jVar.z = 0;
        jVar.A = 0.0f;
        jVar.B = -1;
        jVar.C = -1;
        jVar.D = -1;
        jVar.E = 0;
        jVar.F = 0;
        jVar.G = 0;
        jVar.H = 0;
        jVar.I = 0;
        jVar.J = 0;
        jVar.K = 0;
        jVar.L = Integer.MIN_VALUE;
        jVar.M = Integer.MIN_VALUE;
        jVar.N = Integer.MIN_VALUE;
        jVar.O = Integer.MIN_VALUE;
        jVar.P = Integer.MIN_VALUE;
        jVar.Q = Integer.MIN_VALUE;
        jVar.R = Integer.MIN_VALUE;
        jVar.S = -1.0f;
        jVar.T = -1.0f;
        jVar.U = 0;
        jVar.V = 0;
        jVar.W = 0;
        jVar.X = 0;
        jVar.Y = -1;
        jVar.Z = -1;
        jVar.f4985a0 = -1;
        jVar.f4987b0 = -1;
        jVar.f4989c0 = 1.0f;
        jVar.f4990d0 = 1.0f;
        jVar.f4992e0 = -1;
        jVar.f4994f0 = 0;
        jVar.f4996g0 = -1;
        jVar.k0 = false;
        jVar.f5005l0 = false;
        jVar.f5007m0 = true;
        jVar.f5009n0 = 0;
        this.d = jVar;
        m mVar = new m();
        mVar.f5033a = 0.0f;
        mVar.f5034b = 0.0f;
        mVar.f5035c = 0.0f;
        mVar.d = 1.0f;
        mVar.f5036e = 1.0f;
        mVar.f5037f = Float.NaN;
        mVar.f5038g = Float.NaN;
        mVar.f5039h = -1;
        mVar.f5040i = 0.0f;
        mVar.f5041j = 0.0f;
        mVar.f5042k = 0.0f;
        mVar.f5043l = false;
        mVar.f5044m = 0.0f;
        this.f4981e = mVar;
        this.f4982f = new HashMap();
    }

    public final void a(e eVar) {
        j jVar = this.d;
        eVar.d = jVar.f4995g;
        eVar.f4926e = jVar.f4997h;
        eVar.f4928f = jVar.f4999i;
        eVar.f4930g = jVar.f5001j;
        eVar.f4932h = jVar.f5003k;
        eVar.f4934i = jVar.f5004l;
        eVar.f4936j = jVar.f5006m;
        eVar.f4938k = jVar.f5008n;
        eVar.f4939l = jVar.f5010o;
        eVar.f4941m = jVar.f5011p;
        eVar.f4943n = jVar.f5012q;
        eVar.f4949r = jVar.f5013r;
        eVar.f4950s = jVar.f5014s;
        eVar.f4951t = jVar.f5015t;
        eVar.f4952u = jVar.f5016u;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = jVar.E;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = jVar.F;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = jVar.G;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = jVar.H;
        eVar.z = jVar.Q;
        eVar.A = jVar.P;
        eVar.f4954w = jVar.M;
        eVar.y = jVar.O;
        eVar.D = jVar.f5017v;
        eVar.E = jVar.f5018w;
        eVar.f4945o = jVar.y;
        eVar.f4947p = jVar.z;
        eVar.f4948q = jVar.A;
        eVar.F = jVar.f5019x;
        eVar.S = jVar.B;
        eVar.T = jVar.C;
        eVar.H = jVar.S;
        eVar.G = jVar.T;
        eVar.J = jVar.V;
        eVar.I = jVar.U;
        eVar.V = jVar.k0;
        eVar.W = jVar.f5005l0;
        eVar.K = jVar.W;
        eVar.L = jVar.X;
        eVar.O = jVar.Y;
        eVar.P = jVar.Z;
        eVar.M = jVar.f4985a0;
        eVar.N = jVar.f4987b0;
        eVar.Q = jVar.f4989c0;
        eVar.R = jVar.f4990d0;
        eVar.U = jVar.D;
        eVar.f4923c = jVar.f4993f;
        eVar.f4919a = jVar.d;
        eVar.f4921b = jVar.f4991e;
        ((ViewGroup.MarginLayoutParams) eVar).width = jVar.f4986b;
        ((ViewGroup.MarginLayoutParams) eVar).height = jVar.f4988c;
        String str = jVar.f5002j0;
        if (str != null) {
            eVar.X = str;
        }
        eVar.Y = jVar.f5009n0;
        eVar.setMarginStart(jVar.J);
        eVar.setMarginEnd(jVar.I);
        eVar.a();
    }

    public final Object clone() {
        i iVar = new i();
        j jVar = iVar.d;
        jVar.getClass();
        j jVar2 = this.d;
        jVar.f4984a = jVar2.f4984a;
        jVar.f4986b = jVar2.f4986b;
        jVar.f4988c = jVar2.f4988c;
        jVar.d = jVar2.d;
        jVar.f4991e = jVar2.f4991e;
        jVar.f4993f = jVar2.f4993f;
        jVar.f4995g = jVar2.f4995g;
        jVar.f4997h = jVar2.f4997h;
        jVar.f4999i = jVar2.f4999i;
        jVar.f5001j = jVar2.f5001j;
        jVar.f5003k = jVar2.f5003k;
        jVar.f5004l = jVar2.f5004l;
        jVar.f5006m = jVar2.f5006m;
        jVar.f5008n = jVar2.f5008n;
        jVar.f5010o = jVar2.f5010o;
        jVar.f5011p = jVar2.f5011p;
        jVar.f5012q = jVar2.f5012q;
        jVar.f5013r = jVar2.f5013r;
        jVar.f5014s = jVar2.f5014s;
        jVar.f5015t = jVar2.f5015t;
        jVar.f5016u = jVar2.f5016u;
        jVar.f5017v = jVar2.f5017v;
        jVar.f5018w = jVar2.f5018w;
        jVar.f5019x = jVar2.f5019x;
        jVar.y = jVar2.y;
        jVar.z = jVar2.z;
        jVar.A = jVar2.A;
        jVar.B = jVar2.B;
        jVar.C = jVar2.C;
        jVar.D = jVar2.D;
        jVar.E = jVar2.E;
        jVar.F = jVar2.F;
        jVar.G = jVar2.G;
        jVar.H = jVar2.H;
        jVar.I = jVar2.I;
        jVar.J = jVar2.J;
        jVar.K = jVar2.K;
        jVar.L = jVar2.L;
        jVar.M = jVar2.M;
        jVar.N = jVar2.N;
        jVar.O = jVar2.O;
        jVar.P = jVar2.P;
        jVar.Q = jVar2.Q;
        jVar.R = jVar2.R;
        jVar.S = jVar2.S;
        jVar.T = jVar2.T;
        jVar.U = jVar2.U;
        jVar.V = jVar2.V;
        jVar.W = jVar2.W;
        jVar.X = jVar2.X;
        jVar.Y = jVar2.Y;
        jVar.Z = jVar2.Z;
        jVar.f4985a0 = jVar2.f4985a0;
        jVar.f4987b0 = jVar2.f4987b0;
        jVar.f4989c0 = jVar2.f4989c0;
        jVar.f4990d0 = jVar2.f4990d0;
        jVar.f4992e0 = jVar2.f4992e0;
        jVar.f4994f0 = jVar2.f4994f0;
        jVar.f4996g0 = jVar2.f4996g0;
        jVar.f5002j0 = jVar2.f5002j0;
        int[] iArr = jVar2.f4998h0;
        if (iArr != null) {
            jVar.f4998h0 = Arrays.copyOf(iArr, iArr.length);
        } else {
            jVar.f4998h0 = null;
        }
        jVar.f5000i0 = jVar2.f5000i0;
        jVar.k0 = jVar2.k0;
        jVar.f5005l0 = jVar2.f5005l0;
        jVar.f5007m0 = jVar2.f5007m0;
        jVar.f5009n0 = jVar2.f5009n0;
        k kVar = iVar.f4980c;
        kVar.getClass();
        k kVar2 = this.f4980c;
        kVar2.getClass();
        kVar.f5021a = kVar2.f5021a;
        kVar.f5023c = kVar2.f5023c;
        kVar.f5024e = kVar2.f5024e;
        kVar.d = kVar2.d;
        l lVar = this.f4979b;
        int i8 = lVar.f5029a;
        l lVar2 = iVar.f4979b;
        lVar2.f5029a = i8;
        lVar2.f5031c = lVar.f5031c;
        lVar2.d = lVar.d;
        lVar2.f5030b = lVar.f5030b;
        m mVar = iVar.f4981e;
        mVar.getClass();
        m mVar2 = this.f4981e;
        mVar2.getClass();
        mVar.f5033a = mVar2.f5033a;
        mVar.f5034b = mVar2.f5034b;
        mVar.f5035c = mVar2.f5035c;
        mVar.d = mVar2.d;
        mVar.f5036e = mVar2.f5036e;
        mVar.f5037f = mVar2.f5037f;
        mVar.f5038g = mVar2.f5038g;
        mVar.f5039h = mVar2.f5039h;
        mVar.f5040i = mVar2.f5040i;
        mVar.f5041j = mVar2.f5041j;
        mVar.f5042k = mVar2.f5042k;
        mVar.f5043l = mVar2.f5043l;
        mVar.f5044m = mVar2.f5044m;
        iVar.f4978a = this.f4978a;
        return iVar;
    }
}
