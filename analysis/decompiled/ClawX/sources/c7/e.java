package c7;

import java.io.Closeable;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public f f1157a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1158b;

    /* renamed from: c, reason: collision with root package name */
    public q f1159c;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f1160e;
    public long d = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f1161f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f1162g = -1;

    public final void a(long j4) {
        f fVar = this.f1157a;
        if (fVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.f1158b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j8 = fVar.f1164b;
        if (j4 <= j8) {
            if (j4 < 0) {
                throw new IllegalArgumentException(a8.b.l(j4, "newSize < 0: ").toString());
            }
            long j9 = j8 - j4;
            while (true) {
                if (j9 <= 0) {
                    break;
                }
                q qVar = fVar.f1163a;
                kotlin.jvm.internal.p.b(qVar);
                q qVar2 = qVar.f1192g;
                kotlin.jvm.internal.p.b(qVar2);
                int i8 = qVar2.f1189c;
                long j10 = i8 - qVar2.f1188b;
                if (j10 > j9) {
                    qVar2.f1189c = i8 - ((int) j9);
                    break;
                } else {
                    fVar.f1163a = qVar2.a();
                    r.a(qVar2);
                    j9 -= j10;
                }
            }
            this.f1159c = null;
            this.d = j4;
            this.f1160e = null;
            this.f1161f = -1;
            this.f1162g = -1;
        } else if (j4 > j8) {
            long j11 = j4 - j8;
            int i9 = 1;
            boolean z = true;
            for (long j12 = 0; j11 > j12; j12 = 0) {
                q qVarT = fVar.t(i9);
                int iMin = (int) Math.min(j11, 8192 - qVarT.f1189c);
                int i10 = qVarT.f1189c + iMin;
                qVarT.f1189c = i10;
                j11 -= iMin;
                if (z) {
                    this.f1159c = qVarT;
                    this.d = j8;
                    this.f1160e = qVarT.f1187a;
                    this.f1161f = i10 - iMin;
                    this.f1162g = i10;
                    z = false;
                }
                i9 = 1;
            }
        }
        fVar.f1164b = j4;
    }

    public final int b(long j4) {
        f fVar = this.f1157a;
        if (fVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j4 >= -1) {
            long j8 = fVar.f1164b;
            if (j4 <= j8) {
                if (j4 == -1 || j4 == j8) {
                    this.f1159c = null;
                    this.d = j4;
                    this.f1160e = null;
                    this.f1161f = -1;
                    this.f1162g = -1;
                    return -1;
                }
                q qVar = fVar.f1163a;
                q qVar2 = this.f1159c;
                long j9 = 0;
                if (qVar2 != null) {
                    long j10 = this.d - (this.f1161f - qVar2.f1188b);
                    if (j10 > j4) {
                        qVar2 = qVar;
                        qVar = qVar2;
                        j8 = j10;
                    } else {
                        j9 = j10;
                    }
                } else {
                    qVar2 = qVar;
                }
                if (j8 - j4 > j4 - j9) {
                    while (true) {
                        kotlin.jvm.internal.p.b(qVar2);
                        long j11 = (qVar2.f1189c - qVar2.f1188b) + j9;
                        if (j4 < j11) {
                            break;
                        }
                        qVar2 = qVar2.f1191f;
                        j9 = j11;
                    }
                } else {
                    while (j8 > j4) {
                        kotlin.jvm.internal.p.b(qVar);
                        qVar = qVar.f1192g;
                        kotlin.jvm.internal.p.b(qVar);
                        j8 -= qVar.f1189c - qVar.f1188b;
                    }
                    qVar2 = qVar;
                    j9 = j8;
                }
                if (this.f1158b) {
                    kotlin.jvm.internal.p.b(qVar2);
                    if (qVar2.d) {
                        byte[] bArr = qVar2.f1187a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        kotlin.jvm.internal.p.d(bArrCopyOf, "copyOf(...)");
                        q qVar3 = new q(bArrCopyOf, qVar2.f1188b, qVar2.f1189c, false, true);
                        if (fVar.f1163a == qVar2) {
                            fVar.f1163a = qVar3;
                        }
                        qVar2.b(qVar3);
                        q qVar4 = qVar3.f1192g;
                        kotlin.jvm.internal.p.b(qVar4);
                        qVar4.a();
                        qVar2 = qVar3;
                    }
                }
                this.f1159c = qVar2;
                this.d = j4;
                kotlin.jvm.internal.p.b(qVar2);
                this.f1160e = qVar2.f1187a;
                int i8 = qVar2.f1188b + ((int) (j4 - j9));
                this.f1161f = i8;
                int i9 = qVar2.f1189c;
                this.f1162g = i9;
                return i9 - i8;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j4 + " > size=" + fVar.f1164b);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f1157a == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f1157a = null;
        this.f1159c = null;
        this.d = -1L;
        this.f1160e = null;
        this.f1161f = -1;
        this.f1162g = -1;
    }
}
