package ba;

import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: f, reason: collision with root package name */
    public Object[] f1592f;

    /* renamed from: g, reason: collision with root package name */
    public int f1593g;

    @Override // ba.a
    public final int a() {
        return this.f1593g;
    }

    @Override // ba.a
    public final void f(int i2, v9.g gVar) {
        Object[] objArr = this.f1592f;
        if (objArr.length <= i2) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length * 2);
            q7.k.d(objArrCopyOf, "copyOf(this, newSize)");
            this.f1592f = objArrCopyOf;
        }
        Object[] objArr2 = this.f1592f;
        if (objArr2[i2] == null) {
            this.f1593g++;
        }
        objArr2[i2] = gVar;
    }

    @Override // ba.a
    public final Object get(int i2) {
        return d7.n.k0(i2, this.f1592f);
    }

    @Override // ba.a, java.lang.Iterable
    public final Iterator iterator() {
        return new b(this);
    }
}
