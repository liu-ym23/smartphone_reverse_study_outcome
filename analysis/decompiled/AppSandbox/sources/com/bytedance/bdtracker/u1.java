package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.store.kv.IKVStore;
import com.stepos.cloudsdk.Constants;
import com.stepos.pps.logpull.LogPullAuthActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class u1 {
    public final Context a;
    public final d b;
    public final InitConfig c;
    public final IKVStore d;
    public final IKVStore e;
    public final IKVStore f;
    public volatile JSONObject g;
    public volatile String h;
    public volatile JSONObject i;
    public final Set<String> j;
    public volatile HashSet<String> k;
    public int l;
    public int m;
    public long n;
    public int o;
    public long p;
    public boolean q;
    public int r;
    public final o1 s;

    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            String str;
            String str2;
            String str3;
            String str4;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", u1.this.b.m);
                long j = u1.this.f.getLong("session_interval", 0L);
                if (j > 0) {
                    str = j + "ms";
                } else {
                    str = "--";
                }
                jSONObject2.put("后台会话时长", str);
                long j2 = u1.this.f.getLong("batch_event_interval", 0L);
                if (j2 > 0) {
                    str2 = j2 + "ms";
                } else {
                    str2 = "--";
                }
                jSONObject2.put("事件上报周期", str2);
                long j3 = u1.this.f.getLong("abtest_fetch_interval", 0L);
                if (j3 > 0) {
                    str3 = j3 + "ms";
                } else {
                    str3 = "--";
                }
                jSONObject2.put("AB实验更新周期", str3);
                jSONObject2.put("全埋点开关", u1.this.f.getBoolean("bav_log_collect", false));
                jSONObject2.put("AB实验开关", u1.this.f.getBoolean("bav_ab_config", false));
                jSONObject2.put("实时埋点事件", u1.this.f.getString("real_time_events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                jSONObject2.put("禁止采集手机详情", u1.this.f.getBoolean("forbid_report_phone_detail_info", false));
                long j4 = u1.this.f.getLong("fetch_interval", 0L);
                if (j4 > 0) {
                    str4 = j4 + "ms";
                } else {
                    str4 = "--";
                }
                jSONObject2.put("服务端配置更新周期", str4);
                jSONObject2.put("禁止内部监控开关", u1.this.f.getBoolean("applog_disable_monitor", false));
                int i = u1.this.f.getInt("batch_event_size", -1);
                StringBuilder sb = new StringBuilder();
                sb.append(i >= 0 ? Integer.valueOf(i) : "--");
                sb.append("条");
                jSONObject2.put("事件累计上报数量", sb.toString());
                jSONObject2.put("禁止采集的敏感字段", u1.this.f.getString("sensitive_fields", "--"));
                jSONObject2.put("服务端黑名单事件", u1.this.j);
                jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public u1(d dVar, Context context, InitConfig initConfig) {
        new HashSet();
        this.j = new HashSet();
        this.l = 0;
        this.m = 27;
        this.n = 0L;
        this.o = 0;
        this.p = 0L;
        this.q = false;
        this.r = 1;
        this.b = dVar;
        this.a = context;
        this.c = initConfig;
        IKVStore iKVStoreA = v4.a(initConfig, context, initConfig.getSpName());
        this.f = iKVStoreA;
        this.d = v4.a(initConfig, context, b.a(dVar, "header_custom"));
        this.e = v4.a(initConfig, context, b.a(dVar, "last_sp_session"));
        this.s = new o1(iKVStoreA, dVar.D);
    }

    public List<e4> a(List<e4> list) {
        Iterator<e4> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            e4 next = it.next();
            if (next instanceof l4) {
                l4 l4Var = (l4) next;
                HashSet<String> hashSet = this.k;
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    try {
                        JSONArray jSONArray = new JSONArray(this.f.getString("real_time_events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                hashSet.add(string);
                            }
                        }
                    } catch (Throwable th) {
                        this.b.D.error(Collections.singletonList("ConfigManager"), "getRealTimeEvents failed", th, new Object[0]);
                    }
                }
                this.k = hashSet;
                if (hashSet.contains(l4Var.u)) {
                    it.remove();
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public JSONObject a() {
        JSONObject jSONObject = this.g;
        if (jSONObject != null) {
            return jSONObject;
        }
        synchronized (this) {
            try {
                jSONObject = new JSONObject(this.d.getString("ab_configure", ""));
            } catch (Throwable unused) {
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.g = jSONObject;
            } else {
                this.g = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean a(int i) {
        long j = i;
        return j >= 50 && j <= 9999;
    }

    public final boolean a(long j) {
        return j >= 10000 && j <= com.stepos.pps.data.util.Constants.SYSTEM_SERVER_INTERVAL;
    }

    public final boolean a(String str) {
        String string = this.f.getString("sensitive_fields", "");
        return !TextUtils.isEmpty(string) && string.contains(str);
    }

    public String b() {
        return this.c.getAid();
    }

    public String c() {
        String channel = this.c.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = this.c.getTweakedChannel();
        }
        if (TextUtils.isEmpty(channel)) {
            try {
                return this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
            } catch (Throwable th) {
                this.b.D.error(Collections.singletonList("ConfigManager"), "getChannel failed", th, new Object[0]);
            }
        }
        return channel;
    }

    public String d() {
        String string;
        String str = this.h;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        synchronized (this) {
            string = this.d.getString("external_ab_version", "");
            this.h = string;
        }
        return string;
    }

    public long e() {
        return this.f.getLong("session_interval", 30000L);
    }

    public String f() {
        StringBuilder sbA = com.bytedance.bdtracker.a.a("ssid_");
        sbA.append(this.c.getAid());
        return sbA.toString();
    }

    public String g() {
        return this.d.getString("user_unique_id", "");
    }

    public String h() {
        return this.d.getString("user_unique_id_type", null);
    }

    public boolean i() {
        return this.c.isAbEnable() && this.f.getBoolean("bav_ab_config", this.c.isAbEnable());
    }

    public boolean j() {
        if (this.c.getProcess() == 0) {
            String strB = r.b();
            if (TextUtils.isEmpty(strB)) {
                this.c.setProcess(0);
            } else {
                this.c.setProcess(strB.contains(":") ? 2 : 1);
            }
        }
        return this.c.getProcess() == 1;
    }

    public boolean k() {
        return this.f.getBoolean("monitor_enabled", this.c.isMonitorEnabled());
    }

    public boolean l() {
        return this.c.isOaidEnabled() && !a(LogPullAuthActivity.EXTRA_OAID);
    }

    public boolean m() {
        return this.c.isOperatorInfoEnabled() && !a("carrier");
    }

    public void n() {
        if (LogUtils.isDisabled() || this.f.getLong("app_log_last_config_time", 0L) <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("remote_settings", new a());
    }

    public void a(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("backoff_ratio", 0);
        this.l = iOptInt;
        if (iOptInt < 0 || iOptInt > 10000) {
            this.l = 0;
        }
        int i = this.l > 0 ? 1 : 27;
        int iOptInt2 = jSONObject.optInt("max_request_frequency", i);
        this.m = iOptInt2;
        if (iOptInt2 < 1 || iOptInt2 > 27) {
            this.m = i;
        }
        int i2 = this.l;
        if (i2 > 0 && this.n == 0) {
            this.n = System.currentTimeMillis();
            this.o = 1;
        } else if (i2 == 0) {
            this.n = 0L;
            this.o = 0;
        }
        this.p = jSONObject.optLong("batch_event_interval", 0L) * 1000;
        this.q = jSONObject.optInt("enter_background_not_send") == 1;
        IAppLogLogger iAppLogLogger = this.b.D;
        List<String> listSingletonList = Collections.singletonList("ConfigManager");
        StringBuilder sbA = com.bytedance.bdtracker.a.a("updateLogRespConfig mBackoffRatio: ");
        sbA.append(this.l);
        sbA.append(", mMaxRequestFrequency: ");
        sbA.append(this.m);
        sbA.append(", mBackoffWindowStartTime: ");
        sbA.append(this.n);
        sbA.append(", mBackoffWindowSendCount: ");
        sbA.append(this.o);
        sbA.append(", mEventIntervalFromLogResp: ");
        sbA.append(this.p);
        iAppLogLogger.debug(listSingletonList, sbA.toString(), new Object[0]);
    }
}
