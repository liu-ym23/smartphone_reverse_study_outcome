package y;

import android.view.ViewGroup;
import com.stepos.alphame.utils.Property;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f16043a;

    /* renamed from: b, reason: collision with root package name */
    public final l f16044b;

    /* renamed from: c, reason: collision with root package name */
    public final k f16045c;

    /* renamed from: d, reason: collision with root package name */
    public final j f16046d;

    /* renamed from: e, reason: collision with root package name */
    public final m f16047e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f16048f;

    public i() {
        l lVar = new l();
        lVar.f16126a = 0;
        lVar.f16127b = 0;
        lVar.f16128c = 1.0f;
        lVar.f16129d = Float.NaN;
        this.f16044b = lVar;
        k kVar = new k();
        kVar.f16117a = -1;
        kVar.f16118b = 0;
        kVar.f16119c = -1;
        kVar.f16120d = Float.NaN;
        kVar.f16121e = Float.NaN;
        kVar.f16122f = Float.NaN;
        kVar.f16123g = -1;
        kVar.f16124h = null;
        kVar.f16125i = -1;
        this.f16045c = kVar;
        j jVar = new j();
        jVar.f16075a = false;
        jVar.f16081d = -1;
        jVar.f16083e = -1;
        jVar.f16085f = -1.0f;
        jVar.f16087g = true;
        jVar.f16089h = -1;
        jVar.f16091i = -1;
        jVar.f16093j = -1;
        jVar.f16095k = -1;
        jVar.f16097l = -1;
        jVar.f16099m = -1;
        jVar.f16101n = -1;
        jVar.f16103o = -1;
        jVar.f16105p = -1;
        jVar.f16106q = -1;
        jVar.f16107r = -1;
        jVar.f16108s = -1;
        jVar.f16109t = -1;
        jVar.f16110u = -1;
        jVar.f16111v = -1;
        jVar.f16112w = 0.5f;
        jVar.f16113x = 0.5f;
        jVar.f16114y = null;
        jVar.f16115z = -1;
        jVar.f16050A = 0;
        jVar.f16051B = Property.DEFAULT_FLOAT_VALUE;
        jVar.f16052C = -1;
        jVar.f16053D = -1;
        jVar.f16054E = -1;
        jVar.f16055F = 0;
        jVar.f16056G = 0;
        jVar.f16057H = 0;
        jVar.f16058I = 0;
        jVar.f16059J = 0;
        jVar.f16060K = 0;
        jVar.f16061L = 0;
        jVar.f16062M = Integer.MIN_VALUE;
        jVar.f16063N = Integer.MIN_VALUE;
        jVar.f16064O = Integer.MIN_VALUE;
        jVar.f16065P = Integer.MIN_VALUE;
        jVar.f16066Q = Integer.MIN_VALUE;
        jVar.f16067R = Integer.MIN_VALUE;
        jVar.f16068S = Integer.MIN_VALUE;
        jVar.T = -1.0f;
        jVar.f16069U = -1.0f;
        jVar.f16070V = 0;
        jVar.f16071W = 0;
        jVar.f16072X = 0;
        jVar.f16073Y = 0;
        jVar.f16074Z = 0;
        jVar.f16076a0 = 0;
        jVar.f16078b0 = 0;
        jVar.f16080c0 = 0;
        jVar.f16082d0 = 1.0f;
        jVar.f16084e0 = 1.0f;
        jVar.f16086f0 = -1;
        jVar.f16088g0 = 0;
        jVar.f16090h0 = -1;
        jVar.f16098l0 = false;
        jVar.f16100m0 = false;
        jVar.f16102n0 = true;
        jVar.f16104o0 = 0;
        this.f16046d = jVar;
        m mVar = new m();
        mVar.f16131a = Property.DEFAULT_FLOAT_VALUE;
        mVar.f16132b = Property.DEFAULT_FLOAT_VALUE;
        mVar.f16133c = Property.DEFAULT_FLOAT_VALUE;
        mVar.f16134d = 1.0f;
        mVar.f16135e = 1.0f;
        mVar.f16136f = Float.NaN;
        mVar.f16137g = Float.NaN;
        mVar.f16138h = -1;
        mVar.f16139i = Property.DEFAULT_FLOAT_VALUE;
        mVar.f16140j = Property.DEFAULT_FLOAT_VALUE;
        mVar.f16141k = Property.DEFAULT_FLOAT_VALUE;
        mVar.f16142l = false;
        mVar.f16143m = Property.DEFAULT_FLOAT_VALUE;
        this.f16047e = mVar;
        this.f16048f = new HashMap();
    }

    public final void a(e eVar) {
        j jVar = this.f16046d;
        eVar.f15986e = jVar.f16089h;
        eVar.f15988f = jVar.f16091i;
        eVar.f15990g = jVar.f16093j;
        eVar.f15992h = jVar.f16095k;
        eVar.f15994i = jVar.f16097l;
        eVar.f15996j = jVar.f16099m;
        eVar.f15998k = jVar.f16101n;
        eVar.f16000l = jVar.f16103o;
        eVar.f16002m = jVar.f16105p;
        eVar.f16004n = jVar.f16106q;
        eVar.f16006o = jVar.f16107r;
        eVar.f16012s = jVar.f16108s;
        eVar.f16013t = jVar.f16109t;
        eVar.f16014u = jVar.f16110u;
        eVar.f16015v = jVar.f16111v;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = jVar.f16055F;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = jVar.f16056G;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = jVar.f16057H;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = jVar.f16058I;
        eVar.f15953A = jVar.f16067R;
        eVar.f15954B = jVar.f16066Q;
        eVar.f16017x = jVar.f16063N;
        eVar.f16019z = jVar.f16065P;
        eVar.f15957E = jVar.f16112w;
        eVar.f15958F = jVar.f16113x;
        eVar.f16008p = jVar.f16115z;
        eVar.f16010q = jVar.f16050A;
        eVar.f16011r = jVar.f16051B;
        eVar.f15959G = jVar.f16114y;
        eVar.T = jVar.f16052C;
        eVar.f15972U = jVar.f16053D;
        eVar.f15961I = jVar.T;
        eVar.f15960H = jVar.f16069U;
        eVar.f15963K = jVar.f16071W;
        eVar.f15962J = jVar.f16070V;
        eVar.f15974W = jVar.f16098l0;
        eVar.f15975X = jVar.f16100m0;
        eVar.f15964L = jVar.f16072X;
        eVar.f15965M = jVar.f16073Y;
        eVar.f15968P = jVar.f16074Z;
        eVar.f15969Q = jVar.f16076a0;
        eVar.f15966N = jVar.f16078b0;
        eVar.f15967O = jVar.f16080c0;
        eVar.f15970R = jVar.f16082d0;
        eVar.f15971S = jVar.f16084e0;
        eVar.f15973V = jVar.f16054E;
        eVar.f15982c = jVar.f16085f;
        eVar.f15978a = jVar.f16081d;
        eVar.f15980b = jVar.f16083e;
        ((ViewGroup.MarginLayoutParams) eVar).width = jVar.f16077b;
        ((ViewGroup.MarginLayoutParams) eVar).height = jVar.f16079c;
        String str = jVar.f16096k0;
        if (str != null) {
            eVar.f15976Y = str;
        }
        eVar.f15977Z = jVar.f16104o0;
        eVar.setMarginStart(jVar.f16060K);
        eVar.setMarginEnd(jVar.f16059J);
        eVar.a();
    }

    public final Object clone() {
        i iVar = new i();
        j jVar = iVar.f16046d;
        jVar.getClass();
        j jVar2 = this.f16046d;
        jVar.f16075a = jVar2.f16075a;
        jVar.f16077b = jVar2.f16077b;
        jVar.f16079c = jVar2.f16079c;
        jVar.f16081d = jVar2.f16081d;
        jVar.f16083e = jVar2.f16083e;
        jVar.f16085f = jVar2.f16085f;
        jVar.f16087g = jVar2.f16087g;
        jVar.f16089h = jVar2.f16089h;
        jVar.f16091i = jVar2.f16091i;
        jVar.f16093j = jVar2.f16093j;
        jVar.f16095k = jVar2.f16095k;
        jVar.f16097l = jVar2.f16097l;
        jVar.f16099m = jVar2.f16099m;
        jVar.f16101n = jVar2.f16101n;
        jVar.f16103o = jVar2.f16103o;
        jVar.f16105p = jVar2.f16105p;
        jVar.f16106q = jVar2.f16106q;
        jVar.f16107r = jVar2.f16107r;
        jVar.f16108s = jVar2.f16108s;
        jVar.f16109t = jVar2.f16109t;
        jVar.f16110u = jVar2.f16110u;
        jVar.f16111v = jVar2.f16111v;
        jVar.f16112w = jVar2.f16112w;
        jVar.f16113x = jVar2.f16113x;
        jVar.f16114y = jVar2.f16114y;
        jVar.f16115z = jVar2.f16115z;
        jVar.f16050A = jVar2.f16050A;
        jVar.f16051B = jVar2.f16051B;
        jVar.f16052C = jVar2.f16052C;
        jVar.f16053D = jVar2.f16053D;
        jVar.f16054E = jVar2.f16054E;
        jVar.f16055F = jVar2.f16055F;
        jVar.f16056G = jVar2.f16056G;
        jVar.f16057H = jVar2.f16057H;
        jVar.f16058I = jVar2.f16058I;
        jVar.f16059J = jVar2.f16059J;
        jVar.f16060K = jVar2.f16060K;
        jVar.f16061L = jVar2.f16061L;
        jVar.f16062M = jVar2.f16062M;
        jVar.f16063N = jVar2.f16063N;
        jVar.f16064O = jVar2.f16064O;
        jVar.f16065P = jVar2.f16065P;
        jVar.f16066Q = jVar2.f16066Q;
        jVar.f16067R = jVar2.f16067R;
        jVar.f16068S = jVar2.f16068S;
        jVar.T = jVar2.T;
        jVar.f16069U = jVar2.f16069U;
        jVar.f16070V = jVar2.f16070V;
        jVar.f16071W = jVar2.f16071W;
        jVar.f16072X = jVar2.f16072X;
        jVar.f16073Y = jVar2.f16073Y;
        jVar.f16074Z = jVar2.f16074Z;
        jVar.f16076a0 = jVar2.f16076a0;
        jVar.f16078b0 = jVar2.f16078b0;
        jVar.f16080c0 = jVar2.f16080c0;
        jVar.f16082d0 = jVar2.f16082d0;
        jVar.f16084e0 = jVar2.f16084e0;
        jVar.f16086f0 = jVar2.f16086f0;
        jVar.f16088g0 = jVar2.f16088g0;
        jVar.f16090h0 = jVar2.f16090h0;
        jVar.f16096k0 = jVar2.f16096k0;
        int[] iArr = jVar2.f16092i0;
        if (iArr == null || jVar2.f16094j0 != null) {
            jVar.f16092i0 = null;
        } else {
            jVar.f16092i0 = Arrays.copyOf(iArr, iArr.length);
        }
        jVar.f16094j0 = jVar2.f16094j0;
        jVar.f16098l0 = jVar2.f16098l0;
        jVar.f16100m0 = jVar2.f16100m0;
        jVar.f16102n0 = jVar2.f16102n0;
        jVar.f16104o0 = jVar2.f16104o0;
        k kVar = iVar.f16045c;
        kVar.getClass();
        k kVar2 = this.f16045c;
        kVar2.getClass();
        kVar.f16117a = kVar2.f16117a;
        kVar.f16119c = kVar2.f16119c;
        kVar.f16121e = kVar2.f16121e;
        kVar.f16120d = kVar2.f16120d;
        l lVar = iVar.f16044b;
        lVar.getClass();
        l lVar2 = this.f16044b;
        lVar2.getClass();
        lVar.f16126a = lVar2.f16126a;
        lVar.f16128c = lVar2.f16128c;
        lVar.f16129d = lVar2.f16129d;
        lVar.f16127b = lVar2.f16127b;
        m mVar = iVar.f16047e;
        mVar.getClass();
        m mVar2 = this.f16047e;
        mVar2.getClass();
        mVar.f16131a = mVar2.f16131a;
        mVar.f16132b = mVar2.f16132b;
        mVar.f16133c = mVar2.f16133c;
        mVar.f16134d = mVar2.f16134d;
        mVar.f16135e = mVar2.f16135e;
        mVar.f16136f = mVar2.f16136f;
        mVar.f16137g = mVar2.f16137g;
        mVar.f16138h = mVar2.f16138h;
        mVar.f16139i = mVar2.f16139i;
        mVar.f16140j = mVar2.f16140j;
        mVar.f16141k = mVar2.f16141k;
        mVar.f16142l = mVar2.f16142l;
        mVar.f16143m = mVar2.f16143m;
        iVar.f16043a = this.f16043a;
        return iVar;
    }
}
