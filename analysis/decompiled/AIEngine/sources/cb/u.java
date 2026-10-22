package cb;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2core.DownloadBlock;
import com.tonyodev.fetch2core.Reason;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u implements ya.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f3401a;

    public u(v vVar) {
        this.f3401a = vVar;
    }

    @Override // ya.f
    public final void onAdded(Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new k(fVar, download, 4));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8218a);
                } else {
                    int group = download.getGroup();
                    eb.a aVarC = vVar.f3402a.c(group, download, Reason.f8218a);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                vVar.f3403b.post(new androidx.room.o(dVar, group, download, aVarC));
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new p(dVar2, download, 1));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onCancelled(Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new n(vVar, download, 4));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new o(fVar, download, 1));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8226m);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8226m);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.b();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new p(dVar2, download, 2));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onCompleted(Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new n(vVar, download, 0));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new o(fVar, download, 0));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.h);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.h);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.l();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new p(dVar2, download, 0));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onDeleted(Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new l(vVar, download, 1));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new k(fVar, download, 2));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8227n);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8227n);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.e();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download, 1));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onDownloadBlockUpdated(Download download, DownloadBlock downloadBlock, int i10) {
        kotlin.jvm.internal.g.f(download, "download");
        kotlin.jvm.internal.g.f(downloadBlock, "downloadBlock");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            fVar.onDownloadBlockUpdated(download, downloadBlock, i10);
                        }
                    }
                }
                if (!vVar.f3406e.isEmpty()) {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8228o);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.i();
                            }
                        }
                    }
                }
                lb.n nVar = lb.n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onError(Download download, Error error, Throwable th) {
        kotlin.jvm.internal.g.f(download, "download");
        kotlin.jvm.internal.g.f(error, "error");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new n(vVar, download, 3));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            Download download2 = download;
                            Error error2 = error;
                            Throwable th2 = th;
                            vVar.f3403b.post(new s(fVar, download2, error2, th2, 0));
                            download = download2;
                            error = error2;
                            th = th2;
                        }
                    }
                }
                Download download3 = download;
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download3.getGroup(), download3, Reason.f8223j);
                } else {
                    vVar.f3402a.c(download3.getGroup(), download3, Reason.f8223j);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.a();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download3.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download3, 6));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // ya.f
    public final void onPaused(Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new l(vVar, download, 0));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new k(fVar, download, 1));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8224k);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8224k);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.k();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download, 0));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onProgress(final Download download, final long j10, final long j11) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new l(vVar, download, 2));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        final ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new Runnable() { // from class: cb.q
                                @Override // java.lang.Runnable
                                public final void run() {
                                    fVar.onProgress(download, j10, j11);
                                }
                            });
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8222e);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8222e);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.c();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download, 4));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onQueued(Download download, boolean z) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new t(fVar, download, z));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8219b);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8219b);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.h();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new p(dVar2, download, 3));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onResumed(Download download) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new n(vVar, download, 1));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new k(fVar, download, 3));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8225l);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8225l);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.g();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download, 3));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onStarted(Download download, List<? extends DownloadBlock> list, int i10) {
        kotlin.jvm.internal.g.f(download, "download");
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                vVar.f3408g.post(new n(vVar, download, 2));
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new r(fVar, download, list, i10));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8220c);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8220c);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.f();
                            }
                        }
                    }
                }
                List list2 = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list2 != null) {
                    Iterator it5 = list2.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download, 5));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ya.f
    public final void onWaitingNetwork(Download download) {
        v vVar = this.f3401a;
        synchronized (vVar.f3404c) {
            try {
                Iterator it = vVar.f3405d.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Set) it.next()).iterator();
                    while (it2.hasNext()) {
                        ya.f fVar = (ya.f) ((WeakReference) it2.next()).get();
                        if (fVar == null) {
                            it2.remove();
                        } else {
                            vVar.f3403b.post(new k(fVar, download, 0));
                        }
                    }
                }
                if (vVar.f3406e.isEmpty()) {
                    vVar.f3402a.d(download.getGroup(), download, Reason.f8221d);
                } else {
                    vVar.f3402a.c(download.getGroup(), download, Reason.f8221d);
                    Iterator it3 = vVar.f3406e.values().iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = ((Set) it3.next()).iterator();
                        while (it4.hasNext()) {
                            ya.d dVar = (ya.d) ((WeakReference) it4.next()).get();
                            if (dVar == null) {
                                it4.remove();
                            } else {
                                dVar.d();
                            }
                        }
                    }
                }
                List list = (List) vVar.h.get(Integer.valueOf(download.getId()));
                if (list != null) {
                    Iterator it5 = list.iterator();
                    while (it5.hasNext()) {
                        hb.d dVar2 = (hb.d) ((WeakReference) it5.next()).get();
                        if (dVar2 != null) {
                            vVar.f3403b.post(new m(dVar2, download, 2));
                        }
                    }
                    lb.n nVar = lb.n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
