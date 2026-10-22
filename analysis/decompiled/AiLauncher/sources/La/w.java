package La;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u001b\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u000f2\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "marginPrefix", "o", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "newIndent", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "n", "(Ljava/lang/String;)Ljava/lang/String;", "l", "indent", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)I", "Lkotlin/Function1;", "e", "(Ljava/lang/String;)Lp9/l;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes5.dex */
public class w extends s {
    public static final InterfaceC5074l<String, String> e(final String str) {
        return str.length() == 0 ? new InterfaceC5074l() { // from class: La.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return w.f((String) obj);
            }
        } : new InterfaceC5074l() { // from class: La.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return w.g(str, (String) obj);
            }
        };
    }

    public static final String f(String line) {
        kotlin.jvm.internal.p.i(line, "line");
        return line;
    }

    public static final String g(String str, String line) {
        kotlin.jvm.internal.p.i(line, "line");
        return str + line;
    }

    public static final int h(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (!C0951a.c(str.charAt(i10))) {
                break;
            }
            i10++;
        }
        return i10 == -1 ? str.length() : i10;
    }

    public static final String i(String str, final String indent) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(indent, "indent");
        return SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.R(H.E0(str), new InterfaceC5074l() { // from class: La.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return w.k(indent, (String) obj);
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    public static final String k(String str, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (H.x0(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    public static final String l(String str, String newIndent) {
        String strInvoke;
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(newIndent, "newIndent");
        List<String> listF0 = H.F0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF0) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it.next())));
        }
        Integer num = (Integer) Z8.F.K0(arrayList2);
        int i10 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listF0.size());
        InterfaceC5074l<String, String> interfaceC5074lE = e(newIndent);
        int iO = C1173v.o(listF0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listF0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            String str2 = (String) obj2;
            if ((i10 == 0 || i10 == iO) && H.x0(str2)) {
                str2 = null;
            } else {
                String strL1 = K.L1(str2, iIntValue);
                if (strL1 != null && (strInvoke = interfaceC5074lE.invoke(strL1)) != null) {
                    str2 = strInvoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i10 = i11;
        }
        return ((StringBuilder) Z8.F.x0(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static final String m(String str, String newIndent, String marginPrefix) {
        String str2;
        String strInvoke;
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(newIndent, "newIndent");
        kotlin.jvm.internal.p.i(marginPrefix, "marginPrefix");
        if (H.x0(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> listF0 = H.F0(str);
        int length = str.length() + (newIndent.length() * listF0.size());
        InterfaceC5074l<String, String> interfaceC5074lE = e(newIndent);
        int iO = C1173v.o(listF0);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listF0) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            String str3 = (String) obj;
            String strSubstring = null;
            if ((i10 == 0 || i10 == iO) && H.x0(str3)) {
                str2 = marginPrefix;
                str3 = null;
            } else {
                int length2 = str3.length();
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        i12 = -1;
                        break;
                    }
                    if (!C0951a.c(str3.charAt(i12))) {
                        break;
                    }
                    i12++;
                }
                if (i12 == -1) {
                    str2 = marginPrefix;
                } else {
                    int i13 = i12;
                    str2 = marginPrefix;
                    if (D.W(str3, str2, i13, false, 4, null)) {
                        int length3 = str2.length() + i13;
                        kotlin.jvm.internal.p.g(str3, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str3.substring(length3);
                        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (strInvoke = interfaceC5074lE.invoke(strSubstring)) != null) {
                    str3 = strInvoke;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
            i10 = i11;
            marginPrefix = str2;
        }
        return ((StringBuilder) Z8.F.x0(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static String n(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return l(str, "");
    }

    public static final String o(String str, String marginPrefix) {
        kotlin.jvm.internal.p.i(str, "<this>");
        kotlin.jvm.internal.p.i(marginPrefix, "marginPrefix");
        return m(str, "", marginPrefix);
    }

    public static /* synthetic */ String p(String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str2 = "|";
        }
        return o(str, str2);
    }
}
