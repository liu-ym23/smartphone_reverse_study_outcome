package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.params.SkeinParameters;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m0 implements u0 {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f515n = new int[0];

    /* renamed from: o, reason: collision with root package name */
    public static final Unsafe f516o = h1.i();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f517a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f518b;

    /* renamed from: c, reason: collision with root package name */
    public final int f519c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final a f520e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f521f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f522g;

    /* renamed from: h, reason: collision with root package name */
    public final int f523h;

    /* renamed from: i, reason: collision with root package name */
    public final int f524i;

    /* renamed from: j, reason: collision with root package name */
    public final o0 f525j;

    /* renamed from: k, reason: collision with root package name */
    public final b0 f526k;

    /* renamed from: l, reason: collision with root package name */
    public final c1 f527l;

    /* renamed from: m, reason: collision with root package name */
    public final i0 f528m;

    public m0(int[] iArr, Object[] objArr, int i8, int i9, a aVar, int[] iArr2, int i10, int i11, o0 o0Var, b0 b0Var, c1 c1Var, o oVar, i0 i0Var) {
        this.f517a = iArr;
        this.f518b = objArr;
        this.f519c = i8;
        this.d = i9;
        this.f521f = aVar instanceof v;
        this.f522g = iArr2;
        this.f523h = i10;
        this.f524i = i11;
        this.f525j = o0Var;
        this.f526k = b0Var;
        this.f527l = c1Var;
        this.f520e = aVar;
        this.f528m = i0Var;
    }

    public static Field F(Class cls, String str) {
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

    public static int K(int i8) {
        return (i8 & 267386880) >>> 20;
    }

    public static boolean p(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof v) {
            return ((v) obj).g();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.m0 w(androidx.datastore.preferences.protobuf.t0 r34, androidx.datastore.preferences.protobuf.o0 r35, androidx.datastore.preferences.protobuf.b0 r36, androidx.datastore.preferences.protobuf.c1 r37, androidx.datastore.preferences.protobuf.o r38, androidx.datastore.preferences.protobuf.i0 r39) {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.w(androidx.datastore.preferences.protobuf.t0, androidx.datastore.preferences.protobuf.o0, androidx.datastore.preferences.protobuf.b0, androidx.datastore.preferences.protobuf.c1, androidx.datastore.preferences.protobuf.o, androidx.datastore.preferences.protobuf.i0):androidx.datastore.preferences.protobuf.m0");
    }

    public static long x(int i8) {
        return i8 & 1048575;
    }

    public static int y(Object obj, long j4) {
        return ((Integer) h1.f488c.h(obj, j4)).intValue();
    }

    public static long z(Object obj, long j4) {
        return ((Long) h1.f488c.h(obj, j4)).longValue();
    }

    public final int A(int i8) {
        if (i8 >= this.f519c && i8 <= this.d) {
            int[] iArr = this.f517a;
            int length = (iArr.length / 3) - 1;
            int i9 = 0;
            while (i9 <= length) {
                int i10 = (length + i9) >>> 1;
                int i11 = i10 * 3;
                int i12 = iArr[i11];
                if (i8 == i12) {
                    return i11;
                }
                if (i8 < i12) {
                    length = i10 - 1;
                } else {
                    i9 = i10 + 1;
                }
            }
        }
        return -1;
    }

    public final void B(Object obj, long j4, j jVar, u0 u0Var, n nVar) throws y {
        int iC;
        this.f526k.getClass();
        w wVarA = b0.a(obj, j4);
        a2.e eVar = (a2.e) jVar.f503e;
        int i8 = jVar.f501b;
        if ((i8 & 7) != 3) {
            throw z.b();
        }
        do {
            v vVarD = u0Var.d();
            jVar.b(vVarD, u0Var, nVar);
            u0Var.b(vVarD);
            ((s0) wVarA).add(vVarD);
            if (eVar.g() || jVar.d != 0) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == i8);
        jVar.d = iC;
    }

    public final void C(Object obj, int i8, j jVar, u0 u0Var, n nVar) throws z {
        int iC;
        this.f526k.getClass();
        w wVarA = b0.a(obj, i8 & 1048575);
        a2.e eVar = (a2.e) jVar.f503e;
        int i9 = jVar.f501b;
        if ((i9 & 7) != 2) {
            throw z.b();
        }
        do {
            v vVarD = u0Var.d();
            jVar.d(vVarD, u0Var, nVar);
            u0Var.b(vVarD);
            ((s0) wVarA).add(vVarD);
            if (eVar.g() || jVar.d != 0) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == i9);
        jVar.d = iC;
    }

    public final void D(int i8, j jVar, Object obj) throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        a2.e eVar = (a2.e) jVar.f503e;
        if ((536870912 & i8) != 0) {
            jVar.P(2);
            h1.o(i8 & 1048575, obj, eVar.B());
        } else if (!this.f521f) {
            h1.o(i8 & 1048575, obj, jVar.h());
        } else {
            jVar.P(2);
            h1.o(i8 & 1048575, obj, eVar.A());
        }
    }

    public final void E(int i8, j jVar, Object obj) throws y, com.google.crypto.tink.shaded.protobuf.b0 {
        int i9 = 536870912 & i8;
        b0 b0Var = this.f526k;
        if (i9 != 0) {
            b0Var.getClass();
            jVar.I(b0.a(obj, i8 & 1048575), true);
        } else {
            b0Var.getClass();
            jVar.I(b0.a(obj, i8 & 1048575), false);
        }
    }

    public final void G(int i8, Object obj) {
        int i9 = this.f517a[i8 + 2];
        long j4 = 1048575 & i9;
        if (j4 == 1048575) {
            return;
        }
        h1.m((1 << (i9 >>> 20)) | h1.f488c.f(obj, j4), j4, obj);
    }

    public final void H(Object obj, int i8, int i9) {
        h1.m(i8, this.f517a[i9 + 2] & 1048575, obj);
    }

    public final void I(Object obj, int i8, a aVar) {
        f516o.putObject(obj, L(i8) & 1048575, aVar);
        G(i8, obj);
    }

    public final void J(Object obj, int i8, int i9, a aVar) {
        f516o.putObject(obj, L(i9) & 1048575, aVar);
        H(obj, i8, i9);
    }

    public final int L(int i8) {
        return this.f517a[i8 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void M(Object obj, e0 e0Var) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z;
        m0 m0Var = this;
        int[] iArr = m0Var.f517a;
        int length = iArr.length;
        Unsafe unsafe = f516o;
        int i12 = 1048575;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i14 < length) {
            int iL = m0Var.L(i14);
            int i16 = iArr[i14];
            int iK = K(iL);
            if (iK <= 17) {
                int i17 = iArr[i14 + 2];
                int i18 = i17 & i12;
                if (i18 != i13) {
                    i15 = i18 == i12 ? 0 : unsafe.getInt(obj, i18);
                    i13 = i18;
                }
                i8 = iL;
                i9 = 1 << (i17 >>> 20);
            } else {
                i8 = iL;
                i9 = 0;
            }
            long j4 = i8 & i12;
            switch (iK) {
                case 0:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        double d = h1.f488c.d(obj, j4);
                        l lVar = (l) e0Var.f466a;
                        lVar.getClass();
                        lVar.C0(i16, Double.doubleToRawLongBits(d));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        float fE = h1.f488c.e(obj, j4);
                        l lVar2 = (l) e0Var.f466a;
                        lVar2.getClass();
                        lVar2.A0(i16, Float.floatToRawIntBits(fE));
                    }
                    m0Var = this;
                    break;
                case 2:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).M0(i16, unsafe.getLong(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 3:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).M0(i16, unsafe.getLong(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 4:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).E0(i16, unsafe.getInt(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 5:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).C0(i16, unsafe.getLong(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 6:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).A0(i16, unsafe.getInt(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 7:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).x0(i16, h1.f488c.c(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 8:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        Object object = unsafe.getObject(obj, j4);
                        if (object instanceof String) {
                            ((l) e0Var.f466a).H0(i16, (String) object);
                        } else {
                            ((l) e0Var.f466a).y0(i16, (g) object);
                        }
                    }
                    m0Var = this;
                    break;
                case 9:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).G0(i16, (a) unsafe.getObject(obj, j4), m0Var.m(i14));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).y0(i16, (g) unsafe.getObject(obj, j4));
                    }
                    m0Var = this;
                    break;
                case BERTags.EMBEDDED_PDV /* 11 */:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).K0(i16, unsafe.getInt(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 12:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).E0(i16, unsafe.getInt(obj, j4));
                    }
                    m0Var = this;
                    break;
                case BERTags.RELATIVE_OID /* 13 */:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).A0(i16, unsafe.getInt(obj, j4));
                    }
                    m0Var = this;
                    break;
                case BERTags.TIME /* 14 */:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        ((l) e0Var.f466a).C0(i16, unsafe.getLong(obj, j4));
                    }
                    m0Var = this;
                    break;
                case 15:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        int i19 = unsafe.getInt(obj, j4);
                        ((l) e0Var.f466a).K0(i16, (i19 >> 31) ^ (i19 << 1));
                    }
                    m0Var = this;
                    break;
                case 16:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        long j8 = unsafe.getLong(obj, j4);
                        ((l) e0Var.f466a).M0(i16, (j8 >> 63) ^ (j8 << 1));
                    }
                    m0Var = this;
                    break;
                case 17:
                    if (m0Var.o(obj, i14, i13, i15, i9)) {
                        e0Var.a(i16, unsafe.getObject(obj, j4), m0Var.m(i14));
                        break;
                    } else {
                        break;
                    }
                case BERTags.NUMERIC_STRING /* 18 */:
                    i10 = i13;
                    v0.n(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case 19:
                    i10 = i13;
                    v0.r(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case 20:
                    i10 = i13;
                    v0.t(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    i10 = i13;
                    v0.z(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.IA5_STRING /* 22 */:
                    i10 = i13;
                    v0.s(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.UTC_TIME /* 23 */:
                    i10 = i13;
                    v0.q(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case 24:
                    i10 = i13;
                    v0.p(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.GRAPHIC_STRING /* 25 */:
                    i10 = i13;
                    v0.m(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.VISIBLE_STRING /* 26 */:
                    i11 = i13;
                    int i20 = iArr[i14];
                    List list = (List) unsafe.getObject(obj, j4);
                    Class cls = v0.f571a;
                    if (list != null && !list.isEmpty()) {
                        e0Var.getClass();
                        for (int i21 = 0; i21 < list.size(); i21++) {
                            ((l) e0Var.f466a).H0(i20, (String) list.get(i21));
                        }
                    }
                    i13 = i11;
                    break;
                case BERTags.GENERAL_STRING /* 27 */:
                    i11 = i13;
                    int i22 = iArr[i14];
                    List list2 = (List) unsafe.getObject(obj, j4);
                    u0 u0VarM = m0Var.m(i14);
                    Class cls2 = v0.f571a;
                    if (list2 != null && !list2.isEmpty()) {
                        e0Var.getClass();
                        for (int i23 = 0; i23 < list2.size(); i23++) {
                            ((l) e0Var.f466a).G0(i22, (a) list2.get(i23), u0VarM);
                        }
                    }
                    i13 = i11;
                    break;
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    i11 = i13;
                    int i24 = iArr[i14];
                    List list3 = (List) unsafe.getObject(obj, j4);
                    Class cls3 = v0.f571a;
                    if (list3 != null && !list3.isEmpty()) {
                        e0Var.getClass();
                        for (int i25 = 0; i25 < list3.size(); i25++) {
                            ((l) e0Var.f466a).y0(i24, (g) list3.get(i25));
                        }
                    }
                    i13 = i11;
                    break;
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                    i10 = i13;
                    z = false;
                    v0.y(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case 30:
                    i10 = i13;
                    z = false;
                    v0.o(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.DATE /* 31 */:
                    i10 = i13;
                    z = false;
                    v0.u(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case 32:
                    i10 = i13;
                    z = false;
                    v0.v(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.DATE_TIME /* 33 */:
                    i10 = i13;
                    z = false;
                    v0.w(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.DURATION /* 34 */:
                    i10 = i13;
                    z = false;
                    v0.x(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, false);
                    i13 = i10;
                    break;
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    i11 = i13;
                    v0.n(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    i11 = i13;
                    v0.r(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 37:
                    i11 = i13;
                    v0.t(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 38:
                    i11 = i13;
                    v0.z(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 39:
                    i11 = i13;
                    v0.s(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 40:
                    i11 = i13;
                    v0.q(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 41:
                    i11 = i13;
                    v0.p(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 42:
                    i11 = i13;
                    v0.m(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 43:
                    i11 = i13;
                    v0.y(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 44:
                    i11 = i13;
                    v0.o(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 45:
                    i11 = i13;
                    v0.u(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 46:
                    i11 = i13;
                    v0.v(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 47:
                    i11 = i13;
                    v0.w(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 48:
                    i11 = i13;
                    v0.x(iArr[i14], (List) unsafe.getObject(obj, j4), e0Var, true);
                    i13 = i11;
                    break;
                case 49:
                    i11 = i13;
                    int i26 = iArr[i14];
                    List list4 = (List) unsafe.getObject(obj, j4);
                    u0 u0VarM2 = m0Var.m(i14);
                    Class cls4 = v0.f571a;
                    if (list4 != null && !list4.isEmpty()) {
                        e0Var.getClass();
                        for (int i27 = 0; i27 < list4.size(); i27++) {
                            e0Var.a(i26, list4.get(i27), u0VarM2);
                        }
                    }
                    i13 = i11;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j4);
                    if (object2 != null) {
                        int i28 = 2;
                        Object obj2 = m0Var.f518b[(i14 / 3) * 2];
                        m0Var.f528m.getClass();
                        f0 f0Var = ((g0) obj2).f476a;
                        l lVar3 = (l) e0Var.f466a;
                        lVar3.getClass();
                        for (Map.Entry entry : ((h0) object2).entrySet()) {
                            lVar3.J0(i16, i28);
                            lVar3.L0(g0.a(f0Var, entry.getKey(), entry.getValue()));
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            q.b(lVar3, f0Var.f470a, 1, key);
                            i28 = 2;
                            q.b(lVar3, f0Var.f471b, 2, value);
                            i13 = i13;
                        }
                    }
                    i11 = i13;
                    i13 = i11;
                    break;
                case 51:
                    if (m0Var.q(obj, i16, i14)) {
                        double dDoubleValue = ((Double) h1.f488c.h(obj, j4)).doubleValue();
                        l lVar4 = (l) e0Var.f466a;
                        lVar4.getClass();
                        lVar4.C0(i16, Double.doubleToRawLongBits(dDoubleValue));
                    }
                    break;
                case 52:
                    if (m0Var.q(obj, i16, i14)) {
                        float fFloatValue = ((Float) h1.f488c.h(obj, j4)).floatValue();
                        l lVar5 = (l) e0Var.f466a;
                        lVar5.getClass();
                        lVar5.A0(i16, Float.floatToRawIntBits(fFloatValue));
                    }
                    break;
                case 53:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).M0(i16, z(obj, j4));
                    }
                    break;
                case 54:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).M0(i16, z(obj, j4));
                    }
                    break;
                case 55:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).E0(i16, y(obj, j4));
                    }
                    break;
                case 56:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).C0(i16, z(obj, j4));
                    }
                    break;
                case 57:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).A0(i16, y(obj, j4));
                    }
                    break;
                case 58:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).x0(i16, ((Boolean) h1.f488c.h(obj, j4)).booleanValue());
                    }
                    break;
                case 59:
                    if (m0Var.q(obj, i16, i14)) {
                        Object object3 = unsafe.getObject(obj, j4);
                        if (object3 instanceof String) {
                            ((l) e0Var.f466a).H0(i16, (String) object3);
                        } else {
                            ((l) e0Var.f466a).y0(i16, (g) object3);
                        }
                    }
                    break;
                case 60:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).G0(i16, (a) unsafe.getObject(obj, j4), m0Var.m(i14));
                    }
                    break;
                case 61:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).y0(i16, (g) unsafe.getObject(obj, j4));
                    }
                    break;
                case 62:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).K0(i16, y(obj, j4));
                    }
                    break;
                case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).E0(i16, y(obj, j4));
                    }
                    break;
                case 64:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).A0(i16, y(obj, j4));
                    }
                    break;
                case 65:
                    if (m0Var.q(obj, i16, i14)) {
                        ((l) e0Var.f466a).C0(i16, z(obj, j4));
                    }
                    break;
                case 66:
                    if (m0Var.q(obj, i16, i14)) {
                        int iY = y(obj, j4);
                        ((l) e0Var.f466a).K0(i16, (iY >> 31) ^ (iY << 1));
                    }
                    break;
                case 67:
                    if (m0Var.q(obj, i16, i14)) {
                        long jZ = z(obj, j4);
                        ((l) e0Var.f466a).M0(i16, (jZ << 1) ^ (jZ >> 63));
                    }
                    break;
                case 68:
                    if (m0Var.q(obj, i16, i14)) {
                        e0Var.a(i16, unsafe.getObject(obj, j4), m0Var.m(i14));
                    }
                    break;
            }
            i14 += 3;
            i12 = 1048575;
        }
        m0Var.f527l.getClass();
        ((v) obj).unknownFields.d(e0Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // androidx.datastore.preferences.protobuf.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    @Override // androidx.datastore.preferences.protobuf.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = p(r10)
            if (r0 != 0) goto L8
            goto La5
        L8:
            boolean r0 = r10 instanceof androidx.datastore.preferences.protobuf.v
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r10
            androidx.datastore.preferences.protobuf.v r0 = (androidx.datastore.preferences.protobuf.v) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.k(r2)
            r0.memoizedHashCode = r1
            r0.h()
        L1b:
            int[] r0 = r9.f517a
            int r2 = r0.length
            r3 = r1
        L1f:
            if (r3 >= r2) goto L96
            int r4 = r9.L(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            long r5 = (long) r5
            int r4 = K(r4)
            r7 = 9
            if (r4 == r7) goto L80
            r7 = 60
            if (r4 == r7) goto L6a
            r7 = 68
            if (r4 == r7) goto L6a
            switch(r4) {
                case 17: goto L80;
                case 18: goto L54;
                case 19: goto L54;
                case 20: goto L54;
                case 21: goto L54;
                case 22: goto L54;
                case 23: goto L54;
                case 24: goto L54;
                case 25: goto L54;
                case 26: goto L54;
                case 27: goto L54;
                case 28: goto L54;
                case 29: goto L54;
                case 30: goto L54;
                case 31: goto L54;
                case 32: goto L54;
                case 33: goto L54;
                case 34: goto L54;
                case 35: goto L54;
                case 36: goto L54;
                case 37: goto L54;
                case 38: goto L54;
                case 39: goto L54;
                case 40: goto L54;
                case 41: goto L54;
                case 42: goto L54;
                case 43: goto L54;
                case 44: goto L54;
                case 45: goto L54;
                case 46: goto L54;
                case 47: goto L54;
                case 48: goto L54;
                case 49: goto L54;
                case 50: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L93
        L3e:
            sun.misc.Unsafe r4 = androidx.datastore.preferences.protobuf.m0.f516o
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L93
            androidx.datastore.preferences.protobuf.i0 r8 = r9.f528m
            r8.getClass()
            r8 = r7
            androidx.datastore.preferences.protobuf.h0 r8 = (androidx.datastore.preferences.protobuf.h0) r8
            r8.f485a = r1
            r4.putObject(r10, r5, r7)
            goto L93
        L54:
            androidx.datastore.preferences.protobuf.b0 r4 = r9.f526k
            r4.getClass()
            androidx.datastore.preferences.protobuf.g1 r4 = androidx.datastore.preferences.protobuf.h1.f488c
            java.lang.Object r4 = r4.h(r10, r5)
            androidx.datastore.preferences.protobuf.w r4 = (androidx.datastore.preferences.protobuf.w) r4
            androidx.datastore.preferences.protobuf.b r4 = (androidx.datastore.preferences.protobuf.b) r4
            boolean r5 = r4.f450a
            if (r5 == 0) goto L93
            r4.f450a = r1
            goto L93
        L6a:
            r4 = r0[r3]
            boolean r4 = r9.q(r10, r4, r3)
            if (r4 == 0) goto L93
            androidx.datastore.preferences.protobuf.u0 r4 = r9.m(r3)
            sun.misc.Unsafe r7 = androidx.datastore.preferences.protobuf.m0.f516o
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.b(r5)
            goto L93
        L80:
            boolean r4 = r9.n(r3, r10)
            if (r4 == 0) goto L93
            androidx.datastore.preferences.protobuf.u0 r4 = r9.m(r3)
            sun.misc.Unsafe r7 = androidx.datastore.preferences.protobuf.m0.f516o
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.b(r5)
        L93:
            int r3 = r3 + 3
            goto L1f
        L96:
            androidx.datastore.preferences.protobuf.c1 r9 = r9.f527l
            r9.getClass()
            androidx.datastore.preferences.protobuf.v r10 = (androidx.datastore.preferences.protobuf.v) r10
            androidx.datastore.preferences.protobuf.b1 r9 = r10.unknownFields
            boolean r10 = r9.f455e
            if (r10 == 0) goto La5
            r9.f455e = r1
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.b(java.lang.Object):void");
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final boolean c(Object obj) {
        int i8;
        int i9;
        int i10;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        while (i13 < this.f523h) {
            int i14 = this.f522g[i13];
            int[] iArr = this.f517a;
            int i15 = iArr[i14];
            int iL = L(i14);
            int i16 = iArr[i14 + 2];
            int i17 = i16 & 1048575;
            int i18 = 1 << (i16 >>> 20);
            if (i17 != i11) {
                if (i17 != 1048575) {
                    i12 = f516o.getInt(obj, i17);
                }
                i9 = i14;
                i10 = i12;
                i8 = i17;
            } else {
                int i19 = i12;
                i8 = i11;
                i9 = i14;
                i10 = i19;
            }
            if ((268435456 & iL) == 0 || o(obj, i9, i8, i10, i18)) {
                int iK = K(iL);
                if (iK == 9 || iK == 17) {
                    if (o(obj, i9, i8, i10, i18)) {
                        if (!m(i9).c(h1.f488c.h(obj, iL & 1048575))) {
                        }
                    } else {
                        continue;
                    }
                    i13++;
                    i11 = i8;
                    i12 = i10;
                } else {
                    if (iK != 27) {
                        if (iK == 60 || iK == 68) {
                            if (q(obj, i15, i9)) {
                                if (!m(i9).c(h1.f488c.h(obj, iL & 1048575))) {
                                }
                            } else {
                                continue;
                            }
                            i13++;
                            i11 = i8;
                            i12 = i10;
                        } else if (iK != 49) {
                            if (iK != 50) {
                                continue;
                            } else {
                                Object objH = h1.f488c.h(obj, iL & 1048575);
                                this.f528m.getClass();
                                h0 h0Var = (h0) objH;
                                if (h0Var.isEmpty()) {
                                    continue;
                                } else {
                                    if (((g0) this.f518b[(i9 / 3) * 2]).f476a.f471b.f541a != q1.f553j) {
                                        continue;
                                    } else {
                                        u0 u0VarA = null;
                                        for (Object obj2 : h0Var.values()) {
                                            if (u0VarA == null) {
                                                u0VarA = r0.f559c.a(obj2.getClass());
                                            }
                                            if (!u0VarA.c(obj2)) {
                                            }
                                        }
                                    }
                                }
                            }
                            i13++;
                            i11 = i8;
                            i12 = i10;
                        }
                    }
                    List list = (List) h1.f488c.h(obj, iL & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        u0 u0VarM = m(i9);
                        for (int i20 = 0; i20 < list.size(); i20++) {
                            if (u0VarM.c(list.get(i20))) {
                            }
                        }
                    }
                    i13++;
                    i11 = i8;
                    i12 = i10;
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final v d() {
        this.f525j.getClass();
        return ((v) this.f520e).i();
    }

    @Override // androidx.datastore.preferences.protobuf.u0
    public final void e(Object obj, e0 e0Var) throws IOException {
        e0Var.getClass();
        M(obj, e0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(androidx.datastore.preferences.protobuf.v r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.f(androidx.datastore.preferences.protobuf.v):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // androidx.datastore.preferences.protobuf.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(androidx.datastore.preferences.protobuf.v r12, androidx.datastore.preferences.protobuf.v r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.g(androidx.datastore.preferences.protobuf.v, androidx.datastore.preferences.protobuf.v):boolean");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    @Override // androidx.datastore.preferences.protobuf.u0
    public final void h(java.lang.Object r19, androidx.datastore.preferences.protobuf.j r20, androidx.datastore.preferences.protobuf.n r21) {
        /*
            Method dump skipped, instructions count: 1926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.h(java.lang.Object, androidx.datastore.preferences.protobuf.j, androidx.datastore.preferences.protobuf.n):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01cd  */
    @Override // androidx.datastore.preferences.protobuf.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(androidx.datastore.preferences.protobuf.v r17) {
        /*
            Method dump skipped, instructions count: 1850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.i(androidx.datastore.preferences.protobuf.v):int");
    }

    public final boolean j(v vVar, v vVar2, int i8) {
        return n(i8, vVar) == n(i8, vVar2);
    }

    public final void k(Object obj, int i8, Object obj2) {
        int i9 = this.f517a[i8];
        if (h1.f488c.h(obj, L(i8) & 1048575) == null) {
            return;
        }
        l(i8);
    }

    public final void l(int i8) {
        if (this.f518b[((i8 / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    public final u0 m(int i8) {
        int i9 = (i8 / 3) * 2;
        Object[] objArr = this.f518b;
        u0 u0Var = (u0) objArr[i9];
        if (u0Var != null) {
            return u0Var;
        }
        u0 u0VarA = r0.f559c.a((Class) objArr[i9 + 1]);
        objArr[i9] = u0VarA;
        return u0VarA;
    }

    public final boolean n(int i8, Object obj) {
        int i9 = this.f517a[i8 + 2];
        long j4 = i9 & 1048575;
        if (j4 == 1048575) {
            int iL = L(i8);
            long j8 = iL & 1048575;
            switch (K(iL)) {
                case 0:
                    if (Double.doubleToRawLongBits(h1.f488c.d(obj, j8)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(h1.f488c.e(obj, j8)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (h1.f488c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (h1.f488c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (h1.f488c.f(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (h1.f488c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (h1.f488c.f(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return h1.f488c.c(obj, j8);
                case 8:
                    Object objH = h1.f488c.h(obj, j8);
                    if (objH instanceof String) {
                        return !((String) objH).isEmpty();
                    }
                    if (objH instanceof g) {
                        return !g.f473c.equals(objH);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (h1.f488c.h(obj, j8) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !g.f473c.equals(h1.f488c.h(obj, j8));
                case BERTags.EMBEDDED_PDV /* 11 */:
                    if (h1.f488c.f(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (h1.f488c.f(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case BERTags.RELATIVE_OID /* 13 */:
                    if (h1.f488c.f(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case BERTags.TIME /* 14 */:
                    if (h1.f488c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (h1.f488c.f(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (h1.f488c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (h1.f488c.h(obj, j8) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i9 >>> 20)) & h1.f488c.f(obj, j4)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean o(Object obj, int i8, int i9, int i10, int i11) {
        return i9 == 1048575 ? n(i8, obj) : (i10 & i11) != 0;
    }

    public final boolean q(Object obj, int i8, int i9) {
        return h1.f488c.f(obj, (long) (this.f517a[i9 + 2] & 1048575)) == i8;
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
    public final void r(java.lang.Object r8, int r9, java.lang.Object r10, androidx.datastore.preferences.protobuf.n r11, androidx.datastore.preferences.protobuf.j r12) throws androidx.datastore.preferences.protobuf.y, com.google.crypto.tink.shaded.protobuf.b0 {
        /*
            r7 = this;
            int r9 = r7.L(r9)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r0
            long r0 = (long) r9
            androidx.datastore.preferences.protobuf.g1 r9 = androidx.datastore.preferences.protobuf.h1.f488c
            java.lang.Object r9 = r9.h(r8, r0)
            androidx.datastore.preferences.protobuf.i0 r7 = r7.f528m
            if (r9 != 0) goto L20
            r7.getClass()
            androidx.datastore.preferences.protobuf.h0 r9 = androidx.datastore.preferences.protobuf.h0.f484b
            androidx.datastore.preferences.protobuf.h0 r9 = r9.b()
            androidx.datastore.preferences.protobuf.h1.o(r0, r8, r9)
            goto L37
        L20:
            r7.getClass()
            r2 = r9
            androidx.datastore.preferences.protobuf.h0 r2 = (androidx.datastore.preferences.protobuf.h0) r2
            boolean r2 = r2.f485a
            if (r2 != 0) goto L37
            androidx.datastore.preferences.protobuf.h0 r2 = androidx.datastore.preferences.protobuf.h0.f484b
            androidx.datastore.preferences.protobuf.h0 r2 = r2.b()
            androidx.datastore.preferences.protobuf.i0.a(r2, r9)
            androidx.datastore.preferences.protobuf.h1.o(r0, r8, r2)
            r9 = r2
        L37:
            r7.getClass()
            androidx.datastore.preferences.protobuf.h0 r9 = (androidx.datastore.preferences.protobuf.h0) r9
            androidx.datastore.preferences.protobuf.g0 r10 = (androidx.datastore.preferences.protobuf.g0) r10
            androidx.datastore.preferences.protobuf.f0 r7 = r10.f476a
            r8 = 2
            r12.P(r8)
            java.lang.Object r10 = r12.f503e
            a2.e r10 = (a2.e) r10
            int r0 = r10.D()
            int r0 = r10.l(r0)
            java.lang.Object r1 = r7.f472c
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
            boolean r4 = r12.Q()     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            if (r4 == 0) goto L73
            goto L55
        L73:
            androidx.datastore.preferences.protobuf.z r4 = new androidx.datastore.preferences.protobuf.z     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            throw r4     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
        L79:
            r7 = move-exception
            goto La2
        L7b:
            androidx.datastore.preferences.protobuf.p1 r4 = r7.f471b     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            java.lang.Object r3 = r12.p(r4, r5, r11)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            goto L55
        L86:
            androidx.datastore.preferences.protobuf.p1 r4 = r7.f470a     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            r5 = 0
            java.lang.Object r2 = r12.p(r4, r5, r5)     // Catch: java.lang.Throwable -> L79 androidx.datastore.preferences.protobuf.y -> L8e
            goto L55
        L8e:
            boolean r4 = r12.Q()     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L95
            goto L55
        L95:
            androidx.datastore.preferences.protobuf.z r7 = new androidx.datastore.preferences.protobuf.z     // Catch: java.lang.Throwable -> L79
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.m0.r(java.lang.Object, int, java.lang.Object, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.j):void");
    }

    public final void s(Object obj, int i8, Object obj2) {
        if (n(i8, obj2)) {
            long jL = L(i8) & 1048575;
            Unsafe unsafe = f516o;
            Object object = unsafe.getObject(obj2, jL);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f517a[i8] + " is present but null: " + obj2);
            }
            u0 u0VarM = m(i8);
            if (!n(i8, obj)) {
                if (p(object)) {
                    v vVarD = u0VarM.d();
                    u0VarM.a(vVarD, object);
                    unsafe.putObject(obj, jL, vVarD);
                } else {
                    unsafe.putObject(obj, jL, object);
                }
                G(i8, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jL);
            if (!p(object2)) {
                v vVarD2 = u0VarM.d();
                u0VarM.a(vVarD2, object2);
                unsafe.putObject(obj, jL, vVarD2);
                object2 = vVarD2;
            }
            u0VarM.a(object2, object);
        }
    }

    public final void t(Object obj, int i8, Object obj2) {
        int[] iArr = this.f517a;
        int i9 = iArr[i8];
        if (q(obj2, i9, i8)) {
            long jL = L(i8) & 1048575;
            Unsafe unsafe = f516o;
            Object object = unsafe.getObject(obj2, jL);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i8] + " is present but null: " + obj2);
            }
            u0 u0VarM = m(i8);
            if (!q(obj, i9, i8)) {
                if (p(object)) {
                    v vVarD = u0VarM.d();
                    u0VarM.a(vVarD, object);
                    unsafe.putObject(obj, jL, vVarD);
                } else {
                    unsafe.putObject(obj, jL, object);
                }
                H(obj, i9, i8);
                return;
            }
            Object object2 = unsafe.getObject(obj, jL);
            if (!p(object2)) {
                v vVarD2 = u0VarM.d();
                u0VarM.a(vVarD2, object2);
                unsafe.putObject(obj, jL, vVarD2);
                object2 = vVarD2;
            }
            u0VarM.a(object2, object);
        }
    }

    public final Object u(int i8, Object obj) {
        u0 u0VarM = m(i8);
        long jL = L(i8) & 1048575;
        if (!n(i8, obj)) {
            return u0VarM.d();
        }
        Object object = f516o.getObject(obj, jL);
        if (p(object)) {
            return object;
        }
        v vVarD = u0VarM.d();
        if (object != null) {
            u0VarM.a(vVarD, object);
        }
        return vVarD;
    }

    public final Object v(Object obj, int i8, int i9) {
        u0 u0VarM = m(i9);
        if (!q(obj, i8, i9)) {
            return u0VarM.d();
        }
        Object object = f516o.getObject(obj, L(i9) & 1048575);
        if (p(object)) {
            return object;
        }
        v vVarD = u0VarM.d();
        if (object != null) {
            u0VarM.a(vVarD, object);
        }
        return vVarD;
    }
}
