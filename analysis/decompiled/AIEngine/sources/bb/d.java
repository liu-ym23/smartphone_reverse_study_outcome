package bb;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.database.DownloadInfo;
import com.tonyodev.fetch2core.DownloadBlockInfo;
import com.tonyodev.fetch2core.Downloader;
import hb.i;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Download f3196a;

    /* renamed from: b, reason: collision with root package name */
    public final Downloader<?, ?> f3197b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3198c;

    /* renamed from: d, reason: collision with root package name */
    public final hb.c f3199d;

    /* renamed from: e, reason: collision with root package name */
    public final fb.b f3200e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final com.tonyodev.fetch2core.d f3201j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3202k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f3203l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f3204m;

    /* renamed from: n, reason: collision with root package name */
    public db.a f3205n;

    /* renamed from: o, reason: collision with root package name */
    public volatile long f3206o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f3207p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f3208q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public final lb.d f3209s;

    /* renamed from: t, reason: collision with root package name */
    public double f3210t;

    /* renamed from: u, reason: collision with root package name */
    public final hb.a f3211u;

    /* renamed from: v, reason: collision with root package name */
    public final DownloadBlockInfo f3212v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3213w;

    /* renamed from: x, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f3214x;

    public d(Download download, Downloader downloader, long j10, hb.c logger, fb.b bVar, boolean z, com.tonyodev.fetch2core.d storageResolver, boolean z3) {
        g.f(downloader, "downloader");
        g.f(logger, "logger");
        g.f(storageResolver, "storageResolver");
        this.f3196a = download;
        this.f3197b = downloader;
        this.f3198c = j10;
        this.f3199d = logger;
        this.f3200e = bVar;
        this.h = z;
        this.f3201j = storageResolver;
        this.f3202k = z3;
        this.f3206o = -1L;
        this.r = -1L;
        this.f3209s = kotlin.b.b(new b6.g(this, 1));
        this.f3211u = new hb.a();
        DownloadBlockInfo downloadBlockInfo = new DownloadBlockInfo();
        downloadBlockInfo.setBlockPosition(1);
        downloadBlockInfo.setDownloadId(download.getId());
        this.f3212v = downloadBlockInfo;
        this.f3213w = 1;
        this.f3214x = new stepos.support.v7.app.palette.b(this, 4);
    }

    @Override // bb.b
    public final void C() {
        db.a aVar = this.f3205n;
        if (aVar == null) {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f8435e = true;
        }
        this.f3204m = true;
    }

    @Override // bb.b
    public final DownloadInfo P() {
        b().setDownloaded(this.f3208q);
        b().setTotal(this.f3206o);
        return b();
    }

    @Override // bb.b
    public final void S(db.a aVar) {
        this.f3205n = aVar;
    }

    public final long a() {
        double d8 = this.f3210t;
        if (d8 < 1.0d) {
            return 0L;
        }
        return (long) Math.ceil(d8);
    }

    public final DownloadInfo b() {
        return (DownloadInfo) this.f3209s.getValue();
    }

    public final Downloader.b c() {
        LinkedHashMap linkedHashMapO0 = kotlin.collections.b.o0(this.f3196a.getHeaders());
        linkedHashMapO0.put("Range", ai.onnxruntime.a.h(this.f3208q, "bytes=", "-"));
        return new Downloader.b(this.f3196a.getId(), this.f3196a.getUrl(), linkedHashMapO0, this.f3196a.getFile(), com.tonyodev.fetch2core.b.j(this.f3196a.getFile()), this.f3196a.getTag(), this.f3196a.getIdentifier(), "GET", this.f3196a.getExtras(), "", 1);
    }

    @Override // bb.b
    public final void c0() {
        db.a aVar = this.f3205n;
        if (aVar == null) {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f8435e = true;
        }
        this.f3203l = true;
    }

    public final boolean d() {
        return ((this.f3208q > 0 && this.f3206o > 0) || this.f3207p) && this.f3208q >= this.f3206o;
    }

    public final void e(Downloader.a aVar) {
        if (this.f3203l || this.f3204m || !d()) {
            return;
        }
        this.f3206o = this.f3208q;
        b().setDownloaded(this.f3208q);
        b().setTotal(this.f3206o);
        this.f3212v.setDownloadedBytes(this.f3208q);
        this.f3212v.setEndByte(this.f3206o);
        if (this.f3204m || this.f3203l) {
            return;
        }
        db.a aVar2 = this.f3205n;
        if (aVar2 != null) {
            aVar2.g(b());
        }
        db.a aVar3 = this.f3205n;
        if (aVar3 != null) {
            aVar3.c(b(), this.f3212v, this.f3213w);
        }
        b().setEtaInMilliSeconds(this.r);
        b().setDownloadedBytesPerSecond(a());
        Download downloadCopy = b().copy();
        db.a aVar4 = this.f3205n;
        if (aVar4 != null) {
            aVar4.e(b(), b().getEtaInMilliSeconds(), b().getDownloadedBytesPerSecond());
        }
        b().setEtaInMilliSeconds(-1L);
        b().setDownloadedBytesPerSecond(-1L);
        db.a aVar5 = this.f3205n;
        if (aVar5 != null) {
            aVar5.b(downloadCopy);
        }
    }

    public final void f(BufferedInputStream bufferedInputStream, i iVar, int i10) throws IOException {
        long j10 = this.f3208q;
        byte[] bArr = new byte[i10];
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        int i11 = bufferedInputStream.read(bArr, 0, i10);
        long jNanoTime3 = jNanoTime;
        long j11 = jNanoTime2;
        while (!this.f3203l && !this.f3204m && i11 != -1) {
            iVar.o(bArr, i11);
            if (this.f3204m || this.f3203l) {
                j11 = j11;
                jNanoTime3 = jNanoTime3;
            } else {
                long j12 = jNanoTime3;
                this.f3208q += i11;
                b().setDownloaded(this.f3208q);
                b().setTotal(this.f3206o);
                this.f3212v.setDownloadedBytes(this.f3208q);
                this.f3212v.setEndByte(this.f3206o);
                boolean zO = com.tonyodev.fetch2core.b.o(j11, System.nanoTime(), 1000L);
                long jNanoTime4 = j11;
                if (zO) {
                    this.f3211u.a(this.f3208q - j10);
                    this.f3210t = hb.a.b(this.f3211u);
                    this.r = com.tonyodev.fetch2core.b.b(this.f3208q, this.f3206o, a());
                    j10 = this.f3208q;
                }
                if (com.tonyodev.fetch2core.b.o(j12, System.nanoTime(), this.f3198c)) {
                    this.f3212v.setDownloadedBytes(this.f3208q);
                    if (!this.f3204m && !this.f3203l) {
                        db.a aVar = this.f3205n;
                        if (aVar != null) {
                            aVar.g(b());
                        }
                        db.a aVar2 = this.f3205n;
                        if (aVar2 != null) {
                            aVar2.c(b(), this.f3212v, this.f3213w);
                        }
                        b().setEtaInMilliSeconds(this.r);
                        b().setDownloadedBytesPerSecond(a());
                        db.a aVar3 = this.f3205n;
                        if (aVar3 != null) {
                            aVar3.e(b(), b().getEtaInMilliSeconds(), b().getDownloadedBytesPerSecond());
                        }
                    }
                    jNanoTime3 = System.nanoTime();
                } else {
                    jNanoTime3 = j12;
                }
                if (zO) {
                    jNanoTime4 = System.nanoTime();
                }
                j11 = jNanoTime4;
                i11 = bufferedInputStream.read(bArr, 0, i10);
            }
        }
        iVar.flush();
    }

    @Override // bb.b
    public final boolean o() {
        return this.f3203l;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:231|3)|(1:125)(8:7|(3:234|9|(1:13))|19|(1:21)(1:27)|239|28|238|(6:89|(2:98|99)|(2:106|107)|108|(2:117|118)|119)(5:34|35|(18:37|(2:41|42)(1:40)|43|(1:45)(1:48)|49|(3:51|(1:53)|54)|55|(1:57)|58|252|59|(1:86)(6:63|255|64|(4:68|(1:70)|77|(1:79))|80|81)|247|126|(2:149|(1:152))(2:132|(6:136|(1:138)|143|(1:145)|146|(1:148)))|(2:245|154)|(2:232|159)|(2:236|164))(0)|168|209))|120|247|126|(6:128|149|(1:152)|(0)|(0)|(0))(0)|168|209|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0268, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0269, code lost:
    
        r7 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02aa A[Catch: all -> 0x0263, Exception -> 0x0268, TryCatch #3 {all -> 0x0263, blocks: (B:126:0x0221, B:128:0x0227, B:130:0x022b, B:132:0x022f, B:134:0x0253, B:136:0x0257, B:138:0x025b, B:143:0x026b, B:145:0x026f, B:146:0x027a, B:148:0x0292, B:149:0x02aa, B:152:0x02b2, B:169:0x02e0, B:171:0x02e4, B:173:0x02e8, B:175:0x0305, B:180:0x0317, B:181:0x031a, B:189:0x0332, B:184:0x0325, B:186:0x0329, B:190:0x0334, B:192:0x035f, B:194:0x0363, B:196:0x0375), top: B:231:0x000d, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e4 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:126:0x0221, B:128:0x0227, B:130:0x022b, B:132:0x022f, B:134:0x0253, B:136:0x0257, B:138:0x025b, B:143:0x026b, B:145:0x026f, B:146:0x027a, B:148:0x0292, B:149:0x02aa, B:152:0x02b2, B:169:0x02e0, B:171:0x02e4, B:173:0x02e8, B:175:0x0305, B:180:0x0317, B:181:0x031a, B:189:0x0332, B:184:0x0325, B:186:0x0329, B:190:0x0334, B:192:0x035f, B:194:0x0363, B:196:0x0375), top: B:231:0x000d, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0305 A[Catch: all -> 0x0263, TRY_LEAVE, TryCatch #3 {all -> 0x0263, blocks: (B:126:0x0221, B:128:0x0227, B:130:0x022b, B:132:0x022f, B:134:0x0253, B:136:0x0257, B:138:0x025b, B:143:0x026b, B:145:0x026f, B:146:0x027a, B:148:0x0292, B:149:0x02aa, B:152:0x02b2, B:169:0x02e0, B:171:0x02e4, B:173:0x02e8, B:175:0x0305, B:180:0x0317, B:181:0x031a, B:189:0x0332, B:184:0x0325, B:186:0x0329, B:190:0x0334, B:192:0x035f, B:194:0x0363, B:196:0x0375), top: B:231:0x000d, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0332 A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:126:0x0221, B:128:0x0227, B:130:0x022b, B:132:0x022f, B:134:0x0253, B:136:0x0257, B:138:0x025b, B:143:0x026b, B:145:0x026f, B:146:0x027a, B:148:0x0292, B:149:0x02aa, B:152:0x02b2, B:169:0x02e0, B:171:0x02e4, B:173:0x02e8, B:175:0x0305, B:180:0x0317, B:181:0x031a, B:189:0x0332, B:184:0x0325, B:186:0x0329, B:190:0x0334, B:192:0x035f, B:194:0x0363, B:196:0x0375), top: B:231:0x000d, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x035f A[Catch: all -> 0x0263, TryCatch #3 {all -> 0x0263, blocks: (B:126:0x0221, B:128:0x0227, B:130:0x022b, B:132:0x022f, B:134:0x0253, B:136:0x0257, B:138:0x025b, B:143:0x026b, B:145:0x026f, B:146:0x027a, B:148:0x0292, B:149:0x02aa, B:152:0x02b2, B:169:0x02e0, B:171:0x02e4, B:173:0x02e8, B:175:0x0305, B:180:0x0317, B:181:0x031a, B:189:0x0332, B:184:0x0325, B:186:0x0329, B:190:0x0334, B:192:0x035f, B:194:0x0363, B:196:0x0375), top: B:231:0x000d, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0375 A[Catch: all -> 0x0263, TRY_LEAVE, TryCatch #3 {all -> 0x0263, blocks: (B:126:0x0221, B:128:0x0227, B:130:0x022b, B:132:0x022f, B:134:0x0253, B:136:0x0257, B:138:0x025b, B:143:0x026b, B:145:0x026f, B:146:0x027a, B:148:0x0292, B:149:0x02aa, B:152:0x02b2, B:169:0x02e0, B:171:0x02e4, B:173:0x02e8, B:175:0x0305, B:180:0x0317, B:181:0x031a, B:189:0x0332, B:184:0x0325, B:186:0x0329, B:190:0x0334, B:192:0x035f, B:194:0x0363, B:196:0x0375), top: B:231:0x000d, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x038a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02d1 A[EXC_TOP_SPLITTER, PHI: r18
      0x02d1: PHI (r18v6 hb.i) = (r18v5 hb.i), (r18v9 hb.i) binds: [B:207:0x0396, B:163:0x02cf] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x037e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x039d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089 A[Catch: all -> 0x0067, Exception -> 0x01b5, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x0067, blocks: (B:9:0x0045, B:11:0x0049, B:13:0x004f, B:21:0x0064, B:28:0x006c, B:30:0x0070, B:34:0x0078, B:37:0x0080, B:43:0x0093, B:45:0x009d, B:49:0x00cd, B:51:0x00e9, B:54:0x00f9, B:55:0x00fc, B:57:0x0100, B:58:0x010f, B:48:0x00b8, B:41:0x0089, B:91:0x01be, B:93:0x01c2, B:95:0x01c6, B:98:0x01cd, B:99:0x01d4, B:101:0x01d7, B:103:0x01db, B:106:0x01e2, B:107:0x01e9, B:108:0x01ea, B:110:0x01ee, B:112:0x01f2, B:114:0x01fa, B:117:0x0201, B:118:0x0208), top: B:234:0x0045 }] */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.BufferedInputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 965
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bb.d.run():void");
    }
}
