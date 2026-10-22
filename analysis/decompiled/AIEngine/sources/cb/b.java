package cb;

import android.os.Handler;
import android.os.Looper;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine$bridgeListener$1;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Request;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.exception.FetchException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import mb.y;
import za.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final String f3306a;

    /* renamed from: b, reason: collision with root package name */
    public final za.g f3307b;

    /* renamed from: c, reason: collision with root package name */
    public final bb.a f3308c;

    /* renamed from: d, reason: collision with root package name */
    public final db.d f3309d;

    /* renamed from: e, reason: collision with root package name */
    public final hb.c f3310e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final v f3311j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tonyodev.fetch2core.d f3312k;

    /* renamed from: l, reason: collision with root package name */
    public final PrioritySort f3313l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3314m;

    /* renamed from: n, reason: collision with root package name */
    public final int f3315n;

    /* renamed from: o, reason: collision with root package name */
    public final LinkedHashSet f3316o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f3317p;

    public b(String namespace, za.g gVar, bb.a aVar, db.d dVar, hb.c logger, boolean z, jb.a httpDownloader, com.tonyodev.fetch2core.c fileServerDownloader, v vVar, Handler uiHandler, com.tonyodev.fetch2core.a storageResolver, fb.a aVar2, PrioritySort prioritySort, boolean z3) {
        kotlin.jvm.internal.g.f(namespace, "namespace");
        kotlin.jvm.internal.g.f(logger, "logger");
        kotlin.jvm.internal.g.f(httpDownloader, "httpDownloader");
        kotlin.jvm.internal.g.f(fileServerDownloader, "fileServerDownloader");
        kotlin.jvm.internal.g.f(uiHandler, "uiHandler");
        kotlin.jvm.internal.g.f(storageResolver, "storageResolver");
        kotlin.jvm.internal.g.f(prioritySort, "prioritySort");
        this.f3306a = namespace;
        this.f3307b = gVar;
        this.f3308c = aVar;
        this.f3309d = dVar;
        this.f3310e = logger;
        this.h = z;
        this.f3311j = vVar;
        this.f3312k = storageResolver;
        this.f3313l = prioritySort;
        this.f3314m = z3;
        this.f3315n = UUID.randomUUID().hashCode();
        this.f3316o = new LinkedHashSet();
    }

    @Override // cb.a
    public final ArrayList B0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            za.g gVar = this.f3307b;
            DownloadInfo downloadInfo = gVar.f14303a.e0();
            kotlin.jvm.internal.g.f(request, "<this>");
            kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
            downloadInfo.setId(request.getId());
            downloadInfo.setUrl(request.getUrl());
            downloadInfo.setFile(request.getFile());
            downloadInfo.setPriority(request.getPriority());
            downloadInfo.setHeaders(kotlin.collections.b.n0(request.getHeaders()));
            downloadInfo.setGroup(request.getGroupId());
            downloadInfo.setNetworkType(request.getNetworkType());
            downloadInfo.setStatus(gb.b.f9101e);
            downloadInfo.setError(gb.b.f9100d);
            downloadInfo.setDownloaded(0L);
            downloadInfo.setTag(request.getTag());
            downloadInfo.setEnqueueAction(request.getEnqueueAction());
            downloadInfo.setIdentifier(request.getIdentifier());
            downloadInfo.setDownloadOnEnqueue(request.getDownloadOnEnqueue());
            downloadInfo.setExtras(request.getExtras());
            downloadInfo.setAutoRetryMaxAttempts(request.getAutoRetryMaxAttempts());
            downloadInfo.setAutoRetryAttempts(0);
            downloadInfo.setNamespace(this.f3306a);
            try {
                boolean zW = w(downloadInfo);
                if (downloadInfo.getStatus() != Status.f8192j) {
                    downloadInfo.setStatus(request.getDownloadOnEnqueue() ? Status.f8190d : Status.f8197o);
                    hb.c cVar = this.f3310e;
                    if (zW) {
                        gVar.d(downloadInfo);
                        cVar.a("Updated download " + downloadInfo);
                        arrayList.add(new Pair(downloadInfo, Error.f8155d));
                    } else {
                        Pair<DownloadInfo, Boolean> pairE = gVar.e(downloadInfo);
                        cVar.a("Enqueued download " + pairE.f9985a);
                        arrayList.add(new Pair(pairE.f9985a, Error.f8155d));
                        C();
                    }
                } else {
                    arrayList.add(new Pair(downloadInfo, Error.f8155d));
                }
                if (this.f3313l == PrioritySort.f8185b && !this.f3308c.a()) {
                    this.f3309d.w();
                }
            } catch (Exception e10) {
                arrayList.add(new Pair(downloadInfo, y.y(e10)));
            }
        }
        C();
        return arrayList;
    }

    public final void C() {
        db.d dVar = this.f3309d;
        synchronized (dVar.f8445m) {
            dVar.a(dVar.f8443k);
            lb.n nVar = lb.n.f10413a;
        }
        if (this.f3309d.f8448p && !this.f3317p) {
            this.f3309d.P();
        }
        if (!this.f3309d.f8447o || this.f3317p) {
            return;
        }
        db.d dVar2 = this.f3309d;
        synchronized (dVar2.f8445m) {
            dVar2.K();
            dVar2.f8447o = false;
            dVar2.f8448p = false;
            dVar2.C();
            dVar2.f8441e.a("PriorityIterator resumed");
        }
    }

    @Override // cb.a
    public final ArrayList O(int i10) {
        List<DownloadInfo> listF = this.f3307b.f(i10);
        a(listF);
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo download : listF) {
            kotlin.jvm.internal.g.f(download, "download");
            int iOrdinal = download.getStatus().ordinal();
            if (iOrdinal == 1 || iOrdinal == 2) {
                download.setStatus(Status.h);
                arrayList.add(download);
            }
        }
        this.f3307b.m0(arrayList);
        return arrayList;
    }

    @Override // cb.a
    public final boolean Z(boolean z) {
        if (kotlin.jvm.internal.g.b(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            throw new FetchException("blocking_call_on_ui_thread");
        }
        return this.f3307b.V(z) > 0;
    }

    public final void a(List<? extends DownloadInfo> list) {
        for (DownloadInfo downloadInfo : list) {
            bb.a aVar = this.f3308c;
            int id2 = downloadInfo.getId();
            synchronized (aVar.r) {
                aVar.C(id2);
            }
        }
    }

    @Override // cb.a
    public final ArrayList cancelGroup(int i10) {
        za.g gVar = this.f3307b;
        List<DownloadInfo> listF = gVar.f(i10);
        a(listF);
        ArrayList arrayList = new ArrayList();
        for (DownloadInfo download : listF) {
            kotlin.jvm.internal.g.f(download, "download");
            int iOrdinal = download.getStatus().ordinal();
            if (iOrdinal != 0 && iOrdinal != 4 && iOrdinal != 6) {
                download.setStatus(Status.f8193k);
                download.setError(gb.b.f9100d);
                arrayList.add(download);
            }
        }
        gVar.m0(arrayList);
        return arrayList;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f3317p) {
            return;
        }
        this.f3317p = true;
        synchronized (this.f3316o) {
            try {
                Iterator it = this.f3316o.iterator();
                while (it.hasNext()) {
                    this.f3311j.b(this.f3315n, (ya.f) it.next());
                }
                this.f3316o.clear();
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        db.d dVar = this.f3309d;
        synchronized (dVar.f8445m) {
            if (dVar.f8442j > 0) {
                dVar.f8437a.d(dVar.f8450s);
            }
            dVar.f8447o = false;
            dVar.f8448p = true;
            dVar.f8439c.o();
            dVar.f8441e.a("PriorityIterator stop");
        }
        this.f3309d.close();
        this.f3308c.close();
        Object obj = j.f3347a;
        j.a(this.f3306a);
    }

    @Override // cb.a
    public final List<Download> deleteGroup(int i10) {
        List<DownloadInfo> listF = this.f3307b.f(i10);
        o(listF);
        return listF;
    }

    @Override // cb.a
    public final List<Download> getDownloadsInGroup(int i10) {
        return this.f3307b.f(i10);
    }

    @Override // cb.a
    public final void h(ya.f listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        synchronized (this.f3316o) {
            try {
                Iterator it = this.f3316o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (kotlin.jvm.internal.g.b((ya.f) it.next(), listener)) {
                        it.remove();
                        this.f3310e.a("Removed listener " + listener);
                        break;
                    }
                }
                this.f3311j.b(this.f3315n, listener);
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(List list) {
        a(list);
        za.g gVar = this.f3307b;
        gVar.g(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DownloadInfo downloadInfo = (DownloadInfo) it.next();
            downloadInfo.setStatus(Status.f8196n);
            this.f3312k.d(downloadInfo.getFile());
            e.a<DownloadInfo> aVarJ = gVar.j();
            if (aVarJ != null) {
                aVarJ.a(downloadInfo);
            }
        }
    }

    @Override // cb.a
    public final void r0(Fetch2DownloadEngine$bridgeListener$1 fetch2DownloadEngine$bridgeListener$1) {
        synchronized (this.f3316o) {
            this.f3316o.add(fetch2DownloadEngine$bridgeListener$1);
        }
        v vVar = this.f3311j;
        int i10 = this.f3315n;
        synchronized (vVar.f3404c) {
            try {
                Set linkedHashSet = (Set) vVar.f3405d.get(Integer.valueOf(i10));
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(new WeakReference(fetch2DownloadEngine$bridgeListener$1));
                vVar.f3405d.put(Integer.valueOf(i10), linkedHashSet);
                if (fetch2DownloadEngine$bridgeListener$1 instanceof ya.d) {
                    Set linkedHashSet2 = (Set) vVar.f3406e.get(Integer.valueOf(i10));
                    if (linkedHashSet2 == null) {
                        linkedHashSet2 = new LinkedHashSet();
                    }
                    linkedHashSet2.add(new WeakReference(fetch2DownloadEngine$bridgeListener$1));
                    vVar.f3406e.put(Integer.valueOf(i10), linkedHashSet2);
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f3310e.a("Added listener " + fetch2DownloadEngine$bridgeListener$1);
    }

    @Override // cb.a
    public final ArrayList resumeGroup(int i10) {
        int iOrdinal;
        List<DownloadInfo> listF = this.f3307b.f(i10);
        ArrayList arrayList = new ArrayList(mb.m.Z(listF, 10));
        Iterator<T> it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((DownloadInfo) it.next()).getId()));
        }
        za.g gVar = this.f3307b;
        ArrayList arrayListR0 = kotlin.collections.a.r0(gVar.i(arrayList));
        ArrayList arrayList2 = new ArrayList();
        int size = arrayListR0.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayListR0.get(i11);
            i11++;
            DownloadInfo downloadInfo = (DownloadInfo) obj;
            if (!this.f3308c.K(downloadInfo.getId()) && ((iOrdinal = downloadInfo.getStatus().ordinal()) == 1 || iOrdinal == 3 || iOrdinal == 9)) {
                downloadInfo.setStatus(Status.f8190d);
                arrayList2.add(downloadInfo);
            }
        }
        gVar.m0(arrayList2);
        C();
        return arrayList2;
    }

    @Override // cb.a
    public final void t0() {
        this.f3307b.m();
        if (this.h) {
            this.f3309d.P();
        }
    }

    public final boolean w(DownloadInfo downloadInfo) {
        a(b1.P(downloadInfo));
        String file = downloadInfo.getFile();
        za.g gVar = this.f3307b;
        DownloadInfo downloadInfoK = gVar.k(file);
        boolean z = this.f3314m;
        com.tonyodev.fetch2core.d dVar = this.f3312k;
        if (downloadInfoK != null) {
            a(b1.P(downloadInfoK));
            downloadInfoK = gVar.k(downloadInfo.getFile());
            hb.c cVar = this.f3310e;
            if (downloadInfoK == null || downloadInfoK.getStatus() != Status.f8191e) {
                if ((downloadInfoK != null ? downloadInfoK.getStatus() : null) == Status.f8192j && downloadInfo.getEnqueueAction() == EnqueueAction.h && !dVar.b(downloadInfoK.getFile())) {
                    try {
                        gVar.b(downloadInfoK);
                    } catch (Exception e10) {
                        String message = e10.getMessage();
                        cVar.b(message != null ? message : "", e10);
                    }
                    if (downloadInfo.getEnqueueAction() != EnqueueAction.f8149d && z) {
                        dVar.e(downloadInfo.getFile(), false);
                    }
                    downloadInfoK = null;
                }
            } else {
                downloadInfoK.setStatus(Status.f8190d);
                try {
                    gVar.d(downloadInfoK);
                } catch (Exception e11) {
                    String message2 = e11.getMessage();
                    cVar.b(message2 != null ? message2 : "", e11);
                }
            }
        } else if (downloadInfo.getEnqueueAction() != EnqueueAction.f8149d && z) {
            dVar.e(downloadInfo.getFile(), false);
        }
        int iOrdinal = downloadInfo.getEnqueueAction().ordinal();
        if (iOrdinal == 0) {
            if (downloadInfoK != null) {
                o(b1.P(downloadInfoK));
            }
            o(b1.P(downloadInfo));
            return false;
        }
        if (iOrdinal == 1) {
            if (z) {
                dVar.e(downloadInfo.getFile(), true);
            }
            downloadInfo.setFile(downloadInfo.getFile());
            String url = downloadInfo.getUrl();
            String file2 = downloadInfo.getFile();
            kotlin.jvm.internal.g.f(url, "url");
            kotlin.jvm.internal.g.f(file2, "file");
            downloadInfo.setId(file2.hashCode() + (url.hashCode() * 31));
            return false;
        }
        if (iOrdinal == 2) {
            if (downloadInfoK == null) {
                return false;
            }
            throw new FetchException("request_with_file_path_already_exist");
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (downloadInfoK == null) {
            return false;
        }
        downloadInfo.setDownloaded(downloadInfoK.getDownloaded());
        downloadInfo.setTotal(downloadInfoK.getTotal());
        downloadInfo.setError(downloadInfoK.getError());
        downloadInfo.setStatus(downloadInfoK.getStatus());
        Status status = downloadInfo.getStatus();
        Status status2 = Status.f8192j;
        if (status != status2) {
            downloadInfo.setStatus(Status.f8190d);
            downloadInfo.setError(gb.b.f9100d);
        }
        if (downloadInfo.getStatus() == status2 && !dVar.b(downloadInfo.getFile())) {
            if (z) {
                dVar.e(downloadInfo.getFile(), false);
            }
            downloadInfo.setDownloaded(0L);
            downloadInfo.setTotal(-1L);
            downloadInfo.setStatus(Status.f8190d);
            downloadInfo.setError(gb.b.f9100d);
        }
        return true;
    }
}
