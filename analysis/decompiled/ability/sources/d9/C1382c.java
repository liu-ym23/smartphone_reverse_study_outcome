package d9;

import X8.C0276g;
import java.util.Arrays;
import java.util.Iterator;

/* renamed from: d9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1382c extends AbstractC1380a {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f4304a;
    public int b;

    @Override // d9.AbstractC1380a
    public final int b() {
        return this.b;
    }

    @Override // d9.AbstractC1380a
    public final void e(int i, C0276g c0276g) {
        Object[] objArr = this.f4304a;
        if (objArr.length <= i) {
            int length = objArr.length;
            do {
                length *= 2;
            } while (length <= i);
            Object[] objArrCopyOf = Arrays.copyOf(this.f4304a, length);
            kotlin.jvm.internal.k.e(objArrCopyOf, "copyOf(...)");
            this.f4304a = objArrCopyOf;
        }
        Object[] objArr2 = this.f4304a;
        if (objArr2[i] == null) {
            this.b++;
        }
        objArr2[i] = c0276g;
    }

    @Override // d9.AbstractC1380a
    public final Object get(int i) {
        return D7.q.s0(i, this.f4304a);
    }

    @Override // d9.AbstractC1380a, java.lang.Iterable
    public final Iterator iterator() {
        return new C1381b(this);
    }
}
