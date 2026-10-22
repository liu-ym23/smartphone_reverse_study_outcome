package H8;

import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class o extends AbstractList implements RandomAccess, p {
    public static final G b = new G(new o());

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f778a;

    public o() {
        this.f778a = new ArrayList();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        this.f778a.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f778a.size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f778a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // H8.p
    public final void d(r rVar) {
        this.f778a.add(rVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ArrayList arrayList = this.f778a;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0244e) {
            AbstractC0244e abstractC0244e = (AbstractC0244e) obj;
            String strQ = abstractC0244e.q();
            if (abstractC0244e.i()) {
                arrayList.set(i, strQ);
            }
            return strQ;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = n.f777a;
        try {
            String str = new String(bArr, "UTF-8");
            if (A.c(bArr, 0, bArr.length) == 0) {
                arrayList.set(i, str);
            }
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    @Override // H8.p
    public final AbstractC0244e getByteString(int i) {
        AbstractC0244e rVar;
        ArrayList arrayList = this.f778a;
        Object obj = arrayList.get(i);
        if (obj instanceof AbstractC0244e) {
            rVar = (AbstractC0244e) obj;
        } else if (obj instanceof String) {
            try {
                rVar = new r(((String) obj).getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?", e);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            rVar = new r(bArr2);
        }
        if (rVar != obj) {
            arrayList.set(i, rVar);
        }
        return rVar;
    }

    @Override // H8.p
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f778a);
    }

    @Override // H8.p
    public final G getUnmodifiableView() {
        return new G(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        Object objRemove = this.f778a.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (objRemove instanceof AbstractC0244e) {
            return ((AbstractC0244e) objRemove).q();
        }
        byte[] bArr = (byte[]) objRemove;
        byte[] bArr2 = n.f777a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Object obj2 = this.f778a.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof AbstractC0244e) {
            return ((AbstractC0244e) obj2).q();
        }
        byte[] bArr = (byte[]) obj2;
        byte[] bArr2 = n.f777a;
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f778a.size();
    }

    public o(p pVar) {
        this.f778a = new ArrayList(pVar.size());
        addAll(pVar);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        if (collection instanceof p) {
            collection = ((p) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f778a.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
