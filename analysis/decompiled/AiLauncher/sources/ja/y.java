package ja;

import La.D;
import java.util.List;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class y {
    public static final String b(ga.d dVar) {
        kotlin.jvm.internal.p.i(dVar, "<this>");
        return g(dVar.h());
    }

    public static final String c(ga.e eVar) {
        kotlin.jvm.internal.p.i(eVar, "<this>");
        if (!i(eVar)) {
            String strB = eVar.b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            return strB;
        }
        StringBuilder sb2 = new StringBuilder();
        String strB2 = eVar.b();
        kotlin.jvm.internal.p.h(strB2, "asString(...)");
        sb2.append('`' + strB2);
        sb2.append('`');
        return sb2.toString();
    }

    public static final String d(String lowerRendered, String upperRendered, InterfaceC5063a<String> renderKotlinCollectionsPrefix, InterfaceC5063a<String> renderKotlinPrefix, InterfaceC5074l<? super String, String> escape) {
        kotlin.jvm.internal.p.i(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.p.i(upperRendered, "upperRendered");
        kotlin.jvm.internal.p.i(renderKotlinCollectionsPrefix, "renderKotlinCollectionsPrefix");
        kotlin.jvm.internal.p.i(renderKotlinPrefix, "renderKotlinPrefix");
        kotlin.jvm.internal.p.i(escape, "escape");
        String strInvoke = renderKotlinCollectionsPrefix.invoke();
        String strH = h(lowerRendered, strInvoke + "Mutable", upperRendered, strInvoke, strInvoke + "(Mutable)");
        if (strH != null) {
            return strH;
        }
        String strH2 = h(lowerRendered, strInvoke + "MutableMap.MutableEntry", upperRendered, strInvoke + "Map.Entry", strInvoke + "(Mutable)Map.(Mutable)Entry");
        if (strH2 != null) {
            return strH2;
        }
        String strInvoke2 = renderKotlinPrefix.invoke();
        String strH3 = h(lowerRendered, strInvoke2 + escape.invoke("Array<"), upperRendered, strInvoke2 + escape.invoke("Array<out "), strInvoke2 + escape.invoke("Array<(out) "));
        if (strH3 != null) {
            return strH3;
        }
        return null;
    }

    public static /* synthetic */ String e(String str, String str2, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            interfaceC5074l = x.f34563a;
        }
        return d(str, str2, interfaceC5063a, interfaceC5063a2, interfaceC5074l);
    }

    public static final String f(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it;
    }

    public static final String g(List<ga.e> pathSegments) {
        kotlin.jvm.internal.p.i(pathSegments, "pathSegments");
        StringBuilder sb2 = new StringBuilder();
        for (ga.e eVar : pathSegments) {
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(c(eVar));
        }
        return sb2.toString();
    }

    public static final String h(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        kotlin.jvm.internal.p.i(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.p.i(lowerPrefix, "lowerPrefix");
        kotlin.jvm.internal.p.i(upperRendered, "upperRendered");
        kotlin.jvm.internal.p.i(upperPrefix, "upperPrefix");
        kotlin.jvm.internal.p.i(foldedPrefix, "foldedPrefix");
        if (D.X(lowerRendered, lowerPrefix, false, 2, null) && D.X(upperRendered, upperPrefix, false, 2, null)) {
            String strSubstring = lowerRendered.substring(lowerPrefix.length());
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            String strSubstring2 = upperRendered.substring(upperPrefix.length());
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            String str = foldedPrefix + strSubstring;
            if (kotlin.jvm.internal.p.d(strSubstring, strSubstring2)) {
                return str;
            }
            if (j(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean i(ga.e eVar) {
        String strB = eVar.b();
        kotlin.jvm.internal.p.h(strB, "asString(...)");
        if (w.f34562a.contains(strB)) {
            return true;
        }
        for (int i10 = 0; i10 < strB.length(); i10++) {
            char cCharAt = strB.charAt(i10);
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                return true;
            }
        }
        return strB.length() == 0 || !Character.isJavaIdentifierStart(strB.codePointAt(0));
    }

    public static final boolean j(String lower, String upper) {
        kotlin.jvm.internal.p.i(lower, "lower");
        kotlin.jvm.internal.p.i(upper, "upper");
        if (kotlin.jvm.internal.p.d(lower, D.T(upper, "?", "", false, 4, null))) {
            return true;
        }
        if (D.K(upper, "?", false, 2, null)) {
            if (kotlin.jvm.internal.p.d(lower + '?', upper)) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(lower);
        sb2.append(")?");
        return kotlin.jvm.internal.p.d(sb2.toString(), upper);
    }
}
