package androidx.datastore.preferences.protobuf;

import com.google.protobuf.q2;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class q0 implements z0 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f919o = new int[0];

    /* renamed from: p, reason: collision with root package name */
    public static final Unsafe f920p = s1.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f921a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f922b;

    /* renamed from: c, reason: collision with root package name */
    public final int f923c;

    /* renamed from: d, reason: collision with root package name */
    public final int f924d;

    /* renamed from: e, reason: collision with root package name */
    public final a f925e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f926f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f927g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f928h;

    /* renamed from: i, reason: collision with root package name */
    public final int f929i;

    /* renamed from: j, reason: collision with root package name */
    public final int f930j;

    /* renamed from: k, reason: collision with root package name */
    public final s0 f931k;

    /* renamed from: l, reason: collision with root package name */
    public final g0 f932l;

    /* renamed from: m, reason: collision with root package name */
    public final k1 f933m;

    /* renamed from: n, reason: collision with root package name */
    public final m0 f934n;

    public q0(int[] iArr, Object[] objArr, int i2, int i10, a aVar, boolean z4, int[] iArr2, int i11, int i12, s0 s0Var, g0 g0Var, k1 k1Var, p pVar, m0 m0Var) {
        this.f921a = iArr;
        this.f922b = objArr;
        this.f923c = i2;
        this.f924d = i10;
        this.f926f = aVar instanceof w;
        this.f927g = z4;
        this.f928h = iArr2;
        this.f929i = i11;
        this.f930j = i12;
        this.f931k = s0Var;
        this.f932l = g0Var;
        this.f933m = k1Var;
        this.f925e = aVar;
        this.f934n = m0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0375  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.q0 A(androidx.datastore.preferences.protobuf.y0 r34, androidx.datastore.preferences.protobuf.s0 r35, androidx.datastore.preferences.protobuf.g0 r36, androidx.datastore.preferences.protobuf.k1 r37, androidx.datastore.preferences.protobuf.p r38, androidx.datastore.preferences.protobuf.m0 r39) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.A(androidx.datastore.preferences.protobuf.y0, androidx.datastore.preferences.protobuf.s0, androidx.datastore.preferences.protobuf.g0, androidx.datastore.preferences.protobuf.k1, androidx.datastore.preferences.protobuf.p, androidx.datastore.preferences.protobuf.m0):androidx.datastore.preferences.protobuf.q0");
    }

    public static long B(int i2) {
        return i2 & 1048575;
    }

    public static int C(long j2, Object obj) {
        return ((Integer) s1.f949c.i(j2, obj)).intValue();
    }

    public static long D(long j2, Object obj) {
        return ((Long) s1.f949c.i(j2, obj)).longValue();
    }

    public static Field I(Class cls, String str) {
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

    public static int N(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static void R(int i2, Object obj, i0 i0Var) throws IOException {
        if (!(obj instanceof String)) {
            i0Var.a(i2, (g) obj);
        } else {
            ((m) i0Var.f880a).J(i2, (String) obj);
        }
    }

    public static boolean r(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof w) {
            return ((w) obj).g();
        }
        return true;
    }

    public static List t(w wVar, long j2) {
        return (List) s1.f949c.i(j2, wVar);
    }

    public static q0 z(y0 y0Var, s0 s0Var, g0 g0Var, k1 k1Var, p pVar, m0 m0Var) {
        if (y0Var instanceof y0) {
            return A(y0Var, s0Var, g0Var, k1Var, pVar, m0Var);
        }
        y0Var.getClass();
        throw new ClassCastException();
    }

    public final void E(Object obj, long j2, k kVar, z0 z0Var, o oVar) throws z {
        int iC;
        List listC = this.f932l.c(j2, obj);
        j jVar = (j) kVar.f896e;
        int i2 = kVar.f893b;
        if ((i2 & 7) != 3) {
            throw a0.b();
        }
        do {
            w wVarD = z0Var.d();
            kVar.d(wVarD, z0Var, oVar);
            z0Var.b(wVarD);
            listC.add(wVarD);
            if (jVar.g() || kVar.f895d != 0) {
                return;
            } else {
                iC = jVar.C();
            }
        } while (iC == i2);
        kVar.f895d = iC;
    }

    public final void F(Object obj, int i2, k kVar, z0 z0Var, o oVar) throws a0 {
        int iC;
        List listC = this.f932l.c(i2 & 1048575, obj);
        j jVar = (j) kVar.f896e;
        int i10 = kVar.f893b;
        if ((i10 & 7) != 2) {
            throw a0.b();
        }
        do {
            w wVarD = z0Var.d();
            kVar.g(wVarD, z0Var, oVar);
            z0Var.b(wVarD);
            listC.add(wVarD);
            if (jVar.g() || kVar.f895d != 0) {
                return;
            } else {
                iC = jVar.C();
            }
        } while (iC == i10);
        kVar.f895d = iC;
    }

    public final void G(int i2, k kVar, Object obj) throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        if ((536870912 & i2) != 0) {
            kVar.V(2);
            s1.p(i2 & 1048575, obj, ((j) kVar.f896e).B());
        } else if (!this.f926f) {
            s1.p(i2 & 1048575, obj, kVar.l());
        } else {
            kVar.V(2);
            s1.p(i2 & 1048575, obj, ((j) kVar.f896e).A());
        }
    }

    public final void H(int i2, k kVar, Object obj) throws z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        int i10 = 536870912 & i2;
        g0 g0Var = this.f932l;
        if (i10 != 0) {
            kVar.P(g0Var.c(i2 & 1048575, obj), true);
        } else {
            kVar.P(g0Var.c(i2 & 1048575, obj), false);
        }
    }

    public final void J(int i2, Object obj) {
        int i10 = this.f921a[i2 + 2];
        long j2 = 1048575 & i10;
        if (j2 == 1048575) {
            return;
        }
        s1.n((1 << (i10 >>> 20)) | s1.f949c.g(j2, obj), j2, obj);
    }

    public final void K(int i2, int i10, Object obj) {
        s1.n(i2, this.f921a[i10 + 2] & 1048575, obj);
    }

    public final void L(Object obj, int i2, a aVar) {
        f920p.putObject(obj, O(i2) & 1048575, aVar);
        J(i2, obj);
    }

    public final void M(Object obj, int i2, int i10, a aVar) {
        f920p.putObject(obj, O(i10) & 1048575, aVar);
        K(i2, i10, obj);
    }

    public final int O(int i2) {
        return this.f921a[i2 + 1];
    }

    public final void P(Object obj, i0 i0Var) throws IOException {
        int i2;
        int i10;
        int i11;
        int[] iArr = this.f921a;
        int length = iArr.length;
        Unsafe unsafe = f920p;
        int i12 = 1048575;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14 = i11 + 3) {
            int iO = O(i14);
            int i15 = iArr[i14];
            int iN = N(iO);
            if (iN <= 17) {
                int i16 = iArr[i14 + 2];
                i2 = 1048575;
                int i17 = i16 & 1048575;
                if (i17 != i12) {
                    i13 = unsafe.getInt(obj, i17);
                    i12 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i2 = 1048575;
                i10 = 0;
            }
            int i18 = i14;
            long j2 = iO & i2;
            switch (iN) {
                case 0:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        double dE = s1.f949c.e(j2, obj);
                        m mVar = (m) i0Var.f880a;
                        mVar.getClass();
                        mVar.E(i15, Double.doubleToRawLongBits(dE));
                        continue;
                    }
                case 1:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        float f10 = s1.f949c.f(j2, obj);
                        m mVar2 = (m) i0Var.f880a;
                        mVar2.getClass();
                        mVar2.C(i15, Float.floatToRawIntBits(f10));
                    } else {
                        continue;
                    }
                case 2:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).O(i15, unsafe.getLong(obj, j2));
                    } else {
                        continue;
                    }
                case 3:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).O(i15, unsafe.getLong(obj, j2));
                    } else {
                        continue;
                    }
                case 4:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).G(i15, unsafe.getInt(obj, j2));
                    } else {
                        continue;
                    }
                case 5:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).E(i15, unsafe.getLong(obj, j2));
                    } else {
                        continue;
                    }
                case 6:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).C(i15, unsafe.getInt(obj, j2));
                    } else {
                        continue;
                    }
                case 7:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).z(i15, s1.f949c.c(j2, obj));
                    } else {
                        continue;
                    }
                case 8:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        R(i15, unsafe.getObject(obj, j2), i0Var);
                    } else {
                        continue;
                    }
                case 9:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).I(i15, (a) unsafe.getObject(obj, j2), n(i11));
                    } else {
                        continue;
                    }
                case 10:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        i0Var.a(i15, (g) unsafe.getObject(obj, j2));
                    } else {
                        continue;
                    }
                case 11:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).M(i15, unsafe.getInt(obj, j2));
                    } else {
                        continue;
                    }
                case 12:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).G(i15, unsafe.getInt(obj, j2));
                    } else {
                        continue;
                    }
                case 13:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).C(i15, unsafe.getInt(obj, j2));
                    } else {
                        continue;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((m) i0Var.f880a).E(i15, unsafe.getLong(obj, j2));
                    } else {
                        continue;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i19 = unsafe.getInt(obj, j2);
                        ((m) i0Var.f880a).M(i15, (i19 >> 31) ^ (i19 << 1));
                    } else {
                        continue;
                    }
                case 16:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        long j4 = unsafe.getLong(obj, j2);
                        ((m) i0Var.f880a).O(i15, (j4 << 1) ^ (j4 >> 63));
                    } else {
                        continue;
                    }
                case 17:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        i0Var.b(i15, unsafe.getObject(obj, j2), n(i11));
                    } else {
                        continue;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    i11 = i18;
                    a1.B(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    i11 = i18;
                    a1.F(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 20:
                    i11 = i18;
                    a1.I(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    i11 = i18;
                    a1.Q(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    i11 = i18;
                    a1.H(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    i11 = i18;
                    a1.E(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 24:
                    i11 = i18;
                    a1.D(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 25:
                    i11 = i18;
                    a1.z(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 26:
                    i11 = i18;
                    a1.O(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var);
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    i11 = i18;
                    a1.J(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, n(i11));
                    break;
                case 28:
                    i11 = i18;
                    a1.A(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var);
                    break;
                case 29:
                    i11 = i18;
                    a1.P(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    break;
                case 30:
                    i11 = i18;
                    a1.C(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    i11 = i18;
                    a1.K(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 32:
                    i11 = i18;
                    a1.L(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 33:
                    i11 = i18;
                    a1.M(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case 34:
                    i11 = i18;
                    a1.N(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, false);
                    continue;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    i11 = i18;
                    a1.B(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    i11 = i18;
                    a1.F(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    i11 = i18;
                    a1.I(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 38:
                    i11 = i18;
                    a1.Q(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    i11 = i18;
                    a1.H(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    i11 = i18;
                    a1.E(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    i11 = i18;
                    a1.D(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 42:
                    i11 = i18;
                    a1.z(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 43:
                    i11 = i18;
                    a1.P(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    i11 = i18;
                    a1.C(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    i11 = i18;
                    a1.K(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 46:
                    i11 = i18;
                    a1.L(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 47:
                    i11 = i18;
                    a1.M(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 48:
                    i11 = i18;
                    a1.N(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, true);
                    break;
                case 49:
                    i11 = i18;
                    a1.G(iArr[i11], (List) unsafe.getObject(obj, j2), i0Var, n(i11));
                    break;
                case 50:
                    i11 = i18;
                    Q(i0Var, i15, unsafe.getObject(obj, j2), i11);
                    break;
                case 51:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        double dDoubleValue = ((Double) s1.f949c.i(j2, obj)).doubleValue();
                        m mVar3 = (m) i0Var.f880a;
                        mVar3.getClass();
                        mVar3.E(i15, Double.doubleToRawLongBits(dDoubleValue));
                        break;
                    }
                    break;
                case 52:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        float fFloatValue = ((Float) s1.f949c.i(j2, obj)).floatValue();
                        m mVar4 = (m) i0Var.f880a;
                        mVar4.getClass();
                        mVar4.C(i15, Float.floatToRawIntBits(fFloatValue));
                        break;
                    }
                    break;
                case 53:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).O(i15, D(j2, obj));
                        break;
                    }
                    break;
                case 54:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).O(i15, D(j2, obj));
                        break;
                    }
                    break;
                case 55:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).G(i15, C(j2, obj));
                        break;
                    }
                    break;
                case 56:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).E(i15, D(j2, obj));
                        break;
                    }
                    break;
                case 57:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).C(i15, C(j2, obj));
                        break;
                    }
                    break;
                case 58:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).z(i15, ((Boolean) s1.f949c.i(j2, obj)).booleanValue());
                        break;
                    }
                    break;
                case 59:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        R(i15, unsafe.getObject(obj, j2), i0Var);
                        break;
                    }
                    break;
                case 60:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).I(i15, (a) unsafe.getObject(obj, j2), n(i11));
                        break;
                    }
                    break;
                case 61:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        i0Var.a(i15, (g) unsafe.getObject(obj, j2));
                        break;
                    }
                    break;
                case 62:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).M(i15, C(j2, obj));
                        break;
                    }
                    break;
                case 63:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).G(i15, C(j2, obj));
                        break;
                    }
                    break;
                case 64:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).C(i15, C(j2, obj));
                        break;
                    }
                    break;
                case 65:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        ((m) i0Var.f880a).E(i15, D(j2, obj));
                        break;
                    }
                    break;
                case 66:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        int iC = C(j2, obj);
                        ((m) i0Var.f880a).M(i15, (iC >> 31) ^ (iC << 1));
                        break;
                    }
                    break;
                case 67:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        long jD = D(j2, obj);
                        ((m) i0Var.f880a).O(i15, (jD << 1) ^ (jD >> 63));
                        break;
                    }
                    break;
                case 68:
                    i11 = i18;
                    if (s(i15, i11, obj)) {
                        i0Var.b(i15, unsafe.getObject(obj, j2), n(i11));
                        break;
                    }
                    break;
                default:
                    i11 = i18;
                    break;
            }
        }
        this.f933m.getClass();
        ((w) obj).unknownFields.d(i0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q(androidx.datastore.preferences.protobuf.i0 r22, int r23, java.lang.Object r24, int r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.Q(androidx.datastore.preferences.protobuf.i0, int, java.lang.Object, int):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // androidx.datastore.preferences.protobuf.z0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    @Override // androidx.datastore.preferences.protobuf.z0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = r(r10)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r10 instanceof androidx.datastore.preferences.protobuf.w
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r10
            androidx.datastore.preferences.protobuf.w r0 = (androidx.datastore.preferences.protobuf.w) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.k(r2)
            r0.memoizedHashCode = r1
            r0.h()
        L1a:
            int[] r0 = r9.f921a
            int r2 = r0.length
            r3 = r1
        L1e:
            if (r3 >= r2) goto L85
            int r4 = r9.O(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            long r5 = (long) r5
            int r4 = N(r4)
            r7 = 9
            if (r4 == r7) goto L6f
            r7 = 60
            if (r4 == r7) goto L59
            r7 = 68
            if (r4 == r7) goto L59
            switch(r4) {
                case 17: goto L6f;
                case 18: goto L53;
                case 19: goto L53;
                case 20: goto L53;
                case 21: goto L53;
                case 22: goto L53;
                case 23: goto L53;
                case 24: goto L53;
                case 25: goto L53;
                case 26: goto L53;
                case 27: goto L53;
                case 28: goto L53;
                case 29: goto L53;
                case 30: goto L53;
                case 31: goto L53;
                case 32: goto L53;
                case 33: goto L53;
                case 34: goto L53;
                case 35: goto L53;
                case 36: goto L53;
                case 37: goto L53;
                case 38: goto L53;
                case 39: goto L53;
                case 40: goto L53;
                case 41: goto L53;
                case 42: goto L53;
                case 43: goto L53;
                case 44: goto L53;
                case 45: goto L53;
                case 46: goto L53;
                case 47: goto L53;
                case 48: goto L53;
                case 49: goto L53;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L82
        L3d:
            sun.misc.Unsafe r4 = androidx.datastore.preferences.protobuf.q0.f920p
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L82
            androidx.datastore.preferences.protobuf.m0 r8 = r9.f934n
            r8.getClass()
            r8 = r7
            androidx.datastore.preferences.protobuf.l0 r8 = (androidx.datastore.preferences.protobuf.l0) r8
            r8.f899f = r1
            r4.putObject(r10, r5, r7)
            goto L82
        L53:
            androidx.datastore.preferences.protobuf.g0 r4 = r9.f932l
            r4.a(r5, r10)
            goto L82
        L59:
            r4 = r0[r3]
            boolean r4 = r9.s(r4, r3, r10)
            if (r4 == 0) goto L82
            androidx.datastore.preferences.protobuf.z0 r4 = r9.n(r3)
            sun.misc.Unsafe r7 = androidx.datastore.preferences.protobuf.q0.f920p
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.b(r5)
            goto L82
        L6f:
            boolean r4 = r9.q(r3, r10)
            if (r4 == 0) goto L82
            androidx.datastore.preferences.protobuf.z0 r4 = r9.n(r3)
            sun.misc.Unsafe r7 = androidx.datastore.preferences.protobuf.q0.f920p
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.b(r5)
        L82:
            int r3 = r3 + 3
            goto L1e
        L85:
            androidx.datastore.preferences.protobuf.k1 r9 = r9.f933m
            r9.getClass()
            androidx.datastore.preferences.protobuf.w r10 = (androidx.datastore.preferences.protobuf.w) r10
            androidx.datastore.preferences.protobuf.j1 r9 = r10.unknownFields
            r9.f891e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.b(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    @Override // androidx.datastore.preferences.protobuf.z0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.c(java.lang.Object):boolean");
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final w d() {
        this.f931k.getClass();
        return ((w) this.f925e).i();
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final void e(Object obj, i0 i0Var) throws IOException {
        i0Var.getClass();
        m mVar = (m) i0Var.f880a;
        if (!this.f927g) {
            P(obj, i0Var);
            return;
        }
        int[] iArr = this.f921a;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int iO = O(i2);
            int i10 = iArr[i2];
            switch (N(iO)) {
                case 0:
                    if (q(i2, obj)) {
                        double dE = s1.f949c.e(iO & 1048575, obj);
                        mVar.getClass();
                        mVar.E(i10, Double.doubleToRawLongBits(dE));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (q(i2, obj)) {
                        float f10 = s1.f949c.f(iO & 1048575, obj);
                        mVar.getClass();
                        mVar.C(i10, Float.floatToRawIntBits(f10));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (q(i2, obj)) {
                        mVar.O(i10, s1.f949c.h(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (q(i2, obj)) {
                        mVar.O(i10, s1.f949c.h(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (q(i2, obj)) {
                        mVar.G(i10, s1.f949c.g(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (q(i2, obj)) {
                        mVar.E(i10, s1.f949c.h(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (q(i2, obj)) {
                        mVar.C(i10, s1.f949c.g(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (q(i2, obj)) {
                        mVar.z(i10, s1.f949c.c(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (q(i2, obj)) {
                        R(i10, s1.f949c.i(iO & 1048575, obj), i0Var);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (q(i2, obj)) {
                        mVar.I(i10, (a) s1.f949c.i(iO & 1048575, obj), n(i2));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (q(i2, obj)) {
                        i0Var.a(i10, (g) s1.f949c.i(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (q(i2, obj)) {
                        mVar.M(i10, s1.f949c.g(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (q(i2, obj)) {
                        mVar.G(i10, s1.f949c.g(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (q(i2, obj)) {
                        mVar.C(i10, s1.f949c.g(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (q(i2, obj)) {
                        mVar.E(i10, s1.f949c.h(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (q(i2, obj)) {
                        int iG = s1.f949c.g(iO & 1048575, obj);
                        mVar.M(i10, (iG >> 31) ^ (iG << 1));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (q(i2, obj)) {
                        long jH = s1.f949c.h(iO & 1048575, obj);
                        mVar.O(i10, (jH >> 63) ^ (jH << 1));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (q(i2, obj)) {
                        i0Var.b(i10, s1.f949c.i(iO & 1048575, obj), n(i2));
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    a1.B(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    a1.F(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 20:
                    a1.I(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    a1.Q(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    a1.H(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    a1.E(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 24:
                    a1.D(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 25:
                    a1.z(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 26:
                    a1.O(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var);
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    a1.J(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, n(i2));
                    break;
                case 28:
                    a1.A(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var);
                    break;
                case 29:
                    a1.P(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 30:
                    a1.C(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    a1.K(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 32:
                    a1.L(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 33:
                    a1.M(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case 34:
                    a1.N(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, false);
                    break;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    a1.B(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    a1.F(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    a1.I(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 38:
                    a1.Q(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    a1.H(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    a1.E(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    a1.D(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 42:
                    a1.z(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 43:
                    a1.P(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    a1.C(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    a1.K(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 46:
                    a1.L(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 47:
                    a1.M(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 48:
                    a1.N(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, true);
                    break;
                case 49:
                    a1.G(iArr[i2], (List) s1.f949c.i(iO & 1048575, obj), i0Var, n(i2));
                    break;
                case 50:
                    Q(i0Var, i10, s1.f949c.i(iO & 1048575, obj), i2);
                    break;
                case 51:
                    if (s(i10, i2, obj)) {
                        double dDoubleValue = ((Double) s1.f949c.i(iO & 1048575, obj)).doubleValue();
                        mVar.getClass();
                        mVar.E(i10, Double.doubleToRawLongBits(dDoubleValue));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (s(i10, i2, obj)) {
                        float fFloatValue = ((Float) s1.f949c.i(iO & 1048575, obj)).floatValue();
                        mVar.getClass();
                        mVar.C(i10, Float.floatToRawIntBits(fFloatValue));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (s(i10, i2, obj)) {
                        mVar.O(i10, D(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (s(i10, i2, obj)) {
                        mVar.O(i10, D(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (s(i10, i2, obj)) {
                        mVar.G(i10, C(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (s(i10, i2, obj)) {
                        mVar.E(i10, D(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (s(i10, i2, obj)) {
                        mVar.C(i10, C(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (s(i10, i2, obj)) {
                        mVar.z(i10, ((Boolean) s1.f949c.i(iO & 1048575, obj)).booleanValue());
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (s(i10, i2, obj)) {
                        R(i10, s1.f949c.i(iO & 1048575, obj), i0Var);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (s(i10, i2, obj)) {
                        mVar.I(i10, (a) s1.f949c.i(iO & 1048575, obj), n(i2));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (s(i10, i2, obj)) {
                        i0Var.a(i10, (g) s1.f949c.i(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (s(i10, i2, obj)) {
                        mVar.M(i10, C(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (s(i10, i2, obj)) {
                        mVar.G(i10, C(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (s(i10, i2, obj)) {
                        mVar.C(i10, C(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (s(i10, i2, obj)) {
                        mVar.E(i10, D(iO & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (s(i10, i2, obj)) {
                        int iC = C(iO & 1048575, obj);
                        mVar.M(i10, (iC >> 31) ^ (iC << 1));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (s(i10, i2, obj)) {
                        long jD = D(iO & 1048575, obj);
                        mVar.O(i10, (jD >> 63) ^ (jD << 1));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (s(i10, i2, obj)) {
                        i0Var.b(i10, s1.f949c.i(iO & 1048575, obj), n(i2));
                        break;
                    } else {
                        break;
                    }
            }
        }
        this.f933m.getClass();
        ((w) obj).unknownFields.d(i0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.z0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(androidx.datastore.preferences.protobuf.w r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.f(androidx.datastore.preferences.protobuf.w):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // androidx.datastore.preferences.protobuf.z0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(androidx.datastore.preferences.protobuf.w r12, androidx.datastore.preferences.protobuf.w r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.g(androidx.datastore.preferences.protobuf.w, androidx.datastore.preferences.protobuf.w):boolean");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // androidx.datastore.preferences.protobuf.z0
    public final void h(java.lang.Object r19, androidx.datastore.preferences.protobuf.k r20, androidx.datastore.preferences.protobuf.o r21) {
        /*
            Method dump skipped, instructions count: 1852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.h(java.lang.Object, androidx.datastore.preferences.protobuf.k, androidx.datastore.preferences.protobuf.o):void");
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public final int i(w wVar) {
        return this.f927g ? p(wVar) : o(wVar);
    }

    public final boolean j(w wVar, w wVar2, int i2) {
        return q(i2, wVar) == q(i2, wVar2);
    }

    public final void k(int i2, Object obj, Object obj2) {
        int i10 = this.f921a[i2];
        if (s1.f949c.i(O(i2) & 1048575, obj) == null) {
            return;
        }
        l(i2);
    }

    public final void l(int i2) {
        if (this.f922b[((i2 / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    public final Object m(int i2) {
        return this.f922b[(i2 / 3) * 2];
    }

    public final z0 n(int i2) {
        int i10 = (i2 / 3) * 2;
        Object[] objArr = this.f922b;
        z0 z0Var = (z0) objArr[i10];
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0VarA = w0.f962c.a((Class) objArr[i10 + 1]);
        objArr[i10] = z0VarA;
        return z0VarA;
    }

    public final int o(w wVar) {
        int i2;
        int iS;
        int iU;
        int iS2;
        int iQ;
        int iO;
        int iS3;
        int iR;
        int iC;
        int iP;
        Unsafe unsafe = f920p;
        int i10 = 1048575;
        int i11 = 1048575;
        int i12 = 0;
        int iB = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f921a;
            if (i12 >= iArr.length) {
                this.f933m.getClass();
                return wVar.unknownFields.b() + iB;
            }
            int iO2 = O(i12);
            int i14 = iArr[i12];
            int iN = N(iO2);
            if (iN <= 17) {
                int i15 = iArr[i12 + 2];
                int i16 = i15 & i10;
                i2 = 1 << (i15 >>> 20);
                if (i16 != i11) {
                    i13 = unsafe.getInt(wVar, i16);
                    i11 = i16;
                }
            } else {
                i2 = 0;
            }
            long j2 = iO2 & i10;
            switch (iN) {
                case 0:
                    if ((i13 & i2) != 0) {
                        iB = a1.a.b(i14, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i13 & i2) != 0) {
                        iB = a1.a.b(i14, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i2 & i13) != 0) {
                        long j4 = unsafe.getLong(wVar, j2);
                        iS = m.s(i14);
                        iU = m.u(j4);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i2 & i13) != 0) {
                        long j10 = unsafe.getLong(wVar, j2);
                        iS = m.s(i14);
                        iU = m.u(j10);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i2 & i13) != 0) {
                        int i17 = unsafe.getInt(wVar, j2);
                        iS2 = m.s(i14);
                        iQ = m.q(i17);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i13 & i2) != 0) {
                        iO = m.o(i14);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i13 & i2) != 0) {
                        iO = m.n(i14);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i13 & i2) != 0) {
                        iB = a1.a.b(i14, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i2 & i13) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(wVar, j2);
                        if (object instanceof g) {
                            int iS4 = m.s(i14);
                            int size = ((g) object).size();
                            iC = a1.a.c(size, size, iS4, iB);
                            iB = iC;
                            break;
                        } else {
                            iS3 = m.s(i14);
                            iR = m.r((String) object);
                            iC = iR + iS3 + iB;
                            iB = iC;
                        }
                    }
                case 9:
                    if ((i2 & i13) != 0) {
                        Object object2 = unsafe.getObject(wVar, j2);
                        z0 z0VarN = n(i12);
                        Class cls = a1.f795a;
                        int iS5 = m.s(i14);
                        int iA = ((a) object2).a(z0VarN);
                        iB = a1.a.c(iA, iA, iS5, iB);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i2 & i13) != 0) {
                        iO = m.l(i14, (g) unsafe.getObject(wVar, j2));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i2 & i13) != 0) {
                        int i18 = unsafe.getInt(wVar, j2);
                        iS2 = m.s(i14);
                        iQ = m.t(i18);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i2 & i13) != 0) {
                        int i19 = unsafe.getInt(wVar, j2);
                        iS2 = m.s(i14);
                        iQ = m.q(i19);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i13 & i2) != 0) {
                        iB = a1.a.b(i14, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if ((i13 & i2) != 0) {
                        iB = a1.a.b(i14, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if ((i2 & i13) != 0) {
                        int i20 = unsafe.getInt(wVar, j2);
                        iS2 = m.s(i14);
                        iQ = m.t((i20 >> 31) ^ (i20 << 1));
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i2 & i13) != 0) {
                        long j11 = unsafe.getLong(wVar, j2);
                        iS = m.s(i14);
                        iU = m.u((j11 >> 63) ^ (j11 << 1));
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i2 & i13) != 0) {
                        iO = m.p(i14, (a) unsafe.getObject(wVar, j2), n(i12));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    iO = a1.f(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    iO = a1.d(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 20:
                    iO = a1.j(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    iO = a1.t(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    iO = a1.h(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iO = a1.f(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 24:
                    iO = a1.d(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 25:
                    List list = (List) unsafe.getObject(wVar, j2);
                    Class cls2 = a1.f795a;
                    int size2 = list.size();
                    iB += size2 == 0 ? 0 : (m.s(i14) + 1) * size2;
                    break;
                case 26:
                    iO = a1.q(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iO = a1.l(i14, (List) unsafe.getObject(wVar, j2), n(i12));
                    iB += iO;
                    break;
                case 28:
                    iO = a1.a(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 29:
                    iO = a1.r(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 30:
                    iO = a1.b(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    iO = a1.d(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 32:
                    iO = a1.f(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 33:
                    iO = a1.m(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case 34:
                    iO = a1.o(i14, (List) unsafe.getObject(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    int iG = a1.g((List) unsafe.getObject(wVar, j2));
                    if (iG > 0) {
                        iB = a1.a.c(iG, m.s(i14), iG, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    int iE = a1.e((List) unsafe.getObject(wVar, j2));
                    if (iE > 0) {
                        iB = a1.a.c(iE, m.s(i14), iE, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    int iK = a1.k((List) unsafe.getObject(wVar, j2));
                    if (iK > 0) {
                        iB = a1.a.c(iK, m.s(i14), iK, iB);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iU2 = a1.u((List) unsafe.getObject(wVar, j2));
                    if (iU2 > 0) {
                        iB = a1.a.c(iU2, m.s(i14), iU2, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    int i21 = a1.i((List) unsafe.getObject(wVar, j2));
                    if (i21 > 0) {
                        iB = a1.a.c(i21, m.s(i14), i21, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    int iG2 = a1.g((List) unsafe.getObject(wVar, j2));
                    if (iG2 > 0) {
                        iB = a1.a.c(iG2, m.s(i14), iG2, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    int iE2 = a1.e((List) unsafe.getObject(wVar, j2));
                    if (iE2 > 0) {
                        iB = a1.a.c(iE2, m.s(i14), iE2, iB);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list2 = (List) unsafe.getObject(wVar, j2);
                    Class cls3 = a1.f795a;
                    int size3 = list2.size();
                    if (size3 > 0) {
                        iB = a1.a.c(size3, m.s(i14), size3, iB);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int iS6 = a1.s((List) unsafe.getObject(wVar, j2));
                    if (iS6 > 0) {
                        iB = a1.a.c(iS6, m.s(i14), iS6, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    int iC2 = a1.c((List) unsafe.getObject(wVar, j2));
                    if (iC2 > 0) {
                        iB = a1.a.c(iC2, m.s(i14), iC2, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    int iE3 = a1.e((List) unsafe.getObject(wVar, j2));
                    if (iE3 > 0) {
                        iB = a1.a.c(iE3, m.s(i14), iE3, iB);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int iG3 = a1.g((List) unsafe.getObject(wVar, j2));
                    if (iG3 > 0) {
                        iB = a1.a.c(iG3, m.s(i14), iG3, iB);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int iN2 = a1.n((List) unsafe.getObject(wVar, j2));
                    if (iN2 > 0) {
                        iB = a1.a.c(iN2, m.s(i14), iN2, iB);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int iP2 = a1.p((List) unsafe.getObject(wVar, j2));
                    if (iP2 > 0) {
                        iB = a1.a.c(iP2, m.s(i14), iP2, iB);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list3 = (List) unsafe.getObject(wVar, j2);
                    z0 z0VarN2 = n(i12);
                    Class cls4 = a1.f795a;
                    int size4 = list3.size();
                    if (size4 == 0) {
                        iP = 0;
                    } else {
                        iP = 0;
                        for (int i22 = 0; i22 < size4; i22++) {
                            iP += m.p(i14, (a) list3.get(i22), z0VarN2);
                        }
                    }
                    iB += iP;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(wVar, j2);
                    Object objM = m(i12);
                    this.f934n.getClass();
                    iO = m0.a(i14, object3, objM);
                    iB += iO;
                    break;
                case 51:
                    if (s(i14, i12, wVar)) {
                        iB = a1.a.b(i14, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (s(i14, i12, wVar)) {
                        iB = a1.a.b(i14, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (s(i14, i12, wVar)) {
                        long jD = D(j2, wVar);
                        iS = m.s(i14);
                        iU = m.u(jD);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (s(i14, i12, wVar)) {
                        long jD2 = D(j2, wVar);
                        iS = m.s(i14);
                        iU = m.u(jD2);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (s(i14, i12, wVar)) {
                        int iC3 = C(j2, wVar);
                        iS2 = m.s(i14);
                        iQ = m.q(iC3);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (s(i14, i12, wVar)) {
                        iO = m.o(i14);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (s(i14, i12, wVar)) {
                        iO = m.n(i14);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (s(i14, i12, wVar)) {
                        iB = a1.a.b(i14, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!s(i14, i12, wVar)) {
                        break;
                    } else {
                        Object object4 = unsafe.getObject(wVar, j2);
                        if (object4 instanceof g) {
                            int iS7 = m.s(i14);
                            int size5 = ((g) object4).size();
                            iC = a1.a.c(size5, size5, iS7, iB);
                            iB = iC;
                            break;
                        } else {
                            iS3 = m.s(i14);
                            iR = m.r((String) object4);
                            iC = iR + iS3 + iB;
                            iB = iC;
                        }
                    }
                case 60:
                    if (s(i14, i12, wVar)) {
                        Object object5 = unsafe.getObject(wVar, j2);
                        z0 z0VarN3 = n(i12);
                        Class cls5 = a1.f795a;
                        int iS8 = m.s(i14);
                        int iA2 = ((a) object5).a(z0VarN3);
                        iB = a1.a.c(iA2, iA2, iS8, iB);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (s(i14, i12, wVar)) {
                        iO = m.l(i14, (g) unsafe.getObject(wVar, j2));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (s(i14, i12, wVar)) {
                        int iC4 = C(j2, wVar);
                        iS2 = m.s(i14);
                        iQ = m.t(iC4);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (s(i14, i12, wVar)) {
                        int iC5 = C(j2, wVar);
                        iS2 = m.s(i14);
                        iQ = m.q(iC5);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (s(i14, i12, wVar)) {
                        iB = a1.a.b(i14, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (s(i14, i12, wVar)) {
                        iB = a1.a.b(i14, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (s(i14, i12, wVar)) {
                        int iC6 = C(j2, wVar);
                        iS2 = m.s(i14);
                        iQ = m.t((iC6 >> 31) ^ (iC6 << 1));
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (s(i14, i12, wVar)) {
                        long jD3 = D(j2, wVar);
                        iS = m.s(i14);
                        iU = m.u((jD3 >> 63) ^ (jD3 << 1));
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (s(i14, i12, wVar)) {
                        iO = m.p(i14, (a) unsafe.getObject(wVar, j2), n(i12));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
            }
            i12 += 3;
            i10 = 1048575;
        }
    }

    public final int p(w wVar) {
        int iS;
        int iU;
        int iS2;
        int iQ;
        int iO;
        int iS3;
        int iR;
        int iS4;
        int iU2;
        int iP;
        Unsafe unsafe = f920p;
        int i2 = 0;
        int iB = 0;
        while (true) {
            int[] iArr = this.f921a;
            if (i2 >= iArr.length) {
                this.f933m.getClass();
                return wVar.unknownFields.b() + iB;
            }
            int iO2 = O(i2);
            int iN = N(iO2);
            int i10 = iArr[i2];
            long j2 = iO2 & 1048575;
            if (iN >= s.f942g.f946f && iN <= s.f943h.f946f) {
                int i11 = iArr[i2 + 2];
            }
            switch (iN) {
                case 0:
                    if (q(i2, wVar)) {
                        iB = a1.a.b(i10, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (q(i2, wVar)) {
                        iB = a1.a.b(i10, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (q(i2, wVar)) {
                        long jH = s1.f949c.h(j2, wVar);
                        iS = m.s(i10);
                        iU = m.u(jH);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (q(i2, wVar)) {
                        long jH2 = s1.f949c.h(j2, wVar);
                        iS = m.s(i10);
                        iU = m.u(jH2);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (q(i2, wVar)) {
                        int iG = s1.f949c.g(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.q(iG);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (q(i2, wVar)) {
                        iO = m.o(i10);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (q(i2, wVar)) {
                        iO = m.n(i10);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (q(i2, wVar)) {
                        iB = a1.a.b(i10, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (q(i2, wVar)) {
                        Object objI = s1.f949c.i(j2, wVar);
                        if (objI instanceof g) {
                            int iS5 = m.s(i10);
                            int size = ((g) objI).size();
                            iB = a1.a.c(size, size, iS5, iB);
                            break;
                        } else {
                            iS3 = m.s(i10);
                            iR = m.r((String) objI);
                            iB = iR + iS3 + iB;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (q(i2, wVar)) {
                        Object objI2 = s1.f949c.i(j2, wVar);
                        z0 z0VarN = n(i2);
                        Class cls = a1.f795a;
                        int iS6 = m.s(i10);
                        int iA = ((a) objI2).a(z0VarN);
                        iB = a1.a.c(iA, iA, iS6, iB);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (q(i2, wVar)) {
                        iO = m.l(i10, (g) s1.f949c.i(j2, wVar));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (q(i2, wVar)) {
                        int iG2 = s1.f949c.g(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.t(iG2);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (q(i2, wVar)) {
                        int iG3 = s1.f949c.g(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.q(iG3);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (q(i2, wVar)) {
                        iB = a1.a.b(i10, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (q(i2, wVar)) {
                        iB = a1.a.b(i10, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (q(i2, wVar)) {
                        int iG4 = s1.f949c.g(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.t((iG4 >> 31) ^ (iG4 << 1));
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (q(i2, wVar)) {
                        long jH3 = s1.f949c.h(j2, wVar);
                        iS4 = m.s(i10);
                        iU2 = m.u((jH3 >> 63) ^ (jH3 << 1));
                        iO = iU2 + iS4;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (q(i2, wVar)) {
                        iO = m.p(i10, (a) s1.f949c.i(j2, wVar), n(i2));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    iO = a1.f(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    iO = a1.d(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 20:
                    iO = a1.j(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    iO = a1.t(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    iO = a1.h(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iO = a1.f(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 24:
                    iO = a1.d(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 25:
                    List listT = t(wVar, j2);
                    Class cls2 = a1.f795a;
                    int size2 = listT.size();
                    iB += size2 == 0 ? 0 : (m.s(i10) + 1) * size2;
                    break;
                case 26:
                    iO = a1.q(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iO = a1.l(i10, t(wVar, j2), n(i2));
                    iB += iO;
                    break;
                case 28:
                    iO = a1.a(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 29:
                    iO = a1.r(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 30:
                    iO = a1.b(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    iO = a1.d(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 32:
                    iO = a1.f(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 33:
                    iO = a1.m(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case 34:
                    iO = a1.o(i10, t(wVar, j2));
                    iB += iO;
                    break;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    int iG5 = a1.g((List) unsafe.getObject(wVar, j2));
                    if (iG5 > 0) {
                        iB = a1.a.c(iG5, m.s(i10), iG5, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    int iE = a1.e((List) unsafe.getObject(wVar, j2));
                    if (iE > 0) {
                        iB = a1.a.c(iE, m.s(i10), iE, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    int iK = a1.k((List) unsafe.getObject(wVar, j2));
                    if (iK > 0) {
                        iB = a1.a.c(iK, m.s(i10), iK, iB);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iU3 = a1.u((List) unsafe.getObject(wVar, j2));
                    if (iU3 > 0) {
                        iB = a1.a.c(iU3, m.s(i10), iU3, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    int i12 = a1.i((List) unsafe.getObject(wVar, j2));
                    if (i12 > 0) {
                        iB = a1.a.c(i12, m.s(i10), i12, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    int iG6 = a1.g((List) unsafe.getObject(wVar, j2));
                    if (iG6 > 0) {
                        iB = a1.a.c(iG6, m.s(i10), iG6, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    int iE2 = a1.e((List) unsafe.getObject(wVar, j2));
                    if (iE2 > 0) {
                        iB = a1.a.c(iE2, m.s(i10), iE2, iB);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(wVar, j2);
                    Class cls3 = a1.f795a;
                    int size3 = list.size();
                    if (size3 > 0) {
                        iB = a1.a.c(size3, m.s(i10), size3, iB);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int iS7 = a1.s((List) unsafe.getObject(wVar, j2));
                    if (iS7 > 0) {
                        iB = a1.a.c(iS7, m.s(i10), iS7, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    int iC = a1.c((List) unsafe.getObject(wVar, j2));
                    if (iC > 0) {
                        iB = a1.a.c(iC, m.s(i10), iC, iB);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    int iE3 = a1.e((List) unsafe.getObject(wVar, j2));
                    if (iE3 > 0) {
                        iB = a1.a.c(iE3, m.s(i10), iE3, iB);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int iG7 = a1.g((List) unsafe.getObject(wVar, j2));
                    if (iG7 > 0) {
                        iB = a1.a.c(iG7, m.s(i10), iG7, iB);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int iN2 = a1.n((List) unsafe.getObject(wVar, j2));
                    if (iN2 > 0) {
                        iB = a1.a.c(iN2, m.s(i10), iN2, iB);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int iP2 = a1.p((List) unsafe.getObject(wVar, j2));
                    if (iP2 > 0) {
                        iB = a1.a.c(iP2, m.s(i10), iP2, iB);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List listT2 = t(wVar, j2);
                    z0 z0VarN2 = n(i2);
                    Class cls4 = a1.f795a;
                    int size4 = listT2.size();
                    if (size4 == 0) {
                        iP = 0;
                    } else {
                        iP = 0;
                        for (int i13 = 0; i13 < size4; i13++) {
                            iP += m.p(i10, (a) listT2.get(i13), z0VarN2);
                        }
                    }
                    iB += iP;
                    break;
                case 50:
                    Object objI3 = s1.f949c.i(j2, wVar);
                    Object objM = m(i2);
                    this.f934n.getClass();
                    iO = m0.a(i10, objI3, objM);
                    iB += iO;
                    break;
                case 51:
                    if (s(i10, i2, wVar)) {
                        iB = a1.a.b(i10, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (s(i10, i2, wVar)) {
                        iB = a1.a.b(i10, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (s(i10, i2, wVar)) {
                        long jD = D(j2, wVar);
                        iS = m.s(i10);
                        iU = m.u(jD);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (s(i10, i2, wVar)) {
                        long jD2 = D(j2, wVar);
                        iS = m.s(i10);
                        iU = m.u(jD2);
                        iO = iU + iS;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (s(i10, i2, wVar)) {
                        int iC2 = C(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.q(iC2);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (s(i10, i2, wVar)) {
                        iO = m.o(i10);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (s(i10, i2, wVar)) {
                        iO = m.n(i10);
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (s(i10, i2, wVar)) {
                        iB = a1.a.b(i10, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (s(i10, i2, wVar)) {
                        Object objI4 = s1.f949c.i(j2, wVar);
                        if (objI4 instanceof g) {
                            int iS8 = m.s(i10);
                            int size5 = ((g) objI4).size();
                            iB = a1.a.c(size5, size5, iS8, iB);
                            break;
                        } else {
                            iS3 = m.s(i10);
                            iR = m.r((String) objI4);
                            iB = iR + iS3 + iB;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (s(i10, i2, wVar)) {
                        Object objI5 = s1.f949c.i(j2, wVar);
                        z0 z0VarN3 = n(i2);
                        Class cls5 = a1.f795a;
                        int iS9 = m.s(i10);
                        int iA2 = ((a) objI5).a(z0VarN3);
                        iB = a1.a.c(iA2, iA2, iS9, iB);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (s(i10, i2, wVar)) {
                        iO = m.l(i10, (g) s1.f949c.i(j2, wVar));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (s(i10, i2, wVar)) {
                        int iC3 = C(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.t(iC3);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (s(i10, i2, wVar)) {
                        int iC4 = C(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.q(iC4);
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (s(i10, i2, wVar)) {
                        iB = a1.a.b(i10, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (s(i10, i2, wVar)) {
                        iB = a1.a.b(i10, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (s(i10, i2, wVar)) {
                        int iC5 = C(j2, wVar);
                        iS2 = m.s(i10);
                        iQ = m.t((iC5 >> 31) ^ (iC5 << 1));
                        iO = iQ + iS2;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (s(i10, i2, wVar)) {
                        long jD3 = D(j2, wVar);
                        iS4 = m.s(i10);
                        iU2 = m.u((jD3 >> 63) ^ (jD3 << 1));
                        iO = iU2 + iS4;
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (s(i10, i2, wVar)) {
                        iO = m.p(i10, (a) s1.f949c.i(j2, wVar), n(i2));
                        iB += iO;
                        break;
                    } else {
                        break;
                    }
            }
            i2 += 3;
        }
    }

    public final boolean q(int i2, Object obj) {
        int i10 = this.f921a[i2 + 2];
        long j2 = i10 & 1048575;
        if (j2 == 1048575) {
            int iO = O(i2);
            long j4 = iO & 1048575;
            switch (N(iO)) {
                case 0:
                    if (Double.doubleToRawLongBits(s1.f949c.e(j4, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(s1.f949c.f(j4, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (s1.f949c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (s1.f949c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (s1.f949c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (s1.f949c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (s1.f949c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return s1.f949c.c(j4, obj);
                case 8:
                    Object objI = s1.f949c.i(j4, obj);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof g) {
                        return !g.f850h.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (s1.f949c.i(j4, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !g.f850h.equals(s1.f949c.i(j4, obj));
                case 11:
                    if (s1.f949c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (s1.f949c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (s1.f949c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (s1.f949c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (s1.f949c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (s1.f949c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (s1.f949c.i(j4, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i10 >>> 20)) & s1.f949c.g(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean s(int i2, int i10, Object obj) {
        return s1.f949c.g((long) (this.f921a[i10 + 2] & 1048575), obj) == i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
    
        r9.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009e, code lost:
    
        r10.j(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(java.lang.Object r8, int r9, java.lang.Object r10, androidx.datastore.preferences.protobuf.o r11, androidx.datastore.preferences.protobuf.k r12) throws androidx.datastore.preferences.protobuf.z, com.google.crypto.tink.shaded.protobuf.a0, com.google.protobuf.q2 {
        /*
            r7 = this;
            int r9 = r7.O(r9)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r0
            long r0 = (long) r9
            androidx.datastore.preferences.protobuf.r1 r9 = androidx.datastore.preferences.protobuf.s1.f949c
            java.lang.Object r9 = r9.i(r0, r8)
            androidx.datastore.preferences.protobuf.m0 r7 = r7.f934n
            if (r9 != 0) goto L20
            r7.getClass()
            androidx.datastore.preferences.protobuf.l0 r9 = androidx.datastore.preferences.protobuf.l0.f898g
            androidx.datastore.preferences.protobuf.l0 r9 = r9.b()
            androidx.datastore.preferences.protobuf.s1.p(r0, r8, r9)
            goto L37
        L20:
            r7.getClass()
            r2 = r9
            androidx.datastore.preferences.protobuf.l0 r2 = (androidx.datastore.preferences.protobuf.l0) r2
            boolean r2 = r2.f899f
            if (r2 != 0) goto L37
            androidx.datastore.preferences.protobuf.l0 r2 = androidx.datastore.preferences.protobuf.l0.f898g
            androidx.datastore.preferences.protobuf.l0 r2 = r2.b()
            androidx.datastore.preferences.protobuf.m0.b(r2, r9)
            androidx.datastore.preferences.protobuf.s1.p(r0, r8, r2)
            r9 = r2
        L37:
            r7.getClass()
            androidx.datastore.preferences.protobuf.l0 r9 = (androidx.datastore.preferences.protobuf.l0) r9
            androidx.datastore.preferences.protobuf.k0 r10 = (androidx.datastore.preferences.protobuf.k0) r10
            androidx.datastore.preferences.protobuf.j0 r7 = r10.f897a
            r8 = 2
            r12.V(r8)
            java.lang.Object r10 = r12.f896e
            androidx.datastore.preferences.protobuf.j r10 = (androidx.datastore.preferences.protobuf.j) r10
            int r0 = r10.D()
            int r0 = r10.l(r0)
            java.lang.Object r1 = r7.f885c
            java.lang.String r2 = ""
            r3 = r1
        L55:
            int r4 = r12.a()     // Catch: java.lang.Throwable -> L79
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L9b
            boolean r5 = r10.g()     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L65
            goto L9b
        L65:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L86
            if (r4 == r8) goto L7b
            boolean r4 = r12.W()     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            if (r4 == 0) goto L73
            goto L55
        L73:
            androidx.datastore.preferences.protobuf.a0 r4 = new androidx.datastore.preferences.protobuf.a0     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            throw r4     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
        L79:
            r7 = move-exception
            goto La2
        L7b:
            androidx.datastore.preferences.protobuf.a2 r4 = r7.f884b     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            java.lang.Object r3 = r12.u(r4, r5, r11)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            goto L55
        L86:
            androidx.datastore.preferences.protobuf.a2 r4 = r7.f883a     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            r5 = 0
            java.lang.Object r2 = r12.u(r4, r5, r5)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.z -> L8e
            goto L55
        L8e:
            boolean r4 = r12.W()     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L95
            goto L55
        L95:
            androidx.datastore.preferences.protobuf.a0 r7 = new androidx.datastore.preferences.protobuf.a0     // Catch: java.lang.Throwable -> L79
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L79
            throw r7     // Catch: java.lang.Throwable -> L79
        L9b:
            r9.put(r2, r3)     // Catch: java.lang.Throwable -> L79
            r10.j(r0)
            return
        La2:
            r10.j(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.u(java.lang.Object, int, java.lang.Object, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.k):void");
    }

    public final void v(int i2, Object obj, Object obj2) {
        if (q(i2, obj2)) {
            long jO = O(i2) & 1048575;
            Unsafe unsafe = f920p;
            Object object = unsafe.getObject(obj2, jO);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f921a[i2] + " is present but null: " + obj2);
            }
            z0 z0VarN = n(i2);
            if (!q(i2, obj)) {
                if (r(object)) {
                    w wVarD = z0VarN.d();
                    z0VarN.a(wVarD, object);
                    unsafe.putObject(obj, jO, wVarD);
                } else {
                    unsafe.putObject(obj, jO, object);
                }
                J(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jO);
            if (!r(object2)) {
                w wVarD2 = z0VarN.d();
                z0VarN.a(wVarD2, object2);
                unsafe.putObject(obj, jO, wVarD2);
                object2 = wVarD2;
            }
            z0VarN.a(object2, object);
        }
    }

    public final void w(int i2, Object obj, Object obj2) {
        int[] iArr = this.f921a;
        int i10 = iArr[i2];
        if (s(i10, i2, obj2)) {
            long jO = O(i2) & 1048575;
            Unsafe unsafe = f920p;
            Object object = unsafe.getObject(obj2, jO);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i2] + " is present but null: " + obj2);
            }
            z0 z0VarN = n(i2);
            if (!s(i10, i2, obj)) {
                if (r(object)) {
                    w wVarD = z0VarN.d();
                    z0VarN.a(wVarD, object);
                    unsafe.putObject(obj, jO, wVarD);
                } else {
                    unsafe.putObject(obj, jO, object);
                }
                K(i10, i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jO);
            if (!r(object2)) {
                w wVarD2 = z0VarN.d();
                z0VarN.a(wVarD2, object2);
                unsafe.putObject(obj, jO, wVarD2);
                object2 = wVarD2;
            }
            z0VarN.a(object2, object);
        }
    }

    public final Object x(int i2, Object obj) {
        z0 z0VarN = n(i2);
        long jO = O(i2) & 1048575;
        if (!q(i2, obj)) {
            return z0VarN.d();
        }
        Object object = f920p.getObject(obj, jO);
        if (r(object)) {
            return object;
        }
        w wVarD = z0VarN.d();
        if (object != null) {
            z0VarN.a(wVarD, object);
        }
        return wVarD;
    }

    public final Object y(int i2, int i10, Object obj) {
        z0 z0VarN = n(i10);
        if (!s(i2, i10, obj)) {
            return z0VarN.d();
        }
        Object object = f920p.getObject(obj, O(i10) & 1048575);
        if (r(object)) {
            return object;
        }
        w wVarD = z0VarN.d();
        if (object != null) {
            z0VarN.a(wVarD, object);
        }
        return wVarD;
    }
}
