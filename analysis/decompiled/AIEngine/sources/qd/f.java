package qd;

import com.stepos.core.common.util.TraceIdKeys;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.ByteString;
import sd.a0;
import sd.e;
import sd.g;
import sd.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final g f11663a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f11664b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11665c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11666d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11667e;
    public final sd.e h;

    /* renamed from: j, reason: collision with root package name */
    public final sd.e f11668j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11669k;

    /* renamed from: l, reason: collision with root package name */
    public a f11670l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f11671m;

    /* renamed from: n, reason: collision with root package name */
    public final e.a f11672n;

    public f(g sink, Random random, boolean z, boolean z3, long j10) {
        kotlin.jvm.internal.g.f(sink, "sink");
        this.f11663a = sink;
        this.f11664b = random;
        this.f11665c = z;
        this.f11666d = z3;
        this.f11667e = j10;
        this.h = new sd.e();
        this.f11668j = sink.c();
        this.f11671m = new byte[4];
        this.f11672n = new e.a();
    }

    public final void a(int i10, ByteString byteString) throws IOException {
        if (this.f11669k) {
            throw new IOException("closed");
        }
        int iD = byteString.d();
        if (iD > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        int i11 = i10 | TraceIdKeys.MAX_LENGTH;
        sd.e eVar = this.f11668j;
        eVar.O0(i11);
        eVar.O0(iD | TraceIdKeys.MAX_LENGTH);
        byte[] bArr = this.f11671m;
        kotlin.jvm.internal.g.c(bArr);
        this.f11664b.nextBytes(bArr);
        eVar.m176write(bArr);
        if (iD > 0) {
            long j10 = eVar.f11926b;
            eVar.N0(byteString);
            e.a aVar = this.f11672n;
            kotlin.jvm.internal.g.c(aVar);
            eVar.C0(aVar);
            aVar.o(j10);
            e.a(aVar, bArr);
            aVar.close();
        }
        this.f11663a.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a aVar = this.f11670l;
        if (aVar != null) {
            aVar.close();
        }
    }

    public final void o(ByteString byteString) throws IOException {
        int i10;
        if (this.f11669k) {
            throw new IOException("closed");
        }
        sd.e eVar = this.h;
        eVar.N0(byteString);
        if (!this.f11665c || byteString.f11313a.length < this.f11667e) {
            i10 = 129;
        } else {
            a aVar = this.f11670l;
            if (aVar == null) {
                aVar = new a(this.f11666d);
                this.f11670l = aVar;
            }
            i iVar = aVar.f11651d;
            sd.e eVar2 = aVar.f11649b;
            if (eVar2.f11926b != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (aVar.f11648a) {
                aVar.f11650c.reset();
            }
            iVar.j0(eVar, eVar.f11926b);
            iVar.flush();
            if (eVar2.x0(eVar2.f11926b - r1.f11313a.length, b.f11652a)) {
                long j10 = eVar2.f11926b - 4;
                e.a aVarC0 = eVar2.C0(sd.a.f11899a);
                try {
                    aVarC0.a(j10);
                    aVarC0.close();
                } finally {
                }
            } else {
                eVar2.O0(0);
            }
            eVar.j0(eVar2, eVar2.f11926b);
            i10 = 193;
        }
        long j11 = eVar.f11926b;
        sd.e eVar3 = this.f11668j;
        eVar3.O0(i10);
        if (j11 <= 125) {
            eVar3.O0(((int) j11) | TraceIdKeys.MAX_LENGTH);
        } else if (j11 <= 65535) {
            eVar3.O0(254);
            eVar3.S0((int) j11);
        } else {
            eVar3.O0(255);
            a0 a0VarM0 = eVar3.M0(8);
            byte[] bArr = a0VarM0.f11901a;
            int i11 = a0VarM0.f11903c;
            bArr[i11] = (byte) ((j11 >>> 56) & 255);
            bArr[i11 + 1] = (byte) ((j11 >>> 48) & 255);
            bArr[i11 + 2] = (byte) ((j11 >>> 40) & 255);
            bArr[i11 + 3] = (byte) ((j11 >>> 32) & 255);
            bArr[i11 + 4] = (byte) ((j11 >>> 24) & 255);
            bArr[i11 + 5] = (byte) ((j11 >>> 16) & 255);
            bArr[i11 + 6] = (byte) ((j11 >>> 8) & 255);
            bArr[i11 + 7] = (byte) (j11 & 255);
            a0VarM0.f11903c = i11 + 8;
            eVar3.f11926b += 8;
        }
        byte[] bArr2 = this.f11671m;
        kotlin.jvm.internal.g.c(bArr2);
        this.f11664b.nextBytes(bArr2);
        eVar3.m176write(bArr2);
        if (j11 > 0) {
            e.a aVar2 = this.f11672n;
            kotlin.jvm.internal.g.c(aVar2);
            eVar.C0(aVar2);
            aVar2.o(0L);
            e.a(aVar2, bArr2);
            aVar2.close();
        }
        eVar3.j0(eVar, j11);
        this.f11663a.p();
    }
}
