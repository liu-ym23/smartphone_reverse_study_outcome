package H8;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class w extends AbstractC0244e {
    public static final int[] h;
    public final int b;
    public final AbstractC0244e c;
    public final AbstractC0244e d;
    public final int e;
    public final int f;
    public int g = 0;

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i6 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i10 = i6 + i;
            i6 = i;
            i = i10;
        }
        arrayList.add(Integer.MAX_VALUE);
        h = new int[arrayList.size()];
        int i11 = 0;
        while (true) {
            int[] iArr = h;
            if (i11 >= iArr.length) {
                return;
            }
            iArr[i11] = ((Integer) arrayList.get(i11)).intValue();
            i11++;
        }
    }

    public w(AbstractC0244e abstractC0244e, AbstractC0244e abstractC0244e2) {
        this.c = abstractC0244e;
        this.d = abstractC0244e2;
        int size = abstractC0244e.size();
        this.e = size;
        this.b = abstractC0244e2.size() + size;
        this.f = Math.max(abstractC0244e.g(), abstractC0244e2.g()) + 1;
    }

    public final boolean equals(Object obj) {
        int iO;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0244e) {
            AbstractC0244e abstractC0244e = (AbstractC0244e) obj;
            int size = abstractC0244e.size();
            int i = this.b;
            if (i == size) {
                if (i == 0) {
                    return true;
                }
                if (this.g == 0 || (iO = abstractC0244e.o()) == 0 || this.g == iO) {
                    u uVar = new u(this);
                    r rVarA = uVar.a();
                    u uVar2 = new u(abstractC0244e);
                    r rVarA2 = uVar2.a();
                    int i6 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        int length = rVarA.b.length - i6;
                        int length2 = rVarA2.b.length - i10;
                        int iMin = Math.min(length, length2);
                        if (!(i6 == 0 ? rVarA.s(rVarA2, i10, iMin) : rVarA2.s(rVarA, i6, iMin))) {
                            break;
                        }
                        i11 += iMin;
                        if (i11 >= i) {
                            if (i11 == i) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (iMin == length) {
                            rVarA = uVar.a();
                            i6 = 0;
                        } else {
                            i6 += iMin;
                        }
                        if (iMin == length2) {
                            rVarA2 = uVar2.a();
                            i10 = 0;
                        } else {
                            i10 += iMin;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // H8.AbstractC0244e
    public final void f(byte[] bArr, int i, int i6, int i10) {
        int i11 = i + i10;
        AbstractC0244e abstractC0244e = this.c;
        int i12 = this.e;
        if (i11 <= i12) {
            abstractC0244e.f(bArr, i, i6, i10);
            return;
        }
        AbstractC0244e abstractC0244e2 = this.d;
        if (i >= i12) {
            abstractC0244e2.f(bArr, i - i12, i6, i10);
            return;
        }
        int i13 = i12 - i;
        abstractC0244e.f(bArr, i, i6, i13);
        abstractC0244e2.f(bArr, 0, i6 + i13, i10 - i13);
    }

    @Override // H8.AbstractC0244e
    public final int g() {
        return this.f;
    }

    @Override // H8.AbstractC0244e
    public final boolean h() {
        return this.b >= h[this.f];
    }

    public final int hashCode() {
        int iL = this.g;
        if (iL == 0) {
            int i = this.b;
            iL = l(i, 0, i);
            if (iL == 0) {
                iL = 1;
            }
            this.g = iL;
        }
        return iL;
    }

    @Override // H8.AbstractC0244e
    public final boolean i() {
        int iN = this.c.n(0, 0, this.e);
        AbstractC0244e abstractC0244e = this.d;
        return abstractC0244e.n(iN, 0, abstractC0244e.size()) == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new v(this);
    }

    @Override // H8.AbstractC0244e
    public final int l(int i, int i6, int i10) {
        int i11 = i6 + i10;
        AbstractC0244e abstractC0244e = this.c;
        int i12 = this.e;
        if (i11 <= i12) {
            return abstractC0244e.l(i, i6, i10);
        }
        AbstractC0244e abstractC0244e2 = this.d;
        if (i6 >= i12) {
            return abstractC0244e2.l(i, i6 - i12, i10);
        }
        int i13 = i12 - i6;
        return abstractC0244e2.l(abstractC0244e.l(i, i6, i13), 0, i10 - i13);
    }

    @Override // H8.AbstractC0244e
    public final int n(int i, int i6, int i10) {
        int i11 = i6 + i10;
        AbstractC0244e abstractC0244e = this.c;
        int i12 = this.e;
        if (i11 <= i12) {
            return abstractC0244e.n(i, i6, i10);
        }
        AbstractC0244e abstractC0244e2 = this.d;
        if (i6 >= i12) {
            return abstractC0244e2.n(i, i6 - i12, i10);
        }
        int i13 = i12 - i6;
        return abstractC0244e2.n(abstractC0244e.n(i, i6, i13), 0, i10 - i13);
    }

    @Override // H8.AbstractC0244e
    public final int o() {
        return this.g;
    }

    @Override // H8.AbstractC0244e
    public final String p() {
        byte[] bArr;
        int i = this.b;
        if (i == 0) {
            bArr = n.f777a;
        } else {
            byte[] bArr2 = new byte[i];
            f(bArr2, 0, 0, i);
            bArr = bArr2;
        }
        return new String(bArr, "UTF-8");
    }

    @Override // H8.AbstractC0244e
    public final void r(OutputStream outputStream, int i, int i6) {
        int i10 = i + i6;
        AbstractC0244e abstractC0244e = this.c;
        int i11 = this.e;
        if (i10 <= i11) {
            abstractC0244e.r(outputStream, i, i6);
            return;
        }
        AbstractC0244e abstractC0244e2 = this.d;
        if (i >= i11) {
            abstractC0244e2.r(outputStream, i - i11, i6);
            return;
        }
        int i12 = i11 - i;
        abstractC0244e.r(outputStream, i, i12);
        abstractC0244e2.r(outputStream, 0, i6 - i12);
    }

    @Override // H8.AbstractC0244e
    public final int size() {
        return this.b;
    }
}
