package com.typesafe.config.impl;

import b8.InterfaceC1461g;
import com.autonavi.aps.amapapi.config.Const;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
final class SimpleConfigList extends AbstractConfigValue implements InterfaceC1461g, x, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final List<AbstractConfigValue> f31815b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31816c;

    public class a extends AbstractConfigValue.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ D f31817b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(D d10) {
            super();
            this.f31817b = d10;
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue.b
        public AbstractConfigValue b(String str, AbstractConfigValue abstractConfigValue) {
            return abstractConfigValue.e0(this.f31817b);
        }
    }

    public class b implements Iterator<b8.p> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31819a;

        public b(Iterator it) {
            this.f31819a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b8.p next() {
            return (b8.p) this.f31819a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31819a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw SimpleConfigList.C0("iterator().remove");
        }
    }

    public static class c implements ListIterator<b8.p> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListIterator f31821a;

        public c(ListIterator listIterator) {
            this.f31821a = listIterator;
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(b8.p pVar) {
            throw SimpleConfigList.C0("listIterator().add");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b8.p next() {
            return (b8.p) this.f31821a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b8.p previous() {
            return (b8.p) this.f31821a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(b8.p pVar) {
            throw SimpleConfigList.C0("listIterator().set");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f31821a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f31821a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f31821a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f31821a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw SimpleConfigList.C0("listIterator().remove");
        }
    }

    public static class d implements AbstractConfigValue.a {

        /* renamed from: a, reason: collision with root package name */
        public I f31822a;

        /* renamed from: b, reason: collision with root package name */
        public final L f31823b;

        public d(I i10, L l10) {
            this.f31822a = i10;
            this.f31823b = l10;
        }

        @Override // com.typesafe.config.impl.AbstractConfigValue.a
        public AbstractConfigValue a(String str, AbstractConfigValue abstractConfigValue) throws AbstractConfigValue.NotPossibleToResolve {
            K<? extends AbstractConfigValue> kL = this.f31822a.l(abstractConfigValue, this.f31823b);
            this.f31822a = kL.f31758a;
            return kL.f31759b;
        }
    }

    public SimpleConfigList(b8.k kVar, List<AbstractConfigValue> list) {
        this(kVar, list, ResolveStatus.fromValues(list));
    }

    public static UnsupportedOperationException C0(String str) {
        return new UnsupportedOperationException("ConfigList is immutable, you can't call List.'" + str + "'");
    }

    public static ListIterator<b8.p> E0(ListIterator<AbstractConfigValue> listIterator) {
        return new c(listIterator);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new SerializedConfigValue(this);
    }

    @Override // com.typesafe.config.impl.x
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigList L(AbstractConfigValue abstractConfigValue, AbstractConfigValue abstractConfigValue2) {
        List<AbstractConfigValue> listH0 = AbstractConfigValue.h0(this.f31815b, abstractConfigValue, abstractConfigValue2);
        if (listH0 == null) {
            return null;
        }
        return new SimpleConfigList(e(), listH0);
    }

    @Override // java.util.List
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public b8.p set(int i10, b8.p pVar) {
        throw C0("set");
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigList p0(b8.k kVar) {
        return (SimpleConfigList) super.p0(kVar);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean P(Object obj) {
        return obj instanceof SimpleConfigList;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends b8.p> collection) {
        throw C0("addAll");
    }

    @Override // b8.p
    public ConfigValueType c() {
        return ConfigValueType.LIST;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw C0("clear");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f31815b.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f31815b.containsAll(collection);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        List<AbstractConfigValue> list;
        List<AbstractConfigValue> list2;
        return (obj instanceof SimpleConfigList) && P(obj) && ((list = this.f31815b) == (list2 = ((SimpleConfigList) obj).f31815b) || list.equals(list2));
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public void f0(StringBuilder sb2, int i10, boolean z10, b8.n nVar) {
        if (this.f31815b.isEmpty()) {
            sb2.append("[]");
            return;
        }
        sb2.append("[");
        if (nVar.c()) {
            sb2.append('\n');
        }
        for (AbstractConfigValue abstractConfigValue : this.f31815b) {
            if (nVar.e()) {
                for (String str : abstractConfigValue.e().description().split("\n")) {
                    AbstractConfigValue.V(sb2, i10 + 1, nVar);
                    sb2.append('#');
                    if (!str.isEmpty()) {
                        sb2.append(' ');
                    }
                    sb2.append(str);
                    sb2.append("\n");
                }
            }
            if (nVar.b()) {
                for (String str2 : abstractConfigValue.e().e()) {
                    AbstractConfigValue.V(sb2, i10 + 1, nVar);
                    sb2.append("# ");
                    sb2.append(str2);
                    sb2.append("\n");
                }
            }
            int i11 = i10 + 1;
            AbstractConfigValue.V(sb2, i11, nVar);
            abstractConfigValue.f0(sb2, i11, z10, nVar);
            sb2.append(Const.STR_MART_COMMA);
            if (nVar.c()) {
                sb2.append('\n');
            }
        }
        sb2.setLength(sb2.length() - 1);
        if (nVar.c()) {
            sb2.setLength(sb2.length() - 1);
            sb2.append('\n');
            AbstractConfigValue.V(sb2, i10, nVar);
        }
        sb2.append("]");
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return this.f31815b.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f31815b.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f31815b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<b8.p> iterator() {
        return new b(this.f31815b.iterator());
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public ResolveStatus j0() {
        return ResolveStatus.fromBoolean(this.f31816c);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public K<? extends SimpleConfigList> k0(I i10, L l10) throws AbstractConfigValue.NotPossibleToResolve {
        if (!this.f31816c && !i10.c()) {
            try {
                d dVar = new d(i10, l10.e(this));
                return K.b(dVar.f31822a, w0(dVar, i10.f().b() ? null : ResolveStatus.RESOLVED));
            } catch (AbstractConfigValue.NotPossibleToResolve e10) {
                throw e10;
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new ConfigException.BugOrBroken("unexpected checked exception", e12);
            }
        }
        return K.b(i10, this);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f31815b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<b8.p> listIterator() {
        return E0(this.f31815b.listIterator());
    }

    @Override // java.util.List
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void add(int i10, b8.p pVar) {
        throw C0("add");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw C0("removeAll");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw C0("retainAll");
    }

    @Override // java.util.List, java.util.Collection
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public boolean add(b8.p pVar) {
        throw C0("add");
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f31815b.size();
    }

    @Override // java.util.List
    public List<b8.p> subList(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractConfigValue> it = this.f31815b.subList(i10, i11).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public final SimpleConfigList t0(SimpleConfigList simpleConfigList) {
        b8.k kVarI = M.i(e(), simpleConfigList.e());
        ArrayList arrayList = new ArrayList(this.f31815b.size() + simpleConfigList.f31815b.size());
        arrayList.addAll(this.f31815b);
        arrayList.addAll(simpleConfigList.f31815b);
        return new SimpleConfigList(kVarI, arrayList);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f31815b.toArray();
    }

    @Override // java.util.List
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public AbstractConfigValue get(int i10) {
        return this.f31815b.get(i10);
    }

    public final SimpleConfigList v0(AbstractConfigValue.b bVar, ResolveStatus resolveStatus) {
        try {
            return w0(bVar, resolveStatus);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new ConfigException.BugOrBroken("unexpected checked exception", e11);
        }
    }

    public final SimpleConfigList w0(AbstractConfigValue.a aVar, ResolveStatus resolveStatus) throws Exception {
        ArrayList arrayList = null;
        int i10 = 0;
        for (AbstractConfigValue abstractConfigValue : this.f31815b) {
            AbstractConfigValue abstractConfigValueA = aVar.a(null, abstractConfigValue);
            if (arrayList == null && abstractConfigValueA != abstractConfigValue) {
                arrayList = new ArrayList();
                for (int i11 = 0; i11 < i10; i11++) {
                    arrayList.add(this.f31815b.get(i11));
                }
            }
            if (arrayList != null && abstractConfigValueA != null) {
                arrayList.add(abstractConfigValueA);
            }
            i10++;
        }
        return arrayList != null ? resolveStatus != null ? new SimpleConfigList(e(), arrayList, resolveStatus) : new SimpleConfigList(e(), arrayList) : this;
    }

    @Override // com.typesafe.config.impl.x
    public boolean x(AbstractConfigValue abstractConfigValue) {
        return AbstractConfigValue.S(this.f31815b, abstractConfigValue);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigList c0(b8.k kVar) {
        return new SimpleConfigList(kVar, this.f31815b);
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public SimpleConfigList e0(D d10) {
        return v0(new a(d10), j0());
    }

    @Override // java.util.List
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public b8.p remove(int i10) {
        throw C0("remove");
    }

    @Override // b8.p
    public List<Object> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<AbstractConfigValue> it = this.f31815b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().a());
        }
        return arrayList;
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends b8.p> collection) {
        throw C0("addAll");
    }

    @Override // java.util.List
    public ListIterator<b8.p> listIterator(int i10) {
        return E0(this.f31815b.listIterator(i10));
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw C0("remove");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f31815b.toArray(tArr);
    }

    public SimpleConfigList(b8.k kVar, List<AbstractConfigValue> list, ResolveStatus resolveStatus) {
        super(kVar);
        this.f31815b = list;
        this.f31816c = resolveStatus == ResolveStatus.RESOLVED;
        if (resolveStatus == ResolveStatus.fromValues(list)) {
            return;
        }
        throw new ConfigException.BugOrBroken("SimpleConfigList created with wrong resolve status: " + this);
    }
}
