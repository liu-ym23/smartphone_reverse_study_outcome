package androidx.compose.runtime.snapshots;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.jvm.internal.g;
import lb.n;
import s.c;
import y.d;
import y.f;
import y.i;
import y.k;
import y.l;
import y.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class SnapshotStateSet<T> implements Parcelable, i, Set<T>, RandomAccess, ac.b {
    public static final int $stable = 0;
    private k firstStateRecord;
    public static final b Companion = new b();
    public static final Parcelable.Creator<SnapshotStateSet<Object>> CREATOR = new a();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.ClassLoaderCreator<SnapshotStateSet<Object>> {
        /* JADX WARN: Multi-variable type inference failed */
        public static SnapshotStateSet a(Parcel parcel, ClassLoader classLoader) {
            SnapshotStateSet snapshotStateSet = new SnapshotStateSet();
            if (classLoader == null) {
                classLoader = SnapshotStateSet.class.getClassLoader();
            }
            int i10 = parcel.readInt();
            for (int i11 = 0; i11 < i10; i11++) {
                snapshotStateSet.add(parcel.readValue(classLoader));
            }
            return snapshotStateSet;
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final /* bridge */ /* synthetic */ SnapshotStateSet<Object> createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return a(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i10) {
            return new SnapshotStateSet[i10];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            return a(parcel, null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    public SnapshotStateSet() {
        v.b bVar = v.b.f13237d;
        m mVar = new m(d.b().d(), bVar);
        if (d.f13932a.j() != null) {
            mVar.f13949b = new m(1, bVar);
        }
        this.firstStateRecord = mVar;
    }

    private static final boolean retainAll$lambda$5(Collection collection, Set set) {
        return set.retainAll(kotlin.collections.a.R0(collection));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T t8) {
        int i10;
        c<? extends T> cVar;
        y.b bVarB;
        boolean zA;
        do {
            synchronized (f.f13940a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                m mVar = (m) d.a((m) firstStateRecord);
                i10 = mVar.f13956d;
                cVar = mVar.f13955c;
                n nVar = n.f10413a;
            }
            g.c(cVar);
            v.b bVarAdd = cVar.add(t8);
            if (bVarAdd.equals(cVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            m mVar2 = (m) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zA = f.a((m) d.i(mVar2, this, bVarB), i10, bVarAdd);
            }
            d.d(bVarB, this);
        } while (!zA);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        int i10;
        c<? extends T> cVar;
        y.b bVarB;
        boolean zA;
        do {
            synchronized (f.f13940a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                m mVar = (m) d.a((m) firstStateRecord);
                i10 = mVar.f13956d;
                cVar = mVar.f13955c;
                n nVar = n.f10413a;
            }
            g.c(cVar);
            c<? extends T> cVarAddAll = cVar.addAll((Collection<? extends Object>) collection);
            if (g.b(cVarAddAll, cVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            m mVar2 = (m) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zA = f.a((m) d.i(mVar2, this, bVarB), i10, cVarAddAll);
            }
            d.d(bVarB, this);
        } while (!zA);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        y.b bVarB;
        k firstStateRecord = getFirstStateRecord();
        g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        m mVar = (m) firstStateRecord;
        synchronized (d.f13933b) {
            bVarB = d.b();
            m mVar2 = (m) d.i(mVar, this, bVarB);
            synchronized (f.f13940a) {
                mVar2.f13955c = v.b.f13237d;
                mVar2.f13956d++;
            }
        }
        d.d(bVarB, this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return f.c(this).f13955c.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return f.c(this).f13955c.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Set<T> getDebuggerDisplayValue() {
        k firstStateRecord = getFirstStateRecord();
        g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((m) d.a((m) firstStateRecord)).f13955c;
    }

    @Override // y.i
    public k getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public int getSize() {
        return f.c(this).f13955c.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return f.c(this).f13955c.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new l(this, f.c(this).f13955c.iterator());
    }

    public /* bridge */ /* synthetic */ k mergeRecords(k kVar, k kVar2, k kVar3) {
        return null;
    }

    @Override // y.i
    public void prependStateRecord(k kVar) {
        kVar.f13949b = getFirstStateRecord();
        this.firstStateRecord = (m) kVar;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int i10;
        c<? extends T> cVar;
        y.b bVarB;
        boolean zA;
        do {
            synchronized (f.f13940a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                m mVar = (m) d.a((m) firstStateRecord);
                i10 = mVar.f13956d;
                cVar = mVar.f13955c;
                n nVar = n.f10413a;
            }
            g.c(cVar);
            v.b bVarRemove = cVar.remove(obj);
            if (bVarRemove.equals(cVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            m mVar2 = (m) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zA = f.a((m) d.i(mVar2, this, bVarB), i10, bVarRemove);
            }
            d.d(bVarB, this);
        } while (!zA);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        int i10;
        c<? extends T> cVar;
        y.b bVarB;
        boolean zA;
        do {
            synchronized (f.f13940a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                m mVar = (m) d.a((m) firstStateRecord);
                i10 = mVar.f13956d;
                cVar = mVar.f13955c;
                n nVar = n.f10413a;
            }
            g.c(cVar);
            c<? extends T> cVarRemoveAll = cVar.removeAll((Collection<? extends Object>) collection);
            if (g.b(cVarRemoveAll, cVar)) {
                return false;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            m mVar2 = (m) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zA = f.a((m) d.i(mVar2, this, bVarB), i10, cVarRemoveAll);
            }
            d.d(bVarB, this);
        } while (!zA);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        int i10;
        c<? extends T> cVar;
        boolean zRetainAll$lambda$5;
        y.b bVarB;
        boolean zA;
        do {
            synchronized (f.f13940a) {
                k firstStateRecord = getFirstStateRecord();
                g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                m mVar = (m) d.a((m) firstStateRecord);
                i10 = mVar.f13956d;
                cVar = mVar.f13955c;
                n nVar = n.f10413a;
            }
            if (cVar == null) {
                throw new IllegalStateException("No set to mutate");
            }
            v.c cVarBuilder = cVar.builder();
            zRetainAll$lambda$5 = retainAll$lambda$5(collection, cVarBuilder);
            v.b bVarA = cVarBuilder.a();
            if (bVarA.equals(cVar)) {
                break;
            }
            k firstStateRecord2 = getFirstStateRecord();
            g.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            m mVar2 = (m) firstStateRecord2;
            synchronized (d.f13933b) {
                bVarB = d.b();
                zA = f.a((m) d.i(mVar2, this, bVarB), i10, bVarA);
            }
            d.d(bVarB, this);
        } while (!zA);
        return zRetainAll$lambda$5;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.d.a(this);
    }

    public final Set<T> toSet() {
        return f.c(this).f13955c;
    }

    public String toString() {
        k firstStateRecord = getFirstStateRecord();
        g.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return "SnapshotStateSet(value=" + ((m) d.a((m) firstStateRecord)).f13955c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        Set<T> set = toSet();
        parcel.writeInt(size());
        Iterator<T> it = set.iterator();
        if (it.hasNext()) {
            parcel.writeValue(it.next());
        }
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.d.b(this, tArr);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }
}
