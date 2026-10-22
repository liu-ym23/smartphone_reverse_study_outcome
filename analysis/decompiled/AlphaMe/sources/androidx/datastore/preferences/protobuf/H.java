package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class H extends AbstractC0249c implements I, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3410b;

    static {
        new H(10).f3464a = false;
    }

    public H(int i4) {
        this(new ArrayList(i4));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i4, Object obj) {
        a();
        this.f3410b.add(i4, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0249c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f3410b.size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.C
    public final C b(int i4) {
        ArrayList arrayList = this.f3410b;
        if (i4 < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i4);
        arrayList2.addAll(arrayList);
        return new H(arrayList2);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0249c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.f3410b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i4) {
        String str;
        ArrayList arrayList = this.f3410b;
        Object obj = arrayList.get(i4);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC0259h) {
            AbstractC0259h abstractC0259h = (AbstractC0259h) obj;
            abstractC0259h.getClass();
            Charset charset = D.f3396a;
            if (abstractC0259h.size() == 0) {
                str = "";
            } else {
                C0261i c0261i = (C0261i) abstractC0259h;
                str = new String(c0261i.f3483d, c0261i.h(), c0261i.size(), charset);
            }
            C0261i c0261i2 = (C0261i) abstractC0259h;
            int iH = c0261i2.h();
            if (C0.f3395a.m(c0261i2.f3483d, iH, c0261i2.size() + iH) == 0) {
                arrayList.set(i4, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = new String(bArr, D.f3396a);
            if (C0.f3395a.m(bArr, 0, bArr.length) == 0) {
                arrayList.set(i4, str);
            }
        }
        return str;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final I k() {
        return this.f3464a ? new u0(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final void l(AbstractC0259h abstractC0259h) {
        a();
        this.f3410b.add(abstractC0259h);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final Object m(int i4) {
        return this.f3410b.get(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.I
    public final List n() {
        return Collections.unmodifiableList(this.f3410b);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i4) {
        String str;
        a();
        Object objRemove = this.f3410b.remove(i4);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (objRemove instanceof AbstractC0259h) {
            AbstractC0259h abstractC0259h = (AbstractC0259h) objRemove;
            abstractC0259h.getClass();
            Charset charset = D.f3396a;
            if (abstractC0259h.size() != 0) {
                C0261i c0261i = (C0261i) abstractC0259h;
                return new String(c0261i.f3483d, c0261i.h(), c0261i.size(), charset);
            }
            str = "";
        } else {
            str = new String((byte[]) objRemove, D.f3396a);
        }
        return str;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i4, Object obj) {
        a();
        Object obj2 = this.f3410b.set(i4, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof AbstractC0259h)) {
            return new String((byte[]) obj2, D.f3396a);
        }
        AbstractC0259h abstractC0259h = (AbstractC0259h) obj2;
        abstractC0259h.getClass();
        Charset charset = D.f3396a;
        if (abstractC0259h.size() == 0) {
            return "";
        }
        C0261i c0261i = (C0261i) abstractC0259h;
        return new String(c0261i.f3483d, c0261i.h(), c0261i.size(), charset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3410b.size();
    }

    public H(ArrayList arrayList) {
        this.f3410b = arrayList;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0249c, java.util.AbstractList, java.util.List
    public final boolean addAll(int i4, Collection collection) {
        a();
        if (collection instanceof I) {
            collection = ((I) collection).n();
        }
        boolean zAddAll = this.f3410b.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
