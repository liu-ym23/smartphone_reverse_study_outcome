package com.media.cache.download;

import com.media.cache.listener.IDownloadTaskListener;
import com.media.cache.model.VideoCacheInfo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import u9.d;
import u9.e;

/* JADX INFO: loaded from: classes3.dex */
public class b extends VideoDownloadTask {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final q9.a f10460q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f10461r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile int f10462s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10463t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f10464u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f10465v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f10466w;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q9.c f10467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f10468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f10469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f10470d;

        public a(b r10, q9.c r11, File r12, String r13) {
            this.f10470d = r10;
            this.f10467a = r11;
            this.f10468b = r12;
            this.f10469c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
        L7:
            e = move-exception;
            o0.a.d("M3U8TsDownloadThread download failed, exception=" + e);
            b.m(this.f10470d, e);
            return;
        L3:
            if (b.i(this.f10470d) == true) goto L5;
            b.j(this.f10470d);     // Catch: Exception -> L7
            b.k(this.f10470d);     // Catch: Exception -> L7
        L11:
            b.l(this.f10470d, this.f10467a, this.f10468b, this.f10469c);     // Catch: Exception -> L7
            return;
        L5:
            if (this.f10470d.f10437e.g() == this.f10470d.f10438f.getPort()) goto L9;
            b.j(this.f10470d);     // Catch: Exception -> L7
        L9:
            b.k(this.f10470d);     // Catch: Exception -> L7
            goto L11
        }
    }

    /* JADX INFO: renamed from: com.media.cache.download.b$b, reason: collision with other inner class name */
    public class RunnableC0164b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f10471a;

        public RunnableC0164b(b r10) {
            this.f10471a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L7:
            o0.a.d("M3U8TsDownloadThread createM3U8File failed.");
            return;
        L3:
            if (this.f10471a.f10437e.g() == this.f10471a.f10438f.getPort()) goto L5;
            b.j(this.f10471a);     // Catch: Exception -> L7
        L5:
            b.k(this.f10471a);     // Catch: Exception -> L7
            b.n(this.f10471a);     // Catch: Exception -> L7
            b r10 = this.f10471a;     // Catch: Exception -> L7
            b.p(r10, b.o(r10));     // Catch: Exception -> L7
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f10472a;

        public c(b r10) {
            this.f10472a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r10 = this.f10472a;
            r10.f10438f.setPort(r10.f10437e.g());
            o0.a.c("writeProxyCacheInfo : " + this.f10472a.f10438f);
            b r11 = this.f10472a;
            d.l(r11.f10438f, r11.f10441i);
        }
    }

    public b(p9.a r10, VideoCacheInfo r11, q9.a r12, HashMap r13) {
        super(r10, r11, r13);
        this.f10462s = 0;
        this.f10466w = new Object();
        this.f10460q = r12;
        List r14 = r12.f();
        this.f10461r = r14;
        this.f10463t = r14.size();
        this.f10462s = r11.getCachedTs();
        this.f10465v = r11.getTotalLength();
        this.f10446n = r11.getPercent();
        long r15 = r12.b();
        this.f10464u = r15;
        if (r15 != 0) goto L5;
        this.f10464u = 1;
    L5:
        o0.a.d("jeffmony port=" + r10.g());
        r11.setTotalTs(this.f10463t);
        r11.setCachedTs(this.f10462s);
    }

    private void C() {
        Iterator r10 = this.f10461r.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        q9.c r11 = (q9.c) r10.next();
        if (new File(this.f10441i, r11.c()).exists() == true) goto L4;
        boolean r12 = false;
    L9:
        this.f10438f.setIsCompleted(r12);
        if (r12 == false) goto L16;
        D();
        return;
    L16:
        return;
    L8:
        r12 = true;
        goto L9
    }

    private void D() {
        VideoDownloadTask.OPERATE_TYPE r10 = this.f10448p;
        VideoDownloadTask.OPERATE_TYPE r11 = VideoDownloadTask.OPERATE_TYPE.WRITED;
        if (r10 != r11) goto L5;
        return;
    L5:
        u9.c.b(new c(this));
        if (this.f10448p == VideoDownloadTask.OPERATE_TYPE.DEFAULT) goto L8;
        return;
    L8:
        if (this.f10438f.getIsCompleted() == false) goto L12;
        this.f10448p = r11;
        return;
    }

    public static /* synthetic */ boolean i(b r10) {
        return r10.t();
    }

    public static /* synthetic */ void j(b r10) {
        r10.q();
    }

    public static /* synthetic */ void k(b r10) {
        r10.y();
    }

    public static /* synthetic */ void l(b r10, q9.c r11, File r12, String r13) {
        r10.s(r11, r12, r13);
    }

    public static /* synthetic */ void m(b r10, Exception r11) {
        r10.w(r11);
    }

    public static /* synthetic */ void n(b r10) {
        r10.v();
    }

    public static /* synthetic */ long o(b r10) {
        return r10.f10465v;
    }

    public static /* synthetic */ void p(b r10, long r11) {
        r10.u(r11);
    }

    private void v() {
        if (this.f10434b == null) goto L39;
        this.f10445m = 0;
        Iterator r10 = this.f10461r.iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        this.f10445m += ((q9.c) r10.next()).i();
        goto L6
    L9:
        if (this.f10445m != 0) goto L12;
        this.f10445m = e.a(this.f10441i);
    L12:
        if (this.f10438f.getIsCompleted() == false) goto L18;
        this.f10462s = this.f10463t;
        p9.b.c().b(this.f10441i, this.f10437e.b());
        if (d.g(100.0f, this.f10446n) == true) goto L16;
        this.f10434b.onTaskProgress(100.0f, this.f10445m, this.f10460q);
    L16:
        this.f10446n = 100.0f;
        long r11 = this.f10445m;
        this.f10465v = r11;
        this.f10434b.onTaskFinished(r11);
        return;
    L18:
        int r12 = this.f10462s;
        int r13 = this.f10463t;
        if (r12 < (r13 - 1)) goto L21;
        this.f10462s = r13;
    L21:
        this.f10438f.setCachedTs(this.f10462s);
        this.f10460q.i(this.f10462s);
        float r14 = ((this.f10462s * 1.0f) * 100.0f) / this.f10463t;
        if (d.g(r14, this.f10446n) == true) goto L24;
        this.f10434b.onTaskProgress(r14, this.f10445m, this.f10460q);
        this.f10446n = r14;
        this.f10438f.setPercent(r14);
        this.f10438f.setCachedLength(this.f10445m);
    L24:
        Iterator r15 = this.f10461r.iterator();
    L26:
        if (r15.hasNext() == false) goto L30;
        if (new File(this.f10441i, ((q9.c) r15.next()).c()).exists() == true) goto L26;
        boolean r16 = false;
    L31:
        this.f10438f.setIsCompleted(r16);
        if (r16 == false) goto L40;
        this.f10438f.setTotalLength(this.f10445m);
        long r17 = this.f10445m;
        this.f10465v = r17;
        this.f10434b.onTaskFinished(r17);
        D();
        return;
    L40:
        return;
    L30:
        r16 = true;
        goto L31
    }

    private void y() {
        if (this.f10434b != null) goto L5;
        return;
    L5:
        if (this.f10436d == true) goto L9;
        o0.a.c("M3U8VideoDownloadTask notifyVideoReady");
        String r10 = String.format(Locale.US, "http://%s:%d/%s/%s", new Object[]{this.f10437e.f(), Integer.valueOf(this.f10437e.g()), this.f10442j, "proxy.m3u8"});
        this.f10434b.onLocalProxyReady(r10);
        this.f10436d = true;
        return;
    }

    private HttpURLConnection z(String r10) {
        int r11 = 0;
    L3:
        HttpURLConnection r12 = (HttpURLConnection) new URL(r10).openConnection();
        if (this.f10437e.k() == true) goto L6;
    L8:
        r12.setConnectTimeout(this.f10437e.d());
        r12.setReadTimeout(this.f10437e.h());
        HashMap r13 = this.f10440h;
        if (r13 == null) goto L14;
        Iterator r14 = r13.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r14.next();
        r12.setRequestProperty((String) r15.getKey(), (String) r15.getValue());
    L14:
        int r16 = r12.getResponseCode();
        if (r16 != 301) goto L17;
    L22:
        boolean r17 = true;
    L23:
        if (r17 == false) goto L26;
        r11 = r11 + 1;
        r12.disconnect();
    L26:
        if (r11 > 3) goto L30;
        if (r17 == true) goto L3;
        return r12;
    L30:
        throw new Exception("Too many redirects: " + r11);
    L17:
        if (r16 == 302) goto L22;
        if (r16 == 303) goto L22;
        r17 = false;
        goto L23
    L6:
        if ((r12 instanceof HttpsURLConnection) == false) goto L8;
        u9.b.h((HttpsURLConnection) r12);
        goto L8
    }

    public final void A(InputStream r10, File r11) {
        FileOutputStream r12 = new FileOutputStream(r11);     // Catch: Throwable -> L15 IOException -> L17
    L26:
        byte[] r13 = new byte[8192];     // Catch: Throwable -> L10 IOException -> L12
    L6:
        int r14 = r10.read(r13);     // Catch: Throwable -> L10 IOException -> L12
        if (r14 == (-1)) goto L14;
        r12.write(r13, 0, r14);     // Catch: Throwable -> L10 IOException -> L12
    L14:
        d.b(r10);
        d.b(r12);
        return;
    L12:
        IOException e10 = e;
    L19:
        o0.a.d(r11.getAbsolutePath() + " saveFile failed, exception=" + e10);     // Catch: Throwable -> L10
        if (r11.exists() == false) goto L14;
        r11.delete();     // Catch: Throwable -> L10
    L10:
        Throwable th = th;
    L24:
        d.b(r10);
        d.b(r12);
        throw th;
    L17:
        e = move-exception;
        r12 = null;
        e10 = e;
    L15:
        th = move-exception;
        r12 = null;
        th = th;
        goto L24
    }

    public void B(int r10, IDownloadTaskListener r11) {
        if (this.f10438f.getIsCompleted() == false) goto L6;
        o0.a.c("M3U8VideoDownloadTask local file.");
        x();
        return;
    L6:
        g();
        this.f10462s = r10;
        o0.a.c("seekToDownload curDownloadTs = " + r10);
        this.f10433a = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    L8:
        if (r10 >= this.f10463t) goto L13;
        if (this.f10433a.isShutdown() == true) goto L13;
        String r12 = "seg_" + r10 + ".ts";
        this.f10433a.execute(new a(this, (q9.c) this.f10461r.get(r10), new File(this.f10441i, r12), r12));
        r10 = r10 + 1;
    L13:
        u(this.f10445m);
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void c() {
        ThreadPoolExecutor r10 = this.f10433a;
        if (r10 != null) goto L5;
    L7:
        C();
        return;
    L5:
        if (r10.isShutdown() == true) goto L7;
        this.f10433a.shutdownNow();
        this.f10435c = true;
        b();
        goto L7
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void d() {
        o0.a.c("M3U8VideoDownloadTask resumeDownload, curTs=" + this.f10462s);
        this.f10435c = false;
        B(this.f10462s, this.f10434b);
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void e(long r10, long r11) {
        c();
        o0.a.c("seekToDownload curPosition=" + r10 + ", totalDuration=" + r11 + ", " + this.f10464u);
        if (this.f10464u != r11) goto L5;
    L7:
        int r12 = this.f10460q.e(r10 / 1000);
        this.f10435c = false;
        B(r12, this.f10434b);
        return;
    L5:
        if (r11 == 0) goto L7;
        this.f10464u = r11;
        goto L7
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void f(IDownloadTaskListener r10) {
        this.f10434b = r10;
        if (r10 == null) goto L5;
        r10.onTaskStart(this.f10438f.getUrl());
    L5:
        this.f10436d = false;
        o0.a.c("startDownload=" + this.f10462s);
        B(this.f10462s, r10);
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void h() {
        ThreadPoolExecutor r10 = this.f10433a;
        if (r10 != null) goto L5;
    L7:
        C();
        p9.b.c().b(this.f10441i, this.f10437e.b());
        return;
    L5:
        if (r10.isShutdown() == true) goto L7;
        this.f10433a.shutdownNow();
        this.f10435c = true;
        b();
        goto L7
    }

    public final void q() {
        Object r10 = this.f10466w;
        monitor-enter(r10);
        File r11 = new File(this.f10441i, "temp.m3u8");     // Catch: Throwable -> L7
        if (r11.exists() == false) goto L9;
        r11.delete();     // Catch: Throwable -> L7
    L9:
        BufferedWriter r12 = new BufferedWriter(new FileWriter(r11, false));     // Catch: Throwable -> L7
        r12.write("#EXTM3U\n");     // Catch: Throwable -> L7
        r12.write("#EXT-X-VERSION:" + this.f10460q.g() + "\n");     // Catch: Throwable -> L7
        r12.write("#EXT-X-MEDIA-SEQUENCE:" + this.f10460q.c() + "\n");     // Catch: Throwable -> L7
        r12.write("#EXT-X-TARGETDURATION:" + this.f10460q.d() + "\n");     // Catch: Throwable -> L7
        Iterator r13 = this.f10461r.iterator();     // Catch: Throwable -> L7
    L11:
        if (r13.hasNext() == false) goto L32;
        q9.c r14 = (q9.c) r13.next();     // Catch: Throwable -> L7
        if (r14.l() == false) goto L29;
        if (r14.g() == null) goto L29;
        String r15 = "METHOD=" + r14.g();     // Catch: Throwable -> L7
        if (r14.e() == null) goto L25;
        File r16 = new File(this.f10441i, r14.f());     // Catch: Throwable -> L7
        if (r14.n() == false) goto L21;
    L23:
        r15 = r15 + ",URI=\"" + r14.e() + "\"";     // Catch: Throwable -> L7
        goto L25
    L21:
        if (r16.exists() == false) goto L23;
        r15 = r15 + ",URI=\"" + r14.f() + "\"";     // Catch: Throwable -> L7
    L25:
        if (r14.d() == null) goto L27;
        r15 = r15 + ",IV=" + r14.d();     // Catch: Throwable -> L7
    L27:
        r12.write("#EXT-X-KEY:" + r15 + "\n");     // Catch: Throwable -> L7
    L29:
        if (r14.k() == false) goto L31;
        r12.write("#EXT-X-DISCONTINUITY\n");     // Catch: Throwable -> L7
    L31:
        r12.write("#EXTINF:" + r14.b() + ",\n");     // Catch: Throwable -> L7
        r12.write(r14.h(this.f10437e.f(), this.f10437e.g(), this.f10442j));     // Catch: Throwable -> L7
        r12.newLine();     // Catch: Throwable -> L7
        goto L11
    L32:
        r12.write("#EXT-X-ENDLIST");     // Catch: Throwable -> L7
        r12.flush();     // Catch: Throwable -> L7
        r12.close();     // Catch: Throwable -> L7
        File r17 = new File(this.f10441i, "proxy.m3u8");     // Catch: Throwable -> L7
        if (r17.exists() == false) goto L35;
        r17.delete();     // Catch: Throwable -> L7
    L35:
        r11.renameTo(r17);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void r(String r10, File r11) {
        HttpURLConnection r12 = null;
        InputStream r13 = null;
        r13 = null;
        r13 = null;
        r12 = null;
        HttpURLConnection r14 = z(r10);     // Catch: Throwable -> L14 Exception -> L16
    L10:
        e = e;
        InputStream r15 = r13;
        r12 = r14;
        InputStream r16 = r15;
    L24:
        throw e;     // Catch: Throwable -> L19
    L19:
        th = th;
    L20:
        if (r12 == null) goto L22;
        r12.disconnect();
    L22:
        d.b(r16);
        throw th;
    L8:
        th = th;
        InputStream r17 = r13;
        r12 = r14;
        r16 = r17;
        goto L20
    L5:
        if (r14.getResponseCode() != 200) goto L12;
        r13 = r14.getInputStream();     // Catch: Throwable -> L8 Exception -> L10
        A(r13, r11);     // Catch: Throwable -> L8 Exception -> L10
    L12:
        r14.disconnect();
        d.b(r13);
        return;
    L16:
        e = e;
        r16 = null;
    L14:
        th = th;
        r16 = null;
        goto L20
    }

    public final void s(q9.c r10, File r11, String r12) {
        if (r11.exists() == true) goto L6;
        r(r10.j(), r11);
    L6:
        if (r11.exists() == false) goto L9;
        r10.q(r12);
        r10.r(r11.length());
        this.f10462s++;
        v();
        return;
    }

    public final boolean t() {
        Object r10 = this.f10466w;
        monitor-enter(r10);
        boolean r11 = new File(this.f10441i, "proxy.m3u8").exists();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final void u(long r10) {
        if (this.f10434b == null) goto L8;
        C();
        if (this.f10438f.getIsCompleted() == false) goto L9;
        this.f10434b.onTaskFinished(r10);
        p9.b.c().b(this.f10441i, this.f10437e.b());
        return;
    L9:
        return;
    }

    public final void w(Exception r10) {
        p9.b.c().b(this.f10441i, this.f10437e.b());
        if ((r10 instanceof InterruptedException) == true) goto L18;
        if ((r10 instanceof InterruptedIOException) == true) goto L18;
        if ((r10 instanceof MalformedURLException) == true) goto L10;
        IDownloadTaskListener r11 = this.f10434b;
        if (r11 == null) goto L24;
        r11.onTaskFailed(r10);
        return;
    L24:
        return;
    L10:
        if (r10.toString().contains("no protocol: ") == false) goto L23;
        o0.a.d(r10.toString().substring(r10.toString().indexOf("no protocol: ") + 13) + " not existed.");
        return;
    L23:
        return;
    L18:
        if ((r10 instanceof SocketTimeoutException) == false) goto L21;
        o0.a.d("M3U8VideoDownloadTask notifyFailed: " + r10);
        d();
        return;
    L21:
        c();
        D();
    }

    public final void x() {
        u9.c.b(new RunnableC0164b(this));
    }
}
