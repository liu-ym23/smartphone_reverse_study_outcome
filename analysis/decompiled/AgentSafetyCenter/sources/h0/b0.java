package h0;

import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import k0.s2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final s2 f4919a = new s2(a0.f4904f);

    /* renamed from: b, reason: collision with root package name */
    public static final s2 f4920b = new s2(a0.f4905g);

    public static final long a(z zVar, long j10) {
        long j11 = zVar.f5244a;
        long j12 = zVar.f5259q;
        if (d1.p.d(j10, j11)) {
            return zVar.f5245b;
        }
        if (d1.p.d(j10, zVar.f5249f)) {
            return zVar.f5250g;
        }
        if (d1.p.d(j10, zVar.f5252j)) {
            return zVar.f5253k;
        }
        if (d1.p.d(j10, zVar.f5256n)) {
            return zVar.f5257o;
        }
        if (d1.p.d(j10, zVar.f5265w)) {
            return zVar.f5266x;
        }
        if (d1.p.d(j10, zVar.f5246c)) {
            return zVar.f5247d;
        }
        if (d1.p.d(j10, zVar.f5251h)) {
            return zVar.i;
        }
        if (d1.p.d(j10, zVar.f5254l)) {
            return zVar.f5255m;
        }
        if (d1.p.d(j10, zVar.f5267y)) {
            return zVar.f5268z;
        }
        if (d1.p.d(j10, zVar.f5263u)) {
            return zVar.f5264v;
        }
        if (d1.p.d(j10, zVar.f5258p)) {
            return j12;
        }
        if (d1.p.d(j10, zVar.f5260r)) {
            return zVar.f5261s;
        }
        if (d1.p.d(j10, zVar.D) || d1.p.d(j10, zVar.F) || d1.p.d(j10, zVar.G) || d1.p.d(j10, zVar.H) || d1.p.d(j10, zVar.I) || d1.p.d(j10, zVar.J)) {
            return j12;
        }
        int i = d1.p.f3025h;
        return d1.p.f3024g;
    }

    public static final long b(long j10, k0.s sVar) {
        sVar.X(-1680936624);
        long jA = a((z) sVar.j(f4919a), j10);
        if (jA == 16) {
            jA = ((d1.p) sVar.j(f0.f4961a)).f3026a;
        }
        sVar.q(false);
        return jA;
    }

    public static z c(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, int i, int i3) {
        return new z(j10, (i & 2) != 0 ? j0.a.f6379j : j11, (i & 4) != 0 ? j0.a.f6389t : j12, (i & 8) != 0 ? j0.a.f6380k : j13, (i & 16) != 0 ? j0.a.f6375e : j14, j15, (i & 64) != 0 ? j0.a.f6381l : j16, (i & 128) != 0 ? j0.a.f6391v : j17, (i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? j0.a.f6382m : j18, j19, (i & 1024) != 0 ? j0.a.f6385p : j20, (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? j0.a.F : j21, (i & 4096) != 0 ? j0.a.f6386q : j22, (i & 8192) != 0 ? j0.a.f6371a : j23, (i & 16384) != 0 ? j0.a.f6377g : j24, (32768 & i) != 0 ? j0.a.f6392w : j25, (65536 & i) != 0 ? j0.a.f6383n : j26, (131072 & i) != 0 ? j0.a.E : j27, (262144 & i) != 0 ? j0.a.f6384o : j28, (524288 & i) != 0 ? j10 : j29, (1048576 & i) != 0 ? j0.a.f6376f : j30, (2097152 & i) != 0 ? j0.a.f6374d : j31, j0.a.f6372b, j0.a.f6378h, j0.a.f6373c, j0.a.i, (67108864 & i) != 0 ? j0.a.f6387r : j32, (134217728 & i) != 0 ? j0.a.f6388s : j33, (268435456 & i) != 0 ? j0.a.f6390u : j34, (536870912 & i) != 0 ? j0.a.f6393x : j35, (i3 & 8) != 0 ? j0.a.D : j41, (1073741824 & i) != 0 ? j0.a.f6394y : j36, (i & Integer.MIN_VALUE) != 0 ? j0.a.f6395z : j37, (i3 & 1) != 0 ? j0.a.A : j38, (i3 & 2) != 0 ? j0.a.B : j39, (i3 & 4) != 0 ? j0.a.C : j40);
    }

    public static final long d(z zVar, int i) {
        switch (s.f.c(i)) {
            case 0:
                return zVar.f5256n;
            case 1:
                return zVar.f5265w;
            case 2:
                return zVar.f5267y;
            case 3:
                return zVar.f5264v;
            case 4:
                return zVar.f5248e;
            case 5:
                return zVar.f5263u;
            case 6:
                return zVar.f5257o;
            case 7:
                return zVar.f5266x;
            case 8:
                return zVar.f5268z;
            case 9:
                return zVar.f5245b;
            case 10:
                return zVar.f5247d;
            case 11:
            case 12:
            case 15:
            case 16:
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
            case 28:
            case 32:
            case 33:
            default:
                return d1.p.f3024g;
            case 13:
                return zVar.f5250g;
            case 14:
                return zVar.i;
            case 17:
                return zVar.f5259q;
            case 18:
                return zVar.f5261s;
            case 19:
                return zVar.f5253k;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return zVar.f5255m;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                return zVar.A;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                return zVar.B;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                return zVar.f5244a;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                return zVar.f5246c;
            case 29:
                return zVar.C;
            case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                return zVar.f5249f;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                return zVar.f5251h;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                return zVar.f5258p;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                return zVar.D;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                return zVar.F;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                return zVar.G;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                return zVar.H;
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                return zVar.I;
            case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                return zVar.J;
            case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                return zVar.E;
            case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                return zVar.f5262t;
            case 43:
                return zVar.f5260r;
            case 44:
                return zVar.f5252j;
            case 45:
                return zVar.f5254l;
        }
    }

    public static final long e(int i, k0.s sVar) {
        return d((z) sVar.j(f4919a), i);
    }

    public static z f(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, int i, int i3) {
        long j42 = (i & 1) != 0 ? j0.b.f6414t : j10;
        return new z(j42, (i & 2) != 0 ? j0.b.f6404j : j11, (i & 4) != 0 ? j0.b.f6415u : j12, (i & 8) != 0 ? j0.b.f6405k : j13, (i & 16) != 0 ? j0.b.f6400e : j14, (i & 32) != 0 ? j0.b.f6417w : j15, (i & 64) != 0 ? j0.b.f6406l : j16, (i & 128) != 0 ? j0.b.f6418x : j17, (i & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? j0.b.f6407m : j18, (i & 512) != 0 ? j0.b.H : j19, (i & 1024) != 0 ? j0.b.f6410p : j20, (i & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? j0.b.I : j21, (i & 4096) != 0 ? j0.b.f6411q : j22, (i & 8192) != 0 ? j0.b.f6396a : j23, (i & 16384) != 0 ? j0.b.f6402g : j24, (32768 & i) != 0 ? j0.b.f6419y : j25, (65536 & i) != 0 ? j0.b.f6408n : j26, (131072 & i) != 0 ? j0.b.G : j27, (262144 & i) != 0 ? j0.b.f6409o : j28, (524288 & i) != 0 ? j42 : j29, (1048576 & i) != 0 ? j0.b.f6401f : j30, (2097152 & i) != 0 ? j0.b.f6399d : j31, j0.b.f6397b, j0.b.f6403h, j0.b.f6398c, j0.b.i, (67108864 & i) != 0 ? j0.b.f6412r : j32, (134217728 & i) != 0 ? j0.b.f6413s : j33, (268435456 & i) != 0 ? j0.b.f6416v : j34, (536870912 & i) != 0 ? j0.b.f6420z : j35, (i3 & 8) != 0 ? j0.b.F : j41, (1073741824 & i) != 0 ? j0.b.A : j36, (i & Integer.MIN_VALUE) != 0 ? j0.b.B : j37, (i3 & 1) != 0 ? j0.b.C : j38, (i3 & 2) != 0 ? j0.b.D : j39, (i3 & 4) != 0 ? j0.b.E : j40);
    }
}
