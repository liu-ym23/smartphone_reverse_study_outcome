package t8;

import android.content.SharedPreferences;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kb.l;
import kb.m;
import kb.s;
import kb.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s8.g1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f13218c;

    /* renamed from: e, reason: collision with root package name */
    public static volatile c f13220e;

    /* renamed from: g, reason: collision with root package name */
    public static volatile c f13222g;
    public static volatile c i;

    /* renamed from: a, reason: collision with root package name */
    public w4.e f13224a;

    /* renamed from: b, reason: collision with root package name */
    public static final r2.i f13217b = new r2.i(13);

    /* renamed from: d, reason: collision with root package name */
    public static final r2.i f13219d = new r2.i(14);

    /* renamed from: f, reason: collision with root package name */
    public static final r2.i f13221f = new r2.i(15);

    /* renamed from: h, reason: collision with root package name */
    public static final r2.i f13223h = new r2.i(16);

    public e a(String str) {
        Object next;
        str.getClass();
        ListIterator listIterator = e().listIterator(0);
        while (true) {
            lb.a aVar = (lb.a) listIterator;
            if (!aVar.hasNext()) {
                next = null;
                break;
            }
            next = aVar.next();
            if (((e) next).f13226a.equals(str)) {
                break;
            }
        }
        return (e) next;
    }

    public boolean b(String str) {
        str.getClass();
        String string = hc.h.w0(str).toString();
        if (string.length() == 0) {
            return false;
        }
        return g().containsKey(string) || h().contains(string);
    }

    public ArrayList c() {
        Object objL;
        String string = this.f13224a.getString("receipts", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            String string2 = jSONObject.getString("stepId");
            string2.getClass();
            String string3 = jSONObject.getString("originalPath");
            string3.getClass();
            String string4 = jSONObject.getString("normalizedPath");
            string4.getClass();
            try {
                String string5 = jSONObject.getString("deleteMethod");
                string5.getClass();
                objL = a.valueOf(string5);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            Object obj = a.f13209h;
            if (objL instanceof jb.h) {
                objL = obj;
            }
            a aVar = (a) objL;
            String strOptString = jSONObject.optString("trashUri");
            strOptString.getClass();
            if (hc.h.g0(strOptString)) {
                strOptString = null;
            }
            String strOptString2 = jSONObject.optString("trashRealPath");
            strOptString2.getClass();
            arrayList.add(new b(string2, string3, string4, aVar, strOptString, !hc.h.g0(strOptString2) ? strOptString2 : null, jSONObject.getLong("deletedAtMs")));
        }
        return arrayList;
    }

    public List d() throws JSONException {
        String string = this.f13224a.getString("records", null);
        if (string == null) {
            return s.f7404c;
        }
        JSONArray jSONArray = new JSONArray(string);
        lb.c cVarO = ac.a.o();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            jSONObject.getClass();
            String string2 = jSONObject.getString("revokeKey");
            string2.getClass();
            String string3 = jSONObject.getString("sessionId");
            string3.getClass();
            String string4 = jSONObject.getString("toolCallId");
            string4.getClass();
            String strOptString = jSONObject.optString("taskId");
            strOptString.getClass();
            long jOptLong = jSONObject.optLong("restoredAtMs");
            int iOptInt = jSONObject.optInt("retryCount");
            String strOptString2 = jSONObject.optString("lastError");
            strOptString2.getClass();
            if (hc.h.g0(strOptString2)) {
                strOptString2 = null;
            }
            f fVar = new f();
            fVar.f13233a = string2;
            fVar.f13234b = string3;
            fVar.f13235c = string4;
            fVar.f13236d = strOptString;
            fVar.f13237e = jOptLong;
            fVar.f13238f = iOptInt;
            fVar.f13239g = strOptString2;
            VarHandle.storeStoreFence();
            cVarO.add(fVar);
        }
        return ac.a.k(cVarO);
    }

    public lb.c e() {
        List listK;
        Object objL;
        String string = this.f13224a.getString("records", "[]");
        JSONArray jSONArray = new JSONArray(string != null ? string : "[]");
        lb.c cVarO = ac.a.o();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            jSONObject.getClass();
            String string2 = jSONObject.getString("truthId");
            string2.getClass();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray == null) {
                listK = s.f7404c;
            } else {
                lb.c cVarO2 = ac.a.o();
                int length2 = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length2; i10++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i10);
                    strOptString.getClass();
                    String string3 = hc.h.w0(strOptString).toString();
                    if (string3.length() > 0) {
                        cVarO2.add(string3);
                    }
                }
                listK = ac.a.k(cVarO2);
            }
            List list = listK;
            boolean z10 = jSONObject.getBoolean("success");
            try {
                String string4 = jSONObject.getString("deleteMethod");
                string4.getClass();
                objL = a.valueOf(string4);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            Object obj = a.f13209h;
            if (objL instanceof jb.h) {
                objL = obj;
            }
            a aVar = (a) objL;
            int iOptInt = jSONObject.optInt("affectedCount");
            long j10 = jSONObject.getLong("executedAtMs");
            String strOptString2 = jSONObject.optString("trashRealPath");
            strOptString2.getClass();
            if (hc.h.g0(strOptString2)) {
                strOptString2 = null;
            }
            cVarO.add(new e(string2, list, z10, aVar, iOptInt, j10, strOptString2));
        }
        return ac.a.k(cVarO);
    }

    public LinkedHashMap f() {
        Object objL;
        String string = this.f13224a.getString("revoked_outcomes", null);
        if (string == null) {
            return new LinkedHashMap();
        }
        try {
            objL = new JSONObject(string);
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        if (objL instanceof jb.h) {
            objL = null;
        }
        JSONObject jSONObject = (JSONObject) objL;
        if (jSONObject == null) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        itKeys.getClass();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strP = k0.a.p(next, jSONObject);
            if (strP.length() <= 0) {
                strP = null;
            }
            if (strP != null) {
                linkedHashMap.put(next, strP);
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap g() {
        Object objL;
        Object objL2;
        w4.e eVar = this.f13224a;
        String string = eVar.getString("revoked_keys", null);
        if (string != null) {
            try {
                objL = new JSONArray(string);
            } catch (Throwable th) {
                objL = id.c.l(th);
            }
            if (objL instanceof jb.h) {
                objL = null;
            }
            JSONArray jSONArray = (JSONArray) objL;
            if (jSONArray == null) {
                w4.d dVar = (w4.d) eVar.edit();
                dVar.remove("revoked_keys");
                dVar.apply();
            } else {
                Set setN0 = l.N0(h());
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String strOptString = jSONArray.optString(i3);
                    strOptString.getClass();
                    String string2 = hc.h.w0(strOptString).toString();
                    if (string2.length() <= 0) {
                        string2 = null;
                    }
                    if (string2 != null) {
                        setN0.add(string2);
                    }
                }
                w4.d dVar2 = (w4.d) eVar.edit();
                dVar2.putStringSet("revoked_untimed_keys", setN0);
                dVar2.remove("revoked_keys");
                dVar2.apply();
            }
        }
        String string3 = eVar.getString("revoked_records", null);
        if (string3 == null) {
            return new LinkedHashMap();
        }
        try {
            objL2 = new JSONObject(string3);
        } catch (Throwable th2) {
            objL2 = id.c.l(th2);
        }
        JSONObject jSONObject = (JSONObject) (objL2 instanceof jb.h ? null : objL2);
        if (jSONObject == null) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        itKeys.getClass();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            long jOptLong = jSONObject.optLong(next, 0L);
            if (jOptLong > 0) {
                linkedHashMap.put(next, Long.valueOf(jOptLong));
            }
        }
        return linkedHashMap;
    }

    public Set h() {
        w4.e eVar = this.f13224a;
        u uVar = u.f7406c;
        Set stringSet = eVar.getStringSet("revoked_untimed_keys", uVar);
        return stringSet == null ? uVar : stringSet;
    }

    public void i(Collection collection, long j10, Map map) {
        String string;
        map.getClass();
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(m.m0(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            k0.a.A((String) it.next(), arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        LinkedHashMap linkedHashMapG = g();
        Set setN0 = l.N0(h());
        LinkedHashMap linkedHashMap = new LinkedHashMap(f());
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            String str = (String) obj2;
            linkedHashMapG.put(str, Long.valueOf(j10));
            setN0.remove(str);
            String str2 = (String) map.get(str);
            if (str2 != null && (string = hc.h.w0(str2).toString()) != null) {
                if (string.length() <= 0) {
                    string = null;
                }
                if (string != null) {
                    linkedHashMap.put(str, string);
                }
            }
        }
        k(linkedHashMapG, setN0, linkedHashMap);
    }

    public void j(ArrayList arrayList) {
        SharedPreferences.Editor editorEdit = this.f13224a.edit();
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            e eVar = (e) obj;
            eVar.getClass();
            JSONObject jSONObjectPut = new JSONObject().put("truthId", eVar.f13226a).put("paths", new JSONArray((Collection) eVar.f13227b)).put("success", eVar.f13228c).put("deleteMethod", eVar.f13229d.name()).put("affectedCount", eVar.f13230e).put("executedAtMs", eVar.f13231f);
            String str = eVar.f13232g;
            if (str == null) {
                str = "";
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("trashRealPath", str);
            jSONObjectPut2.getClass();
            jSONArray.put(jSONObjectPut2);
        }
        String string = jSONArray.toString();
        string.getClass();
        w4.d dVar = (w4.d) editorEdit;
        dVar.putString("records", string);
        dVar.apply();
    }

    public void k(LinkedHashMap linkedHashMap, Set set, LinkedHashMap linkedHashMap2) {
        JSONObject jSONObject = new JSONObject();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((Number) entry.getValue()).longValue() > 0) {
                linkedHashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : new TreeMap(linkedHashMap3).entrySet()) {
            String str = (String) entry2.getKey();
            Long l2 = (Long) entry2.getValue();
            l2.getClass();
            jSONObject.put(str, l2.longValue());
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            if (!linkedHashMap.keySet().contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        Set<String> setO0 = l.O0(arrayList);
        JSONObject jSONObject2 = new JSONObject();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            String str2 = (String) entry3.getKey();
            if (linkedHashMap.keySet().contains(str2) || setO0.contains(str2)) {
                linkedHashMap4.put(entry3.getKey(), entry3.getValue());
            }
        }
        for (Map.Entry entry4 : new TreeMap(linkedHashMap4).entrySet()) {
            jSONObject2.put((String) entry4.getKey(), (String) entry4.getValue());
        }
        w4.d dVar = (w4.d) this.f13224a.edit();
        dVar.putString("revoked_records", jSONObject.toString());
        dVar.putStringSet("revoked_untimed_keys", setO0);
        dVar.putString("revoked_outcomes", jSONObject2.toString());
        dVar.apply();
    }

    public void l(long j10) {
        lb.c cVarE = e();
        ArrayList arrayList = new ArrayList();
        ListIterator listIterator = cVarE.listIterator(0);
        while (true) {
            lb.a aVar = (lb.a) listIterator;
            if (!aVar.hasNext()) {
                break;
            }
            Object next = aVar.next();
            if (((e) next).f13231f >= j10) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() != cVarE.a()) {
            j(arrayList);
        }
    }

    public void m(String str) {
        String string = hc.h.w0(str).toString();
        if (string.length() == 0) {
            return;
        }
        List listD = d();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listD) {
            if (!((f) obj).f13233a.equals(string)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == d().size()) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f13224a.edit();
        JSONArray jSONArray = new JSONArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            f fVar = (f) obj2;
            fVar.getClass();
            JSONObject jSONObjectPut = new JSONObject().put("revokeKey", fVar.f13233a).put("sessionId", fVar.f13234b).put("toolCallId", fVar.f13235c).put("taskId", fVar.f13236d).put("restoredAtMs", fVar.f13237e).put("retryCount", fVar.f13238f);
            String str2 = fVar.f13239g;
            if (str2 == null) {
                str2 = "";
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("lastError", str2);
            jSONObjectPut2.getClass();
            jSONArray.put(jSONObjectPut2);
        }
        String string2 = jSONArray.toString();
        string2.getClass();
        w4.d dVar = (w4.d) editorEdit;
        dVar.putString("records", string2);
        dVar.apply();
    }

    public void n(b bVar) {
        ArrayList arrayListC = c();
        ArrayList arrayList = new ArrayList();
        int size = arrayListC.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListC.get(i10);
            i10++;
            b bVar2 = (b) obj;
            if (!yb.k.a(bVar2.f13210a, bVar.f13210a) || !yb.k.a(g1.H(bVar2.f13212c), g1.H(bVar.f13212c))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        arrayList2.add(bVar);
        JSONArray jSONArray = new JSONArray();
        int size2 = arrayList2.size();
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            b bVar3 = (b) obj2;
            JSONObject jSONObjectPut = new JSONObject().put("stepId", bVar3.f13210a).put("originalPath", bVar3.f13211b).put("normalizedPath", bVar3.f13212c).put("deleteMethod", bVar3.f13213d.name());
            String str = bVar3.f13214e;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            JSONObject jSONObjectPut2 = jSONObjectPut.put("trashUri", str);
            String str3 = bVar3.f13215f;
            if (str3 != null) {
                str2 = str3;
            }
            jSONArray.put(jSONObjectPut2.put("trashRealPath", str2).put("deletedAtMs", bVar3.f13216g));
        }
        w4.d dVar = (w4.d) this.f13224a.edit();
        dVar.putString("receipts", jSONArray.toString());
        dVar.apply();
    }
}
