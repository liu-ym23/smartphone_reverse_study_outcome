package r4;

import W3.C0403n;
import i4.InterfaceC0772l;
import java.util.ArrayList;
import java.util.List;
import org.libpag.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: r4.r, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1035r extends C1032o {
    private static final InterfaceC0772l<String, String> d(final String str) {
        return str.length() == 0 ? new InterfaceC0772l() { // from class: r4.p
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1035r.e((String) obj);
            }
        } : new InterfaceC0772l() { // from class: r4.q
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return C1035r.f(str, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(String str) {
        j4.k.g(str, "line");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String str, String str2) {
        j4.k.g(str2, "line");
        return str + str2;
    }

    private static final int g(String str) {
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            }
            if (!C1018a.c(str.charAt(i5))) {
                break;
            }
            i5++;
        }
        return i5 == -1 ? str.length() : i5;
    }

    public static final String h(String str, String str2) {
        String strInvoke;
        j4.k.g(str, "<this>");
        j4.k.g(str2, "newIndent");
        List<String> listL = C1015B.L(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listL) {
            if (!C1015B.E((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C0403n.r(arrayList, 10));
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj2 = arrayList.get(i6);
            i6++;
            arrayList2.add(Integer.valueOf(g((String) obj2)));
        }
        Integer num = (Integer) C0403n.L(arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listL.size());
        InterfaceC0772l<String, String> interfaceC0772lD = d(str2);
        int iJ = C0403n.j(listL);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listL) {
            int i7 = i5 + 1;
            if (i5 < 0) {
                C0403n.q();
            }
            String str3 = (String) obj3;
            if ((i5 == 0 || i5 == iJ) && C1015B.E(str3)) {
                str3 = null;
            } else {
                String strJ0 = C1017D.j0(str3, iIntValue);
                if (strJ0 != null && (strInvoke = interfaceC0772lD.invoke(strJ0)) != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i5 = i7;
        }
        return ((StringBuilder) C0403n.G(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static String i(String str) {
        j4.k.g(str, "<this>");
        return h(str, BuildConfig.FLAVOR);
    }
}
