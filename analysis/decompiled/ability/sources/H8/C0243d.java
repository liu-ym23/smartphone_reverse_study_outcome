package H8;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: H8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0243d extends OutputStream {
    public static final byte[] f = new byte[0];
    public int c;
    public int e;

    /* renamed from: a, reason: collision with root package name */
    public final int f768a = 128;
    public final ArrayList b = new ArrayList();
    public byte[] d = new byte[128];

    public final void b(int i) {
        this.b.add(new r(this.d));
        int length = this.c + this.d.length;
        this.c = length;
        this.d = new byte[Math.max(this.f768a, Math.max(i, length >>> 1))];
        this.e = 0;
    }

    public final void c() {
        int i = this.e;
        byte[] bArr = this.d;
        int length = bArr.length;
        ArrayList arrayList = this.b;
        if (i >= length) {
            arrayList.add(new r(this.d));
            this.d = f;
        } else if (i > 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            arrayList.add(new r(bArr2));
        }
        this.c += this.e;
        this.e = 0;
    }

    public final synchronized AbstractC0244e f() {
        ArrayList arrayList;
        c();
        arrayList = this.b;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((AbstractC0244e) it.next());
            }
            arrayList = arrayList2;
        }
        return arrayList.isEmpty() ? AbstractC0244e.f769a : AbstractC0244e.b(arrayList.iterator(), arrayList.size());
    }

    public final String toString() {
        int i;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        synchronized (this) {
            i = this.c + this.e;
        }
        return String.format("<ByteString.Output@%s size=%d>", hexString, Integer.valueOf(i));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        try {
            if (this.e == this.d.length) {
                b(1);
            }
            byte[] bArr = this.d;
            int i6 = this.e;
            this.e = i6 + 1;
            bArr[i6] = (byte) i;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i6) {
        try {
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i10 = this.e;
            if (i6 <= length - i10) {
                System.arraycopy(bArr, i, bArr2, i10, i6);
                this.e += i6;
            } else {
                int length2 = bArr2.length - i10;
                System.arraycopy(bArr, i, bArr2, i10, length2);
                int i11 = i6 - length2;
                b(i11);
                System.arraycopy(bArr, i + length2, this.d, 0, i11);
                this.e = i11;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
