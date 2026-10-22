package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.C1359w;
import androidx.datastore.preferences.protobuf.E;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class N<T> implements Z<T> {

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f13462r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    public static final Unsafe f13463s = j0.B();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f13464a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13465b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13466c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13467d;

    /* renamed from: e, reason: collision with root package name */
    public final K f13468e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f13469f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13470g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f13471h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13472i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f13473j;

    /* renamed from: k, reason: collision with root package name */
    public final int f13474k;

    /* renamed from: l, reason: collision with root package name */
    public final int f13475l;

    /* renamed from: m, reason: collision with root package name */
    public final P f13476m;

    /* renamed from: n, reason: collision with root package name */
    public final B f13477n;

    /* renamed from: o, reason: collision with root package name */
    public final f0<?, ?> f13478o;

    /* renamed from: p, reason: collision with root package name */
    public final AbstractC1352o<?> f13479p;

    /* renamed from: q, reason: collision with root package name */
    public final F f13480q;

    public N(int[] iArr, Object[] objArr, int i10, int i11, K k10, boolean z10, boolean z11, int[] iArr2, int i12, int i13, P p10, B b10, f0<?, ?> f0Var, AbstractC1352o<?> abstractC1352o, F f10) {
        this.f13464a = iArr;
        this.f13465b = objArr;
        this.f13466c = i10;
        this.f13467d = i11;
        this.f13470g = k10 instanceof GeneratedMessageLite;
        this.f13471h = z10;
        this.f13469f = abstractC1352o != null && abstractC1352o.e(k10);
        this.f13472i = z11;
        this.f13473j = iArr2;
        this.f13474k = i12;
        this.f13475l = i13;
        this.f13476m = p10;
        this.f13477n = b10;
        this.f13478o = f0Var;
        this.f13479p = abstractC1352o;
        this.f13468e = k10;
        this.f13480q = f10;
    }

    public static <T> long A(T t10, long j10) {
        return j0.y(t10, j10);
    }

    public static <T> N<T> G(Class<T> cls, I i10, P p10, B b10, f0<?, ?> f0Var, AbstractC1352o<?> abstractC1352o, F f10) {
        return i10 instanceof X ? I((X) i10, p10, b10, f0Var, abstractC1352o, f10) : H((d0) i10, p10, b10, f0Var, abstractC1352o, f10);
    }

    public static <T> N<T> H(d0 d0Var, P p10, B b10, f0<?, ?> f0Var, AbstractC1352o<?> abstractC1352o, F f10) {
        boolean z10 = d0Var.getSyntax() == ProtoSyntax.PROTO3;
        r[] rVarArrB = d0Var.b();
        if (rVarArrB.length != 0) {
            r rVar = rVarArrB[0];
            throw null;
        }
        int length = rVarArrB.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (rVarArrB.length > 0) {
            r rVar2 = rVarArrB[0];
            throw null;
        }
        int[] iArrA = d0Var.a();
        if (iArrA == null) {
            iArrA = f13462r;
        }
        if (rVarArrB.length > 0) {
            r rVar3 = rVarArrB[0];
            throw null;
        }
        int[] iArr2 = f13462r;
        int[] iArr3 = f13462r;
        int[] iArr4 = new int[iArrA.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrA, 0, iArr4, 0, iArrA.length);
        System.arraycopy(iArr2, 0, iArr4, iArrA.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrA.length + iArr2.length, iArr3.length);
        return new N<>(iArr, objArr, 0, 0, d0Var.getDefaultInstance(), z10, true, iArr4, iArrA.length, iArrA.length + iArr2.length, p10, b10, f0Var, abstractC1352o, f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x039f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> androidx.datastore.preferences.protobuf.N<T> I(androidx.datastore.preferences.protobuf.X r35, androidx.datastore.preferences.protobuf.P r36, androidx.datastore.preferences.protobuf.B r37, androidx.datastore.preferences.protobuf.f0<?, ?> r38, androidx.datastore.preferences.protobuf.AbstractC1352o<?> r39, androidx.datastore.preferences.protobuf.F r40) {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.I(androidx.datastore.preferences.protobuf.X, androidx.datastore.preferences.protobuf.P, androidx.datastore.preferences.protobuf.B, androidx.datastore.preferences.protobuf.f0, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.F):androidx.datastore.preferences.protobuf.N");
    }

    public static long K(int i10) {
        return i10 & 1048575;
    }

    public static <T> boolean L(T t10, long j10) {
        return ((Boolean) j0.A(t10, j10)).booleanValue();
    }

    public static <T> double M(T t10, long j10) {
        return ((Double) j0.A(t10, j10)).doubleValue();
    }

    public static <T> float N(T t10, long j10) {
        return ((Float) j0.A(t10, j10)).floatValue();
    }

    public static <T> int O(T t10, long j10) {
        return ((Integer) j0.A(t10, j10)).intValue();
    }

    public static <T> long P(T t10, long j10) {
        return ((Long) j0.A(t10, j10)).longValue();
    }

    public static Field W(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int a0(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    public static <T> boolean d(T t10, long j10) {
        return j0.p(t10, j10);
    }

    public static <T> double e(T t10, long j10) {
        return j0.v(t10, j10);
    }

    public static <T> float i(T t10, long j10) {
        return j0.w(t10, j10);
    }

    public static <T> int p(T t10, long j10) {
        return j0.x(t10, j10);
    }

    public static boolean q(int i10) {
        return (i10 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean t(Object obj, int i10, Z z10) {
        return z10.isInitialized(j0.A(obj, K(i10)));
    }

    public static boolean y(int i10) {
        return (i10 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0;
    }

    public static List<?> z(Object obj, long j10) {
        return (List) j0.A(obj, j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:334:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r0 = r14.f13474k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0087, code lost:
    
        if (r0 >= r14.f13475l) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        r7 = g(r9, r14.f13473j[r0], r7, r15);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0094, code lost:
    
        if (r7 == null) goto L334;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0638 A[LOOP:3: B:197:0x0634->B:199:0x0638, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x060f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05f4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <UT, UB, ET extends androidx.datastore.preferences.protobuf.C1355s.b<ET>> void B(androidx.datastore.preferences.protobuf.f0<UT, UB> r15, androidx.datastore.preferences.protobuf.AbstractC1352o<ET> r16, T r17, androidx.datastore.preferences.protobuf.Y r18, androidx.datastore.preferences.protobuf.C1351n r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.B(androidx.datastore.preferences.protobuf.f0, androidx.datastore.preferences.protobuf.o, java.lang.Object, androidx.datastore.preferences.protobuf.Y, androidx.datastore.preferences.protobuf.n):void");
    }

    public final <K, V> void C(Object obj, int i10, Object obj2, C1351n c1351n, Y y10) throws IOException {
        long jK = K(b0(i10));
        Object objA = j0.A(obj, jK);
        if (objA == null) {
            objA = this.f13480q.newMapField(obj2);
            j0.O(obj, jK, objA);
        } else if (this.f13480q.isImmutable(objA)) {
            Object objNewMapField = this.f13480q.newMapField(obj2);
            this.f13480q.mergeFrom(objNewMapField, objA);
            j0.O(obj, jK, objNewMapField);
            objA = objNewMapField;
        }
        y10.f(this.f13480q.forMutableMapData(objA), this.f13480q.forMapMetadata(obj2), c1351n);
    }

    public final void D(T t10, T t11, int i10) {
        long jK = K(b0(i10));
        if (r(t11, i10)) {
            Object objA = j0.A(t10, jK);
            Object objA2 = j0.A(t11, jK);
            if (objA != null && objA2 != null) {
                j0.O(t10, jK, C1359w.h(objA, objA2));
                X(t10, i10);
            } else if (objA2 != null) {
                j0.O(t10, jK, objA2);
                X(t10, i10);
            }
        }
    }

    public final void E(T t10, T t11, int i10) {
        int iB0 = b0(i10);
        int iJ = J(i10);
        long jK = K(iB0);
        if (x(t11, iJ, i10)) {
            Object objA = j0.A(t10, jK);
            Object objA2 = j0.A(t11, jK);
            if (objA != null && objA2 != null) {
                j0.O(t10, jK, C1359w.h(objA, objA2));
                Y(t10, iJ, i10);
            } else if (objA2 != null) {
                j0.O(t10, jK, objA2);
                Y(t10, iJ, i10);
            }
        }
    }

    public final void F(T t10, T t11, int i10) {
        int iB0 = b0(i10);
        long jK = K(iB0);
        int iJ = J(i10);
        switch (a0(iB0)) {
            case 0:
                if (r(t11, i10)) {
                    j0.K(t10, jK, j0.v(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 1:
                if (r(t11, i10)) {
                    j0.L(t10, jK, j0.w(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 2:
                if (r(t11, i10)) {
                    j0.N(t10, jK, j0.y(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 3:
                if (r(t11, i10)) {
                    j0.N(t10, jK, j0.y(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 4:
                if (r(t11, i10)) {
                    j0.M(t10, jK, j0.x(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 5:
                if (r(t11, i10)) {
                    j0.N(t10, jK, j0.y(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 6:
                if (r(t11, i10)) {
                    j0.M(t10, jK, j0.x(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 7:
                if (r(t11, i10)) {
                    j0.E(t10, jK, j0.p(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 8:
                if (r(t11, i10)) {
                    j0.O(t10, jK, j0.A(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 9:
                D(t10, t11, i10);
                break;
            case 10:
                if (r(t11, i10)) {
                    j0.O(t10, jK, j0.A(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 11:
                if (r(t11, i10)) {
                    j0.M(t10, jK, j0.x(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 12:
                if (r(t11, i10)) {
                    j0.M(t10, jK, j0.x(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 13:
                if (r(t11, i10)) {
                    j0.M(t10, jK, j0.x(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 14:
                if (r(t11, i10)) {
                    j0.N(t10, jK, j0.y(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 15:
                if (r(t11, i10)) {
                    j0.M(t10, jK, j0.x(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 16:
                if (r(t11, i10)) {
                    j0.N(t10, jK, j0.y(t11, jK));
                    X(t10, i10);
                    break;
                }
                break;
            case 17:
                D(t10, t11, i10);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f13477n.d(t10, t11, jK);
                break;
            case 50:
                b0.F(this.f13480q, t10, t11, jK);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (x(t11, iJ, i10)) {
                    j0.O(t10, jK, j0.A(t11, jK));
                    Y(t10, iJ, i10);
                    break;
                }
                break;
            case 60:
                E(t10, t11, i10);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (x(t11, iJ, i10)) {
                    j0.O(t10, jK, j0.A(t11, jK));
                    Y(t10, iJ, i10);
                    break;
                }
                break;
            case 68:
                E(t10, t11, i10);
                break;
        }
    }

    public final int J(int i10) {
        return this.f13464a[i10];
    }

    public final int Q(int i10) {
        if (i10 < this.f13466c || i10 > this.f13467d) {
            return -1;
        }
        return Z(i10, 0);
    }

    public final int R(int i10) {
        return this.f13464a[i10 + 2];
    }

    public final <E> void S(Object obj, long j10, Y y10, Z<E> z10, C1351n c1351n) throws IOException {
        y10.g(this.f13477n.e(obj, j10), z10, c1351n);
    }

    public final <E> void T(Object obj, int i10, Y y10, Z<E> z10, C1351n c1351n) throws IOException {
        y10.b(this.f13477n.e(obj, K(i10)), z10, c1351n);
    }

    public final void U(Object obj, int i10, Y y10) throws IOException {
        if (q(i10)) {
            j0.O(obj, K(i10), y10.readStringRequireUtf8());
        } else if (this.f13470g) {
            j0.O(obj, K(i10), y10.readString());
        } else {
            j0.O(obj, K(i10), y10.readBytes());
        }
    }

    public final void V(Object obj, int i10, Y y10) throws IOException {
        if (q(i10)) {
            y10.readStringListRequireUtf8(this.f13477n.e(obj, K(i10)));
        } else {
            y10.readStringList(this.f13477n.e(obj, K(i10)));
        }
    }

    public final void X(T t10, int i10) {
        if (this.f13471h) {
            return;
        }
        int iR = R(i10);
        long j10 = iR & 1048575;
        j0.M(t10, j10, j0.x(t10, j10) | (1 << (iR >>> 20)));
    }

    public final void Y(T t10, int i10, int i11) {
        j0.M(t10, R(i11) & 1048575, i10);
    }

    public final int Z(int i10, int i11) {
        int length = (this.f13464a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int iJ = J(i13);
            if (i10 == iJ) {
                return i13;
            }
            if (i10 < iJ) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void a(T t10, Y y10, C1351n c1351n) throws Throwable {
        c1351n.getClass();
        B(this.f13478o, this.f13479p, t10, y10, c1351n);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void b(T t10, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            e0(t10, writer);
        } else if (this.f13471h) {
            d0(t10, writer);
        } else {
            c0(t10, writer);
        }
    }

    public final int b0(int i10) {
        return this.f13464a[i10 + 1];
    }

    public final boolean c(T t10, T t11, int i10) {
        return r(t10, i10) == r(t11, i10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.c0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(T r13, androidx.datastore.preferences.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.d0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.e0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public boolean equals(T t10, T t11) {
        int length = this.f13464a.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            if (!f(t10, t11, i10)) {
                return false;
            }
        }
        if (!this.f13478o.g(t10).equals(this.f13478o.g(t11))) {
            return false;
        }
        if (this.f13469f) {
            return this.f13479p.c(t10).equals(this.f13479p.c(t11));
        }
        return true;
    }

    public final boolean f(T t10, T t11, int i10) {
        int iB0 = b0(i10);
        long jK = K(iB0);
        switch (a0(iB0)) {
            case 0:
                if (!c(t10, t11, i10) || Double.doubleToLongBits(j0.v(t10, jK)) != Double.doubleToLongBits(j0.v(t11, jK))) {
                }
                break;
            case 1:
                if (!c(t10, t11, i10) || Float.floatToIntBits(j0.w(t10, jK)) != Float.floatToIntBits(j0.w(t11, jK))) {
                }
                break;
            case 2:
                if (!c(t10, t11, i10) || j0.y(t10, jK) != j0.y(t11, jK)) {
                }
                break;
            case 3:
                if (!c(t10, t11, i10) || j0.y(t10, jK) != j0.y(t11, jK)) {
                }
                break;
            case 4:
                if (!c(t10, t11, i10) || j0.x(t10, jK) != j0.x(t11, jK)) {
                }
                break;
            case 5:
                if (!c(t10, t11, i10) || j0.y(t10, jK) != j0.y(t11, jK)) {
                }
                break;
            case 6:
                if (!c(t10, t11, i10) || j0.x(t10, jK) != j0.x(t11, jK)) {
                }
                break;
            case 7:
                if (!c(t10, t11, i10) || j0.p(t10, jK) != j0.p(t11, jK)) {
                }
                break;
            case 8:
                if (!c(t10, t11, i10) || !b0.K(j0.A(t10, jK), j0.A(t11, jK))) {
                }
                break;
            case 9:
                if (!c(t10, t11, i10) || !b0.K(j0.A(t10, jK), j0.A(t11, jK))) {
                }
                break;
            case 10:
                if (!c(t10, t11, i10) || !b0.K(j0.A(t10, jK), j0.A(t11, jK))) {
                }
                break;
            case 11:
                if (!c(t10, t11, i10) || j0.x(t10, jK) != j0.x(t11, jK)) {
                }
                break;
            case 12:
                if (!c(t10, t11, i10) || j0.x(t10, jK) != j0.x(t11, jK)) {
                }
                break;
            case 13:
                if (!c(t10, t11, i10) || j0.x(t10, jK) != j0.x(t11, jK)) {
                }
                break;
            case 14:
                if (!c(t10, t11, i10) || j0.y(t10, jK) != j0.y(t11, jK)) {
                }
                break;
            case 15:
                if (!c(t10, t11, i10) || j0.x(t10, jK) != j0.x(t11, jK)) {
                }
                break;
            case 16:
                if (!c(t10, t11, i10) || j0.y(t10, jK) != j0.y(t11, jK)) {
                }
                break;
            case 17:
                if (!c(t10, t11, i10) || !b0.K(j0.A(t10, jK), j0.A(t11, jK))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!w(t10, t11, i10) || !b0.K(j0.A(t10, jK), j0.A(t11, jK))) {
                }
                break;
        }
        return true;
    }

    public final <K, V> void f0(Writer writer, int i10, Object obj, int i11) throws IOException {
        if (obj != null) {
            writer.d(i10, this.f13480q.forMapMetadata(k(i11)), this.f13480q.forMapData(obj));
        }
    }

    public final <UT, UB> UB g(Object obj, int i10, UB ub2, f0<UT, UB> f0Var) {
        C1359w.e eVarJ;
        int iJ = J(i10);
        Object objA = j0.A(obj, K(b0(i10)));
        return (objA == null || (eVarJ = j(i10)) == null) ? ub2 : (UB) h(i10, iJ, this.f13480q.forMutableMapData(objA), eVarJ, ub2, f0Var);
    }

    public final void g0(int i10, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i10, (String) obj);
        } else {
            writer.b(i10, (ByteString) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public int getSerializedSize(T t10) {
        return this.f13471h ? n(t10) : m(t10);
    }

    public final <K, V, UT, UB> UB h(int i10, int i11, Map<K, V> map, C1359w.e eVar, UB ub2, f0<UT, UB> f0Var) {
        E.a<?, ?> aVarForMapMetadata = this.f13480q.forMapMetadata(k(i10));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = f0Var.n();
                }
                ByteString.g gVarU = ByteString.u(E.b(aVarForMapMetadata, next.getKey(), next.getValue()));
                try {
                    E.e(gVarU.b(), aVarForMapMetadata, next.getKey(), next.getValue());
                    f0Var.d(ub2, i11, gVarU.a());
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    public final <UT, UB> void h0(f0<UT, UB> f0Var, T t10, Writer writer) throws IOException {
        f0Var.t(f0Var.g(t10), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public int hashCode(T t10) {
        int i10;
        int iF;
        int length = this.f13464a.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int iB0 = b0(i12);
            int iJ = J(i12);
            long jK = K(iB0);
            int iHashCode = 37;
            switch (a0(iB0)) {
                case 0:
                    i10 = i11 * 53;
                    iF = C1359w.f(Double.doubleToLongBits(j0.v(t10, jK)));
                    i11 = i10 + iF;
                    break;
                case 1:
                    i10 = i11 * 53;
                    iF = Float.floatToIntBits(j0.w(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 2:
                    i10 = i11 * 53;
                    iF = C1359w.f(j0.y(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 3:
                    i10 = i11 * 53;
                    iF = C1359w.f(j0.y(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 4:
                    i10 = i11 * 53;
                    iF = j0.x(t10, jK);
                    i11 = i10 + iF;
                    break;
                case 5:
                    i10 = i11 * 53;
                    iF = C1359w.f(j0.y(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 6:
                    i10 = i11 * 53;
                    iF = j0.x(t10, jK);
                    i11 = i10 + iF;
                    break;
                case 7:
                    i10 = i11 * 53;
                    iF = C1359w.c(j0.p(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 8:
                    i10 = i11 * 53;
                    iF = ((String) j0.A(t10, jK)).hashCode();
                    i11 = i10 + iF;
                    break;
                case 9:
                    Object objA = j0.A(t10, jK);
                    if (objA != null) {
                        iHashCode = objA.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 10:
                    i10 = i11 * 53;
                    iF = j0.A(t10, jK).hashCode();
                    i11 = i10 + iF;
                    break;
                case 11:
                    i10 = i11 * 53;
                    iF = j0.x(t10, jK);
                    i11 = i10 + iF;
                    break;
                case 12:
                    i10 = i11 * 53;
                    iF = j0.x(t10, jK);
                    i11 = i10 + iF;
                    break;
                case 13:
                    i10 = i11 * 53;
                    iF = j0.x(t10, jK);
                    i11 = i10 + iF;
                    break;
                case 14:
                    i10 = i11 * 53;
                    iF = C1359w.f(j0.y(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 15:
                    i10 = i11 * 53;
                    iF = j0.x(t10, jK);
                    i11 = i10 + iF;
                    break;
                case 16:
                    i10 = i11 * 53;
                    iF = C1359w.f(j0.y(t10, jK));
                    i11 = i10 + iF;
                    break;
                case 17:
                    Object objA2 = j0.A(t10, jK);
                    if (objA2 != null) {
                        iHashCode = objA2.hashCode();
                    }
                    i11 = (i11 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i11 * 53;
                    iF = j0.A(t10, jK).hashCode();
                    i11 = i10 + iF;
                    break;
                case 50:
                    i10 = i11 * 53;
                    iF = j0.A(t10, jK).hashCode();
                    i11 = i10 + iF;
                    break;
                case 51:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.f(Double.doubleToLongBits(M(t10, jK)));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = Float.floatToIntBits(N(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.f(P(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.f(P(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = O(t10, jK);
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.f(P(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = O(t10, jK);
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.c(L(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = ((String) j0.A(t10, jK)).hashCode();
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = j0.A(t10, jK).hashCode();
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = j0.A(t10, jK).hashCode();
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = O(t10, jK);
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = O(t10, jK);
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = O(t10, jK);
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.f(P(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = O(t10, jK);
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = C1359w.f(P(t10, jK));
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (x(t10, iJ, i12)) {
                        i10 = i11 * 53;
                        iF = j0.A(t10, jK).hashCode();
                        i11 = i10 + iF;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i11 * 53) + this.f13478o.g(t10).hashCode();
        return this.f13469f ? (iHashCode2 * 53) + this.f13479p.c(t10).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    @Override // androidx.datastore.preferences.protobuf.Z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T r13) {
        /*
            r12 = this;
            r0 = -1
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            int r4 = r12.f13474k
            r5 = 1
            if (r2 >= r4) goto L94
            int[] r4 = r12.f13473j
            r4 = r4[r2]
            int r6 = r12.J(r4)
            int r7 = r12.b0(r4)
            boolean r8 = r12.f13471h
            if (r8 != 0) goto L31
            int[] r8 = r12.f13464a
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r0) goto L32
            sun.misc.Unsafe r0 = androidx.datastore.preferences.protobuf.N.f13463s
            long r10 = (long) r9
            int r3 = r0.getInt(r13, r10)
            r0 = r9
            goto L32
        L31:
            r5 = r1
        L32:
            boolean r8 = y(r7)
            if (r8 == 0) goto L3f
            boolean r8 = r12.s(r13, r4, r3, r5)
            if (r8 != 0) goto L3f
            return r1
        L3f:
            int r8 = a0(r7)
            r9 = 9
            if (r8 == r9) goto L7f
            r9 = 17
            if (r8 == r9) goto L7f
            r5 = 27
            if (r8 == r5) goto L78
            r5 = 60
            if (r8 == r5) goto L67
            r5 = 68
            if (r8 == r5) goto L67
            r5 = 49
            if (r8 == r5) goto L78
            r5 = 50
            if (r8 == r5) goto L60
            goto L90
        L60:
            boolean r4 = r12.v(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L67:
            boolean r5 = r12.x(r13, r6, r4)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.Z r4 = r12.l(r4)
            boolean r4 = t(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L78:
            boolean r4 = r12.u(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L7f:
            boolean r5 = r12.s(r13, r4, r3, r5)
            if (r5 == 0) goto L90
            androidx.datastore.preferences.protobuf.Z r4 = r12.l(r4)
            boolean r4 = t(r13, r7, r4)
            if (r4 != 0) goto L90
            return r1
        L90:
            int r2 = r2 + 1
            goto L4
        L94:
            boolean r0 = r12.f13469f
            if (r0 == 0) goto La5
            androidx.datastore.preferences.protobuf.o<?> r12 = r12.f13479p
            androidx.datastore.preferences.protobuf.s r12 = r12.c(r13)
            boolean r12 = r12.p()
            if (r12 != 0) goto La5
            return r1
        La5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.N.isInitialized(java.lang.Object):boolean");
    }

    public final C1359w.e j(int i10) {
        return (C1359w.e) this.f13465b[((i10 / 3) * 2) + 1];
    }

    public final Object k(int i10) {
        return this.f13465b[(i10 / 3) * 2];
    }

    public final Z l(int i10) {
        int i11 = (i10 / 3) * 2;
        Z z10 = (Z) this.f13465b[i11];
        if (z10 != null) {
            return z10;
        }
        Z<T> zD = V.a().d((Class) this.f13465b[i11 + 1]);
        this.f13465b[i11] = zD;
        return zD;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int m(T t10) {
        int i10;
        int i11;
        int i12;
        int iD;
        boolean z10;
        int iF;
        int i13;
        int iV;
        int iX;
        Unsafe unsafe = f13463s;
        int i14 = -1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < this.f13464a.length) {
            int iB0 = b0(i15);
            int iJ = J(i15);
            int iA0 = a0(iB0);
            if (iA0 <= 17) {
                i10 = this.f13464a[i15 + 2];
                int i18 = 1048575 & i10;
                int i19 = 1 << (i10 >>> 20);
                if (i18 != i14) {
                    i17 = unsafe.getInt(t10, i18);
                    i14 = i18;
                }
                i11 = i19;
            } else {
                i10 = (!this.f13472i || iA0 < FieldType.DOUBLE_LIST_PACKED.id() || iA0 > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.f13464a[i15 + 2] & 1048575;
                i11 = 0;
            }
            long jK = K(iB0);
            int i20 = i14;
            switch (iA0) {
                case 0:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        i12 = CodedOutputStream.i(iJ, 0.0d);
                        i16 += i12;
                        break;
                    }
                case 1:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        i12 = CodedOutputStream.q(iJ, 0.0f);
                        i16 += i12;
                        break;
                    }
                case 2:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        i12 = CodedOutputStream.x(iJ, unsafe.getLong(t10, jK));
                        i16 += i12;
                        break;
                    }
                case 3:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        i12 = CodedOutputStream.Y(iJ, unsafe.getLong(t10, jK));
                        i16 += i12;
                        break;
                    }
                case 4:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        i12 = CodedOutputStream.v(iJ, unsafe.getInt(t10, jK));
                        i16 += i12;
                        break;
                    }
                case 5:
                    if ((i17 & i11) == 0) {
                        break;
                    } else {
                        i12 = CodedOutputStream.o(iJ, 0L);
                        i16 += i12;
                        break;
                    }
                case 6:
                    if ((i17 & i11) != 0) {
                        i12 = CodedOutputStream.m(iJ, 0);
                        i16 += i12;
                        break;
                    }
                    break;
                case 7:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.d(iJ, true);
                        i16 += iD;
                    }
                    break;
                case 8:
                    if ((i17 & i11) != 0) {
                        Object object = unsafe.getObject(t10, jK);
                        iD = object instanceof ByteString ? CodedOutputStream.g(iJ, (ByteString) object) : CodedOutputStream.T(iJ, (String) object);
                        i16 += iD;
                    }
                    break;
                case 9:
                    if ((i17 & i11) != 0) {
                        iD = b0.o(iJ, unsafe.getObject(t10, jK), l(i15));
                        i16 += iD;
                    }
                    break;
                case 10:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.g(iJ, (ByteString) unsafe.getObject(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 11:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.W(iJ, unsafe.getInt(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 12:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.k(iJ, unsafe.getInt(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 13:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.L(iJ, 0);
                        i16 += iD;
                    }
                    break;
                case 14:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.N(iJ, 0L);
                        i16 += iD;
                    }
                    break;
                case 15:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.P(iJ, unsafe.getInt(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 16:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.R(iJ, unsafe.getLong(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 17:
                    if ((i17 & i11) != 0) {
                        iD = CodedOutputStream.s(iJ, (K) unsafe.getObject(t10, jK), l(i15));
                        i16 += iD;
                    }
                    break;
                case 18:
                    iD = b0.h(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iD;
                    break;
                case 19:
                    z10 = false;
                    iF = b0.f(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 20:
                    z10 = false;
                    iF = b0.m(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 21:
                    z10 = false;
                    iF = b0.x(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 22:
                    z10 = false;
                    iF = b0.k(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 23:
                    z10 = false;
                    iF = b0.h(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 24:
                    z10 = false;
                    iF = b0.f(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 25:
                    z10 = false;
                    iF = b0.a(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 26:
                    iD = b0.u(iJ, (List) unsafe.getObject(t10, jK));
                    i16 += iD;
                    break;
                case 27:
                    iD = b0.p(iJ, (List) unsafe.getObject(t10, jK), l(i15));
                    i16 += iD;
                    break;
                case 28:
                    iD = b0.c(iJ, (List) unsafe.getObject(t10, jK));
                    i16 += iD;
                    break;
                case 29:
                    iD = b0.v(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iD;
                    break;
                case 30:
                    z10 = false;
                    iF = b0.d(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 31:
                    z10 = false;
                    iF = b0.f(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 32:
                    z10 = false;
                    iF = b0.h(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 33:
                    z10 = false;
                    iF = b0.q(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 34:
                    z10 = false;
                    iF = b0.s(iJ, (List) unsafe.getObject(t10, jK), false);
                    i16 += iF;
                    break;
                case 35:
                    i13 = b0.i((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 36:
                    i13 = b0.g((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 37:
                    i13 = b0.n((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 38:
                    i13 = b0.y((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 39:
                    i13 = b0.l((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 40:
                    i13 = b0.i((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 41:
                    i13 = b0.g((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 42:
                    i13 = b0.b((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 43:
                    i13 = b0.w((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 44:
                    i13 = b0.e((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 45:
                    i13 = b0.g((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 46:
                    i13 = b0.i((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 47:
                    i13 = b0.r((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 48:
                    i13 = b0.t((List) unsafe.getObject(t10, jK));
                    if (i13 > 0) {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i10, i13);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i13);
                        i16 += iV + iX + i13;
                    }
                    break;
                case 49:
                    iD = b0.j(iJ, (List) unsafe.getObject(t10, jK), l(i15));
                    i16 += iD;
                    break;
                case 50:
                    iD = this.f13480q.getSerializedSize(iJ, unsafe.getObject(t10, jK), k(i15));
                    i16 += iD;
                    break;
                case 51:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.i(iJ, 0.0d);
                        i16 += iD;
                    }
                    break;
                case 52:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.q(iJ, 0.0f);
                        i16 += iD;
                    }
                    break;
                case 53:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.x(iJ, P(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 54:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.Y(iJ, P(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 55:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.v(iJ, O(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 56:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.o(iJ, 0L);
                        i16 += iD;
                    }
                    break;
                case 57:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.m(iJ, 0);
                        i16 += iD;
                    }
                    break;
                case 58:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.d(iJ, true);
                        i16 += iD;
                    }
                    break;
                case 59:
                    if (x(t10, iJ, i15)) {
                        Object object2 = unsafe.getObject(t10, jK);
                        iD = object2 instanceof ByteString ? CodedOutputStream.g(iJ, (ByteString) object2) : CodedOutputStream.T(iJ, (String) object2);
                        i16 += iD;
                    }
                    break;
                case 60:
                    if (x(t10, iJ, i15)) {
                        iD = b0.o(iJ, unsafe.getObject(t10, jK), l(i15));
                        i16 += iD;
                    }
                    break;
                case 61:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.g(iJ, (ByteString) unsafe.getObject(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 62:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.W(iJ, O(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 63:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.k(iJ, O(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 64:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.L(iJ, 0);
                        i16 += iD;
                    }
                    break;
                case 65:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.N(iJ, 0L);
                        i16 += iD;
                    }
                    break;
                case 66:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.P(iJ, O(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 67:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.R(iJ, P(t10, jK));
                        i16 += iD;
                    }
                    break;
                case 68:
                    if (x(t10, iJ, i15)) {
                        iD = CodedOutputStream.s(iJ, (K) unsafe.getObject(t10, jK), l(i15));
                        i16 += iD;
                    }
                    break;
            }
            i15 += 3;
            i14 = i20;
        }
        int iO = i16 + o(this.f13478o, t10);
        return this.f13469f ? iO + this.f13479p.c(t10).l() : iO;
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void makeImmutable(T t10) {
        int i10;
        int i11 = this.f13474k;
        while (true) {
            i10 = this.f13475l;
            if (i11 >= i10) {
                break;
            }
            long jK = K(b0(this.f13473j[i11]));
            Object objA = j0.A(t10, jK);
            if (objA != null) {
                j0.O(t10, jK, this.f13480q.toImmutable(objA));
            }
            i11++;
        }
        int length = this.f13473j.length;
        while (i10 < length) {
            this.f13477n.c(t10, this.f13473j[i10]);
            i10++;
        }
        this.f13478o.j(t10);
        if (this.f13469f) {
            this.f13479p.f(t10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void mergeFrom(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.f13464a.length; i10 += 3) {
            F(t10, t11, i10);
        }
        if (this.f13471h) {
            return;
        }
        b0.G(this.f13478o, t10, t11);
        if (this.f13469f) {
            b0.E(this.f13479p, t10, t11);
        }
    }

    public final int n(T t10) {
        int i10;
        int i11;
        int iV;
        int iX;
        Unsafe unsafe = f13463s;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f13464a.length; i13 += 3) {
            int iB0 = b0(i13);
            int iA0 = a0(iB0);
            int iJ = J(i13);
            long jK = K(iB0);
            int i14 = (iA0 < FieldType.DOUBLE_LIST_PACKED.id() || iA0 > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.f13464a[i13 + 2] & 1048575;
            switch (iA0) {
                case 0:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.i(iJ, 0.0d);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.q(iJ, 0.0f);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.x(iJ, j0.y(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.Y(iJ, j0.y(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.v(iJ, j0.x(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.o(iJ, 0L);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.m(iJ, 0);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.d(iJ, true);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (r(t10, i13)) {
                        Object objA = j0.A(t10, jK);
                        i10 = objA instanceof ByteString ? CodedOutputStream.g(iJ, (ByteString) objA) : CodedOutputStream.T(iJ, (String) objA);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (r(t10, i13)) {
                        i10 = b0.o(iJ, j0.A(t10, jK), l(i13));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.g(iJ, (ByteString) j0.A(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.W(iJ, j0.x(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.k(iJ, j0.x(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.L(iJ, 0);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.N(iJ, 0L);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.P(iJ, j0.x(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.R(iJ, j0.y(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (r(t10, i13)) {
                        i10 = CodedOutputStream.s(iJ, (K) j0.A(t10, jK), l(i13));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i10 = b0.h(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 19:
                    i10 = b0.f(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 20:
                    i10 = b0.m(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 21:
                    i10 = b0.x(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 22:
                    i10 = b0.k(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 23:
                    i10 = b0.h(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 24:
                    i10 = b0.f(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 25:
                    i10 = b0.a(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 26:
                    i10 = b0.u(iJ, z(t10, jK));
                    i12 += i10;
                    break;
                case 27:
                    i10 = b0.p(iJ, z(t10, jK), l(i13));
                    i12 += i10;
                    break;
                case 28:
                    i10 = b0.c(iJ, z(t10, jK));
                    i12 += i10;
                    break;
                case 29:
                    i10 = b0.v(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 30:
                    i10 = b0.d(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 31:
                    i10 = b0.f(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 32:
                    i10 = b0.h(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 33:
                    i10 = b0.q(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 34:
                    i10 = b0.s(iJ, z(t10, jK), false);
                    i12 += i10;
                    break;
                case 35:
                    i11 = b0.i((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 36:
                    i11 = b0.g((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 37:
                    i11 = b0.n((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 38:
                    i11 = b0.y((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 39:
                    i11 = b0.l((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 40:
                    i11 = b0.i((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 41:
                    i11 = b0.g((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 42:
                    i11 = b0.b((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 43:
                    i11 = b0.w((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 44:
                    i11 = b0.e((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 45:
                    i11 = b0.g((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 46:
                    i11 = b0.i((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 47:
                    i11 = b0.r((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 48:
                    i11 = b0.t((List) unsafe.getObject(t10, jK));
                    if (i11 <= 0) {
                        break;
                    } else {
                        if (this.f13472i) {
                            unsafe.putInt(t10, i14, i11);
                        }
                        iV = CodedOutputStream.V(iJ);
                        iX = CodedOutputStream.X(i11);
                        i10 = iV + iX + i11;
                        i12 += i10;
                        break;
                    }
                case 49:
                    i10 = b0.j(iJ, z(t10, jK), l(i13));
                    i12 += i10;
                    break;
                case 50:
                    i10 = this.f13480q.getSerializedSize(iJ, j0.A(t10, jK), k(i13));
                    i12 += i10;
                    break;
                case 51:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.i(iJ, 0.0d);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.q(iJ, 0.0f);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.x(iJ, P(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.Y(iJ, P(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.v(iJ, O(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.o(iJ, 0L);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.m(iJ, 0);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.d(iJ, true);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (x(t10, iJ, i13)) {
                        Object objA2 = j0.A(t10, jK);
                        i10 = objA2 instanceof ByteString ? CodedOutputStream.g(iJ, (ByteString) objA2) : CodedOutputStream.T(iJ, (String) objA2);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (x(t10, iJ, i13)) {
                        i10 = b0.o(iJ, j0.A(t10, jK), l(i13));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.g(iJ, (ByteString) j0.A(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.W(iJ, O(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.k(iJ, O(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.L(iJ, 0);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.N(iJ, 0L);
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.P(iJ, O(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.R(iJ, P(t10, jK));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (x(t10, iJ, i13)) {
                        i10 = CodedOutputStream.s(iJ, (K) j0.A(t10, jK), l(i13));
                        i12 += i10;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i12 + o(this.f13478o, t10);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public T newInstance() {
        return (T) this.f13476m.newInstance(this.f13468e);
    }

    public final <UT, UB> int o(f0<UT, UB> f0Var, T t10) {
        return f0Var.h(f0Var.g(t10));
    }

    public final boolean r(T t10, int i10) {
        boolean zEquals;
        if (!this.f13471h) {
            int iR = R(i10);
            return (j0.x(t10, (long) (iR & 1048575)) & (1 << (iR >>> 20))) != 0;
        }
        int iB0 = b0(i10);
        long jK = K(iB0);
        switch (a0(iB0)) {
            case 0:
                return j0.v(t10, jK) != 0.0d;
            case 1:
                return j0.w(t10, jK) != 0.0f;
            case 2:
                return j0.y(t10, jK) != 0;
            case 3:
                return j0.y(t10, jK) != 0;
            case 4:
                return j0.x(t10, jK) != 0;
            case 5:
                return j0.y(t10, jK) != 0;
            case 6:
                return j0.x(t10, jK) != 0;
            case 7:
                return j0.p(t10, jK);
            case 8:
                Object objA = j0.A(t10, jK);
                if (objA instanceof String) {
                    zEquals = ((String) objA).isEmpty();
                    break;
                } else {
                    if (!(objA instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.f13407b.equals(objA);
                    break;
                }
            case 9:
                return j0.A(t10, jK) != null;
            case 10:
                zEquals = ByteString.f13407b.equals(j0.A(t10, jK));
                break;
            case 11:
                return j0.x(t10, jK) != 0;
            case 12:
                return j0.x(t10, jK) != 0;
            case 13:
                return j0.x(t10, jK) != 0;
            case 14:
                return j0.y(t10, jK) != 0;
            case 15:
                return j0.x(t10, jK) != 0;
            case 16:
                return j0.y(t10, jK) != 0;
            case 17:
                return j0.A(t10, jK) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    public final boolean s(T t10, int i10, int i11, int i12) {
        return this.f13471h ? r(t10, i10) : (i11 & i12) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N> boolean u(Object obj, int i10, int i11) {
        List list = (List) j0.A(obj, K(i10));
        if (list.isEmpty()) {
            return true;
        }
        Z zL = l(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (!zL.isInitialized(list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.datastore.preferences.protobuf.Z] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public final boolean v(T t10, int i10, int i11) {
        Map<?, ?> mapForMapData = this.f13480q.forMapData(j0.A(t10, K(i10)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.f13480q.forMapMetadata(k(i11)).f13443c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? D10 = 0;
        for (Object obj : mapForMapData.values()) {
            D10 = D10;
            if (D10 == 0) {
                D10 = V.a().d(obj.getClass());
            }
            if (!D10.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    public final boolean w(T t10, T t11, int i10) {
        long jR = R(i10) & 1048575;
        return j0.x(t10, jR) == j0.x(t11, jR);
    }

    public final boolean x(T t10, int i10, int i11) {
        return j0.x(t10, (long) (R(i11) & 1048575)) == i10;
    }
}
