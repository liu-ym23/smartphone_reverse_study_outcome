package com.bytedance.apm.config;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.m;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements bt3.b.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f190490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f190491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile JSONObject f190492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile JSONObject f190493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile JSONObject f190494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f190495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f190496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile SharedPreferences f190497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gs3.d f190498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f190499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f190500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f190501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f190502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f190503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f190504o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f190505p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f190506q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f190507r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f190508s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<IConfigListener> f190509t;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements b27.e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f190510a;

        public a(j r100) {
            this.f190510a = r100;
        }
    }

    public final void f() {
        if (this.f190490a == true) goto L17;
        this.f190490a = true;
        List<IConfigListener> r100 = this.f190509t;
        if (r100 == null) goto L24;
        Iterator r101 = ((CopyOnWriteArrayList) r100).iterator();
    L8:
        if (r101.hasNext() == false) goto L25;
        ((IConfigListener) r101.next()).onReady();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L16;
        th.printStackTrace();
    L16:
        EnsureManager.ensureNotReachHere(th);
        goto L8
    L25:
        return;
    L24:
        return;
    }

    public final JSONObject i() {
        gs3.d r100 = this.f190498i;
        if (r100 == null) goto L7;
        ((ApmDelegate.f.a) r100).getClass();
        if (com.bytedance.apm.d.g() == null) goto L7;
        ((ApmDelegate.f.a) this.f190498i).getClass();
        Map<String, String> r101 = com.bytedance.apm.d.g();
    L8:
        if (r101 == null) goto L10;
        HashMap r102 = new HashMap(r101);
    L11:
        r102.put("last_calculate_timestamp", String.valueOf(this.f190507r / 1000));
        r102.put("last_full_calculate_timestamp", String.valueOf(this.f190508s / 1000));
        if ((System.currentTimeMillis() - this.f190507r) < 345600000) goto L14;
        r102.put("force_refresh", String.valueOf(1));
    L14:
        r102.put("minor_version", "1");
        return new JSONObject(r102);
    L10:
        r102 = new HashMap();
    L7:
        r101 = null;
        goto L8
    }

    public final boolean k() {
        if (this.f190497h != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f190497h != null) goto L8;
        this.f190497h = gs3.e.b(com.bytedance.apm.d.getContext(), "monitor_config");     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L13:
        String r100 = this.f190497h.getString("monitor_net_config", "");
        if (com.bytedance.apm.d.j() == false) goto L17;
        av3.b.a("SlardarConfigFetcher", "configStr:" + r100);
    L17:
        if (com.bytedance.apm.d.j() == false) goto L20;
        ps3.b.a(new String[]{"SlardarConfigFetcher.updateFromLocal, configStr=" + r100});
    L20:
        if (TextUtils.isEmpty(r100) == false) goto L39;
    L32:
        boolean r101 = true;
    L34:
        if (com.bytedance.apm.d.j() == false) goto L36;
        ps3.b.a(new String[]{"SlardarConfigFetcher.updateFromLocal, isForceRefreshFromNet=" + r101});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_LOCAL", "needForceRefreshFromNet:" + r101 + " localConfig:" + r100);
    L36:
        return r101;
    L39:
        JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L31
        this.f190500k = true;     // Catch: Exception -> L31
        int r103 = this.f190497h.getInt("setting_version", 0);     // Catch: Exception -> L31
        if (com.bytedance.apm.d.j() == false) goto L25;
        ps3.b.a(new String[]{"SlardarConfigFetcher.updateFromLocal, settingVersion=" + r103});     // Catch: Exception -> L31
    L25:
        if (r103 != 5) goto L32;
        this.f190501l = this.f190497h.getLong("monitor_configure_refresh_time", 0);     // Catch: Exception -> L31
        this.f190507r = this.f190497h.getLong("monitor_last_calculate_timestamp_v5", 0);     // Catch: Exception -> L31
        this.f190508s = this.f190497h.getLong("monitor_last_full_calculate_timestamp_v5", 0);     // Catch: Exception -> L31
        if (com.bytedance.apm.d.j() == false) goto L29;
        av3.b.a("SlardarConfigFetcher", "lastCalculateTimestamp:" + this.f190507r);     // Catch: Exception -> L31
    L29:
        com.bytedance.apm.d.b("config_time", this.f190501l + "");     // Catch: Exception -> L31
        du3.a.f470039q = this.f190501l;     // Catch: Exception -> L31
        j(r102);     // Catch: Exception -> L31
        g(r102, true);     // Catch: Exception -> L31
        f();     // Catch: Exception -> L31
        r101 = false;
    L31:
        ps3.b.a(new String[]{"config read error"});
        goto L32
    }

    public j() {
        this.f190491b = false;
        this.f190495f = fs3.a.f478654a;
        this.f190496g = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        this.f190501l = -1;
        this.f190502m = 60000;
        this.f190503n = -1;
        this.f190504o = false;
    }

    public final boolean d(ff7.b r100) throws JSONException {
        if (r100 == null) goto L18;
        if (r100.f476667a != 200) goto L18;
        byte[] r101 = r100.f476669c;
        if (r101 != null) goto L9;
        return false;
    L9:
        JSONObject r102 = new JSONObject(new String(r101));
        if (com.bytedance.apm.d.j() == false) goto L12;
        av3.b.a("SlardarConfigFetcher", "resultJSON:" + r102);
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_RESULT", r102.toString());
    L12:
        JSONObject r103 = r102.optJSONObject(com.bytedance.apm.d.d().optString("aid"));
        if (r103 != null) goto L16;
        return false;
    L16:
        return l(r103);
    L18:
        if (com.bytedance.apm.d.j() == false) goto L24;
        DoctorManager r104 = DoctorManager.getInstance();
        StringBuilder r105 = new StringBuilder("statusCode error:");
        if (r100 != null) goto L22;
        Object r106 = "null";
    L23:
        r105.append(r106);
        r104.b("APM_SETTING_UPDATE_FROM_NET_ERROR", r105.toString());
        goto L24
    L22:
        r106 = Integer.valueOf(r100.f476667a);
    L24:
        return false;
    }

    public final boolean e(long r100) {
        long r101 = this.f190502m;
        if (r101 <= 60000) goto L10;
        if ((r100 - this.f190503n) > r101) goto L14;
        return false;
    L14:
        return true;
    L10:
        if ((r100 - this.f190501l) > (this.f190496g * 1000)) goto L15;
        return false;
    L15:
        return true;
    }

    public final void h(boolean r110) {
        if (com.bytedance.apm.d.j() == false) goto L13;
        String[] r100 = new String[1];
        StringBuilder r101 = new StringBuilder("SlardarConfigFetcher.queryFromNet.");
        if (this.f190506q == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        r101.append(r102);
        r101.append(" ");
        r101.append(e(System.currentTimeMillis()));
        r100[0] = r101.toString();
        ps3.b.a(r100);
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET", "queryFromNet:" + r110);
        goto L13
    L7:
        if (this.f190505p == true) goto L10;
        r102 = false;
    L13:
        if (this.f190506q == false) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L24;
        if (r110 == false) goto L22;
    L23:
        boolean r111 = true;
    L25:
        if (r111 == true) goto L28;
        return;
    L28:
        if (m.b(com.bytedance.apm.d.getContext()) == true) goto L34;
        if (com.bytedance.apm.d.j() == false) goto L85;
        ps3.b.a(new String[]{"SlardarConfigFetcher.queryFromNet.NetworkUnavailable"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "network not available");
        return;
    L85:
        return;
    L34:
        if (this.f190498i == null) goto L72;
        if (com.bytedance.apm.d.g() == null) goto L72;
        ((ApmDelegate.f.a) this.f190498i).getClass();
        if (com.bytedance.apm.d.g().isEmpty() == true) goto L72;
        if (this.f190507r != 0) goto L44;
        this.f190507r = this.f190497h.getLong("monitor_last_calculate_timestamp_v5", 0);
    L44:
        if (this.f190508s != 0) goto L46;
        this.f190508s = this.f190497h.getLong("monitor_last_full_calculate_timestamp_v5", 0);
    L46:
        this.f190503n = System.currentTimeMillis();
        Iterator<String> r112 = this.f190495f.iterator();
        boolean r104 = false;
    L48:
        if (r112.hasNext() == false) goto L67;
        String r105 = r112.next();
        JSONObject r106 = i();     // Catch: Throwable -> L63
        String r107 = com.bytedance.apm.d.d().optString("aid");     // Catch: Throwable -> L63
        HashMap r108 = new HashMap();     // Catch: Throwable -> L63
        r108.put("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L63
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L63
        if (TextUtils.isEmpty(r107) == false) goto L53;
    L55:
        ff7.b r113 = com.bytedance.apm.d.a(r105, c(r109.toString().getBytes(), r108), r108);     // Catch: Throwable -> L63
        if (com.bytedance.apm.d.j() == false) goto L58;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_REQUEST", r105);     // Catch: Throwable -> L63
    L58:
        r104 = d(r113);     // Catch: Throwable -> L63
        if (com.bytedance.apm.d.j() == false) goto L61;
        ps3.b.a(new String[]{"SlardarConfigFetcher.queryFromNet.fetchResult: " + r113.f476669c.length + " " + r104});     // Catch: Throwable -> L63
    L61:
        if (r104 == false) goto L48;
    L53:
        if (r107.equals("0") == true) goto L55;
        r109.put(r107, r106);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L48;
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "queFromNetError:" + th);
    L67:
        if (r104 == true) goto L69;
        this.f190502m = Math.min(this.f190502m * 2, 600000);
        return;
    L69:
        this.f190502m = 60000;
        return;
    L72:
        if (com.bytedance.apm.d.j() == false) goto L87;
        ps3.b.a(new String[]{"SlardarConfigFetcher.queryFromNet.ParamsEmpty"});
        DoctorManager.getInstance().b("APM_SETTING_UPDATE_FROM_NET_ERROR", "mQueryParams not available");
        return;
    L87:
        return;
    L22:
        if (e(System.currentTimeMillis()) == true) goto L23;
    L24:
        r111 = false;
        goto L25
    L15:
        if (this.f190505p == true) goto L18;
        r103 = false;
        goto L19
    }

    public final void j(JSONObject r100) {
        if (com.bytedance.apm.util.j.c(r100) == false) goto L5;
        return;
    L5:
        JSONObject r101 = com.bytedance.apm.util.j.e(r100, "general", "slardar_api_settings");
        if (r101 == null) goto L13;
        JSONObject r102 = r101.optJSONObject("fetch_setting");
        if (r102 == null) goto L11;
        this.f190496g = r102.optLong("fetch_setting_interval", AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
    L11:
        if (this.f190496g >= 600) goto L13;
        this.f190496g = 600;
    L13:
        JSONObject r103 = r100.optJSONObject("custom_event_settings");
        if (r103 == null) goto L16;
        this.f190492c = r103.optJSONObject("allow_log_type");
        this.f190493d = r103.optJSONObject("allow_metric_type");
        this.f190494e = r103.optJSONObject("allow_service_name");
    L16:
        this.f190499j = r100;
        if (TextUtils.isEmpty("exception_modules") == true) goto L22;
        JSONObject r104 = this.f190499j;
        if (r104 == null) goto L22;
        JSONObject r105 = r104.optJSONObject("exception_modules");
    L23:
        boolean r106 = false;
        if (r105 == null) goto L33;
        JSONObject r107 = r105.optJSONObject(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        if (r107 == null) goto L33;
        if (r107.optInt("enable_upload") != 1) goto L30;
        boolean r108 = true;
    L31:
        this.f190491b = r108;
        goto L33
    L30:
        r108 = false;
    L33:
        if (this.f190494e != null) goto L35;
    L40:
        if (r106 == false) goto L43;
        b27.e.f17039f = new a(this);
        b27.e.f17040g = true;
        return;
    L43:
        return;
    L35:
        if (TextUtils.isEmpty("apm_cost") == true) goto L40;
        if (this.f190494e.optInt("apm_cost") != 1) goto L40;
        r106 = true;
    L22:
        r105 = new JSONObject();
        goto L23
    }

    public final boolean l(JSONObject r110) {
        int r100 = r110.optInt("code", -1);
        if (r100 != (-1)) goto L6;
        return false;
    L6:
        if (r100 != 1) goto L9;
        this.f190501l = System.currentTimeMillis();
        this.f190507r = ((long) r110.optInt("last_calculate_timestamp", 0)) * 1000;
        this.f190508s = ((long) r110.optInt("last_full_calculate_timestamp", 0)) * 1000;
        SharedPreferences.Editor r111 = this.f190497h.edit();
        r111.putLong("monitor_configure_refresh_time", this.f190501l);
        r111.putLong("monitor_last_calculate_timestamp_v5", this.f190507r);
        r111.putLong("monitor_last_full_calculate_timestamp_v5", this.f190508s);
        r111.commit();
        return true;
    L9:
        int r112 = 2;
        if (r100 == 0) goto L14;
        if (r100 == 2) goto L14;
        return false;
    L14:
        JSONObject r101 = r110.optJSONObject("data");
        if (r101 == null) goto L18;
    L38:
        if (r101 != null) goto L111;
        return false;
    L111:
        JSONObject r113 = r110.optJSONObject("data_to_merge");     // Catch: JSONException -> L44
        if (r113 == null) goto L117;
        xu3.d.d(r101, r113);     // Catch: JSONException -> L44
    L117:
        JSONObject r114 = r110.optJSONObject("data_to_delete");     // Catch: JSONException -> L52
        if (r114 == null) goto L56;
        xu3.d.b(r101, r114);     // Catch: JSONException -> L52
    L56:
        this.f190507r = ((long) r110.optInt("last_calculate_timestamp", 0)) * 1000;
        this.f190508s = ((long) r110.optInt("last_full_calculate_timestamp", 0)) * 1000;
        this.f190501l = System.currentTimeMillis();
        this.f190500k = false;
        j(r101);
        JSONObject r115 = r101.optJSONObject("general");
        if (r115 == null) goto L59;
        com.bytedance.apm.internal.g.a(32, !r115.optBoolean("enable_salvage_log", true));
    L59:
        JSONObject r102 = com.bytedance.apm.util.j.e(r101, "performance_modules", "smooth");
        if (r102 != null) goto L62;
    L83:
        JSONObject r116 = com.bytedance.apm.util.j.e(r101, "performance_modules", "start_trace");
        if (r116 != null) goto L86;
    L104:
        if (r102 != null) goto L106;
        if (r116 != null) goto L106;
    L109:
        SharedPreferences.Editor r117 = this.f190497h.edit();
        r117.putString("monitor_net_config", r101.toString());
        r117.putInt("setting_version", 5);
        r117.putLong("monitor_configure_refresh_time", this.f190501l);
        r117.putLong("monitor_last_calculate_timestamp_v5", this.f190507r);
        r117.putLong("monitor_last_full_calculate_timestamp_v5", this.f190508s);
        r117.commit();
        g(r101, false);
        f();
        com.bytedance.apm.d.b("config_time", this.f190501l + "");
        du3.a.f470039q = this.f190501l;
        bt3.b.d.f20539a.g(new h(), 1000);
        return true;
    L106:
        SharedPreferences r118 = com.bytedance.apm.internal.g.f190600b;
        if (r118 == null) goto L109;
        r118.edit().putInt("monitor_switch_config_first_flag", com.bytedance.apm.internal.g.f190602d).putLong("monitor_switch_config_atrace_flag", com.bytedance.apm.internal.g.f190603e).putInt("monitor_thread_info_count", com.bytedance.apm.internal.g.f190604f).apply();
        goto L109
    L86:
        if (r116.optInt("enable_perf_data_collect", 0) != 1) goto L88;
        boolean r103 = true;
    L89:
        com.bytedance.apm.internal.g.a(4, r103);
        if (r116.optInt("enable_lock_data_collect", 0) != 1) goto L92;
        boolean r104 = true;
    L93:
        com.bytedance.apm.internal.g.a(8, r104);
        if (r116.optInt("enable_long_sleep_data_collect", 0) != 1) goto L96;
        boolean r105 = true;
    L97:
        com.bytedance.apm.internal.g.a(16, r105);
        if (r116.optInt("enable_thread_cpu_collect", 0) != 1) goto L100;
        boolean r106 = true;
    L101:
        com.bytedance.apm.internal.g.a(128, r106);
        int r107 = r116.optInt("thread_cpu_collect_count", 0);
        if (r107 <= 0) goto L104;
        com.bytedance.apm.internal.g.f190604f = r107;
        goto L104
    L100:
        r106 = false;
        goto L101
    L96:
        r105 = false;
        goto L97
    L92:
        r104 = false;
        goto L93
    L88:
        r103 = false;
        goto L89
    L62:
        if (r102.optInt("block_enable_upload", 0) != 1) goto L64;
        boolean r119 = true;
    L65:
        com.bytedance.apm.internal.g.a(1, r119);
        if (r102.optInt("enable_trace", 0) != 1) goto L68;
        boolean r120 = true;
    L69:
        com.bytedance.apm.internal.g.a(2, r120);
        if (r102.optInt("enable_stack_sampling", 0) != 1) goto L72;
        boolean r121 = true;
    L73:
        com.bytedance.apm.internal.g.a(64, r121);
        com.bytedance.apm.internal.g.f190603e = r102.optLong("atrace_tag", 0);
        int r108 = com.bytedance.apm.util.j.d(r101, "smooth", "block_monitor_mode");
        if (r108 != 11) goto L76;
    L82:
        com.bytedance.apm.internal.g.f190602d = ((r112 << 29) & (-536870912)) + (com.bytedance.apm.internal.g.f190602d & 536870911);
        goto L83
    L76:
        if (r108 != 101) goto L78;
        r112 = 3;
        goto L82
    L78:
        if (r108 == 1001) goto L80;
        r112 = 1;
        goto L82
    L80:
        r112 = 0;
        goto L82
    L72:
        r121 = false;
        goto L73
    L68:
        r120 = false;
        goto L69
    L64:
        r119 = false;
    L52:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult 3");
        if (com.bytedance.apm.d.j() == false) goto L56;
        av3.b.b("SlardarConfigFetcher", "error nested data: dataToDelete");
    L44:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult 2");
        if (com.bytedance.apm.d.j() == false) goto L117;
        av3.b.b("SlardarConfigFetcher", "error nested data: dataToMerge");
        goto L117
    L18:
        if (this.f190497h != null) goto L28;
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L21:
        if (this.f190497h != null) goto L23;
        this.f190497h = gs3.e.b(com.bytedance.apm.d.getContext(), "monitor_config");     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);     // Catch: Throwable -> L25
    L28:
        String r109 = this.f190497h.getString("monitor_net_config", "");
        if (TextUtils.isEmpty(r109) == false) goto L113;
        r109 = SliceInitService.DEFAULT_SWITCH;
    L113:
        r101 = new JSONObject(r109);     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->updateWithSpecificAidResult");
        if (com.bytedance.apm.d.j() == false) goto L37;
        av3.b.b("SlardarConfigFetcher", "error parse configStr:" + r109);
    L37:
        r101 = null;
        goto L38
    }

    @Override // bt3.b.e
    public final void onTimeEvent(long r100) {
        h(false);
    }

    public static byte[] c(byte[] r100, Map<String, String> r101) throws IOException {
        if (r100.length <= 128) goto L14;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r103 = new GZIPOutputStream(r102);
        r103.write(r100);     // Catch: Throwable -> L7 IOException -> L9
        r103.close();
        byte[] r104 = r102.toByteArray();
        ((HashMap) r101).put("Content-Encoding", DownloadHelper.GZIP);
        return r104;
    L9:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SlardarConfigFetcher->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r103.close();
        throw th;
    L14:
        return r100;
    }

    public final void g(JSONObject r100, boolean r101) {
        List<IConfigListener> r102 = this.f190509t;
        if (r102 == null) goto L15;
        Iterator r103 = ((CopyOnWriteArrayList) r102).iterator();
    L6:
        if (r103.hasNext() == false) goto L22;
        ((IConfigListener) r103.next()).onRefresh(r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L14;
        th.printStackTrace();
    L14:
        EnsureManager.ensureNotReachHere(th);
        goto L6
    L22:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, g r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 2);
        return;
    L38:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 2, null, null, 3, r100).result;     // Catch: Exception -> L33
        if (r101 == 1) goto L19;
        if (r101 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r101 == 3) goto L40;
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L19:
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r110, r111, 2);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, g r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
