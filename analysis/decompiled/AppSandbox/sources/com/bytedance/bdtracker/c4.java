package com.bytedance.bdtracker;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.widget.Toast;
import com.bytedance.applog.IPicker;
import com.bytedance.applog.simulate.SimulateLaunchActivity;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c4 extends AsyncTask<Void, Void, JSONObject> {
    public int a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final d g;

    public static void a(d dVar) {
        new c4(dVar).execute(new Void[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019b  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject doInBackground(java.lang.Void[] r28) throws org.json.JSONException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.c4.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2 = jSONObject;
        this.g.D.debug(Collections.singletonList("SimulateLoginTask"), "Simulate login with response: {}", jSONObject2);
        if (jSONObject2 == null) {
            Toast.makeText(this.g.n, "启动埋点验证|圈选失败，服务端无响应", 1).show();
            return;
        }
        String strOptString = jSONObject2.optString("message");
        String strOptString2 = jSONObject2.optString("Set-Cookie");
        int iOptInt = jSONObject2.optInt("status");
        if (SimulateLaunchActivity.entryMode == 1 && (jSONObjectOptJSONObject = jSONObject2.optJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA)) != null) {
            this.f = jSONObjectOptJSONObject.optString("mode", "").equals("log") ? SimulateLaunchActivity.DEBUG_LOG : SimulateLaunchActivity.BIND_QUERY;
        }
        if (iOptInt == 0 && "OK".equals(strOptString)) {
            if (SimulateLaunchActivity.DEBUG_LOG.equals(this.f)) {
                this.g.setRangersEventVerifyEnable(true, strOptString2);
                return;
            }
            IPicker picker = (this.g.getInitConfig() == null || this.g.getInitConfig().getPicker() == null) ? null : this.g.getInitConfig().getPicker();
            if (picker != null) {
                picker.setMarqueeCookie(strOptString2);
            }
            this.g.startSimulator(strOptString2);
            return;
        }
        if (iOptInt == 0 || !r.d(jSONObject2.optString("message"))) {
            this.g.D.warn(Collections.singletonList("SimulateLoginTask"), "Start simulator failed, please check server response: {}", jSONObject2);
            return;
        }
        Application application = this.g.n;
        StringBuilder sbA = a.a("启动埋点验证|圈选失败: ");
        sbA.append(jSONObject2.optString("message"));
        Toast.makeText(application, sbA.toString(), 1).show();
    }

    public c4(d dVar) {
        this.g = dVar;
        dVar.k.a = SimulateLaunchActivity.entryUrlPrefix;
        this.f = SimulateLaunchActivity.entryType;
        this.c = SimulateLaunchActivity.entryQrParam;
        this.e = dVar.getDid();
        String str = (String) dVar.getHeaderValue("resolution", null, String.class);
        if (r.d(str)) {
            String[] strArrSplit = str.split("x");
            this.b = Integer.parseInt(strArrSplit[0]);
            this.a = Integer.parseInt(strArrSplit[1]);
        }
        PackageInfo packageInfoA = k5.a(dVar.n, dVar.n.getApplicationInfo().packageName, 0);
        this.d = packageInfoA != null ? packageInfoA.versionName : "1.0.0";
        dVar.D.debug(Collections.singletonList("SimulateLoginTask"), "Simulate task init success", new Object[0]);
    }
}
