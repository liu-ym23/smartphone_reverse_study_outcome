package com.bytedance.crash.resource;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.g;
import com.bytedance.crash.d.f;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.general.AppInfo;
import com.bytedance.crash.general.RomInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.h;
import com.bytedance.crash.o.i;
import com.bytedance.crash.o.j;
import com.bytedance.crash.o.l;
import com.bytedance.crash.o.r;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.o;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResourceMonitorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private static final String TAG = "ResourceMonitorAdapter: ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected File f7691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f7692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f7693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected File f7694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.bytedance.crash.resource.f.a f7695e;
    protected boolean f;
    protected boolean g;

    /* JADX INFO: compiled from: ResourceMonitorAdapter.java */
    public static abstract class a {
        private static final String TAG = "ResourceMonitorUploader: ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected com.bytedance.crash.monitor.a f7698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected File f7699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected String f7700c;

        public static String a(long r3) {
            if (r3 > 350) goto L6;
            return "~350MB";
        L6:
            if (r3 <= 350) goto L11;
            if (r3 > 450) goto L11;
            return "350MB~450MB";
        L11:
            if (r3 <= 450) goto L16;
            if (r3 > 550) goto L16;
            return "450MB~550MB";
        L16:
            if (r3 <= 550) goto L21;
            if (r3 > 650) goto L21;
            return "550MB~650MB";
        L21:
            if (r3 <= 650) goto L26;
            if (r3 > 750) goto L26;
            return "650MB~750MB";
        L26:
            if (r3 <= 750) goto L31;
            if (r3 > 850) goto L31;
            return "750MB~850MB";
        L31:
            if (r3 <= 850) goto L36;
            if (r3 > 950) goto L36;
            return "850MB~950MB";
        L36:
            if (r3 <= 950) goto L41;
            if (r3 > 1050) goto L41;
            return "950MB~1050MB";
        L41:
            if (r3 <= 1050) goto L46;
            if (r3 > 1250) goto L46;
            return "1050MB~1250MB";
        L46:
            if (r3 <= 1250) goto L51;
            if (r3 > 1450) goto L51;
            return "1250MB~1450MB";
        L51:
            if (r3 <= 1450) goto L56;
            if (r3 > 1650) goto L56;
            return "1450MB~1650MB";
        L56:
            if (r3 <= 1650) goto L61;
            if (r3 > 1850) goto L61;
            return "1650MB~1850MB";
        L61:
            if (r3 > 1850) goto L63;
        L65:
            return ">2.3G";
        L63:
            if (r3 > 2050) goto L65;
            return "1850MB~2050MB";
        }

        public abstract boolean a(File r1, C0172b r2);

        static /* synthetic */ void a(a r0, f r1, File r2, C0172b r3) {
            r0.a(r1, r2, r3);
        }

        public a(com.bytedance.crash.monitor.a r1, File r2) {
            this.f7698a = r1;
            this.f7699b = r2;
            this.f7700c = r2.getAbsolutePath() + "/" + com.bytedance.crash.crash.b.b();
        }

        public void a() {
            File[] r0 = this.f7699b.listFiles();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = r0.length;
            int r2 = 0;
            int r3 = 0;
        L6:
            if (r2 >= r1) goto L32;
            File r4 = r0[r2];
            if (this.f7700c.equals(r4.getAbsolutePath()) == true) goto L31;
            if (r4.isFile() == true) goto L31;
            if (j.c(r4) == true) goto L30;
            int r5 = r3 + 1;
            if (r3 < 10) goto L17;
            r3 = r5;
            goto L30
        L17:
            C0172b r6 = new C0172b();
            HashMap r7 = new HashMap();
            if (a(r4, r6) == false) goto L21;
            a(r7, r6);     // Catch: Throwable -> L23
            NativeBridge.r(r4.getAbsolutePath());     // Catch: Throwable -> L23
            a(r4, r7, r6);     // Catch: Throwable -> L23
        L22:
            j.a(r4);
            r3 = r5;
            goto L31
        L21:
            j.a(r4);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            r.c(TAG, "upload exception:" + th);     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            j.a(r4);
            throw th;
        L30:
            j.a(r4);
        L31:
            r2 = r2 + 1;
            goto L6
        }

        public void a(File r6, JSONObject r7, JSONObject r8) {
            File r0 = new File(r6, "summary.json");
            File r1 = new File(r6, "crash_time");
            String r9 = i.d(r0);
            String r2 = i.d(r1);
            JSONObject r3 = r8.optJSONObject("filters");
            if (r9 != null) goto L9;
        L5:
            if (r2 == null) goto L11;
            long r5 = Long.parseLong(r2) * 1000;     // Catch: Throwable -> L8
            r8.put("crash_time", r5);     // Catch: Throwable -> L8
            r8.put(DBHelper.COL_TIME, r5);     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        L9:
            JSONObject r4 = new JSONObject(r9);     // Catch: Throwable -> L8
            l.b(r7, r4.optJSONObject("header"));     // Catch: Throwable -> L8
            l.b(r3, r4.optJSONObject("filters"));     // Catch: Throwable -> L8
            r8.put("app_start_time", r7.opt("app_start_time"));     // Catch: Throwable -> L8
            goto L5
        }

        public static int a(JSONArray r1, int r2, String r3) {
        L3:
            if (r2 >= r1.length()) goto L10;
            String r0 = r1.optString(r2, null);
            if (r0 == null) goto L9;
            if (r0.startsWith(r3) == false) goto L9;
            return r2;
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            return -1;
        }

        public static String a(String r4) {
            StringBuilder r0 = new StringBuilder();
            if (r4.length() >= 16) goto L6;
            r0.append(r4);     // Catch: Throwable -> L11
        L12:
            goto L10
        L6:
            r0.append(r4.charAt(6));     // Catch: Throwable -> L11
            r0.append(r4.charAt(7));     // Catch: Throwable -> L11
            r0.append(r4.charAt(4));     // Catch: Throwable -> L11
            r0.append(r4.charAt(5));     // Catch: Throwable -> L11
            r0.append(r4.charAt(2));     // Catch: Throwable -> L11
            r0.append(r4.charAt(3));     // Catch: Throwable -> L11
            r0.append(r4.charAt(0));     // Catch: Throwable -> L11
            r0.append(r4.charAt(1));     // Catch: Throwable -> L11
            r0.append(r4.charAt(10));     // Catch: Throwable -> L11
            r0.append(r4.charAt(11));     // Catch: Throwable -> L11
            r0.append(r4.charAt(8));     // Catch: Throwable -> L11
            r0.append(r4.charAt(9));     // Catch: Throwable -> L11
            r0.append(r4.charAt(14));     // Catch: Throwable -> L11
            r0.append(r4.charAt(15));     // Catch: Throwable -> L11
            r0.append(r4.charAt(12));     // Catch: Throwable -> L11
            r0.append(r4.charAt(13));     // Catch: Throwable -> L11
            if (r4.length() < 32) goto L12;
            r0.append(r4, 16, 32);     // Catch: Throwable -> L11
            r0.append('0');     // Catch: Throwable -> L11
        L10:
            return r0.toString().toUpperCase();
        }

        public static String a(String r2, String r3) {
            if (r2 != null) goto L5;
            return "other";
        L5:
            if (r3 != null) goto L7;
        L8:
            r3 = "B";
        L9:
            r3.hashCode();
            if (r3.equals("GB") == false) goto L12;
            return "1GB+";
        L12:
            if (r3.equals("MB") == true) goto L33;
            return "0~1MB";
        L33:
            int r4 = Integer.parseInt(r2.substring(0, r2.indexOf(46)));     // Catch: Throwable -> L30
            if (r4 >= 200) goto L21;
            return "0~200MB";
        L21:
            if (r4 >= 500) goto L25;
            return "200~500MB";
        L25:
            if (r4 >= 800) goto L28;
            return "500~800MB";
        L28:
            return "800~1024MB(1G)";
        L30:
            return "other";
        L7:
            if (r3.length() != 0) goto L9;
            goto L8
        }

        private void a(f r7, File r8, C0172b r9) {
            JSONObject r0 = Header.a(this.f7698a, System.currentTimeMillis(), CrashType.NATIVE_CUSTOMIZE, (int) r9.f).b();     // Catch: Exception -> L7
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L7
            JSONArray r2 = new JSONArray();     // Catch: Exception -> L7
            JSONObject r10 = r7.a(this.f7698a);     // Catch: Exception -> L7
            r2.put(r10);     // Catch: Exception -> L7
            r1.put("data", r2);     // Catch: Exception -> L7
            r1.put("crash_lib_uuid", r9.h);     // Catch: Exception -> L7
            l.b(r1, r9.j);     // Catch: Exception -> L7
            r1.put("header", r0);     // Catch: Exception -> L7
            a(r8, r0, r10);     // Catch: Exception -> L7
            if (com.bytedance.crash.upload.b.a(o.a(com.bytedance.crash.config.f.h(), r0), r1.toString(), new File[]{r8}) == false) goto L10;
            r.a("ResourceMonitorUploader: upload success");     // Catch: Exception -> L7
            j.a(r8);     // Catch: Exception -> L7
            return;
        L10:
            return;
        }

        private void a(final File r10, Map<String, String> r11, final C0172b r12) {
            Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
            com.bytedance.crash.monitor.a r13 = this.f7698a;
            if (r13 != null) goto L5;
            return;
        L5:
            if (r13.c() != null) goto L8;
            return;
        L8:
            if (r12.f != 0) goto L10;
            r12.f = Process.myPid();
        L10:
            final f r14 = new f(r12.f7705a, r12.f7706b, r12.f7708d, r4, r12.f7707c, "1", "native_exception", (int) r12.f);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) goto L13;
            a(r14, r10, r12);
            return;
        L13:
            DefaultWorkThread.post(new AnonymousClass1(this, r14, r10, r12));
        }

        public void a(Map<String, String> r2, C0172b r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L8;
            if (r3 == null) goto L9;
            r1.putAll(r3.i);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.resource.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ResourceMonitorAdapter.java */
    public static class C0172b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f7705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f7707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f7708d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f7709e;
        public long f;
        public long g;
        public JSONArray h;
        public Map<String, String> i;
        public JSONObject j;

        C0172b() {
            this.f7705a = "";
            this.f7706b = null;
            this.f7707c = null;
            this.f7708d = null;
            this.f7709e = null;
            this.f = 0;
            this.g = 0;
            this.h = new JSONArray();
            this.i = new HashMap();
            this.j = new JSONObject();
        }
    }

    public void b() {
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }

    public b() {
        this.f = false;
        this.g = false;
    }

    public void a(c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (b(r2) == true) goto L7;
        return;
    L7:
        if (c() == false) goto L14;
        this.f7695e.c();
        if (r2.g() == 4) goto L11;
        DefaultWorkThread.post(new AnonymousClass1(this));
        a();
    L11:
        b();
        return;
    }

    private synchronized boolean b(c r10) {
        monitor-enter(this);
    L51:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (this.g == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.g = true;     // Catch: Throwable -> L51
        if (Build.VERSION.SDK_INT >= r10.b()) goto L12;
    L48:
        r.c(TAG, "Unsupported API!!!");     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L12:
        if (Build.VERSION.SDK_INT > r10.a()) goto L48;
        this.f7693c = com.bytedance.crash.i.e();     // Catch: Throwable -> L51
        File r2 = r10.h();     // Catch: Throwable -> L51
        this.f7691a = r2;     // Catch: Throwable -> L51
        if (r2 != null) goto L17;
    L45:
        r.c(TAG, "cannot create " + this.f7691a);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L17:
        if (r2.exists() == false) goto L19;
    L21:
        this.f7692b = this.f7691a.getAbsolutePath() + "/" + com.bytedance.crash.crash.b.b();     // Catch: Throwable -> L51
        com.bytedance.crash.resource.f.a r3 = new com.bytedance.crash.resource.f.a(this.f7691a.getAbsolutePath(), r10.c(), 604800);     // Catch: Throwable -> L51
        this.f7695e = r3;     // Catch: Throwable -> L51
        if (r3.b() == true) goto L26;
        monitor-exit(this);
        return false;
    L26:
        if (d() == true) goto L29;
        monitor-exit(this);
        return false;
    L29:
        d(r10);     // Catch: Throwable -> L51
        if (c(r10) == true) goto L54;
        r.b(TAG, "loadLibrary() failed!");     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L54:
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L43:
        monitor-exit(this);
        return false;
    L35:
        if (this.f7693c == null) goto L43;
        if (NativeResourceMonitor.a(Build.VERSION.SDK_INT, r10.g(), r10.f(), f(), this.f7692b, this.f7693c) != 0) goto L39;
        r1 = true;
    L39:
        monitor-exit(this);
        return r1;
    L19:
        if (this.f7691a.mkdir() == true) goto L21;
        goto L21
    }

    public void a() {
        com.bytedance.crash.monitor.a r1 = h.a();
        if (r1 != null) goto L5;
        return;
    L5:
        if (this.f7692b == null) goto L27;
        File r2 = new File(this.f7692b, "summary.json");
        JSONObject r9 = new JSONObject();
        JSONObject r3 = new JSONObject();
        JSONObject r4 = new JSONObject();
        if (r1.i() != 0) goto L11;
    L13:
        r3.put("channel", r1.f());     // Catch: Throwable -> L22
        r3.put(RomInfo.KEY_ROM_OS_API, com.bytedance.crash.general.c.c());     // Catch: Throwable -> L22
        r3.put(RomInfo.KEY_ROM_OS_VERSION, com.bytedance.crash.general.c.b());     // Catch: Throwable -> L22
        r3.put(AppInfo.KEY_NPTH_VERSION_NAME, g.f7298a);     // Catch: Throwable -> L22
        r3.put("sdk_version", 4020254);     // Catch: Throwable -> L22
        r3.put("app_start_time", com.bytedance.crash.i.f());     // Catch: Throwable -> L22
        if (NativeBridge.g() == false) goto L16;
        String r5 = "true";
    L17:
        r4.put("is_64_runtime", r5);     // Catch: Throwable -> L22
        r4.put("sdk_version", g.f7298a);     // Catch: Throwable -> L22
        r9.put("header", r3);     // Catch: Throwable -> L22
        r9.put("filters", r4);     // Catch: Throwable -> L22
        goto L19
    L16:
        r5 = "false";
        goto L17
    L11:
        if (TextUtils.isEmpty(r1.l()) == true) goto L13;
        r3.put("version_code", r1.i());     // Catch: Throwable -> L22
        r3.put("update_version_code", r1.j());     // Catch: Throwable -> L22
        r3.put("version_name", r1.l());     // Catch: Throwable -> L22
        r3.put(WsConstants.KEY_APP_VERSION, r1.l());     // Catch: Throwable -> L22
        r3.put("manifest_version_code", r1.k());     // Catch: Throwable -> L22
    L19:
        if (r9.length() <= 0) goto L26;
        i.c(r2, r9.toString());
        return;
    L26:
        return;
    }

    private static String f() {
        com.bytedance.crash.monitor.a r0 = h.a();
        if (r0 != null) goto L7;
        return SensitiveType.UNKNOWN;
    L7:
        return String.valueOf(r0.i());
    }

    private boolean c(c r4) {
        r.b(TAG, "loadLibrary...");
        if (this.f == true) goto L6;
        com.bytedance.librarian.a.a(r4.d(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        this.f = true;     // Catch: Throwable -> L7
    L6:
        return this.f;
    }

    private void d(c r4) {
        if (r4 != null) goto L12;
        return;
    L12:
        File r0 = new File(this.f7693c, r4.e());     // Catch: Throwable -> L9
        this.f7694d = r0;     // Catch: Throwable -> L9
        if (r0.exists() == true) goto L7;
        this.f7694d.createNewFile();     // Catch: Throwable -> L9
    L7:
        r.c(TAG, "write Config");     // Catch: Throwable -> L9
        j.a(this.f7694d, r4.toString(), false);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public void e() {
        File r0 = this.f7691a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f7692b == null) goto L26;
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.length < 15) goto L28;
        Arrays.sort(r1, new AnonymousClass2(this));     // Catch: Throwable -> L20
        int r2 = 0;
    L13:
        if (r2 >= (r1.length - 15)) goto L30;
        File r3 = r1[r2];     // Catch: Throwable -> L20
        if (this.f7692b.equals(r3.getAbsolutePath()) == true) goto L18;
        j.a(r3);     // Catch: Throwable -> L20
    L18:
        r2 = r2 + 1;
        goto L13
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }
}
