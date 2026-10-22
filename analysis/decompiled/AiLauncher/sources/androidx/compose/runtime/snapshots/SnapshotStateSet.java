package androidx.compose.runtime.snapshots;

import Z8.F;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import d0.C3941a;
import io.ktor.http.ContentDisposition;
import j0.p;
import j0.r;
import j0.s;
import j0.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import p9.InterfaceC5074l;
import q9.f;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u0000 8*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006:\u00019B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\u0014J\u001d\u0010\"\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b\"\u0010\u0018J\u000f\u0010#\u001a\u00020\u000bH\u0016¢\u0006\u0004\b#\u0010\bJ\u0017\u0010$\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b$\u0010\u0014J\u001d\u0010%\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b%\u0010\u0018J\u001d\u0010&\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b&\u0010\u0018J\u001f\u0010+\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.R$\u0010/\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R \u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8AX\u0080\u0004¢\u0006\f\u0012\u0004\b4\u0010\b\u001a\u0004\b3\u0010\u0010R\u0014\u00107\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.¨\u0006:"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateSet;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "Lj0/p;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "Lj0/r;", UxipConstants.f30680s, "LY8/t;", "prependStateRecord", "(Lj0/r;)V", "", "toSet", "()Ljava/util/Set;", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "toString", "()Ljava/lang/String;", "add", "addAll", "clear", "remove", "removeAll", "retainAll", "Landroid/os/Parcel;", "parcel", "", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "firstStateRecord", "Lj0/r;", "getFirstStateRecord", "()Lj0/r;", "getDebuggerDisplayValue", "getDebuggerDisplayValue$annotations", "debuggerDisplayValue", "getSize", ContentDisposition.Parameters.Size, "Companion", Const.INTENT_KEY_PKGNAME, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class SnapshotStateSet<T> implements Parcelable, p, Set<T>, RandomAccess, f {
    public static final int $stable = 0;
    private r firstStateRecord = e.f(this, C3941a.b());
    public static final Parcelable.Creator<SnapshotStateSet<Object>> CREATOR = new a();

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J)\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/compose/runtime/snapshots/SnapshotStateSet$a", "Landroid/os/Parcelable$ClassLoaderCreator;", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "", "Landroid/os/Parcel;", "parcel", "Ljava/lang/ClassLoader;", "loader", Const.INTENT_KEY_PKGNAME, "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)Landroidx/compose/runtime/snapshots/SnapshotStateSet;", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "", ContentDisposition.Parameters.Size, "", "c", "(I)[Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.ClassLoaderCreator<SnapshotStateSet<Object>> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SnapshotStateSet<Object> createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SnapshotStateSet<Object> createFromParcel(Parcel parcel, ClassLoader loader) {
            SnapshotStateSet<Object> snapshotStateSet = new SnapshotStateSet<>();
            if (loader == null) {
                loader = SnapshotStateSet.class.getClassLoader();
            }
            int i10 = parcel.readInt();
            for (int i11 = 0; i11 < i10; i11++) {
                snapshotStateSet.add(parcel.readValue(loader));
            }
            return snapshotStateSet;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SnapshotStateSet<Object>[] newArray(int size) {
            return new SnapshotStateSet[size];
        }
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainAll$lambda$5(Collection collection, Set set) {
        return set.retainAll(F.r1(collection));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T element) {
        int modification;
        d0.f<T> fVarH;
        c cVarA;
        boolean zB;
        do {
            synchronized (e.f11800a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                t tVar = (t) d.e((t) firstStateRecord);
                modification = tVar.getModification();
                fVarH = tVar.h();
                Y8.t tVar2 = Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.f(fVarH);
            d0.f<T> fVarAdd = fVarH.add((d0.f<T>) element);
            if (kotlin.jvm.internal.p.d(fVarAdd, fVarH)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            t tVar3 = (t) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zB = e.b((t) d.t(tVar3, this, cVarA), modification, fVarAdd);
            }
            d.k(cVarA, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        int modification;
        d0.f<T> fVarH;
        c cVarA;
        boolean zB;
        do {
            synchronized (e.f11800a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                t tVar = (t) d.e((t) firstStateRecord);
                modification = tVar.getModification();
                fVarH = tVar.h();
                Y8.t tVar2 = Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.f(fVarH);
            d0.f<T> fVarAddAll = fVarH.addAll(elements);
            if (kotlin.jvm.internal.p.d(fVarAddAll, fVarH)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            t tVar3 = (t) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zB = e.b((t) d.t(tVar3, this, cVarA), modification, fVarAddAll);
            }
            d.k(cVarA, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        c cVarA;
        r firstStateRecord = getFirstStateRecord();
        kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        t tVar = (t) firstStateRecord;
        synchronized (d.h()) {
            cVarA = c.INSTANCE.a();
            t tVar2 = (t) d.t(tVar, this, cVarA);
            synchronized (e.f11800a) {
                tVar2.j(C3941a.b());
                tVar2.i(tVar2.getModification() + 1);
            }
        }
        d.k(cVarA, this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object element) {
        return e.d(this).h().contains(element);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        return e.d(this).h().containsAll(elements);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Set<T> getDebuggerDisplayValue() {
        r firstStateRecord = getFirstStateRecord();
        kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((t) d.e((t) firstStateRecord)).h();
    }

    @Override // j0.p
    public r getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public int getSize() {
        return e.d(this).h().size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return e.d(this).h().isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new s(this, e.d(this).h().iterator());
    }

    @Override // j0.p
    public /* bridge */ /* synthetic */ r mergeRecords(r rVar, r rVar2, r rVar3) {
        return super.mergeRecords(rVar, rVar2, rVar3);
    }

    @Override // j0.p
    public void prependStateRecord(r value) {
        value.e(getFirstStateRecord());
        kotlin.jvm.internal.p.g(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        this.firstStateRecord = (t) value;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object element) {
        int modification;
        d0.f<T> fVarH;
        c cVarA;
        boolean zB;
        do {
            synchronized (e.f11800a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                t tVar = (t) d.e((t) firstStateRecord);
                modification = tVar.getModification();
                fVarH = tVar.h();
                Y8.t tVar2 = Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.f(fVarH);
            d0.f<T> fVarRemove = fVarH.remove((d0.f<T>) element);
            if (kotlin.jvm.internal.p.d(fVarRemove, fVarH)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            t tVar3 = (t) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zB = e.b((t) d.t(tVar3, this, cVarA), modification, fVarRemove);
            }
            d.k(cVarA, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> elements) {
        int modification;
        d0.f<T> fVarH;
        c cVarA;
        boolean zB;
        do {
            synchronized (e.f11800a) {
                r firstStateRecord = getFirstStateRecord();
                kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                t tVar = (t) d.e((t) firstStateRecord);
                modification = tVar.getModification();
                fVarH = tVar.h();
                Y8.t tVar2 = Y8.t.f7040a;
            }
            kotlin.jvm.internal.p.f(fVarH);
            d0.f<T> fVarRemoveAll = fVarH.removeAll((Collection<? extends T>) elements);
            if (kotlin.jvm.internal.p.d(fVarRemoveAll, fVarH)) {
                return false;
            }
            r firstStateRecord2 = getFirstStateRecord();
            kotlin.jvm.internal.p.g(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            t tVar3 = (t) firstStateRecord2;
            synchronized (d.h()) {
                cVarA = c.INSTANCE.a();
                zB = e.b((t) d.t(tVar3, this, cVarA), modification, fVarRemoveAll);
            }
            d.k(cVarA, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(final Collection<?> elements) {
        return e.e(this, new InterfaceC5074l() { // from class: j0.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SnapshotStateSet.retainAll$lambda$5(elements, (Set) obj));
            }
        });
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return h.a(this);
    }

    public final Set<T> toSet() {
        return e.d(this).h();
    }

    public String toString() {
        r firstStateRecord = getFirstStateRecord();
        kotlin.jvm.internal.p.g(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSet>");
        return "SnapshotStateSet(value=" + ((t) d.e((t) firstStateRecord)).h() + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Set<T> set = toSet();
        parcel.writeInt(size());
        Iterator<T> it = set.iterator();
        if (it.hasNext()) {
            parcel.writeValue(it.next());
        }
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) h.b(this, tArr);
    }
}
