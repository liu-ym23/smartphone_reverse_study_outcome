package O4;

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
import java.util.List;

/* loaded from: classes.dex */
public class i implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final int f4467a = 1179403647;

    /* renamed from: b, reason: collision with root package name */
    private final FileChannel f4468b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f4468b = new FileInputStream(file).getChannel();
    }

    private long a(d dVar, long j5, long j6) {
        for (long j7 = 0; j7 < j5; j7++) {
            e eVarB = dVar.b(j7);
            if (eVarB.f4460a == 1) {
                long j8 = eVarB.f4462c;
                if (j8 <= j6 && j6 <= eVarB.f4463d + j8) {
                    return (j6 - j8) + eVarB.f4461b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d c() throws IOException {
        this.f4468b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (w(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sF = f(byteBufferAllocate, 4L);
        boolean z5 = f(byteBufferAllocate, 5L) == 2;
        if (sF == 1) {
            return new g(z5, this);
        }
        if (sF == 2) {
            return new h(z5, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4468b.close();
    }

    protected short f(ByteBuffer byteBuffer, long j5) throws IOException {
        m(byteBuffer, j5, 1);
        return (short) (byteBuffer.get() & 255);
    }

    protected void m(ByteBuffer byteBuffer, long j5, int i5) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i5);
        long j6 = 0;
        while (j6 < i5) {
            int i6 = this.f4468b.read(byteBuffer, j5 + j6);
            if (i6 == -1) {
                throw new EOFException();
            }
            j6 += i6;
        }
        byteBuffer.position(0);
    }

    protected int o(ByteBuffer byteBuffer, long j5) throws IOException {
        m(byteBuffer, j5, 2);
        return byteBuffer.getShort() & 65535;
    }

    public List<String> r() throws IOException {
        long j5;
        this.f4468b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarC = c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarC.f4451a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j6 = dVarC.f4456f;
        if (j6 == 65535) {
            j6 = dVarC.c(0).f4464a;
        }
        long j7 = 0;
        while (true) {
            if (j7 >= j6) {
                j5 = 0;
                break;
            }
            e eVarB = dVarC.b(j7);
            if (eVarB.f4460a == 2) {
                j5 = eVarB.f4461b;
                break;
            }
            j7++;
        }
        if (j5 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j8 = 0;
        int i5 = 0;
        while (true) {
            c cVarA = dVarC.a(j5, i5);
            long j9 = j5;
            long j10 = cVarA.f4449a;
            if (j10 == 1) {
                arrayList2.add(Long.valueOf(cVarA.f4450b));
            } else if (j10 == 5) {
                j8 = cVarA.f4450b;
            }
            i5++;
            if (cVarA.f4449a == 0) {
                break;
            }
            j5 = j9;
            j6 = j6;
        }
        if (j8 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(dVarC, j6, j8);
        int size = arrayList2.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList2.get(i6);
            i6++;
            arrayList.add(v(byteBufferAllocate, ((Long) obj).longValue() + jA));
        }
        return arrayList;
    }

    protected long u(ByteBuffer byteBuffer, long j5) throws IOException {
        m(byteBuffer, j5, 8);
        return byteBuffer.getLong();
    }

    protected String v(ByteBuffer byteBuffer, long j5) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j6 = 1 + j5;
            short sF = f(byteBuffer, j5);
            if (sF == 0) {
                return sb.toString();
            }
            sb.append((char) sF);
            j5 = j6;
        }
    }

    protected long w(ByteBuffer byteBuffer, long j5) throws IOException {
        m(byteBuffer, j5, 4);
        return byteBuffer.getInt() & 4294967295L;
    }
}
