package c7;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1187a;

    /* renamed from: b, reason: collision with root package name */
    public int f1188b;

    /* renamed from: c, reason: collision with root package name */
    public int f1189c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1190e;

    /* renamed from: f, reason: collision with root package name */
    public q f1191f;

    /* renamed from: g, reason: collision with root package name */
    public q f1192g;

    public q() {
        this.f1187a = new byte[8192];
        this.f1190e = true;
        this.d = false;
    }

    public final q a() {
        q qVar = this.f1191f;
        if (qVar == this) {
            qVar = null;
        }
        q qVar2 = this.f1192g;
        kotlin.jvm.internal.p.b(qVar2);
        qVar2.f1191f = this.f1191f;
        q qVar3 = this.f1191f;
        kotlin.jvm.internal.p.b(qVar3);
        qVar3.f1192g = this.f1192g;
        this.f1191f = null;
        this.f1192g = null;
        return qVar;
    }

    public final void b(q segment) {
        kotlin.jvm.internal.p.e(segment, "segment");
        segment.f1192g = this;
        segment.f1191f = this.f1191f;
        q qVar = this.f1191f;
        kotlin.jvm.internal.p.b(qVar);
        qVar.f1192g = segment;
        this.f1191f = segment;
    }

    public final q c() {
        this.d = true;
        return new q(this.f1187a, this.f1188b, this.f1189c, true, false);
    }

    public final void d(q sink, int i8) {
        kotlin.jvm.internal.p.e(sink, "sink");
        byte[] bArr = sink.f1187a;
        if (!sink.f1190e) {
            throw new IllegalStateException("only owner can write");
        }
        int i9 = sink.f1189c;
        int i10 = i9 + i8;
        if (i10 > 8192) {
            if (sink.d) {
                throw new IllegalArgumentException();
            }
            int i11 = sink.f1188b;
            if (i10 - i11 > 8192) {
                throw new IllegalArgumentException();
            }
            c5.l.U(0, bArr, i11, bArr, i9);
            sink.f1189c -= sink.f1188b;
            sink.f1188b = 0;
        }
        int i12 = sink.f1189c;
        int i13 = this.f1188b;
        c5.l.U(i12, this.f1187a, i13, bArr, i13 + i8);
        sink.f1189c += i8;
        this.f1188b += i8;
    }

    public q(byte[] data, int i8, int i9, boolean z, boolean z2) {
        kotlin.jvm.internal.p.e(data, "data");
        this.f1187a = data;
        this.f1188b = i8;
        this.f1189c = i9;
        this.d = z;
        this.f1190e = z2;
    }
}
