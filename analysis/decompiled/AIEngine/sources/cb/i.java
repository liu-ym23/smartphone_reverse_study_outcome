package cb;

import android.os.Handler;
import android.util.Log;
import androidx.appcompat.widget.z0;
import androidx.datastore.preferences.protobuf.b1;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.exception.FetchException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements ya.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3336a;

    /* renamed from: b, reason: collision with root package name */
    public final ya.b f3337b;

    /* renamed from: c, reason: collision with root package name */
    public final hb.g f3338c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f3339d;

    /* renamed from: e, reason: collision with root package name */
    public final a f3340e;

    /* renamed from: f, reason: collision with root package name */
    public final hb.c f3341f;

    /* renamed from: g, reason: collision with root package name */
    public final v f3342g;
    public final za.g h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f3343i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f3344j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f3345k;

    /* renamed from: l, reason: collision with root package name */
    public final z0 f3346l;

    public i(String namespace, ya.b bVar, hb.g gVar, Handler uiHandler, a fetchHandler, hb.c logger, v vVar, za.g gVar2) {
        kotlin.jvm.internal.g.f(namespace, "namespace");
        kotlin.jvm.internal.g.f(uiHandler, "uiHandler");
        kotlin.jvm.internal.g.f(fetchHandler, "fetchHandler");
        kotlin.jvm.internal.g.f(logger, "logger");
        this.f3336a = namespace;
        this.f3337b = bVar;
        this.f3338c = gVar;
        this.f3339d = uiHandler;
        this.f3340e = fetchHandler;
        this.f3341f = logger;
        this.f3342g = vVar;
        this.h = gVar2;
        this.f3343i = new Object();
        this.f3345k = new LinkedHashSet();
        z0 z0Var = new z0(this, 6);
        this.f3346l = z0Var;
        gVar.b(new h(this, 1));
        gVar.c(bVar.f14193o, z0Var);
    }

    @Override // ya.a
    public final i a(Request request, com.stepos.core.ota.downloader.a aVar, final com.stepos.core.ota.downloader.b bVar) {
        final List listP = b1.P(request);
        final e eVar = new e(this, bVar, aVar, 0);
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new zb.a() { // from class: cb.g
                @Override // zb.a
                public final Object invoke() {
                    ArrayList arrayList;
                    List list = listP;
                    i iVar = this;
                    Handler handler = iVar.f3339d;
                    hb.c cVar = iVar.f3341f;
                    e eVar2 = eVar;
                    try {
                        HashSet hashSet = new HashSet();
                        arrayList = new ArrayList();
                        for (Object obj : list) {
                            if (hashSet.add(((Request) obj).getFile())) {
                                arrayList.add(obj);
                            }
                        }
                    } catch (Exception e10) {
                        String message = "Failed to enqueue list " + list;
                        cVar.getClass();
                        kotlin.jvm.internal.g.f(message, "message");
                        if (cVar.f9386a) {
                            Log.e(cVar.c(), message);
                        }
                        handler.post(new androidx.room.o(3, bVar, y.x(e10.getMessage())));
                    }
                    if (arrayList.size() != list.size()) {
                        throw new FetchException("request_list_not_distinct");
                    }
                    a aVar2 = iVar.f3340e;
                    u uVar = iVar.f3342g.f3409i;
                    ArrayList arrayListB0 = aVar2.B0(list);
                    int size = arrayListB0.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj2 = arrayListB0.get(i10);
                        i10++;
                        Download download = (Download) ((Pair) obj2).f9985a;
                        int iOrdinal = download.getStatus().ordinal();
                        if (iOrdinal == 1) {
                            DownloadInfo downloadInfoE0 = iVar.h.f14303a.e0();
                            a4.a.w(download, downloadInfoE0);
                            downloadInfoE0.setStatus(Status.f8197o);
                            uVar.onAdded(downloadInfoE0);
                            cVar.a("Added " + download);
                            uVar.onQueued(download, false);
                            cVar.a("Queued " + download + " for download");
                        } else if (iOrdinal == 4) {
                            uVar.onCompleted(download);
                            cVar.a("Completed download " + download);
                        } else if (iOrdinal == 9) {
                            uVar.onAdded(download);
                            cVar.a("Added " + download);
                        }
                    }
                    handler.post(new androidx.appcompat.app.l(5, eVar2, arrayListB0));
                    return lb.n.f10413a;
                }
            });
            lb.n nVar = lb.n.f10413a;
        }
        return this;
    }

    @Override // ya.a
    public final i b(final int i10, final e eVar) {
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new zb.a() { // from class: cb.f
                @Override // zb.a
                public final Object invoke() {
                    i iVar = this.f3327a;
                    iVar.f3339d.post(new androidx.appcompat.app.l(3, eVar, iVar.f3340e.getDownloadsInGroup(i10)));
                    return lb.n.f10413a;
                }
            });
        }
        return this;
    }

    public final void c() {
        if (this.f3344j) {
            throw new FetchException("This fetch instance has been closed. Create a new instance using the builder.");
        }
    }

    @Override // ya.a
    public final i cancelGroup(int i10) {
        c cVar = new c(i10, 1, this);
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new android.llama.cpp.b(1, cVar, this));
        }
        return this;
    }

    @Override // ya.a
    public final void close() {
        synchronized (this.f3343i) {
            if (this.f3344j) {
                return;
            }
            this.f3344j = true;
            this.f3341f.a(this.f3336a + " closing/shutting down");
            this.f3338c.d(this.f3346l);
            this.f3338c.b(new h(this, 0));
            lb.n nVar = lb.n.f10413a;
        }
    }

    @Override // ya.a
    public final i deleteGroup(int i10) {
        c cVar = new c(i10, 0, this);
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new d(0, cVar, this));
        }
        return this;
    }

    @Override // ya.a
    public final i h(ya.f listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new d(this, listener, 2));
        }
        return this;
    }

    @Override // ya.a
    public final i pauseGroup(int i10) {
        Integer numValueOf = Integer.valueOf(i10);
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new android.llama.cpp.b(3, this, numValueOf));
            lb.n nVar = lb.n.f10413a;
        }
        return this;
    }

    @Override // ya.a
    public final i resumeGroup(int i10) {
        Integer numValueOf = Integer.valueOf(i10);
        synchronized (this.f3343i) {
            c();
            this.f3338c.b(new d(this, numValueOf, 1));
            lb.n nVar = lb.n.f10413a;
        }
        return this;
    }
}
