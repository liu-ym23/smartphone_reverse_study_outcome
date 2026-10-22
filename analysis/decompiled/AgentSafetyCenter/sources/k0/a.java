package k0;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Operators;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void A(String str, ArrayList arrayList) {
        arrayList.add(hc.h.w0(str).toString());
    }

    public static void B(CoreSubscriber coreSubscriber, Throwable th, CoreSubscriber coreSubscriber2) {
        Operators.error(coreSubscriber2, Operators.onOperatorError(th, coreSubscriber.currentContext()));
    }

    public static String C(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static /* synthetic */ String D(int i) {
        switch (i) {
            case 1:
                return "YEAR";
            case 2:
                return "MONTH";
            case 3:
                return "DAY";
            case 4:
                return "HOUR";
            case 5:
                return "MINUTE";
            case 6:
                return "SECOND";
            case 7:
                return "NANO";
            case 8:
                return "ZONE_OFFSET";
            default:
                throw null;
        }
    }

    public static Number a(int i, u7.a aVar) {
        if (i == 1) {
            return Double.valueOf(aVar.P());
        }
        if (i == 2) {
            return new o7.j(aVar.W());
        }
        if (i == 3) {
            String strW = aVar.W();
            if (strW.indexOf(46) >= 0) {
                return b(strW, aVar);
            }
            try {
                return Long.valueOf(Long.parseLong(strW));
            } catch (NumberFormatException unused) {
                return b(strW, aVar);
            }
        }
        String strW2 = aVar.W();
        try {
            return o7.h.j(strW2);
        } catch (NumberFormatException e10) {
            StringBuilder sbO = androidx.activity.b.o("Cannot parse ", strW2, "; at path ");
            sbO.append(aVar.F());
            throw new m7.k(sbO.toString(), e10);
        }
    }

    public static Double b(String str, u7.a aVar) throws NumberFormatException, u7.d {
        try {
            Double dValueOf = Double.valueOf(str);
            if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                boolean z10 = true;
                if (aVar.f14161s != 1) {
                    z10 = false;
                }
                if (!z10) {
                    throw new u7.d("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.F());
                }
            }
            return dValueOf;
        } catch (NumberFormatException e10) {
            StringBuilder sbO = androidx.activity.b.o("Cannot parse ", str, "; at path ");
            sbO.append(aVar.F());
            throw new m7.k(sbO.toString(), e10);
        }
    }

    public static String c(String str, char c9) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb2.length() != 0) {
                sb2.append(c9);
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String d(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = str.charAt(i);
            if (!Character.isLetter(cCharAt)) {
                i++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static /* synthetic */ String e(int i) {
        if (i == 1) {
            return "\r\n";
        }
        if (i == 2) {
            return "\r";
        }
        if (i == 3) {
            return "\n";
        }
        throw null;
    }

    public static float f(float f5, float f10, float f11, float f12) {
        return ((f5 - f10) * f11) + f12;
    }

    public static int g(int i, float f5, int i3) {
        return (Float.hashCode(f5) + i) * i3;
    }

    public static int h(int i, int i3, boolean z10) {
        return (Boolean.hashCode(z10) + i) * i3;
    }

    public static int i(long j10, int i, int i3) {
        return (Long.hashCode(j10) + i) * i3;
    }

    public static String j(int i, String str) {
        return str + i;
    }

    public static String k(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String l(Object obj, String str) {
        return str + obj;
    }

    public static String m(String str, long j10) {
        return str + j10;
    }

    public static String n(String str, String str2) {
        return str + str2;
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(String str, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(str);
        strOptString.getClass();
        return hc.h.w0(strOptString).toString();
    }

    public static String q(StringBuilder sb2, float f5, char c9) {
        sb2.append(f5);
        sb2.append(c9);
        return sb2.toString();
    }

    public static String r(StringBuilder sb2, int i, String str) {
        sb2.append(i);
        sb2.append(str);
        return sb2.toString();
    }

    public static String s(StringBuilder sb2, String str, char c9) {
        sb2.append(str);
        sb2.append(c9);
        return sb2.toString();
    }

    public static StringBuilder t(int i, String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder u(String str, int i, String str2, String str3, int i3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i);
        sb2.append(str2);
        sb2.append(i3);
        sb2.append(str3);
        return sb2;
    }

    public static StringBuilder v(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        return sb2;
    }

    public static void w(int i, int i3, int i10, int i11, int i12) {
        id.k.b(i);
        id.k.b(i3);
        id.k.b(i10);
        id.k.b(i11);
        id.k.b(i12);
    }

    public static void x(int i, String str, HashMap map, String str2) {
        map.put(str2, new qe.a(i, str));
    }

    public static void y(int i, s sVar, int i3, u1.h hVar) {
        sVar.i0(Integer.valueOf(i));
        sVar.b(Integer.valueOf(i3), hVar);
    }

    public static void z(long j10, StringBuilder sb2, String str) {
        sb2.append((Object) d1.p.j(j10));
        sb2.append(str);
    }
}
