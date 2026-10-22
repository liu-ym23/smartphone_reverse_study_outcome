package com.baidu.mapsdkplatform.comapi.a.a;

import android.content.Context;
import android.os.Build;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f31971a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f31972b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f31973c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f31974d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f31975a;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_a_a_b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapsdkplatform_comapi_a_a_b$a__run$___twin___() {
            if (f.b().a() != null) goto L5;
            return;
        L5:
            PolarisFileWrapper r100 = new PolarisFileWrapper(b.a());
            if (r100.exists() == true) goto L8;
            return;
        L8:
            File[] r101 = r100.listFiles();
            if (r101 != null) goto L11;
            return;
        L11:
            if (r101.length == 0) goto L56;
            Arrays.sort(r101, new c());     // Catch: Exception -> L15
        L16:
            int r102 = r101.length;
            if (r102 <= 10) goto L19;
            r102 = 10;
        L19:
            int r103 = 0;
        L20:
            if (r103 >= r102) goto L40;
            File r104 = r101[r103];
            if (r104.isDirectory() == true) goto L38;
            if (r104.exists() == false) goto L38;
            if (r104.isFile() == false) goto L38;
            if (r104.getName().contains(b.b()) == false) goto L38;
            if (r104.getName().endsWith(Global.SUFFIX_TXT_FILE) == false) goto L34;
            b.a(this.f31975a, r104);
            goto L38
        L34:
            if (r104.getName().endsWith(".zip") == false) goto L38;
            if (r104.exists() == false) goto L38;
            b.a(this.f31975a, r104);
        L38:
            r103 = r103 + 1;
            goto L20
        L40:
            if (r101.length <= 10) goto L55;
            b.a(this.f31975a, r101);
            return;
        L55:
            return;
        }

        public a(b r100) {
            this.f31975a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_a_a_b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mapsdkplatform_comapi_a_a_b$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.a.a.b$b, reason: collision with other inner class name */
    public static final class C0640b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f31976a = null;

        static {
            f31976a = new b();
        }

        public static /* synthetic */ b a() {
            return f31976a;
        }
    }

    private void d() {
        Context r100 = this.f31974d;
        if (r100 != null) goto L5;
        return;
    L5:
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L8;
        return;
    L8:
        String r102 = r101.getPath();
        if (r102.isEmpty() == false) goto L11;
        return;
    L11:
        String r103 = r102 + File.separator + "crash";
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);
        if (r104.exists() == false) goto L15;
        f31971a = r103;
        return;
    L15:
        if (r104.mkdir() == false) goto L17;
        f31971a = r103;
        return;
    L17:
        f31971a = r102;
    }

    private HttpURLConnection e() {
        HttpURLConnection r100 = (HttpURLConnection) INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_a_a_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL("https://api.map.baidu.com/lbs_sdkcc/report"));     // Catch: Exception -> L4
        r100.setDoOutput(true);     // Catch: Exception -> L4
        r100.setUseCaches(false);     // Catch: Exception -> L4
        r100.setRequestMethod("POST");     // Catch: Exception -> L4
        r100.setRequestProperty("Connection", "keep-alive");     // Catch: Exception -> L4
        r100.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");     // Catch: Exception -> L4
        r100.setRequestProperty("Cache-Control", HTTP.NO_CACHE);     // Catch: Exception -> L4
        r100.setRequestProperty("Content-Encoding", DownloadHelper.GZIP);     // Catch: Exception -> L4
        r100.setConnectTimeout(10000);     // Catch: Exception -> L4
        return r100;
    L4:
        return null;
    }

    private void f() {
        String r100 = f31971a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L14;
        String r101 = f31972b;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.isEmpty() == true) goto L16;
        String r102 = f31971a + File.separator + f31972b;
        com.baidu.mapsdkplatform.comapi.a.a.a.a().a(r102);
        JNIHandler.registerNativeHandler(r102);
        return;
    L16:
        return;
    }

    private void g() {
        if (NetworkUtil.isNetworkAvailable(this.f31974d) == true) goto L5;
        return;
    L5:
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this), "/comapi/a/a/b"));
    }

    public static b c() {
        return C0640b.a();
    }

    public b() {
    }

    public static /* synthetic */ String a() {
        return f31971a;
    }

    public static /* synthetic */ String b() {
        return f31972b;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_baidu_mapsdkplatform_comapi_a_a_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private StringBuilder a(File r100) {
        String[] r101 = r100.getName().substring(0, r100.getName().length() - 4).split("_");
        StringBuilder r102 = new StringBuilder();
        r102.append("--bd_map_sdk_cc\r\nContent-Disposition: form-data; name=\"phoneinfo\"\r\n\r\n");
        r102.append(URLDecoder.decode(SyncSysInfo.getPhoneInfo() + "&abi=" + f31973c));
        r102.append("\r\n--bd_map_sdk_cc\r\n");
        String r103 = r101[0];
        if (r103 != null) goto L5;
    L7:
        String r104 = r101[1];
        if (r104 != null) goto L10;
    L12:
        String r105 = r101[2];
        if (r105 != null) goto L15;
    L17:
        r102.append("Content-Disposition: form-data; name=\"os\"\r\n\r\nandroid\r\n--bd_map_sdk_cc\r\n");
        return r102;
    L15:
        if (r105.isEmpty() == true) goto L17;
        r102.append("Content-Disposition: form-data; name=\"timestamp\"\r\n\r\n");
        r102.append(r101[2]);
        r102.append("\r\n--bd_map_sdk_cc\r\n");
        goto L17
    L10:
        if (r104.isEmpty() == true) goto L12;
        r102.append("Content-Disposition: form-data; name=\"version\"\r\n\r\n");
        r102.append(r101[1]);
        r102.append("\r\n--bd_map_sdk_cc\r\n");
        goto L12
    L5:
        if (r103.isEmpty() == true) goto L7;
        r102.append("Content-Disposition: form-data; name=\"packname\"\r\n\r\n");
        r102.append(r101[0]);
        r102.append("\r\n--bd_map_sdk_cc\r\n");
        goto L7
    }

    private synchronized boolean b(File r110) {
        monitor-enter(this);
        BufferedReader r100 = null;
        BufferedReader r101 = null;
        r100 = null;
        InputStream r102 = null;
        r101 = null;
        r100 = null;
        r101 = null;
        HttpURLConnection r103 = e();     // Catch: Throwable -> L59 Exception -> L74
        if (r103 != null) goto L127;
        if (r103 != null) goto L114;
    L11:
        monitor-exit(this);
        return false;
    L114:
        r103.disconnect();     // Catch: Throwable -> L9 Exception -> L92
        goto L11
    L127:
        r103.connect();     // Catch: Throwable -> L56 Exception -> L58
        OutputStream r104 = r103.getOutputStream();     // Catch: Throwable -> L56 Exception -> L58
        r104.write(a(a(r110).toString().getBytes()));     // Catch: Throwable -> L53 Exception -> L55
        r104.write(a("--bd_map_sdk_cc\r\nContent-Disposition: form-data; name=\"file\"; filename=\"c.txt\"\r\n\r\n".getBytes()));     // Catch: Throwable -> L53 Exception -> L55
        ByteArrayOutputStream r105 = new ByteArrayOutputStream((int) r110.length());     // Catch: Throwable -> L53 Exception -> L55
        DataInputStream r106 = new DataInputStream(new PolarisFileInputStreamWrapper(r110));     // Catch: Throwable -> L53 Exception -> L55
        byte[] r107 = new byte[1024];     // Catch: Throwable -> L53 Exception -> L55
    L15:
        int r108 = r106.read(r107);     // Catch: Throwable -> L53 Exception -> L55
        if (r108 == (-1)) goto L19;
        r105.write(r107, 0, r108);     // Catch: Throwable -> L53 Exception -> L55
        goto L15
    L19:
        r104.write(a(r105.toByteArray()));     // Catch: Throwable -> L53 Exception -> L55
        r106.close();     // Catch: Throwable -> L53 Exception -> L55
        r105.close();     // Catch: Throwable -> L53 Exception -> L55
        r104.write(a("\r\n--bd_map_sdk_cc--\r\n".getBytes()));     // Catch: Throwable -> L53 Exception -> L55
        r104.flush();     // Catch: Throwable -> L53 Exception -> L55
        if (r103.getResponseCode() != 200) goto L42;
        InputStream r109 = r103.getInputStream();     // Catch: Throwable -> L53 Exception -> L55
        BufferedReader r111 = new BufferedReader(new InputStreamReader(r109));     // Catch: Throwable -> L39 Exception -> L41
        StringBuffer r112 = new StringBuffer();     // Catch: Throwable -> L36 Exception -> L38
    L24:
        int r113 = r111.read();     // Catch: Throwable -> L36 Exception -> L38
        if (r113 == (-1)) goto L27;
        r112.append((char) r113);     // Catch: Throwable -> L36 Exception -> L38
        goto L24
    L27:
        JSONObject r114 = new JSONObject(r112.toString());     // Catch: Exception -> L93 Throwable -> L36
        if (r114.has("status") == false) goto L35;
        if (r114.getInt("status") != 0) goto L35;
        if (r110.exists() == false) goto L35;
        r110.delete();     // Catch: Exception -> L93 Throwable -> L36
    L35:
        r102 = r109;
    L117:
        r104.close();     // Catch: Throwable -> L9 Exception -> L45
    L46:
        if (r102 == null) goto L102;
        if (r111 == null) goto L102;
        r102.close();     // Catch: Throwable -> L9 Exception -> L94
        r111.close();     // Catch: Throwable -> L9 Exception -> L94
    L102:
        r103.disconnect();     // Catch: Throwable -> L9 Exception -> L95
    L50:
        monitor-exit(this);
        return true;
    L38:
        r101 = r111;
    L36:
        th = th;
        r100 = r111;
    L62:
        if (r104 != null) goto L119;
    L66:
        if (r109 == null) goto L71;
        if (r100 == null) goto L71;
        r109.close();     // Catch: Throwable -> L9 Exception -> L70
        r100.close();     // Catch: Throwable -> L9 Exception -> L70
    L71:
        if (r103 == null) goto L132;
        r103.disconnect();     // Catch: Throwable -> L9 Exception -> L96
        throw th;     // Catch: Throwable -> L9
    L133:
        throw th;     // Catch: Throwable -> L9
    L132:
        throw th;     // Catch: Throwable -> L9
    L119:
        r104.close();     // Catch: Throwable -> L9 Exception -> L65
        goto L66
    L39:
        th = th;
    L76:
        if (r104 != null) goto L121;
    L80:
        if (r109 == null) goto L85;
        if (r101 == null) goto L85;
        r109.close();     // Catch: Throwable -> L9 Exception -> L84
        r101.close();     // Catch: Throwable -> L9 Exception -> L84
    L85:
        if (r103 != null) goto L106;
    L90:
        monitor-exit(this);
        return false;
    L106:
        r103.disconnect();     // Catch: Throwable -> L9 Exception -> L97
        goto L90
    L121:
        r104.close();     // Catch: Throwable -> L9 Exception -> L79
        goto L80
    L42:
        r111 = null;
    L55:
        r109 = null;
    L53:
        th = th;
        r109 = null;
        goto L62
    L58:
        r104 = null;
    L75:
        r109 = r104;
    L56:
        th = th;
        r104 = null;
    L61:
        r109 = r104;
        goto L62
    L9:
        th = move-exception;
        throw th;
    L74:
        r103 = null;
        r104 = null;
    L59:
        th = th;
        r103 = null;
        r104 = null;
        goto L61
    }

    public void a(Context r100) {
        String[] r101 = Build.SUPPORTED_ABIS;
        if (r101.length <= 0) goto L5;
        f31973c = r101[0];
    L5:
        this.f31974d = r100;
        String r102 = g.g();
        if (r102.isEmpty() == false) goto L9;
        return;
    L9:
        if (r102.contains("_") == false) goto L11;
        r102 = r102.replaceAll("_", "");
    L11:
        f31972b = r102 + "_" + g.o() + "_";
        d();
        f();
        g();
    }

    private byte[] a(byte[] r100) throws Exception {
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(r100.length);
        a(r101, r102);
        byte[] r103 = r102.toByteArray();
        r102.flush();
        r102.close();
        r101.close();
        return r103;
    }

    private void a(File[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= (r101 - 10)) goto L11;
        int r103 = r102 + 10;
        File r104 = r100[r103];
        if (r104 == null) goto L10;
        if (r104.exists() == false) goto L10;
        r100[r103].delete();
    L10:
        r102 = r102 + 1;
        goto L4
    }

    private void a(InputStream r100, OutputStream r101) throws Exception {
        GZIPOutputStream r102 = new GZIPOutputStream(r101);
        byte[] r103 = new byte[1024];
    L3:
        int r104 = r100.read(r103, 0, 1024);
        if (r104 == (-1)) goto L6;
        r102.write(r103, 0, r104);
        goto L3
    L6:
        r102.flush();
        r102.close();
        r101.close();     // Catch: Exception -> L9
        r100.close();     // Catch: Exception -> L9
        return;
    }

    public static /* synthetic */ boolean a(b r100, File r101) {
        return r100.b(r101);
    }

    public static /* synthetic */ void a(b r100, File[] r101) {
        r100.a(r101);
    }

    public void a(String r100, String r101) {
        JNIHandler.addLog(r100, r101);
    }
}
