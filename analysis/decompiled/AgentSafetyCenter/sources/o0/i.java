package o0;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends c {

    /* renamed from: g, reason: collision with root package name */
    public static final i f8995g = new i(new Object[0]);

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f8996f;

    public i(Object[] objArr) {
        this.f8996f = objArr;
    }

    @Override // jb.n
    public final int a() {
        return this.f8996f.length;
    }

    @Override // o0.c
    public final c b(int i, Object obj) {
        Object[] objArr = this.f8996f;
        p5.f.l(i, objArr.length);
        if (i == objArr.length) {
            return c(obj);
        }
        if (objArr.length < 32) {
            Object[] objArr2 = new Object[objArr.length + 1];
            k.k0(objArr, objArr2, 0, i, 6);
            k.i0(objArr, objArr2, i + 1, i, objArr.length);
            objArr2[i] = obj;
            return new i(objArr2);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        k.i0(objArr, objArrCopyOf, i + 1, i, objArr.length - 1);
        objArrCopyOf[i] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = objArr[31];
        return new e(objArrCopyOf, objArr3, objArr.length + 1, 0);
    }

    @Override // o0.c
    public final c c(Object obj) {
        Object[] objArr = this.f8996f;
        if (objArr.length < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 1);
            objArrCopyOf[objArr.length] = obj;
            return new i(objArrCopyOf);
        }
        Object[] objArr2 = new Object[32];
        objArr2[0] = obj;
        return new e(objArr, objArr2, objArr.length + 1, 0);
    }

    @Override // o0.c
    public final c d(Collection collection) {
        Object[] objArr = this.f8996f;
        if (collection.size() + objArr.length > 32) {
            f fVarE = e();
            fVarE.addAll(collection);
            return fVarE.c();
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, collection.size() + objArr.length);
        int length = objArr.length;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            objArrCopyOf[length] = it.next();
            length++;
        }
        return new i(objArrCopyOf);
    }

    @Override // o0.c
    public final f e() {
        return new f(this, null, this.f8996f, 0);
    }

    @Override // o0.c
    public final c f(b bVar) {
        Object[] objArr = this.f8996f;
        int length = objArr.length;
        int length2 = objArr.length;
        Object[] objArrCopyOf = objArr;
        boolean z10 = false;
        for (int i = 0; i < length2; i++) {
            Object obj = objArr[i];
            if (((Boolean) bVar.invoke(obj)).booleanValue()) {
                if (!z10) {
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    z10 = true;
                    length = i;
                }
            } else if (z10) {
                objArrCopyOf[length] = obj;
                length++;
            }
        }
        return length == objArr.length ? this : length == 0 ? f8995g : new i(k.l0(objArrCopyOf, 0, length));
    }

    @Override // o0.c
    public final c g(int i) {
        Object[] objArr = this.f8996f;
        p5.f.j(i, objArr.length);
        if (objArr.length == 1) {
            return f8995g;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length - 1);
        k.i0(objArr, objArrCopyOf, i, i + 1, objArr.length);
        return new i(objArrCopyOf);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object[] objArr = this.f8996f;
        p5.f.j(i, objArr.length);
        return objArr[i];
    }

    @Override // o0.c
    public final c h(int i, Object obj) {
        Object[] objArr = this.f8996f;
        p5.f.j(i, objArr.length);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        objArrCopyOf[i] = obj;
        return new i(objArrCopyOf);
    }

    @Override // kb.e, java.util.List
    public final int indexOf(Object obj) {
        return k.r0(this.f8996f, obj);
    }

    @Override // kb.e, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr = this.f8996f;
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i3 = length2 - 1;
                    if (obj.equals(objArr[length2])) {
                        return length2;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    length2 = i3;
                }
            }
        }
        return -1;
    }

    @Override // kb.e, java.util.List
    public final ListIterator listIterator(int i) {
        Object[] objArr = this.f8996f;
        p5.f.l(i, objArr.length);
        d dVar = new d(i, objArr.length, 0);
        dVar.f8979h = objArr;
        VarHandle.storeStoreFence();
        return dVar;
    }
}
