package k;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class i0 implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int[] f5495f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object[] f5496g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f5497h;

    public i0() {
        int i2;
        int i10 = 4;
        while (true) {
            i2 = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i2 = i11;
                break;
            }
            i10++;
        }
        int i12 = i2 / 4;
        this.f5495f = new int[i12];
        this.f5496g = new Object[i12];
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final i0 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        q7.k.c(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        i0 i0Var = (i0) objClone;
        i0Var.f5495f = (int[]) this.f5495f.clone();
        i0Var.f5496g = (Object[]) this.f5496g.clone();
        return i0Var;
    }

    public final Object b(int i2) {
        Object obj;
        int iA = l.a.a(this.f5497h, i2, this.f5495f);
        if (iA < 0 || (obj = this.f5496g[iA]) == o.f5512b) {
            return null;
        }
        return obj;
    }

    public final void c(int i2, Object obj) {
        int iA = l.a.a(this.f5497h, i2, this.f5495f);
        if (iA >= 0) {
            this.f5496g[iA] = obj;
            return;
        }
        int i10 = ~iA;
        int i11 = this.f5497h;
        if (i10 < i11) {
            Object[] objArr = this.f5496g;
            if (objArr[i10] == o.f5512b) {
                this.f5495f[i10] = i2;
                objArr[i10] = obj;
                return;
            }
        }
        if (i11 >= this.f5495f.length) {
            int i12 = (i11 + 1) * 4;
            int i13 = 4;
            while (true) {
                if (i13 >= 32) {
                    break;
                }
                int i14 = (1 << i13) - 12;
                if (i12 <= i14) {
                    i12 = i14;
                    break;
                }
                i13++;
            }
            int i15 = i12 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.f5495f, i15);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f5495f = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f5496g, i15);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            this.f5496g = objArrCopyOf;
        }
        int i16 = this.f5497h;
        if (i16 - i10 != 0) {
            int[] iArr = this.f5495f;
            int i17 = i10 + 1;
            d7.n.W(iArr, iArr, i17, i10, i16);
            Object[] objArr2 = this.f5496g;
            d7.n.Y(objArr2, objArr2, i17, i10, this.f5497h);
        }
        this.f5495f[i10] = i2;
        this.f5496g[i10] = obj;
        this.f5497h++;
    }

    public final Object d(int i2) {
        Object[] objArr = this.f5496g;
        if (i2 < objArr.length) {
            return objArr[i2];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        int i2 = this.f5497h;
        if (i2 <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i2 * 28);
        sb2.append('{');
        int i10 = this.f5497h;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.f5495f[i11]);
            sb2.append('=');
            Object objD = d(i11);
            if (objD != this) {
                sb2.append(objD);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }
}
