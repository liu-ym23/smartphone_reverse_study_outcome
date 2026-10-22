package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    private Context f4930a;

    /* renamed from: b, reason: collision with root package name */
    private List f4931b = null;

    /* renamed from: c, reason: collision with root package name */
    private a f4932c = null;

    public interface a {
        void a(Object obj);
    }

    public g(Context context) {
        this.f4930a = context;
    }

    private List a(HashMap map, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap map2 = new HashMap();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String string = ((String) it.next()).toString();
                map2.put(string, map.get(string));
            }
            arrayList.add(map2);
        } else {
            for (String str : strArr) {
                HashMap map3 = new HashMap();
                Iterator it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    String string2 = ((String) it2.next()).toString();
                    map3.put(string2, map.get(string2));
                }
                map3.put("mcode", str);
                arrayList.add(map3);
            }
        }
        return arrayList;
    }

    private void a(String str) throws JSONException {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        a aVar = this.f4932c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    public void a(HashMap map, String[] strArr, String str, int i4, String str2, String str3, a aVar) {
        this.f4931b = a(map, strArr);
        this.f4932c = aVar;
        new Thread(new h(this, str, i4, str2, str3)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list, String str, int i4, String str2, String str3) throws Throwable {
        int i5;
        b.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            b.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < list.size()) {
            b.a(B0.g.j("syncConnect resuest ", i6, "  start!!!"));
            HashMap map = (HashMap) list.get(i6);
            i iVar = new i(this.f4930a);
            if (iVar.a()) {
                String strA = iVar.a(map, str, i4, str2, str3);
                if (strA == null) {
                    strA = "";
                }
                b.a("syncConnect resuest " + i6 + "  result:" + strA);
                arrayList.add(strA);
                try {
                    JSONObject jSONObject = new JSONObject(strA);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        b.a("auth end and break");
                        a(strA);
                        return;
                    }
                } catch (JSONException unused) {
                    b.a("continue-------------------------------");
                }
            } else {
                b.a("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            b.a("syncConnect end");
            i6++;
        }
        StringBuilder sbT = B0.g.t("--iiiiii:", i6, "<><>paramList.size():");
        sbT.append(list.size());
        sbT.append("<><>authResults.size():");
        sbT.append(arrayList.size());
        b.a(sbT.toString());
        if (list.size() <= 0 || i6 != list.size() || arrayList.size() <= 0 || i6 != arrayList.size() || i6 - 1 <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i5));
            if (!jSONObject2.has("status") || jSONObject2.getInt("status") == 0) {
                return;
            }
            b.a("i-1 result is not 0,return first result");
            a((String) arrayList.get(0));
        } catch (JSONException e4) {
            a(ErrorMessage.a("JSONException:" + e4.getMessage()));
        }
    }
}
