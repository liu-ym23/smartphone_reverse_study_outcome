package v7;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f6008a = {83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, 110, 111, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f6009b = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6010c = {1886001095, 1339575613, 1980447930, 258412557, -95215574, -959694548, 2013120334, 2047061138};
    public static final int[] d = {-1886001114, -1339575614, -1980447931, -258412558, 95215573, 959694547, -2013120335, 100422509};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6011e = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f6012f = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f6013g = {12052516, 1174424, 4087752, 38672185, 20040971, 21899680, 55468344, 20105554, 66708015, 9981791};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f6014h = {66430571, 45040722, 4842939, 15895846, 18981244, 46308410, 4697481, 8903007, 53646190, 12474675};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f6015i = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f6016j = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f6017k = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};

    /* renamed from: l, reason: collision with root package name */
    public static final Object f6018l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public static d[] f6019m = null;

    /* renamed from: n, reason: collision with root package name */
    public static d[] f6020n = null;

    /* renamed from: o, reason: collision with root package name */
    public static int[] f6021o = null;

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f6022p = {83, 105, 103, 69, 100, 52, 52, 56};

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f6023q = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f6024r = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f6025s = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f6026t = {110141154, 30892124, 160820362, 264558960, 217232225, 47722141, 19029845, 8326902, 183409749, 170134547, 90340180, 222600478, 61097333, 7431335, 198491505, 102372861};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f6027u = {221945828, 50763449, 132637478, 109250759, 216053960, 61612587, 50649998, 138339097, 98949899, 248139835, 186410297, 126520782, 47339196, 78164062, 198835543, 169622712};

    /* renamed from: v, reason: collision with root package name */
    public static final Object f6028v = new Object();

    /* renamed from: w, reason: collision with root package name */
    public static b[] f6029w = null;

    /* renamed from: x, reason: collision with root package name */
    public static b[] f6030x = null;
    public static int[] y = null;
    public static final int[] z = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};
    public static final int[] A = {-1424848535, -487721339, 580428573, 1745064566, -770181698, 1036971123, 461123738, -1582065343, 1268693629, -889041821, -731974758, 43769659, 0, 0, 0, 16777216};
    public static final int[] B = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
    public static final int[] C = {463601321, -1045562440, 1239460018, -1189350089, -412821483, 1160071467, -1564970643, 1256291574, -1170454588, -240530412, 2118977290, -1845154869, -1618855054, -1019204973, 1437344377, -1849925303, 1189267370, 280387897, -680846520, -500732508, -1100672524, -1, -1, -1, -1, -1, -1, 268435455};

    public static void A(c[] cVarArr) {
        int length = cVarArr.length;
        int[] iArr = new int[length * 10];
        int[] iArr2 = new int[10];
        u7.a.j(0, 0, cVarArr[0].f6003c, iArr2);
        u7.a.j(0, 0, iArr2, iArr);
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            if (i9 >= length) {
                break;
            }
            u7.a.E(iArr2, cVarArr[i9].f6003c, iArr2);
            u7.a.j(0, i9 * 10, iArr2, iArr);
            i8 = i9;
        }
        u7.a.a(iArr2, iArr2, iArr2);
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[8];
        u7.a.j(0, 0, iArr2, iArr3);
        u7.a.H(iArr3);
        u7.a.t(0, 0, iArr3, iArr4);
        u7.a.t(5, 4, iArr3, iArr4);
        x.f.q0(u7.a.f5783a, iArr4, iArr4);
        u7.a.n(0, 0, iArr4, iArr2);
        u7.a.n(4, 5, iArr4, iArr2);
        iArr2[9] = iArr2[9] & 16777215;
        int[] iArr5 = new int[10];
        while (i8 > 0) {
            int i10 = i8 - 1;
            u7.a.j(i10 * 10, 0, iArr, iArr5);
            u7.a.E(iArr5, iArr2, iArr5);
            u7.a.E(iArr2, cVarArr[i8].f6003c, iArr2);
            u7.a.j(0, 0, iArr5, cVarArr[i8].f6003c);
            i8 = i10;
        }
        u7.a.j(0, 0, iArr2, cVarArr[0].f6003c);
    }

    public static void B(d[] dVarArr) {
        int length = dVarArr.length;
        int[] iArr = new int[length * 16];
        int[] iArr2 = new int[16];
        u7.a.k(0, 0, dVarArr[0].f6006c, iArr2);
        u7.a.k(0, 0, iArr2, iArr);
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            if (i9 >= length) {
                break;
            }
            u7.a.F(iArr2, dVarArr[i9].f6006c, iArr2);
            u7.a.k(0, i9 * 16, iArr2, iArr);
            i8 = i9;
        }
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[14];
        u7.a.k(0, 0, iArr2, iArr3);
        u7.a.K(1, iArr3);
        u7.a.K(-1, iArr3);
        u7.a.v(0, 0, iArr3, iArr4);
        u7.a.v(8, 7, iArr3, iArr4);
        x.f.q0(u7.a.f5785c, iArr4, iArr4);
        u7.a.p(0, 0, iArr4, iArr2);
        u7.a.p(7, 8, iArr4, iArr2);
        int[] iArr5 = new int[16];
        while (i8 > 0) {
            int i10 = i8 - 1;
            u7.a.k(i10 * 16, 0, iArr, iArr5);
            u7.a.F(iArr5, iArr2, iArr5);
            u7.a.F(iArr2, dVarArr[i8].f6006c, iArr2);
            u7.a.k(0, 0, iArr5, dVarArr[i8].f6006c);
            i8 = i10;
        }
        u7.a.k(0, 0, iArr2, dVarArr[0].f6006c);
    }

    public static void C(c cVar, c cVar2, c cVar3, b bVar) {
        int[] iArr = cVar3.f6001a;
        int[] iArr2 = cVar3.f6002b;
        int[] iArr3 = bVar.f5999a;
        int[] iArr4 = bVar.f6000b;
        u7.a.c(cVar.f6002b, cVar.f6001a, iArr2, iArr);
        u7.a.c(cVar2.f6002b, cVar2.f6001a, iArr4, iArr3);
        u7.a.E(iArr, iArr3, iArr);
        u7.a.E(iArr2, iArr4, iArr2);
        u7.a.E(cVar.d, cVar2.d, iArr3);
        u7.a.E(iArr3, f6016j, iArr3);
        int[] iArr5 = cVar.f6003c;
        u7.a.a(iArr5, iArr5, iArr4);
        u7.a.E(iArr4, cVar2.f6003c, iArr4);
        u7.a.c(iArr2, iArr, iArr2, iArr);
        u7.a.c(iArr4, iArr3, iArr4, iArr3);
        u7.a.E(iArr, iArr2, cVar3.d);
        u7.a.E(iArr3, iArr4, cVar3.f6003c);
        u7.a.E(iArr, iArr3, iArr);
        u7.a.E(iArr2, iArr4, iArr2);
    }

    public static void D(d dVar, d dVar2, g gVar) {
        int[] iArr = gVar.f6031a;
        int[] iArr2 = gVar.f6032b;
        int[] iArr3 = gVar.f6033c;
        int[] iArr4 = gVar.d;
        int[] iArr5 = gVar.f6034e;
        int[] iArr6 = gVar.f6035f;
        int[] iArr7 = gVar.f6036g;
        int[] iArr8 = gVar.f6037h;
        u7.a.F(dVar.f6006c, dVar2.f6006c, iArr);
        u7.a.O(iArr, iArr2);
        int[] iArr9 = dVar.f6004a;
        int[] iArr10 = dVar2.f6004a;
        u7.a.F(iArr9, iArr10, iArr3);
        int[] iArr11 = dVar.f6005b;
        int[] iArr12 = dVar2.f6005b;
        u7.a.F(iArr11, iArr12, iArr4);
        u7.a.F(iArr3, iArr4, iArr5);
        u7.a.C(39081, iArr5, iArr5);
        u7.a.b(iArr2, iArr5, iArr6);
        u7.a.Q(iArr2, iArr5, iArr7);
        u7.a.b(iArr11, iArr9, iArr8);
        u7.a.b(iArr12, iArr10, iArr5);
        u7.a.F(iArr8, iArr5, iArr8);
        u7.a.b(iArr4, iArr3, iArr2);
        u7.a.Q(iArr4, iArr3, iArr5);
        u7.a.d(iArr2);
        u7.a.Q(iArr8, iArr2, iArr8);
        u7.a.F(iArr8, iArr, iArr8);
        u7.a.F(iArr5, iArr, iArr5);
        u7.a.F(iArr6, iArr8, iArr10);
        u7.a.F(iArr5, iArr7, iArr12);
        u7.a.F(iArr6, iArr7, dVar2.f6006c);
    }

    public static void E(boolean z2, b bVar, d dVar, g gVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5 = gVar.f6032b;
        int[] iArr6 = gVar.f6033c;
        int[] iArr7 = gVar.d;
        int[] iArr8 = gVar.f6034e;
        int[] iArr9 = gVar.f6035f;
        int[] iArr10 = gVar.f6036g;
        int[] iArr11 = gVar.f6037h;
        if (z2) {
            u7.a.Q(bVar.f6000b, bVar.f5999a, iArr11);
            iArr2 = iArr5;
            iArr = iArr8;
            iArr4 = iArr9;
            iArr3 = iArr10;
        } else {
            u7.a.b(bVar.f6000b, bVar.f5999a, iArr11);
            iArr = iArr5;
            iArr2 = iArr8;
            iArr3 = iArr9;
            iArr4 = iArr10;
        }
        int[] iArr12 = dVar.f6006c;
        int[] iArr13 = dVar.f6005b;
        int[] iArr14 = dVar.f6004a;
        u7.a.O(iArr12, iArr5);
        u7.a.F(bVar.f5999a, iArr14, iArr6);
        u7.a.F(bVar.f6000b, iArr13, iArr7);
        u7.a.F(iArr6, iArr7, iArr8);
        u7.a.C(39081, iArr8, iArr8);
        u7.a.b(iArr5, iArr8, iArr3);
        u7.a.Q(iArr5, iArr8, iArr4);
        u7.a.b(iArr13, iArr14, iArr8);
        u7.a.F(iArr11, iArr8, iArr11);
        u7.a.b(iArr7, iArr6, iArr);
        u7.a.Q(iArr7, iArr6, iArr2);
        u7.a.d(iArr);
        u7.a.Q(iArr11, iArr5, iArr11);
        u7.a.F(iArr11, iArr12, iArr11);
        u7.a.F(iArr8, iArr12, iArr8);
        u7.a.F(iArr9, iArr11, iArr14);
        u7.a.F(iArr8, iArr10, iArr13);
        u7.a.F(iArr9, iArr10, iArr12);
    }

    public static void F(boolean z2, c cVar, a aVar, b bVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3 = aVar.f5995a;
        int[] iArr4 = aVar.f5996b;
        int[] iArr5 = bVar.f5999a;
        int[] iArr6 = aVar.f5997c;
        int[] iArr7 = aVar.d;
        int[] iArr8 = aVar.f5998e;
        if (z2) {
            iArr2 = iArr3;
            iArr = iArr4;
        } else {
            iArr = iArr3;
            iArr2 = iArr4;
        }
        u7.a.c(iArr4, iArr3, iArr4, iArr3);
        u7.a.E(iArr, cVar.f6001a, iArr);
        u7.a.E(iArr2, cVar.f6002b, iArr2);
        u7.a.E(iArr7, iArr8, iArr5);
        u7.a.E(iArr5, cVar.f6003c, iArr5);
        u7.a.E(iArr6, cVar.d, iArr6);
        u7.a.c(iArr4, iArr3, iArr8, iArr7);
        u7.a.c(iArr6, iArr5, iArr2, iArr);
        u7.a.E(iArr3, iArr4, iArr6);
        u7.a.E(iArr3, iArr7, iArr3);
        u7.a.E(iArr4, iArr8, iArr4);
    }

    public static void G(boolean z2, d dVar, a aVar, b bVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3 = aVar.f5995a;
        int[] iArr4 = aVar.f5997c;
        int[] iArr5 = aVar.f5996b;
        int[] iArr6 = bVar.f5999a;
        int[] iArr7 = aVar.d;
        int[] iArr8 = aVar.f5998e;
        if (z2) {
            iArr2 = iArr3;
            iArr = iArr5;
        } else {
            iArr = iArr3;
            iArr2 = iArr5;
        }
        u7.a.c(iArr5, iArr3, iArr5, iArr3);
        u7.a.E(iArr, dVar.f6004a, iArr);
        u7.a.E(iArr2, dVar.f6005b, iArr2);
        u7.a.E(iArr7, iArr8, iArr6);
        u7.a.E(iArr6, dVar.f6006c, iArr6);
        u7.a.c(iArr5, iArr3, iArr8, iArr7);
        u7.a.c(iArr4, iArr6, iArr2, iArr);
        u7.a.E(iArr3, iArr5, iArr4);
        u7.a.E(iArr3, iArr7, iArr3);
        u7.a.E(iArr5, iArr8, iArr5);
    }

    public static void H(boolean z2, d dVar, d dVar2, g gVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5 = dVar2.f6006c;
        int[] iArr6 = gVar.f6031a;
        int[] iArr7 = gVar.f6032b;
        int[] iArr8 = gVar.f6033c;
        int[] iArr9 = gVar.d;
        int[] iArr10 = gVar.f6034e;
        int[] iArr11 = gVar.f6035f;
        int[] iArr12 = gVar.f6036g;
        int[] iArr13 = gVar.f6037h;
        int[] iArr14 = dVar.f6005b;
        int[] iArr15 = dVar.f6004a;
        if (z2) {
            u7.a.Q(iArr14, iArr15, iArr13);
            iArr2 = iArr7;
            iArr = iArr10;
            iArr4 = iArr11;
            iArr3 = iArr12;
        } else {
            u7.a.b(iArr14, iArr15, iArr13);
            iArr = iArr7;
            iArr2 = iArr10;
            iArr3 = iArr11;
            iArr4 = iArr12;
        }
        int[] iArr16 = dVar.f6006c;
        int[] iArr17 = dVar2.f6005b;
        int[] iArr18 = dVar2.f6004a;
        u7.a.F(iArr16, iArr5, iArr6);
        u7.a.O(iArr6, iArr7);
        u7.a.F(dVar.f6004a, iArr18, iArr8);
        u7.a.F(dVar.f6005b, iArr17, iArr9);
        u7.a.F(iArr8, iArr9, iArr10);
        u7.a.C(39081, iArr10, iArr10);
        u7.a.b(iArr7, iArr10, iArr3);
        u7.a.Q(iArr7, iArr10, iArr4);
        u7.a.b(iArr17, iArr18, iArr10);
        u7.a.F(iArr13, iArr10, iArr13);
        u7.a.b(iArr9, iArr8, iArr);
        u7.a.Q(iArr9, iArr8, iArr2);
        u7.a.d(iArr);
        u7.a.Q(iArr13, iArr7, iArr13);
        u7.a.F(iArr13, iArr6, iArr13);
        u7.a.F(iArr10, iArr6, iArr10);
        u7.a.F(iArr11, iArr13, iArr18);
        u7.a.F(iArr10, iArr12, iArr17);
        u7.a.F(iArr11, iArr12, iArr5);
    }

    public static void I(a aVar, c cVar) {
        u7.a.j(0, 0, aVar.f5995a, cVar.f6001a);
        u7.a.j(0, 0, aVar.f5996b, cVar.f6002b);
        u7.a.j(0, 0, aVar.f5997c, cVar.f6003c);
        u7.a.E(aVar.d, aVar.f5998e, cVar.d);
    }

    public static void J(b bVar, d dVar) {
        u7.a.k(0, 0, bVar.f5999a, dVar.f6004a);
        u7.a.k(0, 0, bVar.f6000b, dVar.f6005b);
        int[] iArr = dVar.f6006c;
        iArr[0] = 1;
        for (int i8 = 1; i8 < 16; i8++) {
            iArr[i8] = 0;
        }
    }

    public static void K(d dVar, d dVar2) {
        u7.a.k(0, 0, dVar.f6004a, dVar2.f6004a);
        u7.a.k(0, 0, dVar.f6005b, dVar2.f6005b);
        u7.a.k(0, 0, dVar.f6006c, dVar2.f6006c);
    }

    public static void L(a aVar) {
        int[] iArr = aVar.f5995a;
        int[] iArr2 = aVar.f5996b;
        int[] iArr3 = aVar.f5997c;
        int[] iArr4 = aVar.d;
        int[] iArr5 = aVar.f5998e;
        u7.a.a(iArr, iArr2, iArr4);
        u7.a.M(iArr, iArr);
        u7.a.M(iArr2, iArr2);
        u7.a.M(iArr3, iArr3);
        u7.a.a(iArr3, iArr3, iArr3);
        u7.a.c(iArr, iArr2, iArr5, iArr2);
        u7.a.M(iArr4, iArr4);
        u7.a.P(iArr5, iArr4, iArr4);
        u7.a.a(iArr3, iArr2, iArr);
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = iArr[2];
        int i11 = iArr[3];
        int i12 = iArr[4];
        int i13 = iArr[5];
        int i14 = iArr[6];
        int i15 = iArr[7];
        int i16 = iArr[8];
        int i17 = i10 + (i9 >> 26);
        int i18 = i12 + (i11 >> 26);
        int i19 = i15 + (i14 >> 26);
        int i20 = iArr[9] + (i16 >> 26);
        int i21 = (i11 & 67108863) + (i17 >> 25);
        int i22 = i13 + (i18 >> 25);
        int i23 = (i16 & 67108863) + (i19 >> 25);
        int i24 = ((i20 >> 25) * 38) + i8;
        int i25 = (i9 & 67108863) + (i24 >> 26);
        int i26 = (i14 & 67108863) + (i22 >> 26);
        iArr[0] = i24 & 67108863;
        iArr[1] = i25 & 67108863;
        iArr[2] = (i17 & 33554431) + (i25 >> 26);
        iArr[3] = i21 & 67108863;
        iArr[4] = (i18 & 33554431) + (i21 >> 26);
        iArr[5] = i22 & 67108863;
        iArr[6] = i26 & 67108863;
        iArr[7] = (i19 & 33554431) + (i26 >> 26);
        iArr[8] = i23 & 67108863;
        iArr[9] = (i20 & 33554431) + (i23 >> 26);
        u7.a.E(iArr, iArr2, iArr3);
        u7.a.E(iArr, iArr4, iArr);
        u7.a.E(iArr2, iArr5, iArr2);
    }

    public static void M(d dVar, g gVar) {
        int[] iArr = gVar.f6032b;
        int[] iArr2 = gVar.f6033c;
        int[] iArr3 = gVar.d;
        int[] iArr4 = gVar.f6034e;
        int[] iArr5 = gVar.f6037h;
        int[] iArr6 = gVar.f6031a;
        int[] iArr7 = dVar.f6004a;
        int[] iArr8 = dVar.f6005b;
        u7.a.b(iArr7, iArr8, iArr);
        u7.a.O(iArr, iArr);
        u7.a.O(iArr7, iArr2);
        u7.a.O(iArr8, iArr3);
        u7.a.b(iArr2, iArr3, iArr4);
        u7.a.d(iArr4);
        int[] iArr9 = dVar.f6006c;
        u7.a.O(iArr9, iArr5);
        u7.a.b(iArr5, iArr5, iArr5);
        u7.a.d(iArr5);
        u7.a.Q(iArr4, iArr5, iArr6);
        u7.a.Q(iArr, iArr4, iArr);
        u7.a.Q(iArr2, iArr3, iArr2);
        u7.a.F(iArr, iArr6, iArr7);
        u7.a.F(iArr4, iArr2, iArr8);
        u7.a.F(iArr4, iArr6, iArr9);
    }

    public static void N(b bVar, d[] dVarArr, int i8, int i9, g gVar) {
        d dVar = new d(1);
        J(bVar, dVar);
        M(dVar, gVar);
        d dVar2 = new d(1);
        dVarArr[i8] = dVar2;
        J(bVar, dVar2);
        for (int i10 = 1; i10 < i9; i10++) {
            int i11 = i8 + i10;
            d dVar3 = new d(1);
            dVarArr[i11] = dVar3;
            K(dVarArr[i11 - 1], dVar3);
            D(dVar, dVarArr[i11], gVar);
        }
    }

    public static void O(b bVar, c[] cVarArr, b bVar2) {
        c cVar = new c();
        int[] iArr = bVar.f5999a;
        int i8 = 0;
        u7.a.j(0, 0, iArr, cVar.f6001a);
        int[] iArr2 = bVar.f6000b;
        u7.a.j(0, 0, iArr2, cVar.f6002b);
        u7.a.I(cVar.f6003c);
        u7.a.E(iArr, iArr2, cVar.d);
        c cVar2 = new c();
        C(cVar, cVar, cVar2, bVar2);
        while (true) {
            c cVar3 = new c();
            int[] iArr3 = new int[10];
            cVar3.f6001a = iArr3;
            int[] iArr4 = new int[10];
            cVar3.f6002b = iArr4;
            int[] iArr5 = new int[10];
            cVar3.f6003c = iArr5;
            int[] iArr6 = new int[10];
            cVar3.d = iArr6;
            cVarArr[i8] = cVar3;
            u7.a.c(cVar.f6002b, cVar.f6001a, iArr4, iArr3);
            u7.a.E(cVar.d, f6016j, iArr5);
            int[] iArr7 = cVar.f6003c;
            u7.a.a(iArr7, iArr7, iArr6);
            i8++;
            if (i8 == 4) {
                return;
            } else {
                C(cVar, cVar2, cVar, bVar2);
            }
        }
    }

    public static void P() {
        synchronized (f6018l) {
            try {
                if (f6021o != null) {
                    return;
                }
                c[] cVarArr = new c[96];
                b bVar = new b(1);
                int[] iArr = new int[10];
                int[] iArr2 = new int[10];
                int[] iArr3 = f6011e;
                int i8 = 0;
                u7.a.j(0, 0, iArr3, iArr);
                int[] iArr4 = f6012f;
                u7.a.j(0, 0, iArr4, iArr2);
                c cVar = new c();
                cVarArr[0] = cVar;
                u7.a.j(0, 0, iArr, cVar.f6001a);
                u7.a.j(0, 0, iArr2, cVar.f6002b);
                u7.a.I(cVar.f6003c);
                u7.a.E(iArr, iArr2, cVar.d);
                c cVar2 = new c();
                c cVar3 = cVarArr[0];
                C(cVar3, cVar3, cVar2, bVar);
                for (int i9 = 1; i9 < 16; i9++) {
                    int i10 = 0 + i9;
                    c cVar4 = cVarArr[i10 - 1];
                    c cVar5 = new c();
                    cVarArr[i10] = cVar5;
                    C(cVar4, cVar2, cVar5, bVar);
                }
                int[] iArr5 = new int[10];
                int[] iArr6 = new int[10];
                u7.a.j(0, 0, f6013g, iArr5);
                u7.a.j(0, 0, f6014h, iArr6);
                c cVar6 = new c();
                cVarArr[16] = cVar6;
                u7.a.j(0, 0, iArr5, cVar6.f6001a);
                u7.a.j(0, 0, iArr6, cVar6.f6002b);
                u7.a.I(cVar6.f6003c);
                u7.a.E(iArr5, iArr6, cVar6.d);
                c cVar7 = new c();
                c cVar8 = cVarArr[16];
                C(cVar8, cVar8, cVar7, bVar);
                for (int i11 = 1; i11 < 16; i11++) {
                    int i12 = 16 + i11;
                    c cVar9 = cVarArr[i12 - 1];
                    c cVar10 = new c();
                    cVarArr[i12] = cVar10;
                    C(cVar9, cVar7, cVar10, bVar);
                }
                a aVar = new a();
                u7.a.j(0, 0, iArr3, aVar.f5995a);
                u7.a.j(0, 0, iArr4, aVar.f5996b);
                u7.a.I(aVar.f5997c);
                u7.a.j(0, 0, aVar.f5995a, aVar.d);
                u7.a.j(0, 0, aVar.f5996b, aVar.f5998e);
                int i13 = 4;
                c[] cVarArr2 = new c[4];
                for (int i14 = 0; i14 < 4; i14++) {
                    cVarArr2[i14] = new c();
                }
                c cVar11 = new c();
                int i15 = 0;
                int i16 = 32;
                while (i15 < 8) {
                    int i17 = i16 + 1;
                    c cVar12 = new c();
                    cVarArr[i16] = cVar12;
                    int i18 = i8;
                    while (i18 < i13) {
                        if (i18 == 0) {
                            I(aVar, cVar12);
                        } else {
                            I(aVar, cVar11);
                            C(cVar12, cVar11, cVar12, bVar);
                        }
                        L(aVar);
                        I(aVar, cVarArr2[i18]);
                        if (i15 + i18 != 10) {
                            for (int i19 = 1; i19 < 8; i19++) {
                                L(aVar);
                            }
                        }
                        i18++;
                        i13 = 4;
                    }
                    int[] iArr7 = cVar12.f6001a;
                    u7.a.G(iArr7, iArr7);
                    int[] iArr8 = cVar12.d;
                    u7.a.G(iArr8, iArr8);
                    int i20 = i8;
                    i16 = i17;
                    while (i20 < 3) {
                        int i21 = 1 << i20;
                        int i22 = i8;
                        while (i22 < i21) {
                            c cVar13 = new c();
                            cVarArr[i16] = cVar13;
                            C(cVarArr[i16 - i21], cVarArr2[i20], cVar13, bVar);
                            i22++;
                            i16++;
                        }
                        i20++;
                        i8 = 0;
                    }
                    i15++;
                    i13 = 4;
                    i8 = 0;
                }
                A(cVarArr);
                f6019m = new d[16];
                for (int i23 = 0; i23 < 16; i23++) {
                    c cVar14 = cVarArr[i23];
                    d[] dVarArr = f6019m;
                    d dVar = new d(0);
                    dVarArr[i23] = dVar;
                    int[] iArr9 = cVar14.f6001a;
                    u7.a.E(iArr9, cVar14.f6003c, iArr9);
                    int[] iArr10 = cVar14.f6002b;
                    u7.a.E(iArr10, cVar14.f6003c, iArr10);
                    u7.a.c(cVar14.f6002b, cVar14.f6001a, dVar.f6005b, dVar.f6004a);
                    u7.a.E(cVar14.f6001a, cVar14.f6002b, dVar.f6006c);
                    int[] iArr11 = dVar.f6006c;
                    u7.a.E(iArr11, f6017k, iArr11);
                    u7.a.H(dVar.f6004a);
                    u7.a.H(dVar.f6005b);
                    u7.a.H(dVar.f6006c);
                }
                f6020n = new d[16];
                for (int i24 = 0; i24 < 16; i24++) {
                    c cVar15 = cVarArr[16 + i24];
                    d[] dVarArr2 = f6020n;
                    d dVar2 = new d(0);
                    dVarArr2[i24] = dVar2;
                    int[] iArr12 = cVar15.f6001a;
                    u7.a.E(iArr12, cVar15.f6003c, iArr12);
                    int[] iArr13 = cVar15.f6002b;
                    u7.a.E(iArr13, cVar15.f6003c, iArr13);
                    u7.a.c(cVar15.f6002b, cVar15.f6001a, dVar2.f6005b, dVar2.f6004a);
                    u7.a.E(cVar15.f6001a, cVar15.f6002b, dVar2.f6006c);
                    int[] iArr14 = dVar2.f6006c;
                    u7.a.E(iArr14, f6017k, iArr14);
                    u7.a.H(dVar2.f6004a);
                    u7.a.H(dVar2.f6005b);
                    u7.a.H(dVar2.f6006c);
                }
                f6021o = new int[1920];
                int[] iArr15 = new int[10];
                int[] iArr16 = new int[10];
                int[] iArr17 = new int[10];
                int i25 = 0;
                for (int i26 = 32; i26 < 96; i26++) {
                    c cVar16 = cVarArr[i26];
                    int[] iArr18 = cVar16.f6001a;
                    u7.a.E(iArr18, cVar16.f6003c, iArr18);
                    int[] iArr19 = cVar16.f6002b;
                    u7.a.E(iArr19, cVar16.f6003c, iArr19);
                    u7.a.c(cVar16.f6002b, cVar16.f6001a, iArr16, iArr15);
                    u7.a.E(cVar16.f6001a, cVar16.f6002b, iArr17);
                    u7.a.E(iArr17, f6017k, iArr17);
                    u7.a.H(iArr15);
                    u7.a.H(iArr16);
                    u7.a.H(iArr17);
                    u7.a.j(0, i25, iArr15, f6021o);
                    u7.a.j(0, i25 + 10, iArr16, f6021o);
                    u7.a.j(0, i25 + 20, iArr17, f6021o);
                    i25 += 30;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void Q() {
        synchronized (f6028v) {
            try {
                if (y != null) {
                    return;
                }
                d[] dVarArr = new d[144];
                g gVar = new g();
                b bVar = new b(2);
                u7.a.k(0, 0, f6024r, bVar.f5999a);
                u7.a.k(0, 0, f6025s, bVar.f6000b);
                N(bVar, dVarArr, 0, 32, gVar);
                b bVar2 = new b(2);
                u7.a.k(0, 0, f6026t, bVar2.f5999a);
                u7.a.k(0, 0, f6027u, bVar2.f6000b);
                N(bVar2, dVarArr, 32, 32, gVar);
                d dVar = new d(1);
                J(bVar, dVar);
                int i8 = 5;
                d[] dVarArr2 = new d[5];
                for (int i9 = 0; i9 < 5; i9++) {
                    dVarArr2[i9] = new d(1);
                }
                int i10 = 0;
                int i11 = 64;
                while (i10 < i8) {
                    int i12 = i11 + 1;
                    d dVar2 = new d(1);
                    dVarArr[i11] = dVar2;
                    int i13 = 0;
                    while (i13 < i8) {
                        if (i13 == 0) {
                            K(dVar, dVar2);
                        } else {
                            D(dVar, dVar2, gVar);
                        }
                        M(dVar, gVar);
                        K(dVar, dVarArr2[i13]);
                        if (i10 + i13 != 8) {
                            for (int i14 = 1; i14 < 18; i14++) {
                                M(dVar, gVar);
                            }
                        }
                        i13++;
                        i8 = 5;
                    }
                    int[] iArr = dVar2.f6004a;
                    u7.a.Q(new int[16], iArr, iArr);
                    i11 = i12;
                    for (int i15 = 0; i15 < 4; i15++) {
                        int i16 = 1 << i15;
                        int i17 = 0;
                        while (i17 < i16) {
                            d dVar3 = new d(1);
                            dVarArr[i11] = dVar3;
                            K(dVarArr[i11 - i16], dVar3);
                            D(dVarArr2[i15], dVarArr[i11], gVar);
                            i17++;
                            i11++;
                        }
                    }
                    i10++;
                    i8 = 5;
                }
                B(dVarArr);
                f6029w = new b[32];
                for (int i18 = 0; i18 < 32; i18++) {
                    d dVar4 = dVarArr[i18];
                    b[] bVarArr = f6029w;
                    b bVar3 = new b(2);
                    bVarArr[i18] = bVar3;
                    u7.a.F(dVar4.f6004a, dVar4.f6006c, bVar3.f5999a);
                    int[] iArr2 = bVar3.f5999a;
                    u7.a.K(1, iArr2);
                    u7.a.K(-1, iArr2);
                    u7.a.F(dVar4.f6005b, dVar4.f6006c, bVar3.f6000b);
                    int[] iArr3 = bVar3.f6000b;
                    u7.a.K(1, iArr3);
                    u7.a.K(-1, iArr3);
                }
                f6030x = new b[32];
                for (int i19 = 0; i19 < 32; i19++) {
                    d dVar5 = dVarArr[32 + i19];
                    b[] bVarArr2 = f6030x;
                    b bVar4 = new b(2);
                    bVarArr2[i19] = bVar4;
                    u7.a.F(dVar5.f6004a, dVar5.f6006c, bVar4.f5999a);
                    int[] iArr4 = bVar4.f5999a;
                    u7.a.K(1, iArr4);
                    u7.a.K(-1, iArr4);
                    u7.a.F(dVar5.f6005b, dVar5.f6006c, bVar4.f6000b);
                    int[] iArr5 = bVar4.f6000b;
                    u7.a.K(1, iArr5);
                    u7.a.K(-1, iArr5);
                }
                y = new int[2560];
                int i20 = 0;
                for (int i21 = 64; i21 < 144; i21++) {
                    d dVar6 = dVarArr[i21];
                    int[] iArr6 = dVar6.f6004a;
                    u7.a.F(iArr6, dVar6.f6006c, iArr6);
                    int[] iArr7 = dVar6.f6004a;
                    u7.a.K(1, iArr7);
                    u7.a.K(-1, iArr7);
                    int[] iArr8 = dVar6.f6005b;
                    u7.a.F(iArr8, dVar6.f6006c, iArr8);
                    int[] iArr9 = dVar6.f6005b;
                    u7.a.K(1, iArr9);
                    u7.a.K(-1, iArr9);
                    u7.a.k(0, i20, dVar6.f6004a, y);
                    u7.a.k(0, i20 + 16, dVar6.f6005b, y);
                    i20 += 32;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void R(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        byte b9 = (byte) (bArr2[31] & AbstractJsonLexerKt.TC_INVALID);
        bArr2[31] = b9;
        bArr2[31] = (byte) (b9 | 64);
    }

    public static void S(byte[] bArr, byte[] bArr2) {
        System.arraycopy(bArr, 0, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    public static byte[] T(byte[] bArr) {
        long jG = g(bArr, 49);
        long j4 = jG & 4294967295L;
        long jG2 = g(bArr, 56);
        long j8 = bArr[63] & 255;
        long jF = ((f(bArr, 60) << 4) & 4294967295L) + ((jG2 & 4294967295L) >> 28);
        long j9 = jG2 & 268435455;
        long jG3 = ((g(bArr, 42) & 4294967295L) - (j8 * (-6428113))) - (jF * 5343);
        long jG4 = ((g(bArr, 28) & 4294967295L) - (jF * (-50998291))) - (j9 * 19280294);
        long jF2 = ((((f(bArr, 32) << 4) & 4294967295L) - (j8 * (-50998291))) - (jF * 19280294)) - (j9 * 127719000);
        long jG5 = (((g(bArr, 35) & 4294967295L) - (j8 * 19280294)) - (jF * 127719000)) - (j9 * (-6428113));
        long jF3 = ((((f(bArr, 39) << 4) & 4294967295L) - (j8 * 127719000)) - (jF * (-6428113))) - (j9 * 5343);
        long jF4 = ((f(bArr, 53) << 4) & 4294967295L) + (j4 >> 28);
        long j10 = jG & 268435455;
        long j11 = jG5 - (jF4 * 5343);
        long j12 = (jF2 - (jF4 * (-6428113))) - (j10 * 5343);
        long jF5 = (((f(bArr, 46) << 4) & 4294967295L) - (j8 * 5343)) + (jG3 >> 28);
        long jG6 = (((g(bArr, 21) & 4294967295L) - (jF4 * (-50998291))) - (j10 * 19280294)) - (jF5 * 127719000);
        long jF6 = (((((f(bArr, 25) << 4) & 4294967295L) - (j9 * (-50998291))) - (jF4 * 19280294)) - (j10 * 127719000)) - (jF5 * (-6428113));
        long j13 = ((jG4 - (jF4 * 127719000)) - (j10 * (-6428113))) - (jF5 * 5343);
        long j14 = (jG3 & 268435455) + (jF3 >> 28);
        long jG7 = ((g(bArr, 14) & 4294967295L) - (jF5 * (-50998291))) - (j14 * 19280294);
        long jF7 = ((((f(bArr, 18) << 4) & 4294967295L) - (j10 * (-50998291))) - (jF5 * 19280294)) - (j14 * 127719000);
        long j15 = jF6 - (j14 * 5343);
        long j16 = (jF3 & 268435455) + (j11 >> 28);
        long jF8 = (((f(bArr, 11) << 4) & 4294967295L) - (j14 * (-50998291))) - (j16 * 19280294);
        long j17 = (jG6 - (j14 * (-6428113))) - (j16 * 5343);
        long j18 = (j11 & 268435455) + (j12 >> 28);
        long jF9 = ((f(bArr, 4) << 4) & 4294967295L) - (j18 * (-50998291));
        long jG8 = ((g(bArr, 7) & 4294967295L) - (j16 * (-50998291))) - (j18 * 19280294);
        long j19 = jF8 - (j18 * 127719000);
        long j20 = (jG7 - (j16 * 127719000)) - (j18 * (-6428113));
        long j21 = (jF7 - (j16 * (-6428113))) - (j18 * 5343);
        long j22 = j13 + (j15 >> 28);
        long j23 = j15 & 268435455;
        long j24 = (j12 & 268435455) + (j22 >> 28);
        long j25 = j22 & 268435455;
        long j26 = j25 >>> 27;
        long j27 = j24 + j26;
        long jG9 = (g(bArr, 0) & 4294967295L) - (j27 * (-50998291));
        long j28 = jG8 - (j27 * 127719000);
        long j29 = j19 - (j27 * (-6428113));
        long j30 = j20 - (j27 * 5343);
        long j31 = (jF9 - (j27 * 19280294)) + (jG9 >> 28);
        long j32 = jG9 & 268435455;
        long j33 = j28 + (j31 >> 28);
        long j34 = j29 + (j33 >> 28);
        long j35 = j30 + (j34 >> 28);
        long j36 = j21 + (j35 >> 28);
        long j37 = j17 + (j36 >> 28);
        long j38 = j23 + (j37 >> 28);
        long j39 = j25 + (j38 >> 28);
        long j40 = (j39 >> 28) - j26;
        long j41 = j32 + (j40 & (-50998291));
        long j42 = (j31 & 268435455) + (j40 & 19280294) + (j41 >> 28);
        long j43 = (j33 & 268435455) + (j40 & 127719000) + (j42 >> 28);
        long j44 = (j34 & 268435455) + (j40 & (-6428113)) + (j43 >> 28);
        long j45 = (j35 & 268435455) + (j40 & 5343) + (j44 >> 28);
        long j46 = (j36 & 268435455) + (j45 >> 28);
        long j47 = (j37 & 268435455) + (j46 >> 28);
        long j48 = (j38 & 268435455) + (j47 >> 28);
        long j49 = (j39 & 268435455) + (j48 >> 28);
        long j50 = j48 & 268435455;
        byte[] bArr2 = new byte[32];
        o((j41 & 268435455) | ((j42 & 268435455) << 28), bArr2, 0);
        o((j43 & 268435455) | ((j44 & 268435455) << 28), bArr2, 7);
        o(((j46 & 268435455) << 28) | (j45 & 268435455), bArr2, 14);
        o((j50 << 28) | (j47 & 268435455), bArr2, 21);
        m((int) j49, 28, bArr2);
        return bArr2;
    }

    public static byte[] U(byte[] bArr) {
        long jG = g(bArr, 84);
        long j4 = jG & 4294967295L;
        long jG2 = g(bArr, 91);
        long j8 = jG2 & 4294967295L;
        long jG3 = g(bArr, 98);
        long j9 = jG3 & 4294967295L;
        long jG4 = g(bArr, 105);
        long j10 = ((bArr[112] & 255) | ((bArr[113] & 255) << 8)) & 4294967295L;
        long jF = ((f(bArr, 109) << 4) & 4294967295L) + ((jG4 & 4294967295L) >>> 28);
        long j11 = jG4 & 268435455;
        long jG5 = (j11 * 163752818) + (jF * 30366549) + (j10 * 43969588) + (g(bArr, 56) & 4294967295L);
        long jF2 = (j11 * 258169998) + (jF * 163752818) + (j10 * 30366549) + ((f(bArr, 60) << 4) & 4294967295L);
        long jG6 = (j11 * 96434764) + (jF * 258169998) + (j10 * 163752818) + (g(bArr, 63) & 4294967295L);
        long jF3 = (j11 * 227822194) + (jF * 96434764) + (j10 * 258169998) + ((f(bArr, 67) << 4) & 4294967295L);
        long jG7 = (j11 * 149865618) + (jF * 227822194) + (j10 * 96434764) + (g(bArr, 70) & 4294967295L);
        long jF4 = ((f(bArr, 102) << 4) & 4294967295L) + (j9 >>> 28);
        long j12 = jG3 & 268435455;
        long jF5 = (jF4 * 43969588) + ((f(bArr, 46) << 4) & 4294967295L);
        long jG8 = (jF4 * 30366549) + (j11 * 43969588) + (g(bArr, 49) & 4294967295L);
        long jF6 = (jF4 * 163752818) + (j11 * 30366549) + (jF * 43969588) + ((f(bArr, 53) << 4) & 4294967295L);
        long j13 = (jF4 * 258169998) + jG5;
        long j14 = (jF4 * 96434764) + jF2;
        long j15 = (jF4 * 227822194) + jG6;
        long j16 = (jF4 * 149865618) + jF3;
        long j17 = (jF4 * 550336261) + jG7;
        long jG9 = (j12 * 43969588) + (g(bArr, 42) & 4294967295L);
        long j18 = (j12 * 30366549) + jF5;
        long j19 = (j12 * 163752818) + jG8;
        long j20 = (j12 * 258169998) + jF6;
        long j21 = (j12 * 96434764) + j13;
        long j22 = (j12 * 227822194) + j14;
        long j23 = (j12 * 149865618) + j15;
        long j24 = (j12 * 550336261) + j16;
        long jF7 = ((f(bArr, 95) << 4) & 4294967295L) + (j8 >>> 28);
        long j25 = jG2 & 268435455;
        long j26 = (jF7 * 163752818) + j18;
        long j27 = (jF7 * 258169998) + j19;
        long j28 = (jF7 * 149865618) + j22;
        long jG10 = (j25 * 43969588) + (g(bArr, 35) & 4294967295L);
        long jF8 = (j25 * 30366549) + (jF7 * 43969588) + ((f(bArr, 39) << 4) & 4294967295L);
        long j29 = (j25 * 163752818) + (jF7 * 30366549) + jG9;
        long j30 = (j25 * 258169998) + j26;
        long j31 = (j25 * 96434764) + j27;
        long j32 = (j25 * 227822194) + (jF7 * 96434764) + j20;
        long j33 = (j25 * 149865618) + (jF7 * 227822194) + j21;
        long j34 = (j25 * 550336261) + j28;
        long jF9 = ((f(bArr, 88) << 4) & 4294967295L) + (j4 >>> 28);
        long j35 = (jF9 * 30366549) + jG10;
        long j36 = (jF9 * 163752818) + jF8;
        long j37 = (jF9 * 258169998) + j29;
        long j38 = (jF9 * 149865618) + j32;
        long jF10 = (j11 * 550336261) + (jF * 149865618) + (j10 * 227822194) + ((f(bArr, 74) << 4) & 4294967295L) + (j17 >>> 28);
        long j39 = j17 & 268435455;
        long jG11 = (jF * 550336261) + (j10 * 149865618) + (g(bArr, 77) & 4294967295L) + (jF10 >>> 28);
        long jF11 = (j10 * 550336261) + ((f(bArr, 81) << 4) & 4294967295L) + (jG11 >>> 28);
        long j40 = jG11 & 268435455;
        long j41 = (jG & 268435455) + (jF11 >>> 28);
        long j42 = jF11 & 268435455;
        long jG12 = (j41 * 43969588) + (g(bArr, 28) & 4294967295L);
        long jF12 = (j41 * 30366549) + (jF9 * 43969588) + ((f(bArr, 32) << 4) & 4294967295L);
        long j43 = (j41 * 163752818) + j35;
        long j44 = (j41 * 258169998) + j36;
        long j45 = (j41 * 96434764) + j37;
        long j46 = (j41 * 227822194) + (jF9 * 96434764) + j30;
        long j47 = (j41 * 149865618) + (jF9 * 227822194) + j31;
        long j48 = (j41 * 550336261) + j38;
        long jF13 = (j42 * 43969588) + ((f(bArr, 25) << 4) & 4294967295L);
        long j49 = (j42 * 30366549) + jG12;
        long j50 = (j42 * 163752818) + jF12;
        long j51 = (j42 * 258169998) + j43;
        long j52 = (j42 * 96434764) + j44;
        long j53 = (j42 * 227822194) + j45;
        long j54 = (j42 * 149865618) + j46;
        long j55 = (j42 * 550336261) + j47;
        long jG13 = (j40 * 43969588) + (g(bArr, 21) & 4294967295L);
        long j56 = (j40 * 30366549) + jF13;
        long j57 = (j40 * 163752818) + j49;
        long j58 = (j40 * 258169998) + j50;
        long j59 = (j40 * 96434764) + j51;
        long j60 = (j40 * 227822194) + j52;
        long j61 = (j40 * 149865618) + j53;
        long j62 = (j40 * 550336261) + j54;
        long j63 = (jF7 * 550336261) + j23 + (j34 >>> 28);
        long j64 = j34 & 268435455;
        long j65 = j24 + (j63 >>> 28);
        long j66 = j63 & 268435455;
        long j67 = j39 + (j65 >>> 28);
        long j68 = j65 & 268435455;
        long j69 = (jF10 & 268435455) + (j67 >>> 28);
        long j70 = j67 & 268435455;
        long jF14 = (j69 * 43969588) + ((f(bArr, 18) << 4) & 4294967295L);
        long j71 = (j69 * 30366549) + jG13;
        long j72 = (j69 * 163752818) + j56;
        long j73 = (j69 * 258169998) + j57;
        long j74 = (j69 * 96434764) + j58;
        long j75 = (j69 * 227822194) + j59;
        long j76 = (j69 * 149865618) + j60;
        long j77 = (j69 * 550336261) + j61;
        long j78 = (j70 * 163752818) + j71;
        long j79 = (j70 * 258169998) + j72;
        long j80 = (j70 * 96434764) + j73;
        long j81 = (j70 * 227822194) + j74;
        long j82 = (j70 * 149865618) + j75;
        long jF15 = (j68 * 43969588) + ((f(bArr, 11) << 4) & 4294967295L);
        long jG14 = (j68 * 30366549) + (j70 * 43969588) + (g(bArr, 14) & 4294967295L);
        long j83 = (j68 * 163752818) + (j70 * 30366549) + jF14;
        long j84 = (j68 * 258169998) + j78;
        long j85 = (j68 * 96434764) + j79;
        long j86 = (j68 * 227822194) + j80;
        long j87 = (j68 * 149865618) + j81;
        long j88 = (j68 * 550336261) + j82;
        long j89 = j48 + (j55 >>> 28);
        long j90 = (jF9 * 550336261) + j33 + (j89 >>> 28);
        long j91 = j64 + (j90 >>> 28);
        long j92 = j90 & 268435455;
        long j93 = j66 + (j91 >>> 28);
        long j94 = j91 & 268435455;
        long jG15 = (j93 * 43969588) + (g(bArr, 7) & 4294967295L);
        long j95 = (j93 * 30366549) + jF15;
        long j96 = (j93 * 163752818) + jG14;
        long j97 = (j93 * 258169998) + j83;
        long j98 = (j93 * 96434764) + j84;
        long jF16 = (43969588 * j94) + ((f(bArr, 4) << 4) & 4294967295L);
        long j99 = (163752818 * j94) + j95;
        long j100 = j89 & 67108863;
        long j101 = (j92 * 4) + ((j89 & 268435455) >>> 26) + 1;
        long jG16 = (j101 * 78101261) + (g(bArr, 0) & 4294967295L);
        long j102 = (j101 * 141809365) + jF16;
        long j103 = (j101 * 175155932) + (30366549 * j94) + jG15;
        long j104 = (j101 * 64542499) + j99;
        long j105 = (j101 * 158326419) + (258169998 * j94) + j96;
        long j106 = (j101 * 191173276) + (96434764 * j94) + j97;
        long j107 = (j101 * 104575268) + (227822194 * j94) + j98;
        long j108 = j102 + (jG16 >>> 28);
        long j109 = j103 + (j108 >>> 28);
        long j110 = j104 + (j109 >>> 28);
        long j111 = j105 + (j110 >>> 28);
        long j112 = j106 + (j111 >>> 28);
        long j113 = j107 + (j112 >>> 28);
        long j114 = (j101 * 137584065) + (149865618 * j94) + (j93 * 227822194) + j85 + (j113 >>> 28);
        long j115 = (j94 * 550336261) + (j93 * 149865618) + j86 + (j114 >>> 28);
        long j116 = (j93 * 550336261) + j87 + (j115 >>> 28);
        long j117 = j88 + (j116 >>> 28);
        long j118 = (j70 * 550336261) + j76 + (j117 >>> 28);
        long j119 = j77 + (j118 >>> 28);
        long j120 = j62 + (j119 >>> 28);
        long j121 = (j55 & 268435455) + (j120 >>> 28);
        long j122 = j100 + (j121 >>> 28);
        long j123 = (j122 >>> 26) - 1;
        long j124 = (jG16 & 268435455) - (j123 & 78101261);
        long j125 = ((j108 & 268435455) - (j123 & 141809365)) + (j124 >> 28);
        long j126 = ((j109 & 268435455) - (j123 & 175155932)) + (j125 >> 28);
        long j127 = j125 & 268435455;
        long j128 = ((j110 & 268435455) - (j123 & 64542499)) + (j126 >> 28);
        long j129 = ((j111 & 268435455) - (j123 & 158326419)) + (j128 >> 28);
        long j130 = ((j112 & 268435455) - (j123 & 191173276)) + (j129 >> 28);
        long j131 = ((j113 & 268435455) - (j123 & 104575268)) + (j130 >> 28);
        long j132 = ((j114 & 268435455) - (j123 & 137584065)) + (j131 >> 28);
        long j133 = (j115 & 268435455) + (j132 >> 28);
        long j134 = (j116 & 268435455) + (j133 >> 28);
        long j135 = (j117 & 268435455) + (j134 >> 28);
        long j136 = (j118 & 268435455) + (j135 >> 28);
        long j137 = (j119 & 268435455) + (j136 >> 28);
        long j138 = (j120 & 268435455) + (j137 >> 28);
        long j139 = (j121 & 268435455) + (j138 >> 28);
        long j140 = j138 & 268435455;
        byte[] bArr2 = new byte[57];
        o((j124 & 268435455) | (j127 << 28), bArr2, 0);
        o(((j128 & 268435455) << 28) | (j126 & 268435455), bArr2, 7);
        o(((j130 & 268435455) << 28) | (j129 & 268435455), bArr2, 14);
        o((j131 & 268435455) | ((j132 & 268435455) << 28), bArr2, 21);
        o((j133 & 268435455) | ((j134 & 268435455) << 28), bArr2, 28);
        o((j135 & 268435455) | ((j136 & 268435455) << 28), bArr2, 35);
        o((j137 & 268435455) | (j140 << 28), bArr2, 42);
        o((j139 & 268435455) | (((j122 & 67108863) + (j139 >> 28)) << 28), bArr2, 49);
        return bArr2;
    }

    public static void V(byte[] bArr, a aVar) {
        char c3;
        int[] iArr = aVar.f5998e;
        int[] iArr2 = aVar.d;
        int[] iArr3 = aVar.f5997c;
        int[] iArr4 = aVar.f5996b;
        int[] iArr5 = aVar.f5995a;
        P();
        int i8 = 8;
        int[] iArr6 = new int[8];
        d(bArr, iArr6);
        int i9 = 0;
        int i10 = 1;
        long j4 = 4294967295L;
        long j8 = (-((~iArr6[0]) & 1)) & 4294967295L;
        long j9 = 0;
        int i11 = 0;
        while (i11 < 8) {
            int i12 = i10;
            long j10 = j8;
            long j11 = (iArr6[i11] & j4) + (z[i11] & j10) + j9;
            iArr6[i11] = (int) j11;
            j9 = j11 >>> 32;
            i11++;
            i9 = i9;
            i10 = i12;
            j8 = j10;
            j4 = 4294967295L;
        }
        int i13 = i9;
        int i14 = 8;
        int i15 = i10;
        while (true) {
            i14--;
            if (i14 < 0) {
                break;
            }
            int i16 = iArr6[i14];
            iArr6[i14] = (i15 << 31) | (i16 >>> 1);
            i15 = i16;
        }
        int i17 = i13;
        while (true) {
            c3 = 7;
            if (i17 >= 8) {
                break;
            }
            iArr6[i17] = x.f.p(x.f.p(x.f.p(x.f.p(iArr6[i17], 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
            i17++;
        }
        int[] iArr7 = new int[10];
        int[] iArr8 = new int[10];
        int[] iArr9 = new int[10];
        int[] iArr10 = new int[10];
        for (int i18 = i13; i18 < 10; i18++) {
            iArr5[i18] = i13;
        }
        u7.a.I(iArr4);
        u7.a.I(iArr3);
        for (int i19 = i13; i19 < 10; i19++) {
            iArr2[i19] = i13;
        }
        u7.a.I(iArr);
        int i20 = 28;
        int i21 = i13;
        while (true) {
            int i22 = i13;
            while (i22 < i8) {
                int i23 = iArr6[i22] >>> i20;
                char c8 = c3;
                int i24 = (i23 >>> 3) & 1;
                int i25 = (i23 ^ (-i24)) & 7;
                int i26 = i22 * 240;
                int[] iArr11 = iArr6;
                for (int i27 = i13; i27 < 8; i27++) {
                    int i28 = ((i27 ^ i25) - 1) >> 31;
                    u7.a.g(i28, i26, f6021o, iArr7);
                    int i29 = i26;
                    u7.a.g(i28, i26 + 10, f6021o, iArr8);
                    u7.a.g(i28, i29 + 20, f6021o, iArr9);
                    i26 = i29 + 30;
                }
                int i30 = i21 ^ i24;
                u7.a.i(i30, iArr5);
                u7.a.i(i30, iArr2);
                u7.a.c(iArr4, iArr5, iArr4, iArr5);
                u7.a.E(iArr5, iArr7, iArr5);
                u7.a.E(iArr4, iArr8, iArr4);
                u7.a.E(iArr2, iArr, iArr10);
                u7.a.E(iArr10, iArr9, iArr10);
                u7.a.c(iArr4, iArr5, iArr, iArr2);
                u7.a.c(iArr3, iArr10, iArr4, iArr5);
                u7.a.E(iArr5, iArr4, iArr3);
                u7.a.E(iArr5, iArr2, iArr5);
                u7.a.E(iArr4, iArr, iArr4);
                i22++;
                i21 = i24;
                iArr6 = iArr11;
                c3 = c8;
                i8 = 8;
            }
            int[] iArr12 = iArr6;
            char c9 = c3;
            i20 -= 4;
            if (i20 < 0) {
                u7.a.i(i21, iArr5);
                u7.a.i(i21, iArr2);
                return;
            } else {
                L(aVar);
                iArr6 = iArr12;
                c3 = c9;
                i8 = 8;
            }
        }
    }

    public static void W(byte[] bArr, d dVar) {
        int[] iArr = dVar.f6006c;
        int[] iArr2 = dVar.f6005b;
        int[] iArr3 = dVar.f6004a;
        Q();
        int i8 = 15;
        int[] iArr4 = new int[15];
        e(bArr, iArr4);
        int i9 = 0;
        int i10 = 1;
        long j4 = (-((~iArr4[0]) & 1)) & 4294967295L;
        long j8 = 0;
        int i11 = 0;
        while (i11 < 14) {
            int i12 = i8;
            int[] iArr5 = iArr4;
            long j9 = j4;
            long j10 = (iArr4[i11] & 4294967295L) + (B[i11] & j9) + j8;
            iArr5[i11] = (int) j10;
            j8 = j10 >>> 32;
            i11++;
            i10 = i10;
            i8 = i12;
            iArr4 = iArr5;
            j4 = j9;
        }
        int[] iArr6 = iArr4;
        int i13 = i10;
        iArr6[14] = 4 + ((int) j8);
        int i14 = i8;
        int i15 = 0;
        while (true) {
            i14--;
            if (i14 < 0) {
                break;
            }
            int i16 = iArr6[i14];
            iArr6[i14] = (i15 << 31) | (i16 >>> 1);
            i15 = i16;
        }
        int[] iArr7 = new int[16];
        int[] iArr8 = new int[16];
        int[] iArr9 = new int[16];
        int[] iArr10 = new int[16];
        int[] iArr11 = new int[16];
        int[] iArr12 = new int[16];
        int[] iArr13 = new int[16];
        int[] iArr14 = new int[16];
        int[] iArr15 = new int[16];
        int[] iArr16 = new int[16];
        for (int i17 = 0; i17 < 16; i17++) {
            iArr3[i17] = 0;
        }
        iArr2[0] = i13;
        for (int i18 = i13; i18 < 16; i18++) {
            iArr2[i18] = 0;
        }
        iArr[0] = i13;
        for (int i19 = i13; i19 < 16; i19++) {
            iArr[i19] = 0;
        }
        int i20 = 17;
        while (true) {
            int i21 = i20;
            while (true) {
                if (i9 >= 5) {
                    break;
                }
                int i22 = i20;
                int i23 = 0;
                int i24 = 0;
                for (int i25 = 5; i23 < i25; i25 = 5) {
                    i24 = (i24 & (~(i13 << i23))) ^ ((iArr6[i21 >>> 5] >>> (i21 & 31)) << i23);
                    i21 += 18;
                    i23++;
                }
                int i26 = -((i24 >>> 4) & 1);
                int i27 = (i24 ^ i26) & 15;
                int i28 = i9 * 512;
                int i29 = i9;
                int[] iArr17 = iArr9;
                for (int i30 = 0; i30 < 16; i30++) {
                    int i31 = ((i30 ^ i27) - 1) >> 31;
                    u7.a.h(i31, i28, y, iArr7);
                    u7.a.h(i31, i28 + 16, y, iArr8);
                    i28 += 32;
                }
                int[] iArr18 = new int[16];
                u7.a.Q(iArr18, iArr7, iArr18);
                u7.a.h(i26, 0, iArr18, iArr7);
                u7.a.O(iArr, iArr10);
                u7.a.F(iArr7, iArr3, iArr11);
                u7.a.F(iArr8, iArr2, iArr12);
                u7.a.F(iArr11, iArr12, iArr13);
                u7.a.C(39081, iArr13, iArr13);
                u7.a.b(iArr10, iArr13, iArr14);
                u7.a.Q(iArr10, iArr13, iArr15);
                u7.a.b(iArr8, iArr7, iArr16);
                u7.a.b(iArr2, iArr3, iArr13);
                u7.a.F(iArr16, iArr13, iArr16);
                u7.a.b(iArr12, iArr11, iArr10);
                u7.a.Q(iArr12, iArr11, iArr13);
                u7.a.d(iArr10);
                u7.a.Q(iArr16, iArr10, iArr16);
                u7.a.F(iArr16, iArr, iArr16);
                u7.a.F(iArr13, iArr, iArr13);
                u7.a.F(iArr14, iArr16, iArr3);
                u7.a.F(iArr13, iArr15, iArr2);
                u7.a.F(iArr14, iArr15, iArr);
                i9 = i29 + 1;
                i20 = i22;
                iArr9 = iArr17;
            }
            int[] iArr19 = iArr9;
            int i32 = i20 - 1;
            if (i32 < 0) {
                return;
            }
            u7.a.b(iArr3, iArr2, iArr10);
            u7.a.O(iArr10, iArr10);
            u7.a.O(iArr3, iArr11);
            u7.a.O(iArr2, iArr12);
            u7.a.b(iArr11, iArr12, iArr13);
            u7.a.d(iArr13);
            u7.a.O(iArr, iArr16);
            u7.a.b(iArr16, iArr16, iArr16);
            u7.a.d(iArr16);
            u7.a.Q(iArr13, iArr16, iArr19);
            u7.a.Q(iArr10, iArr13, iArr10);
            u7.a.Q(iArr11, iArr12, iArr11);
            u7.a.F(iArr10, iArr19, iArr3);
            u7.a.F(iArr13, iArr11, iArr2);
            u7.a.F(iArr13, iArr19, iArr);
            i20 = i32;
            iArr9 = iArr19;
            i9 = 0;
        }
    }

    public static void X(int i8, int i9, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i10 = i8;
        int[] iArr5 = iArr3;
        char c3 = ' ';
        int i11 = 0;
        long j4 = 4294967295L;
        long j8 = 0;
        if (i9 == 0) {
            long j9 = 0;
            while (i11 <= i10) {
                long j10 = iArr5[i11] & 4294967295L;
                long j11 = (j9 + j10) - (iArr2[i11] & 4294967295L);
                int i12 = (int) j11;
                j9 = j11 >> 32;
                iArr5[i11] = i12;
                long j12 = ((j8 + (iArr[i11] & 4294967295L)) - j10) - (i12 & 4294967295L);
                iArr[i11] = (int) j12;
                j8 = j12 >> 32;
                i11++;
            }
            return;
        }
        if (i9 < 32) {
            int i13 = 0;
            long j13 = 0;
            long j14 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i11 <= i10) {
                int i16 = iArr5[i11];
                char c8 = c3;
                int i17 = -i9;
                long j15 = j4;
                long j16 = (j13 + (iArr[i11] & j15)) - (((i13 >>> i17) | (i16 << i9)) & j15);
                int i18 = iArr2[i11];
                long j17 = (j14 + (i16 & j15)) - (((i18 << i9) | (i14 >>> i17)) & j15);
                int i19 = (int) j17;
                j14 = j17 >> c8;
                iArr5[i11] = i19;
                long j18 = j16 - (((i15 >>> i17) | (i19 << i9)) & j15);
                iArr[i11] = (int) j18;
                j13 = j18 >> c8;
                i11++;
                i14 = i18;
                i15 = i19;
                i13 = i16;
                c3 = c8;
                j4 = j15;
            }
            return;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i10);
        int i20 = i9 >>> 5;
        int i21 = i9 & 31;
        if (i21 == 0) {
            long j19 = 0;
            for (int i22 = i20; i22 <= i10; i22++) {
                int i23 = i22 - i20;
                long j20 = (j19 + (iArr5[i22] & 4294967295L)) - (iArr2[i23] & 4294967295L);
                iArr5[i22] = (int) j20;
                j19 = j20 >> 32;
                long j21 = ((j8 + (iArr[i22] & 4294967295L)) - (iArr4[i23] & 4294967295L)) - (iArr5[i23] & 4294967295L);
                iArr[i22] = (int) j21;
                j8 = j21 >> 32;
            }
            return;
        }
        int i24 = i20;
        int i25 = 0;
        int i26 = 0;
        long j22 = 0;
        while (i24 <= i10) {
            int i27 = i24 - i20;
            int i28 = iArr4[i27];
            int i29 = -i21;
            long j23 = (j8 + (iArr[i24] & 4294967295L)) - (((i11 >>> i29) | (i28 << i21)) & 4294967295L);
            int i30 = iArr2[i27];
            long j24 = (j22 + (iArr5[i24] & 4294967295L)) - (((i30 << r21) | (i25 >>> i29)) & 4294967295L);
            iArr3[i24] = (int) j24;
            j22 = j24 >> 32;
            int i31 = iArr3[i27];
            long j25 = j23 - (((i31 << r21) | (i26 >>> i29)) & 4294967295L);
            iArr[i24] = (int) j25;
            j8 = j25 >> 32;
            i24++;
            i21 = i21;
            iArr5 = iArr3;
            i26 = i31;
            i25 = i30;
            i11 = i28;
            i10 = i8;
        }
    }

    public static void Y(int i8, int i9, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i10 = i9 >>> 5;
        int i11 = i9 & 31;
        char c3 = ' ';
        long j4 = 4294967295L;
        long j8 = 0;
        if (i11 == 0) {
            long j9 = 0;
            for (int i12 = i10; i12 <= i8; i12++) {
                int i13 = i12 - i10;
                long j10 = (j8 + (iArr[i12] & 4294967295L)) - (iArr3[i13] & 4294967295L);
                long j11 = (j9 + (iArr2[i12] & 4294967295L)) - (iArr4[i13] & 4294967295L);
                iArr[i12] = (int) j10;
                j8 = j10 >> 32;
                iArr2[i12] = (int) j11;
                j9 = j11 >> 32;
            }
            return;
        }
        int i14 = i10;
        int i15 = 0;
        int i16 = 0;
        long j12 = 0;
        while (i14 <= i8) {
            int i17 = i14 - i10;
            int i18 = iArr3[i17];
            int i19 = iArr4[i17];
            char c8 = c3;
            long j13 = j4;
            long j14 = j8 + (iArr[i14] & j13);
            long j15 = j14 - (((i15 >>> (-i11)) | (i18 << i11)) & j13);
            long j16 = (j12 + (iArr2[i14] & j13)) - (((i16 >>> r3) | (i19 << i11)) & j13);
            iArr[i14] = (int) j15;
            j8 = j15 >> c8;
            iArr2[i14] = (int) j16;
            j12 = j16 >> c8;
            i14++;
            c3 = c8;
            i16 = i19;
            i15 = i18;
            j4 = j13;
        }
    }

    public static void a(int i8, int i9, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i10 = i8;
        int[] iArr5 = iArr3;
        char c3 = ' ';
        int i11 = 0;
        long j4 = 4294967295L;
        long j8 = 0;
        if (i9 == 0) {
            long j9 = 0;
            while (i11 <= i10) {
                long j10 = iArr5[i11] & 4294967295L;
                long j11 = j9 + j10 + (iArr2[i11] & 4294967295L);
                int i12 = (int) j11;
                j9 = j11 >>> 32;
                iArr5[i11] = i12;
                long j12 = j8 + (iArr[i11] & 4294967295L) + j10 + (i12 & 4294967295L);
                iArr[i11] = (int) j12;
                j8 = j12 >>> 32;
                i11++;
            }
            return;
        }
        if (i9 < 32) {
            int i13 = 0;
            long j13 = 0;
            long j14 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i11 <= i10) {
                int i16 = iArr5[i11];
                char c8 = c3;
                int i17 = -i9;
                long j15 = j4;
                long j16 = j13 + (iArr[i11] & j15) + (((i13 >>> i17) | (i16 << i9)) & j15);
                int i18 = iArr2[i11];
                long j17 = j14 + (i16 & j15) + (((i18 << i9) | (i14 >>> i17)) & j15);
                int i19 = (int) j17;
                j14 = j17 >>> c8;
                iArr5[i11] = i19;
                long j18 = j16 + (((i15 >>> i17) | (i19 << i9)) & j15);
                iArr[i11] = (int) j18;
                j13 = j18 >>> c8;
                i11++;
                i14 = i18;
                i15 = i19;
                i13 = i16;
                c3 = c8;
                j4 = j15;
            }
            return;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i10);
        int i20 = i9 >>> 5;
        int i21 = i9 & 31;
        if (i21 == 0) {
            long j19 = 0;
            for (int i22 = i20; i22 <= i10; i22++) {
                int i23 = i22 - i20;
                long j20 = j19 + (iArr5[i22] & 4294967295L) + (iArr2[i23] & 4294967295L);
                iArr5[i22] = (int) j20;
                j19 = j20 >>> 32;
                long j21 = j8 + (iArr[i22] & 4294967295L) + (iArr4[i23] & 4294967295L) + (iArr5[i23] & 4294967295L);
                iArr[i22] = (int) j21;
                j8 = j21 >>> 32;
            }
            return;
        }
        int i24 = i20;
        int i25 = 0;
        int i26 = 0;
        long j22 = 0;
        while (i24 <= i10) {
            int i27 = i24 - i20;
            int i28 = iArr4[i27];
            int i29 = -i21;
            long j23 = j8 + (iArr[i24] & 4294967295L) + (((i11 >>> i29) | (i28 << i21)) & 4294967295L);
            int i30 = iArr2[i27];
            long j24 = j22 + (iArr5[i24] & 4294967295L) + (((i30 << r21) | (i25 >>> i29)) & 4294967295L);
            iArr3[i24] = (int) j24;
            j22 = j24 >>> 32;
            int i31 = iArr3[i27];
            long j25 = j23 + (((i31 << r21) | (i26 >>> i29)) & 4294967295L);
            iArr[i24] = (int) j25;
            j8 = j25 >>> 32;
            i24++;
            i21 = i21;
            iArr5 = iArr3;
            i26 = i31;
            i25 = i30;
            i11 = i28;
            i10 = i8;
        }
    }

    public static void b(int i8, int i9, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        int i10 = i9 >>> 5;
        int i11 = i9 & 31;
        char c3 = ' ';
        long j4 = 4294967295L;
        long j8 = 0;
        if (i11 == 0) {
            long j9 = 0;
            for (int i12 = i10; i12 <= i8; i12++) {
                int i13 = i12 - i10;
                long j10 = j8 + (iArr[i12] & 4294967295L) + (iArr3[i13] & 4294967295L);
                long j11 = j9 + (iArr2[i12] & 4294967295L) + (iArr4[i13] & 4294967295L);
                iArr[i12] = (int) j10;
                j8 = j10 >>> 32;
                iArr2[i12] = (int) j11;
                j9 = j11 >>> 32;
            }
            return;
        }
        int i14 = i10;
        int i15 = 0;
        int i16 = 0;
        long j12 = 0;
        while (i14 <= i8) {
            int i17 = i14 - i10;
            int i18 = iArr3[i17];
            int i19 = iArr4[i17];
            char c8 = c3;
            long j13 = j4;
            long j14 = j8 + (iArr[i14] & j13);
            long j15 = j14 + (((i15 >>> (-i11)) | (i18 << i11)) & j13);
            long j16 = j12 + (iArr2[i14] & j13) + (((i16 >>> r3) | (i19 << i11)) & j13);
            iArr[i14] = (int) j15;
            j8 = j15 >>> c8;
            iArr2[i14] = (int) j16;
            j12 = j16 >>> c8;
            i14++;
            c3 = c8;
            i16 = i19;
            i15 = i18;
            j4 = j13;
        }
    }

    public static SHA512Digest c() {
        SHA512Digest sHA512Digest = new SHA512Digest();
        if (sHA512Digest.getDigestSize() == 64) {
            return sHA512Digest;
        }
        throw new IllegalStateException();
    }

    public static void d(byte[] bArr, int[] iArr) {
        h(bArr, 8, iArr);
    }

    public static void e(byte[] bArr, int[] iArr) {
        h(bArr, 14, iArr);
    }

    public static int f(byte[] bArr, int i8) {
        return ((bArr[i8 + 2] & 255) << 16) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8);
    }

    public static int g(byte[] bArr, int i8) {
        return (bArr[i8 + 3] << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public static void h(byte[] bArr, int i8, int[] iArr) {
        for (int i9 = 0; i9 < i8; i9++) {
            iArr[i9] = g(bArr, i9 * 4);
        }
    }

    public static boolean i(byte[] bArr, boolean z2, b bVar) {
        int i8 = (bArr[31] & 128) >>> 7;
        int[] iArr = bVar.f6000b;
        u7.a.o(bArr, iArr, 0, 0);
        u7.a.o(bArr, iArr, 16, 5);
        iArr[9] = iArr[9] & 16777215;
        int[] iArr2 = new int[10];
        int[] iArr3 = new int[10];
        u7.a.M(iArr, iArr2);
        u7.a.E(f6015i, iArr2, iArr3);
        iArr2[0] = iArr2[0] - 1;
        iArr3[0] = iArr3[0] + 1;
        int[] iArr4 = bVar.f5999a;
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        u7.a.E(iArr2, iArr3, iArr5);
        u7.a.M(iArr3, iArr6);
        u7.a.E(iArr5, iArr6, iArr5);
        u7.a.M(iArr6, iArr6);
        u7.a.E(iArr6, iArr5, iArr6);
        int[] iArr7 = new int[10];
        int[] iArr8 = new int[10];
        u7.a.M(iArr6, iArr7);
        u7.a.E(iArr6, iArr7, iArr7);
        int[] iArr9 = new int[10];
        u7.a.M(iArr7, iArr9);
        u7.a.E(iArr6, iArr9, iArr9);
        u7.a.L(2, iArr9, iArr9);
        u7.a.E(iArr7, iArr9, iArr9);
        int[] iArr10 = new int[10];
        u7.a.L(5, iArr9, iArr10);
        u7.a.E(iArr9, iArr10, iArr10);
        int[] iArr11 = new int[10];
        u7.a.L(5, iArr10, iArr11);
        u7.a.E(iArr9, iArr11, iArr11);
        u7.a.L(10, iArr11, iArr9);
        u7.a.E(iArr10, iArr9, iArr9);
        u7.a.L(25, iArr9, iArr10);
        u7.a.E(iArr9, iArr10, iArr10);
        u7.a.L(25, iArr10, iArr11);
        u7.a.E(iArr9, iArr11, iArr11);
        u7.a.L(50, iArr11, iArr9);
        u7.a.E(iArr10, iArr9, iArr9);
        u7.a.L(125, iArr9, iArr10);
        u7.a.E(iArr9, iArr10, iArr10);
        u7.a.L(2, iArr10, iArr9);
        u7.a.E(iArr9, iArr6, iArr8);
        u7.a.E(iArr8, iArr5, iArr8);
        int[] iArr12 = new int[10];
        u7.a.M(iArr8, iArr12);
        u7.a.E(iArr12, iArr3, iArr12);
        u7.a.P(iArr12, iArr2, iArr7);
        u7.a.H(iArr7);
        if (u7.a.A(iArr7) != 0) {
            u7.a.j(0, 0, iArr8, iArr4);
        } else {
            u7.a.a(iArr12, iArr2, iArr7);
            u7.a.H(iArr7);
            if (u7.a.A(iArr7) == 0) {
                return false;
            }
            u7.a.E(iArr8, u7.a.f5784b, iArr4);
        }
        u7.a.H(iArr4);
        if (i8 == 1 && u7.a.A(iArr4) != 0) {
            return false;
        }
        if (z2 ^ (i8 != (iArr4[0] & 1))) {
            u7.a.G(iArr4, iArr4);
            u7.a.H(iArr4);
        }
        return true;
    }

    public static boolean j(byte[] bArr, boolean z2, b bVar) {
        int i8 = (bArr[56] & 128) >>> 7;
        int[] iArr = bVar.f6000b;
        u7.a.r(bArr, iArr, 0, 0);
        u7.a.r(bArr, iArr, 7, 2);
        u7.a.r(bArr, iArr, 14, 4);
        u7.a.r(bArr, iArr, 21, 6);
        u7.a.r(bArr, iArr, 28, 8);
        u7.a.r(bArr, iArr, 35, 10);
        u7.a.r(bArr, iArr, 42, 12);
        u7.a.r(bArr, iArr, 49, 14);
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[16];
        u7.a.O(iArr, iArr2);
        u7.a.C(39081, iArr2, iArr3);
        u7.a.Q(new int[16], iArr2, iArr2);
        iArr2[0] = iArr2[0] + 1;
        iArr3[0] = iArr3[0] + 1;
        int[] iArr4 = bVar.f5999a;
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        u7.a.O(iArr2, iArr5);
        u7.a.F(iArr5, iArr3, iArr5);
        u7.a.O(iArr5, iArr6);
        u7.a.F(iArr5, iArr2, iArr5);
        u7.a.F(iArr6, iArr2, iArr6);
        u7.a.F(iArr6, iArr3, iArr6);
        int[] iArr7 = new int[16];
        int[] iArr8 = new int[16];
        u7.a.O(iArr6, iArr8);
        u7.a.F(iArr6, iArr8, iArr8);
        int[] iArr9 = new int[16];
        u7.a.O(iArr8, iArr9);
        u7.a.F(iArr6, iArr9, iArr9);
        int[] iArr10 = new int[16];
        u7.a.N(3, iArr9, iArr10);
        u7.a.F(iArr9, iArr10, iArr10);
        int[] iArr11 = new int[16];
        u7.a.N(3, iArr10, iArr11);
        u7.a.F(iArr9, iArr11, iArr11);
        int[] iArr12 = new int[16];
        u7.a.N(9, iArr11, iArr12);
        u7.a.F(iArr11, iArr12, iArr12);
        int[] iArr13 = new int[16];
        u7.a.O(iArr12, iArr13);
        u7.a.F(iArr6, iArr13, iArr13);
        int[] iArr14 = new int[16];
        u7.a.N(18, iArr13, iArr14);
        u7.a.F(iArr12, iArr14, iArr14);
        int[] iArr15 = new int[16];
        u7.a.N(37, iArr14, iArr15);
        u7.a.F(iArr14, iArr15, iArr15);
        int[] iArr16 = new int[16];
        u7.a.N(37, iArr15, iArr16);
        u7.a.F(iArr14, iArr16, iArr16);
        int[] iArr17 = new int[16];
        u7.a.N(111, iArr16, iArr17);
        u7.a.F(iArr16, iArr17, iArr17);
        int[] iArr18 = new int[16];
        u7.a.O(iArr17, iArr18);
        u7.a.F(iArr6, iArr18, iArr18);
        int[] iArr19 = new int[16];
        u7.a.N(223, iArr18, iArr19);
        u7.a.F(iArr19, iArr17, iArr7);
        u7.a.F(iArr7, iArr5, iArr7);
        int[] iArr20 = new int[16];
        u7.a.O(iArr7, iArr20);
        u7.a.F(iArr20, iArr3, iArr20);
        u7.a.Q(iArr2, iArr20, iArr20);
        u7.a.K(1, iArr20);
        u7.a.K(-1, iArr20);
        if (u7.a.B(iArr20) == 0) {
            return false;
        }
        u7.a.k(0, 0, iArr7, iArr4);
        u7.a.K(1, iArr4);
        u7.a.K(-1, iArr4);
        if (i8 == 1 && u7.a.B(iArr4) != 0) {
            return false;
        }
        if (z2 ^ (i8 != (iArr4[0] & 1))) {
            u7.a.Q(new int[16], iArr4, iArr4);
            u7.a.K(1, iArr4);
            u7.a.K(-1, iArr4);
        }
        return true;
    }

    public static void k(SHA512Digest sHA512Digest, byte b9, byte[] bArr) {
        int length = bArr.length + 34;
        byte[] bArr2 = new byte[length];
        System.arraycopy(f6008a, 0, bArr2, 0, 32);
        bArr2[32] = b9;
        bArr2[33] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 34, bArr.length);
        sHA512Digest.update(bArr2, 0, length);
    }

    public static void l(SHAKEDigest sHAKEDigest, byte b9, byte[] bArr) {
        int length = bArr.length + 10;
        byte[] bArr2 = new byte[length];
        System.arraycopy(f6022p, 0, bArr2, 0, 8);
        bArr2[8] = b9;
        bArr2[9] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 10, bArr.length);
        sHAKEDigest.update(bArr2, 0, length);
    }

    public static void m(int i8, int i9, byte[] bArr) {
        bArr[i9] = (byte) i8;
        bArr[i9 + 1] = (byte) (i8 >>> 8);
        bArr[i9 + 2] = (byte) (i8 >>> 16);
        bArr[i9 + 3] = (byte) (i8 >>> 24);
    }

    public static void n(byte[] bArr, int i8, int[] iArr) {
        for (int i9 = 0; i9 < i8; i9++) {
            m(iArr[i9], i9 * 4, bArr);
        }
    }

    public static void o(long j4, byte[] bArr, int i8) {
        m((int) j4, i8, bArr);
        int i9 = (int) (j4 >>> 32);
        bArr[i8 + 4] = (byte) i9;
        bArr[i8 + 5] = (byte) (i9 >>> 8);
        bArr[i8 + 6] = (byte) (i9 >>> 16);
    }

    public static void p(e eVar, byte[] bArr, int i8) {
        int[] iArr = eVar.f6007a;
        u7.a.u(bArr, iArr, 10, i8);
        u7.a.u(bArr, iArr, 15, i8 + 16);
        int i9 = i8 + 31;
        bArr[i9] = (byte) (((eVar.f6007a[0] & 1) << 7) | bArr[i9]);
    }

    public static void q(h hVar, byte[] bArr, int i8) {
        int[] iArr = hVar.f6038a;
        u7.a.x(bArr, iArr, 16, i8);
        u7.a.x(bArr, iArr, 18, i8 + 7);
        u7.a.x(bArr, iArr, 20, i8 + 14);
        u7.a.x(bArr, iArr, 22, i8 + 21);
        u7.a.x(bArr, iArr, 24, i8 + 28);
        u7.a.x(bArr, iArr, 26, i8 + 35);
        u7.a.x(bArr, iArr, 28, i8 + 42);
        u7.a.x(bArr, iArr, 30, i8 + 49);
        bArr[i8 + 56] = (byte) ((hVar.f6038a[0] & 1) << 7);
    }

    public static e r(byte[] bArr) {
        SHA512Digest sHA512DigestC = c();
        byte[] bArr2 = new byte[64];
        sHA512DigestC.update(bArr, 0, 32);
        sHA512DigestC.doFinal(bArr2, 0);
        byte[] bArr3 = new byte[32];
        R(bArr2, bArr3);
        a aVar = new a();
        V(bArr3, aVar);
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        u7.a.y(aVar.f5997c, iArr2);
        u7.a.E(iArr2, aVar.f5995a, iArr);
        u7.a.E(iArr2, aVar.f5996b, iArr2);
        u7.a.H(iArr);
        u7.a.H(iArr2);
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        u7.a.M(iArr, iArr4);
        u7.a.M(iArr2, iArr5);
        u7.a.E(iArr4, iArr5, iArr3);
        u7.a.P(iArr4, iArr5, iArr4);
        u7.a.E(iArr3, f6015i, iArr3);
        iArr3[0] = iArr3[0] + 1;
        u7.a.a(iArr3, iArr4, iArr3);
        u7.a.H(iArr3);
        u7.a.H(iArr5);
        if ((u7.a.A(iArr3) & (~u7.a.A(iArr5))) == 0) {
            throw new IllegalStateException();
        }
        int[] iArr6 = new int[20];
        u7.a.j(0, 0, iArr, iArr6);
        u7.a.j(0, 10, iArr2, iArr6);
        return new e(iArr6);
    }

    public static h s(byte[] bArr) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        byte[] bArr2 = new byte[Ed448PrivateKeyParameters.SIGNATURE_SIZE];
        sHAKEDigest.update(bArr, 0, 57);
        sHAKEDigest.doFinal(bArr2, 0, Ed448PrivateKeyParameters.SIGNATURE_SIZE);
        byte[] bArr3 = new byte[57];
        S(bArr2, bArr3);
        d dVar = new d(1);
        W(bArr3, dVar);
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        u7.a.z(dVar.f6006c, iArr2);
        u7.a.F(iArr2, dVar.f6004a, iArr);
        u7.a.F(iArr2, dVar.f6005b, iArr2);
        u7.a.K(1, iArr);
        u7.a.K(-1, iArr);
        u7.a.K(1, iArr2);
        u7.a.K(-1, iArr2);
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        u7.a.O(iArr, iArr4);
        u7.a.O(iArr2, iArr5);
        u7.a.F(iArr4, iArr5, iArr3);
        u7.a.b(iArr4, iArr5, iArr4);
        u7.a.C(39081, iArr3, iArr3);
        int[] iArr6 = new int[16];
        iArr6[0] = 1;
        u7.a.Q(iArr3, iArr6, iArr3);
        u7.a.b(iArr3, iArr4, iArr3);
        u7.a.K(1, iArr3);
        u7.a.K(-1, iArr3);
        u7.a.K(1, iArr5);
        u7.a.K(-1, iArr5);
        if ((u7.a.B(iArr3) & (~u7.a.B(iArr5))) == 0) {
            throw new IllegalStateException();
        }
        int[] iArr7 = new int[32];
        u7.a.k(0, 0, iArr, iArr7);
        u7.a.k(0, 16, iArr2, iArr7);
        return new h(iArr7);
    }

    public static int t(int i8, int[] iArr) {
        int i9 = iArr[i8] >> 31;
        while (i8 > 0 && iArr[i8] == i9) {
            i8--;
        }
        return ((i8 * 32) + 32) - Integers.numberOfLeadingZeros(iArr[i8] ^ i9);
    }

    public static int u(int i8, int[] iArr) {
        while (i8 > 0 && iArr[i8] == 0) {
            i8--;
        }
        return ((i8 * 32) + 32) - Integers.numberOfLeadingZeros(iArr[i8]);
    }

    public static void v(byte[] bArr, int i8, int[] iArr) {
        int length = iArr.length * 2;
        int[] iArr2 = new int[length];
        int i9 = iArr[iArr.length - 1] >> 31;
        int length2 = iArr.length;
        int i10 = length;
        while (true) {
            length2--;
            if (length2 < 0) {
                break;
            }
            int i11 = iArr[length2];
            iArr2[i10 - 1] = (i9 << 16) | (i11 >>> 16);
            i10 -= 2;
            iArr2[i10] = i11;
            i9 = i11;
        }
        int i12 = 32 - i8;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < length) {
            int i16 = iArr2[i13];
            while (i14 < 16) {
                int i17 = i16 >>> i14;
                if ((i17 & 1) == i15) {
                    i14++;
                } else {
                    int i18 = (i17 | 1) << i12;
                    bArr[(i13 << 4) + i14] = (byte) (i18 >> i12);
                    i14 += i8;
                    i15 = i18 >>> 31;
                }
            }
            i13++;
            i14 -= 16;
        }
    }

    public static void w(byte[] bArr, byte[] bArr2, byte[] bArr3, byte b9, byte[] bArr4, int i8, int i9, byte[] bArr5, int i10) {
        if (!(bArr3 == null && b9 == 0) && (bArr3 == null || bArr3.length >= 256)) {
            throw new IllegalArgumentException("ctx");
        }
        SHA512Digest sHA512DigestC = c();
        byte[] bArr6 = new byte[64];
        sHA512DigestC.update(bArr, 0, 32);
        sHA512DigestC.doFinal(bArr6, 0);
        byte[] bArr7 = new byte[32];
        R(bArr6, bArr7);
        if (bArr3 != null) {
            k(sHA512DigestC, b9, bArr3);
        }
        sHA512DigestC.update(bArr6, 32, 32);
        sHA512DigestC.update(bArr4, i8, i9);
        sHA512DigestC.doFinal(bArr6, 0);
        byte[] bArrT = T(bArr6);
        byte[] bArr8 = new byte[32];
        a aVar = new a();
        V(bArrT, aVar);
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        u7.a.y(aVar.f5997c, iArr2);
        u7.a.E(iArr2, aVar.f5995a, iArr);
        u7.a.E(iArr2, aVar.f5996b, iArr2);
        u7.a.H(iArr);
        u7.a.H(iArr2);
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        u7.a.M(iArr, iArr4);
        u7.a.M(iArr2, iArr5);
        u7.a.E(iArr4, iArr5, iArr3);
        u7.a.P(iArr4, iArr5, iArr4);
        u7.a.E(iArr3, f6015i, iArr3);
        iArr3[0] = iArr3[0] + 1;
        u7.a.a(iArr3, iArr4, iArr3);
        u7.a.H(iArr3);
        u7.a.H(iArr5);
        int iA = u7.a.A(iArr3) & (~u7.a.A(iArr5));
        u7.a.u(bArr8, iArr2, 0, 0);
        u7.a.u(bArr8, iArr2, 5, 16);
        bArr8[31] = (byte) (((iArr[0] & 1) << 7) | bArr8[31]);
        if (iA == 0) {
            throw new IllegalStateException();
        }
        if (bArr3 != null) {
            k(sHA512DigestC, b9, bArr3);
        }
        sHA512DigestC.update(bArr8, 0, 32);
        sHA512DigestC.update(bArr2, 0, 32);
        sHA512DigestC.update(bArr4, i8, i9);
        sHA512DigestC.doFinal(bArr6, 0);
        byte[] bArrT2 = T(bArr6);
        int[] iArr6 = new int[16];
        d(bArrT, iArr6);
        int[] iArr7 = new int[8];
        d(bArrT2, iArr7);
        int[] iArr8 = new int[8];
        d(bArr7, iArr8);
        x.e.f0(iArr7, iArr8, iArr6);
        byte[] bArr9 = new byte[64];
        n(bArr9, 16, iArr6);
        byte[] bArrT3 = T(bArr9);
        System.arraycopy(bArr8, 0, bArr5, i10, 32);
        System.arraycopy(bArrT3, 0, bArr5, i10 + 32, 32);
    }

    public static void x(byte[] bArr, byte[] bArr2, byte[] bArr3, byte b9, byte[] bArr4, int i8, int i9, byte[] bArr5, int i10) {
        if (bArr3.length >= 256) {
            throw new IllegalArgumentException("ctx");
        }
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        byte[] bArr6 = new byte[Ed448PrivateKeyParameters.SIGNATURE_SIZE];
        sHAKEDigest.update(bArr, 0, 57);
        sHAKEDigest.doFinal(bArr6, 0, Ed448PrivateKeyParameters.SIGNATURE_SIZE);
        byte[] bArr7 = new byte[57];
        S(bArr6, bArr7);
        l(sHAKEDigest, b9, bArr3);
        sHAKEDigest.update(bArr6, 57, 57);
        sHAKEDigest.update(bArr4, i8, i9);
        sHAKEDigest.doFinal(bArr6, 0, Ed448PrivateKeyParameters.SIGNATURE_SIZE);
        byte[] bArrU = U(bArr6);
        byte[] bArr8 = new byte[57];
        d dVar = new d(1);
        W(bArrU, dVar);
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        u7.a.z(dVar.f6006c, iArr2);
        u7.a.F(iArr2, dVar.f6004a, iArr);
        u7.a.F(iArr2, dVar.f6005b, iArr2);
        u7.a.K(1, iArr);
        u7.a.K(-1, iArr);
        u7.a.K(1, iArr2);
        u7.a.K(-1, iArr2);
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        u7.a.O(iArr, iArr4);
        u7.a.O(iArr2, iArr5);
        u7.a.F(iArr4, iArr5, iArr3);
        u7.a.b(iArr4, iArr5, iArr4);
        u7.a.C(39081, iArr3, iArr3);
        int[] iArr6 = new int[16];
        iArr6[0] = 1;
        u7.a.Q(iArr3, iArr6, iArr3);
        u7.a.b(iArr3, iArr4, iArr3);
        u7.a.K(1, iArr3);
        u7.a.K(-1, iArr3);
        u7.a.K(1, iArr5);
        u7.a.K(-1, iArr5);
        int iB = (~u7.a.B(iArr5)) & u7.a.B(iArr3);
        u7.a.s(bArr8, 0, iArr2);
        bArr8[56] = (byte) ((1 & iArr[0]) << 7);
        if (iB == 0) {
            throw new IllegalStateException();
        }
        l(sHAKEDigest, b9, bArr3);
        sHAKEDigest.update(bArr8, 0, 57);
        sHAKEDigest.update(bArr2, 0, 57);
        sHAKEDigest.update(bArr4, i8, i9);
        sHAKEDigest.doFinal(bArr6, 0, Ed448PrivateKeyParameters.SIGNATURE_SIZE);
        byte[] bArrU2 = U(bArr6);
        int[] iArr7 = new int[28];
        e(bArrU, iArr7);
        e(bArrU2, new int[14]);
        e(bArr7, new int[14]);
        long j4 = 0;
        for (int i11 = 0; i11 < 14; i11++) {
            long jV0 = j4 + (x.f.v0(14, r0, r4[i11], iArr7, i11) & 4294967295L) + (iArr7[r7] & 4294967295L);
            iArr7[i11 + 14] = (int) jV0;
            j4 = jV0 >>> 32;
        }
        byte[] bArr9 = new byte[Ed448PrivateKeyParameters.SIGNATURE_SIZE];
        n(bArr9, 28, iArr7);
        byte[] bArrU3 = U(bArr9);
        System.arraycopy(bArr8, 0, bArr5, i10, 57);
        System.arraycopy(bArrU3, 0, bArr5, i10 + 57, 57);
    }

    public static boolean y(byte[] bArr, int i8, e eVar, byte[] bArr2, byte b9, byte[] bArr3, int i9, int i10) {
        boolean z2;
        char c3;
        boolean z8;
        int i11;
        int[] iArr;
        int i12;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        boolean z9;
        if (!(bArr2 == null && b9 == 0) && (bArr2 == null || bArr2.length >= 256)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArr4 = new byte[32];
        System.arraycopy(bArr, i8, bArr4, 0, 32);
        byte[] bArr5 = new byte[32];
        System.arraycopy(bArr, i8 + 32, bArr5, 0, 32);
        int iG = g(bArr4, 28) & Integer.MAX_VALUE;
        int[] iArr6 = f6009b;
        if (iG < iArr6[7]) {
            z2 = true;
        } else {
            int[] iArr7 = new int[8];
            h(bArr4, 8, iArr7);
            iArr7[7] = Integer.MAX_VALUE & iArr7[7];
            z2 = !x.e.P(iArr7, iArr6);
        }
        if (z2) {
            int[] iArr8 = new int[8];
            d(bArr5, iArr8);
            int[] iArr9 = z;
            if (!x.e.P(iArr8, iArr9)) {
                b bVar = new b(0);
                if (i(bArr4, true, bVar)) {
                    b bVar2 = new b(0);
                    u7.a.G(eVar.f6007a, bVar2.f5999a);
                    u7.a.j(10, 0, eVar.f6007a, bVar2.f6000b);
                    byte[] bArr6 = new byte[32];
                    p(eVar, bArr6, 0);
                    SHA512Digest sHA512DigestC = c();
                    byte[] bArr7 = new byte[64];
                    if (bArr2 != null) {
                        k(sHA512DigestC, b9, bArr2);
                    }
                    sHA512DigestC.update(bArr4, 0, 32);
                    sHA512DigestC.update(bArr6, 0, 32);
                    sHA512DigestC.update(bArr3, i9, i10);
                    sHA512DigestC.doFinal(bArr7, 0);
                    int[] iArr10 = new int[8];
                    d(T(bArr7), iArr10);
                    int[] iArr11 = new int[4];
                    int[] iArr12 = new int[4];
                    int[] iArr13 = new int[16];
                    System.arraycopy(A, 0, iArr13, 0, 16);
                    int[] iArr14 = new int[16];
                    x.e.j0(iArr10, iArr14);
                    iArr14[0] = iArr14[0] + 1;
                    int[] iArr15 = new int[16];
                    x.e.c0(iArr9, iArr10, iArr15);
                    int[] iArr16 = new int[16];
                    int[] iArr17 = new int[4];
                    System.arraycopy(iArr9, 0, iArr17, 0, 4);
                    int[] iArr18 = new int[4];
                    System.arraycopy(iArr10, 0, iArr18, 0, 4);
                    int[] iArr19 = new int[4];
                    iArr19[0] = 1;
                    int i13 = 15;
                    int i14 = 1016;
                    int[] iArr20 = new int[4];
                    int iU = u(15, iArr14);
                    while (true) {
                        if (iU <= 254) {
                            c3 = 0;
                            System.arraycopy(iArr18, 0, iArr11, 0, 4);
                            System.arraycopy(iArr19, 0, iArr12, 0, 4);
                            z8 = true;
                            break;
                        }
                        i14--;
                        if (i14 < 0) {
                            c3 = 0;
                            z8 = false;
                            break;
                        }
                        int iT = t(i13, iArr15) - iU;
                        int i15 = iT & (~(iT >> 31));
                        int i16 = i13;
                        int[] iArr21 = iArr16;
                        int[] iArr22 = iArr13;
                        int[] iArr23 = iArr14;
                        int[] iArr24 = iArr15;
                        if (iArr15[i13] < 0) {
                            a(i16, i15, iArr22, iArr23, iArr24, iArr21);
                            i12 = i16;
                            iArr2 = iArr24;
                            iArr3 = iArr21;
                            int[] iArr25 = iArr20;
                            b(3, i15, iArr17, iArr25, iArr18, iArr19);
                            iArr = iArr25;
                        } else {
                            iArr = iArr20;
                            X(i16, i15, iArr22, iArr23, iArr24, iArr21);
                            i12 = i16;
                            iArr2 = iArr24;
                            iArr3 = iArr21;
                            Y(3, i15, iArr17, iArr, iArr18, iArr19);
                        }
                        int i17 = i12;
                        while (true) {
                            iArr4 = iArr2;
                            int i18 = iArr13[i17] - Integer.MIN_VALUE;
                            iArr5 = iArr3;
                            int i19 = iArr14[i17] - Integer.MIN_VALUE;
                            if (i18 < i19) {
                                z9 = true;
                                break;
                            }
                            if (i18 > i19 || i17 - 1 < 0) {
                                break;
                            }
                            iArr2 = iArr4;
                            iArr3 = iArr5;
                        }
                        z9 = false;
                        if (z9) {
                            int i20 = iU >>> 5;
                            int iU2 = u(i20, iArr13);
                            int[] iArr26 = iArr18;
                            iArr18 = iArr17;
                            iArr17 = iArr26;
                            int[] iArr27 = iArr14;
                            iArr14 = iArr13;
                            iArr13 = iArr27;
                            iU = iU2;
                            iArr20 = iArr19;
                            iArr19 = iArr;
                            i13 = i20;
                        } else {
                            i13 = i12;
                            iArr20 = iArr;
                        }
                        iArr15 = iArr4;
                        iArr16 = iArr5;
                    }
                    if (!z8) {
                        throw new IllegalStateException();
                    }
                    long j4 = iArr8[c3] & 4294967295L;
                    long j8 = iArr8[1] & 4294967295L;
                    long j9 = iArr8[2] & 4294967295L;
                    long j10 = iArr8[3] & 4294967295L;
                    long j11 = iArr8[4] & 4294967295L;
                    long j12 = iArr8[5] & 4294967295L;
                    long j13 = iArr8[6] & 4294967295L;
                    long j14 = iArr8[7] & 4294967295L;
                    long j15 = iArr12[0] & 4294967295L;
                    long j16 = j15 * j4;
                    long j17 = (j15 * j8) + (j16 >>> 32);
                    long j18 = (j15 * j9) + (j17 >>> 32);
                    long j19 = (j15 * j10) + (j18 >>> 32);
                    long j20 = (j15 * j11) + (j19 >>> 32);
                    long j21 = (j15 * j12) + (j20 >>> 32);
                    long j22 = (j15 * j13) + (j21 >>> 32);
                    long j23 = (j15 * j14) + (j22 >>> 32);
                    int[] iArr28 = {(int) j16, (int) j17, (int) j18, (int) j19, (int) j20, (int) j21, (int) j22, (int) j23, (int) (j23 >>> 32), 0, 0, 0};
                    int i21 = 1;
                    while (i21 < 4) {
                        long j24 = iArr12[i21] & 4294967295L;
                        int i22 = i21;
                        long j25 = (j24 * j4) + (iArr28[i22] & 4294967295L);
                        iArr28[i22] = (int) j25;
                        int i23 = i22 + 1;
                        long j26 = (j24 * j8) + (iArr28[i23] & 4294967295L) + (j25 >>> 32);
                        iArr28[i23] = (int) j26;
                        long j27 = (j24 * j9) + (iArr28[r2] & 4294967295L) + (j26 >>> 32);
                        iArr28[i22 + 2] = (int) j27;
                        long j28 = (j24 * j10) + (iArr28[r2] & 4294967295L) + (j27 >>> 32);
                        iArr28[i22 + 3] = (int) j28;
                        long j29 = (j24 * j11) + (iArr28[r2] & 4294967295L) + (j28 >>> 32);
                        iArr28[i22 + 4] = (int) j29;
                        long j30 = (j24 * j12) + (iArr28[r2] & 4294967295L) + (j29 >>> 32);
                        iArr28[i22 + 5] = (int) j30;
                        long j31 = (j24 * j13) + (iArr28[r2] & 4294967295L) + (j30 >>> 32);
                        iArr28[i22 + 6] = (int) j31;
                        long j32 = (j24 * j14) + (iArr28[r2] & 4294967295L) + (j31 >>> 32);
                        iArr28[i22 + 7] = (int) j32;
                        iArr28[i22 + 8] = (int) (j32 >>> 32);
                        i21 = i23;
                    }
                    if (iArr12[3] < 0) {
                        x.e.h(0, iArr9, 4, iArr28, 0);
                        long j33 = ((iArr28[4] & 4294967295L) - (iArr8[0] & 4294967295L)) + (0 & 4294967295L);
                        iArr28[4] = (int) j33;
                        long j34 = ((iArr28[5] & 4294967295L) - (iArr8[1] & 4294967295L)) + (j33 >> 32);
                        iArr28[5] = (int) j34;
                        long j35 = ((iArr28[6] & 4294967295L) - (iArr8[2] & 4294967295L)) + (j34 >> 32);
                        iArr28[6] = (int) j35;
                        long j36 = ((iArr28[7] & 4294967295L) - (iArr8[3] & 4294967295L)) + (j35 >> 32);
                        iArr28[7] = (int) j36;
                        long j37 = ((iArr28[8] & 4294967295L) - (iArr8[4] & 4294967295L)) + (j36 >> 32);
                        iArr28[8] = (int) j37;
                        long j38 = ((iArr28[9] & 4294967295L) - (iArr8[5] & 4294967295L)) + (j37 >> 32);
                        iArr28[9] = (int) j38;
                        long j39 = ((iArr28[10] & 4294967295L) - (iArr8[6] & 4294967295L)) + (j38 >> 32);
                        iArr28[10] = (int) j39;
                        iArr28[11] = (int) (((iArr28[11] & 4294967295L) - (iArr8[7] & 4294967295L)) + (j39 >> 32));
                    }
                    byte[] bArr8 = new byte[48];
                    n(bArr8, 12, iArr28);
                    long jG = g(bArr8, 0) & 4294967295L;
                    long jF = (f(bArr8, 4) << 4) & 4294967295L;
                    long jG2 = g(bArr8, 7) & 4294967295L;
                    long jF2 = (f(bArr8, 11) << 4) & 4294967295L;
                    long jG3 = g(bArr8, 14) & 4294967295L;
                    long jF3 = (f(bArr8, 18) << 4) & 4294967295L;
                    long jG4 = g(bArr8, 21) & 4294967295L;
                    long jF4 = (f(bArr8, 25) << 4) & 4294967295L;
                    long jG5 = g(bArr8, 28) & 4294967295L;
                    long jF5 = f(bArr8, 32) << 4;
                    long j40 = jF5 & 4294967295L;
                    long jG6 = g(bArr8, 35);
                    long j41 = jG6 & 4294967295L;
                    long jF6 = f(bArr8, 39) << 4;
                    long jG7 = g(bArr8, 42);
                    long j42 = ((((bArr8[46] & 255) | ((bArr8[47] & 255) << 8)) << 4) & 4294967295L) + ((jG7 & 4294967295L) >> 28);
                    long j43 = (jG7 & 268435455) + ((jF6 & 4294967295L) >> 28);
                    long j44 = (jF4 - (j42 * (-6428113))) - (j43 * 5343);
                    long j45 = (jF6 & 268435455) + (j41 >> 28);
                    long j46 = ((jG4 - (j42 * 127719000)) - (j43 * (-6428113))) - (j45 * 5343);
                    long j47 = (jG6 & 268435455) + (j40 >> 28);
                    long j48 = (jG2 - (j45 * (-50998291))) - (j47 * 19280294);
                    long j49 = ((jF2 - (j43 * (-50998291))) - (j45 * 19280294)) - (j47 * 127719000);
                    long j50 = (((jG3 - (j42 * (-50998291))) - (j43 * 19280294)) - (j45 * 127719000)) - (j47 * (-6428113));
                    long j51 = (((jF3 - (j42 * 19280294)) - (j43 * 127719000)) - (j45 * (-6428113))) - (j47 * 5343);
                    long j52 = (jG5 - (j42 * 5343)) + (j44 >> 28);
                    long j53 = (jF5 & 268435455) + (j52 >> 28);
                    long j54 = j52 & 268435455;
                    long j55 = j54 >>> 27;
                    long j56 = j53 + j55;
                    long j57 = jG - (j56 * (-50998291));
                    long j58 = j49 - (j56 * (-6428113));
                    long j59 = j50 - (j56 * 5343);
                    long j60 = ((jF - (j47 * (-50998291))) - (j56 * 19280294)) + (j57 >> 28);
                    long j61 = (j48 - (j56 * 127719000)) + (j60 >> 28);
                    long j62 = j60 & 268435455;
                    long j63 = j58 + (j61 >> 28);
                    long j64 = j59 + (j63 >> 28);
                    long j65 = j51 + (j64 >> 28);
                    long j66 = j46 + (j65 >> 28);
                    long j67 = (j44 & 268435455) + (j66 >> 28);
                    long j68 = j54 + (j67 >> 28);
                    long j69 = (j68 >> 28) - j55;
                    long j70 = (j57 & 268435455) + (j69 & (-50998291));
                    long j71 = j62 + (j69 & 19280294) + (j70 >> 28);
                    long j72 = (j61 & 268435455) + (j69 & 127719000) + (j71 >> 28);
                    long j73 = (j63 & 268435455) + (j69 & (-6428113)) + (j72 >> 28);
                    long j74 = (j64 & 268435455) + (j69 & 5343) + (j73 >> 28);
                    long j75 = (j65 & 268435455) + (j74 >> 28);
                    long j76 = (j66 & 268435455) + (j75 >> 28);
                    long j77 = (j67 & 268435455) + (j76 >> 28);
                    byte[] bArr9 = new byte[64];
                    o((j70 & 268435455) | ((j71 & 268435455) << 28), bArr9, 0);
                    o(((j73 & 268435455) << 28) | (j72 & 268435455), bArr9, 7);
                    o((j74 & 268435455) | ((j75 & 268435455) << 28), bArr9, 14);
                    o((j76 & 268435455) | ((j77 & 268435455) << 28), bArr9, 21);
                    m((int) ((j68 & 268435455) + (j77 >> 28)), 28, bArr9);
                    d(bArr9, iArr8);
                    a aVar = new a();
                    P();
                    byte[] bArr10 = new byte[256];
                    int i24 = 128;
                    byte[] bArr11 = new byte[128];
                    byte[] bArr12 = new byte[128];
                    v(bArr10, 6, iArr8);
                    v(bArr11, 4, iArr11);
                    v(bArr12, 4, iArr12);
                    c[] cVarArr = new c[4];
                    c[] cVarArr2 = new c[4];
                    b bVar3 = new b(1);
                    O(bVar2, cVarArr, bVar3);
                    O(bVar, cVarArr2, bVar3);
                    int i25 = 10;
                    for (int i26 = 0; i26 < 10; i26++) {
                        aVar.f5995a[i26] = 0;
                    }
                    int i27 = 0;
                    u7.a.I(aVar.f5996b);
                    u7.a.I(aVar.f5997c);
                    int i28 = 0;
                    while (i28 < i25) {
                        aVar.d[i28] = i27;
                        i28++;
                        i25 = 10;
                        i27 = 0;
                    }
                    u7.a.I(aVar.f5998e);
                    while (true) {
                        i11 = i24 - 1;
                        if (i11 < 0 || (bArr10[i24 + 127] | bArr10[i11] | bArr11[i11] | bArr12[i11]) != 0) {
                            break;
                        }
                        i24 = i11;
                    }
                    while (i11 >= 0) {
                        byte b10 = bArr10[i11];
                        if (b10 != 0) {
                            G(b10 < 0, f6019m[(b10 >> 1) ^ (b10 >> 31)], aVar, bVar3);
                        }
                        byte b11 = bArr10[i11 + 128];
                        if (b11 != 0) {
                            G(b11 < 0, f6020n[(b11 >> 1) ^ (b11 >> 31)], aVar, bVar3);
                        }
                        byte b12 = bArr11[i11];
                        if (b12 != 0) {
                            F(b12 < 0, cVarArr[(b12 >> 1) ^ (b12 >> 31)], aVar, bVar3);
                        }
                        byte b13 = bArr12[i11];
                        if (b13 != 0) {
                            F(b13 < 0, cVarArr2[(b13 >> 1) ^ (b13 >> 31)], aVar, bVar3);
                        }
                        L(aVar);
                        i11--;
                    }
                    L(aVar);
                    L(aVar);
                    u7.a.H(aVar.f5995a);
                    int[] iArr29 = aVar.f5996b;
                    u7.a.H(iArr29);
                    int[] iArr30 = aVar.f5997c;
                    u7.a.H(iArr30);
                    if (u7.a.A(aVar.f5995a) != 0) {
                        if (!(u7.a.A(iArr29) != 0)) {
                            int i29 = 0;
                            for (int i30 = 0; i30 < 10; i30++) {
                                i29 |= iArr29[i30] ^ iArr30[i30];
                            }
                            if (((((i29 >>> 1) | (i29 & 1)) - 1) >> 31) != 0) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean z(byte[] bArr, int i8, h hVar, byte[] bArr2, byte b9, byte[] bArr3, int i9, int i10) {
        boolean z2;
        boolean z8;
        b bVar;
        int i11;
        int[] iArr;
        int i12;
        int[] iArr2;
        char c3;
        int[] iArr3;
        boolean z9;
        int i13;
        int[] iArr4;
        boolean z10;
        if (bArr2.length >= 256) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArr4 = new byte[57];
        System.arraycopy(bArr, i8, bArr4, 0, 57);
        byte[] bArr5 = new byte[57];
        System.arraycopy(bArr, i8 + 57, bArr5, 0, 57);
        if ((bArr4[56] & AbstractJsonLexerKt.TC_INVALID) != 0) {
            z2 = false;
        } else {
            int iG = g(bArr4, 52);
            int[] iArr5 = f6023q;
            if (iG != iArr5[13]) {
                z2 = true;
            } else {
                int[] iArr6 = new int[14];
                h(bArr4, 14, iArr6);
                z2 = !x.f.X(14, iArr6, iArr5);
            }
        }
        if (z2) {
            int[] iArr7 = new int[14];
            byte b10 = bArr5[56];
            int[] iArr8 = B;
            if (b10 != 0) {
                z8 = false;
            } else {
                e(bArr5, iArr7);
                z8 = !x.f.X(14, iArr7, iArr8);
            }
            if (z8) {
                b bVar2 = new b(2);
                if (j(bArr4, true, bVar2)) {
                    b bVar3 = new b(2);
                    u7.a.Q(new int[16], hVar.f6038a, bVar3.f5999a);
                    u7.a.k(16, 0, hVar.f6038a, bVar3.f6000b);
                    byte[] bArr6 = new byte[57];
                    q(hVar, bArr6, 0);
                    SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
                    byte[] bArr7 = new byte[Ed448PrivateKeyParameters.SIGNATURE_SIZE];
                    l(sHAKEDigest, b9, bArr2);
                    sHAKEDigest.update(bArr4, 0, 57);
                    sHAKEDigest.update(bArr6, 0, 57);
                    sHAKEDigest.update(bArr3, i9, i10);
                    sHAKEDigest.doFinal(bArr7, 0, Ed448PrivateKeyParameters.SIGNATURE_SIZE);
                    int[] iArr9 = new int[14];
                    e(U(bArr7), iArr9);
                    int i14 = 8;
                    int[] iArr10 = new int[8];
                    int[] iArr11 = new int[8];
                    int[] iArr12 = new int[28];
                    System.arraycopy(C, 0, iArr12, 0, 28);
                    int[] iArr13 = new int[28];
                    x.f.B0(iArr9, iArr13);
                    int[] iArr14 = iArr7;
                    long j4 = iArr9[7] & 4294967295L;
                    int i15 = 6;
                    int i16 = 0;
                    int i17 = 14;
                    while (true) {
                        int i18 = i15 - 1;
                        bVar = bVar3;
                        long j8 = iArr9[i15 + 7] & 4294967295L;
                        long j9 = j8 * j8;
                        i11 = i14;
                        iArr = iArr9;
                        iArr13[i17 + 13] = (i16 << 31) | ((int) (j9 >>> 33));
                        int i19 = i17 - 2;
                        iArr13[i17 + 12] = (int) (j9 >>> 1);
                        i12 = (int) j9;
                        if (i18 <= 0) {
                            break;
                        }
                        i17 = i19;
                        i16 = i12;
                        j4 = j4;
                        i15 = i18;
                        bVar3 = bVar;
                        iArr9 = iArr;
                        i14 = i11;
                    }
                    long j10 = j4 * j4;
                    iArr13[14] = (int) j10;
                    long j11 = iArr[i11] & 4294967295L;
                    long j12 = (j11 * j4) + (((i12 << 31) & 4294967295L) | (j10 >>> 33));
                    int i20 = (int) j12;
                    iArr13[15] = (i20 << 1) | (((int) (j10 >>> 32)) & 1);
                    int i21 = i20 >>> 31;
                    long j13 = (iArr13[16] & 4294967295L) + (j12 >>> 32);
                    long j14 = iArr[9] & 4294967295L;
                    long j15 = (j14 * j4) + j13;
                    int i22 = (int) j15;
                    iArr13[16] = (i22 << 1) | i21;
                    long jH = a8.b.h(j14, j11, j15 >>> 32, iArr13[17] & 4294967295L);
                    long j16 = (iArr13[18] & 4294967295L) + (jH >>> 32);
                    long j17 = iArr[10] & 4294967295L;
                    long j18 = (iArr13[19] & 4294967295L) + (j16 >>> 32);
                    long j19 = (iArr13[20] & 4294967295L) + (j18 >>> 32);
                    long j20 = j18 & 4294967295L;
                    long j21 = (j17 * j4) + (jH & 4294967295L);
                    int i23 = (int) j21;
                    iArr13[17] = (i23 << 1) | (i22 >>> 31);
                    long jH2 = a8.b.h(j17, j11, j21 >>> 32, j16 & 4294967295L);
                    long jH3 = a8.b.h(j17, j14, jH2 >>> 32, j20);
                    long j22 = j19 + (jH3 >>> 32);
                    long j23 = jH3 & 4294967295L;
                    long j24 = iArr[11] & 4294967295L;
                    long j25 = (iArr13[21] & 4294967295L) + (j22 >>> 32);
                    long j26 = j22 & 4294967295L;
                    long j27 = (iArr13[22] & 4294967295L) + (j25 >>> 32);
                    long j28 = (j24 * j4) + (jH2 & 4294967295L);
                    int i24 = (int) j28;
                    iArr13[18] = (i24 << 1) | (i23 >>> 31);
                    int i25 = i24 >>> 31;
                    long jH4 = a8.b.h(j24, j11, j28 >>> 32, j23);
                    long jH5 = a8.b.h(j24, j14, jH4 >>> 32, j26);
                    long jH6 = a8.b.h(j24, j17, jH5 >>> 32, j25 & 4294967295L);
                    long j29 = j27 + (jH6 >>> 32);
                    long j30 = jH6 & 4294967295L;
                    long j31 = iArr[12] & 4294967295L;
                    long j32 = (iArr13[23] & 4294967295L) + (j29 >>> 32);
                    long j33 = (iArr13[24] & 4294967295L) + (j32 >>> 32);
                    long j34 = j32 & 4294967295L;
                    long j35 = (j31 * j4) + (jH4 & 4294967295L);
                    int i26 = (int) j35;
                    iArr13[19] = i25 | (i26 << 1);
                    long jH7 = a8.b.h(j31, j11, j35 >>> 32, jH5 & 4294967295L);
                    long jH8 = a8.b.h(j31, j14, jH7 >>> 32, j30);
                    long jH9 = a8.b.h(j31, j17, jH8 >>> 32, j29 & 4294967295L);
                    long j36 = jH8 & 4294967295L;
                    long jH10 = a8.b.h(j31, j24, jH9 >>> 32, j34);
                    long j37 = jH9 & 4294967295L;
                    long j38 = j33 + (jH10 >>> 32);
                    long j39 = iArr[13] & 4294967295L;
                    long j40 = (iArr13[25] & 4294967295L) + (j38 >>> 32);
                    long j41 = j38 & 4294967295L;
                    long j42 = (iArr13[26] & 4294967295L) + (j40 >>> 32);
                    long j43 = j40 & 4294967295L;
                    long j44 = (j4 * j39) + (jH7 & 4294967295L);
                    int i27 = (int) j44;
                    iArr13[20] = (i26 >>> 31) | (i27 << 1);
                    int i28 = i27 >>> 31;
                    long jH11 = a8.b.h(j39, j11, j44 >>> 32, j36);
                    long jH12 = a8.b.h(j39, j14, jH11 >>> 32, j37);
                    long jH13 = a8.b.h(j39, j17, jH12 >>> 32, jH10 & 4294967295L);
                    long jH14 = a8.b.h(j39, j24, jH13 >>> 32, j41);
                    int i29 = 25;
                    long jH15 = a8.b.h(j39, j31, jH14 >>> 32, j43);
                    long j45 = j42 + (jH15 >>> 32);
                    int i30 = (int) jH11;
                    iArr13[21] = (i30 << 1) | i28;
                    int i31 = (int) jH12;
                    iArr13[22] = (i30 >>> 31) | (i31 << 1);
                    int i32 = i31 >>> 31;
                    int i33 = (int) jH13;
                    iArr13[23] = i32 | (i33 << 1);
                    int i34 = i33 >>> 31;
                    int i35 = (int) jH14;
                    iArr13[24] = i34 | (i35 << 1);
                    int i36 = i35 >>> 31;
                    int i37 = (int) jH15;
                    iArr13[25] = i36 | (i37 << 1);
                    int i38 = i37 >>> 31;
                    int i39 = (int) j45;
                    iArr13[26] = i38 | (i39 << 1);
                    iArr13[27] = (i39 >>> 31) | ((iArr13[27] + ((int) (j45 >>> 32))) << 1);
                    int iL = x.f.l(iArr13, iArr13);
                    int iJ = x.f.j(21, iArr13, 14, iArr13, x.f.j(0, iArr13, 7, iArr13, 0) + iL) + iL;
                    int[] iArr15 = new int[7];
                    x.f.D(iArr, iArr, iArr15);
                    int[] iArr16 = new int[14];
                    x.f.B0(iArr15, iArr16);
                    x.f.m(iArr13, 28, x.f.H0(14, 7, iArr16, iArr13) + iJ, 21);
                    iArr13[0] = iArr13[0] + 1;
                    int[] iArr17 = new int[28];
                    x.f.s0(iArr8, iArr, iArr17);
                    long j46 = iArr[7] & 4294967295L;
                    long j47 = iArr[i11] & 4294967295L;
                    long j48 = iArr[9] & 4294967295L;
                    long j49 = iArr[10] & 4294967295L;
                    long j50 = iArr[11] & 4294967295L;
                    long j51 = iArr[12] & 4294967295L;
                    long j52 = iArr[13] & 4294967295L;
                    long j53 = iArr8[7] & 4294967295L;
                    long j54 = j53 * j46;
                    iArr17[14] = (int) j54;
                    long j55 = (j53 * j47) + (j54 >>> 32);
                    iArr17[15] = (int) j55;
                    long j56 = (j53 * j48) + (j55 >>> 32);
                    iArr17[16] = (int) j56;
                    long j57 = (j53 * j49) + (j56 >>> 32);
                    iArr17[17] = (int) j57;
                    long j58 = (j53 * j50) + (j57 >>> 32);
                    iArr17[18] = (int) j58;
                    long j59 = (j53 * j51) + (j58 >>> 32);
                    iArr17[19] = (int) j59;
                    long j60 = (j53 * j52) + (j59 >>> 32);
                    iArr17[20] = (int) j60;
                    iArr17[21] = (int) (j60 >>> 32);
                    int i40 = 1;
                    int i41 = 14;
                    while (i40 < 7) {
                        int i42 = i41 + 1;
                        int i43 = i40;
                        int i44 = i41;
                        long j61 = iArr8[7 + i40] & 4294967295L;
                        long j62 = (j61 * j46) + (iArr17[i42] & 4294967295L);
                        iArr17[i42] = (int) j62;
                        long j63 = (j61 * j47) + (iArr17[r3] & 4294967295L) + (j62 >>> 32);
                        iArr17[i44 + 2] = (int) j63;
                        long j64 = (j61 * j48) + (iArr17[r3] & 4294967295L) + (j63 >>> 32);
                        iArr17[i44 + 3] = (int) j64;
                        long j65 = (j61 * j49) + (iArr17[r3] & 4294967295L) + (j64 >>> 32);
                        iArr17[i44 + 4] = (int) j65;
                        long j66 = (j61 * j50) + (iArr17[r3] & 4294967295L) + (j65 >>> 32);
                        iArr17[i44 + 5] = (int) j66;
                        long j67 = (j61 * j51) + (iArr17[r3] & 4294967295L) + (j66 >>> 32);
                        iArr17[i44 + 6] = (int) j67;
                        long j68 = (j61 * j52) + (iArr17[r3] & 4294967295L) + (j67 >>> 32);
                        iArr17[i44 + 7] = (int) j68;
                        iArr17[i44 + 8] = (int) (j68 >>> 32);
                        i40 = i43 + 1;
                        i41 = i42;
                    }
                    int iL2 = x.f.l(iArr17, iArr17);
                    int iJ2 = x.f.j(21, iArr17, 14, iArr17, x.f.j(0, iArr17, 7, iArr17, 0) + iL2) + iL2;
                    int[] iArr18 = new int[7];
                    int[] iArr19 = new int[7];
                    boolean z11 = x.f.D(iArr8, iArr8, iArr18) != x.f.D(iArr, iArr, iArr19);
                    int[] iArr20 = new int[14];
                    x.f.s0(iArr18, iArr19, iArr20);
                    x.f.m(iArr17, 28, iJ2 + (z11 ? x.f.i(14, 7, iArr20, iArr17) : x.f.H0(14, 7, iArr20, iArr17)), 21);
                    int[] iArr21 = new int[28];
                    int[] iArr22 = new int[i11];
                    System.arraycopy(iArr8, 0, iArr22, 0, i11);
                    int[] iArr23 = new int[i11];
                    System.arraycopy(iArr, 0, iArr23, 0, i11);
                    int[] iArr24 = new int[i11];
                    iArr24[0] = 1;
                    int i45 = 27;
                    int[] iArr25 = iArr22;
                    int i46 = 1788;
                    int[] iArr26 = iArr24;
                    int[] iArr27 = iArr23;
                    int[] iArr28 = new int[i11];
                    int iU = u(27, iArr13);
                    int[] iArr29 = iArr12;
                    int[] iArr30 = iArr13;
                    while (true) {
                        if (iU <= 447) {
                            iArr2 = iArr10;
                            c3 = 0;
                            System.arraycopy(iArr27, 0, iArr2, 0, 8);
                            iArr3 = iArr11;
                            System.arraycopy(iArr26, 0, iArr3, 0, 8);
                            z9 = true;
                            break;
                        }
                        int i47 = i46 - 1;
                        if (i47 < 0) {
                            iArr2 = iArr10;
                            iArr3 = iArr11;
                            c3 = 0;
                            z9 = false;
                            break;
                        }
                        int iT = t(i45, iArr17) - iU;
                        int i48 = iT & (~(iT >> 31));
                        int[] iArr31 = iArr17;
                        int[] iArr32 = iArr21;
                        int i49 = i45;
                        if (iArr17[i45] < 0) {
                            a(i49, i48, iArr29, iArr30, iArr31, iArr32);
                            b(7, i48, iArr25, iArr28, iArr27, iArr26);
                            iArr4 = iArr29;
                        } else {
                            X(i49, i48, iArr29, iArr30, iArr31, iArr32);
                            iArr4 = iArr29;
                            Y(7, i48, iArr25, iArr28, iArr27, iArr26);
                        }
                        int i50 = i49;
                        do {
                            int i51 = iArr4[i50] - Integer.MIN_VALUE;
                            int i52 = iArr30[i50] - Integer.MIN_VALUE;
                            if (i51 < i52) {
                                z10 = true;
                                break;
                            }
                            if (i51 > i52) {
                                break;
                            }
                            i50--;
                        } while (i50 >= 0);
                        z10 = false;
                        if (z10) {
                            int i53 = iU >>> 5;
                            int[] iArr33 = iArr27;
                            iArr27 = iArr25;
                            iArr25 = iArr33;
                            int[] iArr34 = iArr26;
                            iArr26 = iArr28;
                            iArr28 = iArr34;
                            i45 = i53;
                            iU = u(i53, iArr4);
                            iArr29 = iArr30;
                            iArr30 = iArr4;
                        } else {
                            iArr29 = iArr4;
                            i45 = i49;
                        }
                        i46 = i47;
                        iArr17 = iArr31;
                        iArr21 = iArr32;
                    }
                    if (!z9) {
                        throw new IllegalStateException();
                    }
                    int[] iArr35 = new int[22];
                    long j69 = iArr3[c3] & 4294967295L;
                    long j70 = 0;
                    int i54 = 0;
                    while (true) {
                        long j71 = ((iArr14[i54] & 4294967295L) * j69) + j70;
                        iArr35[i54] = (int) j71;
                        j70 = j71 >>> 32;
                        i54++;
                        if (i54 >= 14) {
                            break;
                        }
                        iArr35 = iArr35;
                        iArr2 = iArr2;
                        iArr14 = iArr14;
                        i29 = i29;
                    }
                    iArr35[14] = (int) j70;
                    for (int i55 = 1; i55 < 8; i55++) {
                        iArr35[i55 + 14] = x.f.v0(14, iArr14, iArr3[i55], iArr35, i55);
                    }
                    int[] iArr36 = iArr14;
                    if (iArr3[7] < 0) {
                        x.f.i(14, 8, iArr8, iArr35);
                        x.f.H0(14, 8, iArr36, iArr35);
                    }
                    byte[] bArr8 = new byte[88];
                    n(bArr8, 22, iArr35);
                    long jG = g(bArr8, 0) & 4294967295L;
                    long jF = (f(bArr8, 4) << 4) & 4294967295L;
                    long jG2 = g(bArr8, 7) & 4294967295L;
                    long jF2 = (f(bArr8, 11) << 4) & 4294967295L;
                    long jG3 = g(bArr8, 14) & 4294967295L;
                    int[] iArr37 = iArr2;
                    long jF3 = (f(bArr8, 18) << 4) & 4294967295L;
                    long jG4 = g(bArr8, 21) & 4294967295L;
                    long jF4 = (f(bArr8, i29) << 4) & 4294967295L;
                    long jG5 = g(bArr8, 28) & 4294967295L;
                    long jF5 = (f(bArr8, 32) << 4) & 4294967295L;
                    long jG6 = g(bArr8, 35) & 4294967295L;
                    long jF6 = (f(bArr8, 39) << 4) & 4294967295L;
                    long jG7 = g(bArr8, 42) & 4294967295L;
                    long jF7 = (f(bArr8, 46) << 4) & 4294967295L;
                    long jG8 = g(bArr8, 49) & 4294967295L;
                    long jF8 = (f(bArr8, 53) << 4) & 4294967295L;
                    long jG9 = g(bArr8, 56) & 4294967295L;
                    long jF9 = f(bArr8, 60) << 4;
                    long j72 = jF9 & 4294967295L;
                    long jG10 = g(bArr8, 63) & 4294967295L;
                    long jF10 = (f(bArr8, 67) << 4) & 4294967295L;
                    long jG11 = g(bArr8, 70);
                    long j73 = jG11 & 4294967295L;
                    long jF11 = (f(bArr8, 74) << 4) & 4294967295L;
                    long jG12 = g(bArr8, 77) & 4294967295L;
                    long jF12 = (f(bArr8, 81) << 4) & 4294967295L;
                    long jG13 = g(bArr8, 84);
                    long j74 = (jG13 & 4294967295L) >>> 28;
                    long j75 = jF11 + (j73 >>> 28);
                    long j76 = jG12 + (j75 >>> 28);
                    long j77 = jF12 + (j76 >>> 28);
                    long j78 = j76 & 268435455;
                    long j79 = (jG13 & 268435455) + (j77 >>> 28);
                    long j80 = j77 & 268435455;
                    long j81 = (j80 * 43969588) + jF4;
                    long j82 = (j80 * 30366549) + (j79 * 43969588) + jG5;
                    long j83 = (j80 * 163752818) + (j79 * 30366549) + (j74 * 43969588) + jF5;
                    long j84 = (j80 * 258169998) + (j79 * 163752818) + (j74 * 30366549) + jG6;
                    long j85 = (j80 * 96434764) + (j79 * 258169998) + (j74 * 163752818) + jF6;
                    long j86 = (j80 * 227822194) + (j79 * 96434764) + (j74 * 258169998) + jG7;
                    long j87 = (j80 * 149865618) + (j79 * 227822194) + (j74 * 96434764) + jF7;
                    long j88 = (j80 * 550336261) + (j79 * 149865618) + (j74 * 227822194) + jG8;
                    long j89 = (j78 * 43969588) + jG4;
                    long j90 = (j78 * 30366549) + j81;
                    long j91 = (j78 * 163752818) + j82;
                    long j92 = (j78 * 258169998) + j83;
                    long j93 = (j78 * 96434764) + j84;
                    long j94 = (j78 * 227822194) + j85;
                    long j95 = (j78 * 149865618) + j86;
                    long j96 = (j78 * 550336261) + j87;
                    long j97 = jG10 + (j72 >>> 28);
                    long j98 = jF10 + (j97 >>> 28);
                    long j99 = (jG11 & 268435455) + (j98 >>> 28);
                    long j100 = j98 & 268435455;
                    long j101 = (j75 & 268435455) + (j99 >>> 28);
                    long j102 = j99 & 268435455;
                    long j103 = (j101 * 43969588) + jF3;
                    long j104 = (j101 * 30366549) + j89;
                    long j105 = (j101 * 163752818) + j90;
                    long j106 = (j101 * 258169998) + j91;
                    long j107 = (j101 * 96434764) + j92;
                    long j108 = (j101 * 227822194) + j93;
                    long j109 = (j101 * 149865618) + j94;
                    long j110 = (j101 * 550336261) + j95;
                    long j111 = (j102 * 43969588) + jG3;
                    long j112 = (j102 * 30366549) + j103;
                    long j113 = (j102 * 163752818) + j104;
                    long j114 = (j102 * 258169998) + j105;
                    long j115 = (j102 * 96434764) + j106;
                    long j116 = (j102 * 227822194) + j107;
                    long j117 = (j102 * 149865618) + j108;
                    long j118 = (j102 * 550336261) + j109;
                    long j119 = (j100 * 30366549) + j111;
                    long j120 = (j100 * 163752818) + j112;
                    long j121 = (j100 * 258169998) + j113;
                    long j122 = (j100 * 96434764) + j114;
                    long j123 = (j100 * 227822194) + j115;
                    long j124 = (j100 * 149865618) + j116;
                    long j125 = (j79 * 550336261) + (j74 * 149865618) + jF8 + (j88 >>> 28);
                    long j126 = j88 & 268435455;
                    long j127 = (j74 * 550336261) + jG9 + (j125 >>> 28);
                    long j128 = (jF9 & 268435455) + (j127 >>> 28);
                    long j129 = (j97 & 268435455) + (j128 >>> 28);
                    long j130 = j128 & 268435455;
                    long j131 = (j129 * 43969588) + jG2;
                    long j132 = (j129 * 30366549) + (j100 * 43969588) + jF2;
                    long j133 = (j129 * 163752818) + j119;
                    long j134 = (j129 * 258169998) + j120;
                    long j135 = (j129 * 96434764) + j121;
                    long j136 = (j129 * 227822194) + j122;
                    long j137 = (j129 * 149865618) + j123;
                    long j138 = (j129 * 550336261) + j124;
                    long j139 = (43969588 * j130) + jF;
                    long j140 = (30366549 * j130) + j131;
                    long j141 = (163752818 * j130) + j132;
                    long j142 = (258169998 * j130) + j133;
                    long j143 = (96434764 * j130) + j134;
                    long j144 = (227822194 * j130) + j135;
                    long j145 = (149865618 * j130) + j136;
                    long j146 = (j130 * 550336261) + j137;
                    long j147 = ((j127 & 268435455) * 4) + ((j125 & 268435455) >>> 26) + 1;
                    long j148 = (j147 * 78101261) + jG;
                    long j149 = (j147 * 141809365) + j139;
                    long j150 = (j147 * 175155932) + j140;
                    long j151 = (j147 * 64542499) + j141;
                    long j152 = (j147 * 158326419) + j142;
                    long j153 = (j147 * 191173276) + j143;
                    long j154 = (j147 * 104575268) + j144;
                    long j155 = (j147 * 137584065) + j145;
                    long j156 = j149 + (j148 >>> 28);
                    long j157 = j150 + (j156 >>> 28);
                    long j158 = j151 + (j157 >>> 28);
                    long j159 = j157 & 268435455;
                    long j160 = j152 + (j158 >>> 28);
                    long j161 = j158 & 268435455;
                    long j162 = j153 + (j160 >>> 28);
                    long j163 = j154 + (j162 >>> 28);
                    long j164 = j155 + (j163 >>> 28);
                    long j165 = j146 + (j164 >>> 28);
                    long j166 = j138 + (j165 >>> 28);
                    long j167 = (j100 * 550336261) + j117 + (j166 >>> 28);
                    long j168 = j118 + (j167 >>> 28);
                    long j169 = j110 + (j168 >>> 28);
                    long j170 = j96 + (j169 >>> 28);
                    long j171 = j126 + (j170 >>> 28);
                    long j172 = (j125 & 67108863) + (j171 >>> 28);
                    long j173 = (j172 >>> 26) - 1;
                    long j174 = (j148 & 268435455) - (j173 & 78101261);
                    long j175 = ((j156 & 268435455) - (j173 & 141809365)) + (j174 >> 28);
                    long j176 = (j159 - (j173 & 175155932)) + (j175 >> 28);
                    long j177 = (j161 - (j173 & 64542499)) + (j176 >> 28);
                    long j178 = ((j160 & 268435455) - (j173 & 158326419)) + (j177 >> 28);
                    long j179 = ((j162 & 268435455) - (j173 & 191173276)) + (j178 >> 28);
                    long j180 = ((j163 & 268435455) - (j173 & 104575268)) + (j179 >> 28);
                    long j181 = ((j164 & 268435455) - (j173 & 137584065)) + (j180 >> 28);
                    long j182 = (j165 & 268435455) + (j181 >> 28);
                    long j183 = (j166 & 268435455) + (j182 >> 28);
                    long j184 = (j167 & 268435455) + (j183 >> 28);
                    long j185 = (j168 & 268435455) + (j184 >> 28);
                    long j186 = (j169 & 268435455) + (j185 >> 28);
                    long j187 = (j170 & 268435455) + (j186 >> 28);
                    long j188 = (j171 & 268435455) + (j187 >> 28);
                    byte[] bArr9 = new byte[57];
                    o((j174 & 268435455) | ((j175 & 268435455) << 28), bArr9, 0);
                    o(((j177 & 268435455) << 28) | (j176 & 268435455), bArr9, 7);
                    o(((j179 & 268435455) << 28) | (j178 & 268435455), bArr9, 14);
                    o((j180 & 268435455) | ((j181 & 268435455) << 28), bArr9, 21);
                    o((j182 & 268435455) | ((j183 & 268435455) << 28), bArr9, 28);
                    o((j184 & 268435455) | ((j185 & 268435455) << 28), bArr9, 35);
                    o((j186 & 268435455) | ((j187 & 268435455) << 28), bArr9, 42);
                    o((j188 & 268435455) | (((j172 & 67108863) + (j188 >> 28)) << 28), bArr9, 49);
                    e(bArr9, iArr36);
                    d dVar = new d(1);
                    Q();
                    byte[] bArr10 = new byte[450];
                    int i56 = 225;
                    byte[] bArr11 = new byte[225];
                    byte[] bArr12 = new byte[225];
                    v(bArr10, 7, iArr36);
                    v(bArr11, 5, iArr37);
                    v(bArr12, 5, iArr3);
                    d[] dVarArr = new d[8];
                    d[] dVarArr2 = new d[8];
                    g gVar = new g();
                    int i57 = 0;
                    N(bVar, dVarArr, 0, 8, gVar);
                    N(bVar2, dVarArr2, 0, 8, gVar);
                    for (int i58 = 0; i58 < 16; i58++) {
                        dVar.f6004a[i58] = 0;
                    }
                    int[] iArr38 = dVar.f6005b;
                    iArr38[0] = 1;
                    for (int i59 = 1; i59 < 16; i59++) {
                        iArr38[i59] = 0;
                    }
                    int[] iArr39 = dVar.f6006c;
                    iArr39[0] = 1;
                    int i60 = 1;
                    for (int i61 = 16; i60 < i61; i61 = 16) {
                        iArr39[i60] = i57;
                        i60++;
                        i57 = 0;
                    }
                    while (true) {
                        i13 = i56 - 1;
                        if (i13 < 0) {
                            break;
                        }
                        if ((bArr10[i56 + BERTags.FLAGS] | bArr10[i13] | bArr11[i13] | bArr12[i13]) != 0) {
                            break;
                        }
                        i56 = i13;
                    }
                    while (i13 >= 0) {
                        byte b11 = bArr10[i13];
                        if (b11 != 0) {
                            E(b11 < 0, f6029w[(b11 >> 1) ^ (b11 >> 31)], dVar, gVar);
                        }
                        byte b12 = bArr10[i13 + 225];
                        if (b12 != 0) {
                            E(b12 < 0, f6030x[(b12 >> 1) ^ (b12 >> 31)], dVar, gVar);
                        }
                        byte b13 = bArr11[i13];
                        if (b13 != 0) {
                            H(b13 < 0, dVarArr[(b13 >> 1) ^ (b13 >> 31)], dVar, gVar);
                        }
                        byte b14 = bArr12[i13];
                        if (b14 != 0) {
                            H(b14 < 0, dVarArr2[(b14 >> 1) ^ (b14 >> 31)], dVar, gVar);
                        }
                        M(dVar, gVar);
                        i13--;
                    }
                    M(dVar, gVar);
                    int[] iArr40 = dVar.f6004a;
                    u7.a.K(1, iArr40);
                    u7.a.K(-1, iArr40);
                    int[] iArr41 = dVar.f6005b;
                    u7.a.K(1, iArr41);
                    u7.a.K(-1, iArr41);
                    int[] iArr42 = dVar.f6006c;
                    u7.a.K(1, iArr42);
                    u7.a.K(-1, iArr42);
                    if (u7.a.B(dVar.f6004a) != 0) {
                        if (!(u7.a.B(iArr41) != 0)) {
                            int i62 = 0;
                            for (int i63 = 0; i63 < 16; i63++) {
                                i62 |= iArr41[i63] ^ iArr42[i63];
                            }
                            if (((((i62 >>> 1) | (i62 & 1)) - 1) >> 31) != 0) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
