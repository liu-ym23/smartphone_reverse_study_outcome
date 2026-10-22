package t0;

import a2.p;
import a2.q;
import android.database.SQLException;
import android.os.Bundle;
import android.util.LongSparseArray;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k0.s;
import k0.z;
import nc.j0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w.o;
import w0.m;
import y8.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {
    public static final v.k a() {
        v.k kVar = new v.k();
        kVar.f14312a = new j0(0, 16, mc.a.f8551f);
        VarHandle.storeStoreFence();
        return kVar;
    }

    public static final void b(s sVar, m mVar) {
        o oVar = o.f15015c;
        int iR = z.r(sVar);
        m mVarM = t.o.m(sVar, mVar);
        s0.g gVarL = sVar.l();
        u1.j.f13840e.getClass();
        u1.z zVar = u1.i.f13833b;
        sVar.b0();
        if (sVar.S) {
            sVar.k(zVar);
        } else {
            sVar.l0();
        }
        z.B(oVar, sVar, u1.i.f13836e);
        z.B(gVarL, sVar, u1.i.f13835d);
        z.B(mVarM, sVar, u1.i.f13834c);
        u1.h hVar = u1.i.f13837f;
        if (sVar.S || !yb.k.a(sVar.M(), Integer.valueOf(iR))) {
            k0.a.y(iR, sVar, iR, hVar);
        }
        sVar.q(true);
    }

    public static void c(y0.d dVar, LongSparseArray longSparseArray) {
        TranslationResponseValue value;
        CharSequence text;
        q qVar;
        p pVar;
        xb.l lVar;
        int size = longSparseArray.size();
        int i = 0;
        for (int i3 = 0; i3 < size; i3++) {
            long jKeyAt = longSparseArray.keyAt(i3);
            ViewTranslationResponse viewTranslationResponse = (ViewTranslationResponse) longSparseArray.get(jKeyAt);
            if (viewTranslationResponse != null && (value = viewTranslationResponse.getValue("android:text")) != null && (text = value.getText()) != null && (qVar = (q) dVar.f().b((int) jKeyAt)) != null && (pVar = qVar.f92a) != null) {
                Object objG = pVar.f88d.f75c.g(a2.j.f59k);
                if (objG == null) {
                    objG = null;
                }
                a2.a aVar = (a2.a) objG;
                if (aVar != null && (lVar = (xb.l) aVar.f30b) != null) {
                }
            }
        }
    }

    public static final void d(x4.a aVar, String str) {
        aVar.getClass();
        x4.c cVarK = aVar.K(str);
        try {
            cVarK.G();
            t2.a.h(cVarK, null);
        } finally {
        }
    }

    public static final String e(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class f(yb.e eVar) {
        eVar.getClass();
        Class clsA = eVar.a();
        if (!clsA.isPrimitive()) {
            return clsA;
        }
        String name = clsA.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (!name.equals("float")) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return clsA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [jb.h] */
    public static List g(String str) {
        List listL;
        List listK;
        List list = kb.s.f7404c;
        if (str == null || hc.h.g0(str)) {
            return list;
        }
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("contacts");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            lb.c cVarO = ac.a.o();
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("truth_id");
                    strOptString.getClass();
                    long jOptLong = jSONObjectOptJSONObject.optLong("backup_id");
                    String strOptString2 = jSONObjectOptJSONObject.optString("display_name");
                    strOptString2.getClass();
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("phone_numbers");
                    if (jSONArrayOptJSONArray2 == null) {
                        listK = list;
                    } else {
                        lb.c cVarO2 = ac.a.o();
                        int length2 = jSONArrayOptJSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            String strOptString3 = jSONArrayOptJSONArray2.optString(i3);
                            if (strOptString3 != null) {
                                String str2 = !hc.h.g0(strOptString3) ? strOptString3 : null;
                                if (str2 != null) {
                                    cVarO2.add(str2);
                                }
                            }
                        }
                        listK = ac.a.k(cVarO2);
                    }
                    String strOptString4 = jSONObjectOptJSONObject.optString("photo_uri");
                    strOptString4.getClass();
                    String str3 = !hc.h.g0(strOptString4) ? strOptString4 : null;
                    boolean z10 = (jSONObjectOptJSONObject.has("deleted") && (jSONObjectOptJSONObject.get("deleted") instanceof Boolean)) ? jSONObjectOptJSONObject.getBoolean("deleted") : jSONObjectOptJSONObject.optInt("deleted", 1) == 1;
                    listK.getClass();
                    v8.a aVar = new v8.a();
                    aVar.f14850a = strOptString;
                    aVar.f14851b = jOptLong;
                    aVar.f14852c = strOptString2;
                    aVar.f14853d = listK;
                    aVar.f14854e = str3;
                    aVar.f14855f = z10;
                    VarHandle.storeStoreFence();
                    cVarO.add(aVar);
                }
            }
            listL = ac.a.k(cVarO);
        } catch (Throwable th) {
            listL = id.c.l(th);
        }
        if (jb.i.b(listL) == null) {
            list = listL;
        }
        return list;
    }

    public static String h(String str, Set set, Map map) throws JSONException {
        Object objL;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        str.getClass();
        set.getClass();
        map.getClass();
        if (!hc.h.g0(str) && !set.isEmpty()) {
            try {
                objL = new JSONObject(str);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            if (objL instanceof jb.h) {
                objL = null;
            }
            JSONObject jSONObject = (JSONObject) objL;
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                boolean z10 = false;
                if ((jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("tasks")) != null) || (jSONArrayOptJSONArray = jSONObject.optJSONArray("tasks")) != null) {
                    int length = jSONArrayOptJSONArray.length();
                    boolean z11 = false;
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("steps")) != null) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i3);
                                if (jSONObjectOptJSONObject3 != null) {
                                    String strOptString = jSONObjectOptJSONObject3.optString("tool_call_id");
                                    if (hc.h.g0(strOptString)) {
                                        strOptString = jSONObjectOptJSONObject3.optString("id");
                                    }
                                    strOptString.getClass();
                                    String string = hc.h.w0(strOptString).toString();
                                    if (string.length() <= 0) {
                                        String strOptString2 = jSONObjectOptJSONObject3.optString("what");
                                        if (hc.h.g0(strOptString2)) {
                                            strOptString2 = jSONObjectOptJSONObject3.optString("command_summary");
                                        }
                                        String strOptString3 = jSONObjectOptJSONObject3.optString("when");
                                        if (hc.h.g0(strOptString3)) {
                                            strOptString3 = jSONObjectOptJSONObject3.optString("create_time_str");
                                        }
                                        string = "w:" + strOptString2.hashCode() + "|t:" + strOptString3;
                                    }
                                    if (set.contains(string)) {
                                        jSONObjectOptJSONObject3.put("undo", "undo_revoked");
                                        if (jSONObjectOptJSONObject3.has("undo_state")) {
                                            jSONObjectOptJSONObject3.put("undo_state", "undo_revoked");
                                        }
                                        if (jSONObjectOptJSONObject3.has("recoverable")) {
                                            jSONObjectOptJSONObject3.put("recoverable", true);
                                        }
                                        if (jSONObjectOptJSONObject3.has("undoable")) {
                                            jSONObjectOptJSONObject3.put("undoable", false);
                                        }
                                        String str2 = (String) map.get(string);
                                        if (str2 != null) {
                                            if (hc.h.g0(str2)) {
                                                str2 = null;
                                            }
                                            if (str2 != null) {
                                                jSONObjectOptJSONObject3.put("undo_outcome_text", str2);
                                            }
                                        }
                                        z11 = true;
                                    }
                                }
                            }
                        }
                    }
                    z10 = z11;
                }
                if (!z10) {
                    return str;
                }
                String string2 = jSONObject.toString();
                string2.getClass();
                return string2;
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f5  */
    /* JADX WARN: Type inference failed for: r4v10, types: [kb.s] */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(com.stepos.agentsafetycenter.mcp.service.AbilityService r19, java.lang.String r20, lb.c r21, a9.j r22) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.a.i(com.stepos.agentsafetycenter.mcp.service.AbilityService, java.lang.String, lb.c, a9.j):void");
    }

    public static final Object j(Object[] objArr, k kVar, xb.a aVar, s sVar, int i, int i3) {
        Object objC;
        if ((i3 & 2) != 0) {
            kVar = l.f13125a;
            kVar.getClass();
        }
        long j10 = sVar.T;
        com.stepos.statsrpk.h.f(36);
        String string = Long.toString(j10, 36);
        string.getClass();
        kVar.getClass();
        g gVar = (g) sVar.j(i.f13120a);
        Object objM = sVar.M();
        Object obj = k0.m.f6974a;
        if (objM == obj) {
            Object objB = (gVar == null || (objC = gVar.c(string)) == null) ? null : kVar.b(objC);
            if (objB == null) {
                objB = aVar.invoke();
            }
            b bVar = new b();
            bVar.f13106c = kVar;
            bVar.f13107f = gVar;
            bVar.f13108g = string;
            bVar.f13109h = objB;
            bVar.i = objArr;
            ab.e eVar = new ab.e(14);
            eVar.f393f = bVar;
            VarHandle.storeStoreFence();
            bVar.f13111k = eVar;
            VarHandle.storeStoreFence();
            sVar.i0(bVar);
            objM = bVar;
        }
        b bVar2 = (b) objM;
        Object objInvoke = Arrays.equals(objArr, bVar2.i) ? bVar2.f13109h : null;
        if (objInvoke == null) {
            objInvoke = aVar.invoke();
        }
        int i10 = 1;
        boolean zH = sVar.h(bVar2) | ((((i & 112) ^ 48) > 32 && sVar.h(kVar)) || (i & 48) == 32) | sVar.h(gVar) | sVar.f(string) | sVar.h(objInvoke) | sVar.h(objArr);
        Object objM2 = sVar.M();
        Object obj2 = objM2;
        if (zH || objM2 == obj) {
            k8.o oVar = new k8.o(i10);
            oVar.f7328f = bVar2;
            oVar.f7329g = kVar;
            oVar.f7330h = gVar;
            oVar.i = string;
            oVar.f7331j = objInvoke;
            oVar.f7332k = objArr;
            VarHandle.storeStoreFence();
            sVar.i0(oVar);
            obj2 = oVar;
        }
        z.j((xb.a) obj2, sVar);
        return objInvoke;
    }

    public static u8.p k(String str) {
        String lowerCase;
        String string;
        if (str == null || (string = hc.h.w0(str).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            lowerCase.getClass();
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != 3387378) {
                if (iHashCode != 951526432) {
                    if (iHashCode == 1860792298 && lowerCase.equals("file_manager")) {
                        return u8.p.f14243c;
                    }
                } else if (lowerCase.equals("contact")) {
                    return u8.p.f14244f;
                }
            } else if (lowerCase.equals("note")) {
                return u8.p.f14245g;
            }
        }
        return u8.p.f14246h;
    }

    public static final void l(int i, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error code: " + i);
        sb2.append(", message: ".concat(str));
        throw new SQLException(sb2.toString());
    }

    public static final Bundle m(v vVar) {
        vVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt("code", vVar.f16006a);
        bundle.putString("message", vVar.f16007b);
        bundle.putInt("schema_version", 1);
        bundle.putLong("updated_at_ms", vVar.f16008c);
        bundle.putBoolean("from_cache", vVar.f16009d);
        bundle.putBoolean("stale", vVar.f16010e);
        bundle.putString("payload_json", vVar.f16011f);
        return bundle;
    }
}
