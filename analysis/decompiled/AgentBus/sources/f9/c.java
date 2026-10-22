package f9;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f3530k = new byte[0];

    /* renamed from: h, reason: collision with root package name */
    public int f3533h;

    /* renamed from: j, reason: collision with root package name */
    public int f3535j;

    /* renamed from: f, reason: collision with root package name */
    public final int f3531f = 128;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f3532g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public byte[] f3534i = new byte[128];

    public final void a(int i2) {
        this.f3532g.add(new u(this.f3534i));
        int length = this.f3533h + this.f3534i.length;
        this.f3533h = length;
        this.f3534i = new byte[Math.max(this.f3531f, Math.max(i2, length >>> 1))];
        this.f3535j = 0;
    }

    public final void b() {
        int i2 = this.f3535j;
        byte[] bArr = this.f3534i;
        int length = bArr.length;
        ArrayList arrayList = this.f3532g;
        if (i2 >= length) {
            arrayList.add(new u(this.f3534i));
            this.f3534i = f3530k;
        } else if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
            arrayList.add(new u(bArr2));
        }
        this.f3533h += this.f3535j;
        this.f3535j = 0;
    }

    public final synchronized d d() {
        ArrayList arrayList;
        b();
        arrayList = this.f3532g;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((d) it.next());
            }
            arrayList = arrayList2;
        }
        return arrayList.isEmpty() ? d.f3536f : d.a(arrayList.iterator(), arrayList.size());
    }

    public final String toString() {
        int i2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        synchronized (this) {
            i2 = this.f3533h + this.f3535j;
        }
        return String.format("<ByteString.Output@%s size=%d>", hexString, Integer.valueOf(i2));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        try {
            if (this.f3535j == this.f3534i.length) {
                a(1);
            }
            byte[] bArr = this.f3534i;
            int i10 = this.f3535j;
            this.f3535j = i10 + 1;
            bArr[i10] = (byte) i2;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i10) {
        try {
            byte[] bArr2 = this.f3534i;
            int length = bArr2.length;
            int i11 = this.f3535j;
            if (i10 <= length - i11) {
                System.arraycopy(bArr, i2, bArr2, i11, i10);
                this.f3535j += i10;
            } else {
                int length2 = bArr2.length - i11;
                System.arraycopy(bArr, i2, bArr2, i11, length2);
                int i12 = i10 - length2;
                a(i12);
                System.arraycopy(bArr, i2 + length2, this.f3534i, 0, i12);
                this.f3535j = i12;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
