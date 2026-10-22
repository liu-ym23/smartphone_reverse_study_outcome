package androidx.compose.runtime.snapshots;

import ac.c;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.g;
import lb.n;
import t.f;
import t.j;
import y.d;
import y.e;
import y.h;
import y.i;
import y.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class SnapshotStateList<T> implements Parcelable, i, List<T>, RandomAccess, c {
    public static final int $stable = 0;
    private k firstStateRecord;
    public static final b Companion = new b();
    public static final Parcelable.Creator<SnapshotStateList<Object>> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.ClassLoaderCreator<SnapshotStateList<Object>> {
        public static SnapshotStateList a(Parcel parcel, ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = a.class.getClassLoader();
            }
            int i10 = parcel.readInt();
            if (i10 == 0) {
                return new SnapshotStateList();
            }
            f fVarBuilder = j.f12893b.builder();
            for (int i11 = 0; i11 < i10; i11++) {
                fVarBuilder.add(parcel.readValue(classLoader));
            }
            return new SnapshotStateList(fVarBuilder.c());
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final /* bridge */ /* synthetic */ SnapshotStateList<Object> createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return a(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i10) {
            return new SnapshotStateList[i10];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return a(parcel, null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public SnapshotStateList() {
        this(j.f12893b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addAll$lambda$4(int i10, Collection collection, List list) {
        return list.addAll(i10, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainAll$lambda$10(Collection collection, List list) {
        return list.retainAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t8) {
        int i10;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i10 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVarAdd = bVar.add((s.b<? extends T>) t8);
            if (bVarAdd.equals(bVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i10, bVarAdd, true);
            }
            d.d(bVarB, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends T> collection) {
        return e.f(this, new com.stepos.core.ota.confirmui.n(i10, 1, collection));
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        y.b bVarB;
        k firstStateRecord = getFirstStateRecord();
        g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        h hVar = (h) firstStateRecord;
        synchronized (d.f13933b) {
            bVarB = d.b();
            h hVar2 = (h) d.i(hVar, this, bVarB);
            synchronized (e.f13939a) {
                hVar2.f13945c = j.f12893b;
                hVar2.f13946d++;
                hVar2.f13947e++;
            }
        }
        d.d(bVarB, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return e.d(this).f13945c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return e.d(this).f13945c.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.List
    public T get(int i10) {
        return e.d(this).f13945c.get(i10);
    }

    public final List<T> getDebuggerDisplayValue() {
        k firstStateRecord = getFirstStateRecord();
        g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((h) d.a((h) firstStateRecord)).f13945c;
    }

    @Override // y.i
    public k getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public int getSize() {
        return e.d(this).f13945c.size();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return e.d(this).f13945c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return e.d(this).f13945c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return e.d(this).f13945c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new y.g(this, 0);
    }

    public /* bridge */ /* synthetic */ k mergeRecords(k kVar, k kVar2, k kVar3) {
        return null;
    }

    @Override // y.i
    public void prependStateRecord(k kVar) {
        kVar.f13949b = getFirstStateRecord();
        this.firstStateRecord = (h) kVar;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i10) {
        return removeAt(i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        int i10;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i10 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVarRemoveAll = bVar.removeAll((Collection<? extends Object>) collection);
            if (g.b(bVarRemoveAll, bVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i10, bVarRemoveAll, true);
            }
            d.d(bVarB, this);
        } while (!zB);
        return true;
    }

    public T removeAt(int i10) {
        int i11;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        T t8 = get(i10);
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i11 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVarW = bVar.w(i10);
            if (g.b(bVarW, bVar)) {
                break;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i11, bVarW, true);
            }
            d.d(bVarB, this);
        } while (!zB);
        return t8;
    }

    public final void removeRange(int i10, int i11) {
        int i12;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i12 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            f fVarBuilder = bVar.builder();
            fVarBuilder.subList(i10, i11).clear();
            s.b bVarC = fVarBuilder.c();
            if (g.b(bVarC, bVar)) {
                return;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i12, bVarC, true);
            }
            d.d(bVarB, this);
        } while (!zB);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return e.f(this, new androidx.compose.runtime.g(collection, 23));
    }

    public final int retainAllInRange$runtime(Collection<? extends T> collection, int i10, int i11) {
        int i12;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        int size = size();
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i12 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            f fVarBuilder = bVar.builder();
            fVarBuilder.subList(i10, i11).retainAll(collection);
            s.b bVarC = fVarBuilder.c();
            if (g.b(bVarC, bVar)) {
                break;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i12, bVarC, true);
            }
            d.d(bVarB, this);
        } while (!zB);
        return size - size();
    }

    @Override // java.util.List
    public T set(int i10, T t8) {
        int i11;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        T t10 = get(i10);
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i11 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVar2 = bVar.set(i10, (int) t8);
            if (bVar2.equals(bVar)) {
                break;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i11, bVar2, false);
            }
            d.d(bVarB, this);
        } while (!zB);
        return t10;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int i10, int i11) {
        if (!(i10 >= 0 && i10 <= i11 && i11 <= size())) {
            androidx.compose.runtime.f.a("fromIndex or toIndex are out of bounds");
        }
        return new y.n(this, i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    public final List<T> toList() {
        return e.d(this).f13945c;
    }

    public String toString() {
        k firstStateRecord = getFirstStateRecord();
        g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((h) d.a((h) firstStateRecord)).f13945c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        List<T> list = toList();
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeValue(list.get(i11));
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        int i10;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i10 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVarAddAll = bVar.addAll((Collection<? extends Object>) collection);
            if (g.b(bVarAddAll, bVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i10, bVarAddAll, true);
            }
            d.d(bVarB, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i10) {
        return new y.g(this, i10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int i10;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i10 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVarRemove = bVar.remove((s.b<? extends T>) obj);
            if (g.b(bVarRemove, bVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i10, bVarRemove, true);
            }
            d.d(bVarB, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.d.b(this, tArr);
    }

    public SnapshotStateList(s.b<? extends T> bVar) {
        y.b bVarB = d.b();
        h hVar = new h(bVarB.d(), bVar);
        if (!(bVarB instanceof y.a)) {
            hVar.f13949b = new h(1, bVar);
        }
        this.firstStateRecord = hVar;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @Override // java.util.List
    public void add(int i10, T t8) {
        int i11;
        s.b<? extends T> bVar;
        y.b bVarB;
        boolean zB;
        do {
            synchronized (e.f13939a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                h hVar = (h) d.a((h) firstStateRecord);
                i11 = hVar.f13946d;
                bVar = hVar.f13945c;
                n nVar = n.f10413a;
            }
            g.c(bVar);
            s.b<? extends T> bVarAdd = bVar.add(i10, (int) t8);
            if (bVarAdd.equals(bVar)) {
                return;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            h hVar2 = (h) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zB = e.b((h) d.i(hVar2, this, bVarB), i11, bVarAdd, true);
            }
            d.d(bVarB, this);
        } while (!zB);
    }
}
