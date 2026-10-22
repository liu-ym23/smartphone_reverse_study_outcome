package com.media.cache.download;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.media.cache.VideoCacheException;
import com.media.cache.listener.IDownloadTaskListener;
import com.media.cache.model.VideoCacheInfo;
import com.obric.capabilitykit.common.UiType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import u9.d;

/* JADX INFO: loaded from: classes3.dex */
public class a extends VideoDownloadTask {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinkedHashMap f10450q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinkedHashMap f10451r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public c f10452s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f10453t;

    /* JADX INFO: renamed from: com.media.cache.download.a$a, reason: collision with other inner class name */
    public class RunnableC0163a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f10454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f10455b;

        public RunnableC0163a(a r10, long r11) {
            this.f10455b = r10;
            this.f10454a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r10 = this.f10455b;
            a.j(r10, a.k(r10, this.f10454a));
            o0.a.c("seekToDownload ### mCurDownloadRange=" + a.i(this.f10455b));
            if (a.l(this.f10455b) != (-1)) goto L104;
            a r11 = this.f10455b;
            a.m(r11, a.n(r11, r11.f10439g));
            o0.a.c("file length = " + a.l(this.f10455b));
            if (a.l(this.f10455b) > 0) goto L8;
            o0.a.d("BaseVideoDownloadTask file length cannot be fetched.");
            a.o(this.f10455b, new VideoCacheException("File Length Cannot be fetched"));
            return;
        L8:
            a r12 = this.f10455b;
            r12.f10438f.setTotalLength(a.l(r12));
        L104:
            File r13 = new File(this.f10455b.f10441i, this.f10455b.f10442j + ".video");     // Catch: Exception -> L13
            if (r13.exists() == true) goto L16;
            r13.createNewFile();     // Catch: Exception -> L13
        L16:
            if (r13.exists() == false) goto L21;
            if (r13.length() <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) goto L21;
            o0.a.c("seekToDownload, notifyVideoReady, video file length:" + r13.length());
            a.p(this.f10455b);
        L21:
            if (a.i(this.f10455b).f10457a != Long.MIN_VALUE) goto L24;
            a.i(this.f10455b).f10457a = 0;
        L24:
            if (a.i(this.f10455b).f10458b != Long.MAX_VALUE) goto L26;
            a.i(this.f10455b).f10458b = a.l(this.f10455b);
        L26:
            InputStream r14 = null;
            o0.a.c("seekToDownload start request video range:" + a.i(this.f10455b));     // Catch: Throwable -> L62 IOException -> L64
            o0.a.c("begin request");     // Catch: Throwable -> L62 IOException -> L64
            long r15 = a.i(this.f10455b).f10458b;     // Catch: Throwable -> L62 IOException -> L64
            long r16 = a.i(this.f10455b).f10457a;     // Catch: Throwable -> L62 IOException -> L64
            a r17 = this.f10455b;     // Catch: Throwable -> L62 IOException -> L64
            r17.f10445m = r16;     // Catch: Throwable -> L62 IOException -> L64
            InputStream r18 = a.q(r17, r17.f10439g, r16, r15);     // Catch: Throwable -> L62 IOException -> L64
        L116:
            byte[] r19 = new byte[8192];     // Catch: Throwable -> L58 IOException -> L60
            o0.a.c("begin response");     // Catch: Throwable -> L58 IOException -> L60
            Log.i("BaseVideoDownloadTask", "seekToDownload, rangeStart:" + r16 + ", rangeEnd:" + r15);     // Catch: Throwable -> L58 IOException -> L60
            RandomAccessFile r20 = new RandomAccessFile(r13.getAbsolutePath(), "rw");     // Catch: Throwable -> L58 IOException -> L60
            r20.seek(r16);     // Catch: Throwable -> L36 IOException -> L39
        L31:
            int r21 = r18.read(r19);     // Catch: Throwable -> L36 IOException -> L39
            if (r21 == (-1)) goto L106;
            a r22 = this.f10455b;     // Catch: Throwable -> L36 IOException -> L39
            if (r22.f10445m < r15) goto L41;
            r22.f10445m = r15;     // Catch: Throwable -> L36 IOException -> L39
        L41:
            long r23 = r22.f10445m;     // Catch: Throwable -> L36 IOException -> L39
            byte[] r110 = r19;
            long r24 = r21;
            if ((r23 + r24) <= r15) goto L44;
            byte[] r25 = r110;
            r20.write(r25, 0, (int) (r15 - r23));     // Catch: Throwable -> L36 IOException -> L39
            this.f10455b.f10445m = r15;     // Catch: Throwable -> L36 IOException -> L39
        L45:
            a.r(this.f10455b);     // Catch: Throwable -> L36 IOException -> L39
            if (this.f10455b.f10445m < (1056768 + r16)) goto L50;
            o0.a.c("seekToDownload, notifyVideoReady, mCurrentCachedSize:" + this.f10455b.f10445m + ", BUFFER_SIZE:8192, rangeStart:" + r16 + ", START_BUFFER_SIZE:" + UiType.FLAG_APP_CHOOSER_CARD + ", file.size:" + r20.length());     // Catch: Throwable -> L36 IOException -> L39
            a.p(this.f10455b);     // Catch: Throwable -> L36 IOException -> L39
        L50:
            if (this.f10455b.f10445m < r15) goto L52;
            o0.a.d("BaseVideoDownloadTask innerThread segment download finished.");     // Catch: Throwable -> L36 IOException -> L39
            a.s(this.f10455b, r15);     // Catch: Throwable -> L36 IOException -> L39
        L52:
            r19 = r25;
            goto L31
        L44:
            r25 = r110;
            r20.write(r25, 0, r21);     // Catch: Throwable -> L36 IOException -> L39
            this.f10455b.f10445m += r24;     // Catch: Throwable -> L36 IOException -> L39
            goto L45
        L106:
            r18.close();     // Catch: IOException -> L55
            r20.close();     // Catch: IOException -> L55
            return;
        L55:
            e = move-exception;
            o0.a.d("Close stream failed, exception: " + e.getMessage());
            return;
        L39:
            e = e;
        L40:
            r14 = r18;
        L102:
            o0.a.d("BaseVideo Download file failed, exception: " + e);     // Catch: Throwable -> L87
            p9.b r26 = p9.b.c();     // Catch: Throwable -> L87
            a r27 = this.f10455b;     // Catch: Throwable -> L87
            r26.b(r27.f10441i, r27.f10437e.b());     // Catch: Throwable -> L87
            if ((e instanceof InterruptedIOException) == false) goto L77;
            if (r14 != null) goto L100;
        L72:
            if (r20 == null) goto L121;
            r20.close();     // Catch: IOException -> L70
            return;
        L70:
            e = move-exception;
            o0.a.d("Close stream failed, exception: " + e.getMessage());
            return;
        L121:
            return;
        L100:
            r14.close();     // Catch: IOException -> L70
            goto L72
        L77:
            a.o(this.f10455b, e);     // Catch: Throwable -> L87
            if (r14 != null) goto L108;
        L82:
            if (r20 == null) goto L123;
            r20.close();     // Catch: IOException -> L80
            return;
        L80:
            e = move-exception;
            o0.a.d("Close stream failed, exception: " + e.getMessage());
            return;
        L123:
            return;
        L108:
            r14.close();     // Catch: IOException -> L80
        L87:
            th = move-exception;
            Throwable r28 = th;
        L89:
            if (r14 != null) goto L110;
        L93:
            if (r20 == null) goto L125;
            r20.close();     // Catch: IOException -> L91
            throw r28;
        L91:
            e = move-exception;
            o0.a.d("Close stream failed, exception: " + e.getMessage());
            throw r28;
        L125:
            throw r28;
        L110:
            r14.close();     // Catch: IOException -> L91
        L36:
            th = move-exception;
            r28 = th;
        L38:
            r14 = r18;
            goto L89
        L60:
            e = e;
            r20 = null;
        L58:
            th = move-exception;
            r28 = th;
            r20 = null;
        L64:
            e = e;
            r20 = null;
        L62:
            th = move-exception;
            r28 = th;
            r20 = null;
        L13:
            e = move-exception;
            o0.a.d("BaseDownloadTask createNewFile failed, exception=" + e.getMessage());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f10456a;

        public b(a r10) {
            this.f10456a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r10 = this.f10456a;
            r10.f10438f.setPort(r10.f10437e.g());
            o0.a.c("writeProxyCacheInfo : " + this.f10456a.f10438f);
            a r11 = this.f10456a;
            d.l(r11.f10438f, r11.f10441i);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f10459c;

        public c(a r10, long r11, long r12) {
            this.f10459c = r10;
            this.f10457a = r11;
            this.f10458b = r12;
        }

        public boolean equals(Object r10) {
            c r11 = (c) r10;
            if (this.f10457a == r11.f10457a) goto L5;
        L7:
            return false;
        L5:
            if (this.f10458b != r11.f10458b) goto L7;
            return true;
        }

        public String toString() {
            return "VideoRange[start=" + this.f10457a + ", end=" + this.f10458b + "]";
        }
    }

    public a(p9.a r10, VideoCacheInfo r11, HashMap r12) {
        super(r10, r11, r12);
        this.f10453t = -1;
        this.f10453t = r11.getTotalLength();
        this.f10450q = this.f10438f.getSegmentList();
        this.f10451r = new LinkedHashMap();
        this.f10452s = new c(this, Long.MIN_VALUE, Long.MAX_VALUE);
        x();
    }

    public static /* synthetic */ c i(a r10) {
        return r10.f10452s;
    }

    public static /* synthetic */ c j(a r10, c r11) {
        r10.f10452s = r11;
        return r11;
    }

    public static /* synthetic */ c k(a r10, long r11) {
        return r10.w(r11);
    }

    public static /* synthetic */ long l(a r10) {
        return r10.f10453t;
    }

    public static /* synthetic */ long m(a r10, long r11) {
        r10.f10453t = r11;
        return r11;
    }

    public static /* synthetic */ long n(a r10, String r11) {
        return r10.u(r11);
    }

    public static /* synthetic */ void o(a r10, Throwable r11) {
        r10.C(r11);
    }

    public static /* synthetic */ void p(a r10) {
        r10.E();
    }

    public static /* synthetic */ InputStream q(a r10, String r11, long r12, long r13) {
        return r10.v(r11, r12, r13);
    }

    public static /* synthetic */ void r(a r10) {
        r10.B();
    }

    public static /* synthetic */ void s(a r10, long r11) {
        r10.D(r11);
    }

    public final void A() {
        if (this.f10434b == null) goto L6;
        J();
        this.f10434b.onTaskFinished(this.f10453t);
        p9.b.c().b(this.f10441i, this.f10437e.b());
        return;
    }

    public final void B() {
        if (this.f10434b != null) goto L5;
        return;
    L5:
        if (this.f10438f.getIsCompleted() == true) goto L7;
        this.f10438f.setCachedLength(this.f10445m);
        float r10 = ((this.f10445m * 1.0f) * 100.0f) / this.f10453t;
        o0.a.d("notifyCacheProgress isFloatEqual=" + d.g(r10, this.f10446n));
        if (d.g(r10, this.f10446n) == true) goto L16;
        this.f10434b.onTaskProgress(r10, this.f10445m, null);
        this.f10446n = r10;
        return;
    L16:
        return;
    L7:
        if (d.g(100.0f, this.f10446n) == true) goto L9;
        this.f10434b.onTaskProgress(100.0f, this.f10453t, null);
    L9:
        this.f10446n = 100.0f;
        A();
    }

    public final void C(Throwable r10) {
        IDownloadTaskListener r11 = this.f10434b;
        if (r11 == null) goto L6;
        r11.onTaskFailed(r10);
        return;
    }

    public final void D(long r10) {
        c();
        if (r10 >= this.f10453t) goto L6;
        H(r10, this.f10434b);
        return;
    }

    public final synchronized void E() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f10434b != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.f10436d == true) goto L11;
        this.f10434b.onLocalProxyReady(String.format(Locale.US, "http://%s:%d/%s/%s", new Object[]{this.f10437e.f(), Integer.valueOf(this.f10437e.g()), this.f10442j, this.f10442j + ".video"}));     // Catch: Throwable -> L9
        this.f10436d = true;     // Catch: Throwable -> L9
        goto L11
    }

    public final HttpURLConnection F(String r10) {
        HttpURLConnection r11 = (HttpURLConnection) new URL(r10).openConnection();
        if (this.f10437e.k() == true) goto L5;
    L7:
        r11.setConnectTimeout(this.f10437e.h());
        r11.setReadTimeout(this.f10437e.d());
        HashMap r12 = this.f10440h;
        if (r12 == null) goto L13;
        Iterator r13 = r12.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        Map.Entry r14 = (Map.Entry) r13.next();
        r11.setRequestProperty((String) r14.getKey(), (String) r14.getValue());
    L13:
        return r11;
    L5:
        if ((r11 instanceof HttpsURLConnection) == false) goto L7;
        u9.b.h((HttpsURLConnection) r11);
        goto L7
    }

    public final synchronized void G() {
        monitor-enter(this);
        Iterator r10 = this.f10451r.entrySet().iterator();     // Catch: Throwable -> L8
        o0.a.c("printVideoRange size=" + this.f10451r.size());     // Catch: Throwable -> L8
    L5:
        if (r10.hasNext() == false) goto L10;
        o0.a.c("printVideoRange range=" + ((c) ((Map.Entry) r10.next()).getValue()));     // Catch: Throwable -> L8
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void H(long r10, IDownloadTaskListener r12) {
        if (this.f10438f.getIsCompleted() == false) goto L6;
        o0.a.c("BaseVideoDownloadTask local file notifyVideoReady.");
        E();
        B();
        return;
    L6:
        g();
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.f10433a = r13;
        r13.execute(new RunnableC0163a(this, r10));
    }

    public final synchronized void I() {
        monitor-enter(this);
        o0.a.c("BaseVideoDownloadTask updateProxyCacheInfo");     // Catch: Throwable -> L8
        if (y() == true) goto L12;
        long r10 = this.f10445m;     // Catch: Throwable -> L8
        long r11 = this.f10453t;     // Catch: Throwable -> L8
        if (r10 <= r11) goto L10;
        this.f10452s.f10458b = r11;     // Catch: Throwable -> L8
    L11:
        z();     // Catch: Throwable -> L8
        this.f10438f.setCachedLength(this.f10452s.f10458b);     // Catch: Throwable -> L8
        this.f10438f.setIsCompleted(y());     // Catch: Throwable -> L8
    L14:
        if (this.f10438f.getIsCompleted() == false) goto L16;
        A();     // Catch: Throwable -> L8
    L16:
        monitor-exit(this);
        return;
    L10:
        this.f10452s.f10458b = r10;     // Catch: Throwable -> L8
        goto L11
    L12:
        this.f10438f.setIsCompleted(true);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final void J() {
        VideoDownloadTask.OPERATE_TYPE r10 = this.f10448p;
        VideoDownloadTask.OPERATE_TYPE r11 = VideoDownloadTask.OPERATE_TYPE.WRITED;
        if (r10 != r11) goto L5;
        return;
    L5:
        u9.c.b(new b(this));
        if (this.f10448p == VideoDownloadTask.OPERATE_TYPE.DEFAULT) goto L8;
        return;
    L8:
        if (this.f10438f.getIsCompleted() == false) goto L12;
        this.f10448p = r11;
        return;
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void c() {
        ThreadPoolExecutor r10 = this.f10433a;
        if (r10 != null) goto L5;
    L7:
        I();
        J();
        p9.b.c().b(this.f10441i, this.f10437e.b());
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
        o0.a.c("BaseVideoDownloadTask resumeDownload current position=" + this.f10445m);
        this.f10435c = false;
        H(this.f10445m, this.f10434b);
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void e(long r10, long r11) {
        c();
        long r12 = (long) (((r10 * 1.0f) / r11) * this.f10453t);
        o0.a.c("BaseVideoDownloadTask seekToDownload seekToDownload=" + r12);
        this.f10435c = false;
        H(r12, this.f10434b);
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void f(IDownloadTaskListener r10) {
        this.f10434b = r10;
        if (r10 == null) goto L5;
        r10.onTaskStart(this.f10438f.getUrl());
    L5:
        this.f10436d = false;
        H(0, r10);
    }

    @Override // com.media.cache.download.VideoDownloadTask
    public void h() {
        ThreadPoolExecutor r10 = this.f10433a;
        if (r10 != null) goto L5;
    L7:
        I();
        J();
        p9.b.c().b(this.f10441i, this.f10437e.b());
        return;
    L5:
        if (r10.isShutdown() == true) goto L7;
        this.f10433a.shutdownNow();
        this.f10435c = true;
        b();
        goto L7
    }

    public final boolean t(c r10, c r11) {
        if (r10.f10457a < r11.f10457a) goto L5;
    L7:
        return false;
    L5:
        if (r10.f10458b < r11.f10458b) goto L7;
        return true;
    }

    public final long u(String r10) {
        HttpURLConnection r11 = null;
        r11 = F(r10);     // Catch: Throwable -> L5 Exception -> L7
        long r12 = r11.getContentLength();     // Catch: Throwable -> L5 Exception -> L7
        r11.disconnect();
        return r12;
    L7:
        e = move-exception;
        o0.a.d("BaseDownloadTask failed, exception=" + e.getMessage());     // Catch: Throwable -> L5
        if (r11 == null) goto L11;
        r11.disconnect();
    L11:
        return 0;
    L5:
        th = move-exception;
        if (r11 == null) goto L15;
        r11.disconnect();
    L15:
        throw th;
    }

    public final InputStream v(String r10, long r11, long r12) {
        HttpURLConnection r13 = F(r10);
        r13.setRequestProperty("Range", "bytes=" + r11 + "-" + r12);
        return r13.getInputStream();
    }

    public final synchronized c w(long r10) {
        monitor-enter(this);
        G();     // Catch: Throwable -> L14
        Iterator r11 = this.f10451r.entrySet().iterator();     // Catch: Throwable -> L14
        long r12 = 0;
    L5:
        if (r11.hasNext() == false) goto L19;
        c r13 = (c) ((Map.Entry) r11.next()).getValue();     // Catch: Throwable -> L14
        long r14 = r13.f10457a;     // Catch: Throwable -> L14
        if (r14 > r10) goto L8;
        if (r14 > r10) goto L16;
        r12 = r13.f10458b;     // Catch: Throwable -> L14
        if (r12 >= r10) goto L5;
    L16:
        r12 = r13.f10458b;     // Catch: Throwable -> L14
        if (r10 <= (PlaybackStateCompat.ACTION_PLAY_FROM_URI + r12)) goto L5;
        r12 = r10;
        goto L5
    L8:
        long r15 = r14;
    L20:
        c r16 = new c(this, r12, r15);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r16;
    L19:
        r15 = Long.MAX_VALUE;
    L14:
        th = move-exception;
        throw th;
    }

    public final void x() {
        Iterator r10 = this.f10450q.entrySet().iterator();
        o0.a.c("initSegments size=" + this.f10450q.size());
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r10.next();
        Long r12 = (Long) r11.getKey();
        this.f10451r.put(r12, new c(this, r12.longValue(), ((Long) r11.getValue()).longValue()));
        goto L4
    L6:
        G();
    }

    public final synchronized boolean y() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f10451r.size() == 1) goto L8;
        monitor-exit(this);
        return false;
    L8:
        c r10 = (c) this.f10451r.get(0L);     // Catch: Throwable -> L15
        if (r10 == null) goto L17;
        if (r10.f10458b != this.f10453t) goto L17;
        monitor-exit(this);
        return true;
    L17:
        monitor-exit(this);
        return false;
    }

    public final synchronized void z() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f10451r.size() >= 1) goto L16;
        o0.a.c("mergeVideoRange mCurDownloadRange=" + this.f10452s);     // Catch: Throwable -> L12
        c r10 = this.f10452s;     // Catch: Throwable -> L12
        long r11 = r10.f10457a;     // Catch: Throwable -> L12
        if (r11 == Long.MIN_VALUE) goto L14;
        long r12 = r10.f10458b;     // Catch: Throwable -> L12
        if (r12 == Long.MAX_VALUE) goto L14;
        if (r11 >= r12) goto L14;
        this.f10451r.put(Long.valueOf(r11), this.f10452s);     // Catch: Throwable -> L12
    L61:
        LinkedHashMap r13 = new LinkedHashMap();     // Catch: Throwable -> L12
        Iterator r14 = this.f10451r.entrySet().iterator();     // Catch: Throwable -> L12
    L63:
        if (r14.hasNext() == false) goto L65;
        c r15 = (c) ((Map.Entry) r14.next()).getValue();     // Catch: Throwable -> L12
        r13.put(Long.valueOf(r15.f10457a), Long.valueOf(r15.f10458b));     // Catch: Throwable -> L12
        goto L63
    L65:
        this.f10450q.clear();     // Catch: Throwable -> L12
        this.f10450q.putAll(r13);     // Catch: Throwable -> L12
        this.f10438f.setSegmentList(this.f10450q);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L14:
        o0.a.c("mergeVideoRange Cannot merge video range.");     // Catch: Throwable -> L12
        goto L61
    L16:
        if (this.f10451r.containsValue(this.f10452s) == true) goto L61;
        o0.a.c("mergeVideoRange rangeLength>1, mCurDownloadRange=" + this.f10452s);     // Catch: Throwable -> L12
        c r16 = this.f10452s;     // Catch: Throwable -> L12
        long r17 = r16.f10457a;     // Catch: Throwable -> L12
        if (r17 == Long.MIN_VALUE) goto L59;
        long r18 = r16.f10458b;     // Catch: Throwable -> L12
        if (r18 == Long.MAX_VALUE) goto L59;
        if (r17 >= r18) goto L59;
        if (this.f10445m <= r17) goto L59;
        c r19 = new c(this, Long.MIN_VALUE, Long.MAX_VALUE);     // Catch: Throwable -> L12
        Iterator r20 = this.f10451r.entrySet().iterator();     // Catch: Throwable -> L12
    L28:
        if (r20.hasNext() == false) goto L46;
        c r21 = (c) ((Map.Entry) r20.next()).getValue();     // Catch: Throwable -> L12
        o0.a.c("mergeVideoRange  item range=" + r21);     // Catch: Throwable -> L12
        long r22 = r21.f10457a;     // Catch: Throwable -> L12
        c r23 = this.f10452s;     // Catch: Throwable -> L12
        long r110 = r23.f10458b;     // Catch: Throwable -> L12
        if (r22 > r110) goto L31;
        if (r22 > r110) goto L37;
        long r111 = r21.f10458b;     // Catch: Throwable -> L12
        if (r111 < r110) goto L37;
        r19.f10458b = r111;     // Catch: Throwable -> L12
    L37:
        long r112 = r21.f10458b;     // Catch: Throwable -> L12
        long r113 = r23.f10457a;     // Catch: Throwable -> L12
        if (r112 < r113) goto L43;
        if (r22 > r113) goto L43;
        r19.f10457a = r22;     // Catch: Throwable -> L12
    L43:
        if (r112 >= r113) goto L28;
        r19.f10457a = r113;     // Catch: Throwable -> L12
        goto L28
    L31:
        r19.f10458b = r110;     // Catch: Throwable -> L12
    L46:
        if (r19.f10457a != Long.MIN_VALUE) goto L49;
        r19.f10457a = this.f10452s.f10457a;     // Catch: Throwable -> L12
    L49:
        if (r19.f10458b != Long.MAX_VALUE) goto L51;
        r19.f10458b = this.f10452s.f10458b;     // Catch: Throwable -> L12
    L51:
        o0.a.c("finalRange = " + r19);     // Catch: Throwable -> L12
        this.f10451r.put(Long.valueOf(r19.f10457a), r19);     // Catch: Throwable -> L12
        Iterator r24 = this.f10451r.entrySet().iterator();     // Catch: Throwable -> L12
        LinkedHashMap r25 = new LinkedHashMap();     // Catch: Throwable -> L12
    L53:
        if (r24.hasNext() == false) goto L57;
        c r26 = (c) ((Map.Entry) r24.next()).getValue();     // Catch: Throwable -> L12
        if (t(r19, r26) == true) goto L53;
        r25.put(Long.valueOf(r26.f10457a), r26);     // Catch: Throwable -> L12
        goto L53
    L57:
        this.f10451r.clear();     // Catch: Throwable -> L12
        this.f10451r.putAll(r25);     // Catch: Throwable -> L12
    L59:
        monitor-exit(this);
    }
}
