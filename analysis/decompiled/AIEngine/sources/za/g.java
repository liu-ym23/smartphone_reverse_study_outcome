package za;

import cb.j;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.database.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import lb.n;
import za.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements e<DownloadInfo> {

    /* renamed from: a, reason: collision with root package name */
    public final e<DownloadInfo> f14303a;

    /* renamed from: b, reason: collision with root package name */
    public final hb.c f14304b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14305c = new Object();

    public g(e<DownloadInfo> eVar) {
        this.f14303a = eVar;
        this.f14304b = eVar.t();
    }

    @Override // za.e
    public final List<DownloadInfo> B(PrioritySort prioritySort) {
        List<T> listB;
        kotlin.jvm.internal.g.f(prioritySort, "prioritySort");
        synchronized (this.f14305c) {
            listB = this.f14303a.B(prioritySort);
        }
        return listB;
    }

    @Override // za.e
    public final long V(boolean z) {
        long jV;
        synchronized (this.f14305c) {
            jV = this.f14303a.V(z);
        }
        return jV;
    }

    @Override // za.e
    public final void b(DownloadInfo downloadInfo) {
        synchronized (this.f14305c) {
            this.f14303a.b(downloadInfo);
            n nVar = n.f10413a;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f14305c) {
            this.f14303a.close();
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final void d(DownloadInfo downloadInfo) {
        kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
        synchronized (this.f14305c) {
            this.f14303a.d(downloadInfo);
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final Pair<DownloadInfo, Boolean> e(DownloadInfo downloadInfo) {
        Pair<T, Boolean> pairE;
        synchronized (this.f14305c) {
            pairE = this.f14303a.e(downloadInfo);
        }
        return pairE;
    }

    @Override // za.e
    public final DownloadInfo e0() {
        return this.f14303a.e0();
    }

    @Override // za.e
    public final List<DownloadInfo> f(int i10) {
        List<T> listF;
        synchronized (this.f14305c) {
            listF = this.f14303a.f(i10);
        }
        return listF;
    }

    @Override // za.e
    public final void g(List<? extends DownloadInfo> downloadInfoList) {
        kotlin.jvm.internal.g.f(downloadInfoList, "downloadInfoList");
        synchronized (this.f14305c) {
            this.f14303a.g(downloadInfoList);
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final List<DownloadInfo> i(List<Integer> ids) {
        List<T> listI;
        kotlin.jvm.internal.g.f(ids, "ids");
        synchronized (this.f14305c) {
            listI = this.f14303a.i(ids);
        }
        return listI;
    }

    @Override // za.e
    public final void i0(DownloadInfo downloadInfo) {
        kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
        synchronized (this.f14305c) {
            this.f14303a.i0(downloadInfo);
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final e.a<DownloadInfo> j() {
        e.a<T> aVarJ;
        synchronized (this.f14305c) {
            aVarJ = this.f14303a.j();
        }
        return aVarJ;
    }

    @Override // za.e
    public final DownloadInfo k(String file) {
        DownloadInfo downloadInfoK;
        kotlin.jvm.internal.g.f(file, "file");
        synchronized (this.f14305c) {
            downloadInfoK = this.f14303a.k(file);
        }
        return downloadInfoK;
    }

    @Override // za.e
    public final void k0(j.b.a aVar) {
        synchronized (this.f14305c) {
            this.f14303a.k0(aVar);
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final void m() {
        synchronized (this.f14305c) {
            this.f14303a.m();
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final void m0(ArrayList arrayList) {
        synchronized (this.f14305c) {
            this.f14303a.m0(arrayList);
            n nVar = n.f10413a;
        }
    }

    @Override // za.e
    public final hb.c t() {
        return this.f14304b;
    }
}
