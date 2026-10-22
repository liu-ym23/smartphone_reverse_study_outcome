package i0;

import H.h;
import L0.e;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import ca.AbstractC0897f;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import g1.AbstractC1451a;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f4600a;
    public volatile boolean b;
    public volatile JSONObject c;
    public volatile JSONObject d;
    public volatile JSONObject e;
    public List f;
    public volatile long g;
    public SharedPreferences h;
    public L.b i;

    /* renamed from: j, reason: collision with root package name */
    public JSONObject f4601j;
    public boolean k;
    public long l;
    public long m;
    public long n;
    public volatile boolean o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4602q;

    /* renamed from: r, reason: collision with root package name */
    public CopyOnWriteArrayList f4603r;

    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", h.d().optString("aid"));
            jSONObject.put("os", h.d().optString("os"));
            jSONObject.put("app_version", h.d().optString("app_version"));
            jSONObject.put("update_version_code", h.d().optString("update_version_code"));
            jSONObject.put("channel", h.d().optString("channel"));
            jSONObject.put("device_id", h.d().optString("device_id"));
            jSONObject.put("os_version", h.d().optString("os_version"));
            jSONObject.put("device_model", h.d().optString("device_model"));
            if (!TextUtils.isEmpty(h.f718w)) {
                jSONObject.put("x-auth-token", h.f718w);
            }
            L.a aVar = h.e;
            if (aVar != null && !TextUtils.isEmpty(aVar.getUserId())) {
                jSONObject.put("user_id", h.e.getUserId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray.toString();
    }

    public final void b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2;
        if (S0.b.s0(jSONObject)) {
            return;
        }
        if (h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"FinalSetting:\n" + jSONObject.toString()}));
        }
        JSONObject jSONObjectU = S0.b.u("general", jSONObject, "slardar_api_settings");
        if (jSONObjectU != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectU.optJSONObject("fetch_setting");
            if (jSONObjectOptJSONObject2 != null) {
                this.g = jSONObjectOptJSONObject2.optLong("fetch_setting_interval", 1200L);
            }
            if (this.g < 600) {
                this.g = 600L;
            }
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("custom_event_settings");
        if (jSONObjectOptJSONObject3 != null) {
            this.c = jSONObjectOptJSONObject3.optJSONObject("allow_log_type");
            this.d = jSONObjectOptJSONObject3.optJSONObject("allow_metric_type");
            this.e = jSONObjectOptJSONObject3.optJSONObject("allow_service_name");
        }
        this.f4601j = jSONObject;
        JSONObject jSONObject3 = (TextUtils.isEmpty("exception_modules") || (jSONObject2 = this.f4601j) == null) ? new JSONObject() : jSONObject2.optJSONObject("exception_modules");
        if (jSONObject3 == null || (jSONObjectOptJSONObject = jSONObject3.optJSONObject("exception")) == null) {
            return;
        }
        this.b = jSONObjectOptJSONObject.optInt("enable_upload") == 1;
    }

    public final void c(boolean z10) {
        L.b bVar;
        if (this.f4602q || this.p) {
            if (!z10) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j5 = this.m;
                if (j5 > 15000) {
                    if (jCurrentTimeMillis - this.n <= j5) {
                        return;
                    }
                } else if (jCurrentTimeMillis - this.l <= this.g * 1000) {
                    return;
                }
            }
            if (AbstractC0897f.h(h.f711a) && (bVar = this.i) != null) {
                if (h.e() != null) {
                    ((J2.b) this.i).getClass();
                    if (((HashMap) h.e()).isEmpty()) {
                        return;
                    }
                    this.n = System.currentTimeMillis();
                    boolean zD = false;
                    for (String str : this.f) {
                        try {
                            byte[] bArrM = AbstractC1451a.m(a());
                            HashMap map = new HashMap();
                            ((J2.b) this.i).getClass();
                            String strP = S0.b.p(str, h.e());
                            if (bArrM.length > 128) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                try {
                                    try {
                                        gZIPOutputStream.write(bArrM);
                                        gZIPOutputStream.close();
                                        bArrM = byteArrayOutputStream.toByteArray();
                                        map.put("Content-Encoding", "gzip");
                                    } catch (IOException e) {
                                        throw e;
                                    }
                                } catch (Throwable th) {
                                    gZIPOutputStream.close();
                                    throw th;
                                }
                            }
                            map.put(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8");
                            zD = d(h.g.doPost(strP, bArrM, map));
                        } catch (Throwable unused) {
                        }
                        if (zD) {
                            break;
                        }
                    }
                    if (zD) {
                        this.m = 15000L;
                    } else {
                        this.m = Math.min(this.m * 2, TaskTimeouts.TAKEOVER_IDLE_MS);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x031b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(B.b r78) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 2012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.d.d(B.b):boolean");
    }

    @Override // L0.e
    public final void e(long j5) {
        c(false);
    }

    public final void f() {
        if (this.f4600a) {
            return;
        }
        this.f4600a = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4603r;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((C.a) it.next()).onReady();
            }
        }
    }

    public final boolean g() {
        String string = this.h.getString("monitor_net_config", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.k = true;
                this.l = this.h.getLong("monitor_configure_refresh_time", 0L);
                h.b("config_time", this.l + "");
                AbstractC1451a.f4469q = this.l;
                b(jSONObject);
                CopyOnWriteArrayList copyOnWriteArrayList = this.f4603r;
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((C.a) it.next()).onRefresh(jSONObject, true);
                    }
                }
                f();
                return false;
            } catch (Exception unused) {
                Log.e("<monitor><setting>", U7.a.e(new String[]{"配置信息读取失败"}));
            }
        }
        return true;
    }
}
