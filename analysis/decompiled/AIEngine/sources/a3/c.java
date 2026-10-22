package a3;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends OutputStream {
    public static final byte[] h = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final a f14a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<byte[]> f15b;

    /* renamed from: c, reason: collision with root package name */
    public int f16c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f17d;

    /* renamed from: e, reason: collision with root package name */
    public int f18e;

    public c(a aVar) {
        this(aVar, 500);
    }

    public final void C(int i10) {
        int i11 = this.f18e;
        int i12 = i11 + 1;
        byte[] bArr = this.f17d;
        if (i12 >= bArr.length) {
            o(i10 >> 8);
            o(i10);
        } else {
            this.f18e = i12;
            bArr[i11] = (byte) (i10 >> 8);
            this.f18e = i11 + 2;
            bArr[i12] = (byte) i10;
        }
    }

    public final void K() {
        this.f16c = 0;
        this.f18e = 0;
        LinkedList<byte[]> linkedList = this.f15b;
        if (linkedList.isEmpty()) {
            return;
        }
        linkedList.clear();
    }

    public final byte[] P() {
        int i10 = this.f16c + this.f18e;
        if (i10 == 0) {
            return h;
        }
        byte[] bArr = new byte[i10];
        LinkedList<byte[]> linkedList = this.f15b;
        Iterator<byte[]> it = linkedList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i11, length);
            i11 += length;
        }
        System.arraycopy(this.f17d, 0, bArr, i11, this.f18e);
        int i12 = i11 + this.f18e;
        if (i12 != i10) {
            throw new RuntimeException(com.stepos.core.ota.d.e(i10, "Internal error: total len assumed to be ", i12, ", copied ", " bytes"));
        }
        if (!linkedList.isEmpty()) {
            K();
        }
        return bArr;
    }

    public final void a() {
        int length = this.f16c + this.f17d.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this.f16c = length;
        int iMax = Math.max(length >> 1, 1000);
        if (iMax > 131072) {
            iMax = 131072;
        }
        this.f15b.add(this.f17d);
        this.f17d = new byte[iMax];
        this.f18e = 0;
    }

    public final void o(int i10) {
        if (this.f18e >= this.f17d.length) {
            a();
        }
        byte[] bArr = this.f17d;
        int i11 = this.f18e;
        this.f18e = i11 + 1;
        bArr[i11] = (byte) i10;
    }

    public final void w(int i10) {
        int i11 = this.f18e;
        int i12 = i11 + 2;
        byte[] bArr = this.f17d;
        if (i12 >= bArr.length) {
            o(i10 >> 16);
            o(i10 >> 8);
            o(i10);
            return;
        }
        int i13 = i11 + 1;
        this.f18e = i13;
        bArr[i11] = (byte) (i10 >> 16);
        this.f18e = i12;
        bArr[i13] = (byte) (i10 >> 8);
        this.f18e = i11 + 3;
        bArr[i12] = (byte) i10;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public c(a aVar, int i10) {
        this.f15b = new LinkedList<>();
        this.f14a = aVar;
        this.f17d = aVar == null ? new byte[i10 > 131072 ? 131072 : i10] : aVar.a(2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        while (true) {
            int iMin = Math.min(this.f17d.length - this.f18e, i11);
            if (iMin > 0) {
                System.arraycopy(bArr, i10, this.f17d, this.f18e, iMin);
                i10 += iMin;
                this.f18e += iMin;
                i11 -= iMin;
            }
            if (i11 <= 0) {
                return;
            } else {
                a();
            }
        }
    }

    public c(byte[] bArr, int i10) {
        this.f15b = new LinkedList<>();
        this.f14a = null;
        this.f17d = bArr;
        this.f18e = i10;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        o(i10);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }
}
