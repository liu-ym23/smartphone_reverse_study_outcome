package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int[] f9614c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object[] f9615f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ int f9616g;

    public q0(int i) {
        int i3;
        int i10 = 4;
        while (true) {
            i3 = 40;
            if (i10 >= 32) {
                break;
            }
            int i11 = (1 << i10) - 12;
            if (40 <= i11) {
                i3 = i11;
                break;
            }
            i10++;
        }
        int i12 = i3 / 4;
        this.f9614c = new int[i12];
        this.f9615f = new Object[i12];
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final q0 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        q0 q0Var = (q0) objClone;
        q0Var.f9614c = (int[]) this.f9614c.clone();
        q0Var.f9615f = (Object[]) this.f9615f.clone();
        return q0Var;
    }

    public final Object b(int i) {
        Object obj;
        int iA = q.a.a(this.f9616g, i, this.f9614c);
        if (iA < 0 || (obj = this.f9615f[iA]) == o.f9600c) {
            return null;
        }
        return obj;
    }

    public final void c(int i, Object obj) {
        int iA = q.a.a(this.f9616g, i, this.f9614c);
        if (iA >= 0) {
            this.f9615f[iA] = obj;
            return;
        }
        int i3 = ~iA;
        int i10 = this.f9616g;
        if (i3 < i10) {
            Object[] objArr = this.f9615f;
            if (objArr[i3] == o.f9600c) {
                this.f9614c[i3] = i;
                objArr[i3] = obj;
                return;
            }
        }
        if (i10 >= this.f9614c.length) {
            int i11 = (i10 + 1) * 4;
            int i12 = 4;
            while (true) {
                if (i12 >= 32) {
                    break;
                }
                int i13 = (1 << i12) - 12;
                if (i11 <= i13) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
            int i14 = i11 / 4;
            this.f9614c = Arrays.copyOf(this.f9614c, i14);
            this.f9615f = Arrays.copyOf(this.f9615f, i14);
        }
        int i15 = this.f9616g;
        if (i15 - i3 != 0) {
            int[] iArr = this.f9614c;
            int i16 = i3 + 1;
            kb.k.f0(i16, i3, iArr, iArr, i15);
            Object[] objArr2 = this.f9615f;
            kb.k.i0(objArr2, objArr2, i16, i3, this.f9616g);
        }
        this.f9614c[i3] = i;
        this.f9615f[i3] = obj;
        this.f9616g++;
    }

    public final Object d(int i) {
        Object[] objArr = this.f9615f;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        int i = this.f9616g;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(i * 28);
        sb2.append('{');
        int i3 = this.f9616g;
        for (int i10 = 0; i10 < i3; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(this.f9614c[i10]);
            sb2.append('=');
            Object objD = d(i10);
            if (objD != this) {
                sb2.append(objD);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }
}
