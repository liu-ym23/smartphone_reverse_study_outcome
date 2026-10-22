package f9;

import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class s extends AbstractList implements RandomAccess, t {

    /* renamed from: g, reason: collision with root package name */
    public static final h0 f3598g = new h0(new s());

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3599f;

    public s() {
        this.f3599f = new ArrayList();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        this.f3599f.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f3599f.size(), collection);
    }

    @Override // f9.t
    public final void c(u uVar) {
        this.f3599f.add(uVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f3599f.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        ArrayList arrayList = this.f3599f;
        Object obj = arrayList.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String strR = dVar.r();
            if (dVar.l()) {
                arrayList.set(i2, strR);
            }
            return strR;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = q.f3596a;
        try {
            String str = new String(bArr, "UTF-8");
            if (d0.c(bArr, 0, bArr.length) == 0) {
                arrayList.set(i2, str);
            }
            return str;
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    @Override // f9.t
    public final d getByteString(int i2) {
        d uVar;
        ArrayList arrayList = this.f3599f;
        Object obj = arrayList.get(i2);
        if (obj instanceof d) {
            uVar = (d) obj;
        } else if (obj instanceof String) {
            try {
                uVar = new u(((String) obj).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e10) {
                throw new RuntimeException("UTF-8 not supported?", e10);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            uVar = new u(bArr2);
        }
        if (uVar != obj) {
            arrayList.set(i2, uVar);
        }
        return uVar;
    }

    @Override // f9.t
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f3599f);
    }

    @Override // f9.t
    public final h0 getUnmodifiableView() {
        return new h0(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        Object objRemove = this.f3599f.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (objRemove instanceof d) {
            return ((d) objRemove).r();
        }
        byte[] bArr = (byte[]) objRemove;
        byte[] bArr2 = q.f3596a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        Object obj2 = this.f3599f.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof d) {
            return ((d) obj2).r();
        }
        byte[] bArr = (byte[]) obj2;
        byte[] bArr2 = q.f3596a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3599f.size();
    }

    public s(t tVar) {
        this.f3599f = new ArrayList(tVar.size());
        addAll(tVar);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        if (collection instanceof t) {
            collection = ((t) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f3599f.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
