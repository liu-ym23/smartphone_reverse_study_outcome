package u;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e<K, V, T> implements Iterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final s<K, V, T>[] f13108a;

    /* renamed from: b, reason: collision with root package name */
    public int f13109b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13110c = true;

    public e(r<K, V> rVar, s<K, V, T>[] sVarArr) {
        this.f13108a = sVarArr;
        sVarArr[0].a(rVar.f13130d, Integer.bitCount(rVar.f13127a) * 2, 0);
        this.f13109b = 0;
        a();
    }

    public final void a() {
        int i10 = this.f13109b;
        s<K, V, T>[] sVarArr = this.f13108a;
        s<K, V, T> sVar = sVarArr[i10];
        if (sVar.f13135c < sVar.f13134b) {
            return;
        }
        while (-1 < i10) {
            int iB = b(i10);
            if (iB == -1) {
                s<K, V, T> sVar2 = sVarArr[i10];
                int i11 = sVar2.f13135c;
                Object[] objArr = sVar2.f13133a;
                if (i11 < objArr.length) {
                    int length = objArr.length;
                    sVar2.f13135c = i11 + 1;
                    iB = b(i10);
                }
            }
            if (iB != -1) {
                this.f13109b = iB;
                return;
            }
            if (i10 > 0) {
                s<K, V, T> sVar3 = sVarArr[i10 - 1];
                int i12 = sVar3.f13135c;
                int length2 = sVar3.f13133a.length;
                sVar3.f13135c = i12 + 1;
            }
            sVarArr[i10].a(r.f13126e.f13130d, 0, 0);
            i10--;
        }
        this.f13110c = false;
    }

    public final int b(int i10) {
        s<K, V, T>[] sVarArr = this.f13108a;
        s<K, V, T> sVar = sVarArr[i10];
        int i11 = sVar.f13135c;
        if (i11 < sVar.f13134b) {
            return i10;
        }
        Object[] objArr = sVar.f13133a;
        if (i11 >= objArr.length) {
            return -1;
        }
        int length = objArr.length;
        Object obj = objArr[i11];
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        r rVar = (r) obj;
        if (i10 == 6) {
            s<K, V, T> sVar2 = sVarArr[i10 + 1];
            Object[] objArr2 = rVar.f13130d;
            sVar2.a(objArr2, objArr2.length, 0);
        } else {
            sVarArr[i10 + 1].a(rVar.f13130d, Integer.bitCount(rVar.f13127a) * 2, 0);
        }
        return b(i10 + 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13110c;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!this.f13110c) {
            throw new NoSuchElementException();
        }
        T next = this.f13108a[this.f13109b].next();
        a();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
