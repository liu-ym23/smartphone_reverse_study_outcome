package com.apm.lite;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.j.j;
import com.apm.lite.j.k;
import com.apm.lite.k.p;
import com.apm.lite.runtime.ConfigManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;
import r1.l;
import r1.m;

/* JADX INFO: loaded from: classes39.dex */
public class MonitorCrash {
    private static final String TAG = "MonitorCrash";
    private volatile boolean isAppLogInit;
    com.apm.lite.b mAppLog;
    Config mConfig;
    AttachUserData mCustomData;
    HashMap<String, String> mPageViewTagMap;
    HashMap<String, String> mTagMap;

    public static class Config {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f29882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f29883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f29884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f29885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f29886e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String[] f29887f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String[] f29888g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f29889h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.apm.lite.b f29890i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f29891j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f29892k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public IDynamicParams f29893l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Map<String, String> f29894m;

        public interface IDynamicParams {
            String getDid();

            String getUserId();
        }

        public static class SdkBuilder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Config f29895a;

            public SdkBuilder acceptWithActivity(boolean r100) {
                this.f29895a.f29891j = r100;
                return this;
            }

            public Config build() {
                return this.f29895a;
            }

            public SdkBuilder channel(String r100) {
                this.f29895a.f29884c = r100;
                return this;
            }

            public SdkBuilder debugMode(boolean r100) {
                Npth.getConfigManager().setDebugMode(r100);
                return this;
            }

            public SdkBuilder enableAnrMonitor(boolean r100) {
                Npth.getConfigManager().setAnrEnable(r100);
                return this;
            }

            public SdkBuilder enableJavaCrash(boolean r100) {
                Npth.getConfigManager().setJavaCrashEnable(r100);
                return this;
            }

            public SdkBuilder enableNativeCrash(boolean r100) {
                Npth.getConfigManager().setNativeCrashEnable(r100);
                return this;
            }

            public SdkBuilder enableSigQuit(boolean r100) {
                Npth.getConfigManager().setSigQuitEnable(r100);
                return this;
            }

            public SdkBuilder keyWords(String... r100) {
                this.f29895a.f29887f = r100;
                return this;
            }

            public SdkBuilder pageViewTags(Map<String, String> r100) {
                this.f29895a.f29894m = r100;
                return this;
            }

            public SdkBuilder soList(String... r100) {
                this.f29895a.f29888g = r100;
                return this;
            }

            public SdkBuilder token(String r100) {
                this.f29895a.f29883b = r100;
                return this;
            }

            public SdkBuilder url(String r100) {
                this.f29895a.f29892k = r100;
                return this;
            }

            public SdkBuilder versionCode(long r100) {
                this.f29895a.f29885d = r100;
                return this;
            }

            public SdkBuilder versionName(String r100) {
                this.f29895a.f29886e = r100;
                return this;
            }

            public SdkBuilder(String r100) {
                Config r101 = new Config();
                this.f29895a = r101;
                r101.f29882a = r100;
            }

            public SdkBuilder dynamicParams(IDynamicParams r100) {
                this.f29895a.f29893l = r100;
                return this;
            }
        }

        public Config() {
            this.f29885d = -1;
            this.f29891j = false;
            this.f29894m = null;
        }

        public static SdkBuilder sdk(String r100) {
            return new SdkBuilder(r100);
        }

        public String getDeviceId() {
            IDynamicParams r100 = this.f29893l;
            if (r100 != null) goto L6;
            return this.f29889h;
        L6:
            return r100.getDid();
        }

        public String getUID() {
            IDynamicParams r100 = this.f29893l;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100.getUserId();
        }

        public Config setChannel(String r100) {
            this.f29884c = r100;
            com.apm.lite.b r101 = this.f29890i;
            if (r101 == null) goto L5;
            r101.getClass();
        L5:
            p1.b.a();
            return this;
        }

        public Config setDeviceId(String r100) {
            return setDeviceId(r100, true);
        }

        public Config setDeviceId(String r100, boolean r101) {
            this.f29889h = r100;
            com.apm.lite.b r102 = this.f29890i;
            if (r102 == null) goto L5;
            r102.getClass();
        L5:
            if (r101 == false) goto L7;
            p1.b.a();
        L7:
            return this;
        }

        public Config setPackageName(String r100) {
            return setPackageName(new String[]{r100});
        }

        public Config setPackageName(String... r100) {
            this.f29887f = r100;
            p1.b.a();
            return this;
        }

        public Config setSoList(String[] r100) {
            this.f29888g = r100;
            p1.b.a();
            return this;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f29896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonitorCrash f29897b;

        public a(MonitorCrash r100, boolean r101, Context r102) {
            this.f29897b = r100;
            this.f29896a = r101;
        }

        public final void a() {
            if (MonitorCrash.access$000(this.f29897b) == false) goto L6;
            return;
        L6:
            if (j.f29983c == true) goto L8;
            j.b();
        L8:
            String r100 = this.f29897b.mConfig.f29882a;
            r1.e r101 = r1.e.f535556b.get(r100);
            if (r101 != null) goto L11;
        L14:
            boolean r102 = true;
        L15:
            if (r102 == true) goto L17;
            return;
        L17:
            MonitorCrash.access$002(this.f29897b, true);
            MonitorCrash r103 = this.f29897b;
            if (r103.mAppLog != null) goto L20;
            r103.mAppLog = new com.apm.lite.b();
        L20:
            HashMap r104 = null;
            String r105 = null;
            if (this.f29896a == true) goto L34;
            ConcurrentHashMap<String, MonitorCrash> r106 = d.f29907b;
            Iterator<d> r107 = k1.b.f501332a.iterator();
        L24:
            if (r107.hasNext() == false) goto L33;
            d r108 = r107.next();
            if (r108 == null) goto L24;
            if (r108.f29908a != null) goto L30;
            boolean r109 = true;
        L31:
            if (r109 == false) goto L24;
            r105 = r108.e();
            goto L33
        L30:
            r109 = false;
        L33:
            HashMap r110 = new HashMap();
            r110.put("host_app_id", r105);
            r110.put("sdk_version", this.f29897b.mConfig.f29886e);
            r104 = r110;
        L34:
            MonitorCrash r111 = this.f29897b;
            com.apm.lite.b r112 = r111.mAppLog;
            Config r113 = r111.mConfig;
            if (r113 != null) goto L37;
            r112.getClass();
        L38:
            MonitorCrash r114 = this.f29897b;
            Config r115 = r114.mConfig;
            r115.f29890i = r114.mAppLog;
            return;
        L37:
            r112.f29903a = r113;
            r112.f29904b = r104;
            goto L38
        L11:
            if (r101.a() == true) goto L14;
            r102 = false;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IUploadCallback f29898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MonitorCrash f29899b;

        public b(MonitorCrash r100, IUploadCallback r101) {
            this.f29899b = r100;
            this.f29898a = r101;
        }

        public final void a() {
            MonitorCrash r100 = this.f29899b;
            com.apm.lite.b r101 = r100.mAppLog;
            boolean r102 = false;
            if (r101 == null) goto L23;
            HashMap<String, String> r103 = r100.mPageViewTagMap;
            IUploadCallback r104 = this.f29898a;
            Config r105 = r101.f29903a;
            if (r105 == null) goto L7;
        L29:
            JSONObject r106 = r101.c(r103);     // Catch: Throwable -> L27
            ByteArrayOutputStream r107 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L27
            GZIPOutputStream r108 = new GZIPOutputStream(r107);     // Catch: Throwable -> L15
            r108.write(r106.toString().getBytes("UTF-8"));     // Catch: Throwable -> L28
        L16:
            com.apm.lite.k.j.a(r108);     // Catch: Throwable -> L27
            com.apm.lite.k.j.a(r107);     // Catch: Throwable -> L27
            byte[] r109 = r107.toByteArray();     // Catch: Throwable -> L27
            String r110 = e.f29913e.getPageViewUrl() + "?version_code=" + r101.f29903a.f29885d + "&device_platform=android&aid=" + r101.f29903a.f29882a + "&iid=iid";     // Catch: Throwable -> L27
            Config r111 = r101.f29903a;     // Catch: Throwable -> L27
            k r112 = com.apm.lite.b.b(r110, r109, r111.f29882a, r111.f29883b);     // Catch: Throwable -> L27
            if (r104 != null) goto L19;
            return;
        L19:
            if (r112.f29985a == 207) goto L21;
            r102 = true;
        L21:
            r104.afterUpload(r102);     // Catch: Throwable -> L27
            return;
        L15:
            r108 = null;
        L40:
            return;
        L7:
            if (TextUtils.isEmpty(r105.getDeviceId()) == true) goto L29;
            if (r104 == null) goto L35;
            r104.afterUpload(false);
            return;
        L35:
            return;
        L23:
            IUploadCallback r113 = this.f29898a;
            if (r113 == null) goto L38;
            r113.afterUpload(false);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private MonitorCrash(Config r100) {
        this.mTagMap = new HashMap();
        this.mPageViewTagMap = new HashMap();
        this.isAppLogInit = false;
        this.mConfig = r100;
        r100.getClass();
        this.mCustomData = null;
    }

    public static /* synthetic */ boolean access$000(MonitorCrash r100) {
        return r100.isAppLogInit;
    }

    public static /* synthetic */ boolean access$002(MonitorCrash r100, boolean r101) {
        r100.isAppLogInit = r101;
        return r101;
    }

    private void initAppLog(Context r100, boolean r101) {
        initAppLogAsync(r100, r101);
    }

    private void initAppLogAsync(Context r100, boolean r101) {
        m.a().b(new a(this, r101, r100), 5);
    }

    public static void reInitAppLog(String r100) {
    }

    public MonitorCrash addPageViewTags(String r100, String r101) {
        this.mPageViewTagMap.put(r100, r101);
        this.mTagMap.put(r100, r101);
        return this;
    }

    public MonitorCrash addTags(String r100, String r101) {
        this.mTagMap.put(r100, r101);
        return this;
    }

    public Config config() {
        return this.mConfig;
    }

    public void reportPageView(IUploadCallback r100) {
        m.a().b(new b(this, r100), 10);
    }

    private MonitorCrash setReportUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        int r101 = r100.indexOf("://");
        if (r101 >= 0) goto L8;
        r100 = "https://".concat(r100);
        int r102 = 8;
    L9:
        int r103 = r100.indexOf(HTTP.URL_DEFAULT, r102);
        if (r103 < 0) goto L12;
        r100 = r100.substring(0, r103);
    L12:
        p.a("set url " + r100);
        ConfigManager r104 = e.f29913e;
        r104.setLaunchCrashUrl(r100 + ConfigManager.EXCEPTION_URL_SUFFIX);
        r104.setJavaCrashUploadUrl(r100 + ConfigManager.JAVA_URL_SUFFIX);
        r104.setNativeCrashUrl(r100 + ConfigManager.NATIVE_URL_SUFFIX);
        r104.setConfigUrl(r100 + ConfigManager.CONFIG_URL_SUFFIX);
        r104.setAlogUploadUrl(r100 + ConfigManager.ALOG_URL_SUFFIX);
        r104.setFileUploadUrl(r100 + ConfigManager.FILE_UPLOAD_URL_SUFFIX);
        r104.setPageViewUrl(r100 + ConfigManager.PAGEVIEW_URL_SUFFIX);
        return this;
    L8:
        r102 = r101 + 3;
        goto L9
    }

    public void registerOOMCallback(IOOMCallback r100) {
        ((CopyOnWriteArrayList) l.f535571e.f535552e).add(r100);
    }

    public static synchronized MonitorCrash initSDK(Context r100, Config r101) {
        monitor-enter(MonitorCrash.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r101.f29883b) == true) goto L7;
    L7:
        String r102 = r101.f29882a;     // Catch: Throwable -> L22
        MonitorCrash r103 = d.f29907b.get(r102);     // Catch: Throwable -> L22
        if (r103 == null) goto L11;
        monitor-exit(MonitorCrash.class);
        return r103;
    L11:
        MonitorCrash r104 = new MonitorCrash(r101);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r101.f29892k) == true) goto L14;
        r104.setReportUrl(r101.f29892k);     // Catch: Throwable -> L22
    L14:
        Map<String, String> r105 = r101.f29894m;     // Catch: Throwable -> L22
        if (r105 == null) goto L17;
        r104.mPageViewTagMap.putAll(r105);     // Catch: Throwable -> L22
        r104.mTagMap.putAll(r104.mPageViewTagMap);     // Catch: Throwable -> L22
    L17:
        l.b(r100, Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isJavaCrashEnable(), Npth.getConfigManager().isNativeCrashEnable(), Npth.getConfigManager().isAnrEnable());     // Catch: Throwable -> L22
        r104.initAppLog(r100, false);     // Catch: Throwable -> L22
        new d(r104);     // Catch: Throwable -> L22
        if (r104.mConfig == null) goto L20;
        d.f29907b.put(r104.mConfig.f29882a, r104);     // Catch: Throwable -> L22
    L20:
        monitor-exit(MonitorCrash.class);
        return r104;
    }

    public void registerCrashCallback(ICrashCallback r100, CrashType r101) {
        r1.c r102 = l.f535571e;
        r102.getClass();
        int r103 = r1.c.a.f535553a[r101.ordinal()];
        if (r103 != 1) goto L5;
        ((CopyOnWriteArrayList) r102.f535548a).add(r100);
        ((CopyOnWriteArrayList) r102.f535549b).add(r100);
        ((CopyOnWriteArrayList) r102.f535550c).add(r100);
    L17:
        List<ICrashCallback> r104 = r102.f535551d;
    L18:
        ((CopyOnWriteArrayList) r104).add(r100);
        return;
    L5:
        if (r103 == 2) goto L17;
        if (r103 != 3) goto L9;
        r104 = r102.f535549b;
        goto L18
    L9:
        if (r103 != 4) goto L11;
        r104 = r102.f535548a;
        goto L18
    L11:
        if (r103 != 5) goto L20;
        r104 = r102.f535550c;
        goto L18
    }

    public void unregisterCrashCallback(ICrashCallback r100, CrashType r101) {
        r1.c r102 = l.f535571e;
        r102.getClass();
        int r103 = r1.c.a.f535553a[r101.ordinal()];
        if (r103 != 1) goto L5;
        ((CopyOnWriteArrayList) r102.f535548a).remove(r100);
        ((CopyOnWriteArrayList) r102.f535549b).remove(r100);
        ((CopyOnWriteArrayList) r102.f535550c).remove(r100);
    L17:
        List<ICrashCallback> r104 = r102.f535551d;
    L18:
        ((CopyOnWriteArrayList) r104).remove(r100);
        return;
    L5:
        if (r103 == 2) goto L17;
        if (r103 != 3) goto L9;
        r104 = r102.f535549b;
        goto L18
    L9:
        if (r103 != 4) goto L11;
        r104 = r102.f535548a;
        goto L18
    L11:
        if (r103 != 5) goto L20;
        r104 = r102.f535550c;
        goto L18
    }

    public void unregisterOOMCallback(IOOMCallback r100, CrashType r101) {
        ((CopyOnWriteArrayList) l.f535571e.f535552e).remove(r100);
    }
}
