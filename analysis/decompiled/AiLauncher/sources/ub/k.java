package ub;

import La.C0951a;
import La.D;
import La.H;
import Z8.A;
import Z8.C1173v;
import Z8.r;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import i9.C4180c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.C4851b;
import tb.u;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f0\u000b*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001d\u001a\u0004\u0018\u00010\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010 \u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b \u0010!\u001a\u001b\u0010#\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0004\b#\u0010$\u001a#\u0010%\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b%\u0010!\u001a\u001b\u0010&\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b&\u0010'\u001a#\u0010(\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b(\u0010!\u001a\u0013\u0010)\u001a\u00020\u0000*\u00020\u000fH\u0000¢\u0006\u0004\b)\u0010*\u001a\u0017\u0010,\u001a\u00020+2\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010.\u001a\u00020+2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b.\u0010/\u001a\u0013\u00101\u001a\u00020\u0003*\u000200H\u0002¢\u0006\u0004\b1\u00102\u001a#\u00104\u001a\u00020\u00002\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001b\"\u00020\u0003H\u0000¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"Ltb/u;", "", "index", "", "k", "(Ltb/u;I)Ljava/lang/String;", "p", "name", "", "q", "(Ltb/u;Ljava/lang/String;)Ljava/util/List;", "", "Lkotlin/Pair;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/u;)Ljava/util/Iterator;", "Ltb/u$a;", "l", "(Ltb/u;)Ltb/u$a;", "", "other", "", "f", "(Ltb/u;Ljava/lang/Object;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ltb/u;)I", "o", "(Ltb/u;)Ljava/lang/String;", "", "namesAndValues", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(Ltb/u$a;Ljava/lang/String;Ljava/lang/String;)Ltb/u$a;", "headers", "c", "(Ltb/u$a;Ltb/u;)Ltb/u$a;", Const.INTENT_KEY_UMID, "m", "(Ltb/u$a;Ljava/lang/String;)Ltb/u$a;", "n", "e", "(Ltb/u$a;)Ltb/u;", "LY8/t;", "r", "(Ljava/lang/String;)V", "s", "(Ljava/lang/String;Ljava/lang/String;)V", "", Const.INTENT_KEY_APIKEY, "(C)Ljava/lang/String;", "inputNamesAndValues", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([Ljava/lang/String;)Ltb/u;", "okhttp"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class k {
    public static final String a(char c10) {
        String string = Integer.toString(c10, C0951a.a(16));
        kotlin.jvm.internal.p.h(string, "toString(...)");
        if (string.length() >= 2) {
            return string;
        }
        return '0' + string;
    }

    public static final u.a b(u.a aVar, String name, String value) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        r(name);
        s(value, name);
        d(aVar, name, value);
        return aVar;
    }

    public static final u.a c(u.a aVar, u headers) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(headers, "headers");
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            d(aVar, headers.f(i10), headers.k(i10));
        }
        return aVar;
    }

    public static final u.a d(u.a aVar, String name, String value) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        aVar.g().add(name);
        aVar.g().add(H.D1(value).toString());
        return aVar;
    }

    public static final u e(u.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        return new u((String[]) aVar.g().toArray(new String[0]));
    }

    public static final boolean f(u uVar, Object obj) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        return (obj instanceof u) && Arrays.equals(uVar.getNamesAndValues(), ((u) obj).getNamesAndValues());
    }

    public static final int g(u uVar) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        return Arrays.hashCode(uVar.getNamesAndValues());
    }

    public static final String h(String[] namesAndValues, String name) {
        kotlin.jvm.internal.p.i(namesAndValues, "namesAndValues");
        kotlin.jvm.internal.p.i(name, "name");
        int length = namesAndValues.length - 2;
        int iC = C4180c.c(length, 0, -2);
        if (iC > length) {
            return null;
        }
        while (!D.L(name, namesAndValues[length], true)) {
            if (length == iC) {
                return null;
            }
            length -= 2;
        }
        return namesAndValues[length + 1];
    }

    public static final u i(String... inputNamesAndValues) {
        kotlin.jvm.internal.p.i(inputNamesAndValues, "inputNamesAndValues");
        if (inputNamesAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = strArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (strArr[i11] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr[i11] = H.D1(inputNamesAndValues[i11]).toString();
        }
        int iC = C4180c.c(0, strArr.length - 1, 2);
        if (iC >= 0) {
            while (true) {
                String str = strArr[i10];
                String str2 = strArr[i10 + 1];
                r(str);
                s(str2, str);
                if (i10 == iC) {
                    break;
                }
                i10 += 2;
            }
        }
        return new u(strArr);
    }

    public static final Iterator<Pair<String, String>> j(u uVar) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        int size = uVar.size();
        Pair[] pairArr = new Pair[size];
        for (int i10 = 0; i10 < size; i10++) {
            pairArr[i10] = Y8.j.a(uVar.f(i10), uVar.k(i10));
        }
        return C4851b.a(pairArr);
    }

    public static final String k(u uVar, int i10) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        String str = (String) r.j0(uVar.getNamesAndValues(), i10 * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i10 + ']');
    }

    public static final u.a l(u uVar) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        u.a aVar = new u.a();
        A.F(aVar.g(), uVar.getNamesAndValues());
        return aVar;
    }

    public static final u.a m(u.a aVar, String name) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        int i10 = 0;
        while (i10 < aVar.g().size()) {
            if (D.L(name, aVar.g().get(i10), true)) {
                aVar.g().remove(i10);
                aVar.g().remove(i10);
                i10 -= 2;
            }
            i10 += 2;
        }
        return aVar;
    }

    public static final u.a n(u.a aVar, String name, String value) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        r(name);
        s(value, name);
        aVar.h(name);
        d(aVar, name, value);
        return aVar;
    }

    public static final String o(u uVar) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        int size = uVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strF = uVar.f(i10);
            String strK = uVar.k(i10);
            sb2.append(strF);
            sb2.append(": ");
            if (n.v(strF)) {
                strK = "██";
            }
            sb2.append(strK);
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public static final String p(u uVar, int i10) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        String str = (String) r.j0(uVar.getNamesAndValues(), (i10 * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i10 + ']');
    }

    public static final List<String> q(u uVar, String name) {
        kotlin.jvm.internal.p.i(uVar, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        int size = uVar.size();
        List<String> listUnmodifiableList = null;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            if (D.L(name, uVar.f(i10), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(uVar.k(i10));
            }
        }
        if (arrayList != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            kotlin.jvm.internal.p.h(listUnmodifiableList, "unmodifiableList(...)");
        }
        return listUnmodifiableList == null ? C1173v.m() : listUnmodifiableList;
    }

    public static final void r(String name) {
        kotlin.jvm.internal.p.i(name, "name");
        if (name.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = name.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = name.charAt(i10);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(("Unexpected char 0x" + a(cCharAt) + " at " + i10 + " in header name: " + name).toString());
            }
        }
    }

    public static final void s(String value, String name) {
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(name, "name");
        int length = value.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = value.charAt(i10);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected char 0x");
                sb2.append(a(cCharAt));
                sb2.append(" at ");
                sb2.append(i10);
                sb2.append(" in ");
                sb2.append(name);
                sb2.append(" value");
                sb2.append(n.v(name) ? "" : ": " + value);
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }
}
