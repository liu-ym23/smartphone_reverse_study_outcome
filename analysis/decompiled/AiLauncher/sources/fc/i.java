package fc;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class i implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final int f32654a = 1179403647;

    /* renamed from: b, reason: collision with root package name */
    public final FileChannel f32655b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f32655b = new FileInputStream(file).getChannel();
    }

    public String A(ByteBuffer byteBuffer, long j10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short sG = g(byteBuffer, j10);
            if (sG == 0) {
                return sb2.toString();
            }
            sb2.append((char) sG);
            j10 = j11;
        }
    }

    public long G(ByteBuffer byteBuffer, long j10) throws IOException {
        i(byteBuffer, j10, 4);
        return byteBuffer.getInt() & 4294967295L;
    }

    public final long b(d dVar, long j10, long j11) {
        for (long j12 = 0; j12 < j10; j12++) {
            e eVarB = dVar.b(j12);
            if (eVarB.f32647a == 1) {
                long j13 = eVarB.f32649c;
                if (j13 <= j11 && j11 <= eVarB.f32650d + j13) {
                    return (j11 - j13) + eVarB.f32648b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f32655b.close();
    }

    public d e() throws IOException {
        this.f32655b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (G(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sG = g(byteBufferAllocate, 4L);
        boolean z10 = g(byteBufferAllocate, 5L) == 2;
        if (sG == 1) {
            return new g(z10, this);
        }
        if (sG == 2) {
            return new h(z10, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public short g(ByteBuffer byteBuffer, long j10) throws IOException {
        i(byteBuffer, j10, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public void i(ByteBuffer byteBuffer, long j10, int i10) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        long j11 = 0;
        while (j11 < i10) {
            int i11 = this.f32655b.read(byteBuffer, j10 + j11);
            if (i11 == -1) {
                throw new EOFException();
            }
            j11 += i11;
        }
        byteBuffer.position(0);
    }

    public int l(ByteBuffer byteBuffer, long j10) throws IOException {
        i(byteBuffer, j10, 2);
        return byteBuffer.getShort() & 65535;
    }

    public List m() throws IOException {
        long j10;
        long j11;
        this.f32655b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarE = e();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarE.f32638a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j12 = dVarE.f32643f;
        int i10 = 0;
        if (j12 == 65535) {
            j12 = dVarE.c(0).f32651a;
        }
        long j13 = 0;
        while (true) {
            j10 = 1;
            if (j13 >= j12) {
                j11 = 0;
                break;
            }
            e eVarB = dVarE.b(j13);
            if (eVarB.f32647a == 2) {
                j11 = eVarB.f32648b;
                break;
            }
            j13++;
        }
        if (j11 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j14 = 0;
        while (true) {
            c cVarA = dVarE.a(j11, i10);
            long j15 = j10;
            long j16 = cVarA.f32636a;
            if (j16 == j15) {
                arrayList2.add(Long.valueOf(cVarA.f32637b));
            } else if (j16 == 5) {
                j14 = cVarA.f32637b;
            }
            i10++;
            if (cVarA.f32636a == 0) {
                break;
            }
            j10 = j15;
            j12 = j12;
        }
        if (j14 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jB = b(dVarE, j12, j14);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(A(byteBufferAllocate, ((Long) it.next()).longValue() + jB));
        }
        return arrayList;
    }

    public long n(ByteBuffer byteBuffer, long j10) throws IOException {
        i(byteBuffer, j10, 8);
        return byteBuffer.getLong();
    }
}
