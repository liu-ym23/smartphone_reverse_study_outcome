package com.typesafe.config.impl;

import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import com.typesafe.config.ConfigValueType;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static b8.k f31749a = M.r("path parameter");

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public StringBuilder f31750a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f31751b;

        public a(String str, boolean z10) {
            this.f31751b = z10;
            this.f31750a = new StringBuilder(str);
        }

        public String toString() {
            return "Element(" + this.f31750a.toString() + Const.STR_MART_COMMA + this.f31751b + ")";
        }
    }

    public static void a(List<a> list, boolean z10, String str) {
        int iIndexOf = z10 ? -1 : str.indexOf(46);
        a aVar = list.get(list.size() - 1);
        if (iIndexOf >= 0) {
            aVar.f31750a.append(str.substring(0, iIndexOf));
            list.add(new a("", false));
            a(list, false, str.substring(iIndexOf + 1));
        } else {
            aVar.f31750a.append(str);
            if (z10 && aVar.f31750a.length() == 0) {
                aVar.f31751b = true;
            }
        }
    }

    public static D b(D d10, String str, int i10) {
        int iLastIndexOf = str.lastIndexOf(46, i10 - 1);
        D d11 = new D(str.substring(iLastIndexOf + 1, i10), d10);
        return iLastIndexOf < 0 ? d11 : b(d11, str, iLastIndexOf);
    }

    public static boolean c(String str) {
        int length = str.length();
        if (str.isEmpty() || str.charAt(0) == '.' || str.charAt(length - 1) == '.') {
            return true;
        }
        boolean z10 = true;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || ((cCharAt >= 'A' && cCharAt <= 'Z') || cCharAt == '_')) {
                z10 = false;
            } else if (cCharAt == '.') {
                if (z10) {
                    return true;
                }
                z10 = true;
            } else if (cCharAt != '-' || z10) {
                return true;
            }
        }
        return z10;
    }

    public static D d(String str) {
        D dJ = j(str);
        if (dJ != null) {
            return dJ;
        }
        StringReader stringReader = new StringReader(str);
        try {
            Iterator<Q> itD = Tokenizer.d(f31749a, stringReader, ConfigSyntax.CONF);
            itD.next();
            return f(itD, f31749a, str);
        } finally {
            stringReader.close();
        }
    }

    public static D e(Iterator<Q> it, b8.k kVar) {
        return g(it, kVar, null, null, ConfigSyntax.CONF);
    }

    public static D f(Iterator<Q> it, b8.k kVar, String str) {
        return g(it, kVar, str, null, ConfigSyntax.CONF);
    }

    public static D g(Iterator<Q> it, b8.k kVar, String str, ArrayList<Q> arrayList, ConfigSyntax configSyntax) {
        String strD;
        ArrayList<a> arrayList2 = new ArrayList();
        arrayList2.add(new a("", false));
        if (!it.hasNext()) {
            throw new ConfigException.BadPath(kVar, str, "Expecting a field name or path here, but got nothing");
        }
        while (it.hasNext()) {
            Q next = it.next();
            if (arrayList != null) {
                arrayList.add(next);
            }
            if (!S.g(next)) {
                if (S.l(next, ConfigValueType.STRING)) {
                    a(arrayList2, true, S.e(next).m0());
                } else if (next != S.f31788b) {
                    if (S.k(next)) {
                        AbstractConfigValue abstractConfigValueE = S.e(next);
                        if (arrayList != null) {
                            arrayList.remove(arrayList.size() - 1);
                            arrayList.addAll(k(next, configSyntax));
                        }
                        strD = abstractConfigValueE.m0();
                    } else {
                        if (!S.j(next)) {
                            throw new ConfigException.BadPath(kVar, str, "Token not allowed in path expression: " + next + " (you can double-quote this token if you really want it here)");
                        }
                        if (arrayList != null) {
                            arrayList.remove(arrayList.size() - 1);
                            arrayList.addAll(k(next, configSyntax));
                        }
                        strD = S.d(next);
                    }
                    a(arrayList2, false, strD);
                } else {
                    continue;
                }
            }
        }
        E e10 = new E();
        for (a aVar : arrayList2) {
            if (aVar.f31750a.length() == 0 && !aVar.f31751b) {
                throw new ConfigException.BadPath(kVar, str, "path has a leading, trailing, or two adjacent period '.' (use quoted \"\" empty string if you want an empty element)");
            }
            e10.a(aVar.f31750a.toString());
        }
        return e10.d();
    }

    public static r h(Iterator<Q> it, b8.k kVar) {
        return i(it, kVar, null, ConfigSyntax.CONF);
    }

    public static r i(Iterator<Q> it, b8.k kVar, String str, ConfigSyntax configSyntax) {
        ArrayList arrayList = new ArrayList();
        return new r(g(it, kVar, str, arrayList, configSyntax), arrayList);
    }

    public static D j(String str) {
        String strK = C3904j.k(str);
        if (c(strK)) {
            return null;
        }
        return b(null, strK, strK.length());
    }

    public static Collection<Q> k(Q q10, ConfigSyntax configSyntax) {
        String strE = q10.e();
        if (strE.equals(".")) {
            return Collections.singletonList(q10);
        }
        String[] strArrSplit = strE.split("\\.");
        ArrayList arrayList = new ArrayList();
        for (String str : strArrSplit) {
            if (configSyntax == ConfigSyntax.CONF) {
                arrayList.add(S.x(q10.d(), str));
            } else {
                arrayList.add(S.v(q10.d(), str, "\"" + str + "\""));
            }
            arrayList.add(S.x(q10.d(), "."));
        }
        if (strE.charAt(strE.length() - 1) != '.') {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }
}
