package u6;

import java.util.TimeZone;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t implements c7.v {

    /* renamed from: a, reason: collision with root package name */
    public final long f5754a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5755b;

    /* renamed from: c, reason: collision with root package name */
    public final c7.f f5756c = new c7.f();
    public final c7.f d = new c7.f();

    /* renamed from: e, reason: collision with root package name */
    public boolean f5757e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ v f5758f;

    public t(v vVar, long j4, boolean z) {
        this.f5758f = vVar;
        this.f5754a = j4;
        this.f5755b = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j4;
        v vVar = this.f5758f;
        synchronized (vVar) {
            this.f5757e = true;
            c7.f fVar = this.d;
            j4 = fVar.f1164b;
            fVar.skip(j4);
            vVar.notifyAll();
        }
        if (j4 > 0) {
            v vVar2 = this.f5758f;
            TimeZone timeZone = o6.f.f4330a;
            vVar2.f5761b.j(j4);
        }
        this.f5758f.a();
    }

    @Override // c7.v, c7.t
    public final c7.x d() {
        return this.f5758f.f5768j;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[Catch: all -> 0x0022, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:7:0x0012, B:13:0x001c, B:47:0x00b9, B:61:0x00df, B:62:0x00e4, B:17:0x0025, B:19:0x002b, B:21:0x002f, B:23:0x0033, B:27:0x0044, B:29:0x0048, B:31:0x0052, B:33:0x006f, B:35:0x0080, B:38:0x0097, B:41:0x00a1, B:43:0x00a7, B:44:0x00b3, B:58:0x00d5, B:59:0x00dc), top: B:66:0x0005, inners: #0 }] */
    @Override // c7.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long h(long r22, c7.f r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.t.h(long, c7.f):long");
    }
}
