package x8;

import a4.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import v9.v;
import v9.z;
import z8.p0;

/* loaded from: classes.dex */
public final class e implements r9.m {

    /* renamed from: b, reason: collision with root package name */
    public static final e f11255b = new e();

    /* renamed from: c, reason: collision with root package name */
    public static final e f11256c = new e();

    /* renamed from: d, reason: collision with root package name */
    public static final e f11257d = new e();

    public static String[] a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static j b(String str) {
        m9.c cVar;
        q7.k.e(str, "representation");
        char cCharAt = str.charAt(0);
        m9.c[] cVarArrValues = m9.c.values();
        int length = cVarArrValues.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                cVar = null;
                break;
            }
            cVar = cVarArrValues[i2];
            if (cVar.c().charAt(0) == cCharAt) {
                break;
            }
            i2++;
        }
        if (cVar != null) {
            return new i(cVar);
        }
        if (cCharAt == 'V') {
            return new i(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            q7.k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            return new g(b(strSubstring));
        }
        if (cCharAt == 'L') {
            ga.k.n0(str, ';');
        }
        String strSubstring2 = str.substring(1, str.length() - 1);
        q7.k.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return new h(strSubstring2);
    }

    public static h d(String str) {
        q7.k.e(str, "internalName");
        return new h(str);
    }

    public static LinkedHashSet e(String str, String... strArr) {
        q7.k.e(str, "internalName");
        q7.k.e(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public static LinkedHashSet f(String str, String... strArr) {
        q7.k.e(strArr, "signatures");
        return e("java/lang/".concat(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static LinkedHashSet g(String str, String... strArr) {
        return e("java/util/".concat(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public static String h(j jVar) {
        String strC;
        q7.k.e(jVar, "type");
        if (jVar instanceof g) {
            return "[" + h(((g) jVar).f11261i);
        }
        if (jVar instanceof i) {
            m9.c cVar = ((i) jVar).f11263i;
            return (cVar == null || (strC = cVar.c()) == null) ? "V" : strC;
        }
        if (jVar instanceof h) {
            return a1.a.l(new StringBuilder("L"), ((h) jVar).f11262i, ';');
        }
        throw new u();
    }

    @Override // r9.m
    public v c(p0 p0Var, String str, z zVar, z zVar2) {
        q7.k.e(p0Var, "proto");
        q7.k.e(str, "flexibleId");
        q7.k.e(zVar, "lowerBound");
        q7.k.e(zVar2, "upperBound");
        if (str.equals("kotlin.jvm.PlatformType")) {
            return p0Var.j(c9.l.f2168g) ? new t8.f(zVar, zVar2) : v9.d.j(zVar, zVar2);
        }
        return x9.i.c(x9.h.f11312r, str, zVar.toString(), zVar2.toString());
    }
}
