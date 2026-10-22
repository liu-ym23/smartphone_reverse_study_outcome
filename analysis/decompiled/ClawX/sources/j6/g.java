package j6;

import c5.l;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3524a;

    /* renamed from: b, reason: collision with root package name */
    public int f3525b;

    /* renamed from: c, reason: collision with root package name */
    public int f3526c;
    public k d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3527e;

    /* renamed from: f, reason: collision with root package name */
    public g f3528f;

    /* renamed from: g, reason: collision with root package name */
    public g f3529g;

    public g() {
        this.f3524a = new byte[8192];
        this.f3527e = true;
        this.d = null;
    }

    public final int a() {
        return this.f3524a.length - this.f3526c;
    }

    public final int b() {
        return this.f3526c - this.f3525b;
    }

    public final byte c(int i8) {
        return this.f3524a[this.f3525b + i8];
    }

    public final g d() {
        g gVar = this.f3528f;
        g gVar2 = this.f3529g;
        if (gVar2 != null) {
            p.b(gVar2);
            gVar2.f3528f = this.f3528f;
        }
        g gVar3 = this.f3528f;
        if (gVar3 != null) {
            p.b(gVar3);
            gVar3.f3529g = this.f3529g;
        }
        this.f3528f = null;
        this.f3529g = null;
        return gVar;
    }

    public final void e(g segment) {
        p.e(segment, "segment");
        segment.f3529g = this;
        segment.f3528f = this.f3528f;
        g gVar = this.f3528f;
        if (gVar != null) {
            gVar.f3529g = segment;
        }
        this.f3528f = segment;
    }

    public final g f() {
        k fVar = this.d;
        if (fVar == null) {
            g gVar = h.f3530a;
            fVar = new f();
            this.d = fVar;
        }
        int i8 = this.f3525b;
        int i9 = this.f3526c;
        f.f3522c.incrementAndGet((f) fVar);
        return new g(this.f3524a, i8, i9, fVar);
    }

    public final void g(g sink, int i8) {
        p.e(sink, "sink");
        if (!sink.f3527e) {
            throw new IllegalStateException("only owner can write");
        }
        if (sink.f3526c + i8 > 8192) {
            k kVar = sink.d;
            if (kVar != null && ((f) kVar).f3523b > 0) {
                throw new IllegalArgumentException();
            }
            int i9 = sink.f3526c;
            int i10 = sink.f3525b;
            if ((i9 + i8) - i10 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f3524a;
            l.U(0, bArr, i10, bArr, i9);
            sink.f3526c -= sink.f3525b;
            sink.f3525b = 0;
        }
        byte[] bArr2 = this.f3524a;
        byte[] bArr3 = sink.f3524a;
        int i11 = sink.f3526c;
        int i12 = this.f3525b;
        l.U(i11, bArr2, i12, bArr3, i12 + i8);
        sink.f3526c += i8;
        this.f3525b += i8;
    }

    public g(byte[] bArr, int i8, int i9, k kVar) {
        this.f3524a = bArr;
        this.f3525b = i8;
        this.f3526c = i9;
        this.d = kVar;
        this.f3527e = false;
    }
}
