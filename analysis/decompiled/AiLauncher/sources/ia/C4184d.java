package ia;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: ia.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4184d extends AbstractList<String> implements RandomAccess, InterfaceC4185e {

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC4185e f33097b = new C4184d().getUnmodifiableView();

    /* renamed from: a, reason: collision with root package name */
    public final List<Object> f33098a;

    public C4184d() {
        this.f33098a = new ArrayList();
    }

    public static AbstractC4182b c(Object obj) {
        return obj instanceof AbstractC4182b ? (AbstractC4182b) obj : obj instanceof String ? AbstractC4182b.j((String) obj) : AbstractC4182b.f((byte[]) obj);
    }

    public static String e(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC4182b ? ((AbstractC4182b) obj).A() : kotlin.reflect.jvm.internal.impl.protobuf.f.b((byte[]) obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i10, String str) {
        this.f33098a.add(i10, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f33098a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        Object obj = this.f33098a.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC4182b) {
            AbstractC4182b abstractC4182b = (AbstractC4182b) obj;
            String strA = abstractC4182b.A();
            if (abstractC4182b.o()) {
                this.f33098a.set(i10, strA);
            }
            return strA;
        }
        byte[] bArr = (byte[]) obj;
        String strB = kotlin.reflect.jvm.internal.impl.protobuf.f.b(bArr);
        if (kotlin.reflect.jvm.internal.impl.protobuf.f.a(bArr)) {
            this.f33098a.set(i10, strB);
        }
        return strB;
    }

    @Override // ia.InterfaceC4185e
    public AbstractC4182b getByteString(int i10) {
        Object obj = this.f33098a.get(i10);
        AbstractC4182b abstractC4182bC = c(obj);
        if (abstractC4182bC != obj) {
            this.f33098a.set(i10, abstractC4182bC);
        }
        return abstractC4182bC;
    }

    @Override // ia.InterfaceC4185e
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.f33098a);
    }

    @Override // ia.InterfaceC4185e
    public InterfaceC4185e getUnmodifiableView() {
        return new C4191k(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public String remove(int i10) {
        Object objRemove = this.f33098a.remove(i10);
        ((AbstractList) this).modCount++;
        return e(objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String set(int i10, String str) {
        return e(this.f33098a.set(i10, str));
    }

    @Override // ia.InterfaceC4185e
    public void q(AbstractC4182b abstractC4182b) {
        this.f33098a.add(abstractC4182b);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f33098a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends String> collection) {
        if (collection instanceof InterfaceC4185e) {
            collection = ((InterfaceC4185e) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f33098a.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public C4184d(InterfaceC4185e interfaceC4185e) {
        this.f33098a = new ArrayList(interfaceC4185e.size());
        addAll(interfaceC4185e);
    }
}
