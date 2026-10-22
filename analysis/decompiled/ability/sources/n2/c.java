package n2;

import D7.N;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w2.AbstractC2095a;
import y2.e;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue f5346a = new ConcurrentLinkedQueue();

    static {
        new ConcurrentHashMap();
    }

    public static JSONArray a(Object obj, Throwable th, StackTraceElement[] stackTraceElementArr) {
        Iterator it = f5346a.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null && fVar.f2159a == obj) {
                JSONArray jSONArrayA = fVar.a(stackTraceElementArr, th);
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("aid", fVar.g());
                    jSONObject.put("lines", jSONArrayA);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
                return jSONArray;
            }
        }
        return null;
    }

    public static JSONArray b(String str) {
        f fVar;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        String[] strArrSplit = str.split("\n");
        Iterator it = f5346a.iterator();
        while (it.hasNext() && (fVar = (f) it.next()) != null) {
            String strG = fVar.g();
            int i = z2.b.f6926a;
            if (!z2.d.d(strG)) {
                AbstractC2095a.i();
            }
            z2.d dVar = (z2.d) z2.d.c.get(strG);
            if (dVar != null && (jSONObject = dVar.f6928a) != null && 1 == N.b(jSONObject, 0, "crash_module", "switcher") && dVar.e()) {
                JSONArray jSONArrayB = fVar.b(strArrSplit);
                if (!N.g(jSONArrayB)) {
                    jSONArray.put(fVar.c(CrashType.ANR, jSONArrayB, false));
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray c(String str, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("header")) != null) {
                String strValueOf = String.valueOf(jSONObjectOptJSONObject.opt("aid"));
                if (z2.b.e(strValueOf)) {
                    try {
                        String strH = f.h(strValueOf);
                        if (!TextUtils.isEmpty(strH)) {
                            jSONObjectOptJSONObject.put("x-auth-token", strH);
                        }
                    } catch (Throwable unused) {
                    }
                    if (TextUtils.isEmpty(jSONObjectOptJSONObject.optString("package"))) {
                        jSONArray2.put(jSONObjectOptJSONObject2);
                        break;
                    }
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("so_list");
                    if (!N.g(jSONArrayOptJSONArray)) {
                        for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                            if (str.contains(jSONArrayOptJSONArray.optString(i6))) {
                                jSONArray2.put(jSONObjectOptJSONObject2);
                                break;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return jSONArray2;
    }

    public static JSONArray d(Throwable th, File file) {
        f fVar;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement stackTraceElement = e.f6892a;
        ArrayList arrayList = new ArrayList();
        try {
            e.j(th, arrayList);
        } catch (Throwable unused) {
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
        Iterator it = f5346a.iterator();
        while (it.hasNext() && (fVar = (f) it.next()) != null) {
            String strG = fVar.g();
            int i = z2.b.f6926a;
            if (!z2.d.d(strG)) {
                AbstractC2095a.i();
            }
            z2.d dVar = (z2.d) z2.d.c.get(strG);
            if (dVar != null && dVar.c() && dVar.e()) {
                JSONArray jSONArrayA = fVar.a(stackTraceElementArr, th);
                if (!N.g(jSONArrayA)) {
                    jSONArray.put(fVar.c(CrashType.JAVA, jSONArrayA, false));
                }
            } else {
                S0.b.N("not enable javaCrash aid: " + fVar.g());
            }
        }
        if (N.g(jSONArray)) {
            return null;
        }
        try {
            M.a.o(new File(file, "all_data.json"), jSONArray);
        } catch (IOException unused2) {
        }
        return jSONArray;
    }

    public static void e(JSONObject jSONObject, JSONArray jSONArray, b bVar) {
        JSONObject jSONObjectOptJSONObject;
        S0.b.N("uploadFromFile with allData " + jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length() && (jSONObjectOptJSONObject = jSONArray.optJSONObject(i)) != null; i++) {
            if (N.b(jSONObjectOptJSONObject, 0, "header", "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                a.o(jSONObject2, jSONObject);
                a.o(jSONObject2, jSONObjectOptJSONObject);
                bVar.c(jSONObject2);
            } else {
                try {
                    String strH = f.h(N.k(jSONObjectOptJSONObject, "header", "aid"));
                    if (!TextUtils.isEmpty(strH)) {
                        JSONObject jSONObject3 = (JSONObject) jSONObjectOptJSONObject.remove("header");
                        jSONObject3.put("x-auth-token", strH);
                        jSONObjectOptJSONObject.put("header", jSONObject3);
                    }
                } catch (Throwable unused) {
                }
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject4 = new JSONObject();
        a.o(jSONObject4, jSONObject);
        try {
            jSONObject4.put("all_data", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.c(jSONObject4);
    }

    public static String f(Object obj) {
        Iterator it = f5346a.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null && fVar.f2159a == obj) {
                return fVar.g();
            }
        }
        return null;
    }

    public static JSONArray g() {
        f fVar;
        JSONArray jSONArray = new JSONArray();
        Iterator it = f5346a.iterator();
        while (it.hasNext() && (fVar = (f) it.next()) != null) {
            jSONArray.put(fVar.c(null, null, false));
        }
        return jSONArray;
    }

    public static JSONArray h(String str) {
        f fVar;
        JSONArray jSONArray = new JSONArray();
        Iterator it = f5346a.iterator();
        while (it.hasNext() && (fVar = (f) it.next()) != null) {
            if (z2.b.g(fVar.g()) && fVar.f(str) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("aid", fVar.g());
                    jSONObject.put("header", jSONObject2);
                    jSONArray.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }
}
