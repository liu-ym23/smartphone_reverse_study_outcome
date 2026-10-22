package com.bytedance.bdtracker;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.IPullAbTestConfigCallback;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.store.kv.IKVStore;
import com.bytedance.applog.util.UriConstants;
import com.bytedance.bdtracker.j0;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.logpull.LogPullAuthActivity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import org.json.JSONObject;
import stepos.com.android.os.StatsLogEnums;

/* loaded from: classes.dex */
public class e0 implements Handler.Callback, Comparator<e4> {
    public final u3 A;
    public final j B;
    public final n1 C;
    public long D;
    public final j3 G;
    public b0 b;
    public boolean c;
    public final com.bytedance.bdtracker.d d;
    public final u1 e;
    public d0 f;
    public volatile k4 h;
    public final w1 i;
    public volatile Handler j;
    public h0 k;
    public i0 l;
    public volatile a0 m;
    public UriConfig o;
    public final Handler p;
    public l2 q;
    public volatile boolean r;
    public c0 s;
    public volatile g0 t;
    public volatile boolean v;
    public volatile long w;
    public volatile e1 y;
    public volatile InitConfig.IpcDataChecker z;
    public long a = 10000;
    public final ArrayList<e4> g = new ArrayList<>(32);
    public final CopyOnWriteArrayList<c0> u = new CopyOnWriteArrayList<>();
    public final List<d> x = new ArrayList();
    public volatile boolean E = false;
    public final j0 n = new j0(this);
    public final f0 F = new f0(this);

    public class a implements EventBus.DataFetcher {
        public a() {
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", e0.this.d.m);
                jSONObject.put("isMainProcess", e0.this.e.j());
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements g {
        public b() {
        }

        public void a(Map<String, String> map) {
            if (e0.this.i.e() == null || e0.this.i.e().opt(LogPullAuthActivity.EXTRA_OAID) != null || map == null) {
                return;
            }
            e0.this.j.obtainMessage(17, map).sendToTarget();
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ List a;

        public c(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            i0 i0Var = e0.this.l;
            List list = this.a;
            if (list == null || list.size() <= 0) {
                return;
            }
            n4 n4Var = new n4();
            e0 e0Var = e0.this;
            i0 i0Var2 = e0Var.l;
            JSONObject jSONObjectB = r.b(e0Var.i.e());
            IHeaderCustomTimelyCallback headerCustomCallback = i0Var2.f.getHeaderCustomCallback();
            if (headerCustomCallback != null) {
                headerCustomCallback.updateHeader(jSONObjectB);
            }
            n4Var.y = jSONObjectB;
            n4Var.m = e0.this.d.m;
            ArrayList arrayList = new ArrayList();
            for (e4 e4Var : this.a) {
                if (e4Var instanceof l4) {
                    arrayList.add((l4) e4Var);
                }
            }
            n4Var.s = arrayList;
            n4Var.m();
            n4Var.n();
            n4Var.z = n4Var.o();
            if (i0Var == null || !i0Var.a(n4Var)) {
                e0.this.D = System.currentTimeMillis();
                e0.this.p.obtainMessage(8, this.a).sendToTarget();
            } else {
                e0 e0Var2 = e0.this;
                e0Var2.D = 0L;
                k4 k4VarC = e0Var2.c();
                k4VarC.c.a(this.a);
            }
        }
    }

    public static abstract class d<T> {
        public T a;

        public d(T t) {
            this.a = t;
        }
    }

    public class e extends d<String> {
        public e(String str) {
            super(str);
        }
    }

    public e0(com.bytedance.bdtracker.d dVar, u1 u1Var, w1 w1Var, n1 n1Var) {
        this.d = dVar;
        this.e = u1Var;
        this.i = w1Var;
        this.C = n1Var;
        StringBuilder sbA = com.bytedance.bdtracker.a.a("bd_tracker_w:");
        sbA.append(dVar.m);
        HandlerThread handlerThread = new HandlerThread(sbA.toString());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.p = handler;
        j jVar = new j(this);
        this.B = jVar;
        if (u1Var.c.isDeferredALinkEnabled()) {
            dVar.addDataObserver(jVar);
        }
        w1Var.h.b.a(handler);
        if (w1Var.c.c.isMigrateEnabled()) {
            Context context = w1Var.b;
            try {
                try {
                    if (k2.a(context).c) {
                        u1 u1Var2 = w1Var.c;
                        if (u1Var2 != null) {
                            u1Var2.f.remove("google_aid");
                        }
                        IKVStore iKVStore = w1Var.g;
                        String strB = w1Var.h.b();
                        if (iKVStore != null) {
                            iKVStore.putString("old_did", strB);
                            iKVStore.putBoolean("is_migrate", true);
                        }
                        w1Var.h.a("openudid");
                        w1Var.h.a("clientudid");
                        w1Var.h.a("serial_number");
                        w1Var.h.a("sim_serial_number");
                        w1Var.h.a("udid");
                        w1Var.h.a("udid_list");
                        w1Var.h.a("device_id");
                        w1Var.b("clearMigrationInfo");
                    }
                } catch (Exception e2) {
                    LoggerImpl.global().debug("detect migrate is error, ", e2);
                }
                try {
                    k2.a(context).a();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                try {
                    k2.a(context).a();
                } catch (Throwable unused2) {
                }
                throw th;
            }
        }
        this.A = new u3(this);
        if (this.e.c.isClearDidAndIid()) {
            this.i.b(this.e.c.getClearKey());
        }
        if (this.e.c.getIpcDataChecker() != null && !this.e.j()) {
            this.z = this.e.c.getIpcDataChecker();
        }
        if (this.e.k()) {
            this.q = new q2(this);
        }
        this.p.sendEmptyMessage(10);
        if (this.e.c.autoStart()) {
            i();
        }
        this.G = new j3(this);
    }

    public void a() {
        y5.a(new b());
    }

    public void a(Long l) {
        long jLongValue = 0;
        if (l != null && l.longValue() > 0) {
            jLongValue = l.longValue();
        }
        this.a = jLongValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:9:0x001f, B:15:0x003b, B:17:0x0041, B:19:0x0047, B:12:0x0030), top: B:24:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(org.json.JSONObject r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "ssid"
            java.lang.String r2 = ""
            java.lang.String r3 = r8.optString(r1, r2)
            boolean r3 = com.bytedance.bdtracker.r.d(r3)
            r4 = 1
            if (r3 == 0) goto L14
            return r4
        L14:
            com.bytedance.bdtracker.d r3 = r7.d
            com.bytedance.applog.log.IAppLogLogger r3 = r3.D
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r6 = "Register to get ssid by temp header..."
            r3.debug(r6, r5)
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            r3.<init>()     // Catch: java.lang.Throwable -> L50
            com.bytedance.bdtracker.r.a(r3, r8)     // Catch: java.lang.Throwable -> L50
            com.bytedance.bdtracker.h0 r5 = r7.k     // Catch: java.lang.Throwable -> L50
            org.json.JSONObject r3 = r5.b(r3)     // Catch: java.lang.Throwable -> L50
            if (r3 != 0) goto L30
            goto L3a
        L30:
            java.lang.String r2 = r3.optString(r1, r2)     // Catch: java.lang.Throwable -> L50
            boolean r3 = com.bytedance.bdtracker.r.c(r2)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L3b
        L3a:
            r2 = 0
        L3b:
            boolean r3 = com.bytedance.bdtracker.r.d(r2)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L5c
            com.bytedance.bdtracker.d r3 = r7.d     // Catch: java.lang.Throwable -> L50
            com.bytedance.applog.log.IAppLogLogger r3 = r3.D     // Catch: java.lang.Throwable -> L50
            java.lang.String r5 = "Register to get ssid by header success."
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L50
            r3.debug(r5, r6)     // Catch: java.lang.Throwable -> L50
            r8.put(r1, r2)     // Catch: java.lang.Throwable -> L50
            return r4
        L50:
            r8 = move-exception
            com.bytedance.bdtracker.d r7 = r7.d
            com.bytedance.applog.log.IAppLogLogger r7 = r7.D
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "JSON handle failed"
            r7.error(r2, r8, r1)
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.e0.a(org.json.JSONObject):boolean");
    }

    public boolean a(boolean z) {
        if ((!this.c || z) && this.j != null) {
            this.c = true;
            this.j.removeMessages(11);
            this.j.sendEmptyMessage(11);
        }
        return this.c;
    }

    public Context b() {
        return this.d.n;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.a(jSONObject);
    }

    public k4 c() {
        if (this.h == null) {
            synchronized (this) {
                k4 k4Var = this.h;
                if (k4Var == null) {
                    k4Var = new k4(this, this.e.c.getDbName());
                }
                this.h = k4Var;
            }
        }
        return this.h;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.b(jSONObject);
    }

    @Override // java.util.Comparator
    public int compare(e4 e4Var, e4 e4Var2) {
        long j = e4Var.c - e4Var2.c;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public String d() {
        j0 j0Var = this.n;
        if (j0Var != null) {
            return j0Var.e;
        }
        return null;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.c(jSONObject);
    }

    public UriConfig e() {
        if (this.o == null) {
            UriConfig uriConfig = this.e.c.getUriConfig();
            this.o = uriConfig;
            if (uriConfig == null) {
                this.o = UriConstants.createUriConfig(0);
            }
        }
        return this.o;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.d(jSONObject);
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.A.e(jSONObject);
    }

    public final boolean f() {
        return this.e.i() && !TextUtils.isEmpty(e().getAbUri());
    }

    public boolean g() {
        u1 u1Var = this.e;
        return u1Var.r == 1 && u1Var.c.isAutoTrackEnabled();
    }

    public void h() {
        this.p.sendEmptyMessage(10);
    }

    public final void i() {
        this.r = true;
        w1 w1Var = this.i;
        if (w1Var.c.l()) {
            y5.b(w1Var.b);
        }
        this.p.sendEmptyMessage(1);
    }

    public void b(e4 e4Var) {
        if (this.t == null) {
            return;
        }
        if ((e4Var instanceof l4) || (((e4Var instanceof o4) && g()) || (e4Var instanceof h4) || (e4Var instanceof p4))) {
            JSONObject jSONObjectH = e4Var.h();
            if (e4Var instanceof o4) {
                if (!((o4) e4Var).k()) {
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectH.optJSONObject(MetricsSQLiteCacheKt.METRICS_PARAMS);
                if (jSONObjectOptJSONObject != null) {
                    try {
                        jSONObjectOptJSONObject.remove("duration");
                        jSONObjectH.put(MetricsSQLiteCacheKt.METRICS_PARAMS, jSONObjectOptJSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
            if ((e4Var instanceof h4) && !jSONObjectH.has("event")) {
                try {
                    jSONObjectH.put("event", jSONObjectH.optString("log_type", ((h4) e4Var).s));
                } catch (Throwable unused2) {
                }
            }
            this.d.k.a(jSONObjectH, this.t.g);
        }
    }

    public final void b(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(this.i.k());
        this.i.i(str);
        this.i.j(str2);
        this.i.h("");
        this.i.d("$tr_web_ssid");
        if (this.e.c.isClearABCacheOnUserChange() && !zIsEmpty) {
            this.i.f(null);
            this.i.m.clear();
        }
        this.v = true;
        if (this.j != null) {
            this.j.sendMessage(this.j.obtainMessage(12, str));
            return;
        }
        synchronized (this.x) {
            this.x.add(new e(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String[] r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.e0.a(java.lang.String[], boolean):void");
    }

    public void a(e4 e4Var) {
        int size;
        if (e4Var.c == 0) {
            this.d.D.warn("Data ts is 0", new Object[0]);
        }
        synchronized (this.g) {
            size = this.g.size();
            this.g.add(e4Var);
            this.n.a(this.d, e4Var, this.g);
        }
        boolean z = e4Var instanceof o4;
        if (size % 10 == 0 || z) {
            this.p.removeMessages(4);
            if (z || size != 0) {
                this.p.sendEmptyMessage(4);
            } else {
                this.p.sendEmptyMessageDelayed(4, 200L);
            }
        }
    }

    public final void a(String str) {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, this.i.e());
        try {
            h0 h0Var = this.k;
            if (h0Var == null || !h0Var.a(jSONObject)) {
                return;
            }
            if (r.d(str)) {
                this.e.f.putInt("is_first_time_launch", 1);
            }
            a(true);
        } catch (Throwable th) {
            this.d.D.error("Register new uuid:{} failed", th, str);
        }
    }

    public final void a(List<e4> list) {
        x.a.execute(new c(list));
    }

    public void a(String str, String str2) {
        String strK = this.i.k();
        String strL = this.i.l();
        boolean z = false;
        if (r.a(str, strK) && r.a(str2, strL)) {
            this.d.D.debug("setUserUniqueId not change", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        o4 o4VarA = w.a();
        boolean zD = r.d(this.n.e);
        if (zD && o4VarA != null) {
            o4VarA = (o4) o4VarA.m321clone();
            o4VarA.m = this.d.m;
            long j = jCurrentTimeMillis - o4VarA.c;
            o4VarA.a(jCurrentTimeMillis);
            if (j < 0) {
                j = 0;
            }
            o4VarA.s = j;
            o4VarA.B = this.n.n;
            this.n.a(this.d, o4VarA);
            arrayList.add(o4VarA);
        }
        b(str, str2);
        if (o4VarA == null) {
            o4VarA = w.m;
        } else {
            z = true;
        }
        if (zD && o4VarA != null) {
            o4 o4Var = (o4) o4VarA.m321clone();
            o4Var.a(jCurrentTimeMillis + 1);
            o4Var.s = -1L;
            this.n.a(this.d, o4Var, arrayList, true).v = this.n.n;
            if (z) {
                this.n.a(this.d, o4Var);
                arrayList.add(o4Var);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((e4) it.next());
        }
        this.p.sendEmptyMessage(14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.bdtracker.j0$a] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.bdtracker.e1] */
    /* JADX WARN: Type inference failed for: r4v5 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Map<String, ?> all;
        Set set;
        Set set2;
        c0 c0Var;
        String str;
        String str2;
        ?? g1Var = 0;
        String[] strArr = null;
        g1Var = 0;
        g1Var = 0;
        switch (message.what) {
            case 1:
                this.d.D.info("AppLog is starting...", new Object[0]);
                u1 u1Var = this.e;
                u1Var.r = u1Var.f.getBoolean("bav_log_collect", u1Var.c.isAutoTrackEnabled()) ? 1 : 0;
                if (this.i.q()) {
                    if (this.e.j()) {
                        StringBuilder sbA = com.bytedance.bdtracker.a.a("bd_tracker_n:");
                        sbA.append(this.d.m);
                        HandlerThread handlerThread = new HandlerThread(sbA.toString());
                        handlerThread.start();
                        this.j = new Handler(handlerThread.getLooper(), this);
                        this.j.sendEmptyMessage(2);
                        if (this.g.size() > 0) {
                            this.p.removeMessages(4);
                            this.p.sendEmptyMessageDelayed(4, 1000L);
                        }
                        Application application = this.d.n;
                        m5.a = true;
                        x.a.submit(new n5(application));
                        this.d.D.info("AppLog started on main process.", new Object[0]);
                    } else {
                        this.d.D.info("AppLog started on secondary process.", new Object[0]);
                    }
                    if (!LogUtils.isDisabled()) {
                        LogUtils.sendJsonFetcher("start_end", new a());
                    }
                } else {
                    this.d.D.info("AppLog is not ready, will try start again after 1 second...", new Object[0]);
                    this.p.removeMessages(1);
                    this.p.sendEmptyMessageDelayed(1, 1000L);
                }
                return true;
            case 2:
                h0 h0Var = new h0(this);
                this.k = h0Var;
                this.u.add(h0Var);
                InitConfig initConfig = this.e.c;
                if (initConfig == null || initConfig.isTrackEventEnabled()) {
                    i0 i0Var = new i0(this);
                    this.l = i0Var;
                    this.u.add(i0Var);
                    this.E = true;
                }
                UriConfig uriConfigE = e();
                if (!TextUtils.isEmpty(uriConfigE.getSettingUri())) {
                    d0 d0Var = new d0(this);
                    this.f = d0Var;
                    this.u.add(d0Var);
                }
                if (!TextUtils.isEmpty(uriConfigE.getProfileUri())) {
                    Handler handler = this.A.b;
                    handler.sendMessage(handler.obtainMessage(StatsLogEnums.InvalidConfigReasonEnum.INVALID_CONFIG_REASON_VALUE_METRIC_HIST_WITH_UPLOAD_THRESHOLD_VALUE));
                }
                this.j.removeMessages(13);
                this.j.sendEmptyMessage(13);
                String strA = com.bytedance.bdtracker.b.a(this.d, "sp_filter_name");
                if (this.i.g.getInt("version_code", 0) != this.i.m() || !TextUtils.equals(this.e.f.getString("channel", ""), this.e.c())) {
                    h0 h0Var2 = this.k;
                    if (h0Var2 != null) {
                        h0Var2.b = true;
                    }
                    d0 d0Var2 = this.f;
                    if (d0Var2 != null) {
                        d0Var2.b = true;
                    }
                    if (this.e.c.isEventFilterEnable()) {
                        this.y = e1.a(this.d.n, strA, null);
                    }
                } else if (this.e.c.isEventFilterEnable()) {
                    try {
                        IKVStore iKVStoreA = v4.a(this.d.n, strA);
                        HashSet hashSet = new HashSet();
                        HashMap map = new HashMap();
                        try {
                            all = iKVStoreA.getAll();
                        } catch (Throwable unused) {
                            all = null;
                        }
                        if (all != null && all.size() > 0) {
                            int i = 0;
                            for (Map.Entry<String, ?> entry : all.entrySet()) {
                                if (entry != null) {
                                    String key = entry.getKey();
                                    if ("is_block".equals(key)) {
                                        i = iKVStoreA.getInt("is_block", 0);
                                    } else if ("events".equals(key)) {
                                        try {
                                            set2 = (Set) entry.getValue();
                                        } catch (Throwable unused2) {
                                            set2 = null;
                                        }
                                        if (set2 != null && set2.size() > 0) {
                                            hashSet.addAll(set2);
                                        }
                                    } else if (!TextUtils.isEmpty(key)) {
                                        HashSet hashSet2 = new HashSet();
                                        try {
                                            set = (Set) entry.getValue();
                                        } catch (Throwable unused3) {
                                            set = null;
                                        }
                                        if (set != null && set.size() > 0) {
                                            hashSet2.addAll(set);
                                        }
                                        if (hashSet2.size() > 0) {
                                            map.put(key, hashSet2);
                                        }
                                    }
                                }
                            }
                            g1Var = i > 0 ? new g1(hashSet, map) : new f1(hashSet, map);
                        }
                    } catch (Throwable unused4) {
                    }
                    this.y = g1Var;
                }
                this.j.removeMessages(6);
                this.j.sendEmptyMessage(6);
                l2 l2Var = this.q;
                if (l2Var != null) {
                    q2 q2Var = (q2) l2Var;
                    u1 u1Var2 = q2Var.c.e;
                    Intrinsics.checkExpressionValueIsNotNull(u1Var2, "mEngine.config");
                    if (u1Var2.k()) {
                        q2Var.b.a(new p2(q2Var));
                    }
                }
                return true;
            case 3:
            case 5:
            default:
                this.d.D.error("Unknown handler message type", new Object[0]);
                return true;
            case 4:
                a((String[]) message.obj, false);
                return true;
            case 6:
                this.j.removeMessages(6);
                boolean z = this.d.x;
                long j = Constants.IPC_TIMEOUT;
                if (!z && (!this.e.c.isSilenceInBackground() || this.n.a())) {
                    Iterator<c0> it = this.u.iterator();
                    long j2 = LongCompanionObject.MAX_VALUE;
                    while (it.hasNext()) {
                        c0 next = it.next();
                        if (!next.f()) {
                            long jA = next.a();
                            if (jA < j2) {
                                j2 = jA;
                            }
                        }
                    }
                    long jCurrentTimeMillis = j2 - System.currentTimeMillis();
                    if (jCurrentTimeMillis <= Constants.IPC_TIMEOUT) {
                        j = jCurrentTimeMillis;
                    }
                }
                this.j.sendEmptyMessageDelayed(6, j);
                if (this.x.size() > 0) {
                    synchronized (this.x) {
                        for (d dVar : this.x) {
                            if (dVar != null) {
                                e eVar = (e) dVar;
                                e0.this.a((String) eVar.a);
                            }
                        }
                        this.x.clear();
                    }
                }
                return true;
            case 7:
                synchronized (this.g) {
                    ArrayList<e4> arrayList = this.g;
                    if (j0.q == null) {
                        j0.q = new j0.b(g1Var);
                    }
                    j0.q.a(0L);
                    arrayList.add(j0.q);
                }
                a((String[]) null, false);
                return true;
            case 8:
                c().c.b((ArrayList) message.obj);
                return true;
            case 9:
                c0 c0Var2 = this.s;
                if (!c0Var2.f()) {
                    long jA2 = c0Var2.a();
                    if (!c0Var2.f()) {
                        this.j.sendEmptyMessageDelayed(9, jA2 - System.currentTimeMillis());
                    }
                }
                return true;
            case 10:
                synchronized (this.g) {
                    int iA = this.C.a(this.g, this.d, this.n);
                    this.d.D.debug("[event_process] dumpData size: " + iA, new Object[0]);
                }
                n1 n1Var = this.C;
                int size = n1Var.b.size();
                if (size > 0) {
                    strArr = new String[size];
                    n1Var.b.toArray(strArr);
                    n1Var.b.clear();
                }
                a(strArr, false);
                return true;
            case 11:
                b0 b0Var = this.b;
                if (b0Var == null) {
                    b0 b0Var2 = new b0(this);
                    this.b = b0Var2;
                    this.u.add(b0Var2);
                } else {
                    b0Var.setStop(false);
                }
                c0Var = this.b;
                a(c0Var);
                return true;
            case 12:
                Object obj = message.obj;
                a(obj != null ? obj.toString() : null);
                return true;
            case 13:
                if (!f()) {
                    if (this.m != null) {
                        this.m.setStop(true);
                        this.u.remove(this.m);
                        this.m = null;
                    }
                    this.i.a();
                    return true;
                }
                if (this.m == null) {
                    this.m = new a0(this);
                }
                if (!this.u.contains(this.m)) {
                    this.u.add(this.m);
                }
                c0Var = this.m;
                a(c0Var);
                return true;
            case 14:
                a((String[]) null, true);
                return true;
            case 15:
                Object[] objArr = (Object[]) message.obj;
                boolean zBooleanValue = ((Boolean) objArr[0]).booleanValue();
                String str3 = (String) objArr[1];
                if (this.t != null) {
                    this.t.setStop(true);
                    this.u.remove(this.t);
                    this.t = null;
                }
                if (zBooleanValue) {
                    this.t = new g0(this, str3);
                    this.u.add(this.t);
                    this.j.removeMessages(6);
                    this.j.sendEmptyMessage(6);
                }
                return true;
            case 16:
                b((e4) message.obj);
                return true;
            case 17:
                Map map2 = (Map) message.obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(LogPullAuthActivity.EXTRA_OAID, new JSONObject(map2));
                    String strC = this.i.c();
                    String strF = this.i.f();
                    jSONObject.put("bd_did", strC);
                    jSONObject.put("install_id", strF);
                    if (p5.c.b(new Object[0]).booleanValue()) {
                        str = "os";
                        str2 = "Harmony";
                    } else {
                        str = "os";
                        str2 = "Android";
                    }
                    jSONObject.put(str, str2);
                    jSONObject.put("aid", this.i.c.c.getAid());
                    this.d.D.debug("Report oaid success: {}", this.k.c(jSONObject));
                } catch (Throwable th) {
                    this.d.D.error("Report oaid failed", th, new Object[0]);
                }
                return true;
            case 18:
                Object obj2 = message.obj;
                if (obj2 instanceof IPullAbTestConfigCallback) {
                    int i2 = message.arg1;
                    IPullAbTestConfigCallback iPullAbTestConfigCallback = (IPullAbTestConfigCallback) obj2;
                    if (f()) {
                        if (this.m == null) {
                            this.m = new a0(this);
                        }
                        try {
                            JSONObject jSONObjectA = this.m.a(i2);
                            if (iPullAbTestConfigCallback != null) {
                                iPullAbTestConfigCallback.onRemoteConfig(jSONObjectA);
                            }
                        } catch (i3 unused5) {
                            if (iPullAbTestConfigCallback != null) {
                                iPullAbTestConfigCallback.onTimeoutError();
                            }
                        }
                    } else {
                        this.d.D.warn("ABTest is not enabled", new Object[0]);
                    }
                } else {
                    a(this.m);
                }
                return true;
        }
    }

    public final void a(c0 c0Var) {
        if (this.j == null || c0Var == null || this.d.x) {
            return;
        }
        c0Var.i();
        if (Looper.myLooper() == this.j.getLooper()) {
            c0Var.a();
        } else {
            this.j.removeMessages(6);
            this.j.sendEmptyMessage(6);
        }
    }
}
