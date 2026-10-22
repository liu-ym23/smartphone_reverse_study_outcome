package com.bytedance.bdtracker;

import com.bytedance.applog.Level;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.stepos.cloudsdk.Constants;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d0 extends c0 {

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            r.c(this.a, jSONObject);
            try {
                jSONObject.put("appId", d0.this.f.m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(e0 e0Var) {
        super(e0Var);
        long j = e0Var.e.f.getLong("app_log_last_config_time", 0L);
        this.c = j;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() throws JSONException {
        String strA;
        w1 w1Var = this.e.i;
        JSONObject jSONObjectE = w1Var.e();
        if (w1Var.h() != 0 && jSONObjectE != null) {
            JSONObject jSONObjectB = z3.b(jSONObjectE);
            if (this.e.e.c.isEventFilterEnable()) {
                jSONObjectB.put("event_filter", 1);
            }
            g5.a(this.f, jSONObjectB);
            String strA2 = this.f.j.a(w1Var.e(), this.e.e().getSettingUri(), true, Level.L1);
            z3 z3Var = this.f.k;
            String strA3 = z3.a(strA2, g5.b);
            z3Var.b.D.debug(11, "Start to get config to uri:{} with request:{}...", strA3, jSONObjectB);
            try {
                strA = z3Var.a(jSONObjectB, strA3, z3Var.a(), 60000);
            } catch (Throwable th) {
                z3Var.b.D.error(11, "Config failed", th, new Object[0]);
                strA = null;
            }
            z3Var.b.D.debug(11, "Get config with response:{}", strA);
            JSONObject jSONObjectA = z3Var.a(strA);
            JSONObject jSONObjectOptJSONObject = (jSONObjectA == null || !"ss_app_log".equals(jSONObjectA.optString("magic_tag", ""))) ? null : jSONObjectA.optJSONObject(Constants.PATH_CONFIG);
            u1 u1Var = this.e.e;
            h1 h1Var = this.f.y;
            if (h1Var != null) {
                h1Var.onRemoteConfigGet(!r.b(jSONObjectOptJSONObject, u1Var.i), jSONObjectOptJSONObject);
            }
            if (jSONObjectOptJSONObject != null) {
                u1Var.b.D.debug(Collections.singletonList("ConfigManager"), "Set config:{}", jSONObjectOptJSONObject);
                u1Var.i = jSONObjectOptJSONObject;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jOptInt = jSONObjectOptJSONObject.optInt("session_interval", 0);
                if (jOptInt <= 0 || jOptInt > 604800) {
                    u1Var.f.remove("session_interval");
                } else {
                    u1Var.f.putLong("session_interval", jOptInt * 1000);
                }
                long jOptInt2 = jSONObjectOptJSONObject.optInt("batch_event_interval", 60) * 1000;
                if (jOptInt2 < 10000 || jOptInt2 > com.stepos.pps.data.util.Constants.SYSTEM_SERVER_INTERVAL) {
                    u1Var.f.remove("batch_event_interval");
                } else {
                    u1Var.f.putLong("batch_event_interval", jOptInt2);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("batch_event_size", -1);
                if (u1Var.a(iOptInt)) {
                    u1Var.f.putInt("batch_event_size", iOptInt);
                } else {
                    u1Var.f.remove("batch_event_size");
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("send_launch_timely", 0);
                if (iOptInt2 <= 0 || iOptInt2 > 604800) {
                    u1Var.f.remove("send_launch_timely");
                } else {
                    u1Var.f.putInt("send_launch_timely", iOptInt2);
                }
                long jOptInt3 = jSONObjectOptJSONObject.optInt("abtest_fetch_interval", 0);
                if (jOptInt3 <= 20 || jOptInt3 > 604800) {
                    u1Var.f.remove("abtest_fetch_interval");
                } else {
                    u1Var.f.putLong("abtest_fetch_interval", jOptInt3 * 1000);
                }
                boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("bav_log_collect", u1Var.c.isAutoTrackEnabled());
                u1Var.f.putBoolean("bav_log_collect", zOptBoolean);
                u1Var.r = zOptBoolean ? 1 : 0;
                u1Var.f.putBoolean("bav_ab_config", jSONObjectOptJSONObject.optBoolean("bav_ab_config", u1Var.c.isAbEnable()));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("real_time_events");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    u1Var.f.remove("real_time_events");
                } else {
                    u1Var.f.putString("real_time_events", jSONArrayOptJSONArray.toString());
                }
                u1Var.k = null;
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("sensitive_fields");
                if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0) {
                    u1Var.f.remove("sensitive_fields");
                } else {
                    u1Var.f.putString("sensitive_fields", jSONArrayOptJSONArray2.toString());
                }
                u1Var.f.putLong("app_log_last_config_time", jCurrentTimeMillis);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("forbid_report_phone_detail_info", -1);
                if (iOptInt3 >= 0) {
                    u1Var.f.putBoolean("forbid_report_phone_detail_info", iOptInt3 > 0);
                }
                long jOptLong = jSONObjectOptJSONObject.optLong("fetch_interval", 21600L) * 1000;
                if (jOptLong < 1800000 || jOptLong > 172800000) {
                    jOptLong = 21600000;
                }
                u1Var.f.putLong("fetch_interval", jOptLong);
                if (jSONObjectOptJSONObject.has("applog_disable_monitor")) {
                    u1Var.f.putBoolean("monitor_enabled", jSONObjectOptJSONObject.optInt("applog_disable_monitor", 0) == 1);
                }
                if (jSONObjectOptJSONObject.has("enter_background_not_send")) {
                    u1Var.f.putBoolean("enter_background_not_send", jSONObjectOptJSONObject.optInt("enter_background_not_send") == 1);
                }
                u1Var.n();
                this.f.setForbidReportPhoneDetailInfo(u1Var.f.getBoolean("forbid_report_phone_detail_info", false));
                if (!u1Var.k()) {
                    this.e.q = null;
                }
                e0 e0Var = this.e;
                e0Var.j.removeMessages(13);
                e0Var.j.sendEmptyMessage(13);
                if (this.e.e.c.isEventFilterEnable()) {
                    String strA4 = b.a(this.f, "sp_filter_name");
                    e0 e0Var2 = this.e;
                    e0Var2.y = e1.a(e0Var2.b(), strA4, jSONObjectOptJSONObject);
                }
                if (!LogUtils.isDisabled()) {
                    LogUtils.sendJsonFetcher("fetch_log_settings_end", new a(jSONObjectOptJSONObject));
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "Configure";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return h0.h;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long h() {
        return this.e.e.f.getLong("fetch_interval", 21600000L);
    }
}
