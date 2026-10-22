package k3;

import androidx.room.AbstractC0351g;
import java.io.Closeable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import s.AbstractC0831a;

/* renamed from: k3.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0692g implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public C0694i f13347a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13348b;

    /* renamed from: c, reason: collision with root package name */
    public w f13349c;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f13351e;

    /* renamed from: d, reason: collision with root package name */
    public long f13350d = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f13352f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f13353g = -1;

    public final void a(long j4) {
        C0694i c0694i = this.f13347a;
        if (c0694i == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!this.f13348b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long j5 = c0694i.f13357b;
        if (j4 <= j5) {
            if (j4 < 0) {
                throw new IllegalArgumentException(AbstractC0351g.n("newSize < 0: ", j4).toString());
            }
            long j6 = j5 - j4;
            while (true) {
                if (j6 <= 0) {
                    break;
                }
                w wVar = c0694i.f13356a;
                Intrinsics.checkNotNull(wVar);
                w wVar2 = wVar.f13391g;
                Intrinsics.checkNotNull(wVar2);
                int i4 = wVar2.f13387c;
                long j7 = i4 - wVar2.f13386b;
                if (j7 > j6) {
                    wVar2.f13387c = i4 - ((int) j6);
                    break;
                } else {
                    c0694i.f13356a = wVar2.a();
                    x.a(wVar2);
                    j6 -= j7;
                }
            }
            this.f13349c = null;
            this.f13350d = j4;
            this.f13351e = null;
            this.f13352f = -1;
            this.f13353g = -1;
        } else if (j4 > j5) {
            long j8 = j4 - j5;
            int i5 = 1;
            boolean z4 = true;
            for (long j9 = 0; j8 > j9; j9 = 0) {
                w wVarR = c0694i.R(i5);
                int iMin = (int) Math.min(j8, 8192 - wVarR.f13387c);
                int i6 = wVarR.f13387c + iMin;
                wVarR.f13387c = i6;
                j8 -= iMin;
                if (z4) {
                    this.f13349c = wVarR;
                    this.f13350d = j5;
                    this.f13351e = wVarR.f13385a;
                    this.f13352f = i6 - iMin;
                    this.f13353g = i6;
                    z4 = false;
                }
                i5 = 1;
            }
        }
        c0694i.f13357b = j4;
    }

    public final int b(long j4) {
        w wVar;
        C0694i c0694i = this.f13347a;
        if (c0694i == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (j4 >= -1) {
            long j5 = c0694i.f13357b;
            if (j4 <= j5) {
                if (j4 == -1 || j4 == j5) {
                    this.f13349c = null;
                    this.f13350d = j4;
                    this.f13351e = null;
                    this.f13352f = -1;
                    this.f13353g = -1;
                    return -1;
                }
                w wVar2 = c0694i.f13356a;
                w wVar3 = this.f13349c;
                long j6 = 0;
                if (wVar3 != null) {
                    long j7 = this.f13350d;
                    int i4 = this.f13352f;
                    Intrinsics.checkNotNull(wVar3);
                    long j8 = j7 - (i4 - wVar3.f13386b);
                    if (j8 > j4) {
                        wVar = wVar2;
                        wVar2 = this.f13349c;
                        j5 = j8;
                    } else {
                        wVar = this.f13349c;
                        j6 = j8;
                    }
                } else {
                    wVar = wVar2;
                }
                if (j5 - j4 > j4 - j6) {
                    while (true) {
                        Intrinsics.checkNotNull(wVar);
                        long j9 = (wVar.f13387c - wVar.f13386b) + j6;
                        if (j4 < j9) {
                            break;
                        }
                        wVar = wVar.f13390f;
                        j6 = j9;
                    }
                } else {
                    while (j5 > j4) {
                        Intrinsics.checkNotNull(wVar2);
                        wVar2 = wVar2.f13391g;
                        Intrinsics.checkNotNull(wVar2);
                        j5 -= wVar2.f13387c - wVar2.f13386b;
                    }
                    wVar = wVar2;
                    j6 = j5;
                }
                if (this.f13348b) {
                    Intrinsics.checkNotNull(wVar);
                    if (wVar.f13388d) {
                        byte[] bArr = wVar.f13385a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, size)");
                        w wVar4 = new w(bArrCopyOf, wVar.f13386b, wVar.f13387c, false, true);
                        if (c0694i.f13356a == wVar) {
                            c0694i.f13356a = wVar4;
                        }
                        wVar.b(wVar4);
                        w wVar5 = wVar4.f13391g;
                        Intrinsics.checkNotNull(wVar5);
                        wVar5.a();
                        wVar = wVar4;
                    }
                }
                this.f13349c = wVar;
                this.f13350d = j4;
                Intrinsics.checkNotNull(wVar);
                this.f13351e = wVar.f13385a;
                int i5 = wVar.f13386b + ((int) (j4 - j6));
                this.f13352f = i5;
                int i6 = wVar.f13387c;
                this.f13353g = i6;
                return i6 - i5;
            }
        }
        StringBuilder sbE = AbstractC0831a.e("offset=", j4, " > size=");
        sbE.append(c0694i.f13357b);
        throw new ArrayIndexOutOfBoundsException(sbE.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f13347a == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        this.f13347a = null;
        this.f13349c = null;
        this.f13350d = -1L;
        this.f13351e = null;
        this.f13352f = -1;
        this.f13353g = -1;
    }
}
