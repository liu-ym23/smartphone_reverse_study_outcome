package x5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class o extends x.f {
    public static String Q0(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        List listY1 = n.y1(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listY1) {
            if (!n.t1((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(c5.o.n0(arrayList, 10));
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = arrayList.get(i9);
            i9++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!x.f.j0(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Integer num = (Integer) c5.m.D0(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listY1.size();
        int iJ0 = c5.n.j0(listY1);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = listY1.iterator();
        while (true) {
            if (!it.hasNext()) {
                StringBuilder sb = new StringBuilder(length3);
                c5.m.z0(arrayList3, sb, "\n", null, 124);
                return sb.toString();
            }
            Object next = it.next();
            int i10 = i8 + 1;
            if (i8 < 0) {
                c5.n.m0();
                throw null;
            }
            String str3 = (String) next;
            String strI1 = ((i8 == 0 || i8 == iJ0) && n.t1(str3)) ? null : n.i1(iIntValue, str3);
            if (strI1 != null) {
                arrayList3.add(strI1);
            }
            i8 = i10;
        }
    }

    public static String R0(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        if (n.t1("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listY1 = n.y1(str);
        int length = str.length();
        listY1.size();
        int iJ0 = c5.n.j0(listY1);
        ArrayList arrayList = new ArrayList();
        Iterator it = listY1.iterator();
        int i8 = 0;
        while (true) {
            String strSubstring = null;
            if (!it.hasNext()) {
                StringBuilder sb = new StringBuilder(length);
                c5.m.z0(arrayList, sb, "\n", null, 124);
                return sb.toString();
            }
            Object next = it.next();
            int i9 = i8 + 1;
            if (i8 < 0) {
                c5.n.m0();
                throw null;
            }
            String str2 = (String) next;
            if ((i8 != 0 && i8 != iJ0) || !n.t1(str2)) {
                int length2 = str2.length();
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        i10 = -1;
                        break;
                    }
                    if (!x.f.j0(str2.charAt(i10))) {
                        break;
                    }
                    i10++;
                }
                if (i10 != -1 && u.b1(str2, "|", i10, false)) {
                    strSubstring = str2.substring("|".length() + i10);
                    kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i8 = i9;
        }
    }
}
