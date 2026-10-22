package j9;

import D7.v;
import D7.w;
import ca.AbstractC0897f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class n extends com.stepos.statsrpk.d {
    public static String Q(String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        return kotlin.sequences.a.l0(kotlin.sequences.a.m0(new D7.t(str, 7), new R3.c("    ", 20)), "\n");
    }

    public static String R(String str) throws IOException {
        int length;
        Comparable comparable;
        kotlin.jvm.internal.k.f(str, "<this>");
        List listW0 = m.w0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listW0) {
            if (!m.s0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(w.c0(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length2 = str2.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!AbstractC0897f.F(str2.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str2.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listW0.size();
        int iH = H4.o.H(listW0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listW0) {
            int i = length + 1;
            if (length < 0) {
                H4.o.X();
                throw null;
            }
            String str3 = (String) obj2;
            String strJ0 = ((length == 0 || length == iH) && m.s0(str3)) ? null : m.j0(iIntValue, str3);
            if (strJ0 != null) {
                arrayList3.add(strJ0);
            }
            length = i;
        }
        StringBuilder sb = new StringBuilder(length3);
        v.H0(arrayList3, sb, "\n", null, null, null, 124);
        return sb.toString();
    }

    public static String S(String str) throws IOException {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (m.s0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listW0 = m.w0(str);
        int length = str.length();
        listW0.size();
        int iH = H4.o.H(listW0);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listW0) {
            int i6 = i + 1;
            String strSubstring = null;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            String str2 = (String) obj;
            if ((i != 0 && i != iH) || !m.s0(str2)) {
                int length2 = str2.length();
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        i10 = -1;
                        break;
                    }
                    if (!AbstractC0897f.F(str2.charAt(i10))) {
                        break;
                    }
                    i10++;
                }
                if (i10 != -1 && t.d0(i10, str2, "|", false)) {
                    strSubstring = str2.substring("|".length() + i10);
                    kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i = i6;
        }
        StringBuilder sb = new StringBuilder(length);
        v.H0(arrayList, sb, "\n", null, null, null, 124);
        return sb.toString();
    }
}
