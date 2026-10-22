package hd;

import od.i0;
import od.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public long f5560c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5561f;

    /* renamed from: g, reason: collision with root package name */
    public od.i f5562g;

    /* renamed from: h, reason: collision with root package name */
    public od.i f5563h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ v f5564j;

    @Override // od.i0
    public final k0 b() {
        return this.f5564j.f5575k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j10;
        v vVar = this.f5564j;
        synchronized (vVar) {
            this.i = true;
            od.i iVar = this.f5563h;
            j10 = iVar.f9454f;
            iVar.d();
            vVar.notifyAll();
        }
        if (j10 > 0) {
            v vVar2 = this.f5564j;
            byte[] bArr = bd.b.f2074a;
            vVar2.f5567b.n(j10);
        }
        this.f5564j.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x003c A[Catch: all -> 0x0031, TryCatch #1 {all -> 0x0031, blocks: (B:7:0x0015, B:9:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0024, B:17:0x0026, B:19:0x0029, B:21:0x002c, B:25:0x0034, B:28:0x0037, B:29:0x0038, B:31:0x003c, B:33:0x0047, B:35:0x005b, B:37:0x006a, B:38:0x0076, B:41:0x007e, B:44:0x0084, B:45:0x0090, B:58:0x00a8, B:59:0x00af, B:62:0x00b2, B:8:0x0016, B:18:0x0027), top: B:71:0x0015, outer: #4, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0099 A[LOOP:0: B:4:0x000d->B:49:0x0099, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x009d A[SYNTHETIC] */
    @Override // od.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l(od.i r17, long r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.t.l(od.i, long):long");
    }
}
