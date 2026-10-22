package z8;

import gc.m;
import hc.h;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kb.b0;
import kb.k;
import kb.l;
import kb.p;
import kb.q;
import kb.s;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f16505a = k.v0(new String[]{"ability", "nodes", "exec", "bash", "shell"});

    /* renamed from: b, reason: collision with root package name */
    public static final Set f16506b = k.v0(new String[]{"tool", "method", "action", "node", "invokeTimeoutMs", "timeout", "invokeCommand", "invokeParamsJson"});

    /* renamed from: c, reason: collision with root package name */
    public static final List f16507c = ac.a.F("paths", "src", "files", "file", "path", "number");

    /* renamed from: d, reason: collision with root package name */
    public static final List f16508d = ac.a.F("dst", "destination");

    public static String a(String str, String str2) {
        int iE0;
        Object next;
        Iterator it = ac.a.F("--".concat(str2), "-".concat(str2)).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            int length = 0;
            while (length < str.length() && (iE0 = h.e0(str, str3, length, false, 4)) >= 0) {
                boolean z10 = iE0 == 0 || com.stepos.statsrpk.h.v(str.charAt(iE0 + (-1)));
                int length2 = str3.length() + iE0;
                boolean z11 = length2 >= str.length() || com.stepos.statsrpk.h.v(str.charAt(length2)) || str.charAt(length2) == '=';
                if (z10 && z11) {
                    if (length2 < str.length() && str.charAt(length2) == '=') {
                        length2++;
                    }
                    while (length2 < str.length() && com.stepos.statsrpk.h.v(str.charAt(length2))) {
                        length2++;
                    }
                    if (length2 < str.length()) {
                        char cCharAt = str.charAt(length2);
                        if (cCharAt == '\"' || cCharAt == '\'') {
                            int i = length2 + 1;
                            int length3 = i;
                            while (true) {
                                if (length3 >= str.length()) {
                                    length3 = str.length();
                                    break;
                                }
                                char cCharAt2 = str.charAt(length3);
                                if (cCharAt2 == '\\' && length3 + 1 < str.length()) {
                                    length3 += 2;
                                } else {
                                    if (cCharAt2 == cCharAt) {
                                        break;
                                    }
                                    length3++;
                                }
                            }
                            return str.substring(i, length3);
                        }
                        ec.a it2 = p5.f.O(length2, str.length()).iterator();
                        while (true) {
                            if (!it2.f3752h) {
                                next = null;
                                break;
                            }
                            next = it2.next();
                            if (com.stepos.statsrpk.h.v(str.charAt(((Number) next).intValue()))) {
                                break;
                            }
                        }
                        Integer num = (Integer) next;
                        String strSubstring = str.substring(length2, num != null ? num.intValue() : str.length());
                        if (strSubstring.length() > 0) {
                            return strSubstring;
                        }
                    }
                } else {
                    length = iE0 + str3.length();
                }
            }
        }
        return null;
    }

    public static String b(String str, JSONObject jSONObject) {
        String strB0;
        List<String> listE;
        if (jSONObject == null || jSONObject.length() == 0) {
            strB0 = "";
        } else {
            ArrayList arrayList = new ArrayList();
            List<String> list = f16507c;
            for (String str2 : list) {
                if (jSONObject.has(str2)) {
                    q.p0(g(str2, jSONObject), arrayList);
                }
            }
            List<String> list2 = f16508d;
            for (String str3 : list2) {
                if (jSONObject.has(str3)) {
                    q.p0(g(str3, jSONObject), arrayList);
                }
            }
            LinkedHashSet linkedHashSetR = b0.R(b0.R(f16506b, list), list2);
            Iterator<String> itKeys = jSONObject.keys();
            itKeys.getClass();
            gc.k kVarR = m.R(itKeys);
            a9.e eVar = new a9.e(20);
            eVar.f257f = linkedHashSetR;
            VarHandle.storeStoreFence();
            gc.h hVar = new gc.h(kVarR, true, eVar);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = hVar.iterator();
            while (true) {
                gc.g gVar = (gc.g) it;
                if (!gVar.hasNext()) {
                    break;
                }
                arrayList2.add(gVar.next());
            }
            p.n0(arrayList2);
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                Object next = it2.next();
                if (it2.hasNext()) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(next);
                    while (it2.hasNext()) {
                        arrayList3.add(it2.next());
                    }
                    listE = arrayList3;
                } else {
                    listE = ac.a.E(next);
                }
            } else {
                listE = s.f7404c;
            }
            for (String str4 : listE) {
                Object objOpt = jSONObject.opt(str4);
                if (objOpt != null && !objOpt.equals(JSONObject.NULL)) {
                    if ((objOpt instanceof Boolean) || (objOpt instanceof Number)) {
                        arrayList.add(str4 + "=" + objOpt);
                    } else if (objOpt instanceof String) {
                        if (!h.g0((CharSequence) objOpt)) {
                            arrayList.add(str4 + "=" + objOpt);
                        }
                    } else if (objOpt instanceof JSONArray) {
                        str4.getClass();
                        List listG = g(str4, jSONObject);
                        if (!listG.isEmpty()) {
                            arrayList.add(str4 + "=" + l.B0(listG, ",", null, null, null, 62));
                        }
                    }
                }
            }
            strB0 = l.B0(arrayList, " ", null, null, null, 62);
        }
        return h.g0(strB0) ? str : k0.a.o(str, " ", strB0);
    }

    public static JSONObject c(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("params")) {
            return null;
        }
        Object objOpt = jSONObject.opt("params");
        if (objOpt instanceof JSONObject) {
            return (JSONObject) objOpt;
        }
        if (objOpt instanceof String) {
            return d((String) objOpt);
        }
        return null;
    }

    public static JSONObject d(String str) {
        Object objL;
        String string = str != null ? h.w0(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0 || string.charAt(0) != '{') {
            return null;
        }
        try {
            objL = new JSONObject(string);
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        return (JSONObject) (objL instanceof jb.h ? null : objL);
    }

    public static String e(String str, String str2) {
        String str3;
        String strOptString;
        String strOptString2;
        String strM0 = h.m0(h.m0(h.w0(str).toString(), "\""), "'");
        JSONObject jSONObjectD = d(str2);
        if (strM0.equals("stepclaw.exec")) {
            String string = (jSONObjectD == null || (strOptString2 = jSONObjectD.optString("tool")) == null) ? null : h.w0(strOptString2).toString();
            str3 = string != null ? string : "";
            if (str3.length() != 0) {
                return b(str3, jSONObjectD);
            }
        } else if (strM0.equals("ability.call")) {
            String string2 = (jSONObjectD == null || (strOptString = jSONObjectD.optString("method")) == null) ? null : h.w0(strOptString).toString();
            str3 = string2 != null ? string2 : "";
            if (str3.length() != 0) {
                return b(str3, c(jSONObjectD));
            }
        } else if (!h.g0(strM0)) {
            return strM0;
        }
        return null;
    }

    public static final void f(StringBuilder sb2, ArrayList arrayList) {
        String string = h.w0(sb2.toString()).toString();
        sb2.setLength(0);
        if (string.length() > 0) {
            arrayList.add(string);
        }
    }

    public static List g(String str, JSONObject jSONObject) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt != null && !objOpt.equals(JSONObject.NULL)) {
            if (objOpt instanceof JSONArray) {
                lb.c cVarO = ac.a.o();
                JSONArray jSONArray = (JSONArray) objOpt;
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object objOpt2 = jSONArray.opt(i);
                    if (objOpt2 != null && !objOpt2.equals(JSONObject.NULL)) {
                        cVarO.add(objOpt2.toString());
                    }
                }
                return ac.a.k(cVarO);
            }
            String string = h.w0(objOpt.toString()).toString();
            if (string.length() != 0) {
                return ac.a.E(string);
            }
        }
        return s.f7404c;
    }
}
