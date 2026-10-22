package bb;

import androidx.appcompat.app.l;
import androidx.datastore.preferences.protobuf.b1;
import androidx.lifecycle.j0;
import bb.b;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.Downloader;
import hb.e;
import hb.f;
import hb.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements b {
    public volatile Exception A;
    public List<e> B;
    public i C;
    public int D;
    public final stepos.support.v7.app.palette.b E;

    /* renamed from: a, reason: collision with root package name */
    public final Download f3176a;

    /* renamed from: b, reason: collision with root package name */
    public final Downloader<?, ?> f3177b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3178c;

    /* renamed from: d, reason: collision with root package name */
    public final hb.c f3179d;

    /* renamed from: e, reason: collision with root package name */
    public final fb.b f3180e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final String f3181j;

    /* renamed from: k, reason: collision with root package name */
    public final com.tonyodev.fetch2core.d f3182k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3183l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f3184m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f3185n;

    /* renamed from: o, reason: collision with root package name */
    public db.a f3186o;

    /* renamed from: p, reason: collision with root package name */
    public final lb.d f3187p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f3188q;
    public volatile long r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f3189s;

    /* renamed from: t, reason: collision with root package name */
    public double f3190t;

    /* renamed from: u, reason: collision with root package name */
    public final hb.a f3191u;

    /* renamed from: v, reason: collision with root package name */
    public long f3192v;

    /* renamed from: w, reason: collision with root package name */
    public ExecutorService f3193w;

    /* renamed from: x, reason: collision with root package name */
    public volatile int f3194x;

    /* renamed from: y, reason: collision with root package name */
    public int f3195y;
    public final Object z;

    public c(Download download, Downloader downloader, long j10, hb.c logger, fb.b bVar, boolean z, String fileTempDir, com.tonyodev.fetch2core.d storageResolver, boolean z3) {
        g.f(downloader, "downloader");
        g.f(logger, "logger");
        g.f(fileTempDir, "fileTempDir");
        g.f(storageResolver, "storageResolver");
        this.f3176a = download;
        this.f3177b = downloader;
        this.f3178c = j10;
        this.f3179d = logger;
        this.f3180e = bVar;
        this.h = z;
        this.f3181j = fileTempDir;
        this.f3182k = storageResolver;
        this.f3183l = z3;
        this.f3187p = kotlin.b.b(new j0(this, 2));
        this.r = -1L;
        this.f3191u = new hb.a();
        this.f3192v = -1L;
        this.z = new Object();
        this.B = EmptyList.f10001a;
        this.E = new stepos.support.v7.app.palette.b(this, 3);
    }

    @Override // bb.b
    public final void C() {
        db.a aVar = this.f3186o;
        if (aVar == null) {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f8435e = true;
        }
        this.f3185n = true;
    }

    @Override // bb.b
    public final DownloadInfo P() {
        d().setDownloaded(this.f3188q);
        d().setTotal(this.r);
        return d();
    }

    @Override // bb.b
    public final void S(db.a aVar) {
        this.f3186o = aVar;
    }

    public final void a(Downloader.b bVar, ArrayList arrayList) {
        int i10 = 0;
        this.f3194x = 0;
        this.f3195y = arrayList.size();
        if (!this.f3182k.b(bVar.f8214c)) {
            this.f3182k.e(bVar.f8214c, this.f3176a.getEnqueueAction() == EnqueueAction.f8149d);
        }
        if (this.f3183l) {
            this.f3182k.f(d().getTotal(), bVar.f8214c);
        }
        i iVarA = this.f3182k.a(bVar);
        this.C = iVarA;
        iVarA.a(0L);
        int size = arrayList.size();
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            e eVar = (e) obj;
            if (this.f3184m || this.f3185n) {
                return;
            }
            ExecutorService executorService = this.f3193w;
            if (executorService != null) {
                executorService.execute(new l(2, this, eVar));
            }
        }
    }

    public final long b() {
        double d8 = this.f3190t;
        if (d8 < 1.0d) {
            return 0L;
        }
        return (long) Math.ceil(d8);
    }

    public final b.a c() {
        return this.f3186o;
    }

    @Override // bb.b
    public final void c0() {
        db.a aVar = this.f3186o;
        if (aVar == null) {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f8435e = true;
        }
        this.f3184m = true;
    }

    public final DownloadInfo d() {
        return (DownloadInfo) this.f3187p.getValue();
    }

    public final List<e> e(boolean z, Downloader.b bVar) throws IOException {
        Long l10;
        if (!this.f3182k.b(d().getFile())) {
            gb.c.a(d().getId(), this.f3181j);
        }
        int id2 = d().getId();
        String fileTempDir = this.f3181j;
        g.f(fileTempDir, "fileTempDir");
        int iLongValue = -1;
        try {
            Long l11 = com.tonyodev.fetch2core.b.l(gb.c.c(id2, fileTempDir));
            if (l11 != null) {
                iLongValue = (int) l11.longValue();
            }
        } catch (Exception unused) {
        }
        long jLongValue = 0;
        if (!z || this.f3189s) {
            if (iLongValue != 1) {
                gb.c.a(d().getId(), this.f3181j);
            }
            gb.c.g(d().getId(), 1, this.f3181j);
            int id3 = d().getId();
            long j10 = this.r;
            int id4 = d().getId();
            String fileTempDir2 = this.f3181j;
            g.f(fileTempDir2, "fileTempDir");
            try {
                Long l12 = com.tonyodev.fetch2core.b.l(gb.c.b(id4, 1, fileTempDir2));
                if (l12 != null) {
                    jLongValue = l12.longValue();
                }
            } catch (Exception unused2) {
            }
            e eVar = new e(id3, 1, 0L, j10, jLongValue);
            this.f3188q += eVar.f9392e;
            return b1.P(eVar);
        }
        this.f3177b.G(bVar);
        long j11 = this.r;
        float f8 = (j11 / 1024.0f) * 1024.0f;
        f fVar = 1024.0f * f8 >= 1.0f ? new f(6, (long) Math.ceil(r8 / 6)) : f8 >= 1.0f ? new f(4, (long) Math.ceil(r8 / 4)) : new f(2, j11);
        if (iLongValue != fVar.f9393a) {
            gb.c.a(d().getId(), this.f3181j);
        }
        gb.c.g(d().getId(), fVar.f9393a, this.f3181j);
        ArrayList arrayList = new ArrayList();
        int i10 = fVar.f9393a;
        if (1 > i10) {
            return arrayList;
        }
        long j12 = 0;
        int i11 = 1;
        while (!this.f3184m && !this.f3185n) {
            long j13 = fVar.f9393a == i11 ? this.r : fVar.f9394b + j12;
            int id5 = d().getId();
            int id6 = d().getId();
            String fileTempDir3 = this.f3181j;
            g.f(fileTempDir3, "fileTempDir");
            try {
                l10 = com.tonyodev.fetch2core.b.l(gb.c.b(id6, i11, fileTempDir3));
            } catch (Exception unused3) {
            }
            long jLongValue2 = l10 != null ? l10.longValue() : 0L;
            e eVar2 = new e(id5, i11, j12, j13, jLongValue2);
            this.f3188q += eVar2.f9392e;
            arrayList.add(eVar2);
            if (i11 == i10) {
                return arrayList;
            }
            i11++;
            j12 = j13;
        }
        return arrayList;
    }

    public final boolean f() {
        return this.f3185n;
    }

    public final void g() {
        synchronized (this.z) {
            this.f3194x++;
            n nVar = n.f10413a;
        }
    }

    public final boolean h() {
        return ((this.f3188q > 0 && this.r > 0) || this.f3189s) && this.f3188q >= this.r;
    }

    public final void i(Downloader.a aVar) {
        if (aVar.f8207b && aVar.f8208c == -1) {
            this.f3189s = true;
        }
    }

    public final void j() throws InterruptedException {
        long j10 = this.f3188q;
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        while (this.f3194x != this.f3195y && !this.f3184m && !this.f3185n) {
            d().setDownloaded(this.f3188q);
            d().setTotal(this.r);
            boolean zO = com.tonyodev.fetch2core.b.o(jNanoTime2, System.nanoTime(), 1000L);
            long j11 = jNanoTime2;
            if (zO) {
                this.f3191u.a(this.f3188q - j10);
                this.f3190t = hb.a.b(this.f3191u);
                this.f3192v = com.tonyodev.fetch2core.b.b(this.f3188q, this.r, b());
                j10 = this.f3188q;
            }
            if (com.tonyodev.fetch2core.b.o(jNanoTime, System.nanoTime(), this.f3178c)) {
                synchronized (this.z) {
                    try {
                        if (!this.f3184m && !this.f3185n) {
                            d().setDownloaded(this.f3188q);
                            d().setTotal(this.r);
                            db.a aVar = this.f3186o;
                            if (aVar != null) {
                                aVar.g(d());
                            }
                            d().setEtaInMilliSeconds(this.f3192v);
                            d().setDownloadedBytesPerSecond(b());
                            db.a aVar2 = this.f3186o;
                            if (aVar2 != null) {
                                aVar2.e(d(), d().getEtaInMilliSeconds(), d().getDownloadedBytesPerSecond());
                            }
                        }
                        n nVar = n.f10413a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                jNanoTime = System.nanoTime();
            }
            jNanoTime2 = zO ? System.nanoTime() : j11;
            try {
                Thread.sleep(this.f3178c);
            } catch (InterruptedException e10) {
                this.f3179d.b("FileDownloader", e10);
            }
        }
    }

    @Override // bb.b
    public final boolean o() {
        return this.f3184m;
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x03e8 A[Catch: all -> 0x0049, TryCatch #5 {all -> 0x0049, blocks: (B:3:0x0008, B:5:0x0045, B:11:0x0053, B:14:0x005d, B:17:0x0065, B:19:0x0069, B:21:0x0073, B:24:0x007a, B:25:0x007f, B:26:0x0080, B:27:0x00a4, B:31:0x00b0, B:32:0x00bb, B:34:0x00c1, B:36:0x00ce, B:37:0x00d2, B:39:0x00d8, B:41:0x00de, B:42:0x0101, B:44:0x0107, B:45:0x0137, B:47:0x013d, B:49:0x0143, B:51:0x0157, B:52:0x0162, B:54:0x0169, B:56:0x0177, B:58:0x017d, B:169:0x0391, B:171:0x0397, B:173:0x039d, B:175:0x03bf, B:180:0x03cf, B:181:0x03d2, B:189:0x03e8, B:184:0x03db, B:186:0x03df, B:190:0x03ea, B:192:0x0409, B:194:0x040f, B:196:0x0423, B:63:0x018d, B:65:0x0195, B:66:0x019f, B:100:0x0214, B:102:0x022a, B:104:0x0230, B:106:0x0236, B:108:0x023c, B:110:0x0242, B:111:0x024b, B:113:0x0265, B:114:0x0281, B:116:0x0287, B:118:0x028d, B:120:0x0293, B:122:0x0297, B:123:0x029d, B:125:0x02a3, B:126:0x02ad, B:128:0x02b3, B:131:0x02c1, B:133:0x02d8, B:135:0x02de, B:137:0x02e4, B:139:0x02ea, B:140:0x02f3, B:142:0x0306, B:144:0x030c, B:146:0x032e, B:147:0x0348, B:149:0x035c, B:132:0x02c2, B:168:0x0390, B:30:0x00ab, B:70:0x01bf, B:72:0x01c5, B:74:0x01cb, B:77:0x01d2, B:78:0x01d7, B:80:0x01da, B:82:0x01de, B:84:0x01e4, B:86:0x01ea, B:89:0x01f1, B:90:0x01f8, B:91:0x01f9, B:93:0x01ff, B:95:0x0205, B:98:0x020c, B:99:0x0213), top: B:243:0x0008, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0423 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #5 {all -> 0x0049, blocks: (B:3:0x0008, B:5:0x0045, B:11:0x0053, B:14:0x005d, B:17:0x0065, B:19:0x0069, B:21:0x0073, B:24:0x007a, B:25:0x007f, B:26:0x0080, B:27:0x00a4, B:31:0x00b0, B:32:0x00bb, B:34:0x00c1, B:36:0x00ce, B:37:0x00d2, B:39:0x00d8, B:41:0x00de, B:42:0x0101, B:44:0x0107, B:45:0x0137, B:47:0x013d, B:49:0x0143, B:51:0x0157, B:52:0x0162, B:54:0x0169, B:56:0x0177, B:58:0x017d, B:169:0x0391, B:171:0x0397, B:173:0x039d, B:175:0x03bf, B:180:0x03cf, B:181:0x03d2, B:189:0x03e8, B:184:0x03db, B:186:0x03df, B:190:0x03ea, B:192:0x0409, B:194:0x040f, B:196:0x0423, B:63:0x018d, B:65:0x0195, B:66:0x019f, B:100:0x0214, B:102:0x022a, B:104:0x0230, B:106:0x0236, B:108:0x023c, B:110:0x0242, B:111:0x024b, B:113:0x0265, B:114:0x0281, B:116:0x0287, B:118:0x028d, B:120:0x0293, B:122:0x0297, B:123:0x029d, B:125:0x02a3, B:126:0x02ad, B:128:0x02b3, B:131:0x02c1, B:133:0x02d8, B:135:0x02de, B:137:0x02e4, B:139:0x02ea, B:140:0x02f3, B:142:0x0306, B:144:0x030c, B:146:0x032e, B:147:0x0348, B:149:0x035c, B:132:0x02c2, B:168:0x0390, B:30:0x00ab, B:70:0x01bf, B:72:0x01c5, B:74:0x01cb, B:77:0x01d2, B:78:0x01d7, B:80:0x01da, B:82:0x01de, B:84:0x01e4, B:86:0x01ea, B:89:0x01f1, B:90:0x01f8, B:91:0x01f9, B:93:0x01ff, B:95:0x0205, B:98:0x020c, B:99:0x0213), top: B:243:0x0008, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0430 A[Catch: Exception -> 0x0434, TRY_LEAVE, TryCatch #6 {Exception -> 0x0434, blocks: (B:197:0x042c, B:199:0x0430), top: B:244:0x042c }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x043e A[Catch: Exception -> 0x0442, TRY_LEAVE, TryCatch #13 {Exception -> 0x0442, blocks: (B:203:0x043a, B:205:0x043e), top: B:257:0x043a }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x044a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1155
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.c.run():void");
    }
}
