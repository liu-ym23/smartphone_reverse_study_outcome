package za;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.datastore.preferences.protobuf.b1;
import androidx.room.RoomDatabase;
import cb.j;
import cb.w;
import com.tonyodev.fetch2.PrioritySort;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadDatabase;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2.exception.FetchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import lb.n;
import za.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements e<DownloadInfo> {

    /* renamed from: a, reason: collision with root package name */
    public final hb.c f14294a;

    /* renamed from: b, reason: collision with root package name */
    public final w f14295b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tonyodev.fetch2core.a f14296c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f14297d;

    /* renamed from: e, reason: collision with root package name */
    public j.b.a f14298e;
    public final DownloadDatabase h;

    /* renamed from: j, reason: collision with root package name */
    public final y1.b f14299j;

    /* renamed from: k, reason: collision with root package name */
    public final String f14300k;

    /* renamed from: l, reason: collision with root package name */
    public final String f14301l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f14302m;

    public f(Context context, hb.c logger, ab.a[] aVarArr, w wVar, com.tonyodev.fetch2core.a aVar) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(logger, "logger");
        this.f14294a = logger;
        this.f14295b = wVar;
        this.f14296c = aVar;
        RoomDatabase.a aVarA = androidx.room.j.a(context, DownloadDatabase.class, "ota_model_download.db");
        aVarA.a((u1.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        DownloadDatabase downloadDatabase = (DownloadDatabase) aVarA.b();
        this.h = downloadDatabase;
        this.f14299j = downloadDatabase.h().n0();
        Status.a aVar2 = Status.f8188b;
        this.f14300k = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2'";
        this.f14301l = "SELECT _id FROM requests WHERE _status = '1' OR _status = '2' OR _status = '9'";
        this.f14302m = new ArrayList();
    }

    @Override // za.e
    public final List<DownloadInfo> B(PrioritySort prioritySort) {
        ArrayList arrayListT;
        kotlin.jvm.internal.g.f(prioritySort, "prioritySort");
        o();
        PrioritySort prioritySort2 = PrioritySort.f8184a;
        DownloadDatabase downloadDatabase = this.h;
        if (prioritySort == prioritySort2) {
            b bVarR = downloadDatabase.r();
            Status.a aVar = Status.f8188b;
            arrayListT = bVarR.s();
        } else {
            b bVarR2 = downloadDatabase.r();
            Status.a aVar2 = Status.f8188b;
            arrayListT = bVarR2.t();
        }
        int i10 = 0;
        if (!a(arrayListT, false)) {
            return arrayListT;
        }
        ArrayList arrayList = new ArrayList();
        int size = arrayListT.size();
        while (i10 < size) {
            Object obj = arrayListT.get(i10);
            i10++;
            if (((DownloadInfo) obj).getStatus() == Status.f8190d) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // za.e
    public final long V(boolean z) {
        try {
            Cursor cursorO0 = this.f14299j.o0(z ? this.f14301l : this.f14300k);
            long count = cursorO0.getCount();
            cursorO0.close();
            return count;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public final boolean a(List<? extends DownloadInfo> list, boolean z) {
        ArrayList arrayList = this.f14302m;
        arrayList.clear();
        for (DownloadInfo downloadInfo : list) {
            switch (downloadInfo.getStatus().ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                case 1:
                case 3:
                    if (downloadInfo.getDownloaded() <= 0 || this.f14296c.b(downloadInfo.getFile())) {
                        break;
                    } else {
                        downloadInfo.setDownloaded(0L);
                        downloadInfo.setTotal(-1L);
                        downloadInfo.setError(gb.b.f9100d);
                        arrayList.add(downloadInfo);
                        j.b.a aVar = this.f14298e;
                        if (aVar != null) {
                            aVar.a(downloadInfo);
                            break;
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    if (z) {
                        downloadInfo.setStatus((downloadInfo.getDownloaded() <= 0 || downloadInfo.getTotal() <= 0 || downloadInfo.getDownloaded() < downloadInfo.getTotal()) ? Status.f8190d : Status.f8192j);
                        downloadInfo.setError(gb.b.f9100d);
                        arrayList.add(downloadInfo);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    if (downloadInfo.getTotal() >= 1 || downloadInfo.getDownloaded() <= 0) {
                        break;
                    } else {
                        downloadInfo.setTotal(downloadInfo.getDownloaded());
                        downloadInfo.setError(gb.b.f9100d);
                        arrayList.add(downloadInfo);
                        break;
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            try {
                m0(arrayList);
            } catch (Exception e10) {
                this.f14294a.b("Failed to update", e10);
            }
        }
        arrayList.clear();
        return size > 0;
    }

    @Override // za.e
    public final void b(DownloadInfo downloadInfo) {
        o();
        this.h.r().b(downloadInfo);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f14297d) {
            return;
        }
        this.f14297d = true;
        try {
            this.f14299j.close();
        } catch (Exception unused) {
        }
        try {
            this.h.d();
        } catch (Exception unused2) {
        }
        this.f14294a.a("Database closed");
    }

    @Override // za.e
    public final void d(DownloadInfo downloadInfo) {
        kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
        o();
        this.h.r().d(downloadInfo);
    }

    @Override // za.e
    public final Pair<DownloadInfo, Boolean> e(DownloadInfo downloadInfo) {
        o();
        return new Pair<>(downloadInfo, Boolean.valueOf(this.h.r().e(downloadInfo) != -1));
    }

    @Override // za.e
    public final DownloadInfo e0() {
        return new DownloadInfo();
    }

    @Override // za.e
    public final List<DownloadInfo> f(int i10) {
        o();
        ArrayList arrayListF = this.h.r().f(i10);
        a(arrayListF, false);
        return arrayListF;
    }

    @Override // za.e
    public final void g(List<? extends DownloadInfo> downloadInfoList) {
        kotlin.jvm.internal.g.f(downloadInfoList, "downloadInfoList");
        o();
        this.h.r().g(downloadInfoList);
    }

    @Override // za.e
    public final List<DownloadInfo> i(List<Integer> ids) {
        kotlin.jvm.internal.g.f(ids, "ids");
        o();
        ArrayList arrayListI = this.h.r().i(ids);
        a(arrayListI, false);
        return arrayListI;
    }

    @Override // za.e
    public final void i0(DownloadInfo downloadInfo) {
        hb.c cVar = this.f14294a;
        y1.b bVar = this.f14299j;
        kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
        o();
        try {
            bVar.l();
            bVar.z("UPDATE requests SET _written_bytes = ?, _total_bytes = ?, _status = ? WHERE _id = ?", new Object[]{Long.valueOf(downloadInfo.getDownloaded()), Long.valueOf(downloadInfo.getTotal()), Integer.valueOf(downloadInfo.getStatus().f8199a), Integer.valueOf(downloadInfo.getId())});
            bVar.y();
        } catch (SQLiteException e10) {
            cVar.b("DatabaseManager exception", e10);
        }
        try {
            bVar.H();
        } catch (SQLiteException e11) {
            cVar.b("DatabaseManager exception", e11);
        }
    }

    @Override // za.e
    public final e.a<DownloadInfo> j() {
        return this.f14298e;
    }

    @Override // za.e
    public final DownloadInfo k(String file) {
        kotlin.jvm.internal.g.f(file, "file");
        o();
        DownloadInfo downloadInfoK = this.h.r().k(file);
        if (downloadInfoK == null) {
            return downloadInfoK;
        }
        a(b1.P(downloadInfoK), false);
        return downloadInfoK;
    }

    @Override // za.e
    public final void k0(j.b.a aVar) {
        this.f14298e = aVar;
    }

    @Override // za.e
    public final void m() {
        o();
        w wVar = this.f14295b;
        synchronized (wVar.f3410a) {
            if (!wVar.f3411b) {
                o();
                ArrayList arrayList = this.h.r().get();
                a(arrayList, false);
                a(arrayList, true);
                wVar.f3411b = true;
            }
            n nVar = n.f10413a;
            n nVar2 = n.f10413a;
        }
    }

    @Override // za.e
    public final void m0(ArrayList downloadInfoList) {
        kotlin.jvm.internal.g.f(downloadInfoList, "downloadInfoList");
        o();
        this.h.r().n(downloadInfoList);
    }

    public final void o() {
        if (this.f14297d) {
            throw new FetchException("ota_model_download database is closed");
        }
    }

    @Override // za.e
    public final hb.c t() {
        return this.f14294a;
    }
}
