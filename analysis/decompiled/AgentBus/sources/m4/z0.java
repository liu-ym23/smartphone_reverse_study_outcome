package m4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.i f6377a = new ga.i("^#{1,6}\\s+(.+)$", ga.j.f4028h);

    public static String a(String str) {
        String strP0;
        return (str == null || (strP0 = ga.k.P0(ga.r.e0(str, "\r\n", "\n"), 65279)) == null) ? "" : strP0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d7.z] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public static x0 b(String str) {
        List listK0;
        Object next;
        if (str == null || ga.k.t0(str)) {
            return new x0();
        }
        List listX0 = ga.k.x0(a(str));
        boolean zIsEmpty = listX0.isEmpty();
        ?? arrayList = d7.z.f2978f;
        if (zIsEmpty || !q7.k.a(ga.k.N0((String) d7.r.N0(listX0)).toString(), "---")) {
            listK0 = null;
        } else {
            Iterator it = d7.r.K0(d7.r.r1(listX0), 1).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (q7.k.a(ga.k.N0((String) ((d7.c0) next).f2952b).toString(), "---")) {
                    break;
                }
            }
            d7.c0 c0Var = (d7.c0) next;
            Integer numValueOf = c0Var != null ? Integer.valueOf(c0Var.f2951a) : null;
            if (numValueOf != null) {
                listK0 = listX0.subList(1, numValueOf.intValue());
            } else {
                listK0 = d7.r.K0(listX0, 1);
                if (listK0.isEmpty()) {
                    listK0 = arrayList;
                } else {
                    Iterator it2 = listK0.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        String string = ga.k.N0((String) it2.next()).toString();
                        Pattern patternCompile = Pattern.compile("^#{1,6}\\s+.+$");
                        q7.k.d(patternCompile, "compile(...)");
                        q7.k.e(string, "input");
                        if (patternCompile.matcher(string).matches()) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 >= 0) {
                        listK0 = listK0.subList(0, i2);
                    }
                }
            }
        }
        if (listK0 == null) {
            return new x0();
        }
        int i10 = 0;
        String strA0 = null;
        String string2 = null;
        String strA02 = null;
        while (i10 < listK0.size()) {
            String strP0 = ga.k.P0(ga.k.N0((String) listK0.get(i10)).toString(), 65279);
            ga.i iVar = y0.f6370a;
            if (iVar.b(strP0) != null) {
                ga.h hVarB = iVar.b(strP0);
                q7.k.b(hVarB);
                strA0 = ga.k.A0(ga.k.A0(ga.k.N0((String) ((d7.h0) hVarB.a()).get(1)).toString(), "\""), "'");
                if (ga.k.t0(strA0)) {
                    strA0 = null;
                }
            } else {
                ga.i iVar2 = y0.f6373d;
                if (iVar2.b(strP0) != null) {
                    ga.h hVarB2 = iVar2.b(strP0);
                    q7.k.b(hVarB2);
                    strA02 = ga.k.A0(ga.k.A0(ga.k.N0((String) ((d7.h0) hVarB2.a()).get(1)).toString(), "\""), "'");
                    if (ga.k.t0(strA02)) {
                        strA02 = null;
                    }
                } else {
                    ga.i iVar3 = y0.f6371b;
                    if (iVar3.b(strP0) != null) {
                        ga.h hVarB3 = iVar3.b(strP0);
                        q7.k.b(hVarB3);
                        String string3 = ga.k.N0((String) ((d7.h0) hVarB3.a()).get(1)).toString();
                        if (q7.k.a(string3, "|") || q7.k.a(string3, ">")) {
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                i10++;
                                if (i10 >= listK0.size()) {
                                    break;
                                }
                                String str2 = (String) listK0.get(i10);
                                if (!ga.r.g0(str2, "  ", false) && (ga.k.t0(str2) || str2.charAt(0) != ' ')) {
                                    break;
                                }
                                sb2.append(ga.k.N0(str2).toString());
                                sb2.append('\n');
                            }
                            String string4 = sb2.toString();
                            q7.k.d(string4, "toString(...)");
                            string2 = ga.k.N0(string4).toString();
                            if (ga.k.t0(string2)) {
                                string2 = null;
                            }
                        } else {
                            string2 = ga.k.A0(ga.k.A0(string3, "\""), "'");
                            if (ga.k.t0(string2)) {
                                string2 = null;
                            }
                        }
                    } else {
                        ga.i iVar4 = y0.f6372c;
                        if (iVar4.b(strP0) != null) {
                            ga.h hVarB4 = iVar4.b(strP0);
                            q7.k.b(hVarB4);
                            String string5 = ga.k.N0((String) ((d7.h0) hVarB4.a()).get(1)).toString();
                            if (ga.r.g0(string5, "[", false)) {
                                String strZ0 = ga.k.z0(string5, "[");
                                List listD0 = ga.k.D0(ga.k.N0(ga.k.K0(strZ0, "]", strZ0)).toString(), new String[]{","}, 6);
                                ArrayList arrayList2 = new ArrayList(d7.t.A0(listD0, 10));
                                Iterator it3 = listD0.iterator();
                                while (it3.hasNext()) {
                                    arrayList2.add(ga.k.A0(ga.k.A0(ga.k.N0((String) it3.next()).toString(), "\""), "'"));
                                }
                                arrayList = new ArrayList();
                                Iterator it4 = arrayList2.iterator();
                                while (it4.hasNext()) {
                                    Object next2 = it4.next();
                                    if (((String) next2).length() > 0) {
                                        arrayList.add(next2);
                                    }
                                }
                            } else if (string5.length() == 0) {
                                i10++;
                                arrayList = new ArrayList();
                                while (i10 < listK0.size()) {
                                    String string6 = ga.k.N0((String) listK0.get(i10)).toString();
                                    if (ga.r.g0(string6, "-", false)) {
                                        arrayList.add(ga.k.A0(ga.k.A0(ga.k.N0(ga.k.z0(string6, "-")).toString(), "\""), "'"));
                                    } else if (string6.length() == 0) {
                                    }
                                    i10++;
                                }
                            } else {
                                List listD02 = ga.k.D0(string5, new String[]{","}, 6);
                                ArrayList arrayList3 = new ArrayList(d7.t.A0(listD02, 10));
                                Iterator it5 = listD02.iterator();
                                while (it5.hasNext()) {
                                    arrayList3.add(ga.k.A0(ga.k.A0(ga.k.N0((String) it5.next()).toString(), "\""), "'"));
                                }
                                arrayList = new ArrayList();
                                Iterator it6 = arrayList3.iterator();
                                while (it6.hasNext()) {
                                    Object next3 = it6.next();
                                    if (((String) next3).length() > 0) {
                                        arrayList.add(next3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            i10++;
        }
        return new x0(strA0, string2, arrayList, strA02);
    }

    public static String c(String str) {
        Object next;
        List listX0 = ga.k.x0(str);
        if (listX0.isEmpty() || !q7.k.a(ga.k.N0((String) d7.r.N0(listX0)).toString(), "---")) {
            return str;
        }
        Iterator it = d7.r.K0(d7.r.r1(listX0), 1).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (q7.k.a(ga.k.N0((String) ((d7.c0) next).f2952b).toString(), "---")) {
                break;
            }
        }
        d7.c0 c0Var = (d7.c0) next;
        return c0Var != null ? d7.r.U0(listX0.subList(c0Var.f2951a + 1, listX0.size()), "\n", null, null, null, 62) : "";
    }
}
