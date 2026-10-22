package com.ss.bduploader;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: BDUploadUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f37556a = "SpeedTestcontextDir";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f37557b = "DiskResumeConfigDir";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f37558c = "RetryStatesInfoDir";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f37559d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static com.ss.bduploader.a.b f37560e = null;
    public static com.ss.bduploader.c.b f = null;
    public static Boolean g = null;
    public static Boolean h = null;
    private static volatile i i = null;
    private static volatile boolean j = false;
    private static volatile boolean k = false;
    private static final ReentrantLock l = null;
    private static volatile String m;
    private static volatile long n;

    public static /* synthetic */ void lambda$kbLnpiz1hKV3LU_xBtYRv94LazM() {
        d();
    }

    static {
        l = new ReentrantLock();
        f37560e = null;
        f = null;
        g = false;
        h = false;
    }

    private static boolean c() {
        boolean r1 = true;
        if (i != null) goto L6;
        return true;
    L6:
        if (i == null) goto L27;
        if (j == true) goto L27;
        boolean r0 = com.bytedance.boringssl.so.a.a();
        boolean r2 = i.a("ttopenssl");
        if (r0 == true) goto L14;
        if (r2 == true) goto L14;
        boolean r3 = false;
    L15:
        i.a("vcn");
        i.a("vcnverify");
        boolean r4 = i.a("xquic");
        boolean r5 = i.a("xquicclient");
        boolean r6 = i.a("bdvideouploader");
        if (r4 == false) goto L19;
        if (r5 == false) goto L19;
        boolean r7 = true;
    L20:
        k = r7;
        if (r3 == false) goto L24;
        if (r6 == false) goto L24;
    L25:
        j = r1;
    L24:
        r1 = false;
    L19:
        r7 = false;
    L14:
        r3 = true;
    L27:
        return j;
    }

    public static synchronized boolean a(StringBuffer r4) {
        monitor-enter(t.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (c() == true) goto L9;
        a("ttmn", String.format("proxy library load fail", new Object[0]));     // Catch: Throwable -> L21
        monitor-exit(t.class);
        return false;
    L9:
        b("ttmn", "use defaullt loadLibrary()");     // Catch: Throwable -> L21
        if (i == null) goto L12;
        boolean r1 = true;
    L14:
        if (a(r1, r4) == 1) goto L18;
        a("ttmn", String.format("library has not been loaded", new Object[0]));     // Catch: Throwable -> L21
        monitor-exit(t.class);
        return false;
    L18:
        b("ttmn", "init()");     // Catch: Throwable -> L21
        monitor-exit(t.class);
        return true;
    L12:
        r1 = false;
        goto L14
    }

    private static int a(boolean r5, StringBuffer r6) {
        if (j == false) goto L6;
        b("ttmn", "had load success");
        return 1;
    L6:
        j = r5;
        b("ttmn", "mIsLibraryLoaded:" + j);
        if (j == true) goto L34;
        if (com.bytedance.boringssl.so.a.a() == true) goto L12;
        a("ttmn", "load boringssl fail!");
    L12:
        if (com.ss.mediakit.vcnlib.a.a() == true) goto L15;
        a("ttmn", "Can't load vcn");
    L15:
        if (com.ss.mediakit.vcnlib.a.b() == true) goto L17;
        a("ttmn", "Can't load vcn verify");
    L17:
        boolean r7 = false;
        System.loadLibrary("xquic");     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L22
        System.loadLibrary("xquicclient");     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L22
        r7 = true;
    L24:
        k = r7;
        if (k == true) goto L40;
        a("ttmn", "Can't load xquic client");
    L40:
        System.loadLibrary("bdvideouploader");     // Catch: Throwable -> L29 UnsatisfiedLinkError -> L31
        j = true;     // Catch: Throwable -> L29 UnsatisfiedLinkError -> L31
    L31:
        e = move-exception;
        a("ttmn", "Can't load bdvideoUploader library: " + e.toString());
        r6.append(e.toString());
    L29:
        th = move-exception;
        a("ttmn", "other exception when loading bdvideoUploader library: " + th.toString());
        r6.append(th.toString());
        goto L34
    L22:
        e = move-exception;
        a("ttmn", "Can't load xquic library: " + e);
    L20:
        th = move-exception;
        a("ttmn", "other exception when loading xquic library: " + th);
    L34:
        if (j == true) goto L37;
        return -1;
    L37:
        return 1;
    }

    public static synchronized boolean a() {
        monitor-enter(t.class);
        boolean r1 = k;     // Catch: Throwable -> L7
        monitor-exit(t.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static String a(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L15;
        return null;
    L15:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L14
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r3.hasNext() == false) goto L12;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        Object r5 = r8.get(r4);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L14
        goto L7
    L12:
        return r2.toString();
    L14:
        return null;
    }

    public static JSONObject b(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L17;
        return null;
    L17:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L14
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14
        Object r5 = r8.get(r4);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L14
        goto L7
    L13:
        return r2;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static synchronized String b() {
        monitor-enter(t.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((SystemClock.elapsedRealtime() - n) < 300000) goto L7;
        com.ss.bduploader.net.f.a($$Lambda$t$kbLnpiz1hKV3LU_xBtYRv94LazM.INSTANCE);     // Catch: Throwable -> L10
    L7:
        String r1 = m;     // Catch: Throwable -> L10
        monitor-exit(t.class);
        return r1;
    }

    private static /* synthetic */ void d() {
        InetAddress r0 = InetAddress.getByName("whoami.akamai.net");     // Catch: UnknownHostException -> L6
        if (r0 == null) goto L9;
        m = r0.getHostAddress();     // Catch: UnknownHostException -> L6
        n = SystemClock.elapsedRealtime();     // Catch: UnknownHostException -> L6
        return;
    L9:
        return;
    }

    public static Map<String, String> a(JSONObject r4) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = String.valueOf(r1.next());
        r0.put(r2, r4.optString(r2));
        goto L4
    L6:
        return r0;
    }

    public static int a(String r4) {
        File r0 = new File(r4);
        if (r0.exists() == false) goto L7;
        c("ttmn", r4 + " has already exists");
        return 1;
    L7:
        if (r4.endsWith(File.separator) == true) goto L10;
        r4 = r4 + File.separator;
    L10:
        if (r0.mkdirs() == false) goto L13;
        b("ttmn", r4 + "create success");
        return 1;
    L13:
        a("ttmn", r4 + " failed");
        return -1;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
