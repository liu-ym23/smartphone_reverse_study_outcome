package l6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.ttnet.TTNetInit;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h implements SsHttpCall.IHttpCallThrottleControl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f21891m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static h f21892n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f21895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Set f21901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f21902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f21903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f21904l;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map f21907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Set f21908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f21909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f21911g;

        public b() {
            this.f21905a = false;
            this.f21906b = true;
            this.f21907c = new ConcurrentHashMap();
            this.f21908d = new CopyOnWriteArraySet();
            this.f21909e = 1000;
            this.f21910f = 100;
            this.f21911g = 1000;
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static final class c extends BroadcastReceiver {

        public class a extends w3.c {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ c f21912e;

            public a(c r10, String r11) {
                this.f21912e = r10;
                super(r11);
            }

            @Override // w3.c, java.lang.Runnable
            public void run() {
                i.b().a();
            }
        }

        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION".equals(r11.getAction()) == false) goto L8;
            new a(this, "SyncAppDelayConfig").a();
            return;
        }
    }

    public h(Context r10, boolean r11) {
        this.f21895c = new ConcurrentHashMap();
        this.f21896d = "";
        this.f21897e = false;
        this.f21898f = false;
        this.f21899g = 1000;
        this.f21900h = 100;
        this.f21901i = new CopyOnWriteArraySet();
        this.f21902j = new ConcurrentHashMap();
        this.f21903k = new ConcurrentHashMap();
        this.f21904l = new AtomicInteger(0);
        this.f21893a = r10.getApplicationContext();
        this.f21894b = r11;
    }

    public static /* synthetic */ void a(h r10) {
        r10.c();
    }

    public static h b(Context r10) {
        monitor-enter(h.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f21892n != null) goto L17;
        boolean r11 = com.bytedance.frameworks.baselib.network.http.util.f.e(r10);     // Catch: Throwable -> L9
        f21892n = new h(r10, r11);     // Catch: Throwable -> L9
        f21891m = r10.getPackageName();     // Catch: Throwable -> L9
        if (r11 == false) goto L11;
        SsHttpCall.l(f21892n);     // Catch: Throwable -> L9
        goto L17
    L11:
        IntentFilter r12 = new IntentFilter();     // Catch: Throwable -> L9
        r12.addAction("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION");     // Catch: Throwable -> L9
        r10.registerReceiver(new c(), r12, null, null);     // Catch: Throwable -> L14
    L16:
        SsHttpCall.l(i.b());     // Catch: Throwable -> L9
        goto L17
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L9
    L17:
        h r13 = f21892n;     // Catch: Throwable -> L9
        monitor-exit(h.class);     // Catch: Throwable -> L9
        return r13;
    }

    public static void d(Map r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.clear();
        if (TextUtils.isEmpty(r11) == false) goto L16;
        return;
    L16:
        JSONObject r12 = new JSONObject(r11);     // Catch: JSONException -> L9
    L11:
        Iterator<String> r13 = r12.keys();
    L13:
        if (r13.hasNext() == false) goto L15;
        String r14 = r13.next();
        r10.put(r14, Integer.valueOf(r12.optInt(r14)));
        goto L13
    L15:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L11
    }

    public static void g(Set r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.clear();
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        r10.addAll(Arrays.asList(r11.split(",")));
    }

    public final /* synthetic */ void c() {
        k(TTAppStateManager.AppStartState.Default);
    }

    public final void e(JSONObject r12) {
        JSONArray r13 = r12.optJSONArray("tt_req_delay_config");
        if (r13 != null) goto L6;
        this.f21895c.clear();
        return;
    L6:
        int r10 = 0;
    L8:
        if (r10 >= r13.length()) goto L43;
        b r11 = new b(null);
        JSONObject r14 = r13.optJSONObject(r10);
        if (r14 == null) goto L42;
        int r15 = r14.optInt(WsConstants.KEY_CONNECTION_STATE, -2);
        if (r15 != (-1)) goto L15;
        TTAppStateManager.AppStartState r16 = TTAppStateManager.AppStartState.NormalStart;
    L26:
        if (r14.isNull("bl_with_delay_ms") == true) goto L33;
        r11.f21905a = true;
        r11.f21906b = true;
        JSONObject r17 = r14.optJSONObject("bl_with_delay_ms");
        Iterator<String> r18 = r17.keys();
    L29:
        if (r18.hasNext() == false) goto L31;
        String r19 = r18.next();
        r11.f21907c.put(r19, Integer.valueOf(r17.optInt(r19)));
        goto L29
    L31:
        r11.f21909e = r14.optInt("bl_disable_time_ms", 1000);
    L41:
        this.f21895c.put(r16, r11);
        goto L42
    L33:
        if (r14.isNull("wl") == true) goto L41;
        r11.f21905a = true;
        r11.f21906b = false;
        JSONArray r20 = r14.optJSONArray("wl");
        if (r20 == null) goto L40;
        int r21 = 0;
    L38:
        if (r21 >= r20.length()) goto L40;
        r11.f21908d.add((String) r20.opt(r21));
        r21 = r21 + 1;
    L40:
        r11.f21910f = r14.optInt("delay_time_ms", 100);
        r11.f21911g = r14.optInt("wl_disable_time_ms", 1000);
        goto L41
    L15:
        if (r15 != 0) goto L17;
        r16 = TTAppStateManager.AppStartState.ColdStart;
        goto L26
    L17:
        if (r15 != 1) goto L20;
        r16 = TTAppStateManager.AppStartState.HotStart;
        goto L26
    L20:
        if (r15 != 2) goto L23;
        r16 = TTAppStateManager.AppStartState.WarmStart;
        goto L26
    L23:
        if (r15 != 3) goto L42;
        r16 = TTAppStateManager.AppStartState.WeakNet;
    L42:
        r10 = r10 + 1;
        goto L8
    }

    public void f(JSONObject r10) {
        this.f21896d = r10.toString();
        i();
        e(r10);
        b(this.f21893a).k(TTAppStateManager.a());
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public int getDelayTimeByApp(String r10) {
        boolean r11 = this.f21898f;
        int r12 = 0;
        if (r11 == false) goto L17;
        Map r13 = this.f21902j;
        if (r13 == null) goto L17;
        Iterator r14 = r13.keySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L21;
        String r15 = (String) r14.next();
        if (TextUtils.isEmpty(r15) == true) goto L8;
        if (r10.startsWith(r15) == false) goto L8;
        Integer r16 = (Integer) this.f21902j.get(r15);
        if (r16 == null) goto L21;
        r12 = r16.intValue();
    L21:
        if (r12 <= 0) goto L23;
        this.f21904l.incrementAndGet();
        this.f21903k.put(r10, Integer.valueOf(r12));
    L23:
        return r12;
    L17:
        if (r11 == true) goto L21;
        if (r6.a.a(r10, this.f21901i) == false) goto L21;
        r12 = this.f21900h;
        goto L21
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public int getDispatchDelayTime(String r10, String r11) {
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().c(r10, r11);
    }

    public void h() {
        String r10 = this.f21893a.getSharedPreferences("tt_state_config", 4).getString("tnc_delay_config", "");
        this.f21896d = r10;
        if (TextUtils.isEmpty(r10) == true) goto L9;
        e(new JSONObject(this.f21896d));     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if (this.f21894b == false) goto L14;
        k(TTAppStateManager.a());
        return;
    }

    public final void i() {
        SharedPreferences.Editor r10 = this.f21893a.getSharedPreferences("tt_state_config", 4).edit();
        r10.putString("tnc_delay_config", this.f21896d);
        SharedPrefsEditorCompat.a(r10);
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public boolean isAppDelayHandleEnable() {
        return this.f21897e;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public boolean isDispatchDelayEnabled() {
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.g.l().n();
    }

    public final synchronized void j(b r10) {
        monitor-enter(this);
        this.f21898f = false;     // Catch: Throwable -> L7
        this.f21902j.clear();     // Catch: Throwable -> L7
        this.f21900h = 100;     // Catch: Throwable -> L7
        this.f21901i.clear();     // Catch: Throwable -> L7
        this.f21899g = 1000;     // Catch: Throwable -> L7
        this.f21903k.clear();     // Catch: Throwable -> L7
        if (r10 != null) goto L10;
        this.f21897e = false;     // Catch: Throwable -> L7
    L15:
        l();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L10:
        if (r10.f21908d.isEmpty() == true) goto L13;
        this.f21897e = true;     // Catch: Throwable -> L7
        this.f21900h = r10.f21910f;     // Catch: Throwable -> L7
        this.f21901i = r10.f21908d;     // Catch: Throwable -> L7
        this.f21899g = r10.f21911g;     // Catch: Throwable -> L7
        goto L15
    L13:
        if (r10.f21907c.isEmpty() == true) goto L15;
        this.f21897e = true;     // Catch: Throwable -> L7
        this.f21898f = true;     // Catch: Throwable -> L7
        this.f21902j = r10.f21907c;     // Catch: Throwable -> L7
        this.f21899g = r10.f21909e;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void k(TTAppStateManager.AppStartState r10) {
        j((b) this.f21895c.get(r10));
        TTAppStateManager.c(r10);
        if (r10 == TTAppStateManager.AppStartState.ColdStart) goto L5;
        return;
    L5:
        if (this.f21897e == false) goto L9;
        new Handler(Looper.getMainLooper()).postDelayed(new g(this), this.f21899g);
        return;
    }

    public final void l() {
        LinkedHashMap r10 = new LinkedHashMap();
        if (this.f21897e == false) goto L5;
        r10.put("app_delay_enable", 1);
    L7:
        if (this.f21898f == false) goto L9;
        r10.put("app_delay_use_black_list", 1);
    L10:
        r10.put("app_delay_whitelist_delay_time", Integer.valueOf(this.f21900h));
        String[] r11 = (String[]) this.f21901i.toArray(new String[0]);
        StringBuilder r12 = new StringBuilder();
        int r13 = r11.length;
        int r14 = 0;
    L11:
        if (r14 >= r13) goto L14;
        r12.append(r11[r14]);
        r12.append(",");
        r14 = r14 + 1;
        goto L11
    L14:
        if (r11.length <= 0) goto L16;
        r10.put("app_delay_white_list", r12.substring(0, r12.length() - 1));
    L17:
        r10.put("app_delay_black_list", new JSONObject(this.f21902j).toString());
        TTNetInit.getTTNetDepend().saveMapToProvider(this.f21893a, r10);
        Intent r15 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION");
        if (TextUtils.isEmpty(f21891m) == true) goto L20;
        r15.setPackage(f21891m);
    L20:
        this.f21893a.sendBroadcast(r15);
        return;
    L16:
        r10.put("app_delay_white_list", "");
        goto L17
    L9:
        r10.put("app_delay_use_black_list", 0);
        goto L10
    L5:
        r10.put("app_delay_enable", 0);
        goto L7
    }
}
