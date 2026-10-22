package f9;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
public abstract class d implements Iterable {

    /* renamed from: f, reason: collision with root package name */
    public static final u f3536f = new u(new byte[0]);

    public static d a(Iterator it, int i2) {
        if (i2 == 1) {
            return (d) it.next();
        }
        int i10 = i2 >>> 1;
        return a(it, i10).f(a(it, i2 - i10));
    }

    public static c m() {
        return new c();
    }

    public final d f(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (size + size2 >= 2147483647L) {
            StringBuilder sb2 = new StringBuilder(53);
            sb2.append("ByteString would be too long: ");
            sb2.append(size);
            sb2.append("+");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        int[] iArr = z.f3607m;
        z zVar = this instanceof z ? (z) this : null;
        if (dVar.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return dVar;
        }
        int size3 = dVar.size() + size();
        if (size3 < 128) {
            int size4 = size();
            int size5 = dVar.size();
            byte[] bArr = new byte[size4 + size5];
            h(0, 0, size4, bArr);
            dVar.h(0, size4, size5, bArr);
            return new u(bArr);
        }
        if (zVar != null) {
            d dVar2 = zVar.f3610i;
            if (dVar.size() + dVar2.size() < 128) {
                int size6 = dVar2.size();
                int size7 = dVar.size();
                byte[] bArr2 = new byte[size6 + size7];
                dVar2.h(0, 0, size6, bArr2);
                dVar.h(0, size6, size7, bArr2);
                return new z(zVar.f3609h, new u(bArr2));
            }
        }
        if (zVar != null) {
            d dVar3 = zVar.f3610i;
            d dVar4 = zVar.f3609h;
            if (dVar4.j() > dVar3.j() && zVar.f3612k > dVar.j()) {
                return new z(dVar4, new z(dVar3, dVar));
            }
        }
        if (size3 >= z.f3607m[Math.max(j(), dVar.j()) + 1]) {
            return new z(this, dVar);
        }
        a7.d dVar5 = new a7.d(9);
        dVar5.i(this);
        dVar5.i(dVar);
        Stack stack = (Stack) dVar5.f411g;
        d zVar2 = (d) stack.pop();
        while (!stack.isEmpty()) {
            zVar2 = new z((d) stack.pop(), zVar2);
        }
        return zVar2;
    }

    public final void h(int i2, int i10, int i11, byte[] bArr) {
        if (i2 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i10 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i10);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        if (i11 < 0) {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i11);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i12 = i2 + i11;
        if (i12 > size()) {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Source end offset < 0: ");
            sb5.append(i12);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        int i13 = i10 + i11;
        if (i13 <= bArr.length) {
            if (i11 > 0) {
                i(i2, i10, i11, bArr);
            }
        } else {
            StringBuilder sb6 = new StringBuilder(34);
            sb6.append("Target end offset < 0: ");
            sb6.append(i13);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    public abstract void i(int i2, int i10, int i11, byte[] bArr);

    public abstract int j();

    public abstract boolean k();

    public abstract boolean l();

    public abstract int n(int i2, int i10, int i11);

    public abstract int o(int i2, int i10, int i11);

    public abstract int p();

    public abstract String q();

    public final String r() {
        try {
            return q();
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public abstract void s(OutputStream outputStream, int i2, int i10);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
