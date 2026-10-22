package q0;

import com.stepos.minor.Minor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import m0.InterfaceC0856d;
import o0.C0896i;
import u0.C1151a;
import u0.C1152b;
import u0.C1154d;

/* renamed from: q0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0954a {

    /* renamed from: c, reason: collision with root package name */
    static final String f19727c = C1152b.g(C0946I.class);

    /* renamed from: d, reason: collision with root package name */
    static final String f19728d;

    /* renamed from: e, reason: collision with root package name */
    static final String f19729e;

    /* renamed from: f, reason: collision with root package name */
    static final String f19730f;

    /* renamed from: g, reason: collision with root package name */
    static final String f19731g;

    /* renamed from: h, reason: collision with root package name */
    static final String f19732h;

    /* renamed from: i, reason: collision with root package name */
    static final String f19733i;

    /* renamed from: j, reason: collision with root package name */
    static final String f19734j;

    /* renamed from: k, reason: collision with root package name */
    static final String f19735k;

    /* renamed from: a, reason: collision with root package name */
    protected final C1151a f19736a = new C1151a();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f19737b = new AtomicLong();

    /* renamed from: q0.a$a, reason: collision with other inner class name */
    static class C0235a {

        /* renamed from: h, reason: collision with root package name */
        static int f19738h = 6;

        /* renamed from: i, reason: collision with root package name */
        static int f19739i = 7;

        /* renamed from: j, reason: collision with root package name */
        static int f19740j = 8;

        /* renamed from: a, reason: collision with root package name */
        private final C1154d[] f19741a;

        /* renamed from: b, reason: collision with root package name */
        private final String f19742b;

        /* renamed from: c, reason: collision with root package name */
        private final a0 f19743c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f19744d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, Integer> f19745e = new HashMap();

        /* renamed from: f, reason: collision with root package name */
        private int f19746f = 9;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f19747g;

        public C0235a(C1154d[] c1154dArr, a0 a0Var, String str, boolean z5, boolean z6) {
            this.f19741a = c1154dArr;
            this.f19742b = str;
            this.f19743c = a0Var;
            this.f19744d = z5;
            this.f19747g = z6 || a0Var.f19748a.isEnum();
        }

        public int f(String str) {
            int length = this.f19741a.length;
            for (int i5 = 0; i5 < length; i5++) {
                if (this.f19741a[i5].f22730a.equals(str)) {
                    return i5;
                }
            }
            return -1;
        }

        public int g(String str) {
            if (this.f19745e.get(str) == null) {
                Map<String, Integer> map = this.f19745e;
                int i5 = this.f19746f;
                this.f19746f = i5 + 1;
                map.put(str, Integer.valueOf(i5));
            }
            return this.f19745e.get(str).intValue();
        }

        public int h(String str, int i5) {
            if (this.f19745e.get(str) == null) {
                this.f19745e.put(str, Integer.valueOf(this.f19746f));
                this.f19746f += i5;
            }
            return this.f19745e.get(str).intValue();
        }
    }

    static {
        String strG = C1152b.g(U.class);
        f19728d = strG;
        f19729e = "L" + strG + ";";
        String strG2 = C1152b.g(e0.class);
        f19730f = strG2;
        f19731g = "L" + strG2 + ";";
        f19732h = C1152b.g(C0947J.class);
        f19733i = "L" + C1152b.g(C0947J.class) + ";";
        f19734j = C1152b.b(Z.class);
        f19735k = C1152b.b(d0.class);
    }

    private void A(Class<?> cls, n0.h hVar, C1154d[] c1154dArr, C0235a c0235a) {
        int i5;
        String str;
        int i6;
        String str2;
        int i7;
        String str3;
        String str4;
        int i8;
        char c6;
        boolean z5;
        C0954a c0954a;
        char c7;
        n0.f fVar;
        int i9;
        Class<?> cls2;
        int i10;
        n0.f fVar2;
        n0.f fVar3;
        n0.f fVar4;
        String str5;
        Class<?> cls3;
        n0.f fVar5;
        String str6;
        int i11;
        int i12;
        String str7;
        int i13;
        n0.f fVar6;
        C0954a c0954a2 = this;
        C1154d[] c1154dArr2 = c1154dArr;
        n0.f fVar7 = new n0.f();
        hVar.g(25, 1);
        hVar.g(25, 0);
        String str8 = f19727c;
        hVar.i(182, str8, "hasPropertyFilters", "(" + f19735k + ")Z");
        hVar.h(154, fVar7);
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.g(25, 2);
        hVar.g(25, 3);
        hVar.g(25, 4);
        hVar.g(21, 5);
        String str9 = f19732h;
        StringBuilder sb = new StringBuilder();
        String str10 = "(L";
        sb.append("(L");
        sb.append(str8);
        String str11 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        hVar.i(183, str9, "writeNoneASM", sb.toString());
        hVar.e(177);
        hVar.l(fVar7);
        String str12 = "out";
        hVar.g(25, c0235a.g("out"));
        hVar.g(16, 91);
        String str13 = f19730f;
        String str14 = "(I)V";
        hVar.i(182, str13, "write", "(I)V");
        int i14 = 0;
        int length = c1154dArr2.length;
        if (length == 0) {
            hVar.g(25, c0235a.g("out"));
            hVar.g(16, 93);
            hVar.i(182, str13, "write", "(I)V");
            return;
        }
        int i15 = 0;
        while (i15 < length) {
            int i16 = i15 == length + (-1) ? 93 : 44;
            C1154d c1154d = c1154dArr2[i15];
            Class<?> cls4 = c1154d.f22734e;
            hVar.k(c1154d.f22730a);
            hVar.g(58, C0235a.f19738h);
            if (cls4 == Byte.TYPE || cls4 == Short.TYPE || cls4 == Integer.TYPE) {
                i5 = i14;
                str = str12;
                int i17 = i16;
                i6 = length;
                str2 = str11;
                i7 = i15;
                str3 = str10;
                str4 = str14;
                i8 = 182;
                c6 = 25;
                z5 = true;
                hVar.g(25, c0235a.g(str));
                hVar.e(89);
                c0954a = this;
                c0954a.i(hVar, c0235a, c1154d);
                String str15 = f19730f;
                hVar.i(182, str15, "writeInt", str4);
                c7 = 16;
                hVar.g(16, i17);
                hVar.i(182, str15, "write", str4);
            } else {
                if (cls4 == Long.TYPE) {
                    hVar.g(25, c0235a.g(str12));
                    hVar.e(89);
                    c0954a2.i(hVar, c0235a, c1154d);
                    String str16 = f19730f;
                    i8 = 182;
                    hVar.i(182, str16, "writeLong", "(J)V");
                    hVar.g(16, i16);
                    hVar.i(182, str16, "write", str14);
                } else if (cls4 == Float.TYPE) {
                    hVar.g(25, c0235a.g(str12));
                    hVar.e(89);
                    c0954a2.i(hVar, c0235a, c1154d);
                    hVar.e(4);
                    String str17 = f19730f;
                    i8 = 182;
                    hVar.i(182, str17, "writeFloat", "(FZ)V");
                    hVar.g(16, i16);
                    hVar.i(182, str17, "write", str14);
                } else if (cls4 == Double.TYPE) {
                    hVar.g(25, c0235a.g(str12));
                    hVar.e(89);
                    c0954a2.i(hVar, c0235a, c1154d);
                    hVar.e(4);
                    String str18 = f19730f;
                    i8 = 182;
                    hVar.i(182, str18, "writeDouble", "(DZ)V");
                    hVar.g(16, i16);
                    hVar.i(182, str18, "write", str14);
                } else if (cls4 == Boolean.TYPE) {
                    hVar.g(25, c0235a.g(str12));
                    hVar.e(89);
                    c0954a2.i(hVar, c0235a, c1154d);
                    String str19 = f19730f;
                    i8 = 182;
                    hVar.i(182, str19, "write", "(Z)V");
                    hVar.g(16, i16);
                    hVar.i(182, str19, "write", str14);
                } else {
                    if (cls4 == Character.TYPE) {
                        hVar.g(25, c0235a.g(str12));
                        c0954a2.i(hVar, c0235a, c1154d);
                        hVar.i(184, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                        hVar.g(16, i16);
                        i8 = 182;
                        hVar.i(182, f19730f, "writeString", "(Ljava/lang/String;C)V");
                        str = str12;
                        i6 = length;
                        str2 = str11;
                        i7 = i15;
                        c7 = 16;
                        str3 = str10;
                        str4 = str14;
                    } else {
                        if (cls4 == String.class) {
                            hVar.g(25, c0235a.g(str12));
                            c0954a2.i(hVar, c0235a, c1154d);
                            hVar.g(16, i16);
                            hVar.i(182, f19730f, "writeString", "(Ljava/lang/String;C)V");
                            c0954a = c0954a2;
                            str = str12;
                            i6 = length;
                            str2 = str11;
                            i7 = i15;
                            str3 = str10;
                            str4 = str14;
                            z5 = true;
                            i5 = i14;
                            c6 = 25;
                            i8 = 182;
                        } else if (cls4.isEnum()) {
                            hVar.g(25, c0235a.g(str12));
                            hVar.e(89);
                            c0954a2.i(hVar, c0235a, c1154d);
                            String str20 = f19730f;
                            hVar.i(182, str20, "writeEnum", "(Ljava/lang/Enum;)V");
                            hVar.g(16, i16);
                            hVar.i(182, str20, "write", str14);
                            str = str12;
                            i6 = length;
                            str2 = str11;
                            i7 = i15;
                            i8 = 182;
                            str3 = str10;
                            str4 = str14;
                            c7 = 16;
                        } else if (List.class.isAssignableFrom(cls4)) {
                            Type type = c1154d.f22735f;
                            Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[i14];
                            if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                                cls2 = null;
                            }
                            c0954a2.i(hVar, c0235a, c1154d);
                            Type type3 = type2;
                            hVar.b(192, "java/util/List");
                            i6 = length;
                            hVar.g(58, c0235a.g("list"));
                            if (cls2 == String.class && c0235a.f19744d) {
                                hVar.g(25, c0235a.g(str12));
                                hVar.g(25, c0235a.g("list"));
                                hVar.i(182, f19730f, "write", "(Ljava/util/List;)V");
                                str6 = str12;
                                i10 = i16;
                                str2 = str11;
                                i7 = i15;
                                i13 = 182;
                                str3 = str10;
                                str7 = str14;
                                i12 = 16;
                                i11 = 25;
                            } else {
                                n0.f fVar8 = new n0.f();
                                n0.f fVar9 = new n0.f();
                                i7 = i15;
                                i10 = i16;
                                hVar.g(25, c0235a.g("list"));
                                hVar.h(199, fVar9);
                                hVar.g(25, c0235a.g(str12));
                                String str21 = f19730f;
                                String str22 = str11;
                                hVar.i(182, str21, "writeNull", "()V");
                                hVar.h(167, fVar8);
                                hVar.l(fVar9);
                                hVar.g(25, c0235a.g("list"));
                                hVar.i(185, "java/util/List", "size", "()I");
                                hVar.g(54, c0235a.g("size"));
                                hVar.g(25, c0235a.g(str12));
                                hVar.g(16, 91);
                                hVar.i(182, str21, "write", str14);
                                n0.f fVar10 = new n0.f();
                                n0.f fVar11 = new n0.f();
                                n0.f fVar12 = new n0.f();
                                hVar.e(3);
                                String str23 = str10;
                                hVar.g(54, c0235a.g("i"));
                                hVar.l(fVar10);
                                hVar.g(21, c0235a.g("i"));
                                hVar.g(21, c0235a.g("size"));
                                hVar.h(162, fVar12);
                                hVar.g(21, c0235a.g("i"));
                                hVar.h(153, fVar11);
                                hVar.g(25, c0235a.g(str12));
                                hVar.g(16, 44);
                                hVar.i(182, str21, "write", str14);
                                hVar.l(fVar11);
                                hVar.g(25, c0235a.g("list"));
                                hVar.g(21, c0235a.g("i"));
                                hVar.i(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
                                hVar.g(58, c0235a.g("list_item"));
                                n0.f fVar13 = new n0.f();
                                n0.f fVar14 = new n0.f();
                                String str24 = str14;
                                hVar.g(25, c0235a.g("list_item"));
                                hVar.h(199, fVar14);
                                hVar.g(25, c0235a.g(str12));
                                String str25 = str12;
                                hVar.i(182, str21, "writeNull", "()V");
                                hVar.h(167, fVar13);
                                hVar.l(fVar14);
                                n0.f fVar15 = new n0.f();
                                n0.f fVar16 = new n0.f();
                                if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                    fVar2 = fVar10;
                                    fVar3 = fVar13;
                                    fVar4 = fVar12;
                                    str5 = str21;
                                    cls3 = cls2;
                                    str2 = str22;
                                    str3 = str23;
                                    fVar5 = fVar16;
                                } else {
                                    hVar.g(25, c0235a.g("list_item"));
                                    str5 = str21;
                                    fVar4 = fVar12;
                                    hVar.i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                    hVar.k(n0.j.g(C1152b.b(cls2)));
                                    hVar.h(166, fVar16);
                                    c0954a2.k(c0235a, hVar, c1154d, cls2);
                                    hVar.g(58, c0235a.g("list_item_desc"));
                                    n0.f fVar17 = new n0.f();
                                    n0.f fVar18 = new n0.f();
                                    if (c0235a.f19744d) {
                                        cls3 = cls2;
                                        hVar.g(25, c0235a.g("list_item_desc"));
                                        String str26 = f19732h;
                                        hVar.b(193, str26);
                                        hVar.h(153, fVar17);
                                        hVar.g(25, c0235a.g("list_item_desc"));
                                        hVar.b(192, str26);
                                        hVar.g(25, 1);
                                        hVar.g(25, c0235a.g("list_item"));
                                        if (c0235a.f19747g) {
                                            hVar.e(1);
                                            fVar2 = fVar10;
                                            fVar3 = fVar13;
                                        } else {
                                            hVar.g(21, c0235a.g("i"));
                                            fVar2 = fVar10;
                                            fVar3 = fVar13;
                                            hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                        }
                                        hVar.k(n0.j.g(C1152b.b(cls3)));
                                        hVar.k(Integer.valueOf(c1154d.f22738i));
                                        StringBuilder sb2 = new StringBuilder();
                                        str3 = str23;
                                        sb2.append(str3);
                                        sb2.append(f19727c);
                                        str2 = str22;
                                        sb2.append(str2);
                                        fVar6 = fVar16;
                                        hVar.i(182, str26, "writeAsArrayNonContext", sb2.toString());
                                        hVar.h(167, fVar18);
                                        hVar.l(fVar17);
                                    } else {
                                        fVar2 = fVar10;
                                        fVar3 = fVar13;
                                        cls3 = cls2;
                                        str2 = str22;
                                        str3 = str23;
                                        fVar6 = fVar16;
                                    }
                                    hVar.g(25, c0235a.g("list_item_desc"));
                                    hVar.g(25, 1);
                                    hVar.g(25, c0235a.g("list_item"));
                                    if (c0235a.f19747g) {
                                        hVar.e(1);
                                    } else {
                                        hVar.g(21, c0235a.g("i"));
                                        hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    hVar.k(n0.j.g(C1152b.b(cls3)));
                                    hVar.k(Integer.valueOf(c1154d.f22738i));
                                    hVar.i(185, f19728d, "write", str3 + f19727c + str2);
                                    hVar.l(fVar18);
                                    hVar.h(167, fVar15);
                                    fVar5 = fVar6;
                                }
                                hVar.l(fVar5);
                                hVar.g(25, 1);
                                hVar.g(25, c0235a.g("list_item"));
                                if (c0235a.f19747g) {
                                    hVar.e(1);
                                } else {
                                    hVar.g(21, c0235a.g("i"));
                                    hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                                    hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                                } else {
                                    hVar.k(n0.j.g(C1152b.b((Class) type3)));
                                    hVar.k(Integer.valueOf(c1154d.f22738i));
                                    hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                                }
                                hVar.l(fVar15);
                                hVar.l(fVar3);
                                hVar.a(c0235a.g("i"), 1);
                                hVar.h(167, fVar2);
                                hVar.l(fVar4);
                                str6 = str25;
                                i11 = 25;
                                hVar.g(25, c0235a.g(str6));
                                i12 = 16;
                                hVar.g(16, 93);
                                str7 = str24;
                                i13 = 182;
                                hVar.i(182, str5, "write", str7);
                                hVar.l(fVar8);
                            }
                            hVar.g(i11, c0235a.g(str6));
                            hVar.g(i12, i10);
                            hVar.i(i13, f19730f, "write", str7);
                            c0954a = this;
                            str = str6;
                            str4 = str7;
                            i8 = i13;
                            c7 = 16;
                            c6 = 25;
                            z5 = true;
                            i5 = i14;
                        } else {
                            String str27 = str12;
                            int i18 = i16;
                            i6 = length;
                            str2 = str11;
                            i7 = i15;
                            str3 = str10;
                            String str28 = str14;
                            n0.f fVar19 = new n0.f();
                            n0.f fVar20 = new n0.f();
                            i(hVar, c0235a, c1154d);
                            hVar.e(89);
                            hVar.g(58, c0235a.g("field_" + c1154d.f22734e.getName()));
                            hVar.h(199, fVar20);
                            hVar.g(25, c0235a.g(str27));
                            String str29 = f19730f;
                            hVar.i(182, str29, "writeNull", "()V");
                            hVar.h(167, fVar19);
                            hVar.l(fVar20);
                            n0.f fVar21 = new n0.f();
                            n0.f fVar22 = new n0.f();
                            hVar.g(25, c0235a.g("field_" + c1154d.f22734e.getName()));
                            hVar.i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                            hVar.k(n0.j.g(C1152b.b(cls4)));
                            hVar.h(166, fVar22);
                            j(c0235a, hVar, c1154d);
                            hVar.g(58, c0235a.g("fied_ser"));
                            n0.f fVar23 = new n0.f();
                            n0.f fVar24 = new n0.f();
                            if (c0235a.f19744d && Modifier.isPublic(cls4.getModifiers())) {
                                hVar.g(25, c0235a.g("fied_ser"));
                                String str30 = f19732h;
                                hVar.b(193, str30);
                                hVar.h(153, fVar23);
                                hVar.g(25, c0235a.g("fied_ser"));
                                hVar.b(192, str30);
                                hVar.g(25, 1);
                                hVar.g(25, c0235a.g("field_" + c1154d.f22734e.getName()));
                                hVar.g(25, C0235a.f19738h);
                                hVar.k(n0.j.g(C1152b.b(cls4)));
                                hVar.k(Integer.valueOf(c1154d.f22738i));
                                fVar = fVar19;
                                hVar.i(182, str30, "writeAsArrayNonContext", str3 + f19727c + str2);
                                hVar.h(167, fVar24);
                                hVar.l(fVar23);
                            } else {
                                fVar = fVar19;
                            }
                            hVar.g(25, c0235a.g("fied_ser"));
                            hVar.g(25, 1);
                            hVar.g(25, c0235a.g("field_" + c1154d.f22734e.getName()));
                            hVar.g(25, C0235a.f19738h);
                            hVar.k(n0.j.g(C1152b.b(cls4)));
                            hVar.k(Integer.valueOf(c1154d.f22738i));
                            String str31 = f19728d;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str3);
                            String str32 = f19727c;
                            sb3.append(str32);
                            sb3.append(str2);
                            hVar.i(185, str31, "write", sb3.toString());
                            hVar.l(fVar24);
                            hVar.h(167, fVar21);
                            hVar.l(fVar22);
                            String strM = c1154d.m();
                            z5 = true;
                            hVar.g(25, 1);
                            hVar.g(25, c0235a.g("field_" + c1154d.f22734e.getName()));
                            if (strM != null) {
                                hVar.k(strM);
                                i9 = 182;
                                hVar.i(182, str32, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                            } else {
                                i9 = 182;
                                hVar.g(25, C0235a.f19738h);
                                Type type4 = c1154d.f22735f;
                                if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                                    hVar.i(182, str32, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                                } else {
                                    i5 = i14;
                                    hVar.g(25, i5);
                                    hVar.c(180, c0235a.f19742b, c1154d.f22730a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                    hVar.k(Integer.valueOf(c1154d.f22738i));
                                    i8 = 182;
                                    hVar.i(182, str32, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                                    hVar.l(fVar21);
                                    hVar.l(fVar);
                                    str = str27;
                                    c6 = 25;
                                    hVar.g(25, c0235a.g(str));
                                    hVar.g(16, i18);
                                    str4 = str28;
                                    hVar.i(i8, str29, "write", str4);
                                    c0954a = this;
                                }
                            }
                            i5 = i14;
                            i8 = i9;
                            hVar.l(fVar21);
                            hVar.l(fVar);
                            str = str27;
                            c6 = 25;
                            hVar.g(25, c0235a.g(str));
                            hVar.g(16, i18);
                            str4 = str28;
                            hVar.i(i8, str29, "write", str4);
                            c0954a = this;
                        }
                        c7 = 16;
                    }
                    c6 = 25;
                    z5 = true;
                    c0954a = c0954a2;
                    i5 = i14;
                }
                c0954a = c0954a2;
                str = str12;
                i6 = length;
                str2 = str11;
                i7 = i15;
                str3 = str10;
                str4 = str14;
                c7 = 16;
                c6 = 25;
                z5 = true;
                i5 = i14;
            }
            i15 = i7 + 1;
            str14 = str4;
            str10 = str3;
            i14 = i5;
            str12 = str;
            str11 = str2;
            c0954a2 = c0954a;
            length = i6;
            c1154dArr2 = c1154dArr;
        }
    }

    private void B(Class<?> cls, n0.h hVar, C1154d[] c1154dArr, C0235a c0235a) {
        n0.f fVar;
        String str;
        int i5;
        int i6;
        C0954a c0954a = this;
        Class<?> cls2 = cls;
        n0.h hVar2 = hVar;
        n0.f fVar2 = new n0.f();
        int length = c1154dArr.length;
        if (c0235a.f19744d) {
            fVar = fVar2;
        } else {
            n0.f fVar3 = new n0.f();
            n0.f fVar4 = new n0.f();
            fVar = fVar2;
            hVar2.g(25, c0235a.g("out"));
            hVar2.k(Integer.valueOf(f0.PrettyFormat.f19849a));
            hVar2.i(182, f19730f, "isEnabled", "(I)Z");
            hVar2.h(154, fVar4);
            int length2 = c1154dArr.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length2) {
                    hVar2.h(167, fVar3);
                    break;
                } else {
                    if (c1154dArr[i7].f22731b != null) {
                        hVar2.g(25, c0235a.g("out"));
                        hVar2.k(Integer.valueOf(f0.IgnoreErrorGetter.f19849a));
                        hVar2.i(182, f19730f, "isEnabled", "(I)Z");
                        hVar2.h(153, fVar3);
                        break;
                    }
                    i7++;
                }
            }
            hVar2.l(fVar4);
            hVar2.g(25, 0);
            hVar2.g(25, 1);
            hVar2.g(25, 2);
            hVar2.g(25, 3);
            hVar2.g(25, 4);
            hVar2.g(21, 5);
            hVar2.i(183, f19732h, "write", "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar2.e(177);
            hVar2.l(fVar3);
        }
        if (!c0235a.f19747g) {
            n0.f fVar5 = new n0.f();
            hVar2.g(25, 0);
            hVar2.g(25, 1);
            hVar2.g(25, 2);
            hVar2.g(21, 5);
            hVar2.i(182, f19732h, "writeReference", "(L" + f19727c + ";Ljava/lang/Object;I)Z");
            hVar2.h(153, fVar5);
            hVar2.e(177);
            hVar2.l(fVar5);
        }
        String str2 = c0235a.f19744d ? c0235a.f19747g ? "writeAsArrayNonContext" : "writeAsArray" : "writeAsArrayNormal";
        int i8 = c0235a.f19743c.f19754g;
        f0 f0Var = f0.BeanToArray;
        if ((i8 & f0Var.f19849a) == 0) {
            n0.f fVar6 = new n0.f();
            hVar2.g(25, c0235a.g("out"));
            hVar2.k(Integer.valueOf(f0Var.f19849a));
            hVar2.i(182, f19730f, "isEnabled", "(I)Z");
            hVar2.h(153, fVar6);
            hVar2.g(25, 0);
            hVar2.g(25, 1);
            hVar2.g(25, 2);
            hVar2.g(25, 3);
            hVar2.g(25, 4);
            hVar2.g(21, 5);
            hVar2.i(182, c0235a.f19742b, str2, "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar2.e(177);
            hVar2.l(fVar6);
        } else {
            hVar2.g(25, 0);
            hVar2.g(25, 1);
            hVar2.g(25, 2);
            hVar2.g(25, 3);
            hVar2.g(25, 4);
            hVar2.g(21, 5);
            hVar2.i(182, c0235a.f19742b, str2, "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar2.e(177);
        }
        if (!c0235a.f19747g) {
            hVar2.g(25, 1);
            String str3 = f19727c;
            StringBuilder sb = new StringBuilder();
            sb.append("()");
            String str4 = f19734j;
            sb.append(str4);
            hVar2.i(182, str3, "getContext", sb.toString());
            hVar2.g(58, c0235a.g("parent"));
            hVar2.g(25, 1);
            hVar2.g(25, c0235a.g("parent"));
            hVar2.g(25, 2);
            hVar2.g(25, 3);
            hVar2.k(Integer.valueOf(c0235a.f19743c.f19754g));
            hVar2.i(182, str3, "setContext", "(" + str4 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z5 = (c0235a.f19743c.f19754g & f0.WriteClassName.f19849a) != 0;
        if (z5 || !c0235a.f19744d) {
            n0.f fVar7 = new n0.f();
            n0.f fVar8 = new n0.f();
            n0.f fVar9 = new n0.f();
            if (z5) {
                str = "parent";
                i5 = 182;
            } else {
                hVar2.g(25, 1);
                hVar2.g(25, 4);
                hVar2.g(25, 2);
                str = "parent";
                i5 = 182;
                hVar2.i(182, f19727c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                hVar2.h(153, fVar8);
            }
            hVar2.g(25, 4);
            hVar2.g(25, 2);
            hVar2.i(i5, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar2.h(165, fVar8);
            hVar2.l(fVar9);
            hVar2.g(25, c0235a.g("out"));
            hVar2.g(16, 123);
            hVar2.i(i5, f19730f, "write", "(I)V");
            hVar2.g(25, 0);
            hVar2.g(25, 1);
            if (c0235a.f19743c.f19750c != null) {
                hVar2.k(c0235a.f19743c.f19750c);
            } else {
                hVar2.e(1);
            }
            hVar2.g(25, 2);
            hVar2.i(182, f19732h, "writeClassName", "(L" + f19727c + ";Ljava/lang/String;Ljava/lang/Object;)V");
            hVar2.g(16, 44);
            hVar2.h(167, fVar7);
            hVar2.l(fVar8);
            hVar2.g(16, 123);
            hVar2.l(fVar7);
        } else {
            hVar2.g(16, 123);
            str = "parent";
        }
        hVar2.g(54, c0235a.g("seperator"));
        if (!c0235a.f19744d) {
            c0954a.c(hVar2, c0235a);
        }
        if (c0235a.f19744d) {
            i6 = 0;
        } else {
            hVar2.g(25, c0235a.g("out"));
            hVar2.i(182, f19730f, "isNotWriteDefaultValue", "()Z");
            hVar2.g(54, c0235a.g("notWriteDefaultValue"));
            hVar2.g(25, 1);
            hVar2.g(25, 0);
            String str5 = f19727c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            String str6 = f19735k;
            sb2.append(str6);
            sb2.append(")Z");
            hVar2.i(182, str5, "checkValue", sb2.toString());
            hVar2.g(54, c0235a.g("checkValue"));
            hVar2.g(25, 1);
            i6 = 0;
            hVar2.g(25, 0);
            hVar2.i(182, str5, "hasNameFilters", "(" + str6 + ")Z");
            hVar2.g(54, c0235a.g("hasNameFilters"));
        }
        int i9 = i6;
        while (i9 < length) {
            C1154d c1154d = c1154dArr[i9];
            Class<?> cls3 = c1154d.f22734e;
            hVar2.k(c1154d.f22730a);
            hVar2.g(58, C0235a.f19738h);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                c0954a.m(cls2, hVar2, c1154d, c0235a, c0235a.g(cls3.getName()), 'I');
            } else if (cls3 == Long.TYPE) {
                c0954a.p(cls2, hVar2, c1154d, c0235a);
            } else if (cls3 == Float.TYPE) {
                c0954a.h(cls2, hVar2, c1154d, c0235a);
            } else if (cls3 == Double.TYPE) {
                c0954a.e(cls2, hVar2, c1154d, c0235a);
            } else if (cls3 == Boolean.TYPE) {
                c0954a.m(cls2, hVar2, c1154d, c0235a, c0235a.g("boolean"), 'Z');
                c0954a = this;
                hVar2 = hVar;
            } else if (cls3 == Character.TYPE) {
                c0954a = this;
                hVar2 = hVar;
                c0954a.m(cls, hVar2, c1154d, c0235a, c0235a.g("char"), 'C');
            } else {
                c0954a = this;
                hVar2 = hVar;
                if (cls3 == String.class) {
                    c0954a.w(cls, hVar2, c1154d, c0235a);
                } else if (cls3 == BigDecimal.class) {
                    c0954a.d(cls, hVar2, c1154d, c0235a);
                } else if (List.class.isAssignableFrom(cls3)) {
                    c0954a.o(cls, hVar2, c1154d, c0235a);
                } else if (cls3.isEnum()) {
                    c0954a.f(cls, hVar2, c1154d, c0235a);
                } else {
                    c0954a.s(cls, hVar2, c1154d, c0235a);
                }
            }
            i9++;
            cls2 = cls;
        }
        if (!c0235a.f19744d) {
            c0954a.a(hVar2, c0235a);
        }
        n0.f fVar10 = new n0.f();
        n0.f fVar11 = new n0.f();
        hVar2.g(21, c0235a.g("seperator"));
        hVar2.d(16, 123);
        hVar2.h(160, fVar10);
        hVar2.g(25, c0235a.g("out"));
        hVar2.g(16, 123);
        String str7 = f19730f;
        hVar2.i(182, str7, "write", "(I)V");
        hVar2.l(fVar10);
        hVar2.g(25, c0235a.g("out"));
        hVar2.g(16, 125);
        hVar2.i(182, str7, "write", "(I)V");
        hVar2.l(fVar11);
        hVar2.l(fVar);
        if (c0235a.f19747g) {
            return;
        }
        hVar2.g(25, 1);
        hVar2.g(25, c0235a.g(str));
        hVar2.i(182, f19727c, "setContext", "(" + f19734j + ")V");
    }

    private void a(n0.h hVar, C0235a c0235a) {
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.g(25, 2);
        hVar.g(21, c0235a.g("seperator"));
        hVar.i(182, f19732h, "writeAfter", "(L" + f19727c + ";Ljava/lang/Object;C)C");
        hVar.g(54, c0235a.g("seperator"));
    }

    private void b(n0.h hVar, C1154d c1154d, C0235a c0235a) {
        Class<?> cls = c1154d.f22734e;
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.g(25, 2);
        hVar.g(25, C0235a.f19738h);
        if (cls == Byte.TYPE) {
            hVar.g(21, c0235a.g("byte"));
            hVar.i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.g(21, c0235a.g("short"));
            hVar.i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.g(21, c0235a.g("int"));
            hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.g(21, c0235a.g("char"));
            hVar.i(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.g(22, c0235a.h("long", 2));
            hVar.i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.g(23, c0235a.g("float"));
            hVar.i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.g(24, c0235a.h("double", 2));
            hVar.i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.g(21, c0235a.g("boolean"));
            hVar.i(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.g(25, c0235a.g("decimal"));
        } else if (cls == String.class) {
            hVar.g(25, c0235a.g("string"));
        } else if (cls.isEnum()) {
            hVar.g(25, c0235a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.g(25, c0235a.g("list"));
        } else {
            hVar.g(25, c0235a.g("object"));
        }
        hVar.i(182, f19732h, "apply", "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void c(n0.h hVar, C0235a c0235a) {
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.g(25, 2);
        hVar.g(21, c0235a.g("seperator"));
        hVar.i(182, f19732h, "writeBefore", "(L" + f19727c + ";Ljava/lang/Object;C)C");
        hVar.g(54, c0235a.g("seperator"));
    }

    private void d(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(58, c0235a.g("decimal"));
        g(hVar, c1154d, c0235a, fVar);
        n0.f fVar2 = new n0.f();
        n0.f fVar3 = new n0.f();
        n0.f fVar4 = new n0.f();
        hVar.l(fVar2);
        hVar.g(25, c0235a.g("decimal"));
        hVar.h(199, fVar3);
        l(hVar, c1154d, c0235a);
        hVar.h(167, fVar4);
        hVar.l(fVar3);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        hVar.g(25, C0235a.f19738h);
        hVar.g(25, c0235a.g("decimal"));
        hVar.i(182, f19730f, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        v(hVar, c0235a);
        hVar.h(167, fVar4);
        hVar.l(fVar4);
        hVar.l(fVar);
    }

    private void e(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(57, c0235a.h("double", 2));
        g(hVar, c1154d, c0235a, fVar);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        hVar.g(25, C0235a.f19738h);
        hVar.g(24, c0235a.h("double", 2));
        hVar.i(182, f19730f, "writeFieldValue", "(CLjava/lang/String;D)V");
        v(hVar, c0235a);
        hVar.l(fVar);
    }

    private void f(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        n0.f fVar2 = new n0.f();
        n0.f fVar3 = new n0.f();
        q(hVar, c1154d, c0235a, fVar3);
        i(hVar, c0235a, c1154d);
        hVar.b(192, "java/lang/Enum");
        hVar.g(58, c0235a.g("enum"));
        g(hVar, c1154d, c0235a, fVar3);
        hVar.g(25, c0235a.g("enum"));
        hVar.h(199, fVar);
        l(hVar, c1154d, c0235a);
        hVar.h(167, fVar2);
        hVar.l(fVar);
        if (c0235a.f19744d) {
            hVar.g(25, c0235a.g("out"));
            hVar.g(21, c0235a.g("seperator"));
            hVar.g(25, C0235a.f19738h);
            hVar.g(25, c0235a.g("enum"));
            hVar.i(182, "java/lang/Enum", Minor.COLUMN_NAME, "()Ljava/lang/String;");
            hVar.i(182, f19730f, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.g(25, c0235a.g("out"));
            hVar.g(21, c0235a.g("seperator"));
            String str = f19730f;
            hVar.i(182, str, "write", "(I)V");
            hVar.g(25, c0235a.g("out"));
            hVar.g(25, C0235a.f19738h);
            hVar.e(3);
            hVar.i(182, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            hVar.g(25, 1);
            hVar.g(25, c0235a.g("enum"));
            hVar.g(25, C0235a.f19738h);
            hVar.k(n0.j.g(C1152b.b(c1154d.f22734e)));
            hVar.k(Integer.valueOf(c1154d.f22738i));
            hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        v(hVar, c0235a);
        hVar.l(fVar2);
        hVar.l(fVar3);
    }

    private void g(n0.h hVar, C1154d c1154d, C0235a c0235a, n0.f fVar) {
        if (c1154d.f22744o) {
            hVar.g(25, c0235a.g("out"));
            hVar.k(Integer.valueOf(f0.SkipTransientField.f19849a));
            hVar.i(182, f19730f, "isEnabled", "(I)Z");
            hVar.h(154, fVar);
        }
        r(hVar, c1154d, c0235a, fVar);
        if (c0235a.f19744d) {
            return;
        }
        b(hVar, c1154d, c0235a);
        hVar.h(153, fVar);
        t(hVar, c1154d, c0235a);
        u(hVar, c1154d, c0235a, fVar);
    }

    private void h(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(56, c0235a.g("float"));
        g(hVar, c1154d, c0235a, fVar);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        hVar.g(25, C0235a.f19738h);
        hVar.g(23, c0235a.g("float"));
        hVar.i(182, f19730f, "writeFieldValue", "(CLjava/lang/String;F)V");
        v(hVar, c0235a);
        hVar.l(fVar);
    }

    private void i(n0.h hVar, C0235a c0235a, C1154d c1154d) {
        Method method = c1154d.f22731b;
        if (method != null) {
            hVar.g(25, c0235a.g("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            hVar.i(declaringClass.isInterface() ? 185 : 182, C1152b.g(declaringClass), method.getName(), C1152b.c(method));
            if (method.getReturnType().equals(c1154d.f22734e)) {
                return;
            }
            hVar.b(192, C1152b.g(c1154d.f22734e));
            return;
        }
        hVar.g(25, c0235a.g("entity"));
        Field field = c1154d.f22732c;
        hVar.c(180, C1152b.g(c1154d.f22736g), field.getName(), C1152b.b(field.getType()));
        if (field.getType().equals(c1154d.f22734e)) {
            return;
        }
        hVar.b(192, C1152b.g(c1154d.f22734e));
    }

    private void j(C0235a c0235a, n0.h hVar, C1154d c1154d) {
        n0.f fVar = new n0.f();
        hVar.g(25, 0);
        String str = c0235a.f19742b;
        String str2 = c1154d.f22730a + "_asm_ser_";
        String str3 = f19729e;
        hVar.c(180, str, str2, str3);
        hVar.h(199, fVar);
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.k(n0.j.g(C1152b.b(c1154d.f22734e)));
        hVar.i(182, f19727c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.c(181, c0235a.f19742b, c1154d.f22730a + "_asm_ser_", str3);
        hVar.l(fVar);
        hVar.g(25, 0);
        hVar.c(180, c0235a.f19742b, c1154d.f22730a + "_asm_ser_", str3);
    }

    private void k(C0235a c0235a, n0.h hVar, C1154d c1154d, Class<?> cls) {
        n0.f fVar = new n0.f();
        hVar.g(25, 0);
        String str = c0235a.f19742b;
        String str2 = c1154d.f22730a + "_asm_list_item_ser_";
        String str3 = f19729e;
        hVar.c(180, str, str2, str3);
        hVar.h(199, fVar);
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.k(n0.j.g(C1152b.b(cls)));
        hVar.i(182, f19727c, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.c(181, c0235a.f19742b, c1154d.f22730a + "_asm_list_item_ser_", str3);
        hVar.l(fVar);
        hVar.g(25, 0);
        hVar.c(180, c0235a.f19742b, c1154d.f22730a + "_asm_list_item_ser_", str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l(n0.h r18, u0.C1154d r19, q0.C0954a.C0235a r20) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.C0954a.l(n0.h, u0.d, q0.a$a):void");
    }

    private void m(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a, int i5, char c6) {
        n0.f fVar = new n0.f();
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(54, i5);
        g(hVar, c1154d, c0235a, fVar);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        hVar.g(25, C0235a.f19738h);
        hVar.g(21, i5);
        hVar.i(182, f19730f, "writeFieldValue", "(CLjava/lang/String;" + c6 + ")V");
        v(hVar, c0235a);
        hVar.l(fVar);
    }

    private void n(n0.h hVar, C1154d c1154d, C0235a c0235a, n0.f fVar) {
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.k(c1154d.f22740k);
        hVar.i(182, f19732h, "applyLabel", "(L" + f19727c + ";Ljava/lang/String;)Z");
        hVar.h(153, fVar);
    }

    private void o(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar;
        n0.f fVar2;
        n0.f fVar3;
        Class<?> cls2;
        String str;
        n0.f fVar4;
        n0.f fVar5;
        C1154d c1154d2;
        n0.f fVar6;
        int i5;
        int i6;
        int i7;
        n0.f fVar7;
        n0.f fVar8;
        Type typeU = u0.o.U(c1154d.f22735f);
        Class<?> cls3 = null;
        Class<?> cls4 = typeU instanceof Class ? (Class) typeU : null;
        if (cls4 != Object.class && cls4 != Serializable.class) {
            cls3 = cls4;
        }
        n0.f fVar9 = new n0.f();
        n0.f fVar10 = new n0.f();
        n0.f fVar11 = new n0.f();
        q(hVar, c1154d, c0235a, fVar9);
        i(hVar, c0235a, c1154d);
        hVar.b(192, "java/util/List");
        hVar.g(58, c0235a.g("list"));
        g(hVar, c1154d, c0235a, fVar9);
        hVar.g(25, c0235a.g("list"));
        hVar.h(199, fVar10);
        l(hVar, c1154d, c0235a);
        hVar.h(167, fVar11);
        hVar.l(fVar10);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        String str2 = f19730f;
        hVar.i(182, str2, "write", "(I)V");
        x(hVar, c0235a);
        hVar.g(25, c0235a.g("list"));
        hVar.i(185, "java/util/List", "size", "()I");
        hVar.g(54, c0235a.g("size"));
        n0.f fVar12 = new n0.f();
        n0.f fVar13 = new n0.f();
        hVar.g(21, c0235a.g("size"));
        hVar.e(3);
        hVar.h(160, fVar12);
        hVar.g(25, c0235a.g("out"));
        hVar.k("[]");
        hVar.i(182, str2, "write", "(Ljava/lang/String;)V");
        hVar.h(167, fVar13);
        hVar.l(fVar12);
        if (c0235a.f19747g) {
            fVar = fVar13;
        } else {
            hVar.g(25, 1);
            hVar.g(25, c0235a.g("list"));
            hVar.g(25, C0235a.f19738h);
            fVar = fVar13;
            hVar.i(182, f19727c, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (typeU == String.class && c0235a.f19744d) {
            i6 = 25;
            hVar.g(25, c0235a.g("out"));
            hVar.g(25, c0235a.g("list"));
            i7 = 182;
            hVar.i(182, str2, "write", "(Ljava/util/List;)V");
            i5 = 1;
        } else {
            hVar.g(25, c0235a.g("out"));
            hVar.g(16, 91);
            hVar.i(182, str2, "write", "(I)V");
            n0.f fVar14 = new n0.f();
            n0.f fVar15 = new n0.f();
            n0.f fVar16 = new n0.f();
            hVar.e(3);
            hVar.g(54, c0235a.g("i"));
            hVar.l(fVar14);
            hVar.g(21, c0235a.g("i"));
            hVar.g(21, c0235a.g("size"));
            hVar.h(162, fVar16);
            hVar.g(21, c0235a.g("i"));
            hVar.h(153, fVar15);
            hVar.g(25, c0235a.g("out"));
            hVar.g(16, 44);
            hVar.i(182, str2, "write", "(I)V");
            hVar.l(fVar15);
            hVar.g(25, c0235a.g("list"));
            hVar.g(21, c0235a.g("i"));
            hVar.i(185, "java/util/List", "get", "(I)Ljava/lang/Object;");
            hVar.g(58, c0235a.g("list_item"));
            n0.f fVar17 = new n0.f();
            n0.f fVar18 = new n0.f();
            hVar.g(25, c0235a.g("list_item"));
            hVar.h(199, fVar18);
            hVar.g(25, c0235a.g("out"));
            hVar.i(182, str2, "writeNull", "()V");
            hVar.h(167, fVar17);
            hVar.l(fVar18);
            n0.f fVar19 = new n0.f();
            n0.f fVar20 = new n0.f();
            if (cls3 == null || !Modifier.isPublic(cls3.getModifiers())) {
                fVar2 = fVar14;
                fVar3 = fVar17;
                cls2 = cls3;
                str = "out";
                fVar4 = fVar19;
                fVar5 = fVar16;
                c1154d2 = c1154d;
                fVar6 = fVar20;
            } else {
                str = "out";
                hVar.g(25, c0235a.g("list_item"));
                fVar5 = fVar16;
                fVar2 = fVar14;
                hVar.i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                hVar.k(n0.j.g(C1152b.b(cls3)));
                hVar.h(166, fVar20);
                c1154d2 = c1154d;
                k(c0235a, hVar, c1154d2, cls3);
                cls2 = cls3;
                hVar.g(58, c0235a.g("list_item_desc"));
                n0.f fVar21 = new n0.f();
                n0.f fVar22 = new n0.f();
                if (c0235a.f19744d) {
                    String str3 = (c0235a.f19747g && c0235a.f19744d) ? "writeDirectNonContext" : "write";
                    fVar3 = fVar17;
                    fVar8 = fVar20;
                    hVar.g(25, c0235a.g("list_item_desc"));
                    String str4 = f19732h;
                    hVar.b(193, str4);
                    hVar.h(153, fVar21);
                    fVar7 = fVar19;
                    hVar.g(25, c0235a.g("list_item_desc"));
                    hVar.b(192, str4);
                    hVar.g(25, 1);
                    hVar.g(25, c0235a.g("list_item"));
                    if (c0235a.f19747g) {
                        hVar.e(1);
                    } else {
                        hVar.g(21, c0235a.g("i"));
                        hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    hVar.k(n0.j.g(C1152b.b(cls2)));
                    hVar.k(Integer.valueOf(c1154d2.f22738i));
                    hVar.i(182, str4, str3, "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    hVar.h(167, fVar22);
                    hVar.l(fVar21);
                } else {
                    fVar3 = fVar17;
                    fVar7 = fVar19;
                    fVar8 = fVar20;
                }
                hVar.g(25, c0235a.g("list_item_desc"));
                hVar.g(25, 1);
                hVar.g(25, c0235a.g("list_item"));
                if (c0235a.f19747g) {
                    hVar.e(1);
                } else {
                    hVar.g(21, c0235a.g("i"));
                    hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                hVar.k(n0.j.g(C1152b.b(cls2)));
                hVar.k(Integer.valueOf(c1154d2.f22738i));
                hVar.i(185, f19728d, "write", "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                hVar.l(fVar22);
                fVar4 = fVar7;
                hVar.h(167, fVar4);
                fVar6 = fVar8;
            }
            hVar.l(fVar6);
            hVar.g(25, 1);
            hVar.g(25, c0235a.g("list_item"));
            if (c0235a.f19747g) {
                hVar.e(1);
            } else {
                hVar.g(21, c0235a.g("i"));
                hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                hVar.k(n0.j.g(C1152b.b((Class) typeU)));
                hVar.k(Integer.valueOf(c1154d2.f22738i));
                hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            hVar.l(fVar4);
            hVar.l(fVar3);
            i5 = 1;
            hVar.a(c0235a.g("i"), 1);
            hVar.h(167, fVar2);
            hVar.l(fVar5);
            i6 = 25;
            hVar.g(25, c0235a.g(str));
            hVar.g(16, 93);
            i7 = 182;
            hVar.i(182, str2, "write", "(I)V");
        }
        hVar.g(i6, i5);
        hVar.i(i7, f19727c, "popContext", "()V");
        hVar.l(fVar);
        v(hVar, c0235a);
        hVar.l(fVar11);
        hVar.l(fVar9);
    }

    private void p(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(55, c0235a.h("long", 2));
        g(hVar, c1154d, c0235a, fVar);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        hVar.g(25, C0235a.f19738h);
        hVar.g(22, c0235a.h("long", 2));
        hVar.i(182, f19730f, "writeFieldValue", "(CLjava/lang/String;J)V");
        v(hVar, c0235a);
        hVar.l(fVar);
    }

    private void q(n0.h hVar, C1154d c1154d, C0235a c0235a, n0.f fVar) {
        if (!c0235a.f19744d) {
            hVar.g(25, 0);
            hVar.g(25, 1);
            hVar.g(25, 2);
            hVar.g(25, C0235a.f19738h);
            hVar.i(182, f19732h, "applyName", "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            hVar.h(153, fVar);
            n(hVar, c1154d, c0235a, fVar);
        }
        if (c1154d.f22732c == null) {
            hVar.g(25, c0235a.g("out"));
            hVar.k(Integer.valueOf(f0.IgnoreNonFieldGetter.f19849a));
            hVar.i(182, f19730f, "isEnabled", "(I)Z");
            hVar.h(154, fVar);
        }
    }

    private void r(n0.h hVar, C1154d c1154d, C0235a c0235a, n0.f fVar) {
        if (c0235a.f19744d) {
            return;
        }
        n0.f fVar2 = new n0.f();
        hVar.g(21, c0235a.g("notWriteDefaultValue"));
        hVar.h(153, fVar2);
        Class<?> cls = c1154d.f22734e;
        if (cls == Boolean.TYPE) {
            hVar.g(21, c0235a.g("boolean"));
            hVar.h(153, fVar);
        } else if (cls == Byte.TYPE) {
            hVar.g(21, c0235a.g("byte"));
            hVar.h(153, fVar);
        } else if (cls == Short.TYPE) {
            hVar.g(21, c0235a.g("short"));
            hVar.h(153, fVar);
        } else if (cls == Integer.TYPE) {
            hVar.g(21, c0235a.g("int"));
            hVar.h(153, fVar);
        } else if (cls == Long.TYPE) {
            hVar.g(22, c0235a.g("long"));
            hVar.e(9);
            hVar.e(148);
            hVar.h(153, fVar);
        } else if (cls == Float.TYPE) {
            hVar.g(23, c0235a.g("float"));
            hVar.e(11);
            hVar.e(149);
            hVar.h(153, fVar);
        } else if (cls == Double.TYPE) {
            hVar.g(24, c0235a.g("double"));
            hVar.e(14);
            hVar.e(151);
            hVar.h(153, fVar);
        }
        hVar.l(fVar2);
    }

    private void s(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(58, c0235a.g("object"));
        g(hVar, c1154d, c0235a, fVar);
        y(hVar, c1154d, c0235a, fVar);
        hVar.l(fVar);
    }

    private void t(n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        hVar.g(21, c0235a.g("hasNameFilters"));
        hVar.h(153, fVar);
        Class<?> cls = c1154d.f22734e;
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.g(25, 2);
        hVar.g(25, C0235a.f19738h);
        if (cls == Byte.TYPE) {
            hVar.g(21, c0235a.g("byte"));
            hVar.i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.g(21, c0235a.g("short"));
            hVar.i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.g(21, c0235a.g("int"));
            hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.g(21, c0235a.g("char"));
            hVar.i(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.g(22, c0235a.h("long", 2));
            hVar.i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.g(23, c0235a.g("float"));
            hVar.i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.g(24, c0235a.h("double", 2));
            hVar.i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.g(21, c0235a.g("boolean"));
            hVar.i(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.g(25, c0235a.g("decimal"));
        } else if (cls == String.class) {
            hVar.g(25, c0235a.g("string"));
        } else if (cls.isEnum()) {
            hVar.g(25, c0235a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.g(25, c0235a.g("list"));
        } else {
            hVar.g(25, c0235a.g("object"));
        }
        hVar.i(182, f19732h, "processKey", "(L" + f19727c + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        hVar.g(58, C0235a.f19738h);
        hVar.l(fVar);
    }

    private void u(n0.h hVar, C1154d c1154d, C0235a c0235a, n0.f fVar) {
        n0.f fVar2 = new n0.f();
        Class<?> cls = c1154d.f22734e;
        if (cls.isPrimitive()) {
            n0.f fVar3 = new n0.f();
            hVar.g(21, c0235a.g("checkValue"));
            hVar.h(154, fVar3);
            hVar.e(1);
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
            hVar.g(58, C0235a.f19740j);
            hVar.h(167, fVar2);
            hVar.l(fVar3);
        }
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.g(25, 0);
        hVar.k(Integer.valueOf(c0235a.f(c1154d.f22730a)));
        String str = f19732h;
        hVar.i(182, str, "getBeanContext", "(I)" + C1152b.b(C0963j.class));
        hVar.g(25, 2);
        hVar.g(25, C0235a.f19738h);
        if (cls == Byte.TYPE) {
            hVar.g(21, c0235a.g("byte"));
            hVar.i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Short.TYPE) {
            hVar.g(21, c0235a.g("short"));
            hVar.i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Integer.TYPE) {
            hVar.g(21, c0235a.g("int"));
            hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Character.TYPE) {
            hVar.g(21, c0235a.g("char"));
            hVar.i(184, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Long.TYPE) {
            hVar.g(22, c0235a.h("long", 2));
            hVar.i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Float.TYPE) {
            hVar.g(23, c0235a.g("float"));
            hVar.i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Double.TYPE) {
            hVar.g(24, c0235a.h("double", 2));
            hVar.i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == Boolean.TYPE) {
            hVar.g(21, c0235a.g("boolean"));
            hVar.i(184, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            hVar.e(89);
            hVar.g(58, C0235a.f19739i);
        } else if (cls == BigDecimal.class) {
            hVar.g(25, c0235a.g("decimal"));
            hVar.g(58, C0235a.f19739i);
            hVar.g(25, C0235a.f19739i);
        } else if (cls == String.class) {
            hVar.g(25, c0235a.g("string"));
            hVar.g(58, C0235a.f19739i);
            hVar.g(25, C0235a.f19739i);
        } else if (cls.isEnum()) {
            hVar.g(25, c0235a.g("enum"));
            hVar.g(58, C0235a.f19739i);
            hVar.g(25, C0235a.f19739i);
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.g(25, c0235a.g("list"));
            hVar.g(58, C0235a.f19739i);
            hVar.g(25, C0235a.f19739i);
        } else {
            hVar.g(25, c0235a.g("object"));
            hVar.g(58, C0235a.f19739i);
            hVar.g(25, C0235a.f19739i);
        }
        hVar.i(182, str, "processValue", "(L" + f19727c + ";" + C1152b.b(C0963j.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.g(58, C0235a.f19740j);
        hVar.g(25, C0235a.f19739i);
        hVar.g(25, C0235a.f19740j);
        hVar.h(165, fVar2);
        y(hVar, c1154d, c0235a, fVar);
        hVar.h(167, fVar);
        hVar.l(fVar2);
    }

    private void v(n0.h hVar, C0235a c0235a) {
        hVar.g(16, 44);
        hVar.g(54, c0235a.g("seperator"));
    }

    private void w(Class<?> cls, n0.h hVar, C1154d c1154d, C0235a c0235a) {
        n0.f fVar = new n0.f();
        if (c1154d.f22730a.equals(c0235a.f19743c.f19750c)) {
            hVar.g(25, 1);
            hVar.g(25, 4);
            hVar.g(25, 2);
            hVar.i(182, f19727c, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            hVar.h(154, fVar);
        }
        q(hVar, c1154d, c0235a, fVar);
        i(hVar, c0235a, c1154d);
        hVar.g(58, c0235a.g("string"));
        g(hVar, c1154d, c0235a, fVar);
        n0.f fVar2 = new n0.f();
        n0.f fVar3 = new n0.f();
        hVar.g(25, c0235a.g("string"));
        hVar.h(199, fVar2);
        l(hVar, c1154d, c0235a);
        hVar.h(167, fVar3);
        hVar.l(fVar2);
        if ("trim".equals(c1154d.f22749t)) {
            hVar.g(25, c0235a.g("string"));
            hVar.i(182, "java/lang/String", "trim", "()Ljava/lang/String;");
            hVar.g(58, c0235a.g("string"));
        }
        if (c0235a.f19744d) {
            hVar.g(25, c0235a.g("out"));
            hVar.g(21, c0235a.g("seperator"));
            hVar.g(25, C0235a.f19738h);
            hVar.g(25, c0235a.g("string"));
            hVar.i(182, f19730f, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.g(25, c0235a.g("out"));
            hVar.g(21, c0235a.g("seperator"));
            hVar.g(25, C0235a.f19738h);
            hVar.g(25, c0235a.g("string"));
            hVar.i(182, f19730f, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        v(hVar, c0235a);
        hVar.l(fVar3);
        hVar.l(fVar);
    }

    private void x(n0.h hVar, C0235a c0235a) {
        if (c0235a.f19744d) {
            hVar.g(25, c0235a.g("out"));
            hVar.g(25, C0235a.f19738h);
            hVar.i(182, f19730f, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            hVar.g(25, c0235a.g("out"));
            hVar.g(25, C0235a.f19738h);
            hVar.e(3);
            hVar.i(182, f19730f, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void y(n0.h hVar, C1154d c1154d, C0235a c0235a, n0.f fVar) {
        String str;
        n0.f fVar2;
        n0.f fVar3;
        String strM = c1154d.m();
        Class<?> cls = c1154d.f22734e;
        n0.f fVar4 = new n0.f();
        if (c0235a.f19744d) {
            hVar.g(25, c0235a.g("object"));
        } else {
            hVar.g(25, C0235a.f19740j);
        }
        hVar.e(89);
        hVar.g(58, c0235a.g("object"));
        hVar.h(199, fVar4);
        l(hVar, c1154d, c0235a);
        hVar.h(167, fVar);
        hVar.l(fVar4);
        hVar.g(25, c0235a.g("out"));
        hVar.g(21, c0235a.g("seperator"));
        hVar.i(182, f19730f, "write", "(I)V");
        x(hVar, c0235a);
        n0.f fVar5 = new n0.f();
        n0.f fVar6 = new n0.f();
        if (!Modifier.isPublic(cls.getModifiers()) || C0896i.v(cls)) {
            str = strM;
            fVar2 = fVar5;
            fVar3 = fVar6;
        } else {
            hVar.g(25, c0235a.g("object"));
            hVar.i(182, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.k(n0.j.g(C1152b.b(cls)));
            hVar.h(166, fVar6);
            j(c0235a, hVar, c1154d);
            hVar.g(58, c0235a.g("fied_ser"));
            n0.f fVar7 = new n0.f();
            n0.f fVar8 = new n0.f();
            hVar.g(25, c0235a.g("fied_ser"));
            String str2 = f19732h;
            hVar.b(193, str2);
            hVar.h(153, fVar7);
            int i5 = c1154d.f22738i;
            boolean z5 = (i5 & f0.DisableCircularReferenceDetect.f19849a) != 0;
            boolean z6 = (i5 & f0.BeanToArray.f19849a) != 0;
            String str3 = (z5 || (c0235a.f19747g && c0235a.f19744d)) ? z6 ? "writeAsArrayNonContext" : "writeDirectNonContext" : z6 ? "writeAsArray" : "write";
            str = strM;
            hVar.g(25, c0235a.g("fied_ser"));
            hVar.b(192, str2);
            hVar.g(25, 1);
            hVar.g(25, c0235a.g("object"));
            hVar.g(25, C0235a.f19738h);
            hVar.g(25, 0);
            hVar.c(180, c0235a.f19742b, c1154d.f22730a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.k(Integer.valueOf(c1154d.f22738i));
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            String str4 = f19727c;
            sb.append(str4);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.i(182, str2, str3, sb.toString());
            hVar.h(167, fVar8);
            hVar.l(fVar7);
            hVar.g(25, c0235a.g("fied_ser"));
            hVar.g(25, 1);
            hVar.g(25, c0235a.g("object"));
            hVar.g(25, C0235a.f19738h);
            hVar.g(25, 0);
            hVar.c(180, c0235a.f19742b, c1154d.f22730a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.k(Integer.valueOf(c1154d.f22738i));
            hVar.i(185, f19728d, "write", "(L" + str4 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.l(fVar8);
            fVar2 = fVar5;
            hVar.h(167, fVar2);
            fVar3 = fVar6;
        }
        hVar.l(fVar3);
        hVar.g(25, 1);
        if (c0235a.f19744d) {
            hVar.g(25, c0235a.g("object"));
        } else {
            hVar.g(25, C0235a.f19740j);
        }
        if (str != null) {
            hVar.k(str);
            hVar.i(182, f19727c, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            hVar.g(25, C0235a.f19738h);
            Type type = c1154d.f22735f;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (c1154d.f22734e == String.class) {
                    hVar.k(n0.j.g(C1152b.b(String.class)));
                } else {
                    hVar.g(25, 0);
                    hVar.c(180, c0235a.f19742b, c1154d.f22730a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                hVar.k(Integer.valueOf(c1154d.f22738i));
                hVar.i(182, f19727c, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        hVar.l(fVar2);
        v(hVar, c0235a);
    }

    public C0947J z(a0 a0Var) {
        String str;
        boolean z5;
        Class<a0> cls;
        String str2;
        int i5;
        n0.c cVar;
        String str3;
        int i6;
        boolean z6;
        boolean z7;
        String str4;
        boolean z8;
        boolean z9;
        boolean z10;
        String str5;
        C1154d[] c1154dArr;
        n0.c cVar2;
        int i7;
        char c6;
        C1154d[] c1154dArr2;
        int i8;
        String str6;
        Method method;
        Class<?> cls2 = a0Var.f19748a;
        if (cls2.isPrimitive()) {
            throw new l0.d("unsupportd class " + cls2.getName());
        }
        InterfaceC0856d interfaceC0856d = (InterfaceC0856d) u0.o.M(cls2, InterfaceC0856d.class);
        C1154d[] c1154dArr3 = a0Var.f19752e;
        for (C1154d c1154d : c1154dArr3) {
            if (c1154d.f22732c == null && (method = c1154d.f22731b) != null && method.getDeclaringClass().isInterface()) {
                return new C0947J(a0Var);
            }
        }
        C1154d[] c1154dArr4 = a0Var.f19753f;
        boolean z11 = c1154dArr4 == a0Var.f19752e;
        if (c1154dArr4.length > 256) {
            return new C0947J(a0Var);
        }
        for (C1154d c1154d2 : c1154dArr4) {
            if (!C1152b.a(c1154d2.o().getName())) {
                return new C0947J(a0Var);
            }
        }
        String str7 = "ASMSerializer_" + this.f19737b.incrementAndGet() + "_" + cls2.getSimpleName();
        Package r42 = C0954a.class.getPackage();
        if (r42 != null) {
            String name = r42.getName();
            String str8 = name.replace('.', '/') + "/" + str7;
            str7 = name + "." + str7;
            str = str8;
        } else {
            str = str7;
        }
        n0.c cVar3 = new n0.c();
        cVar3.k(49, 33, str, f19732h, new String[]{f19728d});
        n0.c cVar4 = cVar3;
        int length = c1154dArr4.length;
        int i9 = 0;
        while (i9 < length) {
            C1154d c1154d3 = c1154dArr4[i9];
            if (c1154d3.f22734e.isPrimitive() || c1154d3.f22734e == String.class) {
                str6 = str7;
            } else {
                StringBuilder sb = new StringBuilder();
                str6 = str7;
                sb.append(c1154d3.f22730a);
                sb.append("_asm_fieldType");
                new n0.d(cVar4, 1, sb.toString(), "Ljava/lang/reflect/Type;").c();
                if (List.class.isAssignableFrom(c1154d3.f22734e)) {
                    new n0.d(cVar4, 1, c1154d3.f22730a + "_asm_list_item_ser_", f19729e).c();
                }
                new n0.d(cVar4, 1, c1154d3.f22730a + "_asm_ser_", f19729e).c();
            }
            i9++;
            str7 = str6;
        }
        String str9 = str7;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        Class<a0> cls3 = a0.class;
        sb2.append(C1152b.b(cls3));
        sb2.append(")V");
        n0.i iVar = new n0.i(cVar4, 1, "<init>", sb2.toString(), null, null);
        iVar.g(25, 0);
        iVar.g(25, 1);
        iVar.i(183, f19732h, "<init>", "(" + C1152b.b(cls3) + ")V");
        int i10 = 0;
        while (i10 < c1154dArr4.length) {
            C1154d c1154d4 = c1154dArr4[i10];
            if (c1154d4.f22734e.isPrimitive() || c1154d4.f22734e == String.class) {
                c1154dArr2 = c1154dArr4;
                i8 = i10;
            } else {
                iVar.g(25, 0);
                if (c1154d4.f22731b != null) {
                    iVar.k(n0.j.g(C1152b.b(c1154d4.f22736g)));
                    iVar.k(c1154d4.f22731b.getName());
                    c1154dArr2 = c1154dArr4;
                    i8 = i10;
                    iVar.i(184, C1152b.g(C1152b.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    c1154dArr2 = c1154dArr4;
                    i8 = i10;
                    iVar.g(25, 0);
                    iVar.k(Integer.valueOf(i8));
                    iVar.i(183, f19732h, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                iVar.c(181, str, c1154d4.f22730a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i10 = i8 + 1;
            c1154dArr4 = c1154dArr2;
        }
        C1154d[] c1154dArr5 = c1154dArr4;
        iVar.e(177);
        iVar.f(4, 4);
        iVar.j();
        if (interfaceC0856d != null) {
            for (f0 f0Var : interfaceC0856d.serialzeFeatures()) {
                if (f0Var == f0.DisableCircularReferenceDetect) {
                    z5 = true;
                    break;
                }
            }
            z5 = false;
        } else {
            z5 = false;
        }
        int i11 = 0;
        while (true) {
            InterfaceC0856d interfaceC0856d2 = interfaceC0856d;
            cls = cls3;
            if (i11 >= 3) {
                break;
            }
            if (i11 == 0) {
                str4 = "write";
                z9 = z5;
                z8 = true;
            } else if (i11 == 1) {
                str4 = "writeNormal";
                z9 = z5;
                z8 = false;
            } else {
                str4 = "writeDirectNonContext";
                z8 = true;
                z9 = true;
            }
            C1154d[] c1154dArr6 = c1154dArr5;
            String str10 = str9;
            C0235a c0235a = new C0235a(c1154dArr6, a0Var, str, z8, z9);
            int i12 = i11;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str11 = f19727c;
            sb3.append(str11);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            n0.i iVar2 = new n0.i(cVar4, 1, str4, sb3.toString(), null, new String[]{"java/io/IOException"});
            n0.f fVar = new n0.f();
            iVar2.g(25, 2);
            iVar2.h(199, fVar);
            iVar2.g(25, 1);
            boolean z12 = z9;
            iVar2.i(182, str11, "writeNull", "()V");
            iVar2.e(177);
            iVar2.l(fVar);
            iVar2.g(25, 1);
            iVar2.c(180, str11, "out", f19731g);
            iVar2.g(58, c0235a.g("out"));
            if (z11 || c0235a.f19744d || !(interfaceC0856d2 == null || interfaceC0856d2.alphabetic())) {
                z10 = z11;
                str5 = "(L";
            } else {
                n0.f fVar2 = new n0.f();
                iVar2.g(25, c0235a.g("out"));
                z10 = z11;
                iVar2.i(182, f19730f, "isSortField", "()Z");
                iVar2.h(154, fVar2);
                iVar2.g(25, 0);
                iVar2.g(25, 1);
                iVar2.g(25, 2);
                iVar2.g(25, 3);
                iVar2.g(25, 4);
                iVar2.g(21, 5);
                StringBuilder sb4 = new StringBuilder();
                str5 = "(L";
                sb4.append(str5);
                sb4.append(str11);
                sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.i(182, str, "writeUnsorted", sb4.toString());
                iVar2.e(177);
                iVar2.l(fVar2);
            }
            if (!c0235a.f19744d || z12) {
                c1154dArr = c1154dArr3;
                cVar2 = cVar4;
                i7 = 177;
                c6 = 4;
            } else {
                n0.f fVar3 = new n0.f();
                n0.f fVar4 = new n0.f();
                iVar2.g(25, 0);
                iVar2.g(25, 1);
                String str12 = f19732h;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str5);
                sb5.append(str11);
                cVar2 = cVar4;
                sb5.append(";)Z");
                c1154dArr = c1154dArr3;
                iVar2.i(182, str12, "writeDirect", sb5.toString());
                iVar2.h(154, fVar4);
                iVar2.g(25, 0);
                iVar2.g(25, 1);
                iVar2.g(25, 2);
                iVar2.g(25, 3);
                iVar2.g(25, 4);
                iVar2.g(21, 5);
                iVar2.i(182, str, "writeNormal", str5 + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.e(177);
                iVar2.l(fVar4);
                iVar2.g(25, c0235a.g("out"));
                iVar2.k(Integer.valueOf(f0.DisableCircularReferenceDetect.f19849a));
                iVar2.i(182, f19730f, "isEnabled", "(I)Z");
                iVar2.h(153, fVar3);
                iVar2.g(25, 0);
                iVar2.g(25, 1);
                iVar2.g(25, 2);
                iVar2.g(25, 3);
                c6 = 4;
                iVar2.g(25, 4);
                iVar2.g(21, 5);
                iVar2.i(182, str, "writeDirectNonContext", str5 + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i7 = 177;
                iVar2.e(177);
                iVar2.l(fVar3);
            }
            iVar2.g(25, 2);
            iVar2.b(192, C1152b.g(cls2));
            iVar2.g(58, c0235a.g("entity"));
            B(cls2, iVar2, c1154dArr6, c0235a);
            iVar2.e(i7);
            iVar2.f(7, c0235a.f19746f + 2);
            iVar2.j();
            i11 = i12 + 1;
            c1154dArr5 = c1154dArr6;
            interfaceC0856d = interfaceC0856d2;
            cls3 = cls;
            z11 = z10;
            cVar4 = cVar2;
            str9 = str10;
            c1154dArr3 = c1154dArr;
        }
        C1154d[] c1154dArr7 = c1154dArr3;
        n0.c cVar5 = cVar4;
        String str13 = str9;
        C1154d[] c1154dArr8 = c1154dArr5;
        if (z11) {
            str2 = "(L";
            i5 = 180;
            cVar = cVar5;
        } else {
            str2 = "(L";
            C0235a c0235a2 = new C0235a(c1154dArr8, a0Var, str, false, z5);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str2);
            String str14 = f19727c;
            sb6.append(str14);
            sb6.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            i5 = 180;
            cVar = cVar5;
            n0.i iVar3 = new n0.i(cVar, 1, "writeUnsorted", sb6.toString(), null, new String[]{"java/io/IOException"});
            iVar3.g(25, 1);
            iVar3.c(180, str14, "out", f19731g);
            iVar3.g(58, c0235a2.g("out"));
            iVar3.g(25, 2);
            iVar3.b(192, C1152b.g(cls2));
            iVar3.g(58, c0235a2.g("entity"));
            B(cls2, iVar3, c1154dArr7, c0235a2);
            iVar3.e(177);
            iVar3.f(7, c0235a2.f19746f + 2);
            iVar3.j();
        }
        int i13 = 0;
        for (int i14 = 3; i13 < i14; i14 = i14) {
            if (i13 == 0) {
                str3 = "writeAsArray";
                i6 = i5;
                z7 = z5;
                z6 = true;
            } else if (i13 == 1) {
                str3 = "writeAsArrayNormal";
                i6 = i5;
                z7 = z5;
                z6 = false;
            } else {
                str3 = "writeAsArrayNonContext";
                i6 = i5;
                z6 = true;
                z7 = true;
            }
            int i15 = i6;
            C0235a c0235a3 = new C0235a(c1154dArr8, a0Var, str, z6, z7);
            int i16 = i13;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str2);
            String str15 = f19727c;
            sb7.append(str15);
            sb7.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            n0.i iVar4 = new n0.i(cVar, 1, str3, sb7.toString(), null, new String[]{"java/io/IOException"});
            iVar4.g(25, 1);
            iVar4.c(i15, str15, "out", f19731g);
            iVar4.g(58, c0235a3.g("out"));
            iVar4.g(25, 2);
            iVar4.b(192, C1152b.g(cls2));
            iVar4.g(58, c0235a3.g("entity"));
            A(cls2, iVar4, c1154dArr8, c0235a3);
            iVar4.e(177);
            iVar4.f(7, c0235a3.f19746f + 2);
            iVar4.j();
            i13 = i16 + 1;
            i5 = i15;
        }
        byte[] bArrJ = cVar.j();
        return (C0947J) this.f19736a.a(str13, bArrJ, 0, bArrJ.length).getConstructor(cls).newInstance(a0Var);
    }
}
