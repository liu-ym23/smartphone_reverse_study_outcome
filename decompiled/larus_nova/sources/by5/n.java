package by5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.apm.api.IHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f21458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, JSONObject> f21459b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f21460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f21461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f21462e;

    static {
        f21459b = new ConcurrentHashMap();
        f21461d = false;
    }

    public static Map<String, String> b() {
        if (TextUtils.isEmpty((CharSequence) ((HashMap) f21460c).get("device_id")) == false) goto L5;
        Iterator<Long> r100 = f21459b.keySet().iterator();
    L8:
        if (r100.hasNext() == false) goto L16;
        Long r101 = r100.next();
        JSONObject r102 = f21459b.get(r101);
        if (r102 == null) goto L8;
        CastLongProtector.parseLong(r102.optString("device_id"));     // Catch: Throwable -> L14
        Map<String, String> r103 = f21460c;     // Catch: Throwable -> L14
        HashMap r104 = (HashMap) r103;     // Catch: Throwable -> L14
        r104.put("device_id", r102.optString("device_id"));     // Catch: Throwable -> L14
    L16:
        return f21460c;
    L5:
        return f21460c;
    }

    public static synchronized JSONObject c() {
        monitor-enter(n.class);
        ConcurrentHashMap<Long, JSONObject> r100 = f21459b;     // Catch: Throwable -> L12
        Iterator<Long> r101 = r100.keySet().iterator();     // Catch: Throwable -> L12
        if (r101.hasNext() == false) goto L9;
        JSONObject r102 = r100.get(r101.next());     // Catch: Throwable -> L12
        monitor-exit(n.class);
        return r102;
    L9:
        monitor-exit(n.class);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean d() {
        monitor-enter(n.class);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (f21461d == false) goto L43;
        monitor-exit(n.class);
        return true;
    L43:
        PolarisFileWrapper r100 = new PolarisFileWrapper(a.f(), "file.lock");     // Catch: Throwable -> L25
        if (r100.exists() == true) goto L12;
        r100.createNewFile();     // Catch: Throwable -> L25
    L12:
        FileChannel r101 = new RandomAccessFile(r100, "rw").getChannel();     // Catch: Throwable -> L25
        if (r101 != null) goto L39;
    L17:
        boolean r102 = f21461d;     // Catch: Throwable -> L24
        if (r101 != null) goto L20;
    L22:
        monitor-exit(n.class);
        return r102;
    L20:
        if (f21461d == true) goto L22;
        r101.close();     // Catch: IOException -> L36 Throwable -> L33
    L26:
        if (r101 != null) goto L28;
    L30:
        monitor-exit(n.class);
        return false;
    L28:
        if (f21461d == true) goto L30;
        r101.close();     // Catch: IOException -> L37 Throwable -> L33
        goto L30
    L39:
        FileLock r103 = r101.tryLock();     // Catch: Throwable -> L24
        if (r103 == null) goto L17;
        f21461d = r103.isValid();     // Catch: Throwable -> L24
    L25:
        r101 = null;
        goto L26
    }

    public static Context getContext() {
        return f21458a;
    }

    public static synchronized void e(String r100, JSONObject r101) {
        monitor-enter(n.class);
        f21459b.put(Long.valueOf(CastLongProtector.parseLong(r100)), r101);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(n.class);
        return;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        fy5.c.c("setHeader", e);     // Catch: Throwable -> L6
        goto L10
    }

    public static ff7.b a(String r100, Map<String, String> r101, byte[] r102) throws Exception {
        IHttpService r103 = (IHttpService) ServiceManager.getService(IHttpService.class);
        if (r103 == null) goto L60;
        return r103.doPost(r100, r102, r101);
    L60:
        HttpURLConnection r104 = (HttpURLConnection) ey5.a.a(new URL(r100));     // Catch: Throwable -> L49
        r104.setConnectTimeout(5000);     // Catch: Throwable -> L48
        r104.setReadTimeout(5000);     // Catch: Throwable -> L48
        HashMap r105 = (HashMap) r101;     // Catch: Throwable -> L48
        if (r105.isEmpty() == true) goto L18;
        Iterator r106 = r105.entrySet().iterator();     // Catch: Throwable -> L48
    L13:
        if (r106.hasNext() == false) goto L18;
        Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Throwable -> L48
        if (r107 == null) goto L13;
        r104.setRequestProperty((String) r107.getKey(), (String) r107.getValue());     // Catch: Throwable -> L48
    L18:
        r104.setDoOutput(TextUtils.equals("POST", "POST"));     // Catch: Throwable -> L48
        r104.setRequestMethod("POST");     // Catch: Throwable -> L48
        if (r102 != null) goto L21;
    L23:
        int r108 = r104.getResponseCode();     // Catch: Throwable -> L48
        if (r108 != 200) goto L45;
        InputStream r109 = r104.getInputStream();     // Catch: Throwable -> L48
        String r110 = r104.getContentEncoding();     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r110) == false) goto L29;
    L31:
        byte[] r111 = com.bytedance.framwork.core.sdkmonitor.e.e(r109);     // Catch: Throwable -> L44
    L32:
        Map<String, List<String>> r112 = r104.getHeaderFields();     // Catch: Throwable -> L44
        HashMap r113 = new HashMap();     // Catch: Throwable -> L44
        Iterator<Map.Entry<String, List<String>>> r114 = r112.entrySet().iterator();     // Catch: Throwable -> L44
    L34:
        if (r114.hasNext() == false) goto L40;
        Map.Entry<String, List<String>> r115 = r114.next();     // Catch: Throwable -> L44
        String r116 = r115.getKey();     // Catch: Throwable -> L44
        List<String> r117 = r115.getValue();     // Catch: Throwable -> L44
        if (r117 == null) goto L34;
        if (r117.size() <= 0) goto L34;
        r113.put(r116, r117.get(0));     // Catch: Throwable -> L44
        goto L34
    L40:
        ff7.b r118 = new ff7.b(r108, r113, r111);     // Catch: Throwable -> L44
        xu3.c.a(r109);
        r104.disconnect();     // Catch: Exception -> L54
    L81:
        return r118;
    L29:
        if (r110.equalsIgnoreCase(DownloadHelper.GZIP) == false) goto L31;
        GZIPInputStream r119 = new GZIPInputStream(r109);     // Catch: Throwable -> L44
        r111 = com.bytedance.framwork.core.sdkmonitor.e.e(r119);     // Catch: Throwable -> L44
        r119.close();     // Catch: Throwable -> L44
    L50:
        xu3.c.a(r109);
        if (r104 == null) goto L83;
        r104.disconnect();     // Catch: Exception -> L55
        return null;
    L84:
        return null;
    L83:
        return null;
    L45:
        ff7.b r120 = new ff7.b(r108, null);     // Catch: Throwable -> L48
        r104.disconnect();     // Catch: Exception -> L56
    L82:
        return r120;
    L21:
        if (r102.length <= 0) goto L23;
        DataOutputStream r121 = new DataOutputStream(r104.getOutputStream());     // Catch: Throwable -> L48
        r121.write(r102);     // Catch: Throwable -> L48
        r121.flush();     // Catch: Throwable -> L48
        r121.close();     // Catch: Throwable -> L48
    L48:
        r109 = null;
    L49:
        r104 = null;
        r109 = null;
        goto L50
    }
}
