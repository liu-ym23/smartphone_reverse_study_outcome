package g0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class d implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final l[] f3675f;

    /* renamed from: g, reason: collision with root package name */
    public int f3676g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3677h = true;

    public d(k kVar, l[] lVarArr) {
        this.f3675f = lVarArr;
        lVarArr[0].a(kVar.f3691d, Integer.bitCount(kVar.f3688a) * 2, 0);
        this.f3676g = 0;
        a();
    }

    public final void a() {
        int i2 = this.f3676g;
        l[] lVarArr = this.f3675f;
        l lVar = lVarArr[i2];
        if (lVar.f3694h < lVar.f3693g) {
            return;
        }
        while (-1 < i2) {
            int iC = c(i2);
            if (iC == -1) {
                l lVar2 = lVarArr[i2];
                int i10 = lVar2.f3694h;
                Object[] objArr = lVar2.f3692f;
                if (i10 < objArr.length) {
                    int length = objArr.length;
                    lVar2.f3694h = i10 + 1;
                    iC = c(i2);
                }
            }
            if (iC != -1) {
                this.f3676g = iC;
                return;
            }
            if (i2 > 0) {
                l lVar3 = lVarArr[i2 - 1];
                int i11 = lVar3.f3694h;
                int length2 = lVar3.f3692f.length;
                lVar3.f3694h = i11 + 1;
            }
            lVarArr[i2].a(k.f3687e.f3691d, 0, 0);
            i2--;
        }
        this.f3677h = false;
    }

    public final int c(int i2) {
        l[] lVarArr = this.f3675f;
        l lVar = lVarArr[i2];
        int i10 = lVar.f3694h;
        if (i10 < lVar.f3693g) {
            return i2;
        }
        Object[] objArr = lVar.f3692f;
        if (i10 >= objArr.length) {
            return -1;
        }
        int length = objArr.length;
        Object obj = objArr[i10];
        q7.k.c(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        k kVar = (k) obj;
        if (i2 == 6) {
            l lVar2 = lVarArr[i2 + 1];
            Object[] objArr2 = kVar.f3691d;
            lVar2.a(objArr2, objArr2.length, 0);
        } else {
            lVarArr[i2 + 1].a(kVar.f3691d, Integer.bitCount(kVar.f3688a) * 2, 0);
        }
        return c(i2 + 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3677h;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f3677h) {
            throw new NoSuchElementException();
        }
        Object next = this.f3675f[this.f3676g].next();
        a();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
