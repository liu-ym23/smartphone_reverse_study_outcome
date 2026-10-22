package H;

import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w2.AbstractC2095a;
import x0.C2112a;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f710a;
    public final /* synthetic */ JSONObject b;

    public /* synthetic */ f(int i, JSONObject jSONObject) {
        this.f710a = i;
        this.b = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f710a) {
            case 0:
                O.a aVarG = O.a.g();
                P.d dVar = new P.d();
                JSONObject jSONObject = this.b;
                dVar.f1056a = jSONObject;
                aVarG.c(dVar);
                if (h.b) {
                    StringBuilder sb = new StringBuilder("Receive:FlutterData \n");
                    sb.append(jSONObject != null ? jSONObject.toString() : "");
                    Log.d("ApmInsight", U7.a.e(new String[]{sb.toString()}));
                    break;
                }
                break;
            case 1:
                CopyOnWriteArrayList copyOnWriteArrayList = S0.b.g;
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((Q1.b) ((C.b) it.next())).getClass();
                        JSONArray jSONArrayOptJSONArray = this.b.optJSONArray("cloud_commands");
                        if (jSONArrayOptJSONArray != null) {
                            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                String strOptString = jSONArrayOptJSONArray.optString(i);
                                Q1.a aVarB = Q1.a.b();
                                aVarB.b.execute(new A.a(7, aVarB, strOptString));
                            }
                        }
                    }
                    break;
                }
                break;
            case 2:
                P.e eVar = new P.e("page_load_trace", "", "", null, null, this.b);
                eVar.f = O0.a.a().b();
                O.a.g().c(eVar);
                try {
                    JSONObject jSONObjectA = eVar.a();
                    if (jSONObjectA != null) {
                        C2112a.c.a(jSONObjectA.toString());
                        break;
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 3:
                JSONObject jSONObject2 = this.b;
                String javaCrashUploadUrl = com.apm.insight.g.g.getJavaCrashUploadUrl();
                try {
                    jSONObject2.put("upload_scene", "direct");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AbstractC2095a.g(javaCrashUploadUrl, jSONObject2.toString(), false);
                break;
            default:
                try {
                    StringBuilder sb2 = new StringBuilder(com.apm.insight.g.g.getCrashPortraitUploadUrl());
                    String strJ = com.apm.insight.f.j();
                    sb2.append("?os=Android");
                    if (!TextUtils.isEmpty(strJ)) {
                        sb2.append("&aid=" + strJ);
                        String strI = com.apm.insight.f.i(strJ);
                        sb2.append(TextUtils.isEmpty(strI) ? "&device_id=null_device_id" : "&device_id=" + strI);
                    }
                    AbstractC2095a.g(sb2.toString(), this.b.toString(), true);
                    break;
                } catch (Throwable unused2) {
                    return;
                }
        }
    }
}
