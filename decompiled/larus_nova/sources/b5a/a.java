package b5a;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExecutorService f17788d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteArrayOutputStream f17791c;

    static {
        f17788d = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("DevToolDownloader"));
    }

    public final void b() {
        HttpURLConnection r100 = (HttpURLConnection) a(new URL(this.f17789a));     // Catch: Exception -> L26
        r100.setConnectTimeout(1440);     // Catch: Exception -> L26
        r100.setReadTimeout(120000);     // Catch: Exception -> L26
        r100.setDoOutput(false);     // Catch: Exception -> L26
        r100.setDoInput(true);     // Catch: Exception -> L26
        r100.connect();     // Catch: Exception -> L26
        r100.setInstanceFollowRedirects(true);     // Catch: Exception -> L26
        int r101 = r100.getResponseCode();     // Catch: Exception -> L26
        if (r101 <= 299) goto L9;
        r100.disconnect();     // Catch: Exception -> L26
        String r102 = "Download connection failed and the response code is " + r101;     // Catch: Exception -> L26
        b r103 = this.f17790b;     // Catch: Exception -> L26
        if (r103 == null) goto L33;
        r103.onFailure(r102);     // Catch: Exception -> L26
        return;
    L33:
        return;
    L9:
        int r104 = r100.getContentLength();     // Catch: Exception -> L26
        b r105 = this.f17790b;     // Catch: Exception -> L26
        if (r105 == null) goto L12;
        r105.onResponse(r101, r104);     // Catch: Exception -> L26
    L12:
        Runtime r106 = Runtime.getRuntime();     // Catch: Exception -> L26
        long r107 = ((r106.maxMemory() - r106.totalMemory()) + r106.freeMemory()) / 10;     // Catch: Exception -> L26
        if (r104 <= r107) goto L18;
        r100.disconnect();     // Catch: Exception -> L26
        String r108 = "The size of the downloaded data has exceeded the maximum safe memory size, which may pose a risk of OOM. Currently, the content size is " + r104 + " byte, and the safe memory available for use is " + r107;     // Catch: Exception -> L26
        b r109 = this.f17790b;     // Catch: Exception -> L26
        if (r109 == null) goto L34;
        r109.onFailure(r108);     // Catch: Exception -> L26
        return;
    L34:
        return;
    L18:
        InputStream r110 = r100.getInputStream();     // Catch: Exception -> L26
        byte[] r111 = new byte[8192];     // Catch: Exception -> L26
    L19:
        int r112 = r110.read(r111);     // Catch: Exception -> L26
        if (r112 == (-1)) goto L21;
        this.f17791c.write(r111, 0, r112);     // Catch: Exception -> L26
        goto L19
    L21:
        byte[] r113 = this.f17791c.toByteArray();     // Catch: Exception -> L26
        int r114 = this.f17791c.size();     // Catch: Exception -> L26
        b r115 = this.f17790b;     // Catch: Exception -> L26
        if (r115 == null) goto L35;
        r115.onData(r113, r114);     // Catch: Exception -> L26
        return;
    L35:
        return;
    L26:
        e = move-exception;
        String r116 = "An exception occurred when download: " + e.getMessage();
        b r117 = this.f17790b;
        if (r117 == null) goto L37;
        r117.onFailure(r116);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
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

    public a(String r100, b r101) {
        this.f17789a = r100;
        this.f17790b = r101;
        this.f17791c = new ByteArrayOutputStream();
        f17788d.execute(this);
    }
}
