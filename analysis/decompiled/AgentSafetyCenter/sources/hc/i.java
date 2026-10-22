package hc;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i extends id.c {
    public static String M(String str) {
        gc.n nVarI0 = h.i0(str);
        a9.k kVar = new a9.k(1);
        kVar.f282f = "    ";
        VarHandle.storeStoreFence();
        gc.i iVar = new gc.i(2);
        iVar.f4694b = nVarI0;
        iVar.f4695c = kVar;
        VarHandle.storeStoreFence();
        return gc.m.T(iVar, "\n");
    }

    public static String N(String str) {
        List listU = gc.m.U(h.i0(str));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listU) {
            if (!h.g0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            String str2 = (String) obj2;
            int length = str2.length();
            int length2 = 0;
            while (true) {
                if (length2 >= length) {
                    length2 = -1;
                    break;
                }
                if (!com.stepos.statsrpk.h.v(str2.charAt(length2))) {
                    break;
                }
                length2++;
            }
            if (length2 == -1) {
                length2 = str2.length();
            }
            arrayList2.add(Integer.valueOf(length2));
        }
        Integer num = (Integer) kb.l.E0(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listU.size();
        int size2 = listU.size() - 1;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listU) {
            int i10 = i + 1;
            String strSubstring = null;
            if (i < 0) {
                ac.a.a0();
                throw null;
            }
            String str3 = (String) obj3;
            if ((i != 0 && i != size2) || !h.g0(str3)) {
                str3.getClass();
                if (iIntValue < 0) {
                    od.f.c(k0.a.k(iIntValue, "Requested character count ", " is less than zero."));
                    return null;
                }
                int length4 = str3.length();
                if (iIntValue <= length4) {
                    length4 = iIntValue;
                }
                strSubstring = str3.substring(length4);
            }
            if (strSubstring != null) {
                arrayList3.add(strSubstring);
            }
            i = i10;
        }
        StringBuilder sb2 = new StringBuilder(length3);
        kb.l.z0(arrayList3, sb2, "\n", "", "", "...", null);
        return sb2.toString();
    }

    public static String O(String str) {
        if (h.g0("|")) {
            g5.f.s("marginPrefix must be non-blank string.");
            return null;
        }
        List listU = gc.m.U(h.i0(str));
        int length = str.length();
        listU.size();
        int size = listU.size() - 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listU) {
            int i3 = i + 1;
            String strSubstring = null;
            if (i < 0) {
                ac.a.a0();
                throw null;
            }
            String str2 = (String) obj;
            if ((i != 0 && i != size) || !h.g0(str2)) {
                int length2 = str2.length();
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        i10 = -1;
                        break;
                    }
                    if (!com.stepos.statsrpk.h.v(str2.charAt(i10))) {
                        break;
                    }
                    i10++;
                }
                if (i10 != -1 && o.T(str2, "|", i10, false)) {
                    strSubstring = str2.substring("|".length() + i10);
                }
                if (strSubstring == null) {
                    strSubstring = str2;
                }
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
            i = i3;
        }
        StringBuilder sb2 = new StringBuilder(length);
        kb.l.z0(arrayList, sb2, "\n", "", "", "...", null);
        return sb2.toString();
    }
}
