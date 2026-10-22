package ya;

import com.stepos.account.oauth.OAuthConstants;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import n7.m;
import n7.o;
import q7.k;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final g f11736a = new g();

    public static final d a(int i2, CharSequence charSequence, String str) {
        k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        k.e(charSequence, "input");
        String str2 = str + "\nJSON input: " + ((Object) f(charSequence, i2));
        k.e(str2, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (i2 >= 0) {
            str2 = "Unexpected JSON token at offset " + i2 + ": " + str2;
        }
        return new d(str2, 0);
    }

    public static final ua.d b(ua.d dVar, w4.a aVar) {
        k.e(dVar, "<this>");
        k.e(aVar, "module");
        if (!k.a(dVar.getKind(), ua.e.f10214b)) {
            return dVar.e() ? b(dVar.i(0), aVar) : dVar;
        }
        m.s(dVar);
        return dVar;
    }

    public static final byte c(char c10) {
        if (c10 < '~') {
            return c.f11733b[c10];
        }
        return (byte) 0;
    }

    public static final boolean d(ua.d dVar, xa.c cVar) {
        k.e(dVar, "<this>");
        k.e(cVar, "json");
        if (cVar.f11332a.f11339b) {
            return true;
        }
        List annotations = dVar.getAnnotations();
        if (annotations != null && annotations.isEmpty()) {
            return false;
        }
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            if (((Annotation) it.next()) instanceof xa.g) {
                return true;
            }
        }
        return false;
    }

    public static final void e(g3.e eVar, String str) {
        eVar.l(eVar.f3802b - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingComma = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence f(CharSequence charSequence, int i2) {
        k.e(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i2 != -1) {
                int i10 = i2 - 30;
                int i11 = i2 + 30;
                String str = i10 <= 0 ? "" : ".....";
                String str2 = i11 >= charSequence.length() ? "" : ".....";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                if (i10 < 0) {
                    i10 = 0;
                }
                int length = charSequence.length();
                if (i11 > length) {
                    i11 = length;
                }
                sb2.append(charSequence.subSequence(i10, i11).toString());
                sb2.append(str2);
                return sb2.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void g(ua.d dVar, xa.c cVar) {
        k.e(dVar, "<this>");
        k.e(cVar, "json");
        k.a(dVar.getKind(), ua.f.f10216b);
    }

    public static final i h(ua.d dVar, xa.c cVar) {
        k.e(dVar, "desc");
        o kind = dVar.getKind();
        if (kind instanceof ua.a) {
            return i.f11743k;
        }
        if (k.a(kind, ua.f.f10217c)) {
            return i.f11741i;
        }
        if (!k.a(kind, ua.f.f10218d)) {
            return i.f11740h;
        }
        ua.d dVarB = b(dVar.i(0), cVar.f11333b);
        o kind2 = dVarB.getKind();
        if ((kind2 instanceof ua.c) || k.a(kind2, ua.e.f10215c)) {
            return i.f11742j;
        }
        throw new d("Value of type '" + dVarB.b() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + dVarB.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.", 1);
    }
}
