package p0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import o0.AbstractC0891d;
import o0.C0888a;
import o0.C0895h;
import o0.C0896i;
import o0.C0897j;
import o0.EnumC0889b;
import o0.InterfaceC0890c;
import u0.C1151a;
import u0.C1152b;
import u0.C1154d;

/* renamed from: p0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0914a {

    /* renamed from: c, reason: collision with root package name */
    static final String f19282c = C1152b.g(C0888a.class);

    /* renamed from: d, reason: collision with root package name */
    static final String f19283d = C1152b.g(AbstractC0891d.class);

    /* renamed from: a, reason: collision with root package name */
    public final C1151a f19284a;

    /* renamed from: b, reason: collision with root package name */
    protected final AtomicLong f19285b = new AtomicLong();

    /* renamed from: p0.a$a, reason: collision with other inner class name */
    static class C0229a {

        /* renamed from: a, reason: collision with root package name */
        private int f19286a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, Integer> f19287b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Class<?> f19288c;

        /* renamed from: d, reason: collision with root package name */
        private final u0.i f19289d;

        /* renamed from: e, reason: collision with root package name */
        private final String f19290e;

        /* renamed from: f, reason: collision with root package name */
        private C1154d[] f19291f;

        public C0229a(String str, C0896i c0896i, u0.i iVar, int i5) {
            this.f19286a = -1;
            this.f19290e = str;
            this.f19288c = iVar.f22776a;
            this.f19286a = i5;
            this.f19289d = iVar;
            this.f19291f = iVar.f22783h;
        }

        public String g(C1154d c1154d) {
            if (j(c1154d.f22730a)) {
                return c1154d.f22730a + "_asm_deser__";
            }
            return "_asm_deser__" + u0.o.J(c1154d.f22730a);
        }

        public String h(C1154d c1154d) {
            if (j(c1154d.f22730a)) {
                return c1154d.f22730a + "_asm_prefix__";
            }
            return "asm_field_" + u0.o.J(c1154d.f22730a);
        }

        public Class<?> i() {
            Class<?> cls = this.f19289d.f22777b;
            return cls == null ? this.f19288c : cls;
        }

        boolean j(String str) {
            for (int i5 = 0; i5 < str.length(); i5++) {
                char cCharAt = str.charAt(i5);
                if (cCharAt == 0) {
                    if (!u0.g.e(cCharAt)) {
                        return false;
                    }
                } else if (!u0.g.i(cCharAt)) {
                    return false;
                }
            }
            return true;
        }

        public int k(String str) {
            if (this.f19287b.get(str) == null) {
                Map<String, Integer> map = this.f19287b;
                int i5 = this.f19286a;
                this.f19286a = i5 + 1;
                map.put(str, Integer.valueOf(i5));
            }
            return this.f19287b.get(str).intValue();
        }

        public int l(String str, int i5) {
            if (this.f19287b.get(str) == null) {
                this.f19287b.put(str, Integer.valueOf(this.f19286a));
                this.f19286a += i5;
            }
            return this.f19287b.get(str).intValue();
        }

        public int m(C1154d c1154d) {
            return k(c1154d.f22730a + "_asm");
        }

        public int n(C1154d c1154d, int i5) {
            return l(c1154d.f22730a + "_asm", i5);
        }
    }

    public C0914a(ClassLoader classLoader) {
        this.f19284a = classLoader instanceof C1151a ? (C1151a) classLoader : new C1151a(classLoader);
    }

    private void a(C0229a c0229a, n0.h hVar) {
        b(c0229a, hVar, true);
    }

    private void b(C0229a c0229a, n0.h hVar, boolean z5) {
        int length = c0229a.f19291f.length;
        for (int i5 = 0; i5 < length; i5++) {
            n0.f fVar = new n0.f();
            if (z5) {
                n(hVar, c0229a, i5, fVar);
            }
            o(c0229a, hVar, c0229a.f19291f[i5]);
            if (z5) {
                hVar.l(fVar);
            }
        }
    }

    private void c(n0.c cVar, C0229a c0229a) {
        if (Modifier.isPublic(c0229a.f19289d.f22778c.getModifiers())) {
            n0.i iVar = new n0.i(cVar, 1, "createInstance", "(L" + f19282c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            iVar.b(187, C1152b.g(c0229a.i()));
            iVar.e(89);
            iVar.i(183, C1152b.g(c0229a.i()), "<init>", "()V");
            iVar.e(176);
            iVar.f(3, 3);
            iVar.j();
        }
    }

    private void d(C0229a c0229a, n0.h hVar) {
        Constructor<?> constructor = c0229a.f19289d.f22778c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            hVar.b(187, C1152b.g(c0229a.i()));
            hVar.e(89);
            hVar.i(183, C1152b.g(constructor.getDeclaringClass()), "<init>", "()V");
        } else {
            hVar.g(25, 0);
            hVar.g(25, 1);
            hVar.g(25, 0);
            hVar.c(180, C1152b.g(o.class), "clazz", "Ljava/lang/Class;");
            hVar.i(183, C1152b.g(o.class), "createInstance", "(L" + f19282c + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
            hVar.b(192, C1152b.g(c0229a.i()));
        }
        hVar.g(58, c0229a.k("instance"));
    }

    private void e(C0229a c0229a, n0.h hVar, C1154d c1154d, Class<?> cls, int i5) {
        l(c0229a, hVar, c1154d);
        n0.f fVar = new n0.f();
        n0.f fVar2 = new n0.f();
        if ((c1154d.f22739j & EnumC0889b.SupportArrayToBean.f18991a) != 0) {
            hVar.e(89);
            hVar.b(193, C1152b.g(o.class));
            hVar.h(153, fVar);
            hVar.b(192, C1152b.g(o.class));
            hVar.g(25, 1);
            if (c1154d.f22735f instanceof Class) {
                hVar.k(n0.j.g(C1152b.b(c1154d.f22734e)));
            } else {
                hVar.g(25, 0);
                hVar.k(Integer.valueOf(i5));
                hVar.i(182, C1152b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            hVar.k(c1154d.f22730a);
            hVar.k(Integer.valueOf(c1154d.f22739j));
            hVar.i(182, C1152b.g(o.class), "deserialze", "(L" + f19282c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            hVar.b(192, C1152b.g(cls));
            hVar.g(58, c0229a.m(c1154d));
            hVar.h(167, fVar2);
            hVar.l(fVar);
        }
        hVar.g(25, 1);
        if (c1154d.f22735f instanceof Class) {
            hVar.k(n0.j.g(C1152b.b(c1154d.f22734e)));
        } else {
            hVar.g(25, 0);
            hVar.k(Integer.valueOf(i5));
            hVar.i(182, C1152b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        hVar.k(c1154d.f22730a);
        hVar.i(185, C1152b.g(t.class), "deserialze", "(L" + f19282c + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.b(192, C1152b.g(cls));
        hVar.g(58, c0229a.m(c1154d));
        hVar.l(fVar2);
    }

    private void f(C0229a c0229a, n0.h hVar, n0.f fVar) {
        hVar.d(21, c0229a.k("matchedCount"));
        hVar.h(158, fVar);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, f19283d, "token", "()I");
        hVar.k(13);
        hVar.h(160, fVar);
        r(c0229a, hVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0ab8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0add  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g(n0.c r29, p0.C0914a.C0229a r30) {
        /*
            Method dump skipped, instructions count: 3253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C0914a.g(n0.c, p0.a$a):void");
    }

    private void h(n0.c cVar, C0229a c0229a) {
        int i5;
        Integer num;
        int i6;
        char c6;
        boolean z5;
        int i7;
        char c7;
        Integer num2 = 5;
        Integer num3 = 16;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str = f19282c;
        sb.append(str);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        n0.i iVar = new n0.i(cVar, 1, "deserialzeArrayMapping", sb.toString(), null, null);
        w(c0229a, iVar);
        iVar.g(25, c0229a.k("lexer"));
        iVar.g(25, 1);
        iVar.i(182, str, "getSymbolTable", "()" + C1152b.b(C0897j.class));
        iVar.i(182, f19283d, "scanTypeName", "(" + C1152b.b(C0897j.class) + ")Ljava/lang/String;");
        iVar.g(58, c0229a.k("typeName"));
        n0.f fVar = new n0.f();
        iVar.g(25, c0229a.k("typeName"));
        iVar.h(198, fVar);
        iVar.g(25, 1);
        iVar.i(182, str, "getConfig", "()" + C1152b.b(C0896i.class));
        iVar.g(25, 0);
        iVar.c(180, C1152b.g(o.class), "beanInfo", C1152b.b(u0.i.class));
        iVar.g(25, c0229a.k("typeName"));
        iVar.i(184, C1152b.g(o.class), "getSeeAlso", "(" + C1152b.b(C0896i.class) + C1152b.b(u0.i.class) + "Ljava/lang/String;)" + C1152b.b(o.class));
        iVar.g(58, c0229a.k("userTypeDeser"));
        iVar.g(25, c0229a.k("userTypeDeser"));
        iVar.b(193, C1152b.g(o.class));
        iVar.h(153, fVar);
        iVar.g(25, c0229a.k("userTypeDeser"));
        iVar.g(25, 1);
        iVar.g(25, 2);
        iVar.g(25, 3);
        iVar.g(25, 4);
        iVar.i(182, C1152b.g(o.class), "deserialzeArrayMapping", "(L" + str + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        iVar.e(176);
        iVar.l(fVar);
        d(c0229a, iVar);
        C1154d[] c1154dArr = c0229a.f19289d.f22784i;
        int length = c1154dArr.length;
        int i8 = 0;
        while (i8 < length) {
            boolean z6 = i8 == length + (-1);
            int i9 = z6 ? 93 : 44;
            C1154d c1154d = c1154dArr[i8];
            Class<?> cls = c1154d.f22734e;
            C1154d[] c1154dArr2 = c1154dArr;
            Type type = c1154d.f22735f;
            boolean z7 = z6;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                i5 = i8;
                num = num3;
                i6 = length;
                c6 = ':';
                z5 = true;
                iVar.g(25, c0229a.k("lexer"));
                iVar.g(16, i9);
                iVar.i(182, f19283d, "scanInt", "(C)I");
                iVar.g(54, c0229a.m(c1154d));
            } else {
                i6 = length;
                Integer num4 = num3;
                i5 = i8;
                if (cls == Byte.class) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    String str2 = f19283d;
                    iVar.i(182, str2, "scanInt", "(C)I");
                    iVar.i(184, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    iVar.g(58, c0229a.m(c1154d));
                    n0.f fVar2 = new n0.f();
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.c(180, str2, "matchStat", "I");
                    iVar.k(num2);
                    iVar.h(160, fVar2);
                    iVar.e(1);
                    iVar.g(58, c0229a.m(c1154d));
                    iVar.l(fVar2);
                } else if (cls == Short.class) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    String str3 = f19283d;
                    iVar.i(182, str3, "scanInt", "(C)I");
                    iVar.i(184, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    iVar.g(58, c0229a.m(c1154d));
                    n0.f fVar3 = new n0.f();
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.c(180, str3, "matchStat", "I");
                    iVar.k(num2);
                    iVar.h(160, fVar3);
                    iVar.e(1);
                    iVar.g(58, c0229a.m(c1154d));
                    iVar.l(fVar3);
                } else if (cls == Integer.class) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    String str4 = f19283d;
                    iVar.i(182, str4, "scanInt", "(C)I");
                    iVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    iVar.g(58, c0229a.m(c1154d));
                    n0.f fVar4 = new n0.f();
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.c(180, str4, "matchStat", "I");
                    iVar.k(num2);
                    iVar.h(160, fVar4);
                    iVar.e(1);
                    iVar.g(58, c0229a.m(c1154d));
                    iVar.l(fVar4);
                } else if (cls == Long.TYPE) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    iVar.i(182, f19283d, "scanLong", "(C)J");
                    iVar.g(55, c0229a.n(c1154d, 2));
                } else if (cls == Long.class) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    String str5 = f19283d;
                    iVar.i(182, str5, "scanLong", "(C)J");
                    iVar.i(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    iVar.g(58, c0229a.m(c1154d));
                    n0.f fVar5 = new n0.f();
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.c(180, str5, "matchStat", "I");
                    iVar.k(num2);
                    iVar.h(160, fVar5);
                    iVar.e(1);
                    iVar.g(58, c0229a.m(c1154d));
                    iVar.l(fVar5);
                } else if (cls == Boolean.TYPE) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    iVar.i(182, f19283d, "scanBoolean", "(C)Z");
                    iVar.g(54, c0229a.m(c1154d));
                } else if (cls == Float.TYPE) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    iVar.i(182, f19283d, "scanFloat", "(C)F");
                    iVar.g(56, c0229a.m(c1154d));
                } else if (cls == Float.class) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    String str6 = f19283d;
                    iVar.i(182, str6, "scanFloat", "(C)F");
                    iVar.i(184, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    iVar.g(58, c0229a.m(c1154d));
                    n0.f fVar6 = new n0.f();
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.c(180, str6, "matchStat", "I");
                    iVar.k(num2);
                    iVar.h(160, fVar6);
                    iVar.e(1);
                    iVar.g(58, c0229a.m(c1154d));
                    iVar.l(fVar6);
                } else if (cls == Double.TYPE) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    iVar.i(182, f19283d, "scanDouble", "(C)D");
                    iVar.g(57, c0229a.n(c1154d, 2));
                } else if (cls == Double.class) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    String str7 = f19283d;
                    iVar.i(182, str7, "scanDouble", "(C)D");
                    iVar.i(184, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    iVar.g(58, c0229a.m(c1154d));
                    n0.f fVar7 = new n0.f();
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.c(180, str7, "matchStat", "I");
                    iVar.k(num2);
                    iVar.h(160, fVar7);
                    iVar.e(1);
                    iVar.g(58, c0229a.m(c1154d));
                    iVar.l(fVar7);
                } else if (cls == Character.TYPE) {
                    iVar.g(25, c0229a.k("lexer"));
                    iVar.g(16, i9);
                    iVar.i(182, f19283d, "scanString", "(C)Ljava/lang/String;");
                    iVar.e(3);
                    iVar.i(182, "java/lang/String", "charAt", "(I)C");
                    iVar.g(54, c0229a.m(c1154d));
                } else {
                    if (cls == String.class) {
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.g(16, i9);
                        iVar.i(182, f19283d, "scanString", "(C)Ljava/lang/String;");
                        c7 = ':';
                        iVar.g(58, c0229a.m(c1154d));
                    } else if (cls == BigDecimal.class) {
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.g(16, i9);
                        iVar.i(182, f19283d, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                        c7 = ':';
                        iVar.g(58, c0229a.m(c1154d));
                    } else if (cls == Date.class) {
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.g(16, i9);
                        iVar.i(182, f19283d, "scanDate", "(C)Ljava/util/Date;");
                        c7 = ':';
                        iVar.g(58, c0229a.m(c1154d));
                    } else if (cls == UUID.class) {
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.g(16, i9);
                        iVar.i(182, f19283d, "scanUUID", "(C)Ljava/util/UUID;");
                        c7 = ':';
                        iVar.g(58, c0229a.m(c1154d));
                    } else if (cls.isEnum()) {
                        n0.f fVar8 = new n0.f();
                        n0.f fVar9 = new n0.f();
                        n0.f fVar10 = new n0.f();
                        n0.f fVar11 = new n0.f();
                        Integer num5 = num2;
                        iVar.g(25, c0229a.k("lexer"));
                        String str8 = f19283d;
                        iVar.i(182, str8, "getCurrent", "()C");
                        iVar.e(89);
                        iVar.g(54, c0229a.k("ch"));
                        iVar.k(110);
                        iVar.h(159, fVar11);
                        iVar.g(21, c0229a.k("ch"));
                        iVar.k(34);
                        iVar.h(160, fVar8);
                        iVar.l(fVar11);
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.k(n0.j.g(C1152b.b(cls)));
                        iVar.g(25, 1);
                        iVar.i(182, f19282c, "getSymbolTable", "()" + C1152b.b(C0897j.class));
                        iVar.g(16, i9);
                        iVar.i(182, str8, "scanEnum", "(Ljava/lang/Class;" + C1152b.b(C0897j.class) + "C)Ljava/lang/Enum;");
                        iVar.h(167, fVar10);
                        iVar.l(fVar8);
                        iVar.g(21, c0229a.k("ch"));
                        iVar.k(48);
                        iVar.h(161, fVar9);
                        iVar.g(21, c0229a.k("ch"));
                        iVar.k(57);
                        iVar.h(163, fVar9);
                        l(c0229a, iVar, c1154d);
                        iVar.b(192, C1152b.g(h.class));
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.g(16, i9);
                        iVar.i(182, str8, "scanInt", "(C)I");
                        iVar.i(182, C1152b.g(h.class), "valueOf", "(I)Ljava/lang/Enum;");
                        iVar.h(167, fVar10);
                        iVar.l(fVar9);
                        iVar.g(25, 0);
                        iVar.g(25, c0229a.k("lexer"));
                        iVar.g(16, i9);
                        iVar.i(182, C1152b.g(o.class), "scanEnum", "(L" + str8 + ";C)Ljava/lang/Enum;");
                        iVar.l(fVar10);
                        iVar.b(192, C1152b.g(cls));
                        iVar.g(58, c0229a.m(c1154d));
                        c6 = ':';
                        num = num4;
                        num2 = num5;
                        z5 = true;
                    } else {
                        Integer num6 = num2;
                        if (Collection.class.isAssignableFrom(cls)) {
                            Class<?> clsR = u0.o.R(type);
                            if (clsR == String.class) {
                                if (cls == List.class || cls == Collections.class || cls == ArrayList.class) {
                                    iVar.b(187, C1152b.g(ArrayList.class));
                                    iVar.e(89);
                                    iVar.i(183, C1152b.g(ArrayList.class), "<init>", "()V");
                                } else {
                                    iVar.k(n0.j.g(C1152b.b(cls)));
                                    iVar.i(184, C1152b.g(u0.o.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                                }
                                iVar.g(58, c0229a.m(c1154d));
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.g(25, c0229a.m(c1154d));
                                iVar.g(16, i9);
                                String str9 = f19283d;
                                iVar.i(182, str9, "scanStringArray", "(Ljava/util/Collection;C)V");
                                n0.f fVar12 = new n0.f();
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.c(180, str9, "matchStat", "I");
                                num2 = num6;
                                iVar.k(num2);
                                iVar.h(160, fVar12);
                                iVar.e(1);
                                iVar.g(58, c0229a.m(c1154d));
                                iVar.l(fVar12);
                                i7 = i5;
                            } else {
                                num2 = num6;
                                n0.f fVar13 = new n0.f();
                                iVar.g(25, c0229a.k("lexer"));
                                String str10 = f19283d;
                                iVar.i(182, str10, "token", "()I");
                                iVar.g(54, c0229a.k("token"));
                                iVar.g(21, c0229a.k("token"));
                                int i10 = i5 == 0 ? 14 : 16;
                                iVar.k(Integer.valueOf(i10));
                                iVar.h(159, fVar13);
                                iVar.g(25, 1);
                                iVar.k(Integer.valueOf(i10));
                                String str11 = f19282c;
                                iVar.i(182, str11, "throwException", "(I)V");
                                iVar.l(fVar13);
                                n0.f fVar14 = new n0.f();
                                n0.f fVar15 = new n0.f();
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.i(182, str10, "getCurrent", "()C");
                                iVar.g(16, 91);
                                iVar.h(160, fVar14);
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.i(182, str10, "next", "()C");
                                iVar.e(87);
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.k(14);
                                iVar.i(182, str10, "setToken", "(I)V");
                                iVar.h(167, fVar15);
                                iVar.l(fVar14);
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.k(14);
                                iVar.i(182, str10, "nextToken", "(I)V");
                                iVar.l(fVar15);
                                i7 = i5;
                                p(iVar, cls, i7, false);
                                iVar.e(89);
                                iVar.g(58, c0229a.m(c1154d));
                                k(c0229a, iVar, c1154d, clsR);
                                iVar.g(25, 1);
                                iVar.k(n0.j.g(C1152b.b(clsR)));
                                iVar.g(25, 3);
                                iVar.i(184, C1152b.g(o.class), "parseArray", "(Ljava/util/Collection;" + C1152b.b(t.class) + "L" + str11 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            }
                            i5 = i7;
                        } else {
                            num2 = num6;
                            if (cls.isArray()) {
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.k(14);
                                iVar.i(182, f19283d, "nextToken", "(I)V");
                                z5 = true;
                                iVar.g(25, 1);
                                iVar.g(25, 0);
                                iVar.k(Integer.valueOf(i5));
                                iVar.i(182, C1152b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                                iVar.i(182, f19282c, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                                iVar.b(192, C1152b.g(cls));
                                iVar.g(58, c0229a.m(c1154d));
                                c6 = ':';
                                i5 = i5;
                                num = num4;
                            } else {
                                z5 = true;
                                n0.f fVar16 = new n0.f();
                                n0.f fVar17 = new n0.f();
                                if (cls == Date.class) {
                                    iVar.g(25, c0229a.k("lexer"));
                                    String str12 = f19283d;
                                    iVar.i(182, str12, "getCurrent", "()C");
                                    iVar.k(49);
                                    iVar.h(160, fVar16);
                                    iVar.b(187, C1152b.g(Date.class));
                                    iVar.e(89);
                                    iVar.g(25, c0229a.k("lexer"));
                                    iVar.g(16, i9);
                                    iVar.i(182, str12, "scanLong", "(C)J");
                                    iVar.i(183, C1152b.g(Date.class), "<init>", "(J)V");
                                    c6 = ':';
                                    iVar.g(58, c0229a.m(c1154d));
                                    iVar.h(167, fVar17);
                                } else {
                                    c6 = ':';
                                }
                                iVar.l(fVar16);
                                q(c0229a, iVar, 14);
                                e(c0229a, iVar, c1154d, cls, i5);
                                i5 = i5;
                                iVar.g(25, c0229a.k("lexer"));
                                iVar.i(182, f19283d, "token", "()I");
                                iVar.k(15);
                                iVar.h(159, fVar17);
                                iVar.g(25, 0);
                                iVar.g(25, c0229a.k("lexer"));
                                if (z7) {
                                    num = num4;
                                    iVar.k(15);
                                } else {
                                    num = num4;
                                    iVar.k(num);
                                }
                                iVar.i(183, C1152b.g(o.class), "check", "(" + C1152b.b(InterfaceC0890c.class) + "I)V");
                                iVar.l(fVar17);
                            }
                        }
                    }
                    c6 = c7;
                    num = num4;
                    z5 = true;
                }
                num = num4;
                c6 = ':';
                z5 = true;
            }
            c1154dArr = c1154dArr2;
            length = i6;
            num3 = num;
            i8 = i5 + 1;
        }
        Integer num7 = num3;
        b(c0229a, iVar, false);
        n0.f fVar18 = new n0.f();
        n0.f fVar19 = new n0.f();
        n0.f fVar20 = new n0.f();
        n0.f fVar21 = new n0.f();
        iVar.g(25, c0229a.k("lexer"));
        String str13 = f19283d;
        iVar.i(182, str13, "getCurrent", "()C");
        iVar.e(89);
        iVar.g(54, c0229a.k("ch"));
        iVar.g(16, 44);
        iVar.h(160, fVar19);
        iVar.g(25, c0229a.k("lexer"));
        iVar.i(182, str13, "next", "()C");
        iVar.e(87);
        iVar.g(25, c0229a.k("lexer"));
        iVar.k(num7);
        iVar.i(182, str13, "setToken", "(I)V");
        iVar.h(167, fVar21);
        iVar.l(fVar19);
        iVar.g(21, c0229a.k("ch"));
        iVar.g(16, 93);
        iVar.h(160, fVar20);
        iVar.g(25, c0229a.k("lexer"));
        iVar.i(182, str13, "next", "()C");
        iVar.e(87);
        iVar.g(25, c0229a.k("lexer"));
        iVar.k(15);
        iVar.i(182, str13, "setToken", "(I)V");
        iVar.h(167, fVar21);
        iVar.l(fVar20);
        iVar.g(21, c0229a.k("ch"));
        iVar.g(16, 26);
        iVar.h(160, fVar18);
        iVar.g(25, c0229a.k("lexer"));
        iVar.i(182, str13, "next", "()C");
        iVar.e(87);
        iVar.g(25, c0229a.k("lexer"));
        iVar.k(20);
        iVar.i(182, str13, "setToken", "(I)V");
        iVar.h(167, fVar21);
        iVar.l(fVar18);
        iVar.g(25, c0229a.k("lexer"));
        iVar.k(num7);
        iVar.i(182, str13, "nextToken", "(I)V");
        iVar.l(fVar21);
        iVar.g(25, c0229a.k("instance"));
        iVar.e(176);
        iVar.f(5, c0229a.f19286a);
        iVar.j();
    }

    private void i(C0229a c0229a, n0.h hVar, n0.f fVar, C1154d c1154d, Class<?> cls, Class<?> cls2, int i5) {
        String str;
        boolean z5;
        String str2;
        String str3;
        int i6;
        n0.f fVar2 = new n0.f();
        String str4 = f19283d;
        hVar.i(182, str4, "matchField", "([C)Z");
        hVar.h(153, fVar2);
        u(hVar, c0229a, i5);
        n0.f fVar3 = new n0.f();
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str4, "token", "()I");
        hVar.k(8);
        hVar.h(160, fVar3);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(16);
        hVar.i(182, str4, "nextToken", "(I)V");
        hVar.h(167, fVar2);
        hVar.l(fVar3);
        n0.f fVar4 = new n0.f();
        n0.f fVar5 = new n0.f();
        n0.f fVar6 = new n0.f();
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str4, "token", "()I");
        hVar.k(21);
        hVar.h(160, fVar5);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(14);
        hVar.i(182, str4, "nextToken", "(I)V");
        p(hVar, cls, i5, true);
        hVar.h(167, fVar4);
        hVar.l(fVar5);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str4, "token", "()I");
        hVar.k(14);
        hVar.h(159, fVar6);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str4, "token", "()I");
        hVar.k(12);
        hVar.h(160, fVar);
        p(hVar, cls, i5, false);
        hVar.g(58, c0229a.m(c1154d));
        k(c0229a, hVar, c1154d, cls2);
        hVar.g(25, 1);
        hVar.k(n0.j.g(C1152b.b(cls2)));
        hVar.e(3);
        hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String strG = C1152b.g(t.class);
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str5 = f19282c;
        sb.append(str5);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.i(185, strG, "deserialze", sb.toString());
        hVar.g(58, c0229a.k("list_item_value"));
        hVar.g(25, c0229a.m(c1154d));
        hVar.g(25, c0229a.k("list_item_value"));
        if (cls.isInterface()) {
            str = "list_item_value";
            hVar.i(185, C1152b.g(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            str = "list_item_value";
            hVar.i(182, C1152b.g(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar.e(87);
        hVar.h(167, fVar2);
        hVar.l(fVar6);
        p(hVar, cls, i5, false);
        hVar.l(fVar4);
        hVar.g(58, c0229a.m(c1154d));
        boolean zV = C0896i.v(c1154d.f22734e);
        k(c0229a, hVar, c1154d, cls2);
        if (zV) {
            z5 = zV;
            hVar.i(185, C1152b.g(t.class), "getFastMatchToken", "()I");
            hVar.g(54, c0229a.k("fastMatchToken"));
            hVar.g(25, c0229a.k("lexer"));
            hVar.g(21, c0229a.k("fastMatchToken"));
            str2 = str4;
            str3 = "nextToken";
            hVar.i(182, str2, str3, "(I)V");
        } else {
            z5 = zV;
            str2 = str4;
            str3 = "nextToken";
            hVar.e(87);
            hVar.k(12);
            hVar.g(54, c0229a.k("fastMatchToken"));
            q(c0229a, hVar, 12);
        }
        hVar.g(25, 1);
        hVar.i(182, str5, "getContext", "()" + C1152b.b(C0895h.class));
        hVar.g(58, c0229a.k("listContext"));
        hVar.g(25, 1);
        hVar.g(25, c0229a.m(c1154d));
        hVar.k(c1154d.f22730a);
        hVar.i(182, str5, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + C1152b.b(C0895h.class));
        hVar.e(87);
        n0.f fVar7 = new n0.f();
        n0.f fVar8 = new n0.f();
        hVar.e(3);
        hVar.g(54, c0229a.k("i"));
        hVar.l(fVar7);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str2, "token", "()I");
        hVar.k(15);
        hVar.h(159, fVar8);
        hVar.g(25, 0);
        String str6 = c0229a.f19290e;
        StringBuilder sb2 = new StringBuilder();
        String str7 = str3;
        sb2.append(c1154d.f22730a);
        sb2.append("_asm_list_item_deser__");
        hVar.c(180, str6, sb2.toString(), C1152b.b(t.class));
        hVar.g(25, 1);
        hVar.k(n0.j.g(C1152b.b(cls2)));
        hVar.g(21, c0229a.k("i"));
        hVar.i(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        hVar.i(185, C1152b.g(t.class), "deserialze", "(L" + str5 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        String str8 = str;
        hVar.g(58, c0229a.k(str8));
        hVar.a(c0229a.k("i"), 1);
        hVar.g(25, c0229a.m(c1154d));
        hVar.g(25, c0229a.k(str8));
        if (cls.isInterface()) {
            hVar.i(185, C1152b.g(cls), "add", "(Ljava/lang/Object;)Z");
            i6 = 182;
        } else {
            i6 = 182;
            hVar.i(182, C1152b.g(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar.e(87);
        hVar.g(25, 1);
        hVar.g(25, c0229a.m(c1154d));
        hVar.i(i6, str5, "checkListResolve", "(Ljava/util/Collection;)V");
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(i6, str2, "token", "()I");
        hVar.k(16);
        hVar.h(160, fVar7);
        if (z5) {
            hVar.g(25, c0229a.k("lexer"));
            hVar.g(21, c0229a.k("fastMatchToken"));
            hVar.i(i6, str2, str7, "(I)V");
        } else {
            q(c0229a, hVar, 12);
        }
        hVar.h(167, fVar7);
        hVar.l(fVar8);
        hVar.g(25, 1);
        hVar.g(25, c0229a.k("listContext"));
        hVar.i(182, str5, "setContext", "(" + C1152b.b(C0895h.class) + ")V");
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str2, "token", "()I");
        hVar.k(15);
        hVar.h(160, fVar);
        r(c0229a, hVar);
        hVar.l(fVar2);
    }

    private void j(C0229a c0229a, n0.h hVar, n0.f fVar, C1154d c1154d, Class<?> cls, int i5) {
        n0.f fVar2 = new n0.f();
        n0.f fVar3 = new n0.f();
        hVar.g(25, c0229a.k("lexer"));
        hVar.g(25, 0);
        hVar.c(180, c0229a.f19290e, c0229a.h(c1154d), "[C");
        hVar.i(182, f19283d, "matchField", "([C)Z");
        hVar.h(154, fVar2);
        hVar.e(1);
        hVar.g(58, c0229a.m(c1154d));
        hVar.h(167, fVar3);
        hVar.l(fVar2);
        u(hVar, c0229a, i5);
        hVar.g(21, c0229a.k("matchedCount"));
        hVar.e(4);
        hVar.e(96);
        hVar.g(54, c0229a.k("matchedCount"));
        e(c0229a, hVar, c1154d, cls, i5);
        hVar.g(25, 1);
        String str = f19282c;
        hVar.i(182, str, "getResolveStatus", "()I");
        hVar.k(1);
        hVar.h(160, fVar3);
        hVar.g(25, 1);
        hVar.i(182, str, "getLastResolveTask", "()" + C1152b.b(C0888a.C0227a.class));
        hVar.g(58, c0229a.k("resolveTask"));
        hVar.g(25, c0229a.k("resolveTask"));
        hVar.g(25, 1);
        hVar.i(182, str, "getContext", "()" + C1152b.b(C0895h.class));
        hVar.c(181, C1152b.g(C0888a.C0227a.class), "ownerContext", C1152b.b(C0895h.class));
        hVar.g(25, c0229a.k("resolveTask"));
        hVar.g(25, 0);
        hVar.k(c1154d.f22730a);
        hVar.i(182, C1152b.g(o.class), "getFieldDeserializer", "(Ljava/lang/String;)" + C1152b.b(l.class));
        hVar.c(181, C1152b.g(C0888a.C0227a.class), "fieldDeserializer", C1152b.b(l.class));
        hVar.g(25, 1);
        hVar.k(0);
        hVar.i(182, str, "setResolveStatus", "(I)V");
        hVar.l(fVar3);
    }

    private void k(C0229a c0229a, n0.h hVar, C1154d c1154d, Class<?> cls) {
        n0.f fVar = new n0.f();
        hVar.g(25, 0);
        hVar.c(180, c0229a.f19290e, c1154d.f22730a + "_asm_list_item_deser__", C1152b.b(t.class));
        hVar.h(199, fVar);
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.i(182, f19282c, "getConfig", "()" + C1152b.b(C0896i.class));
        hVar.k(n0.j.g(C1152b.b(cls)));
        hVar.i(182, C1152b.g(C0896i.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + C1152b.b(t.class));
        hVar.c(181, c0229a.f19290e, c1154d.f22730a + "_asm_list_item_deser__", C1152b.b(t.class));
        hVar.l(fVar);
        hVar.g(25, 0);
        hVar.c(180, c0229a.f19290e, c1154d.f22730a + "_asm_list_item_deser__", C1152b.b(t.class));
    }

    private void l(C0229a c0229a, n0.h hVar, C1154d c1154d) {
        n0.f fVar = new n0.f();
        hVar.g(25, 0);
        hVar.c(180, c0229a.f19290e, c0229a.g(c1154d), C1152b.b(t.class));
        hVar.h(199, fVar);
        hVar.g(25, 0);
        hVar.g(25, 1);
        hVar.i(182, f19282c, "getConfig", "()" + C1152b.b(C0896i.class));
        hVar.k(n0.j.g(C1152b.b(c1154d.f22734e)));
        hVar.i(182, C1152b.g(C0896i.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + C1152b.b(t.class));
        hVar.c(181, c0229a.f19290e, c0229a.g(c1154d), C1152b.b(t.class));
        hVar.l(fVar);
        hVar.g(25, 0);
        hVar.c(180, c0229a.f19290e, c0229a.g(c1154d), C1152b.b(t.class));
    }

    private void m(n0.c cVar, C0229a c0229a) {
        int length = c0229a.f19291f.length;
        for (int i5 = 0; i5 < length; i5++) {
            new n0.d(cVar, 1, c0229a.h(c0229a.f19291f[i5]), "[C").c();
        }
        int length2 = c0229a.f19291f.length;
        for (int i6 = 0; i6 < length2; i6++) {
            C1154d c1154d = c0229a.f19291f[i6];
            Class<?> cls = c1154d.f22734e;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new n0.d(cVar, 1, c1154d.f22730a + "_asm_list_item_deser__", C1152b.b(t.class)).c();
                } else {
                    new n0.d(cVar, 1, c0229a.g(c1154d), C1152b.b(t.class)).c();
                }
            }
        }
        n0.i iVar = new n0.i(cVar, 1, "<init>", "(" + C1152b.b(C0896i.class) + C1152b.b(u0.i.class) + ")V", null, null);
        iVar.g(25, 0);
        iVar.g(25, 1);
        iVar.g(25, 2);
        iVar.i(183, C1152b.g(o.class), "<init>", "(" + C1152b.b(C0896i.class) + C1152b.b(u0.i.class) + ")V");
        int length3 = c0229a.f19291f.length;
        for (int i7 = 0; i7 < length3; i7++) {
            C1154d c1154d2 = c0229a.f19291f[i7];
            iVar.g(25, 0);
            iVar.k("\"" + c1154d2.f22730a + "\":");
            iVar.i(182, "java/lang/String", "toCharArray", "()[C");
            iVar.c(181, c0229a.f19290e, c0229a.h(c1154d2), "[C");
        }
        iVar.e(177);
        iVar.f(4, 4);
        iVar.j();
    }

    private void n(n0.h hVar, C0229a c0229a, int i5, n0.f fVar) {
        hVar.g(21, c0229a.k("_asm_flag_" + (i5 / 32)));
        hVar.k(Integer.valueOf(1 << i5));
        hVar.e(126);
        hVar.h(153, fVar);
    }

    private void o(C0229a c0229a, n0.h hVar, C1154d c1154d) {
        Class<?> cls = c1154d.f22734e;
        Type type = c1154d.f22735f;
        if (cls == Boolean.TYPE) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(21, c0229a.m(c1154d));
            s(c0229a, hVar, c1154d);
            return;
        }
        if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(21, c0229a.m(c1154d));
            s(c0229a, hVar, c1154d);
            return;
        }
        if (cls == Long.TYPE) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(22, c0229a.n(c1154d, 2));
            if (c1154d.f22731b == null) {
                hVar.c(181, C1152b.g(c1154d.f22736g), c1154d.f22732c.getName(), C1152b.b(c1154d.f22734e));
                return;
            }
            hVar.i(182, C1152b.g(c0229a.i()), c1154d.f22731b.getName(), C1152b.c(c1154d.f22731b));
            if (c1154d.f22731b.getReturnType().equals(Void.TYPE)) {
                return;
            }
            hVar.e(87);
            return;
        }
        if (cls == Float.TYPE) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(23, c0229a.m(c1154d));
            s(c0229a, hVar, c1154d);
            return;
        }
        if (cls == Double.TYPE) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(24, c0229a.n(c1154d, 2));
            s(c0229a, hVar, c1154d);
            return;
        }
        if (cls == String.class) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(25, c0229a.m(c1154d));
            s(c0229a, hVar, c1154d);
            return;
        }
        if (cls.isEnum()) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(25, c0229a.m(c1154d));
            s(c0229a, hVar, c1154d);
        } else if (!Collection.class.isAssignableFrom(cls)) {
            hVar.g(25, c0229a.k("instance"));
            hVar.g(25, c0229a.m(c1154d));
            s(c0229a, hVar, c1154d);
        } else {
            hVar.g(25, c0229a.k("instance"));
            if (u0.o.R(type) == String.class) {
                hVar.g(25, c0229a.m(c1154d));
                hVar.b(192, C1152b.g(cls));
            } else {
                hVar.g(25, c0229a.m(c1154d));
            }
            s(c0229a, hVar, c1154d);
        }
    }

    private void p(n0.h hVar, Class<?> cls, int i5, boolean z5) {
        if (cls.isAssignableFrom(ArrayList.class) && !z5) {
            hVar.b(187, "java/util/ArrayList");
            hVar.e(89);
            hVar.i(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z5) {
            hVar.b(187, C1152b.g(LinkedList.class));
            hVar.e(89);
            hVar.i(183, C1152b.g(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            hVar.b(187, C1152b.g(HashSet.class));
            hVar.e(89);
            hVar.i(183, C1152b.g(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            hVar.b(187, C1152b.g(TreeSet.class));
            hVar.e(89);
            hVar.i(183, C1152b.g(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            hVar.b(187, C1152b.g(LinkedHashSet.class));
            hVar.e(89);
            hVar.i(183, C1152b.g(LinkedHashSet.class), "<init>", "()V");
        } else if (z5) {
            hVar.b(187, C1152b.g(HashSet.class));
            hVar.e(89);
            hVar.i(183, C1152b.g(HashSet.class), "<init>", "()V");
        } else {
            hVar.g(25, 0);
            hVar.k(Integer.valueOf(i5));
            hVar.i(182, C1152b.g(o.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            hVar.i(184, C1152b.g(u0.o.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        hVar.b(192, C1152b.g(cls));
    }

    private void q(C0229a c0229a, n0.h hVar, int i5) {
        n0.f fVar = new n0.f();
        n0.f fVar2 = new n0.f();
        hVar.g(25, c0229a.k("lexer"));
        String str = f19283d;
        hVar.i(182, str, "getCurrent", "()C");
        if (i5 == 12) {
            hVar.g(16, 123);
        } else {
            if (i5 != 14) {
                throw new IllegalStateException();
            }
            hVar.g(16, 91);
        }
        hVar.h(160, fVar);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str, "next", "()C");
        hVar.e(87);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(Integer.valueOf(i5));
        hVar.i(182, str, "setToken", "(I)V");
        hVar.h(167, fVar2);
        hVar.l(fVar);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(Integer.valueOf(i5));
        hVar.i(182, str, "nextToken", "(I)V");
        hVar.l(fVar2);
    }

    private void r(C0229a c0229a, n0.h hVar) {
        n0.f fVar = new n0.f();
        n0.f fVar2 = new n0.f();
        n0.f fVar3 = new n0.f();
        n0.f fVar4 = new n0.f();
        n0.f fVar5 = new n0.f();
        hVar.g(25, c0229a.k("lexer"));
        String str = f19283d;
        hVar.i(182, str, "getCurrent", "()C");
        hVar.e(89);
        hVar.g(54, c0229a.k("ch"));
        hVar.g(16, 44);
        hVar.h(160, fVar2);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str, "next", "()C");
        hVar.e(87);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(16);
        hVar.i(182, str, "setToken", "(I)V");
        hVar.h(167, fVar5);
        hVar.l(fVar2);
        hVar.g(21, c0229a.k("ch"));
        hVar.g(16, 125);
        hVar.h(160, fVar3);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str, "next", "()C");
        hVar.e(87);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(13);
        hVar.i(182, str, "setToken", "(I)V");
        hVar.h(167, fVar5);
        hVar.l(fVar3);
        hVar.g(21, c0229a.k("ch"));
        hVar.g(16, 93);
        hVar.h(160, fVar4);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str, "next", "()C");
        hVar.e(87);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(15);
        hVar.i(182, str, "setToken", "(I)V");
        hVar.h(167, fVar5);
        hVar.l(fVar4);
        hVar.g(21, c0229a.k("ch"));
        hVar.g(16, 26);
        hVar.h(160, fVar);
        hVar.g(25, c0229a.k("lexer"));
        hVar.k(20);
        hVar.i(182, str, "setToken", "(I)V");
        hVar.h(167, fVar5);
        hVar.l(fVar);
        hVar.g(25, c0229a.k("lexer"));
        hVar.i(182, str, "nextToken", "()V");
        hVar.l(fVar5);
    }

    private void s(C0229a c0229a, n0.h hVar, C1154d c1154d) {
        Method method = c1154d.f22731b;
        if (method == null) {
            hVar.c(181, C1152b.g(c1154d.f22736g), c1154d.f22732c.getName(), C1152b.b(c1154d.f22734e));
            return;
        }
        hVar.i(method.getDeclaringClass().isInterface() ? 185 : 182, C1152b.g(c1154d.f22736g), method.getName(), C1152b.c(method));
        if (c1154d.f22731b.getReturnType().equals(Void.TYPE)) {
            return;
        }
        hVar.e(87);
    }

    private void t(C0229a c0229a, n0.h hVar) {
        hVar.g(25, 1);
        hVar.g(25, c0229a.k("context"));
        hVar.i(182, f19282c, "setContext", "(" + C1152b.b(C0895h.class) + ")V");
        n0.f fVar = new n0.f();
        hVar.g(25, c0229a.k("childContext"));
        hVar.h(198, fVar);
        hVar.g(25, c0229a.k("childContext"));
        hVar.g(25, c0229a.k("instance"));
        hVar.c(181, C1152b.g(C0895h.class), "object", "Ljava/lang/Object;");
        hVar.l(fVar);
    }

    private void u(n0.h hVar, C0229a c0229a, int i5) {
        String str = "_asm_flag_" + (i5 / 32);
        hVar.g(21, c0229a.k(str));
        hVar.k(Integer.valueOf(1 << i5));
        hVar.e(128);
        hVar.g(54, c0229a.k(str));
    }

    private void w(C0229a c0229a, n0.h hVar) {
        hVar.g(25, 1);
        hVar.c(180, f19282c, "lexer", C1152b.b(InterfaceC0890c.class));
        hVar.b(192, f19283d);
        hVar.g(58, c0229a.k("lexer"));
    }

    public t v(C0896i c0896i, u0.i iVar) {
        String str;
        Class<?> cls = iVar.f22776a;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str2 = "FastjsonASMDeserializer_" + this.f19285b.incrementAndGet() + "_" + cls.getSimpleName();
        Package r12 = C0914a.class.getPackage();
        if (r12 != null) {
            String name = r12.getName();
            String str3 = name.replace('.', '/') + "/" + str2;
            str2 = name + "." + str2;
            str = str3;
        } else {
            str = str2;
        }
        n0.c cVar = new n0.c();
        cVar.k(49, 33, str, C1152b.g(o.class), null);
        m(cVar, new C0229a(str, c0896i, iVar, 3));
        c(cVar, new C0229a(str, c0896i, iVar, 3));
        g(cVar, new C0229a(str, c0896i, iVar, 5));
        h(cVar, new C0229a(str, c0896i, iVar, 4));
        byte[] bArrJ = cVar.j();
        return (t) this.f19284a.a(str2, bArrJ, 0, bArrJ.length).getConstructor(C0896i.class, u0.i.class).newInstance(c0896i, iVar);
    }
}
