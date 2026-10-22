package z2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: p0, reason: collision with root package name */
    public static final SparseIntArray f16260p0;
    public int A;
    public float B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public float T;
    public float U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f16261a;

    /* renamed from: a0, reason: collision with root package name */
    public int f16262a0;

    /* renamed from: b, reason: collision with root package name */
    public int f16263b;

    /* renamed from: b0, reason: collision with root package name */
    public int f16264b0;

    /* renamed from: c, reason: collision with root package name */
    public int f16265c;

    /* renamed from: c0, reason: collision with root package name */
    public int f16266c0;

    /* renamed from: d, reason: collision with root package name */
    public int f16267d;

    /* renamed from: d0, reason: collision with root package name */
    public float f16268d0;

    /* renamed from: e, reason: collision with root package name */
    public int f16269e;
    public float e0;

    /* renamed from: f, reason: collision with root package name */
    public float f16270f;
    public int f0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16271g;

    /* renamed from: g0, reason: collision with root package name */
    public int f16272g0;

    /* renamed from: h, reason: collision with root package name */
    public int f16273h;

    /* renamed from: h0, reason: collision with root package name */
    public int f16274h0;
    public int i;

    /* renamed from: i0, reason: collision with root package name */
    public int[] f16275i0;

    /* renamed from: j, reason: collision with root package name */
    public int f16276j;

    /* renamed from: j0, reason: collision with root package name */
    public String f16277j0;

    /* renamed from: k, reason: collision with root package name */
    public int f16278k;

    /* renamed from: k0, reason: collision with root package name */
    public String f16279k0;

    /* renamed from: l, reason: collision with root package name */
    public int f16280l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f16281l0;

    /* renamed from: m, reason: collision with root package name */
    public int f16282m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f16283m0;

    /* renamed from: n, reason: collision with root package name */
    public int f16284n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f16285n0;

    /* renamed from: o, reason: collision with root package name */
    public int f16286o;

    /* renamed from: o0, reason: collision with root package name */
    public int f16287o0;

    /* renamed from: p, reason: collision with root package name */
    public int f16288p;

    /* renamed from: q, reason: collision with root package name */
    public int f16289q;

    /* renamed from: r, reason: collision with root package name */
    public int f16290r;

    /* renamed from: s, reason: collision with root package name */
    public int f16291s;

    /* renamed from: t, reason: collision with root package name */
    public int f16292t;

    /* renamed from: u, reason: collision with root package name */
    public int f16293u;

    /* renamed from: v, reason: collision with root package name */
    public int f16294v;

    /* renamed from: w, reason: collision with root package name */
    public float f16295w;

    /* renamed from: x, reason: collision with root package name */
    public float f16296x;

    /* renamed from: y, reason: collision with root package name */
    public String f16297y;

    /* renamed from: z, reason: collision with root package name */
    public int f16298z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16260p0 = sparseIntArray;
        sparseIntArray.append(43, 24);
        sparseIntArray.append(44, 25);
        sparseIntArray.append(46, 28);
        sparseIntArray.append(47, 29);
        sparseIntArray.append(52, 35);
        sparseIntArray.append(51, 34);
        sparseIntArray.append(24, 4);
        sparseIntArray.append(23, 3);
        sparseIntArray.append(19, 1);
        sparseIntArray.append(61, 6);
        sparseIntArray.append(62, 7);
        sparseIntArray.append(31, 17);
        sparseIntArray.append(32, 18);
        sparseIntArray.append(33, 19);
        sparseIntArray.append(15, 90);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(48, 31);
        sparseIntArray.append(49, 32);
        sparseIntArray.append(30, 10);
        sparseIntArray.append(29, 9);
        sparseIntArray.append(66, 13);
        sparseIntArray.append(69, 16);
        sparseIntArray.append(67, 14);
        sparseIntArray.append(64, 11);
        sparseIntArray.append(68, 15);
        sparseIntArray.append(65, 12);
        sparseIntArray.append(55, 38);
        sparseIntArray.append(41, 37);
        sparseIntArray.append(40, 39);
        sparseIntArray.append(54, 40);
        sparseIntArray.append(39, 20);
        sparseIntArray.append(53, 36);
        sparseIntArray.append(28, 5);
        sparseIntArray.append(42, 91);
        sparseIntArray.append(50, 91);
        sparseIntArray.append(45, 91);
        sparseIntArray.append(22, 91);
        sparseIntArray.append(18, 91);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(56, 41);
        sparseIntArray.append(34, 42);
        sparseIntArray.append(17, 41);
        sparseIntArray.append(16, 42);
        sparseIntArray.append(71, 76);
        sparseIntArray.append(25, 61);
        sparseIntArray.append(27, 62);
        sparseIntArray.append(26, 63);
        sparseIntArray.append(60, 69);
        sparseIntArray.append(38, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
    }

    public final void a(Context context, AttributeSet attributeSet) throws NumberFormatException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f16336e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray = f16260p0;
            int i3 = sparseIntArray.get(index);
            switch (i3) {
                case 1:
                    this.f16288p = m.e(typedArrayObtainStyledAttributes, index, this.f16288p);
                    break;
                case 2:
                    this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                    break;
                case 3:
                    this.f16286o = m.e(typedArrayObtainStyledAttributes, index, this.f16286o);
                    break;
                case 4:
                    this.f16284n = m.e(typedArrayObtainStyledAttributes, index, this.f16284n);
                    break;
                case 5:
                    this.f16297y = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                    break;
                case 7:
                    this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                    break;
                case 8:
                    this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                    break;
                case 9:
                    this.f16294v = m.e(typedArrayObtainStyledAttributes, index, this.f16294v);
                    break;
                case 10:
                    this.f16293u = m.e(typedArrayObtainStyledAttributes, index, this.f16293u);
                    break;
                case 11:
                    this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                    break;
                case 12:
                    this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                    break;
                case 13:
                    this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                    break;
                case 14:
                    this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                    break;
                case 15:
                    this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                    break;
                case 16:
                    this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                    break;
                case 17:
                    this.f16267d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f16267d);
                    break;
                case 18:
                    this.f16269e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f16269e);
                    break;
                case 19:
                    this.f16270f = typedArrayObtainStyledAttributes.getFloat(index, this.f16270f);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    this.f16295w = typedArrayObtainStyledAttributes.getFloat(index, this.f16295w);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    this.f16265c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f16265c);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    this.f16263b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f16263b);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                    break;
                case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                    this.f16273h = m.e(typedArrayObtainStyledAttributes, index, this.f16273h);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    this.i = m.e(typedArrayObtainStyledAttributes, index, this.i);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    this.E = typedArrayObtainStyledAttributes.getInt(index, this.E);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                    break;
                case 28:
                    this.f16276j = m.e(typedArrayObtainStyledAttributes, index, this.f16276j);
                    break;
                case 29:
                    this.f16278k = m.e(typedArrayObtainStyledAttributes, index, this.f16278k);
                    break;
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                    this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                    this.f16291s = m.e(typedArrayObtainStyledAttributes, index, this.f16291s);
                    break;
                case 32:
                    this.f16292t = m.e(typedArrayObtainStyledAttributes, index, this.f16292t);
                    break;
                case 33:
                    this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                    this.f16282m = m.e(typedArrayObtainStyledAttributes, index, this.f16282m);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                    this.f16280l = m.e(typedArrayObtainStyledAttributes, index, this.f16280l);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                    this.f16296x = typedArrayObtainStyledAttributes.getFloat(index, this.f16296x);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                    this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                    this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                    this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                    m.f(this, typedArrayObtainStyledAttributes, index, 0);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                    m.f(this, typedArrayObtainStyledAttributes, index, 1);
                    break;
                default:
                    switch (i3) {
                        case 61:
                            this.f16298z = m.e(typedArrayObtainStyledAttributes, index, this.f16298z);
                            break;
                        case 62:
                            this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                            break;
                        case 63:
                            this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
                            break;
                        default:
                            switch (i3) {
                                case 69:
                                    this.f16268d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    this.e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    this.f0 = typedArrayObtainStyledAttributes.getInt(index, this.f0);
                                    break;
                                case 73:
                                    this.f16272g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16272g0);
                                    break;
                                case 74:
                                    this.f16277j0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 75:
                                    this.f16285n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f16285n0);
                                    break;
                                case 76:
                                    this.f16287o0 = typedArrayObtainStyledAttributes.getInt(index, this.f16287o0);
                                    break;
                                case 77:
                                    this.f16289q = m.e(typedArrayObtainStyledAttributes, index, this.f16289q);
                                    break;
                                case 78:
                                    this.f16290r = m.e(typedArrayObtainStyledAttributes, index, this.f16290r);
                                    break;
                                case 79:
                                    this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                    break;
                                case 80:
                                    this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                    break;
                                case 81:
                                    this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                                    break;
                                case 82:
                                    this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                    break;
                                case 83:
                                    this.f16262a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16262a0);
                                    break;
                                case 84:
                                    this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    break;
                                case 85:
                                    this.f16266c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16266c0);
                                    break;
                                case 86:
                                    this.f16264b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16264b0);
                                    break;
                                case 87:
                                    this.f16281l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f16281l0);
                                    break;
                                case 88:
                                    this.f16283m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f16283m0);
                                    break;
                                case 89:
                                    this.f16279k0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 90:
                                    this.f16271g = typedArrayObtainStyledAttributes.getBoolean(index, this.f16271g);
                                    break;
                                case 91:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                            }
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
