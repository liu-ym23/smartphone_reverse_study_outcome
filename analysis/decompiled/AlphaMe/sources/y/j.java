package y;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.entity.pb.PoiResult;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: p0, reason: collision with root package name */
    public static final SparseIntArray f16049p0;

    /* renamed from: A, reason: collision with root package name */
    public int f16050A;

    /* renamed from: B, reason: collision with root package name */
    public float f16051B;

    /* renamed from: C, reason: collision with root package name */
    public int f16052C;

    /* renamed from: D, reason: collision with root package name */
    public int f16053D;

    /* renamed from: E, reason: collision with root package name */
    public int f16054E;

    /* renamed from: F, reason: collision with root package name */
    public int f16055F;

    /* renamed from: G, reason: collision with root package name */
    public int f16056G;

    /* renamed from: H, reason: collision with root package name */
    public int f16057H;

    /* renamed from: I, reason: collision with root package name */
    public int f16058I;

    /* renamed from: J, reason: collision with root package name */
    public int f16059J;

    /* renamed from: K, reason: collision with root package name */
    public int f16060K;

    /* renamed from: L, reason: collision with root package name */
    public int f16061L;

    /* renamed from: M, reason: collision with root package name */
    public int f16062M;

    /* renamed from: N, reason: collision with root package name */
    public int f16063N;

    /* renamed from: O, reason: collision with root package name */
    public int f16064O;

    /* renamed from: P, reason: collision with root package name */
    public int f16065P;

    /* renamed from: Q, reason: collision with root package name */
    public int f16066Q;

    /* renamed from: R, reason: collision with root package name */
    public int f16067R;

    /* renamed from: S, reason: collision with root package name */
    public int f16068S;
    public float T;

    /* renamed from: U, reason: collision with root package name */
    public float f16069U;

    /* renamed from: V, reason: collision with root package name */
    public int f16070V;

    /* renamed from: W, reason: collision with root package name */
    public int f16071W;

    /* renamed from: X, reason: collision with root package name */
    public int f16072X;

    /* renamed from: Y, reason: collision with root package name */
    public int f16073Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f16074Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f16075a;

    /* renamed from: a0, reason: collision with root package name */
    public int f16076a0;

    /* renamed from: b, reason: collision with root package name */
    public int f16077b;

    /* renamed from: b0, reason: collision with root package name */
    public int f16078b0;

    /* renamed from: c, reason: collision with root package name */
    public int f16079c;

    /* renamed from: c0, reason: collision with root package name */
    public int f16080c0;

    /* renamed from: d, reason: collision with root package name */
    public int f16081d;

    /* renamed from: d0, reason: collision with root package name */
    public float f16082d0;

    /* renamed from: e, reason: collision with root package name */
    public int f16083e;

    /* renamed from: e0, reason: collision with root package name */
    public float f16084e0;

    /* renamed from: f, reason: collision with root package name */
    public float f16085f;

    /* renamed from: f0, reason: collision with root package name */
    public int f16086f0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16087g;

    /* renamed from: g0, reason: collision with root package name */
    public int f16088g0;

    /* renamed from: h, reason: collision with root package name */
    public int f16089h;

    /* renamed from: h0, reason: collision with root package name */
    public int f16090h0;

    /* renamed from: i, reason: collision with root package name */
    public int f16091i;

    /* renamed from: i0, reason: collision with root package name */
    public int[] f16092i0;

    /* renamed from: j, reason: collision with root package name */
    public int f16093j;

    /* renamed from: j0, reason: collision with root package name */
    public String f16094j0;

    /* renamed from: k, reason: collision with root package name */
    public int f16095k;

    /* renamed from: k0, reason: collision with root package name */
    public String f16096k0;

    /* renamed from: l, reason: collision with root package name */
    public int f16097l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f16098l0;

    /* renamed from: m, reason: collision with root package name */
    public int f16099m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f16100m0;

    /* renamed from: n, reason: collision with root package name */
    public int f16101n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f16102n0;

    /* renamed from: o, reason: collision with root package name */
    public int f16103o;

    /* renamed from: o0, reason: collision with root package name */
    public int f16104o0;

    /* renamed from: p, reason: collision with root package name */
    public int f16105p;

    /* renamed from: q, reason: collision with root package name */
    public int f16106q;

    /* renamed from: r, reason: collision with root package name */
    public int f16107r;

    /* renamed from: s, reason: collision with root package name */
    public int f16108s;

    /* renamed from: t, reason: collision with root package name */
    public int f16109t;

    /* renamed from: u, reason: collision with root package name */
    public int f16110u;

    /* renamed from: v, reason: collision with root package name */
    public int f16111v;

    /* renamed from: w, reason: collision with root package name */
    public float f16112w;

    /* renamed from: x, reason: collision with root package name */
    public float f16113x;

    /* renamed from: y, reason: collision with root package name */
    public String f16114y;

    /* renamed from: z, reason: collision with root package name */
    public int f16115z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16049p0 = sparseIntArray;
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

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f16155e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            SparseIntArray sparseIntArray = f16049p0;
            int i5 = sparseIntArray.get(index);
            switch (i5) {
                case 1:
                    this.f16105p = n.f(typedArrayObtainStyledAttributes, index, this.f16105p);
                    break;
                case 2:
                    this.f16058I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16058I);
                    break;
                case 3:
                    this.f16103o = n.f(typedArrayObtainStyledAttributes, index, this.f16103o);
                    break;
                case 4:
                    this.f16101n = n.f(typedArrayObtainStyledAttributes, index, this.f16101n);
                    break;
                case 5:
                    this.f16114y = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    this.f16052C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f16052C);
                    break;
                case 7:
                    this.f16053D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f16053D);
                    break;
                case 8:
                    this.f16059J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16059J);
                    break;
                case 9:
                    this.f16111v = n.f(typedArrayObtainStyledAttributes, index, this.f16111v);
                    break;
                case 10:
                    this.f16110u = n.f(typedArrayObtainStyledAttributes, index, this.f16110u);
                    break;
                case 11:
                    this.f16065P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16065P);
                    break;
                case 12:
                    this.f16066Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16066Q);
                    break;
                case 13:
                    this.f16062M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16062M);
                    break;
                case 14:
                    this.f16064O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16064O);
                    break;
                case 15:
                    this.f16067R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16067R);
                    break;
                case 16:
                    this.f16063N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16063N);
                    break;
                case 17:
                    this.f16081d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f16081d);
                    break;
                case 18:
                    this.f16083e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f16083e);
                    break;
                case 19:
                    this.f16085f = typedArrayObtainStyledAttributes.getFloat(index, this.f16085f);
                    break;
                case 20:
                    this.f16112w = typedArrayObtainStyledAttributes.getFloat(index, this.f16112w);
                    break;
                case 21:
                    this.f16079c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f16079c);
                    break;
                case 22:
                    this.f16077b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f16077b);
                    break;
                case 23:
                    this.f16055F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16055F);
                    break;
                case 24:
                    this.f16089h = n.f(typedArrayObtainStyledAttributes, index, this.f16089h);
                    break;
                case 25:
                    this.f16091i = n.f(typedArrayObtainStyledAttributes, index, this.f16091i);
                    break;
                case 26:
                    this.f16054E = typedArrayObtainStyledAttributes.getInt(index, this.f16054E);
                    break;
                case 27:
                    this.f16056G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16056G);
                    break;
                case 28:
                    this.f16093j = n.f(typedArrayObtainStyledAttributes, index, this.f16093j);
                    break;
                case 29:
                    this.f16095k = n.f(typedArrayObtainStyledAttributes, index, this.f16095k);
                    break;
                case 30:
                    this.f16060K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16060K);
                    break;
                case 31:
                    this.f16108s = n.f(typedArrayObtainStyledAttributes, index, this.f16108s);
                    break;
                case 32:
                    this.f16109t = n.f(typedArrayObtainStyledAttributes, index, this.f16109t);
                    break;
                case 33:
                    this.f16057H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16057H);
                    break;
                case 34:
                    this.f16099m = n.f(typedArrayObtainStyledAttributes, index, this.f16099m);
                    break;
                case 35:
                    this.f16097l = n.f(typedArrayObtainStyledAttributes, index, this.f16097l);
                    break;
                case 36:
                    this.f16113x = typedArrayObtainStyledAttributes.getFloat(index, this.f16113x);
                    break;
                case 37:
                    this.f16069U = typedArrayObtainStyledAttributes.getFloat(index, this.f16069U);
                    break;
                case 38:
                    this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                    break;
                case 39:
                    this.f16070V = typedArrayObtainStyledAttributes.getInt(index, this.f16070V);
                    break;
                case 40:
                    this.f16071W = typedArrayObtainStyledAttributes.getInt(index, this.f16071W);
                    break;
                case 41:
                    n.g(this, typedArrayObtainStyledAttributes, index, 0);
                    break;
                case 42:
                    n.g(this, typedArrayObtainStyledAttributes, index, 1);
                    break;
                default:
                    switch (i5) {
                        case 61:
                            this.f16115z = n.f(typedArrayObtainStyledAttributes, index, this.f16115z);
                            break;
                        case 62:
                            this.f16050A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16050A);
                            break;
                        case 63:
                            this.f16051B = typedArrayObtainStyledAttributes.getFloat(index, this.f16051B);
                            break;
                        default:
                            switch (i5) {
                                case 69:
                                    this.f16082d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    this.f16084e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    this.f16086f0 = typedArrayObtainStyledAttributes.getInt(index, this.f16086f0);
                                    break;
                                case PoiResult.Contents.HEAD_RESULT_MSG_FIELD_NUMBER /* 73 */:
                                    this.f16088g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16088g0);
                                    break;
                                case PoiResult.Contents.HW_BROWSE_RECORDS_FIELD_NUMBER /* 74 */:
                                    this.f16094j0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case PoiResult.Contents.BAR_BUTTON_FIELD_NUMBER /* 75 */:
                                    this.f16102n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f16102n0);
                                    break;
                                case 76:
                                    this.f16104o0 = typedArrayObtainStyledAttributes.getInt(index, this.f16104o0);
                                    break;
                                case PoiResult.Contents.CARD_TYPE_FIELD_NUMBER /* 77 */:
                                    this.f16106q = n.f(typedArrayObtainStyledAttributes, index, this.f16106q);
                                    break;
                                case PoiResult.Contents.ADVERTISE_INFO_FIELD_NUMBER /* 78 */:
                                    this.f16107r = n.f(typedArrayObtainStyledAttributes, index, this.f16107r);
                                    break;
                                case 79:
                                    this.f16068S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16068S);
                                    break;
                                case 80:
                                    this.f16061L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16061L);
                                    break;
                                case 81:
                                    this.f16072X = typedArrayObtainStyledAttributes.getInt(index, this.f16072X);
                                    break;
                                case PoiResult.Contents.FAV_NUM_FIELD_NUMBER /* 82 */:
                                    this.f16073Y = typedArrayObtainStyledAttributes.getInt(index, this.f16073Y);
                                    break;
                                case 83:
                                    this.f16076a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16076a0);
                                    break;
                                case PoiResult.Contents.FAV_BUBBLE_FIELD_NUMBER /* 84 */:
                                    this.f16074Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16074Z);
                                    break;
                                case PoiResult.Contents.GUILD_BUTTON_FIELD_NUMBER /* 85 */:
                                    this.f16080c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16080c0);
                                    break;
                                case PoiResult.Contents.BOUND_FIELD_NUMBER /* 86 */:
                                    this.f16078b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f16078b0);
                                    break;
                                case 87:
                                    this.f16098l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f16098l0);
                                    break;
                                case 88:
                                    this.f16100m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f16100m0);
                                    break;
                                case Opcodes.DUP /* 89 */:
                                    this.f16096k0 = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 90:
                                    this.f16087g = typedArrayObtainStyledAttributes.getBoolean(index, this.f16087g);
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
