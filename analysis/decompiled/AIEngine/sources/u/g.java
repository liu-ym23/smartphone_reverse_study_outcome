package u;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class g<K, V, T> extends e<K, V, T> {

    /* renamed from: d, reason: collision with root package name */
    public final f<K, V> f13116d;

    /* renamed from: e, reason: collision with root package name */
    public K f13117e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public int f13118j;

    public g(f<K, V> fVar, s<K, V, T>[] sVarArr) {
        super(fVar.f13113c, sVarArr);
        this.f13116d = fVar;
        this.f13118j = fVar.f13115e;
    }

    public final void c(int i10, r<?, ?> rVar, K k9, int i11) {
        int i12 = i11 * 5;
        s<K, V, T>[] sVarArr = this.f13108a;
        if (i12 <= 30) {
            int iC = 1 << y.C(i10, i12);
            if (rVar.h(iC)) {
                sVarArr[i11].a(rVar.f13130d, Integer.bitCount(rVar.f13127a) * 2, rVar.f(iC));
                this.f13109b = i11;
                return;
            } else {
                int iT = rVar.t(iC);
                r<?, ?> rVarS = rVar.s(iT);
                sVarArr[i11].a(rVar.f13130d, Integer.bitCount(rVar.f13127a) * 2, iT);
                c(i10, rVarS, k9, i11 + 1);
                return;
            }
        }
        s<K, V, T> sVar = sVarArr[i11];
        Object[] objArr = rVar.f13130d;
        sVar.a(objArr, objArr.length, 0);
        while (true) {
            s<K, V, T> sVar2 = sVarArr[i11];
            if (kotlin.jvm.internal.g.b(sVar2.f13133a[sVar2.f13135c], k9)) {
                this.f13109b = i11;
                return;
            } else {
                sVarArr[i11].f13135c += 2;
            }
        }
    }

    @Override // u.e, java.util.Iterator
    public final T next() {
        if (this.f13116d.f13115e != this.f13118j) {
            throw new ConcurrentModificationException();
        }
        if (!this.f13110c) {
            throw new NoSuchElementException();
        }
        s<K, V, T> sVar = this.f13108a[this.f13109b];
        this.f13117e = (K) sVar.f13133a[sVar.f13135c];
        this.h = true;
        return (T) super.next();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u.e, java.util.Iterator
    public final void remove() {
        if (!this.h) {
            throw new IllegalStateException();
        }
        boolean z = this.f13110c;
        f<K, V> fVar = this.f13116d;
        if (!z) {
            kotlin.jvm.internal.k.b(fVar).remove(this.f13117e);
        } else {
            if (!z) {
                throw new NoSuchElementException();
            }
            s<K, V, T> sVar = this.f13108a[this.f13109b];
            Object obj = sVar.f13133a[sVar.f13135c];
            kotlin.jvm.internal.k.b(fVar).remove(this.f13117e);
            c(obj != null ? obj.hashCode() : 0, fVar.f13113c, obj, 0);
        }
        this.f13117e = null;
        this.h = false;
        this.f13118j = fVar.f13115e;
    }
}
