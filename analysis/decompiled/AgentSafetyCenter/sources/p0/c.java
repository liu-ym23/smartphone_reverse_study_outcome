package p0;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final k[] f9660c;

    /* renamed from: f, reason: collision with root package name */
    public int f9661f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9662g = true;

    public c(j jVar, k[] kVarArr) {
        this.f9660c = kVarArr;
        kVarArr[0].a(jVar.f9675d, Integer.bitCount(jVar.f9672a) * 2, 0);
        this.f9661f = 0;
        a();
    }

    public final void a() {
        int i = this.f9661f;
        k[] kVarArr = this.f9660c;
        k kVar = kVarArr[i];
        if (kVar.f9678g < kVar.f9677f) {
            return;
        }
        while (-1 < i) {
            int iB = b(i);
            if (iB == -1) {
                k kVar2 = kVarArr[i];
                int i3 = kVar2.f9678g;
                Object[] objArr = kVar2.f9676c;
                if (i3 < objArr.length) {
                    int length = objArr.length;
                    kVar2.f9678g = i3 + 1;
                    iB = b(i);
                }
            }
            if (iB != -1) {
                this.f9661f = iB;
                return;
            }
            if (i > 0) {
                k kVar3 = kVarArr[i - 1];
                int i10 = kVar3.f9678g;
                int length2 = kVar3.f9676c.length;
                kVar3.f9678g = i10 + 1;
            }
            kVarArr[i].a(j.f9671e.f9675d, 0, 0);
            i--;
        }
        this.f9662g = false;
    }

    public final int b(int i) {
        k[] kVarArr = this.f9660c;
        k kVar = kVarArr[i];
        int i3 = kVar.f9678g;
        if (i3 < kVar.f9677f) {
            return i;
        }
        Object[] objArr = kVar.f9676c;
        if (i3 >= objArr.length) {
            return -1;
        }
        int length = objArr.length;
        Object obj = objArr[i3];
        obj.getClass();
        j jVar = (j) obj;
        if (i == 6) {
            k kVar2 = kVarArr[i + 1];
            Object[] objArr2 = jVar.f9675d;
            kVar2.a(objArr2, objArr2.length, 0);
        } else {
            kVarArr[i + 1].a(jVar.f9675d, Integer.bitCount(jVar.f9672a) * 2, 0);
        }
        return b(i + 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9662g;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.f9662g) {
            g5.f.k();
            return null;
        }
        Object next = this.f9660c[this.f9661f].next();
        a();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
