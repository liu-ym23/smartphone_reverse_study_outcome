package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInitMetrics {
    public static final String G = "TTNetInitMetrics";
    public static volatile TTNetInitMetrics H;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CronetInitMode f7209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f7215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f7216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f7217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f7218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f7219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f7220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f7222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f7223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f7224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f7225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f7226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f7227s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f7228t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f7229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f7230v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f7231w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f7232x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f7233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f7234z;

    public static final enum CronetInitMode extends Enum<CronetInitMode> {
        private static final /* synthetic */ CronetInitMode[] $VALUES = null;
        public static final CronetInitMode FORCE_INIT = null;
        public static final CronetInitMode LAZY_INIT = null;
        public static final CronetInitMode NONE = null;
        public static final CronetInitMode PRE_INIT = null;
        final int initMode;

        static {
            CronetInitMode r10 = new CronetInitMode("NONE", 0, 0);
            NONE = r10;
            CronetInitMode r11 = new CronetInitMode("LAZY_INIT", 1, 1);
            LAZY_INIT = r11;
            CronetInitMode r12 = new CronetInitMode("PRE_INIT", 2, 2);
            PRE_INIT = r12;
            CronetInitMode r13 = new CronetInitMode("FORCE_INIT", 3, 3);
            FORCE_INIT = r13;
            $VALUES = new CronetInitMode[]{r10, r11, r12, r13};
        }

        private CronetInitMode(String r10, int r11, int r12) {
            super(r10, r11);
            this.initMode = r12;
        }

        public static CronetInitMode valueOf(String r10) {
            return (CronetInitMode) Enum.valueOf(CronetInitMode.class, r10);
        }

        public static CronetInitMode[] values() {
            return (CronetInitMode[]) $VALUES.clone();
        }
    }

    static {
    }

    public TTNetInitMetrics() {
        this.f7209a = CronetInitMode.NONE;
        this.f7210b = true;
        this.f7227s = -1;
        this.f7228t = -1;
        this.f7229u = -1;
        this.f7230v = -1;
        this.f7231w = -1;
        this.f7232x = -1;
        this.f7233y = -1;
        this.f7234z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = -1;
        this.F = -1;
    }

    public static TTNetInitMetrics c() {
        if (H != null) goto L16;
        monitor-enter(TTNetInitMetrics.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (H != null) goto L11;
        H = new TTNetInitMetrics();     // Catch: Throwable -> L9
    L11:
        monitor-exit(TTNetInitMetrics.class);     // Catch: Throwable -> L9
    L16:
        return H;
    }

    public void a(Context r10, List r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.size() != 2) goto L12;
        String r12 = G;
        Logger.d(r12, "http address: " + r11.get(0) + " ws address: " + r11.get(1));
        this.f7214f = System.currentTimeMillis();
        if (e(r10, r11) == true) goto L9;
        Logger.d(r12, "init mssdk failed.");
    L9:
        this.f7215g = System.currentTimeMillis();
        return;
    }

    public void b(Context r10) {
        long r11 = System.currentTimeMillis();
        e(r10, null);
        this.f7216h = System.currentTimeMillis() - r11;
    }

    public boolean d() {
        CronetInitMode r10 = this.f7209a;
        if (r10 != CronetInitMode.PRE_INIT) goto L5;
    L8:
        return true;
    L5:
        if (r10 == CronetInitMode.FORCE_INIT) goto L8;
        return false;
    }

    public final boolean e(Context r10, List r11) {
        HashMap r12 = null;
        Class<?> r13 = Class.forName("com.bytedance.mobsec.metasec.ml.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r13 != null) goto L9;
        r13 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L22
    L9:
        if (r13 != null) goto L12;
        return false;
    L12:
        if (r11 != null) goto L27;
    L18:
        r13.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r13, new Object[]{r10, 1, r12});     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        th.printStackTrace();
        return false;
    L27:
        if (r11.size() != 2) goto L18;
        r12 = new HashMap();     // Catch: Throwable -> L16
        r12.put("http_callback", String.valueOf(r11.get(0)));     // Catch: Throwable -> L16
        r12.put("ws_callback", String.valueOf(r11.get(1)));     // Catch: Throwable -> L16
    L5:
        r13 = null;
        goto L6
    }

    public JSONObject f() {
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        r10.put("mode", this.f7209a.initMode);     // Catch: JSONException -> L6
        r10.put("is_main_process", this.f7210b);     // Catch: JSONException -> L6
        r10.put("net_thread_priority", this.f7211c);     // Catch: JSONException -> L6
        r11.put("ttnet_start", this.f7212d);     // Catch: JSONException -> L6
        r11.put("ttnet_end", this.f7213e);     // Catch: JSONException -> L6
        r11.put("engine_start", this.f7217i);     // Catch: JSONException -> L6
        r11.put("engine_end", this.f7218j);     // Catch: JSONException -> L6
        r11.put("init_start", this.f7219k);     // Catch: JSONException -> L6
        r11.put("init_end", this.f7220l);     // Catch: JSONException -> L6
        r11.put("network_start", this.f7223o);     // Catch: JSONException -> L6
        r11.put("network_end", this.f7224p);     // Catch: JSONException -> L6
        r11.put("exec_wait_end", this.f7225q);     // Catch: JSONException -> L6
        r11.put("preconnect_start", this.f7226r);     // Catch: JSONException -> L6
        r12.put("builder_build", this.f7227s);     // Catch: JSONException -> L6
        r12.put("load_cronet", this.f7228t);     // Catch: JSONException -> L6
        r12.put("init_mssdk", this.f7216h);     // Catch: JSONException -> L6
        g(r12, "init_ttnet", this.f7212d, this.f7213e);     // Catch: JSONException -> L6
        g(r12, "init_metasec", this.f7214f, this.f7215g);     // Catch: JSONException -> L6
        g(r12, "create_engine", this.f7217i, this.f7218j);     // Catch: JSONException -> L6
        g(r12, "init_thread", this.f7219k, this.f7220l);     // Catch: JSONException -> L6
        g(r12, "native_init_thread", this.f7221m, this.f7222n);     // Catch: JSONException -> L6
        g(r12, "network_thread", this.f7223o, this.f7224p);     // Catch: JSONException -> L6
        g(r12, "exec_tasks", this.f7224p, this.f7225q);     // Catch: JSONException -> L6
        g(r12, "init_total", this.f7212d, this.f7224p);     // Catch: JSONException -> L6
        g(r12, "init_preconnect", this.f7212d, this.f7226r);     // Catch: JSONException -> L6
        r12.put("nqe_init", this.f7229u);     // Catch: JSONException -> L6
        r12.put("prefs_init", this.f7230v);     // Catch: JSONException -> L6
        r12.put("channel_init", this.f7231w);     // Catch: JSONException -> L6
        r12.put("context_build", this.f7232x);     // Catch: JSONException -> L6
        r12.put("tnc_config", this.f7233y);     // Catch: JSONException -> L6
        r12.put("update_appinfo", this.f7234z);     // Catch: JSONException -> L6
        r12.put("netlog_init", this.A);     // Catch: JSONException -> L6
        r12.put("nqe_detect", this.B);     // Catch: JSONException -> L6
        r12.put("preconnect", this.C);     // Catch: JSONException -> L6
        r12.put("ssl_session", this.D);     // Catch: JSONException -> L6
        r12.put("ttnet_config", this.E);     // Catch: JSONException -> L6
        r12.put("install_cert", this.F);     // Catch: JSONException -> L6
        r10.put("ttnet_timestamp", r11);     // Catch: JSONException -> L6
        r10.put("ttnet_duration", r12);     // Catch: JSONException -> L6
    L4:
        Logger.d(G, "cronet init metrics json: " + r10.toString());
        return r10;
    }

    public final void g(JSONObject r10, String r11, long r12, long r13) {
        if (r12 > r13) goto L5;
        r10.put(r11, r13 - r12);     // Catch: JSONException -> L8
    L9:
        return;
    L5:
        r10.put(r11, -1);     // Catch: JSONException -> L8
    }
}
