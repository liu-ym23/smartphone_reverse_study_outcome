package bb;

import androidx.appcompat.widget.l;
import cb.v;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.exception.FetchException;
import com.tonyodev.fetch2core.Downloader;
import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Downloader<?, ?> f3157a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3158b;

    /* renamed from: c, reason: collision with root package name */
    public final hb.c f3159c;

    /* renamed from: d, reason: collision with root package name */
    public final fb.b f3160d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3161e;
    public final stepos.support.v7.app.palette.b h;

    /* renamed from: j, reason: collision with root package name */
    public final l f3162j;

    /* renamed from: k, reason: collision with root package name */
    public final v f3163k;

    /* renamed from: l, reason: collision with root package name */
    public final com.tonyodev.fetch2core.c f3164l;

    /* renamed from: m, reason: collision with root package name */
    public final com.tonyodev.fetch2core.d f3165m;

    /* renamed from: n, reason: collision with root package name */
    public final String f3166n;

    /* renamed from: o, reason: collision with root package name */
    public final fb.a f3167o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3168p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3169q;
    public final Object r;

    /* renamed from: s, reason: collision with root package name */
    public final ExecutorService f3170s;

    /* renamed from: t, reason: collision with root package name */
    public db.b f3171t;

    /* renamed from: u, reason: collision with root package name */
    public volatile int f3172u;

    /* renamed from: v, reason: collision with root package name */
    public final HashMap<Integer, b> f3173v;

    /* renamed from: w, reason: collision with root package name */
    public volatile int f3174w;

    /* renamed from: x, reason: collision with root package name */
    public volatile boolean f3175x;

    public a(jb.a httpDownloader, int i10, long j10, hb.c logger, fb.b bVar, boolean z, stepos.support.v7.app.palette.b bVar2, l lVar, v vVar, com.tonyodev.fetch2core.c fileServerDownloader, com.tonyodev.fetch2core.a storageResolver, String namespace, fb.a aVar, int i11, boolean z3) {
        g.f(httpDownloader, "httpDownloader");
        g.f(logger, "logger");
        g.f(fileServerDownloader, "fileServerDownloader");
        g.f(storageResolver, "storageResolver");
        g.f(namespace, "namespace");
        this.f3157a = httpDownloader;
        this.f3158b = j10;
        this.f3159c = logger;
        this.f3160d = bVar;
        this.f3161e = z;
        this.h = bVar2;
        this.f3162j = lVar;
        this.f3163k = vVar;
        this.f3164l = fileServerDownloader;
        this.f3165m = storageResolver;
        this.f3166n = namespace;
        this.f3167o = aVar;
        this.f3168p = i11;
        this.f3169q = z3;
        this.r = new Object();
        this.f3170s = i10 > 0 ? Executors.newFixedThreadPool(i10) : null;
        this.f3172u = i10;
        this.f3173v = new HashMap<>();
    }

    public final boolean C(int i10) {
        if (this.f3175x) {
            throw new FetchException("DownloadManager is already shutdown.");
        }
        b bVar = this.f3173v.get(Integer.valueOf(i10));
        if (bVar != null) {
            bVar.c0();
            this.f3173v.remove(Integer.valueOf(i10));
            this.f3174w--;
            this.f3162j.o(i10);
            this.f3159c.a("DownloadManager cancelled download " + bVar.P());
            return bVar.o();
        }
        l lVar = this.f3162j;
        synchronized (lVar.f887g) {
            try {
                b bVar2 = (b) ((LinkedHashMap) lVar.h).get(Integer.valueOf(i10));
                if (bVar2 != null) {
                    bVar2.c0();
                    ((LinkedHashMap) lVar.h).remove(Integer.valueOf(i10));
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean K(int r3) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.r
            monitor-enter(r0)
            boolean r1 = r2.f3175x     // Catch: java.lang.Throwable -> L20
            if (r1 != 0) goto L22
            androidx.appcompat.widget.l r2 = r2.f3162j     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r2.f887g     // Catch: java.lang.Throwable -> L20
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.Object r2 = r2.h     // Catch: java.lang.Throwable -> L1d
            java.util.LinkedHashMap r2 = (java.util.LinkedHashMap) r2     // Catch: java.lang.Throwable -> L1d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L1d
            boolean r2 = r2.containsKey(r3)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L22
            r2 = 1
            goto L23
        L1d:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L20
            throw r2     // Catch: java.lang.Throwable -> L20
        L20:
            r2 = move-exception
            goto L25
        L22:
            r2 = 0
        L23:
            monitor-exit(r0)
            return r2
        L25:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.a.K(int):boolean");
    }

    public final b P(Download download, Downloader<?, ?> downloader) {
        Downloader.b bVarD = gb.c.d(download, "GET");
        downloader.L(bVarD);
        Downloader.FileDownloaderType fileDownloaderTypeQ0 = downloader.q0(bVarD, downloader.y0(bVarD));
        Downloader.FileDownloaderType fileDownloaderType = Downloader.FileDownloaderType.f8203a;
        fb.b bVar = this.f3160d;
        if (fileDownloaderTypeQ0 == fileDownloaderType) {
            return new d(download, downloader, this.f3158b, this.f3159c, bVar, this.f3161e, this.f3165m, this.f3169q);
        }
        return new c(download, downloader, this.f3158b, this.f3159c, bVar, this.f3161e, this.f3165m.c(bVarD), this.f3165m, this.f3169q);
    }

    public final void Q(Download download) {
        synchronized (this.r) {
            try {
                if (this.f3173v.containsKey(Integer.valueOf(download.getId()))) {
                    this.f3173v.remove(Integer.valueOf(download.getId()));
                    this.f3174w--;
                }
                this.f3162j.o(download.getId());
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void S() {
        for (Map.Entry<Integer, b> entry : this.f3173v.entrySet()) {
            b value = entry.getValue();
            if (value != null) {
                value.C();
                this.f3159c.a("DownloadManager terminated download " + value.P());
                this.f3162j.o(entry.getKey().intValue());
            }
        }
        this.f3173v.clear();
        this.f3174w = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.r
            monitor-enter(r0)
            boolean r1 = r2.f3175x     // Catch: java.lang.Throwable -> Lf
            if (r1 != 0) goto L11
            int r1 = r2.f3174w     // Catch: java.lang.Throwable -> Lf
            int r2 = r2.f3172u     // Catch: java.lang.Throwable -> Lf
            if (r1 >= r2) goto L11
            r2 = 1
            goto L12
        Lf:
            r2 = move-exception
            goto L14
        L11:
            r2 = 0
        L12:
            monitor-exit(r0)
            return r2
        L14:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.a.a():boolean");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.r) {
            try {
                if (this.f3175x) {
                    return;
                }
                this.f3175x = true;
                if (this.f3172u > 0) {
                    S();
                }
                this.f3159c.a("DownloadManager closing download manager");
                try {
                    ExecutorService executorService = this.f3170s;
                    if (executorService != null) {
                        executorService.shutdown();
                        n nVar = n.f10413a;
                    }
                } catch (Exception unused) {
                    n nVar2 = n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o() {
        synchronized (this.r) {
            if (this.f3175x) {
                throw new FetchException("DownloadManager is already shutdown.");
            }
            w();
            n nVar = n.f10413a;
        }
    }

    public final void w() {
        List<b> listO0;
        if (this.f3172u > 0) {
            l lVar = this.f3162j;
            synchronized (lVar.f887g) {
                listO0 = kotlin.collections.a.O0(((LinkedHashMap) lVar.h).values());
            }
            for (b bVar : listO0) {
                if (bVar != null) {
                    bVar.c0();
                    this.f3162j.o(bVar.P().getId());
                    this.f3159c.a("DownloadManager cancelled download " + bVar.P());
                }
            }
        }
        this.f3173v.clear();
        this.f3174w = 0;
    }
}
