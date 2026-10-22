package com.bytedance.crash.config;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.crash.o.i;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.p;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.obric.aiagent.platform.depend.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ConfigManager implements Runnable {
    private static final String TAG = "ConfigManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<com.bytedance.crash.monitor.f, ConfigManager> f7271a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f7272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f7273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.crash.monitor.f f7275e;
    private volatile boolean f;
    private boolean g;
    private long h;
    private List<b> i;
    private long j;
    private ConfigFileObserver k;

    private class ConfigFileObserver extends FileObserver {
        private final File configFile;
        final /* synthetic */ ConfigManager this$0;

        public ConfigFileObserver(ConfigManager r2, File r3) {
            this.this$0 = r2;
            super(r3.getAbsolutePath(), 264);
            this.configFile = r3;
        }

        public void start() {
            if (this.configFile.exists() == false) goto L9;
        L7:
            startWatching();
            return;
        L9:
            this.configFile.createNewFile();     // Catch: IOException -> L6
        }

        @Override // android.os.FileObserver
        public void onEvent(int r1, String r2) {
            if ((r1 & 8) == 0) goto L6;
            this.this$0.c();
            return;
        }
    }

    public static /* synthetic */ void a(ConfigManager r0, File r1) {
        r0.f7272b = r1;
    }

    public static /* synthetic */ File b(ConfigManager r0) {
        return r0.f7272b;
    }

    public static /* synthetic */ com.bytedance.crash.monitor.f c(ConfigManager r0) {
        return r0.f7275e;
    }

    private File g() {
        return a(this);
    }

    static /* synthetic */ boolean d(ConfigManager r0) {
        return r0.f();
    }

    static {
        f7271a = new ConcurrentHashMap();
    }

    public ConfigManager(com.bytedance.crash.monitor.f r3) {
        this.f7274d = 1200;
        this.f = false;
        this.h = -1;
        this.j = 60000;
        this.f7275e = r3;
        this.i = new CopyOnWriteArrayList();
        f7271a.put(r3, this);
    }

    public synchronized void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f = true;     // Catch: Throwable -> L11
        r.b(TAG, "init：" + this.f7275e.e());     // Catch: Throwable -> L11
        DefaultWorkThread.post(this);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (TextUtils.isEmpty(this.f7275e.e()) == false) goto L5;
    L9:
        r.b(TAG, "app id isEmpty：");
        if (ZeusTransformUtils.instanceOf(this.f7275e, com.bytedance.crash.monitor.a.class) == false) goto L12;
        DefaultWorkThread.postDelayed(this, 200);
        return;
    L12:
        DefaultWorkThread.postDelayed(this, 500);
        return;
    L5:
        if (TextUtils.isEmpty(this.f7275e.a("")) == true) goto L9;
        DefaultWorkThread.removeCallbacks(this);
        b();
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.i != null) goto L9;
        this.i = new CopyOnWriteArrayList();
    L9:
        if (this.i.contains(r4) == true) goto L12;
        this.i.add(r4);
    L12:
        if (this.g == false) goto L15;
        r4.a(this.f7273c);
        return;
    }

    public void b() {
        c();
        if (com.bytedance.crash.o.b.b() == false) goto L14;
        long r0 = System.currentTimeMillis() - this.h;
        long r2 = this.f7274d * 1000;
        if (r0 <= r2) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        d();
        return;
    L13:
        DefaultWorkThread.postDelayed(new AnonymousClass1(this), r2 - r0);
        return;
    L7:
        if (r0 < 0) goto L10;
        r4 = false;
        goto L11
    L14:
        ConfigFileObserver r1 = new ConfigFileObserver(this, g());
        this.k = r1;
        r1.start();
    }

    public void c() {
        String r1 = e();
        if (TextUtils.isEmpty(r1) == true) goto L14;
        JSONObject r2 = new JSONObject(r1);     // Catch: Exception -> L9
        this.h = r2.optLong("monitor_configure_refresh_time");     // Catch: Exception -> L9
        if (h.f() == false) goto L7;
        r.b(TAG, "updateFromLocal:" + this.f7275e.e() + " " + this.h);     // Catch: Exception -> L9
    L7:
        b(r2);     // Catch: Exception -> L9
        a(r2, true);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        r.a(TAG, "updateFromLocal", e);
        return;
    }

    public boolean a(JSONObject r6) {
    L9:
        e = move-exception;
        r.a(TAG, "saveConfig", e);
        return false;
    L4:
        if (h.f() == false) goto L6;
        r.b(TAG, "saveConfig :" + r6);     // Catch: Exception -> L9
    L6:
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L9
        this.h = r2;     // Catch: Exception -> L9
        r6.put("monitor_configure_refresh_time", r2);     // Catch: Exception -> L9
        j.a(g(), r6, false);     // Catch: Exception -> L9
        b(r6);     // Catch: Exception -> L9
        a(r6, false);     // Catch: Exception -> L9
        return true;
    }

    private void a(JSONObject r3, boolean r4) {
        this.g = true;
        List<b> r2 = this.i;
        if (r2 == null) goto L12;
        Iterator<b> r5 = r2.iterator();
    L6:
        if (r5.hasNext() == false) goto L19;
        ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")).a(r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r.a(TAG, "notifyListenerRefresh", th);
        goto L6
    L19:
        return;
    }

    private String e() {
        File r0 = g();
        return j.d(r0);
    L5:
        if (r0 == null) goto L11;
        r0.delete();
        return null;
    L11:
        return null;
    }

    private void b(JSONObject r5) {
        if (l.a(r5) == false) goto L5;
        return;
    L5:
        this.f7273c = r5;
        JSONObject r6 = l.a(r5, "general", "slardar_api_settings");
        if (r6 == null) goto L17;
        JSONObject r7 = r6.optJSONObject("fetch_setting");
        if (r7 == null) goto L11;
        this.f7274d = r7.optLong("fetch_setting_interval", 1200);
    L11:
        if (this.f7274d >= 600) goto L14;
        this.f7274d = 600;
    L14:
        if (h.f() == false) goto L18;
        r.b(TAG, "updateCurrentConfig:" + this.f7274d);
        return;
    L18:
        return;
    }

    public void d() {
        if (p.b() == true) goto L7;
        DefaultWorkThread.postDelayed(new AnonymousClass2(this), 300000);
        return;
    L7:
        if (f() == false) goto L9;
        long r0 = this.f7274d;
    L11:
        if (h.f() == false) goto L13;
        r.b(TAG, "queryConfigFromRemote:" + r0);
    L13:
        DefaultWorkThread.postDelayed(new AnonymousClass3(this), r0 * 1000);
        return;
    L9:
        r0 = Math.min(this.j * 2, 600);
        this.j = r0;
        goto L11
    }

    private boolean f() {
        String r1 = o.a(f.c(), this.f7275e);     // Catch: Throwable -> L16
        if (h.f() == false) goto L6;
        r.b(TAG, "queryFromNet:" + r1);     // Catch: Throwable -> L16
    L6:
        byte[] r2 = com.bytedance.crash.upload.b.a(r1);     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
    L15:
        return false;
    L9:
        if (r2.length <= 0) goto L15;
        JSONObject r3 = new JSONObject(new String(r2)).optJSONObject("ret");     // Catch: Throwable -> L16
        if (r3 == null) goto L18;
        return a(r3);
    L18:
        return false;
    L16:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
        goto L18
    }

    public static File a(ConfigManager r6) {
        File r0 = b(r6);
        if (r0 != null) goto L5;
        File r2 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getFilesDir().getParentFile().getPath() + File.separator + "npth" + File.separator + "configs");
        if (r2.exists() == true) goto L9;
        i.b(r2);
    L9:
        com.bytedance.crash.monitor.f r3 = c(r6);
        if (r3 == null) goto L13;
        r0 = new File(r2, ((com.bytedance.crash.monitor.f) ZeusTransformUtils.preCheckCast(r3, com.bytedance.crash.monitor.f.class, "com.obric.aiagent.plugin")).e() + ".config");
        a(r6, r0);
    L13:
        return (File) ZeusTransformUtils.preCheckCast(r0, File.class, "com.obric.aiagent.plugin");
    L5:
        return (File) ZeusTransformUtils.preCheckCast(r0, File.class, "com.obric.aiagent.plugin");
    }
}
