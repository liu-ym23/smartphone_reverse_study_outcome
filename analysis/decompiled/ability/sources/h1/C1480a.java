package h1;

import H.h;
import android.app.Application;
import android.util.Log;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g1.AbstractC1451a;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import s1.AbstractRunnableC1911a;
import s2.C1912a;

/* renamed from: h1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1480a extends AbstractRunnableC1911a {
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Throwable f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1480a(String str, String str2, Throwable th) {
        super(0L);
        this.d = str;
        this.e = str2;
        this.f = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.d;
        String str2 = this.e;
        cc.dd.ee.ff.dd.a aVar = new cc.dd.ee.ff.dd.a(B7.a.n("tag=", str, " message=", str2), this.f);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "exception");
            jSONObject.put("timestamp", System.currentTimeMillis());
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            aVar.printStackTrace(printWriter);
            Throwable cause = aVar.getCause();
            if (cause != null) {
                cause.printStackTrace(printWriter);
                Throwable cause2 = cause.getCause();
                if (cause2 != null) {
                    cause2.printStackTrace(printWriter);
                }
            }
            String string = stringWriter.toString();
            printWriter.close();
            jSONObject.put("stack", string);
            jSONObject.put("exception_type", 1);
            jSONObject.put("message", str + "_" + str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("apm_sdk", "apm6_error");
            jSONObject2.put("host_aid", String.valueOf(AbstractC1451a.q()));
            jSONObject.put("filters", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject3.put(SettingsConfig.KEY_DATA, jSONArray);
            JSONObject jSONObject4 = new JSONObject();
            S0.b.z0(jSONObject4, AbstractC1451a.K());
            if (AbstractC1451a.c != null) {
                S0.b.z0(jSONObject4, C1912a.b());
            }
            jSONObject4.put("os", "Android");
            jSONObject4.put("aid", 2085);
            jSONObject4.put("device_id", AbstractC1451a.C());
            jSONObject4.put("channel", AbstractC1451a.z());
            jSONObject4.put("version_code", AbstractC1451a.O());
            jSONObject4.put("update_version_code", AbstractC1451a.M());
            jSONObject4.put("device_id", AbstractC1451a.C());
            AbstractC1451a.c.getClass();
            Application application = h.f711a;
            jSONObject4.put("uid", 0L);
            jSONObject4.put("process_name", AbstractC1451a.A());
            jSONObject3.put("header", jSONObject4);
            if (AbstractC1451a.f4467a) {
                Log.e("APM-CustomException", "tag:" + str + " message:" + str2, aVar);
            }
            AbstractC1481b.c(AbstractC1481b.c, jSONObject3.toString().getBytes());
        } catch (Throwable unused) {
        }
    }
}
