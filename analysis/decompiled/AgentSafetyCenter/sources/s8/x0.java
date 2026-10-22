package s8;

import android.content.res.Resources;
import com.stepos.agentsafetycenter.R;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFormatter f12068a;

    static {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("M/d");
        dateTimeFormatterOfPattern.getClass();
        f12068a = dateTimeFormatterOfPattern;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(s8.j3 r5, java.lang.String r6) {
        /*
            java.lang.String r0 = r5.f11698a
            r6.getClass()
            java.lang.String r1 = p(r5)
            boolean r1 = hc.h.g0(r1)
            if (r1 != 0) goto L10
            goto L62
        L10:
            java.util.List r1 = r5.f11702e
            boolean r2 = r1.isEmpty()
            r3 = 0
            if (r2 == 0) goto L1a
            goto L60
        L1a:
            java.util.List r1 = s8.g1.R(r1)
            java.lang.Object r1 = kb.l.D0(r1)
            s8.p3 r1 = (s8.p3) r1
            java.lang.String r2 = "--:--"
            if (r1 == 0) goto L49
            java.lang.String r1 = r1.f11877c
            if (r1 == 0) goto L49
            java.lang.CharSequence r1 = hc.h.w0(r1)
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L49
            int r4 = r1.length()
            if (r4 <= 0) goto L43
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L43
            goto L44
        L43:
            r1 = r3
        L44:
            if (r1 != 0) goto L47
            goto L49
        L47:
            r3 = r1
            goto L60
        L49:
            java.lang.String r5 = r5.f11705h
            java.lang.CharSequence r5 = hc.h.w0(r5)
            java.lang.String r5 = r5.toString()
            int r1 = r5.length()
            if (r1 <= 0) goto L60
            boolean r1 = r5.equals(r2)
            if (r1 != 0) goto L60
            r3 = r5
        L60:
            if (r3 != 0) goto L63
        L62:
            return r0
        L63:
            r5 = 1
            java.lang.Object[] r0 = new java.lang.Object[]{r3}
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r0, r5)
            java.lang.String r5 = java.lang.String.format(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.x0.a(s8.j3, java.lang.String):java.lang.String");
    }

    public static final List b(p3 p3Var) {
        p3Var.getClass();
        List list = p3Var.B;
        if (!list.isEmpty()) {
            return list;
        }
        u8.a aVar = p3Var.A;
        return aVar != null ? ac.a.E(aVar) : kb.s.f7404c;
    }

    public static final List c(p3 p3Var) {
        String string;
        p3Var.getClass();
        List list = p3Var.f11890q;
        ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k0.a.A((String) it.next(), arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList2.isEmpty()) {
            return kb.l.L0(kb.l.N0(arrayList2));
        }
        String str = p3Var.f11889p;
        String str2 = null;
        if (str != null && (string = hc.h.w0(str).toString()) != null && string.length() > 0) {
            str2 = string;
        }
        return str2 != null ? ac.a.E(str2) : kb.s.f7404c;
    }

    public static final j3 d(List list, j3 j3Var) {
        Object next;
        list.getClass();
        j3Var.getClass();
        String strO = o(j3Var);
        Object obj = null;
        if (!hc.h.g0(strO)) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (yb.k.a(o((j3) next), strO)) {
                    break;
                }
            }
            j3 j3Var2 = (j3) next;
            if (j3Var2 != null) {
                return j3Var2;
            }
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            j3 j3Var3 = (j3) next2;
            if (j3Var3.f11698a.equals(j3Var.f11698a) && j3Var3.i == j3Var.i) {
                obj = next2;
                break;
            }
        }
        return (j3) obj;
    }

    public static final boolean e(j3 j3Var, t tVar, Set set, List list) {
        j3Var.getClass();
        tVar.getClass();
        set.getClass();
        list.getClass();
        if (list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (s((p3) it.next(), j3Var, tVar, set)) {
                return true;
            }
        }
        return false;
    }

    public static final String f(p3 p3Var) {
        p3Var.getClass();
        String string = hc.h.w0(p3Var.f11886m).toString();
        if (string.length() > 0) {
            return w2.c.b("step:", string);
        }
        return null;
    }

    public static final List g(j3 j3Var, t tVar) {
        j3Var.getClass();
        tVar.getClass();
        List list = j3Var.f11702e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((p3) obj).f11880f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            p3 p3Var = (p3) obj2;
            String strL = l(p3Var, j3Var, tVar);
            if (strL == null) {
                strL = f(p3Var);
            }
            if (strL != null) {
                arrayList2.add(strL);
            }
        }
        return kb.l.L0(kb.l.N0(arrayList2));
    }

    public static final boolean h(p3 p3Var) {
        p3Var.getClass();
        return p3Var.f11882h == z8.g.i;
    }

    public static final long i(j3 j3Var) {
        Long lValueOf;
        j3Var.getClass();
        Iterator it = j3Var.f11702e.iterator();
        if (it.hasNext()) {
            lValueOf = Long.valueOf(((p3) it.next()).f11895v);
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(((p3) it.next()).f11895v);
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
        } else {
            lValueOf = null;
        }
        if (lValueOf != null) {
            Long l2 = lValueOf.longValue() > 0 ? lValueOf : null;
            if (l2 != null) {
                return l2.longValue();
            }
        }
        return j3Var.i;
    }

    public static final t j(t tVar, xb.l lVar) {
        int size;
        jb.g gVar;
        String str;
        tVar.getClass();
        List list = tVar.f11967e;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            j3 j3VarA = null;
            size = 0;
            if (!it.hasNext()) {
                break;
            }
            j3 j3Var = (j3) it.next();
            List list2 = j3Var.f11702e;
            ArrayList arrayList2 = new ArrayList(kb.m.m0(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(lVar.invoke(it2.next()));
            }
            if (!arrayList2.isEmpty()) {
                List listR = g1.R(arrayList2);
                if (listR.isEmpty()) {
                    gVar = new jb.g(kb.s.f7404c, 0);
                } else {
                    gVar = listR.size() <= 3 ? new jb.g(listR, 0) : new jb.g(kb.l.J0(listR, 3), Integer.valueOf(listR.size() - 3));
                }
                List list3 = (List) gVar.f6759c;
                int iIntValue = ((Number) gVar.f6760f).intValue();
                int size2 = list3.size() + iIntValue;
                p3 p3Var = (p3) kb.l.x0(list3);
                if (p3Var == null || (str = p3Var.f11877c) == null) {
                    p3 p3Var2 = (p3) kb.l.x0(arrayList2);
                    str = p3Var2 != null ? p3Var2.f11877c : j3Var.f11705h;
                }
                j3VarA = j3.a(j3Var, list3, iIntValue, size2, arrayList2, str, 865);
            }
            if (j3VarA != null) {
                arrayList.add(j3VarA);
            }
        }
        int size3 = arrayList.size();
        int i = 0;
        while (i < size3) {
            Object obj = arrayList.get(i);
            i++;
            size += ((j3) obj).f11702e.size();
        }
        return t.a(tVar, size, null, arrayList, 14);
    }

    public static final String k(p3 p3Var) {
        p3Var.getClass();
        String string = hc.h.w0(p3Var.f11886m).toString();
        if (string.length() <= 0) {
            string = null;
        }
        return string != null ? "id:".concat(string) : androidx.activity.b.j("t:", p3Var.f11877c, ":", p3Var.f11875a);
    }

    public static final String l(p3 p3Var, j3 j3Var, t tVar) {
        Object next;
        Object next2;
        p3Var.getClass();
        j3Var.getClass();
        tVar.getClass();
        List list = tVar.f11966d;
        String strF = f(p3Var);
        if (strF != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                if (((f2) next2).f11599a.equals(strF)) {
                    break;
                }
            }
            if (((f2) next2) != null) {
                return strF;
            }
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            f2 f2Var = (f2) next;
            if (yb.k.a(f2Var.f11600b, p3Var.f11875a)) {
                List list2 = tVar.f11967e;
                list2.getClass();
                j3 j3VarM = m(f2Var, list2);
                if (j3VarM != null) {
                    String strO = o(j3Var);
                    if ((!hc.h.g0(strO) && yb.k.a(o(j3VarM), strO)) || (j3VarM.f11698a.equals(j3Var.f11698a) && j3VarM.i == j3Var.i)) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        f2 f2Var2 = (f2) next;
        if (f2Var2 != null) {
            return f2Var2.f11599a;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final s8.j3 m(s8.f2 r5, java.util.List r6) {
        /*
            r5.getClass()
            r6.getClass()
            java.lang.String r0 = r5.f11603e
            java.lang.CharSequence r0 = hc.h.w0(r0)
            java.lang.String r0 = r0.toString()
            r1 = 0
            if (r0 == 0) goto L3d
            int r2 = r0.length()
            if (r2 <= 0) goto L1a
            goto L1b
        L1a:
            r0 = r1
        L1b:
            if (r0 == 0) goto L3d
            java.util.Iterator r2 = r6.iterator()
        L21:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L37
            java.lang.Object r3 = r2.next()
            r4 = r3
            s8.j3 r4 = (s8.j3) r4
            java.lang.String r4 = r4.f11698a
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L21
            goto L38
        L37:
            r3 = r1
        L38:
            s8.j3 r3 = (s8.j3) r3
            if (r3 == 0) goto L3d
            return r3
        L3d:
            java.lang.String r0 = r5.f11601c
            java.lang.String r2 = "来自\\s*(.+?)\\s*任务"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            r2.getClass()
            r0.getClass()
            java.util.regex.Matcher r2 = r2.matcher(r0)
            r2.getClass()
            r3 = 0
            hc.f r0 = h5.t.h(r2, r3, r0)
            if (r0 != 0) goto L5b
        L59:
            r0 = r1
            goto L76
        L5b:
            java.util.List r0 = r0.a()
            r2 = 1
            hc.e r0 = (hc.e) r0
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.CharSequence r0 = hc.h.w0(r0)
            java.lang.String r0 = r0.toString()
            int r2 = r0.length()
            if (r2 <= 0) goto L59
        L76:
            if (r0 == 0) goto L98
            java.util.Iterator r2 = r6.iterator()
        L7c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L92
            java.lang.Object r3 = r2.next()
            r4 = r3
            s8.j3 r4 = (s8.j3) r4
            java.lang.String r4 = r4.f11698a
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7c
            goto L93
        L92:
            r3 = r1
        L93:
            s8.j3 r3 = (s8.j3) r3
            if (r3 == 0) goto L98
            return r3
        L98:
            java.util.Iterator r6 = r6.iterator()
        L9c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto Lcd
            java.lang.Object r0 = r6.next()
            r2 = r0
            s8.j3 r2 = (s8.j3) r2
            java.util.List r2 = r2.f11702e
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto Lb2
            goto L9c
        Lb2:
            java.util.Iterator r2 = r2.iterator()
        Lb6:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L9c
            java.lang.Object r3 = r2.next()
            s8.p3 r3 = (s8.p3) r3
            java.lang.String r3 = r3.f11875a
            java.lang.String r4 = r5.f11600b
            boolean r3 = yb.k.a(r3, r4)
            if (r3 == 0) goto Lb6
            r1 = r0
        Lcd:
            s8.j3 r1 = (s8.j3) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.x0.m(s8.f2, java.util.List):s8.j3");
    }

    public static final String n(p3 p3Var, j3 j3Var, t tVar) {
        p3Var.getClass();
        j3Var.getClass();
        tVar.getClass();
        String strL = l(p3Var, j3Var, tVar);
        if (strL != null) {
            return strL;
        }
        String strF = f(p3Var);
        if (p3Var.f11881g) {
            return strF;
        }
        return null;
    }

    public static final String o(j3 j3Var) {
        j3Var.getClass();
        String string = hc.h.w0(j3Var.f11706j).toString();
        if (!hc.h.g0(string)) {
            return string;
        }
        p3 p3Var = (p3) kb.l.x0(j3Var.f11702e);
        String str = p3Var != null ? p3Var.f11887n : null;
        if (str == null) {
            str = "";
        }
        return hc.h.w0(str).toString();
    }

    public static final String p(j3 j3Var) {
        String str;
        Iterator it = j3Var.f11702e.iterator();
        do {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            String string = hc.h.w0(((p3) it.next()).f11888o).toString();
            if (string.length() > 0) {
                str = string;
            }
        } while (str == null);
        return str == null ? "" : str;
    }

    public static final String q(p3 p3Var, Resources resources, ZoneId zoneId) throws Resources.NotFoundException {
        String str;
        p3Var.getClass();
        resources.getClass();
        zoneId.getClass();
        long j10 = p3Var.f11896w;
        DateTimeFormatter dateTimeFormatter = f12068a;
        if (j10 > 0) {
            str = Instant.ofEpochMilli(j10).atZone(zoneId).format(dateTimeFormatter);
            str.getClass();
        } else {
            str = LocalDate.now(zoneId).format(dateTimeFormatter);
            str.getClass();
        }
        int iOrdinal = p3Var.f11899z.ordinal();
        if (iOrdinal == 1) {
            int size = b(p3Var).size();
            String string = resources.getString(R.string.revoke_outcome_contact, str, Integer.valueOf(size >= 1 ? size : 1));
            string.getClass();
            return string;
        }
        if (iOrdinal != 2) {
            String string2 = resources.getString(R.string.revoke_outcome_default, str);
            string2.getClass();
            return string2;
        }
        int size2 = p3Var.C.size();
        String string3 = resources.getString(R.string.revoke_outcome_note, str, Integer.valueOf(size2 >= 1 ? size2 : 1));
        string3.getClass();
        return string3;
    }

    public static final boolean r(j3 j3Var) {
        String str = j3Var.f11703f;
        if (hc.h.g0(str)) {
            return false;
        }
        if (hc.h.g0(p(j3Var))) {
            return (yb.k.a(hc.h.w0(j3Var.f11698a).toString(), "未分组") || yb.k.a(hc.h.w0(str).toString(), "未分组")) ? false : true;
        }
        return true;
    }

    public static final boolean s(p3 p3Var, j3 j3Var, t tVar, Set set) {
        p3Var.getClass();
        j3Var.getClass();
        tVar.getClass();
        set.getClass();
        if (!p3Var.f11880f || !p3Var.f11881g) {
            return false;
        }
        if (n(p3Var, j3Var, tVar) == null) {
            return true;
        }
        return !set.contains(r1);
    }

    public static final boolean t(p3 p3Var) {
        p3Var.getClass();
        String str = p3Var.f11875a;
        boolean z10 = p3Var.D;
        z8.g gVar = p3Var.f11882h;
        if (z10) {
            return gVar == z8.g.f16511g;
        }
        int iOrdinal = gVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return true;
            }
            if (iOrdinal == 2 || iOrdinal == 3) {
                return false;
            }
            g5.f.a();
            return false;
        }
        Boolean bool = p3Var.i;
        if (yb.k.a(bool, Boolean.TRUE)) {
            return true;
        }
        if (yb.k.a(bool, Boolean.FALSE)) {
            return false;
        }
        if (bool != null) {
            g5.f.a();
            return false;
        }
        List<String> list = p3Var.f11878d;
        if (list == null || !list.isEmpty()) {
            for (String str2 : list) {
                str2.getClass();
                if (hc.h.X(str2, "可撤销", true) || hc.h.X(str2, "可撤回", true) || hc.h.X(str2, "undo", true)) {
                    return true;
                }
            }
        }
        return hc.h.X(str, "可撤销", true) || hc.h.X(str, "可撤回", true) || hc.h.X(str, "undo", true);
    }

    public static final ArrayList u(j3 j3Var) {
        List list = j3Var.f11702e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (t((p3) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.time.Duration v(s8.p3 r5, java.time.Instant r6, java.time.ZoneId r7) {
        /*
            r5.getClass()
            java.lang.String r7 = r5.f11883j
            r0 = 0
            if (r7 == 0) goto L30
            java.lang.CharSequence r7 = hc.h.w0(r7)
            java.lang.String r7 = r7.toString()
            if (r7 == 0) goto L30
            int r1 = r7.length()
            if (r1 <= 0) goto L19
            goto L1a
        L19:
            r7 = r0
        L1a:
            if (r7 == 0) goto L30
            java.time.Instant r7 = java.time.Instant.parse(r7)     // Catch: java.lang.Throwable -> L21
            goto L26
        L21:
            r7 = move-exception
            jb.h r7 = id.c.l(r7)
        L26:
            boolean r1 = r7 instanceof jb.h
            if (r1 == 0) goto L2b
            r7 = r0
        L2b:
            java.time.Instant r7 = (java.time.Instant) r7
            if (r7 == 0) goto L30
            goto L46
        L30:
            long r1 = r5.f11895v
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L45
            java.time.Instant r5 = java.time.Instant.ofEpochMilli(r1)
            r1 = 30
            java.time.temporal.ChronoUnit r7 = java.time.temporal.ChronoUnit.DAYS
            java.time.Instant r7 = r5.plus(r1, r7)
            goto L46
        L45:
            r7 = r0
        L46:
            if (r7 != 0) goto L49
            return r0
        L49:
            java.time.Duration r5 = java.time.Duration.between(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.x0.v(s8.p3, java.time.Instant, java.time.ZoneId):java.time.Duration");
    }
}
