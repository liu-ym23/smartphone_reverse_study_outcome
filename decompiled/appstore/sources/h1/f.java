package h1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.p;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.toolbox.ServerElements;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements AsyncEventManager.IMonitorTimeTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f20289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f20291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONObject f20292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile JSONObject f20293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f20294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f20295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile SharedPreferences f20296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IQueryParams f20297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f20298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f20300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f20301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f20302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f20303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f20304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f20305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f20306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f20307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f20308t;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20309a;

        /* JADX INFO: renamed from: h1.f$a$a, reason: collision with other inner class name */
        public class RunnableC0262a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f20310a;

            public RunnableC0262a(a r10) {
                this.f20310a = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.a(this.f20310a.f20309a);     // Catch: Throwable -> L4
                return;
            }
        }

        public a(f r10) {
            this.f20309a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 == null) goto L17;
            String r12 = r11.getStringExtra("PROCESS_NAME");     // Catch: Throwable -> L14
            String r13 = p.a(w0.c.g());     // Catch: Throwable -> L14
            if (w0.c.B() == false) goto L7;
            s1.c.d("apm_initializing", new String[]{"BroadcastReceiver.onReceive, processName:", r12, "currentProcessName:", r13});     // Catch: Throwable -> L14
        L7:
            if (TextUtils.isEmpty(r12) == false) goto L9;
            return;
        L9:
            if (TextUtils.isEmpty(r13) == false) goto L11;
            return;
        L11:
            if (r12.equals(r13) == true) goto L20;
            AsyncEventManager.e().h(new RunnableC0262a(this));     // Catch: Throwable -> L14
            return;
        L20:
            return;
        L21:
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20311a;

        public b(f r10) {
            this.f20311a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent r10 = new Intent("com.apm.setting.update.action");     // Catch: Exception -> L6
            r10.putExtra("PROCESS_NAME", p.a(w0.c.g()));     // Catch: Exception -> L6
            w0.c.g().sendBroadcast(r10);     // Catch: Exception -> L6
            if (w0.c.B() == false) goto L9;
            s1.c.d("apm_initializing", new String[]{"BroadcastReceiver.sendBroadUpdateSetting"});     // Catch: Exception -> L6
            return;
        L9:
            return;
        }
    }

    public class c implements LooperMonitor.IReporter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20312a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f20313a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f20314b;

            public a(c r10, long r11) {
                this.f20314b = r10;
                this.f20313a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
                r10.put(CommonConsts.APM_INNER_LOOPER_COST, this.f20313a);     // Catch: JSONException -> L4
                JSONObject r11 = new JSONObject();     // Catch: JSONException -> L4
                r11.put("is_main_process", f.b(this.f20314b.f20312a));     // Catch: JSONException -> L4
                ApmAgent.h("apm_cost", r11, r10, null);     // Catch: JSONException -> L4
                return;
            }
        }

        public c(f r10) {
            this.f20312a = r10;
        }

        @Override // com.bytedance.monitor.collector.LooperMonitor.IReporter
        public void reportCost(long r10) {
            AsyncEventManager.e().h(new a(this, r10));
        }
    }

    public f() {
        this.f20290b = false;
        this.f20294f = i1.a.f20484a;
        this.f20295g = 1200;
        this.f20300l = -1;
        this.f20301m = 60000;
        this.f20302n = -1;
        this.f20303o = false;
    }

    public static /* synthetic */ boolean a(f r10) {
        return r10.G();
    }

    public static /* synthetic */ boolean b(f r10) {
        return r10.f20305q;
    }

    public static byte[] d(byte[] r10, Map r11) {
        if (r10.length <= 128) goto L14;
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r13 = new GZIPOutputStream(r12);
        r13.write(r10);     // Catch: Throwable -> L7 IOException -> L9
        r13.close();
        byte[] r14 = r12.toByteArray();
        r11.put("Content-Encoding", "gzip");
        return r14;
    L7:
        th = move-exception;
        r13.close();
        throw th;
    L9:
        e = move-exception;
        i6.a.d(e, "SlardarConfigFetcher->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L14:
        return r10;
    }

    public final void A() {
        IntentFilter r10 = new IntentFilter();
        r10.addAction("com.apm.setting.update.action");
        a r11 = new a(this);
        if (w0.c.g() == null) goto L17;
    L7:
        th = move-exception;
        s3.a.c("SlardarConfigFetcher", "registerBroadUpdateSetting", th);
        return;
    L5:
        if (Build.VERSION.SDK_INT <= 33) goto L9;
        w0.c.g().registerReceiver(r11, r10, 2);     // Catch: Throwable -> L7
    L13:
        return;
    L9:
        w0.c.g().registerReceiver(r11, r10);     // Catch: Throwable -> L7
        goto L13
    }

    public void B(IConfigListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List r11 = this.f20308t;
        if (r11 == null) goto L8;
        r11.remove(r10);
        return;
    }

    public JSONObject C() {
        IQueryParams r10 = this.f20297i;
        if (r10 != null) goto L5;
    L7:
        Map<String, String> r11 = null;
    L8:
        if (r11 == null) goto L10;
        HashMap r12 = new HashMap(r11);
    L11:
        r12.put("last_calculate_timestamp", String.valueOf(this.f20306r / 1000));
        r12.put("last_full_calculate_timestamp", String.valueOf(this.f20307s / 1000));
        if ((System.currentTimeMillis() - this.f20306r) < 345600000) goto L14;
        r12.put("force_refresh", String.valueOf(1));
    L14:
        r12.put(SlardarSettingsConsts.KEY_QUERY_MINOR_VERSION, "1");
        return new JSONObject(r12);
    L10:
        r12 = new HashMap();
        goto L11
    L5:
        if (r10.getQueryParams() == null) goto L7;
        r11 = this.f20297i.getQueryParams();
        goto L8
    }

    public final void D(JSONObject r10) {
        JSONObject r11 = r10.optJSONObject("general");
        boolean r12 = true;
        if (r11 == null) goto L5;
        com.bytedance.apm.internal.a.h(32, !r11.optBoolean(SlardarSettingsConsts.ENABLE_SALVAGE_LOG, true));
    L5:
        JSONObject r13 = i.g(r10, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH);
        if (r13 != null) goto L8;
    L20:
        JSONObject r14 = i.g(r10, "performance_modules", "start_trace");
        if (r14 != null) goto L23;
    L35:
        if (r13 != null) goto L37;
        if (r14 != null) goto L37;
        return;
    L37:
        com.bytedance.apm.internal.a.e();
        return;
    L23:
        if (r14.optInt(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT, 0) != 1) goto L25;
        boolean r15 = true;
    L26:
        com.bytedance.apm.internal.a.h(4, r15);
        if (r14.optInt(SlardarSettingsConsts.PERF_KEY_LOCK_DATA_COLLECT, 0) != 1) goto L29;
        boolean r16 = true;
    L30:
        com.bytedance.apm.internal.a.h(8, r16);
        if (r14.optInt(SlardarSettingsConsts.PERF_KEY_LONG_SLEEP_DATA_COLLECT, 0) == 1) goto L34;
        r12 = false;
    L34:
        com.bytedance.apm.internal.a.h(16, r12);
        goto L35
    L29:
        r16 = false;
        goto L30
    L25:
        r15 = false;
        goto L26
    L8:
        if (r13.optInt(SlardarSettingsConsts.PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) != 1) goto L10;
        boolean r17 = true;
    L11:
        com.bytedance.apm.internal.a.h(1, r17);
        if (r13.optInt(SlardarSettingsConsts.PERF_TRACE_ENABLE, 0) != 1) goto L14;
        boolean r18 = true;
    L15:
        com.bytedance.apm.internal.a.h(2, r18);
        if (r13.optInt(SlardarSettingsConsts.PERF_SMOOTH_STACK_SAMPLING, 0) != 1) goto L18;
        boolean r19 = true;
    L19:
        com.bytedance.apm.internal.a.h(64, r19);
        com.bytedance.apm.internal.a.f(r13.optLong(SlardarSettingsConsts.PERF_ATRACE_TAG, 0));
        com.bytedance.apm.internal.a.g(SlardarConfigConsts.MONITOR_RUN_MODE_MASK, com.bytedance.apm.block.f.c(r10) << 29);
        goto L20
    L18:
        r19 = false;
        goto L19
    L14:
        r18 = false;
        goto L15
    L10:
        r17 = false;
        goto L11
    }

    public final void E() {
        AsyncEventManager.e().j(new b(this), 1000);
    }

    public final void F(JSONObject r10) {
        if (i.d(r10) == false) goto L5;
        return;
    L5:
        JSONObject r11 = i.g(r10, "general", "slardar_api_settings");
        if (r11 == null) goto L13;
        JSONObject r12 = r11.optJSONObject(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH);
        if (r12 == null) goto L11;
        this.f20295g = r12.optLong(SlardarSettingsConsts.SETTING_GENERAL_API_FETCH_INTERVAL, 1200);
    L11:
        if (this.f20295g >= 600) goto L13;
        this.f20295g = 600;
    L13:
        JSONObject r13 = r10.optJSONObject("custom_event_settings");
        if (r13 == null) goto L16;
        this.f20291c = r13.optJSONObject("allow_log_type");
        this.f20292d = r13.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_METRIC_TYPE);
        this.f20293e = r13.optJSONObject(SlardarSettingsConsts.BASE_KEY_ALLOW_SERVICE_NAME);
    L16:
        this.f20298j = r10;
        JSONObject r14 = i(SlardarSettingsConsts.SETTING_EXCEPTION_CUSTOM_EVENT);
        if (r14 == null) goto L26;
        JSONObject r15 = r14.optJSONObject("exception");
        if (r15 == null) goto L26;
        if (r15.optInt("enable_upload") != 1) goto L23;
        boolean r16 = true;
    L24:
        this.f20290b = r16;
        goto L26
    L23:
        r16 = false;
    L26:
        if (l("apm_cost") == false) goto L29;
        LooperMonitor.m(new c(this));
        LooperMonitor.e(true);
        return;
    }

    public final boolean G() {
        String r10 = x();
        if (s1.a.c() == null) goto L6;
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L28
        r11.put("updateFromLocal", TextUtils.isEmpty(r10));     // Catch: Exception -> L28
        s1.a.c().d("SlardarConfigFetcher", r11.toString());     // Catch: Exception -> L28
    L6:
        if (w0.c.B() == false) goto L9;
        s3.a.a("SlardarConfigFetcher", "configStr:" + r10);
    L9:
        if (w0.c.B() == false) goto L11;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, configStr=" + r10});
    L11:
        boolean r12 = true;
        if (TextUtils.isEmpty(r10) == true) goto L25;
        JSONObject r13 = new JSONObject(r10);     // Catch: Exception -> L23
        this.f20299k = true;     // Catch: Exception -> L23
        int r14 = this.f20296h.getInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 0);     // Catch: Exception -> L23
        if (w0.c.B() == false) goto L17;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, settingVersion=" + r14});     // Catch: Exception -> L23
    L17:
        if (r14 != 5) goto L25;
        this.f20300l = z();     // Catch: Exception -> L23
        this.f20306r = this.f20296h.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0);     // Catch: Exception -> L23
        this.f20307s = this.f20296h.getLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0);     // Catch: Exception -> L23
        if (w0.c.B() == false) goto L21;
        s3.a.a("SlardarConfigFetcher", "lastCalculateTimestamp:" + this.f20306r);     // Catch: Exception -> L23
    L21:
        w0.c.e("config_time", this.f20300l + "");     // Catch: Exception -> L23
        d3.a.C(this.f20300l);     // Catch: Exception -> L23
        F(r13);     // Catch: Exception -> L23
        w(r13, true);     // Catch: Exception -> L23
        v();     // Catch: Exception -> L23
        r12 = false;
    L23:
        s1.c.c(s1.b.f24483a, new String[]{"config read error"});
    L25:
        if (w0.c.B() == false) goto L27;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + r12});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_LOCAL", "needForceRefreshFromNet:" + r12 + " localConfig:" + r10);
    L27:
        return r12;
    }

    public boolean H(JSONObject r14) {
        int r10 = r14.optInt(ServerElements.CODE, -1);
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        if (r10 != 1) goto L9;
        this.f20300l = System.currentTimeMillis();
        this.f20306r = ((long) r14.optInt("last_calculate_timestamp", 0)) * 1000;
        this.f20307s = ((long) r14.optInt("last_full_calculate_timestamp", 0)) * 1000;
        SharedPreferences.Editor r15 = this.f20296h.edit();
        r15.putLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, this.f20300l);
        r15.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, this.f20306r);
        r15.putLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.f20307s);
        r15.commit();
        return true;
    L9:
        if (r10 != 0) goto L11;
    L14:
        JSONObject r11 = r14.optJSONObject("data");
        if (r11 != null) goto L27;
        String r12 = x();
        if (TextUtils.isEmpty(r12) == false) goto L51;
        r12 = "{}";
    L51:
        r11 = new JSONObject(r12);     // Catch: JSONException -> L22
    L22:
        e = move-exception;
        i6.a.d(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
        if (w0.c.B() == false) goto L26;
        s3.a.b("SlardarConfigFetcher", "error parse configStr:" + r12);
    L26:
        r11 = null;
    L27:
        if (r11 != null) goto L49;
        return false;
    L49:
        JSONObject r13 = r14.optJSONObject("data_to_merge");     // Catch: JSONException -> L33
        if (r13 == null) goto L47;
        r3.e.e(r11, r13);     // Catch: JSONException -> L33
    L47:
        JSONObject r16 = r14.optJSONObject("data_to_delete");     // Catch: JSONException -> L41
        if (r16 == null) goto L45;
        r3.e.b(r11, r16);     // Catch: JSONException -> L41
    L45:
        this.f20306r = ((long) r14.optInt("last_calculate_timestamp", 0)) * 1000;
        this.f20307s = ((long) r14.optInt("last_full_calculate_timestamp", 0)) * 1000;
        this.f20300l = System.currentTimeMillis();
        this.f20299k = false;
        F(r11);
        D(r11);
        SharedPreferences.Editor r17 = this.f20296h.edit();
        r17.putString(SlardarConfigConsts.MONITOR_NET_CONFIG, r11.toString());
        r17.putInt(SlardarConfigConsts.MONITOR_NET_CONFIG_VERSION, 5);
        r17.putLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, this.f20300l);
        r17.putLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, this.f20306r);
        r17.putLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, this.f20307s);
        r17.commit();
        w(r11, false);
        v();
        w0.c.e("config_time", this.f20300l + "");
        d3.a.C(this.f20300l);
        E();
        s1.a.d("apm_debug", "APM_SETTING_READY");
        return true;
    L41:
        e = move-exception;
        i6.a.d(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (w0.c.B() == false) goto L45;
        s3.a.b("SlardarConfigFetcher", "error nested data: dataToDelete");
    L33:
        e = move-exception;
        i6.a.d(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (w0.c.B() == false) goto L47;
        s3.a.b("SlardarConfigFetcher", "error nested data: dataToMerge");
        goto L47
    L11:
        if (r10 == 2) goto L14;
        return false;
    }

    public void c(IConfigListener r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f20308t != null) goto L8;
        this.f20308t = new CopyOnWriteArrayList();
    L8:
        if (this.f20308t.contains(r10) == true) goto L11;
        this.f20308t.add(r10);
    L11:
        if (w0.c.B() == false) goto L14;
        s1.c.d("apm_initializing", new String[]{"addConfigListener, mReady=" + this.f20289a});
    L14:
        if (this.f20289a == false) goto L17;
        r10.onRefresh(this.f20298j, this.f20299k);
        r10.onReady();
        return;
    }

    public final List e(List r10) {
        if (ListUtils.b(r10) == true) goto L14;
        ArrayList r11 = new ArrayList(2);     // Catch: MalformedURLException -> L15
        int r12 = r10.size();     // Catch: MalformedURLException -> L15
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L12;
        String r14 = new URL((String) r10.get(r13)).getHost();     // Catch: MalformedURLException -> L15
        if (TextUtils.isEmpty(r14) == true) goto L11;
        if (r14.indexOf(46) <= 0) goto L11;
        r11.add("https://" + r14 + "/monitor/appmonitor/v5/batch_settings");     // Catch: MalformedURLException -> L15
    L11:
        r13 = r13 + 1;
        goto L5
    L12:
        return r11;
    L14:
        return Collections.emptyList();
    }

    public void f(IQueryParams r10, List r11) {
        G();
        if (r10 == null) goto L6;
        this.f20297i = r10;
    L6:
        if (ListUtils.b(r11) == true) goto L8;
        this.f20294f = new ArrayList(r11);
    L8:
        y(true);
    }

    public JSONObject g() {
        return this.f20298j;
    }

    public int h(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r12 = this.f20298j;
        if (r12 == null) goto L9;
        return r12.optInt(r10, r11);
    L9:
        return r11;
    }

    public JSONObject i(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L10;
        JSONObject r11 = this.f20298j;
        if (r11 == null) goto L10;
        return r11.optJSONObject(r10);
    L10:
        return new JSONObject();
    }

    public boolean j(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r10, "block_monitor") == false) goto L9;
        r10 = "caton_monitor";
    L9:
        if (TextUtils.equals(r10, SlardarSettingsConsts.TYPE_ENSURE_MONITOR) == false) goto L13;
        return this.f20290b;
    L13:
        if (this.f20291c != null) goto L16;
        return false;
    L16:
        if (this.f20291c.optInt(r10) == 1) goto L18;
        return false;
    L18:
        return true;
    }

    public boolean k(String r10) {
        if (this.f20292d != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.f20292d.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean l(String r10) {
        if (this.f20293e != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        if (this.f20293e.optInt(r10) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean m(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L9;
        JSONObject r11 = this.f20298j;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.optBoolean(r10);
    L9:
        return false;
    }

    public final boolean n(i6.c r10) {
        if (r10 == null) goto L18;
        if (r10.c() != 200) goto L18;
        byte[] r11 = r10.b();
        if (r11 != null) goto L9;
        return false;
    L9:
        JSONObject r12 = new JSONObject(new String(r11));
        if (w0.c.B() == false) goto L12;
        s3.a.a("SlardarConfigFetcher", "resultJSON:" + r12);
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_RESULT", r12.toString());
    L12:
        JSONObject r13 = r12.optJSONObject(w0.c.j().optString("aid"));
        if (r13 != null) goto L16;
        return false;
    L16:
        return H(r13);
    L18:
        if (w0.c.B() == false) goto L24;
        DoctorManager r14 = DoctorManager.getInstance();
        StringBuilder r15 = new StringBuilder();
        r15.append("statusCode error:");
        if (r10 != null) goto L22;
        Object r16 = "null";
    L23:
        r15.append(r16);
        r14.b("APM_SETTING_UPDATE_FROM_NET_ERROR", r15.toString());
        goto L24
    L22:
        r16 = Integer.valueOf(r10.c());
    L24:
        return false;
    }

    public void o() {
        boolean r10 = G();
        if (w0.c.F() == true) goto L5;
        return;
    L5:
        if (this.f20300l <= System.currentTimeMillis()) goto L7;
        r10 = true;
    L7:
        y(r10);
    }

    @Override // com.bytedance.apm.thread.AsyncEventManager.IMonitorTimeTask
    public void onTimeEvent(long r10) {
        y(false);
    }

    public void p(boolean r10, IQueryParams r11, List r12) {
        this.f20304p = r10;
        this.f20305q = w0.c.F();
        r();
        this.f20297i = r11;
        if (ListUtils.b(r12) == true) goto L5;
        this.f20294f = e(r12);
    L5:
        q();
    }

    public final void q() {
        if (this.f20303o == true) goto L9;
        this.f20303o = true;
        if (s() == false) goto L7;
        AsyncEventManager.e().addTimeTask(this);
    L7:
        A();
        return;
    }

    public final void r() {
        if (this.f20296h != null) goto L14;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.f20296h != null) goto L10;
        this.f20296h = j1.b.g(w0.c.g(), SlardarConfigConsts.MONITOR_CONFIG);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    }

    public final boolean s() {
        if (this.f20305q == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f20304p == true) goto L8;
        return false;
    }

    public final boolean t(long r10) {
        long r11 = this.f20301m;
        if (r11 <= 60000) goto L9;
        if ((r10 - this.f20302n) > r11) goto L7;
        return false;
    L7:
        return true;
    L9:
        if ((r10 - this.f20300l) > (this.f20295g * 1000)) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean u() {
        return this.f20289a;
    }

    public final void v() {
        if (this.f20289a == true) goto L17;
        this.f20289a = true;
        List r10 = this.f20308t;
        if (r10 == null) goto L24;
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L25;
        ((IConfigListener) r11.next()).onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (w0.c.B() == false) goto L16;
        th.printStackTrace();
    L16:
        i6.a.c(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }

    public final void w(JSONObject r10, boolean r11) {
        List r12 = this.f20308t;
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L22;
        ((IConfigListener) r13.next()).onRefresh(r10, r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (w0.c.B() == false) goto L14;
        th.printStackTrace();
    L14:
        i6.a.c(th);
        goto L6
    L22:
        return;
    }

    public String x() {
        r();
        return this.f20296h.getString(SlardarConfigConsts.MONITOR_NET_CONFIG, "");
    }

    public final void y(boolean r11) {
        if (w0.c.B() == false) goto L6;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet." + s() + " " + t(System.currentTimeMillis())});
        DoctorManager r10 = DoctorManager.getInstance();
        StringBuilder r12 = new StringBuilder();
        r12.append("queryFromNet:");
        r12.append(r11);
        r10.b("APM_SETTING_UPDATE_FROM_NET", r12.toString());
    L6:
        if (s() == false) goto L71;
        if (r11 == true) goto L11;
        if (t(System.currentTimeMillis()) == true) goto L11;
        return;
    L11:
        if (k.b(w0.c.g()) == false) goto L13;
        IQueryParams r13 = this.f20297i;
        if (r13 == null) goto L56;
        if (r13.getQueryParams() == null) goto L56;
        if (this.f20297i.getQueryParams().isEmpty() == true) goto L56;
        if (this.f20306r != 0) goto L27;
        this.f20306r = this.f20296h.getLong(SlardarConfigConsts.MONITOR_CONFIG_CALCULATE_TIME, 0);
    L27:
        if (this.f20307s != 0) goto L29;
        this.f20307s = this.f20296h.getLong(SlardarConfigConsts.MONITOR_CONFIG_FULL_CALCULATE_TIME, 0);
    L29:
        this.f20302n = System.currentTimeMillis();
        Iterator r14 = this.f20294f.iterator();
        boolean r15 = false;
    L31:
        if (r14.hasNext() == false) goto L51;
        String r16 = (String) r14.next();
        JSONObject r17 = C();     // Catch: Throwable -> L38
        String r18 = w0.c.j().optString("aid");     // Catch: Throwable -> L38
        HashMap r19 = new HashMap();     // Catch: Throwable -> L38
        r19.put("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L38
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r18) == false) goto L36;
    L40:
        q1.a r21 = new q1.a(r16, r19, d(r20.toString().getBytes(), r19));     // Catch: Throwable -> L38
        i6.c r22 = w0.c.d(r21.f23487a, r21.f23489c, r21.f23488b);     // Catch: Throwable -> L38
        if (w0.c.B() == false) goto L43;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_REQUEST", r21.f23487a);     // Catch: Throwable -> L38
    L43:
        r15 = n(r22);     // Catch: Throwable -> L38
        if (w0.c.B() == false) goto L46;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.fetchResult: " + r22.b().length + " " + r15});     // Catch: Throwable -> L38
    L46:
        if (r15 == false) goto L31;
    L36:
        if (r18.equals(AdReportParam.ClickPosType.SKIP) == true) goto L40;
        r20.put(r18, r17);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (w0.c.B() == false) goto L31;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "queFromNetError:" + th);
    L51:
        if (r15 == true) goto L53;
        this.f20301m = Math.min(this.f20301m * 2, AdConstant.SPLASH_AD_INTERVAL);
        return;
    L53:
        this.f20301m = 60000;
        return;
    L56:
        if (w0.c.B() == false) goto L73;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "mQueryParams not available");
        return;
    L73:
        return;
    L13:
        if (w0.c.B() == false) goto L69;
        s1.c.d("apm_initializing", new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "network not available");
        return;
    L69:
        return;
    }

    public final long z() {
        return this.f20296h.getLong(SlardarConfigConsts.MONITOR_CONFIG_REFRESH_TIME, 0);
    }
}
