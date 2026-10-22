package H8;

import androidx.collection.SieveCacheKt;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Stack;

/* renamed from: H8.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0244e implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public static final r f769a = new r(new byte[0]);

    public static AbstractC0244e b(Iterator it, int i) {
        if (i == 1) {
            return (AbstractC0244e) it.next();
        }
        int i6 = i >>> 1;
        return b(it, i6).c(b(it, i - i6));
    }

    public static C0243d j() {
        return new C0243d();
    }

    public final AbstractC0244e c(AbstractC0244e abstractC0244e) {
        int size = size();
        int size2 = abstractC0244e.size();
        if (size + size2 >= SieveCacheKt.NodeLinkMask) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
        int[] iArr = w.h;
        w wVar = this instanceof w ? (w) this : null;
        if (abstractC0244e.size() == 0) {
            return this;
        }
        if (size() == 0) {
            return abstractC0244e;
        }
        int size3 = abstractC0244e.size() + size();
        if (size3 < 128) {
            int size4 = size();
            int size5 = abstractC0244e.size();
            byte[] bArr = new byte[size4 + size5];
            e(bArr, 0, 0, size4);
            abstractC0244e.e(bArr, 0, size4, size5);
            return new r(bArr);
        }
        if (wVar != null) {
            AbstractC0244e abstractC0244e2 = wVar.d;
            if (abstractC0244e.size() + abstractC0244e2.size() < 128) {
                int size6 = abstractC0244e2.size();
                int size7 = abstractC0244e.size();
                byte[] bArr2 = new byte[size6 + size7];
                abstractC0244e2.e(bArr2, 0, 0, size6);
                abstractC0244e.e(bArr2, 0, size6, size7);
                return new w(wVar.c, new r(bArr2));
            }
        }
        if (wVar != null) {
            AbstractC0244e abstractC0244e3 = wVar.d;
            AbstractC0244e abstractC0244e4 = wVar.c;
            if (abstractC0244e4.g() > abstractC0244e3.g() && wVar.f > abstractC0244e.g()) {
                return new w(abstractC0244e4, new w(abstractC0244e3, abstractC0244e));
            }
        }
        if (size3 >= w.h[Math.max(g(), abstractC0244e.g()) + 1]) {
            return new w(this, abstractC0244e);
        }
        A0.b bVar = new A0.b(1);
        bVar.w(this);
        bVar.w(abstractC0244e);
        Stack stack = (Stack) bVar.b;
        AbstractC0244e wVar2 = (AbstractC0244e) stack.pop();
        while (!stack.isEmpty()) {
            wVar2 = new w((AbstractC0244e) stack.pop(), wVar2);
        }
        return wVar2;
    }

    public final void e(byte[] bArr, int i, int i6, int i10) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i6 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i10 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i10);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i11 = i + i10;
        if (i11 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i11);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i12 = i6 + i10;
        if (i12 <= bArr.length) {
            if (i10 > 0) {
                f(bArr, i, i6, i10);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i12);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    public abstract void f(byte[] bArr, int i, int i6, int i10);

    public abstract int g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract int l(int i, int i6, int i10);

    public abstract int n(int i, int i6, int i10);

    public abstract int o();

    public abstract String p();

    public final String q() {
        try {
            return p();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public abstract void r(OutputStream outputStream, int i, int i6);

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
