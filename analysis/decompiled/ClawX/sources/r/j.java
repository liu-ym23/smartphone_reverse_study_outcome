package r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.params.SkeinParameters;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: o0, reason: collision with root package name */
    public static final SparseIntArray f4983o0;
    public float A;
    public int B;
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
    public float S;
    public float T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f4984a;

    /* renamed from: a0, reason: collision with root package name */
    public int f4985a0;

    /* renamed from: b, reason: collision with root package name */
    public int f4986b;

    /* renamed from: b0, reason: collision with root package name */
    public int f4987b0;

    /* renamed from: c, reason: collision with root package name */
    public int f4988c;

    /* renamed from: c0, reason: collision with root package name */
    public float f4989c0;
    public int d;

    /* renamed from: d0, reason: collision with root package name */
    public float f4990d0;

    /* renamed from: e, reason: collision with root package name */
    public int f4991e;

    /* renamed from: e0, reason: collision with root package name */
    public int f4992e0;

    /* renamed from: f, reason: collision with root package name */
    public float f4993f;

    /* renamed from: f0, reason: collision with root package name */
    public int f4994f0;

    /* renamed from: g, reason: collision with root package name */
    public int f4995g;

    /* renamed from: g0, reason: collision with root package name */
    public int f4996g0;

    /* renamed from: h, reason: collision with root package name */
    public int f4997h;

    /* renamed from: h0, reason: collision with root package name */
    public int[] f4998h0;

    /* renamed from: i, reason: collision with root package name */
    public int f4999i;

    /* renamed from: i0, reason: collision with root package name */
    public String f5000i0;

    /* renamed from: j, reason: collision with root package name */
    public int f5001j;

    /* renamed from: j0, reason: collision with root package name */
    public String f5002j0;

    /* renamed from: k, reason: collision with root package name */
    public int f5003k;
    public boolean k0;

    /* renamed from: l, reason: collision with root package name */
    public int f5004l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f5005l0;

    /* renamed from: m, reason: collision with root package name */
    public int f5006m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f5007m0;

    /* renamed from: n, reason: collision with root package name */
    public int f5008n;

    /* renamed from: n0, reason: collision with root package name */
    public int f5009n0;

    /* renamed from: o, reason: collision with root package name */
    public int f5010o;

    /* renamed from: p, reason: collision with root package name */
    public int f5011p;

    /* renamed from: q, reason: collision with root package name */
    public int f5012q;

    /* renamed from: r, reason: collision with root package name */
    public int f5013r;

    /* renamed from: s, reason: collision with root package name */
    public int f5014s;

    /* renamed from: t, reason: collision with root package name */
    public int f5015t;

    /* renamed from: u, reason: collision with root package name */
    public int f5016u;

    /* renamed from: v, reason: collision with root package name */
    public float f5017v;

    /* renamed from: w, reason: collision with root package name */
    public float f5018w;

    /* renamed from: x, reason: collision with root package name */
    public String f5019x;
    public int y;
    public int z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4983o0 = sparseIntArray;
        sparseIntArray.append(42, 24);
        sparseIntArray.append(43, 25);
        sparseIntArray.append(45, 28);
        sparseIntArray.append(46, 29);
        sparseIntArray.append(51, 35);
        sparseIntArray.append(50, 34);
        sparseIntArray.append(23, 4);
        sparseIntArray.append(22, 3);
        sparseIntArray.append(18, 1);
        sparseIntArray.append(60, 6);
        sparseIntArray.append(61, 7);
        sparseIntArray.append(30, 17);
        sparseIntArray.append(31, 18);
        sparseIntArray.append(32, 19);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(47, 31);
        sparseIntArray.append(48, 32);
        sparseIntArray.append(29, 10);
        sparseIntArray.append(28, 9);
        sparseIntArray.append(65, 13);
        sparseIntArray.append(68, 16);
        sparseIntArray.append(66, 14);
        sparseIntArray.append(63, 11);
        sparseIntArray.append(67, 15);
        sparseIntArray.append(64, 12);
        sparseIntArray.append(54, 38);
        sparseIntArray.append(40, 37);
        sparseIntArray.append(39, 39);
        sparseIntArray.append(53, 40);
        sparseIntArray.append(38, 20);
        sparseIntArray.append(52, 36);
        sparseIntArray.append(27, 5);
        sparseIntArray.append(41, 76);
        sparseIntArray.append(49, 76);
        sparseIntArray.append(44, 76);
        sparseIntArray.append(21, 76);
        sparseIntArray.append(17, 76);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(55, 41);
        sparseIntArray.append(33, 42);
        sparseIntArray.append(16, 41);
        sparseIntArray.append(15, 42);
        sparseIntArray.append(70, 97);
        sparseIntArray.append(24, 61);
        sparseIntArray.append(26, 62);
        sparseIntArray.append(25, 63);
        sparseIntArray.append(59, 69);
        sparseIntArray.append(37, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f5053e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            SparseIntArray sparseIntArray = f4983o0;
            int i9 = sparseIntArray.get(index);
            if (i9 == 80) {
                this.k0 = typedArrayObtainStyledAttributes.getBoolean(index, this.k0);
            } else if (i9 == 81) {
                this.f5005l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f5005l0);
            } else if (i9 != 97) {
                switch (i9) {
                    case 1:
                        this.f5010o = n.f(typedArrayObtainStyledAttributes, index, this.f5010o);
                        break;
                    case 2:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 3:
                        this.f5008n = n.f(typedArrayObtainStyledAttributes, index, this.f5008n);
                        break;
                    case 4:
                        this.f5006m = n.f(typedArrayObtainStyledAttributes, index, this.f5006m);
                        break;
                    case 5:
                        this.f5019x = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                        break;
                    case 7:
                        this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                        break;
                    case 8:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 9:
                        this.f5016u = n.f(typedArrayObtainStyledAttributes, index, this.f5016u);
                        break;
                    case 10:
                        this.f5015t = n.f(typedArrayObtainStyledAttributes, index, this.f5015t);
                        break;
                    case BERTags.EMBEDDED_PDV /* 11 */:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 12:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case BERTags.RELATIVE_OID /* 13 */:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case BERTags.TIME /* 14 */:
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 15:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 16:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 17:
                        this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.d);
                        break;
                    case BERTags.NUMERIC_STRING /* 18 */:
                        this.f4991e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4991e);
                        break;
                    case 19:
                        this.f4993f = typedArrayObtainStyledAttributes.getFloat(index, this.f4993f);
                        break;
                    case 20:
                        this.f5017v = typedArrayObtainStyledAttributes.getFloat(index, this.f5017v);
                        break;
                    case BERTags.VIDEOTEX_STRING /* 21 */:
                        this.f4988c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f4988c);
                        break;
                    case BERTags.IA5_STRING /* 22 */:
                        this.f4986b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f4986b);
                        break;
                    case BERTags.UTC_TIME /* 23 */:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.E);
                        break;
                    case 24:
                        this.f4995g = n.f(typedArrayObtainStyledAttributes, index, this.f4995g);
                        break;
                    case BERTags.GRAPHIC_STRING /* 25 */:
                        this.f4997h = n.f(typedArrayObtainStyledAttributes, index, this.f4997h);
                        break;
                    case BERTags.VISIBLE_STRING /* 26 */:
                        this.D = typedArrayObtainStyledAttributes.getInt(index, this.D);
                        break;
                    case BERTags.GENERAL_STRING /* 27 */:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case BERTags.UNIVERSAL_STRING /* 28 */:
                        this.f4999i = n.f(typedArrayObtainStyledAttributes, index, this.f4999i);
                        break;
                    case BERTags.UNRESTRICTED_STRING /* 29 */:
                        this.f5001j = n.f(typedArrayObtainStyledAttributes, index, this.f5001j);
                        break;
                    case 30:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case BERTags.DATE /* 31 */:
                        this.f5013r = n.f(typedArrayObtainStyledAttributes, index, this.f5013r);
                        break;
                    case 32:
                        this.f5014s = n.f(typedArrayObtainStyledAttributes, index, this.f5014s);
                        break;
                    case BERTags.DATE_TIME /* 33 */:
                        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case BERTags.DURATION /* 34 */:
                        this.f5004l = n.f(typedArrayObtainStyledAttributes, index, this.f5004l);
                        break;
                    case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                        this.f5003k = n.f(typedArrayObtainStyledAttributes, index, this.f5003k);
                        break;
                    case BERTags.RELATIVE_OID_IRI /* 36 */:
                        this.f5018w = typedArrayObtainStyledAttributes.getFloat(index, this.f5018w);
                        break;
                    case 37:
                        this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                        break;
                    case 38:
                        this.S = typedArrayObtainStyledAttributes.getFloat(index, this.S);
                        break;
                    case 39:
                        this.U = typedArrayObtainStyledAttributes.getInt(index, this.U);
                        break;
                    case 40:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 41:
                        n.g(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        n.g(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i9) {
                            case 54:
                                this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                                break;
                            case 55:
                                this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                                break;
                            case 56:
                                this.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                break;
                            case 57:
                                this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                break;
                            case 58:
                                this.f4985a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4985a0);
                                break;
                            case 59:
                                this.f4987b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4987b0);
                                break;
                            default:
                                switch (i9) {
                                    case 61:
                                        this.y = n.f(typedArrayObtainStyledAttributes, index, this.y);
                                        break;
                                    case 62:
                                        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                                        break;
                                    case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                                        this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
                                        break;
                                    default:
                                        switch (i9) {
                                            case 69:
                                                this.f4989c0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 70:
                                                this.f4990d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 71:
                                                Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                break;
                                            case 72:
                                                this.f4992e0 = typedArrayObtainStyledAttributes.getInt(index, this.f4992e0);
                                                break;
                                            case 73:
                                                this.f4994f0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4994f0);
                                                break;
                                            case 74:
                                                this.f5000i0 = typedArrayObtainStyledAttributes.getString(index);
                                                break;
                                            case 75:
                                                this.f5007m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f5007m0);
                                                break;
                                            case 76:
                                                Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                break;
                                            case 77:
                                                this.f5002j0 = typedArrayObtainStyledAttributes.getString(index);
                                                break;
                                            default:
                                                switch (i9) {
                                                    case 91:
                                                        this.f5011p = n.f(typedArrayObtainStyledAttributes, index, this.f5011p);
                                                        break;
                                                    case 92:
                                                        this.f5012q = n.f(typedArrayObtainStyledAttributes, index, this.f5012q);
                                                        break;
                                                    case 93:
                                                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                                                        break;
                                                    case 94:
                                                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                                                        break;
                                                    default:
                                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                        break;
                                                }
                                        }
                                }
                        }
                }
            } else {
                this.f5009n0 = typedArrayObtainStyledAttributes.getInt(index, this.f5009n0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
