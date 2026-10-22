package gc;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class k extends b1 {
    public static String Z(String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        List listW0 = q.w0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listW0) {
            if (!q.t0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(mb.m.Z(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj2 = arrayList.get(i11);
            i11++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!b1.N(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Integer num = (Integer) kotlin.collections.a.C0(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listW0.size();
        int iA0 = mb.m.a0(listW0);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = listW0.iterator();
        while (true) {
            if (!it.hasNext()) {
                StringBuilder sb2 = new StringBuilder(length3);
                kotlin.collections.a.y0(arrayList3, sb2, "\n", null, 124);
                return sb2.toString();
            }
            Object next = it.next();
            int i12 = i10 + 1;
            if (i10 < 0) {
                mb.m.f0();
                throw null;
            }
            String str3 = (String) next;
            String strQ0 = ((i10 == 0 || i10 == iA0) && q.t0(str3)) ? null : r.Q0(iIntValue, str3);
            if (strQ0 != null) {
                arrayList3.add(strQ0);
            }
            i10 = i12;
        }
    }

    public static String a0(String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        if (q.t0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listW0 = q.w0(str);
        int length = str.length();
        listW0.size();
        int iA0 = mb.m.a0(listW0);
        ArrayList arrayList = new ArrayList();
        Iterator it = listW0.iterator();
        int i10 = 0;
        while (true) {
            String strSubstring = null;
            if (!it.hasNext()) {
                StringBuilder sb2 = new StringBuilder(length);
                kotlin.collections.a.y0(arrayList, sb2, "\n", null, 124);
                return sb2.toString();
            }
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                mb.m.f0();
                throw null;
            }
            String str2 = (String) next;
            if ((i10 != 0 && i10 != iA0) || !q.t0(str2)) {
                int length2 = str2.length();
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        i12 = -1;
                        break;
                    }
                    if (!b1.N(str2.charAt(i12))) {
                        break;
                    }
                    i12++;
                }
                if (i12 != -1 && o.j0(i12, str2, "|", false)) {
                    strSubstring = str2.substring("|".length() + i12);
                    kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i10 = i11;
        }
    }
}
