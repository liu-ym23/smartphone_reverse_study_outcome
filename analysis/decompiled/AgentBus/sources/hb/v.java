package hb;

import ob.k0;
import ob.m0;

/* loaded from: classes.dex */
public final class v implements k0 {

    /* renamed from: f, reason: collision with root package name */
    public final long f4357f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4358g;

    /* renamed from: h, reason: collision with root package name */
    public final ob.h f4359h = new ob.h();

    /* renamed from: i, reason: collision with root package name */
    public final ob.h f4360i = new ob.h();

    /* renamed from: j, reason: collision with root package name */
    public boolean f4361j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f4362k;

    public v(x xVar, long j2, boolean z4) {
        this.f4362k = xVar;
        this.f4357f = j2;
        this.f4358g = z4;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j2;
        x xVar = this.f4362k;
        synchronized (xVar) {
            this.f4361j = true;
            ob.h hVar = this.f4360i;
            j2 = hVar.f7993g;
            hVar.a();
            xVar.notifyAll();
        }
        if (j2 > 0) {
            x xVar2 = this.f4362k;
            byte[] bArr = bb.b.f1659a;
            xVar2.f4365b.g(j2);
        }
        this.f4362k.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[LOOP:0: B:4:0x000f->B:47:0x0096, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x009a A[SYNTHETIC] */
    @Override // ob.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(ob.h r16, long r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.v.read(ob.h, long):long");
    }

    @Override // ob.k0
    public final m0 timeout() {
        return this.f4362k.f4374k;
    }
}
