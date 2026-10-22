package b7;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final c7.g f988a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f989b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f990c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final long f991e;

    /* renamed from: f, reason: collision with root package name */
    public final c7.f f992f;

    /* renamed from: g, reason: collision with root package name */
    public final c7.f f993g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f994h;

    /* renamed from: j, reason: collision with root package name */
    public a f995j;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f996k;

    /* renamed from: l, reason: collision with root package name */
    public final c7.e f997l;

    public l(c7.g sink, Random random, boolean z, boolean z2, long j4) {
        p.e(sink, "sink");
        this.f988a = sink;
        this.f989b = random;
        this.f990c = z;
        this.d = z2;
        this.f991e = j4;
        this.f992f = new c7.f();
        this.f993g = sink.c();
        this.f996k = new byte[4];
        this.f997l = new c7.e();
    }

    public final void a(int i8, c7.i iVar) {
        if (this.f994h) {
            throw new IOException("closed");
        }
        int iC = iVar.c();
        if (iC > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        c7.f fVar = this.f993g;
        fVar.A(i8 | 128);
        fVar.A(iC | 128);
        byte[] bArr = this.f996k;
        p.b(bArr);
        this.f989b.nextBytes(bArr);
        fVar.v(bArr, bArr.length);
        if (iC > 0) {
            long j4 = fVar.f1164b;
            fVar.u(iVar);
            c7.e eVar = this.f997l;
            p.b(eVar);
            fVar.g(eVar);
            eVar.b(j4);
            b8.h.P(eVar, bArr);
            eVar.close();
        }
        this.f988a.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(c7.i r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.l.b(c7.i):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a aVar = this.f995j;
        if (aVar != null) {
            o6.d.a(aVar);
        }
        o6.d.a(this.f988a);
    }
}
