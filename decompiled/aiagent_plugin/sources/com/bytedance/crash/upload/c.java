package com.bytedance.crash.upload;

import com.bytedance.crash.af;
import com.bytedance.crash.o.r;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpMultipart.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.crash.o f7793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpURLConnection f7795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.crash.c.b.a f7796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f7797e;

    public c(String r7, boolean r8) {
        this.f7794b = "AAA" + System.currentTimeMillis() + "AAA";
        SSLContext.getInstance("TLS").init(null, null, null);     // Catch: Throwable -> L18
    L4:
        HttpURLConnection r9 = b.a(new URL(r7));
        this.f7795c = r9;
        r9.setUseCaches(false);
        r9.setDoOutput(true);
        r9.setDoInput(true);
        r9.setRequestMethod("POST");
        r9.setRequestProperty(DownloadHelper.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f7794b);
        if (r8 == false) goto L20;
        r9.setRequestProperty(DownloadHelper.CONTENT_ENCODING, DownloadHelper.GZIP);
    L20:
        com.bytedance.crash.l.f r10 = af.b();     // Catch: Throwable -> L19
        if (r10 == null) goto L16;
        Map<String, String> r11 = r10.a("urlconnection");     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        Iterator<String> r1 = r11.keySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        this.f7795c.setRequestProperty(r2, (String) ZeusTransformUtils.preCheckCast(r11.get(r2), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
    L16:
        this.f7797e = new d(this.f7795c.getOutputStream(), r8);
        this.f7793a = com.bytedance.crash.config.h.c();
        this.f7796d = new com.bytedance.crash.c.b.a("crash_upload_size");
    }

    public void a(String r2, String r3) {
        a(r2, r3, false);
    }

    public void a(String r7, String r8, boolean r9) {
        long r0 = this.f7797e.b();
        StringBuilder r2 = new StringBuilder();
        r2.append("--").append(this.f7794b).append("\r\n").append("Content-Disposition: form-data; name=\"").append(r7).append("\"").append("\r\n").append("Content-Type: text/plain; charset=UTF-8").append("\r\n").append("\r\n");
        this.f7797e.a(r2.toString());     // Catch: IOException -> L10
    L4:
        byte[] r10 = r8.getBytes();
        if (r9 == false) goto L17;
        r10 = this.f7793a.a(r10);     // Catch: Throwable -> L11
    L17:
        this.f7797e.a(r10);     // Catch: IOException -> L12
        this.f7797e.a("\r\n");     // Catch: IOException -> L12
    L8:
        this.f7796d.b(new Object[]{r7 + "_size", Long.valueOf(this.f7797e.b() - r0)});
    }

    public void a(String r5, File r6) {
        long r0 = this.f7797e.b();
        b(r5);
        a(r6);
        this.f7796d.b(new Object[]{r5 + "_size", Long.valueOf(this.f7797e.b() - r0)});
    }

    private void b(String r2) {
        a(r2, null);
    }

    private void a(String r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        r0.append("--").append(this.f7794b).append("\r\n").append("Content-Disposition: form-data; name=\"").append(r8).append("\"; filename=\"").append(r8).append("\"");
        if (r10 == null) goto L8;
        Iterator r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.append("; ").append((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin")).append("=\"").append((String) ZeusTransformUtils.preCheckCast(r12.getValue(), String.class, "com.obric.aiagent.plugin")).append("\"");
    L8:
        r0.append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        this.f7797e.a(r0.toString().getBytes());
    }

    public void a(String r5, List<File> r6) {
        List<File> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        long r0 = this.f7797e.b();
        a(r5, null);
        this.f7797e.a(r7);
        this.f7797e.a("\r\n");
        this.f7796d.b(new Object[]{r5 + "_size", Long.valueOf(this.f7797e.b() - r0)});
    }

    public void a(File r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        a(r3.getName(), r5);
        a(r3);
    }

    private void a(File r5) {
        FileInputStream r0 = new FileInputStream(r5);
        byte[] r6 = new byte[8192];
    L3:
        int r1 = r0.read(r6);
        if (r1 == (-1)) goto L6;
        this.f7797e.a(r6, 0, r1);
        goto L3
    L6:
        r0.close();
        this.f7797e.a("\r\n");
    }

    public void a(String r6) {
        this.f7797e.a("\r\n--" + this.f7794b + "--\r\n");
        this.f7797e.a();
        this.f7796d.a(new Object[]{"data_type", r6});
        this.f7796d.b(new Object[]{"total_size", Long.valueOf(this.f7797e.b())});
        this.f7796d.a();
    }

    public l a() {
        ArrayList r0 = new ArrayList();
        r.a("getHeaderFields:" + this.f7795c.getHeaderFields());
        int r1 = this.f7795c.getResponseCode();
        l r2 = new l(r1);
        if (r1 != 200) goto L9;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(this.f7795c.getInputStream()));
    L5:
        String r4 = r3.readLine();
        if (r4 == null) goto L8;
        r0.add(r4);
        goto L5
    L8:
        r3.close();
        this.f7795c.disconnect();
    L10:
        StringBuilder r5 = new StringBuilder();
        Iterator r6 = r0.iterator();
    L12:
        if (r6.hasNext() == false) goto L22;
        r5.append((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"));
        goto L12
    L22:
        JSONObject r7 = new JSONObject(r5.toString());     // Catch: JSONException -> L16
    L17:
        r2.a(r7);
        k.a(this.f7795c.getURL(), r2);     // Catch: Throwable -> L21
    L19:
        r2.a(r5.toString().getBytes());
        return r2;
    L16:
        r7 = new JSONObject();
        r2.a(207);
        goto L17
    L9:
        r2.a(207);
        goto L10
    }
}
